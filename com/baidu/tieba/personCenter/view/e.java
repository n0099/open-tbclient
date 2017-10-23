package com.baidu.tieba.personCenter.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.view.PersonHeadPendantView;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.c.f> {
    private TextView aoi;
    protected PersonHeadPendantView fba;
    private TbImageView fbb;
    private TextView fbc;
    private ImageView fbd;
    private FrameLayout fbe;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fba = (PersonHeadPendantView) view.findViewById(d.h.person_header);
        this.fba.vZ();
        this.fba.getHeadView().setIsRound(true);
        this.fba.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(d.f.ds1));
        this.fba.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fba.getHeadView().setCustomBigViewIconId(d.g.pic_v_avatar_big);
        this.fbe = (FrameLayout) view.findViewById(d.h.person_header_container);
        this.fbb = (TbImageView) view.findViewById(d.h.member_icon);
        this.aoi = (TextView) view.findViewById(d.h.person_name);
        this.fbc = (TextView) view.findViewById(d.h.person_desc);
        this.fbd = (ImageView) view.findViewById(d.h.arrow_icon);
        view.setOnClickListener(this);
        this.fbb.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.e.cp_bg_line_d);
            this.fbd.setImageDrawable(aj.getDrawable(d.g.icon_mine_list_arrow));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null && fVar.eyj != null) {
            this.mUserData = fVar.eyj;
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dy = o.dy(portrait);
                this.fba.getHeadView().setUrl(dy);
                this.fba.getHeadView().c(dy, 25, false);
            } else {
                this.fba.getHeadView().c(String.valueOf(d.g.pic_mycenter_avatar_def_i), 24, false);
            }
            i pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fba.eh(pendantData.pL());
            }
            if (this.fba.vY()) {
                this.fba.getHeadView().setShowV(false);
                this.fbe.setPadding(0, (int) getContext().getResources().getDimension(d.f.ds15), 0, (int) getContext().getResources().getDimension(d.f.ds15));
            } else {
                this.fbe.setPadding(0, 0, 0, 0);
                if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                    this.fba.getHeadView().setShowV(true);
                } else {
                    this.fba.getHeadView().setShowV(false);
                }
            }
            if (this.mUserData.getIsMem() > 0) {
                this.fbb.c(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.fbb.setImageDrawable(aj.getDrawable(d.g.icon_crown_super_non));
            }
            aVq();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aoi.setText(name_show);
            }
            int i = d.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.g.icon_pop_girl : d.g.icon_pop_boy;
            }
            this.aoi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            if (StringUtils.isNull(this.mUserData.getIntro())) {
                this.fbc.setText(getContext().getString(d.l.person_center_introduce, getContext().getString(d.l.person_center_default_introduce)));
            } else {
                this.fbc.setText(getContext().getString(d.l.person_center_introduce, this.mUserData.getIntro()));
            }
            aVr();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aVq() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.c(this.aoi, d.e.cp_cont_h, 1);
        } else {
            aj.c(this.aoi, d.e.cp_cont_b, 1);
        }
    }

    private void aVr() {
        if (StringUtils.isNull(this.mUserData.getIntro())) {
            aj.i(this.fbc, d.e.cp_cont_e);
        } else {
            aj.i(this.fbc, d.e.cp_cont_j);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.fbb) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 2));
                if (ax.aT(this.mTbPageContext.getPageActivity())) {
                    av.vA().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new ak("c12523").r("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
