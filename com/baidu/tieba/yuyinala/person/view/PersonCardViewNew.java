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
    private boolean aIu;
    private long bmk;
    private PersonUserData boq;
    private long fXY;
    private Animation gKo;
    private TextView hBV;
    private TextView hBW;
    private TextView hBX;
    private TextView hBY;
    private TextView hBZ;
    private boolean hCA;
    private boolean hCD;
    private TextView hCa;
    private TextView hCb;
    private TextView hCc;
    private TextView hCd;
    private TextView hCe;
    private TextView hCf;
    private TextView hCi;
    private TextView hCj;
    private TextView hCk;
    private TextView hCl;
    private TextView hCm;
    private ViewGroup hCn;
    private HeadImageView hCo;
    private TbImageView hCp;
    private LinearLayout hCq;
    private View hCr;
    private View hCs;
    private View hCt;
    private View hCu;
    private HeadImageView hCv;
    private boolean hCx;
    private String hCy;
    private boolean hCz;
    private boolean hzf;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView = mw(false);
    private ImageView okA;
    private Intent okm;
    protected final PersonCardActivity oku;
    private TextView okv;
    private a.InterfaceC0929a okw;
    private com.baidu.tieba.yuyinala.person.view.a okx;
    private com.baidu.tieba.yuyinala.person.a oky;
    private a okz;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes4.dex */
    public interface a {
        void ciy();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.oku = personCardActivity;
        this.hCD = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.eaP();
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.okx = new com.baidu.tieba.yuyinala.person.view.a(personCardActivity, this.mRootView.findViewById(a.f.user_icon_layout), this.mRootView);
    }

    public void eaP() {
        if (this.okm != null) {
            ab abVar = new ab(this.oku);
            abVar.setIntent(this.okm);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, abVar));
        }
    }

    public void a(a aVar) {
        this.okz = aVar;
    }

    private void initView() {
        this.hCr = this.mRootView.findViewById(a.f.person_card_layout);
        this.hBV = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hCi = (TextView) this.mRootView.findViewById(a.f.report_text_view);
        this.hBW = (TextView) this.mRootView.findViewById(a.f.user_name);
        this.hBX = (TextView) this.mRootView.findViewById(a.f.fans_num);
        this.hBY = (TextView) this.mRootView.findViewById(a.f.bean_num);
        this.hBZ = (TextView) this.mRootView.findViewById(a.f.fans_num_unit);
        this.hCb = (TextView) this.mRootView.findViewById(a.f.bean_num_unit);
        this.hCa = (TextView) this.mRootView.findViewById(a.f.attention_num_unit);
        this.hCc = (TextView) this.mRootView.findViewById(a.f.user_location);
        this.hCd = (TextView) this.mRootView.findViewById(a.f.attention_num);
        this.hCe = (TextView) this.mRootView.findViewById(a.f.user_id);
        this.hCm = (TextView) this.mRootView.findViewById(a.f.user_desc);
        this.hCf = (TextView) this.mRootView.findViewById(a.f.btn_person_card_follow);
        this.hCl = (TextView) this.mRootView.findViewById(a.f.user_receive_charm);
        this.hCq = (LinearLayout) this.mRootView.findViewById(a.f.bottom_layout);
        this.hCs = this.mRootView.findViewById(a.f.user_divide);
        this.hCt = this.mRootView.findViewById(a.f.user_divide2);
        this.hCj = (TextView) this.mRootView.findViewById(a.f.btn_person_card_nav_liveroom);
        this.okv = (TextView) this.mRootView.findViewById(a.f.btn_person_single_message);
        this.hCk = (TextView) this.mRootView.findViewById(a.f.btn_person_card_ate);
        this.okA = (ImageView) this.mRootView.findViewById(a.f.user_sex);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hCj.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.okv.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.hCk.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.hCj.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.okv.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
            this.hCk.setBackgroundResource(a.e.yuyin_ala_person_card_bottom_tab_text_bg_gray);
        }
        this.hCn = (ViewGroup) this.mRootView.findViewById(a.f.layout_avatar);
        this.hCo = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hCo.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.hCo.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.hCo.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hCo.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.hCo.setIsRound(true);
        this.hCo.setAutoChangeStyle(false);
        this.hCo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hCo.setBorderWidth(BdUtilHelper.getDimens(this.oku.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hCo.setBorderColor(-1);
        this.hCi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.ciN();
            }
        });
        this.hCo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (b.Wy().iP(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()))) {
                    Toast.makeText(PersonCardViewNew.this.oku, PersonCardViewNew.this.oku.getString(a.h.yuyin_ala_person_isonwheat), 1).show();
                } else if (b.Wy().isApplying()) {
                    Toast.makeText(PersonCardViewNew.this.oku, PersonCardViewNew.this.oku.getString(a.h.yuyin_ala_person_isapplying), 1).show();
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hCy) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hCy);
                    }
                } else {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.oku.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                        b.Wy().muteOrUnmuteAudio(true);
                        PersonCardViewNew.this.oku.finish();
                    }
                }
            }
        });
        this.hCu = this.mRootView.findViewById(a.f.layout_charm_rank);
        this.hCv = (HeadImageView) this.mRootView.findViewById(a.f.avatar_charm);
        this.hCv.setIsRound(true);
        this.hCv.setAutoChangeStyle(false);
        this.hCv.setDrawBorder(false);
        this.hCv.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void initListener() {
        this.hBV.setOnClickListener(this);
        this.hCj.setOnClickListener(this);
        this.okv.setOnClickListener(this);
        this.hCk.setOnClickListener(this);
        this.hCf.setOnClickListener(this);
        a(new a.InterfaceC0929a() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.yuyinala.person.a.InterfaceC0929a
            public void ciB() {
                PersonCardViewNew.this.oku.ciw();
            }
        });
    }

    public void a(a.InterfaceC0929a interfaceC0929a) {
        this.okw = interfaceC0929a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.boq = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            i(personUserData);
            this.okx.setData(personUserData.user_info);
            if (this.hzf) {
                this.hCq.setVisibility(8);
            }
            if (this.hCq != null && this.hCq.getVisibility() == 0) {
                int childCount = this.hCq.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hCq.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hCq.getResources().getDimensionPixelOffset(i2 >= 3 ? a.d.sdk_ds20 : a.d.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hCq.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.hCq.setWeightSum(i2);
                this.hCq.requestLayout();
            }
        }
    }

    private void e(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aIu = personUserData.user_info != null && this.oku.Id(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hCy = personUserData.user_info != null ? personUserData.user_info.aMv : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.hCz = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.hCz) {
                this.hCq.setVisibility(8);
            } else {
                this.hCq.setVisibility(0);
            }
            if (!z) {
                this.hCc.setText("火星");
            } else {
                this.hCc.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hCl.setVisibility(8);
                this.hCt.setVisibility(8);
            } else {
                this.hCl.setText(String.format(this.oku.getString(a.h.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hCt.setVisibility(0);
                this.hCl.setVisibility(0);
            }
            if (z2) {
                this.hCe.setText(String.format(this.oku.getString(a.h.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hCe.setVisibility(0);
                this.hCs.setVisibility(0);
                return;
            }
            this.hCe.setVisibility(8);
            this.hCs.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciN() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.oku.getActivity());
            this.oku.finish();
        } else if (this.oku != null) {
            this.oku.ciw();
        }
    }

    private void f(PersonUserData personUserData) {
        aq aqVar = personUserData.user_info;
        if (aqVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(aqVar.fans_count < 0 ? 0L : aqVar.fans_count);
            this.hBX.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hBZ.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(aqVar.follow_count >= 0 ? aqVar.follow_count : 0L);
            this.hCd.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hCa.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hBY.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hCb.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hCb.setText("");
            }
            int i = this.hCD ? 26 : 30;
            if (this.screenWidth < 360) {
                i = this.hCD ? 22 : 26;
            }
            this.hBX.setTextSize(1, i);
            this.hCd.setTextSize(1, i);
            this.hBY.setTextSize(1, i);
            if (personUserData.user_info == null || TextUtils.equals(personUserData.user_info.user_id, "0") || TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id)) {
                this.hBV.setVisibility(8);
                this.hCi.setVisibility(8);
            } else {
                this.hCi.setVisibility(0);
                if (personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowManagerBtn) {
                    if (personUserData.mYuyinBanMangerData.userIndentity == 2 && personUserData.mYuyinBanMangerData.userCardIndentity != 3) {
                        this.hBV.setVisibility(8);
                    } else {
                        this.hBV.setVisibility(0);
                    }
                } else {
                    this.hBV.setVisibility(8);
                }
            }
            if (com.baidu.live.aa.b.Pr().Ps() && personUserData.mYuyinBanMangerData != null && personUserData.mYuyinBanMangerData.isShowSinglePrivate) {
                this.okv.setVisibility(0);
            } else {
                this.okv.setVisibility(8);
            }
            if (personUserData.user_info.gender == 2) {
                this.okA.setVisibility(8);
                return;
            }
            this.okA.setVisibility(0);
            this.okA.setImageResource(personUserData.user_info.gender == 0 ? a.e.sdk_icon_mine_girl : a.e.sdk_icon_mine_boy);
        }
    }

    private void g(PersonUserData personUserData) {
        aq aqVar = personUserData.user_info;
        if (aqVar != null && !StringUtils.isNull(aqVar.getNameShow())) {
            String nameShow = aqVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hBW.setText(nameShow);
        }
        l.a(this.hCo, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (aqVar != null) {
            if (StringUtils.isNull(aqVar.description)) {
                this.hCm.setText(a.h.ala_person_desc_default_text);
            } else {
                this.hCm.setText(aqVar.description);
            }
            If(aqVar.aMr);
        }
    }

    private void If(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hCp == null) {
                this.hCp = new TbImageView(this.hCn.getContext());
            }
            this.hCp.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.5
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    int realScreenWidth;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hCn != null && PersonCardViewNew.this.hCp != null && PersonCardViewNew.this.hCp.getLoadedWidth() > 0 && PersonCardViewNew.this.hCp.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f = resources.getDisplayMetrics().density;
                            if (f > 0.0f) {
                                float f2 = 3.0f / f;
                            }
                        }
                        if (PersonCardViewNew.this.hCD) {
                            realScreenWidth = resources.getDimensionPixelOffset(a.d.sdk_ds800);
                        } else {
                            realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                        }
                        float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hCp.getLoadedWidth();
                        ViewGroup.LayoutParams layoutParams = PersonCardViewNew.this.hCn.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = -1;
                            layoutParams.height = (int) (loadedWidth * PersonCardViewNew.this.hCp.getLoadedHeight());
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((-0.55f) * layoutParams.height);
                            }
                            PersonCardViewNew.this.hCn.setLayoutParams(layoutParams);
                        }
                        if (PersonCardViewNew.this.hCo != null) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hCo.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams2.removeRule(14);
                            } else {
                                layoutParams2.addRule(14, 0);
                            }
                            layoutParams2.addRule(13);
                            PersonCardViewNew.this.hCo.setPadding(2, 2, 2, 2);
                            PersonCardViewNew.this.hCo.setLayoutParams(layoutParams2);
                        }
                        if (PersonCardViewNew.this.hCn.indexOfChild(PersonCardViewNew.this.hCp) < 0) {
                            PersonCardViewNew.this.hCn.addView(PersonCardViewNew.this.hCp, PersonCardViewNew.this.hCn.indexOfChild(PersonCardViewNew.this.hCo) + 1, new ViewGroup.LayoutParams(-1, -1));
                        }
                        if (PersonCardViewNew.this.hCi.getVisibility() == 0 && PersonCardViewNew.this.hBV.getVisibility() == 0) {
                            PersonCardViewNew.this.hBV.setPadding(PersonCardViewNew.this.hBV.getPaddingLeft(), PersonCardViewNew.this.hBV.getPaddingTop(), resources.getDimensionPixelOffset(a.d.sdk_ds16), PersonCardViewNew.this.hBV.getPaddingBottom());
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hBV.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= 17) {
                                layoutParams3.removeRule(1);
                            } else {
                                layoutParams3.addRule(1, 0);
                            }
                            layoutParams3.addRule(11);
                            PersonCardViewNew.this.hBV.setLayoutParams(layoutParams3);
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hCp.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hCx = false;
            nV(false);
        } else if (!this.hCz && (alaRelationData = personUserData.relation_info) != null) {
            this.hCx = alaRelationData.follow_status != 0;
            if (z) {
                this.hCf.setVisibility(8);
            } else {
                nV(this.hCx);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hCu.setVisibility(0);
            this.hCu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.okz != null) {
                        PersonCardViewNew.this.okz.ciy();
                    }
                }
            });
            this.hCv.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hCu.setVisibility(4);
    }

    private void nV(boolean z) {
        if (z) {
            this.hCf.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hCf.setBackgroundResource(a.e.ala_person_card_followed_bg_bd);
            }
            this.hCf.setAlpha(0.2f);
        } else {
            this.hCf.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hCf.setBackgroundResource(a.e.ala_person_card_bottom_tab_text_bg_bd_selector);
            }
            this.hCf.setAlpha(1.0f);
        }
        this.hCf.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hCj != null && personUserData != null && personUserData.user_info != null) {
            this.hCj.setVisibility((this.hCA && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hCf) {
            ciP();
        } else if (view == this.hCk) {
            ciJ();
        } else if (view == this.hCj) {
            ciO();
        } else if (view == this.hBV) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501060, new Object[]{this.oku, this.boq}));
        } else if (view == this.okv) {
            eaQ();
        }
    }

    private void eaQ() {
        if (this.boq != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oku.getActivity());
            } else if (this.boq.user_info != null && JavaTypesHelper.toLong(this.boq.user_info.user_id, 0L) != 0 && !this.boq.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ae(this.oku.getApplicationContext(), this.boq.user_info.user_id, this.boq.user_info.getNameShow(), "media".equals(this.boq.user_info.type) ? "80" : "0", "media".equals(this.boq.user_info.loginType), String.valueOf(this.boq.user_info.live_id), "", this.boq.user_info.aMp, this.boq.user_info.portrait)));
            }
        }
    }

    private void ciO() {
        if (this.oku != null && this.boq != null && this.boq.user_info != null && !TextUtils.isEmpty(this.boq.user_info.live_id)) {
            try {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.oku.getPageContext().getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.boq.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                this.oku.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void ciJ() {
        if (this.boq != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oku.getActivity());
            } else if (this.boq.user_info == null || JavaTypesHelper.toLong(this.boq.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.oku.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.boq.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oku.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                c cVar = new c();
                cVar.blO = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.boq.user_info));
                this.oku.finish();
            }
        }
    }

    private void ciP() {
        String str;
        if (this.boq != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.oku.getActivity());
                this.oku.finish();
            } else if (this.boq.user_info == null || TextUtils.equals(this.boq.user_info.user_id, TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.oku.getActivity(), a.h.ala_cannot_follow_myself);
            } else {
                if (this.hCx) {
                    wS(1);
                    this.oku.civ();
                } else {
                    wS(0);
                    this.oku.ciu();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hCx ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aIu) {
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

    public void wS(int i) {
        switch (i) {
            case 0:
                this.hCx = true;
                nV(true);
                if (this.boq != null && this.boq.user_info != null) {
                    this.boq.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.boq.user_info.fans_count >= 0 ? this.boq.user_info.fans_count : 0L);
                    this.hBX.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hBZ.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hCx = false;
                nV(false);
                if (this.boq != null && this.boq.user_info != null) {
                    this.boq.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.boq.user_info.fans_count >= 0 ? this.boq.user_info.fans_count : 0L);
                    this.hBX.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hBZ.setText(formatForPersonCardBeanValue2[1]);
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

    private View mw(boolean z) {
        return LayoutInflater.from(this.oku.getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void nX(boolean z) {
        this.hzf = z;
    }

    public void av(Intent intent) {
        this.okm = intent;
    }

    public void nY(boolean z) {
        this.hCA = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.person.view.PersonCardViewNew.7
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.gKo == null) {
                        PersonCardViewNew.this.gKo = AnimationUtils.loadAnimation(PersonCardViewNew.this.oku.getActivity(), a.C0195a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hCr.setAnimation(PersonCardViewNew.this.gKo);
                    PersonCardViewNew.this.hCr.setVisibility(0);
                    PersonCardViewNew.this.gKo.setDuration(300L);
                    PersonCardViewNew.this.gKo.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hCr != null) {
            this.hCr.clearAnimation();
        }
        if (this.oky != null && this.oky.isShowing()) {
            this.oky.dismiss();
        }
    }

    public Animation bTx() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gKo != null) {
            this.gKo.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.oku.getActivity(), a.C0195a.sdk_push_up_out);
        this.hCr.setAnimation(loadAnimation);
        this.hCr.setVisibility(8);
        return loadAnimation;
    }

    public void aP(String str, String str2) {
        this.bmk = JavaTypesHelper.toLong(str, 0L);
        this.fXY = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
