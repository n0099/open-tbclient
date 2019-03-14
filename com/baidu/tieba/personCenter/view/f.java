package com.baidu.tieba.personCenter.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.g;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.a<g> {
    private TextView bTY;
    protected HeadPendantView hMO;
    private TbImageView hMP;
    private TextView hMQ;
    private ImageView hMR;
    private FrameLayout hMS;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hMO = (HeadPendantView) view.findViewById(d.g.person_header);
        this.hMO.setHasPendantStyle();
        this.hMO.getHeadView().setIsRound(true);
        this.hMO.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(d.e.ds1));
        this.hMO.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hMO.getHeadView().setGodIconResId(d.f.pic_v_avatar_big);
        this.hMO.getHeadView().setGodIconWidth(d.e.ds40);
        this.hMO.setDefalutResid(d.f.pic_mycenter_avatar_def_i);
        this.hMO.setBigVIconResId(d.f.pic_v_avatar_big);
        this.hMO.setBigVDimenSize(d.e.ds40);
        this.hMS = (FrameLayout) view.findViewById(d.g.person_header_container);
        this.hMP = (TbImageView) view.findViewById(d.g.member_icon);
        this.bTY = (TextView) view.findViewById(d.g.person_name);
        this.hMQ = (TextView) view.findViewById(d.g.person_desc);
        this.hMR = (ImageView) view.findViewById(d.g.arrow_icon);
        view.setOnClickListener(this);
        this.hMP.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.l(getView(), d.C0277d.cp_bg_line_d);
            this.hMR.setImageDrawable(al.getDrawable(d.f.icon_mine_list_arrow));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(g gVar) {
        if (gVar != null && gVar.userData != null) {
            this.mUserData = gVar.userData;
            this.hMO.a(this.mUserData);
            if (this.mUserData.getIsMem() > 0) {
                this.hMP.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.hMP.setImageDrawable(al.getDrawable(d.f.icon_crown_super_non));
            }
            bQE();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.bTY.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.bTY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.hMQ.setText(getContext().getString(d.j.person_center_default_introduce));
            bQF();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bQE() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.d(this.bTY, d.C0277d.cp_cont_h, 1);
        } else {
            al.d(this.bTY, d.C0277d.cp_cont_b, 1);
        }
    }

    private void bQF() {
        al.j(this.hMQ, d.C0277d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.hMP) {
                TiebaStatic.log(new am("c12523").T("obj_locate", 2));
                if (bc.cZ(this.mTbPageContext.getPageActivity())) {
                    ba.adD().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new am("c12523").T("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
