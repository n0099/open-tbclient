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
    private String jws;
    private LinearLayout lHl;
    private TextView lHm;
    private TextView lHn;
    private TextView lHp;
    private TextView lHq;
    private TextView lLo;
    private com.baidu.tieba.personPolymeric.c.a lMh;
    private AlignTextView lNf;
    private LinearLayout lNg;
    private TextView lNh;
    private AlignTextView lNi;
    private AlignTextView lNj;
    private ImageView lNk;
    private RelativeLayout lNl;
    private RelativeLayout lNm;
    private TextView lNn;
    private ImageView lNo;
    private View lNp;
    private ImageView lNq;
    private TextView lNr;
    private RoundRelativeLayout lNs;
    private TextView lNt;
    private TextView lNu;
    private ImageView lNv;
    private ImageView lNw;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.lNl || view == b.this.lNk) {
                if (b.this.mIsHost) {
                    b.this.dqx();
                } else {
                    PersonIntroductionActivity.aU(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.lNn) {
                b.this.dqx();
            } else if (view == b.this.lNo) {
                b.this.dqx();
            } else if (view == b.this.lNs) {
                if (StringUtils.isNull(b.this.jws)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bkP();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.jws);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new aq("c13899").dK("uid", b.this.mUserData.getUserId()));
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
        this.lHp = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.lNf = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.lNf.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lHq = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.lNg = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.lNp = this.mRootView.findViewById(R.id.space_view);
        this.lNh = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.lHm = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.lHl = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.lNi = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.lNi.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lHn = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.lNj = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.lNj.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lLo = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.lNk = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.lNk.setOnClickListener(this.mClickListener);
        this.lNl = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.lNl.setOnClickListener(this.mClickListener);
        this.lNm = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.lNn = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.lNn.setOnClickListener(this.mClickListener);
        this.lNq = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.lNr = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.lNs = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.lNs.setOnClickListener(this.mClickListener);
        this.lNw = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.lNv = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.lNu = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.lNt = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.lNo = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.lNo.setOnClickListener(this.mClickListener);
        int measureText = (int) this.lNh.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.lNf.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.lNf.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.lNi.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.lNi.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.lNj.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.lNj.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dL(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.lMh = aVar;
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
                this.lHl.setVisibility(0);
                this.lHm.setVisibility(0);
                this.lHm.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.lHl.setVisibility(8);
                this.lHm.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (at.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.lHn.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cc birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !at.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.etm == 2) {
                    this.lHq.setVisibility(0);
                    this.lHq.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.lHq.setVisibility(8);
                }
                this.lHp.setVisibility(0);
                this.lHp.setText(birthdayInfo.constellation);
                this.lNg.setVisibility(0);
            } else {
                this.lNg.setVisibility(8);
                this.lHp.setVisibility(8);
                this.lHq.setVisibility(8);
            }
            if (this.mIsHost) {
                this.lNo.setVisibility(0);
            } else {
                this.lNo.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!at.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.lHn.getLeft(), 0), 0, spannableString.length(), 18);
                    this.lLo.setText(spannableString);
                    e.mY().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.lLo.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.lNl.setOnClickListener(null);
                                    b.this.lNk.setVisibility(8);
                                    return;
                                }
                                b.this.lNl.setOnClickListener(b.this.mClickListener);
                                b.this.lNk.setVisibility(0);
                            }
                        }
                    });
                    this.lNm.setVisibility(8);
                    this.lNp.setVisibility(0);
                } else {
                    this.lNl.setVisibility(8);
                    if (this.mIsHost) {
                        this.lNm.setVisibility(0);
                        this.lNo.setVisibility(8);
                        this.lNp.setVisibility(8);
                    } else {
                        this.lNm.setVisibility(8);
                        this.lNp.setVisibility(0);
                    }
                }
            } else if (at.isEmpty(intro)) {
                this.lNl.setVisibility(8);
                if (this.mIsHost) {
                    this.lNm.setVisibility(0);
                    this.lNo.setVisibility(8);
                    this.lNp.setVisibility(8);
                } else {
                    this.lNm.setVisibility(8);
                    this.lNp.setVisibility(0);
                }
            } else {
                this.lNm.setVisibility(8);
                this.lNl.setVisibility(8);
                this.lNp.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.lNs.setVisibility(0);
                this.jws = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.jws)) {
                    this.jws = "";
                }
                this.lNt.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.jws));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.lNu.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.lNu.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.lNu.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new aq("c13898").dK("uid", this.mUserData.getUserId()));
                return;
            }
            this.lNs.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bmU().a(this.lNo, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bmU().a(this.lNk, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lNf, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lHp, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lHq, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lNh, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lHm, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lNi, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lHn, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lNj, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lLo, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lNr, R.color.cp_cont_b, 1, i);
        ap.setBackgroundColor(this.lNs, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.lNt, R.color.cp_other_e);
        ap.setViewTextColor(this.lNu, R.color.cp_other_e);
        SvgManager.bmU().a(this.lNv, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bmU().a(this.lNw, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqx() {
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
                if (this.lMh.lKN != null) {
                    personChangeData.setNickNameLeftDays(this.lMh.lKN.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().etl);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().etm);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void au(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
