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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a bRn;
    private static String bRo;
    public TextView aED;
    public TextView aIn;
    private int bFf;
    private final LinearLayout bRj;
    private final LinearLayout bRk;
    private final ColumnLayout bRl;
    private final ColumnLayout bRm;
    private b bRp;
    public LinearLayout bRq;
    public HeadImageView bRr;
    public TextView bRs;
    public TextView bRt;
    private final LinearLayout bsB;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bRq = (LinearLayout) view.findViewById(com.baidu.tieba.v.top_line);
        this.bRr = (HeadImageView) view.findViewById(com.baidu.tieba.v.portrait);
        this.bRs = (TextView) view.findViewById(com.baidu.tieba.v.username);
        this.aIn = (TextView) view.findViewById(com.baidu.tieba.v.reply_time);
        this.aED = (TextView) view.findViewById(com.baidu.tieba.v.forum_name);
        this.bRt = (TextView) view.findViewById(com.baidu.tieba.v.reply_count);
        this.bRk = (LinearLayout) view.findViewById(com.baidu.tieba.v.item_content);
        this.bRl = (ColumnLayout) view.findViewById(com.baidu.tieba.v.item_header);
        this.bRm = (ColumnLayout) view.findViewById(com.baidu.tieba.v.item_footer);
        this.bsB = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_thread);
        this.bRj = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_child);
        this.bFf = com.baidu.adp.lib.util.n.dip2px(view.getContext(), 42.0f);
        if (this.bRk != null) {
            this.bRk.setOnClickListener(this);
        }
        this.bRr.setOnClickListener(this);
        this.bRs.setOnClickListener(this);
        this.aIn.setOnClickListener(this);
        this.aED.setOnClickListener(this);
        this.bRt.setOnClickListener(this);
        this.bRl.setOnClickListener(this);
        this.bRm.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.bRp != null) {
            this.bRp.Q(view);
        }
    }

    public void a(b bVar) {
        this.bRp = bVar;
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
    public void a(PersonPostModel.PostList postList, boolean z, String str) {
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
                            String str7 = postList.user_name;
                            strArr[0] = String.valueOf(postList.thread_id);
                            strArr[1] = String.valueOf(postList.post_id);
                            String n = bd.n(postList.create_time * 1000);
                            String str8 = postList.forum_name;
                            str5 = String.valueOf(postList.reply_num);
                            str4 = str7;
                            str3 = n;
                            str2 = str8;
                            str6 = 1;
                        } else {
                            String str9 = postList.user_name;
                            strArr[0] = String.valueOf(postList.thread_id);
                            strArr[1] = String.valueOf(postList.content[0].post_id);
                            strArr[2] = String.valueOf(postList.content[0].post_type);
                            String n2 = bd.n(postList.create_time * 1000);
                            String str10 = postList.forum_name;
                            str5 = String.valueOf(postList.reply_num);
                            str4 = str9;
                            str3 = n2;
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
            this.bRs.setText(str4);
            this.aIn.setText(str3);
            this.aED.setText(str2);
            this.aED.setTag(str2);
            this.bRt.setText(str5);
            this.aED.setOnClickListener(this);
            hZ(str);
            if (this.bRk != null) {
                this.bRk.setTag(strArr);
            }
            this.bRl.setTag(strArr);
            this.bRm.setTag(strArr);
        }
    }

    private void hZ(String str) {
        if (bRo != null && !bRo.equals(str)) {
            bRn = null;
        }
        if (bRn != null) {
            this.bRr.setImageBitmap(bRn.mz());
            bRo = str;
            return;
        }
        this.bRr.a(str, 12, this.bFf, this.bFf, false);
    }

    public void ct(int i) {
        ba.b(this.aED, com.baidu.tieba.s.cp_cont_d, 1);
        ba.b(this.aIn, com.baidu.tieba.s.cp_cont_d, 1);
        ba.b(this.bRs, com.baidu.tieba.s.cp_cont_f, 1);
        ba.i(this.bsB, com.baidu.tieba.s.cp_bg_line_c);
        ba.i(this.bRj, com.baidu.tieba.u.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.bRt.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ba.b(this.bRt, com.baidu.tieba.s.cp_link_tip_c, 1);
    }
}
