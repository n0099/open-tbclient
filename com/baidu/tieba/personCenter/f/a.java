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
    View.OnClickListener asT;
    private ImageView eBc;
    private TextView eBd;

    public a(Context context) {
        super(context);
        this.asT = new b(this);
    }

    @Override // com.baidu.tieba.view.t
    public View QX() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.item_person_center_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void P(View view) {
        this.fKe = (BdExpandImageView) view.findViewById(w.h.person_center_header_expand_img);
        this.fKf = (HeadPendantView) view.findViewById(w.h.person_center_header_user_img);
        this.fKg = (TbImageView) view.findViewById(w.h.person_center_header_god_user_icon);
        this.eBc = (ImageView) view.findViewById(w.h.person_center_header_jump_person_info_img);
        this.fKh = (UserIconBox) view.findViewById(w.h.person_center_header_user_vip_icon);
        this.amq = (TextView) view.findViewById(w.h.person_center_header_user_name_txt);
        this.fKk = (TextView) view.findViewById(w.h.seal_prefix_view);
        this.fKi = (UserIconBox) view.findViewById(w.h.person_center_header_label_box);
        this.eBd = (TextView) view.findViewById(w.h.person_center_header_tdou_txt);
        this.fKj = (TextView) view.findViewById(w.h.person_center_header_visitor_txt);
        this.fKl = (PersonHeaderAttentionView) view.findViewById(w.h.person_center_header_attention_container);
        bms();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aQu() {
        super.aQu();
        this.fKf.setOnClickListener(this.asT);
        this.eBc.setOnClickListener(this.asT);
        this.fKh.setOnClickListener(this.asT);
        this.fKi.setOnClickListener(this.asT);
        this.eBd.setOnClickListener(this.asT);
        this.fKe.setOnClickListener(this.asT);
        this.fKk.setOnClickListener(this.asT);
    }

    @Override // com.baidu.tieba.view.t
    public void f(UserData userData) {
        super.f(userData);
        this.eBd.setText(String.valueOf(au.F(userData.getTDouNum())) + " | " + this.mContext.getString(w.l.get_tdou));
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.c(this.eBd, w.e.white_alpha60, 1);
        aq.c(this.fKj, w.e.cp_cont_i, 1);
        this.eBd.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(w.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
