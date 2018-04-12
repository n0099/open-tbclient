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
    private View cpq;
    private View fbh;
    private b fbi;
    private b fbj;
    private b fbk;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void qm(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(d.i.chosen_pb_comment_layout, (ViewGroup) null);
        this.Tm = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_title);
        this.cpq = this.rootView.findViewById(d.g.chosen_pb_comment_line);
        this.fbh = this.rootView.findViewById(d.g.comment_layout_blank_view);
        this.fbi = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_first), aVar);
        this.fbj = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_second), aVar);
        this.fbk = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.Tm.setVisibility(8);
            this.fbi.jk(false);
            this.fbj.jk(false);
            this.fbk.jk(false);
            this.cpq.setVisibility(8);
            return;
        }
        this.cpq.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.fbi.a(context, list.get(0), a(list.get(0), list2));
            this.fbj.jk(false);
            this.fbk.jk(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.fbi.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.fbj.a(context, list.get(1), a(list.get(1), list2));
            this.fbk.jk(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.fbi.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.fbj.a(context, list.get(1), a(list.get(1), list2));
            z = this.fbk.a(context, list.get(2), a(list.get(2), list2));
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
        ak.j(this.fbh, d.C0126d.cp_bg_line_d);
        ak.c(this.Tm, d.C0126d.cp_cont_f, 1);
        ak.j(this.cpq, d.C0126d.cp_bg_line_b);
        this.fbi.onChangeSkinType();
        this.fbj.onChangeSkinType();
        this.fbk.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
