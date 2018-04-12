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
    protected HeadPendantView fEQ;
    private TbImageView fER;
    private TextView fES;
    private ImageView fET;
    private FrameLayout fEU;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view2 = getView();
        this.fEQ = (HeadPendantView) view2.findViewById(d.g.person_header);
        this.fEQ.setHasPendantStyle();
        this.fEQ.getHeadView().setIsRound(true);
        this.fEQ.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(d.e.ds1));
        this.fEQ.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fEQ.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.fEQ.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.fEU = (FrameLayout) view2.findViewById(d.g.person_header_container);
        this.fER = (TbImageView) view2.findViewById(d.g.member_icon);
        this.aqm = (TextView) view2.findViewById(d.g.person_name);
        this.fES = (TextView) view2.findViewById(d.g.person_desc);
        this.fET = (ImageView) view2.findViewById(d.g.arrow_icon);
        view2.setOnClickListener(this);
        this.fER.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.j(getView(), d.C0126d.cp_bg_line_d);
            this.fET.setImageDrawable(ak.getDrawable(d.f.icon_mine_list_arrow));
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
        if (fVar != null && fVar.fbV != null) {
            this.mUserData = fVar.fbV;
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dU = o.dU(portrait);
                this.fEQ.getHeadView().setUrl(dU);
                if (dU.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.fEQ.getHeadView().startLoad(dU, 10, false);
                } else {
                    this.fEQ.getHeadView().startLoad(dU, 25, false);
                }
            } else {
                this.fEQ.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            h pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fEQ.eK(pendantData.qG());
            }
            if (this.fEQ.wE()) {
                this.fEQ.getHeadView().setShowV(false);
                this.fEU.setPadding(0, 0, 0, 0);
            } else {
                this.fEU.setPadding(0, 0, 0, 0);
                if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                    this.fEQ.getHeadView().setShowV(true);
                } else {
                    this.fEQ.getHeadView().setShowV(false);
                }
            }
            if (this.mUserData.getIsMem() > 0) {
                this.fER.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.fER.setImageDrawable(ak.getDrawable(d.f.icon_crown_super_non));
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
            this.fES.setText(getContext().getString(d.k.person_center_default_introduce));
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
        ak.h(this.fES, d.C0126d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            if (view2 == this.fER) {
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
