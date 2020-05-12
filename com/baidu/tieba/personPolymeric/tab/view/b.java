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
    private LinearLayout jXf;
    private TextView jXg;
    private TextView jXh;
    private TextView jXj;
    private TextView jXk;
    private com.baidu.tieba.personPolymeric.c.a kbM;
    private TextView kbi;
    private AlignTextView kcK;
    private LinearLayout kcL;
    private TextView kcM;
    private AlignTextView kcN;
    private AlignTextView kcO;
    private ImageView kcP;
    private RelativeLayout kcQ;
    private RelativeLayout kcR;
    private TextView kcS;
    private ImageView kcT;
    private View kcU;
    private ImageView kcV;
    private TextView kcW;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.kcQ || view == b.this.kcP) {
                if (b.this.mIsHost) {
                    b.this.cIE();
                } else {
                    PersonIntroductionActivity.aL(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.kcS) {
                b.this.cIE();
            } else if (view == b.this.kcT) {
                b.this.cIE();
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
        this.jXj = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.kcK = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.kcK.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jXk = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.kcL = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.kcU = this.mRootView.findViewById(R.id.space_view);
        this.kcM = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.jXg = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.jXf = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.kcN = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.kcN.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jXh = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.kcO = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.kcO.setTextColor(am.getColor(R.color.cp_cont_c));
        this.kbi = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.kcP = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.kcP.setOnClickListener(this.mClickListener);
        this.kcQ = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.kcQ.setOnClickListener(this.mClickListener);
        this.kcR = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.kcS = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.kcS.setOnClickListener(this.mClickListener);
        this.kcV = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.kcW = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.kcT = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.kcT.setOnClickListener(this.mClickListener);
        int measureText = (int) this.kcM.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.kcK.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.kcK.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.kcN.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.kcN.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.kcO.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.kcO.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.cK(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.kbM = aVar;
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
                this.jXf.setVisibility(0);
                this.jXg.setVisibility(0);
                this.jXg.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.jXf.setVisibility(8);
                this.jXg.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (aq.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.jXh.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            bp birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !aq.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.duq == 2) {
                    this.jXk.setVisibility(0);
                    this.jXk.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.jXk.setVisibility(8);
                }
                this.jXj.setVisibility(0);
                this.jXj.setText(birthdayInfo.constellation);
                this.kcL.setVisibility(0);
            } else {
                this.kcL.setVisibility(8);
                this.jXj.setVisibility(8);
                this.jXk.setVisibility(8);
            }
            if (this.mIsHost) {
                this.kcT.setVisibility(0);
            } else {
                this.kcT.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!aq.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.jXh.getLeft(), 0), 0, spannableString.length(), 18);
                    this.kbi.setText(spannableString);
                    e.lb().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.kbi.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.kcQ.setOnClickListener(null);
                                    b.this.kcP.setVisibility(8);
                                    return;
                                }
                                b.this.kcQ.setOnClickListener(b.this.mClickListener);
                                b.this.kcP.setVisibility(0);
                            }
                        }
                    });
                    this.kcR.setVisibility(8);
                    this.kcU.setVisibility(0);
                    return;
                }
                this.kcQ.setVisibility(8);
                if (this.mIsHost) {
                    this.kcR.setVisibility(0);
                    this.kcT.setVisibility(8);
                    this.kcU.setVisibility(8);
                    return;
                }
                this.kcR.setVisibility(8);
                this.kcU.setVisibility(0);
            } else if (aq.isEmpty(intro)) {
                this.kcQ.setVisibility(8);
                if (this.mIsHost) {
                    this.kcR.setVisibility(0);
                    this.kcT.setVisibility(8);
                    this.kcU.setVisibility(8);
                    return;
                }
                this.kcR.setVisibility(8);
                this.kcU.setVisibility(0);
            } else {
                this.kcR.setVisibility(8);
                this.kcQ.setVisibility(8);
                this.kcU.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aOR().a(this.kcT, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOR().a(this.kcP, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kcK, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jXj, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jXk, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kcM, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jXg, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kcN, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jXh, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kcO, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.kbi, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kcW, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIE() {
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
                if (this.kbM.kaH != null) {
                    personChangeData.setNickNameLeftDays(this.kbM.kaH.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().dup);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().duq);
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
