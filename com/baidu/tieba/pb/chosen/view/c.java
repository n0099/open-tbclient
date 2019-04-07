package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes5.dex */
public class c {
    private TextView buc;
    private View eiu;
    private View hiW;
    private b hiX;
    private b hiY;
    private b hiZ;
    private View rootView;

    /* loaded from: classes5.dex */
    public interface a {
        void zC(String str);
    }

    public c(Context context, a aVar) {
        this.rootView = LayoutInflater.from(context).inflate(d.h.chosen_pb_comment_layout, (ViewGroup) null);
        this.buc = (TextView) this.rootView.findViewById(d.g.chosen_pb_comment_title);
        this.eiu = this.rootView.findViewById(d.g.chosen_pb_comment_line);
        this.hiW = this.rootView.findViewById(d.g.comment_layout_blank_view);
        this.hiX = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_first), aVar);
        this.hiY = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_second), aVar);
        this.hiZ = new b((ViewStub) this.rootView.findViewById(d.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.buc.setVisibility(8);
            this.hiX.mV(false);
            this.hiY.mV(false);
            this.hiZ.mV(false);
            this.eiu.setVisibility(8);
            return;
        }
        this.eiu.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.hiX.a(context, list.get(0), a(list.get(0), list2));
            this.hiY.mV(false);
            this.hiZ.mV(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.hiX.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.hiY.a(context, list.get(1), a(list.get(1), list2));
            this.hiZ.mV(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.hiX.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.hiY.a(context, list.get(1), a(list.get(1), list2));
            z = this.hiZ.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.buc.setVisibility(0);
        } else {
            this.buc.setVisibility(8);
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
        al.k(this.rootView, d.C0277d.common_color_10187);
        al.l(this.hiW, d.C0277d.cp_bg_line_d);
        al.d(this.buc, d.C0277d.cp_cont_f, 1);
        al.l(this.eiu, d.C0277d.cp_bg_line_b);
        this.hiX.onChangeSkinType();
        this.hiY.onChangeSkinType();
        this.hiZ.onChangeSkinType();
    }

    public View getView() {
        return this.rootView;
    }
}
