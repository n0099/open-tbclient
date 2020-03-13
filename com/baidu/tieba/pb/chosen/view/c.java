package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes10.dex */
public class c {
    private TextView cKS;
    private View fKw;
    private View iBa;
    private b iBb;
    private b iBc;
    private b iBd;
    private View rootView;

    /* loaded from: classes10.dex */
    public interface a {
        void FG(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.cKS = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.fKw = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.iBa = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.iBb = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.iBc = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.iBd = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.cKS.setVisibility(8);
            this.iBb.pq(false);
            this.iBc.pq(false);
            this.iBd.pq(false);
            this.fKw.setVisibility(8);
            return;
        }
        this.fKw.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.iBb.a(context, list.get(0), a(list.get(0), list2));
            this.iBc.pq(false);
            this.iBd.pq(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.iBb.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.iBc.a(context, list.get(1), a(list.get(1), list2));
            this.iBd.pq(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.iBb.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.iBc.a(context, list.get(1), a(list.get(1), list2));
            z = this.iBd.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.cKS.setVisibility(0);
        } else {
            this.cKS.setVisibility(8);
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
        am.setBackgroundResource(this.rootView, R.color.common_color_10187);
        am.setBackgroundColor(this.iBa, R.color.cp_bg_line_d);
        am.setViewTextColor(this.cKS, R.color.cp_cont_f, 1);
        am.setBackgroundColor(this.fKw, R.color.cp_bg_line_c);
        this.iBb.onChangeSkinType();
        this.iBc.onChangeSkinType();
        this.iBd.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
