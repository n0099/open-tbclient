package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.r;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private String c;
    private int height;
    private int width;
    private static final Pattern pbPattern0 = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern fCn = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private int type = 0;
    private String text = null;
    private String link = null;
    private String fCl = null;
    private SpannableStringBuilder fCm = null;
    private boolean fCk = false;

    public static boolean bw(int i, int i2) {
        return i == 0 && i2 != 3;
    }

    public static boolean bx(int i, int i2) {
        return (i != 0 || i2 == 3 || i2 == 2) ? false : true;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public String getText() {
        return this.text;
    }

    public String blV() {
        return this.c;
    }

    public SpannableStringBuilder blW() {
        return this.fCm;
    }

    public SpannableStringBuilder a(SpannableString spannableString) {
        if (this.fCm == null) {
            this.fCm = new SpannableStringBuilder();
        }
        this.fCm.append((CharSequence) spannableString);
        return this.fCm;
    }

    public SpannableString br(Context context) {
        String str;
        switch (this.type) {
            case 0:
                return new SpannableString(this.text);
            case 1:
                if (!this.text.endsWith(" ")) {
                    this.text = String.valueOf(this.text) + " ";
                }
                SpannableString spannableString = new SpannableString(this.text);
                spannableString.setSpan(new n(this, context), 0, this.text.length() - 1, 33);
                return spannableString;
            case 2:
                SpannableString spannableString2 = new SpannableString(String.valueOf(this.text) + " ");
                com.baidu.adp.widget.a.a face = TbadkCoreApplication.m9getInst().getFace(this.text);
                if (face != null) {
                    BitmapDrawable jX = face.jX();
                    jX.setBounds(0, 0, face.getWidth(), face.getHeight());
                    spannableString2.setSpan(new ImageSpan(jX, 1), 0, this.text.length(), 33);
                    return spannableString2;
                }
                return spannableString2;
            case 3:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            default:
                return null;
            case 4:
                if (!this.text.endsWith(" ")) {
                    this.text = String.valueOf(this.text) + " ";
                }
                SpannableString spannableString3 = new SpannableString(this.text);
                spannableString3.setSpan(new o(this, context), 0, this.text.length() - 1, 33);
                return spannableString3;
            case 5:
                if (!this.text.endsWith(" ")) {
                    this.text = String.valueOf(this.text) + " ";
                }
                String string = context.getString(r.j.video);
                SpannableString spannableString4 = new SpannableString(String.valueOf(string) + this.text);
                spannableString4.setSpan(new m(this, context), string.length(), str.length() - 1, 33);
                return spannableString4;
        }
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = jSONObject.optInt("type", 0);
                if (this.type == 3) {
                    this.link = jSONObject.optString("src");
                    this.text = jSONObject.optString("bsize");
                    this.fCl = jSONObject.optString("cdn_src", null);
                    if (this.text != null && this.text.length() > 0) {
                        String[] split = this.text.split(",");
                        if (split.length > 1) {
                            this.width = Integer.valueOf(split[0]).intValue();
                            this.height = Integer.valueOf(split[1]).intValue();
                        }
                    }
                    if (this.width <= 0) {
                        this.width = 1;
                    }
                    if (this.height <= 0) {
                        this.height = 1;
                    }
                    if (this.link != null && this.link.indexOf(".baidu.com") != -1) {
                        this.fCk = true;
                    }
                } else if (this.type == 4) {
                    this.text = jSONObject.optString("text");
                    this.link = jSONObject.optString("uid");
                } else if (this.type == 11) {
                    this.c = jSONObject.optString("c");
                } else {
                    this.text = jSONObject.optString("text");
                    this.link = jSONObject.optString("link");
                    if (this.type == 2 && TbFaceManager.Eo().fu(this.text) == 0) {
                        this.type = 0;
                        this.text = "[" + jSONObject.optString("c") + "]";
                    }
                }
                if (this.type != 0) {
                    this.text = this.text.replaceAll("\n", "");
                    this.link = this.link.replaceAll("\n", "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
