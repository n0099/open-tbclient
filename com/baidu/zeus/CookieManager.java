package com.baidu.zeus;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.baidu.loginshare.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes.dex */
public final class CookieManager {
    private static final char COMMA = ',';
    private static final CookieComparator COMPARATOR;
    private static final String DOMAIN = "domain";
    private static final char EQUAL = '=';
    private static final String EXPIRES = "expires";
    private static final String HTTPS = "https";
    private static final String LOGTAG = "webkit";
    private static final String MAX_AGE = "max-age";
    private static final int MAX_COOKIE_COUNT_PER_BASE_DOMAIN = 50;
    private static final int MAX_COOKIE_LENGTH = 4096;
    private static final int MAX_DOMAIN_COUNT = 200;
    private static final int MAX_RAM_COOKIES_COUNT = 1000;
    private static final int MAX_RAM_DOMAIN_COUNT = 15;
    private static final String PATH = "path";
    private static final char PATH_DELIM = '/';
    private static final char PERIOD = '.';
    private static final char QUESTION_MARK = '?';
    private static final char QUOTATION = '\"';
    private static final char SEMICOLON = ';';
    private static final char WHITE_SPACE = ' ';
    private static CookieManager sRef;
    private static final String SECURE = "secure";
    private static final int SECURE_LENGTH = SECURE.length();
    private static final String HTTP_ONLY = "httponly";
    private static final int HTTP_ONLY_LENGTH = HTTP_ONLY.length();
    private static final String[] BAD_COUNTRY_2LDS = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", e.e, "or", "org"};
    private Map mCookieMap = new LinkedHashMap(200, 0.75f, true);
    private boolean mAcceptCookie = true;

    private static native boolean nativeAcceptCookie();

    private static native boolean nativeAcceptFileSchemeCookies();

    private static native void nativeFlushCookieStore();

    private static native String nativeGetCookie(String str, boolean z);

    private static native boolean nativeHasCookies(boolean z);

    private static native void nativeRemoveAllCookie();

    private static native void nativeRemoveExpiredCookie();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRemoveSessionCookie();

    private static native void nativeSetAcceptCookie(boolean z);

    private static native void nativeSetAcceptFileSchemeCookies(boolean z);

