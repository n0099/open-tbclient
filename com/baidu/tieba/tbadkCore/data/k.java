package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.d;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class k {
    private String c;
    private static final Pattern pbPattern0 = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern gMQ = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private int type = 0;
    private String text = null;
    private String link = null;
    private String gMO = null;
    private SpannableStringBuilder gMP = null;
    private boolean gMN = false;

    public static boolean bJ(int i, int i2) {
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

    public String bxm() {
        return this.c;
    }

    public SpannableStringBuilder bxn() {
        return this.gMP;
    }

    public SpannableStringBuilder b(SpannableString spannableString) {
        if (this.gMP == null) {
            this.gMP = new SpannableStringBuilder();
        }
        this.gMP.append((CharSequence) spannableString);
        return this.gMP;
    }

    public SpannableString cf(Context context) {
        String str;
        switch (this.type) {
            case 0:
                return new SpannableString(this.text);
            case 1:
                if (!this.text.endsWith(" ")) {
                    this.text += " ";
                }
                SpannableString spannableString = new SpannableString(this.text);
                spannableString.setSpan(new com.baidu.tbadk.util.k(context) { // from class: com.baidu.tieba.tbadkCore.data.k.2
                    @Override // com.baidu.tbadk.util.k, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        Matcher matcher = k.pbPattern0.matcher(k.this.link);
                        if (matcher.find()) {
                            try {
                                String group = matcher.group();
                                hC(group.substring(group.lastIndexOf("/") + 1));
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        Matcher matcher2 = k.gMQ.matcher(k.this.link);
                        if (matcher2.find()) {
                            try {
                                String group2 = matcher2.group();
                                hC(group2.substring(group2.lastIndexOf("=") + 1));
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        hB(k.this.link);
                    }
                }, 0, this.text.length() - 1, 33);
                return spannableString;
            case 2:
                SpannableString spannableString2 = new SpannableString(this.text + " ");
                com.baidu.adp.widget.ImageView.a face = TbadkCoreApplication.getInst().getFace(this.text);
                if (face != null) {
                    BitmapDrawable nb = face.nb();
                    nb.setBounds(0, 0, face.getWidth(), face.getHeight());
                    spannableString2.setSpan(new ImageSpan(nb, 1), 0, this.text.length(), 33);
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
                spannableString3.setSpan(new com.baidu.tbadk.util.k(context) { // from class: com.baidu.tieba.tbadkCore.data.k.3
                    @Override // com.baidu.tbadk.util.k, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        if (k.this.text != null) {
                            k.this.text.replace("@", "").replace(" ", "");
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getContext()).createNormalConfig(com.baidu.adp.lib.g.b.c(k.this.link, 0L), false, false)));
                    }
                }, 0, this.text.length() - 1, 33);
                return spannableString3;
            case 5:
                if (!this.text.endsWith(" ")) {
                    this.text += " ";
                }
                String string = context.getString(d.k.video);
                SpannableString spannableString4 = new SpannableString(string + this.text);
                spannableString4.setSpan(new com.baidu.tbadk.util.k(context) { // from class: com.baidu.tieba.tbadkCore.data.k.1
                    @Override // com.baidu.tbadk.util.k, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        hB(k.this.text);
                    }
                }, string.length(), str.length() - 1, 33);
                return spannableString4;
        }
    }

    public String getLink() {
        return this.link;
    }
}
