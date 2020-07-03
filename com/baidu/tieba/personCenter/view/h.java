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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.i;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.PersonCenterGuideView;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class h extends com.baidu.tieba.card.b<i> {
    private TextView dEL;
    private View iwk;
    private RelativeLayout kHL;
    private PersonHeadPendantView kHM;
    private TbImageView kHN;
    private TextView kHO;
    private ImageView kHP;
    private PersonCenterGuideView kHQ;
    private int mSkinType;
    private UserData mUserData;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.kHM = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.iwk = view.findViewById(R.id.person_header_shadow);
        this.kHM.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.kHM.setHasPendantStyle();
        this.kHM.getHeadView().setIsRound(true);
        this.kHM.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.kHM.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kHM.getHeadView().setPlaceHolder(2);
        this.kHL = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.kHN = (TbImageView) view.findViewById(R.id.member_icon);
        this.dEL = (TextView) view.findViewById(R.id.person_name);
        this.kHO = (TextView) view.findViewById(R.id.person_desc);
        this.kHP = (ImageView) view.findViewById(R.id.arrow_icon);
        this.kHQ = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.kHN.setOnClickListener(this);
        this.kHQ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.kHQ.onChangeSkinType();
            an.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            an.setViewTextColor(this.kHO, (int) R.color.cp_cont_j);
            SvgManager.aWQ().a(this.kHP, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.kHM.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.e.a.aXp().lP(2).lQ(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aR(this.iwk);
            cSa();
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
            this.kHM.a(this.mUserData);
            this.kHM.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new ao("c13690").dk("uid", this.mUserData.getUserId()).dk("obj_locate", "0"));
                SvgManager.aWQ().a(this.kHM.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.kHM.setBigVDimenSize(R.dimen.tbds57);
                this.kHM.hs(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.kHM.setBigVDimenSize(R.dimen.tbds57);
            }
            this.kHM.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.mUserData.getNewGodData() != null && h.this.mUserData.getNewGodData().hasNewGodInvited()) {
                        TiebaStatic.log(new ao("c13690").dk("uid", h.this.mUserData.getUserId()).dk("obj_locate", "1"));
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
            this.dEL.setText(this.mUserData.getName_show());
            this.kHO.setText(getContext().getString(R.string.person_center_default_introduce));
            cSa();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cSa() {
        cSb();
        cSd();
        cSc();
    }

    private void cSb() {
        if (this.mUserData == null) {
            this.kHN.setImageDrawable(an.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.kHN.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.kHN.setImageDrawable(an.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void cSc() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.dEL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aWQ().a(i, null), (Drawable) null);
    }

    private void cSd() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            an.setViewTextColor(this.dEL, R.color.cp_cont_h, 1);
        } else {
            an.setViewTextColor(this.dEL, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.kHN) {
                TiebaStatic.log(new ao("c12523").ag("obj_locate", 2));
                if (be.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    bc.aWU().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.kHQ) {
                this.kHQ.dqy();
            }
            TiebaStatic.log(new ao("c12523").ag("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
