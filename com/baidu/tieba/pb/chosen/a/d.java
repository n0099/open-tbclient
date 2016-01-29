package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class d {
    private View aOS;
    private TextView aQR;
    private View azA;
    private b cIP;
    private b cIQ;
    private b cIR;

    /* loaded from: classes.dex */
    public interface a {
        void ku(String str);
    }

    public d(Context context, a aVar) {
        this.azA = LayoutInflater.from(context).inflate(t.h.chosen_pb_comment_layout, (ViewGroup) null);
        this.aQR = (TextView) this.azA.findViewById(t.g.chosen_pb_comment_title);
        this.aOS = this.azA.findViewById(t.g.chosen_pb_comment_line);
        this.cIP = new b((ViewStub) this.azA.findViewById(t.g.chosen_pb_commrnt_first), aVar);
        this.cIQ = new b((ViewStub) this.azA.findViewById(t.g.chosen_pb_commrnt_second), aVar);
        this.cIR = new b((ViewStub) this.azA.findViewById(t.g.chosen_pb_commrnt_third), aVar);
    }

    public void a(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (list == null || list.isEmpty()) {
            this.aQR.setVisibility(8);
            this.cIP.fb(false);
            this.cIQ.fb(false);
            this.cIR.fb(false);
            return;
        }
        int size = list.size();
        if (size == 1) {
            boolean a2 = this.cIP.a(context, list.get(0), a(list.get(0), list2));
            this.cIQ.fb(false);
            this.cIR.fb(false);
            z2 = false;
            z3 = a2;
            z = false;
        } else if (size == 2) {
            z3 = this.cIP.a(context, list.get(0), a(list.get(0), list2));
            boolean a3 = this.cIQ.a(context, list.get(1), a(list.get(1), list2));
            this.cIR.fb(false);
            z2 = a3;
            z = false;
        } else if (size >= 3) {
            boolean a4 = this.cIP.a(context, list.get(0), a(list.get(0), list2));
            boolean a5 = this.cIQ.a(context, list.get(1), a(list.get(1), list2));
            z = this.cIR.a(context, list.get(2), a(list.get(2), list2));
            z2 = a5;
            z3 = a4;
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z3 || z2 || z) {
            this.aQR.setVisibility(0);
        } else {
            this.aQR.setVisibility(8);
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

    public void uv() {
        ar.k(this.azA, t.d.recommend_pb_comment_background);
        ar.b(this.aQR, t.d.cp_cont_f, 1);
        ar.l(this.aOS, t.d.cp_bg_line_b);
        this.cIP.uv();
        this.cIQ.uv();
        this.cIR.uv();
    }

    public View getView() {
        return this.azA;
    }
}
