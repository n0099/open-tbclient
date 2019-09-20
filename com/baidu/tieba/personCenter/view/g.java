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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.h;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.a<h> {
    private TextView cdZ;
    private ImageView fUp;
    protected HeadPendantView iov;
    private TbImageView iow;
    private TextView iox;
    private FrameLayout ioy;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.iov = (HeadPendantView) view.findViewById(R.id.person_header);
        this.iov.setHasPendantStyle();
        this.iov.getHeadView().setIsRound(true);
        this.iov.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(R.dimen.ds1));
        this.iov.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iov.getHeadView().setGodIconResId(R.drawable.pic_v_avatar_big);
        this.iov.getHeadView().setGodIconWidth(R.dimen.ds40);
        this.iov.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.iov.setBigVIconResId(R.drawable.pic_v_avatar_big);
        this.iov.setBigVDimenSize(R.dimen.ds40);
        this.ioy = (FrameLayout) view.findViewById(R.id.person_header_container);
        this.iow = (TbImageView) view.findViewById(R.id.member_icon);
        this.cdZ = (TextView) view.findViewById(R.id.person_name);
        this.iox = (TextView) view.findViewById(R.id.person_desc);
        this.fUp = (ImageView) view.findViewById(R.id.arrow_icon);
        view.setOnClickListener(this);
        this.iow.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.l(getView(), R.color.cp_bg_line_e);
            SvgManager.ajv().a(this.fUp, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
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
        int i = R.drawable.icon_mask_boy_n_svg;
        if (hVar != null && hVar.userData != null) {
            this.mUserData = hVar.userData;
            this.iov.a(this.mUserData);
            if (this.mUserData.getIsMem() > 0) {
                this.iow.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.iow.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
            }
            ccv();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.cdZ.setText(name_show);
            }
            if (this.mUserData != null && this.mUserData.getSex() == 2) {
                i = R.drawable.icon_mask_girl_n_svg;
            }
            this.cdZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(i, null), (Drawable) null);
            this.iox.setText(getContext().getString(R.string.person_center_default_introduce));
            ccw();
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ccv() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.f(this.cdZ, R.color.cp_cont_h, 1);
        } else {
            am.f(this.cdZ, R.color.cp_cont_b, 1);
        }
    }

    private void ccw() {
        am.j(this.iox, R.color.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.iow) {
                TiebaStatic.log(new an("c12523").P("obj_locate", 2));
                if (bc.cF(this.mTbPageContext.getPageActivity())) {
                    ba.ajK().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new an("c12523").P("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
