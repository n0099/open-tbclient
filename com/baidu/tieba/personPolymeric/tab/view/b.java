package com.baidu.tieba.personPolymeric.tab.view;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.cc;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.view.RoundRelativeLayout;
import tbclient.BaijiahaoInfo;
/* loaded from: classes24.dex */
public class b {
    private String jIR;
    private LinearLayout lTH;
    private TextView lTI;
    private TextView lTJ;
    private TextView lTL;
    private TextView lTM;
    private TextView lXK;
    private com.baidu.tieba.personPolymeric.c.a lYD;
    private AlignTextView lZB;
    private LinearLayout lZC;
    private TextView lZD;
    private AlignTextView lZE;
    private AlignTextView lZF;
    private ImageView lZG;
    private RelativeLayout lZH;
    private RelativeLayout lZI;
    private TextView lZJ;
    private ImageView lZK;
    private View lZL;
    private ImageView lZM;
    private TextView lZN;
    private RoundRelativeLayout lZO;
    private TextView lZP;
    private TextView lZQ;
    private ImageView lZR;
    private ImageView lZS;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.lZH || view == b.this.lZG) {
                if (b.this.mIsHost) {
                    b.this.dtE();
                } else {
                    PersonIntroductionActivity.aW(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.lZJ) {
                b.this.dtE();
            } else if (view == b.this.lZK) {
                b.this.dtE();
            } else if (view == b.this.lZO) {
                if (StringUtils.isNull(b.this.jIR)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bmI();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.jIR);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new aq("c13899").dR("uid", b.this.mUserData.getUserId()));
            }
        }
    };
    private boolean mIsHost;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitleView;
    private UserData mUserData;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_information_header, (ViewGroup) null);
        this.mRootView.setVisibility(8);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.person_information_title);
        this.lTL = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.lZB = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.lZB.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lTM = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.lZC = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.lZL = this.mRootView.findViewById(R.id.space_view);
        this.lZD = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.lTI = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.lTH = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.lZE = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.lZE.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lTJ = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.lZF = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.lZF.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lXK = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.lZG = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.lZG.setOnClickListener(this.mClickListener);
        this.lZH = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.lZH.setOnClickListener(this.mClickListener);
        this.lZI = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.lZJ = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.lZJ.setOnClickListener(this.mClickListener);
        this.lZM = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.lZN = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.lZO = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.lZO.setOnClickListener(this.mClickListener);
        this.lZS = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.lZR = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.lZQ = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.lZP = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.lZK = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.lZK.setOnClickListener(this.mClickListener);
        int measureText = (int) this.lZD.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.lZB.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.lZB.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.lZE.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.lZE.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.lZF.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.lZF.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dS(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.lYD = aVar;
            this.mUserData = aVar.getUserData();
            this.mRootView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RecyclerView.LayoutParams(-1, -2);
            } else {
                layoutParams.width = -1;
            }
            this.mRootView.setLayoutParams(layoutParams);
            if (this.mUserData.getAlaUserData() != null && this.mUserData.getAlaUserData().ala_id > 0) {
                this.lTH.setVisibility(0);
                this.lTI.setVisibility(0);
                this.lTI.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.lTH.setVisibility(8);
                this.lTI.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (at.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.lTJ.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cc birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !at.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eBL == 2) {
                    this.lTM.setVisibility(0);
                    this.lTM.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.lTM.setVisibility(8);
                }
                this.lTL.setVisibility(0);
                this.lTL.setText(birthdayInfo.constellation);
                this.lZC.setVisibility(0);
            } else {
                this.lZC.setVisibility(8);
                this.lTL.setVisibility(8);
                this.lTM.setVisibility(8);
            }
            if (this.mIsHost) {
                this.lZK.setVisibility(0);
            } else {
                this.lZK.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!at.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.lTJ.getLeft(), 0), 0, spannableString.length(), 18);
                    this.lXK.setText(spannableString);
                    e.mY().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.lXK.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.lZH.setOnClickListener(null);
                                    b.this.lZG.setVisibility(8);
                                    return;
                                }
                                b.this.lZH.setOnClickListener(b.this.mClickListener);
                                b.this.lZG.setVisibility(0);
                            }
                        }
                    });
                    this.lZI.setVisibility(8);
                    this.lZL.setVisibility(0);
                } else {
                    this.lZH.setVisibility(8);
                    if (this.mIsHost) {
                        this.lZI.setVisibility(0);
                        this.lZK.setVisibility(8);
                        this.lZL.setVisibility(8);
                    } else {
                        this.lZI.setVisibility(8);
                        this.lZL.setVisibility(0);
                    }
                }
            } else if (at.isEmpty(intro)) {
                this.lZH.setVisibility(8);
                if (this.mIsHost) {
                    this.lZI.setVisibility(0);
                    this.lZK.setVisibility(8);
                    this.lZL.setVisibility(8);
                } else {
                    this.lZI.setVisibility(8);
                    this.lZL.setVisibility(0);
                }
            } else {
                this.lZI.setVisibility(8);
                this.lZH.setVisibility(8);
                this.lZL.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.lZO.setVisibility(0);
                this.jIR = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.jIR)) {
                    this.jIR = "";
                }
                this.lZP.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.jIR));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.lZQ.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.lZQ.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.lZQ.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new aq("c13898").dR("uid", this.mUserData.getUserId()));
                return;
            }
            this.lZO.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.boN().a(this.lZK, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.boN().a(this.lZG, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lZB, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lTL, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lTM, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lZD, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lTI, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lZE, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lTJ, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lZF, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lXK, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lZN, R.color.cp_cont_b, 1, i);
        ap.setBackgroundColor(this.lZO, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.lZP, R.color.cp_other_e);
        ap.setViewTextColor(this.lZQ, R.color.cp_other_e);
        SvgManager.boN().a(this.lZR, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.boN().a(this.lZS, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtE() {
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.mUserData != null) {
                personChangeData.setPortrait(this.mUserData.getPortrait());
                personChangeData.setName(this.mUserData.getUserName());
                personChangeData.setSex(this.mUserData.getSex());
                personChangeData.setIntro(this.mUserData.getIntro());
                personChangeData.setNameShow(this.mUserData.getName_show());
                personChangeData.setMem(this.mUserData.getIsMem());
                personChangeData.setForumAge(this.mUserData.getTb_age());
                personChangeData.setCanModifyAvatar(this.mUserData.canModifyAvatar());
                personChangeData.setCantModifyAvatarDesc(this.mUserData.getCantModifyAvatarDesc());
                if (this.mUserData.alaUserData != null) {
                    personChangeData.setAlaId(this.mUserData.alaUserData.ala_id);
                }
                if (this.lYD.lXj != null) {
                    personChangeData.setNickNameLeftDays(this.lYD.lXj.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eBK);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eBL);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void ax(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
