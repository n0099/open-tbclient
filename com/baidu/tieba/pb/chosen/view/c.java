package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class c {
    private TextView anq;
    private View cYV;
    private View fSW;
    private b fSX;
    private b fSY;
    private b fSZ;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void tb(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(e.h.chosen_pb_comment_layout, (ViewGroup) null);
        this.anq = (TextView) this.rootView.findViewById(e.g.chosen_pb_comment_title);
        this.cYV = this.rootView.findViewById(e.g.chosen_pb_comment_line);
        this.fSW = this.rootView.findViewById(e.g.comment_layout_blank_view);
        this.fSX = new b((ViewStub) this.rootView.findViewById(e.g.chosen_pb_commrnt_first), aVar);
        this.fSY = new b((ViewStub) this.rootView.findViewById(e.g.chosen_pb_commrnt_second), aVar);
        this.fSZ = new b((ViewStub) this.rootView.findViewById(e.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.anq.setVisibility(8);
            this.fSX.ku(false);
            this.fSY.ku(false);
            this.fSZ.ku(false);
            this.cYV.setVisibility(8);
            return;
        }
        this.cYV.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.fSX.a(context, list.get(0), a(list.get(0), list2));
            this.fSY.ku(false);
            this.fSZ.ku(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.fSX.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.fSY.a(context, list.get(1), a(list.get(1), list2));
            this.fSZ.ku(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.fSX.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.fSY.a(context, list.get(1), a(list.get(1), list2));
            z = this.fSZ.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.anq.setVisibility(0);
        } else {
            this.anq.setVisibility(8);
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
        al.i(this.rootView, e.d.common_color_10187);
        al.j(this.fSW, e.d.cp_bg_line_d);
        al.c(this.anq, e.d.cp_cont_f, 1);
        al.j(this.cYV, e.d.cp_bg_line_b);
        this.fSX.onChangeSkinType();
        this.fSY.onChangeSkinType();
        this.fSZ.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
