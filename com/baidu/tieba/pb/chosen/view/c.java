package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class c {
    private TextView aaX;
    private View czu;
    private View frF;
    private b frG;
    private b frH;
    private b frI;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void qY(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(f.h.chosen_pb_comment_layout, (ViewGroup) null);
        this.aaX = (TextView) this.rootView.findViewById(f.g.chosen_pb_comment_title);
        this.czu = this.rootView.findViewById(f.g.chosen_pb_comment_line);
        this.frF = this.rootView.findViewById(f.g.comment_layout_blank_view);
        this.frG = new b((ViewStub) this.rootView.findViewById(f.g.chosen_pb_commrnt_first), aVar);
        this.frH = new b((ViewStub) this.rootView.findViewById(f.g.chosen_pb_commrnt_second), aVar);
        this.frI = new b((ViewStub) this.rootView.findViewById(f.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.aaX.setVisibility(8);
            this.frG.jm(false);
            this.frH.jm(false);
            this.frI.jm(false);
            this.czu.setVisibility(8);
            return;
        }
        this.czu.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.frG.a(context, list.get(0), a(list.get(0), list2));
            this.frH.jm(false);
            this.frI.jm(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.frG.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.frH.a(context, list.get(1), a(list.get(1), list2));
            this.frI.jm(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.frG.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.frH.a(context, list.get(1), a(list.get(1), list2));
            z = this.frI.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.aaX.setVisibility(0);
        } else {
            this.aaX.setVisibility(8);
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
        am.i(this.rootView, f.d.common_color_10187);
        am.j(this.frF, f.d.cp_bg_line_d);
        am.c(this.aaX, f.d.cp_cont_f, 1);
        am.j(this.czu, f.d.cp_bg_line_b);
        this.frG.onChangeSkinType();
        this.frH.onChangeSkinType();
        this.frI.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
