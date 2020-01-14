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
    private LinearLayout jkg;
    private TextView jkh;
    private TextView jki;
    private TextView jkk;
    private TextView jkl;
    private com.baidu.tieba.personPolymeric.c.a joK;
    private TextView joj;
    private AlignTextView jpI;
    private LinearLayout jpJ;
    private TextView jpK;
    private AlignTextView jpL;
    private AlignTextView jpM;
    private ImageView jpN;
    private RelativeLayout jpO;
    private RelativeLayout jpP;
    private TextView jpQ;
    private ImageView jpR;
    private View jpS;
    private ImageView jpT;
    private TextView jpU;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.jpO || view == b.this.jpN) {
                if (b.this.mIsHost) {
                    b.this.cwe();
                } else {
                    PersonIntroductionActivity.bc(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.jpQ) {
                b.this.cwe();
            } else if (view == b.this.jpR) {
                b.this.cwe();
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
        this.jkk = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.jpI = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.jpI.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jkl = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.jpJ = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.jpS = this.mRootView.findViewById(R.id.space_view);
        this.jpK = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.jkh = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.jkg = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.jpL = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.jpL.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jki = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.jpM = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.jpM.setTextColor(am.getColor(R.color.cp_cont_c));
        this.joj = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.jpN = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.jpN.setOnClickListener(this.mClickListener);
        this.jpO = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.jpO.setOnClickListener(this.mClickListener);
        this.jpP = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.jpQ = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.jpQ.setOnClickListener(this.mClickListener);
        this.jpT = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.jpU = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.jpR = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.jpR.setOnClickListener(this.mClickListener);
        int measureText = (int) this.jpK.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.jpI.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.jpI.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.jpL.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.jpL.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.jpM.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.jpM.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.cr(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.joK = aVar;
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
                this.jkg.setVisibility(0);
                this.jkh.setVisibility(0);
                this.jkh.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.jkg.setVisibility(8);
                this.jkh.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (aq.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.jki.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            bp birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !aq.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.cQK == 2) {
                    this.jkl.setVisibility(0);
                    this.jkl.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.jkl.setVisibility(8);
                }
                this.jkk.setVisibility(0);
                this.jkk.setText(birthdayInfo.constellation);
                this.jpJ.setVisibility(0);
            } else {
                this.jpJ.setVisibility(8);
                this.jkk.setVisibility(8);
                this.jkl.setVisibility(8);
            }
            if (this.mIsHost) {
                this.jpR.setVisibility(0);
            } else {
                this.jpR.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!aq.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.jki.getLeft(), 0), 0, spannableString.length(), 18);
                    this.joj.setText(spannableString);
                    e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.joj.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.jpO.setOnClickListener(null);
                                    b.this.jpN.setVisibility(8);
                                    return;
                                }
                                b.this.jpO.setOnClickListener(b.this.mClickListener);
                                b.this.jpN.setVisibility(0);
                            }
                        }
                    });
                    this.jpP.setVisibility(8);
                    this.jpS.setVisibility(0);
                    return;
                }
                this.jpO.setVisibility(8);
                if (this.mIsHost) {
                    this.jpP.setVisibility(0);
                    this.jpR.setVisibility(8);
                    this.jpS.setVisibility(8);
                    return;
                }
                this.jpP.setVisibility(8);
                this.jpS.setVisibility(0);
            } else if (aq.isEmpty(intro)) {
                this.jpO.setVisibility(8);
                if (this.mIsHost) {
                    this.jpP.setVisibility(0);
                    this.jpR.setVisibility(8);
                    this.jpS.setVisibility(8);
                    return;
                }
                this.jpP.setVisibility(8);
                this.jpS.setVisibility(0);
            } else {
                this.jpP.setVisibility(8);
                this.jpO.setVisibility(8);
                this.jpS.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aEp().a(this.jpR, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aEp().a(this.jpN, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jpI, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jkk, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jkl, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jpK, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jkh, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jpL, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jki, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jpM, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.joj, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jpU, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwe() {
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
                if (this.joK.jnH != null) {
                    personChangeData.setNickNameLeftDays(this.joK.jnH.left_days.intValue());
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
