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
/* loaded from: classes8.dex */
public class c {
    private TextView eKc;
    private View iwu;
    private View lFa;
    private b lFb;
    private b lFc;
    private b lFd;
    private View rootView;

    /* loaded from: classes8.dex */
    public interface a {
        void Px(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.eKc = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.iwu = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.lFa = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.lFb = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.lFc = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.lFd = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.eKc.setVisibility(8);
            this.lFb.uu(false);
            this.lFc.uu(false);
            this.lFd.uu(false);
            this.iwu.setVisibility(8);
            return;
        }
        this.iwu.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.lFb.a(context, list.get(0), a(list.get(0), list2));
            this.lFc.uu(false);
            this.lFd.uu(false);
            z = false;
            z2 = false;
            z3 = a2;
        } else if (size == 2) {
            boolean a3 = this.lFb.a(context, list.get(0), a(list.get(0), list2));
            z2 = this.lFc.a(context, list.get(1), a(list.get(1), list2));
            this.lFd.uu(false);
            z = false;
            z3 = a3;
        } else if (size >= 3) {
            z3 = this.lFb.a(context, list.get(0), a(list.get(0), list2));
            boolean a4 = this.lFc.a(context, list.get(1), a(list.get(1), list2));
            z = this.lFd.a(context, list.get(2), a(list.get(2), list2));
            z2 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.eKc.setVisibility(0);
        } else {
            this.eKc.setVisibility(8);
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
        ao.setBackgroundColor(this.lFa, R.color.CAM_X0201);
        ao.setViewTextColor(this.eKc, R.color.CAM_X0106, 1);
        ao.setBackgroundColor(this.iwu, R.color.CAM_X0204);
        this.lFb.onChangeSkinType();
        this.lFc.onChangeSkinType();
        this.lFd.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
