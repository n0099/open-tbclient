package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.view.w {
    View.OnClickListener asZ;
    private boolean bdp;
    private ImageView bjm;
    private float caS;
    private ImageView eEW;
    private TextView eEX;
    private TextView eEY;
    private TextView eEZ;
    private TextView eFa;
    private View eFb;
    private int eFc;
    private TextView eFd;
    private TextView eFe;
    private Animation eFf;
    private Animation eFg;

    public w(Context context, boolean z) {
        super(context);
        this.caS = 360.0f;
        this.bdp = false;
        this.eFc = 0;
        this.asZ = new x(this);
        this.bdp = z;
        TextView textView = this.fJr;
        if (this.bdp) {
        }
        textView.setVisibility(8);
        aQc();
        if (this.eFb != null && this.bdp) {
            this.eFb.setVisibility(8);
        }
        if (this.bdp) {
            this.eFb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.w
    public View Ru() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.w
    public void O(View view) {
        this.fJm = (BdExpandImageView) view.findViewById(w.h.person_polymeric_header_expand_img);
        this.eEW = (ImageView) view.findViewById(w.h.person_polymeric_header_refresh_image);
        this.fJn = (HeadPendantView) view.findViewById(w.h.person_polymeric_header_user_img);
        this.bjm = (ImageView) view.findViewById(w.h.person_polymeric_header_gift);
        this.fJo = (TbImageView) view.findViewById(w.h.person_polymeric_header_god_user_icon);
        this.fJp = (UserIconBox) view.findViewById(w.h.person_polymeric_header_user_vip_icon);
        this.amB = (TextView) view.findViewById(w.h.person_polymeric_header_user_name_txt);
        this.fJs = (TextView) view.findViewById(w.h.seal_prefix_view);
        this.fJq = (UserIconBox) view.findViewById(w.h.person_polymeric_header_label_box);
        this.eEX = (TextView) view.findViewById(w.h.person_polymeric_header_bar_age_txt);
        this.fJr = (TextView) view.findViewById(w.h.person_polymeric_header_visitor_txt);
        this.eEY = (TextView) view.findViewById(w.h.person_polymeric_header_sign_txt);
        this.eEZ = (TextView) view.findViewById(w.h.person_center_header_tdou_txt);
        this.eFa = (TextView) view.findViewById(w.h.space_line);
        this.eFb = view.findViewById(w.h.person_polymeric_header_alaentry_layout);
        this.eEZ.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(w.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fJt = (PersonHeaderAttentionView) view.findViewById(w.h.person_center_header_attention_container);
        bkY();
        this.eFf = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_fadeout);
        this.eFf.setAnimationListener(new y(this));
        this.eFg = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_easeout);
        this.eFg.setAnimationListener(new z(this));
    }

    private void aQc() {
        if (!TbadkCoreApplication.m9getInst().isGiftSwitchOn() || TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null || this.bdp) {
            this.bjm.setVisibility(8);
        } else {
            this.bjm.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.w
    public void aQd() {
        super.aQd();
        this.fJp.setOnClickListener(this.asZ);
        this.fJq.setOnClickListener(this.asZ);
        this.bjm.setOnClickListener(this.asZ);
        this.fJm.setOnClickListener(this.asZ);
        this.fJn.setOnClickListener(this.asZ);
        this.fJr.setOnClickListener(this.asZ);
        this.fJs.setOnClickListener(this.asZ);
        this.eEZ.setOnClickListener(this.asZ);
        this.eFb.setOnClickListener(this.asZ);
    }

    @Override // com.baidu.tieba.view.w
    public void d(UserData userData) {
        super.d(userData);
        this.eEX.setText(String.format(this.mContext.getString(w.l.person_center_header_bar_age), userData.getTb_age()));
        if (this.bdp) {
            this.eFa.setVisibility(0);
            this.eEZ.setVisibility(0);
            this.eFa.setText("|");
            this.eEZ.setText(bL(String.valueOf(au.G(userData.getTDouNum())) + "   |   " + this.mContext.getString(w.l.get_tdou), "   |   "));
        } else {
            this.eFa.setVisibility(8);
            this.eEZ.setVisibility(8);
        }
        if (userData.getIsOfficialAccount() == 1) {
            this.bjm.setVisibility(8);
        }
        String intro = userData.getIntro();
        if (StringUtils.isNull(intro)) {
            intro = this.mContext.getString(w.l.no_person_sign);
        }
        if (intro.length() > 45) {
            intro = String.valueOf(intro.substring(0, 45)) + "...";
        }
        this.eEY.setText(intro);
        this.eFd = (TextView) this.eFb.findViewById(w.h.person_polymeric_header_alaentry_status);
        this.eFe = (TextView) this.eFb.findViewById(w.h.person_polymeric_header_alalevel);
        ImageView imageView = (ImageView) this.eFb.findViewById(w.h.person_polymeric_header_livepoint);
        this.eFb.clearAnimation();
        if (userData.getLiveStatus() == 1) {
            this.eFe.setVisibility(8);
            imageView.setVisibility(0);
            this.eFd.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_entry_live));
            this.eFe.setText(Integer.toString(userData.getLiveLevel()));
        } else {
            imageView.setVisibility(8);
            this.eFd.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_live_title));
            this.eFe.setVisibility(0);
            this.eFe.setText(Integer.toString(userData.getLiveLevel()));
        }
        if (this.mUserData.getPersonPrivate().BQ() != 3) {
            if (this.mUserData.getPersonPrivate().BQ() != 2 || this.mUserData.getIsFriend() == 1) {
                this.eFb.setAnimation(this.eFf);
                this.eFf.start();
            }
        }
    }

    private SpannableString bL(String str, String str2) {
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        if (str2 != null && str.contains(str2)) {
            int indexOf = str.indexOf(str2);
            spannableString.setSpan(new ForegroundColorSpan(aq.getColor(w.e.cp_cont_i_alpha60)), indexOf, str2.length() + indexOf, 17);
            return spannableString;
        }
        return spannableString;
    }

    @Override // com.baidu.tieba.view.w
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.c(this.fJr, w.e.cp_cont_i, 1);
        aq.c(this.eEX, w.e.cp_cont_i, 1);
        aq.c(this.eEY, w.e.cp_cont_i_alpha60, 1);
        aq.c(this.eEZ, w.e.cp_cont_i, 1);
        aq.c(this.eFa, w.e.cp_cont_i_alpha60, 1);
        aq.c(this.bjm, w.g.icon_mycenter_gift_selector, i);
        this.eEZ.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(w.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void F(float f) {
        if (!this.eEW.isShown()) {
            this.eEW.setVisibility(0);
            this.eEW.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.caS, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.eEW.startAnimation(rotateAnimation);
        this.caS = f;
    }

    public void acw() {
        this.eEW.clearAnimation();
        this.eEW.setImageDrawable(null);
        this.eEW.setVisibility(8);
    }

    public void lb() {
        if (!this.eEW.isShown()) {
            this.eEW.setVisibility(0);
            this.eEW.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        this.eEW.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, w.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.w
    public void onDestory() {
        if (this.eFd != null) {
            this.eFd.clearAnimation();
        }
    }
}
