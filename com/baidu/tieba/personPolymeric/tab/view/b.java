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
import com.baidu.tbadk.core.data.cf;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.view.RoundRelativeLayout;
import tbclient.BaijiahaoInfo;
/* loaded from: classes8.dex */
public class b {
    private String kqq;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.mzv || view == b.this.mzu) {
                if (b.this.mIsHost) {
                    b.this.dAO();
                } else {
                    PersonIntroductionActivity.bd(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.mzx) {
                b.this.dAO();
            } else if (view == b.this.mzy) {
                b.this.dAO();
            } else if (view == b.this.mzC) {
                if (StringUtils.isNull(b.this.kqq)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bud();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.kqq);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new aq("c13899").dX("uid", b.this.mUserData.getUserId()));
            }
        }
    };
    private boolean mIsHost;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitleView;
    private UserData mUserData;
    private LinearLayout mts;
    private TextView mtt;
    private TextView mtu;
    private TextView mtw;
    private TextView mtx;
    private TextView mxx;
    private com.baidu.tieba.personPolymeric.c.a myq;
    private ImageView mzA;
    private TextView mzB;
    private RoundRelativeLayout mzC;
    private TextView mzD;
    private TextView mzE;
    private ImageView mzF;
    private ImageView mzG;
    private AlignTextView mzp;
    private LinearLayout mzq;
    private TextView mzr;
    private AlignTextView mzs;
    private AlignTextView mzt;
    private ImageView mzu;
    private RelativeLayout mzv;
    private RelativeLayout mzw;
    private TextView mzx;
    private ImageView mzy;
    private View mzz;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_information_header, (ViewGroup) null);
        this.mRootView.setVisibility(8);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.person_information_title);
        this.mtw = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.mzp = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.mzp.setTextColor(ao.getColor(R.color.CAM_X0108));
        this.mtx = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.mzq = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.mzz = this.mRootView.findViewById(R.id.space_view);
        this.mzr = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.mtt = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.mts = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.mzs = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.mzs.setTextColor(ao.getColor(R.color.CAM_X0108));
        this.mtu = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.mzt = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.mzt.setTextColor(ao.getColor(R.color.CAM_X0108));
        this.mxx = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.mzu = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.mzu.setOnClickListener(this.mClickListener);
        this.mzv = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.mzv.setOnClickListener(this.mClickListener);
        this.mzw = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.mzx = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.mzx.setOnClickListener(this.mClickListener);
        this.mzA = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.mzB = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.mzC = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.mzC.setOnClickListener(this.mClickListener);
        this.mzG = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.mzF = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.mzE = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.mzD = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.mzy = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.mzy.setOnClickListener(this.mClickListener);
        int measureText = (int) this.mzr.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.mzp.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.mzp.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mzs.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.mzs.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.mzt.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.mzt.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dY(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.myq = aVar;
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
                this.mts.setVisibility(0);
                this.mtt.setVisibility(0);
                this.mtt.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.mts.setVisibility(8);
                this.mtt.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (at.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.mtu.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cf birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !at.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eWT == 2) {
                    this.mtx.setVisibility(0);
                    this.mtx.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.mtx.setVisibility(8);
                }
                this.mtw.setVisibility(0);
                this.mtw.setText(birthdayInfo.constellation);
                this.mzq.setVisibility(0);
            } else {
                this.mzq.setVisibility(8);
                this.mtw.setVisibility(8);
                this.mtx.setVisibility(8);
            }
            if (this.mIsHost) {
                this.mzy.setVisibility(0);
            } else {
                this.mzy.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !at.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!at.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.mtu.getLeft(), 0), 0, spannableString.length(), 18);
                    this.mxx.setText(spannableString);
                    e.mB().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.mxx.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.mzv.setOnClickListener(null);
                                    b.this.mzu.setVisibility(8);
                                    return;
                                }
                                b.this.mzv.setOnClickListener(b.this.mClickListener);
                                b.this.mzu.setVisibility(0);
                            }
                        }
                    });
                    this.mzw.setVisibility(8);
                    this.mzz.setVisibility(0);
                } else {
                    this.mzv.setVisibility(8);
                    if (this.mIsHost) {
                        this.mzw.setVisibility(0);
                        this.mzy.setVisibility(8);
                        this.mzz.setVisibility(8);
                    } else {
                        this.mzw.setVisibility(8);
                        this.mzz.setVisibility(0);
                    }
                }
            } else if (at.isEmpty(intro)) {
                this.mzv.setVisibility(8);
                if (this.mIsHost) {
                    this.mzw.setVisibility(0);
                    this.mzy.setVisibility(8);
                    this.mzz.setVisibility(8);
                } else {
                    this.mzw.setVisibility(8);
                    this.mzz.setVisibility(0);
                }
            } else {
                this.mzw.setVisibility(8);
                this.mzv.setVisibility(8);
                this.mzz.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.mzC.setVisibility(0);
                this.kqq = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.kqq)) {
                    this.kqq = "";
                }
                this.mzD.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.kqq));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.mzE.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.mzE.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.mzE.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new aq("c13898").dX("uid", this.mUserData.getUserId()));
                return;
            }
            this.mzC.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bwq().a(this.mzy, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bwq().a(this.mzu, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mzp, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.mtw, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mtx, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mzr, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.mtt, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mzs, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.mtu, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mzt, R.color.CAM_X0108, 1, i);
        ao.setViewTextColor(this.mxx, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.mzB, R.color.CAM_X0105, 1, i);
        ao.setBackgroundColor(this.mzC, R.color.CAM_X0206);
        ao.setViewTextColor(this.mzD, R.color.CAM_X0311);
        ao.setViewTextColor(this.mzE, R.color.CAM_X0311);
        SvgManager.bwq().a(this.mzF, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwq().a(this.mzG, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAO() {
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
                if (this.myq.mwW != null) {
                    personChangeData.setNickNameLeftDays(this.myq.mwW.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eWS);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eWT);
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
