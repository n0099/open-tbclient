package com.baidu.tieba.personPolymeric.tab.view;

import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ch;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.view.RoundRelativeLayout;
import tbclient.BaijiahaoInfo;
/* loaded from: classes8.dex */
public class b {
    private String kug;
    private TextView mCh;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.mEj || view == b.this.mEi) {
                if (b.this.mIsHost) {
                    b.this.dzn();
                } else {
                    PersonIntroductionActivity.ba(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.mEl) {
                b.this.dzn();
            } else if (view == b.this.mEm) {
                b.this.dzn();
            } else if (view == b.this.mEq) {
                if (StringUtils.isNull(b.this.kug)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bqD();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.kug);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new ar("c13899").dR("uid", b.this.mUserData.getUserId()));
            }
        }
    };
    private com.baidu.tieba.personPolymeric.c.a mDc;
    private AlignTextView mEd;
    private LinearLayout mEe;
    private TextView mEf;
    private AlignTextView mEg;
    private AlignTextView mEh;
    private ImageView mEi;
    private RelativeLayout mEj;
    private RelativeLayout mEk;
    private TextView mEl;
    private ImageView mEm;
    private View mEn;
    private ImageView mEo;
    private TextView mEp;
    private RoundRelativeLayout mEq;
    private TextView mEr;
    private TextView mEs;
    private ImageView mEt;
    private ImageView mEu;
    private boolean mIsHost;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitleView;
    private UserData mUserData;
    private LinearLayout myb;
    private TextView myc;
    private TextView myd;
    private TextView myf;
    private TextView myg;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_information_header, (ViewGroup) null);
        this.mRootView.setVisibility(8);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.person_information_title);
        this.myf = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.mEd = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.mEd.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.myg = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.mEe = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.mEn = this.mRootView.findViewById(R.id.space_view);
        this.mEf = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.myc = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.myb = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.mEg = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.mEg.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.myd = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.mEh = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.mEh.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.mCh = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.mEi = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.mEi.setOnClickListener(this.mClickListener);
        this.mEj = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.mEj.setOnClickListener(this.mClickListener);
        this.mEk = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.mEl = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.mEl.setOnClickListener(this.mClickListener);
        this.mEo = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.mEp = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.mEq = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.mEq.setOnClickListener(this.mClickListener);
        this.mEu = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.mEt = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.mEs = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.mEr = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.mEm = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.mEm.setOnClickListener(this.mClickListener);
        int measureText = (int) this.mEf.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.mEd.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.mEd.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mEg.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.mEg.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.mEh.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.mEh.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dS(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mDc = aVar;
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
                this.myb.setVisibility(0);
                this.myc.setVisibility(0);
                this.myc.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.myb.setVisibility(8);
                this.myc.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (au.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.myd.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            ch birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !au.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eUw == 2) {
                    this.myg.setVisibility(0);
                    this.myg.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.myg.setVisibility(8);
                }
                this.myf.setVisibility(0);
                this.myf.setText(birthdayInfo.constellation);
                this.mEe.setVisibility(0);
            } else {
                this.mEe.setVisibility(8);
                this.myf.setVisibility(8);
                this.myg.setVisibility(8);
            }
            if (this.mIsHost) {
                this.mEm.setVisibility(0);
            } else {
                this.mEm.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!au.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.myd.getLeft(), 0), 0, spannableString.length(), 18);
                    this.mCh.setText(spannableString);
                    e.mA().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.mCh.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.mEj.setOnClickListener(null);
                                    b.this.mEi.setVisibility(8);
                                    return;
                                }
                                b.this.mEj.setOnClickListener(b.this.mClickListener);
                                b.this.mEi.setVisibility(0);
                            }
                        }
                    });
                    this.mEk.setVisibility(8);
                    this.mEn.setVisibility(0);
                } else {
                    this.mEj.setVisibility(8);
                    if (this.mIsHost) {
                        this.mEk.setVisibility(0);
                        this.mEm.setVisibility(8);
                        this.mEn.setVisibility(8);
                    } else {
                        this.mEk.setVisibility(8);
                        this.mEn.setVisibility(0);
                    }
                }
            } else if (au.isEmpty(intro)) {
                this.mEj.setVisibility(8);
                if (this.mIsHost) {
                    this.mEk.setVisibility(0);
                    this.mEm.setVisibility(8);
                    this.mEn.setVisibility(8);
                } else {
                    this.mEk.setVisibility(8);
                    this.mEn.setVisibility(0);
                }
            } else {
                this.mEk.setVisibility(8);
                this.mEj.setVisibility(8);
                this.mEn.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.mEq.setVisibility(0);
                this.kug = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.kug)) {
                    this.kug = "";
                }
                this.mEr.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.kug));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.mEs.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.mEs.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.mEs.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new ar("c13898").dR("uid", this.mUserData.getUserId()));
                return;
            }
            this.mEq.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bsR().a(this.mEm, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsR().a(this.mEi, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mEd, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.myf, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.myg, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mEf, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.myc, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mEg, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.myd, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mEh, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.mCh, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mEp, R.color.CAM_X0105, 1, i);
        ap.setBackgroundColor(this.mEq, R.color.CAM_X0206);
        ap.setViewTextColor(this.mEr, R.color.CAM_X0311);
        ap.setViewTextColor(this.mEs, R.color.CAM_X0311);
        SvgManager.bsR().a(this.mEt, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a(this.mEu, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzn() {
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
                if (this.mDc.mBG != null) {
                    personChangeData.setNickNameLeftDays(this.mDc.mBG.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eUv);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eUw);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void aw(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
