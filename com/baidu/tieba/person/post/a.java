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
    private static com.baidu.adp.widget.a.a bQX;
    private static String bQY;
    public TextView aEv;
    public TextView aIf;
    private int bES;
    private final LinearLayout bQT;
    private final LinearLayout bQU;
    private final ColumnLayout bQV;
    private final ColumnLayout bQW;
    private b bQZ;
    public LinearLayout bRa;
    public HeadImageView bRb;
    public TextView bRc;
    public TextView bRd;
    private final LinearLayout bsl;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bRa = (LinearLayout) view.findViewById(com.baidu.tieba.v.top_line);
        this.bRb = (HeadImageView) view.findViewById(com.baidu.tieba.v.portrait);
        this.bRc = (TextView) view.findViewById(com.baidu.tieba.v.username);
        this.aIf = (TextView) view.findViewById(com.baidu.tieba.v.reply_time);
        this.aEv = (TextView) view.findViewById(com.baidu.tieba.v.forum_name);
        this.bRd = (TextView) view.findViewById(com.baidu.tieba.v.reply_count);
        this.bQU = (LinearLayout) view.findViewById(com.baidu.tieba.v.item_content);
        this.bQV = (ColumnLayout) view.findViewById(com.baidu.tieba.v.item_header);
        this.bQW = (ColumnLayout) view.findViewById(com.baidu.tieba.v.item_footer);
        this.bsl = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_thread);
        this.bQT = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_child);
        this.bES = com.baidu.adp.lib.util.n.dip2px(view.getContext(), 42.0f);
        if (this.bQU != null) {
            this.bQU.setOnClickListener(this);
        }
        this.bRb.setOnClickListener(this);
        this.bRc.setOnClickListener(this);
        this.aIf.setOnClickListener(this);
        this.aEv.setOnClickListener(this);
        this.bRd.setOnClickListener(this);
        this.bQV.setOnClickListener(this);
        this.bQW.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.bQZ != null) {
            this.bQZ.Q(view);
        }
    }

    public void a(b bVar) {
        this.bQZ = bVar;
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
            this.bRc.setText(str4);
            this.aIf.setText(str3);
            this.aEv.setText(str2);
            this.aEv.setTag(str2);
            this.bRd.setText(str5);
            this.aEv.setOnClickListener(this);
            hW(str);
            if (this.bQU != null) {
                this.bQU.setTag(strArr);
            }
            this.bQV.setTag(strArr);
            this.bQW.setTag(strArr);
        }
    }

    private void hW(String str) {
        if (bQY != null && !bQY.equals(str)) {
            bQX = null;
        }
        if (bQX != null) {
            this.bRb.setImageBitmap(bQX.mz());
            bQY = str;
            return;
        }
        this.bRb.a(str, 12, this.bES, this.bES, false);
    }

    public void ct(int i) {
        ba.b(this.aEv, com.baidu.tieba.s.cp_cont_d, 1);
        ba.b(this.aIf, com.baidu.tieba.s.cp_cont_d, 1);
        ba.b(this.bRc, com.baidu.tieba.s.cp_cont_f, 1);
        ba.i(this.bsl, com.baidu.tieba.s.cp_bg_line_c);
        ba.i(this.bQT, com.baidu.tieba.u.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.bRd.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ba.b(this.bRd, com.baidu.tieba.s.cp_link_tip_c, 1);
    }
}
