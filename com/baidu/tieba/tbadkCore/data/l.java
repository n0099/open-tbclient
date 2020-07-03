package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class l {
    private String c;
    private static final Pattern pbPattern0 = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern lFF = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private int type = 0;
    private String text = null;
    private String link = null;
    private String lFD = null;
    private SpannableStringBuilder lFE = null;
    private boolean lFC = false;

    public static boolean db(int i, int i2) {
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

    public String dhH() {
        return this.c;
    }

    public SpannableStringBuilder dhI() {
        return this.lFE;
    }

    public SpannableStringBuilder b(SpannableString spannableString) {
        if (this.lFE == null) {
            this.lFE = new SpannableStringBuilder();
        }
        this.lFE.append((CharSequence) spannableString);
        return this.lFE;
    }

    public SpannableString fn(Context context) {
        String str;
        switch (this.type) {
            case 0:
                return new SpannableString(this.text);
            case 1:
                if (!this.text.endsWith(" ")) {
                    this.text += " ";
                }
                SpannableString spannableString = new SpannableString(this.text);
                spannableString.setSpan(new com.baidu.tbadk.util.p(context) { // from class: com.baidu.tieba.tbadkCore.data.l.2
                    @Override // com.baidu.tbadk.util.p, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        Matcher matcher = l.pbPattern0.matcher(l.this.link);
                        if (matcher.find()) {
                            try {
                                String group = matcher.group();
                                zl(group.substring(group.lastIndexOf("/") + 1));
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        Matcher matcher2 = l.lFF.matcher(l.this.link);
                        if (matcher2.find()) {
                            try {
                                String group2 = matcher2.group();
                                zl(group2.substring(group2.lastIndexOf(ETAG.EQUAL) + 1));
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        zk(l.this.link);
                    }
                }, 0, this.text.length() - 1, 33);
                return spannableString;
            case 2:
                SpannableString spannableString2 = new SpannableString(this.text + " ");
                com.baidu.adp.widget.ImageView.a face = TbadkCoreApplication.getInst().getFace(this.text);
                if (face != null) {
                    BitmapDrawable asBitmapDrawable = face.getAsBitmapDrawable();
                    asBitmapDrawable.setBounds(0, 0, face.getWidth(), face.getHeight());
                    spannableString2.setSpan(new ImageSpan(asBitmapDrawable, 1), 0, this.text.length(), 33);
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
                spannableString3.setSpan(new com.baidu.tbadk.util.p(context) { // from class: com.baidu.tieba.tbadkCore.data.l.3
                    @Override // com.baidu.tbadk.util.p, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        if (l.this.text != null) {
                            l.this.text.replace(UgcConstant.AT_RULE_TAG, "").replace(" ", "");
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(getContext()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(l.this.link, 0L), false, false)));
                    }
                }, 0, this.text.length() - 1, 33);
                return spannableString3;
            case 5:
                if (!this.text.endsWith(" ")) {
                    this.text += " ";
                }
                String string = context.getString(R.string.video);
                SpannableString spannableString4 = new SpannableString(string + this.text);
                spannableString4.setSpan(new com.baidu.tbadk.util.p(context) { // from class: com.baidu.tieba.tbadkCore.data.l.1
                    @Override // com.baidu.tbadk.util.p, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        zk(l.this.text);
                    }
                }, string.length(), str.length() - 1, 33);
                return spannableString4;
        }
    }

    public String getLink() {
        return this.link;
    }
}
