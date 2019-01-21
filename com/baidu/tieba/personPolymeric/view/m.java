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
    private com.baidu.tieba.personPolymeric.event.b gAC = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g gDX;
    private com.baidu.tieba.personPolymeric.c.a gDY;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gDX = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gDY = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gDX != null && this.gDY != null && this.gDY.getUserData() != null) {
            UserData userData = this.gDY.getUserData();
            this.gAC.dul = -1;
            if (view.getId() == e.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new am("c12502").aB("obj_locate", "5"));
                this.gAC.dul = 1;
                this.gAC.dum = new Bundle();
                this.gAC.dum.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.gAC.dul = 2;
            } else if (view.getId() == e.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new am("c12502").aB("obj_locate", "4"));
                this.gAC.dul = 3;
                this.gAC.dum = new Bundle();
                this.gAC.dum.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.container_send_gift) {
                TiebaStatic.log(new am("c12503").aB("obj_locate", "3"));
                this.gAC.dul = 12;
                this.gAC.dum = new Bundle();
                this.gAC.dum.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.seal_prefix_view) {
                this.gAC.dul = 13;
            } else if (view.getId() == e.g.person_center_header_tdou_txt || view.getId() == e.g.textview_get_tdou) {
                if (view.getId() == e.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == e.g.textview_get_tdou) {
                    TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.gAC.dul = 14;
            } else if (view.getId() == e.g.person_polymeric_header_user_name_txt || view.getId() == e.g.person_polymeric_header_sign_txt || view.getId() == e.g.btn_edit_person_info) {
                if (view.getId() == e.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new am("c12502").aB("obj_locate", "7"));
                } else if (view.getId() == e.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == e.g.btn_edit_person_info) {
                    TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.gAC.dum = new Bundle();
                    this.gAC.dum.putSerializable(UserData.TYPE_USER, userData);
                    if (this.gDY != null && this.gDY.gBU != null) {
                        this.gAC.dum.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.gDY.gBU.left_days.intValue());
                    }
                    this.gAC.dul = 11;
                } else {
                    view.requestLayout();
                    if (view instanceof TextView) {
                        ((TextView) view).setMaxLines(2147483646);
                    }
                }
            } else if (view.getId() == e.g.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_WPA_STATE));
                } else {
                    TiebaStatic.log(new am("c12503").aB("obj_locate", "5"));
                }
                this.gAC.dul = 34;
                this.gAC.dum = new Bundle();
                this.gAC.dum.putSerializable(UserData.TYPE_USER, userData);
            }
            this.gDX.a(view, this.gAC);
        }
    }
}
