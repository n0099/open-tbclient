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
/* loaded from: classes8.dex */
public class c {
    private TextView eHx;
    private View ixr;
    private View lJi;
    private b lJj;
    private b lJk;
    private b lJl;
    private View rootView;

    /* loaded from: classes8.dex */
    public interface a {
        void Ph(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.eHx = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.ixr = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.lJi = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.lJj = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.lJk = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.lJl = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.eHx.setVisibility(8);
            this.lJj.uD(false);
            this.lJk.uD(false);
            this.lJl.uD(false);
            this.ixr.setVisibility(8);
            return;
        }
        this.ixr.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.lJj.a(context, list.get(0), a(list.get(0), list2));
            this.lJk.uD(false);
            this.lJl.uD(false);
            z = false;
            z2 = false;
            z3 = a2;
        } else if (size == 2) {
            boolean a3 = this.lJj.a(context, list.get(0), a(list.get(0), list2));
            z2 = this.lJk.a(context, list.get(1), a(list.get(1), list2));
            this.lJl.uD(false);
            z = false;
            z3 = a3;
        } else if (size >= 3) {
            z3 = this.lJj.a(context, list.get(0), a(list.get(0), list2));
            boolean a4 = this.lJk.a(context, list.get(1), a(list.get(1), list2));
            z = this.lJl.a(context, list.get(2), a(list.get(2), list2));
            z2 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.eHx.setVisibility(0);
        } else {
            this.eHx.setVisibility(8);
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
        ap.setBackgroundColor(this.lJi, R.color.CAM_X0201);
        ap.setViewTextColor(this.eHx, R.color.CAM_X0106, 1);
        ap.setBackgroundColor(this.ixr, R.color.CAM_X0204);
        this.lJj.onChangeSkinType();
        this.lJk.onChangeSkinType();
        this.lJl.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
