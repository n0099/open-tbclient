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
    View.OnClickListener asD;
    private ImageView eDf;
    private TextView eDg;

    public a(Context context) {
        super(context);
        this.asD = new b(this);
    }

    @Override // com.baidu.tieba.view.t
    public View Qz() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.item_person_center_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void P(View view) {
        this.fIv = (BdExpandImageView) view.findViewById(w.h.person_center_header_expand_img);
        this.fIw = (HeadPendantView) view.findViewById(w.h.person_center_header_user_img);
        this.fIx = (TbImageView) view.findViewById(w.h.person_center_header_god_user_icon);
        this.eDf = (ImageView) view.findViewById(w.h.person_center_header_jump_person_info_img);
        this.fIy = (UserIconBox) view.findViewById(w.h.person_center_header_user_vip_icon);
        this.amc = (TextView) view.findViewById(w.h.person_center_header_user_name_txt);
        this.fIB = (TextView) view.findViewById(w.h.seal_prefix_view);
        this.fIz = (UserIconBox) view.findViewById(w.h.person_center_header_label_box);
        this.eDg = (TextView) view.findViewById(w.h.person_center_header_tdou_txt);
        this.fIA = (TextView) view.findViewById(w.h.person_center_header_visitor_txt);
        this.fIC = (PersonHeaderAttentionView) view.findViewById(w.h.person_center_header_attention_container);
        blI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aQl() {
        super.aQl();
        this.fIw.setOnClickListener(this.asD);
        this.eDf.setOnClickListener(this.asD);
        this.fIy.setOnClickListener(this.asD);
        this.fIz.setOnClickListener(this.asD);
        this.eDg.setOnClickListener(this.asD);
        this.fIv.setOnClickListener(this.asD);
        this.fIB.setOnClickListener(this.asD);
    }

    @Override // com.baidu.tieba.view.t
    public void f(UserData userData) {
        super.f(userData);
        this.eDg.setText(String.valueOf(au.F(userData.getTDouNum())) + " | " + this.mContext.getString(w.l.get_tdou));
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.c(this.eDg, w.e.white_alpha60, 1);
        aq.c(this.fIA, w.e.cp_cont_i, 1);
        this.eDg.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(w.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
