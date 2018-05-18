package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class c {
    private TextView Ti;
    private View cqx;
    private View fcl;
    private b fcm;
    private b fcn;
    private b fco;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void qp(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(d.i.chosen_pb_comment_layout, (ViewGroup) null);
        this.Ti = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_title);
        this.cqx = this.rootView.findViewById(d.g.chosen_pb_comment_line);
        this.fcl = this.rootView.findViewById(d.g.comment_layout_blank_view);
        this.fcm = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_first), aVar);
        this.fcn = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_second), aVar);
        this.fco = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.Ti.setVisibility(8);
            this.fcm.jl(false);
            this.fcn.jl(false);
            this.fco.jl(false);
            this.cqx.setVisibility(8);
            return;
        }
        this.cqx.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.fcm.a(context, list.get(0), a(list.get(0), list2));
            this.fcn.jl(false);
            this.fco.jl(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.fcm.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.fcn.a(context, list.get(1), a(list.get(1), list2));
            this.fco.jl(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.fcm.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.fcn.a(context, list.get(1), a(list.get(1), list2));
            z = this.fco.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.Ti.setVisibility(0);
        } else {
            this.Ti.setVisibility(8);
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
        ak.i(this.rootView, d.C0126d.common_color_10187);
        ak.j(this.fcl, d.C0126d.cp_bg_line_d);
        ak.c(this.Ti, d.C0126d.cp_cont_f, 1);
        ak.j(this.cqx, d.C0126d.cp_bg_line_b);
        this.fcm.onChangeSkinType();
        this.fcn.onChangeSkinType();
        this.fco.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
