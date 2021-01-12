package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes7.dex */
public class c {
    private TextView eFr;
    private View irN;
    private View lAv;
    private b lAw;
    private b lAx;
    private b lAy;
    private View rootView;

    /* loaded from: classes7.dex */
    public interface a {
        void Op(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.eFr = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.irN = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.lAv = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.lAw = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.lAx = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.lAy = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.eFr.setVisibility(8);
            this.lAw.uq(false);
            this.lAx.uq(false);
            this.lAy.uq(false);
            this.irN.setVisibility(8);
            return;
        }
        this.irN.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.lAw.a(context, list.get(0), a(list.get(0), list2));
            this.lAx.uq(false);
            this.lAy.uq(false);
            z = false;
            z2 = false;
            z3 = a2;
        } else if (size == 2) {
            boolean a3 = this.lAw.a(context, list.get(0), a(list.get(0), list2));
            z2 = this.lAx.a(context, list.get(1), a(list.get(1), list2));
            this.lAy.uq(false);
            z = false;
            z3 = a3;
        } else if (size >= 3) {
            z3 = this.lAw.a(context, list.get(0), a(list.get(0), list2));
            boolean a4 = this.lAx.a(context, list.get(1), a(list.get(1), list2));
            z = this.lAy.a(context, list.get(2), a(list.get(2), list2));
            z2 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.eFr.setVisibility(0);
        } else {
            this.eFr.setVisibility(8);
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
        ao.setBackgroundResource(this.rootView, R.color.common_color_10187);
        ao.setBackgroundColor(this.lAv, R.color.CAM_X0201);
        ao.setViewTextColor(this.eFr, R.color.CAM_X0106, 1);
        ao.setBackgroundColor(this.irN, R.color.CAM_X0204);
        this.lAw.onChangeSkinType();
        this.lAx.onChangeSkinType();
        this.lAy.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
