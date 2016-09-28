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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import com.baidu.tieba.view.t;
/* loaded from: classes.dex */
public class a extends t {
    View.OnClickListener anF;
    private ImageView eFO;
    private TextView eFP;

    public a(Context context) {
        super(context);
        this.anF = new b(this);
    }

    @Override // com.baidu.tieba.view.t
    public View ard() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.item_person_center_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void R(View view) {
        this.fYN = (BdExpandImageView) view.findViewById(r.g.person_center_header_expand_img);
        this.fYO = (HeadPendantView) view.findViewById(r.g.person_center_header_user_img);
        this.fYP = (TbImageView) view.findViewById(r.g.person_center_header_god_user_icon);
        this.eFO = (ImageView) view.findViewById(r.g.person_center_header_jump_person_info_img);
        this.fYQ = (UserIconBox) view.findViewById(r.g.person_center_header_user_vip_icon);
        this.ahv = (TextView) view.findViewById(r.g.person_center_header_user_name_txt);
        this.fYR = (UserIconBox) view.findViewById(r.g.person_center_header_label_box);
        this.eFP = (TextView) view.findViewById(r.g.person_center_header_tdou_txt);
        this.fYS = (TextView) view.findViewById(r.g.person_center_header_visitor_txt);
        this.fYT = (PersonHeaderAttentionView) view.findViewById(r.g.person_center_header_attention_container);
        bqY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aSR() {
        super.aSR();
        this.fYO.setOnClickListener(this.anF);
        this.eFO.setOnClickListener(this.anF);
        this.fYQ.setOnClickListener(this.anF);
        this.fYR.setOnClickListener(this.anF);
        this.eFP.setOnClickListener(this.anF);
        this.fYN.setOnClickListener(this.anF);
    }

    @Override // com.baidu.tieba.view.t
    public void h(UserData userData) {
        super.h(userData);
        this.eFP.setText(String.valueOf(az.J(userData.getTDouNum())) + " | " + this.mContext.getString(r.j.self_tdou_get));
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.c(this.eFP, r.d.white_alpha60, 1);
        av.c(this.fYS, r.d.cp_cont_i, 1);
        this.eFP.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(r.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
