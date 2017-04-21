package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.view.t {
    View.OnClickListener asV;
    private boolean bcY;
    private ImageView biP;
    com.baidu.tieba.view.q bwH;
    private float cdf;
    private ImageView eJj;
    private TextView eJk;
    private TextView eJl;
    private View eJm;
    private int eJn;
    private TextView eJo;
    private TextView eJp;
    private Animation eJq;
    private Animation eJr;

    public t(Context context, boolean z) {
        super(context);
        this.eJn = 0;
        this.cdf = 360.0f;
        this.bcY = false;
        this.asV = new u(this);
        this.bwH = new v(this);
        this.bcY = z;
        aSH();
        this.fMF.setVisibility(this.bcY ? 0 : 8);
        if (this.eJm != null && this.bcY) {
            this.eJm.setVisibility(8);
        }
        if (this.bcY) {
            this.eJm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.t
    public View RZ() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void P(View view) {
        this.fMA = (BdExpandImageView) view.findViewById(w.h.person_polymeric_header_expand_img);
        this.eJj = (ImageView) view.findViewById(w.h.person_polymeric_header_refresh_image);
        this.fMB = (HeadPendantView) view.findViewById(w.h.person_polymeric_header_user_img);
        this.fMC = (TbImageView) view.findViewById(w.h.person_polymeric_header_god_user_icon);
        this.fMD = (UserIconBox) view.findViewById(w.h.person_polymeric_header_user_vip_icon);
        this.amq = (TextView) view.findViewById(w.h.person_polymeric_header_user_name_txt);
        this.fMG = (TextView) view.findViewById(w.h.seal_prefix_view);
        this.fME = (UserIconBox) view.findViewById(w.h.person_polymeric_header_label_box);
        this.eJk = (TextView) view.findViewById(w.h.person_polymeric_header_bar_age_txt);
        this.biP = (ImageView) view.findViewById(w.h.person_polymeric_header_gift);
        this.fMF = (TextView) view.findViewById(w.h.person_polymeric_header_visitor_txt);
        this.eJl = (TextView) view.findViewById(w.h.person_polymeric_header_sign_txt);
        this.eJm = view.findViewById(w.h.person_polymeric_header_alaentry_layout);
        this.fMH = new PersonHeaderAttentionView(this.mContext);
        bnt();
        this.eJq = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_fadeout);
        this.eJq.setAnimationListener(new w(this));
        this.eJr = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_easeout);
        this.eJr.setAnimationListener(new x(this));
    }

    private void aSH() {
        if (!TbadkCoreApplication.m9getInst().isGiftSwitchOn() || TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null || this.bcY) {
            this.biP.setVisibility(8);
        } else {
            this.biP.setVisibility(0);
        }
    }

    public PersonHeaderAttentionView aSI() {
        return this.fMH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aRv() {
        super.aRv();
        this.fMD.setOnClickListener(this.asV);
        this.fME.setOnClickListener(this.asV);
        this.fMA.setOnClickListener(this.asV);
        this.fMB.setOnClickListener(this.asV);
        this.fMF.setOnClickListener(this.asV);
        this.biP.setOnClickListener(this.asV);
        this.fMG.setOnClickListener(this.asV);
        this.eJm.setOnClickListener(this.asV);
    }

    @Override // com.baidu.tieba.view.t
    public void f(UserData userData) {
        super.f(userData);
        this.eJk.setText(String.format(this.mContext.getString(w.l.person_center_header_bar_age), userData.getTb_age()));
        if (userData.getIsOfficialAccount() == 1) {
            this.biP.setVisibility(8);
        }
        String intro = userData.getIntro();
        if (StringUtils.isNull(intro)) {
            intro = this.mContext.getString(w.l.no_person_sign);
        }
        if (intro.length() > 45) {
            intro = String.valueOf(intro.substring(0, 45)) + "...";
        }
        if (this.bcY) {
            String format = String.format(this.mContext.getString(w.l.person_polymeric_intro), intro);
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.bwH, format.length() - 4, format.length(), 33);
            this.eJl.setText(spannableString);
            this.eJl.setMovementMethod(com.baidu.tieba.view.r.bnq());
            this.eJl.setHighlightColor(0);
            this.eJl.setLongClickable(false);
        } else {
            this.eJl.setText(intro);
        }
        this.eJo = (TextView) this.eJm.findViewById(w.h.person_polymeric_header_alaentry_status);
        this.eJp = (TextView) this.eJm.findViewById(w.h.person_polymeric_header_alalevel);
        ImageView imageView = (ImageView) this.eJm.findViewById(w.h.person_polymeric_header_livepoint);
        this.eJm.clearAnimation();
        if (userData.getLiveStatus() == 1) {
            this.eJp.setVisibility(8);
            imageView.setVisibility(0);
            this.eJo.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_entry_live));
            this.eJp.setText(Integer.toString(userData.getLiveLevel()));
        } else {
            imageView.setVisibility(8);
            this.eJo.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_live_title));
            this.eJp.setVisibility(0);
            this.eJp.setText(Integer.toString(userData.getLiveLevel()));
        }
        if (this.mUserData.getPersonPrivate().CL() != 3) {
            if (this.mUserData.getPersonPrivate().CL() != 2 || this.mUserData.getIsFriend() == 1) {
                this.eJm.setAnimation(this.eJq);
                this.eJq.start();
            }
        }
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.c(this.fMF, w.e.cp_cont_i, 1);
        aq.c(this.eJk, w.e.cp_cont_i_alpha80, 1);
        aq.c(this.eJl, w.e.cp_cont_i_alpha40, 1);
        aq.c(this.biP, w.g.icon_mycenter_gift_selector, i);
    }

    public void F(float f) {
        if (!this.eJj.isShown()) {
            this.eJj.setVisibility(0);
            this.eJj.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cdf, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.eJj.startAnimation(rotateAnimation);
        this.cdf = f;
    }

    public void aet() {
        this.eJj.clearAnimation();
        this.eJj.setImageDrawable(null);
        this.eJj.setVisibility(8);
    }

    public void lc() {
        if (!this.eJj.isShown()) {
            this.eJj.setVisibility(0);
            this.eJj.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        this.eJj.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, w.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.t
    public void onDestory() {
        if (this.eJo != null) {
            this.eJo.clearAnimation();
        }
    }
}
