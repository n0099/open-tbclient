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
import com.baidu.tieba.personCenter.data.h;
import com.baidu.tieba.view.PersonCenterGuideView;
/* loaded from: classes7.dex */
public class g extends com.baidu.tieba.card.a<h> {
    private TextView bXF;
    private ImageView gPf;
    private View hdL;
    private RelativeLayout jhN;
    private PersonHeadPendantView jhO;
    private TbImageView jhP;
    private TextView jhQ;
    private PersonCenterGuideView jhR;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jhO = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.hdL = view.findViewById(R.id.person_header_shadow);
        this.jhO.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.jhO.setHasPendantStyle();
        this.jhO.getHeadView().setIsRound(true);
        this.jhO.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.jhO.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jhO.getHeadView().setPlaceHolder(2);
        this.jhN = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.jhP = (TbImageView) view.findViewById(R.id.member_icon);
        this.bXF = (TextView) view.findViewById(R.id.person_name);
        this.jhQ = (TextView) view.findViewById(R.id.person_desc);
        this.gPf = (ImageView) view.findViewById(R.id.arrow_icon);
        this.jhR = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.jhP.setOnClickListener(this);
        this.jhR.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jhR.onChangeSkinType();
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            am.setViewTextColor(this.jhQ, (int) R.color.cp_cont_j);
            SvgManager.aEp().a(this.gPf, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.jhO.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.f.a.aEL().kt(2).ku(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aQ(this.hdL);
            ctV();
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
            this.jhO.a(this.mUserData);
            this.jhO.a(this.mUserData, 3);
            this.bXF.setText(this.mUserData.getName_show());
            this.jhQ.setText(getContext().getString(R.string.person_center_default_introduce));
            ctV();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ctV() {
        ctW();
        ctY();
        ctX();
    }

    private void ctW() {
        if (this.mUserData == null) {
            this.jhP.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.jhP.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.jhP.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void ctX() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.bXF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(i, null), (Drawable) null);
    }

    private void ctY() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.setViewTextColor(this.bXF, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.bXF, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jhP) {
                TiebaStatic.log(new an("c12523").Z("obj_locate", 2));
                if (bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    ba.aEt().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.jhR) {
                this.jhR.cRZ();
            }
            TiebaStatic.log(new an("c12523").Z("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
