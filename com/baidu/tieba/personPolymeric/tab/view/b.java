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
import com.baidu.tbadk.core.data.bq;
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
    private LinearLayout kqe;
    private TextView kqf;
    private TextView kqg;
    private TextView kqi;
    private TextView kqj;
    private com.baidu.tieba.personPolymeric.c.a kuK;
    private TextView kug;
    private AlignTextView kvH;
    private LinearLayout kvI;
    private TextView kvJ;
    private AlignTextView kvK;
    private AlignTextView kvL;
    private ImageView kvM;
    private RelativeLayout kvN;
    private RelativeLayout kvO;
    private TextView kvP;
    private ImageView kvQ;
    private View kvR;
    private ImageView kvS;
    private TextView kvT;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.kvN || view == b.this.kvM) {
                if (b.this.mIsHost) {
                    b.this.cPT();
                } else {
                    PersonIntroductionActivity.aM(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.kvP) {
                b.this.cPT();
            } else if (view == b.this.kvQ) {
                b.this.cPT();
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
        this.kqi = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.kvH = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.kvH.setTextColor(am.getColor(R.color.cp_cont_c));
        this.kqj = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.kvI = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.kvR = this.mRootView.findViewById(R.id.space_view);
        this.kvJ = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.kqf = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.kqe = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.kvK = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.kvK.setTextColor(am.getColor(R.color.cp_cont_c));
        this.kqg = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.kvL = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.kvL.setTextColor(am.getColor(R.color.cp_cont_c));
        this.kug = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.kvM = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.kvM.setOnClickListener(this.mClickListener);
        this.kvN = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.kvN.setOnClickListener(this.mClickListener);
        this.kvO = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.kvP = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.kvP.setOnClickListener(this.mClickListener);
        this.kvS = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.kvT = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.kvQ = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.kvQ.setOnClickListener(this.mClickListener);
        int measureText = (int) this.kvJ.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.kvH.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.kvH.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.kvK.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.kvK.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.kvL.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.kvL.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dj(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.kuK = aVar;
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
                this.kqe.setVisibility(0);
                this.kqf.setVisibility(0);
                this.kqf.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.kqe.setVisibility(8);
                this.kqf.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (aq.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.kqg.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            bq birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !aq.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.dIl == 2) {
                    this.kqj.setVisibility(0);
                    this.kqj.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.kqj.setVisibility(8);
                }
                this.kqi.setVisibility(0);
                this.kqi.setText(birthdayInfo.constellation);
                this.kvI.setVisibility(0);
            } else {
                this.kvI.setVisibility(8);
                this.kqi.setVisibility(8);
                this.kqj.setVisibility(8);
            }
            if (this.mIsHost) {
                this.kvQ.setVisibility(0);
            } else {
                this.kvQ.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!aq.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.kqg.getLeft(), 0), 0, spannableString.length(), 18);
                    this.kug.setText(spannableString);
                    e.ld().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.kug.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.kvN.setOnClickListener(null);
                                    b.this.kvM.setVisibility(8);
                                    return;
                                }
                                b.this.kvN.setOnClickListener(b.this.mClickListener);
                                b.this.kvM.setVisibility(0);
                            }
                        }
                    });
                    this.kvO.setVisibility(8);
                    this.kvR.setVisibility(0);
                    return;
                }
                this.kvN.setVisibility(8);
                if (this.mIsHost) {
                    this.kvO.setVisibility(0);
                    this.kvQ.setVisibility(8);
                    this.kvR.setVisibility(8);
                    return;
                }
                this.kvO.setVisibility(8);
                this.kvR.setVisibility(0);
            } else if (aq.isEmpty(intro)) {
                this.kvN.setVisibility(8);
                if (this.mIsHost) {
                    this.kvO.setVisibility(0);
                    this.kvQ.setVisibility(8);
                    this.kvR.setVisibility(8);
                    return;
                }
                this.kvO.setVisibility(8);
                this.kvR.setVisibility(0);
            } else {
                this.kvO.setVisibility(8);
                this.kvN.setVisibility(8);
                this.kvR.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aUW().a(this.kvQ, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUW().a(this.kvM, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kvH, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.kqi, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kqj, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kvJ, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.kqf, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kvK, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.kqg, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kvL, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.kug, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kvT, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPT() {
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
                if (this.kuK.ktF != null) {
                    personChangeData.setNickNameLeftDays(this.kuK.ktF.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().dIk);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().dIl);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void am(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
