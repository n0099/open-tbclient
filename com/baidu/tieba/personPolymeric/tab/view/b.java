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
import com.baidu.tbadk.core.data.ch;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.view.RoundRelativeLayout;
import tbclient.BaijiahaoInfo;
/* loaded from: classes8.dex */
public class b {
    private String ktS;
    private TextView mBS;
    private com.baidu.tieba.personPolymeric.c.a mCM;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.mDU || view == b.this.mDT) {
                if (b.this.mIsHost) {
                    b.this.dzg();
                } else {
                    PersonIntroductionActivity.bc(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.mDW) {
                b.this.dzg();
            } else if (view == b.this.mDX) {
                b.this.dzg();
            } else if (view == b.this.mEb) {
                if (StringUtils.isNull(b.this.ktS)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bqD();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.ktS);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new ar("c13899").dR("uid", b.this.mUserData.getUserId()));
            }
        }
    };
    private AlignTextView mDO;
    private LinearLayout mDP;
    private TextView mDQ;
    private AlignTextView mDR;
    private AlignTextView mDS;
    private ImageView mDT;
    private RelativeLayout mDU;
    private RelativeLayout mDV;
    private TextView mDW;
    private ImageView mDX;
    private View mDY;
    private ImageView mDZ;
    private TextView mEa;
    private RoundRelativeLayout mEb;
    private TextView mEc;
    private TextView mEd;
    private ImageView mEe;
    private ImageView mEf;
    private boolean mIsHost;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitleView;
    private UserData mUserData;
    private LinearLayout mxM;
    private TextView mxN;
    private TextView mxO;
    private TextView mxQ;
    private TextView mxR;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_information_header, (ViewGroup) null);
        this.mRootView.setVisibility(8);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.person_information_title);
        this.mxQ = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.mDO = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.mDO.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.mxR = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.mDP = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.mDY = this.mRootView.findViewById(R.id.space_view);
        this.mDQ = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.mxN = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.mxM = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.mDR = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.mDR.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.mxO = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.mDS = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.mDS.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.mBS = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.mDT = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.mDT.setOnClickListener(this.mClickListener);
        this.mDU = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.mDU.setOnClickListener(this.mClickListener);
        this.mDV = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.mDW = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.mDW.setOnClickListener(this.mClickListener);
        this.mDZ = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.mEa = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.mEb = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.mEb.setOnClickListener(this.mClickListener);
        this.mEf = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.mEe = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.mEd = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.mEc = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.mDX = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.mDX.setOnClickListener(this.mClickListener);
        int measureText = (int) this.mDQ.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.mDO.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.mDO.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mDR.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.mDR.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.mDS.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.mDS.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dS(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mCM = aVar;
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
                this.mxM.setVisibility(0);
                this.mxN.setVisibility(0);
                this.mxN.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.mxM.setVisibility(8);
                this.mxN.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (au.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.mxO.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            ch birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !au.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eUw == 2) {
                    this.mxR.setVisibility(0);
                    this.mxR.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.mxR.setVisibility(8);
                }
                this.mxQ.setVisibility(0);
                this.mxQ.setText(birthdayInfo.constellation);
                this.mDP.setVisibility(0);
            } else {
                this.mDP.setVisibility(8);
                this.mxQ.setVisibility(8);
                this.mxR.setVisibility(8);
            }
            if (this.mIsHost) {
                this.mDX.setVisibility(0);
            } else {
                this.mDX.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!au.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.mxO.getLeft(), 0), 0, spannableString.length(), 18);
                    this.mBS.setText(spannableString);
                    e.mA().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.mBS.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.mDU.setOnClickListener(null);
                                    b.this.mDT.setVisibility(8);
                                    return;
                                }
                                b.this.mDU.setOnClickListener(b.this.mClickListener);
                                b.this.mDT.setVisibility(0);
                            }
                        }
                    });
                    this.mDV.setVisibility(8);
                    this.mDY.setVisibility(0);
                } else {
                    this.mDU.setVisibility(8);
                    if (this.mIsHost) {
                        this.mDV.setVisibility(0);
                        this.mDX.setVisibility(8);
                        this.mDY.setVisibility(8);
                    } else {
                        this.mDV.setVisibility(8);
                        this.mDY.setVisibility(0);
                    }
                }
            } else if (au.isEmpty(intro)) {
                this.mDU.setVisibility(8);
                if (this.mIsHost) {
                    this.mDV.setVisibility(0);
                    this.mDX.setVisibility(8);
                    this.mDY.setVisibility(8);
                } else {
                    this.mDV.setVisibility(8);
                    this.mDY.setVisibility(0);
                }
            } else {
                this.mDV.setVisibility(8);
                this.mDU.setVisibility(8);
                this.mDY.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.mEb.setVisibility(0);
                this.ktS = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.ktS)) {
                    this.ktS = "";
                }
                this.mEc.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.ktS));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.mEd.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.mEd.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.mEd.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new ar("c13898").dR("uid", this.mUserData.getUserId()));
                return;
            }
            this.mEb.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bsR().a(this.mDX, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsR().a(this.mDT, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mDO, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.mxQ, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mxR, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mDQ, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.mxN, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mDR, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.mxO, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mDS, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.mBS, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mEa, R.color.CAM_X0105, 1, i);
        ap.setBackgroundColor(this.mEb, R.color.CAM_X0206);
        ap.setViewTextColor(this.mEc, R.color.CAM_X0311);
        ap.setViewTextColor(this.mEd, R.color.CAM_X0311);
        SvgManager.bsR().a(this.mEe, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a(this.mEf, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzg() {
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
                if (this.mCM.mBr != null) {
                    personChangeData.setNickNameLeftDays(this.mCM.mBr.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eUv);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eUw);
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
