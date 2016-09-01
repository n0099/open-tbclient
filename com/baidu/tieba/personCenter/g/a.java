package com.baidu.tieba.personCenter.g;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import com.baidu.tieba.view.t;
/* loaded from: classes.dex */
public class a extends t {
    View.OnClickListener anX;
    private ImageView eDK;
    private TextView eDL;

    public a(Context context) {
        super(context);
        this.anX = new b(this);
    }

    @Override // com.baidu.tieba.view.t
    public View aqE() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.item_person_center_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void R(View view) {
        this.fWI = (BdExpandImageView) view.findViewById(t.g.person_center_header_expand_img);
        this.fWJ = (HeadPendantView) view.findViewById(t.g.person_center_header_user_img);
        this.fWK = (TbImageView) view.findViewById(t.g.person_center_header_god_user_icon);
        this.eDK = (ImageView) view.findViewById(t.g.person_center_header_jump_person_info_img);
        this.fWL = (UserIconBox) view.findViewById(t.g.person_center_header_user_vip_icon);
        this.ahN = (TextView) view.findViewById(t.g.person_center_header_user_name_txt);
        this.fWM = (UserIconBox) view.findViewById(t.g.person_center_header_label_box);
        this.eDL = (TextView) view.findViewById(t.g.person_center_header_tdou_txt);
        this.fWN = (TextView) view.findViewById(t.g.person_center_header_visitor_txt);
        this.fWO = (PersonHeaderAttentionView) view.findViewById(t.g.person_center_header_attention_container);
        bqt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aSt() {
        super.aSt();
        this.fWJ.setOnClickListener(this.anX);
        this.eDK.setOnClickListener(this.anX);
        this.fWL.setOnClickListener(this.anX);
        this.fWM.setOnClickListener(this.anX);
        this.eDL.setOnClickListener(this.anX);
        this.fWI.setOnClickListener(this.anX);
    }

    @Override // com.baidu.tieba.view.t
    public void h(UserData userData) {
        super.h(userData);
        this.eDL.setText(String.valueOf(ba.I(userData.getTDouNum())) + " | " + this.mContext.getString(t.j.self_tdou_get));
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.c(this.eDL, t.d.white_alpha60, 1);
        av.c(this.fWN, t.d.cp_cont_i, 1);
        this.eDL.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(t.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
