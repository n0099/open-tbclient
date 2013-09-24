package com.baidu.tieba.person.post;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.person.post.PersonPostReplyModel;
import com.baidu.tieba.person.post.PersonPostThreadModel;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.as;
import com.baidu.tieba.util.at;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.c j;
    private static String k;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f1711a;
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    private final LinearLayout g;
    private final RelativeLayout h;
    private final RelativeLayout i;
    private c l;
    private com.baidu.tieba.util.a m;

    public a(View view) {
        this.f1711a = (LinearLayout) view.findViewById(R.id.top_line);
        this.b = (HeadImageView) view.findViewById(R.id.portrait);
        this.c = (TextView) view.findViewById(R.id.username);
        this.d = (TextView) view.findViewById(R.id.reply_time);
        this.e = (TextView) view.findViewById(R.id.forum_name);
        this.f = (TextView) view.findViewById(R.id.reply_count);
        this.g = (LinearLayout) view.findViewById(R.id.item_content);
        this.h = (RelativeLayout) view.findViewById(R.id.item_header);
        this.i = (RelativeLayout) view.findViewById(R.id.item_footer);
        this.m = new com.baidu.tieba.util.a(view.getContext());
        int a2 = UtilHelper.a(view.getContext(), 42.0f);
        this.m.a(a2, a2);
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
            case R.id.forum_name /* 2131100652 */:
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

    public void a(c cVar) {
        this.l = cVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00c5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x000a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x004e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x004e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0050 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e  */
    /* JADX WARN: Type inference failed for: r0v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Object obj, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        String[] strArr = new String[3];
        try {
            str2 = obj instanceof PersonPostReplyModel.Post;
        } catch (Exception e) {
            str2 = str6;
            str3 = str6;
            str4 = str6;
        }
        try {
            try {
                try {
                } catch (Exception e2) {
                    str2 = str6;
                    str3 = str6;
                    str5 = str4;
                    str4 = str3;
                    str3 = str2;
                    str2 = 0;
                    if (str2 != 0) {
                    }
                }
            } catch (Exception e3) {
                str5 = str4;
                str4 = str3;
                str3 = str2;
                str2 = 0;
                if (str2 != 0) {
                }
            }
        } catch (Exception e4) {
            str2 = str6;
            str5 = str4;
            str4 = str3;
            str3 = str2;
            str2 = 0;
            if (str2 != 0) {
            }
        }
        if (str2 != 0) {
            PersonPostReplyModel.Post post = (PersonPostReplyModel.Post) obj;
            String str7 = post.user_name;
            strArr[0] = String.valueOf(post.thread_id);
            strArr[1] = String.valueOf(post.content[0].post_id);
            strArr[2] = String.valueOf(post.content[0].post_type);
            String g = at.g(new Date(post.create_time * 1000));
            String str8 = post.forum_name;
            str6 = String.valueOf(post.reply_num);
            str5 = str7;
            str4 = g;
            str3 = str8;
            str2 = 1;
        } else if (obj instanceof PersonPostThreadModel.PostList) {
            PersonPostThreadModel.PostList postList = (PersonPostThreadModel.PostList) obj;
            String str9 = postList.user_name;
            strArr[0] = String.valueOf(postList.thread_id);
            strArr[1] = String.valueOf(postList.post_id);
            String g2 = at.g(new Date(postList.create_time * 1000));
            String str10 = postList.forum_name;
            str6 = String.valueOf(postList.reply_num);
            str5 = str9;
            str4 = g2;
            str3 = str10;
            str2 = 1;
        } else {
            str2 = 0;
            str3 = null;
            str4 = null;
            str5 = null;
            if (str2 != 0) {
                this.c.setText(str5);
                this.d.setText(str4);
                this.e.setText(str3);
                this.e.setTag(str3);
                this.f.setText(str6);
                this.e.setOnClickListener(this);
                b(str);
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

    private void b(String str) {
        if (k != null && !k.equals(str)) {
            j = null;
        }
        if (j == null) {
            j = this.m.c(str);
        }
        if (j != null) {
            this.b.setImageBitmap(j.f());
            k = str;
            return;
        }
        this.m.b(str, new b(this, str));
    }

    public void a(int i) {
        as.c(this.e, i);
        as.c(this.d, i);
        if (TiebaApplication.g().ap() == 1) {
            a(this.h, R.drawable.bg_list_top_1);
            a(this.g, R.drawable.bg_list_border_1);
            a(this.i, R.drawable.bg_list_bottom_1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.e.getResources().getDrawable(R.drawable.person_post_ba_n_1);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.e.setCompoundDrawables(bitmapDrawable, null, null, null);
            this.f.setCompoundDrawablesWithIntrinsicBounds(this.f.getResources().getDrawable(R.drawable.person_post_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.e.setTextColor(this.e.getResources().getColor(R.color.person_post_header_forumname_1));
            this.c.setTextColor(this.c.getResources().getColor(R.color.person_post_header_uname_1));
            this.f.setTextColor(this.f.getResources().getColor(R.color.home_reply_num_txt_1));
            return;
        }
        a(this.h, R.drawable.bg_list_top);
        a(this.g, R.drawable.bg_list_border);
        a(this.i, R.drawable.bg_list_bottom);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.e.getResources().getDrawable(R.drawable.person_post_ba_n);
        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
        this.e.setCompoundDrawables(bitmapDrawable2, null, null, null);
        this.f.setCompoundDrawablesWithIntrinsicBounds(this.f.getResources().getDrawable(R.drawable.person_post_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        this.e.setTextColor(this.e.getResources().getColor(R.color.person_post_header_forumname));
        this.c.setTextColor(this.c.getResources().getColor(R.color.person_post_header_uname));
        this.f.setTextColor(this.f.getResources().getColor(R.color.home_reply_num_txt));
    }

    private void a(View view, int i) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundResource(i);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
