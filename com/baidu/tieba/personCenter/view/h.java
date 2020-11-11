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
    private TextView ewx;
    private View jHw;
    private RelativeLayout lXl;
    private PersonHeadPendantView lXm;
    private TbImageView lXn;
    private TextView lXo;
    private ImageView lXp;
    private PersonCenterGuideView lXq;
    private int mSkinType;
    private UserData mUserData;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.lXm = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.jHw = view.findViewById(R.id.person_header_shadow);
        this.lXm.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.lXm.setHasPendantStyle();
        this.lXm.getHeadView().setIsRound(true);
        this.lXm.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.lXm.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lXm.getHeadView().setPlaceHolder(2);
        this.lXl = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.lXn = (TbImageView) view.findViewById(R.id.member_icon);
        this.ewx = (TextView) view.findViewById(R.id.person_name);
        this.lXo = (TextView) view.findViewById(R.id.person_desc);
        this.lXp = (ImageView) view.findViewById(R.id.arrow_icon);
        this.lXq = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.lXn.setOnClickListener(this);
        this.lXq.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.lXq.onChangeSkinType();
            ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            ap.setViewTextColor(this.lXo, R.color.cp_cont_j);
            SvgManager.brn().a(this.lXp, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.lXm.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.e.a.brN().pt(2).pu(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).bk(this.jHw);
            dtN();
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
            this.lXm.a(this.mUserData);
            this.lXm.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new aq("c13690").dR("uid", this.mUserData.getUserId()).dR("obj_locate", "0"));
                SvgManager.brn().a(this.lXm.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.lXm.setBigVDimenSize(R.dimen.tbds57);
                this.lXm.jm(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.lXm.setBigVDimenSize(R.dimen.tbds57);
            }
            this.lXm.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.mUserData.getNewGodData() != null && h.this.mUserData.getNewGodData().hasNewGodInvited()) {
                        TiebaStatic.log(new aq("c13690").dR("uid", h.this.mUserData.getUserId()).dR("obj_locate", "1"));
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
            this.ewx.setText(this.mUserData.getName_show());
            this.lXo.setText(getContext().getString(R.string.person_center_default_introduce));
            dtN();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dtN() {
        dtO();
        dtQ();
        dtP();
    }

    private void dtO() {
        if (this.mUserData == null) {
            this.lXn.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.lXn.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.lXn.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void dtP() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.ewx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.brn().a(i, null), (Drawable) null);
    }

    private void dtQ() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ap.setViewTextColor(this.ewx, R.color.cp_cont_h, 1);
        } else {
            ap.setViewTextColor(this.ewx, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.lXn) {
                TiebaStatic.log(new aq("c12523").al("obj_locate", 2));
                if (bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    be.brr().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.lXq) {
                this.lXq.dSJ();
            }
            TiebaStatic.log(new aq("c12523").al("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
