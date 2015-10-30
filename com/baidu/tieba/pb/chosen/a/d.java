package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class d {
    private TextView aKd;
    private b cfA;
    private b cfB;
    private b cfC;
    private View cfD;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void jC(String str);
    }

    public d(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(i.g.chosen_pb_comment_layout, (ViewGroup) null);
        this.aKd = (TextView) this.rootView.findViewById(i.f.chosen_pb_comment_title);
        this.cfD = this.rootView.findViewById(i.f.chosen_pb_comment_line);
        this.cfA = new b((ViewStub) this.rootView.findViewById(i.f.chosen_pb_commrnt_first), aVar);
        this.cfB = new b((ViewStub) this.rootView.findViewById(i.f.chosen_pb_commrnt_second), aVar);
        this.cfC = new b((ViewStub) this.rootView.findViewById(i.f.chosen_pb_commrnt_third), aVar);
    }

    public void b(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.aKd.setVisibility(8);
            this.cfA.ek(false);
            this.cfB.ek(false);
            this.cfC.ek(false);
            return;
        }
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.cfA.a(context, list.get(0), a(list.get(0), list2));
            this.cfB.ek(false);
            this.cfC.ek(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.cfA.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.cfB.a(context, list.get(1), a(list.get(1), list2));
            this.cfC.ek(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.cfA.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.cfB.a(context, list.get(1), a(list.get(1), list2));
            z = this.cfC.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.aKd.setVisibility(0);
        } else {
            this.aKd.setVisibility(8);
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

    public void sZ() {
        an.i(this.rootView, i.c.recommend_pb_comment_background);
        an.b(this.aKd, i.c.cp_cont_f, 1);
        an.j(this.cfD, i.c.cp_bg_line_b);
        this.cfA.sZ();
        this.cfB.sZ();
        this.cfC.sZ();
    }

    public View getView() {
        return this.rootView;
    }
}
