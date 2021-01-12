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
    private TextView eGI;
    private View ker;
    private int mSkinType;
    private UserData mUserData;
    private RelativeLayout mmq;
    private PersonHeadPendantView mmr;
    private TbImageView mms;
    private TextView mmt;
    private ImageView mmu;
    private PersonCenterGuideView mmv;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.mmr = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.ker = view.findViewById(R.id.person_header_shadow);
        this.mmr.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.mmr.setHasPendantStyle();
        this.mmr.getHeadView().setIsRound(true);
        this.mmr.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.mmr.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mmr.getHeadView().setPlaceHolder(2);
        this.mmq = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.mms = (TbImageView) view.findViewById(R.id.member_icon);
        this.eGI = (TextView) view.findViewById(R.id.person_name);
        this.mmt = (TextView) view.findViewById(R.id.person_desc);
        this.mmu = (ImageView) view.findViewById(R.id.arrow_icon);
        this.mmv = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.mms.setOnClickListener(this);
        this.mmv.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mmv.onChangeSkinType();
            ao.setBackgroundColor(getView(), R.color.CAM_X0205);
            ao.setViewTextColor(this.mmt, R.color.CAM_X0107);
            SvgManager.bsx().a(this.mmu, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.mmr.setBorderColor(R.color.CAM_X0402);
            com.baidu.tbadk.core.util.f.a.bta().oU(2).oV(4369).x(R.color.CAM_X0807, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).bz(this.ker);
            duE();
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
            this.mmr.a(this.mUserData);
            this.mmr.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new aq("c13690").dW("uid", this.mUserData.getUserId()).dW("obj_locate", "0"));
                SvgManager.bsx().a(this.mmr.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.mmr.setBigVDimenSize(R.dimen.tbds57);
                this.mmr.jV(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.mmr.setBigVDimenSize(R.dimen.tbds57);
            }
            this.mmr.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.mUserData.getNewGodData() != null && h.this.mUserData.getNewGodData().hasNewGodInvited()) {
                        TiebaStatic.log(new aq("c13690").dW("uid", h.this.mUserData.getUserId()).dW("obj_locate", "1"));
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
            this.eGI.setText(this.mUserData.getName_show());
            this.mmt.setText(getContext().getString(R.string.person_center_default_introduce));
            duE();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void duE() {
        duF();
        duH();
        duG();
    }

    private void duF() {
        if (this.mUserData == null) {
            this.mms.setImageDrawable(ao.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.mms.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.mms.setImageDrawable(ao.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void duG() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.eGI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsx().a(i, null), (Drawable) null);
    }

    private void duH() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ao.setViewTextColor(this.eGI, R.color.CAM_X0301, 1);
        } else {
            ao.setViewTextColor(this.eGI, R.color.CAM_X0105, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.mms) {
                TiebaStatic.log(new aq("c12523").an("obj_locate", 2));
                if (bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    be.bsB().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.mmv) {
                this.mmv.dTP();
            }
            TiebaStatic.log(new aq("c12523").an("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
