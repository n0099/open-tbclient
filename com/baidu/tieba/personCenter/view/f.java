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
    private TextView bTX;
    protected HeadPendantView hMU;
    private TbImageView hMV;
    private TextView hMW;
    private ImageView hMX;
    private FrameLayout hMY;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hMU = (HeadPendantView) view.findViewById(d.g.person_header);
        this.hMU.setHasPendantStyle();
        this.hMU.getHeadView().setIsRound(true);
        this.hMU.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(d.e.ds1));
        this.hMU.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hMU.getHeadView().setGodIconResId(d.f.pic_v_avatar_big);
        this.hMU.getHeadView().setGodIconWidth(d.e.ds40);
        this.hMU.setDefalutResid(d.f.pic_mycenter_avatar_def_i);
        this.hMU.setBigVIconResId(d.f.pic_v_avatar_big);
        this.hMU.setBigVDimenSize(d.e.ds40);
        this.hMY = (FrameLayout) view.findViewById(d.g.person_header_container);
        this.hMV = (TbImageView) view.findViewById(d.g.member_icon);
        this.bTX = (TextView) view.findViewById(d.g.person_name);
        this.hMW = (TextView) view.findViewById(d.g.person_desc);
        this.hMX = (ImageView) view.findViewById(d.g.arrow_icon);
        view.setOnClickListener(this);
        this.hMV.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.l(getView(), d.C0236d.cp_bg_line_d);
            this.hMX.setImageDrawable(al.getDrawable(d.f.icon_mine_list_arrow));
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
            this.hMU.a(this.mUserData);
            if (this.mUserData.getIsMem() > 0) {
                this.hMV.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.hMV.setImageDrawable(al.getDrawable(d.f.icon_crown_super_non));
            }
            bQC();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.bTX.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.bTX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.hMW.setText(getContext().getString(d.j.person_center_default_introduce));
            bQD();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bQC() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.d(this.bTX, d.C0236d.cp_cont_h, 1);
        } else {
            al.d(this.bTX, d.C0236d.cp_cont_b, 1);
        }
    }

    private void bQD() {
        al.j(this.hMW, d.C0236d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.hMV) {
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
