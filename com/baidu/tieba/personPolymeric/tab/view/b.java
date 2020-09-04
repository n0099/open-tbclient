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
    private String iYO;
    private LinearLayout ljc;
    private TextView ljd;
    private TextView lje;
    private TextView ljg;
    private TextView ljh;
    private com.baidu.tieba.personPolymeric.c.a lnV;
    private TextView lnf;
    private AlignTextView loX;
    private LinearLayout loY;
    private TextView loZ;
    private AlignTextView lpa;
    private AlignTextView lpb;
    private ImageView lpc;
    private RelativeLayout lpd;
    private RelativeLayout lpe;
    private TextView lpf;
    private ImageView lpg;
    private View lph;
    private ImageView lpi;
    private TextView lpj;
    private RoundRelativeLayout lpk;
    private TextView lpl;
    private TextView lpm;
    private ImageView lpn;
    private ImageView lpo;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.lpd || view == b.this.lpc) {
                if (b.this.mIsHost) {
                    b.this.djg();
                } else {
                    PersonIntroductionActivity.aP(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.lpf) {
                b.this.djg();
            } else if (view == b.this.lpg) {
                b.this.djg();
            } else if (view == b.this.lpk) {
                if (StringUtils.isNull(b.this.iYO)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bhm();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.iYO);
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
        this.ljg = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.loX = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.loX.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.ljh = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.loY = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.lph = this.mRootView.findViewById(R.id.space_view);
        this.loZ = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.ljd = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.ljc = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.lpa = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.lpa.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lje = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.lpb = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.lpb.setTextColor(ap.getColor(R.color.cp_cont_c));
        this.lnf = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.lpc = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.lpc.setOnClickListener(this.mClickListener);
        this.lpd = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.lpd.setOnClickListener(this.mClickListener);
        this.lpe = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.lpf = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.lpf.setOnClickListener(this.mClickListener);
        this.lpi = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.lpj = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.lpk = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.lpk.setOnClickListener(this.mClickListener);
        this.lpo = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.lpn = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.lpm = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.lpl = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.lpg = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.lpg.setOnClickListener(this.mClickListener);
        int measureText = (int) this.loZ.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.loX.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.loX.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.lpa.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.lpa.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.lpb.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.lpb.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dE(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.lnV = aVar;
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
                this.ljc.setVisibility(0);
                this.ljd.setVisibility(0);
                this.ljd.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.ljc.setVisibility(8);
                this.ljd.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (at.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.lje.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cc birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !at.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eeR == 2) {
                    this.ljh.setVisibility(0);
                    this.ljh.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.ljh.setVisibility(8);
                }
                this.ljg.setVisibility(0);
                this.ljg.setText(birthdayInfo.constellation);
                this.loY.setVisibility(0);
            } else {
                this.loY.setVisibility(8);
                this.ljg.setVisibility(8);
                this.ljh.setVisibility(8);
            }
            if (this.mIsHost) {
                this.lpg.setVisibility(0);
            } else {
                this.lpg.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!at.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.lje.getLeft(), 0), 0, spannableString.length(), 18);
                    this.lnf.setText(spannableString);
                    e.mS().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.lnf.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.lpd.setOnClickListener(null);
                                    b.this.lpc.setVisibility(8);
                                    return;
                                }
                                b.this.lpd.setOnClickListener(b.this.mClickListener);
                                b.this.lpc.setVisibility(0);
                            }
                        }
                    });
                    this.lpe.setVisibility(8);
                    this.lph.setVisibility(0);
                } else {
                    this.lpd.setVisibility(8);
                    if (this.mIsHost) {
                        this.lpe.setVisibility(0);
                        this.lpg.setVisibility(8);
                        this.lph.setVisibility(8);
                    } else {
                        this.lpe.setVisibility(8);
                        this.lph.setVisibility(0);
                    }
                }
            } else if (at.isEmpty(intro)) {
                this.lpd.setVisibility(8);
                if (this.mIsHost) {
                    this.lpe.setVisibility(0);
                    this.lpg.setVisibility(8);
                    this.lph.setVisibility(8);
                } else {
                    this.lpe.setVisibility(8);
                    this.lph.setVisibility(0);
                }
            } else {
                this.lpe.setVisibility(8);
                this.lpd.setVisibility(8);
                this.lph.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.lpk.setVisibility(0);
                this.iYO = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.iYO)) {
                    this.iYO = "";
                }
                this.lpl.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.iYO));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.lpm.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.lpm.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.lpm.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new aq("c13898").dD("uid", this.mUserData.getUserId()));
                return;
            }
            this.lpk.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bjq().a(this.lpg, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bjq().a(this.lpc, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.loX, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.ljg, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.ljh, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.loZ, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.ljd, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lpa, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lje, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lpb, R.color.cp_cont_c, 1, i);
        ap.setViewTextColor(this.lnf, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.lpj, R.color.cp_cont_b, 1, i);
        ap.setBackgroundColor(this.lpk, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.lpl, (int) R.color.cp_other_e);
        ap.setViewTextColor(this.lpm, (int) R.color.cp_other_e);
        SvgManager.bjq().a(this.lpn, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a(this.lpo, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djg() {
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
                if (this.lnV.lmE != null) {
                    personChangeData.setNickNameLeftDays(this.lnV.lmE.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eeQ);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eeR);
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
