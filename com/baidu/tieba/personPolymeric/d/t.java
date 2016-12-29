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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.view.PersonHeaderAttentionView;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.view.t {
    View.OnClickListener aob;
    private float bOy;
    com.baidu.tieba.view.q bdO;
    private boolean ceV;
    private ImageView evC;
    private TextView evD;
    private TextView evE;
    private ImageView evF;

    public t(Context context, boolean z) {
        super(context);
        this.bOy = 360.0f;
        this.aob = new u(this);
        this.bdO = new v(this);
        this.ceV = z;
        aPV();
        this.fvf.setVisibility(this.ceV ? 0 : 8);
    }

    @Override // com.baidu.tieba.view.t
    public View anz() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void S(View view) {
        this.fva = (BdExpandImageView) view.findViewById(r.g.person_polymeric_header_expand_img);
        this.evC = (ImageView) view.findViewById(r.g.person_polymeric_header_refresh_image);
        this.fvb = (HeadPendantView) view.findViewById(r.g.person_polymeric_header_user_img);
        this.fvc = (TbImageView) view.findViewById(r.g.person_polymeric_header_god_user_icon);
        this.fvd = (UserIconBox) view.findViewById(r.g.person_polymeric_header_user_vip_icon);
        this.ahw = (TextView) view.findViewById(r.g.person_polymeric_header_user_name_txt);
        this.fvg = (TextView) view.findViewById(r.g.seal_prefix_view);
        this.fve = (UserIconBox) view.findViewById(r.g.person_polymeric_header_label_box);
        this.evD = (TextView) view.findViewById(r.g.person_polymeric_header_bar_age_txt);
        this.evF = (ImageView) view.findViewById(r.g.person_polymeric_header_gift);
        this.fvf = (TextView) view.findViewById(r.g.person_polymeric_header_visitor_txt);
        this.evE = (TextView) view.findViewById(r.g.person_polymeric_header_sign_txt);
        this.fvh = new PersonHeaderAttentionView(this.mContext);
        bkr();
    }

    private void aPV() {
        if (!TbadkCoreApplication.m9getInst().isGiftSwitchOn() || TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null || this.ceV) {
            this.evF.setVisibility(8);
        } else {
            this.evF.setVisibility(0);
        }
    }

    public PersonHeaderAttentionView aPW() {
        return this.fvh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aOI() {
        super.aOI();
        this.fvd.setOnClickListener(this.aob);
        this.fve.setOnClickListener(this.aob);
        this.fva.setOnClickListener(this.aob);
        this.fvb.setOnClickListener(this.aob);
        this.fvf.setOnClickListener(this.aob);
        this.evF.setOnClickListener(this.aob);
        this.fvg.setOnClickListener(this.aob);
    }

    @Override // com.baidu.tieba.view.t
    public void f(UserData userData) {
        super.f(userData);
        this.evD.setText(String.format(this.mContext.getString(r.j.person_center_header_bar_age), userData.getTb_age()));
        if (userData.getIsOfficialAccount() == 1) {
            this.evF.setVisibility(8);
        }
        String intro = userData.getIntro();
        if (StringUtils.isNull(intro)) {
            intro = this.mContext.getString(r.j.no_person_sign);
        }
        if (intro.length() > 45) {
            intro = String.valueOf(intro.substring(0, 45)) + "...";
        }
        if (this.ceV) {
            String format = String.format(this.mContext.getString(r.j.person_polymeric_intro), intro);
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.bdO, format.length() - 4, format.length(), 33);
            this.evE.setText(spannableString);
            this.evE.setMovementMethod(com.baidu.tieba.view.r.bko());
            this.evE.setHighlightColor(0);
            this.evE.setLongClickable(false);
            return;
        }
        this.evE.setText(intro);
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ar.c(this.fvf, r.d.cp_cont_i, 1);
        ar.c(this.evD, r.d.cp_cont_i_alpha80, 1);
        ar.c(this.evE, r.d.cp_cont_i_alpha40, 1);
        ar.c(this.evF, r.f.icon_mycenter_gift_selector, i);
    }

    public void F(float f) {
        if (!this.evC.isShown()) {
            this.evC.setVisibility(0);
            this.evC.setImageDrawable(this.mContext.getResources().getDrawable(r.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bOy, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.evC.startAnimation(rotateAnimation);
        this.bOy = f;
    }

    public void abt() {
        this.evC.clearAnimation();
        this.evC.setImageDrawable(null);
        this.evC.setVisibility(8);
    }

    public void kh() {
        if (!this.evC.isShown()) {
            this.evC.setVisibility(0);
            this.evC.setImageDrawable(this.mContext.getResources().getDrawable(r.f.icon_pop_refresh));
        }
        this.evC.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, r.a.user_info_center_head_rotate));
    }
}
