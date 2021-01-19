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
/* loaded from: classes10.dex */
public class PersonCardViewNew implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private boolean aGY;
    private long brk;
    private PersonUserData bty;
    private long gmc;
    private boolean hQm;
    private TextView hTA;
    private TextView hTB;
    private TextView hTC;
    private TextView hTD;
    private TextView hTE;
    private TextView hTF;
    private TextView hTJ;
    private TextView hTK;
    private TextView hTL;
    private TextView hTM;
    private TextView hTN;
    private ViewGroup hTO;
    private TbImageView hTP;
    private LinearLayout hTQ;
    private View hTT;
    private View hTU;
    private View hTV;
    private HeadImageView hTW;
    private boolean hTY;
    private String hTZ;
    private View hTi;
    private TextView hTn;
    private HeadImageView hTo;
    private boolean hTs;
    private TextView hTx;
    private TextView hTy;
    private TextView hTz;
    private boolean hUa;
    private boolean hUb;
    private Animation haJ;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView = nn(false);
    private a.InterfaceC0943a oCA;
    private com.baidu.tieba.yuyinala.person.view.a oCB;
    private com.baidu.tieba.yuyinala.person.a oCC;
    private a oCD;
    private ImageView oCE;
    private Intent oCo;
    protected final PersonCardActivity oCx;
    private AlaLoadingButton oCy;
    private TextView oCz;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes10.dex */
    public interface a {
        void clt();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.oCx = personCardActivity;
        this.hTs = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.oCB = new com.baidu.tieba.yuyinala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void edj() {
        if (this.oCo != null) {
            ac acVar = new ac(this.oCx);
            acVar.setIntent(this.oCo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, acVar));
        }
    }

    public void a(a aVar) {
        this.oCD = aVar;
    }

    private void initView() {
        this.hTi = this.mRootView.findViewById(a.f.person_card_layout);
        this.hTn = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hTJ = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.hTx = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hTy = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hTz = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hTA = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hTC = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hTB = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hTD = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hTE = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hTF = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hTN = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.oCy = (AlaLoadingButton) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hTM = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hTQ = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hTT = this.mRootView.findViewById(a.f.user_divide);
        this.hTU = this.mRootView.findViewById(a.f.user_divide2);
        this.hTK = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.oCz = (TextView) this.mRootView.findViewById(a.f.btn_person_single_message);
        this.hTL = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.oCE = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hTK.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.oCz.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.hTL.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.hTK.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.oCz.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.hTL.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
        }
        this.hTO = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hTo = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hTo.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.hTo.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.hTo.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hTo.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.hTo.setIsRound(true);
        this.hTo.setAutoChangeStyle(false);
        this.hTo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hTo.setBorderWidth(BdUtilHelper.getDimens(this.oCx.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hTo.setBorderColor(-1);
        this.hTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.clJ();
            }
        });
        this.hTo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (com.baidu.live.aq.a.Wu().ib(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                    Toast.makeText(PersonCardViewNew.this.oCx, PersonCardViewNew.this.oCx.getString(a.h.yuyin_ala_person_isonwheat), 1).show();
                } else if (com.baidu.live.aq.a.Wu().isApplying()) {
                    Toast.makeText(PersonCardViewNew.this.oCx, PersonCardViewNew.this.oCx.getString(a.h.yuyin_ala_person_isapplying), 1).show();
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hTZ) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hTZ);
                    }
                } else {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.oCx.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                        com.baidu.live.aq.a.Wu().muteOrUnmuteAudio(true);
                        PersonCardViewNew.this.oCx.finish();
                    }
                }
            }
        });
        this.hTV = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hTW = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hTW.setIsRound(true);
        this.hTW.setAutoChangeStyle(false);
        this.hTW.setDrawBorder(false);
        this.hTW.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void initListener() {
        this.oCx.a(new PersonCardActivity.a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.yuyinala.person.PersonCardActivity.a
            public void cnx() {
                PersonCardViewNew.this.edj();
            }
        });
        this.hTn.setOnClickListener(this);
        this.hTK.setOnClickListener(this);
        this.oCz.setOnClickListener(this);
        this.hTL.setOnClickListener(this);
        this.oCy.setOnClickListener(this);
        a(new a.InterfaceC0943a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.yuyinala.person.a.InterfaceC0943a
            public void clw() {
                PersonCardViewNew.this.oCx.clr();
            }
        });
    }

    public void a(a.InterfaceC0943a interfaceC0943a) {
        this.oCA = interfaceC0943a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bty = personUserData;
            d(personUserData);
            f(personUserData);
            b(personUserData, z);
            h(personUserData);
            i(personUserData);
            this.oCB.setData(personUserData.user_info);
            if (this.hQm) {
                this.hTQ.setVisibility(8);
            }
            if (this.hTQ != null && this.hTQ.getVisibility() == 0) {
                if (z) {
                    this.hTL.setVisibility(0);
                    this.oCz.setVisibility(0);
                    this.oCy.setVisibility(0);
                }
                int childCount = this.hTQ.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hTQ.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hTQ.getResources().getDimensionPixelOffset(i2 >= 3 ? a.d.sdk_ds20 : a.d.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hTQ.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hTQ.setWeightSum(i2);
                this.hTQ.requestLayout();
            }
        }
    }

    private void f(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aGY = personUserData.user_info != null && this.oCx.HE(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hTZ = personUserData.user_info != null ? personUserData.user_info.aLw : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.hUa = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.hUa) {
                this.hTQ.setVisibility(8);
            } else {
                this.hTQ.setVisibility(0);
            }
            if (!z) {
                this.hTD.setText("火星");
            } else {
                this.hTD.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hTM.setVisibility(8);
                this.hTU.setVisibility(8);
            } else {
                this.hTM.setText(String.format(this.oCx.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hTU.setVisibility(0);
                this.hTM.setVisibility(0);
            }
            if (z2) {
                this.hTF.setText(String.format(this.oCx.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hTF.setVisibility(0);
                this.hTT.setVisibility(0);
                return;
            }
            this.hTF.setVisibility(8);
            this.hTT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clJ() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.oCx.getActivity());
            this.oCx.finish();
        } else if (this.oCx != null) {
            this.oCx.clr();
        }
    }

    private void d(PersonUserData personUserData) {
        at atVar = personUserData.user_info;
        if (atVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(atVar.fans_count < 0 ? 0L : atVar.fans_count);
            this.hTy.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hTA.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(atVar.follow_count >= 0 ? atVar.follow_count : 0L);
            this.hTE.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hTB.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hTz.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hTC.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hTC.setText("");
            }
            int i = this.hTs ? 26 : 30;
            if (this.screenWidth < 360) {
                i = this.hTs ? 22 : 26;
            }
            this.hTy.setTextSize(1, i);
            this.hTE.setTextSize(1, i);
            this.hTz.setTextSize(1, i);
            if (personUserData.user_info == null || TextUtils.equals(personUserData.user_info.user_id, "0") || TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id)) {
                this.hTn.setVisibility(8);
                this.hTJ.setVisibility(8);
            } else {
                this.hTJ.setVisibility(0);
                if (personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowManagerBtn) {
                    if (personUserData.mYuyinBanMangerData.userIndentity == 2 && personUserData.mYuyinBanMangerData.userCardIndentity != 3) {
                        this.hTn.setVisibility(8);
                    } else {
                        this.hTn.setVisibility(0);
                    }
                } else {
                    this.hTn.setVisibility(8);
                }
            }
            if (b.OU().OV() && personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowSinglePrivate) {
                this.oCz.setVisibility(0);
            } else {
                this.oCz.setVisibility(8);
            }
            if (personUserData.user_info.gender == 2) {
                this.oCE.setVisibility(8);
                return;
            }
            this.oCE.setVisibility(0);
            this.oCE.setImageResource(personUserData.user_info.gender == 0 ? a.e.sdk_icon_mine_girl : a.e.sdk_icon_mine_boy);
        }
    }

    private void g(PersonUserData personUserData) {
        at atVar = personUserData.user_info;
        if (atVar != null && !StringUtils.isNull(atVar.getNameShow())) {
            String nameShow = atVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hTx.setText(nameShow);
        }
        m.a(this.hTo, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (atVar != null) {
            if (StringUtils.isNull(atVar.description)) {
                this.hTN.setText(a.h.ala_person_desc_default_text);
            } else {
                this.hTN.setText(atVar.description);
            }
            HG(atVar.aLs);
        }
    }

    private void HG(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hTP == null) {
                this.hTP = new TbImageView(this.hTO.getContext());
            }
            this.hTP.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.6
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hTO != null && PersonCardViewNew.this.hTP != null && PersonCardViewNew.this.hTP.getLoadedWidth() > 0 && PersonCardViewNew.this.hTP.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hTs) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hTP.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hTO.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hTP.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hTO.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hTo != null) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hTo.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hTo.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hTo.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hTO.indexOfChild(PersonCardViewNew.this.hTP) < 0) {
                            PersonCardViewNew.this.hTO.addView(PersonCardViewNew.this.hTP, PersonCardViewNew.this.hTO.indexOfChild(PersonCardViewNew.this.hTo) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hTJ.getVisibility() == 0 && PersonCardViewNew.this.hTn.getVisibility() == 0) {
                            PersonCardViewNew.this.hTn.setPadding(PersonCardViewNew.this.hTn.getPaddingLeft(), PersonCardViewNew.this.hTn.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hTn.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hTn.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hTn.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hTP.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hTY = false;
            oL(false);
        } else if (!this.hUa && (alaRelationData = personUserData.relation_info) != null) {
            this.hTY = alaRelationData.follow_status != 0;
            if (z) {
                this.oCy.setVisibility(8);
            } else {
                oL(this.hTY);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hTV.setVisibility(0);
            this.hTV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.oCD != null) {
                        PersonCardViewNew.this.oCD.clt();
                    }
                }
            });
            this.hTW.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hTV.setVisibility(4);
    }

    private void oL(boolean z) {
        if (z) {
            this.oCy.setStatus(4);
            this.oCy.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_red);
            this.oCy.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.oCy.setBackgroundResource(a.e.ala_person_card_followed_bg_bd);
            }
            this.oCy.setAlpha(0.2f);
        } else {
            this.oCy.setStatus(1);
            this.oCy.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.oCy.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_bd_selector);
            }
            this.oCy.setAlpha(1.0f);
        }
        this.oCy.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hTK != null && personUserData != null && personUserData.user_info != null) {
            this.hTK.setVisibility((this.hUb && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oCy) {
            clL();
        } else if (view == this.hTL) {
            clE();
        } else if (view == this.hTK) {
            clK();
        } else if (view == this.hTn) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501060, new Object[]{this.oCx, this.bty}));
        } else if (view == this.oCz) {
            edk();
        }
    }

    private void edk() {
        if (this.bty != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oCx.getActivity());
            } else if (this.bty.user_info != null && JavaTypesHelper.toLong(this.bty.user_info.user_id, 0L) != 0 && !this.bty.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new af(this.oCx.getApplicationContext(), this.bty.user_info.user_id, this.bty.user_info.getNameShow(), "media".equals(this.bty.user_info.type) ? "80" : "0", "media".equals(this.bty.user_info.loginType), String.valueOf(this.bty.user_info.live_id), "", this.bty.user_info.aLq, this.bty.user_info.portrait)));
            }
        }
    }

    private void clK() {
        if (this.oCx != null && this.bty != null && this.bty.user_info != null && !TextUtils.isEmpty(this.bty.user_info.live_id)) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.oCx.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bty.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.oCx.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void clE() {
        if (this.bty != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oCx.getActivity());
            } else if (this.bty.user_info == null || JavaTypesHelper.toLong(this.bty.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.oCx.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.bty.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oCx.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                c cVar = new c();
                cVar.bod = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bty.user_info));
                this.oCx.finish();
            }
        }
    }

    private void clL() {
        String str;
        if (this.bty != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oCx.getActivity());
                this.oCx.finish();
            } else if (this.bty.user_info == null || TextUtils.equals(this.bty.user_info.user_id, TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oCx.getActivity(), a.h.ala_cannot_follow_myself);
            } else {
                if (this.hTY) {
                    this.oCx.clq();
                } else {
                    this.oCx.clp();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (this.oCy != null) {
                    this.oCy.setStatus(3);
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hTY ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aGY) {
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

    public void we(int i) {
        switch (i) {
            case 0:
                this.hTY = true;
                oL(true);
                if (this.bty != null && this.bty.user_info != null) {
                    this.bty.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bty.user_info.fans_count >= 0 ? this.bty.user_info.fans_count : 0L);
                    this.hTy.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hTA.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hTY = false;
                oL(false);
                if (this.bty != null && this.bty.user_info != null) {
                    this.bty.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bty.user_info.fans_count >= 0 ? this.bty.user_info.fans_count : 0L);
                    this.hTy.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hTA.setText(formatForPersonCardBeanValue2[1]);
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

    private View nn(boolean z) {
        return LayoutInflater.from(this.oCx.getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void oN(boolean z) {
        this.hQm = z;
    }

    public void at(Intent intent) {
        this.oCo = intent;
    }

    public void oO(boolean z) {
        this.hUb = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.8
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.haJ == null) {
                        PersonCardViewNew.this.haJ = AnimationUtils.loadAnimation(PersonCardViewNew.this.oCx.getActivity(), a.C0194a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hTi.setAnimation(PersonCardViewNew.this.haJ);
                    PersonCardViewNew.this.hTi.setVisibility(0);
                    PersonCardViewNew.this.haJ.setDuration(300L);
                    PersonCardViewNew.this.haJ.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hTi != null) {
            this.hTi.clearAnimation();
        }
        if (this.oCC != null && this.oCC.isShowing()) {
            this.oCC.dismiss();
        }
    }

    public Animation bVW() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.haJ != null) {
            this.haJ.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.oCx.getActivity(), a.C0194a.sdk_push_up_out);
        this.hTi.setAnimation(loadAnimation);
        this.hTi.setVisibility(8);
        return loadAnimation;
    }

    public void aN(String str, String str2) {
        this.brk = JavaTypesHelper.toLong(str, 0L);
        this.gmc = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
