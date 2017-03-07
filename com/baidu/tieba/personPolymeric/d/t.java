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
    View.OnClickListener asD;
    private boolean bch;
    private ImageView bgQ;
    com.baidu.tieba.view.q bux;
    private float ccn;
    private ImageView eIY;
    private TextView eIZ;
    private TextView eJa;
    private View eJb;
    private int eJc;
    private TextView eJd;
    private TextView eJe;
    private Animation eJf;
    private Animation eJg;

    public t(Context context, boolean z) {
        super(context);
        this.eJc = 0;
        this.ccn = 360.0f;
        this.bch = false;
        this.asD = new u(this);
        this.bux = new v(this);
        this.bch = z;
        aRx();
        this.fIA.setVisibility(this.bch ? 0 : 8);
        if (this.eJb != null && this.bch) {
            this.eJb.setVisibility(8);
        }
        if (this.bch) {
            this.eJb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.t
    public View Qz() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void P(View view) {
        this.fIv = (BdExpandImageView) view.findViewById(w.h.person_polymeric_header_expand_img);
        this.eIY = (ImageView) view.findViewById(w.h.person_polymeric_header_refresh_image);
        this.fIw = (HeadPendantView) view.findViewById(w.h.person_polymeric_header_user_img);
        this.fIx = (TbImageView) view.findViewById(w.h.person_polymeric_header_god_user_icon);
        this.fIy = (UserIconBox) view.findViewById(w.h.person_polymeric_header_user_vip_icon);
        this.amc = (TextView) view.findViewById(w.h.person_polymeric_header_user_name_txt);
        this.fIB = (TextView) view.findViewById(w.h.seal_prefix_view);
        this.fIz = (UserIconBox) view.findViewById(w.h.person_polymeric_header_label_box);
        this.eIZ = (TextView) view.findViewById(w.h.person_polymeric_header_bar_age_txt);
        this.bgQ = (ImageView) view.findViewById(w.h.person_polymeric_header_gift);
        this.fIA = (TextView) view.findViewById(w.h.person_polymeric_header_visitor_txt);
        this.eJa = (TextView) view.findViewById(w.h.person_polymeric_header_sign_txt);
        this.eJb = view.findViewById(w.h.person_polymeric_header_alaentry_layout);
        this.fIC = new PersonHeaderAttentionView(this.mContext);
        blI();
        this.eJf = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_fadeout);
        this.eJf.setAnimationListener(new w(this));
        this.eJg = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_easeout);
        this.eJg.setAnimationListener(new x(this));
    }

    private void aRx() {
        if (!TbadkCoreApplication.m9getInst().isGiftSwitchOn() || TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null || this.bch) {
            this.bgQ.setVisibility(8);
        } else {
            this.bgQ.setVisibility(0);
        }
    }

    public PersonHeaderAttentionView aRy() {
        return this.fIC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aQl() {
        super.aQl();
        this.fIy.setOnClickListener(this.asD);
        this.fIz.setOnClickListener(this.asD);
        this.fIv.setOnClickListener(this.asD);
        this.fIw.setOnClickListener(this.asD);
        this.fIA.setOnClickListener(this.asD);
        this.bgQ.setOnClickListener(this.asD);
        this.fIB.setOnClickListener(this.asD);
        this.eJb.setOnClickListener(this.asD);
    }

    @Override // com.baidu.tieba.view.t
    public void f(UserData userData) {
        super.f(userData);
        this.eIZ.setText(String.format(this.mContext.getString(w.l.person_center_header_bar_age), userData.getTb_age()));
        if (userData.getIsOfficialAccount() == 1) {
            this.bgQ.setVisibility(8);
        }
        String intro = userData.getIntro();
        if (StringUtils.isNull(intro)) {
            intro = this.mContext.getString(w.l.no_person_sign);
        }
        if (intro.length() > 45) {
            intro = String.valueOf(intro.substring(0, 45)) + "...";
        }
        if (this.bch) {
            String format = String.format(this.mContext.getString(w.l.person_polymeric_intro), intro);
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.bux, format.length() - 4, format.length(), 33);
            this.eJa.setText(spannableString);
            this.eJa.setMovementMethod(com.baidu.tieba.view.r.blF());
            this.eJa.setHighlightColor(0);
            this.eJa.setLongClickable(false);
        } else {
            this.eJa.setText(intro);
        }
        this.eJd = (TextView) this.eJb.findViewById(w.h.person_polymeric_header_alaentry_status);
        this.eJe = (TextView) this.eJb.findViewById(w.h.person_polymeric_header_alalevel);
        ImageView imageView = (ImageView) this.eJb.findViewById(w.h.person_polymeric_header_livepoint);
        this.eJb.clearAnimation();
        if (userData.getLiveStatus() == 1) {
            this.eJe.setVisibility(8);
            imageView.setVisibility(0);
            this.eJd.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_entry_live));
            this.eJe.setText(Integer.toString(userData.getLiveLevel()));
        } else {
            imageView.setVisibility(8);
            this.eJd.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_live_title));
            this.eJe.setVisibility(0);
            this.eJe.setText(Integer.toString(userData.getLiveLevel()));
        }
        if (this.mUserData.getPersonPrivate().Cn() != 3) {
            if (this.mUserData.getPersonPrivate().Cn() != 2 || this.mUserData.getIsFriend() == 1) {
                this.eJb.setAnimation(this.eJf);
                this.eJf.start();
            }
        }
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.c(this.fIA, w.e.cp_cont_i, 1);
        aq.c(this.eIZ, w.e.cp_cont_i_alpha80, 1);
        aq.c(this.eJa, w.e.cp_cont_i_alpha40, 1);
        aq.c(this.bgQ, w.g.icon_mycenter_gift_selector, i);
    }

    public void F(float f) {
        if (!this.eIY.isShown()) {
            this.eIY.setVisibility(0);
            this.eIY.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.ccn, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.eIY.startAnimation(rotateAnimation);
        this.ccn = f;
    }

    public void ady() {
        this.eIY.clearAnimation();
        this.eIY.setImageDrawable(null);
        this.eIY.setVisibility(8);
    }

    public void kX() {
        if (!this.eIY.isShown()) {
            this.eIY.setVisibility(0);
            this.eIY.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        this.eIY.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, w.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.t
    public void onDestory() {
        if (this.eJd != null) {
            this.eJd.clearAnimation();
        }
    }
}
