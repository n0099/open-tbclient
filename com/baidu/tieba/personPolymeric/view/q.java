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
public class q implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.event.a fnO = new com.baidu.tieba.personPolymeric.event.a();
    protected com.baidu.tieba.view.h frE;
    private com.baidu.tieba.personPolymeric.c.a frF;
    private Context mContext;
    private boolean mIsHost;

    public q(Context context) {
        this.mContext = context;
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.h hVar) {
        this.frE = hVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.frF = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.frE != null && this.frF != null && this.frF.getUserData() != null) {
            UserData userData = this.frF.getUserData();
            this.fnO.cmv = -1;
            if (view.getId() == d.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new ak("c12502").ac("obj_locate", "5"));
                this.fnO.cmv = 1;
                this.fnO.cmw = new Bundle();
                this.fnO.cmw.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new ak("c12502").ac("obj_locate", "6"));
                this.fnO.cmv = 2;
            } else if (view.getId() == d.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new ak("c12502").ac("obj_locate", "4"));
                this.fnO.cmv = 3;
                this.fnO.cmw = new Bundle();
                this.fnO.cmw.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.btn_give_gift) {
                TiebaStatic.log(new ak("c12503").ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                this.fnO.cmv = 12;
                this.fnO.cmw = new Bundle();
                this.fnO.cmw.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.seal_prefix_view) {
                this.fnO.cmv = 13;
            } else if (view.getId() == d.g.person_center_header_tdou_txt || view.getId() == d.g.textview_get_tdou) {
                if (view.getId() == d.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "12"));
                } else if (view.getId() == d.g.textview_get_tdou) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "13"));
                }
                this.fnO.cmv = 14;
            } else if (view.getId() == d.g.person_polymeric_header_user_name_txt || view.getId() == d.g.person_polymeric_header_sign_txt) {
                if (view.getId() == d.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", NewWriteModel.THREAD_TYPE_LBS));
                } else if (view.getId() == d.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "14"));
                }
                if (this.mIsHost) {
                    this.fnO.cmw = new Bundle();
                    this.fnO.cmw.putSerializable(UserData.TYPE_USER, userData);
                    if (this.frF != null && this.frF.fpw != null) {
                        this.fnO.cmw.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.frF.fpw.left_days.intValue());
                    }
                    this.fnO.cmv = 11;
                }
            } else if (view.getId() == d.g.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "15"));
                } else {
                    TiebaStatic.log(new ak("c12503").ac("obj_locate", "5"));
                }
                this.fnO.cmv = 34;
                this.fnO.cmw = new Bundle();
                this.fnO.cmw.putSerializable(UserData.TYPE_USER, userData);
            }
            this.frE.a(view, this.fnO);
        }
    }
}
