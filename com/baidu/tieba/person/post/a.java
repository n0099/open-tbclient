package com.baidu.tieba.person.post;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.person.post.PersonPostReplyModel;
import com.baidu.tieba.person.post.PersonPostThreadModel;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.b j;
    private static String k;
    public LinearLayout a;
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    private final LinearLayout g;
    private final ColumnLayout h;
    private final ColumnLayout i;
    private c l;
    private com.baidu.tieba.util.i m;

    public a(View view) {
        this.a = (LinearLayout) view.findViewById(R.id.top_line);
        this.b = (HeadImageView) view.findViewById(R.id.portrait);
        this.c = (TextView) view.findViewById(R.id.username);
        this.d = (TextView) view.findViewById(R.id.reply_time);
        this.e = (TextView) view.findViewById(R.id.forum_name);
        this.f = (TextView) view.findViewById(R.id.reply_count);
        this.g = (LinearLayout) view.findViewById(R.id.item_content);
        this.h = (ColumnLayout) view.findViewById(R.id.item_header);
        this.i = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.m = new com.baidu.tieba.util.i(view.getContext());
        int a = BdUtilHelper.a(view.getContext(), 42.0f);
        this.m.a(a, a);
        if (this.g != null) {
            this.g.setOnClickListener(this);
        }
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.h.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forum_name /* 2131101342 */:
                FrsActivity.a(view.getContext(), (String) view.getTag(), "");
                return;
            default:
                if (this.l != null) {
                    this.l.a(view);
                    return;
                }
                return;
        }
    }

    public final void a(c cVar) {
        this.l = cVar;
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
            String a = bs.a(post.create_time * 1000);
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
            String a2 = bs.a(postList.create_time * 1000);
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
                if (k != null && !k.equals(str)) {
                    j = null;
                }
                if (j != null) {
                    this.b.setImageBitmap(j.h());
                    k = str;
                } else {
                    this.m.c(str, new b(this, str));
                }
                if (this.g != null) {
                    this.g.setTag(strArr);
                }
                this.h.setTag(strArr);
                return;
            }
            return;
        }
        if (str2 != 0) {
        }
    }

    public void a(int i) {
        bq.c(this.e, i);
        bq.c(this.d, i);
        if (TiebaApplication.g().ae() == 1) {
            a(this.h, (int) R.drawable.bg_list_top_1);
            a(this.g, (int) R.drawable.bg_list_border_1);
            a(this.i, (int) R.drawable.bg_list_bottom_1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.e.getResources().getDrawable(R.drawable.person_post_ba_n_1);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.e.setCompoundDrawables(bitmapDrawable, null, null, null);
            this.f.setCompoundDrawablesWithIntrinsicBounds(this.f.getResources().getDrawable(R.drawable.person_post_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.e.setTextColor(this.e.getResources().getColor(R.color.person_post_header_forumname_1));
            this.c.setTextColor(this.c.getResources().getColor(R.color.person_post_header_uname_1));
            this.f.setTextColor(this.f.getResources().getColor(R.color.home_reply_num_txt_1));
            return;
        }
        a(this.h, (int) R.drawable.bg_list_top);
        a(this.g, (int) R.drawable.bg_list_border);
        a(this.i, (int) R.drawable.bg_list_bottom);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.e.getResources().getDrawable(R.drawable.person_post_ba_n);
        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
        this.e.setCompoundDrawables(bitmapDrawable2, null, null, null);
        this.f.setCompoundDrawablesWithIntrinsicBounds(this.f.getResources().getDrawable(R.drawable.person_post_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        this.e.setTextColor(this.e.getResources().getColor(R.color.person_post_header_forumname));
        this.c.setTextColor(this.c.getResources().getColor(R.color.person_post_header_uname));
        this.f.setTextColor(this.f.getResources().getColor(R.color.home_reply_num_txt));
    }

    private static void a(View view, int i) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundResource(i);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
