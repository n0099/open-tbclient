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
    private TextView cKQ;
    private View fKh;
    private View iAM;
    private b iAN;
    private b iAO;
    private b iAP;
    private View rootView;

    /* loaded from: classes10.dex */
    public interface a {
        void FF(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.cKQ = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.fKh = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.iAM = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.iAN = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.iAO = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.iAP = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.cKQ.setVisibility(8);
            this.iAN.pq(false);
            this.iAO.pq(false);
            this.iAP.pq(false);
            this.fKh.setVisibility(8);
            return;
        }
        this.fKh.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.iAN.a(context, list.get(0), a(list.get(0), list2));
            this.iAO.pq(false);
            this.iAP.pq(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.iAN.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.iAO.a(context, list.get(1), a(list.get(1), list2));
            this.iAP.pq(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.iAN.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.iAO.a(context, list.get(1), a(list.get(1), list2));
            z = this.iAP.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.cKQ.setVisibility(0);
        } else {
            this.cKQ.setVisibility(8);
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
        am.setBackgroundColor(this.iAM, R.color.cp_bg_line_d);
        am.setViewTextColor(this.cKQ, R.color.cp_cont_f, 1);
        am.setBackgroundColor(this.fKh, R.color.cp_bg_line_c);
        this.iAN.onChangeSkinType();
        this.iAO.onChangeSkinType();
        this.iAP.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
