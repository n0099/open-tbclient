package com.baidu.tieba.pb.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.view.PbFirstFloorUserLikeButton;
/* loaded from: classes.dex */
public class g extends FrameLayout {
    private TbPageContext<?> ako;
    private View cTA;
    private PbFirstFloorUserLikeButton eNC;
    private ao eND;
    private TextView eNp;
    private TextView eNq;
    private View eYW;
    private ClickableHeaderImageView eYX;
    private HeadPendantClickableView eYY;
    private boolean eYZ;
    private LinearLayout eZa;
    private TextView eZb;
    private TextView eZc;
    private TextView eZd;
    private TextView eZe;
    private TextView eZf;
    private TextView eZg;
    private View eZh;
    private View eZi;
    private View eZj;
    private View.OnClickListener eZk;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.eZk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eYX.getVisibility() == 0) {
                    g.this.eYX.mOnClickListener.onClick(view);
                } else {
                    g.this.eYY.mOnClickListener.onClick(view);
                }
                TiebaStatic.log(new aj("c12151").r("obj_locate", 2));
            }
        };
        this.ako = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.j.new_pb_header_user_item_simple, (ViewGroup) this, true);
        this.eYY = (HeadPendantClickableView) this.mRootView.findViewById(d.h.pb_pendant_head_owner_photo);
        this.eYX = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.pb_head_owner_photo);
        this.eNC = (PbFirstFloorUserLikeButton) this.mRootView.findViewById(d.h.pb_like_button);
        this.eNq = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_user_intro);
        this.eNp = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_user_name);
        this.eZa = (LinearLayout) this.mRootView.findViewById(d.h.pb_head_user_info_content);
        this.eZb = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_fan_number);
        this.eZc = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_zan_number);
        this.eZd = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_thread_number);
        this.eZe = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_fan_number_string);
        this.eZf = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_zan_number_string);
        this.eZg = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_thread_number_string);
        this.eYW = this.mRootView.findViewById(d.h.pb_head_owner_root);
        this.cTA = this.mRootView.findViewById(d.h.bottom_divider_line);
        this.eZh = this.mRootView.findViewById(d.h.middle_divider_line);
        this.eZi = this.mRootView.findViewById(d.h.left_vertical_divider_line);
        this.eZj = this.mRootView.findViewById(d.h.middle_vertical_divider_line);
        this.eYY.wt();
        if (this.eYY.getHeadView() != null) {
            this.eYY.getHeadView().setIsRound(true);
            this.eYY.getHeadView().setDrawBorder(false);
        }
        if (this.eYY.getPendantView() != null) {
            this.eYY.getPendantView().setIsRound(true);
            this.eYY.getPendantView().setDrawBorder(false);
        }
        this.eYX.setDefaultResource(17170445);
        this.eYX.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.eYX.setDefaultBgResource(d.e.cp_bg_line_e);
        this.eYX.setIsRound(true);
        this.eND = new ao(this.ako, this.eNC, 2);
    }

    public void setData(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null && jVar.eDi != null) {
            MetaData metaData = jVar.eDi;
            this.eYZ = metaData.isBigV();
            if (this.eND != null) {
                this.eND.isBigV = this.eYZ;
            }
            if (this.eYZ) {
                this.eYX.setVisibility(0);
                this.eYY.setVisibility(8);
                this.eYX.setData(metaData);
                this.eYX.setShowV(this.eYZ);
                this.mRootView.setOnClickListener(this.eZk);
            } else if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().pL())) {
                this.eYX.setVisibility(8);
                this.eYY.setVisibility(0);
                this.eYY.setData(metaData);
                UtilHelper.showHeadImageViewBigV(this.eYY.getHeadView(), metaData);
                this.mRootView.setOnClickListener(this.eZk);
            }
            String string = metaData.getName_show() == null ? StringUtils.string(metaData.getUserName()) : StringUtils.string(metaData.getName_show());
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aM(metaData.getSealPrefix()) + 2 : 0) > 0) {
                if (com.baidu.adp.lib.util.j.aM(string) > 12) {
                    string = al.d(string, 12, "...");
                }
            } else if (com.baidu.adp.lib.util.j.aM(string) > 14) {
                string = al.d(string, 14, "...");
            }
            this.eNp.setText(ap.i(getContext(), metaData.getSealPrefix(), string));
            if (metaData != null && !TextUtils.isEmpty(metaData.getGodIntro())) {
                this.eNq.setVisibility(0);
                this.eNq.setText(ap.a(metaData));
            } else {
                this.eNq.setVisibility(8);
            }
            if (metaData != null && metaData.getFansNum() > 0) {
                this.eZb.setText(al.w(metaData.getFansNum()));
            } else {
                this.eZb.setText("0");
            }
            if (metaData != null && metaData.getLikeNum() > 0) {
                this.eZc.setText(al.w(metaData.getLikeNum()));
            } else {
                this.eZc.setText("0");
            }
            if (metaData != null && metaData.getThreadNum() > 0) {
                this.eZd.setText(al.w(metaData.getThreadNum()));
            } else {
                this.eZd.setText("1");
            }
            GodUserData godUserData = metaData.getGodUserData();
            if (godUserData == null || !jVar.eDk) {
                this.eNC.setVisibility(8);
            } else if (godUserData.getIsLike() && godUserData.getIsFromNetWork()) {
                this.eNC.setVisibility(8);
            } else {
                this.eNC.setVisibility(0);
                this.eNC.setTextSize(0, k.g(getContext(), d.f.ds24));
                this.eND.a(metaData);
                this.eNC.aQ(metaData.getGodUserData().getIsLike());
                ai.j(this.eNC, d.g.btn_recomend_card_rounded_corner_blue_frame);
            }
            if (jVar.eDj) {
                this.cTA.setVisibility(0);
            } else {
                this.cTA.setVisibility(8);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        ai.k(this, d.e.cp_bg_line_d);
        ai.k(this.cTA, d.e.cp_bg_line_c);
        ai.j(this.eZa, d.g.bg_gray_border_shape_selector);
        ai.i(this.eZb, d.e.cp_cont_b);
        ai.i(this.eZc, d.e.cp_cont_b);
        ai.i(this.eZd, d.e.cp_cont_b);
        ai.i(this.eZe, d.e.cp_cont_f);
        ai.i(this.eZf, d.e.cp_cont_f);
        ai.i(this.eZg, d.e.cp_cont_f);
        ai.k(this.eZh, d.e.cp_bg_line_c);
        ai.k(this.eZi, d.e.cp_bg_line_c);
        ai.k(this.eZj, d.e.cp_bg_line_c);
        ai.i(this.eNq, d.e.cp_cont_f);
        if (this.eYZ) {
            ai.i(this.eNp, d.e.cp_cont_r);
        } else {
            ai.i(this.eNp, d.e.cp_cont_f);
        }
        if (this.eNC != null) {
            this.eNC.onChangeSkinType(i);
        }
    }
}
