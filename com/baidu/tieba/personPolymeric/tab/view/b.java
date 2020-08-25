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
/* loaded from: classes18.dex */
public class b {
    private String iYI;
    private LinearLayout liV;
    private TextView liW;
    private TextView liX;
    private TextView liZ;
    private TextView lja;
    private TextView lmU;
    private com.baidu.tieba.personPolymeric.c.a lnK;
    private AlignTextView loM;
    private LinearLayout loN;
    private TextView loO;
    private AlignTextView loP;
    private AlignTextView loQ;
    private ImageView loR;
    private RelativeLayout loS;
    private RelativeLayout loT;
    private TextView loU;
    private ImageView loV;
    private View loW;
    private ImageView loX;
    private TextView loY;
    private RoundRelativeLayout loZ;
    private TextView lpa;
    private TextView lpb;
    private ImageView lpc;
    private ImageView lpd;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.loS || view == b.this.loR) {
                if (b.this.mIsHost) {
                    b.this.djd();
                } else {
                    PersonIntroductionActivity.aP(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.loU) {
                b.this.djd();
            } else if (view == b.this.loV) {
                b.this.djd();
            } else if (view == b.this.loZ) {
                if (StringUtils.isNull(b.this.iYI)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bhm();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.iYI);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new aq("c13899").dD("uid", b.this.mUserData.getUserId()));
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
        this.liZ = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.loM = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.loM.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lja = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.loN = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.loW = this.mRootView.findViewById(R.id.space_view);
        this.loO = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.liW = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.liV = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.loP = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.loP.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.liX = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.loQ = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.loQ.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lmU = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.loR = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.loR.setOnClickListener(this.mClickListener);
        this.loS = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.loS.setOnClickListener(this.mClickListener);
        this.loT = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.loU = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.loU.setOnClickListener(this.mClickListener);
        this.loX = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.loY = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.loZ = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.loZ.setOnClickListener(this.mClickListener);
        this.lpd = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.lpc = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.lpb = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.lpa = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.loV = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.loV.setOnClickListener(this.mClickListener);
        int measureText = (int) this.loO.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.loM.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.loM.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.loP.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.loP.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.loQ.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.loQ.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dE(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.lnK = aVar;
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
                this.liV.setVisibility(0);
                this.liW.setVisibility(0);
                this.liW.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.liV.setVisibility(8);
                this.liW.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (at.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.liX.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cc birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !at.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eeN == 2) {
                    this.lja.setVisibility(0);
                    this.lja.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.lja.setVisibility(8);
                }
                this.liZ.setVisibility(0);
                this.liZ.setText(birthdayInfo.constellation);
                this.loN.setVisibility(0);
            } else {
                this.loN.setVisibility(8);
                this.liZ.setVisibility(8);
                this.lja.setVisibility(8);
            }
            if (this.mIsHost) {
                this.loV.setVisibility(0);
            } else {
                this.loV.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!at.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.liX.getLeft(), 0), 0, spannableString.length(), 18);
                    this.lmU.setText(spannableString);
                    e.mS().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.lmU.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.loS.setOnClickListener(null);
                                    b.this.loR.setVisibility(8);
                                    return;
                                }
                                b.this.loS.setOnClickListener(b.this.mClickListener);
                                b.this.loR.setVisibility(0);
                            }
                        }
                    });
                    this.loT.setVisibility(8);
                    this.loW.setVisibility(0);
                } else {
                    this.loS.setVisibility(8);
                    if (this.mIsHost) {
                        this.loT.setVisibility(0);
                        this.loV.setVisibility(8);
                        this.loW.setVisibility(8);
                    } else {
                        this.loT.setVisibility(8);
                        this.loW.setVisibility(0);
                    }
                }
            } else if (at.isEmpty(intro)) {
                this.loS.setVisibility(8);
                if (this.mIsHost) {
                    this.loT.setVisibility(0);
                    this.loV.setVisibility(8);
                    this.loW.setVisibility(8);
                } else {
                    this.loT.setVisibility(8);
                    this.loW.setVisibility(0);
                }
            } else {
                this.loT.setVisibility(8);
                this.loS.setVisibility(8);
                this.loW.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.loZ.setVisibility(0);
                this.iYI = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.iYI)) {
                    this.iYI = "";
                }
                this.lpa.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.iYI));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.lpb.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.lpb.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.lpb.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new aq("c13898").dD("uid", this.mUserData.getUserId()));
                return;
            }
            this.loZ.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bjq().a(this.loV, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bjq().a(this.loR, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.loM, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.liZ, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lja, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.loO, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.liW, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.loP, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.liX, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.loQ, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lmU, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.loY, R.color.cp_cont_b, 1, i);
        ap.setBackgroundColor(this.loZ, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.lpa, R.color.cp_other_e);
        ap.setViewTextColor(this.lpb, R.color.cp_other_e);
        SvgManager.bjq().a(this.lpc, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a(this.lpd, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djd() {
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
                if (this.lnK.lmt != null) {
                    personChangeData.setNickNameLeftDays(this.lnK.lmt.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eeM);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eeN);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void at(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
