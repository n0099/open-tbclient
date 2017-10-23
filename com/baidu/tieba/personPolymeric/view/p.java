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
    private com.baidu.tieba.personPolymeric.event.a ffb = new com.baidu.tieba.personPolymeric.event.a();
    protected com.baidu.tieba.view.g fiy;
    private com.baidu.tieba.personPolymeric.c.a fiz;
    private Context mContext;
    private boolean mIsHost;

    public p(Context context) {
        this.mContext = context;
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fiy = gVar;
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fiz = aVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fiy != null && this.fiz != null && this.fiz.getUserData() != null) {
            UserData userData = this.fiz.getUserData();
            this.ffb.ceI = -1;
            if (view.getId() == d.h.person_polymeric_header_user_img) {
                TiebaStatic.log(new ak("c12502").ac("obj_locate", "5"));
                this.ffb.ceI = 1;
                this.ffb.ceJ = new Bundle();
                this.ffb.ceJ.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.h.person_polymeric_header_user_vip_icon) {
                TiebaStatic.log(new ak("c12502").ac("obj_locate", "6"));
                this.ffb.ceI = 2;
            } else if (view.getId() == d.h.person_polymeric_header_label_box) {
                TiebaStatic.log(new ak("c12502").ac("obj_locate", "4"));
                this.ffb.ceI = 3;
                this.ffb.ceJ = new Bundle();
                this.ffb.ceJ.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.h.btn_give_gift) {
                TiebaStatic.log(new ak("c12503").ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                this.ffb.ceI = 12;
                this.ffb.ceJ = new Bundle();
                this.ffb.ceJ.putSerializable(UserData.TYPE_USER, userData);
            } else if (view.getId() == d.h.seal_prefix_view) {
                this.ffb.ceI = 13;
            } else if (view.getId() == d.h.person_center_header_tdou_txt || view.getId() == d.h.textview_get_tdou) {
                if (view.getId() == d.h.person_center_header_tdou_txt) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "12"));
                } else if (view.getId() == d.h.textview_get_tdou) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "13"));
                }
                this.ffb.ceI = 14;
            } else if (view.getId() == d.h.person_polymeric_header_user_name_txt || view.getId() == d.h.person_polymeric_header_sign_txt) {
                if (view.getId() == d.h.person_polymeric_header_user_name_txt) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", NewWriteModel.THREAD_TYPE_LBS));
                } else if (view.getId() == d.h.person_polymeric_header_sign_txt) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "14"));
                }
                if (this.mIsHost) {
                    this.ffb.ceJ = new Bundle();
                    this.ffb.ceJ.putSerializable(UserData.TYPE_USER, userData);
                    if (this.fiz != null && this.fiz.fgA != null) {
                        this.ffb.ceJ.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, this.fiz.fgA.left_days.intValue());
                    }
                    this.ffb.ceI = 11;
                }
            } else if (view.getId() == d.h.layout_gift) {
                if (this.mIsHost) {
                    TiebaStatic.log(new ak("c12502").ac("obj_locate", "15"));
                } else {
                    TiebaStatic.log(new ak("c12503").ac("obj_locate", "5"));
                }
                this.ffb.ceI = 34;
                this.ffb.ceJ = new Bundle();
                this.ffb.ceJ.putSerializable(UserData.TYPE_USER, userData);
            }
            this.fiy.a(view, this.ffb);
        }
    }
}
