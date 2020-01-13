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
/* loaded from: classes9.dex */
public class b {
    private LinearLayout jkb;
    private TextView jkc;
    private TextView jkd;
    private TextView jkf;
    private TextView jkg;
    private com.baidu.tieba.personPolymeric.c.a joF;
    private TextView joe;
    private AlignTextView jpD;
    private LinearLayout jpE;
    private TextView jpF;
    private AlignTextView jpG;
    private AlignTextView jpH;
    private ImageView jpI;
    private RelativeLayout jpJ;
    private RelativeLayout jpK;
    private TextView jpL;
    private ImageView jpM;
    private View jpN;
    private ImageView jpO;
    private TextView jpP;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.jpJ || view == b.this.jpI) {
                if (b.this.mIsHost) {
                    b.this.cwc();
                } else {
                    PersonIntroductionActivity.bc(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.jpL) {
                b.this.cwc();
            } else if (view == b.this.jpM) {
                b.this.cwc();
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
        this.jkf = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.jpD = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.jpD.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jkg = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.jpE = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.jpN = this.mRootView.findViewById(R.id.space_view);
        this.jpF = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.jkc = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.jkb = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.jpG = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.jpG.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jkd = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.jpH = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.jpH.setTextColor(am.getColor(R.color.cp_cont_c));
        this.joe = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.jpI = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.jpI.setOnClickListener(this.mClickListener);
        this.jpJ = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.jpJ.setOnClickListener(this.mClickListener);
        this.jpK = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.jpL = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.jpL.setOnClickListener(this.mClickListener);
        this.jpO = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.jpP = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.jpM = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.jpM.setOnClickListener(this.mClickListener);
        int measureText = (int) this.jpF.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.jpD.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.jpD.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.jpG.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.jpG.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.jpH.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.jpH.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.cr(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.joF = aVar;
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
                this.jkb.setVisibility(0);
                this.jkc.setVisibility(0);
                this.jkc.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.jkb.setVisibility(8);
                this.jkc.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (aq.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.jkd.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            bp birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !aq.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.cQK == 2) {
                    this.jkg.setVisibility(0);
                    this.jkg.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.jkg.setVisibility(8);
                }
                this.jkf.setVisibility(0);
                this.jkf.setText(birthdayInfo.constellation);
                this.jpE.setVisibility(0);
            } else {
                this.jpE.setVisibility(8);
                this.jkf.setVisibility(8);
                this.jkg.setVisibility(8);
            }
            if (this.mIsHost) {
                this.jpM.setVisibility(0);
            } else {
                this.jpM.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!aq.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.jkd.getLeft(), 0), 0, spannableString.length(), 18);
                    this.joe.setText(spannableString);
                    e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.joe.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.jpJ.setOnClickListener(null);
                                    b.this.jpI.setVisibility(8);
                                    return;
                                }
                                b.this.jpJ.setOnClickListener(b.this.mClickListener);
                                b.this.jpI.setVisibility(0);
                            }
                        }
                    });
                    this.jpK.setVisibility(8);
                    this.jpN.setVisibility(0);
                    return;
                }
                this.jpJ.setVisibility(8);
                if (this.mIsHost) {
                    this.jpK.setVisibility(0);
                    this.jpM.setVisibility(8);
                    this.jpN.setVisibility(8);
                    return;
                }
                this.jpK.setVisibility(8);
                this.jpN.setVisibility(0);
            } else if (aq.isEmpty(intro)) {
                this.jpJ.setVisibility(8);
                if (this.mIsHost) {
                    this.jpK.setVisibility(0);
                    this.jpM.setVisibility(8);
                    this.jpN.setVisibility(8);
                    return;
                }
                this.jpK.setVisibility(8);
                this.jpN.setVisibility(0);
            } else {
                this.jpK.setVisibility(8);
                this.jpJ.setVisibility(8);
                this.jpN.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aEp().a(this.jpM, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aEp().a(this.jpI, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jpD, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jkf, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jkg, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jpF, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jkc, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jpG, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jkd, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jpH, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.joe, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jpP, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwc() {
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
                if (this.joF.jnC != null) {
                    personChangeData.setNickNameLeftDays(this.joF.jnC.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().cQJ);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().cQK);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void ag(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
