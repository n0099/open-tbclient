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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.data.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.a<f> {
    private TextView bfg;
    protected HeadPendantView gko;
    private TbImageView gkp;
    private TextView gkq;
    private ImageView gkr;
    private FrameLayout gks;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gko = (HeadPendantView) view.findViewById(d.g.person_header);
        this.gko.DT();
        this.gko.getHeadView().setIsRound(true);
        this.gko.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(d.e.ds1));
        this.gko.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gko.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.gko.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.gks = (FrameLayout) view.findViewById(d.g.person_header_container);
        this.gkp = (TbImageView) view.findViewById(d.g.member_icon);
        this.bfg = (TextView) view.findViewById(d.g.person_name);
        this.gkq = (TextView) view.findViewById(d.g.person_desc);
        this.gkr = (ImageView) view.findViewById(d.g.arrow_icon);
        view.setOnClickListener(this);
        this.gkp.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0140d.cp_bg_line_d);
            this.gkr.setImageDrawable(aj.getDrawable(d.f.icon_mine_list_arrow));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.fHl != null) {
            this.mUserData = fVar.fHl;
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String ec = o.ec(portrait);
                this.gko.getHeadView().setUrl(ec);
                this.gko.getHeadView().startLoad(ec, 25, false);
            } else {
                this.gko.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            h pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gko.eS(pendantData.ya());
            }
            if (this.gko.DS()) {
                this.gko.getHeadView().setShowV(false);
                this.gks.setPadding(0, 0, 0, 0);
            } else {
                this.gks.setPadding(0, 0, 0, 0);
                if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                    this.gko.getHeadView().setShowV(true);
                } else {
                    this.gko.getHeadView().setShowV(false);
                }
            }
            if (this.mUserData.getIsMem() > 0) {
                this.gkp.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.gkp.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
            }
            biO();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.bfg.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.bfg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gkq.setText(getContext().getString(d.j.person_center_default_introduce));
            biP();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void biO() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.e(this.bfg, d.C0140d.cp_cont_h, 1);
        } else {
            aj.e(this.bfg, d.C0140d.cp_cont_b, 1);
        }
    }

    private void biP() {
        aj.r(this.gkq, d.C0140d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.gkp) {
                TiebaStatic.log(new ak("c12523").s("obj_locate", 2));
                if (ay.ba(this.mTbPageContext.getPageActivity())) {
                    aw.Du().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new ak("c12523").s("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
