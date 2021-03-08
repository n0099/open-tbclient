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
/* loaded from: classes7.dex */
public class b {
    private String kwi;
    private LinearLayout mAd;
    private TextView mAe;
    private TextView mAf;
    private TextView mAh;
    private TextView mAi;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.mGm || view == b.this.mGk) {
                if (b.this.mIsHost) {
                    b.this.dzw();
                } else {
                    PersonIntroductionActivity.ba(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.mGo) {
                b.this.dzw();
            } else if (view == b.this.mGp) {
                b.this.dzw();
            } else if (view == b.this.mGt) {
                if (StringUtils.isNull(b.this.kwi)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bqF();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.kwi);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new ar("c13899").dR("uid", b.this.mUserData.getUserId()));
            }
        }
    };
    private TextView mEn;
    private com.baidu.tieba.personPolymeric.c.a mFg;
    private AlignTextView mGf;
    private LinearLayout mGg;
    private TextView mGh;
    private AlignTextView mGi;
    private AlignTextView mGj;
    private ImageView mGk;
    private RelativeLayout mGm;
    private RelativeLayout mGn;
    private TextView mGo;
    private ImageView mGp;
    private View mGq;
    private ImageView mGr;
    private TextView mGs;
    private RoundRelativeLayout mGt;
    private TextView mGu;
    private TextView mGv;
    private ImageView mGw;
    private ImageView mGx;
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
        this.mAh = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.mGf = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.mGf.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.mAi = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.mGg = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.mGq = this.mRootView.findViewById(R.id.space_view);
        this.mGh = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.mAe = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.mAd = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.mGi = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.mGi.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.mAf = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.mGj = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.mGj.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.mEn = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.mGk = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.mGk.setOnClickListener(this.mClickListener);
        this.mGm = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.mGm.setOnClickListener(this.mClickListener);
        this.mGn = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.mGo = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.mGo.setOnClickListener(this.mClickListener);
        this.mGr = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.mGs = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.mGt = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.mGt.setOnClickListener(this.mClickListener);
        this.mGx = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.mGw = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.mGv = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.mGu = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.mGp = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.mGp.setOnClickListener(this.mClickListener);
        int measureText = (int) this.mGh.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.mGf.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.mGf.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mGi.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.mGi.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.mGj.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.mGj.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dS(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mFg = aVar;
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
                this.mAd.setVisibility(0);
                this.mAe.setVisibility(0);
                this.mAe.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.mAd.setVisibility(8);
                this.mAe.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (au.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.mAf.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            ch birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !au.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eVV == 2) {
                    this.mAi.setVisibility(0);
                    this.mAi.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.mAi.setVisibility(8);
                }
                this.mAh.setVisibility(0);
                this.mAh.setText(birthdayInfo.constellation);
                this.mGg.setVisibility(0);
            } else {
                this.mGg.setVisibility(8);
                this.mAh.setVisibility(8);
                this.mAi.setVisibility(8);
            }
            if (this.mIsHost) {
                this.mGp.setVisibility(0);
            } else {
                this.mGp.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!au.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.mAf.getLeft(), 0), 0, spannableString.length(), 18);
                    this.mEn.setText(spannableString);
                    e.mA().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.mEn.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.mGm.setOnClickListener(null);
                                    b.this.mGk.setVisibility(8);
                                    return;
                                }
                                b.this.mGm.setOnClickListener(b.this.mClickListener);
                                b.this.mGk.setVisibility(0);
                            }
                        }
                    });
                    this.mGn.setVisibility(8);
                    this.mGq.setVisibility(0);
                } else {
                    this.mGm.setVisibility(8);
                    if (this.mIsHost) {
                        this.mGn.setVisibility(0);
                        this.mGp.setVisibility(8);
                        this.mGq.setVisibility(8);
                    } else {
                        this.mGn.setVisibility(8);
                        this.mGq.setVisibility(0);
                    }
                }
            } else if (au.isEmpty(intro)) {
                this.mGm.setVisibility(8);
                if (this.mIsHost) {
                    this.mGn.setVisibility(0);
                    this.mGp.setVisibility(8);
                    this.mGq.setVisibility(8);
                } else {
                    this.mGn.setVisibility(8);
                    this.mGq.setVisibility(0);
                }
            } else {
                this.mGn.setVisibility(8);
                this.mGm.setVisibility(8);
                this.mGq.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.mGt.setVisibility(0);
                this.kwi = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.kwi)) {
                    this.kwi = "";
                }
                this.mGu.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.kwi));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.mGv.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.mGv.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.mGv.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new ar("c13898").dR("uid", this.mUserData.getUserId()));
                return;
            }
            this.mGt.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bsU().a(this.mGp, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bsU().a(this.mGk, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mGf, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.mAh, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mAi, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mGh, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.mAe, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mGi, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.mAf, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mGj, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.mEn, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mGs, R.color.CAM_X0105, 1, i);
        ap.setBackgroundColor(this.mGt, R.color.CAM_X0206);
        ap.setViewTextColor(this.mGu, R.color.CAM_X0311);
        ap.setViewTextColor(this.mGv, R.color.CAM_X0311);
        SvgManager.bsU().a(this.mGw, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsU().a(this.mGx, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzw() {
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
                if (this.mFg.mDM != null) {
                    personChangeData.setNickNameLeftDays(this.mFg.mDM.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eVU);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eVV);
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
