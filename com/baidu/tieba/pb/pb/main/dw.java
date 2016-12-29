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
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class dw extends y.a {
    UserIconBox ahx;
    public TbImageView bAR;
    public UserIconBox bQG;
    public ViewStub baW;
    public TbImageView baX;
    public TextView bbH;
    public View dXQ;
    public View dXR;
    public View dXS;
    public HeadPendantView dXT;
    public HeadImageView dXU;
    public ImageView dXV;
    public ImageView dXW;
    public TextView dXX;
    public TextView dXY;
    public TextView dXZ;
    public TbRichTextView dYa;
    public FrsPraiseView dYb;
    public ImageView dYc;
    public PbGiftListView dYd;
    public RelativeLayout dYe;
    public SubPbLayout dYf;
    public RelativeLayout dYg;
    public RelativeLayout dYh;
    public View dYi;
    public LinearLayout dYj;
    public LinearLayout dYn;
    public TextView dYo;
    public View dYp;
    public View dYq;
    public RelativeLayout dYr;
    public TextView dYs;
    public TextView dYt;
    public TextView dYu;
    public TextView dYv;
    public TextView dYw;
    public TriangleShapeView dYx;
    public GifView edA;
    public ThreadSkinView edB;
    public LinearLayout edC;
    public LinearLayout edD;
    public com.baidu.tieba.pb.pb.main.view.k edE;
    public RelativeLayout edl;
    public View edm;
    public TextView edn;
    public TextView edo;
    public TextView edp;
    public TbImageView edq;
    public TextView edr;
    public TextView eds;
    public ImageView edt;
    public View edu;
    public ClickableHeaderImageView edv;
    public TextView edw;
    public TbImageView edx;
    public FrameLayout edy;
    public TbImageView edz;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [162=5] */
    public dw(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.dXS = view.findViewById(r.g.sub_pb_more);
        this.dYg = (RelativeLayout) view.findViewById(r.g.user_head_layout);
        this.dXU = (HeadImageView) view.findViewById(r.g.photo);
        this.dXT = (HeadPendantView) view.findViewById(r.g.pendant_photo);
        this.baW = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.dXU.setRadius(com.baidu.adp.lib.util.k.e(view.getContext(), r.e.ds30));
        this.dXT.vY();
        if (this.dXT.getHeadView() != null) {
            this.dXT.getHeadView().setIsRound(true);
            this.dXT.getHeadView().setDrawBorder(false);
        }
        if (this.dXT.getPendantView() != null) {
            this.dXT.getPendantView().setIsRound(true);
            this.dXT.getPendantView().setDrawBorder(false);
        }
        this.bbH = (TextView) view.findViewById(r.g.user_name);
        this.dXV = (ImageView) view.findViewById(r.g.user_rank);
        this.dXW = (ImageView) view.findViewById(r.g.user_bawu);
        this.dYa = (TbRichTextView) view.findViewById(r.g.richText);
        this.dYi = view.findViewById(r.g.new_pb_list_item_line_full);
        this.dYd = (PbGiftListView) view.findViewById(r.g.gift_list_view);
        this.dYb = (FrsPraiseView) view.findViewById(r.g.pb_item_praise_view);
        this.dYc = (ImageView) view.findViewById(r.g.pb_item_praise_bottomline);
        this.dYr = (RelativeLayout) view.findViewById(r.g.pb_first_floor_location_container);
        this.dYs = (TextView) view.findViewById(r.g.pb_item_first_floor_name);
        this.dYt = (TextView) view.findViewById(r.g.pb_item_first_floor_reply_time);
        this.dYu = (TextView) view.findViewById(r.g.pb_item_first_floor_location_address);
        this.dYv = (TextView) view.findViewById(r.g.pb_reply_location_address);
        this.dYh = (RelativeLayout) view.findViewById(r.g.pb_item_floor_layout);
        this.dXZ = (TextView) view.findViewById(r.g.floor_owner);
        this.dXX = (TextView) view.findViewById(r.g.floor);
        this.dXY = (TextView) view.findViewById(r.g.time);
        this.dYe = (RelativeLayout) view.findViewById(r.g.pb_post_header_layout);
        this.dYf = (SubPbLayout) view.findViewById(r.g.pb_post_footer_layout);
        this.dXQ = view;
        this.dXR = view.findViewById(r.g.new_pb_list_item_blank_top);
        this.dYa.Im();
        this.dYa.setImageViewStretch(true);
        this.bAR = (TbImageView) view.findViewById(r.g.game_activity_banner);
        this.edw = (TextView) view.findViewById(r.g.action_button);
        this.edx = (TbImageView) view.findViewById(r.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.dYa.getPaddingLeft()) - this.dYa.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds60)), i);
        this.dYa.setMaxImageWidth(min);
        this.dYa.setMaxImageHeight((int) (min * 1.618f));
        this.dYa.setTextSize(TbConfig.getContentSize());
        this.dYa.j(z, false);
        this.dYa.setVoiceViewRes(r.h.voice_play_btn_new);
        this.bQG = (UserIconBox) view.findViewById(r.g.user_icon_box);
        this.ahx = (UserIconBox) view.findViewById(r.g.user_tshow_icon_box);
        this.dYj = (LinearLayout) view.findViewById(r.g.add_post_footer_layout);
        this.dYn = (LinearLayout) view.findViewById(r.g.addition_more_container);
        this.dYo = (TextView) this.dYn.findViewById(r.g.addition_more);
        this.dYp = this.dYn.findViewById(r.g.addition_divider1);
        this.dYq = this.dYn.findViewById(r.g.addition_divider2);
        this.dYw = (TextView) view.findViewById(r.g.pb_item_tail_content);
        this.edt = (ImageView) view.findViewById(r.g.replybtn);
        this.edu = view.findViewById(r.g.cover_reply_content);
        this.edv = (ClickableHeaderImageView) view.findViewById(r.g.god_user_photo);
        this.baX = (TbImageView) view.findViewById(r.g.user_head_mask);
        this.edv.setGodIconMargin(0);
        this.edv.setGodIconWidth(r.e.ds24);
        this.edy = (FrameLayout) view.findViewById(r.g.lottery_tail);
        this.edz = (TbImageView) view.findViewById(r.g.lottery_tail_normalview);
        this.edA = (GifView) view.findViewById(r.g.lottery_tail_gifview);
        this.edB = (ThreadSkinView) view.findViewById(r.g.pb_item_thread_skin);
        this.edC = (LinearLayout) view.findViewById(r.g.middle);
        this.edD = (LinearLayout) view.findViewById(r.g.pb_list_content);
        this.edE = new com.baidu.tieba.pb.pb.main.view.k(tbPageContext, view);
        this.dYx = (TriangleShapeView) view.findViewById(r.g.triangle_view);
    }

    public void aLk() {
        if (this.edl == null) {
            this.edl = (RelativeLayout) ((ViewStub) this.dXQ.findViewById(r.g.pb_yule_head_img_container)).inflate();
        }
        this.edl.setVisibility(0);
        if (this.edq == null) {
            this.edq = (TbImageView) this.dXQ.findViewById(r.g.yule_head_img_img);
        }
        if (this.edr == null) {
            this.edr = (TextView) this.dXQ.findViewById(r.g.yule_head_img_pic_author);
        }
        if (this.eds == null) {
            this.eds = (TextView) this.dXQ.findViewById(r.g.yule_head_img_post_author);
        }
        if (this.edp == null) {
            this.edp = (TextView) this.dXQ.findViewById(r.g.yule_head_img_all_rank);
        }
        if (this.edm == null) {
            this.edm = this.dXQ.findViewById(r.g.yule_head_img_header_divider);
        }
        if (this.edn == null) {
            this.edn = (TextView) this.dXQ.findViewById(r.g.yule_head_img_rank);
        }
        if (this.edo == null) {
            this.edo = (TextView) this.dXQ.findViewById(r.g.yule_head_img_up_info);
        }
    }
}
