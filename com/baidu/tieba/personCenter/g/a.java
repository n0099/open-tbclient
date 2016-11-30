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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import com.baidu.tieba.view.t;
/* loaded from: classes.dex */
public class a extends t {
    View.OnClickListener aoz;
    private ImageView eMn;
    private TextView eMo;

    public a(Context context) {
        super(context);
        this.aoz = new b(this);
    }

    @Override // com.baidu.tieba.view.t
    public View ata() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.item_person_center_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void S(View view) {
        this.ggi = (BdExpandImageView) view.findViewById(r.g.person_center_header_expand_img);
        this.ggj = (HeadPendantView) view.findViewById(r.g.person_center_header_user_img);
        this.ggk = (TbImageView) view.findViewById(r.g.person_center_header_god_user_icon);
        this.eMn = (ImageView) view.findViewById(r.g.person_center_header_jump_person_info_img);
        this.ggl = (UserIconBox) view.findViewById(r.g.person_center_header_user_vip_icon);
        this.ahV = (TextView) view.findViewById(r.g.person_center_header_user_name_txt);
        this.ggo = (TextView) view.findViewById(r.g.seal_prefix_view);
        this.ggm = (UserIconBox) view.findViewById(r.g.person_center_header_label_box);
        this.eMo = (TextView) view.findViewById(r.g.person_center_header_tdou_txt);
        this.ggn = (TextView) view.findViewById(r.g.person_center_header_visitor_txt);
        this.ggp = (PersonHeaderAttentionView) view.findViewById(r.g.person_center_header_attention_container);
        btr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aUY() {
        super.aUY();
        this.ggj.setOnClickListener(this.aoz);
        this.eMn.setOnClickListener(this.aoz);
        this.ggl.setOnClickListener(this.aoz);
        this.ggm.setOnClickListener(this.aoz);
        this.eMo.setOnClickListener(this.aoz);
        this.ggi.setOnClickListener(this.aoz);
        this.ggo.setOnClickListener(this.aoz);
    }

    @Override // com.baidu.tieba.view.t
    public void h(UserData userData) {
        super.h(userData);
        this.eMo.setText(String.valueOf(ax.I(userData.getTDouNum())) + " | " + this.mContext.getString(r.j.self_tdou_get));
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        at.c(this.eMo, r.d.white_alpha60, 1);
        at.c(this.ggn, r.d.cp_cont_i, 1);
        this.eMo.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(r.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
