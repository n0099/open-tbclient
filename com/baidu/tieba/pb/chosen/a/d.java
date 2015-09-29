package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class d {
    private TextView aJS;
    private b cfp;
    private b cfq;
    private b cfr;
    private View cfs;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void jC(String str);
    }

    public d(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(i.g.chosen_pb_comment_layout, (ViewGroup) null);
        this.aJS = (TextView) this.rootView.findViewById(i.f.chosen_pb_comment_title);
        this.cfs = this.rootView.findViewById(i.f.chosen_pb_comment_line);
        this.cfp = new b((ViewStub) this.rootView.findViewById(i.f.chosen_pb_commrnt_first), aVar);
        this.cfq = new b((ViewStub) this.rootView.findViewById(i.f.chosen_pb_commrnt_second), aVar);
        this.cfr = new b((ViewStub) this.rootView.findViewById(i.f.chosen_pb_commrnt_third), aVar);
    }

    public void b(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.aJS.setVisibility(8);
            this.cfp.ek(false);
            this.cfq.ek(false);
            this.cfr.ek(false);
            return;
        }
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.cfp.a(context, list.get(0), a(list.get(0), list2));
            this.cfq.ek(false);
            this.cfr.ek(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.cfp.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.cfq.a(context, list.get(1), a(list.get(1), list2));
            this.cfr.ek(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.cfp.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.cfq.a(context, list.get(1), a(list.get(1), list2));
            z = this.cfr.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.aJS.setVisibility(0);
        } else {
            this.aJS.setVisibility(8);
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

    public void tc() {
        am.i(this.rootView, i.c.recommend_pb_comment_background);
        am.b(this.aJS, i.c.cp_cont_f, 1);
        am.j(this.cfs, i.c.cp_bg_line_b);
        this.cfp.tc();
        this.cfq.tc();
        this.cfr.tc();
    }

    public View getView() {
        return this.rootView;
    }
}
