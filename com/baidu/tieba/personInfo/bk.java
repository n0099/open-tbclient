package com.baidu.tieba.personInfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bk extends a {
    private View bWM;
    private BaseFragmentActivity bgI;
    private TextView boH;
    private ImageView boI;
    private TextView cJr;
    private boolean ciS;
    private TextView dei;
    private HeadImageView dlQ;
    private TextView dlS;
    private ImageView eBA;
    private LinearLayout eBB;
    private ImageView eBC;
    private LinearLayout eBD;
    private TextView eBE;
    private TextView eBF;
    private ImageView eBG;
    private BdExpandImageView eBl;
    private ImageView eBm;
    private RelativeLayout eBn;
    private UserIconBox eBo;
    private TextView eBp;
    private ImageView eBq;
    private TextView eBr;
    private TextView eBs;
    private LinearLayout eBt;
    private UserIconBox eBu;
    private LinearLayout eBv;
    private LinearLayout eBw;
    private LinearLayout eBx;
    private ImageView eBy;
    private LinearLayout eBz;
    private h epz;
    private TextView etO;
    private View mRootView;
    private float bTH = 360.0f;
    private int eBH = 12;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aBq = new bl(this);
    View.OnClickListener eBI = new bm(this);

    public bk(h hVar, boolean z) {
        this.epz = hVar;
        this.bgI = hVar.getBaseFragmentActivity();
        this.ciS = z;
        this.mRootView = LayoutInflater.from(this.bgI.getPageContext().getPageActivity()).inflate(u.h.personinfo_head_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bWM = this.mRootView.findViewById(u.g.root);
        this.eBl = (BdExpandImageView) this.mRootView.findViewById(u.g.expand_image);
        this.eBm = (ImageView) this.mRootView.findViewById(u.g.refresh_image);
        this.eBn = (RelativeLayout) this.mRootView.findViewById(u.g.head);
        this.dlQ = (HeadImageView) this.mRootView.findViewById(u.g.user_head);
        this.dlQ.setContentDescription(this.epz.getResources().getString(u.j.my_portrait));
        this.eBo = (UserIconBox) this.mRootView.findViewById(u.g.user_vip_icon);
        this.eBv = (LinearLayout) this.mRootView.findViewById(u.g.yinji_wrapper);
        this.eBw = (LinearLayout) this.mRootView.findViewById(u.g.sign_wrapper);
        this.eBw.setOnClickListener(this.epz);
        this.eBv.setOnClickListener(this.epz);
        this.eBo.setOnClickListener(this.epz);
        this.eBl.setOnClickListener(this.epz);
        this.dlS = (TextView) this.mRootView.findViewById(u.g.user_name);
        this.eBp = (TextView) this.mRootView.findViewById(u.g.user_signs);
        this.eBt = (LinearLayout) this.mRootView.findViewById(u.g.user_age_wrapper);
        this.eBq = (ImageView) this.mRootView.findViewById(u.g.user_sex);
        this.eBr = (TextView) this.mRootView.findViewById(u.g.user_bar_age);
        this.eBs = (TextView) this.mRootView.findViewById(u.g.user_bar_age_num);
        this.eBu = (UserIconBox) this.mRootView.findViewById(u.g.user_icon);
        this.eBu.setOnClickListener(this.epz);
        this.boH = (TextView) this.mRootView.findViewById(u.g.btn_attention);
        this.boI = (ImageView) this.mRootView.findViewById(u.g.follow_icon);
        this.eBx = (LinearLayout) this.mRootView.findViewById(u.g.btn_attention_wrapper);
        this.eBx.setOnClickListener(this.epz);
        this.eBB = (LinearLayout) this.mRootView.findViewById(u.g.my_gift_ll);
        this.eBB.setOnClickListener(this.epz);
        this.eBC = (ImageView) this.mRootView.findViewById(u.g.my_gift);
        this.etO = (TextView) this.mRootView.findViewById(u.g.my_tdou_value);
        this.eBD = (LinearLayout) this.mRootView.findViewById(u.g.personinfo_tdou_wrapper);
        this.eBE = (TextView) this.mRootView.findViewById(u.g.my_tdou_get);
        this.eBF = (TextView) this.mRootView.findViewById(u.g.tdou_divider);
        this.eBG = (ImageView) this.mRootView.findViewById(u.g.my_tdou_arrow);
        aOk();
        aOl();
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setBackBitmap(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.CP().eD(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.bgI.getApplicationContext(), u.f.pic_mycenter_bg_def);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.bgI.getApplicationContext(), u.f.pic_mycenter_bg_def, options);
            }
            if (logoBitmap != null) {
                this.eBl.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.dF().a(bg_pic, 10, this.aBq, 0, 0, null, new Object[0]);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aOj() {
        if (this.dlQ != null) {
            this.dlQ.CM();
        }
        this.eBl.setImageBitmap(null);
    }

    private void aOk() {
        if (TbadkCoreApplication.m10getInst().isGiftSwitchOn()) {
            this.eBB.setVisibility(0);
        } else {
            this.eBB.setVisibility(8);
        }
        if (TbadkCoreApplication.m10getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.eBB.setVisibility(8);
        }
        if (this.ciS) {
            this.eBB.setVisibility(8);
            this.eBx.setVisibility(8);
            return;
        }
        this.eBD.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void kT() {
        com.baidu.tbadk.core.util.av.l(this.bWM, u.d.cp_bg_line_c);
        UserData userData = this.epz.aPe().getUserData();
        if (userData != null) {
            if (userData.getIsMem() > 0) {
                this.dlS.setTextColor(this.bgI.getResources().getColor(u.d.cp_other_b));
            } else {
                this.dlS.setTextColor(this.bgI.getResources().getColor(u.d.cp_cont_g));
            }
        } else {
            this.dlS.setTextColor(this.bgI.getResources().getColor(u.d.cp_cont_g));
        }
        if (userData != null) {
            if (!TextUtils.isEmpty(userData.getIntro())) {
                com.baidu.tbadk.core.util.av.c(this.eBp, u.d.cp_cont_f, 1);
            } else {
                com.baidu.tbadk.core.util.av.c(this.eBp, u.d.cp_cont_d, 1);
            }
        } else {
            com.baidu.tbadk.core.util.av.c(this.eBp, u.d.cp_cont_d, 1);
        }
        this.eBr.setTextColor(this.bgI.getResources().getColor(u.d.cp_cont_g));
        this.eBs.setTextColor(this.bgI.getResources().getColor(u.d.cp_cont_g));
        com.baidu.tbadk.core.util.av.k(this.eBB, u.f.personinfo_head_icon);
        com.baidu.tbadk.core.util.av.c(this.eBC, u.f.icon_mycenter_gift);
        if (userData != null) {
            if (userData.getHave_attention() == 1) {
                com.baidu.tbadk.core.util.av.k(this.eBx, u.f.btn_pop_news);
                com.baidu.tbadk.core.util.av.c(this.boH, u.d.cp_link_tip_c, 1);
            } else {
                com.baidu.tbadk.core.util.av.k(this.eBx, u.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.av.k(this.boI, u.f.icon_person_add_n);
                com.baidu.tbadk.core.util.av.c(this.boH, u.d.cp_cont_i, 1);
            }
        } else {
            com.baidu.tbadk.core.util.av.k(this.eBx, u.f.personinfo_follow_btn);
            com.baidu.tbadk.core.util.av.k(this.boI, u.f.icon_person_add_n);
            com.baidu.tbadk.core.util.av.c(this.boH, u.d.cp_cont_i, 1);
        }
        com.baidu.tbadk.core.util.av.c(this.dei, u.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.av.c(this.cJr, u.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.av.k(this.eBy, u.f.icon_mycenter_bar_site);
        com.baidu.tbadk.core.util.av.k(this.eBA, u.f.icon_mycenter_bar_date);
        com.baidu.tbadk.core.util.av.k(this.eBv, u.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.av.k(this.eBw, u.d.cp_bg_line_d);
        this.etO.setCompoundDrawablesWithIntrinsicBounds(this.bgI.getResources().getDrawable(u.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void aOl() {
        this.dlQ.setIsRound(true);
        this.dlQ.setDrawBorder(false);
        this.dlQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dlQ.setOnClickListener(this.epz);
    }

    @Override // com.baidu.tieba.personInfo.a
    public HeadImageView getHeadImage() {
        return this.dlQ;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getUserIcon() {
        return this.eBu;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setGiftIcon(boolean z) {
        if (this.eBC != null) {
            if (z) {
                com.baidu.tbadk.core.util.av.c(this.eBC, u.f.icon_mycenter_gift_open);
            } else {
                com.baidu.tbadk.core.util.av.c(this.eBC, u.f.icon_mycenter_gift);
            }
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public void t(float f) {
        if (!this.eBm.isShown()) {
            this.eBm.setVisibility(0);
            this.eBm.setImageDrawable(this.bgI.getResources().getDrawable(u.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bTH, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.eBm.startAnimation(rotateAnimation);
        this.bTH = f;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aap() {
        this.eBm.clearAnimation();
        this.eBm.setImageDrawable(null);
        this.eBm.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void jm() {
        if (!this.eBm.isShown()) {
            this.eBm.setVisibility(0);
            this.eBm.setImageDrawable(this.bgI.getResources().getDrawable(u.f.icon_pop_refresh));
        }
        this.eBm.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.bgI.getPageContext().getPageActivity(), u.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void RP() {
        bn aPe = this.epz.aPe();
        UserData userData = aPe.getUserData();
        setBackBitmap(userData);
        i(userData);
        h(userData);
        aPe.aPD();
    }

    public void h(UserData userData) {
        if (!aOm()) {
            this.eBD.setVisibility(8);
            return;
        }
        if (this.ciS) {
            this.eBD.setVisibility(0);
        } else {
            this.eBD.setVisibility(8);
        }
        if (userData != null) {
            long tDouNum = userData.getTDouNum();
            this.etO.setText(com.baidu.tbadk.core.util.ba.H(tDouNum));
            this.etO.setContentDescription(String.valueOf(this.bgI.getResources().getString(u.j.self_tdou)) + com.baidu.tbadk.core.util.ba.H(tDouNum));
            this.etO.setOnClickListener(this.eBI);
            this.eBE.setOnClickListener(this.eBI);
            this.eBD.setOnClickListener(this.eBI);
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dh = com.baidu.tbadk.core.util.q.dh(portrait);
                this.dlQ.setUrl(dh);
                this.dlQ.c(dh, 25, false);
            } else {
                this.dlQ.setImageResource(u.f.pic_mycenter_avatar_def_i);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.eBo.setTag(tShowInfo.get(0).getUrl());
                this.eBo.setVisibility(0);
                this.eBo.a(tShowInfo, tShowInfo.size(), this.bgI.getResources().getDimensionPixelSize(u.e.ds34), this.bgI.getResources().getDimensionPixelSize(u.e.ds34), this.bgI.getResources().getDimensionPixelSize(u.e.ds10), true);
            } else {
                this.eBo.setVisibility(8);
            }
            String name_show = userData.getName_show();
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(name_show)) {
                this.dlS.setText(name_show);
                this.dlS.setContentDescription(name_show);
                this.dlS.setClickable(true);
                if (isMem > 0) {
                    this.dlS.setTextColor(this.bgI.getResources().getColor(u.d.cp_other_b));
                } else {
                    this.dlS.setTextColor(this.bgI.getResources().getColor(u.d.cp_cont_g));
                }
            }
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.eBp.setText(intro);
                com.baidu.tbadk.core.util.av.c(this.eBp, u.d.cp_cont_f, 1);
            } else {
                this.eBp.setText(u.j.no_person_sign);
                com.baidu.tbadk.core.util.av.c(this.eBp, u.d.cp_cont_d, 1);
            }
            int sex = userData.getSex();
            if (sex == 1) {
                this.eBq.setImageResource(u.f.icon_pop_boy);
            } else if (sex == 2) {
                this.eBq.setImageResource(u.f.icon_pop_girl);
            } else {
                this.eBq.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                String string = this.bgI.getResources().getString(u.j.user_info_center_head_viewpager_forum_age_text);
                String str = String.valueOf(tb_age) + this.bgI.getResources().getString(u.j.user_info_center_head_viewpager_tb_age);
                this.eBs.setText(str);
                this.eBt.setClickable(true);
                this.eBt.setContentDescription(String.valueOf(string) + str);
            }
            this.eBu.a(userData.getIconInfo(), 9, this.bgI.getResources().getDimensionPixelSize(u.e.ds34), this.bgI.getResources().getDimensionPixelSize(u.e.ds34), this.bgI.getResources().getDimensionPixelSize(u.e.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.boH.setText(u.j.attention_cancel);
                this.boI.setVisibility(8);
                com.baidu.tbadk.core.util.av.k(this.eBx, u.f.btn_pop_news);
                com.baidu.tbadk.core.util.av.c(this.boH, u.d.cp_link_tip_c, 1);
            } else {
                this.boH.setText(u.j.attention);
                this.boI.setVisibility(0);
                com.baidu.tbadk.core.util.av.k(this.eBx, u.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.av.k(this.boI, u.f.icon_person_add_n);
                com.baidu.tbadk.core.util.av.c(this.boH, u.d.cp_cont_i, 1);
            }
            j(userData);
        }
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.eBx.setVisibility(8);
            this.eBz.setVisibility(8);
            this.eBB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getMyGiftIcon() {
        return this.eBB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.personInfo.a
    /* renamed from: aPA */
    public LinearLayout getAttentionView() {
        return this.eBx;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getVipIcon() {
        return this.eBo;
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getYinjiWraper() {
        return this.eBv;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getRootView() {
        return this.mRootView;
    }

    private boolean aOm() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }

    @Override // com.baidu.tieba.personInfo.a
    public BdExpandImageView getExpandImg() {
        return this.eBl;
    }
}
