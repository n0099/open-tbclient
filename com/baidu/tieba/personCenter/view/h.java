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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.i;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.PersonCenterGuideView;
import java.util.HashMap;
/* loaded from: classes16.dex */
public class h extends com.baidu.tieba.card.b<i> {
    private TextView dTQ;
    private View iRo;
    private RelativeLayout lgE;
    private PersonHeadPendantView lgF;
    private TbImageView lgG;
    private TextView lgH;
    private ImageView lgI;
    private PersonCenterGuideView lgJ;
    private int mSkinType;
    private UserData mUserData;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.lgF = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.iRo = view.findViewById(R.id.person_header_shadow);
        this.lgF.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.lgF.setHasPendantStyle();
        this.lgF.getHeadView().setIsRound(true);
        this.lgF.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.lgF.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lgF.getHeadView().setPlaceHolder(2);
        this.lgE = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.lgG = (TbImageView) view.findViewById(R.id.member_icon);
        this.dTQ = (TextView) view.findViewById(R.id.person_name);
        this.lgH = (TextView) view.findViewById(R.id.person_desc);
        this.lgI = (ImageView) view.findViewById(R.id.arrow_icon);
        this.lgJ = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.lgG.setOnClickListener(this);
        this.lgJ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.lgJ.onChangeSkinType();
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            ap.setViewTextColor(this.lgH, R.color.cp_cont_j);
            SvgManager.bjq().a(this.lgI, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.lgF.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.e.a.bjP().on(2).oo(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aZ(this.iRo);
            dgO();
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(i iVar) {
        if (iVar != null && iVar.userData != null) {
            this.mUserData = iVar.userData;
            this.lgF.a(this.mUserData);
            this.lgF.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new aq("c13690").dD("uid", this.mUserData.getUserId()).dD("obj_locate", "0"));
                SvgManager.bjq().a(this.lgF.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.lgF.setBigVDimenSize(R.dimen.tbds57);
                this.lgF.iu(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.lgF.setBigVDimenSize(R.dimen.tbds57);
            }
            this.lgF.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.mUserData.getNewGodData() != null && h.this.mUserData.getNewGodData().hasNewGodInvited()) {
                        TiebaStatic.log(new aq("c13690").dD("uid", h.this.mUserData.getUserId()).dD("obj_locate", "1"));
                        HashMap hashMap = new HashMap();
                        hashMap.put("from", "6");
                        hashMap.put("field_id", h.this.mUserData.getNewGodData().getFieldId());
                        hashMap.put("animated", false);
                        hashMap.put("transparent", true);
                        hashMap.put("swipeback", false);
                        hashMap.put("present", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(h.this.mTbPageContext.getPageActivity(), "GodDialog", hashMap)));
                    }
                }
            });
            this.dTQ.setText(this.mUserData.getName_show());
            this.lgH.setText(getContext().getString(R.string.person_center_default_introduce));
            dgO();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dgO() {
        dgP();
        dgR();
        dgQ();
    }

    private void dgP() {
        if (this.mUserData == null) {
            this.lgG.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.lgG.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.lgG.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void dgQ() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.dTQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bjq().a(i, null), (Drawable) null);
    }

    private void dgR() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ap.setViewTextColor(this.dTQ, R.color.cp_cont_h, 1);
        } else {
            ap.setViewTextColor(this.dTQ, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.lgG) {
                TiebaStatic.log(new aq("c12523").ai("obj_locate", 2));
                if (bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    be.bju().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.lgJ) {
                this.lgJ.dFk();
            }
            TiebaStatic.log(new aq("c12523").ai("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
