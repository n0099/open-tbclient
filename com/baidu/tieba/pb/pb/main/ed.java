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
public class ed extends y.a {
    public ViewStub aUU;
    public TbImageView aUV;
    UserIconBox agL;
    public TbImageView bIm;
    public UserIconBox bXk;
    public TextView blu;
    public HeadPendantView egA;
    public HeadImageView egB;
    public ImageView egC;
    public ImageView egD;
    public TextView egE;
    public TextView egF;
    public TextView egG;
    public TbRichTextView egH;
    public FrsPraiseView egI;
    public ImageView egJ;
    public PbGiftListView egK;
    public RelativeLayout egL;
    public SubPbLayout egM;
    public RelativeLayout egN;
    public RelativeLayout egO;
    public View egP;
    public LinearLayout egQ;
    public LinearLayout egU;
    public TextView egV;
    public View egW;
    public View egX;
    public RelativeLayout egY;
    public TextView egZ;
    public View egx;
    public View egy;
    public View egz;
    public TextView eha;
    public TextView ehb;
    public TextView ehc;
    public TextView ehd;
    public TriangleShapeView ehe;
    public View eme;
    public RelativeLayout emf;
    public View emg;
    public TextView emh;
    public TextView emi;
    public TextView emj;
    public TbImageView emk;
    public TextView eml;
    public TextView emm;
    public ImageView emn;
    public View emo;
    public ClickableHeaderImageView emp;
    public TextView emq;
    public TbImageView emr;
    public FrameLayout ems;
    public TbImageView emt;
    public GifView emu;
    public ThreadSkinView emv;
    public LinearLayout emw;
    public LinearLayout emx;
    public com.baidu.tieba.pb.pb.main.view.j emy;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [164=5] */
    public ed(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.egz = view.findViewById(r.h.sub_pb_more);
        this.egN = (RelativeLayout) view.findViewById(r.h.user_head_layout);
        this.egB = (HeadImageView) view.findViewById(r.h.photo);
        this.egA = (HeadPendantView) view.findViewById(r.h.pendant_photo);
        this.aUU = (ViewStub) view.findViewById(r.h.viewstub_headimage_mask);
        this.egB.setRadius(com.baidu.adp.lib.util.k.e(view.getContext(), r.f.ds30));
        this.egA.vS();
        if (this.egA.getHeadView() != null) {
            this.egA.getHeadView().setIsRound(true);
            this.egA.getHeadView().setDrawBorder(false);
        }
        if (this.egA.getPendantView() != null) {
            this.egA.getPendantView().setIsRound(true);
            this.egA.getPendantView().setDrawBorder(false);
        }
        this.blu = (TextView) view.findViewById(r.h.user_name);
        this.egC = (ImageView) view.findViewById(r.h.user_rank);
        this.egD = (ImageView) view.findViewById(r.h.user_bawu);
        this.egH = (TbRichTextView) view.findViewById(r.h.richText);
        this.egP = view.findViewById(r.h.new_pb_list_item_line_full);
        this.egK = (PbGiftListView) view.findViewById(r.h.gift_list_view);
        this.egI = (FrsPraiseView) view.findViewById(r.h.pb_item_praise_view);
        this.egJ = (ImageView) view.findViewById(r.h.pb_item_praise_bottomline);
        this.egY = (RelativeLayout) view.findViewById(r.h.pb_first_floor_location_container);
        this.egZ = (TextView) view.findViewById(r.h.pb_item_first_floor_name);
        this.eha = (TextView) view.findViewById(r.h.pb_item_first_floor_reply_time);
        this.ehb = (TextView) view.findViewById(r.h.pb_item_first_floor_location_address);
        this.ehc = (TextView) view.findViewById(r.h.pb_reply_location_address);
        this.egO = (RelativeLayout) view.findViewById(r.h.pb_item_floor_layout);
        this.egG = (TextView) view.findViewById(r.h.floor_owner);
        this.egE = (TextView) view.findViewById(r.h.floor);
        this.egF = (TextView) view.findViewById(r.h.time);
        this.egL = (RelativeLayout) view.findViewById(r.h.pb_post_header_layout);
        this.egM = (SubPbLayout) view.findViewById(r.h.pb_post_footer_layout);
        this.egx = view;
        this.egy = view.findViewById(r.h.new_pb_list_item_blank_top);
        this.egH.Id();
        this.egH.setImageViewStretch(true);
        this.bIm = (TbImageView) view.findViewById(r.h.game_activity_banner);
        this.emq = (TextView) view.findViewById(r.h.action_button);
        this.emr = (TbImageView) view.findViewById(r.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.egH.getPaddingLeft()) - this.egH.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.f.ds60)), i);
        this.egH.setMaxImageWidth(min);
        this.egH.setMaxImageHeight((int) (min * 1.618f));
        this.egH.setTextSize(TbConfig.getContentSize());
        this.egH.j(z, false);
        this.egH.setVoiceViewRes(r.j.voice_play_btn_new);
        this.bXk = (UserIconBox) view.findViewById(r.h.user_icon_box);
        this.agL = (UserIconBox) view.findViewById(r.h.user_tshow_icon_box);
        this.egQ = (LinearLayout) view.findViewById(r.h.add_post_footer_layout);
        this.egU = (LinearLayout) view.findViewById(r.h.addition_more_container);
        this.egV = (TextView) this.egU.findViewById(r.h.addition_more);
        this.egW = this.egU.findViewById(r.h.addition_divider1);
        this.egX = this.egU.findViewById(r.h.addition_divider2);
        this.ehd = (TextView) view.findViewById(r.h.pb_item_tail_content);
        this.emn = (ImageView) view.findViewById(r.h.replybtn);
        this.emo = view.findViewById(r.h.cover_reply_content);
        this.emp = (ClickableHeaderImageView) view.findViewById(r.h.god_user_photo);
        this.aUV = (TbImageView) view.findViewById(r.h.user_head_mask);
        this.emp.setGodIconMargin(0);
        this.emp.setGodIconWidth(r.f.ds24);
        this.ems = (FrameLayout) view.findViewById(r.h.lottery_tail);
        this.emt = (TbImageView) view.findViewById(r.h.lottery_tail_normalview);
        this.emu = (GifView) view.findViewById(r.h.lottery_tail_gifview);
        this.emv = (ThreadSkinView) view.findViewById(r.h.pb_item_thread_skin);
        this.emw = (LinearLayout) view.findViewById(r.h.middle);
        this.emx = (LinearLayout) view.findViewById(r.h.pb_list_content);
        this.emy = new com.baidu.tieba.pb.pb.main.view.j(tbPageContext, view);
        this.ehe = (TriangleShapeView) view.findViewById(r.h.triangle_view);
        this.eme = com.baidu.tbadk.ala.c.np().f(tbPageContext.getPageActivity(), 3);
        if (this.eme != null) {
            this.emw.addView(this.eme, 2);
            this.eme.setVisibility(8);
        }
    }

    public void aMY() {
        if (this.emf == null) {
            this.emf = (RelativeLayout) ((ViewStub) this.egx.findViewById(r.h.pb_yule_head_img_container)).inflate();
        }
        this.emf.setVisibility(0);
        if (this.emk == null) {
            this.emk = (TbImageView) this.egx.findViewById(r.h.yule_head_img_img);
        }
        if (this.eml == null) {
            this.eml = (TextView) this.egx.findViewById(r.h.yule_head_img_pic_author);
        }
        if (this.emm == null) {
            this.emm = (TextView) this.egx.findViewById(r.h.yule_head_img_post_author);
        }
        if (this.emj == null) {
            this.emj = (TextView) this.egx.findViewById(r.h.yule_head_img_all_rank);
        }
        if (this.emg == null) {
            this.emg = this.egx.findViewById(r.h.yule_head_img_header_divider);
        }
        if (this.emh == null) {
            this.emh = (TextView) this.egx.findViewById(r.h.yule_head_img_rank);
        }
        if (this.emi == null) {
            this.emi = (TextView) this.egx.findViewById(r.h.yule_head_img_up_info);
        }
    }
}
