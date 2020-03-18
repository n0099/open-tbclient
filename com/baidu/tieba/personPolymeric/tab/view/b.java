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
    private LinearLayout jmN;
    private TextView jmO;
    private TextView jmP;
    private TextView jmR;
    private TextView jmS;
    private TextView jqP;
    private com.baidu.tieba.personPolymeric.c.a jrt;
    private View jsA;
    private ImageView jsB;
    private TextView jsC;
    private AlignTextView jsq;
    private LinearLayout jsr;
    private TextView jss;
    private AlignTextView jst;
    private AlignTextView jsu;
    private ImageView jsv;
    private RelativeLayout jsw;
    private RelativeLayout jsx;
    private TextView jsy;
    private ImageView jsz;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.jsw || view == b.this.jsv) {
                if (b.this.mIsHost) {
                    b.this.cxW();
                } else {
                    PersonIntroductionActivity.bc(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.jsy) {
                b.this.cxW();
            } else if (view == b.this.jsz) {
                b.this.cxW();
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
        this.jmR = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.jsq = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.jsq.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jmS = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.jsr = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.jsA = this.mRootView.findViewById(R.id.space_view);
        this.jss = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.jmO = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.jmN = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.jst = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.jst.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jmP = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.jsu = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.jsu.setTextColor(am.getColor(R.color.cp_cont_c));
        this.jqP = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.jsv = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.jsv.setOnClickListener(this.mClickListener);
        this.jsw = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.jsw.setOnClickListener(this.mClickListener);
        this.jsx = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.jsy = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.jsy.setOnClickListener(this.mClickListener);
        this.jsB = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.jsC = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.jsz = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.jsz.setOnClickListener(this.mClickListener);
        int measureText = (int) this.jss.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.jsq.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.jsq.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.jst.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.jst.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.jsu.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.jsu.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.cz(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.jrt = aVar;
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
                this.jmN.setVisibility(0);
                this.jmO.setVisibility(0);
                this.jmO.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.jmN.setVisibility(8);
                this.jmO.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (aq.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.jmP.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            bp birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !aq.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.cVb == 2) {
                    this.jmS.setVisibility(0);
                    this.jmS.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.jmS.setVisibility(8);
                }
                this.jmR.setVisibility(0);
                this.jmR.setText(birthdayInfo.constellation);
                this.jsr.setVisibility(0);
            } else {
                this.jsr.setVisibility(8);
                this.jmR.setVisibility(8);
                this.jmS.setVisibility(8);
            }
            if (this.mIsHost) {
                this.jsz.setVisibility(0);
            } else {
                this.jsz.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!aq.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.jmP.getLeft(), 0), 0, spannableString.length(), 18);
                    this.jqP.setText(spannableString);
                    e.gx().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.jqP.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.jsw.setOnClickListener(null);
                                    b.this.jsv.setVisibility(8);
                                    return;
                                }
                                b.this.jsw.setOnClickListener(b.this.mClickListener);
                                b.this.jsv.setVisibility(0);
                            }
                        }
                    });
                    this.jsx.setVisibility(8);
                    this.jsA.setVisibility(0);
                    return;
                }
                this.jsw.setVisibility(8);
                if (this.mIsHost) {
                    this.jsx.setVisibility(0);
                    this.jsz.setVisibility(8);
                    this.jsA.setVisibility(8);
                    return;
                }
                this.jsx.setVisibility(8);
                this.jsA.setVisibility(0);
            } else if (aq.isEmpty(intro)) {
                this.jsw.setVisibility(8);
                if (this.mIsHost) {
                    this.jsx.setVisibility(0);
                    this.jsz.setVisibility(8);
                    this.jsA.setVisibility(8);
                    return;
                }
                this.jsx.setVisibility(8);
                this.jsA.setVisibility(0);
            } else {
                this.jsx.setVisibility(8);
                this.jsw.setVisibility(8);
                this.jsA.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aGG().a(this.jsz, R.drawable.icon_pure_personalba_edit24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGG().a(this.jsv, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.mTitleView, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jsq, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jmR, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jmS, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jss, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jmO, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jst, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jmP, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jsu, R.color.cp_cont_c, 1, i);
        am.setViewTextColor(this.jqP, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.jsC, R.color.cp_cont_b, 1, i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxW() {
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
                if (this.jrt.jqo != null) {
                    personChangeData.setNickNameLeftDays(this.jrt.jqo.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().cVa);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().cVb);
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
