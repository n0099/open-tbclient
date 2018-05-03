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
    private TextView Tm;
    private View cpn;
    private View fbe;
    private b fbf;
    private b fbg;
    private b fbh;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void qm(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(d.i.chosen_pb_comment_layout, (ViewGroup) null);
        this.Tm = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_title);
        this.cpn = this.rootView.findViewById(d.g.chosen_pb_comment_line);
        this.fbe = this.rootView.findViewById(d.g.comment_layout_blank_view);
        this.fbf = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_first), aVar);
        this.fbg = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_second), aVar);
        this.fbh = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.Tm.setVisibility(8);
            this.fbf.jk(false);
            this.fbg.jk(false);
            this.fbh.jk(false);
            this.cpn.setVisibility(8);
            return;
        }
        this.cpn.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.fbf.a(context, list.get(0), a(list.get(0), list2));
            this.fbg.jk(false);
            this.fbh.jk(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.fbf.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.fbg.a(context, list.get(1), a(list.get(1), list2));
            this.fbh.jk(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.fbf.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.fbg.a(context, list.get(1), a(list.get(1), list2));
            z = this.fbh.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.Tm.setVisibility(0);
        } else {
            this.Tm.setVisibility(8);
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
        ak.j(this.fbe, d.C0126d.cp_bg_line_d);
        ak.c(this.Tm, d.C0126d.cp_cont_f, 1);
        ak.j(this.cpn, d.C0126d.cp_bg_line_b);
        this.fbf.onChangeSkinType();
        this.fbg.onChangeSkinType();
        this.fbh.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
