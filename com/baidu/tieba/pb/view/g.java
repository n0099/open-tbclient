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
    private TbPageContext<?> alI;
    private View cUT;
    private TextView eOC;
    private TextView eOD;
    private PbFirstFloorUserLikeButton eOP;
    private ao eOQ;
    private View fai;
    private ClickableHeaderImageView faj;
    private HeadPendantClickableView fak;
    private boolean fal;
    private LinearLayout fam;
    private TextView fan;
    private TextView fao;
    private TextView fap;
    private TextView faq;
    private TextView far;
    private TextView fas;
    private View fat;
    private View fau;
    private View fav;
    private View.OnClickListener faw;
    private View mRootView;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.faw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.faj.getVisibility() == 0) {
                    g.this.faj.mOnClickListener.onClick(view);
                } else {
                    g.this.fak.mOnClickListener.onClick(view);
                }
                TiebaStatic.log(new aj("c12151").r("obj_locate", 2));
            }
        };
        this.alI = tbPageContext;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.j.new_pb_header_user_item_simple, (ViewGroup) this, true);
        this.fak = (HeadPendantClickableView) this.mRootView.findViewById(d.h.pb_pendant_head_owner_photo);
        this.faj = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.pb_head_owner_photo);
        this.eOP = (PbFirstFloorUserLikeButton) this.mRootView.findViewById(d.h.pb_like_button);
        this.eOD = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_user_intro);
        this.eOC = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_user_name);
        this.fam = (LinearLayout) this.mRootView.findViewById(d.h.pb_head_user_info_content);
        this.fan = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_fan_number);
        this.fao = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_zan_number);
        this.fap = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_thread_number);
        this.faq = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_fan_number_string);
        this.far = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_zan_number_string);
        this.fas = (TextView) this.mRootView.findViewById(d.h.pb_head_owner_info_thread_number_string);
        this.fai = this.mRootView.findViewById(d.h.pb_head_owner_root);
        this.cUT = this.mRootView.findViewById(d.h.bottom_divider_line);
        this.fat = this.mRootView.findViewById(d.h.middle_divider_line);
        this.fau = this.mRootView.findViewById(d.h.left_vertical_divider_line);
        this.fav = this.mRootView.findViewById(d.h.middle_vertical_divider_line);
        this.fak.wD();
        if (this.fak.getHeadView() != null) {
            this.fak.getHeadView().setIsRound(true);
            this.fak.getHeadView().setDrawBorder(false);
        }
        if (this.fak.getPendantView() != null) {
            this.fak.getPendantView().setIsRound(true);
            this.fak.getPendantView().setDrawBorder(false);
        }
        this.faj.setDefaultResource(17170445);
        this.faj.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.faj.setDefaultBgResource(d.e.cp_bg_line_e);
        this.faj.setIsRound(true);
        this.eOQ = new ao(this.alI, this.eOP, 2);
    }

    public void setData(com.baidu.tieba.pb.data.j jVar) {
        if (jVar != null && jVar.eEv != null) {
            MetaData metaData = jVar.eEv;
            this.fal = metaData.isBigV();
            if (this.eOQ != null) {
                this.eOQ.isBigV = this.fal;
            }
            if (this.fal) {
                this.faj.setVisibility(0);
                this.fak.setVisibility(8);
                this.faj.setData(metaData);
                this.faj.setShowV(this.fal);
                this.mRootView.setOnClickListener(this.faw);
            } else if (metaData.getPendantData() != null && !StringUtils.isNull(metaData.getPendantData().pV())) {
                this.faj.setVisibility(8);
                this.fak.setVisibility(0);
                this.fak.setData(metaData);
                UtilHelper.showHeadImageViewBigV(this.fak.getHeadView(), metaData);
                this.mRootView.setOnClickListener(this.faw);
            }
            String string = metaData.getName_show() == null ? StringUtils.string(metaData.getUserName()) : StringUtils.string(metaData.getName_show());
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aS(metaData.getSealPrefix()) + 2 : 0) > 0) {
                if (com.baidu.adp.lib.util.j.aS(string) > 12) {
                    string = al.d(string, 12, "...");
                }
            } else if (com.baidu.adp.lib.util.j.aS(string) > 14) {
                string = al.d(string, 14, "...");
            }
            this.eOC.setText(ap.i(getContext(), metaData.getSealPrefix(), string));
            if (metaData != null && !TextUtils.isEmpty(metaData.getGodIntro())) {
                this.eOD.setVisibility(0);
                this.eOD.setText(ap.a(metaData));
            } else {
                this.eOD.setVisibility(8);
            }
            if (metaData != null && metaData.getFansNum() > 0) {
                this.fan.setText(al.w(metaData.getFansNum()));
            } else {
                this.fan.setText("0");
            }
            if (metaData != null && metaData.getLikeNum() > 0) {
                this.fao.setText(al.w(metaData.getLikeNum()));
            } else {
                this.fao.setText("0");
            }
            if (metaData != null && metaData.getThreadNum() > 0) {
                this.fap.setText(al.w(metaData.getThreadNum()));
            } else {
                this.fap.setText("1");
            }
            GodUserData godUserData = metaData.getGodUserData();
            if (godUserData == null || !jVar.eEx) {
                this.eOP.setVisibility(8);
            } else if (godUserData.getIsLike() && godUserData.getIsFromNetWork()) {
                this.eOP.setVisibility(8);
            } else {
                this.eOP.setVisibility(0);
                this.eOP.setTextSize(0, k.g(getContext(), d.f.ds24));
                this.eOQ.a(metaData);
                this.eOP.aQ(metaData.getGodUserData().getIsLike());
                ai.j(this.eOP, d.g.btn_recomend_card_rounded_corner_blue_frame);
            }
            if (jVar.eEw) {
                this.cUT.setVisibility(0);
            } else {
                this.cUT.setVisibility(8);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        ai.k(this, d.e.cp_bg_line_d);
        ai.k(this.cUT, d.e.cp_bg_line_c);
        ai.j(this.fam, d.g.bg_gray_border_shape_selector);
        ai.i(this.fan, d.e.cp_cont_b);
        ai.i(this.fao, d.e.cp_cont_b);
        ai.i(this.fap, d.e.cp_cont_b);
        ai.i(this.faq, d.e.cp_cont_f);
        ai.i(this.far, d.e.cp_cont_f);
        ai.i(this.fas, d.e.cp_cont_f);
        ai.k(this.fat, d.e.cp_bg_line_c);
        ai.k(this.fau, d.e.cp_bg_line_c);
        ai.k(this.fav, d.e.cp_bg_line_c);
        ai.i(this.eOD, d.e.cp_cont_f);
        if (this.fal) {
            ai.i(this.eOC, d.e.cp_cont_r);
        } else {
            ai.i(this.eOC, d.e.cp_cont_f);
        }
        if (this.eOP != null) {
            this.eOP.onChangeSkinType(i);
        }
    }
}
