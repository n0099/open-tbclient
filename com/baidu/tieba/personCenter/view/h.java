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
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.card.b<i> {
    private TextView eKp;
    private View koQ;
    private int mSkinType;
    private UserData mUserData;
    private RelativeLayout mxI;
    private PersonHeadPendantView mxJ;
    private TbImageView mxK;
    private TextView mxL;
    private ImageView mxM;
    private PersonCenterGuideView mxN;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.mxJ = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.koQ = view.findViewById(R.id.person_header_shadow);
        this.mxJ.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.mxJ.setHasPendantStyle();
        this.mxJ.getHeadView().setIsRound(true);
        this.mxJ.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.mxJ.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mxJ.getHeadView().setPlaceHolder(2);
        this.mxI = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.mxK = (TbImageView) view.findViewById(R.id.member_icon);
        this.eKp = (TextView) view.findViewById(R.id.person_name);
        this.mxL = (TextView) view.findViewById(R.id.person_desc);
        this.mxM = (ImageView) view.findViewById(R.id.arrow_icon);
        this.mxN = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.mxK.setOnClickListener(this);
        this.mxN.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mxN.onChangeSkinType();
            ap.setBackgroundColor(getView(), R.color.CAM_X0205);
            ap.setViewTextColor(this.mxL, R.color.CAM_X0107);
            SvgManager.bsU().a(this.mxM, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.mxJ.setBorderColor(R.color.CAM_X0402);
            com.baidu.tbadk.core.util.f.a.btx().pa(2).pb(4369).x(R.color.CAM_X0807, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).bv(this.koQ);
            dxd();
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
            this.mxJ.a(this.mUserData);
            this.mxJ.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new ar("c13690").dR("uid", this.mUserData.getUserId()).dR("obj_locate", "0"));
                SvgManager.bsU().a(this.mxJ.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.mxJ.setBigVDimenSize(R.dimen.tbds57);
                this.mxJ.jY(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.mxJ.setBigVDimenSize(R.dimen.tbds57);
            }
            this.mxJ.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.h.1
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
            this.eKp.setText(this.mUserData.getName_show());
            this.mxL.setText(getContext().getString(R.string.person_center_default_introduce));
            dxd();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dxd() {
        dxe();
        dxg();
        dxf();
    }

    private void dxe() {
        if (this.mUserData == null) {
            this.mxK.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.mxK.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.mxK.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void dxf() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.eKp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bsU().a(i, null), (Drawable) null);
    }

    private void dxg() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ap.setViewTextColor(this.eKp, R.color.CAM_X0301, 1);
        } else {
            ap.setViewTextColor(this.eKp, R.color.CAM_X0105, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.mxK) {
                TiebaStatic.log(new ar("c12523").aq("obj_locate", 2));
                if (bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    bf.bsY().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.mxN) {
                this.mxN.dWt();
            }
            TiebaStatic.log(new ar("c12523").aq("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
