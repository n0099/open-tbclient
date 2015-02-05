package com.baidu.tieba.person.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a bIL;
    private static String bIM;
    public TextView aCj;
    public TextView aQw;
    private final LinearLayout bIH;
    private final LinearLayout bII;
    private final ColumnLayout bIJ;
    private final ColumnLayout bIK;
    private b bIN;
    public LinearLayout bIO;
    public HeadImageView bIP;
    public TextView bIQ;
    public TextView bIR;
    private int bzF;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bIO = (LinearLayout) view.findViewById(com.baidu.tieba.w.top_line);
        this.bIP = (HeadImageView) view.findViewById(com.baidu.tieba.w.portrait);
        this.bIQ = (TextView) view.findViewById(com.baidu.tieba.w.username);
        this.aCj = (TextView) view.findViewById(com.baidu.tieba.w.reply_time);
        this.aQw = (TextView) view.findViewById(com.baidu.tieba.w.forum_name);
        this.bIR = (TextView) view.findViewById(com.baidu.tieba.w.reply_count);
        this.bII = (LinearLayout) view.findViewById(com.baidu.tieba.w.item_content);
        this.bIJ = (ColumnLayout) view.findViewById(com.baidu.tieba.w.item_header);
        this.bIK = (ColumnLayout) view.findViewById(com.baidu.tieba.w.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(com.baidu.tieba.w.person_thread);
        this.bIH = (LinearLayout) view.findViewById(com.baidu.tieba.w.person_child);
        this.bzF = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.bII != null) {
            this.bII.setOnClickListener(this);
        }
        this.bIP.setOnClickListener(this);
        this.bIQ.setOnClickListener(this);
        this.aCj.setOnClickListener(this);
        this.aQw.setOnClickListener(this);
        this.bIR.setOnClickListener(this);
        this.bIJ.setOnClickListener(this);
        this.bIK.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.w.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.bIN != null) {
            this.bIN.Q(view);
        }
    }

    public void a(b bVar) {
        this.bIN = bVar;
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
                            String n = bf.n(postList.create_time * 1000);
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
                            String n2 = bf.n(postList.create_time * 1000);
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
            this.bIQ.setText(str4);
            this.aCj.setText(str3);
            this.aQw.setText(str2);
            this.aQw.setTag(str2);
            this.bIR.setText(str5);
            this.aQw.setOnClickListener(this);
            hK(str);
            if (this.bII != null) {
                this.bII.setTag(strArr);
            }
            this.bIJ.setTag(strArr);
            this.bIK.setTag(strArr);
        }
    }

    private void hK(String str) {
        if (bIM != null && !bIM.equals(str)) {
            bIL = null;
        }
        if (bIL != null) {
            this.bIP.setImageBitmap(bIL.jc());
            bIM = str;
            return;
        }
        this.bIP.a(str, 12, this.bzF, this.bzF, false);
    }

    public void cs(int i) {
        bc.b(this.aQw, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.aCj, com.baidu.tieba.t.cp_cont_d, 1);
        bc.b(this.bIQ, com.baidu.tieba.t.cp_cont_f, 1);
        bc.i(this.mLayout, com.baidu.tieba.t.cp_bg_line_c);
        bc.i(this.bIH, com.baidu.tieba.v.daily_recommend_item_selector);
        this.bIR.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        bc.b(this.bIR, com.baidu.tieba.t.cp_link_tip_c, 1);
    }
}
