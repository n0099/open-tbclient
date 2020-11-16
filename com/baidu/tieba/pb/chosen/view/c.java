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
/* loaded from: classes22.dex */
public class c {
    private TextView etx;
    private View hZa;
    private View lmt;
    private b lmu;
    private b lmv;
    private b lmw;
    private View rootView;

    /* loaded from: classes22.dex */
    public interface a {
        void OK(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.etx = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.hZa = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.lmt = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.lmu = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.lmv = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.lmw = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.etx.setVisibility(8);
            this.lmu.tR(false);
            this.lmv.tR(false);
            this.lmw.tR(false);
            this.hZa.setVisibility(8);
            return;
        }
        this.hZa.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.lmu.a(context, list.get(0), a(list.get(0), list2));
            this.lmv.tR(false);
            this.lmw.tR(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.lmu.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.lmv.a(context, list.get(1), a(list.get(1), list2));
            this.lmw.tR(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.lmu.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.lmv.a(context, list.get(1), a(list.get(1), list2));
            z = this.lmw.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.etx.setVisibility(0);
        } else {
            this.etx.setVisibility(8);
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
        ap.setBackgroundColor(this.lmt, R.color.CAM_X0201);
        ap.setViewTextColor(this.etx, R.color.CAM_X0106, 1);
        ap.setBackgroundColor(this.hZa, R.color.CAM_X0204);
        this.lmu.onChangeSkinType();
        this.lmv.onChangeSkinType();
        this.lmw.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
