package com.baidu.tieba.person.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.post.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a l;
    private static String m;
    public LinearLayout a;
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    private final LinearLayout g;
    private final LinearLayout h;
    private final LinearLayout i;
    private final ColumnLayout j;
    private final ColumnLayout k;
    private b n;
    private int o;

    public a(View view) {
        this.a = (LinearLayout) view.findViewById(com.baidu.tieba.v.top_line);
        this.b = (HeadImageView) view.findViewById(com.baidu.tieba.v.portrait);
        this.c = (TextView) view.findViewById(com.baidu.tieba.v.username);
        this.d = (TextView) view.findViewById(com.baidu.tieba.v.reply_time);
        this.e = (TextView) view.findViewById(com.baidu.tieba.v.forum_name);
        this.f = (TextView) view.findViewById(com.baidu.tieba.v.reply_count);
        this.i = (LinearLayout) view.findViewById(com.baidu.tieba.v.item_content);
        this.j = (ColumnLayout) view.findViewById(com.baidu.tieba.v.item_header);
        this.k = (ColumnLayout) view.findViewById(com.baidu.tieba.v.item_footer);
        this.g = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_thread);
        this.h = (LinearLayout) view.findViewById(com.baidu.tieba.v.person_child);
        this.o = com.baidu.adp.lib.util.j.a(view.getContext(), 42.0f);
        if (this.i != null) {
            this.i.setOnClickListener(this);
        }
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.forum_name) {
            if (view.getContext() instanceof BaseActivity) {
                ((BaseActivity) view.getContext()).sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.r(view.getContext()).a((String) view.getTag(), "")));
            }
        } else if (this.n != null) {
            this.n.a(view);
        }
    }

    public void a(b bVar) {
        this.n = bVar;
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
                            String a = bm.a(postList.create_time * 1000);
                            String str8 = postList.forum_name;
                            str5 = String.valueOf(postList.reply_num);
                            str4 = str7;
                            str3 = a;
                            str2 = str8;
                            str6 = 1;
                        } else {
                            String str9 = postList.user_name;
                            strArr[0] = String.valueOf(postList.thread_id);
                            strArr[1] = String.valueOf(postList.content[0].post_id);
                            strArr[2] = String.valueOf(postList.content[0].post_type);
                            String a2 = bm.a(postList.create_time * 1000);
                            String str10 = postList.forum_name;
                            str5 = String.valueOf(postList.reply_num);
                            str4 = str9;
                            str3 = a2;
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
            this.c.setText(str4);
            this.d.setText(str3);
            this.e.setText(str2);
            this.e.setTag(str2);
            this.f.setText(str5);
            this.e.setOnClickListener(this);
            a(str);
            if (this.i != null) {
                this.i.setTag(strArr);
            }
            this.j.setTag(strArr);
            this.k.setTag(strArr);
        }
    }

    private void a(String str) {
        if (m != null && !m.equals(str)) {
            l = null;
        }
        if (l != null) {
            this.b.setImageBitmap(l.h());
            m = str;
            return;
        }
        this.b.a(str, 12, this.o, this.o, false);
    }

    public void a(int i) {
        bk.a(this.e, com.baidu.tieba.s.cp_cont_d, 1);
        bk.a(this.d, com.baidu.tieba.s.cp_cont_d, 1);
        bk.a(this.c, com.baidu.tieba.s.cp_cont_f, 1);
        bk.f(this.g, com.baidu.tieba.s.cp_bg_line_c);
        bk.f(this.h, com.baidu.tieba.u.daily_recommend_item_selector);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.f.setCompoundDrawablesWithIntrinsicBounds(this.f.getResources().getDrawable(com.baidu.tieba.u.icon_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f.setTextColor(this.f.getResources().getColor(com.baidu.tieba.s.cp_link_tip_c_1));
            return;
        }
        this.f.setCompoundDrawablesWithIntrinsicBounds(this.f.getResources().getDrawable(com.baidu.tieba.u.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f.setTextColor(this.f.getResources().getColor(com.baidu.tieba.s.cp_link_tip_c));
    }
}
