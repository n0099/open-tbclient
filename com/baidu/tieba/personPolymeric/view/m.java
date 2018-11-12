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
    private com.baidu.tieba.personPolymeric.event.b gpQ = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g gtl;
    private com.baidu.tieba.personPolymeric.c.a gtm;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gtl = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gtm = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gtl != null && this.gtm != null && this.gtm.getUserData() != null) {
            UserData userData = this.gtm.getUserData();
            this.gpQ.dkl = -1;
            if (view.getId() == e.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new am("c12502").ax("obj_locate", "5"));
                this.gpQ.dkl = 1;
                this.gpQ.dkm = new Bundle();
                this.gpQ.dkm.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.gpQ.dkl = 2;
            } else if (view.getId() == e.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new am("c12502").ax("obj_locate", "4"));
                this.gpQ.dkl = 3;
                this.gpQ.dkm = new Bundle();
                this.gpQ.dkm.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.container_send_gift) {
                TiebaStatic.log(new am("c12503").ax("obj_locate", "3"));
                this.gpQ.dkl = 12;
                this.gpQ.dkm = new Bundle();
                this.gpQ.dkm.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == e.g.seal_prefix_view) {
                this.gpQ.dkl = 13;
            } else if (view.getId() == e.g.person_center_header_tdou_txt || view.getId() == e.g.textview_get_tdou) {
                if (view.getId() == e.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == e.g.textview_get_tdou) {
                    TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.gpQ.dkl = 14;
            } else if (view.getId() == e.g.person_polymeric_header_user_name_txt || view.getId() == e.g.person_polymeric_header_sign_txt || view.getId() == e.g.btn_edit_person_info) {
                if (view.getId() == e.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new am("c12502").ax("obj_locate", "7"));
                } else if (view.getId() == e.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == e.g.btn_edit_person_info) {
                    TiebaStatic.log(new am("c12502").ax("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.gpQ.dkm = new Bundle();
                    this.gpQ.dkm.putSerializable(UserData.TYPE_USER, userData);
                    if (this.gtm != null && this.gtm.gri != null) {
                        this.gpQ.dkm.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.gtm.gri.left_days.intValue());
                    }
                    this.gpQ.dkl = 11;
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
                this.gpQ.dkl = 34;
                this.gpQ.dkm = new Bundle();
                this.gpQ.dkm.putSerializable(UserData.TYPE_USER, userData);
            }
            this.gtl.a(view, this.gpQ);
        }
    }
}
