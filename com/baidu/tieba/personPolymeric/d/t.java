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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.view.PersonHeaderAttentionView;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.view.t {
    private boolean aVU;
    View.OnClickListener ani;
    private float bUV;
    private ImageView baf;
    com.baidu.tieba.view.q bnC;
    private int eFA;
    private TextView eFB;
    private TextView eFC;
    private Animation eFD;
    private Animation eFE;
    private ImageView eFw;
    private TextView eFx;
    private TextView eFy;
    private View eFz;

    public t(Context context, boolean z) {
        super(context);
        this.eFA = 0;
        this.bUV = 360.0f;
        this.aVU = false;
        this.ani = new u(this);
        this.bnC = new v(this);
        this.aVU = z;
        aRU();
        this.fDZ.setVisibility(this.aVU ? 0 : 8);
        if (this.eFz != null && this.aVU) {
            this.eFz.setVisibility(8);
        }
        if (this.aVU) {
            this.eFz.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.t
    public View PG() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(r.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void R(View view) {
        this.fDU = (BdExpandImageView) view.findViewById(r.h.person_polymeric_header_expand_img);
        this.eFw = (ImageView) view.findViewById(r.h.person_polymeric_header_refresh_image);
        this.fDV = (HeadPendantView) view.findViewById(r.h.person_polymeric_header_user_img);
        this.fDW = (TbImageView) view.findViewById(r.h.person_polymeric_header_god_user_icon);
        this.fDX = (UserIconBox) view.findViewById(r.h.person_polymeric_header_user_vip_icon);
        this.agJ = (TextView) view.findViewById(r.h.person_polymeric_header_user_name_txt);
        this.fEa = (TextView) view.findViewById(r.h.seal_prefix_view);
        this.fDY = (UserIconBox) view.findViewById(r.h.person_polymeric_header_label_box);
        this.eFx = (TextView) view.findViewById(r.h.person_polymeric_header_bar_age_txt);
        this.baf = (ImageView) view.findViewById(r.h.person_polymeric_header_gift);
        this.fDZ = (TextView) view.findViewById(r.h.person_polymeric_header_visitor_txt);
        this.eFy = (TextView) view.findViewById(r.h.person_polymeric_header_sign_txt);
        this.eFz = view.findViewById(r.h.person_polymeric_header_alaentry_layout);
        this.fEb = new PersonHeaderAttentionView(this.mContext);
        blT();
        this.eFD = AnimationUtils.loadAnimation(this.mContext, r.a.user_live_info_fadeout);
        this.eFD.setAnimationListener(new w(this));
        this.eFE = AnimationUtils.loadAnimation(this.mContext, r.a.user_live_info_easeout);
        this.eFE.setAnimationListener(new x(this));
    }

    private void aRU() {
        if (!TbadkCoreApplication.m9getInst().isGiftSwitchOn() || TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null || this.aVU) {
            this.baf.setVisibility(8);
        } else {
            this.baf.setVisibility(0);
        }
    }

    public PersonHeaderAttentionView aRV() {
        return this.fEb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aQI() {
        super.aQI();
        this.fDX.setOnClickListener(this.ani);
        this.fDY.setOnClickListener(this.ani);
        this.fDU.setOnClickListener(this.ani);
        this.fDV.setOnClickListener(this.ani);
        this.fDZ.setOnClickListener(this.ani);
        this.baf.setOnClickListener(this.ani);
        this.fEa.setOnClickListener(this.ani);
        this.eFz.setOnClickListener(this.ani);
    }

    @Override // com.baidu.tieba.view.t
    public void f(UserData userData) {
        super.f(userData);
        this.eFx.setText(String.format(this.mContext.getString(r.l.person_center_header_bar_age), userData.getTb_age()));
        if (userData.getIsOfficialAccount() == 1) {
            this.baf.setVisibility(8);
        }
        String intro = userData.getIntro();
        if (StringUtils.isNull(intro)) {
            intro = this.mContext.getString(r.l.no_person_sign);
        }
        if (intro.length() > 45) {
            intro = String.valueOf(intro.substring(0, 45)) + "...";
        }
        if (this.aVU) {
            String format = String.format(this.mContext.getString(r.l.person_polymeric_intro), intro);
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.bnC, format.length() - 4, format.length(), 33);
            this.eFy.setText(spannableString);
            this.eFy.setMovementMethod(com.baidu.tieba.view.r.blQ());
            this.eFy.setHighlightColor(0);
            this.eFy.setLongClickable(false);
        } else {
            this.eFy.setText(intro);
        }
        this.eFB = (TextView) this.eFz.findViewById(r.h.person_polymeric_header_alaentry_status);
        this.eFC = (TextView) this.eFz.findViewById(r.h.person_polymeric_header_alalevel);
        ImageView imageView = (ImageView) this.eFz.findViewById(r.h.person_polymeric_header_livepoint);
        this.eFz.clearAnimation();
        if (userData.getLiveStatus() == 1) {
            this.eFC.setVisibility(8);
            imageView.setVisibility(0);
            this.eFB.setText(this.mContext.getResources().getString(r.l.person_polymeric_ala_entry_live));
            this.eFC.setText(Integer.toString(userData.getLiveLevel()));
        } else {
            imageView.setVisibility(8);
            this.eFB.setText(this.mContext.getResources().getString(r.l.person_polymeric_ala_live_title));
            this.eFC.setVisibility(0);
            this.eFC.setText(Integer.toString(userData.getLiveLevel()));
        }
        if (this.mUserData.getPersonPrivate().BU() != 3) {
            if (this.mUserData.getPersonPrivate().BU() != 2 || this.mUserData.getIsFriend() == 1) {
                this.eFz.setAnimation(this.eFD);
                this.eFD.start();
            }
        }
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.c(this.fDZ, r.e.cp_cont_i, 1);
        ap.c(this.eFx, r.e.cp_cont_i_alpha80, 1);
        ap.c(this.eFy, r.e.cp_cont_i_alpha40, 1);
        ap.c(this.baf, r.g.icon_mycenter_gift_selector, i);
    }

    public void F(float f) {
        if (!this.eFw.isShown()) {
            this.eFw.setVisibility(0);
            this.eFw.setImageDrawable(this.mContext.getResources().getDrawable(r.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bUV, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.eFw.startAnimation(rotateAnimation);
        this.bUV = f;
    }

    public void acA() {
        this.eFw.clearAnimation();
        this.eFw.setImageDrawable(null);
        this.eFw.setVisibility(8);
    }

    public void kd() {
        if (!this.eFw.isShown()) {
            this.eFw.setVisibility(0);
            this.eFw.setImageDrawable(this.mContext.getResources().getDrawable(r.g.icon_pop_refresh));
        }
        this.eFw.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, r.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.t
    public void onDestory() {
        if (this.eFB != null) {
            this.eFB.clearAnimation();
        }
    }
}
