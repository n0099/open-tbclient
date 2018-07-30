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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.f;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<f> {
    private TextView ayY;
    protected HeadPendantView fVB;
    private TbImageView fVC;
    private TextView fVD;
    private ImageView fVE;
    private FrameLayout fVF;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fVB = (HeadPendantView) view.findViewById(d.g.person_header);
        this.fVB.setHasPendantStyle();
        this.fVB.getHeadView().setIsRound(true);
        this.fVB.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(d.e.ds1));
        this.fVB.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fVB.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.fVB.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.fVF = (FrameLayout) view.findViewById(d.g.person_header_container);
        this.fVC = (TbImageView) view.findViewById(d.g.member_icon);
        this.ayY = (TextView) view.findViewById(d.g.person_name);
        this.fVD = (TextView) view.findViewById(d.g.person_desc);
        this.fVE = (ImageView) view.findViewById(d.g.arrow_icon);
        view.setOnClickListener(this);
        this.fVC.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.j(getView(), d.C0140d.cp_bg_line_d);
            this.fVE.setImageDrawable(am.getDrawable(d.f.icon_mine_list_arrow));
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
        if (fVar != null && fVar.fsA != null) {
            this.mUserData = fVar.fsA;
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String ev = p.ev(portrait);
                this.fVB.getHeadView().setUrl(ev);
                if (ev.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.fVB.getHeadView().startLoad(ev, 10, false);
                } else {
                    this.fVB.getHeadView().startLoad(ev, 25, false);
                }
            } else {
                this.fVB.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            i pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fVB.fl(pendantData.tU());
            }
            if (this.fVB.Aj()) {
                this.fVB.getHeadView().setShowV(false);
                this.fVF.setPadding(0, 0, 0, 0);
            } else {
                this.fVF.setPadding(0, 0, 0, 0);
                if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                    this.fVB.getHeadView().setShowV(true);
                } else {
                    this.fVB.getHeadView().setShowV(false);
                }
            }
            if (this.mUserData.getIsMem() > 0) {
                this.fVC.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.fVC.setImageDrawable(am.getDrawable(d.f.icon_crown_super_non));
            }
            bhO();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.ayY.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.ayY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fVD.setText(getContext().getString(d.j.person_center_default_introduce));
            bhP();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bhO() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.c(this.ayY, d.C0140d.cp_cont_h, 1);
        } else {
            am.c(this.ayY, d.C0140d.cp_cont_b, 1);
        }
    }

    private void bhP() {
        am.h(this.fVD, d.C0140d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.fVC) {
                TiebaStatic.log(new an("c12523").r("obj_locate", 2));
                if (ba.aV(this.mTbPageContext.getPageActivity())) {
                    ay.zK().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new an("c12523").r("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
