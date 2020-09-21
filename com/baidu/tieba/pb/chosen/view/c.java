package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes22.dex */
public class c {
    private TextView dUN;
    private View hrm;
    private b kEA;
    private View kEx;
    private b kEy;
    private b kEz;
    private View rootView;

    /* loaded from: classes22.dex */
    public interface a {
        void NK(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.dUN = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.hrm = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.kEx = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.kEy = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.kEz = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.kEA = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.dUN.setVisibility(8);
            this.kEy.sH(false);
            this.kEz.sH(false);
            this.kEA.sH(false);
            this.hrm.setVisibility(8);
            return;
        }
        this.hrm.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.kEy.a(context, list.get(0), a(list.get(0), list2));
            this.kEz.sH(false);
            this.kEA.sH(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.kEy.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.kEz.a(context, list.get(1), a(list.get(1), list2));
            this.kEA.sH(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.kEy.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.kEz.a(context, list.get(1), a(list.get(1), list2));
            z = this.kEA.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.dUN.setVisibility(0);
        } else {
            this.dUN.setVisibility(8);
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
        ap.setBackgroundResource(this.rootView, R.color.common_color_10187);
        ap.setBackgroundColor(this.kEx, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dUN, R.color.cp_cont_f, 1);
        ap.setBackgroundColor(this.hrm, R.color.cp_bg_line_c);
        this.kEy.onChangeSkinType();
        this.kEz.onChangeSkinType();
        this.kEA.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
