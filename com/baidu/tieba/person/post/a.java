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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a bHa;
    private static String bHb;
    public TextView aBl;
    public TextView aPs;
    private final LinearLayout bGW;
    private final LinearLayout bGX;
    private final ColumnLayout bGY;
    private final ColumnLayout bGZ;
    private b bHc;
    public LinearLayout bHd;
    public HeadImageView bHe;
    public TextView bHf;
    public TextView bHg;
    private int bxX;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bHd = (LinearLayout) view.findViewById(com.baidu.tieba.w.top_line);
        this.bHe = (HeadImageView) view.findViewById(com.baidu.tieba.w.portrait);
        this.bHf = (TextView) view.findViewById(com.baidu.tieba.w.username);
        this.aBl = (TextView) view.findViewById(com.baidu.tieba.w.reply_time);
        this.aPs = (TextView) view.findViewById(com.baidu.tieba.w.forum_name);
        this.bHg = (TextView) view.findViewById(com.baidu.tieba.w.reply_count);
        this.bGX = (LinearLayout) view.findViewById(com.baidu.tieba.w.item_content);
        this.bGY = (ColumnLayout) view.findViewById(com.baidu.tieba.w.item_header);
        this.bGZ = (ColumnLayout) view.findViewById(com.baidu.tieba.w.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(com.baidu.tieba.w.person_thread);
        this.bGW = (LinearLayout) view.findViewById(com.baidu.tieba.w.person_child);
        this.bxX = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.bGX != null) {
            this.bGX.setOnClickListener(this);
        }
        this.bHe.setOnClickListener(this);
        this.bHf.setOnClickListener(this);
        this.aBl.setOnClickListener(this);
        this.aPs.setOnClickListener(this);
        this.bHg.setOnClickListener(this);
        this.bGY.setOnClickListener(this);
        this.bGZ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.w.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.bHc != null) {
            this.bHc.O(view);
        }
    }

    public void a(b bVar) {
        this.bHc = bVar;
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
                            String n = ba.n(postList.create_time * 1000);
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
                            String n2 = ba.n(postList.create_time * 1000);
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
            this.bHf.setText(str4);
            this.aBl.setText(str3);
            this.aPs.setText(str2);
            this.aPs.setTag(str2);
            this.bHg.setText(str5);
            this.aPs.setOnClickListener(this);
            hG(str);
            if (this.bGX != null) {
                this.bGX.setTag(strArr);
            }
            this.bGY.setTag(strArr);
            this.bGZ.setTag(strArr);
        }
    }

    private void hG(String str) {
        if (bHb != null && !bHb.equals(str)) {
            bHa = null;
        }
        if (bHa != null) {
            this.bHe.setImageBitmap(bHa.ji());
            bHb = str;
            return;
        }
        this.bHe.a(str, 12, this.bxX, this.bxX, false);
    }

    public void cl(int i) {
        ax.b(this.aPs, com.baidu.tieba.t.cp_cont_d, 1);
        ax.b(this.aBl, com.baidu.tieba.t.cp_cont_d, 1);
        ax.b(this.bHf, com.baidu.tieba.t.cp_cont_f, 1);
        ax.i(this.mLayout, com.baidu.tieba.t.cp_bg_line_c);
        ax.i(this.bGW, com.baidu.tieba.v.daily_recommend_item_selector);
        TbadkCoreApplication.m255getInst().getSkinType();
        this.bHg.setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(com.baidu.tieba.v.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ax.b(this.bHg, com.baidu.tieba.t.cp_link_tip_c, 1);
    }
}
