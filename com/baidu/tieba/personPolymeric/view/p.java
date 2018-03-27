package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class p implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.event.b goi = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.i grN;
    private com.baidu.tieba.personPolymeric.c.a grO;
    private boolean mIsHost;

    public p(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.i iVar) {
        this.grN = iVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.grO = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.grN != null && this.grO != null && this.grO.getUserData() != null) {
            UserData userData = this.grO.getUserData();
            this.goi.dro = -1;
            if (view.getId() == d.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new ak("c12502").ab("obj_locate", "5"));
                this.goi.dro = 1;
                this.goi.drp = new Bundle();
                this.goi.drp.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new ak("c12502").ab("obj_locate", "6"));
                this.goi.dro = 2;
            } else if (view.getId() == d.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new ak("c12502").ab("obj_locate", "4"));
                this.goi.dro = 3;
                this.goi.drp = new Bundle();
                this.goi.drp.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.container_send_gift) {
                TiebaStatic.log(new ak("c12503").ab("obj_locate", "3"));
                this.goi.dro = 12;
                this.goi.drp = new Bundle();
                this.goi.drp.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.seal_prefix_view) {
                this.goi.dro = 13;
            } else if (view.getId() == d.g.person_center_header_tdou_txt || view.getId() == d.g.textview_get_tdou) {
                if (view.getId() == d.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == d.g.textview_get_tdou) {
                    TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.goi.dro = 14;
            } else if (view.getId() == d.g.person_polymeric_header_user_name_txt || view.getId() == d.g.person_polymeric_header_sign_txt) {
                if (view.getId() == d.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new ak("c12502").ab("obj_locate", "7"));
                } else if (view.getId() == d.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                }
                if (this.mIsHost) {
                    this.goi.drp = new Bundle();
                    this.goi.drp.putSerializable(UserData.TYPE_USER, userData);
                    if (this.grO != null && this.grO.gpI != null) {
                        this.goi.drp.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.grO.gpI.left_days.intValue());
                    }
                    this.goi.dro = 11;
                } else {
                    view.requestLayout();
                    if (view instanceof TextView) {
                        ((TextView) view).setMaxLines(2147483646);
                    }
                }
            } else if (view.getId() == d.g.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_WPA_STATE));
                } else {
                    TiebaStatic.log(new ak("c12503").ab("obj_locate", "5"));
                }
                this.goi.dro = 34;
                this.goi.drp = new Bundle();
                this.goi.drp.putSerializable(UserData.TYPE_USER, userData);
            }
            this.grN.a(view, this.goi);
        }
    }
}
