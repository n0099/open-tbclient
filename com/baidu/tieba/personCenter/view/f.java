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
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.card.a<g> {
    private TextView aBX;
    protected HeadPendantView gcQ;
    private TbImageView gcR;
    private TextView gcS;
    private ImageView gcT;
    private FrameLayout gcU;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gcQ = (HeadPendantView) view.findViewById(e.g.person_header);
        this.gcQ.setHasPendantStyle();
        this.gcQ.getHeadView().setIsRound(true);
        this.gcQ.getHeadView().setBorderWidth((int) getContext().getResources().getDimension(e.C0141e.ds1));
        this.gcQ.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gcQ.getHeadView().setCustomBigViewIconId(e.f.pic_v_avatar_big);
        this.gcQ.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds40));
        this.gcU = (FrameLayout) view.findViewById(e.g.person_header_container);
        this.gcR = (TbImageView) view.findViewById(e.g.member_icon);
        this.aBX = (TextView) view.findViewById(e.g.person_name);
        this.gcS = (TextView) view.findViewById(e.g.person_desc);
        this.gcT = (ImageView) view.findViewById(e.g.arrow_icon);
        view.setOnClickListener(this);
        this.gcR.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.j(getView(), e.d.cp_bg_line_d);
            this.gcT.setImageDrawable(al.getDrawable(e.f.icon_mine_list_arrow));
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
        if (gVar != null && gVar.fAd != null) {
            this.mUserData = gVar.fAd;
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String eN = o.eN(portrait);
                this.gcQ.getHeadView().setUrl(eN);
                if (eN.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.gcQ.getHeadView().startLoad(eN, 10, false);
                } else {
                    this.gcQ.getHeadView().startLoad(eN, 25, false);
                }
            } else {
                this.gcQ.getHeadView().startLoad(String.valueOf(e.f.pic_mycenter_avatar_def_i), 24, false);
            }
            j pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gcQ.fF(pendantData.uW());
            }
            if (this.gcQ.Bv()) {
                this.gcQ.getHeadView().setShowV(false);
                this.gcU.setPadding(0, 0, 0, 0);
            } else {
                this.gcU.setPadding(0, 0, 0, 0);
                if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                    this.gcQ.getHeadView().setShowV(true);
                } else {
                    this.gcQ.getHeadView().setShowV(false);
                }
            }
            if (this.mUserData.getIsMem() > 0) {
                this.gcR.startLoad(this.mUserData.getUserVipInfo().getVipIconUrl(), 10, false);
            } else {
                this.gcR.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
            }
            bkm();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aBX.setText(name_show);
            }
            int i = e.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? e.f.icon_mine_girl : e.f.icon_mine_boy;
            }
            this.aBX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gcS.setText(getContext().getString(e.j.person_center_default_introduce));
            bkn();
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void bkm() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aBX, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aBX, e.d.cp_cont_b, 1);
        }
    }

    private void bkn() {
        al.h(this.gcS, e.d.cp_cont_j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.gcR) {
                TiebaStatic.log(new am("c12523").w("obj_locate", 2));
                if (ba.bA(this.mTbPageContext.getPageActivity())) {
                    ay.AN().c(this.mTbPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            TiebaStatic.log(new am("c12523").w("obj_locate", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mTbPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().isBigV() : false)));
        }
    }
}
