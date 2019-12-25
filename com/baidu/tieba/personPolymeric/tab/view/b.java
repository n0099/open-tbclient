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
/* loaded from: classes8.dex */
public class b {
    private TextView jgA;
    private TextView jgC;
    private TextView jgD;
    private LinearLayout jgy;
    private TextView jgz;
    private TextView jkC;
    private com.baidu.tieba.personPolymeric.c.a jlc;
    private AlignTextView jma;
    private LinearLayout jmb;
    private TextView jmc;
    private AlignTextView jmd;
    private AlignTextView jme;
    private ImageView jmf;
    private RelativeLayout jmg;
    private RelativeLayout jmh;
    private TextView jmi;
    private ImageView jmj;
    private View jmk;
    private ImageView jml;
    private TextView jmm;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.jmg || view == b.this.jmf) {
                if (b.this.mIsHost) {
                    b.this.cuV();
                } else {
                    PersonIntroductionActivity.bb(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.jmi) {
                b.this.cuV();
            } else if (view == b.this.jmj) {
                b.this.cuV();
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
        this.jgC = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.jma = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.jma.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jgD = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.jmb = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.jmk = this.mRootView.findViewById(R.id.space_view);
        this.jmc = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.jgz = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.jgy = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.jmd = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.jmd.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jgA = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.jme = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.jme.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jkC = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.jmf = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.jmf.setOnClickListener(this.mClickListener);
        this.jmg = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.jmg.setOnClickListener(this.mClickListener);
        this.jmh = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.jmi = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.jmi.setOnClickListener(this.mClickListener);
        this.jml = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.jmm = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.jmj = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.jmj.setOnClickListener(this.mClickListener);
        int measureText = (int) this.jmc.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.jma.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.jma.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.jmd.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.jmd.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.jme.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.jme.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.cr(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.jlc = aVar;
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
                this.jgy.setVisibility(0);
                this.jgz.setVisibility(0);
                this.jgz.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.jgy.setVisibility(8);
                this.jgz.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (aq.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.jgA.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            bp birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !aq.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.cQA == 2) {
                    this.jgD.setVisibility(0);
                    this.jgD.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.jgD.setVisibility(8);
                }
                this.jgC.setVisibility(0);
                this.jgC.setText(birthdayInfo.constellation);
                this.jmb.setVisibility(0);
            } else {
                this.jmb.setVisibility(8);
                this.jgC.setVisibility(8);
                this.jgD.setVisibility(8);
            }
            if (this.mIsHost) {
                this.jmj.setVisibility(0);
            } else {
                this.jmj.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!aq.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.jgA.getLeft(), 0), 0, spannableString.length(), 18);
                    this.jkC.setText(spannableString);
                    e.gy().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.jkC.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.jmg.setOnClickListener(null);
                                    b.this.jmf.setVisibility(8);
                                    return;
                                }
                                b.this.jmg.setOnClickListener(b.this.mClickListener);
                                b.this.jmf.setVisibility(0);
                            }
                        }
                    });
                    this.jmh.setVisibility(8);
                    this.jmk.setVisibility(0);
                    return;
                }
                this.jmg.setVisibility(8);
                if (this.mIsHost) {
                    this.jmh.setVisibility(0);
                    this.jmj.setVisibility(8);
                    this.jmk.setVisibility(8);
                    return;
                }
                this.jmh.setVisibility(8);
                this.jmk.setVisibility(0);
            } else if (aq.isEmpty(intro)) {
                this.jmg.setVisibility(8);
                if (this.mIsHost) {
                    this.jmh.setVisibility(0);
                    this.jmj.setVisibility(8);
                    this.jmk.setVisibility(8);
                    return;
                }
                this.jmh.setVisibility(8);
                this.jmk.setVisibility(0);
            } else {
                this.jmh.setVisibility(8);
                this.jmg.setVisibility(8);
                this.jmk.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aDW().a(this.jmj, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aDW().a(this.jmf, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jma, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jgC, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jgD, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jmc, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jgz, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jmd, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jgA, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jme, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jkC, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jmm, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuV() {
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
                if (this.jlc.jka != null) {
                    personChangeData.setNickNameLeftDays(this.jlc.jka.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().cQz);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().cQA);
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
