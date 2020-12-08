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
import com.baidu.tbadk.core.data.ce;
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
/* loaded from: classes24.dex */
public class b {
    private String kdc;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.mug || view == b.this.muf) {
                if (b.this.mIsHost) {
                    b.this.dAY();
                } else {
                    PersonIntroductionActivity.aX(b.this.mPageContext.getPageActivity(), b.this.mUserData.getIntro());
                }
            } else if (view == b.this.mui) {
                b.this.dAY();
            } else if (view == b.this.muj) {
                b.this.dAY();
            } else if (view == b.this.mun) {
                if (StringUtils.isNull(b.this.kdc)) {
                    BdToast.b(b.this.mPageContext.getPageActivity(), b.this.mPageContext.getPageActivity().getText(R.string.god_get_error)).brB();
                } else {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                    hotUserRankActivityConfig.setCategory(b.this.kdc);
                    hotUserRankActivityConfig.setIsGod(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                }
                TiebaStatic.log(new ar("c13899").dY("uid", b.this.mUserData.getUserId()));
            }
        }
    };
    private boolean mIsHost;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitleView;
    private UserData mUserData;
    private LinearLayout mod;
    private TextView moe;
    private TextView mof;
    private TextView moh;
    private TextView moi;
    private TextView msi;
    private com.baidu.tieba.personPolymeric.c.a mtb;
    private AlignTextView mua;
    private LinearLayout mub;
    private TextView muc;
    private AlignTextView mud;
    private AlignTextView mue;
    private ImageView muf;
    private RelativeLayout mug;
    private RelativeLayout muh;
    private TextView mui;
    private ImageView muj;
    private View muk;
    private ImageView mul;
    private TextView mum;
    private RoundRelativeLayout mun;
    private TextView muo;
    private TextView mup;
    private ImageView muq;
    private ImageView mur;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_information_header, (ViewGroup) null);
        this.mRootView.setVisibility(8);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.person_information_title);
        this.moh = (TextView) this.mRootView.findViewById(R.id.person_information_constellation);
        this.mua = (AlignTextView) this.mRootView.findViewById(R.id.person_information_constellation_label);
        this.mua.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.moi = (TextView) this.mRootView.findViewById(R.id.person_information_age);
        this.mub = (LinearLayout) this.mRootView.findViewById(R.id.person_information_constellation_layout);
        this.muk = this.mRootView.findViewById(R.id.space_view);
        this.muc = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id_label);
        this.moe = (TextView) this.mRootView.findViewById(R.id.person_information_ala_id);
        this.mod = (LinearLayout) this.mRootView.findViewById(R.id.person_information_ala_id_layout);
        this.mud = (AlignTextView) this.mRootView.findViewById(R.id.person_information_forum_age_label);
        this.mud.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.mof = (TextView) this.mRootView.findViewById(R.id.person_information_forum_age);
        this.mue = (AlignTextView) this.mRootView.findViewById(R.id.person_information_intro_label);
        this.mue.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.msi = (TextView) this.mRootView.findViewById(R.id.person_information_intro);
        this.muf = (ImageView) this.mRootView.findViewById(R.id.person_information_more_icon);
        this.muf.setOnClickListener(this.mClickListener);
        this.mug = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_intro_layout);
        this.mug.setOnClickListener(this.mClickListener);
        this.muh = (RelativeLayout) this.mRootView.findViewById(R.id.person_information_perfect);
        this.mui = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_btn);
        this.mui.setOnClickListener(this.mClickListener);
        this.mul = (ImageView) this.mRootView.findViewById(R.id.person_information_perfect_image);
        this.mum = (TextView) this.mRootView.findViewById(R.id.person_information_perfect_tip);
        this.mun = (RoundRelativeLayout) this.mRootView.findViewById(R.id.god_container);
        this.mun.setOnClickListener(this.mClickListener);
        this.mur = (ImageView) this.mRootView.findViewById(R.id.god_arrow);
        this.muq = (ImageView) this.mRootView.findViewById(R.id.god_icon);
        this.mup = (TextView) this.mRootView.findViewById(R.id.god_rank);
        this.muo = (TextView) this.mRootView.findViewById(R.id.god_title);
        this.muj = (ImageView) this.mRootView.findViewById(R.id.person_information_edit_icon);
        this.muj.setOnClickListener(this.mClickListener);
        int measureText = (int) this.muc.getPaint().measureText(this.mPageContext.getString(R.string.person_ala_id));
        ViewGroup.LayoutParams layoutParams = this.mua.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = measureText;
            this.mua.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.mud.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = measureText;
            this.mud.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.mue.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = measureText;
            this.mue.setLayoutParams(layoutParams3);
        }
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10)), NoDataViewFactory.d.dZ(null, this.mPageContext.getResources().getString(R.string.no_data_common_txt)), null);
        if (this.mRootView instanceof ViewGroup) {
            ((ViewGroup) this.mRootView).addView(this.mNoDataView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mtb = aVar;
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
                this.mod.setVisibility(0);
                this.moe.setVisibility(0);
                this.moe.setText(String.valueOf(this.mUserData.getAlaUserData().ala_id));
            } else {
                this.mod.setVisibility(8);
                this.moe.setVisibility(8);
            }
            String tb_age = this.mUserData.getTb_age();
            if (au.isEmpty(tb_age)) {
                tb_age = "0";
            }
            this.mof.setText(this.mPageContext.getResources().getString(R.string.person_forum_age_suffix, tb_age));
            ce birthdayInfo = this.mUserData.getBirthdayInfo();
            if (birthdayInfo != null && !au.isEmpty(birthdayInfo.constellation)) {
                if (birthdayInfo.age < 0) {
                    birthdayInfo.age = 0;
                }
                if (birthdayInfo.eMV == 2) {
                    this.moi.setVisibility(0);
                    this.moi.setText(this.mPageContext.getResources().getString(R.string.person_information_header_age, Integer.valueOf(birthdayInfo.age)));
                } else {
                    this.moi.setVisibility(8);
                }
                this.moh.setVisibility(0);
                this.moh.setText(birthdayInfo.constellation);
                this.mub.setVisibility(0);
            } else {
                this.mub.setVisibility(8);
                this.moh.setVisibility(8);
                this.moi.setVisibility(8);
            }
            if (this.mIsHost) {
                this.muj.setVisibility(0);
            } else {
                this.muj.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !au.isEmpty(baijiahaoInfo.auth_desc)) {
                if (!au.isEmpty(intro)) {
                    SpannableString spannableString = new SpannableString(intro);
                    spannableString.setSpan(new LeadingMarginSpan.Standard(this.mof.getLeft(), 0), 0, spannableString.length(), 18);
                    this.msi.setText(spannableString);
                    e.mY().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.tab.view.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Layout layout = b.this.msi.getLayout();
                            if (layout != null) {
                                int lineCount = layout.getLineCount();
                                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                    b.this.mug.setOnClickListener(null);
                                    b.this.muf.setVisibility(8);
                                    return;
                                }
                                b.this.mug.setOnClickListener(b.this.mClickListener);
                                b.this.muf.setVisibility(0);
                            }
                        }
                    });
                    this.muh.setVisibility(8);
                    this.muk.setVisibility(0);
                } else {
                    this.mug.setVisibility(8);
                    if (this.mIsHost) {
                        this.muh.setVisibility(0);
                        this.muj.setVisibility(8);
                        this.muk.setVisibility(8);
                    } else {
                        this.muh.setVisibility(8);
                        this.muk.setVisibility(0);
                    }
                }
            } else if (au.isEmpty(intro)) {
                this.mug.setVisibility(8);
                if (this.mIsHost) {
                    this.muh.setVisibility(0);
                    this.muj.setVisibility(8);
                    this.muk.setVisibility(8);
                } else {
                    this.muh.setVisibility(8);
                    this.muk.setVisibility(0);
                }
            } else {
                this.muh.setVisibility(8);
                this.mug.setVisibility(8);
                this.muk.setVisibility(0);
            }
            if (aVar.hotUserRankEntry != null) {
                this.mun.setVisibility(0);
                this.kdc = aVar.hotUserRankEntry.module_name;
                if (TextUtils.isEmpty(this.kdc)) {
                    this.kdc = "";
                }
                this.muo.setText(String.format(this.mPageContext.getString(R.string.god_entry_title), this.kdc));
                if (aVar.hotUserRankEntry.is_in_rank.booleanValue()) {
                    if (aVar.hotUserRankEntry.today_rank == null || aVar.hotUserRankEntry.today_rank.intValue() <= 0 || aVar.hotUserRankEntry.today_rank.intValue() > 500) {
                        this.mup.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                    } else {
                        this.mup.setText(String.format(this.mPageContext.getString(R.string.god_entry_rank), aVar.hotUserRankEntry.today_rank));
                    }
                } else {
                    this.mup.setText(this.mPageContext.getString(R.string.god_entry_no_rank));
                }
                TiebaStatic.log(new ar("c13898").dY("uid", this.mUserData.getUserId()));
                return;
            }
            this.mun.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.btW().a(this.muj, R.drawable.icon_pure_personalba_edit24_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.btW().a(this.muf, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mua, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.moh, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.moi, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.muc, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.moe, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mud, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.mof, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mue, R.color.CAM_X0108, 1, i);
        ap.setViewTextColor(this.msi, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.mum, R.color.CAM_X0105, 1, i);
        ap.setBackgroundColor(this.mun, R.color.CAM_X0206);
        ap.setViewTextColor(this.muo, (int) R.color.CAM_X0311);
        ap.setViewTextColor(this.mup, (int) R.color.CAM_X0311);
        SvgManager.btW().a(this.muq, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a(this.mur, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAY() {
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
                if (this.mtb.mrG != null) {
                    personChangeData.setNickNameLeftDays(this.mtb.mrG.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eMU);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eMV);
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
