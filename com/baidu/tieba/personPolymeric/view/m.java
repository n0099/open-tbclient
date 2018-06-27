package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class m implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.event.b fZg = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g gcD;
    private com.baidu.tieba.personPolymeric.c.a gcE;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gcD = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gcE = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gcD != null && this.gcE != null && this.gcE.getUserData() != null) {
            UserData userData = this.gcE.getUserData();
            this.fZg.cSt = -1;
            if (view.getId() == d.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new an("c12502").ah("obj_locate", "5"));
                this.fZg.cSt = 1;
                this.fZg.cSu = new Bundle();
                this.fZg.cSu.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                this.fZg.cSt = 2;
            } else if (view.getId() == d.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new an("c12502").ah("obj_locate", "4"));
                this.fZg.cSt = 3;
                this.fZg.cSu = new Bundle();
                this.fZg.cSu.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.container_send_gift) {
                TiebaStatic.log(new an("c12503").ah("obj_locate", "3"));
                this.fZg.cSt = 12;
                this.fZg.cSu = new Bundle();
                this.fZg.cSu.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.seal_prefix_view) {
                this.fZg.cSt = 13;
            } else if (view.getId() == d.g.person_center_header_tdou_txt || view.getId() == d.g.textview_get_tdou) {
                if (view.getId() == d.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == d.g.textview_get_tdou) {
                    TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.fZg.cSt = 14;
            } else if (view.getId() == d.g.person_polymeric_header_user_name_txt || view.getId() == d.g.person_polymeric_header_sign_txt || view.getId() == d.g.btn_edit_person_info) {
                if (view.getId() == d.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new an("c12502").ah("obj_locate", "7"));
                } else if (view.getId() == d.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else if (view.getId() == d.g.btn_edit_person_info) {
                    TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_REPORT_TYPE_START_WAP));
                }
                if (this.mIsHost) {
                    this.fZg.cSu = new Bundle();
                    this.fZg.cSu.putSerializable(UserData.TYPE_USER, userData);
                    if (this.gcE != null && this.gcE.gaz != null) {
                        this.fZg.cSu.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.gcE.gaz.left_days.intValue());
                    }
                    this.fZg.cSt = 11;
                } else {
                    view.requestLayout();
                    if (view instanceof TextView) {
                        ((TextView) view).setMaxLines(2147483646);
                    }
                }
            } else if (view.getId() == d.g.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new an("c12502").ah("obj_locate", Constants.VIA_REPORT_TYPE_WPA_STATE));
                } else {
                    TiebaStatic.log(new an("c12503").ah("obj_locate", "5"));
                }
                this.fZg.cSt = 34;
                this.fZg.cSu = new Bundle();
                this.fZg.cSu.putSerializable(UserData.TYPE_USER, userData);
            }
            this.gcD.a(view, this.fZg);
        }
    }
}
