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
    private TextView cKR;
    private View fKj;
    private View iAO;
    private b iAP;
    private b iAQ;
    private b iAR;
    private View rootView;

    /* loaded from: classes10.dex */
    public interface a {
        void FF(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.cKR = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.fKj = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.iAO = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.iAP = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.iAQ = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.iAR = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.cKR.setVisibility(8);
            this.iAP.pq(false);
            this.iAQ.pq(false);
            this.iAR.pq(false);
            this.fKj.setVisibility(8);
            return;
        }
        this.fKj.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.iAP.a(context, list.get(0), a(list.get(0), list2));
            this.iAQ.pq(false);
            this.iAR.pq(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.iAP.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.iAQ.a(context, list.get(1), a(list.get(1), list2));
            this.iAR.pq(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.iAP.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.iAQ.a(context, list.get(1), a(list.get(1), list2));
            z = this.iAR.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.cKR.setVisibility(0);
        } else {
            this.cKR.setVisibility(8);
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
        am.setBackgroundColor(this.iAO, R.color.cp_bg_line_d);
        am.setViewTextColor(this.cKR, R.color.cp_cont_f, 1);
        am.setBackgroundColor(this.fKj, R.color.cp_bg_line_c);
        this.iAP.onChangeSkinType();
        this.iAQ.onChangeSkinType();
        this.iAR.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
