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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
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
    private TextView ayt;
    protected HeadPendantView fRm;
    private TbImageView fRn;
    private TextView fRo;
    private ImageView fRp;
    private FrameLayout fRq;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fRm = (HeadPendantView) view.findViewById(d.g.person_header);
        this.fRm.setHasPendantStyle();
        this.fRm.getHeadView().setIsRound(true);
        this.fRm.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(d.e.ds1));
        this.fRm.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fRm.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.fRm.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.fRq = (FrameLayout) view.findViewById(d.g.person_header_container);
        this.fRn = (TbImageView) view.findViewById(d.g.member_icon);
        this.ayt = (TextView) view.findViewById(d.g.person_name);
        this.fRo = (TextView) view.findViewById(d.g.person_desc);
        this.fRp = (ImageView) view.findViewById(d.g.arrow_icon);
        view.setOnClickListener(this);
        this.fRn.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(getView(), d.C0141d.cp_bg_line_d);
            this.fRp.setImageDrawable(al.getDrawable(d.f.icon_mine_list_arrow));
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
        if (fVar != null && fVar.fov != null) {
            this.mUserData = fVar.fov;
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String eu = p.eu(portrait);
                this.fRm.getHeadView().setUrl(eu);
                if (eu.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.fRm.getHeadView().startLoad(eu, 10, false);
                } else {
                    this.fRm.getHeadView().startLoad(eu, 25, false);
                }
            } else {
                this.fRm.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            i pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fRm.fj(pendantData.ub());
            }
            if (this.fRm.Ae()) {
                this.fRm.getHeadView().setShowV(false);
                this.fRq.setPadding(0, 0, 0, 0);
            } else {
                this.fRq.setPadding(0, 0, 0, 0);
                if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                    this.fRm.getHeadView().setShowV(true);
                } else {
                    this.fRm.getHeadView().setShowV(false);
                }
            }
            if (this.mUserData.getIsMem() > 0) {
                this.fRn.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.fRn.setImageDrawable(al.getDrawable(d.f.icon_crown_super_non));
            }
            biP();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.ayt.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.ayt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fRo.setText(getContext().getString(d.k.person_center_default_introduce));
            biQ();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void biP() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.ayt, d.C0141d.cp_cont_h, 1);
        } else {
            al.c(this.ayt, d.C0141d.cp_cont_b, 1);
        }
    }

    private void biQ() {
        al.h(this.fRo, d.C0141d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.fRn) {
                TiebaStatic.log(new am("c12523").r("obj_locate", 2));
                if (ba.aU(this.mTbPageContext.getPageActivity())) {
                    ay.zG().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new am("c12523").r("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
