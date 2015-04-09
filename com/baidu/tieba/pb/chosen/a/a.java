package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.v;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public class a {
    private TextView aFA;
    private HeadImageView azz;
    private View bGt;
    private TextView bGu;
    private d bGv;

    public a(View view) {
        this.bGt = view;
        this.azz = (HeadImageView) view.findViewById(v.chosen_pb_person_info_head);
        this.aFA = (TextView) view.findViewById(v.chosen_pb_person_info_name);
        this.bGu = (TextView) view.findViewById(v.chosen_pb_person_info_tag);
    }

    public void a(d dVar) {
        this.bGv = dVar;
    }

    public void hC(String str) {
        if (!StringUtils.isNull(str) && this.azz != null) {
            this.azz.c(str, 12, false);
        }
    }

    public void setName(String str) {
        if (this.aFA != null) {
            this.aFA.setText(str);
        }
    }

    public void hD(String str) {
        if (this.bGu != null) {
            if (StringUtils.isNull(str)) {
                this.bGu.setVisibility(8);
                return;
            }
            this.bGu.setVisibility(0);
            this.bGu.setText(str);
        }
    }

    public void a(User_Info user_Info) {
        if (user_Info != null) {
            setName(user_Info.name);
            hC(user_Info.portrait);
            this.azz.setOnClickListener(new b(this, user_Info));
            this.aFA.setOnClickListener(new c(this, user_Info));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, String str) {
        if (this.bGv != null) {
            this.bGv.aP(String.valueOf(j), str);
        }
    }
}
