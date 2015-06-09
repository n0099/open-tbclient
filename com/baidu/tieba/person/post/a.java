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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a bTT;
    private static String bTU;
    public TextView aGI;
    public TextView aKw;
    private int bIb;
    private final LinearLayout bTP;
    private final LinearLayout bTQ;
    private final ColumnLayout bTR;
    private final ColumnLayout bTS;
    private b bTV;
    public LinearLayout bTW;
    public HeadImageView bTX;
    public TextView bTY;
    public TextView bTZ;
    private final LinearLayout bvn;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bTW = (LinearLayout) view.findViewById(com.baidu.tieba.q.top_line);
        this.bTX = (HeadImageView) view.findViewById(com.baidu.tieba.q.portrait);
        this.bTY = (TextView) view.findViewById(com.baidu.tieba.q.username);
        this.aKw = (TextView) view.findViewById(com.baidu.tieba.q.reply_time);
        this.aGI = (TextView) view.findViewById(com.baidu.tieba.q.forum_name);
        this.bTZ = (TextView) view.findViewById(com.baidu.tieba.q.reply_count);
        this.bTQ = (LinearLayout) view.findViewById(com.baidu.tieba.q.item_content);
        this.bTR = (ColumnLayout) view.findViewById(com.baidu.tieba.q.item_header);
        this.bTS = (ColumnLayout) view.findViewById(com.baidu.tieba.q.item_footer);
        this.bvn = (LinearLayout) view.findViewById(com.baidu.tieba.q.person_thread);
        this.bTP = (LinearLayout) view.findViewById(com.baidu.tieba.q.person_child);
        this.bIb = com.baidu.adp.lib.util.n.dip2px(view.getContext(), 42.0f);
        if (this.bTQ != null) {
            this.bTQ.setOnClickListener(this);
        }
        this.bTX.setOnClickListener(this);
        this.bTY.setOnClickListener(this);
        this.aKw.setOnClickListener(this);
        this.aGI.setOnClickListener(this);
        this.bTZ.setOnClickListener(this);
        this.bTR.setOnClickListener(this);
        this.bTS.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.q.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.bTV != null) {
            this.bTV.Q(view);
        }
    }

    public void a(b bVar) {
        this.bTV = bVar;
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
                            String o = bb.o(postList.create_time * 1000);
                            String str8 = postList.forum_name;
                            str5 = String.valueOf(postList.reply_num);
                            str4 = str7;
                            str3 = o;
                            str2 = str8;
                            str6 = 1;
                        } else {
                            String str9 = postList.user_name;
                            strArr[0] = String.valueOf(postList.thread_id);
                            strArr[1] = String.valueOf(postList.content[0].post_id);
                            strArr[2] = String.valueOf(postList.content[0].post_type);
                            String o2 = bb.o(postList.create_time * 1000);
                            String str10 = postList.forum_name;
                            str5 = String.valueOf(postList.reply_num);
                            str4 = str9;
                            str3 = o2;
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
            this.bTY.setText(str4);
            this.aKw.setText(str3);
            this.aGI.setText(str2);
            this.aGI.setTag(str2);
            this.bTZ.setText(str5);
            this.aGI.setOnClickListener(this);
            iE(str);
            if (this.bTQ != null) {
                this.bTQ.setTag(strArr);
            }
            this.bTR.setTag(strArr);
            this.bTS.setTag(strArr);
        }
    }

    private void iE(String str) {
        if (bTU != null && !bTU.equals(str)) {
            bTT = null;
        }
        if (bTT != null) {
            this.bTX.setImageBitmap(bTT.mS());
            bTU = str;
            return;
        }
        this.bTX.a(str, 12, this.bIb, this.bIb, false);
    }

    public void cy(int i) {
        ay.b(this.aGI, com.baidu.tieba.n.cp_cont_d, 1);
        ay.b(this.aKw, com.baidu.tieba.n.cp_cont_d, 1);
        ay.b(this.bTY, com.baidu.tieba.n.cp_cont_f, 1);
        ay.i(this.bvn, com.baidu.tieba.n.cp_bg_line_c);
        ay.i(this.bTP, com.baidu.tieba.p.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.bTZ.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ay.b(this.bTZ, com.baidu.tieba.n.cp_link_tip_c, 1);
    }
}
