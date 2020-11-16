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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.i;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.PersonCenterGuideView;
import java.util.HashMap;
/* loaded from: classes21.dex */
public class h extends com.baidu.tieba.card.b<i> {
    private TextView euO;
    private View jIh;
    private RelativeLayout lXD;
    private PersonHeadPendantView lXE;
    private TbImageView lXF;
    private TextView lXG;
    private ImageView lXH;
    private PersonCenterGuideView lXI;
    private int mSkinType;
    private UserData mUserData;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.lXE = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.jIh = view.findViewById(R.id.person_header_shadow);
        this.lXE.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.lXE.setHasPendantStyle();
        this.lXE.getHeadView().setIsRound(true);
        this.lXE.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.lXE.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lXE.getHeadView().setPlaceHolder(2);
        this.lXD = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.lXF = (TbImageView) view.findViewById(R.id.member_icon);
        this.euO = (TextView) view.findViewById(R.id.person_name);
        this.lXG = (TextView) view.findViewById(R.id.person_desc);
        this.lXH = (ImageView) view.findViewById(R.id.arrow_icon);
        this.lXI = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.lXF.setOnClickListener(this);
        this.lXI.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.lXI.onChangeSkinType();
            ap.setBackgroundColor(getView(), R.color.CAM_X0205);
            ap.setViewTextColor(this.lXG, R.color.CAM_X0107);
            SvgManager.bqB().a(this.lXH, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.lXE.setBorderColor(R.color.CAM_X0402);
            com.baidu.tbadk.core.util.e.a.brb().pQ(2).pR(4369).s(R.color.CAM_X0807, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).bn(this.jIh);
            dtn();
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
            this.lXE.a(this.mUserData);
            this.lXE.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new ar("c13690").dR("uid", this.mUserData.getUserId()).dR("obj_locate", "0"));
                SvgManager.bqB().a(this.lXE.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.lXE.setBigVDimenSize(R.dimen.tbds57);
                this.lXE.jn(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.lXE.setBigVDimenSize(R.dimen.tbds57);
            }
            this.lXE.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.mUserData.getNewGodData() != null && h.this.mUserData.getNewGodData().hasNewGodInvited()) {
                        TiebaStatic.log(new ar("c13690").dR("uid", h.this.mUserData.getUserId()).dR("obj_locate", "1"));
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
            this.euO.setText(this.mUserData.getName_show());
            this.lXG.setText(getContext().getString(R.string.person_center_default_introduce));
            dtn();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dtn() {
        dto();
        dtq();
        dtp();
    }

    private void dto() {
        if (this.mUserData == null) {
            this.lXF.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.lXF.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.lXF.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void dtp() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.euO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bqB().a(i, null), (Drawable) null);
    }

    private void dtq() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ap.setViewTextColor(this.euO, R.color.CAM_X0301, 1);
        } else {
            ap.setViewTextColor(this.euO, R.color.CAM_X0105, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.lXF) {
                TiebaStatic.log(new ar("c12523").ak("obj_locate", 2));
                if (bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    bf.bqF().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.lXI) {
                this.lXI.dSI();
            }
            TiebaStatic.log(new ar("c12523").ak("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
