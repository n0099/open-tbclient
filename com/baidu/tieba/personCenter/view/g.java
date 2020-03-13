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
import com.baidu.tieba.view.PersonCenterGuideView;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.a<h> {
    private TextView cbL;
    private ImageView gRt;
    private View hfZ;
    private RelativeLayout jja;
    private PersonHeadPendantView jjb;
    private TbImageView jjc;
    private TextView jjd;
    private PersonCenterGuideView jje;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jjb = (PersonHeadPendantView) view.findViewById(R.id.person_header);
        this.hfZ = view.findViewById(R.id.person_header_shadow);
        this.jjb.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds8));
        this.jjb.setHasPendantStyle();
        this.jjb.getHeadView().setIsRound(true);
        this.jjb.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.jjb.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jjb.getHeadView().setPlaceHolder(2);
        this.jja = (RelativeLayout) view.findViewById(R.id.person_header_container);
        this.jjc = (TbImageView) view.findViewById(R.id.member_icon);
        this.cbL = (TextView) view.findViewById(R.id.person_name);
        this.jjd = (TextView) view.findViewById(R.id.person_desc);
        this.gRt = (ImageView) view.findViewById(R.id.arrow_icon);
        this.jje = (PersonCenterGuideView) view.findViewById(R.id.person_center_guide_view);
        view.setOnClickListener(this);
        this.jjc.setOnClickListener(this);
        this.jje.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.jje.onChangeSkinType();
            am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
            am.setViewTextColor(this.jjd, (int) R.color.cp_cont_j);
            SvgManager.aGC().a(this.gRt, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            this.jjb.setBorderColor(R.color.cp_border_b);
            com.baidu.tbadk.core.util.e.a.aHa().kK(2).kL(4369).a(R.color.cp_shadow_a, 0.4f, 0, 0, l.getDimens(getContext(), R.dimen.tbds12)).aQ(this.hfZ);
            cvt();
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(h hVar) {
        if (hVar != null && hVar.userData != null) {
            this.mUserData = hVar.userData;
            this.jjb.a(this.mUserData);
            this.jjb.a(this.mUserData, 3);
            this.cbL.setText(this.mUserData.getName_show());
            this.jjd.setText(getContext().getString(R.string.person_center_default_introduce));
            cvt();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cvt() {
        cvu();
        cvw();
        cvv();
    }

    private void cvu() {
        if (this.mUserData == null) {
            this.jjc.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
            return;
        }
        UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
        if (this.mUserData.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.jjc.startLoad(userVipInfo.getVipIconUrl(), 10, false);
        } else {
            this.jjc.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
    }

    private void cvv() {
        int i = R.drawable.icon_mask_boy16_svg;
        if (this.mUserData != null && this.mUserData.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        this.cbL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(i, null), (Drawable) null);
    }

    private void cvw() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.setViewTextColor(this.cbL, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.cbL, R.color.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jjc) {
                TiebaStatic.log(new an("c12523").X("obj_locate", 2));
                if (bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                    ba.aGG().b(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            if (view == this.jje) {
                this.jje.cTz();
            }
            TiebaStatic.log(new an("c12523").X("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
