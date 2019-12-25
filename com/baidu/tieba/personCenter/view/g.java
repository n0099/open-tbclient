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
/* loaded from: classes6.dex */
public class g extends com.baidu.tieba.card.a<h> {
    private TextView bXt;
    private ImageView gHr;
    private View haj;
    private RelativeLayout jel;
    private PersonHeadPendantView jem;
    private TbImageView jen;
    private TextView jeo;
    private PersonCenterGuideView jep;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jem = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.haj = view.findViewById(R.id.person_header_shadow);
        this.jem.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.jem.setHasPendantStyle();
        this.jem.getHeadView().setIsRound(true);
        this.jem.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.jem.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jem.getHeadView().setPlaceHolder(2);
        this.jel = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.jen = (TbImageView) view.findViewById(R.id.member_icon);
        this.bXt = (TextView) view.findViewById(R.id.person_name);
        this.jeo = (TextView) view.findViewById(R.id.person_desc);
        this.gHr = (ImageView) view.findViewById(R.id.arrow_icon);
        this.jep = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.jen.setOnClickListener(this);
        this.jep.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jep.onChangeSkinType();
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            am.setViewTextColor(this.jeo, (int) R.color.cp_cont_j);
            SvgManager.aDW().a(this.gHr, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.jem.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.f.a.aEs().kt(2).ku(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aM(this.haj);
            csO();
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
            this.jem.a(this.mUserData);
            this.jem.a(this.mUserData, 3);
            this.bXt.setText(this.mUserData.getName_show());
            this.jeo.setText(getContext().getString(R.string.person_center_default_introduce));
            csO();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void csO() {
        csP();
        csR();
        csQ();
    }

    private void csP() {
        if (this.mUserData == null) {
            this.jen.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.jen.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.jen.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void csQ() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.bXt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aDW().a(i, null), (Drawable) null);
    }

    private void csR() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.setViewTextColor(this.bXt, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.bXt, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jen) {
                TiebaStatic.log(new an("c12523").Z("obj_locate", 2));
                if (bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    ba.aEa().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.jep) {
                this.jep.cQW();
            }
            TiebaStatic.log(new an("c12523").Z("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
