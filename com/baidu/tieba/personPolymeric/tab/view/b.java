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
    private LinearLayout koY;
    private TextView koZ;
    private TextView kpa;
    private TextView kpc;
    private TextView kpd;
    private com.baidu.tieba.personPolymeric.c.a ktE;
    private TextView kta;
    private AlignTextView kuB;
    private LinearLayout kuC;
    private TextView kuD;
    private AlignTextView kuE;
    private AlignTextView kuF;
    private ImageView kuG;
    private RelativeLayout kuH;
    private RelativeLayout kuI;
    private TextView kuJ;
    private ImageView kuK;
    private View kuL;
    private ImageView kuM;
    private TextView kuN;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.kuH || view == b.this.kuG) {
                if (b.this.mIsHost) {
                    b.this.cPD();
                } else {
                    PersonIntroductionActivity.aM(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.kuJ) {
                b.this.cPD();
            } else if (view == b.this.kuK) {
                b.this.cPD();
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
        this.kpc = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.kuB = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.kuB.setTextColor(am.getColor(R.color.cp_cont_c));
        this.kpd = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.kuC = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.kuL = this.mRootView.findViewById(R.id.space_view);
        this.kuD = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.koZ = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.koY = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.kuE = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.kuE.setTextColor(am.getColor(R.color.cp_cont_c));
        this.kpa = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.kuF = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.kuF.setTextColor(am.getColor(R.color.cp_cont_c));
        this.kta = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.kuG = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.kuG.setOnClickListener(this.mClickListener);
        this.kuH = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.kuH.setOnClickListener(this.mClickListener);
        this.kuI = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.kuJ = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.kuJ.setOnClickListener(this.mClickListener);
        this.kuM = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.kuN = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.kuK = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.kuK.setOnClickListener(this.mClickListener);
        int measureText = (int) this.kuD.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.kuB.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.kuB.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.kuE.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.kuE.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.kuF.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.kuF.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dj(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.ktE = aVar;
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
                this.koY.setVisibility(0);
                this.koZ.setVisibility(0);
                this.koZ.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.koY.setVisibility(8);
                this.koZ.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (aq.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.kpa.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            bq birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !aq.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.dIl == 2) {
                    this.kpd.setVisibility(0);
                    this.kpd.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.kpd.setVisibility(8);
                }
                this.kpc.setVisibility(0);
                this.kpc.setText(birthdayInfo.constellation);
                this.kuC.setVisibility(0);
            } else {
                this.kuC.setVisibility(8);
                this.kpc.setVisibility(8);
                this.kpd.setVisibility(8);
            }
            if (this.mIsHost) {
                this.kuK.setVisibility(0);
            } else {
                this.kuK.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!aq.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.kpa.getLeft(), 0), 0, spannableString.length(), 18);
                    this.kta.setText(spannableString);
                    e.ld().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.kta.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.kuH.setOnClickListener(null);
                                    b.this.kuG.setVisibility(8);
                                    return;
                                }
                                b.this.kuH.setOnClickListener(b.this.mClickListener);
                                b.this.kuG.setVisibility(0);
                            }
                        }
                    });
                    this.kuI.setVisibility(8);
                    this.kuL.setVisibility(0);
                    return;
                }
                this.kuH.setVisibility(8);
                if (this.mIsHost) {
                    this.kuI.setVisibility(0);
                    this.kuK.setVisibility(8);
                    this.kuL.setVisibility(8);
                    return;
                }
                this.kuI.setVisibility(8);
                this.kuL.setVisibility(0);
            } else if (aq.isEmpty(intro)) {
                this.kuH.setVisibility(8);
                if (this.mIsHost) {
                    this.kuI.setVisibility(0);
                    this.kuK.setVisibility(8);
                    this.kuL.setVisibility(8);
                    return;
                }
                this.kuI.setVisibility(8);
                this.kuL.setVisibility(0);
            } else {
                this.kuI.setVisibility(8);
                this.kuH.setVisibility(8);
                this.kuL.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aUV().a(this.kuK, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUV().a(this.kuG, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kuB, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.kpc, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kpd, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kuD, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.koZ, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kuE, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.kpa, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kuF, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.kta, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.kuN, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPD() {
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
                if (this.ktE.ksz != null) {
                    personChangeData.setNickNameLeftDays(this.ktE.ksz.left_days.intValue());
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
