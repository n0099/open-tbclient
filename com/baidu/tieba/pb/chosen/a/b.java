package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public class b {
    private HeadImageView aBk;
    private TextView aDj;
    private TextView aHH;
    private TextView aiA;
    private View bJl;
    private g bJm;
    private TextView bJn;

    public b(Context context) {
        this.bJl = com.baidu.adp.lib.g.b.hr().inflate(context, r.chosen_pb_person_info, null);
        this.aiA = (TextView) this.bJl.findViewById(q.chosen_pb_title);
        this.aBk = (HeadImageView) this.bJl.findViewById(q.chosen_pb_person_info_head);
        this.aHH = (TextView) this.bJl.findViewById(q.chosen_pb_person_info_name);
        this.aDj = (TextView) this.bJl.findViewById(q.chosen_pb_person_info_tag);
        this.bJn = (TextView) this.bJl.findViewById(q.chosen_pb_person_info_bar);
        this.aBk.setRadius(n.dip2px(context, 2.0f));
    }

    public View aam() {
        return this.bJl;
    }

    public void a(g gVar) {
        this.bJm = gVar;
    }

    public void ii(String str) {
        if (!StringUtils.isNull(str) && this.aBk != null) {
            this.aBk.c(str, 12, false);
        }
    }

    public void setName(String str) {
        if (this.aHH != null) {
            this.aHH.setText(str);
        }
    }

    public void N(Context context, String str) {
        if (this.bJn != null) {
            if (StringUtils.isNull(str)) {
                this.bJn.setVisibility(4);
                return;
            }
            this.bJn.setText(context.getString(t.chosen_pb_original_bar, str));
            this.bJn.setOnClickListener(new c(this, str));
            this.bJn.setVisibility(0);
        }
    }

    public void ij(String str) {
        if (this.aDj != null) {
            if (StringUtils.isNull(str)) {
                this.aDj.setVisibility(8);
                return;
            }
            this.aDj.setVisibility(0);
            this.aDj.setText(str);
            this.aDj.setOnClickListener(new d(this, str));
        }
    }

    public void setTitle(String str) {
        if (this.aiA != null) {
            this.aiA.setText(str);
        }
    }

    public void a(User_Info user_Info) {
        if (user_Info != null) {
            setName(user_Info.name);
            ii(user_Info.portrait);
            this.aBk.setOnClickListener(new e(this, user_Info));
            this.aHH.setOnClickListener(new f(this, user_Info));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, String str) {
        if (this.bJm != null) {
            this.bJm.aU(String.valueOf(j), str);
        }
    }
}
