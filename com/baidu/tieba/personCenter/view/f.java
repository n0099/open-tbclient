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
    private TextView aKV;
    private TbImageView gvA;
    private TextView gvB;
    private ImageView gvC;
    private FrameLayout gvD;
    protected HeadPendantView gvz;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gvz = (HeadPendantView) view.findViewById(e.g.person_header);
        this.gvz.setHasPendantStyle();
        this.gvz.getHeadView().setIsRound(true);
        this.gvz.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(e.C0210e.ds1));
        this.gvz.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvz.getHeadView().setGodIconResId(e.f.pic_v_avatar_big);
        this.gvz.getHeadView().setGodIconWidth(e.C0210e.ds40);
        this.gvz.setDefalutResid(e.f.pic_mycenter_avatar_def_i);
        this.gvz.setBigVIconResId(e.f.pic_v_avatar_big);
        this.gvz.setBigVDimenSize(e.C0210e.ds40);
        this.gvD = (FrameLayout) view.findViewById(e.g.person_header_container);
        this.gvA = (TbImageView) view.findViewById(e.g.member_icon);
        this.aKV = (TextView) view.findViewById(e.g.person_name);
        this.gvB = (TextView) view.findViewById(e.g.person_desc);
        this.gvC = (ImageView) view.findViewById(e.g.arrow_icon);
        view.setOnClickListener(this);
        this.gvA.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(getView(), e.d.cp_bg_line_d);
            this.gvC.setImageDrawable(al.getDrawable(e.f.icon_mine_list_arrow));
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
        if (gVar != null && gVar.fSM != null) {
            this.mUserData = gVar.fSM;
            this.gvz.a(this.mUserData);
            if (this.mUserData.getIsMem() > 0) {
                this.gvA.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.gvA.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
            }
            bpw();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aKV.setText(name_show);
            }
            int i = e.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? e.f.icon_mine_girl : e.f.icon_mine_boy;
            }
            this.aKV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gvB.setText(getContext().getString(e.j.person_center_default_introduce));
            bpx();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bpw() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aKV, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aKV, e.d.cp_cont_b, 1);
        }
    }

    private void bpx() {
        al.h(this.gvB, e.d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.gvA) {
                TiebaStatic.log(new am("c12523").x("obj_locate", 2));
                if (ba.bJ(this.mTbPageContext.getPageActivity())) {
                    ay.Ef().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new am("c12523").x("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
