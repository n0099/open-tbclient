package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.f;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class m implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.event.b fZy = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g gcU;
    private com.baidu.tieba.personPolymeric.c.a gcV;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gcU = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gcV = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gcU != null && this.gcV != null && this.gcV.getUserData() != null) {
            UserData userData = this.gcV.getUserData();
            this.fZy.cVc = -1;
            if (view.getId() == f.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new an("c12502").ae("obj_locate", "5"));
                this.fZy.cVc = 1;
                this.fZy.cVd = new Bundle();
                this.fZy.cVd.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == f.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.fZy.cVc = 2;
            } else if (view.getId() == f.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new an("c12502").ae("obj_locate", "4"));
                this.fZy.cVc = 3;
                this.fZy.cVd = new Bundle();
                this.fZy.cVd.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == f.g.container_send_gift) {
                TiebaStatic.log(new an("c12503").ae("obj_locate", "3"));
                this.fZy.cVc = 12;
                this.fZy.cVd = new Bundle();
                this.fZy.cVd.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == f.g.seal_prefix_view) {
                this.fZy.cVc = 13;
            } else if (view.getId() == f.g.person_center_header_tdou_txt || view.getId() == f.g.textview_get_tdou) {
                if (view.getId() == f.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == f.g.textview_get_tdou) {
                    TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.fZy.cVc = 14;
            } else if (view.getId() == f.g.person_polymeric_header_user_name_txt || view.getId() == f.g.person_polymeric_header_sign_txt || view.getId() == f.g.btn_edit_person_info) {
                if (view.getId() == f.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new an("c12502").ae("obj_locate", "7"));
                } else if (view.getId() == f.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == f.g.btn_edit_person_info) {
                    TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.fZy.cVd = new Bundle();
                    this.fZy.cVd.putSerializable(UserData.TYPE_USER, userData);
                    if (this.gcV != null && this.gcV.gaQ != null) {
                        this.fZy.cVd.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.gcV.gaQ.left_days.intValue());
                    }
                    this.fZy.cVc = 11;
                } else {
                    view.requestLayout();
                    if (view instanceof TextView) {
                        ((TextView) view).setMaxLines(2147483646);
                    }
                }
            } else if (view.getId() == f.g.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c12502").ae("obj_locate", Constants.VIA_REPORT_TYPE_WPA_STATE));
                } else {
                    TiebaStatic.log(new an("c12503").ae("obj_locate", "5"));
                }
                this.fZy.cVc = 34;
                this.fZy.cVd = new Bundle();
                this.fZy.cVd.putSerializable(UserData.TYPE_USER, userData);
            }
            this.gcU.a(view, this.fZy);
        }
    }
}
