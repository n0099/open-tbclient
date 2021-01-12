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
/* loaded from: classes7.dex */
public class b {
    private String klL;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.muQ || view == b.this.muP) {
                if (b.this.mIsHost) {
                    b.this.dwX();
                } else {
                    PersonIntroductionActivity.bd(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.muS) {
                b.this.dwX();
            } else if (view == b.this.muT) {
                b.this.dwX();
            } else if (view == b.this.muX) {
                if (StringUtils.isNull(b.this.klL)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bqk();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.klL);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new aq("c13899").dW("uid", b.this.mUserData.getUserId()));
            }
        }
    };
    private boolean mIsHost;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitleView;
    private UserData mUserData;
    private LinearLayout moM;
    private TextView moN;
    private TextView moO;
    private TextView moQ;
    private TextView moR;
    private TextView msS;
    private com.baidu.tieba.personPolymeric.c.a mtL;
    private AlignTextView muK;
    private LinearLayout muL;
    private TextView muM;
    private AlignTextView muN;
    private AlignTextView muO;
    private ImageView muP;
    private RelativeLayout muQ;
    private RelativeLayout muR;
    private TextView muS;
    private ImageView muT;
    private View muU;
    private ImageView muV;
    private TextView muW;
    private RoundRelativeLayout muX;
    private TextView muY;
    private TextView muZ;
    private ImageView mva;
    private ImageView mvb;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_information_header, (ViewGroup) null);
        this.mRootView.setVisibility(8);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.person_information_title);
        this.moQ = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.muK = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.muK.setTextColor(ao.getColor(R.color.CAM_X0108));
        this.moR = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.muL = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.muU = this.mRootView.findViewById(R.id.space_view);
        this.muM = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.moN = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.moM = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.muN = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.muN.setTextColor(ao.getColor(R.color.CAM_X0108));
        this.moO = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.muO = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.muO.setTextColor(ao.getColor(R.color.CAM_X0108));
        this.msS = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.muP = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.muP.setOnClickListener(this.mClickListener);
        this.muQ = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.muQ.setOnClickListener(this.mClickListener);
        this.muR = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.muS = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.muS.setOnClickListener(this.mClickListener);
        this.muV = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.muW = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.muX = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.muX.setOnClickListener(this.mClickListener);
        this.mvb = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.mva = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.muZ = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.muY = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.muT = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.muT.setOnClickListener(this.mClickListener);
        int measureText = (int) this.muM.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.muK.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.muK.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.muN.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.muN.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.muO.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.muO.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dX(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mtL = aVar;
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
                this.moM.setVisibility(0);
                this.moN.setVisibility(0);
                this.moN.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.moM.setVisibility(8);
                this.moN.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (at.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.moO.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cf birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !at.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eSi == 2) {
                    this.moR.setVisibility(0);
                    this.moR.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.moR.setVisibility(8);
                }
                this.moQ.setVisibility(0);
                this.moQ.setText(birthdayInfo.constellation);
                this.muL.setVisibility(0);
            } else {
                this.muL.setVisibility(8);
                this.moQ.setVisibility(8);
                this.moR.setVisibility(8);
            }
            if (this.mIsHost) {
                this.muT.setVisibility(0);
            } else {
                this.muT.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!at.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.moO.getLeft(), 0), 0, spannableString.length(), 18);
                    this.msS.setText(spannableString);
                    e.mB().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.msS.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.muQ.setOnClickListener(null);
                                    b.this.muP.setVisibility(8);
                                    return;
                                }
                                b.this.muQ.setOnClickListener(b.this.mClickListener);
                                b.this.muP.setVisibility(0);
                            }
                        }
                    });
                    this.muR.setVisibility(8);
                    this.muU.setVisibility(0);
                } else {
                    this.muQ.setVisibility(8);
                    if (this.mIsHost) {
                        this.muR.setVisibility(0);
                        this.muT.setVisibility(8);
                        this.muU.setVisibility(8);
                    } else {
                        this.muR.setVisibility(8);
                        this.muU.setVisibility(0);
                    }
                }
            } else if (at.isEmpty(intro)) {
                this.muQ.setVisibility(8);
                if (this.mIsHost) {
                    this.muR.setVisibility(0);
                    this.muT.setVisibility(8);
                    this.muU.setVisibility(8);
                } else {
                    this.muR.setVisibility(8);
                    this.muU.setVisibility(0);
                }
            } else {
                this.muR.setVisibility(8);
                this.muQ.setVisibility(8);
                this.muU.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.muX.setVisibility(0);
                this.klL = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.klL)) {
                    this.klL = "";
                }
                this.muY.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.klL));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.muZ.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.muZ.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.muZ.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new aq("c13898").dW("uid", this.mUserData.getUserId()));
                return;
            }
            this.muX.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bsx().a(this.muT, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsx().a(this.muP, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.muK, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.moQ, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.moR, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.muM, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.moN, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.muN, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.moO, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.muO, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.msS, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.muW, R.color.CAM_X0105, 1, i);
        ao.setBackgroundColor(this.muX, R.color.CAM_X0206);
        ao.setViewTextColor(this.muY, R.color.CAM_X0311);
        ao.setViewTextColor(this.muZ, R.color.CAM_X0311);
        SvgManager.bsx().a(this.mva, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsx().a(this.mvb, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwX() {
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
                if (this.mtL.msr != null) {
                    personChangeData.setNickNameLeftDays(this.mtL.msr.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eSh);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eSi);
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
