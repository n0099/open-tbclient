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
    private com.baidu.tieba.personPolymeric.event.b iqZ = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g iuv;
    private com.baidu.tieba.personPolymeric.c.a iuw;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.iuv = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.iuw = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iuv != null && this.iuw != null && this.iuw.getUserData() != null) {
            UserData userData = this.iuw.getUserData();
            this.iqZ.fhu = -1;
            if (view.getId() == R.id.person_polymeric_header_user_img) {
                TiebaStatic.log(new an("c12502").bS("obj_locate", "5"));
                this.iqZ.fhu = 1;
                this.iqZ.aSR = new Bundle();
                this.iqZ.aSR.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == R.id.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new an("c12502").bS("obj_locate", "6"));
                this.iqZ.fhu = 2;
            } else if (view.getId() == R.id.person_polymeric_header_label_box) {
                TiebaStatic.log(new an("c12502").bS("obj_locate", "4"));
                this.iqZ.fhu = 3;
                this.iqZ.aSR = new Bundle();
                this.iqZ.aSR.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == R.id.container_send_gift) {
                TiebaStatic.log(new an("c12503").bS("obj_locate", "3"));
                this.iqZ.fhu = 12;
                this.iqZ.aSR = new Bundle();
                this.iqZ.aSR.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == R.id.seal_prefix_view) {
                this.iqZ.fhu = 13;
            } else if (view.getId() == R.id.person_center_header_tdou_txt || view.getId() == R.id.textview_get_tdou) {
                if (view.getId() == R.id.person_center_header_tdou_txt) {
                    TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == R.id.textview_get_tdou) {
                    TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.iqZ.fhu = 14;
            } else if (view.getId() == R.id.person_polymeric_header_user_name_txt || view.getId() == R.id.person_polymeric_header_sign_txt || view.getId() == R.id.btn_edit_person_info) {
                if (view.getId() == R.id.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new an("c12502").bS("obj_locate", "7"));
                } else if (view.getId() == R.id.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == R.id.btn_edit_person_info) {
                    TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.iqZ.aSR = new Bundle();
                    this.iqZ.aSR.putSerializable(UserData.TYPE_USER, userData);
                    if (this.iuw != null && this.iuw.isr != null) {
                        this.iqZ.aSR.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.iuw.isr.left_days.intValue());
                    }
                    this.iqZ.fhu = 11;
                } else {
                    view.requestLayout();
                    if (view instanceof TextView) {
                        ((TextView) view).setMaxLines(2147483646);
                    }
                }
            } else if (view.getId() == R.id.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c12502").bS("obj_locate", Constants.VIA_REPORT_TYPE_WPA_STATE));
                } else {
                    TiebaStatic.log(new an("c12503").bS("obj_locate", "5"));
                }
                this.iqZ.fhu = 34;
                this.iqZ.aSR = new Bundle();
                this.iqZ.aSR.putSerializable(UserData.TYPE_USER, userData);
            }
            this.iuv.a(view, this.iqZ);
        }
    }
}
