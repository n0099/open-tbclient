package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class m implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.event.b fID = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g fMl;
    private com.baidu.tieba.personPolymeric.c.a fMm;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fMl = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fMm = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.fMl != null && this.fMm != null && this.fMm.getUserData() != null) {
            UserData userData = this.fMm.getUserData();
            this.fID.cKc = -1;
            if (view2.getId() == d.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new al("c12502").ac("obj_locate", "5"));
                this.fID.cKc = 1;
                this.fID.cKd = new Bundle();
                this.fID.cKd.putSerializable(UserData.TYPE_USER, userData);
            } else if (view2.getId() == d.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new al("c12502").ac("obj_locate", "6"));
                this.fID.cKc = 2;
            } else if (view2.getId() == d.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new al("c12502").ac("obj_locate", "4"));
                this.fID.cKc = 3;
                this.fID.cKd = new Bundle();
                this.fID.cKd.putSerializable(UserData.TYPE_USER, userData);
            } else if (view2.getId() == d.g.container_send_gift) {
                TiebaStatic.log(new al("c12503").ac("obj_locate", "3"));
                this.fID.cKc = 12;
                this.fID.cKd = new Bundle();
                this.fID.cKd.putSerializable(UserData.TYPE_USER, userData);
            } else if (view2.getId() == d.g.seal_prefix_view) {
                this.fID.cKc = 13;
            } else if (view2.getId() == d.g.person_center_header_tdou_txt || view2.getId() == d.g.textview_get_tdou) {
                if (view2.getId() == d.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view2.getId() == d.g.textview_get_tdou) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.fID.cKc = 14;
            } else if (view2.getId() == d.g.person_polymeric_header_user_name_txt || view2.getId() == d.g.person_polymeric_header_sign_txt) {
                if (view2.getId() == d.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", "7"));
                } else if (view2.getId() == d.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                }
                if (this.mIsHost) {
                    this.fID.cKd = new Bundle();
                    this.fID.cKd.putSerializable(UserData.TYPE_USER, userData);
                    if (this.fMm != null && this.fMm.fKh != null) {
                        this.fID.cKd.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.fMm.fKh.left_days.intValue());
                    }
                    this.fID.cKc = 11;
                } else {
                    view2.requestLayout();
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setMaxLines(2147483646);
                    }
                }
            } else if (view2.getId() == d.g.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_WPA_STATE));
                } else {
                    TiebaStatic.log(new al("c12503").ac("obj_locate", "5"));
                }
                this.fID.cKc = 34;
                this.fID.cKd = new Bundle();
                this.fID.cKd.putSerializable(UserData.TYPE_USER, userData);
            }
            this.fMl.a(view2, this.fID);
        }
    }
}
