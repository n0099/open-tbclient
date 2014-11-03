package com.baidu.tieba.person.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.post.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static String bDA;
    private static com.baidu.adp.widget.a.a bDz;
    public TextView axz;
    public TextView azq;
    private b bDB;
    public LinearLayout bDC;
    public HeadImageView bDD;
    public TextView bDE;
    public TextView bDF;
    private final LinearLayout bDv;
    private final LinearLayout bDw;
    private final ColumnLayout bDx;
    private final ColumnLayout bDy;
    private int bum;
    private final LinearLayout mLayout;

    public a(View view) {
        this.bDC = (LinearLayout) view.findViewById(com.baidu.tieba.v.top_line);
        this.bDD = (HeadImageView) view.findViewById(com.baidu.tieba.v.portrait);
        this.bDE = (TextView) view.findViewById(com.baidu.tieba.v.username);
        this.azq = (TextView) view.findViewById(com.baidu.tieba.v.reply_time);
        this.axz = (TextView) view.findViewById(com.baidu.tieba.v.forum_name);
        this.bDF = (TextView) view.findViewById(com.baidu.tieba.v.reply_count);
        this.bDw = (LinearLayout) view.findViewById(com.baidu.tieba.v.item_content);
        this.bDx = (ColumnLayout) view.findViewById(com.baidu.tieba.v.item_header);
        this.bDy = (ColumnLayout) view.findViewById(com.baidu.tieba.v.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_thread);
        this.bDv = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_child);
        this.bum = com.baidu.adp.lib.util.m.dip2px(view.getContext(), 42.0f);
        if (this.bDw != null) {
            this.bDw.setOnClickListener(this);
        }
        this.bDD.setOnClickListener(this);
        this.bDE.setOnClickListener(this);
        this.azq.setOnClickListener(this);
        this.axz.setOnClickListener(this);
        this.bDF.setOnClickListener(this);
        this.bDx.setOnClickListener(this);
        this.bDy.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.forum_name) {
            if (view.getContext() instanceof BaseActivity) {
                ((BaseActivity) view.getContext()).sendMessage(new CustomMessage(2003000, new FrsActivityConfig(view.getContext()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.bDB != null) {
            this.bDB.X(view);
        }
    }

    public void a(b bVar) {
        this.bDB = bVar;
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
                            String j = az.j(postList.create_time * 1000);
                            String str8 = postList.forum_name;
                            str5 = String.valueOf(postList.reply_num);
                            str4 = str7;
                            str3 = j;
                            str2 = str8;
                            str6 = 1;
                        } else {
                            String str9 = postList.user_name;
                            strArr[0] = String.valueOf(postList.thread_id);
                            strArr[1] = String.valueOf(postList.content[0].post_id);
                            strArr[2] = String.valueOf(postList.content[0].post_type);
                            String j2 = az.j(postList.create_time * 1000);
                            String str10 = postList.forum_name;
                            str5 = String.valueOf(postList.reply_num);
                            str4 = str9;
                            str3 = j2;
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
            this.bDE.setText(str4);
            this.azq.setText(str3);
            this.axz.setText(str2);
            this.axz.setTag(str2);
            this.bDF.setText(str5);
            this.axz.setOnClickListener(this);
            hg(str);
            if (this.bDw != null) {
                this.bDw.setTag(strArr);
            }
            this.bDx.setTag(strArr);
            this.bDy.setTag(strArr);
        }
    }

    private void hg(String str) {
        if (bDA != null && !bDA.equals(str)) {
            bDz = null;
        }
        if (bDz != null) {
            this.bDD.setImageBitmap(bDz.hl());
            bDA = str;
            return;
        }
        this.bDD.a(str, 12, this.bum, this.bum, false);
    }

    public void bM(int i) {
        aw.b(this.axz, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.azq, com.baidu.tieba.s.cp_cont_d, 1);
        aw.b(this.bDE, com.baidu.tieba.s.cp_cont_f, 1);
        aw.h(this.mLayout, com.baidu.tieba.s.cp_bg_line_c);
        aw.h(this.bDv, com.baidu.tieba.u.daily_recommend_item_selector);
        TbadkApplication.m251getInst().getSkinType();
        this.bDF.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        aw.b(this.bDF, com.baidu.tieba.s.cp_link_tip_c, 1);
    }
}
