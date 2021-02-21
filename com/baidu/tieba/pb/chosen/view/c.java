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
    private View ixF;
    private View lJw;
    private b lJx;
    private b lJy;
    private b lJz;
    private View rootView;

    /* loaded from: classes8.dex */
    public interface a {
        void Pi(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.eHx = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.ixF = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.lJw = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.lJx = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.lJy = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.lJz = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.eHx.setVisibility(8);
            this.lJx.uD(false);
            this.lJy.uD(false);
            this.lJz.uD(false);
            this.ixF.setVisibility(8);
            return;
        }
        this.ixF.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.lJx.a(context, list.get(0), a(list.get(0), list2));
            this.lJy.uD(false);
            this.lJz.uD(false);
            z = false;
            z2 = false;
            z3 = a2;
        } else if (size == 2) {
            boolean a3 = this.lJx.a(context, list.get(0), a(list.get(0), list2));
            z2 = this.lJy.a(context, list.get(1), a(list.get(1), list2));
            this.lJz.uD(false);
            z = false;
            z3 = a3;
        } else if (size >= 3) {
            z3 = this.lJx.a(context, list.get(0), a(list.get(0), list2));
            boolean a4 = this.lJy.a(context, list.get(1), a(list.get(1), list2));
            z = this.lJz.a(context, list.get(2), a(list.get(2), list2));
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
        ap.setBackgroundColor(this.lJw, R.color.CAM_X0201);
        ap.setViewTextColor(this.eHx, R.color.CAM_X0106, 1);
        ap.setBackgroundColor(this.ixF, R.color.CAM_X0204);
        this.lJx.onChangeSkinType();
        this.lJy.onChangeSkinType();
        this.lJz.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
