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
    private TextView dTU;
    private View iRu;
    private RelativeLayout lgL;
    private PersonHeadPendantView lgM;
    private TbImageView lgN;
    private TextView lgO;
    private ImageView lgP;
    private PersonCenterGuideView lgQ;
    private int mSkinType;
    private UserData mUserData;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.lgM = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.iRu = view.findViewById(R.id.person_header_shadow);
        this.lgM.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.lgM.setHasPendantStyle();
        this.lgM.getHeadView().setIsRound(true);
        this.lgM.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.lgM.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lgM.getHeadView().setPlaceHolder(2);
        this.lgL = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.lgN = (TbImageView) view.findViewById(R.id.member_icon);
        this.dTU = (TextView) view.findViewById(R.id.person_name);
        this.lgO = (TextView) view.findViewById(R.id.person_desc);
        this.lgP = (ImageView) view.findViewById(R.id.arrow_icon);
        this.lgQ = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.lgN.setOnClickListener(this);
        this.lgQ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.lgQ.onChangeSkinType();
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            ap.setViewTextColor(this.lgO, R.color.cp_cont_j);
            SvgManager.bjq().a(this.lgP, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.lgM.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.e.a.bjP().on(2).oo(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aZ(this.iRu);
            dgP();
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
            this.lgM.a(this.mUserData);
            this.lgM.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new aq("c13690").dD("uid", this.mUserData.getUserId()).dD("obj_locate", "0"));
                SvgManager.bjq().a(this.lgM.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.lgM.setBigVDimenSize(R.dimen.tbds57);
                this.lgM.iv(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.lgM.setBigVDimenSize(R.dimen.tbds57);
            }
            this.lgM.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.h.1
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
            this.dTU.setText(this.mUserData.getName_show());
            this.lgO.setText(getContext().getString(R.string.person_center_default_introduce));
            dgP();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dgP() {
        dgQ();
        dgS();
        dgR();
    }

    private void dgQ() {
        if (this.mUserData == null) {
            this.lgN.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.lgN.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.lgN.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void dgR() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.dTU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bjq().a(i, null), (Drawable) null);
    }

    private void dgS() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ap.setViewTextColor(this.dTU, R.color.cp_cont_h, 1);
        } else {
            ap.setViewTextColor(this.dTU, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.lgN) {
                TiebaStatic.log(new aq("c12523").ai("obj_locate", 2));
                if (bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    be.bju().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.lgQ) {
                this.lgQ.dFt();
            }
            TiebaStatic.log(new aq("c12523").ai("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
