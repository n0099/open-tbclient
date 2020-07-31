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
    private LinearLayout kTd;
    private TextView kTe;
    private TextView kTf;
    private TextView kTh;
    private TextView kTi;
    private com.baidu.tieba.personPolymeric.c.a kXD;
    private TextView kXa;
    private AlignTextView kYA;
    private LinearLayout kYB;
    private TextView kYC;
    private AlignTextView kYD;
    private AlignTextView kYE;
    private ImageView kYF;
    private RelativeLayout kYG;
    private RelativeLayout kYH;
    private TextView kYI;
    private ImageView kYJ;
    private View kYK;
    private ImageView kYL;
    private TextView kYM;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.kYG || view == b.this.kYF) {
                if (b.this.mIsHost) {
                    b.this.cYb();
                } else {
                    PersonIntroductionActivity.aL(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.kYI) {
                b.this.cYb();
            } else if (view == b.this.kYJ) {
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
        this.kTh = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.kYA = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.kYA.setTextColor(ao.getColor(R.color.cp_cont_c));
        this.kTi = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.kYB = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.kYK = this.mRootView.findViewById(R.id.space_view);
        this.kYC = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.kTe = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.kTd = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.kYD = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.kYD.setTextColor(ao.getColor(R.color.cp_cont_c));
        this.kTf = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.kYE = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.kYE.setTextColor(ao.getColor(R.color.cp_cont_c));
        this.kXa = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.kYF = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.kYF.setOnClickListener(this.mClickListener);
        this.kYG = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.kYG.setOnClickListener(this.mClickListener);
        this.kYH = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.kYI = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.kYI.setOnClickListener(this.mClickListener);
        this.kYL = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.kYM = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.kYJ = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.kYJ.setOnClickListener(this.mClickListener);
        int measureText = (int) this.kYC.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.kYA.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.kYA.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.kYD.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.kYD.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.kYE.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.kYE.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.m31do(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.kXD = aVar;
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
                this.kTd.setVisibility(0);
                this.kTe.setVisibility(0);
                this.kTe.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.kTd.setVisibility(8);
                this.kTe.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (as.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.kTf.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cb birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !as.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.dVn == 2) {
                    this.kTi.setVisibility(0);
                    this.kTi.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.kTi.setVisibility(8);
                }
                this.kTh.setVisibility(0);
                this.kTh.setText(birthdayInfo.constellation);
                this.kYB.setVisibility(0);
            } else {
                this.kYB.setVisibility(8);
                this.kTh.setVisibility(8);
                this.kTi.setVisibility(8);
            }
            if (this.mIsHost) {
                this.kYJ.setVisibility(0);
            } else {
                this.kYJ.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !as.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!as.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.kTf.getLeft(), 0), 0, spannableString.length(), 18);
                    this.kXa.setText(spannableString);
                    e.lt().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.kXa.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.kYG.setOnClickListener(null);
                                    b.this.kYF.setVisibility(8);
                                    return;
                                }
                                b.this.kYG.setOnClickListener(b.this.mClickListener);
                                b.this.kYF.setVisibility(0);
                            }
                        }
                    });
                    this.kYH.setVisibility(8);
                    this.kYK.setVisibility(0);
                    return;
                }
                this.kYG.setVisibility(8);
                if (this.mIsHost) {
                    this.kYH.setVisibility(0);
                    this.kYJ.setVisibility(8);
                    this.kYK.setVisibility(8);
                    return;
                }
                this.kYH.setVisibility(8);
                this.kYK.setVisibility(0);
            } else if (as.isEmpty(intro)) {
                this.kYG.setVisibility(8);
                if (this.mIsHost) {
                    this.kYH.setVisibility(0);
                    this.kYJ.setVisibility(8);
                    this.kYK.setVisibility(8);
                    return;
                }
                this.kYH.setVisibility(8);
                this.kYK.setVisibility(0);
            } else {
                this.kYH.setVisibility(8);
                this.kYG.setVisibility(8);
                this.kYK.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.baR().a(this.kYJ, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.baR().a(this.kYF, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kYA, R.color.cp_cont_c, 1, i);
        ao.setViewTextColor(this.kTh, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kTi, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kYC, R.color.cp_cont_c, 1, i);
        ao.setViewTextColor(this.kTe, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kYD, R.color.cp_cont_c, 1, i);
        ao.setViewTextColor(this.kTf, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kYE, R.color.cp_cont_c, 1, i);
        ao.setViewTextColor(this.kXa, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.kYM, R.color.cp_cont_b, 1, i);
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
                if (this.kXD.kWA != null) {
                    personChangeData.setNickNameLeftDays(this.kXD.kWA.left_days.intValue());
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
