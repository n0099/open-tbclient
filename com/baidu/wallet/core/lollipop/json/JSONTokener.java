package com.baidu.wallet.core.lollipop.json;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.zxing.client.result.ResultParser;
/* loaded from: classes5.dex */
public class JSONTokener {
    public final String in;
    public int pos;

    public JSONTokener(String str) {
        if (str != null && str.startsWith(ResultParser.BYTE_ORDER_MARK)) {
            str = str.substring(1);
        }
        this.in = str;
    }

    public static int dehexchar(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                c3 = 'a';
                if (c2 < 'a' || c2 > 'f') {
                    return -1;
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    private int nextCleanInternal() throws JSONException {
        while (this.pos < this.in.length()) {
            String str = this.in;
            int i = this.pos;
            this.pos = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                if (charAt != '#') {
                    if (charAt != '/' || this.pos == this.in.length()) {
                        return charAt;
                    }
                    char charAt2 = this.in.charAt(this.pos);
                    if (charAt2 == '*') {
                        int i2 = this.pos + 1;
                        this.pos = i2;
                        int indexOf = this.in.indexOf("*/", i2);
                        if (indexOf != -1) {
                            this.pos = indexOf + 2;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    } else if (charAt2 != '/') {
                        return charAt;
                    } else {
                        this.pos++;
                        skipToEndOfLine();
                    }
                } else {
                    skipToEndOfLine();
                }
            }
        }
        return -1;
    }

    private String nextToInternal(String str) {
        int i = this.pos;
        while (this.pos < this.in.length()) {
            char charAt = this.in.charAt(this.pos);
            if (charAt != '\r' && charAt != '\n' && str.indexOf(charAt) == -1) {
                this.pos++;
            } else {
                return this.in.substring(i, this.pos);
            }
        }
        return this.in.substring(i);
    }

    private JSONArray readArray() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        while (true) {
            int nextCleanInternal = nextCleanInternal();
            if (nextCleanInternal == -1) {
                throw syntaxError("Unterminated array");
            }
            if (nextCleanInternal == 44 || nextCleanInternal == 59) {
                jSONArray.put((Object) null);
            } else if (nextCleanInternal == 93) {
                if (z) {
                    jSONArray.put((Object) null);
                }
                return jSONArray;
            } else {
                this.pos--;
                jSONArray.put(nextValue());
                int nextCleanInternal2 = nextCleanInternal();
                if (nextCleanInternal2 != 44 && nextCleanInternal2 != 59) {
                    if (nextCleanInternal2 == 93) {
                        return jSONArray;
                    }
                    throw syntaxError("Unterminated array");
                }
            }
            z = true;
        }
    }

    private char readEscapeCharacter() throws JSONException {
        String str = this.in;
        int i = this.pos;
        this.pos = i + 1;
        char charAt = str.charAt(i);
        if (charAt != 'b') {
            if (charAt != 'f') {
                if (charAt != 'n') {
                    if (charAt != 'r') {
                        if (charAt != 't') {
                            if (charAt != 'u') {
                                return charAt;
                            }
                            if (this.pos + 4 <= this.in.length()) {
                                String str2 = this.in;
                                int i2 = this.pos;
                                String substring = str2.substring(i2, i2 + 4);
                                this.pos += 4;
                                return (char) Integer.parseInt(substring, 16);
                            }
                            throw syntaxError("Unterminated escape sequence");
                        }
                        return '\t';
                    }
                    return '\r';
                }
                return '\n';
            }
            return '\f';
        }
        return '\b';
    }

    private Object readLiteral() throws JSONException {
        String substring;
        int i;
        String nextToInternal = nextToInternal("{}[]/\\:,=;# \t\f");
        if (nextToInternal.length() != 0) {
            if (StringUtil.NULL_STRING.equalsIgnoreCase(nextToInternal)) {
                return JSONObject.NULL;
            }
            if ("true".equalsIgnoreCase(nextToInternal)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(nextToInternal)) {
                return Boolean.FALSE;
            }
            if (nextToInternal.indexOf(46) == -1) {
                if (!nextToInternal.startsWith("0x") && !nextToInternal.startsWith("0X")) {
                    if (!nextToInternal.startsWith("0") || nextToInternal.length() <= 1) {
                        substring = nextToInternal;
                        i = 10;
                    } else {
                        substring = nextToInternal.substring(1);
                        i = 8;
                    }
                } else {
                    substring = nextToInternal.substring(2);
                    i = 16;
                }
                try {
                    long parseLong = Long.parseLong(substring, i);
                    if (parseLong <= 2147483647L && parseLong >= -2147483648L) {
                        return Integer.valueOf((int) parseLong);
                    }
                    return Long.valueOf(parseLong);
                } catch (NumberFormatException unused) {
                }
            }
            try {
                return Double.valueOf(nextToInternal);
            } catch (NumberFormatException unused2) {
                return nextToInternal;
            }
        }
        throw syntaxError("Expected literal value");
    }

    private JSONObject readObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == 125) {
            return jSONObject;
        }
        if (nextCleanInternal != -1) {
            this.pos--;
        }
        while (true) {
            Object nextValue = nextValue();
            if (!(nextValue instanceof String)) {
                if (nextValue == null) {
                    throw syntaxError("Names cannot be null");
                }
                throw syntaxError("Names must be strings, but " + nextValue + " is of type " + nextValue.getClass().getName());
            }
            int nextCleanInternal2 = nextCleanInternal();
            if (nextCleanInternal2 != 58 && nextCleanInternal2 != 61) {
                throw syntaxError("Expected ':' after " + nextValue);
            }
            if (this.pos < this.in.length() && this.in.charAt(this.pos) == '>') {
                this.pos++;
            }
            jSONObject.put((String) nextValue, nextValue());
            int nextCleanInternal3 = nextCleanInternal();
            if (nextCleanInternal3 != 44 && nextCleanInternal3 != 59) {
                if (nextCleanInternal3 == 125) {
                    return jSONObject;
                }
                throw syntaxError("Unterminated object");
            }
        }
    }

    private void skipToEndOfLine() {
        while (this.pos < this.in.length()) {
            char charAt = this.in.charAt(this.pos);
            if (charAt != '\r' && charAt != '\n') {
                this.pos++;
            } else {
                this.pos++;
                return;
            }
        }
    }

    public void back() {
        int i = this.pos - 1;
        this.pos = i;
        if (i == -1) {
            this.pos = 0;
        }
    }

    public boolean more() {
        return this.pos < this.in.length();
    }

    public char next() {
        if (this.pos < this.in.length()) {
            String str = this.in;
            int i = this.pos;
            this.pos = i + 1;
            return str.charAt(i);
        }
        return (char) 0;
    }

    public char nextClean() throws JSONException {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == -1) {
            return (char) 0;
        }
        return (char) nextCleanInternal;
    }

    public String nextString(char c2) throws JSONException {
        int i = this.pos;
        StringBuilder sb = null;
        while (this.pos < this.in.length()) {
            String str = this.in;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt == c2) {
                if (sb == null) {
                    return this.in.substring(i, this.pos - 1);
                }
                sb.append((CharSequence) this.in, i, this.pos - 1);
                return sb.toString();
            } else if (charAt == '\\') {
                if (this.pos != this.in.length()) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append((CharSequence) this.in, i, this.pos - 1);
                    sb.append(readEscapeCharacter());
                    i = this.pos;
                } else {
                    throw syntaxError("Unterminated escape sequence");
                }
            }
        }
        throw syntaxError("Unterminated string");
    }

    public String nextTo(String str) {
        if (str != null) {
            return nextToInternal(str).trim();
        }
        throw new NullPointerException("excluded == null");
    }

    public Object nextValue() throws JSONException {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal != -1) {
            if (nextCleanInternal == 34 || nextCleanInternal == 39) {
                return nextString((char) nextCleanInternal);
            }
            if (nextCleanInternal != 91) {
                if (nextCleanInternal != 123) {
                    this.pos--;
                    return readLiteral();
                }
                return readObject();
            }
            return readArray();
        }
        throw syntaxError("End of input");
    }

    public void skipPast(String str) {
        int indexOf = this.in.indexOf(str, this.pos);
        this.pos = indexOf == -1 ? this.in.length() : str.length() + indexOf;
    }

    public char skipTo(char c2) {
        int indexOf = this.in.indexOf(c2, this.pos);
        if (indexOf != -1) {
            this.pos = indexOf;
            return c2;
        }
        return (char) 0;
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + this);
    }

    public String toString() {
        return " at character " + this.pos + " of " + this.in;
    }

    public char next(char c2) throws JSONException {
        char next = next();
        if (next == c2) {
            return next;
        }
        throw syntaxError("Expected " + c2 + " but was " + next);
    }

    public String nextTo(char c2) {
        return nextToInternal(String.valueOf(c2)).trim();
    }

    public String next(int i) throws JSONException {
        if (this.pos + i <= this.in.length()) {
            String str = this.in;
            int i2 = this.pos;
            String substring = str.substring(i2, i2 + i);
            this.pos += i;
            return substring;
        }
        throw syntaxError(i + " is out of bounds");
    }
}
