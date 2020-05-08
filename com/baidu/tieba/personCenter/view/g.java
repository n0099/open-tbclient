package com.baidu.tieba.personCenter.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.h;
import com.baidu.tieba.view.PersonCenterGuideView;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.a<h> {
    private TextView cBd;
    private View hRp;
    private RelativeLayout jUR;
    private PersonHeadPendantView jUS;
    private TbImageView jUT;
    private TextView jUU;
    private ImageView jUV;
    private PersonCenterGuideView jUW;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jUS = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.hRp = view.findViewById(R.id.person_header_shadow);
        this.jUS.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.jUS.setHasPendantStyle();
        this.jUS.getHeadView().setIsRound(true);
        this.jUS.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.jUS.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jUS.getHeadView().setPlaceHolder(2);
        this.jUR = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.jUT = (TbImageView) view.findViewById(R.id.member_icon);
        this.cBd = (TextView) view.findViewById(R.id.person_name);
        this.jUU = (TextView) view.findViewById(R.id.person_desc);
        this.jUV = (ImageView) view.findViewById(R.id.arrow_icon);
        this.jUW = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.jUT.setOnClickListener(this);
        this.jUW.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jUW.onChangeSkinType();
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            am.setViewTextColor(this.jUU, (int) R.color.cp_cont_j);
            SvgManager.aOR().a(this.jUV, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.jUS.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.e.a.aPq().kU(2).kV(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aR(this.hRp);
            cGt();
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(h hVar) {
        if (hVar != null && hVar.userData != null) {
            this.mUserData = hVar.userData;
            this.jUS.a(this.mUserData);
            this.jUS.a(this.mUserData, 3);
            this.cBd.setText(this.mUserData.getName_show());
            this.jUU.setText(getContext().getString(R.string.person_center_default_introduce));
            cGt();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cGt() {
        cGu();
        cGw();
        cGv();
    }

    private void cGu() {
        if (this.mUserData == null) {
            this.jUT.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.jUT.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.jUT.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void cGv() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.cBd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOR().a(i, null), (Drawable) null);
    }

    private void cGw() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.setViewTextColor(this.cBd, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.cBd, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jUT) {
                TiebaStatic.log(new an("c12523").af("obj_locate", 2));
                if (bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    ba.aOV().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.jUW) {
                this.jUW.deF();
            }
            TiebaStatic.log(new an("c12523").af("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
