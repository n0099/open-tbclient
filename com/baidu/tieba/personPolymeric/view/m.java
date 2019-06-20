package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes6.dex */
public class m implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.event.b ije = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g imA;
    private com.baidu.tieba.personPolymeric.c.a imB;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.imA = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.imB = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.imA != null && this.imB != null && this.imB.getUserData() != null) {
            UserData userData = this.imB.getUserData();
            this.ije.eXw = -1;
            if (view.getId() == R.id.person_polymeric_header_user_img) {
                TiebaStatic.log(new am("c12502").bT("obj_locate", "5"));
                this.ije.eXw = 1;
                this.ije.ayy = new Bundle();
                this.ije.ayy.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == R.id.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.ije.eXw = 2;
            } else if (view.getId() == R.id.person_polymeric_header_label_box) {
                TiebaStatic.log(new am("c12502").bT("obj_locate", "4"));
                this.ije.eXw = 3;
                this.ije.ayy = new Bundle();
                this.ije.ayy.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == R.id.container_send_gift) {
                TiebaStatic.log(new am("c12503").bT("obj_locate", "3"));
                this.ije.eXw = 12;
                this.ije.ayy = new Bundle();
                this.ije.ayy.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == R.id.seal_prefix_view) {
                this.ije.eXw = 13;
            } else if (view.getId() == R.id.person_center_header_tdou_txt || view.getId() == R.id.textview_get_tdou) {
                if (view.getId() == R.id.person_center_header_tdou_txt) {
                    TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == R.id.textview_get_tdou) {
                    TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.ije.eXw = 14;
            } else if (view.getId() == R.id.person_polymeric_header_user_name_txt || view.getId() == R.id.person_polymeric_header_sign_txt || view.getId() == R.id.btn_edit_person_info) {
                if (view.getId() == R.id.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new am("c12502").bT("obj_locate", "7"));
                } else if (view.getId() == R.id.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == R.id.btn_edit_person_info) {
                    TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.ije.ayy = new Bundle();
                    this.ije.ayy.putSerializable(UserData.TYPE_USER, userData);
                    if (this.imB != null && this.imB.ikw != null) {
                        this.ije.ayy.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.imB.ikw.left_days.intValue());
                    }
                    this.ije.eXw = 11;
                } else {
                    view.requestLayout();
                    if (view instanceof TextView) {
                        ((TextView) view).setMaxLines(2147483646);
                    }
                }
            } else if (view.getId() == R.id.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new am("c12502").bT("obj_locate", Constants.VIA_REPORT_TYPE_WPA_STATE));
                } else {
                    TiebaStatic.log(new am("c12503").bT("obj_locate", "5"));
                }
                this.ije.eXw = 34;
                this.ije.ayy = new Bundle();
                this.ije.ayy.putSerializable(UserData.TYPE_USER, userData);
            }
            this.imA.a(view, this.ije);
        }
    }
}
