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
    private com.baidu.tieba.personPolymeric.event.b gAB = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g gDW;
    private com.baidu.tieba.personPolymeric.c.a gDX;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gDW = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gDX = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gDW != null && this.gDX != null && this.gDX.getUserData() != null) {
            UserData userData = this.gDX.getUserData();
            this.gAB.duk = -1;
            if (view.getId() == e.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new am("c12502").aB("obj_locate", "5"));
                this.gAB.duk = 1;
                this.gAB.dul = new Bundle();
                this.gAB.dul.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.gAB.duk = 2;
            } else if (view.getId() == e.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new am("c12502").aB("obj_locate", "4"));
                this.gAB.duk = 3;
                this.gAB.dul = new Bundle();
                this.gAB.dul.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.container_send_gift) {
                TiebaStatic.log(new am("c12503").aB("obj_locate", "3"));
                this.gAB.duk = 12;
                this.gAB.dul = new Bundle();
                this.gAB.dul.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.seal_prefix_view) {
                this.gAB.duk = 13;
            } else if (view.getId() == e.g.person_center_header_tdou_txt || view.getId() == e.g.textview_get_tdou) {
                if (view.getId() == e.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == e.g.textview_get_tdou) {
                    TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.gAB.duk = 14;
            } else if (view.getId() == e.g.person_polymeric_header_user_name_txt || view.getId() == e.g.person_polymeric_header_sign_txt || view.getId() == e.g.btn_edit_person_info) {
                if (view.getId() == e.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new am("c12502").aB("obj_locate", "7"));
                } else if (view.getId() == e.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == e.g.btn_edit_person_info) {
                    TiebaStatic.log(new am("c12502").aB("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.gAB.dul = new Bundle();
                    this.gAB.dul.putSerializable(UserData.TYPE_USER, userData);
                    if (this.gDX != null && this.gDX.gBT != null) {
                        this.gAB.dul.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.gDX.gBT.left_days.intValue());
                    }
                    this.gAB.duk = 11;
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
                this.gAB.duk = 34;
                this.gAB.dul = new Bundle();
                this.gAB.dul.putSerializable(UserData.TYPE_USER, userData);
            }
            this.gDW.a(view, this.gAB);
        }
    }
}
