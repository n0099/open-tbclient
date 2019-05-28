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
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.h;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.a<h> {
    private TextView cbV;
    protected HeadPendantView ieY;
    private TbImageView ieZ;
    private TextView ifa;
    private ImageView ifb;
    private FrameLayout ifc;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ieY = (HeadPendantView) view.findViewById(R.id.person_header);
        this.ieY.setHasPendantStyle();
        this.ieY.getHeadView().setIsRound(true);
        this.ieY.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(R.dimen.ds1));
        this.ieY.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ieY.getHeadView().setGodIconResId(R.drawable.pic_v_avatar_big);
        this.ieY.getHeadView().setGodIconWidth(R.dimen.ds40);
        this.ieY.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.ieY.setBigVIconResId(R.drawable.pic_v_avatar_big);
        this.ieY.setBigVDimenSize(R.dimen.ds40);
        this.ifc = (FrameLayout) view.findViewById(R.id.person_header_container);
        this.ieZ = (TbImageView) view.findViewById(R.id.member_icon);
        this.cbV = (TextView) view.findViewById(R.id.person_name);
        this.ifa = (TextView) view.findViewById(R.id.person_desc);
        this.ifb = (ImageView) view.findViewById(R.id.arrow_icon);
        view.setOnClickListener(this);
        this.ieZ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.l(getView(), R.color.cp_bg_line_d);
            this.ifb.setImageDrawable(al.getDrawable(R.drawable.icon_mine_list_arrow));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_header_info_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(h hVar) {
        int i = R.drawable.icon_mine_boy;
        if (hVar != null && hVar.userData != null) {
            this.mUserData = hVar.userData;
            this.ieY.a(this.mUserData);
            if (this.mUserData.getIsMem() > 0) {
                this.ieZ.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.ieZ.setImageDrawable(al.getDrawable(R.drawable.icon_crown_super_non));
            }
            bYz();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.cbV.setText(name_show);
            }
            if (this.mUserData != null && this.mUserData.getSex() == 2) {
                i = R.drawable.icon_mine_girl;
            }
            this.cbV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.ifa.setText(getContext().getString(R.string.person_center_default_introduce));
            bYA();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bYz() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.f(this.cbV, R.color.cp_cont_h, 1);
        } else {
            al.f(this.cbV, R.color.cp_cont_b, 1);
        }
    }

    private void bYA() {
        al.j(this.ifa, R.color.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.ieZ) {
                TiebaStatic.log(new am("c12523").P("obj_locate", 2));
                if (bc.cE(this.mTbPageContext.getPageActivity())) {
                    ba.aiz().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new am("c12523").P("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
