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
    private LinearLayout jlb;
    private TextView jlc;
    private TextView jld;
    private TextView jlf;
    private TextView jlg;
    private com.baidu.tieba.personPolymeric.c.a jpI;
    private TextView jpe;
    private AlignTextView jqF;
    private LinearLayout jqG;
    private TextView jqH;
    private AlignTextView jqI;
    private AlignTextView jqJ;
    private ImageView jqK;
    private RelativeLayout jqL;
    private RelativeLayout jqM;
    private TextView jqN;
    private ImageView jqO;
    private View jqP;
    private ImageView jqQ;
    private TextView jqR;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.jqL || view == b.this.jqK) {
                if (b.this.mIsHost) {
                    b.this.cxC();
                } else {
                    PersonIntroductionActivity.bc(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.jqN) {
                b.this.cxC();
            } else if (view == b.this.jqO) {
                b.this.cxC();
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
        this.jlf = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.jqF = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.jqF.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jlg = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.jqG = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.jqP = this.mRootView.findViewById(R.id.space_view);
        this.jqH = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.jlc = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.jlb = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.jqI = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.jqI.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jld = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.jqJ = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.jqJ.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jpe = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.jqK = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.jqK.setOnClickListener(this.mClickListener);
        this.jqL = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.jqL.setOnClickListener(this.mClickListener);
        this.jqM = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.jqN = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.jqN.setOnClickListener(this.mClickListener);
        this.jqQ = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.jqR = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.jqO = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.jqO.setOnClickListener(this.mClickListener);
        int measureText = (int) this.jqH.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.jqF.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.jqF.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.jqI.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.jqI.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.jqJ.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.jqJ.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.cA(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.jpI = aVar;
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
                this.jlb.setVisibility(0);
                this.jlc.setVisibility(0);
                this.jlc.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.jlb.setVisibility(8);
                this.jlc.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (aq.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.jld.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            bp birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !aq.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.cUN == 2) {
                    this.jlg.setVisibility(0);
                    this.jlg.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.jlg.setVisibility(8);
                }
                this.jlf.setVisibility(0);
                this.jlf.setText(birthdayInfo.constellation);
                this.jqG.setVisibility(0);
            } else {
                this.jqG.setVisibility(8);
                this.jlf.setVisibility(8);
                this.jlg.setVisibility(8);
            }
            if (this.mIsHost) {
                this.jqO.setVisibility(0);
            } else {
                this.jqO.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!aq.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.jld.getLeft(), 0), 0, spannableString.length(), 18);
                    this.jpe.setText(spannableString);
                    e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.jpe.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.jqL.setOnClickListener(null);
                                    b.this.jqK.setVisibility(8);
                                    return;
                                }
                                b.this.jqL.setOnClickListener(b.this.mClickListener);
                                b.this.jqK.setVisibility(0);
                            }
                        }
                    });
                    this.jqM.setVisibility(8);
                    this.jqP.setVisibility(0);
                    return;
                }
                this.jqL.setVisibility(8);
                if (this.mIsHost) {
                    this.jqM.setVisibility(0);
                    this.jqO.setVisibility(8);
                    this.jqP.setVisibility(8);
                    return;
                }
                this.jqM.setVisibility(8);
                this.jqP.setVisibility(0);
            } else if (aq.isEmpty(intro)) {
                this.jqL.setVisibility(8);
                if (this.mIsHost) {
                    this.jqM.setVisibility(0);
                    this.jqO.setVisibility(8);
                    this.jqP.setVisibility(8);
                    return;
                }
                this.jqM.setVisibility(8);
                this.jqP.setVisibility(0);
            } else {
                this.jqM.setVisibility(8);
                this.jqL.setVisibility(8);
                this.jqP.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aGC().a(this.jqO, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.jqK, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqF, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jlf, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jlg, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqH, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jlc, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqI, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jld, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqJ, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jpe, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqR, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxC() {
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
                if (this.jpI.joD != null) {
                    personChangeData.setNickNameLeftDays(this.jpI.joD.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().cUM);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().cUN);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void ai(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
