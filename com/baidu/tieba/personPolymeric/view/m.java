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
    private com.baidu.tieba.personPolymeric.event.b hQn = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g hTI;
    private com.baidu.tieba.personPolymeric.c.a hTJ;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.hTI = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.hTJ = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hTI != null && this.hTJ != null && this.hTJ.getUserData() != null) {
            UserData userData = this.hTJ.getUserData();
            this.hQn.eHk = -1;
            if (view.getId() == d.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new am("c12502").bJ("obj_locate", "5"));
                this.hQn.eHk = 1;
                this.hQn.eHl = new Bundle();
                this.hQn.eHl.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.hQn.eHk = 2;
            } else if (view.getId() == d.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new am("c12502").bJ("obj_locate", "4"));
                this.hQn.eHk = 3;
                this.hQn.eHl = new Bundle();
                this.hQn.eHl.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.container_send_gift) {
                TiebaStatic.log(new am("c12503").bJ("obj_locate", "3"));
                this.hQn.eHk = 12;
                this.hQn.eHl = new Bundle();
                this.hQn.eHl.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.seal_prefix_view) {
                this.hQn.eHk = 13;
            } else if (view.getId() == d.g.person_center_header_tdou_txt || view.getId() == d.g.textview_get_tdou) {
                if (view.getId() == d.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == d.g.textview_get_tdou) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.hQn.eHk = 14;
            } else if (view.getId() == d.g.person_polymeric_header_user_name_txt || view.getId() == d.g.person_polymeric_header_sign_txt || view.getId() == d.g.btn_edit_person_info) {
                if (view.getId() == d.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", "7"));
                } else if (view.getId() == d.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == d.g.btn_edit_person_info) {
                    TiebaStatic.log(new am("c12502").bJ("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.hQn.eHl = new Bundle();
                    this.hQn.eHl.putSerializable(UserData.TYPE_USER, userData);
                    if (this.hTJ != null && this.hTJ.hRF != null) {
                        this.hQn.eHl.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.hTJ.hRF.left_days.intValue());
                    }
                    this.hQn.eHk = 11;
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
                this.hQn.eHk = 34;
                this.hQn.eHl = new Bundle();
                this.hQn.eHl.putSerializable(UserData.TYPE_USER, userData);
            }
            this.hTI.a(view, this.hQn);
        }
    }
}
