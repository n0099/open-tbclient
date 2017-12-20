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
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.e> {
    private TextView aoX;
    protected HeadPendantView ftG;
    private TbImageView ftH;
    private TextView ftI;
    private ImageView ftJ;
    private FrameLayout ftK;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ftG = (HeadPendantView) view.findViewById(d.g.person_header);
        this.ftG.wi();
        this.ftG.getHeadView().setIsRound(true);
        this.ftG.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(d.e.ds1));
        this.ftG.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ftG.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.ftG.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.ftK = (FrameLayout) view.findViewById(d.g.person_header_container);
        this.ftH = (TbImageView) view.findViewById(d.g.member_icon);
        this.aoX = (TextView) view.findViewById(d.g.person_name);
        this.ftI = (TextView) view.findViewById(d.g.person_desc);
        this.ftJ = (ImageView) view.findViewById(d.g.arrow_icon);
        view.setOnClickListener(this);
        this.ftH.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0096d.cp_bg_line_d);
            this.ftJ.setImageDrawable(aj.getDrawable(d.f.icon_mine_list_arrow));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.e eVar) {
        if (eVar != null && eVar.ePs != null) {
            this.mUserData = eVar.ePs;
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dE = o.dE(portrait);
                this.ftG.getHeadView().setUrl(dE);
                this.ftG.getHeadView().startLoad(dE, 25, false);
            } else {
                this.ftG.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            k pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.ftG.es(pendantData.pR());
            }
            if (this.ftG.wh()) {
                this.ftG.getHeadView().setShowV(false);
                this.ftK.setPadding(0, (int) getContext().getResources().getDimension(d.e.ds15), 0, (int) getContext().getResources().getDimension(d.e.ds15));
            } else {
                this.ftK.setPadding(0, 0, 0, 0);
                if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                    this.ftG.getHeadView().setShowV(true);
                } else {
                    this.ftG.getHeadView().setShowV(false);
                }
            }
            if (this.mUserData.getIsMem() > 0) {
                this.ftH.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.ftH.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
            }
            bak();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aoX.setText(name_show);
            }
            int i = d.f.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_pop_girl : d.f.icon_pop_boy;
            }
            this.aoX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.ftI.setText(getContext().getString(d.j.person_center_default_introduce));
            bal();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bak() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.c(this.aoX, d.C0096d.cp_cont_h, 1);
        } else {
            aj.c(this.aoX, d.C0096d.cp_cont_b, 1);
        }
    }

    private void bal() {
        aj.i(this.ftI, d.C0096d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.ftH) {
                TiebaStatic.log(new ak("c12523").r("obj_locate", 2));
                if (ax.aS(this.mTbPageContext.getPageActivity())) {
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
