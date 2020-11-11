package com.baidu.tieba.yuyinala.person.view;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.ViewPager;
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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.al.b;
import com.baidu.live.b.ab;
import com.baidu.live.b.ae;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.aq;
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
import com.baidu.live.utils.l;
import com.baidu.tieba.yuyinala.person.PersonCardActivity;
import com.baidu.tieba.yuyinala.person.a;
/* loaded from: classes4.dex */
public class PersonCardViewNew implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private boolean aKf;
    private long bnV;
    private PersonUserData bqb;
    private long fYr;
    private Animation gKH;
    private TextView hCB;
    private TextView hCC;
    private TextView hCD;
    private TextView hCE;
    private TextView hCF;
    private ViewGroup hCG;
    private HeadImageView hCH;
    private TbImageView hCI;
    private LinearLayout hCJ;
    private View hCK;
    private View hCL;
    private View hCM;
    private View hCN;
    private HeadImageView hCO;
    private boolean hCQ;
    private String hCR;
    private boolean hCS;
    private boolean hCT;
    private boolean hCW;
    private TextView hCo;
    private TextView hCp;
    private TextView hCq;
    private TextView hCr;
    private TextView hCs;
    private TextView hCt;
    private TextView hCu;
    private TextView hCv;
    private TextView hCw;
    private TextView hCx;
    private TextView hCy;
    private boolean hzy;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView = mv(false);
    private Intent oiJ;
    protected final PersonCardActivity oiR;
    private TextView oiS;
    private a.InterfaceC0926a oiT;
    private com.baidu.tieba.yuyinala.person.view.a oiU;
    private com.baidu.tieba.yuyinala.person.a oiV;
    private a oiW;
    private ImageView oiX;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes4.dex */
    public interface a {
        void cjf();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.oiR = personCardActivity;
        this.hCW = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.eaQ();
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.oiU = new com.baidu.tieba.yuyinala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void eaQ() {
        if (this.oiJ != null) {
            ab abVar = new ab(this.oiR);
            abVar.setIntent(this.oiJ);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, abVar));
        }
    }

    public void a(a aVar) {
        this.oiW = aVar;
    }

    private void initView() {
        this.hCK = this.mRootView.findViewById(a.f.person_card_layout);
        this.hCo = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hCB = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.hCp = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hCq = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hCr = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hCs = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hCu = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hCt = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hCv = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hCw = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hCx = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hCF = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.hCy = (TextView) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hCE = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hCJ = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hCL = this.mRootView.findViewById(a.f.user_divide);
        this.hCM = this.mRootView.findViewById(a.f.user_divide2);
        this.hCC = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.oiS = (TextView) this.mRootView.findViewById(a.f.btn_person_single_message);
        this.hCD = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.oiX = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hCC.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.oiS.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.hCD.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.hCC.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.oiS.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.hCD.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
        }
        this.hCG = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hCH = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hCH.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.hCH.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.hCH.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hCH.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.hCH.setIsRound(true);
        this.hCH.setAutoChangeStyle(false);
        this.hCH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hCH.setBorderWidth(BdUtilHelper.getDimens(this.oiR.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hCH.setBorderColor(-1);
        this.hCB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cju();
            }
        });
        this.hCH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (b.Xh().iV(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                    Toast.makeText(PersonCardViewNew.this.oiR, PersonCardViewNew.this.oiR.getString(a.h.yuyin_ala_person_isonwheat), 1).show();
                } else if (b.Xh().isApplying()) {
                    Toast.makeText(PersonCardViewNew.this.oiR, PersonCardViewNew.this.oiR.getString(a.h.yuyin_ala_person_isapplying), 1).show();
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hCR) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hCR);
                    }
                } else {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.oiR.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                        b.Xh().muteOrUnmuteAudio(true);
                        PersonCardViewNew.this.oiR.finish();
                    }
                }
            }
        });
        this.hCN = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hCO = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hCO.setIsRound(true);
        this.hCO.setAutoChangeStyle(false);
        this.hCO.setDrawBorder(false);
        this.hCO.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void initListener() {
        this.hCo.setOnClickListener(this);
        this.hCC.setOnClickListener(this);
        this.oiS.setOnClickListener(this);
        this.hCD.setOnClickListener(this);
        this.hCy.setOnClickListener(this);
        a(new a.InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.yuyinala.person.a.InterfaceC0926a
            public void cji() {
                PersonCardViewNew.this.oiR.cjd();
            }
        });
    }

    public void a(a.InterfaceC0926a interfaceC0926a) {
        this.oiT = interfaceC0926a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bqb = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            i(personUserData);
            this.oiU.setData(personUserData.user_info);
            if (this.hzy) {
                this.hCJ.setVisibility(8);
            }
            if (this.hCJ != null && this.hCJ.getVisibility() == 0) {
                int childCount = this.hCJ.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hCJ.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hCJ.getResources().getDimensionPixelOffset(i2 >= 3 ? a.d.sdk_ds20 : a.d.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hCJ.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hCJ.setWeightSum(i2);
                this.hCJ.requestLayout();
            }
        }
    }

    private void e(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aKf = personUserData.user_info != null && this.oiR.IC(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hCR = personUserData.user_info != null ? personUserData.user_info.aOg : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.hCS = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.hCS) {
                this.hCJ.setVisibility(8);
            } else {
                this.hCJ.setVisibility(0);
            }
            if (!z) {
                this.hCv.setText("火星");
            } else {
                this.hCv.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hCE.setVisibility(8);
                this.hCM.setVisibility(8);
            } else {
                this.hCE.setText(String.format(this.oiR.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hCM.setVisibility(0);
                this.hCE.setVisibility(0);
            }
            if (z2) {
                this.hCx.setText(String.format(this.oiR.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hCx.setVisibility(0);
                this.hCL.setVisibility(0);
                return;
            }
            this.hCx.setVisibility(8);
            this.hCL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cju() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.oiR.getActivity());
            this.oiR.finish();
        } else if (this.oiR != null) {
            this.oiR.cjd();
        }
    }

    private void f(PersonUserData personUserData) {
        aq aqVar = personUserData.user_info;
        if (aqVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(aqVar.fans_count < 0 ? 0L : aqVar.fans_count);
            this.hCq.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hCs.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(aqVar.follow_count >= 0 ? aqVar.follow_count : 0L);
            this.hCw.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hCt.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hCr.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hCu.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hCu.setText("");
            }
            int i = this.hCW ? 26 : 30;
            if (this.screenWidth < 360) {
                i = this.hCW ? 22 : 26;
            }
            this.hCq.setTextSize(1, i);
            this.hCw.setTextSize(1, i);
            this.hCr.setTextSize(1, i);
            if (personUserData.user_info == null || TextUtils.equals(personUserData.user_info.user_id, "0") || TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id)) {
                this.hCo.setVisibility(8);
                this.hCB.setVisibility(8);
            } else {
                this.hCB.setVisibility(0);
                if (personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowManagerBtn) {
                    if (personUserData.mYuyinBanMangerData.userIndentity == 2 && personUserData.mYuyinBanMangerData.userCardIndentity != 3) {
                        this.hCo.setVisibility(8);
                    } else {
                        this.hCo.setVisibility(0);
                    }
                } else {
                    this.hCo.setVisibility(8);
                }
            }
            if (com.baidu.live.aa.b.Qa().Qb() && personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowSinglePrivate) {
                this.oiS.setVisibility(0);
            } else {
                this.oiS.setVisibility(8);
            }
            if (personUserData.user_info.gender == 2) {
                this.oiX.setVisibility(8);
                return;
            }
            this.oiX.setVisibility(0);
            this.oiX.setImageResource(personUserData.user_info.gender == 0 ? a.e.sdk_icon_mine_girl : a.e.sdk_icon_mine_boy);
        }
    }

    private void g(PersonUserData personUserData) {
        aq aqVar = personUserData.user_info;
        if (aqVar != null && !StringUtils.isNull(aqVar.getNameShow())) {
            String nameShow = aqVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hCp.setText(nameShow);
        }
        l.a(this.hCH, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (aqVar != null) {
            if (StringUtils.isNull(aqVar.description)) {
                this.hCF.setText(a.h.ala_person_desc_default_text);
            } else {
                this.hCF.setText(aqVar.description);
            }
            IE(aqVar.aOc);
        }
    }

    private void IE(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hCI == null) {
                this.hCI = new TbImageView(this.hCG.getContext());
            }
            this.hCI.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.5
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hCG != null && PersonCardViewNew.this.hCI != null && PersonCardViewNew.this.hCI.getLoadedWidth() > 0 && PersonCardViewNew.this.hCI.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hCW) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hCI.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hCG.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hCI.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hCG.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hCH != null) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hCH.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hCH.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hCH.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hCG.indexOfChild(PersonCardViewNew.this.hCI) < 0) {
                            PersonCardViewNew.this.hCG.addView(PersonCardViewNew.this.hCI, PersonCardViewNew.this.hCG.indexOfChild(PersonCardViewNew.this.hCH) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hCB.getVisibility() == 0 && PersonCardViewNew.this.hCo.getVisibility() == 0) {
                            PersonCardViewNew.this.hCo.setPadding(PersonCardViewNew.this.hCo.getPaddingLeft(), PersonCardViewNew.this.hCo.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hCo.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hCo.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hCo.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hCI.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hCQ = false;
            nU(false);
        } else if (!this.hCS && (alaRelationData = personUserData.relation_info) != null) {
            this.hCQ = alaRelationData.follow_status != 0;
            if (z) {
                this.hCy.setVisibility(8);
            } else {
                nU(this.hCQ);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hCN.setVisibility(0);
            this.hCN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.oiW != null) {
                        PersonCardViewNew.this.oiW.cjf();
                    }
                }
            });
            this.hCO.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hCN.setVisibility(4);
    }

    private void nU(boolean z) {
        if (z) {
            this.hCy.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hCy.setBackgroundResource(a.e.ala_person_card_followed_bg_bd);
            }
            this.hCy.setAlpha(0.2f);
        } else {
            this.hCy.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hCy.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_bd_selector);
            }
            this.hCy.setAlpha(1.0f);
        }
        this.hCy.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hCC != null && personUserData != null && personUserData.user_info != null) {
            this.hCC.setVisibility((this.hCT && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hCy) {
            cjw();
        } else if (view == this.hCD) {
            cjq();
        } else if (view == this.hCC) {
            cjv();
        } else if (view == this.hCo) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501060, new Object[]{this.oiR, this.bqb}));
        } else if (view == this.oiS) {
            eaR();
        }
    }

    private void eaR() {
        if (this.bqb != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oiR.getActivity());
            } else if (this.bqb.user_info != null && JavaTypesHelper.toLong(this.bqb.user_info.user_id, 0L) != 0 && !this.bqb.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ae(this.oiR.getApplicationContext(), this.bqb.user_info.user_id, this.bqb.user_info.getNameShow(), "media".equals(this.bqb.user_info.type) ? "80" : "0", "media".equals(this.bqb.user_info.loginType), String.valueOf(this.bqb.user_info.live_id), "", this.bqb.user_info.aOa, this.bqb.user_info.portrait)));
            }
        }
    }

    private void cjv() {
        if (this.oiR != null && this.bqb != null && this.bqb.user_info != null && !TextUtils.isEmpty(this.bqb.user_info.live_id)) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.oiR.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bqb.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.oiR.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cjq() {
        if (this.bqb != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oiR.getActivity());
            } else if (this.bqb.user_info == null || JavaTypesHelper.toLong(this.bqb.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.oiR.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.bqb.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oiR.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                c cVar = new c();
                cVar.bnz = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bqb.user_info));
                this.oiR.finish();
            }
        }
    }

    private void cjw() {
        String str;
        if (this.bqb != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oiR.getActivity());
                this.oiR.finish();
            } else if (this.bqb.user_info == null || TextUtils.equals(this.bqb.user_info.user_id, TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oiR.getActivity(), a.h.ala_cannot_follow_myself);
            } else {
                if (this.hCQ) {
                    wu(1);
                    this.oiR.cjc();
                } else {
                    wu(0);
                    this.oiR.cjb();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hCQ ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aKf) {
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

    public void wu(int i) {
        switch (i) {
            case 0:
                this.hCQ = true;
                nU(true);
                if (this.bqb != null && this.bqb.user_info != null) {
                    this.bqb.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bqb.user_info.fans_count >= 0 ? this.bqb.user_info.fans_count : 0L);
                    this.hCq.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hCs.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hCQ = false;
                nU(false);
                if (this.bqb != null && this.bqb.user_info != null) {
                    this.bqb.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bqb.user_info.fans_count >= 0 ? this.bqb.user_info.fans_count : 0L);
                    this.hCq.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hCs.setText(formatForPersonCardBeanValue2[1]);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    private View mv(boolean z) {
        return LayoutInflater.from(this.oiR.getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void nW(boolean z) {
        this.hzy = z;
    }

    public void av(Intent intent) {
        this.oiJ = intent;
    }

    public void nX(boolean z) {
        this.hCT = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.7
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.gKH == null) {
                        PersonCardViewNew.this.gKH = AnimationUtils.loadAnimation(PersonCardViewNew.this.oiR.getActivity(), a.C0197a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hCK.setAnimation(PersonCardViewNew.this.gKH);
                    PersonCardViewNew.this.hCK.setVisibility(0);
                    PersonCardViewNew.this.gKH.setDuration(300L);
                    PersonCardViewNew.this.gKH.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hCK != null) {
            this.hCK.clearAnimation();
        }
        if (this.oiV != null && this.oiV.isShowing()) {
            this.oiV.dismiss();
        }
    }

    public Animation bUe() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gKH != null) {
            this.gKH.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.oiR.getActivity(), a.C0197a.sdk_push_up_out);
        this.hCK.setAnimation(loadAnimation);
        this.hCK.setVisibility(8);
        return loadAnimation;
    }

    public void aQ(String str, String str2) {
        this.bnV = JavaTypesHelper.toLong(str, 0L);
        this.fYr = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
