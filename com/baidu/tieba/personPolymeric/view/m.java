package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes6.dex */
public class m implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.event.b iqA = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g itU;
    private com.baidu.tieba.personPolymeric.c.a itV;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.itU = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.itV = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.itU != null && this.itV != null && this.itV.getUserData() != null) {
            UserData userData = this.itV.getUserData();
            this.iqA.fcX = -1;
            if (view.getId() == R.id.person_polymeric_header_user_img) {
                TiebaStatic.log(new an("c12502").bT("obj_locate", "5"));
                this.iqA.fcX = 1;
                this.iqA.azf = new Bundle();
                this.iqA.azf.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == R.id.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.iqA.fcX = 2;
            } else if (view.getId() == R.id.person_polymeric_header_label_box) {
                TiebaStatic.log(new an("c12502").bT("obj_locate", "4"));
                this.iqA.fcX = 3;
                this.iqA.azf = new Bundle();
                this.iqA.azf.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == R.id.container_send_gift) {
                TiebaStatic.log(new an("c12503").bT("obj_locate", "3"));
                this.iqA.fcX = 12;
                this.iqA.azf = new Bundle();
                this.iqA.azf.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == R.id.seal_prefix_view) {
                this.iqA.fcX = 13;
            } else if (view.getId() == R.id.person_center_header_tdou_txt || view.getId() == R.id.textview_get_tdou) {
                if (view.getId() == R.id.person_center_header_tdou_txt) {
                    TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == R.id.textview_get_tdou) {
                    TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.iqA.fcX = 14;
            } else if (view.getId() == R.id.person_polymeric_header_user_name_txt || view.getId() == R.id.person_polymeric_header_sign_txt || view.getId() == R.id.btn_edit_person_info) {
                if (view.getId() == R.id.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new an("c12502").bT("obj_locate", "7"));
                } else if (view.getId() == R.id.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == R.id.btn_edit_person_info) {
                    TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.iqA.azf = new Bundle();
                    this.iqA.azf.putSerializable(UserData.TYPE_USER, userData);
                    if (this.itV != null && this.itV.irS != null) {
                        this.iqA.azf.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.itV.irS.left_days.intValue());
                    }
                    this.iqA.fcX = 11;
                } else {
                    view.requestLayout();
                    if (view instanceof TextView) {
                        ((TextView) view).setMaxLines(2147483646);
                    }
                }
            } else if (view.getId() == R.id.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_WPA_STATE));
                } else {
                    TiebaStatic.log(new an("c12503").bT("obj_locate", "5"));
                }
                this.iqA.fcX = 34;
                this.iqA.azf = new Bundle();
                this.iqA.azf.putSerializable(UserData.TYPE_USER, userData);
            }
            this.itU.a(view, this.iqA);
        }
    }
}
