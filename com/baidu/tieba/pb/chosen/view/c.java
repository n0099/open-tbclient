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
/* loaded from: classes7.dex */
public class c {
    private TextView eIY;
    private View izo;
    private b lLA;
    private b lLB;
    private View lLy;
    private b lLz;
    private View rootView;

    /* loaded from: classes7.dex */
    public interface a {
        void Po(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.eIY = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.izo = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.lLy = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.lLz = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.lLA = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.lLB = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.eIY.setVisibility(8);
            this.lLz.uD(false);
            this.lLA.uD(false);
            this.lLB.uD(false);
            this.izo.setVisibility(8);
            return;
        }
        this.izo.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.lLz.a(context, list.get(0), a(list.get(0), list2));
            this.lLA.uD(false);
            this.lLB.uD(false);
            z = false;
            z2 = false;
            z3 = a2;
        } else if (size == 2) {
            boolean a3 = this.lLz.a(context, list.get(0), a(list.get(0), list2));
            z2 = this.lLA.a(context, list.get(1), a(list.get(1), list2));
            this.lLB.uD(false);
            z = false;
            z3 = a3;
        } else if (size >= 3) {
            z3 = this.lLz.a(context, list.get(0), a(list.get(0), list2));
            boolean a4 = this.lLA.a(context, list.get(1), a(list.get(1), list2));
            z = this.lLB.a(context, list.get(2), a(list.get(2), list2));
            z2 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.eIY.setVisibility(0);
        } else {
            this.eIY.setVisibility(8);
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
        ap.setBackgroundColor(this.lLy, R.color.CAM_X0201);
        ap.setViewTextColor(this.eIY, R.color.CAM_X0106, 1);
        ap.setBackgroundColor(this.izo, R.color.CAM_X0204);
        this.lLz.onChangeSkinType();
        this.lLA.onChangeSkinType();
        this.lLB.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
