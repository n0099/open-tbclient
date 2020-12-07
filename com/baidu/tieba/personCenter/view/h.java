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
/* loaded from: classes22.dex */
public class h extends com.baidu.tieba.card.b<i> {
    private TextView eBQ;
    private View jVK;
    private int mSkinType;
    private UserData mUserData;
    private RelativeLayout mlL;
    private PersonHeadPendantView mlM;
    private TbImageView mlN;
    private TextView mlO;
    private ImageView mlP;
    private PersonCenterGuideView mlQ;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.mlM = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.jVK = view.findViewById(R.id.person_header_shadow);
        this.mlM.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.mlM.setHasPendantStyle();
        this.mlM.getHeadView().setIsRound(true);
        this.mlM.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.mlM.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mlM.getHeadView().setPlaceHolder(2);
        this.mlL = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.mlN = (TbImageView) view.findViewById(R.id.member_icon);
        this.eBQ = (TextView) view.findViewById(R.id.person_name);
        this.mlO = (TextView) view.findViewById(R.id.person_desc);
        this.mlP = (ImageView) view.findViewById(R.id.arrow_icon);
        this.mlQ = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.mlN.setOnClickListener(this);
        this.mlQ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mlQ.onChangeSkinType();
            ap.setBackgroundColor(getView(), R.color.CAM_X0205);
            ap.setViewTextColor(this.mlO, R.color.CAM_X0107);
            SvgManager.btW().a(this.mlP, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.mlM.setBorderColor(R.color.CAM_X0402);
            com.baidu.tbadk.core.util.e.a.buy().qq(2).qr(4369).w(R.color.CAM_X0807, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).bq(this.jVK);
            dyF();
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
            this.mlM.a(this.mUserData);
            this.mlM.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new ar("c13690").dY("uid", this.mUserData.getUserId()).dY("obj_locate", "0"));
                SvgManager.btW().a(this.mlM.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.mlM.setBigVDimenSize(R.dimen.tbds57);
                this.mlM.jD(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.mlM.setBigVDimenSize(R.dimen.tbds57);
            }
            this.mlM.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.mUserData.getNewGodData() != null && h.this.mUserData.getNewGodData().hasNewGodInvited()) {
                        TiebaStatic.log(new ar("c13690").dY("uid", h.this.mUserData.getUserId()).dY("obj_locate", "1"));
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
            this.eBQ.setText(this.mUserData.getName_show());
            this.mlO.setText(getContext().getString(R.string.person_center_default_introduce));
            dyF();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dyF() {
        dyG();
        dyI();
        dyH();
    }

    private void dyG() {
        if (this.mUserData == null) {
            this.mlN.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.mlN.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.mlN.setImageDrawable(ap.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void dyH() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.eBQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.btW().a(i, null), (Drawable) null);
    }

    private void dyI() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0301, 1);
        } else {
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0105, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.mlN) {
                TiebaStatic.log(new ar("c12523").al("obj_locate", 2));
                if (bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    bf.bua().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.mlQ) {
                this.mlQ.dYc();
            }
            TiebaStatic.log(new ar("c12523").al("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
