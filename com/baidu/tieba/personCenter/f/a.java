package com.baidu.tieba.personCenter.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import com.baidu.tieba.view.t;
/* loaded from: classes.dex */
public class a extends t {
    View.OnClickListener ani;
    private ImageView ezG;
    private TextView ezH;

    public a(Context context) {
        super(context);
        this.ani = new b(this);
    }

    @Override // com.baidu.tieba.view.t
    public View PG() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(r.j.item_person_center_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void R(View view) {
        this.fDU = (BdExpandImageView) view.findViewById(r.h.person_center_header_expand_img);
        this.fDV = (HeadPendantView) view.findViewById(r.h.person_center_header_user_img);
        this.fDW = (TbImageView) view.findViewById(r.h.person_center_header_god_user_icon);
        this.ezG = (ImageView) view.findViewById(r.h.person_center_header_jump_person_info_img);
        this.fDX = (UserIconBox) view.findViewById(r.h.person_center_header_user_vip_icon);
        this.agJ = (TextView) view.findViewById(r.h.person_center_header_user_name_txt);
        this.fEa = (TextView) view.findViewById(r.h.seal_prefix_view);
        this.fDY = (UserIconBox) view.findViewById(r.h.person_center_header_label_box);
        this.ezH = (TextView) view.findViewById(r.h.person_center_header_tdou_txt);
        this.fDZ = (TextView) view.findViewById(r.h.person_center_header_visitor_txt);
        this.fEb = (PersonHeaderAttentionView) view.findViewById(r.h.person_center_header_attention_container);
        blT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aQI() {
        super.aQI();
        this.fDV.setOnClickListener(this.ani);
        this.ezG.setOnClickListener(this.ani);
        this.fDX.setOnClickListener(this.ani);
        this.fDY.setOnClickListener(this.ani);
        this.ezH.setOnClickListener(this.ani);
        this.fDU.setOnClickListener(this.ani);
        this.fEa.setOnClickListener(this.ani);
    }

    @Override // com.baidu.tieba.view.t
    public void f(UserData userData) {
        super.f(userData);
        this.ezH.setText(String.valueOf(at.F(userData.getTDouNum())) + " | " + this.mContext.getString(r.l.get_tdou));
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.c(this.ezH, r.e.white_alpha60, 1);
        ap.c(this.fDZ, r.e.cp_cont_i, 1);
        this.ezH.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(r.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
