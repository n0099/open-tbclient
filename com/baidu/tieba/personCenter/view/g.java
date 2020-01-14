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
    private RelativeLayout jhS;
    private PersonHeadPendantView jhT;
    private TbImageView jhU;
    private TextView jhV;
    private PersonCenterGuideView jhW;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jhT = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.hdL = view.findViewById(R.id.person_header_shadow);
        this.jhT.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.jhT.setHasPendantStyle();
        this.jhT.getHeadView().setIsRound(true);
        this.jhT.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.jhT.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jhT.getHeadView().setPlaceHolder(2);
        this.jhS = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.jhU = (TbImageView) view.findViewById(R.id.member_icon);
        this.bXF = (TextView) view.findViewById(R.id.person_name);
        this.jhV = (TextView) view.findViewById(R.id.person_desc);
        this.gPf = (ImageView) view.findViewById(R.id.arrow_icon);
        this.jhW = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.jhU.setOnClickListener(this);
        this.jhW.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jhW.onChangeSkinType();
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            am.setViewTextColor(this.jhV, (int) R.color.cp_cont_j);
            SvgManager.aEp().a(this.gPf, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.jhT.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.f.a.aEL().kt(2).ku(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aQ(this.hdL);
            ctX();
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
            this.jhT.a(this.mUserData);
            this.jhT.a(this.mUserData, 3);
            this.bXF.setText(this.mUserData.getName_show());
            this.jhV.setText(getContext().getString(R.string.person_center_default_introduce));
            ctX();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ctX() {
        ctY();
        cua();
        ctZ();
    }

    private void ctY() {
        if (this.mUserData == null) {
            this.jhU.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.jhU.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.jhU.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void ctZ() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.bXF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aEp().a(i, null), (Drawable) null);
    }

    private void cua() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.setViewTextColor(this.bXF, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.bXF, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jhU) {
                TiebaStatic.log(new an("c12523").Z("obj_locate", 2));
                if (bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    ba.aEt().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.jhW) {
                this.jhW.cSb();
            }
            TiebaStatic.log(new an("c12523").Z("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
