package com.baidu.tieba.personPolymeric.tab.view;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.SpannableString;
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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import tbclient.BaijiahaoInfo;
/* loaded from: classes18.dex */
public class b {
    private LinearLayout kTf;
    private TextView kTg;
    private TextView kTh;
    private TextView kTj;
    private TextView kTk;
    private com.baidu.tieba.personPolymeric.c.a kXF;
    private TextView kXc;
    private AlignTextView kYC;
    private LinearLayout kYD;
    private TextView kYE;
    private AlignTextView kYF;
    private AlignTextView kYG;
    private ImageView kYH;
    private RelativeLayout kYI;
    private RelativeLayout kYJ;
    private TextView kYK;
    private ImageView kYL;
    private View kYM;
    private ImageView kYN;
    private TextView kYO;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.kYI || view == b.this.kYH) {
                if (b.this.mIsHost) {
                    b.this.cYb();
                } else {
                    PersonIntroductionActivity.aL(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.kYK) {
                b.this.cYb();
            } else if (view == b.this.kYL) {
                b.this.cYb();
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
        this.kTj = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.kYC = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.kYC.setTextColor(ao.getColor(R.color.cp_cont_c));
        this.kTk = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.kYD = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.kYM = this.mRootView.findViewById(R.id.space_view);
        this.kYE = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.kTg = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.kTf = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.kYF = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.kYF.setTextColor(ao.getColor(R.color.cp_cont_c));
        this.kTh = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.kYG = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.kYG.setTextColor(ao.getColor(R.color.cp_cont_c));
        this.kXc = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.kYH = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.kYH.setOnClickListener(this.mClickListener);
        this.kYI = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.kYI.setOnClickListener(this.mClickListener);
        this.kYJ = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.kYK = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.kYK.setOnClickListener(this.mClickListener);
        this.kYN = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.kYO = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.kYL = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.kYL.setOnClickListener(this.mClickListener);
        int measureText = (int) this.kYE.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.kYC.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.kYC.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.kYF.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.kYF.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.kYG.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.kYG.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.m31do(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.kXF = aVar;
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
                this.kTf.setVisibility(0);
                this.kTg.setVisibility(0);
                this.kTg.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.kTf.setVisibility(8);
                this.kTg.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (as.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.kTh.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cb birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !as.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.dVn == 2) {
                    this.kTk.setVisibility(0);
                    this.kTk.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.kTk.setVisibility(8);
                }
                this.kTj.setVisibility(0);
                this.kTj.setText(birthdayInfo.constellation);
                this.kYD.setVisibility(0);
            } else {
                this.kYD.setVisibility(8);
                this.kTj.setVisibility(8);
                this.kTk.setVisibility(8);
            }
            if (this.mIsHost) {
                this.kYL.setVisibility(0);
            } else {
                this.kYL.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !as.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!as.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.kTh.getLeft(), 0), 0, spannableString.length(), 18);
                    this.kXc.setText(spannableString);
                    e.lt().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.kXc.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.kYI.setOnClickListener(null);
                                    b.this.kYH.setVisibility(8);
                                    return;
                                }
                                b.this.kYI.setOnClickListener(b.this.mClickListener);
                                b.this.kYH.setVisibility(0);
                            }
                        }
                    });
                    this.kYJ.setVisibility(8);
                    this.kYM.setVisibility(0);
                    return;
                }
                this.kYI.setVisibility(8);
                if (this.mIsHost) {
                    this.kYJ.setVisibility(0);
                    this.kYL.setVisibility(8);
                    this.kYM.setVisibility(8);
                    return;
                }
                this.kYJ.setVisibility(8);
                this.kYM.setVisibility(0);
            } else if (as.isEmpty(intro)) {
                this.kYI.setVisibility(8);
                if (this.mIsHost) {
                    this.kYJ.setVisibility(0);
                    this.kYL.setVisibility(8);
                    this.kYM.setVisibility(8);
                    return;
                }
                this.kYJ.setVisibility(8);
                this.kYM.setVisibility(0);
            } else {
                this.kYJ.setVisibility(8);
                this.kYI.setVisibility(8);
                this.kYM.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.baR().a(this.kYL, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.baR().a(this.kYH, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kYC, R.color.cp_cont_c, 1, i);
        ao.setViewTextColor(this.kTj, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kTk, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kYE, R.color.cp_cont_c, 1, i);
        ao.setViewTextColor(this.kTg, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kYF, R.color.cp_cont_c, 1, i);
        ao.setViewTextColor(this.kTh, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kYG, R.color.cp_cont_c, 1, i);
        ao.setViewTextColor(this.kXc, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kYO, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYb() {
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
                if (this.kXF.kWC != null) {
                    personChangeData.setNickNameLeftDays(this.kXF.kWC.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().dVm);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().dVn);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void ao(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
