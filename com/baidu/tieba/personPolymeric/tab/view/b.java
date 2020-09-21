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
/* loaded from: classes23.dex */
public class b {
    private String jht;
    private LinearLayout lrY;
    private TextView lrZ;
    private TextView lsa;
    private TextView lsc;
    private TextView lsd;
    private com.baidu.tieba.personPolymeric.c.a lwR;
    private TextView lwc;
    private AlignTextView lxP;
    private LinearLayout lxQ;
    private TextView lxR;
    private AlignTextView lxS;
    private AlignTextView lxT;
    private ImageView lxU;
    private RelativeLayout lxV;
    private RelativeLayout lxW;
    private TextView lxX;
    private ImageView lxY;
    private View lxZ;
    private ImageView lya;
    private TextView lyb;
    private RoundRelativeLayout lyc;
    private TextView lyd;
    private TextView lye;
    private ImageView lyf;
    private ImageView lyg;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.lxV || view == b.this.lxU) {
                if (b.this.mIsHost) {
                    b.this.dmL();
                } else {
                    PersonIntroductionActivity.aS(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.lxX) {
                b.this.dmL();
            } else if (view == b.this.lxY) {
                b.this.dmL();
            } else if (view == b.this.lyc) {
                if (StringUtils.isNull(b.this.jht)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).big();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.jht);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new aq("c13899").dF("uid", b.this.mUserData.getUserId()));
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
        this.lsc = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.lxP = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.lxP.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lsd = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.lxQ = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.lxZ = this.mRootView.findViewById(R.id.space_view);
        this.lxR = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.lrZ = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.lrY = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.lxS = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.lxS.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lsa = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.lxT = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.lxT.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lwc = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.lxU = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.lxU.setOnClickListener(this.mClickListener);
        this.lxV = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.lxV.setOnClickListener(this.mClickListener);
        this.lxW = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.lxX = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.lxX.setOnClickListener(this.mClickListener);
        this.lya = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.lyb = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.lyc = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.lyc.setOnClickListener(this.mClickListener);
        this.lyg = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.lyf = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.lye = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.lyd = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.lxY = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.lxY.setOnClickListener(this.mClickListener);
        int measureText = (int) this.lxR.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.lxP.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.lxP.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.lxS.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.lxS.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.lxT.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.lxT.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dG(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.lwR = aVar;
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
                this.lrY.setVisibility(0);
                this.lrZ.setVisibility(0);
                this.lrZ.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.lrY.setVisibility(8);
                this.lrZ.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (at.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.lsa.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cc birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !at.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.ehf == 2) {
                    this.lsd.setVisibility(0);
                    this.lsd.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.lsd.setVisibility(8);
                }
                this.lsc.setVisibility(0);
                this.lsc.setText(birthdayInfo.constellation);
                this.lxQ.setVisibility(0);
            } else {
                this.lxQ.setVisibility(8);
                this.lsc.setVisibility(8);
                this.lsd.setVisibility(8);
            }
            if (this.mIsHost) {
                this.lxY.setVisibility(0);
            } else {
                this.lxY.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!at.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.lsa.getLeft(), 0), 0, spannableString.length(), 18);
                    this.lwc.setText(spannableString);
                    e.mX().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.lwc.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.lxV.setOnClickListener(null);
                                    b.this.lxU.setVisibility(8);
                                    return;
                                }
                                b.this.lxV.setOnClickListener(b.this.mClickListener);
                                b.this.lxU.setVisibility(0);
                            }
                        }
                    });
                    this.lxW.setVisibility(8);
                    this.lxZ.setVisibility(0);
                } else {
                    this.lxV.setVisibility(8);
                    if (this.mIsHost) {
                        this.lxW.setVisibility(0);
                        this.lxY.setVisibility(8);
                        this.lxZ.setVisibility(8);
                    } else {
                        this.lxW.setVisibility(8);
                        this.lxZ.setVisibility(0);
                    }
                }
            } else if (at.isEmpty(intro)) {
                this.lxV.setVisibility(8);
                if (this.mIsHost) {
                    this.lxW.setVisibility(0);
                    this.lxY.setVisibility(8);
                    this.lxZ.setVisibility(8);
                } else {
                    this.lxW.setVisibility(8);
                    this.lxZ.setVisibility(0);
                }
            } else {
                this.lxW.setVisibility(8);
                this.lxV.setVisibility(8);
                this.lxZ.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.lyc.setVisibility(0);
                this.jht = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.jht)) {
                    this.jht = "";
                }
                this.lyd.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.jht));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.lye.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.lye.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.lye.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new aq("c13898").dF("uid", this.mUserData.getUserId()));
                return;
            }
            this.lyc.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bkl().a(this.lxY, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bkl().a(this.lxU, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lxP, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lsc, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lsd, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lxR, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lrZ, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lxS, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lsa, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lxT, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lwc, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lyb, R.color.cp_cont_b, 1, i);
        ap.setBackgroundColor(this.lyc, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.lyd, (int) R.color.cp_other_e);
        ap.setViewTextColor(this.lye, (int) R.color.cp_other_e);
        SvgManager.bkl().a(this.lyf, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bkl().a(this.lyg, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmL() {
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
                if (this.lwR.lvB != null) {
                    personChangeData.setNickNameLeftDays(this.lwR.lvB.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().ehe);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().ehf);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void av(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
