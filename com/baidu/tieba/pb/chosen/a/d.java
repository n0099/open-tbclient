package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class d {
    private TextView aLa;
    private b cak;
    private b cal;
    private b cam;
    private View can;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void jk(String str);
    }

    public d(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(i.g.chosen_pb_comment_layout, (ViewGroup) null);
        this.aLa = (TextView) this.rootView.findViewById(i.f.chosen_pb_comment_title);
        this.can = this.rootView.findViewById(i.f.chosen_pb_comment_line);
        this.cak = new b((ViewStub) this.rootView.findViewById(i.f.chosen_pb_commrnt_first), aVar);
        this.cal = new b((ViewStub) this.rootView.findViewById(i.f.chosen_pb_commrnt_second), aVar);
        this.cam = new b((ViewStub) this.rootView.findViewById(i.f.chosen_pb_commrnt_third), aVar);
    }

    public void b(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.aLa.setVisibility(8);
            this.cak.ef(false);
            this.cal.ef(false);
            this.cam.ef(false);
            return;
        }
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.cak.a(context, list.get(0), a(list.get(0), list2));
            this.cal.ef(false);
            this.cam.ef(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.cak.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.cal.a(context, list.get(1), a(list.get(1), list2));
            this.cam.ef(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.cak.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.cal.a(context, list.get(1), a(list.get(1), list2));
            z = this.cam.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.aLa.setVisibility(0);
        } else {
            this.aLa.setVisibility(8);
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

    public void tf() {
        al.h(this.rootView, i.c.recommend_pb_comment_background);
        al.b(this.aLa, i.c.cp_cont_f, 1);
        al.i(this.can, i.c.cp_bg_line_b);
        this.cak.tf();
        this.cal.tf();
        this.cam.tf();
    }

    public View getView() {
        return this.rootView;
    }
}
