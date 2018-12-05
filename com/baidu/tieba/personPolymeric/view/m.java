package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class m implements View.OnClickListener {
    protected com.baidu.tieba.view.g gAb;
    private com.baidu.tieba.personPolymeric.c.a gAc;
    private com.baidu.tieba.personPolymeric.event.b gwG = new com.baidu.tieba.personPolymeric.event.b();
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gAb = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gAc = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gAb != null && this.gAc != null && this.gAc.getUserData() != null) {
            UserData userData = this.gAc.getUserData();
            this.gwG.dqN = -1;
            if (view.getId() == e.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new am("c12502").aA("obj_locate", "5"));
                this.gwG.dqN = 1;
                this.gwG.dqO = new Bundle();
                this.gwG.dqO.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.gwG.dqN = 2;
            } else if (view.getId() == e.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new am("c12502").aA("obj_locate", "4"));
                this.gwG.dqN = 3;
                this.gwG.dqO = new Bundle();
                this.gwG.dqO.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.container_send_gift) {
                TiebaStatic.log(new am("c12503").aA("obj_locate", "3"));
                this.gwG.dqN = 12;
                this.gwG.dqO = new Bundle();
                this.gwG.dqO.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.seal_prefix_view) {
                this.gwG.dqN = 13;
            } else if (view.getId() == e.g.person_center_header_tdou_txt || view.getId() == e.g.textview_get_tdou) {
                if (view.getId() == e.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == e.g.textview_get_tdou) {
                    TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.gwG.dqN = 14;
            } else if (view.getId() == e.g.person_polymeric_header_user_name_txt || view.getId() == e.g.person_polymeric_header_sign_txt || view.getId() == e.g.btn_edit_person_info) {
                if (view.getId() == e.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new am("c12502").aA("obj_locate", "7"));
                } else if (view.getId() == e.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == e.g.btn_edit_person_info) {
                    TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.gwG.dqO = new Bundle();
                    this.gwG.dqO.putSerializable(UserData.TYPE_USER, userData);
                    if (this.gAc != null && this.gAc.gxY != null) {
                        this.gwG.dqO.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.gAc.gxY.left_days.intValue());
                    }
                    this.gwG.dqN = 11;
                } else {
                    view.requestLayout();
                    if (view instanceof TextView) {
                        ((TextView) view).setMaxLines(2147483646);
                    }
                }
            } else if (view.getId() == e.g.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new am("c12502").aA("obj_locate", Constants.VIA_REPORT_TYPE_WPA_STATE));
                } else {
                    TiebaStatic.log(new am("c12503").aA("obj_locate", "5"));
                }
                this.gwG.dqN = 34;
                this.gwG.dqO = new Bundle();
                this.gwG.dqO.putSerializable(UserData.TYPE_USER, userData);
            }
            this.gAb.a(view, this.gwG);
        }
    }
}
