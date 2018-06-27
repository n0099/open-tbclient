package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class c {
    private TextView abu;
    private View cwU;
    private View frA;
    private b frB;
    private b frC;
    private b frD;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void rc(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(d.i.chosen_pb_comment_layout, (ViewGroup) null);
        this.abu = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_title);
        this.cwU = this.rootView.findViewById(d.g.chosen_pb_comment_line);
        this.frA = this.rootView.findViewById(d.g.comment_layout_blank_view);
        this.frB = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_first), aVar);
        this.frC = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_second), aVar);
        this.frD = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.abu.setVisibility(8);
            this.frB.jA(false);
            this.frC.jA(false);
            this.frD.jA(false);
            this.cwU.setVisibility(8);
            return;
        }
        this.cwU.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.frB.a(context, list.get(0), a(list.get(0), list2));
            this.frC.jA(false);
            this.frD.jA(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.frB.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.frC.a(context, list.get(1), a(list.get(1), list2));
            this.frD.jA(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.frB.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.frC.a(context, list.get(1), a(list.get(1), list2));
            z = this.frD.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.abu.setVisibility(0);
        } else {
            this.abu.setVisibility(8);
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
        am.i(this.rootView, d.C0142d.common_color_10187);
        am.j(this.frA, d.C0142d.cp_bg_line_d);
        am.c(this.abu, d.C0142d.cp_cont_f, 1);
        am.j(this.cwU, d.C0142d.cp_bg_line_b);
        this.frB.onChangeSkinType();
        this.frC.onChangeSkinType();
        this.frD.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
