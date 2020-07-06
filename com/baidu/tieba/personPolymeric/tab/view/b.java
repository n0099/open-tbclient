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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import tbclient.BaijiahaoInfo;
/* loaded from: classes11.dex */
public class b {
    private LinearLayout kKc;
    private TextView kKd;
    private TextView kKe;
    private TextView kKg;
    private TextView kKh;
    private com.baidu.tieba.personPolymeric.c.a kOH;
    private TextView kOd;
    private AlignTextView kPE;
    private LinearLayout kPF;
    private TextView kPG;
    private AlignTextView kPH;
    private AlignTextView kPI;
    private ImageView kPJ;
    private RelativeLayout kPK;
    private RelativeLayout kPL;
    private TextView kPM;
    private ImageView kPN;
    private View kPO;
    private ImageView kPP;
    private TextView kPQ;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.kPK || view == b.this.kPJ) {
                if (b.this.mIsHost) {
                    b.this.cUl();
                } else {
                    PersonIntroductionActivity.aM(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.kPM) {
                b.this.cUl();
            } else if (view == b.this.kPN) {
                b.this.cUl();
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
        this.kKg = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.kPE = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.kPE.setTextColor(an.getColor(R.color.cp_cont_c));
        this.kKh = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.kPF = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.kPO = this.mRootView.findViewById(R.id.space_view);
        this.kPG = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.kKd = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.kKc = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.kPH = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.kPH.setTextColor(an.getColor(R.color.cp_cont_c));
        this.kKe = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.kPI = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.kPI.setTextColor(an.getColor(R.color.cp_cont_c));
        this.kOd = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.kPJ = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.kPJ.setOnClickListener(this.mClickListener);
        this.kPK = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.kPK.setOnClickListener(this.mClickListener);
        this.kPL = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.kPM = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.kPM.setOnClickListener(this.mClickListener);
        this.kPP = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.kPQ = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.kPN = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.kPN.setOnClickListener(this.mClickListener);
        int measureText = (int) this.kPG.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.kPE.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.kPE.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.kPH.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.kPH.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.kPI.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.kPI.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dm(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.kOH = aVar;
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
                this.kKc.setVisibility(0);
                this.kKd.setVisibility(0);
                this.kKd.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.kKc.setVisibility(8);
                this.kKd.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (ar.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.kKe.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            ca birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !ar.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.dPb == 2) {
                    this.kKh.setVisibility(0);
                    this.kKh.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.kKh.setVisibility(8);
                }
                this.kKg.setVisibility(0);
                this.kKg.setText(birthdayInfo.constellation);
                this.kPF.setVisibility(0);
            } else {
                this.kPF.setVisibility(8);
                this.kKg.setVisibility(8);
                this.kKh.setVisibility(8);
            }
            if (this.mIsHost) {
                this.kPN.setVisibility(0);
            } else {
                this.kPN.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !ar.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!ar.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.kKe.getLeft(), 0), 0, spannableString.length(), 18);
                    this.kOd.setText(spannableString);
                    e.lt().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.kOd.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.kPK.setOnClickListener(null);
                                    b.this.kPJ.setVisibility(8);
                                    return;
                                }
                                b.this.kPK.setOnClickListener(b.this.mClickListener);
                                b.this.kPJ.setVisibility(0);
                            }
                        }
                    });
                    this.kPL.setVisibility(8);
                    this.kPO.setVisibility(0);
                    return;
                }
                this.kPK.setVisibility(8);
                if (this.mIsHost) {
                    this.kPL.setVisibility(0);
                    this.kPN.setVisibility(8);
                    this.kPO.setVisibility(8);
                    return;
                }
                this.kPL.setVisibility(8);
                this.kPO.setVisibility(0);
            } else if (ar.isEmpty(intro)) {
                this.kPK.setVisibility(8);
                if (this.mIsHost) {
                    this.kPL.setVisibility(0);
                    this.kPN.setVisibility(8);
                    this.kPO.setVisibility(8);
                    return;
                }
                this.kPL.setVisibility(8);
                this.kPO.setVisibility(0);
            } else {
                this.kPL.setVisibility(8);
                this.kPK.setVisibility(8);
                this.kPO.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aWQ().a(this.kPN, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aWQ().a(this.kPJ, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        an.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.kPE, R.color.cp_cont_c, 1, i);
        an.setViewTextColor(this.kKg, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.kKh, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.kPG, R.color.cp_cont_c, 1, i);
        an.setViewTextColor(this.kKd, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.kPH, R.color.cp_cont_c, 1, i);
        an.setViewTextColor(this.kKe, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.kPI, R.color.cp_cont_c, 1, i);
        an.setViewTextColor(this.kOd, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.kPQ, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUl() {
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
                if (this.kOH.kNC != null) {
                    personChangeData.setNickNameLeftDays(this.kOH.kNC.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().dPa);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().dPb);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void an(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
