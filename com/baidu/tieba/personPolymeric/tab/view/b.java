package com.baidu.tieba.personPolymeric.tab.view;

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
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tbadk.core.data.cf;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.view.RoundRelativeLayout;
import tbclient.BaijiahaoInfo;
/* loaded from: classes8.dex */
public class b {
    private String kqq;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.mzu || view == b.this.mzt) {
                if (b.this.mIsHost) {
                    b.this.dAP();
                } else {
                    PersonIntroductionActivity.bd(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.mzw) {
                b.this.dAP();
            } else if (view == b.this.mzx) {
                b.this.dAP();
            } else if (view == b.this.mzB) {
                if (StringUtils.isNull(b.this.kqq)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bue();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.kqq);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new aq("c13899").dX("uid", b.this.mUserData.getUserId()));
            }
        }
    };
    private boolean mIsHost;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitleView;
    private UserData mUserData;
    private LinearLayout mtr;
    private TextView mts;
    private TextView mtt;
    private TextView mtv;
    private TextView mtw;
    private TextView mxw;
    private com.baidu.tieba.personPolymeric.c.a myp;
    private TextView mzA;
    private RoundRelativeLayout mzB;
    private TextView mzC;
    private TextView mzD;
    private ImageView mzE;
    private ImageView mzF;
    private AlignTextView mzo;
    private LinearLayout mzp;
    private TextView mzq;
    private AlignTextView mzr;
    private AlignTextView mzs;
    private ImageView mzt;
    private RelativeLayout mzu;
    private RelativeLayout mzv;
    private TextView mzw;
    private ImageView mzx;
    private View mzy;
    private ImageView mzz;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_information_header, (ViewGroup) null);
        this.mRootView.setVisibility(8);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.person_information_title);
        this.mtv = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.mzo = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.mzo.setTextColor(ao.getColor(R.color.CAM_X0108));
        this.mtw = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.mzp = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.mzy = this.mRootView.findViewById(R.id.space_view);
        this.mzq = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.mts = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.mtr = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.mzr = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.mzr.setTextColor(ao.getColor(R.color.CAM_X0108));
        this.mtt = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.mzs = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.mzs.setTextColor(ao.getColor(R.color.CAM_X0108));
        this.mxw = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.mzt = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.mzt.setOnClickListener(this.mClickListener);
        this.mzu = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.mzu.setOnClickListener(this.mClickListener);
        this.mzv = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.mzw = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.mzw.setOnClickListener(this.mClickListener);
        this.mzz = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.mzA = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.mzB = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.mzB.setOnClickListener(this.mClickListener);
        this.mzF = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.mzE = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.mzD = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.mzC = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.mzx = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.mzx.setOnClickListener(this.mClickListener);
        int measureText = (int) this.mzq.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.mzo.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.mzo.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mzr.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.mzr.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.mzs.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.mzs.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dY(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.myp = aVar;
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
                this.mtr.setVisibility(0);
                this.mts.setVisibility(0);
                this.mts.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.mtr.setVisibility(8);
                this.mts.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (at.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.mtt.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cf birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !at.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eWT == 2) {
                    this.mtw.setVisibility(0);
                    this.mtw.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.mtw.setVisibility(8);
                }
                this.mtv.setVisibility(0);
                this.mtv.setText(birthdayInfo.constellation);
                this.mzp.setVisibility(0);
            } else {
                this.mzp.setVisibility(8);
                this.mtv.setVisibility(8);
                this.mtw.setVisibility(8);
            }
            if (this.mIsHost) {
                this.mzx.setVisibility(0);
            } else {
                this.mzx.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!at.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.mtt.getLeft(), 0), 0, spannableString.length(), 18);
                    this.mxw.setText(spannableString);
                    e.mB().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.mxw.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.mzu.setOnClickListener(null);
                                    b.this.mzt.setVisibility(8);
                                    return;
                                }
                                b.this.mzu.setOnClickListener(b.this.mClickListener);
                                b.this.mzt.setVisibility(0);
                            }
                        }
                    });
                    this.mzv.setVisibility(8);
                    this.mzy.setVisibility(0);
                } else {
                    this.mzu.setVisibility(8);
                    if (this.mIsHost) {
                        this.mzv.setVisibility(0);
                        this.mzx.setVisibility(8);
                        this.mzy.setVisibility(8);
                    } else {
                        this.mzv.setVisibility(8);
                        this.mzy.setVisibility(0);
                    }
                }
            } else if (at.isEmpty(intro)) {
                this.mzu.setVisibility(8);
                if (this.mIsHost) {
                    this.mzv.setVisibility(0);
                    this.mzx.setVisibility(8);
                    this.mzy.setVisibility(8);
                } else {
                    this.mzv.setVisibility(8);
                    this.mzy.setVisibility(0);
                }
            } else {
                this.mzv.setVisibility(8);
                this.mzu.setVisibility(8);
                this.mzy.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.mzB.setVisibility(0);
                this.kqq = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.kqq)) {
                    this.kqq = "";
                }
                this.mzC.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.kqq));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.mzD.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.mzD.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.mzD.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new aq("c13898").dX("uid", this.mUserData.getUserId()));
                return;
            }
            this.mzB.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bwr().a(this.mzx, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bwr().a(this.mzt, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mzo, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.mtv, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mtw, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mzq, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.mts, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mzr, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.mtt, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mzs, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.mxw, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mzA, R.color.CAM_X0105, 1, i);
        ao.setBackgroundColor(this.mzB, R.color.CAM_X0206);
        ao.setViewTextColor(this.mzC, R.color.CAM_X0311);
        ao.setViewTextColor(this.mzD, R.color.CAM_X0311);
        SvgManager.bwr().a(this.mzE, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwr().a(this.mzF, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAP() {
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
                if (this.myp.mwV != null) {
                    personChangeData.setNickNameLeftDays(this.myp.mwV.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eWS);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eWT);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void aw(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
