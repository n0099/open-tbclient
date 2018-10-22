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
    private com.baidu.tieba.personPolymeric.event.b gor = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g grL;
    private com.baidu.tieba.personPolymeric.c.a grM;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.grL = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.grM = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.grL != null && this.grM != null && this.grM.getUserData() != null) {
            UserData userData = this.grM.getUserData();
            this.gor.djg = -1;
            if (view.getId() == e.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new am("c12502").ax("obj_locate", "5"));
                this.gor.djg = 1;
                this.gor.djh = new Bundle();
                this.gor.djh.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.gor.djg = 2;
            } else if (view.getId() == e.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new am("c12502").ax("obj_locate", "4"));
                this.gor.djg = 3;
                this.gor.djh = new Bundle();
                this.gor.djh.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.container_send_gift) {
                TiebaStatic.log(new am("c12503").ax("obj_locate", "3"));
                this.gor.djg = 12;
                this.gor.djh = new Bundle();
                this.gor.djh.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.seal_prefix_view) {
                this.gor.djg = 13;
            } else if (view.getId() == e.g.person_center_header_tdou_txt || view.getId() == e.g.textview_get_tdou) {
                if (view.getId() == e.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == e.g.textview_get_tdou) {
                    TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.gor.djg = 14;
            } else if (view.getId() == e.g.person_polymeric_header_user_name_txt || view.getId() == e.g.person_polymeric_header_sign_txt || view.getId() == e.g.btn_edit_person_info) {
                if (view.getId() == e.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new am("c12502").ax("obj_locate", "7"));
                } else if (view.getId() == e.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == e.g.btn_edit_person_info) {
                    TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.gor.djh = new Bundle();
                    this.gor.djh.putSerializable(UserData.TYPE_USER, userData);
                    if (this.grM != null && this.grM.gpJ != null) {
                        this.gor.djh.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.grM.gpJ.left_days.intValue());
                    }
                    this.gor.djg = 11;
                } else {
                    view.requestLayout();
                    if (view instanceof TextView) {
                        ((TextView) view).setMaxLines(2147483646);
                    }
                }
            } else if (view.getId() == e.g.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_WPA_STATE));
                } else {
                    TiebaStatic.log(new am("c12503").ax("obj_locate", "5"));
                }
                this.gor.djg = 34;
                this.gor.djh = new Bundle();
                this.gor.djh.putSerializable(UserData.TYPE_USER, userData);
            }
            this.grL.a(view, this.gor);
        }
    }
}
