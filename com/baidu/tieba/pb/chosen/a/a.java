package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.v;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public class a {
    private TextView aFs;
    private HeadImageView azr;
    private View bGg;
    private TextView bGh;
    private d bGi;

    public a(View view) {
        this.bGg = view;
        this.azr = (HeadImageView) view.findViewById(v.chosen_pb_person_info_head);
        this.aFs = (TextView) view.findViewById(v.chosen_pb_person_info_name);
        this.bGh = (TextView) view.findViewById(v.chosen_pb_person_info_tag);
    }

    public void a(d dVar) {
        this.bGi = dVar;
    }

    public void hz(String str) {
        if (!StringUtils.isNull(str) && this.azr != null) {
            this.azr.c(str, 12, false);
        }
    }

    public void setName(String str) {
        if (this.aFs != null) {
            this.aFs.setText(str);
        }
    }

    public void hA(String str) {
        if (this.bGh != null) {
            if (StringUtils.isNull(str)) {
                this.bGh.setVisibility(8);
                return;
            }
            this.bGh.setVisibility(0);
            this.bGh.setText(str);
        }
    }

    public void a(User_Info user_Info) {
        if (user_Info != null) {
            setName(user_Info.name);
            hz(user_Info.portrait);
            this.azr.setOnClickListener(new b(this, user_Info));
            this.aFs.setOnClickListener(new c(this, user_Info));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, String str) {
        if (this.bGi != null) {
            this.bGi.aP(String.valueOf(j), str);
        }
    }
}
