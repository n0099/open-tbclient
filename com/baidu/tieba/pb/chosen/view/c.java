package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class c {
    private TextView aaW;
    private View czx;
    private View frM;
    private b frN;
    private b frO;
    private b frP;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void qV(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(d.h.chosen_pb_comment_layout, (ViewGroup) null);
        this.aaW = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_title);
        this.czx = this.rootView.findViewById(d.g.chosen_pb_comment_line);
        this.frM = this.rootView.findViewById(d.g.comment_layout_blank_view);
        this.frN = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_first), aVar);
        this.frO = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_second), aVar);
        this.frP = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.aaW.setVisibility(8);
            this.frN.jm(false);
            this.frO.jm(false);
            this.frP.jm(false);
            this.czx.setVisibility(8);
            return;
        }
        this.czx.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.frN.a(context, list.get(0), a(list.get(0), list2));
            this.frO.jm(false);
            this.frP.jm(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.frN.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.frO.a(context, list.get(1), a(list.get(1), list2));
            this.frP.jm(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.frN.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.frO.a(context, list.get(1), a(list.get(1), list2));
            z = this.frP.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.aaW.setVisibility(0);
        } else {
            this.aaW.setVisibility(8);
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
        am.i(this.rootView, d.C0140d.common_color_10187);
        am.j(this.frM, d.C0140d.cp_bg_line_d);
        am.c(this.aaW, d.C0140d.cp_cont_f, 1);
        am.j(this.czx, d.C0140d.cp_bg_line_b);
        this.frN.onChangeSkinType();
        this.frO.onChangeSkinType();
        this.frP.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
