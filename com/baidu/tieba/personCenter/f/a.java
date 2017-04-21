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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import com.baidu.tieba.view.t;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends t {
    View.OnClickListener asV;
    private ImageView eDs;
    private TextView eDt;

    public a(Context context) {
        super(context);
        this.asV = new b(this);
    }

    @Override // com.baidu.tieba.view.t
    public View RZ() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.item_person_center_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void P(View view) {
        this.fMA = (BdExpandImageView) view.findViewById(w.h.person_center_header_expand_img);
        this.fMB = (HeadPendantView) view.findViewById(w.h.person_center_header_user_img);
        this.fMC = (TbImageView) view.findViewById(w.h.person_center_header_god_user_icon);
        this.eDs = (ImageView) view.findViewById(w.h.person_center_header_jump_person_info_img);
        this.fMD = (UserIconBox) view.findViewById(w.h.person_center_header_user_vip_icon);
        this.amq = (TextView) view.findViewById(w.h.person_center_header_user_name_txt);
        this.fMG = (TextView) view.findViewById(w.h.seal_prefix_view);
        this.fME = (UserIconBox) view.findViewById(w.h.person_center_header_label_box);
        this.eDt = (TextView) view.findViewById(w.h.person_center_header_tdou_txt);
        this.fMF = (TextView) view.findViewById(w.h.person_center_header_visitor_txt);
        this.fMH = (PersonHeaderAttentionView) view.findViewById(w.h.person_center_header_attention_container);
        bnt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aRv() {
        super.aRv();
        this.fMB.setOnClickListener(this.asV);
        this.eDs.setOnClickListener(this.asV);
        this.fMD.setOnClickListener(this.asV);
        this.fME.setOnClickListener(this.asV);
        this.eDt.setOnClickListener(this.asV);
        this.fMA.setOnClickListener(this.asV);
        this.fMG.setOnClickListener(this.asV);
    }

    @Override // com.baidu.tieba.view.t
    public void f(UserData userData) {
        super.f(userData);
        this.eDt.setText(String.valueOf(au.F(userData.getTDouNum())) + " | " + this.mContext.getString(w.l.get_tdou));
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.c(this.eDt, w.e.white_alpha60, 1);
        aq.c(this.fMF, w.e.cp_cont_i, 1);
        this.eDt.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(w.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