    private static native void nativeSetCookie(String str, String str2, boolean z);

    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
        COMPARATOR = new CookieComparator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Cookie {
        static final byte MODE_DELETED = 2;
        static final byte MODE_NEW = 0;
        static final byte MODE_NORMAL = 1;
        static final byte MODE_REPLACED = 3;
        String domain;
        long expires;
        long lastAcessTime;
        long lastUpdateTime;
        byte mode;
        String name;
        String path;
        boolean secure;
        String value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Cookie() {
        }

        Cookie(String str, String str2) {
            this.domain = str;
            this.path = str2;
            this.expires = -1L;
        }

        boolean exactMatch(Cookie cookie) {
            return this.domain.equals(cookie.domain) && this.path.equals(cookie.path) && this.name.equals(cookie.name) && (!((this.value == null) ^ (cookie.value == null)));
        }

        boolean domainMatch(String str) {
            if (this.domain.startsWith(".")) {
                if (str.endsWith(this.domain.substring(1))) {
                    int length = this.domain.length();
                    int length2 = str.length();
                    return length2 <= length + (-1) || str.charAt(length2 - length) == '.';
                }
                return false;
            }
            return str.equals(this.domain);
        }

        boolean pathMatch(String str) {
            if (str.startsWith(this.path)) {
                int length = this.path.length();
                if (length == 0) {
                    Log.w(CookieManager.LOGTAG, "Empty cookie path");
                    return false;
                }
                int length2 = str.length();
                if (this.path.charAt(length - 1) == '/' || length2 <= length) {
                    return true;
                }
                return str.charAt(length) == '/';
            }
            return false;
        }

        public String toString() {
            return "domain: " + this.domain + "; path: " + this.path + "; name: " + this.name + "; value: " + this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class CookieComparator implements Comparator {
        private CookieComparator() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Cookie cookie, Cookie cookie2) {
            int length = cookie2.path.length() - cookie.path.length();
            if (length == 0) {
                int length2 = cookie2.domain.length() - cookie.domain.length();
                if (length2 == 0) {
                    if (cookie2.value == null) {
                        if (cookie.value != null) {
                            return -1;
                        }
                    } else if (cookie.value == null) {
                        return 1;
                    }
                    return cookie.name.compareTo(cookie2.name);
                }
                return length2;
            }
            return length;
        }
    }

    private CookieManager() {
    }

    protected Object clone() {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    public static synchronized CookieManager getInstance() {
        CookieManager cookieManager;
        synchronized (CookieManager.class) {
            if (sRef == null) {
                sRef = new CookieManager();
            }
            cookieManager = sRef;
        }
        return cookieManager;
    }

    public synchronized void setAcceptCookie(boolean z) {
        if (JniUtil.useChromiumHttpStack()) {
            nativeSetAcceptCookie(z);
        } else {
            this.mAcceptCookie = z;
        }
    }

    public synchronized boolean acceptCookie() {
        return JniUtil.useChromiumHttpStack() ? nativeAcceptCookie() : this.mAcceptCookie;
    }

    public void setCookie(String str, String str2) {
        if (JniUtil.useChromiumHttpStack()) {
            setCookie(str, str2, false);
            return;
        }
        try {
            setCookie(new WebAddress(str), str2);
        } catch (ParseException e) {
            Log.e(LOGTAG, "Bad address: " + str);
        }
    }

    public void setCookie(String str, String str2, boolean z) {
        if (!JniUtil.useChromiumHttpStack()) {
            setCookie(str, str2);
            return;
        }
        try {
            nativeSetCookie(new WebAddress(str).toString(), str2, z);
        } catch (ParseException e) {
            Log.e(LOGTAG, "Bad address: " + str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        if (r17.length() > 4096) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void setCookie(WebAddress webAddress, String str) {
        String[] hostAndPath;
        ArrayList arrayList;
        boolean z;
        if (str != null) {
        }
        if (this.mAcceptCookie && webAddress != null && (hostAndPath = getHostAndPath(webAddress)) != null) {
            if (hostAndPath[1].length() > 1) {
                int lastIndexOf = hostAndPath[1].lastIndexOf(47);
                String str2 = hostAndPath[1];
                if (lastIndexOf <= 0) {
                    lastIndexOf++;
                }
                hostAndPath[1] = str2.substring(0, lastIndexOf);
            }
            try {
                arrayList = parseCookie(hostAndPath[0], hostAndPath[1], str);
            } catch (RuntimeException e) {
                Log.e(LOGTAG, "parse cookie failed for: " + str);
                arrayList = null;
            }
            if (arrayList != null && arrayList.size() != 0) {
                String baseDomain = getBaseDomain(hostAndPath[0]);
                ArrayList arrayList2 = (ArrayList) this.mCookieMap.get(baseDomain);
                if (arrayList2 == null) {
                    arrayList2 = CookieSyncManager.getInstance().getCookiesForDomain(baseDomain);
                    this.mCookieMap.put(baseDomain, arrayList2);
                }
                ArrayList arrayList3 = arrayList2;
                long currentTimeMillis = System.currentTimeMillis();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    Cookie cookie = (Cookie) arrayList.get(i);
                    Iterator it = arrayList3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        Cookie cookie2 = (Cookie) it.next();
                        if (cookie.exactMatch(cookie2)) {
                            if (cookie.expires < 0 || cookie.expires > currentTimeMillis) {
                                if (!cookie2.secure || HTTPS.equals(webAddress.mScheme)) {
                                    cookie2.value = cookie.value;
                                    cookie2.expires = cookie.expires;
                                    cookie2.secure = cookie.secure;
                                    cookie2.lastAcessTime = currentTimeMillis;
                                    cookie2.lastUpdateTime = currentTimeMillis;
                                    cookie2.mode = (byte) 3;
                                }
                            } else {
                                cookie2.lastUpdateTime = currentTimeMillis;
                                cookie2.mode = (byte) 2;
                            }
                            z = true;
                        }
                    }
                    if (!z && (cookie.expires < 0 || cookie.expires > currentTimeMillis)) {
                        cookie.lastAcessTime = currentTimeMillis;
                        cookie.lastUpdateTime = currentTimeMillis;
                        cookie.mode = (byte) 0;
                        if (arrayList3.size() > MAX_COOKIE_COUNT_PER_BASE_DOMAIN) {
                            Cookie cookie3 = new Cookie();
                            cookie3.lastAcessTime = currentTimeMillis;
                            Iterator it2 = arrayList3.iterator();
                            while (it2.hasNext()) {
                                Cookie cookie4 = (Cookie) it2.next();
                                if (cookie4.lastAcessTime >= cookie3.lastAcessTime || cookie4.mode == 2) {
                                    cookie4 = cookie3;
                                }
                                cookie3 = cookie4;
                            }
                            cookie3.mode = (byte) 2;
                        }
                        arrayList3.add(cookie);
                    }
                }
            }
        }
    }

    public String getCookie(String str) {
        if (JniUtil.useChromiumHttpStack()) {
            return getCookie(str, false);
        }
        try {
            return getCookie(new WebAddress(str));
        } catch (ParseException e) {
            Log.e(LOGTAG, "Bad address: " + str);
            return null;
        }
    }

    public String getCookie(String str, boolean z) {
        if (!JniUtil.useChromiumHttpStack()) {
            return getCookie(str);
        }
        try {
            return nativeGetCookie(new WebAddress(str).toString(), z);
        } catch (ParseException e) {
            Log.e(LOGTAG, "Bad address: " + str);
            return null;
        }
    }

    public synchronized String getCookie(WebAddress webAddress) {
        String str;
        if (!this.mAcceptCookie || webAddress == null) {
            str = null;
        } else {
            String[] hostAndPath = getHostAndPath(webAddress);
            if (hostAndPath == null) {
                str = null;
            } else {
                String baseDomain = getBaseDomain(hostAndPath[0]);
                ArrayList arrayList = (ArrayList) this.mCookieMap.get(baseDomain);
                if (arrayList == null) {
                    arrayList = CookieSyncManager.getInstance().getCookiesForDomain(baseDomain);
                    this.mCookieMap.put(baseDomain, arrayList);
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean equals = HTTPS.equals(webAddress.mScheme);
                Iterator it = arrayList.iterator();
                TreeSet<Cookie> treeSet = new TreeSet(COMPARATOR);
                while (it.hasNext()) {
                    Cookie cookie = (Cookie) it.next();
                    if (cookie.domainMatch(hostAndPath[0]) && cookie.pathMatch(hostAndPath[1]) && (cookie.expires < 0 || cookie.expires > currentTimeMillis)) {
                        if (!cookie.secure || equals) {
                            if (cookie.mode != 2) {
                                cookie.lastAcessTime = currentTimeMillis;
                                treeSet.add(cookie);
                            }
                        }
                    }
                }
                StringBuilder sb = new StringBuilder(256);
                for (Cookie cookie2 : treeSet) {
                    if (sb.length() > 0) {
                        sb.append(SEMICOLON);
                        sb.append(WHITE_SPACE);
                    }
                    sb.append(cookie2.name);
                    if (cookie2.value != null) {
                        sb.append(EQUAL);
                        sb.append(cookie2.value);
                    }
                }
                str = sb.length() > 0 ? sb.toString() : null;
            }
        }
        return str;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.zeus.CookieManager$1] */
    public void removeSessionCookie() {
        if (JniUtil.useChromiumHttpStack()) {
            new AsyncTask() { // from class: com.baidu.zeus.CookieManager.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    CookieManager.nativeRemoveSessionCookie();
                    return null;
                }
            }.execute(new Void[0]);
        } else {
            new Thread(new Runnable() { // from class: com.baidu.zeus.CookieManager.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CookieManager.this) {
                        for (ArrayList arrayList : CookieManager.this.mCookieMap.values()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (((Cookie) it.next()).expires == -1) {
                                    it.remove();
                                }
                            }
                        }
                        CookieSyncManager.getInstance().clearSessionCookies();
                    }
                }
            }).start();
        }
    }

