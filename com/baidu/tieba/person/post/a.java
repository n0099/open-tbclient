package com.baidu.tieba.person.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.post.PersonPostReplyModel;
import com.baidu.tieba.person.post.PersonPostThreadModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.b k;
    private static String l;
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
    private c m;
    private final com.baidu.tbadk.editortool.aa n;

    public a(View view) {
        this.a = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.top_line);
        this.b = (HeadImageView) view.findViewById(com.baidu.tieba.a.h.portrait);
        this.c = (TextView) view.findViewById(com.baidu.tieba.a.h.username);
        this.d = (TextView) view.findViewById(com.baidu.tieba.a.h.reply_time);
        this.e = (TextView) view.findViewById(com.baidu.tieba.a.h.forum_name);
        this.f = (TextView) view.findViewById(com.baidu.tieba.a.h.reply_count);
        this.i = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.item_content);
        this.j = (ColumnLayout) view.findViewById(com.baidu.tieba.a.h.item_header);
        this.g = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.person_thread);
        this.h = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.person_child);
        this.n = new com.baidu.tbadk.editortool.aa(view.getContext());
        int a = com.baidu.adp.lib.util.i.a(view.getContext(), 42.0f);
        this.n.a(a, a);
        if (this.i != null) {
            this.i.setOnClickListener(this);
        }
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.a.h.forum_name) {
            if (view.getContext() instanceof com.baidu.tbadk.a) {
                ((com.baidu.tbadk.a) view.getContext()).sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(view.getContext()).a((String) view.getTag(), "")));
            }
        } else if (this.m != null) {
            this.m.a(view);
        }
    }

    public final void a(c cVar) {
        this.m = cVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x00e7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x004a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x000a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x004a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Type inference failed for: r0v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Object obj, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        String[] strArr = new String[3];
        try {
            str2 = obj instanceof PersonPostReplyModel.Post;
        } catch (Exception e) {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        try {
            try {
                try {
                } catch (Exception e2) {
                    str2 = 0;
                    str3 = null;
                    str5 = str3;
                    str3 = null;
                    String str7 = str2;
                    str2 = str6;
                    str6 = str4;
                    str4 = str7;
                    if (str2 != 0) {
                    }
                }
            } catch (Exception e3) {
                str5 = str3;
                str3 = null;
                String str72 = str2;
                str2 = str6;
                str6 = str4;
                str4 = str72;
                if (str2 != 0) {
                }
            }
        } catch (Exception e4) {
            str2 = null;
            str5 = str3;
            str3 = null;
            String str722 = str2;
            str2 = str6;
            str6 = str4;
            str4 = str722;
            if (str2 != 0) {
            }
        }
        if (str2 != 0) {
            PersonPostReplyModel.Post post = (PersonPostReplyModel.Post) obj;
            String str8 = post.user_name;
            strArr[0] = String.valueOf(post.thread_id);
            strArr[1] = String.valueOf(post.content[0].post_id);
            strArr[2] = String.valueOf(post.content[0].post_type);
            String a = bc.a(post.create_time * 1000);
            String str9 = post.forum_name;
            str5 = a;
            str3 = String.valueOf(post.reply_num);
            str6 = str8;
            str4 = str9;
            str2 = 1;
        } else if (obj instanceof PersonPostThreadModel.PostList) {
            PersonPostThreadModel.PostList postList = (PersonPostThreadModel.PostList) obj;
            String str10 = postList.user_name;
            strArr[0] = String.valueOf(postList.thread_id);
            strArr[1] = String.valueOf(postList.post_id);
            String a2 = bc.a(postList.create_time * 1000);
            String str11 = postList.forum_name;
            str5 = a2;
            str3 = String.valueOf(postList.reply_num);
            str6 = str10;
            str4 = str11;
            str2 = 1;
        } else {
            str2 = 0;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            if (str2 != 0) {
                this.c.setText(str6);
                this.d.setText(str5);
                this.e.setText(str4);
                this.e.setTag(str4);
                this.f.setText(str3);
                this.e.setOnClickListener(this);
                if (l != null && !l.equals(str)) {
                    k = null;
                }
                if (k != null) {
                    this.b.setImageBitmap(k.h());
                    l = str;
                } else {
                    this.n.c(str, new b(this, str));
                }
                if (this.i != null) {
                    this.i.setTag(strArr);
                }
                this.j.setTag(strArr);
                return;
            }
            return;
        }
        if (str2 != 0) {
        }
    }

    public void a(int i) {
        ba.a(this.e, com.baidu.tieba.a.e.cp_cont_d, 1);
        ba.a(this.d, com.baidu.tieba.a.e.cp_cont_d, 1);
        ba.a(this.c, com.baidu.tieba.a.e.cp_cont_f, 1);
        ba.f(this.g, com.baidu.tieba.a.e.cp_bg_line_c);
        ba.f(this.h, com.baidu.tieba.a.g.daily_recommend_item_selector);
        if (TbadkApplication.j().l() == 1) {
            this.f.setCompoundDrawablesWithIntrinsicBounds(this.f.getResources().getDrawable(com.baidu.tieba.a.g.icon_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f.setTextColor(this.f.getResources().getColor(com.baidu.tieba.a.e.cp_link_tip_c_1));
            return;
        }
        this.f.setCompoundDrawablesWithIntrinsicBounds(this.f.getResources().getDrawable(com.baidu.tieba.a.g.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f.setTextColor(this.f.getResources().getColor(com.baidu.tieba.a.e.cp_link_tip_c));
    }
}
