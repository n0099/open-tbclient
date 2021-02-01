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
    private long goL;
    private boolean hUH;
    private View hXD;
    private TextView hXI;
    private HeadImageView hXJ;
    private boolean hXN;
    private TextView hXS;
    private TextView hXT;
    private TextView hXU;
    private TextView hXV;
    private TextView hXW;
    private TextView hXX;
    private TextView hXY;
    private TextView hXZ;
    private TextView hYa;
    private TextView hYe;
    private TextView hYf;
    private TextView hYg;
    private TextView hYh;
    private TextView hYi;
    private ViewGroup hYj;
    private TbImageView hYk;
    private LinearLayout hYl;
    private View hYo;
    private View hYp;
    private View hYq;
    private HeadImageView hYr;
    private boolean hYt;
    private String hYu;
    private boolean hYv;
    private boolean hYw;
    private Animation hdt;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView = ns(false);
    protected final PersonCardActivity oMF;
    private AlaLoadingButton oMG;
    private TextView oMH;
    private a.InterfaceC0947a oMI;
    private com.baidu.tieba.yuyinala.person.view.a oMJ;
    private com.baidu.tieba.yuyinala.person.a oMK;
    private a oML;
    private ImageView oMM;
    private boolean oMN;
    private Intent oMw;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes11.dex */
    public interface a {
        void cmr();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.oMF = personCardActivity;
        this.hXN = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.oMN = true;
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.oMJ = new com.baidu.tieba.yuyinala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void efA() {
        if (this.oMw != null && this.oMN) {
            ac acVar = new ac(this.oMF);
            acVar.setIntent(this.oMw);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
        }
    }

    public void a(a aVar) {
        this.oML = aVar;
    }

    private void initView() {
        this.hXD = this.mRootView.findViewById(a.f.person_card_layout);
        this.hXI = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hYe = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.hXS = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hXT = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hXU = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hXV = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hXX = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hXW = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hXY = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hXZ = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hYa = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hYi = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.oMG = (AlaLoadingButton) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hYh = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hYl = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hYo = this.mRootView.findViewById(a.f.user_divide);
        this.hYp = this.mRootView.findViewById(a.f.user_divide2);
        this.hYf = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.oMH = (TextView) this.mRootView.findViewById(a.f.btn_person_single_message);
        this.hYg = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.oMM = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hYf.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.oMH.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.hYg.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.hYf.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.oMH.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.hYg.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
        }
        this.hYj = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hXJ = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hXJ.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hXJ.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hXJ.setIsRound(true);
        this.hXJ.setAutoChangeStyle(false);
        this.hXJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hXJ.setBorderWidth(BdUtilHelper.getDimens(this.oMF.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hXJ.setBorderColor(-1);
        this.hYe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cmH();
            }
        });
        this.hXJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (com.baidu.live.ao.a.Yj().iH(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                    Toast.makeText(PersonCardViewNew.this.oMF, PersonCardViewNew.this.oMF.getString(a.h.yuyin_ala_person_isonwheat), 1).show();
                } else if (com.baidu.live.ao.a.Yj().isApplying()) {
                    Toast.makeText(PersonCardViewNew.this.oMF, PersonCardViewNew.this.oMF.getString(a.h.yuyin_ala_person_isapplying), 1).show();
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hYu) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hYu);
                    }
                } else {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.oMF.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                        com.baidu.live.ao.a.Yj().muteOrUnmuteAudio(true);
                        PersonCardViewNew.this.oMF.finish();
                    }
                }
            }
        });
        this.hYq = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hYr = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hYr.setIsRound(true);
        this.hYr.setAutoChangeStyle(false);
        this.hYr.setDrawBorder(false);
        this.hYr.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void initListener() {
        this.oMF.a(new PersonCardActivity.a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.yuyinala.person.PersonCardActivity.a
            public void cov() {
                PersonCardViewNew.this.efA();
            }
        });
        this.hXI.setOnClickListener(this);
        this.hYf.setOnClickListener(this);
        this.oMH.setOnClickListener(this);
        this.hYg.setOnClickListener(this);
        this.oMG.setOnClickListener(this);
        a(new a.InterfaceC0947a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.yuyinala.person.a.InterfaceC0947a
            public void cmu() {
                PersonCardViewNew.this.oMF.cmp();
            }
        });
    }

    public void a(a.InterfaceC0947a interfaceC0947a) {
        this.oMI = interfaceC0947a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bxd = personUserData;
            d(personUserData);
            f(personUserData);
            b(personUserData, z);
            h(personUserData);
            i(personUserData);
            this.oMJ.setData(personUserData.user_info);
            if (this.hUH) {
                this.hYl.setVisibility(8);
            }
            if (this.hYl != null && this.hYl.getVisibility() == 0) {
                if (z) {
                    this.hYg.setVisibility(0);
                    this.oMH.setVisibility(0);
                    this.oMG.setVisibility(0);
                }
                int childCount = this.hYl.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hYl.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hYl.getResources().getDimensionPixelOffset(i2 >= 3 ? a.d.sdk_ds20 : a.d.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hYl.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hYl.setWeightSum(i2);
                this.hYl.requestLayout();
            }
        }
    }

    private void f(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aJC = personUserData.user_info != null && this.oMF.Ii(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hYu = personUserData.user_info != null ? personUserData.user_info.aOt : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.hYv = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.hYv) {
                this.hYl.setVisibility(8);
            } else {
                this.hYl.setVisibility(0);
            }
            if (!z) {
                this.hXY.setText("火星");
            } else {
                this.hXY.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hYh.setVisibility(8);
                this.hYp.setVisibility(8);
            } else {
                this.hYh.setText(String.format(this.oMF.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hYp.setVisibility(0);
                this.hYh.setVisibility(0);
            }
            if (z2) {
                this.hYa.setText(String.format(this.oMF.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hYa.setVisibility(0);
                this.hYo.setVisibility(0);
                return;
            }
            this.hYa.setVisibility(8);
            this.hYo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmH() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.oMF.getActivity());
            this.oMF.finish();
        } else if (this.oMF != null) {
            this.oMF.cmp();
        }
    }

    private void d(PersonUserData personUserData) {
        ax axVar = personUserData.user_info;
        if (axVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(axVar.fans_count < 0 ? 0L : axVar.fans_count);
            this.hXT.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hXV.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(axVar.follow_count >= 0 ? axVar.follow_count : 0L);
            this.hXZ.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hXW.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hXU.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hXX.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hXX.setText("");
            }
            int i = this.hXN ? 26 : 30;
            if (this.screenWidth < 360) {
                i = this.hXN ? 22 : 26;
            }
            this.hXT.setTextSize(1, i);
            this.hXZ.setTextSize(1, i);
            this.hXU.setTextSize(1, i);
            if (personUserData.user_info == null || TextUtils.equals(personUserData.user_info.user_id, "0") || TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id)) {
                this.hXI.setVisibility(8);
                this.hYe.setVisibility(8);
            } else {
                this.hYe.setVisibility(0);
                if (personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowManagerBtn) {
                    if (personUserData.mYuyinBanMangerData.userIndentity == 2 && personUserData.mYuyinBanMangerData.userCardIndentity != 3) {
                        this.hXI.setVisibility(8);
                    } else {
                        this.hXI.setVisibility(0);
                    }
                } else {
                    this.hXI.setVisibility(8);
                }
            }
            if (b.Qv().Qw() && personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowSinglePrivate) {
                this.oMH.setVisibility(0);
            } else {
                this.oMH.setVisibility(8);
            }
            if (personUserData.user_info.gender == 2) {
                this.oMM.setVisibility(8);
                return;
            }
            this.oMM.setVisibility(0);
            this.oMM.setImageResource(personUserData.user_info.gender == 0 ? a.e.sdk_icon_mine_girl : a.e.sdk_icon_mine_boy);
        }
    }

    private void g(PersonUserData personUserData) {
        ax axVar = personUserData.user_info;
        if (axVar != null && !StringUtils.isNull(axVar.getNameShow())) {
            String nameShow = axVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hXS.setText(nameShow);
        }
        String str = null;
        if (personUserData != null && personUserData.user_info != null) {
            if (!TextUtils.isEmpty(personUserData.user_info.aOo)) {
                str = personUserData.user_info.aOo;
            } else if (!TextUtils.isEmpty(personUserData.user_info.portrait)) {
                str = personUserData.user_info.portrait;
            }
            m.a(this.hXJ, str, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        }
        if (axVar != null) {
            if (StringUtils.isNull(axVar.description)) {
                this.hYi.setText(a.h.ala_person_desc_default_text);
            } else {
                this.hYi.setText(axVar.description);
            }
            Ik(axVar.aOp);
        }
    }

    private void Ik(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hYk == null) {
                this.hYk = new TbImageView(this.hYj.getContext());
            }
            this.hYk.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.6
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hYj != null && PersonCardViewNew.this.hYk != null && PersonCardViewNew.this.hYk.getLoadedWidth() > 0 && PersonCardViewNew.this.hYk.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hXN) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hYk.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hYj.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hYk.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hYj.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hXJ != null) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXJ.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hXJ.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hXJ.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hYj.indexOfChild(PersonCardViewNew.this.hYk) < 0) {
                            PersonCardViewNew.this.hYj.addView(PersonCardViewNew.this.hYk, PersonCardViewNew.this.hYj.indexOfChild(PersonCardViewNew.this.hXJ) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hYe.getVisibility() == 0 && PersonCardViewNew.this.hXI.getVisibility() == 0) {
                            PersonCardViewNew.this.hXI.setPadding(PersonCardViewNew.this.hXI.getPaddingLeft(), PersonCardViewNew.this.hXI.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hXI.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hXI.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hXI.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hYk.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hYt = false;
            oV(false);
        } else if (!this.hYv && (alaRelationData = personUserData.relation_info) != null) {
            this.hYt = alaRelationData.follow_status != 0;
            if (z) {
                this.oMG.setVisibility(8);
            } else {
                oV(this.hYt);
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
            this.hYq.setVisibility(0);
            this.hYq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.oML != null) {
                        PersonCardViewNew.this.oML.cmr();
                    }
                }
            });
            this.hYr.startLoad(str, 12, false, false);
            return;
        }
        this.hYq.setVisibility(4);
    }

    private void oV(boolean z) {
        if (z) {
            this.oMG.setStatus(4);
            this.oMG.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_red);
            this.oMG.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.oMG.setBackgroundResource(a.e.ala_person_card_followed_bg_bd);
            }
            this.oMG.setAlpha(0.2f);
        } else {
            this.oMG.setStatus(1);
            this.oMG.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.oMG.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_bd_selector);
            }
            this.oMG.setAlpha(1.0f);
        }
        this.oMG.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hYf != null && personUserData != null && personUserData.user_info != null) {
            this.hYf.setVisibility((this.hYw && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oMG) {
            cmJ();
        } else if (view == this.hYg) {
            cmC();
        } else if (view == this.hYf) {
            cmI();
        } else if (view == this.hXI) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501060, new Object[]{this.oMF, this.bxd}));
        } else if (view == this.oMH) {
            efB();
        }
    }

    private void efB() {
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oMF.getActivity());
            } else if (this.bxd.user_info != null && JavaTypesHelper.toLong(this.bxd.user_info.user_id, 0L) != 0 && !this.bxd.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new af(this.oMF.getApplicationContext(), this.bxd.user_info.user_id, this.bxd.user_info.getNameShow(), "media".equals(this.bxd.user_info.type) ? "80" : "0", "media".equals(this.bxd.user_info.loginType), String.valueOf(this.bxd.user_info.live_id), "", this.bxd.user_info.aOm, this.bxd.user_info.portrait)));
            }
        }
    }

    private void cmI() {
        if (this.oMF != null && this.bxd != null && this.bxd.user_info != null && !TextUtils.isEmpty(this.bxd.user_info.live_id)) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.oMF.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bxd.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.oMF.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cmC() {
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oMF.getActivity());
            } else if (this.bxd.user_info == null || JavaTypesHelper.toLong(this.bxd.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.oMF.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.bxd.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oMF.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913123));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                c cVar = new c();
                cVar.brE = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bxd.user_info));
                this.oMF.finish();
            }
        }
    }

    private void cmJ() {
        String str;
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oMF.getActivity());
                this.oMF.finish();
            } else if (this.bxd.user_info == null || TextUtils.equals(this.bxd.user_info.user_id, TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oMF.getActivity(), a.h.ala_cannot_follow_myself);
            } else {
                if (this.hYt) {
                    this.oMF.cmo();
                } else {
                    this.oMF.cmn();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (this.oMG != null) {
                    this.oMG.setStatus(3);
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hYt ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
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
                this.hYt = true;
                oV(true);
                if (this.bxd != null && this.bxd.user_info != null) {
                    this.bxd.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bxd.user_info.fans_count >= 0 ? this.bxd.user_info.fans_count : 0L);
                    this.hXT.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hXV.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hYt = false;
                oV(false);
                if (this.bxd != null && this.bxd.user_info != null) {
                    this.bxd.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bxd.user_info.fans_count >= 0 ? this.bxd.user_info.fans_count : 0L);
                    this.hXT.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hXV.setText(formatForPersonCardBeanValue2[1]);
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
        return LayoutInflater.from(this.oMF.getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void oX(boolean z) {
        this.hUH = z;
    }

    public void at(Intent intent) {
        this.oMw = intent;
    }

    public void oY(boolean z) {
        this.hYw = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.8
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.hdt == null) {
                        PersonCardViewNew.this.hdt = AnimationUtils.loadAnimation(PersonCardViewNew.this.oMF.getActivity(), a.C0195a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hXD.setAnimation(PersonCardViewNew.this.hdt);
                    PersonCardViewNew.this.hXD.setVisibility(0);
                    PersonCardViewNew.this.hdt.setDuration(300L);
                    PersonCardViewNew.this.hdt.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hXD != null) {
            this.hXD.clearAnimation();
        }
        if (this.oMK != null && this.oMK.isShowing()) {
            this.oMK.dismiss();
        }
    }

    public Animation bWA() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hdt != null) {
            this.hdt.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.oMF.getActivity(), a.C0195a.sdk_push_up_out);
        this.hXD.setAnimation(loadAnimation);
        this.hXD.setVisibility(8);
        return loadAnimation;
    }

    public void aN(String str, String str2) {
        this.buN = JavaTypesHelper.toLong(str, 0L);
        this.goL = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
