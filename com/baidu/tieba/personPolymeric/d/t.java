package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.view.PersonHeaderAttentionView;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.view.t {
    View.OnClickListener anF;
    com.baidu.tieba.view.q bbr;
    private float ceO;
    private boolean cuB;
    private ImageView eLF;
    private TextView eLG;
    private TextView eLH;
    private ImageView eLI;

    public t(Context context, boolean z) {
        super(context);
        this.ceO = 360.0f;
        this.anF = new u(this);
        this.bbr = new v(this);
        this.cuB = z;
        aUe();
        this.fYS.setVisibility(this.cuB ? 0 : 8);
    }

    @Override // com.baidu.tieba.view.t
    public View ard() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void R(View view) {
        this.fYN = (BdExpandImageView) view.findViewById(r.g.person_polymeric_header_expand_img);
        this.eLF = (ImageView) view.findViewById(r.g.person_polymeric_header_refresh_image);
        this.fYO = (HeadPendantView) view.findViewById(r.g.person_polymeric_header_user_img);
        this.fYP = (TbImageView) view.findViewById(r.g.person_polymeric_header_god_user_icon);
        this.fYQ = (UserIconBox) view.findViewById(r.g.person_polymeric_header_user_vip_icon);
        this.ahv = (TextView) view.findViewById(r.g.person_polymeric_header_user_name_txt);
        this.fYR = (UserIconBox) view.findViewById(r.g.person_polymeric_header_label_box);
        this.eLG = (TextView) view.findViewById(r.g.person_polymeric_header_bar_age_txt);
        this.eLI = (ImageView) view.findViewById(r.g.person_polymeric_header_gift);
        this.fYS = (TextView) view.findViewById(r.g.person_polymeric_header_visitor_txt);
        this.eLH = (TextView) view.findViewById(r.g.person_polymeric_header_sign_txt);
        this.fYT = new PersonHeaderAttentionView(this.mContext);
        bqY();
    }

    private void aUe() {
        if (!TbadkCoreApplication.m9getInst().isGiftSwitchOn() || TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null || this.cuB) {
            this.eLI.setVisibility(8);
        } else {
            this.eLI.setVisibility(0);
        }
    }

    public PersonHeaderAttentionView aUf() {
        return this.fYT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aSR() {
        super.aSR();
        this.fYQ.setOnClickListener(this.anF);
        this.fYR.setOnClickListener(this.anF);
        this.fYN.setOnClickListener(this.anF);
        this.fYO.setOnClickListener(this.anF);
        this.fYS.setOnClickListener(this.anF);
        this.eLI.setOnClickListener(this.anF);
    }

    @Override // com.baidu.tieba.view.t
    public void h(UserData userData) {
        super.h(userData);
        this.eLG.setText(String.format(this.mContext.getString(r.j.person_center_header_bar_age), userData.getTb_age()));
        if (userData.getIsOfficialAccount() == 1) {
            this.eLI.setVisibility(8);
        }
        String intro = userData.getIntro();
        if (StringUtils.isNull(intro)) {
            intro = this.mContext.getString(r.j.no_person_sign);
        }
        if (intro.length() > 45) {
            intro = String.valueOf(intro.substring(0, 45)) + "...";
        }
        if (this.cuB) {
            String format = String.format(this.mContext.getString(r.j.person_polymeric_intro), intro);
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.bbr, format.length() - 4, format.length(), 33);
            this.eLH.setText(spannableString);
            this.eLH.setMovementMethod(com.baidu.tieba.view.r.bqV());
            this.eLH.setHighlightColor(0);
            this.eLH.setLongClickable(false);
            return;
        }
        this.eLH.setText(intro);
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.c(this.fYS, r.d.cp_cont_i, 1);
        av.c(this.eLG, r.d.cp_cont_i_alpha80, 1);
        av.c(this.eLH, r.d.cp_cont_i_alpha40, 1);
        av.c(this.eLI, r.f.icon_mycenter_gift_selector, i);
    }

    public void F(float f) {
        if (!this.eLF.isShown()) {
            this.eLF.setVisibility(0);
            this.eLF.setImageDrawable(this.mContext.getResources().getDrawable(r.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.ceO, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.eLF.startAnimation(rotateAnimation);
        this.ceO = f;
    }

    public void afo() {
        this.eLF.clearAnimation();
        this.eLF.setImageDrawable(null);
        this.eLF.setVisibility(8);
    }

    public void kh() {
        if (!this.eLF.isShown()) {
            this.eLF.setVisibility(0);
            this.eLF.setImageDrawable(this.mContext.getResources().getDrawable(r.f.icon_pop_refresh));
        }
        this.eLF.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, r.a.user_info_center_head_rotate));
    }
}
