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
    private com.baidu.tieba.personPolymeric.event.b fIG = new com.baidu.tieba.personPolymeric.event.b();
    protected com.baidu.tieba.view.g fMo;
    private com.baidu.tieba.personPolymeric.c.a fMp;
    private boolean mIsHost;

    public m(Context context) {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fMo = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fMp = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.fMo != null && this.fMp != null && this.fMp.getUserData() != null) {
            UserData userData = this.fMp.getUserData();
            this.fIG.cKf = -1;
            if (view2.getId() == d.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new al("c12502").ac("obj_locate", "5"));
                this.fIG.cKf = 1;
                this.fIG.cKg = new Bundle();
                this.fIG.cKg.putSerializable(UserData.TYPE_USER, userData);
            } else if (view2.getId() == d.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new al("c12502").ac("obj_locate", "6"));
                this.fIG.cKf = 2;
            } else if (view2.getId() == d.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new al("c12502").ac("obj_locate", "4"));
                this.fIG.cKf = 3;
                this.fIG.cKg = new Bundle();
                this.fIG.cKg.putSerializable(UserData.TYPE_USER, userData);
            } else if (view2.getId() == d.g.container_send_gift) {
                TiebaStatic.log(new al("c12503").ac("obj_locate", "3"));
                this.fIG.cKf = 12;
                this.fIG.cKg = new Bundle();
                this.fIG.cKg.putSerializable(UserData.TYPE_USER, userData);
            } else if (view2.getId() == d.g.seal_prefix_view) {
                this.fIG.cKf = 13;
            } else if (view2.getId() == d.g.person_center_header_tdou_txt || view2.getId() == d.g.textview_get_tdou) {
                if (view2.getId() == d.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR));
                } else if (view2.getId() == d.g.textview_get_tdou) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                }
                this.fIG.cKf = 14;
            } else if (view2.getId() == d.g.person_polymeric_header_user_name_txt || view2.getId() == d.g.person_polymeric_header_sign_txt) {
                if (view2.getId() == d.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", "7"));
                } else if (view2.getId() == d.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new al("c12502").ac("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                }
                if (this.mIsHost) {
                    this.fIG.cKg = new Bundle();
                    this.fIG.cKg.putSerializable(UserData.TYPE_USER, userData);
                    if (this.fMp != null && this.fMp.fKk != null) {
                        this.fIG.cKg.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.fMp.fKk.left_days.intValue());
                    }
                    this.fIG.cKf = 11;
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
                this.fIG.cKf = 34;
                this.fIG.cKg = new Bundle();
                this.fIG.cKg.putSerializable(UserData.TYPE_USER, userData);
            }
            this.fMo.a(view2, this.fIG);
        }
    }
}
