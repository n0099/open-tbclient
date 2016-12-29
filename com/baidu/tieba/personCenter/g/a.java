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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import com.baidu.tieba.view.t;
/* loaded from: classes.dex */
public class a extends t {
    View.OnClickListener aob;
    private ImageView epJ;
    private TextView epK;

    public a(Context context) {
        super(context);
        this.aob = new b(this);
    }

    @Override // com.baidu.tieba.view.t
    public View anz() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.item_person_center_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void S(View view) {
        this.fva = (BdExpandImageView) view.findViewById(r.g.person_center_header_expand_img);
        this.fvb = (HeadPendantView) view.findViewById(r.g.person_center_header_user_img);
        this.fvc = (TbImageView) view.findViewById(r.g.person_center_header_god_user_icon);
        this.epJ = (ImageView) view.findViewById(r.g.person_center_header_jump_person_info_img);
        this.fvd = (UserIconBox) view.findViewById(r.g.person_center_header_user_vip_icon);
        this.ahw = (TextView) view.findViewById(r.g.person_center_header_user_name_txt);
        this.fvg = (TextView) view.findViewById(r.g.seal_prefix_view);
        this.fve = (UserIconBox) view.findViewById(r.g.person_center_header_label_box);
        this.epK = (TextView) view.findViewById(r.g.person_center_header_tdou_txt);
        this.fvf = (TextView) view.findViewById(r.g.person_center_header_visitor_txt);
        this.fvh = (PersonHeaderAttentionView) view.findViewById(r.g.person_center_header_attention_container);
        bkr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aOI() {
        super.aOI();
        this.fvb.setOnClickListener(this.aob);
        this.epJ.setOnClickListener(this.aob);
        this.fvd.setOnClickListener(this.aob);
        this.fve.setOnClickListener(this.aob);
        this.epK.setOnClickListener(this.aob);
        this.fva.setOnClickListener(this.aob);
        this.fvg.setOnClickListener(this.aob);
    }

    @Override // com.baidu.tieba.view.t
    public void f(UserData userData) {
        super.f(userData);
        this.epK.setText(String.valueOf(av.H(userData.getTDouNum())) + " | " + this.mContext.getString(r.j.self_tdou_get));
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ar.c(this.epK, r.d.white_alpha60, 1);
        ar.c(this.fvf, r.d.cp_cont_i, 1);
        this.epK.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(r.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
