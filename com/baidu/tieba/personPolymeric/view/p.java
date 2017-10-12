package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.event.a ffp = new com.baidu.tieba.personPolymeric.event.a();
    protected com.baidu.tieba.view.g fiM;
    private com.baidu.tieba.personPolymeric.c.a fiN;
    private Context mContext;
    private boolean mIsHost;

    public p(Context context) {
        this.mContext = context;
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fiM = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fiN = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fiM != null && this.fiN != null && this.fiN.getUserData() != null) {
            UserData userData = this.fiN.getUserData();
            this.ffp.ceU = -1;
            if (view.getId() == d.h.person_polymeric_header_user_img) {
                TiebaStatic.log(new ak("c12502").ad("obj_locate", "5"));
                this.ffp.ceU = 1;
                this.ffp.ceV = new Bundle();
                this.ffp.ceV.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.h.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new ak("c12502").ad("obj_locate", "6"));
                this.ffp.ceU = 2;
            } else if (view.getId() == d.h.person_polymeric_header_label_box) {
                TiebaStatic.log(new ak("c12502").ad("obj_locate", "4"));
                this.ffp.ceU = 3;
                this.ffp.ceV = new Bundle();
                this.ffp.ceV.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.h.btn_give_gift) {
                TiebaStatic.log(new ak("c12503").ad("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                this.ffp.ceU = 12;
                this.ffp.ceV = new Bundle();
                this.ffp.ceV.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.h.seal_prefix_view) {
                this.ffp.ceU = 13;
            } else if (view.getId() == d.h.person_center_header_tdou_txt || view.getId() == d.h.textview_get_tdou) {
                if (view.getId() == d.h.person_center_header_tdou_txt) {
                    TiebaStatic.log(new ak("c12502").ad("obj_locate", "12"));
                } else if (view.getId() == d.h.textview_get_tdou) {
                    TiebaStatic.log(new ak("c12502").ad("obj_locate", "13"));
                }
                this.ffp.ceU = 14;
            } else if (view.getId() == d.h.person_polymeric_header_user_name_txt || view.getId() == d.h.person_polymeric_header_sign_txt) {
                if (view.getId() == d.h.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new ak("c12502").ad("obj_locate", NewWriteModel.THREAD_TYPE_LBS));
                } else if (view.getId() == d.h.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new ak("c12502").ad("obj_locate", "14"));
                }
                if (this.mIsHost) {
                    this.ffp.ceV = new Bundle();
                    this.ffp.ceV.putSerializable(UserData.TYPE_USER, userData);
                    if (this.fiN != null && this.fiN.fgO != null) {
                        this.ffp.ceV.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.fiN.fgO.left_days.intValue());
                    }
                    this.ffp.ceU = 11;
                }
            } else if (view.getId() == d.h.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new ak("c12502").ad("obj_locate", "15"));
                } else {
                    TiebaStatic.log(new ak("c12503").ad("obj_locate", "5"));
                }
                this.ffp.ceU = 34;
                this.ffp.ceV = new Bundle();
                this.ffp.ceV.putSerializable(UserData.TYPE_USER, userData);
            }
            this.fiM.a(view, this.ffp);
        }
    }
}
