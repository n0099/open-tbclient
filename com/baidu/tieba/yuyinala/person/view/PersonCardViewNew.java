package com.baidu.tieba.yuyinala.person.view;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.af.b;
import com.baidu.live.d.ac;
import com.baidu.live.d.af;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.at;
import com.baidu.live.liveroom.d.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJump;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.schemeability.ISchemeAbility;
import com.baidu.live.tbadk.schemeability.SchemeAbilityManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import com.baidu.live.view.AlaLoadingButton;
import com.baidu.tieba.yuyinala.person.PersonCardActivity;
import com.baidu.tieba.yuyinala.person.a;
/* loaded from: classes11.dex */
public class PersonCardViewNew implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private boolean aLL;
    private long bvY;
    private PersonUserData byl;
    private long gqJ;
    private boolean hUT;
    private View hXP;
    private TextView hXU;
    private HeadImageView hXV;
    private boolean hXZ;
    private View hYA;
    private View hYB;
    private View hYC;
    private HeadImageView hYD;
    private boolean hYF;
    private String hYG;
    private boolean hYH;
    private boolean hYI;
    private TextView hYe;
    private TextView hYf;
    private TextView hYg;
    private TextView hYh;
    private TextView hYi;
    private TextView hYj;
    private TextView hYk;
    private TextView hYl;
    private TextView hYm;
    private TextView hYq;
    private TextView hYr;
    private TextView hYs;
    private TextView hYt;
    private TextView hYu;
    private ViewGroup hYv;
    private TbImageView hYw;
    private LinearLayout hYx;
    private Animation hfp;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView = nr(false);
    private Intent oGS;
    protected final PersonCardActivity oHb;
    private AlaLoadingButton oHc;
    private TextView oHd;
    private a.InterfaceC0960a oHe;
    private com.baidu.tieba.yuyinala.person.view.a oHf;
    private com.baidu.tieba.yuyinala.person.a oHg;
    private a oHh;
    private ImageView oHi;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes11.dex */
    public interface a {
        void cpl();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.oHb = personCardActivity;
        this.hXZ = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.oHf = new com.baidu.tieba.yuyinala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void ehb() {
        if (this.oGS != null) {
            ac acVar = new ac(this.oHb);
            acVar.setIntent(this.oGS);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
        }
    }

    public void a(a aVar) {
        this.oHh = aVar;
    }

    private void initView() {
        this.hXP = this.mRootView.findViewById(a.f.person_card_layout);
        this.hXU = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hYq = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.hYe = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hYf = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hYg = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hYh = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hYj = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hYi = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hYk = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hYl = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hYm = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hYu = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.oHc = (AlaLoadingButton) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hYt = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hYx = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hYA = this.mRootView.findViewById(a.f.user_divide);
        this.hYB = this.mRootView.findViewById(a.f.user_divide2);
        this.hYr = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.oHd = (TextView) this.mRootView.findViewById(a.f.btn_person_single_message);
        this.hYs = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.oHi = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hYr.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.oHd.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.hYs.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.hYr.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.oHd.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.hYs.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
        }
        this.hYv = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hXV = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hXV.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.hXV.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.hXV.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hXV.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.hXV.setIsRound(true);
        this.hXV.setAutoChangeStyle(false);
        this.hXV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hXV.setBorderWidth(BdUtilHelper.getDimens(this.oHb.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hXV.setBorderColor(-1);
        this.hYq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cpB();
            }
        });
        this.hXV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (com.baidu.live.aq.a.aan().jm(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                    Toast.makeText(PersonCardViewNew.this.oHb, PersonCardViewNew.this.oHb.getString(a.h.yuyin_ala_person_isonwheat), 1).show();
                } else if (com.baidu.live.aq.a.aan().isApplying()) {
                    Toast.makeText(PersonCardViewNew.this.oHb, PersonCardViewNew.this.oHb.getString(a.h.yuyin_ala_person_isapplying), 1).show();
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hYG) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hYG);
                    }
                } else {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.oHb.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                        com.baidu.live.aq.a.aan().muteOrUnmuteAudio(true);
                        PersonCardViewNew.this.oHb.finish();
                    }
                }
            }
        });
        this.hYC = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hYD = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hYD.setIsRound(true);
        this.hYD.setAutoChangeStyle(false);
        this.hYD.setDrawBorder(false);
        this.hYD.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void initListener() {
        this.oHb.a(new PersonCardActivity.a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.yuyinala.person.PersonCardActivity.a
            public void crp() {
                PersonCardViewNew.this.ehb();
            }
        });
        this.hXU.setOnClickListener(this);
        this.hYr.setOnClickListener(this);
        this.oHd.setOnClickListener(this);
        this.hYs.setOnClickListener(this);
        this.oHc.setOnClickListener(this);
        a(new a.InterfaceC0960a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.yuyinala.person.a.InterfaceC0960a
            public void cpo() {
                PersonCardViewNew.this.oHb.cpj();
            }
        });
    }

    public void a(a.InterfaceC0960a interfaceC0960a) {
        this.oHe = interfaceC0960a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.byl = personUserData;
            d(personUserData);
            f(personUserData);
            b(personUserData, z);
            h(personUserData);
            i(personUserData);
            this.oHf.setData(personUserData.user_info);
            if (this.hUT) {
                this.hYx.setVisibility(8);
            }
            if (this.hYx != null && this.hYx.getVisibility() == 0) {
                if (z) {
                    this.hYs.setVisibility(0);
                    this.oHd.setVisibility(0);
                    this.oHc.setVisibility(0);
                }
                int childCount = this.hYx.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hYx.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hYx.getResources().getDimensionPixelOffset(i2 >= 3 ? a.d.sdk_ds20 : a.d.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hYx.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hYx.setWeightSum(i2);
                this.hYx.requestLayout();
            }
        }
    }

    private void f(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aLL = personUserData.user_info != null && this.oHb.IP(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hYG = personUserData.user_info != null ? personUserData.user_info.aQj : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.hYH = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.hYH) {
                this.hYx.setVisibility(8);
            } else {
                this.hYx.setVisibility(0);
            }
            if (!z) {
                this.hYk.setText("火星");
            } else {
                this.hYk.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hYt.setVisibility(8);
                this.hYB.setVisibility(8);
            } else {
                this.hYt.setText(String.format(this.oHb.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hYB.setVisibility(0);
                this.hYt.setVisibility(0);
            }
            if (z2) {
                this.hYm.setText(String.format(this.oHb.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hYm.setVisibility(0);
                this.hYA.setVisibility(0);
                return;
            }
            this.hYm.setVisibility(8);
            this.hYA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpB() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.oHb.getActivity());
            this.oHb.finish();
        } else if (this.oHb != null) {
            this.oHb.cpj();
        }
    }

    private void d(PersonUserData personUserData) {
        at atVar = personUserData.user_info;
        if (atVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(atVar.fans_count < 0 ? 0L : atVar.fans_count);
            this.hYf.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hYh.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(atVar.follow_count >= 0 ? atVar.follow_count : 0L);
            this.hYl.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hYi.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hYg.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hYj.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hYj.setText("");
            }
            int i = this.hXZ ? 26 : 30;
            if (this.screenWidth < 360) {
                i = this.hXZ ? 22 : 26;
            }
            this.hYf.setTextSize(1, i);
            this.hYl.setTextSize(1, i);
            this.hYg.setTextSize(1, i);
            if (personUserData.user_info == null || TextUtils.equals(personUserData.user_info.user_id, "0") || TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id)) {
                this.hXU.setVisibility(8);
                this.hYq.setVisibility(8);
            } else {
                this.hYq.setVisibility(0);
                if (personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowManagerBtn) {
                    if (personUserData.mYuyinBanMangerData.userIndentity == 2 && personUserData.mYuyinBanMangerData.userCardIndentity != 3) {
                        this.hXU.setVisibility(8);
                    } else {
                        this.hXU.setVisibility(0);
                    }
                } else {
                    this.hXU.setVisibility(8);
                }
            }
            if (b.SP().SQ() && personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowSinglePrivate) {
                this.oHd.setVisibility(0);
            } else {
                this.oHd.setVisibility(8);
            }
            if (personUserData.user_info.gender == 2) {
                this.oHi.setVisibility(8);
                return;
            }
            this.oHi.setVisibility(0);
            this.oHi.setImageResource(personUserData.user_info.gender == 0 ? a.e.sdk_icon_mine_girl : a.e.sdk_icon_mine_boy);
        }
    }

    private void g(PersonUserData personUserData) {
        at atVar = personUserData.user_info;
        if (atVar != null && !StringUtils.isNull(atVar.getNameShow())) {
            String nameShow = atVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hYe.setText(nameShow);
        }
        m.a(this.hXV, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (atVar != null) {
            if (StringUtils.isNull(atVar.description)) {
                this.hYu.setText(a.h.ala_person_desc_default_text);
            } else {
                this.hYu.setText(atVar.description);
            }
            IR(atVar.aQf);
        }
    }

    private void IR(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hYw == null) {
                this.hYw = new TbImageView(this.hYv.getContext());
            }
            this.hYw.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.6
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hYv != null && PersonCardViewNew.this.hYw != null && PersonCardViewNew.this.hYw.getLoadedWidth() > 0 && PersonCardViewNew.this.hYw.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hXZ) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hYw.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hYv.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hYw.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hYv.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hXV != null) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXV.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hXV.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hXV.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hYv.indexOfChild(PersonCardViewNew.this.hYw) < 0) {
                            PersonCardViewNew.this.hYv.addView(PersonCardViewNew.this.hYw, PersonCardViewNew.this.hYv.indexOfChild(PersonCardViewNew.this.hXV) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hYq.getVisibility() == 0 && PersonCardViewNew.this.hXU.getVisibility() == 0) {
                            PersonCardViewNew.this.hXU.setPadding(PersonCardViewNew.this.hXU.getPaddingLeft(), PersonCardViewNew.this.hXU.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hXU.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXU.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hXU.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hYw.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hYF = false;
            oP(false);
        } else if (!this.hYH && (alaRelationData = personUserData.relation_info) != null) {
            this.hYF = alaRelationData.follow_status != 0;
            if (z) {
                this.oHc.setVisibility(8);
            } else {
                oP(this.hYF);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hYC.setVisibility(0);
            this.hYC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.oHh != null) {
                        PersonCardViewNew.this.oHh.cpl();
                    }
                }
            });
            this.hYD.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hYC.setVisibility(4);
    }

    private void oP(boolean z) {
        if (z) {
            this.oHc.setStatus(4);
            this.oHc.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_red);
            this.oHc.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.oHc.setBackgroundResource(a.e.ala_person_card_followed_bg_bd);
            }
            this.oHc.setAlpha(0.2f);
        } else {
            this.oHc.setStatus(1);
            this.oHc.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.oHc.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_bd_selector);
            }
            this.oHc.setAlpha(1.0f);
        }
        this.oHc.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hYr != null && personUserData != null && personUserData.user_info != null) {
            this.hYr.setVisibility((this.hYI && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oHc) {
            cpD();
        } else if (view == this.hYs) {
            cpw();
        } else if (view == this.hYr) {
            cpC();
        } else if (view == this.hXU) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501060, new Object[]{this.oHb, this.byl}));
        } else if (view == this.oHd) {
            ehc();
        }
    }

    private void ehc() {
        if (this.byl != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oHb.getActivity());
            } else if (this.byl.user_info != null && JavaTypesHelper.toLong(this.byl.user_info.user_id, 0L) != 0 && !this.byl.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new af(this.oHb.getApplicationContext(), this.byl.user_info.user_id, this.byl.user_info.getNameShow(), "media".equals(this.byl.user_info.type) ? "80" : "0", "media".equals(this.byl.user_info.loginType), String.valueOf(this.byl.user_info.live_id), "", this.byl.user_info.aQd, this.byl.user_info.portrait)));
            }
        }
    }

    private void cpC() {
        if (this.oHb != null && this.byl != null && this.byl.user_info != null && !TextUtils.isEmpty(this.byl.user_info.live_id)) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.oHb.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.byl.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.oHb.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cpw() {
        if (this.byl != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oHb.getActivity());
            } else if (this.byl.user_info == null || JavaTypesHelper.toLong(this.byl.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.oHb.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.byl.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oHb.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                c cVar = new c();
                cVar.bsP = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.byl.user_info));
                this.oHb.finish();
            }
        }
    }

    private void cpD() {
        String str;
        if (this.byl != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oHb.getActivity());
                this.oHb.finish();
            } else if (this.byl.user_info == null || TextUtils.equals(this.byl.user_info.user_id, TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oHb.getActivity(), a.h.ala_cannot_follow_myself);
            } else {
                if (this.hYF) {
                    this.oHb.cpi();
                } else {
                    this.oHb.cph();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (this.oHc != null) {
                    this.oHc.setStatus(3);
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hYF ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aLL) {
                        str = "author_profile";
                    } else {
                        str = "guest_profile";
                    }
                    alaStaticItem2.addParams("loc", str);
                    alaStaticItem2.addParams("other_params", this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                }
            }
        }
    }

    public void xK(int i) {
        switch (i) {
            case 0:
                this.hYF = true;
                oP(true);
                if (this.byl != null && this.byl.user_info != null) {
                    this.byl.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.byl.user_info.fans_count >= 0 ? this.byl.user_info.fans_count : 0L);
                    this.hYf.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hYh.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hYF = false;
                oP(false);
                if (this.byl != null && this.byl.user_info != null) {
                    this.byl.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.byl.user_info.fans_count >= 0 ? this.byl.user_info.fans_count : 0L);
                    this.hYf.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hYh.setText(formatForPersonCardBeanValue2[1]);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    private View nr(boolean z) {
        return LayoutInflater.from(this.oHb.getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void oR(boolean z) {
        this.hUT = z;
    }

    public void at(Intent intent) {
        this.oGS = intent;
    }

    public void oS(boolean z) {
        this.hYI = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.8
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.hfp == null) {
                        PersonCardViewNew.this.hfp = AnimationUtils.loadAnimation(PersonCardViewNew.this.oHb.getActivity(), a.C0203a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hXP.setAnimation(PersonCardViewNew.this.hfp);
                    PersonCardViewNew.this.hXP.setVisibility(0);
                    PersonCardViewNew.this.hfp.setDuration(300L);
                    PersonCardViewNew.this.hfp.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hXP != null) {
            this.hXP.clearAnimation();
        }
        if (this.oHg != null && this.oHg.isShowing()) {
            this.oHg.dismiss();
        }
    }

    public Animation bZO() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hfp != null) {
            this.hfp.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.oHb.getActivity(), a.C0203a.sdk_push_up_out);
        this.hXP.setAnimation(loadAnimation);
        this.hXP.setVisibility(8);
        return loadAnimation;
    }

    public void aO(String str, String str2) {
        this.bvY = JavaTypesHelper.toLong(str, 0L);
        this.gqJ = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
