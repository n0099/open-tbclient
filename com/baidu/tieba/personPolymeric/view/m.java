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
    private com.baidu.tieba.personPolymeric.event.b fJJ = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g fNr;
    private com.baidu.tieba.personPolymeric.c.a fNs;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fNr = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fNs = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.fNr != null && this.fNs != null && this.fNs.getUserData() != null) {
            UserData userData = this.fNs.getUserData();
            this.fJJ.cLl = -1;
            if (view2.getId() == d.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new al("c12502").ac("obj_locate", "5"));
                this.fJJ.cLl = 1;
                this.fJJ.cLm = new Bundle();
                this.fJJ.cLm.putSerializable(UserData.TYPE_USER, userData);
            } else if (view2.getId() == d.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new al("c12502").ac("obj_locate", "6"));
                this.fJJ.cLl = 2;
            } else if (view2.getId() == d.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new al("c12502").ac("obj_locate", "4"));
                this.fJJ.cLl = 3;
                this.fJJ.cLm = new Bundle();
                this.fJJ.cLm.putSerializable(UserData.TYPE_USER, userData);
            } else if (view2.getId() == d.g.container_send_gift) {
                TiebaStatic.log(new al("c12503").ac("obj_locate", "3"));
                this.fJJ.cLl = 12;
                this.fJJ.cLm = new Bundle();
                this.fJJ.cLm.putSerializable(UserData.TYPE_USER, userData);
            } else if (view2.getId() == d.g.seal_prefix_view) {
                this.fJJ.cLl = 13;
            } else if (view2.getId() == d.g.person_center_header_tdou_txt || view2.getId() == d.g.textview_get_tdou) {
                if (view2.getId() == d.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view2.getId() == d.g.textview_get_tdou) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.fJJ.cLl = 14;
            } else if (view2.getId() == d.g.person_polymeric_header_user_name_txt || view2.getId() == d.g.person_polymeric_header_sign_txt) {
                if (view2.getId() == d.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", "7"));
                } else if (view2.getId() == d.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                }
                if (this.mIsHost) {
                    this.fJJ.cLm = new Bundle();
                    this.fJJ.cLm.putSerializable(UserData.TYPE_USER, userData);
                    if (this.fNs != null && this.fNs.fLn != null) {
                        this.fJJ.cLm.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.fNs.fLn.left_days.intValue());
                    }
                    this.fJJ.cLl = 11;
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
                this.fJJ.cLl = 34;
                this.fJJ.cLm = new Bundle();
                this.fJJ.cLm.putSerializable(UserData.TYPE_USER, userData);
            }
            this.fNr.a(view2, this.fJJ);
        }
    }
}
