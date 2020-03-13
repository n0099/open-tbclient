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
    private LinearLayout jln;
    private TextView jlo;
    private TextView jlp;
    private TextView jlr;
    private TextView jls;
    private com.baidu.tieba.personPolymeric.c.a jpU;
    private TextView jpq;
    private AlignTextView jqR;
    private LinearLayout jqS;
    private TextView jqT;
    private AlignTextView jqU;
    private AlignTextView jqV;
    private ImageView jqW;
    private RelativeLayout jqX;
    private RelativeLayout jqY;
    private TextView jqZ;
    private ImageView jra;
    private View jrb;
    private ImageView jrc;
    private TextView jrd;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.jqX || view == b.this.jqW) {
                if (b.this.mIsHost) {
                    b.this.cxD();
                } else {
                    PersonIntroductionActivity.bc(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.jqZ) {
                b.this.cxD();
            } else if (view == b.this.jra) {
                b.this.cxD();
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
        this.jlr = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.jqR = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.jqR.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jls = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.jqS = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.jrb = this.mRootView.findViewById(R.id.space_view);
        this.jqT = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.jlo = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.jln = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.jqU = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.jqU.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jlp = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.jqV = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.jqV.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jpq = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.jqW = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.jqW.setOnClickListener(this.mClickListener);
        this.jqX = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.jqX.setOnClickListener(this.mClickListener);
        this.jqY = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.jqZ = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.jqZ.setOnClickListener(this.mClickListener);
        this.jrc = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.jrd = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.jra = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.jra.setOnClickListener(this.mClickListener);
        int measureText = (int) this.jqT.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.jqR.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.jqR.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.jqU.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.jqU.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.jqV.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.jqV.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.cA(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.jpU = aVar;
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
                this.jln.setVisibility(0);
                this.jlo.setVisibility(0);
                this.jlo.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.jln.setVisibility(8);
                this.jlo.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (aq.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.jlp.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            bp birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !aq.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.cUO == 2) {
                    this.jls.setVisibility(0);
                    this.jls.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.jls.setVisibility(8);
                }
                this.jlr.setVisibility(0);
                this.jlr.setText(birthdayInfo.constellation);
                this.jqS.setVisibility(0);
            } else {
                this.jqS.setVisibility(8);
                this.jlr.setVisibility(8);
                this.jls.setVisibility(8);
            }
            if (this.mIsHost) {
                this.jra.setVisibility(0);
            } else {
                this.jra.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!aq.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.jlp.getLeft(), 0), 0, spannableString.length(), 18);
                    this.jpq.setText(spannableString);
                    e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.jpq.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.jqX.setOnClickListener(null);
                                    b.this.jqW.setVisibility(8);
                                    return;
                                }
                                b.this.jqX.setOnClickListener(b.this.mClickListener);
                                b.this.jqW.setVisibility(0);
                            }
                        }
                    });
                    this.jqY.setVisibility(8);
                    this.jrb.setVisibility(0);
                    return;
                }
                this.jqX.setVisibility(8);
                if (this.mIsHost) {
                    this.jqY.setVisibility(0);
                    this.jra.setVisibility(8);
                    this.jrb.setVisibility(8);
                    return;
                }
                this.jqY.setVisibility(8);
                this.jrb.setVisibility(0);
            } else if (aq.isEmpty(intro)) {
                this.jqX.setVisibility(8);
                if (this.mIsHost) {
                    this.jqY.setVisibility(0);
                    this.jra.setVisibility(8);
                    this.jrb.setVisibility(8);
                    return;
                }
                this.jqY.setVisibility(8);
                this.jrb.setVisibility(0);
            } else {
                this.jqY.setVisibility(8);
                this.jqX.setVisibility(8);
                this.jrb.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aGC().a(this.jra, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.jqW, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqR, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jlr, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jls, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqT, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jlo, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqU, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jlp, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jqV, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jpq, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jrd, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxD() {
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
                if (this.jpU.joP != null) {
                    personChangeData.setNickNameLeftDays(this.jpU.joP.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().cUN);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().cUO);
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
