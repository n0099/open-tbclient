package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ee extends y.a {
    UserIconBox ame;
    public TbImageView bPv;
    public ViewStub bbh;
    public TbImageView bbi;
    public TextView bsn;
    public UserIconBox ceI;
    public FrsPraiseView ejA;
    public ImageView ejB;
    public PbGiftListView ejC;
    public RelativeLayout ejD;
    public SubPbLayout ejE;
    public RelativeLayout ejF;
    public RelativeLayout ejG;
    public View ejH;
    public LinearLayout ejI;
    public LinearLayout ejM;
    public TextView ejN;
    public View ejO;
    public View ejP;
    public RelativeLayout ejQ;
    public TextView ejR;
    public TextView ejS;
    public TextView ejT;
    public TextView ejU;
    public TextView ejV;
    public TriangleShapeView ejW;
    public View ejp;
    public View ejq;
    public View ejr;
    public HeadPendantView ejs;
    public HeadImageView ejt;
    public ImageView eju;
    public ImageView ejv;
    public TextView ejw;
    public TextView ejx;
    public TextView ejy;
    public TbRichTextView ejz;
    public View epb;
    public RelativeLayout epc;
    public View epd;
    public TextView epe;
    public TextView epf;
    public TextView epg;
    public TbImageView eph;
    public TextView epi;
    public TextView epj;
    public ImageView epk;
    public View epl;
    public ImageView epm;
    public View epn;
    public PbFloorAgreeView epo;
    public ClickableHeaderImageView epp;
    public TextView epq;
    public TbImageView epr;
    public FrameLayout eps;
    public TbImageView ept;
    public GifView epu;
    public ThreadSkinView epv;
    public LinearLayout epw;
    public LinearLayout epx;
    public com.baidu.tieba.pb.pb.main.view.j epy;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=5] */
    public ee(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.ejr = view.findViewById(w.h.sub_pb_more);
        this.ejF = (RelativeLayout) view.findViewById(w.h.user_head_layout);
        this.ejt = (HeadImageView) view.findViewById(w.h.photo);
        this.ejs = (HeadPendantView) view.findViewById(w.h.pendant_photo);
        this.bbh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.ejt.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), w.f.ds30));
        this.ejs.wp();
        if (this.ejs.getHeadView() != null) {
            this.ejs.getHeadView().setIsRound(true);
            this.ejs.getHeadView().setDrawBorder(false);
        }
        if (this.ejs.getPendantView() != null) {
            this.ejs.getPendantView().setIsRound(true);
            this.ejs.getPendantView().setDrawBorder(false);
        }
        this.bsn = (TextView) view.findViewById(w.h.user_name);
        this.eju = (ImageView) view.findViewById(w.h.user_rank);
        this.ejv = (ImageView) view.findViewById(w.h.user_bawu);
        this.ejz = (TbRichTextView) view.findViewById(w.h.richText);
        this.ejH = view.findViewById(w.h.new_pb_list_item_line_full);
        this.ejC = (PbGiftListView) view.findViewById(w.h.gift_list_view);
        this.ejA = (FrsPraiseView) view.findViewById(w.h.pb_item_praise_view);
        this.ejB = (ImageView) view.findViewById(w.h.pb_item_praise_bottomline);
        this.ejQ = (RelativeLayout) view.findViewById(w.h.pb_first_floor_location_container);
        this.ejR = (TextView) view.findViewById(w.h.pb_item_first_floor_name);
        this.ejS = (TextView) view.findViewById(w.h.pb_item_first_floor_reply_time);
        this.ejT = (TextView) view.findViewById(w.h.pb_item_first_floor_location_address);
        this.ejU = (TextView) view.findViewById(w.h.pb_reply_location_address);
        this.ejG = (RelativeLayout) view.findViewById(w.h.pb_item_floor_layout);
        this.ejy = (TextView) view.findViewById(w.h.floor_owner);
        this.ejw = (TextView) view.findViewById(w.h.floor);
        this.ejx = (TextView) view.findViewById(w.h.time);
        this.ejD = (RelativeLayout) view.findViewById(w.h.pb_post_header_layout);
        this.ejE = (SubPbLayout) view.findViewById(w.h.pb_post_footer_layout);
        this.ejp = view;
        this.ejq = view.findViewById(w.h.new_pb_list_item_blank_top);
        this.ejz.ID();
        this.ejz.setImageViewStretch(true);
        this.bPv = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.epq = (TextView) view.findViewById(w.h.action_button);
        this.epr = (TbImageView) view.findViewById(w.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ejz.getPaddingLeft()) - this.ejz.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60)), i);
        this.ejz.setMaxImageWidth(min);
        this.ejz.setMaxImageHeight((int) (min * 1.618f));
        this.ejz.setTextSize(TbConfig.getContentSize());
        this.ejz.j(z, false);
        this.ejz.setVoiceViewRes(w.j.voice_play_btn_new);
        this.ceI = (UserIconBox) view.findViewById(w.h.user_icon_box);
        this.ame = (UserIconBox) view.findViewById(w.h.user_tshow_icon_box);
        this.ejI = (LinearLayout) view.findViewById(w.h.add_post_footer_layout);
        this.ejM = (LinearLayout) view.findViewById(w.h.addition_more_container);
        this.ejN = (TextView) this.ejM.findViewById(w.h.addition_more);
        this.ejO = this.ejM.findViewById(w.h.addition_divider1);
        this.ejP = this.ejM.findViewById(w.h.addition_divider2);
        this.ejV = (TextView) view.findViewById(w.h.pb_item_tail_content);
        this.epk = (ImageView) view.findViewById(w.h.replybtn);
        this.epl = view.findViewById(w.h.cover_reply_content);
        this.epm = (ImageView) view.findViewById(w.h.replybtn_top_right);
        this.epn = view.findViewById(w.h.cover_reply_content_top_right);
        this.epo = (PbFloorAgreeView) view.findViewById(w.h.pb_floor_agree);
        this.epp = (ClickableHeaderImageView) view.findViewById(w.h.god_user_photo);
        this.bbi = (TbImageView) view.findViewById(w.h.user_head_mask);
        this.epp.setGodIconMargin(0);
        this.epp.setGodIconWidth(w.f.ds24);
        this.eps = (FrameLayout) view.findViewById(w.h.lottery_tail);
        this.ept = (TbImageView) view.findViewById(w.h.lottery_tail_normalview);
        this.epu = (GifView) view.findViewById(w.h.lottery_tail_gifview);
        this.epv = (ThreadSkinView) view.findViewById(w.h.pb_item_thread_skin);
        this.epw = (LinearLayout) view.findViewById(w.h.middle);
        this.epx = (LinearLayout) view.findViewById(w.h.pb_list_content);
        this.epy = new com.baidu.tieba.pb.pb.main.view.j(tbPageContext, view);
        this.ejW = (TriangleShapeView) view.findViewById(w.h.triangle_view);
        this.epb = com.baidu.tbadk.ala.c.nD().h(tbPageContext.getPageActivity(), 3);
        if (this.epb != null) {
            this.epw.addView(this.epb, 2);
            this.epb.setVisibility(8);
        }
    }

    public void aMr() {
        if (this.epc == null) {
            this.epc = (RelativeLayout) ((ViewStub) this.ejp.findViewById(w.h.pb_yule_head_img_container)).inflate();
        }
        this.epc.setVisibility(0);
        if (this.eph == null) {
            this.eph = (TbImageView) this.ejp.findViewById(w.h.yule_head_img_img);
        }
        if (this.epi == null) {
            this.epi = (TextView) this.ejp.findViewById(w.h.yule_head_img_pic_author);
        }
        if (this.epj == null) {
            this.epj = (TextView) this.ejp.findViewById(w.h.yule_head_img_post_author);
        }
        if (this.epg == null) {
            this.epg = (TextView) this.ejp.findViewById(w.h.yule_head_img_all_rank);
        }
        if (this.epd == null) {
            this.epd = this.ejp.findViewById(w.h.yule_head_img_header_divider);
        }
        if (this.epe == null) {
            this.epe = (TextView) this.ejp.findViewById(w.h.yule_head_img_rank);
        }
        if (this.epf == null) {
            this.epf = (TextView) this.ejp.findViewById(w.h.yule_head_img_up_info);
        }
    }
}
