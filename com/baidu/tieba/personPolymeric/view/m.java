package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes6.dex */
public class m implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.event.b hQB = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g hTW;
    private com.baidu.tieba.personPolymeric.c.a hTX;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.hTW = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.hTX = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hTW != null && this.hTX != null && this.hTX.getUserData() != null) {
            UserData userData = this.hTX.getUserData();
            this.hQB.eHy = -1;
            if (view.getId() == d.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new am("c12502").bJ("obj_locate", "5"));
                this.hQB.eHy = 1;
                this.hQB.eHz = new Bundle();
                this.hQB.eHz.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.hQB.eHy = 2;
            } else if (view.getId() == d.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new am("c12502").bJ("obj_locate", "4"));
                this.hQB.eHy = 3;
                this.hQB.eHz = new Bundle();
                this.hQB.eHz.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.container_send_gift) {
                TiebaStatic.log(new am("c12503").bJ("obj_locate", "3"));
                this.hQB.eHy = 12;
                this.hQB.eHz = new Bundle();
                this.hQB.eHz.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.seal_prefix_view) {
                this.hQB.eHy = 13;
            } else if (view.getId() == d.g.person_center_header_tdou_txt || view.getId() == d.g.textview_get_tdou) {
                if (view.getId() == d.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == d.g.textview_get_tdou) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.hQB.eHy = 14;
            } else if (view.getId() == d.g.person_polymeric_header_user_name_txt || view.getId() == d.g.person_polymeric_header_sign_txt || view.getId() == d.g.btn_edit_person_info) {
                if (view.getId() == d.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", "7"));
                } else if (view.getId() == d.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == d.g.btn_edit_person_info) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.hQB.eHz = new Bundle();
                    this.hQB.eHz.putSerializable(UserData.TYPE_USER, userData);
                    if (this.hTX != null && this.hTX.hRT != null) {
                        this.hQB.eHz.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.hTX.hRT.left_days.intValue());
                    }
                    this.hQB.eHy = 11;
                } else {
                    view.requestLayout();
                    if (view instanceof TextView) {
                        ((TextView) view).setMaxLines(2147483646);
                    }
                }
            } else if (view.getId() == d.g.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_WPA_STATE));
                } else {
                    TiebaStatic.log(new am("c12503").bJ("obj_locate", "5"));
                }
                this.hQB.eHy = 34;
                this.hQB.eHz = new Bundle();
                this.hQB.eHz.putSerializable(UserData.TYPE_USER, userData);
            }
            this.hTW.a(view, this.hQB);
        }
    }
}
