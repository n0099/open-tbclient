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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.view.PersonHeaderAttentionView;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.view.t {
    View.OnClickListener aoz;
    com.baidu.tieba.view.q bex;
    private float cjs;
    private boolean czI;
    private ImageView eSd;
    private TextView eSe;
    private TextView eSf;
    private ImageView eSg;

    public t(Context context, boolean z) {
        super(context);
        this.cjs = 360.0f;
        this.aoz = new u(this);
        this.bex = new v(this);
        this.czI = z;
        aWl();
        this.ggn.setVisibility(this.czI ? 0 : 8);
    }

    @Override // com.baidu.tieba.view.t
    public View ata() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.view.t
    public void S(View view) {
        this.ggi = (BdExpandImageView) view.findViewById(r.g.person_polymeric_header_expand_img);
        this.eSd = (ImageView) view.findViewById(r.g.person_polymeric_header_refresh_image);
        this.ggj = (HeadPendantView) view.findViewById(r.g.person_polymeric_header_user_img);
        this.ggk = (TbImageView) view.findViewById(r.g.person_polymeric_header_god_user_icon);
        this.ggl = (UserIconBox) view.findViewById(r.g.person_polymeric_header_user_vip_icon);
        this.ahV = (TextView) view.findViewById(r.g.person_polymeric_header_user_name_txt);
        this.ggo = (TextView) view.findViewById(r.g.seal_prefix_view);
        this.ggm = (UserIconBox) view.findViewById(r.g.person_polymeric_header_label_box);
        this.eSe = (TextView) view.findViewById(r.g.person_polymeric_header_bar_age_txt);
        this.eSg = (ImageView) view.findViewById(r.g.person_polymeric_header_gift);
        this.ggn = (TextView) view.findViewById(r.g.person_polymeric_header_visitor_txt);
        this.eSf = (TextView) view.findViewById(r.g.person_polymeric_header_sign_txt);
        this.ggp = new PersonHeaderAttentionView(this.mContext);
        btr();
    }

    private void aWl() {
        if (!TbadkCoreApplication.m9getInst().isGiftSwitchOn() || TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null || this.czI) {
            this.eSg.setVisibility(8);
        } else {
            this.eSg.setVisibility(0);
        }
    }

    public PersonHeaderAttentionView aWm() {
        return this.ggp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.t
    public void aUY() {
        super.aUY();
        this.ggl.setOnClickListener(this.aoz);
        this.ggm.setOnClickListener(this.aoz);
        this.ggi.setOnClickListener(this.aoz);
        this.ggj.setOnClickListener(this.aoz);
        this.ggn.setOnClickListener(this.aoz);
        this.eSg.setOnClickListener(this.aoz);
        this.ggo.setOnClickListener(this.aoz);
    }

    @Override // com.baidu.tieba.view.t
    public void h(UserData userData) {
        super.h(userData);
        this.eSe.setText(String.format(this.mContext.getString(r.j.person_center_header_bar_age), userData.getTb_age()));
        if (userData.getIsOfficialAccount() == 1) {
            this.eSg.setVisibility(8);
        }
        String intro = userData.getIntro();
        if (StringUtils.isNull(intro)) {
            intro = this.mContext.getString(r.j.no_person_sign);
        }
        if (intro.length() > 45) {
            intro = String.valueOf(intro.substring(0, 45)) + "...";
        }
        if (this.czI) {
            String format = String.format(this.mContext.getString(r.j.person_polymeric_intro), intro);
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.bex, format.length() - 4, format.length(), 33);
            this.eSf.setText(spannableString);
            this.eSf.setMovementMethod(com.baidu.tieba.view.r.bto());
            this.eSf.setHighlightColor(0);
            this.eSf.setLongClickable(false);
            return;
        }
        this.eSf.setText(intro);
    }

    @Override // com.baidu.tieba.view.t
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        at.c(this.ggn, r.d.cp_cont_i, 1);
        at.c(this.eSe, r.d.cp_cont_i_alpha80, 1);
        at.c(this.eSf, r.d.cp_cont_i_alpha40, 1);
        at.c(this.eSg, r.f.icon_mycenter_gift_selector, i);
    }

    public void F(float f) {
        if (!this.eSd.isShown()) {
            this.eSd.setVisibility(0);
            this.eSd.setImageDrawable(this.mContext.getResources().getDrawable(r.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cjs, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.eSd.startAnimation(rotateAnimation);
        this.cjs = f;
    }

    public void agY() {
        this.eSd.clearAnimation();
        this.eSd.setImageDrawable(null);
        this.eSd.setVisibility(8);
    }

    public void kh() {
        if (!this.eSd.isShown()) {
            this.eSd.setVisibility(0);
            this.eSd.setImageDrawable(this.mContext.getResources().getDrawable(r.f.icon_pop_refresh));
        }
        this.eSd.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext, r.a.user_info_center_head_rotate));
    }
}
