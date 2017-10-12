package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private String c;
    private int height;
    private int width;
    private static final Pattern pbPattern0 = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern ggD = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private int type = 0;
    private String text = null;
    private String link = null;
    private String ggB = null;
    private SpannableStringBuilder ggC = null;
    private boolean ggA = false;

    public static boolean bT(int i, int i2) {
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

    public String brh() {
        return this.c;
    }

    public SpannableStringBuilder bri() {
        return this.ggC;
    }

    public SpannableStringBuilder b(SpannableString spannableString) {
        if (this.ggC == null) {
            this.ggC = new SpannableStringBuilder();
        }
        this.ggC.append((CharSequence) spannableString);
        return this.ggC;
    }

    public SpannableString bV(Context context) {
        String str;
        switch (this.type) {
            case 0:
                return new SpannableString(this.text);
            case 1:
                if (!this.text.endsWith(" ")) {
                    this.text += " ";
                }
                SpannableString spannableString = new SpannableString(this.text);
                spannableString.setSpan(new com.baidu.tbadk.util.i(context) { // from class: com.baidu.tieba.tbadkCore.data.k.2
                    @Override // com.baidu.tbadk.util.i, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        Matcher matcher = k.pbPattern0.matcher(k.this.link);
                        if (matcher.find()) {
                            try {
                                String group = matcher.group();
                                gH(group.substring(group.lastIndexOf("/") + 1));
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        Matcher matcher2 = k.ggD.matcher(k.this.link);
                        if (matcher2.find()) {
                            try {
                                String group2 = matcher2.group();
                                gH(group2.substring(group2.lastIndexOf("=") + 1));
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        gG(k.this.link);
                    }
                }, 0, this.text.length() - 1, 33);
                return spannableString;
            case 2:
                SpannableString spannableString2 = new SpannableString(this.text + " ");
                com.baidu.adp.widget.ImageView.a face = TbadkCoreApplication.getInst().getFace(this.text);
                if (face != null) {
                    BitmapDrawable kP = face.kP();
                    kP.setBounds(0, 0, face.getWidth(), face.getHeight());
                    spannableString2.setSpan(new ImageSpan(kP, 1), 0, this.text.length(), 33);
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
                    this.text += " ";
                }
                SpannableString spannableString3 = new SpannableString(this.text);
                spannableString3.setSpan(new com.baidu.tbadk.util.i(context) { // from class: com.baidu.tieba.tbadkCore.data.k.3
                    @Override // com.baidu.tbadk.util.i, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        if (k.this.text != null) {
                            k.this.text.replace("@", "").replace(" ", "");
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getContext()).createNormalConfig(com.baidu.adp.lib.g.b.c(k.this.link, 0L), false, false)));
                    }
                }, 0, this.text.length() - 1, 33);
                return spannableString3;
            case 5:
                if (!this.text.endsWith(" ")) {
                    this.text += " ";
                }
                String string = context.getString(d.l.video);
                SpannableString spannableString4 = new SpannableString(string + this.text);
                spannableString4.setSpan(new com.baidu.tbadk.util.i(context) { // from class: com.baidu.tieba.tbadkCore.data.k.1
                    @Override // com.baidu.tbadk.util.i, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        gG(k.this.text);
                    }
                }, string.length(), str.length() - 1, 33);
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
                    this.ggB = jSONObject.optString("cdn_src", null);
                    if (this.text != null && this.text.length() > 0) {
                        String[] split = this.text.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                        this.ggA = true;
                    }
                } else if (this.type == 4) {
                    this.text = jSONObject.optString("text");
                    this.link = jSONObject.optString(SapiAccountManager.SESSION_UID);
                } else if (this.type == 11) {
                    this.c = jSONObject.optString("c");
                } else {
                    this.text = jSONObject.optString("text");
                    this.link = jSONObject.optString("link");
                    if (this.type == 2 && TbFaceManager.DY().fz(this.text) == 0) {
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
