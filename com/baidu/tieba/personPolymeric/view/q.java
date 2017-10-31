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
    private com.baidu.tieba.personPolymeric.event.a fnr = new com.baidu.tieba.personPolymeric.event.a();
    protected com.baidu.tieba.view.h frg;
    private com.baidu.tieba.personPolymeric.c.a frh;
    private Context mContext;
    private boolean mIsHost;

    public q(Context context) {
        this.mContext = context;
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.h hVar) {
        this.frg = hVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.frh = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.frg != null && this.frh != null && this.frh.getUserData() != null) {
            UserData userData = this.frh.getUserData();
            this.fnr.cmb = -1;
            if (view.getId() == d.g.person_polymeric_header_user_img) {
                TiebaStatic.log(new ak("c12502").ac("obj_locate", "5"));
                this.fnr.cmb = 1;
                this.fnr.cmc = new Bundle();
                this.fnr.cmc.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new ak("c12502").ac("obj_locate", "6"));
                this.fnr.cmb = 2;
            } else if (view.getId() == d.g.person_polymeric_header_label_box) {
                TiebaStatic.log(new ak("c12502").ac("obj_locate", "4"));
                this.fnr.cmb = 3;
                this.fnr.cmc = new Bundle();
                this.fnr.cmc.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.btn_give_gift) {
                TiebaStatic.log(new ak("c12503").ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                this.fnr.cmb = 12;
                this.fnr.cmc = new Bundle();
                this.fnr.cmc.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.g.seal_prefix_view) {
                this.fnr.cmb = 13;
            } else if (view.getId() == d.g.person_center_header_tdou_txt || view.getId() == d.g.textview_get_tdou) {
                if (view.getId() == d.g.person_center_header_tdou_txt) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "12"));
                } else if (view.getId() == d.g.textview_get_tdou) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "13"));
                }
                this.fnr.cmb = 14;
            } else if (view.getId() == d.g.person_polymeric_header_user_name_txt || view.getId() == d.g.person_polymeric_header_sign_txt) {
                if (view.getId() == d.g.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", NewWriteModel.THREAD_TYPE_LBS));
                } else if (view.getId() == d.g.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "14"));
                }
                if (this.mIsHost) {
                    this.fnr.cmc = new Bundle();
                    this.fnr.cmc.putSerializable(UserData.TYPE_USER, userData);
                    if (this.frh != null && this.frh.foY != null) {
                        this.fnr.cmc.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.frh.foY.left_days.intValue());
                    }
                    this.fnr.cmb = 11;
                }
            } else if (view.getId() == d.g.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "15"));
                } else {
                    TiebaStatic.log(new ak("c12503").ac("obj_locate", "5"));
                }
                this.fnr.cmb = 34;
                this.fnr.cmc = new Bundle();
                this.fnr.cmc.putSerializable(UserData.TYPE_USER, userData);
            }
            this.frg.a(view, this.fnr);
        }
    }
}
