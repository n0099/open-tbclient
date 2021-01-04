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
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.card.b<i> {
    private TextView eLt;
    private View kiY;
    private int mSkinType;
    private UserData mUserData;
    private RelativeLayout mqW;
    private PersonHeadPendantView mqX;
    private TbImageView mqY;
    private TextView mqZ;
    private ImageView mra;
    private PersonCenterGuideView mrb;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.mqX = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.kiY = view.findViewById(R.id.person_header_shadow);
        this.mqX.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.mqX.setHasPendantStyle();
        this.mqX.getHeadView().setIsRound(true);
        this.mqX.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.mqX.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mqX.getHeadView().setPlaceHolder(2);
        this.mqW = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.mqY = (TbImageView) view.findViewById(R.id.member_icon);
        this.eLt = (TextView) view.findViewById(R.id.person_name);
        this.mqZ = (TextView) view.findViewById(R.id.person_desc);
        this.mra = (ImageView) view.findViewById(R.id.arrow_icon);
        this.mrb = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.mqY.setOnClickListener(this);
        this.mrb.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mrb.onChangeSkinType();
            ao.setBackgroundColor(getView(), R.color.CAM_X0205);
            ao.setViewTextColor(this.mqZ, R.color.CAM_X0107);
            SvgManager.bwq().a(this.mra, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.mqX.setBorderColor(R.color.CAM_X0402);
            com.baidu.tbadk.core.util.f.a.bwT().qB(2).qC(4369).x(R.color.CAM_X0807, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).bz(this.kiY);
            dyv();
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
            this.mqX.a(this.mUserData);
            this.mqX.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new aq("c13690").dX("uid", this.mUserData.getUserId()).dX("obj_locate", "0"));
                SvgManager.bwq().a(this.mqX.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.mqX.setBigVDimenSize(R.dimen.tbds57);
                this.mqX.jZ(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.mqX.setBigVDimenSize(R.dimen.tbds57);
            }
            this.mqX.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.mUserData.getNewGodData() != null && h.this.mUserData.getNewGodData().hasNewGodInvited()) {
                        TiebaStatic.log(new aq("c13690").dX("uid", h.this.mUserData.getUserId()).dX("obj_locate", "1"));
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
            this.eLt.setText(this.mUserData.getName_show());
            this.mqZ.setText(getContext().getString(R.string.person_center_default_introduce));
            dyv();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dyv() {
        dyw();
        dyy();
        dyx();
    }

    private void dyw() {
        if (this.mUserData == null) {
            this.mqY.setImageDrawable(ao.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.mqY.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.mqY.setImageDrawable(ao.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void dyx() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.eLt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bwq().a(i, null), (Drawable) null);
    }

    private void dyy() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ao.setViewTextColor(this.eLt, R.color.CAM_X0301, 1);
        } else {
            ao.setViewTextColor(this.eLt, R.color.CAM_X0105, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.mqY) {
                TiebaStatic.log(new aq("c12523").an("obj_locate", 2));
                if (bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    be.bwu().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.mrb) {
                this.mrb.dXG();
            }
            TiebaStatic.log(new aq("c12523").an("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
