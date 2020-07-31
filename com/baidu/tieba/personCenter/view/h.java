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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.i;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.PersonCenterGuideView;
import java.util.HashMap;
/* loaded from: classes16.dex */
public class h extends com.baidu.tieba.card.b<i> {
    private TextView dKI;
    private View iCo;
    private RelativeLayout kQM;
    private PersonHeadPendantView kQN;
    private TbImageView kQO;
    private TextView kQP;
    private ImageView kQQ;
    private PersonCenterGuideView kQR;
    private int mSkinType;
    private UserData mUserData;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.kQN = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.iCo = view.findViewById(R.id.person_header_shadow);
        this.kQN.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.kQN.setHasPendantStyle();
        this.kQN.getHeadView().setIsRound(true);
        this.kQN.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.kQN.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kQN.getHeadView().setPlaceHolder(2);
        this.kQM = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.kQO = (TbImageView) view.findViewById(R.id.member_icon);
        this.dKI = (TextView) view.findViewById(R.id.person_name);
        this.kQP = (TextView) view.findViewById(R.id.person_desc);
        this.kQQ = (ImageView) view.findViewById(R.id.arrow_icon);
        this.kQR = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.kQO.setOnClickListener(this);
        this.kQR.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.kQR.onChangeSkinType();
            ao.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            ao.setViewTextColor(this.kQP, R.color.cp_cont_j);
            SvgManager.baR().a(this.kQQ, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.kQN.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.e.a.bbq().mj(2).mk(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aX(this.iCo);
            cVR();
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
            this.kQN.a(this.mUserData);
            this.kQN.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new ap("c13690").dn("uid", this.mUserData.getUserId()).dn("obj_locate", "0"));
                SvgManager.baR().a(this.kQN.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.kQN.setBigVDimenSize(R.dimen.tbds57);
                this.kQN.hX(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.kQN.setBigVDimenSize(R.dimen.tbds57);
            }
            this.kQN.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.mUserData.getNewGodData() != null && h.this.mUserData.getNewGodData().hasNewGodInvited()) {
                        TiebaStatic.log(new ap("c13690").dn("uid", h.this.mUserData.getUserId()).dn("obj_locate", "1"));
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
            this.dKI.setText(this.mUserData.getName_show());
            this.kQP.setText(getContext().getString(R.string.person_center_default_introduce));
            cVR();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cVR() {
        cVS();
        cVU();
        cVT();
    }

    private void cVS() {
        if (this.mUserData == null) {
            this.kQO.setImageDrawable(ao.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.kQO.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.kQO.setImageDrawable(ao.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void cVT() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.dKI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.baR().a(i, null), (Drawable) null);
    }

    private void cVU() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ao.setViewTextColor(this.dKI, R.color.cp_cont_h, 1);
        } else {
            ao.setViewTextColor(this.dKI, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.kQO) {
                TiebaStatic.log(new ap("c12523").ah("obj_locate", 2));
                if (bf.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    bd.baV().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.kQR) {
                this.kQR.dtO();
            }
            TiebaStatic.log(new ap("c12523").ah("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