    public void removeAllCookie() {
        if (JniUtil.useChromiumHttpStack()) {
            nativeRemoveAllCookie();
        } else {
            new Thread(new Runnable() { // from class: com.baidu.zeus.CookieManager.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CookieManager.this) {
                        CookieManager.this.mCookieMap = new LinkedHashMap(200, 0.75f, true);
                        CookieSyncManager.getInstance().clearAllCookies();
                    }
                }
            }).start();
        }
    }

    public void deleteCookieFile(Context context) {
        File file = new File(context.getApplicationContext().getDatabasePath("dummy").getParent() + "/webviewCookiesChromium.db");
        if (file.exists() && !file.delete()) {
            Log.v("CookieManager", "----in file delete failed");
        }
    }

    public synchronized boolean hasCookies() {
        return JniUtil.useChromiumHttpStack() ? hasCookies(false) : CookieSyncManager.getInstance().hasCookies();
    }

    public synchronized boolean hasCookies(boolean z) {
        return !JniUtil.useChromiumHttpStack() ? hasCookies() : nativeHasCookies(z);
    }

    public void removeExpiredCookie() {
        if (JniUtil.useChromiumHttpStack()) {
            nativeRemoveExpiredCookie();
        } else {
            new Thread(new Runnable() { // from class: com.baidu.zeus.CookieManager.4
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CookieManager.this) {
                        long currentTimeMillis = System.currentTimeMillis();
                        for (ArrayList arrayList : CookieManager.this.mCookieMap.values()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                Cookie cookie = (Cookie) it.next();
                                if (cookie.expires > 0 && cookie.expires < currentTimeMillis) {
                                    it.remove();
                                }
                            }
                        }
                        CookieSyncManager.getInstance().clearExpiredCookies(currentTimeMillis);
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flushCookieStore() {
        if (JniUtil.useChromiumHttpStack()) {
            nativeFlushCookieStore();
        }
    }

    public static boolean allowFileSchemeCookies() {
        if (JniUtil.useChromiumHttpStack()) {
            return nativeAcceptFileSchemeCookies();
        }
        return true;
    }

    public static void setAcceptFileSchemeCookies(boolean z) {
        if (JniUtil.useChromiumHttpStack()) {
            nativeSetAcceptFileSchemeCookies(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ArrayList getUpdatedCookiesSince(long j) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (ArrayList arrayList2 : this.mCookieMap.values()) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Cookie cookie = (Cookie) it.next();
                if (cookie.lastUpdateTime > j) {
                    arrayList.add(cookie);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void deleteACookie(Cookie cookie) {
        if (cookie.mode == 2) {
            String baseDomain = getBaseDomain(cookie.domain);
            ArrayList arrayList = (ArrayList) this.mCookieMap.get(baseDomain);
            if (arrayList != null) {
                arrayList.remove(cookie);
                if (arrayList.isEmpty()) {
                    this.mCookieMap.remove(baseDomain);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void syncedACookie(Cookie cookie) {
        cookie.mode = (byte) 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ArrayList deleteLRUDomain() {
        ArrayList arrayList;
        int i = 0;
        int size = this.mCookieMap.size();
        if (size < 15) {
            Iterator it = this.mCookieMap.values().iterator();
            int i2 = 0;
            while (it.hasNext() && i2 < 1000) {
                i2 += ((ArrayList) it.next()).size();
            }
            i = i2;
        }
        arrayList = new ArrayList();
        if (size >= 15 || i >= 1000) {
            Object[] array = this.mCookieMap.keySet().toArray();
            int i3 = (size / 10) + 1;
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                String obj = array[i4].toString();
                arrayList.addAll((Collection) this.mCookieMap.get(obj));
                this.mCookieMap.remove(obj);
                i3 = i4;
            }
        }
        return arrayList;
    }

    private String[] getHostAndPath(WebAddress webAddress) {
        if (webAddress.mHost == null || webAddress.mPath == null) {
            return null;
        }
        String[] strArr = {webAddress.mHost.toLowerCase(), webAddress.mPath};
        int indexOf = strArr[0].indexOf(46);
        if (indexOf == -1) {
            if (webAddress.mScheme.equalsIgnoreCase("file")) {
                strArr[0] = "localhost";
            }
        } else if (indexOf == strArr[0].lastIndexOf(46)) {
            strArr[0] = PERIOD + strArr[0];
        }
        if (strArr[1].charAt(0) != '/') {
            return null;
        }
        int indexOf2 = strArr[1].indexOf(63);
        if (indexOf2 != -1) {
            strArr[1] = strArr[1].substring(0, indexOf2);
        }
        return strArr;
    }

    private String getBaseDomain(String str) {
        int i = 0;
        int indexOf = str.indexOf(46);
        int lastIndexOf = str.lastIndexOf(46);
        while (indexOf < lastIndexOf) {
            i = indexOf + 1;
            indexOf = str.indexOf(46, i);
        }
        if (i > 0) {
            return str.substring(i);
        }
        return str;
    }

    private ArrayList parseCookie(String str, String str2, String str3) {
        int i;
        String str4;
        int i2;
        int indexOf;
        int indexOf2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int length = str3.length();
        while (i3 >= 0 && i3 < length) {
            if (str3.charAt(i3) == ' ') {
                i3++;
            } else {
                int indexOf3 = str3.indexOf(59, i3);
                int indexOf4 = str3.indexOf(61, i3);
                Cookie cookie = new Cookie(str, str2);
                if ((indexOf3 != -1 && indexOf3 < indexOf4) || indexOf4 == -1) {
                    if (indexOf3 == -1) {
                        indexOf3 = length;
                    }
                    cookie.name = str3.substring(i3, indexOf3);
                    cookie.value = null;
                } else {
                    cookie.name = str3.substring(i3, indexOf4);
                    if (indexOf4 < length - 1 && str3.charAt(indexOf4 + 1) == '\"') {
                        i = str3.indexOf(34, indexOf4 + 2);
                        if (i == -1) {
                            break;
                        }
                    } else {
                        i = i3;
                    }
                    indexOf3 = str3.indexOf(59, i);
                    if (indexOf3 == -1) {
                        indexOf3 = length;
                    }
                    if (indexOf3 - indexOf4 > 4096) {
                        cookie.value = str3.substring(indexOf4 + 1, indexOf4 + 1 + 4096);
                    } else if (indexOf4 + 1 == indexOf3 || indexOf3 < indexOf4) {
                        cookie.value = "";
                    } else {
                        cookie.value = str3.substring(indexOf4 + 1, indexOf3);
                    }
                }
                while (true) {
                    if (indexOf3 < 0 || indexOf3 >= length) {
                        break;
                    } else if (str3.charAt(indexOf3) == ' ' || str3.charAt(indexOf3) == ';') {
                        indexOf3++;
                    } else if (str3.charAt(indexOf3) == ',') {
                        indexOf3++;
                        break;
                    } else if (length - indexOf3 >= SECURE_LENGTH && str3.substring(indexOf3, SECURE_LENGTH + indexOf3).equalsIgnoreCase(SECURE)) {
                        indexOf3 += SECURE_LENGTH;
                        cookie.secure = true;
                        if (indexOf3 == length) {
                            break;
                        } else if (str3.charAt(indexOf3) == '=') {
                            indexOf3++;
                        }
                    } else if (length - indexOf3 >= HTTP_ONLY_LENGTH && str3.substring(indexOf3, HTTP_ONLY_LENGTH + indexOf3).equalsIgnoreCase(HTTP_ONLY)) {
                        indexOf3 += HTTP_ONLY_LENGTH;
                        if (indexOf3 == length) {
                            break;
                        } else if (str3.charAt(indexOf3) == '=') {
                            indexOf3++;
                        }
                    } else {
                        int indexOf5 = str3.indexOf(61, indexOf3);
                        if (indexOf5 > 0) {
                            String lowerCase = str3.substring(indexOf3, indexOf5).toLowerCase();
                            if (lowerCase.equals("expires") && (indexOf2 = str3.indexOf(44, indexOf5)) != -1 && indexOf2 - indexOf5 <= 10) {
                                indexOf3 = indexOf2 + 1;
                            }
                            int indexOf6 = str3.indexOf(59, indexOf3);
                            indexOf3 = str3.indexOf(44, indexOf3);
                            if (indexOf6 == -1 && indexOf3 == -1) {
                                indexOf3 = length;
                            } else if (indexOf6 != -1) {
                                indexOf3 = indexOf3 == -1 ? indexOf6 : Math.min(indexOf6, indexOf3);
                            }
                            String substring = str3.substring(indexOf5 + 1, indexOf3);
                            if (substring.length() > 2 && substring.charAt(0) == '\"' && (indexOf = substring.indexOf(34, 1)) > 0) {
                                substring = substring.substring(1, indexOf);
                            }
                            if (lowerCase.equals("expires")) {
                                try {
                                    cookie.expires = AndroidHttpClient.parseDate(substring);
                                } catch (IllegalArgumentException e) {
                                    Log.e(LOGTAG, "illegal format for expires: " + substring);
                                }
                            } else if (lowerCase.equals(MAX_AGE)) {
                                try {
                                    cookie.expires = System.currentTimeMillis() + (1000 * Long.parseLong(substring));
                                } catch (NumberFormatException e2) {
                                    Log.e(LOGTAG, "illegal format for max-age: " + substring);
                                }
                            } else if (lowerCase.equals(PATH)) {
                                if (substring.length() > 0) {
                                    cookie.path = substring;
                                }
                            } else if (lowerCase.equals(DOMAIN)) {
                                int lastIndexOf = substring.lastIndexOf(46);
                                if (lastIndexOf == 0) {
                                    cookie.domain = null;
                                } else {
                                    try {
                                        Integer.parseInt(substring.substring(lastIndexOf + 1));
                                        if (!substring.equals(str)) {
                                            cookie.domain = null;
                                        }
                                    } catch (NumberFormatException e3) {
                                        String lowerCase2 = substring.toLowerCase();
                                        if (lowerCase2.charAt(0) != '.') {
                                            String str5 = PERIOD + lowerCase2;
                                            i2 = lastIndexOf + 1;
                                            str4 = str5;
                                        } else {
                                            str4 = lowerCase2;
                                            i2 = lastIndexOf;
                                        }
                                        if (str.endsWith(str4.substring(1))) {
                                            int length2 = str4.length();
                                            int length3 = str.length();
                                            if (length3 > length2 - 1 && str.charAt(length3 - length2) != '.') {
                                                cookie.domain = null;
                                            } else {
                                                if (length2 == i2 + 3 && length2 >= 6 && length2 <= 8) {
                                                    if (Arrays.binarySearch(BAD_COUNTRY_2LDS, str4.substring(1, i2)) >= 0) {
                                                        cookie.domain = null;
                                                    }
                                                }
                                                cookie.domain = str4;
                                            }
                                        } else {
                                            cookie.domain = null;
                                        }
                                    }
                                }
                            }
                        } else {
                            indexOf3 = length;
                        }
                    }
                }
                if (cookie != null && cookie.domain != null) {
                    arrayList.add(cookie);
                }
                i3 = indexOf3;
            }
        }
        return arrayList;
    }
}
