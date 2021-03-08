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
/* loaded from: classes10.dex */
public class PersonCardViewNew implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private boolean aLc;
    private long bwn;
    private PersonUserData byD;
    private long gqI;
    private boolean hWE;
    private View hZA;
    private TextView hZF;
    private HeadImageView hZG;
    private boolean hZK;
    private TextView hZP;
    private TextView hZQ;
    private TextView hZR;
    private TextView hZS;
    private TextView hZT;
    private TextView hZU;
    private TextView hZV;
    private TextView hZW;
    private TextView hZX;
    private Animation hfq;
    private TextView iab;
    private TextView iac;
    private TextView iad;
    private TextView iae;
    private TextView iaf;
    private ViewGroup iag;
    private TbImageView iah;
    private LinearLayout iai;
    private View ial;
    private View iam;
    private View ian;
    private HeadImageView iao;
    private boolean iaq;
    private String iar;
    private boolean ias;
    private boolean iat;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView = ns(false);
    private Intent oPb;
    protected final PersonCardActivity oPk;
    private AlaLoadingButton oPl;
    private TextView oPm;
    private a.InterfaceC0955a oPn;
    private com.baidu.tieba.yuyinala.person.view.a oPo;
    private com.baidu.tieba.yuyinala.person.a oPp;
    private a oPq;
    private ImageView oPr;
    private boolean oPs;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes10.dex */
    public interface a {
        void cmE();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.oPk = personCardActivity;
        this.hZK = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.oPs = true;
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.oPo = new com.baidu.tieba.yuyinala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void efQ() {
        if (this.oPb != null && this.oPs) {
            ac acVar = new ac(this.oPk);
            acVar.setIntent(this.oPb);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
        }
    }

    public void a(a aVar) {
        this.oPq = aVar;
    }

    private void initView() {
        this.hZA = this.mRootView.findViewById(a.f.person_card_layout);
        this.hZF = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.iab = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.hZP = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hZQ = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hZR = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hZS = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hZU = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hZT = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hZV = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hZW = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hZX = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.iaf = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.oPl = (AlaLoadingButton) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.iae = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.iai = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.ial = this.mRootView.findViewById(a.f.user_divide);
        this.iam = this.mRootView.findViewById(a.f.user_divide2);
        this.iac = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.oPm = (TextView) this.mRootView.findViewById(a.f.btn_person_single_message);
        this.iad = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.oPr = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.iac.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.oPm.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.iad.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.iac.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.oPm.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.iad.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
        }
        this.iag = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hZG = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hZG.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hZG.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hZG.setIsRound(true);
        this.hZG.setAutoChangeStyle(false);
        this.hZG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hZG.setBorderWidth(BdUtilHelper.getDimens(this.oPk.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hZG.setBorderColor(-1);
        this.iab.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cmU();
            }
        });
        this.hZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (com.baidu.live.ao.a.Ym().iN(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                    Toast.makeText(PersonCardViewNew.this.oPk, PersonCardViewNew.this.oPk.getString(a.h.yuyin_ala_person_isonwheat), 1).show();
                } else if (com.baidu.live.ao.a.Ym().isApplying()) {
                    Toast.makeText(PersonCardViewNew.this.oPk, PersonCardViewNew.this.oPk.getString(a.h.yuyin_ala_person_isapplying), 1).show();
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.iar) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.iar);
                    }
                } else {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.oPk.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                        com.baidu.live.ao.a.Ym().muteOrUnmuteAudio(true);
                        PersonCardViewNew.this.oPk.finish();
                    }
                }
            }
        });
        this.ian = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.iao = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.iao.setIsRound(true);
        this.iao.setAutoChangeStyle(false);
        this.iao.setDrawBorder(false);
        this.iao.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void initListener() {
        this.oPk.a(new PersonCardActivity.a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.yuyinala.person.PersonCardActivity.a
            public void coI() {
                PersonCardViewNew.this.efQ();
            }
        });
        this.hZF.setOnClickListener(this);
        this.iac.setOnClickListener(this);
        this.oPm.setOnClickListener(this);
        this.iad.setOnClickListener(this);
        this.oPl.setOnClickListener(this);
        a(new a.InterfaceC0955a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.yuyinala.person.a.InterfaceC0955a
            public void cmH() {
                PersonCardViewNew.this.oPk.cmC();
            }
        });
    }

    public void a(a.InterfaceC0955a interfaceC0955a) {
        this.oPn = interfaceC0955a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.byD = personUserData;
            d(personUserData);
            f(personUserData);
            b(personUserData, z);
            h(personUserData);
            i(personUserData);
            this.oPo.setData(personUserData.user_info);
            if (this.hWE) {
                this.iai.setVisibility(8);
            }
            if (this.iai != null && this.iai.getVisibility() == 0) {
                if (z) {
                    this.iad.setVisibility(0);
                    this.oPm.setVisibility(0);
                    this.oPl.setVisibility(0);
                }
                int childCount = this.iai.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.iai.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.iai.getResources().getDimensionPixelOffset(i2 >= 3 ? a.d.sdk_ds20 : a.d.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.iai.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.iai.setWeightSum(i2);
                this.iai.requestLayout();
            }
        }
    }

    private void f(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aLc = personUserData.user_info != null && this.oPk.Is(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.iar = personUserData.user_info != null ? personUserData.user_info.aPT : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.ias = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.ias) {
                this.iai.setVisibility(8);
            } else {
                this.iai.setVisibility(0);
            }
            if (!z) {
                this.hZV.setText("火星");
            } else {
                this.hZV.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.iae.setVisibility(8);
                this.iam.setVisibility(8);
            } else {
                this.iae.setText(String.format(this.oPk.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.iam.setVisibility(0);
                this.iae.setVisibility(0);
            }
            if (z2) {
                this.hZX.setText(String.format(this.oPk.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hZX.setVisibility(0);
                this.ial.setVisibility(0);
                return;
            }
            this.hZX.setVisibility(8);
            this.ial.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmU() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.oPk.getActivity());
            this.oPk.finish();
        } else if (this.oPk != null) {
            this.oPk.cmC();
        }
    }

    private void d(PersonUserData personUserData) {
        ax axVar = personUserData.user_info;
        if (axVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(axVar.fans_count < 0 ? 0L : axVar.fans_count);
            this.hZQ.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hZS.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(axVar.follow_count >= 0 ? axVar.follow_count : 0L);
            this.hZW.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hZT.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hZR.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hZU.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hZU.setText("");
            }
            int i = this.hZK ? 26 : 30;
            if (this.screenWidth < 360) {
                i = this.hZK ? 22 : 26;
            }
            this.hZQ.setTextSize(1, i);
            this.hZW.setTextSize(1, i);
            this.hZR.setTextSize(1, i);
            if (personUserData.user_info == null || TextUtils.equals(personUserData.user_info.user_id, "0") || TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id)) {
                this.hZF.setVisibility(8);
                this.iab.setVisibility(8);
            } else {
                this.iab.setVisibility(0);
                if (personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowManagerBtn) {
                    if (personUserData.mYuyinBanMangerData.userIndentity == 2 && personUserData.mYuyinBanMangerData.userCardIndentity != 3) {
                        this.hZF.setVisibility(8);
                    } else {
                        this.hZF.setVisibility(0);
                    }
                } else {
                    this.hZF.setVisibility(8);
                }
            }
            if (b.Qy().Qz() && personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowSinglePrivate) {
                this.oPm.setVisibility(0);
            } else {
                this.oPm.setVisibility(8);
            }
            if (personUserData.user_info.gender == 2) {
                this.oPr.setVisibility(8);
                return;
            }
            this.oPr.setVisibility(0);
            this.oPr.setImageResource(personUserData.user_info.gender == 0 ? a.e.sdk_icon_mine_girl : a.e.sdk_icon_mine_boy);
        }
    }

    private void g(PersonUserData personUserData) {
        ax axVar = personUserData.user_info;
        if (axVar != null && !StringUtils.isNull(axVar.getNameShow())) {
            String nameShow = axVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hZP.setText(nameShow);
        }
        String str = null;
        if (personUserData != null && personUserData.user_info != null) {
            if (!TextUtils.isEmpty(personUserData.user_info.aPO)) {
                str = personUserData.user_info.aPO;
            } else if (!TextUtils.isEmpty(personUserData.user_info.portrait)) {
                str = personUserData.user_info.portrait;
            }
            m.a(this.hZG, str, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        }
        if (axVar != null) {
            if (StringUtils.isNull(axVar.description)) {
                this.iaf.setText(a.h.ala_person_desc_default_text);
            } else {
                this.iaf.setText(axVar.description);
            }
            Iu(axVar.aPP);
        }
    }

    private void Iu(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.iah == null) {
                this.iah = new TbImageView(this.iag.getContext());
            }
            this.iah.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.6
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.iag != null && PersonCardViewNew.this.iah != null && PersonCardViewNew.this.iah.getLoadedWidth() > 0 && PersonCardViewNew.this.iah.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hZK) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.iah.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.iag.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.iah.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.iag.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hZG != null) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hZG.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hZG.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hZG.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.iag.indexOfChild(PersonCardViewNew.this.iah) < 0) {
                            PersonCardViewNew.this.iag.addView(PersonCardViewNew.this.iah, PersonCardViewNew.this.iag.indexOfChild(PersonCardViewNew.this.hZG) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.iab.getVisibility() == 0 && PersonCardViewNew.this.hZF.getVisibility() == 0) {
                            PersonCardViewNew.this.hZF.setPadding(PersonCardViewNew.this.hZF.getPaddingLeft(), PersonCardViewNew.this.hZF.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hZF.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hZF.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hZF.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.iah.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.iaq = false;
            oV(false);
        } else if (!this.ias && (alaRelationData = personUserData.relation_info) != null) {
            this.iaq = alaRelationData.follow_status != 0;
            if (z) {
                this.oPl.setVisibility(8);
            } else {
                oV(this.iaq);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        String str = null;
        if (personUserData != null && personUserData.topContributionUserInfo != null) {
            if (!TextUtils.isEmpty(personUserData.topContributionUserInfo.aPO)) {
                str = personUserData.topContributionUserInfo.aPO;
            } else if (!TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
                str = personUserData.topContributionUserInfo.portrait;
            }
        }
        if (str != null) {
            this.ian.setVisibility(0);
            this.ian.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.oPq != null) {
                        PersonCardViewNew.this.oPq.cmE();
                    }
                }
            });
            this.iao.startLoad(str, 12, false, false);
            return;
        }
        this.ian.setVisibility(4);
    }

    private void oV(boolean z) {
        if (z) {
            this.oPl.setStatus(4);
            this.oPl.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_red);
            this.oPl.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.oPl.setBackgroundResource(a.e.ala_person_card_followed_bg_bd);
            }
            this.oPl.setAlpha(0.2f);
        } else {
            this.oPl.setStatus(1);
            this.oPl.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.oPl.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_bd_selector);
            }
            this.oPl.setAlpha(1.0f);
        }
        this.oPl.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.iac != null && personUserData != null && personUserData.user_info != null) {
            this.iac.setVisibility((this.iat && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oPl) {
            cmW();
        } else if (view == this.iad) {
            cmP();
        } else if (view == this.iac) {
            cmV();
        } else if (view == this.hZF) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501060, new Object[]{this.oPk, this.byD}));
        } else if (view == this.oPm) {
            efR();
        }
    }

    private void efR() {
        if (this.byD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oPk.getActivity());
            } else if (this.byD.user_info != null && JavaTypesHelper.toLong(this.byD.user_info.user_id, 0L) != 0 && !this.byD.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new af(this.oPk.getApplicationContext(), this.byD.user_info.user_id, this.byD.user_info.getNameShow(), "media".equals(this.byD.user_info.type) ? "80" : "0", "media".equals(this.byD.user_info.loginType), String.valueOf(this.byD.user_info.live_id), "", this.byD.user_info.aPM, this.byD.user_info.portrait)));
            }
        }
    }

    private void cmV() {
        if (this.oPk != null && this.byD != null && this.byD.user_info != null && !TextUtils.isEmpty(this.byD.user_info.live_id)) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.oPk.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.byD.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.oPk.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cmP() {
        if (this.byD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oPk.getActivity());
            } else if (this.byD.user_info == null || JavaTypesHelper.toLong(this.byD.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.oPk.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.byD.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oPk.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913123));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                c cVar = new c();
                cVar.bte = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.byD.user_info));
                this.oPk.finish();
            }
        }
    }

    private void cmW() {
        String str;
        if (this.byD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oPk.getActivity());
                this.oPk.finish();
            } else if (this.byD.user_info == null || TextUtils.equals(this.byD.user_info.user_id, TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oPk.getActivity(), a.h.ala_cannot_follow_myself);
            } else {
                if (this.iaq) {
                    this.oPk.cmB();
                } else {
                    this.oPk.cmA();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (this.oPl != null) {
                    this.oPl.setStatus(3);
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.iaq ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aLc) {
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

    public void wq(int i) {
        switch (i) {
            case 0:
                this.iaq = true;
                oV(true);
                if (this.byD != null && this.byD.user_info != null) {
                    this.byD.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.byD.user_info.fans_count >= 0 ? this.byD.user_info.fans_count : 0L);
                    this.hZQ.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hZS.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.iaq = false;
                oV(false);
                if (this.byD != null && this.byD.user_info != null) {
                    this.byD.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.byD.user_info.fans_count >= 0 ? this.byD.user_info.fans_count : 0L);
                    this.hZQ.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hZS.setText(formatForPersonCardBeanValue2[1]);
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
        return LayoutInflater.from(this.oPk.getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void oX(boolean z) {
        this.hWE = z;
    }

    public void at(Intent intent) {
        this.oPb = intent;
    }

    public void oY(boolean z) {
        this.iat = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.8
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.hfq == null) {
                        PersonCardViewNew.this.hfq = AnimationUtils.loadAnimation(PersonCardViewNew.this.oPk.getActivity(), a.C0201a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hZA.setAnimation(PersonCardViewNew.this.hfq);
                    PersonCardViewNew.this.hZA.setVisibility(0);
                    PersonCardViewNew.this.hfq.setDuration(300L);
                    PersonCardViewNew.this.hfq.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hZA != null) {
            this.hZA.clearAnimation();
        }
        if (this.oPp != null && this.oPp.isShowing()) {
            this.oPp.dismiss();
        }
    }

    public Animation bWN() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hfq != null) {
            this.hfq.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.oPk.getActivity(), a.C0201a.sdk_push_up_out);
        this.hZA.setAnimation(loadAnimation);
        this.hZA.setVisibility(8);
        return loadAnimation;
    }

    public void aN(String str, String str2) {
        this.bwn = JavaTypesHelper.toLong(str, 0L);
        this.gqI = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
