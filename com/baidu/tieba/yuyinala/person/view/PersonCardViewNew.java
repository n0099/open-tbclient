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
import com.baidu.live.ae.b;
import com.baidu.live.d.ac;
import com.baidu.live.d.af;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ax;
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
    private boolean aJC;
    private long buN;
    private PersonUserData bxd;
    private long goZ;
    private boolean hUV;
    private View hXR;
    private TextView hXW;
    private HeadImageView hXX;
    private View hYC;
    private View hYD;
    private View hYE;
    private HeadImageView hYF;
    private boolean hYH;
    private String hYI;
    private boolean hYJ;
    private boolean hYK;
    private boolean hYb;
    private TextView hYg;
    private TextView hYh;
    private TextView hYi;
    private TextView hYj;
    private TextView hYk;
    private TextView hYl;
    private TextView hYm;
    private TextView hYn;
    private TextView hYo;
    private TextView hYs;
    private TextView hYt;
    private TextView hYu;
    private TextView hYv;
    private TextView hYw;
    private ViewGroup hYx;
    private TbImageView hYy;
    private LinearLayout hYz;
    private Animation hdH;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView = ns(false);
    private Intent oMW;
    protected final PersonCardActivity oNf;
    private AlaLoadingButton oNg;
    private TextView oNh;
    private a.InterfaceC0949a oNi;
    private com.baidu.tieba.yuyinala.person.view.a oNj;
    private com.baidu.tieba.yuyinala.person.a oNk;
    private a oNl;
    private ImageView oNm;
    private boolean oNn;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes11.dex */
    public interface a {
        void cmy();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.oNf = personCardActivity;
        this.hYb = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.oNn = true;
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.oNj = new com.baidu.tieba.yuyinala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void efI() {
        if (this.oMW != null && this.oNn) {
            ac acVar = new ac(this.oNf);
            acVar.setIntent(this.oMW);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
        }
    }

    public void a(a aVar) {
        this.oNl = aVar;
    }

    private void initView() {
        this.hXR = this.mRootView.findViewById(a.f.person_card_layout);
        this.hXW = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hYs = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.hYg = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hYh = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hYi = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hYj = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hYl = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hYk = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hYm = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hYn = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hYo = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hYw = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.oNg = (AlaLoadingButton) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hYv = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hYz = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hYC = this.mRootView.findViewById(a.f.user_divide);
        this.hYD = this.mRootView.findViewById(a.f.user_divide2);
        this.hYt = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.oNh = (TextView) this.mRootView.findViewById(a.f.btn_person_single_message);
        this.hYu = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.oNm = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hYt.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.oNh.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.hYu.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.hYt.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.oNh.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.hYu.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
        }
        this.hYx = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hXX = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hXX.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hXX.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hXX.setIsRound(true);
        this.hXX.setAutoChangeStyle(false);
        this.hXX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hXX.setBorderWidth(BdUtilHelper.getDimens(this.oNf.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hXX.setBorderColor(-1);
        this.hYs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cmO();
            }
        });
        this.hXX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (com.baidu.live.ao.a.Yj().iH(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                    Toast.makeText(PersonCardViewNew.this.oNf, PersonCardViewNew.this.oNf.getString(a.h.yuyin_ala_person_isonwheat), 1).show();
                } else if (com.baidu.live.ao.a.Yj().isApplying()) {
                    Toast.makeText(PersonCardViewNew.this.oNf, PersonCardViewNew.this.oNf.getString(a.h.yuyin_ala_person_isapplying), 1).show();
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hYI) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hYI);
                    }
                } else {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.oNf.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                        com.baidu.live.ao.a.Yj().muteOrUnmuteAudio(true);
                        PersonCardViewNew.this.oNf.finish();
                    }
                }
            }
        });
        this.hYE = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hYF = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hYF.setIsRound(true);
        this.hYF.setAutoChangeStyle(false);
        this.hYF.setDrawBorder(false);
        this.hYF.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void initListener() {
        this.oNf.a(new PersonCardActivity.a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.yuyinala.person.PersonCardActivity.a
            public void coC() {
                PersonCardViewNew.this.efI();
            }
        });
        this.hXW.setOnClickListener(this);
        this.hYt.setOnClickListener(this);
        this.oNh.setOnClickListener(this);
        this.hYu.setOnClickListener(this);
        this.oNg.setOnClickListener(this);
        a(new a.InterfaceC0949a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.yuyinala.person.a.InterfaceC0949a
            public void cmB() {
                PersonCardViewNew.this.oNf.cmw();
            }
        });
    }

    public void a(a.InterfaceC0949a interfaceC0949a) {
        this.oNi = interfaceC0949a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bxd = personUserData;
            d(personUserData);
            f(personUserData);
            b(personUserData, z);
            h(personUserData);
            i(personUserData);
            this.oNj.setData(personUserData.user_info);
            if (this.hUV) {
                this.hYz.setVisibility(8);
            }
            if (this.hYz != null && this.hYz.getVisibility() == 0) {
                if (z) {
                    this.hYu.setVisibility(0);
                    this.oNh.setVisibility(0);
                    this.oNg.setVisibility(0);
                }
                int childCount = this.hYz.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hYz.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hYz.getResources().getDimensionPixelOffset(i2 >= 3 ? a.d.sdk_ds20 : a.d.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hYz.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hYz.setWeightSum(i2);
                this.hYz.requestLayout();
            }
        }
    }

    private void f(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aJC = personUserData.user_info != null && this.oNf.Ij(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hYI = personUserData.user_info != null ? personUserData.user_info.aOt : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.hYJ = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.hYJ) {
                this.hYz.setVisibility(8);
            } else {
                this.hYz.setVisibility(0);
            }
            if (!z) {
                this.hYm.setText("火星");
            } else {
                this.hYm.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hYv.setVisibility(8);
                this.hYD.setVisibility(8);
            } else {
                this.hYv.setText(String.format(this.oNf.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hYD.setVisibility(0);
                this.hYv.setVisibility(0);
            }
            if (z2) {
                this.hYo.setText(String.format(this.oNf.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hYo.setVisibility(0);
                this.hYC.setVisibility(0);
                return;
            }
            this.hYo.setVisibility(8);
            this.hYC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmO() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.oNf.getActivity());
            this.oNf.finish();
        } else if (this.oNf != null) {
            this.oNf.cmw();
        }
    }

    private void d(PersonUserData personUserData) {
        ax axVar = personUserData.user_info;
        if (axVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(axVar.fans_count < 0 ? 0L : axVar.fans_count);
            this.hYh.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hYj.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(axVar.follow_count >= 0 ? axVar.follow_count : 0L);
            this.hYn.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hYk.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hYi.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hYl.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hYl.setText("");
            }
            int i = this.hYb ? 26 : 30;
            if (this.screenWidth < 360) {
                i = this.hYb ? 22 : 26;
            }
            this.hYh.setTextSize(1, i);
            this.hYn.setTextSize(1, i);
            this.hYi.setTextSize(1, i);
            if (personUserData.user_info == null || TextUtils.equals(personUserData.user_info.user_id, "0") || TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id)) {
                this.hXW.setVisibility(8);
                this.hYs.setVisibility(8);
            } else {
                this.hYs.setVisibility(0);
                if (personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowManagerBtn) {
                    if (personUserData.mYuyinBanMangerData.userIndentity == 2 && personUserData.mYuyinBanMangerData.userCardIndentity != 3) {
                        this.hXW.setVisibility(8);
                    } else {
                        this.hXW.setVisibility(0);
                    }
                } else {
                    this.hXW.setVisibility(8);
                }
            }
            if (b.Qv().Qw() && personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowSinglePrivate) {
                this.oNh.setVisibility(0);
            } else {
                this.oNh.setVisibility(8);
            }
            if (personUserData.user_info.gender == 2) {
                this.oNm.setVisibility(8);
                return;
            }
            this.oNm.setVisibility(0);
            this.oNm.setImageResource(personUserData.user_info.gender == 0 ? a.e.sdk_icon_mine_girl : a.e.sdk_icon_mine_boy);
        }
    }

    private void g(PersonUserData personUserData) {
        ax axVar = personUserData.user_info;
        if (axVar != null && !StringUtils.isNull(axVar.getNameShow())) {
            String nameShow = axVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hYg.setText(nameShow);
        }
        String str = null;
        if (personUserData != null && personUserData.user_info != null) {
            if (!TextUtils.isEmpty(personUserData.user_info.aOo)) {
                str = personUserData.user_info.aOo;
            } else if (!TextUtils.isEmpty(personUserData.user_info.portrait)) {
                str = personUserData.user_info.portrait;
            }
            m.a(this.hXX, str, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        }
        if (axVar != null) {
            if (StringUtils.isNull(axVar.description)) {
                this.hYw.setText(a.h.ala_person_desc_default_text);
            } else {
                this.hYw.setText(axVar.description);
            }
            Il(axVar.aOp);
        }
    }

    private void Il(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hYy == null) {
                this.hYy = new TbImageView(this.hYx.getContext());
            }
            this.hYy.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.6
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hYx != null && PersonCardViewNew.this.hYy != null && PersonCardViewNew.this.hYy.getLoadedWidth() > 0 && PersonCardViewNew.this.hYy.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hYb) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hYy.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hYx.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hYy.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hYx.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hXX != null) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXX.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hXX.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hXX.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hYx.indexOfChild(PersonCardViewNew.this.hYy) < 0) {
                            PersonCardViewNew.this.hYx.addView(PersonCardViewNew.this.hYy, PersonCardViewNew.this.hYx.indexOfChild(PersonCardViewNew.this.hXX) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hYs.getVisibility() == 0 && PersonCardViewNew.this.hXW.getVisibility() == 0) {
                            PersonCardViewNew.this.hXW.setPadding(PersonCardViewNew.this.hXW.getPaddingLeft(), PersonCardViewNew.this.hXW.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hXW.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXW.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hXW.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hYy.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hYH = false;
            oV(false);
        } else if (!this.hYJ && (alaRelationData = personUserData.relation_info) != null) {
            this.hYH = alaRelationData.follow_status != 0;
            if (z) {
                this.oNg.setVisibility(8);
            } else {
                oV(this.hYH);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        String str = null;
        if (personUserData != null && personUserData.topContributionUserInfo != null) {
            if (!TextUtils.isEmpty(personUserData.topContributionUserInfo.aOo)) {
                str = personUserData.topContributionUserInfo.aOo;
            } else if (!TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
                str = personUserData.topContributionUserInfo.portrait;
            }
        }
        if (str != null) {
            this.hYE.setVisibility(0);
            this.hYE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.oNl != null) {
                        PersonCardViewNew.this.oNl.cmy();
                    }
                }
            });
            this.hYF.startLoad(str, 12, false, false);
            return;
        }
        this.hYE.setVisibility(4);
    }

    private void oV(boolean z) {
        if (z) {
            this.oNg.setStatus(4);
            this.oNg.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_red);
            this.oNg.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.oNg.setBackgroundResource(a.e.ala_person_card_followed_bg_bd);
            }
            this.oNg.setAlpha(0.2f);
        } else {
            this.oNg.setStatus(1);
            this.oNg.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.oNg.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_bd_selector);
            }
            this.oNg.setAlpha(1.0f);
        }
        this.oNg.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hYt != null && personUserData != null && personUserData.user_info != null) {
            this.hYt.setVisibility((this.hYK && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oNg) {
            cmQ();
        } else if (view == this.hYu) {
            cmJ();
        } else if (view == this.hYt) {
            cmP();
        } else if (view == this.hXW) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501060, new Object[]{this.oNf, this.bxd}));
        } else if (view == this.oNh) {
            efJ();
        }
    }

    private void efJ() {
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oNf.getActivity());
            } else if (this.bxd.user_info != null && JavaTypesHelper.toLong(this.bxd.user_info.user_id, 0L) != 0 && !this.bxd.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new af(this.oNf.getApplicationContext(), this.bxd.user_info.user_id, this.bxd.user_info.getNameShow(), "media".equals(this.bxd.user_info.type) ? "80" : "0", "media".equals(this.bxd.user_info.loginType), String.valueOf(this.bxd.user_info.live_id), "", this.bxd.user_info.aOm, this.bxd.user_info.portrait)));
            }
        }
    }

    private void cmP() {
        if (this.oNf != null && this.bxd != null && this.bxd.user_info != null && !TextUtils.isEmpty(this.bxd.user_info.live_id)) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.oNf.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bxd.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.oNf.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cmJ() {
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oNf.getActivity());
            } else if (this.bxd.user_info == null || JavaTypesHelper.toLong(this.bxd.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.oNf.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.bxd.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oNf.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913123));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                c cVar = new c();
                cVar.brE = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bxd.user_info));
                this.oNf.finish();
            }
        }
    }

    private void cmQ() {
        String str;
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oNf.getActivity());
                this.oNf.finish();
            } else if (this.bxd.user_info == null || TextUtils.equals(this.bxd.user_info.user_id, TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oNf.getActivity(), a.h.ala_cannot_follow_myself);
            } else {
                if (this.hYH) {
                    this.oNf.cmv();
                } else {
                    this.oNf.cmu();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (this.oNg != null) {
                    this.oNg.setStatus(3);
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hYH ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aJC) {
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

    public void wp(int i) {
        switch (i) {
            case 0:
                this.hYH = true;
                oV(true);
                if (this.bxd != null && this.bxd.user_info != null) {
                    this.bxd.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bxd.user_info.fans_count >= 0 ? this.bxd.user_info.fans_count : 0L);
                    this.hYh.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hYj.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hYH = false;
                oV(false);
                if (this.bxd != null && this.bxd.user_info != null) {
                    this.bxd.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bxd.user_info.fans_count >= 0 ? this.bxd.user_info.fans_count : 0L);
                    this.hYh.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hYj.setText(formatForPersonCardBeanValue2[1]);
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

    private View ns(boolean z) {
        return LayoutInflater.from(this.oNf.getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void oX(boolean z) {
        this.hUV = z;
    }

    public void at(Intent intent) {
        this.oMW = intent;
    }

    public void oY(boolean z) {
        this.hYK = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.8
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.hdH == null) {
                        PersonCardViewNew.this.hdH = AnimationUtils.loadAnimation(PersonCardViewNew.this.oNf.getActivity(), a.C0195a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hXR.setAnimation(PersonCardViewNew.this.hdH);
                    PersonCardViewNew.this.hXR.setVisibility(0);
                    PersonCardViewNew.this.hdH.setDuration(300L);
                    PersonCardViewNew.this.hdH.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hXR != null) {
            this.hXR.clearAnimation();
        }
        if (this.oNk != null && this.oNk.isShowing()) {
            this.oNk.dismiss();
        }
    }

    public Animation bWH() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hdH != null) {
            this.hdH.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.oNf.getActivity(), a.C0195a.sdk_push_up_out);
        this.hXR.setAnimation(loadAnimation);
        this.hXR.setVisibility(8);
        return loadAnimation;
    }

    public void aN(String str, String str2) {
        this.buN = JavaTypesHelper.toLong(str, 0L);
        this.goZ = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
