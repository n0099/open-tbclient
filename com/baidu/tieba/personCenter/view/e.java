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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.data.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.f;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<f> {
    private TextView aqm;
    protected HeadPendantView fEN;
    private TbImageView fEO;
    private TextView fEP;
    private ImageView fEQ;
    private FrameLayout fER;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view2 = getView();
        this.fEN = (HeadPendantView) view2.findViewById(d.g.person_header);
        this.fEN.setHasPendantStyle();
        this.fEN.getHeadView().setIsRound(true);
        this.fEN.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(d.e.ds1));
        this.fEN.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fEN.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.fEN.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.fER = (FrameLayout) view2.findViewById(d.g.person_header_container);
        this.fEO = (TbImageView) view2.findViewById(d.g.member_icon);
        this.aqm = (TextView) view2.findViewById(d.g.person_name);
        this.fEP = (TextView) view2.findViewById(d.g.person_desc);
        this.fEQ = (ImageView) view2.findViewById(d.g.arrow_icon);
        view2.setOnClickListener(this);
        this.fEO.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.j(getView(), d.C0126d.cp_bg_line_d);
            this.fEQ.setImageDrawable(ak.getDrawable(d.f.icon_mine_list_arrow));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.fbS != null) {
            this.mUserData = fVar.fbS;
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dU = o.dU(portrait);
                this.fEN.getHeadView().setUrl(dU);
                if (dU.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.fEN.getHeadView().startLoad(dU, 10, false);
                } else {
                    this.fEN.getHeadView().startLoad(dU, 25, false);
                }
            } else {
                this.fEN.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            h pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fEN.eK(pendantData.qG());
            }
            if (this.fEN.wE()) {
                this.fEN.getHeadView().setShowV(false);
                this.fER.setPadding(0, 0, 0, 0);
            } else {
                this.fER.setPadding(0, 0, 0, 0);
                if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                    this.fEN.getHeadView().setShowV(true);
                } else {
                    this.fEN.getHeadView().setShowV(false);
                }
            }
            if (this.mUserData.getIsMem() > 0) {
                this.fEO.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.fEO.setImageDrawable(ak.getDrawable(d.f.icon_crown_super_non));
            }
            bdP();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aqm.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.aqm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fEP.setText(getContext().getString(d.k.person_center_default_introduce));
            bdQ();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bdP() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ak.c(this.aqm, d.C0126d.cp_cont_h, 1);
        } else {
            ak.c(this.aqm, d.C0126d.cp_cont_b, 1);
        }
    }

    private void bdQ() {
        ak.h(this.fEP, d.C0126d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            if (view2 == this.fEO) {
                TiebaStatic.log(new al("c12523").r("obj_locate", 2));
                if (az.aK(this.mTbPageContext.getPageActivity())) {
                    ax.wg().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new al("c12523").r("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
