package com.baidu.tieba.personPolymeric.tab.view;

import android.support.v7.widget.RecyclerView;
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
import com.baidu.tbadk.core.data.cd;
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
/* loaded from: classes23.dex */
public class b {
    private String jPz;
    private LinearLayout lZV;
    private TextView lZW;
    private TextView lZX;
    private TextView lZZ;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.mga || view == b.this.mfZ) {
                if (b.this.mIsHost) {
                    b.this.dvG();
                } else {
                    PersonIntroductionActivity.aT(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.mgc) {
                b.this.dvG();
            } else if (view == b.this.mgd) {
                b.this.dvG();
            } else if (view == b.this.mgh) {
                if (StringUtils.isNull(b.this.jPz)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).bom();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.jPz);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new ar("c13899").dR("uid", b.this.mUserData.getUserId()));
            }
        }
    };
    private boolean mIsHost;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitleView;
    private UserData mUserData;
    private TextView maa;
    private com.baidu.tieba.personPolymeric.c.a meV;
    private TextView meb;
    private AlignTextView mfU;
    private LinearLayout mfV;
    private TextView mfW;
    private AlignTextView mfX;
    private AlignTextView mfY;
    private ImageView mfZ;
    private RelativeLayout mga;
    private RelativeLayout mgb;
    private TextView mgc;
    private ImageView mgd;
    private View mge;
    private ImageView mgf;
    private TextView mgg;
    private RoundRelativeLayout mgh;
    private TextView mgi;
    private TextView mgj;
    private ImageView mgk;
    private ImageView mgl;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_information_header, (ViewGroup) null);
        this.mRootView.setVisibility(8);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.person_information_title);
        this.lZZ = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.mfU = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.mfU.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.maa = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.mfV = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.mge = this.mRootView.findViewById(R.id.space_view);
        this.mfW = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.lZW = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.lZV = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.mfX = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.mfX.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.lZX = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.mfY = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.mfY.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.meb = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.mfZ = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.mfZ.setOnClickListener(this.mClickListener);
        this.mga = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.mga.setOnClickListener(this.mClickListener);
        this.mgb = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.mgc = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.mgc.setOnClickListener(this.mClickListener);
        this.mgf = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.mgg = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.mgh = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.mgh.setOnClickListener(this.mClickListener);
        this.mgl = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.mgk = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.mgj = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.mgi = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.mgd = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.mgd.setOnClickListener(this.mClickListener);
        int measureText = (int) this.mfW.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.mfU.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.mfU.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mfX.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.mfX.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.mfY.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.mfY.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dS(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.meV = aVar;
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
                this.lZV.setVisibility(0);
                this.lZW.setVisibility(0);
                this.lZW.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.lZV.setVisibility(8);
                this.lZW.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (au.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.lZX.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            cd birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !au.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eFS == 2) {
                    this.maa.setVisibility(0);
                    this.maa.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.maa.setVisibility(8);
                }
                this.lZZ.setVisibility(0);
                this.lZZ.setText(birthdayInfo.constellation);
                this.mfV.setVisibility(0);
            } else {
                this.mfV.setVisibility(8);
                this.lZZ.setVisibility(8);
                this.maa.setVisibility(8);
            }
            if (this.mIsHost) {
                this.mgd.setVisibility(0);
            } else {
                this.mgd.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!au.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.lZX.getLeft(), 0), 0, spannableString.length(), 18);
                    this.meb.setText(spannableString);
                    e.mY().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.meb.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.mga.setOnClickListener(null);
                                    b.this.mfZ.setVisibility(8);
                                    return;
                                }
                                b.this.mga.setOnClickListener(b.this.mClickListener);
                                b.this.mfZ.setVisibility(0);
                            }
                        }
                    });
                    this.mgb.setVisibility(8);
                    this.mge.setVisibility(0);
                } else {
                    this.mga.setVisibility(8);
                    if (this.mIsHost) {
                        this.mgb.setVisibility(0);
                        this.mgd.setVisibility(8);
                        this.mge.setVisibility(8);
                    } else {
                        this.mgb.setVisibility(8);
                        this.mge.setVisibility(0);
                    }
                }
            } else if (au.isEmpty(intro)) {
                this.mga.setVisibility(8);
                if (this.mIsHost) {
                    this.mgb.setVisibility(0);
                    this.mgd.setVisibility(8);
                    this.mge.setVisibility(8);
                } else {
                    this.mgb.setVisibility(8);
                    this.mge.setVisibility(0);
                }
            } else {
                this.mgb.setVisibility(8);
                this.mga.setVisibility(8);
                this.mge.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.mgh.setVisibility(0);
                this.jPz = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.jPz)) {
                    this.jPz = "";
                }
                this.mgi.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.jPz));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.mgj.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.mgj.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.mgj.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new ar("c13898").dR("uid", this.mUserData.getUserId()));
                return;
            }
            this.mgh.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.bqB().a(this.mgd, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bqB().a(this.mfZ, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mfU, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.lZZ, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.maa, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mfW, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.lZW, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mfX, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.lZX, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mfY, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.meb, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mgg, R.color.CAM_X0105, 1, i);
        ap.setBackgroundColor(this.mgh, R.color.CAM_X0206);
        ap.setViewTextColor(this.mgi, R.color.CAM_X0311);
        ap.setViewTextColor(this.mgj, R.color.CAM_X0311);
        SvgManager.bqB().a(this.mgk, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bqB().a(this.mgl, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvG() {
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
                if (this.meV.mdA != null) {
                    personChangeData.setNickNameLeftDays(this.meV.mdA.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eFR);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eFS);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void au(boolean z, boolean z2) {
        if (!z2 && z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }
}
