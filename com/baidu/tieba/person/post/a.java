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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a crk;
    private static String crl;
    public TextView aNC;
    public TextView aTg;
    private final LinearLayout bNb;
    private int ccQ;
    protected final LinearLayout crg;
    private final LinearLayout crh;
    protected final ColumnLayout cri;
    protected final ColumnLayout crj;
    private InterfaceC0072a crm;
    public LinearLayout crn;
    public HeadImageView cro;
    public TextView crp;
    public TextView crq;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.person.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072a {
        void ae(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.crn = (LinearLayout) view.findViewById(i.f.top_line);
        this.cro = (HeadImageView) view.findViewById(i.f.portrait);
        this.crp = (TextView) view.findViewById(i.f.username);
        this.aTg = (TextView) view.findViewById(i.f.reply_time);
        this.aNC = (TextView) view.findViewById(i.f.forum_name);
        this.crq = (TextView) view.findViewById(i.f.reply_count);
        this.crh = (LinearLayout) view.findViewById(i.f.item_content);
        this.cri = (ColumnLayout) view.findViewById(i.f.item_header);
        this.crj = (ColumnLayout) view.findViewById(i.f.item_footer);
        this.bNb = (LinearLayout) view.findViewById(i.f.person_thread);
        this.crg = (LinearLayout) view.findViewById(i.f.person_child);
        this.ccQ = com.baidu.adp.lib.util.k.dip2px(view.getContext(), 42.0f);
        if (this.crh != null) {
            this.crh.setOnClickListener(this);
        }
        this.cro.setOnClickListener(this);
        this.crp.setOnClickListener(this);
        this.aTg.setOnClickListener(this);
        this.aNC.setOnClickListener(this);
        this.crq.setOnClickListener(this);
        this.cri.setOnClickListener(this);
        this.crj.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == i.f.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.crm != null) {
            this.crm.ae(view);
        }
    }

    public void a(InterfaceC0072a interfaceC0072a) {
        this.crm = interfaceC0072a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00cc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0008 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x003c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        String str6 = 4;
        String[] strArr = new String[4];
        try {
            try {
                try {
                    try {
                        if (z) {
                            String str7 = postInfoList.user_name;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String m = as.m(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = m;
                            str2 = str8;
                            str6 = valueOf;
                            str5 = 1;
                        } else {
                            String str9 = postInfoList.user_name;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str9;
                            str3 = as.m(postInfoList.create_time * 1000);
                            str2 = postInfoList.forum_name;
                            str6 = String.valueOf(postInfoList.reply_num);
                            str5 = 1;
                        }
                    } catch (Exception e) {
                        str4 = str3;
                        str3 = str2;
                        str2 = str6;
                        str6 = str5;
                        str5 = null;
                        if (str5 != null) {
                        }
                    }
                } catch (Exception e2) {
                    str6 = str5;
                    str4 = str3;
                    str3 = str2;
                    str2 = str6;
                    str6 = str5;
                    str5 = null;
                    if (str5 != null) {
                    }
                }
            } catch (Exception e3) {
                str6 = str5;
                str2 = str5;
                str4 = str3;
                str3 = str2;
                str2 = str6;
                str6 = str5;
                str5 = null;
                if (str5 != null) {
                }
            }
        } catch (Exception e4) {
            str6 = str5;
            str2 = str5;
            str3 = str5;
            str4 = str3;
            str3 = str2;
            str2 = str6;
            str6 = str5;
            str5 = null;
            if (str5 != null) {
            }
        }
        if (str5 != null) {
            this.crp.setText(str4);
            this.aTg.setText(str3);
            this.aNC.setText(str2);
            this.aNC.setTag(str2);
            this.crq.setText(str6);
            this.aNC.setOnClickListener(this);
            eu(str);
            if (this.crh != null) {
                this.crh.setTag(strArr);
            }
            this.cri.setTag(strArr);
            this.crj.setTag(strArr);
        }
    }

    private void eu(String str) {
        if (crl != null && !crl.equals(str)) {
            crk = null;
        }
        if (crk != null) {
            this.cro.setImageBitmap(crk.na());
            crl = str;
            return;
        }
        this.cro.a(str, 12, this.ccQ, this.ccQ, false);
    }

    public void cN(int i) {
        an.b(this.aNC, i.c.cp_cont_d, 1);
        an.b(this.aTg, i.c.cp_cont_d, 1);
        an.b(this.crp, i.c.cp_cont_f, 1);
        an.i(this.bNb, i.c.cp_bg_line_c);
        an.i(this.crg, i.e.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.crq.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        an.b(this.crq, i.c.cp_link_tip_c, 1);
    }
}
