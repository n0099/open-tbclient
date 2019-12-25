package com.baidu.tieba.personPolymeric.header;

import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.e;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.BaijiahaoInfo;
/* loaded from: classes8.dex */
public class b {
    private TextView bXt;
    private TextView jkC;
    private ImageView jkD;
    private ImageView jkE;
    private UserIconBox jkF;
    private FrameLayout jkG;
    private TextView jkH;
    private TextView jkI;
    private FrameLayout jkJ;
    private TextView jkK;
    private TextView jkL;
    private FrameLayout jkM;
    private TextView jkN;
    private TextView jkO;
    private ImageView jkP;
    private ImageView jkQ;
    private ImageView jkR;
    private TBSpecificationBtn jkS;
    private TBSpecificationBtn jkT;
    private TbImageView jkU;
    private ImageView jkV;
    private HeadPendantView jkW;
    private View jkX;
    private TextView jkY;
    private View jkZ;
    private View.OnClickListener mClickListener;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mClickListener = onClickListener;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.bXt = (TextView) this.mRootView.findViewById(R.id.person_user_name);
        this.bXt.setOnClickListener(this.mClickListener);
        this.jkC = (TextView) this.mRootView.findViewById(R.id.person_introduction);
        this.jkC.setAlpha(0.85f);
        this.jkC.setOnClickListener(this.mClickListener);
        this.jkD = (ImageView) this.mRootView.findViewById(R.id.person_header_intro_more_icon);
        this.jkD.setOnClickListener(this.mClickListener);
        this.jkF = (UserIconBox) this.mRootView.findViewById(R.id.person_header_label_box);
        this.jkF.setOnClickListener(this.mClickListener);
        this.jkH = (TextView) this.mRootView.findViewById(R.id.person_header_fans_num);
        this.jkG = (FrameLayout) this.mRootView.findViewById(R.id.person_header_fans_layout);
        this.jkG.setOnClickListener(this.mClickListener);
        this.jkI = (TextView) this.mRootView.findViewById(R.id.person_header_fans_suffix);
        this.jkI.setAlpha(0.8f);
        this.jkQ = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_icon);
        this.jkE = (ImageView) this.mRootView.findViewById(R.id.person_header_fans_red_tip);
        this.jkK = (TextView) this.mRootView.findViewById(R.id.person_header_attention_num);
        this.jkJ = (FrameLayout) this.mRootView.findViewById(R.id.person_header_attention_layout);
        this.jkJ.setOnClickListener(this.mClickListener);
        this.jkL = (TextView) this.mRootView.findViewById(R.id.person_header_attention_suffix);
        this.jkL.setAlpha(0.8f);
        this.jkR = (ImageView) this.mRootView.findViewById(R.id.person_header_attention_icon);
        this.jkN = (TextView) this.mRootView.findViewById(R.id.person_header_forum_num);
        this.jkM = (FrameLayout) this.mRootView.findViewById(R.id.person_header_forum_layout);
        this.jkM.setOnClickListener(this.mClickListener);
        this.jkO = (TextView) this.mRootView.findViewById(R.id.person_header_forum_suffix);
        this.jkO.setAlpha(0.8f);
        this.jkP = (ImageView) this.mRootView.findViewById(R.id.person_header_forum_icon);
        this.jkS = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_attention_btn);
        this.jkS.setOnClickListener(this.mClickListener);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lc(R.color.cp_cont_b);
        this.jkS.setConfig(cVar);
        this.jkS.setText(this.mPageContext.getString(R.string.person_attention_tip));
        this.jkT = (TBSpecificationBtn) this.mRootView.findViewById(R.id.person_gift_icon_btn);
        this.jkT.setOnClickListener(this.mClickListener);
        e eVar = new e();
        eVar.lf(R.color.cp_cont_a);
        eVar.la(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        eVar.w(R.drawable.icon_mask_wo_list_gift24_svg, true);
        this.jkT.setConfig(eVar);
        this.jkU = (TbImageView) this.mRootView.findViewById(R.id.person_user_vip_icon);
        this.jkU.setOnClickListener(this.mClickListener);
        this.jkV = (ImageView) this.mRootView.findViewById(R.id.person_user_sex_icon);
        this.jkW = (HeadPendantView) this.mRootView.findViewById(R.id.person_header_header_view);
        this.jkW.setHasPendantStyle();
        this.jkW.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.jkW.getHeadView().setIsRound(true);
        this.jkW.getHeadView().setDrawBorder(false);
        this.jkW.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jkW.setOnClickListener(this.mClickListener);
        this.jkW.setBigVDimenSize(R.dimen.tbds57);
        this.jkW.setAuthIconType(3);
        this.jkW.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        this.jkZ = this.mRootView.findViewById(R.id.person_header_ring);
        this.jkZ.setAlpha(0.33f);
        this.jkX = this.mRootView.findViewById(R.id.person_header_ala_ring);
        this.jkY = (TextView) this.mRootView.findViewById(R.id.person_header_ala_live);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mRootView;
    }

    public void e(UserData userData) {
        String intro;
        int i;
        if (userData != null) {
            this.mUserData = userData;
            if (!aq.isEmpty(this.mUserData.getName_show())) {
                this.bXt.setText(this.mUserData.getName_show());
            }
            this.jkC.setVisibility(0);
            final BaijiahaoInfo baijiahaoInfo = this.mUserData.getBaijiahaoInfo();
            if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                intro = this.mPageContext.getResources().getString(R.string.person_auth_perfix, baijiahaoInfo.auth_desc);
            } else {
                intro = this.mUserData.getIntro();
                if (!aq.isEmpty(intro)) {
                    intro = this.mPageContext.getResources().getString(R.string.person_sign_prefix, intro);
                } else if (this.mIsHost) {
                    intro = this.mPageContext.getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o");
                }
            }
            if (!aq.isEmpty(intro)) {
                this.jkC.setVisibility(0);
                this.jkC.setText(intro);
                this.jkC.setEnabled(true);
                com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.personPolymeric.header.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Layout layout = b.this.jkC.getLayout();
                        if (layout != null) {
                            int lineCount = layout.getLineCount();
                            if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                                if (!b.this.mIsHost) {
                                    b.this.jkC.setEnabled(false);
                                } else if (baijiahaoInfo != null && !aq.isEmpty(baijiahaoInfo.auth_desc)) {
                                    b.this.jkC.setEnabled(false);
                                }
                                b.this.jkD.setVisibility(8);
                                return;
                            }
                            b.this.jkD.setVisibility(0);
                        }
                    }
                });
            } else {
                this.jkC.setVisibility(8);
            }
            this.jkF.a(this.mUserData.getIconInfo(), 9, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            this.jkH.setText(aq.numFormatOverWanNa(this.mUserData.getFansNum()));
            this.jkN.setText(aq.numFormatOverWanNa(this.mUserData.getLike_bars()));
            this.jkK.setText(aq.numFormatOverWanNa(this.mUserData.getConcernNum()));
            if (this.mIsHost) {
                this.jkS.setVisibility(8);
                this.jkT.setVisibility(8);
            } else {
                this.jkT.setVisibility(0);
                this.jkS.setVisibility(0);
                re(this.mUserData.getHave_attention() == 1);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.jkU.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                this.jkU.setVisibility(0);
            } else if (this.mIsHost) {
                this.jkU.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.jkU.setVisibility(0);
            } else {
                this.jkU.setVisibility(8);
            }
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
            } else {
                i = R.drawable.icon_mask_boy16_svg;
            }
            SvgManager.aDW().a(this.jkV, i, SvgManager.SvgResourceStateType.NORMAL);
            if (this.mUserData.getSex() == 0) {
                this.jkV.setVisibility(8);
            } else {
                this.jkV.setVisibility(0);
            }
            AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1) {
                this.jkX.setVisibility(0);
                this.jkY.setVisibility(0);
                this.jkW.tz(this.mUserData.getAvater());
                return;
            }
            this.jkW.a(this.mUserData);
            this.jkY.setVisibility(8);
            this.jkX.setVisibility(8);
        }
    }

    public void Gw(String str) {
        this.jkW.ty(str);
    }

    public void re(boolean z) {
        if (z) {
            this.jkS.setText(this.mPageContext.getString(R.string.person_attention_has_attention));
            if (this.jkS.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) this.jkS.getStyleConfig()).aFJ();
                return;
            }
            return;
        }
        this.jkS.setText(this.mPageContext.getString(R.string.person_attention_tip));
        if (this.jkS.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
            ((com.baidu.tbadk.core.view.commonBtn.c) this.jkS.getStyleConfig()).lc(R.color.cp_cont_b);
        }
    }

    public void rf(boolean z) {
        if (z) {
            this.jkE.setVisibility(0);
        } else {
            this.jkE.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        SvgManager.aDW().a(this.jkP, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aDW().a(this.jkQ, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aDW().a(this.jkR, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jkT.aFd();
        this.jkS.aFd();
        SvgManager.aDW().a(this.jkD, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        am.setViewTextColor(this.bXt, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jkC, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jkH, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jkI, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jkK, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jkL, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jkN, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jkO, R.color.cp_cont_a, 1, i);
        am.setImageResource(this.jkE, R.drawable.icon_news_down_bar_one);
        am.setBackgroundResource(this.jkZ, R.drawable.person_header_bg, i);
        if (this.mUserData != null) {
            SvgManager.aDW().a(this.jkV, this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public TbImageView cuD() {
        return this.jkU;
    }

    public View cuE() {
        return this.jkS;
    }

    public View cuF() {
        return this.jkT;
    }

    public TextView getUserName() {
        return this.bXt;
    }

    public TextView cuG() {
        return this.jkC;
    }

    public UserIconBox cuH() {
        return this.jkF;
    }

    public FrameLayout cuI() {
        return this.jkG;
    }

    public FrameLayout cuJ() {
        return this.jkJ;
    }

    public FrameLayout cuK() {
        return this.jkM;
    }

    public HeadPendantView cuL() {
        return this.jkW;
    }

    public ImageView cuM() {
        return this.jkD;
    }
}
