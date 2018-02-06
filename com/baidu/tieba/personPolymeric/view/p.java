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
    private com.baidu.tieba.personPolymeric.event.b goc = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.i grI;
    private com.baidu.tieba.personPolymeric.c.a grJ;
    private boolean mIsHost;

    public p(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.i iVar) {
        this.grI = iVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.grJ = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.grI != null && this.grJ != null && this.grJ.getUserData() != null) {
            UserData userData = this.grJ.getUserData();
            this.goc.drx = -1;
            if (view.getId() == d.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new ak("c12502").ab("obj_locate", "5"));
                this.goc.drx = 1;
                this.goc.dry = new Bundle();
                this.goc.dry.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new ak("c12502").ab("obj_locate", "6"));
                this.goc.drx = 2;
            } else if (view.getId() == d.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new ak("c12502").ab("obj_locate", "4"));
                this.goc.drx = 3;
                this.goc.dry = new Bundle();
                this.goc.dry.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.container_send_gift) {
                TiebaStatic.log(new ak("c12503").ab("obj_locate", "3"));
                this.goc.drx = 12;
                this.goc.dry = new Bundle();
                this.goc.dry.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.seal_prefix_view) {
                this.goc.drx = 13;
            } else if (view.getId() == d.g.person_center_header_tdou_txt || view.getId() == d.g.textview_get_tdou) {
                if (view.getId() == d.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view.getId() == d.g.textview_get_tdou) {
                    TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.goc.drx = 14;
            } else if (view.getId() == d.g.person_polymeric_header_user_name_txt || view.getId() == d.g.person_polymeric_header_sign_txt) {
                if (view.getId() == d.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_SHARE_TYPE_PUBLISHMOOD));
                } else if (view.getId() == d.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new ak("c12502").ab("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                }
                if (this.mIsHost) {
                    this.goc.dry = new Bundle();
                    this.goc.dry.putSerializable(UserData.TYPE_USER, userData);
                    if (this.grJ != null && this.grJ.gpD != null) {
                        this.goc.dry.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.grJ.gpD.left_days.intValue());
                    }
                    this.goc.drx = 11;
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
                this.goc.drx = 34;
                this.goc.dry = new Bundle();
                this.goc.dry.putSerializable(UserData.TYPE_USER, userData);
            }
            this.grI.a(view, this.goc);
        }
    }
}
