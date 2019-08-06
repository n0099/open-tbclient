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
/* loaded from: classes5.dex */
public class c {
    private TextView bCd;
    private View eDo;
    private b hHA;
    private b hHB;
    private b hHC;
    private View hHz;
    private View rootView;

    /* loaded from: classes5.dex */
    public interface a {
        void BH(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.bCd = (TextView) this.rootView.findViewById(R.id.chosen_pb_comment_title);
        this.eDo = this.rootView.findViewById(R.id.chosen_pb_comment_line);
        this.hHz = this.rootView.findViewById(R.id.comment_layout_blank_view);
        this.hHA = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.hHB = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.hHC = new b((ViewStub) this.rootView.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.bCd.setVisibility(8);
            this.hHA.nZ(false);
            this.hHB.nZ(false);
            this.hHC.nZ(false);
            this.eDo.setVisibility(8);
            return;
        }
        this.eDo.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.hHA.a(context, list.get(0), a(list.get(0), list2));
            this.hHB.nZ(false);
            this.hHC.nZ(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.hHA.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.hHB.a(context, list.get(1), a(list.get(1), list2));
            this.hHC.nZ(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.hHA.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.hHB.a(context, list.get(1), a(list.get(1), list2));
            z = this.hHC.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.bCd.setVisibility(0);
        } else {
            this.bCd.setVisibility(8);
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
        am.k(this.rootView, R.color.common_color_10187);
        am.l(this.hHz, R.color.cp_bg_line_d);
        am.f(this.bCd, R.color.cp_cont_f, 1);
        am.l(this.eDo, R.color.cp_bg_line_b);
        this.hHA.onChangeSkinType();
        this.hHB.onChangeSkinType();
        this.hHC.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
