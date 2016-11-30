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
import com.baidu.tieba.pb.view.PbReplyEcommCard;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class ed extends y.a {
    public TextView aYg;
    UserIconBox ahW;
    public TbImageView bUF;
    public ViewStub bbQ;
    public TbImageView bbR;
    public UserIconBox clv;
    public ImageView etA;
    public ImageView etB;
    public TextView etC;
    public TextView etD;
    public TextView etE;
    public TbRichTextView etF;
    public FrsPraiseView etG;
    public ImageView etH;
    public PbGiftListView etI;
    public RelativeLayout etJ;
    public SubPbLayout etK;
    public RelativeLayout etL;
    public RelativeLayout etM;
    public View etN;
    public LinearLayout etO;
    public LinearLayout etS;
    public TextView etT;
    public View etU;
    public View etV;
    public RelativeLayout etW;
    public TextView etX;
    public TextView etY;
    public TextView etZ;
    public View etv;
    public View etw;
    public View etx;
    public HeadPendantView ety;
    public HeadImageView etz;
    public TextView eua;
    public TextView eub;
    public TriangleShapeView euc;
    public RelativeLayout eza;
    public View ezb;
    public TextView ezc;
    public TextView ezd;
    public TextView eze;
    public TbImageView ezf;
    public TextView ezg;
    public TextView ezh;
    public ImageView ezi;
    public View ezj;
    public ClickableHeaderImageView ezk;
    public TextView ezl;
    public TbImageView ezm;
    public FrameLayout ezn;
    public TbImageView ezo;
    public GifView ezp;
    public ThreadSkinView ezq;
    public LinearLayout ezr;
    private ViewStub ezs;
    public PbReplyEcommCard ezt;
    public LinearLayout ezu;
    public com.baidu.tieba.pb.pb.main.view.k ezv;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=5] */
    public ed(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.etx = view.findViewById(r.g.sub_pb_more);
        this.etL = (RelativeLayout) view.findViewById(r.g.user_head_layout);
        this.etz = (HeadImageView) view.findViewById(r.g.photo);
        this.ety = (HeadPendantView) view.findViewById(r.g.pendant_photo);
        this.bbQ = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.etz.setRadius(com.baidu.adp.lib.util.k.e(view.getContext(), r.e.ds30));
        this.ety.wo();
        if (this.ety.getHeadView() != null) {
            this.ety.getHeadView().setIsRound(true);
            this.ety.getHeadView().setDrawBorder(false);
        }
        if (this.ety.getPendantView() != null) {
            this.ety.getPendantView().setIsRound(true);
            this.ety.getPendantView().setDrawBorder(false);
        }
        this.aYg = (TextView) view.findViewById(r.g.user_name);
        this.etA = (ImageView) view.findViewById(r.g.user_rank);
        this.etB = (ImageView) view.findViewById(r.g.user_bawu);
        this.etF = (TbRichTextView) view.findViewById(r.g.richText);
        this.etN = view.findViewById(r.g.new_pb_list_item_line_full);
        this.etI = (PbGiftListView) view.findViewById(r.g.gift_list_view);
        this.etG = (FrsPraiseView) view.findViewById(r.g.pb_item_praise_view);
        this.etH = (ImageView) view.findViewById(r.g.pb_item_praise_bottomline);
        this.etW = (RelativeLayout) view.findViewById(r.g.pb_first_floor_location_container);
        this.etX = (TextView) view.findViewById(r.g.pb_item_first_floor_name);
        this.etY = (TextView) view.findViewById(r.g.pb_item_first_floor_reply_time);
        this.etZ = (TextView) view.findViewById(r.g.pb_item_first_floor_location_address);
        this.eua = (TextView) view.findViewById(r.g.pb_reply_location_address);
        this.etM = (RelativeLayout) view.findViewById(r.g.pb_item_floor_layout);
        this.etE = (TextView) view.findViewById(r.g.floor_owner);
        this.etC = (TextView) view.findViewById(r.g.floor);
        this.etD = (TextView) view.findViewById(r.g.time);
        this.etJ = (RelativeLayout) view.findViewById(r.g.pb_post_header_layout);
        this.etK = (SubPbLayout) view.findViewById(r.g.pb_post_footer_layout);
        this.etv = view;
        this.etw = view.findViewById(r.g.new_pb_list_item_blank_top);
        this.etF.IR();
        this.etF.setImageViewStretch(true);
        this.bUF = (TbImageView) view.findViewById(r.g.game_activity_banner);
        this.ezl = (TextView) view.findViewById(r.g.action_button);
        this.ezm = (TbImageView) view.findViewById(r.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.etF.getPaddingLeft()) - this.etF.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds60)), i);
        this.etF.setMaxImageWidth(min);
        this.etF.setMaxImageHeight((int) (min * 1.618f));
        this.etF.setTextSize(TbConfig.getContentSize());
        this.etF.j(z, false);
        this.etF.setVoiceViewRes(r.h.voice_play_btn_new);
        this.clv = (UserIconBox) view.findViewById(r.g.user_icon_box);
        this.ahW = (UserIconBox) view.findViewById(r.g.user_tshow_icon_box);
        this.etO = (LinearLayout) view.findViewById(r.g.add_post_footer_layout);
        this.etS = (LinearLayout) view.findViewById(r.g.addition_more_container);
        this.etT = (TextView) this.etS.findViewById(r.g.addition_more);
        this.etU = this.etS.findViewById(r.g.addition_divider1);
        this.etV = this.etS.findViewById(r.g.addition_divider2);
        this.eub = (TextView) view.findViewById(r.g.pb_item_tail_content);
        this.ezi = (ImageView) view.findViewById(r.g.replybtn);
        this.ezj = view.findViewById(r.g.cover_reply_content);
        this.ezk = (ClickableHeaderImageView) view.findViewById(r.g.god_user_photo);
        this.bbR = (TbImageView) view.findViewById(r.g.user_head_mask);
        this.ezk.setGodIconMargin(0);
        this.ezk.setGodIconWidth(r.e.ds24);
        this.ezn = (FrameLayout) view.findViewById(r.g.lottery_tail);
        this.ezo = (TbImageView) view.findViewById(r.g.lottery_tail_normalview);
        this.ezp = (GifView) view.findViewById(r.g.lottery_tail_gifview);
        this.ezq = (ThreadSkinView) view.findViewById(r.g.pb_item_thread_skin);
        this.ezr = (LinearLayout) view.findViewById(r.g.middle);
        this.ezs = (ViewStub) view.findViewById(r.g.reply_ecomm_card);
        this.ezu = (LinearLayout) view.findViewById(r.g.pb_list_content);
        this.ezv = new com.baidu.tieba.pb.pb.main.view.k(tbPageContext, view);
        this.euc = (TriangleShapeView) view.findViewById(r.g.triangle_view);
    }

    public PbReplyEcommCard aRp() {
        if (this.ezt == null) {
            this.ezt = (PbReplyEcommCard) this.ezs.inflate();
        }
        return this.ezt;
    }

    public void aRq() {
        if (this.eza == null) {
            this.eza = (RelativeLayout) ((ViewStub) this.etv.findViewById(r.g.pb_yule_head_img_container)).inflate();
        }
        this.eza.setVisibility(0);
        if (this.ezf == null) {
            this.ezf = (TbImageView) this.etv.findViewById(r.g.yule_head_img_img);
        }
        if (this.ezg == null) {
            this.ezg = (TextView) this.etv.findViewById(r.g.yule_head_img_pic_author);
        }
        if (this.ezh == null) {
            this.ezh = (TextView) this.etv.findViewById(r.g.yule_head_img_post_author);
        }
        if (this.eze == null) {
            this.eze = (TextView) this.etv.findViewById(r.g.yule_head_img_all_rank);
        }
        if (this.ezb == null) {
            this.ezb = this.etv.findViewById(r.g.yule_head_img_header_divider);
        }
        if (this.ezc == null) {
            this.ezc = (TextView) this.etv.findViewById(r.g.yule_head_img_rank);
        }
        if (this.ezd == null) {
            this.ezd = (TextView) this.etv.findViewById(r.g.yule_head_img_up_info);
        }
    }
}
