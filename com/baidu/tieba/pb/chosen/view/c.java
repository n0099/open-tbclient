package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes23.dex */
public class c {
    private TextView egP;
    private View hGg;
    private View kTI;
    private b kTJ;
    private b kTK;
    private b kTL;
    private View rootView;

    /* loaded from: classes23.dex */
    public interface a {
        void Oz(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.egP = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.hGg = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.kTI = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.kTJ = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.kTK = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.kTL = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.egP.setVisibility(8);
            this.kTJ.to(false);
            this.kTK.to(false);
            this.kTL.to(false);
            this.hGg.setVisibility(8);
            return;
        }
        this.hGg.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.kTJ.a(context, list.get(0), a(list.get(0), list2));
            this.kTK.to(false);
            this.kTL.to(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.kTJ.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.kTK.a(context, list.get(1), a(list.get(1), list2));
            this.kTL.to(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.kTJ.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.kTK.a(context, list.get(1), a(list.get(1), list2));
            z = this.kTL.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.egP.setVisibility(0);
        } else {
            this.egP.setVisibility(8);
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
        ap.setBackgroundResource(this.rootView, R.color.common_color_10187);
        ap.setBackgroundColor(this.kTI, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.egP, R.color.cp_cont_f, 1);
        ap.setBackgroundColor(this.hGg, R.color.cp_bg_line_c);
        this.kTJ.onChangeSkinType();
        this.kTK.onChangeSkinType();
        this.kTL.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
