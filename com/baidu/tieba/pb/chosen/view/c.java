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
/* loaded from: classes3.dex */
public class c {
    private TextView abq;
    private View cza;
    private View fnG;
    private b fnH;
    private b fnI;
    private b fnJ;
    private View rootView;

    /* loaded from: classes3.dex */
    public interface a {
        void rd(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(d.i.chosen_pb_comment_layout, (ViewGroup) null);
        this.abq = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_title);
        this.cza = this.rootView.findViewById(d.g.chosen_pb_comment_line);
        this.fnG = this.rootView.findViewById(d.g.comment_layout_blank_view);
        this.fnH = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_first), aVar);
        this.fnI = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_second), aVar);
        this.fnJ = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.abq.setVisibility(8);
            this.fnH.jr(false);
            this.fnI.jr(false);
            this.fnJ.jr(false);
            this.cza.setVisibility(8);
            return;
        }
        this.cza.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.fnH.a(context, list.get(0), a(list.get(0), list2));
            this.fnI.jr(false);
            this.fnJ.jr(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.fnH.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.fnI.a(context, list.get(1), a(list.get(1), list2));
            this.fnJ.jr(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.fnH.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.fnI.a(context, list.get(1), a(list.get(1), list2));
            z = this.fnJ.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.abq.setVisibility(0);
        } else {
            this.abq.setVisibility(8);
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
        al.i(this.rootView, d.C0141d.common_color_10187);
        al.j(this.fnG, d.C0141d.cp_bg_line_d);
        al.c(this.abq, d.C0141d.cp_cont_f, 1);
        al.j(this.cza, d.C0141d.cp_bg_line_b);
        this.fnH.onChangeSkinType();
        this.fnI.onChangeSkinType();
        this.fnJ.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
