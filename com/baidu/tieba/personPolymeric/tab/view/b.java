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
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import tbclient.BaijiahaoInfo;
/* loaded from: classes11.dex */
public class b {
    private LinearLayout jXb;
    private TextView jXc;
    private TextView jXd;
    private TextView jXf;
    private TextView jXg;
    private com.baidu.tieba.personPolymeric.c.a kbI;
    private TextView kbe;
    private AlignTextView kcG;
    private LinearLayout kcH;
    private TextView kcI;
    private AlignTextView kcJ;
    private AlignTextView kcK;
    private ImageView kcL;
    private RelativeLayout kcM;
    private RelativeLayout kcN;
    private TextView kcO;
    private ImageView kcP;
    private View kcQ;
    private ImageView kcR;
    private TextView kcS;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.kcM || view == b.this.kcL) {
                if (b.this.mIsHost) {
                    b.this.cIG();
                } else {
                    PersonIntroductionActivity.aX(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.kcO) {
                b.this.cIG();
            } else if (view == b.this.kcP) {
                b.this.cIG();
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
        this.jXf = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.kcG = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.kcG.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jXg = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.kcH = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.kcQ = this.mRootView.findViewById(R.id.space_view);
        this.kcI = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.jXc = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.jXb = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.kcJ = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.kcJ.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jXd = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.kcK = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.kcK.setTextColor(am.getColor(R.color.cp_cont_c));
        this.kbe = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.kcL = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.kcL.setOnClickListener(this.mClickListener);
        this.kcM = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.kcM.setOnClickListener(this.mClickListener);
        this.kcN = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.kcO = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.kcO.setOnClickListener(this.mClickListener);
        this.kcR = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.kcS = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.kcP = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.kcP.setOnClickListener(this.mClickListener);
        int measureText = (int) this.kcI.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.kcG.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.kcG.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.kcJ.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.kcJ.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.kcK.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.kcK.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.cK(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.kbI = aVar;
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
                this.jXb.setVisibility(0);
                this.jXc.setVisibility(0);
                this.jXc.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.jXb.setVisibility(8);
                this.jXc.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (aq.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.jXd.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            bp birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !aq.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.dum == 2) {
                    this.jXg.setVisibility(0);
                    this.jXg.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.jXg.setVisibility(8);
                }
                this.jXf.setVisibility(0);
                this.jXf.setText(birthdayInfo.constellation);
                this.kcH.setVisibility(0);
            } else {
                this.kcH.setVisibility(8);
                this.jXf.setVisibility(8);
                this.jXg.setVisibility(8);
            }
            if (this.mIsHost) {
                this.kcP.setVisibility(0);
            } else {
                this.kcP.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!aq.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.jXd.getLeft(), 0), 0, spannableString.length(), 18);
                    this.kbe.setText(spannableString);
                    e.lb().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.kbe.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.kcM.setOnClickListener(null);
                                    b.this.kcL.setVisibility(8);
                                    return;
                                }
                                b.this.kcM.setOnClickListener(b.this.mClickListener);
                                b.this.kcL.setVisibility(0);
                            }
                        }
                    });
                    this.kcN.setVisibility(8);
                    this.kcQ.setVisibility(0);
                    return;
                }
                this.kcM.setVisibility(8);
                if (this.mIsHost) {
                    this.kcN.setVisibility(0);
                    this.kcP.setVisibility(8);
                    this.kcQ.setVisibility(8);
                    return;
                }
                this.kcN.setVisibility(8);
                this.kcQ.setVisibility(0);
            } else if (aq.isEmpty(intro)) {
                this.kcM.setVisibility(8);
                if (this.mIsHost) {
                    this.kcN.setVisibility(0);
                    this.kcP.setVisibility(8);
                    this.kcQ.setVisibility(8);
                    return;
                }
                this.kcN.setVisibility(8);
                this.kcQ.setVisibility(0);
            } else {
                this.kcN.setVisibility(8);
                this.kcM.setVisibility(8);
                this.kcQ.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aOU().a(this.kcP, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOU().a(this.kcL, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kcG, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jXf, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jXg, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kcI, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jXc, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kcJ, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jXd, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kcK, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.kbe, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kcS, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIG() {
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
                if (this.kbI.kaD != null) {
                    personChangeData.setNickNameLeftDays(this.kbI.kaD.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().dul);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().dum);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void aj(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
