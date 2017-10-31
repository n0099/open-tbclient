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
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.view.PersonHeadPendantView;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.f> {
    private TextView aoE;
    protected PersonHeadPendantView fjr;
    private TbImageView fjs;
    private TextView fjt;
    private ImageView fju;
    private FrameLayout fjv;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fjr = (PersonHeadPendantView) view.findViewById(d.g.person_header);
        this.fjr.wg();
        this.fjr.getHeadView().setIsRound(true);
        this.fjr.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(d.e.ds1));
        this.fjr.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fjr.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.fjv = (FrameLayout) view.findViewById(d.g.person_header_container);
        this.fjs = (TbImageView) view.findViewById(d.g.member_icon);
        this.aoE = (TextView) view.findViewById(d.g.person_name);
        this.fjt = (TextView) view.findViewById(d.g.person_desc);
        this.fju = (ImageView) view.findViewById(d.g.arrow_icon);
        view.setOnClickListener(this);
        this.fjs.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0080d.cp_bg_line_d);
            this.fju.setImageDrawable(aj.getDrawable(d.f.icon_mine_list_arrow));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.f fVar) {
        if (fVar != null && fVar.eGm != null) {
            this.mUserData = fVar.eGm;
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dE = o.dE(portrait);
                this.fjr.getHeadView().setUrl(dE);
                this.fjr.getHeadView().startLoad(dE, 25, false);
            } else {
                this.fjr.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            k pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fjr.en(pendantData.pQ());
            }
            if (this.fjr.wf()) {
                this.fjr.getHeadView().setShowV(false);
                this.fjv.setPadding(0, (int) getContext().getResources().getDimension(d.e.ds15), 0, (int) getContext().getResources().getDimension(d.e.ds15));
            } else {
                this.fjv.setPadding(0, 0, 0, 0);
                if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                    this.fjr.getHeadView().setShowV(true);
                } else {
                    this.fjr.getHeadView().setShowV(false);
                }
            }
            if (this.mUserData.getIsMem() > 0) {
                this.fjs.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.fjs.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
            }
            aYs();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aoE.setText(name_show);
            }
            int i = d.f.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_pop_girl : d.f.icon_pop_boy;
            }
            this.aoE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            if (StringUtils.isNull(this.mUserData.getIntro())) {
                this.fjt.setText(getContext().getString(d.j.person_center_introduce, getContext().getString(d.j.person_center_default_introduce)));
            } else {
                this.fjt.setText(getContext().getString(d.j.person_center_introduce, this.mUserData.getIntro()));
            }
            aYt();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aYs() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.c(this.aoE, d.C0080d.cp_cont_h, 1);
        } else {
            aj.c(this.aoE, d.C0080d.cp_cont_b, 1);
        }
    }

    private void aYt() {
        if (StringUtils.isNull(this.mUserData.getIntro())) {
            aj.i(this.fjt, d.C0080d.cp_cont_e);
        } else {
            aj.i(this.fjt, d.C0080d.cp_cont_j);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.fjs) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 2));
                if (ax.aT(this.mTbPageContext.getPageActivity())) {
                    av.vI().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new ak("c12523").r("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
