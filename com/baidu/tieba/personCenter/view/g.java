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
    private View igM;
    private RelativeLayout knP;
    private PersonHeadPendantView knQ;
    private TbImageView knR;
    private TextView knS;
    private ImageView knT;
    private PersonCenterGuideView knU;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.knQ = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.igM = view.findViewById(R.id.person_header_shadow);
        this.knQ.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.knQ.setHasPendantStyle();
        this.knQ.getHeadView().setIsRound(true);
        this.knQ.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.knQ.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.knQ.getHeadView().setPlaceHolder(2);
        this.knP = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.knR = (TbImageView) view.findViewById(R.id.member_icon);
        this.dXU = (TextView) view.findViewById(R.id.person_name);
        this.knS = (TextView) view.findViewById(R.id.person_desc);
        this.knT = (ImageView) view.findViewById(R.id.arrow_icon);
        this.knU = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.knR.setOnClickListener(this);
        this.knU.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.knU.onChangeSkinType();
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            am.setViewTextColor(this.knS, (int) R.color.cp_cont_j);
            SvgManager.aUW().a(this.knT, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.knQ.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.e.a.aVv().ly(2).lz(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aR(this.igM);
            cNJ();
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
            this.knQ.a(this.mUserData);
            this.knQ.a(this.mUserData, 3);
            if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new an("c13690").dh("uid", this.mUserData.getUserId()).dh("obj_locate", "0"));
                SvgManager.aUW().a(this.knQ.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.knQ.setBigVDimenSize(R.dimen.tbds57);
                this.knQ.hj(true);
            } else if (this.mUserData.getNewGodData() != null && this.mUserData.getNewGodData().isNewGod()) {
                this.knQ.setBigVDimenSize(R.dimen.tbds57);
            }
            this.knQ.getBigVIconView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.g.1
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
            this.knS.setText(getContext().getString(R.string.person_center_default_introduce));
            cNJ();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cNJ() {
        cNK();
        cNM();
        cNL();
    }

    private void cNK() {
        if (this.mUserData == null) {
            this.knR.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.knR.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.knR.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void cNL() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.dXU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUW().a(i, null), (Drawable) null);
    }

    private void cNM() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.setViewTextColor(this.dXU, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.dXU, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.knR) {
                TiebaStatic.log(new an("c12523").ag("obj_locate", 2));
                if (bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    ba.aVa().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.knU) {
                this.knU.dml();
            }
            TiebaStatic.log(new an("c12523").ag("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
