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
public class ec extends y.a {
    UserIconBox ams;
    public TbImageView bRB;
    public ViewStub bbW;
    public TbImageView bbX;
    public TextView bux;
    public UserIconBox cfz;
    public View ejL;
    public View ejM;
    public View ejN;
    public HeadPendantView ejO;
    public HeadImageView ejP;
    public ImageView ejQ;
    public ImageView ejR;
    public TextView ejS;
    public TextView ejT;
    public TextView ejU;
    public TbRichTextView ejV;
    public FrsPraiseView ejW;
    public ImageView ejX;
    public PbGiftListView ejY;
    public RelativeLayout ejZ;
    public SubPbLayout eka;
    public RelativeLayout ekb;
    public RelativeLayout ekc;
    public View ekd;
    public LinearLayout eke;
    public LinearLayout eki;
    public TextView ekj;
    public View ekk;
    public View ekl;
    public RelativeLayout ekm;
    public TextView ekn;
    public TextView eko;
    public TextView ekp;
    public TextView ekq;
    public TextView ekr;
    public TriangleShapeView eks;
    public View epB;
    public RelativeLayout epC;
    public View epD;
    public TextView epE;
    public TextView epF;
    public TextView epG;
    public TbImageView epH;
    public TextView epI;
    public TextView epJ;
    public ImageView epK;
    public View epL;
    public ImageView epM;
    public View epN;
    public PbFloorAgreeView epO;
    public ClickableHeaderImageView epP;
    public TextView epQ;
    public TbImageView epR;
    public FrameLayout epS;
    public TbImageView epT;
    public GifView epU;
    public ThreadSkinView epV;
    public LinearLayout epW;
    public LinearLayout epX;
    public com.baidu.tieba.pb.pb.main.view.j epY;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=5] */
    public ec(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.ejN = view.findViewById(w.h.sub_pb_more);
        this.ekb = (RelativeLayout) view.findViewById(w.h.user_head_layout);
        this.ejP = (HeadImageView) view.findViewById(w.h.photo);
        this.ejO = (HeadPendantView) view.findViewById(w.h.pendant_photo);
        this.bbW = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.ejP.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), w.f.ds30));
        this.ejO.wL();
        if (this.ejO.getHeadView() != null) {
            this.ejO.getHeadView().setIsRound(true);
            this.ejO.getHeadView().setDrawBorder(false);
        }
        if (this.ejO.getPendantView() != null) {
            this.ejO.getPendantView().setIsRound(true);
            this.ejO.getPendantView().setDrawBorder(false);
        }
        this.bux = (TextView) view.findViewById(w.h.user_name);
        this.ejQ = (ImageView) view.findViewById(w.h.user_rank);
        this.ejR = (ImageView) view.findViewById(w.h.user_bawu);
        this.ejV = (TbRichTextView) view.findViewById(w.h.richText);
        this.ekd = view.findViewById(w.h.new_pb_list_item_line_full);
        this.ejY = (PbGiftListView) view.findViewById(w.h.gift_list_view);
        this.ejW = (FrsPraiseView) view.findViewById(w.h.pb_item_praise_view);
        this.ejX = (ImageView) view.findViewById(w.h.pb_item_praise_bottomline);
        this.ekm = (RelativeLayout) view.findViewById(w.h.pb_first_floor_location_container);
        this.ekn = (TextView) view.findViewById(w.h.pb_item_first_floor_name);
        this.eko = (TextView) view.findViewById(w.h.pb_item_first_floor_reply_time);
        this.ekp = (TextView) view.findViewById(w.h.pb_item_first_floor_location_address);
        this.ekq = (TextView) view.findViewById(w.h.pb_reply_location_address);
        this.ekc = (RelativeLayout) view.findViewById(w.h.pb_item_floor_layout);
        this.ejU = (TextView) view.findViewById(w.h.floor_owner);
        this.ejS = (TextView) view.findViewById(w.h.floor);
        this.ejT = (TextView) view.findViewById(w.h.time);
        this.ejZ = (RelativeLayout) view.findViewById(w.h.pb_post_header_layout);
        this.eka = (SubPbLayout) view.findViewById(w.h.pb_post_footer_layout);
        this.ejL = view;
        this.ejM = view.findViewById(w.h.new_pb_list_item_blank_top);
        this.ejV.Jc();
        this.ejV.setImageViewStretch(true);
        this.bRB = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.epQ = (TextView) view.findViewById(w.h.action_button);
        this.epR = (TbImageView) view.findViewById(w.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ejV.getPaddingLeft()) - this.ejV.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60)), i);
        this.ejV.setMaxImageWidth(min);
        this.ejV.setMaxImageHeight((int) (min * 1.618f));
        this.ejV.setTextSize(TbConfig.getContentSize());
        this.ejV.j(z, false);
        this.ejV.setVoiceViewRes(w.j.voice_play_btn_new);
        this.cfz = (UserIconBox) view.findViewById(w.h.user_icon_box);
        this.ams = (UserIconBox) view.findViewById(w.h.user_tshow_icon_box);
        this.eke = (LinearLayout) view.findViewById(w.h.add_post_footer_layout);
        this.eki = (LinearLayout) view.findViewById(w.h.addition_more_container);
        this.ekj = (TextView) this.eki.findViewById(w.h.addition_more);
        this.ekk = this.eki.findViewById(w.h.addition_divider1);
        this.ekl = this.eki.findViewById(w.h.addition_divider2);
        this.ekr = (TextView) view.findViewById(w.h.pb_item_tail_content);
        this.epK = (ImageView) view.findViewById(w.h.replybtn);
        this.epL = view.findViewById(w.h.cover_reply_content);
        this.epM = (ImageView) view.findViewById(w.h.replybtn_top_right);
        this.epN = view.findViewById(w.h.cover_reply_content_top_right);
        this.epO = (PbFloorAgreeView) view.findViewById(w.h.pb_floor_agree);
        this.epP = (ClickableHeaderImageView) view.findViewById(w.h.god_user_photo);
        this.bbX = (TbImageView) view.findViewById(w.h.user_head_mask);
        this.epP.setGodIconMargin(0);
        this.epP.setGodIconWidth(w.f.ds24);
        this.epS = (FrameLayout) view.findViewById(w.h.lottery_tail);
        this.epT = (TbImageView) view.findViewById(w.h.lottery_tail_normalview);
        this.epU = (GifView) view.findViewById(w.h.lottery_tail_gifview);
        this.epV = (ThreadSkinView) view.findViewById(w.h.pb_item_thread_skin);
        this.epW = (LinearLayout) view.findViewById(w.h.middle);
        this.epX = (LinearLayout) view.findViewById(w.h.pb_list_content);
        this.epY = new com.baidu.tieba.pb.pb.main.view.j(tbPageContext, view);
        this.eks = (TriangleShapeView) view.findViewById(w.h.triangle_view);
        this.epB = com.baidu.tbadk.ala.c.oa().h(tbPageContext.getPageActivity(), 3);
        if (this.epB != null) {
            this.epW.addView(this.epB, 2);
            this.epB.setVisibility(8);
        }
    }

    public void aNB() {
        if (this.epC == null) {
            this.epC = (RelativeLayout) ((ViewStub) this.ejL.findViewById(w.h.pb_yule_head_img_container)).inflate();
        }
        this.epC.setVisibility(0);
        if (this.epH == null) {
            this.epH = (TbImageView) this.ejL.findViewById(w.h.yule_head_img_img);
        }
        if (this.epI == null) {
            this.epI = (TextView) this.ejL.findViewById(w.h.yule_head_img_pic_author);
        }
        if (this.epJ == null) {
            this.epJ = (TextView) this.ejL.findViewById(w.h.yule_head_img_post_author);
        }
        if (this.epG == null) {
            this.epG = (TextView) this.ejL.findViewById(w.h.yule_head_img_all_rank);
        }
        if (this.epD == null) {
            this.epD = this.ejL.findViewById(w.h.yule_head_img_header_divider);
        }
        if (this.epE == null) {
            this.epE = (TextView) this.ejL.findViewById(w.h.yule_head_img_rank);
        }
        if (this.epF == null) {
            this.epF = (TextView) this.ejL.findViewById(w.h.yule_head_img_up_info);
        }
    }
}
