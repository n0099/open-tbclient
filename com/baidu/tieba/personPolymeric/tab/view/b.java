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
    private String jOP;
    private LinearLayout lZD;
    private TextView lZE;
    private TextView lZF;
    private TextView lZH;
    private TextView lZI;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.mfH || view == b.this.mfG) {
                if (b.this.mIsHost) {
                    b.this.dwg();
                } else {
                    PersonIntroductionActivity.aW(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.mfJ) {
                b.this.dwg();
            } else if (view == b.this.mfK) {
                b.this.dwg();
            } else if (view == b.this.mfO) {
                if (StringUtils.isNull(b.this.jOP)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bpi();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.jOP);
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
    private TextView mdJ;
    private com.baidu.tieba.personPolymeric.c.a meD;
    private AlignTextView mfB;
    private LinearLayout mfC;
    private TextView mfD;
    private AlignTextView mfE;
    private AlignTextView mfF;
    private ImageView mfG;
    private RelativeLayout mfH;
    private RelativeLayout mfI;
    private TextView mfJ;
    private ImageView mfK;
    private View mfL;
    private ImageView mfM;
    private TextView mfN;
    private RoundRelativeLayout mfO;
    private TextView mfP;
    private TextView mfQ;
    private ImageView mfR;
    private ImageView mfS;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_information_header, (ViewGroup) null);
        this.mRootView.setVisibility(8);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.person_information_title);
        this.lZH = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.mfB = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.mfB.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lZI = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.mfC = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.mfL = this.mRootView.findViewById(R.id.space_view);
        this.mfD = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.lZE = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.lZD = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.mfE = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.mfE.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lZF = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.mfF = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.mfF.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.mdJ = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.mfG = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.mfG.setOnClickListener(this.mClickListener);
        this.mfH = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.mfH.setOnClickListener(this.mClickListener);
        this.mfI = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.mfJ = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.mfJ.setOnClickListener(this.mClickListener);
        this.mfM = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.mfN = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.mfO = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.mfO.setOnClickListener(this.mClickListener);
        this.mfS = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.mfR = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.mfQ = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.mfP = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.mfK = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.mfK.setOnClickListener(this.mClickListener);
        int measureText = (int) this.mfD.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.mfB.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.mfB.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mfE.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.mfE.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.mfF.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.mfF.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dS(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.meD = aVar;
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
                this.lZD.setVisibility(0);
                this.lZE.setVisibility(0);
                this.lZE.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.lZD.setVisibility(8);
                this.lZE.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (at.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.lZF.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cc birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !at.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eHA == 2) {
                    this.lZI.setVisibility(0);
                    this.lZI.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.lZI.setVisibility(8);
                }
                this.lZH.setVisibility(0);
                this.lZH.setText(birthdayInfo.constellation);
                this.mfC.setVisibility(0);
            } else {
                this.mfC.setVisibility(8);
                this.lZH.setVisibility(8);
                this.lZI.setVisibility(8);
            }
            if (this.mIsHost) {
                this.mfK.setVisibility(0);
            } else {
                this.mfK.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!at.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.lZF.getLeft(), 0), 0, spannableString.length(), 18);
                    this.mdJ.setText(spannableString);
                    e.mY().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.mdJ.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.mfH.setOnClickListener(null);
                                    b.this.mfG.setVisibility(8);
                                    return;
                                }
                                b.this.mfH.setOnClickListener(b.this.mClickListener);
                                b.this.mfG.setVisibility(0);
                            }
                        }
                    });
                    this.mfI.setVisibility(8);
                    this.mfL.setVisibility(0);
                } else {
                    this.mfH.setVisibility(8);
                    if (this.mIsHost) {
                        this.mfI.setVisibility(0);
                        this.mfK.setVisibility(8);
                        this.mfL.setVisibility(8);
                    } else {
                        this.mfI.setVisibility(8);
                        this.mfL.setVisibility(0);
                    }
                }
            } else if (at.isEmpty(intro)) {
                this.mfH.setVisibility(8);
                if (this.mIsHost) {
                    this.mfI.setVisibility(0);
                    this.mfK.setVisibility(8);
                    this.mfL.setVisibility(8);
                } else {
                    this.mfI.setVisibility(8);
                    this.mfL.setVisibility(0);
                }
            } else {
                this.mfI.setVisibility(8);
                this.mfH.setVisibility(8);
                this.mfL.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.mfO.setVisibility(0);
                this.jOP = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.jOP)) {
                    this.jOP = "";
                }
                this.mfP.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.jOP));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.mfQ.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.mfQ.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.mfQ.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new aq("c13898").dR("uid", this.mUserData.getUserId()));
                return;
            }
            this.mfO.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.brn().a(this.mfK, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.brn().a(this.mfG, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.mfB, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lZH, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lZI, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.mfD, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lZE, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.mfE, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lZF, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.mfF, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.mdJ, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.mfN, R.color.cp_cont_b, 1, i);
        ap.setBackgroundColor(this.mfO, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.mfP, (int) R.color.cp_other_e);
        ap.setViewTextColor(this.mfQ, (int) R.color.cp_other_e);
        SvgManager.brn().a(this.mfR, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.brn().a(this.mfS, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwg() {
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
                if (this.meD.mdi != null) {
                    personChangeData.setNickNameLeftDays(this.meD.mdi.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eHz);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eHA);
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
