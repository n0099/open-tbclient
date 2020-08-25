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
/* loaded from: classes17.dex */
public class c {
    private TextView dSz;
    private View hkf;
    private View kvR;
    private b kvS;
    private b kvT;
    private b kvU;
    private View rootView;

    /* loaded from: classes17.dex */
    public interface a {
        void Nh(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.dSz = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.hkf = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.kvR = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.kvS = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.kvT = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.kvU = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.dSz.setVisibility(8);
            this.kvS.sx(false);
            this.kvT.sx(false);
            this.kvU.sx(false);
            this.hkf.setVisibility(8);
            return;
        }
        this.hkf.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.kvS.a(context, list.get(0), a(list.get(0), list2));
            this.kvT.sx(false);
            this.kvU.sx(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.kvS.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.kvT.a(context, list.get(1), a(list.get(1), list2));
            this.kvU.sx(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.kvS.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.kvT.a(context, list.get(1), a(list.get(1), list2));
            z = this.kvU.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.dSz.setVisibility(0);
        } else {
            this.dSz.setVisibility(8);
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
        ap.setBackgroundColor(this.kvR, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dSz, R.color.cp_cont_f, 1);
        ap.setBackgroundColor(this.hkf, R.color.cp_bg_line_c);
        this.kvS.onChangeSkinType();
        this.kvT.onChangeSkinType();
        this.kvU.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
