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
import com.baidu.tieba.t;
import com.baidu.tieba.view.PersonHeaderAttentionView;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.view.t {
    View.OnClickListener anX;
    com.baidu.tieba.view.q bba;
    private float ceP;
    private boolean cue;
    private ImageView eJC;
    private TextView eJD;
    private TextView eJE;
    private ImageView eJF;

    public t(Context context, boolean z) {
        super(context);
        this.ceP = 360.0f;
        this.anX = new u(this);
        this.bba = new v(this);
        this.cue = z;
        aTH();
        this.fWN.setVisibility(this.cue ? 0 : 8);
    }

    @Override // com.baidu.tieba.view.t
    public View aqE() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void R(View view) {
        this.fWI = (BdExpandImageView) view.findViewById(t.g.person_polymeric_header_expand_img);
        this.eJC = (ImageView) view.findViewById(t.g.person_polymeric_header_refresh_image);
        this.fWJ = (HeadPendantView) view.findViewById(t.g.person_polymeric_header_user_img);
        this.fWK = (TbImageView) view.findViewById(t.g.person_polymeric_header_god_user_icon);
        this.fWL = (UserIconBox) view.findViewById(t.g.person_polymeric_header_user_vip_icon);
        this.ahN = (TextView) view.findViewById(t.g.person_polymeric_header_user_name_txt);
        this.fWM = (UserIconBox) view.findViewById(t.g.person_polymeric_header_label_box);
        this.eJD = (TextView) view.findViewById(t.g.person_polymeric_header_bar_age_txt);
        this.eJF = (ImageView) view.findViewById(t.g.person_polymeric_header_gift);
        this.fWN = (TextView) view.findViewById(t.g.person_polymeric_header_visitor_txt);
        this.eJE = (TextView) view.findViewById(t.g.person_polymeric_header_sign_txt);
        this.fWO = new PersonHeaderAttentionView(this.mContext);
        bqt();
    }

    private void aTH() {
        if (!TbadkCoreApplication.m9getInst().isGiftSwitchOn() || TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null || this.cue) {
            this.eJF.setVisibility(8);
        } else {
            this.eJF.setVisibility(0);
        }
    }

    public PersonHeaderAttentionView aTI() {
        return this.fWO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aSt() {
        super.aSt();
        this.fWL.setOnClickListener(this.anX);
        this.fWM.setOnClickListener(this.anX);
        this.fWI.setOnClickListener(this.anX);
        this.fWJ.setOnClickListener(this.anX);
        this.fWN.setOnClickListener(this.anX);
        this.eJF.setOnClickListener(this.anX);
    }

    @Override // com.baidu.tieba.view.t
    public void h(UserData userData) {
        super.h(userData);
        this.eJD.setText(String.format(this.mContext.getString(t.j.person_center_header_bar_age), userData.getTb_age()));
        if (userData.getIsOfficialAccount() == 1) {
            this.eJF.setVisibility(8);
        }
        String intro = userData.getIntro();
        if (StringUtils.isNull(intro)) {
            intro = this.mContext.getString(t.j.no_person_sign);
        }
        if (intro.length() > 45) {
            intro = String.valueOf(intro.substring(0, 45)) + "...";
        }
        if (this.cue) {
            String format = String.format(this.mContext.getString(t.j.person_polymeric_intro), intro);
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.bba, format.length() - 4, format.length(), 33);
            this.eJE.setText(spannableString);
            this.eJE.setMovementMethod(com.baidu.tieba.view.r.bqr());
            this.eJE.setHighlightColor(0);
            this.eJE.setLongClickable(false);
            return;
        }
        this.eJE.setText(intro);
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.c(this.fWN, t.d.cp_cont_i, 1);
        av.c(this.eJD, t.d.cp_cont_i_alpha80, 1);
        av.c(this.eJE, t.d.cp_cont_i_alpha40, 1);
        av.c(this.eJF, t.f.icon_mycenter_gift_selector, i);
    }

    public void F(float f) {
        if (!this.eJC.isShown()) {
            this.eJC.setVisibility(0);
            this.eJC.setImageDrawable(this.mContext.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.ceP, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.eJC.startAnimation(rotateAnimation);
        this.ceP = f;
    }

    public void afa() {
        this.eJC.clearAnimation();
        this.eJC.setImageDrawable(null);
        this.eJC.setVisibility(8);
    }

    public void kh() {
        if (!this.eJC.isShown()) {
            this.eJC.setVisibility(0);
            this.eJC.setImageDrawable(this.mContext.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        this.eJC.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, t.a.user_info_center_head_rotate));
    }
}
