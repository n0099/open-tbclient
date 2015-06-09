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
    private HeadImageView aBl;
    private TextView aDk;
    private TextView aHI;
    private TextView aiA;
    private View bJm;
    private g bJn;
    private TextView bJo;

    public b(Context context) {
        this.bJm = com.baidu.adp.lib.g.b.hr().inflate(context, r.chosen_pb_person_info, null);
        this.aiA = (TextView) this.bJm.findViewById(q.chosen_pb_title);
        this.aBl = (HeadImageView) this.bJm.findViewById(q.chosen_pb_person_info_head);
        this.aHI = (TextView) this.bJm.findViewById(q.chosen_pb_person_info_name);
        this.aDk = (TextView) this.bJm.findViewById(q.chosen_pb_person_info_tag);
        this.bJo = (TextView) this.bJm.findViewById(q.chosen_pb_person_info_bar);
        this.aBl.setRadius(n.dip2px(context, 2.0f));
    }

    public View aan() {
        return this.bJm;
    }

    public void a(g gVar) {
        this.bJn = gVar;
    }

    public void ii(String str) {
        if (!StringUtils.isNull(str) && this.aBl != null) {
            this.aBl.c(str, 12, false);
        }
    }

    public void setName(String str) {
        if (this.aHI != null) {
            this.aHI.setText(str);
        }
    }

    public void N(Context context, String str) {
        if (this.bJo != null) {
            if (StringUtils.isNull(str)) {
                this.bJo.setVisibility(4);
                return;
            }
            this.bJo.setText(context.getString(t.chosen_pb_original_bar, str));
            this.bJo.setOnClickListener(new c(this, str));
            this.bJo.setVisibility(0);
        }
    }

    public void ij(String str) {
        if (this.aDk != null) {
            if (StringUtils.isNull(str)) {
                this.aDk.setVisibility(8);
                return;
            }
            this.aDk.setVisibility(0);
            this.aDk.setText(str);
            this.aDk.setOnClickListener(new d(this, str));
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
            this.aBl.setOnClickListener(new e(this, user_Info));
            this.aHI.setOnClickListener(new f(this, user_Info));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, String str) {
        if (this.bJn != null) {
            this.bJn.aU(String.valueOf(j), str);
        }
    }
}
