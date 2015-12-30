package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class d {
    private TextView aOS;
    private View aPe;
    private b cCk;
    private b cCl;
    private b cCm;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void kq(String str);
    }

    public d(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(n.h.chosen_pb_comment_layout, (ViewGroup) null);
        this.aOS = (TextView) this.rootView.findViewById(n.g.chosen_pb_comment_title);
        this.aPe = this.rootView.findViewById(n.g.chosen_pb_comment_line);
        this.cCk = new b((ViewStub) this.rootView.findViewById(n.g.chosen_pb_commrnt_first), aVar);
        this.cCl = new b((ViewStub) this.rootView.findViewById(n.g.chosen_pb_commrnt_second), aVar);
        this.cCm = new b((ViewStub) this.rootView.findViewById(n.g.chosen_pb_commrnt_third), aVar);
    }

    public void b(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.aOS.setVisibility(8);
            this.cCk.eN(false);
            this.cCl.eN(false);
            this.cCm.eN(false);
            return;
        }
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.cCk.a(context, list.get(0), a(list.get(0), list2));
            this.cCl.eN(false);
            this.cCm.eN(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.cCk.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.cCl.a(context, list.get(1), a(list.get(1), list2));
            this.cCm.eN(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.cCk.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.cCl.a(context, list.get(1), a(list.get(1), list2));
            z = this.cCm.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.aOS.setVisibility(0);
        } else {
            this.aOS.setVisibility(8);
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

    public void tr() {
        as.i(this.rootView, n.d.recommend_pb_comment_background);
        as.b(this.aOS, n.d.cp_cont_f, 1);
        as.j(this.aPe, n.d.cp_bg_line_b);
        this.cCk.tr();
        this.cCl.tr();
        this.cCm.tr();
    }

    public View getView() {
        return this.rootView;
    }
}
