package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes17.dex */
public class c {
    private TextView dJr;
    private View gXm;
    private View kgw;
    private b kgx;
    private b kgy;
    private b kgz;
    private View rootView;

    /* loaded from: classes17.dex */
    public interface a {
        void Ko(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.dJr = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.gXm = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.kgw = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.kgx = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.kgy = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.kgz = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.dJr.setVisibility(8);
            this.kgx.rQ(false);
            this.kgy.rQ(false);
            this.kgz.rQ(false);
            this.gXm.setVisibility(8);
            return;
        }
        this.gXm.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.kgx.a(context, list.get(0), a(list.get(0), list2));
            this.kgy.rQ(false);
            this.kgz.rQ(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.kgx.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.kgy.a(context, list.get(1), a(list.get(1), list2));
            this.kgz.rQ(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.kgx.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.kgy.a(context, list.get(1), a(list.get(1), list2));
            z = this.kgz.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.dJr.setVisibility(0);
        } else {
            this.dJr.setVisibility(8);
        }
    }

    private User a(Post post, List<User> list) {
        if (post == null || list == null || list.isEmpty()) {
            return null;
        }
        if (post.author_id == null) {
            return null;
        }
        long longValue = post.author_id.longValue();
        for (User user : list) {
            if (user != null && user.id != null && user.id.longValue() == longValue) {
                return user;
            }
        }
        return null;
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.rootView, R.color.common_color_10187);
        ao.setBackgroundColor(this.kgw, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.dJr, R.color.cp_cont_f, 1);
        ao.setBackgroundColor(this.gXm, R.color.cp_bg_line_c);
        this.kgx.onChangeSkinType();
        this.kgy.onChangeSkinType();
        this.kgz.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
