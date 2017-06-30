package com.baidu.tieba.personPolymeric.d;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import com.baidu.tieba.w;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.view.x {
    private TbPageContext ajP;
    View.OnClickListener atM;
    private float cpu;
    private ImageView eXU;
    private TextView eXV;
    private TextView eXW;
    private TextView eXX;
    private TextView eXY;
    private View eXZ;
    private View eYa;
    private TextView eYb;
    private int eYc;
    private TextView eYd;
    private TextView eYe;
    private Animation eYf;
    private Animation eYg;
    private TextView eYh;

    public w(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity(), z);
        this.cpu = 360.0f;
        this.eYc = 0;
        this.atM = new x(this);
        this.ajP = tbPageContext;
        TextView textView = this.gaZ;
        if (this.bhl) {
        }
        textView.setVisibility(8);
        if (this.eXZ != null && this.bhl) {
            this.eXZ.setVisibility(8);
        }
        if (this.eYb != null) {
            this.eYb.setVisibility(this.bhl ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.x
    public View Tv() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.x
    public void O(View view) {
        this.gaU = (BdExpandImageView) view.findViewById(w.h.person_polymeric_header_expand_img);
        this.eXU = (ImageView) view.findViewById(w.h.person_polymeric_header_refresh_image);
        this.gaV = (HeadPendantView) view.findViewById(w.h.person_polymeric_header_user_img);
        this.gaW = (TbImageView) view.findViewById(w.h.person_polymeric_header_god_user_icon);
        this.gaX = (UserIconBox) view.findViewById(w.h.person_polymeric_header_user_vip_icon);
        this.anw = (TextView) view.findViewById(w.h.person_polymeric_header_user_name_txt);
        this.gba = (TextView) view.findViewById(w.h.seal_prefix_view);
        this.gaY = (UserIconBox) view.findViewById(w.h.person_polymeric_header_label_box);
        this.eXV = (TextView) view.findViewById(w.h.person_polymeric_header_bar_age_txt);
        this.gaZ = (TextView) view.findViewById(w.h.person_polymeric_header_visitor_txt);
        this.eXW = (TextView) view.findViewById(w.h.person_polymeric_header_sign_txt);
        this.eXX = (TextView) view.findViewById(w.h.person_center_header_tdou_txt);
        this.eXY = (TextView) view.findViewById(w.h.space_line);
        this.eXZ = view.findViewById(w.h.person_polymeric_header_alaentry_layout_root);
        this.eYa = view.findViewById(w.h.person_polymeric_header_alaentry_layout);
        this.eYh = (TextView) view.findViewById(w.h.person_praise_number);
        this.eYb = (TextView) view.findViewById(w.h.person_polymeric_header_bigV_entrance);
        this.eXX.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(w.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gbb = (PersonHeaderAttentionView) view.findViewById(w.h.person_center_header_attention_container);
        bqE();
        this.eYf = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_fadeout);
        this.eYf.setAnimationListener(new y(this));
        this.eYg = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_easeout);
        this.eYg.setAnimationListener(new z(this));
        this.eYb.setOnClickListener(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.x
    public void adm() {
        super.adm();
        this.gaX.setOnClickListener(this.atM);
        this.gaY.setOnClickListener(this.atM);
        this.gaU.setOnClickListener(this.atM);
        this.gaV.setOnClickListener(this.atM);
        this.gaZ.setOnClickListener(this.atM);
        this.gba.setOnClickListener(this.atM);
        this.eXX.setOnClickListener(this.atM);
        this.eYa.setOnClickListener(this.atM);
        this.anw.setOnClickListener(this.atM);
        this.eXW.setOnClickListener(this.atM);
    }

    @Override // com.baidu.tieba.view.x
    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            super.e(aVar);
            this.eXV.setText(String.format(this.mContext.getString(w.l.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.bhl) {
                this.eXY.setVisibility(0);
                this.eXX.setVisibility(0);
                this.eXY.setText("|");
                this.eXX.setText(bN(String.valueOf(aw.H(this.mUserData.getTDouNum())) + "   |   " + this.mContext.getString(w.l.get_tdou), "   |   "));
            } else {
                this.eXY.setVisibility(8);
                this.eXX.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                intro = this.mContext.getString(w.l.no_person_sign);
            }
            if (intro.length() > 45) {
                intro = String.valueOf(intro.substring(0, 45)) + "...";
            }
            this.eXW.setText(intro);
            this.eYd = (TextView) this.eYa.findViewById(w.h.person_polymeric_header_alaentry_status);
            this.eYe = (TextView) this.eYa.findViewById(w.h.person_polymeric_header_alalevel);
            ImageView imageView = (ImageView) this.eYa.findViewById(w.h.person_polymeric_header_livepoint);
            this.eYa.clearAnimation();
            if (this.mUserData.getLiveStatus() == 1) {
                this.eYe.setVisibility(8);
                imageView.setVisibility(0);
                this.eYd.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_entry_live));
                this.eYe.setText(Integer.toString(this.mUserData.getLiveLevel()));
            } else {
                imageView.setVisibility(8);
                this.eYd.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_live_title));
                this.eYe.setVisibility(0);
                this.eYe.setText(Integer.toString(this.mUserData.getLiveLevel()));
            }
            a(aVar.eWt);
            if (this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Ce() != 3) {
                if (this.mUserData.getPersonPrivate().Ce() != 2 || this.mUserData.getIsFriend() == 1) {
                    this.eYa.setAnimation(this.eYf);
                    this.eYf.start();
                }
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.eYh.setVisibility(8);
            return;
        }
        this.eYh.setVisibility(0);
        String A = aw.A(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = as.getDrawable(w.g.icon_floor_praised);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        this.eYh.setCompoundDrawables(drawable, null, null, null);
        this.eYh.setText(A);
    }

    private SpannableString bN(String str, String str2) {
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        if (str2 != null && str.contains(str2)) {
            int indexOf = str.indexOf(str2);
            spannableString.setSpan(new ForegroundColorSpan(as.getColor(w.e.cp_cont_i_alpha60)), indexOf, str2.length() + indexOf, 17);
            return spannableString;
        }
        return spannableString;
    }

    @Override // com.baidu.tieba.view.x
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        as.i(this.eYb, w.e.cp_cont_i);
        as.c(this.gaZ, w.e.cp_cont_i, 1);
        as.c(this.eXV, w.e.cp_cont_i, 1);
        as.c(this.eXW, w.e.cp_cont_i_alpha60, 1);
        as.c(this.eXX, w.e.cp_cont_i, 1);
        as.c(this.eXY, w.e.cp_cont_i_alpha60, 1);
        as.i(this.eYh, w.e.cp_cont_i);
        this.eXX.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(w.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = as.u(i, w.g.icon_floor_praised);
        u.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        this.eYh.setCompoundDrawables(u, null, null, null);
    }

    @Override // com.baidu.tieba.view.x
    public void F(float f) {
        if (!this.eXU.isShown()) {
            this.eXU.setVisibility(0);
            this.eXU.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cpu, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.eXU.startAnimation(rotateAnimation);
        this.cpu = f;
    }

    @Override // com.baidu.tieba.view.x
    public void ahs() {
        this.eXU.clearAnimation();
        this.eXU.setImageDrawable(null);
        this.eXU.setVisibility(8);
    }

    @Override // com.baidu.tieba.view.x
    public void kZ() {
        if (!this.eXU.isShown()) {
            this.eXU.setVisibility(0);
            this.eXU.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        this.eXU.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, w.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.x
    public void onDestory() {
        if (this.eYd != null) {
            this.eYd.clearAnimation();
        }
    }
}
