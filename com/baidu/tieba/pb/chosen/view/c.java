package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes5.dex */
public class c {
    private TextView btZ;
    private View eiI;
    private View hjj;
    private b hjk;
    private b hjl;
    private b hjm;
    private View rootView;

    /* loaded from: classes5.dex */
    public interface a {
        void zD(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(d.h.chosen_pb_comment_layout, (ViewGroup) null);
        this.btZ = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_title);
        this.eiI = this.rootView.findViewById(d.g.chosen_pb_comment_line);
        this.hjj = this.rootView.findViewById(d.g.comment_layout_blank_view);
        this.hjk = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_first), aVar);
        this.hjl = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_second), aVar);
        this.hjm = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.btZ.setVisibility(8);
            this.hjk.mV(false);
            this.hjl.mV(false);
            this.hjm.mV(false);
            this.eiI.setVisibility(8);
            return;
        }
        this.eiI.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.hjk.a(context, list.get(0), a(list.get(0), list2));
            this.hjl.mV(false);
            this.hjm.mV(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.hjk.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.hjl.a(context, list.get(1), a(list.get(1), list2));
            this.hjm.mV(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.hjk.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.hjl.a(context, list.get(1), a(list.get(1), list2));
            z = this.hjm.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.btZ.setVisibility(0);
        } else {
            this.btZ.setVisibility(8);
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
        al.k(this.rootView, d.C0277d.common_color_10187);
        al.l(this.hjj, d.C0277d.cp_bg_line_d);
        al.d(this.btZ, d.C0277d.cp_cont_f, 1);
        al.l(this.eiI, d.C0277d.cp_bg_line_b);
        this.hjk.onChangeSkinType();
        this.hjl.onChangeSkinType();
        this.hjm.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
