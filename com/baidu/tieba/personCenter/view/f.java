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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.personCenter.data.g;
/* loaded from: classes5.dex */
public class f extends com.baidu.tieba.card.a<g> {
    private TextView aHt;
    protected HeadPendantView glS;
    private TbImageView glT;
    private TextView glU;
    private ImageView glV;
    private FrameLayout glW;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.glS = (HeadPendantView) view.findViewById(e.g.person_header);
        this.glS.setHasPendantStyle();
        this.glS.getHeadView().setIsRound(true);
        this.glS.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(e.C0200e.ds1));
        this.glS.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.glS.getHeadView().setGodIconResId(e.f.pic_v_avatar_big);
        this.glS.getHeadView().setGodIconWidth(e.C0200e.ds40);
        this.glS.setDefalutResid(e.f.pic_mycenter_avatar_def_i);
        this.glS.setBigVIconResId(e.f.pic_v_avatar_big);
        this.glS.setBigVDimenSize(e.C0200e.ds40);
        this.glW = (FrameLayout) view.findViewById(e.g.person_header_container);
        this.glT = (TbImageView) view.findViewById(e.g.member_icon);
        this.aHt = (TextView) view.findViewById(e.g.person_name);
        this.glU = (TextView) view.findViewById(e.g.person_desc);
        this.glV = (ImageView) view.findViewById(e.g.arrow_icon);
        view.setOnClickListener(this);
        this.glT.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(getView(), e.d.cp_bg_line_d);
            this.glV.setImageDrawable(al.getDrawable(e.f.icon_mine_list_arrow));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(g gVar) {
        if (gVar != null && gVar.fJe != null) {
            this.mUserData = gVar.fJe;
            this.glS.a(this.mUserData);
            if (this.mUserData.getIsMem() > 0) {
                this.glT.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.glT.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
            }
            bmS();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aHt.setText(name_show);
            }
            int i = e.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? e.f.icon_mine_girl : e.f.icon_mine_boy;
            }
            this.aHt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.glU.setText(getContext().getString(e.j.person_center_default_introduce));
            bmT();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bmS() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aHt, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aHt, e.d.cp_cont_b, 1);
        }
    }

    private void bmT() {
        al.h(this.glU, e.d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.glT) {
                TiebaStatic.log(new am("c12523").x("obj_locate", 2));
                if (ba.bG(this.mTbPageContext.getPageActivity())) {
                    ay.Db().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new am("c12523").x("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
