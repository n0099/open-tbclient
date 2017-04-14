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
    View.OnClickListener asT;
    private boolean bca;
    private ImageView bgK;
    com.baidu.tieba.view.q bup;
    private float caO;
    private ImageView eGT;
    private TextView eGU;
    private TextView eGV;
    private View eGW;
    private int eGX;
    private TextView eGY;
    private TextView eGZ;
    private Animation eHa;
    private Animation eHb;

    public t(Context context, boolean z) {
        super(context);
        this.eGX = 0;
        this.caO = 360.0f;
        this.bca = false;
        this.asT = new u(this);
        this.bup = new v(this);
        this.bca = z;
        aRG();
        this.fKj.setVisibility(this.bca ? 0 : 8);
        if (this.eGW != null && this.bca) {
            this.eGW.setVisibility(8);
        }
        if (this.bca) {
            this.eGW.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.t
    public View QX() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void P(View view) {
        this.fKe = (BdExpandImageView) view.findViewById(w.h.person_polymeric_header_expand_img);
        this.eGT = (ImageView) view.findViewById(w.h.person_polymeric_header_refresh_image);
        this.fKf = (HeadPendantView) view.findViewById(w.h.person_polymeric_header_user_img);
        this.fKg = (TbImageView) view.findViewById(w.h.person_polymeric_header_god_user_icon);
        this.fKh = (UserIconBox) view.findViewById(w.h.person_polymeric_header_user_vip_icon);
        this.amq = (TextView) view.findViewById(w.h.person_polymeric_header_user_name_txt);
        this.fKk = (TextView) view.findViewById(w.h.seal_prefix_view);
        this.fKi = (UserIconBox) view.findViewById(w.h.person_polymeric_header_label_box);
        this.eGU = (TextView) view.findViewById(w.h.person_polymeric_header_bar_age_txt);
        this.bgK = (ImageView) view.findViewById(w.h.person_polymeric_header_gift);
        this.fKj = (TextView) view.findViewById(w.h.person_polymeric_header_visitor_txt);
        this.eGV = (TextView) view.findViewById(w.h.person_polymeric_header_sign_txt);
        this.eGW = view.findViewById(w.h.person_polymeric_header_alaentry_layout);
        this.fKl = new PersonHeaderAttentionView(this.mContext);
        bms();
        this.eHa = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_fadeout);
        this.eHa.setAnimationListener(new w(this));
        this.eHb = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_easeout);
        this.eHb.setAnimationListener(new x(this));
    }

    private void aRG() {
        if (!TbadkCoreApplication.m9getInst().isGiftSwitchOn() || TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null || this.bca) {
            this.bgK.setVisibility(8);
        } else {
            this.bgK.setVisibility(0);
        }
    }

    public PersonHeaderAttentionView aRH() {
        return this.fKl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aQu() {
        super.aQu();
        this.fKh.setOnClickListener(this.asT);
        this.fKi.setOnClickListener(this.asT);
        this.fKe.setOnClickListener(this.asT);
        this.fKf.setOnClickListener(this.asT);
        this.fKj.setOnClickListener(this.asT);
        this.bgK.setOnClickListener(this.asT);
        this.fKk.setOnClickListener(this.asT);
        this.eGW.setOnClickListener(this.asT);
    }

    @Override // com.baidu.tieba.view.t
    public void f(UserData userData) {
        super.f(userData);
        this.eGU.setText(String.format(this.mContext.getString(w.l.person_center_header_bar_age), userData.getTb_age()));
        if (userData.getIsOfficialAccount() == 1) {
            this.bgK.setVisibility(8);
        }
        String intro = userData.getIntro();
        if (StringUtils.isNull(intro)) {
            intro = this.mContext.getString(w.l.no_person_sign);
        }
        if (intro.length() > 45) {
            intro = String.valueOf(intro.substring(0, 45)) + "...";
        }
        if (this.bca) {
            String format = String.format(this.mContext.getString(w.l.person_polymeric_intro), intro);
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.bup, format.length() - 4, format.length(), 33);
            this.eGV.setText(spannableString);
            this.eGV.setMovementMethod(com.baidu.tieba.view.r.bmp());
            this.eGV.setHighlightColor(0);
            this.eGV.setLongClickable(false);
        } else {
            this.eGV.setText(intro);
        }
        this.eGY = (TextView) this.eGW.findViewById(w.h.person_polymeric_header_alaentry_status);
        this.eGZ = (TextView) this.eGW.findViewById(w.h.person_polymeric_header_alalevel);
        ImageView imageView = (ImageView) this.eGW.findViewById(w.h.person_polymeric_header_livepoint);
        this.eGW.clearAnimation();
        if (userData.getLiveStatus() == 1) {
            this.eGZ.setVisibility(8);
            imageView.setVisibility(0);
            this.eGY.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_entry_live));
            this.eGZ.setText(Integer.toString(userData.getLiveLevel()));
        } else {
            imageView.setVisibility(8);
            this.eGY.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_live_title));
            this.eGZ.setVisibility(0);
            this.eGZ.setText(Integer.toString(userData.getLiveLevel()));
        }
        if (this.mUserData.getPersonPrivate().CL() != 3) {
            if (this.mUserData.getPersonPrivate().CL() != 2 || this.mUserData.getIsFriend() == 1) {
                this.eGW.setAnimation(this.eHa);
                this.eHa.start();
            }
        }
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.c(this.fKj, w.e.cp_cont_i, 1);
        aq.c(this.eGU, w.e.cp_cont_i_alpha80, 1);
        aq.c(this.eGV, w.e.cp_cont_i_alpha40, 1);
        aq.c(this.bgK, w.g.icon_mycenter_gift_selector, i);
    }

    public void F(float f) {
        if (!this.eGT.isShown()) {
            this.eGT.setVisibility(0);
            this.eGT.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.caO, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.eGT.startAnimation(rotateAnimation);
        this.caO = f;
    }

    public void ads() {
        this.eGT.clearAnimation();
        this.eGT.setImageDrawable(null);
        this.eGT.setVisibility(8);
    }

    public void lb() {
        if (!this.eGT.isShown()) {
            this.eGT.setVisibility(0);
            this.eGT.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        this.eGT.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, w.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.t
    public void onDestory() {
        if (this.eGY != null) {
            this.eGY.clearAnimation();
        }
    }
}
