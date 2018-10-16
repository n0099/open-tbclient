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
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.personCenter.data.g;
import org.apache.http.HttpHost;
/* loaded from: classes5.dex */
public class f extends com.baidu.tieba.card.a<g> {
    private TextView aGD;
    protected HeadPendantView gks;
    private TbImageView gkt;
    private TextView gku;
    private ImageView gkv;
    private FrameLayout gkw;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gks = (HeadPendantView) view.findViewById(e.g.person_header);
        this.gks.setHasPendantStyle();
        this.gks.getHeadView().setIsRound(true);
        this.gks.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(e.C0175e.ds1));
        this.gks.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gks.getHeadView().setCustomBigViewIconId(e.f.pic_v_avatar_big);
        this.gks.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds40));
        this.gkw = (FrameLayout) view.findViewById(e.g.person_header_container);
        this.gkt = (TbImageView) view.findViewById(e.g.member_icon);
        this.aGD = (TextView) view.findViewById(e.g.person_name);
        this.gku = (TextView) view.findViewById(e.g.person_desc);
        this.gkv = (ImageView) view.findViewById(e.g.arrow_icon);
        view.setOnClickListener(this);
        this.gkt.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(getView(), e.d.cp_bg_line_d);
            this.gkv.setImageDrawable(al.getDrawable(e.f.icon_mine_list_arrow));
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
        if (gVar != null && gVar.fHF != null) {
            this.mUserData = gVar.fHF;
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String fc = o.fc(portrait);
                this.gks.getHeadView().setUrl(fc);
                if (fc.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.gks.getHeadView().startLoad(fc, 10, false);
                } else {
                    this.gks.getHeadView().startLoad(fc, 25, false);
                }
            } else {
                this.gks.getHeadView().startLoad(String.valueOf(e.f.pic_mycenter_avatar_def_i), 24, false);
            }
            j pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gks.fT(pendantData.xf());
            }
            if (this.gks.DB()) {
                this.gks.getHeadView().setShowV(false);
                this.gkw.setPadding(0, 0, 0, 0);
            } else {
                this.gkw.setPadding(0, 0, 0, 0);
                if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                    this.gks.getHeadView().setShowV(true);
                } else {
                    this.gks.getHeadView().setShowV(false);
                }
            }
            if (this.mUserData.getIsMem() > 0) {
                this.gkt.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.gkt.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
            }
            bnx();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aGD.setText(name_show);
            }
            int i = e.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? e.f.icon_mine_girl : e.f.icon_mine_boy;
            }
            this.aGD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gku.setText(getContext().getString(e.j.person_center_default_introduce));
            bny();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bnx() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aGD, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aGD, e.d.cp_cont_b, 1);
        }
    }

    private void bny() {
        al.h(this.gku, e.d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.gkt) {
                TiebaStatic.log(new am("c12523").x("obj_locate", 2));
                if (ba.bI(this.mTbPageContext.getPageActivity())) {
                    ay.CU().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new am("c12523").x("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
