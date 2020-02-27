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
    private TextView cbJ;
    private ImageView gRf;
    private View hfL;
    private RelativeLayout jiM;
    private PersonHeadPendantView jiN;
    private TbImageView jiO;
    private TextView jiP;
    private PersonCenterGuideView jiQ;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jiN = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.hfL = view.findViewById(R.id.person_header_shadow);
        this.jiN.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.jiN.setHasPendantStyle();
        this.jiN.getHeadView().setIsRound(true);
        this.jiN.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.jiN.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jiN.getHeadView().setPlaceHolder(2);
        this.jiM = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.jiO = (TbImageView) view.findViewById(R.id.member_icon);
        this.cbJ = (TextView) view.findViewById(R.id.person_name);
        this.jiP = (TextView) view.findViewById(R.id.person_desc);
        this.gRf = (ImageView) view.findViewById(R.id.arrow_icon);
        this.jiQ = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.jiO.setOnClickListener(this);
        this.jiQ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jiQ.onChangeSkinType();
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            am.setViewTextColor(this.jiP, (int) R.color.cp_cont_j);
            SvgManager.aGA().a(this.gRf, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.jiN.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.f.a.aGX().kK(2).kL(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aQ(this.hfL);
            cvq();
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
            this.jiN.a(this.mUserData);
            this.jiN.a(this.mUserData, 3);
            this.cbJ.setText(this.mUserData.getName_show());
            this.jiP.setText(getContext().getString(R.string.person_center_default_introduce));
            cvq();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cvq() {
        cvr();
        cvt();
        cvs();
    }

    private void cvr() {
        if (this.mUserData == null) {
            this.jiO.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.jiO.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.jiO.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void cvs() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.cbJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGA().a(i, null), (Drawable) null);
    }

    private void cvt() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.setViewTextColor(this.cbJ, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.cbJ, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jiO) {
                TiebaStatic.log(new an("c12523").X("obj_locate", 2));
                if (bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    ba.aGE().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.jiQ) {
                this.jiQ.cTw();
            }
            TiebaStatic.log(new an("c12523").X("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
