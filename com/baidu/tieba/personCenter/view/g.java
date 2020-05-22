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
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.PersonCenterGuideView;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.b<h> {
    private TextView dXU;
    private View ifZ;
    private RelativeLayout kmJ;
    private PersonHeadPendantView kmK;
    private TbImageView kmL;
    private TextView kmM;
    private ImageView kmN;
    private PersonCenterGuideView kmO;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.kmK = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.ifZ = view.findViewById(R.id.person_header_shadow);
        this.kmK.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.kmK.setHasPendantStyle();
        this.kmK.getHeadView().setIsRound(true);
        this.kmK.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.kmK.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kmK.getHeadView().setPlaceHolder(2);
        this.kmJ = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.kmL = (TbImageView) view.findViewById(R.id.member_icon);
        this.dXU = (TextView) view.findViewById(R.id.person_name);
        this.kmM = (TextView) view.findViewById(R.id.person_desc);
        this.kmN = (ImageView) view.findViewById(R.id.arrow_icon);
        this.kmO = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.kmL.setOnClickListener(this);
        this.kmO.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.kmO.onChangeSkinType();
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            am.setViewTextColor(this.kmM, (int) R.color.cp_cont_j);
            SvgManager.aUV().a(this.kmN, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.kmK.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.e.a.aVu().lw(2).lx(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aR(this.ifZ);
            cNt();
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(h hVar) {
        if (hVar != null && hVar.userData != null) {
            this.mUserData = hVar.userData;
            this.kmK.a(this.mUserData);
            this.kmK.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new an("c13690").dh("uid", this.mUserData.getUserId()).dh("obj_locate", "0"));
                SvgManager.aUV().a(this.kmK.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.kmK.setBigVDimenSize(R.dimen.tbds57);
                this.kmK.hj(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.kmK.setBigVDimenSize(R.dimen.tbds57);
            }
            this.kmK.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.mUserData.getNewGodData() != null && g.this.mUserData.getNewGodData().hasNewGodInvited()) {
                        TiebaStatic.log(new an("c13690").dh("uid", g.this.mUserData.getUserId()).dh("obj_locate", "1"));
                        HashMap hashMap = new HashMap();
                        hashMap.put("from", "6");
                        hashMap.put("field_id", g.this.mUserData.getNewGodData().getFieldId());
                        hashMap.put("animated", false);
                        hashMap.put("transparent", true);
                        hashMap.put("swipeback", false);
                        hashMap.put("present", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(g.this.mTbPageContext.getPageActivity(), "GodDialog", hashMap)));
                    }
                }
            });
            this.dXU.setText(this.mUserData.getName_show());
            this.kmM.setText(getContext().getString(R.string.person_center_default_introduce));
            cNt();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cNt() {
        cNu();
        cNw();
        cNv();
    }

    private void cNu() {
        if (this.mUserData == null) {
            this.kmL.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.kmL.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.kmL.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void cNv() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.dXU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUV().a(i, null), (Drawable) null);
    }

    private void cNw() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.setViewTextColor(this.dXU, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.dXU, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.kmL) {
                TiebaStatic.log(new an("c12523").ag("obj_locate", 2));
                if (bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    ba.aUZ().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.kmO) {
                this.kmO.dlW();
            }
            TiebaStatic.log(new an("c12523").ag("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
