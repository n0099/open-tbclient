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
    private LinearLayout jkZ;
    private TextView jla;
    private TextView jlb;
    private TextView jld;
    private TextView jle;
    private com.baidu.tieba.personPolymeric.c.a jpG;
    private TextView jpc;
    private AlignTextView jqD;
    private LinearLayout jqE;
    private TextView jqF;
    private AlignTextView jqG;
    private AlignTextView jqH;
    private ImageView jqI;
    private RelativeLayout jqJ;
    private RelativeLayout jqK;
    private TextView jqL;
    private ImageView jqM;
    private View jqN;
    private ImageView jqO;
    private TextView jqP;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.jqJ || view == b.this.jqI) {
                if (b.this.mIsHost) {
                    b.this.cxA();
                } else {
                    PersonIntroductionActivity.bc(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.jqL) {
                b.this.cxA();
            } else if (view == b.this.jqM) {
                b.this.cxA();
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
        this.jld = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.jqD = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.jqD.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jle = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.jqE = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.jqN = this.mRootView.findViewById(R.id.space_view);
        this.jqF = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.jla = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.jkZ = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.jqG = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.jqG.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jlb = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.jqH = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.jqH.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jpc = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.jqI = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.jqI.setOnClickListener(this.mClickListener);
        this.jqJ = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.jqJ.setOnClickListener(this.mClickListener);
        this.jqK = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.jqL = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.jqL.setOnClickListener(this.mClickListener);
        this.jqO = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.jqP = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.jqM = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.jqM.setOnClickListener(this.mClickListener);
        int measureText = (int) this.jqF.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.jqD.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.jqD.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.jqG.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.jqG.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.jqH.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.jqH.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.cA(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.jpG = aVar;
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
                this.jkZ.setVisibility(0);
                this.jla.setVisibility(0);
                this.jla.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.jkZ.setVisibility(8);
                this.jla.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (aq.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.jlb.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            bp birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !aq.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.cUM == 2) {
                    this.jle.setVisibility(0);
                    this.jle.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.jle.setVisibility(8);
                }
                this.jld.setVisibility(0);
                this.jld.setText(birthdayInfo.constellation);
                this.jqE.setVisibility(0);
            } else {
                this.jqE.setVisibility(8);
                this.jld.setVisibility(8);
                this.jle.setVisibility(8);
            }
            if (this.mIsHost) {
                this.jqM.setVisibility(0);
            } else {
                this.jqM.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!aq.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.jlb.getLeft(), 0), 0, spannableString.length(), 18);
                    this.jpc.setText(spannableString);
                    e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.jpc.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.jqJ.setOnClickListener(null);
                                    b.this.jqI.setVisibility(8);
                                    return;
                                }
                                b.this.jqJ.setOnClickListener(b.this.mClickListener);
                                b.this.jqI.setVisibility(0);
                            }
                        }
                    });
                    this.jqK.setVisibility(8);
                    this.jqN.setVisibility(0);
                    return;
                }
                this.jqJ.setVisibility(8);
                if (this.mIsHost) {
                    this.jqK.setVisibility(0);
                    this.jqM.setVisibility(8);
                    this.jqN.setVisibility(8);
                    return;
                }
                this.jqK.setVisibility(8);
                this.jqN.setVisibility(0);
            } else if (aq.isEmpty(intro)) {
                this.jqJ.setVisibility(8);
                if (this.mIsHost) {
                    this.jqK.setVisibility(0);
                    this.jqM.setVisibility(8);
                    this.jqN.setVisibility(8);
                    return;
                }
                this.jqK.setVisibility(8);
                this.jqN.setVisibility(0);
            } else {
                this.jqK.setVisibility(8);
                this.jqJ.setVisibility(8);
                this.jqN.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aGA().a(this.jqM, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGA().a(this.jqI, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqD, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jld, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jle, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqF, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jla, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqG, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jlb, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqH, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jpc, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqP, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxA() {
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
                if (this.jpG.joB != null) {
                    personChangeData.setNickNameLeftDays(this.jpG.joB.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().cUL);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().cUM);
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
