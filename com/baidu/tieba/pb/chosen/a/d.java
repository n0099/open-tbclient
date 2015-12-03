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
    private TextView aNy;
    private b cyD;
    private b cyE;
    private b cyF;
    private View cyG;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void ku(String str);
    }

    public d(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(n.g.chosen_pb_comment_layout, (ViewGroup) null);
        this.aNy = (TextView) this.rootView.findViewById(n.f.chosen_pb_comment_title);
        this.cyG = this.rootView.findViewById(n.f.chosen_pb_comment_line);
        this.cyD = new b((ViewStub) this.rootView.findViewById(n.f.chosen_pb_commrnt_first), aVar);
        this.cyE = new b((ViewStub) this.rootView.findViewById(n.f.chosen_pb_commrnt_second), aVar);
        this.cyF = new b((ViewStub) this.rootView.findViewById(n.f.chosen_pb_commrnt_third), aVar);
    }

    public void b(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.aNy.setVisibility(8);
            this.cyD.eO(false);
            this.cyE.eO(false);
            this.cyF.eO(false);
            return;
        }
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.cyD.a(context, list.get(0), a(list.get(0), list2));
            this.cyE.eO(false);
            this.cyF.eO(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.cyD.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.cyE.a(context, list.get(1), a(list.get(1), list2));
            this.cyF.eO(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.cyD.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.cyE.a(context, list.get(1), a(list.get(1), list2));
            z = this.cyF.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.aNy.setVisibility(0);
        } else {
            this.aNy.setVisibility(8);
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

    public void tH() {
        as.i(this.rootView, n.c.recommend_pb_comment_background);
        as.b(this.aNy, n.c.cp_cont_f, 1);
        as.j(this.cyG, n.c.cp_bg_line_b);
        this.cyD.tH();
        this.cyE.tH();
        this.cyF.tH();
    }

    public View getView() {
        return this.rootView;
    }
}
