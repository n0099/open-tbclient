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
    private TextView aou;
    protected PersonHeadPendantView fbp;
    private TbImageView fbq;
    private TextView fbr;
    private ImageView fbs;
    private FrameLayout fbt;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fbp = (PersonHeadPendantView) view.findViewById(d.h.person_header);
        this.fbp.wg();
        this.fbp.getHeadView().setIsRound(true);
        this.fbp.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(d.f.ds1));
        this.fbp.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fbp.getHeadView().setCustomBigViewIconId(d.g.pic_v_avatar_big);
        this.fbt = (FrameLayout) view.findViewById(d.h.person_header_container);
        this.fbq = (TbImageView) view.findViewById(d.h.member_icon);
        this.aou = (TextView) view.findViewById(d.h.person_name);
        this.fbr = (TextView) view.findViewById(d.h.person_desc);
        this.fbs = (ImageView) view.findViewById(d.h.arrow_icon);
        view.setOnClickListener(this);
        this.fbq.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.e.cp_bg_line_d);
            this.fbs.setImageDrawable(aj.getDrawable(d.g.icon_mine_list_arrow));
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
        if (fVar != null && fVar.eyy != null) {
            this.mUserData = fVar.eyy;
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dz = o.dz(portrait);
                this.fbp.getHeadView().setUrl(dz);
                this.fbp.getHeadView().c(dz, 25, false);
            } else {
                this.fbp.getHeadView().c(String.valueOf(d.g.pic_mycenter_avatar_def_i), 24, false);
            }
            i pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fbp.ei(pendantData.pS());
            }
            if (this.fbp.wf()) {
                this.fbp.getHeadView().setShowV(false);
                this.fbt.setPadding(0, (int) getContext().getResources().getDimension(d.f.ds15), 0, (int) getContext().getResources().getDimension(d.f.ds15));
            } else {
                this.fbt.setPadding(0, 0, 0, 0);
                if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                    this.fbp.getHeadView().setShowV(true);
                } else {
                    this.fbp.getHeadView().setShowV(false);
                }
            }
            if (this.mUserData.getIsMem() > 0) {
                this.fbq.c(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.fbq.setImageDrawable(aj.getDrawable(d.g.icon_crown_super_non));
            }
            aVw();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aou.setText(name_show);
            }
            int i = d.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.g.icon_pop_girl : d.g.icon_pop_boy;
            }
            this.aou.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            if (StringUtils.isNull(this.mUserData.getIntro())) {
                this.fbr.setText(getContext().getString(d.l.person_center_introduce, getContext().getString(d.l.person_center_default_introduce)));
            } else {
                this.fbr.setText(getContext().getString(d.l.person_center_introduce, this.mUserData.getIntro()));
            }
            aVx();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aVw() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.c(this.aou, d.e.cp_cont_h, 1);
        } else {
            aj.c(this.aou, d.e.cp_cont_b, 1);
        }
    }

    private void aVx() {
        if (StringUtils.isNull(this.mUserData.getIntro())) {
            aj.i(this.fbr, d.e.cp_cont_e);
        } else {
            aj.i(this.fbr, d.e.cp_cont_j);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.fbq) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 2));
                if (ax.aU(this.mTbPageContext.getPageActivity())) {
                    av.vH().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new ak("c12523").r("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
