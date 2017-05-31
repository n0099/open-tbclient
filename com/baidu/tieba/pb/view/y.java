package com.baidu.tieba.pb.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.pb.pb.main.fv;
import com.baidu.tieba.pb.pb.main.fw;
import com.baidu.tieba.pb.pb.main.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class y extends FrameLayout {
    private TbPageContext<?> ajh;
    private View cCZ;
    private View eCX;
    private ClickableHeaderImageView eCY;
    private HeadPendantClickableView eCZ;
    private boolean eDa;
    private View.OnClickListener eDb;
    private TextView esW;
    private TextView esX;
    private PbFirstFloorUserLikeButton etk;
    private fv etl;
    private View mRootView;

    public y(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.eDb = new z(this);
        this.ajh = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(w.j.new_pb_header_user_item_simple, (ViewGroup) this, true);
        this.eCZ = (HeadPendantClickableView) this.mRootView.findViewById(w.h.pb_pendant_head_owner_photo);
        this.eCY = (ClickableHeaderImageView) this.mRootView.findViewById(w.h.pb_head_owner_photo);
        this.etk = (PbFirstFloorUserLikeButton) this.mRootView.findViewById(w.h.pb_like_button);
        this.esX = (TextView) this.mRootView.findViewById(w.h.pb_head_owner_info_user_intro);
        this.esW = (TextView) this.mRootView.findViewById(w.h.pb_head_owner_info_user_name);
        this.eCX = this.mRootView.findViewById(w.h.pb_head_owner_root);
        this.cCZ = this.mRootView.findViewById(w.h.bottom_divider_line);
        this.eCZ.vV();
        if (this.eCZ.getHeadView() != null) {
            this.eCZ.getHeadView().setIsRound(true);
            this.eCZ.getHeadView().setDrawBorder(false);
        }
        if (this.eCZ.getPendantView() != null) {
            this.eCZ.getPendantView().setIsRound(true);
            this.eCZ.getPendantView().setDrawBorder(false);
        }
        this.eCY.setDefaultResource(17170445);
        this.eCY.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.eCY.setDefaultBgResource(w.e.cp_bg_line_e);
        this.eCY.setIsRound(true);
        this.etl = new fv(this.ajh, this.etk, 2);
    }

    public void setData(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null && jVar.ejc != null) {
            MetaData metaData = jVar.ejc;
            this.eDa = metaData.isBigV();
            if (this.etl != null) {
                this.etl.isBigV = this.eDa;
            }
            if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().pL())) {
                this.eCY.setVisibility(8);
                this.eCZ.setVisibility(0);
                this.eCZ.setData(metaData);
                UtilHelper.showHeadImageViewBigV(this.eCZ.getHeadView(), metaData);
                this.mRootView.setOnClickListener(this.eDb);
            } else {
                this.eCY.setVisibility(0);
                this.eCZ.setVisibility(8);
                this.eCY.setData(metaData);
                UtilHelper.showHeadImageViewBigV(this.eCY, metaData);
                this.mRootView.setOnClickListener(this.eDb);
            }
            String string = metaData.getName_show() == null ? StringUtils.string(metaData.getUserName()) : StringUtils.string(metaData.getName_show());
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aF(metaData.getSealPrefix()) + 2 : 0) > 0) {
                if (com.baidu.adp.lib.util.j.aF(string) > 12) {
                    string = au.d(string, 12, "...");
                }
            } else if (com.baidu.adp.lib.util.j.aF(string) > 14) {
                string = au.d(string, 14, "...");
            }
            this.esW.setText(fw.i(getContext(), metaData.getSealPrefix(), string));
            if (metaData != null && !TextUtils.isEmpty(metaData.getGodIntro())) {
                this.esX.setVisibility(0);
                this.esX.setText(fw.a(metaData));
            } else {
                this.esX.setVisibility(8);
            }
            GodUserData godUserData = metaData.getGodUserData();
            if (godUserData == null) {
                this.etk.setVisibility(8);
            } else if (godUserData.getIsLike() && godUserData.getIsFromNetWork()) {
                this.etk.setVisibility(8);
            } else {
                this.etk.setVisibility(0);
                this.etk.setTextSize(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds24));
                this.etl.a(metaData);
                this.etk.aO(metaData.getGodUserData().getIsLike());
            }
            if (jVar.ejd) {
                this.cCZ.setVisibility(0);
            } else {
                this.cCZ.setVisibility(8);
            }
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        aq.k(this, w.e.cp_bg_line_d);
        aq.k(this.cCZ, w.e.cp_bg_line_c);
        aq.j(this.eCX, w.g.bg_gray_border_shape_selector);
        aq.i(this.esW, w.e.cp_cont_b);
        aq.i(this.esX, w.e.cp_cont_f);
        if (this.etk != null) {
            this.etk.onChangeSkinType(i);
        }
    }
}
