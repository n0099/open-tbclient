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
    private com.baidu.tieba.personPolymeric.event.b hQo = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g hTJ;
    private com.baidu.tieba.personPolymeric.c.a hTK;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.hTJ = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.hTK = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hTJ != null && this.hTK != null && this.hTK.getUserData() != null) {
            UserData userData = this.hTK.getUserData();
            this.hQo.eHl = -1;
            if (view.getId() == d.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new am("c12502").bJ("obj_locate", "5"));
                this.hQo.eHl = 1;
                this.hQo.eHm = new Bundle();
                this.hQo.eHm.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.hQo.eHl = 2;
            } else if (view.getId() == d.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new am("c12502").bJ("obj_locate", "4"));
                this.hQo.eHl = 3;
                this.hQo.eHm = new Bundle();
                this.hQo.eHm.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.container_send_gift) {
                TiebaStatic.log(new am("c12503").bJ("obj_locate", "3"));
                this.hQo.eHl = 12;
                this.hQo.eHm = new Bundle();
                this.hQo.eHm.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.seal_prefix_view) {
                this.hQo.eHl = 13;
            } else if (view.getId() == d.g.person_center_header_tdou_txt || view.getId() == d.g.textview_get_tdou) {
                if (view.getId() == d.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == d.g.textview_get_tdou) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.hQo.eHl = 14;
            } else if (view.getId() == d.g.person_polymeric_header_user_name_txt || view.getId() == d.g.person_polymeric_header_sign_txt || view.getId() == d.g.btn_edit_person_info) {
                if (view.getId() == d.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", "7"));
                } else if (view.getId() == d.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == d.g.btn_edit_person_info) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.hQo.eHm = new Bundle();
                    this.hQo.eHm.putSerializable(UserData.TYPE_USER, userData);
                    if (this.hTK != null && this.hTK.hRG != null) {
                        this.hQo.eHm.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.hTK.hRG.left_days.intValue());
                    }
                    this.hQo.eHl = 11;
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
                this.hQo.eHl = 34;
                this.hQo.eHm = new Bundle();
                this.hQo.eHm.putSerializable(UserData.TYPE_USER, userData);
            }
            this.hTJ.a(view, this.hQo);
        }
    }
}
