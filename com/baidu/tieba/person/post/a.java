package com.baidu.tieba.person.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a ckA;
    private static String ckB;
    private TbPageContext<?> Mr;
    public TextView aOi;
    public TextView aTL;
    private final LinearLayout bJe;
    private int bXZ;
    private InterfaceC0067a ckC;
    public LinearLayout ckD;
    public HeadImageView ckE;
    public TextView ckF;
    public TextView ckG;
    private final LinearLayout ckw;
    private final LinearLayout ckx;
    private final ColumnLayout cky;
    private final ColumnLayout ckz;

    /* renamed from: com.baidu.tieba.person.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067a {
        void ac(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.Mr = tbPageContext;
        this.ckD = (LinearLayout) view.findViewById(i.f.top_line);
        this.ckE = (HeadImageView) view.findViewById(i.f.portrait);
        this.ckF = (TextView) view.findViewById(i.f.username);
        this.aTL = (TextView) view.findViewById(i.f.reply_time);
        this.aOi = (TextView) view.findViewById(i.f.forum_name);
        this.ckG = (TextView) view.findViewById(i.f.reply_count);
        this.ckx = (LinearLayout) view.findViewById(i.f.item_content);
        this.cky = (ColumnLayout) view.findViewById(i.f.item_header);
        this.ckz = (ColumnLayout) view.findViewById(i.f.item_footer);
        this.bJe = (LinearLayout) view.findViewById(i.f.person_thread);
        this.ckw = (LinearLayout) view.findViewById(i.f.person_child);
        this.bXZ = com.baidu.adp.lib.util.k.dip2px(view.getContext(), 42.0f);
        if (this.ckx != null) {
            this.ckx.setOnClickListener(this);
        }
        this.ckE.setOnClickListener(this);
        this.ckF.setOnClickListener(this);
        this.aTL.setOnClickListener(this);
        this.aOi.setOnClickListener(this);
        this.ckG.setOnClickListener(this);
        this.cky.setOnClickListener(this);
        this.ckz.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == i.f.forum_name) {
            if (this.Mr != null) {
                this.Mr.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.Mr.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.ckC != null) {
            this.ckC.ac(view);
        }
    }

    public void a(InterfaceC0067a interfaceC0067a) {
        this.ckC = interfaceC0067a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00b6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0008 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0032 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        String str6 = 3;
        String[] strArr = new String[3];
        try {
            try {
                try {
                    try {
                        if (z) {
                            String str7 = postInfoList.user_name;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String m = aq.m(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            str5 = String.valueOf(postInfoList.reply_num);
                            str4 = str7;
                            str3 = m;
                            str2 = str8;
                            str6 = 1;
                        } else {
                            String str9 = postInfoList.user_name;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            String m2 = aq.m(postInfoList.create_time * 1000);
                            String str10 = postInfoList.forum_name;
                            str5 = String.valueOf(postInfoList.reply_num);
                            str4 = str9;
                            str3 = m2;
                            str2 = str10;
                            str6 = 1;
                        }
                    } catch (Exception e) {
                        str6 = str5;
                        str2 = str5;
                        str4 = str3;
                        str3 = str2;
                        str2 = str6;
                        str6 = 0;
                        if (str6 != 0) {
                        }
                    }
                } catch (Exception e2) {
                    str4 = str3;
                    str3 = str2;
                    str2 = str6;
                    str6 = 0;
                    if (str6 != 0) {
                    }
                }
            } catch (Exception e3) {
                str6 = str5;
                str4 = str3;
                str3 = str2;
                str2 = str6;
                str6 = 0;
                if (str6 != 0) {
                }
            }
        } catch (Exception e4) {
            str6 = str5;
            str2 = str5;
            str3 = str5;
            str4 = str3;
            str3 = str2;
            str2 = str6;
            str6 = 0;
            if (str6 != 0) {
            }
        }
        if (str6 != 0) {
            this.ckF.setText(str4);
            this.aTL.setText(str3);
            this.aOi.setText(str2);
            this.aOi.setTag(str2);
            this.ckG.setText(str5);
            this.aOi.setOnClickListener(this);
            jy(str);
            if (this.ckx != null) {
                this.ckx.setTag(strArr);
            }
            this.cky.setTag(strArr);
            this.ckz.setTag(strArr);
        }
    }

    private void jy(String str) {
        if (ckB != null && !ckB.equals(str)) {
            ckA = null;
        }
        if (ckA != null) {
            this.ckE.setImageBitmap(ckA.nc());
            ckB = str;
            return;
        }
        this.ckE.a(str, 12, this.bXZ, this.bXZ, false);
    }

    public void cG(int i) {
        al.b(this.aOi, i.c.cp_cont_d, 1);
        al.b(this.aTL, i.c.cp_cont_d, 1);
        al.b(this.ckF, i.c.cp_cont_f, 1);
        al.i(this.bJe, i.c.cp_bg_line_c);
        al.i(this.ckw, i.e.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.ckG.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.b(this.ckG, i.c.cp_link_tip_c, 1);
    }
}
