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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import com.baidu.tieba.w;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.view.x {
    private TbPageContext ajh;
    View.OnClickListener asJ;
    private ImageView bxn;
    private float bxw;
    private TextView eNL;
    private TextView eNM;
    private TextView eNN;
    private TextView eNO;
    private View eNP;
    private View eNQ;
    private TextView eNR;
    private int eNS;
    private TextView eNT;
    private TextView eNU;
    private Animation eNV;
    private Animation eNW;
    private TextView eNX;

    public w(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext.getPageActivity(), z);
        this.bxw = 360.0f;
        this.eNS = 0;
        this.asJ = new x(this);
        this.ajh = tbPageContext;
        TextView textView = this.fQY;
        if (this.beq) {
        }
        textView.setVisibility(8);
        if (this.eNP != null && this.beq) {
            this.eNP.setVisibility(8);
        }
        if (this.eNR != null) {
            this.eNR.setVisibility(this.beq ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.view.x
    public View RG() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.x
    public void N(View view) {
        this.fQT = (BdExpandImageView) view.findViewById(w.h.person_polymeric_header_expand_img);
        this.bxn = (ImageView) view.findViewById(w.h.person_polymeric_header_refresh_image);
        this.fQU = (HeadPendantView) view.findViewById(w.h.person_polymeric_header_user_img);
        this.fQV = (TbImageView) view.findViewById(w.h.person_polymeric_header_god_user_icon);
        this.fQW = (UserIconBox) view.findViewById(w.h.person_polymeric_header_user_vip_icon);
        this.amy = (TextView) view.findViewById(w.h.person_polymeric_header_user_name_txt);
        this.fQZ = (TextView) view.findViewById(w.h.seal_prefix_view);
        this.fQX = (UserIconBox) view.findViewById(w.h.person_polymeric_header_label_box);
        this.eNL = (TextView) view.findViewById(w.h.person_polymeric_header_bar_age_txt);
        this.fQY = (TextView) view.findViewById(w.h.person_polymeric_header_visitor_txt);
        this.eNM = (TextView) view.findViewById(w.h.person_polymeric_header_sign_txt);
        this.eNN = (TextView) view.findViewById(w.h.person_center_header_tdou_txt);
        this.eNO = (TextView) view.findViewById(w.h.space_line);
        this.eNP = view.findViewById(w.h.person_polymeric_header_alaentry_layout_root);
        this.eNQ = view.findViewById(w.h.person_polymeric_header_alaentry_layout);
        this.eNX = (TextView) view.findViewById(w.h.person_praise_number);
        this.eNR = (TextView) view.findViewById(w.h.person_polymeric_header_bigV_entrance);
        this.eNN.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(w.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fRa = (PersonHeaderAttentionView) view.findViewById(w.h.person_center_header_attention_container);
        bmu();
        this.eNV = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_fadeout);
        this.eNV.setAnimationListener(new y(this));
        this.eNW = AnimationUtils.loadAnimation(this.mContext, w.a.user_live_info_easeout);
        this.eNW.setAnimationListener(new z(this));
        this.eNR.setOnClickListener(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.x
    public void TA() {
        super.TA();
        this.fQW.setOnClickListener(this.asJ);
        this.fQX.setOnClickListener(this.asJ);
        this.fQT.setOnClickListener(this.asJ);
        this.fQU.setOnClickListener(this.asJ);
        this.fQY.setOnClickListener(this.asJ);
        this.fQZ.setOnClickListener(this.asJ);
        this.eNN.setOnClickListener(this.asJ);
        this.eNQ.setOnClickListener(this.asJ);
    }

    @Override // com.baidu.tieba.view.x
    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            super.b(aVar);
            this.eNL.setText(String.format(this.mContext.getString(w.l.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.beq) {
                this.eNO.setVisibility(0);
                this.eNN.setVisibility(0);
                this.eNO.setText("|");
                this.eNN.setText(bJ(String.valueOf(au.G(this.mUserData.getTDouNum())) + "   |   " + this.mContext.getString(w.l.get_tdou), "   |   "));
            } else {
                this.eNO.setVisibility(8);
                this.eNN.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                intro = this.mContext.getString(w.l.no_person_sign);
            }
            if (intro.length() > 45) {
                intro = String.valueOf(intro.substring(0, 45)) + "...";
            }
            this.eNM.setText(intro);
            this.eNT = (TextView) this.eNQ.findViewById(w.h.person_polymeric_header_alaentry_status);
            this.eNU = (TextView) this.eNQ.findViewById(w.h.person_polymeric_header_alalevel);
            ImageView imageView = (ImageView) this.eNQ.findViewById(w.h.person_polymeric_header_livepoint);
            this.eNQ.clearAnimation();
            if (this.mUserData.getLiveStatus() == 1) {
                this.eNU.setVisibility(8);
                imageView.setVisibility(0);
                this.eNT.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_entry_live));
                this.eNU.setText(Integer.toString(this.mUserData.getLiveLevel()));
            } else {
                imageView.setVisibility(8);
                this.eNT.setText(this.mContext.getResources().getString(w.l.person_polymeric_ala_live_title));
                this.eNU.setVisibility(0);
                this.eNU.setText(Integer.toString(this.mUserData.getLiveLevel()));
            }
            a(aVar.eMl);
            if (this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().BK() != 3) {
                if (this.mUserData.getPersonPrivate().BK() != 2 || this.mUserData.getIsFriend() == 1) {
                    this.eNQ.setAnimation(this.eNV);
                    this.eNV.start();
                }
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.eNX.setVisibility(8);
            return;
        }
        this.eNX.setVisibility(0);
        String z = au.z(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = aq.getDrawable(w.g.icon_floor_praised);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        this.eNX.setCompoundDrawables(drawable, null, null, null);
        this.eNX.setText(z);
    }

    private SpannableString bJ(String str, String str2) {
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

    @Override // com.baidu.tieba.view.x
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.i(this.eNR, w.e.cp_cont_i);
        aq.c(this.fQY, w.e.cp_cont_i, 1);
        aq.c(this.eNL, w.e.cp_cont_i, 1);
        aq.c(this.eNM, w.e.cp_cont_i_alpha60, 1);
        aq.c(this.eNN, w.e.cp_cont_i, 1);
        aq.c(this.eNO, w.e.cp_cont_i_alpha60, 1);
        aq.i(this.eNX, w.e.cp_cont_i);
        this.eNN.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(w.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = aq.u(i, w.g.icon_floor_praised);
        u.setBounds(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32));
        this.eNX.setCompoundDrawables(u, null, null, null);
    }

    @Override // com.baidu.tieba.view.x
    public void F(float f) {
        if (!this.bxn.isShown()) {
            this.bxn.setVisibility(0);
            this.bxn.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bxw, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.bxn.startAnimation(rotateAnimation);
        this.bxw = f;
    }

    @Override // com.baidu.tieba.view.x
    public void Tx() {
        this.bxn.clearAnimation();
        this.bxn.setImageDrawable(null);
        this.bxn.setVisibility(8);
    }

    @Override // com.baidu.tieba.view.x
    public void lb() {
        if (!this.bxn.isShown()) {
            this.bxn.setVisibility(0);
            this.bxn.setImageDrawable(this.mContext.getResources().getDrawable(w.g.icon_pop_refresh));
        }
        this.bxn.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, w.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.view.x
    public void onDestory() {
        if (this.eNT != null) {
            this.eNT.clearAnimation();
        }
    }
}
