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
/* loaded from: classes22.dex */
public class h extends com.baidu.tieba.card.b<i> {
    private TextView eig;
    private View joZ;
    private RelativeLayout lET;
    private PersonHeadPendantView lEU;
    private TbImageView lEV;
    private TextView lEW;
    private ImageView lEX;
    private PersonCenterGuideView lEY;
    private int mSkinType;
    private UserData mUserData;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.lEU = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.joZ = view.findViewById(R.id.person_header_shadow);
        this.lEU.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.lEU.setHasPendantStyle();
        this.lEU.getHeadView().setIsRound(true);
        this.lEU.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.lEU.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lEU.getHeadView().setPlaceHolder(2);
        this.lET = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.lEV = (TbImageView) view.findViewById(R.id.member_icon);
        this.eig = (TextView) view.findViewById(R.id.person_name);
        this.lEW = (TextView) view.findViewById(R.id.person_desc);
        this.lEX = (ImageView) view.findViewById(R.id.arrow_icon);
        this.lEY = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.lEV.setOnClickListener(this);
        this.lEY.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.lEY.onChangeSkinType();
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            ap.setViewTextColor(this.lEW, R.color.cp_cont_j);
            SvgManager.bmU().a(this.lEX, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.lEU.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.e.a.bnu().oX(2).oY(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).bf(this.joZ);
            doe();
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
            this.lEU.a(this.mUserData);
            this.lEU.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new aq("c13690").dK("uid", this.mUserData.getUserId()).dK("obj_locate", "0"));
                SvgManager.bmU().a(this.lEU.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.lEU.setBigVDimenSize(R.dimen.tbds57);
                this.lEU.iQ(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.lEU.setBigVDimenSize(R.dimen.tbds57);
            }
            this.lEU.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.mUserData.getNewGodData() != null && h.this.mUserData.getNewGodData().hasNewGodInvited()) {
                        TiebaStatic.log(new aq("c13690").dK("uid", h.this.mUserData.getUserId()).dK("obj_locate", "1"));
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
            this.eig.setText(this.mUserData.getName_show());
            this.lEW.setText(getContext().getString(R.string.person_center_default_introduce));
            doe();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void doe() {
        dof();
        doh();
        dog();
    }

    private void dof() {
        if (this.mUserData == null) {
            this.lEV.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.lEV.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.lEV.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void dog() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.eig.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bmU().a(i, null), (Drawable) null);
    }

    private void doh() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ap.setViewTextColor(this.eig, R.color.cp_cont_h, 1);
        } else {
            ap.setViewTextColor(this.eig, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.lEV) {
                TiebaStatic.log(new aq("c12523").aj("obj_locate", 2));
                if (bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    be.bmY().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.lEY) {
                this.lEY.dMZ();
            }
            TiebaStatic.log(new aq("c12523").aj("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
