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
    private TextView cAX;
    private View hRj;
    private RelativeLayout jUN;
    private PersonHeadPendantView jUO;
    private TbImageView jUP;
    private TextView jUQ;
    private ImageView jUR;
    private PersonCenterGuideView jUS;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jUO = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.hRj = view.findViewById(R.id.person_header_shadow);
        this.jUO.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.jUO.setHasPendantStyle();
        this.jUO.getHeadView().setIsRound(true);
        this.jUO.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.jUO.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jUO.getHeadView().setPlaceHolder(2);
        this.jUN = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.jUP = (TbImageView) view.findViewById(R.id.member_icon);
        this.cAX = (TextView) view.findViewById(R.id.person_name);
        this.jUQ = (TextView) view.findViewById(R.id.person_desc);
        this.jUR = (ImageView) view.findViewById(R.id.arrow_icon);
        this.jUS = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.jUP.setOnClickListener(this);
        this.jUS.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jUS.onChangeSkinType();
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            am.setViewTextColor(this.jUQ, (int) R.color.cp_cont_j);
            SvgManager.aOU().a(this.jUR, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.jUO.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.e.a.aPt().kU(2).kV(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aR(this.hRj);
            cGw();
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
            this.jUO.a(this.mUserData);
            this.jUO.a(this.mUserData, 3);
            this.cAX.setText(this.mUserData.getName_show());
            this.jUQ.setText(getContext().getString(R.string.person_center_default_introduce));
            cGw();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cGw() {
        cGx();
        cGz();
        cGy();
    }

    private void cGx() {
        if (this.mUserData == null) {
            this.jUP.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.jUP.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.jUP.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void cGy() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.cAX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aOU().a(i, null), (Drawable) null);
    }

    private void cGz() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.setViewTextColor(this.cAX, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.cAX, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jUP) {
                TiebaStatic.log(new an("c12523").af("obj_locate", 2));
                if (bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    ba.aOY().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.jUS) {
                this.jUS.deI();
            }
            TiebaStatic.log(new an("c12523").af("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
