package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class c {
    private TextView aHT;
    private View cXx;
    private View fGm;
    private b fGn;
    private b fGo;
    private b fGp;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void qg(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(d.h.chosen_pb_comment_layout, (ViewGroup) null);
        this.aHT = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_title);
        this.cXx = this.rootView.findViewById(d.g.chosen_pb_comment_line);
        this.fGm = this.rootView.findViewById(d.g.comment_layout_blank_view);
        this.fGn = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_first), aVar);
        this.fGo = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_second), aVar);
        this.fGp = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.aHT.setVisibility(8);
            this.fGn.jJ(false);
            this.fGo.jJ(false);
            this.fGp.jJ(false);
            this.cXx.setVisibility(8);
            return;
        }
        this.cXx.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.fGn.a(context, list.get(0), a(list.get(0), list2));
            this.fGo.jJ(false);
            this.fGp.jJ(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.fGn.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.fGo.a(context, list.get(1), a(list.get(1), list2));
            this.fGp.jJ(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.fGn.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.fGo.a(context, list.get(1), a(list.get(1), list2));
            z = this.fGp.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.aHT.setVisibility(0);
        } else {
            this.aHT.setVisibility(8);
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
        aj.s(this.rootView, d.C0141d.common_color_10187);
        aj.t(this.fGm, d.C0141d.cp_bg_line_d);
        aj.e(this.aHT, d.C0141d.cp_cont_f, 1);
        aj.t(this.cXx, d.C0141d.cp_bg_line_b);
        this.fGn.onChangeSkinType();
        this.fGo.onChangeSkinType();
        this.fGp.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
