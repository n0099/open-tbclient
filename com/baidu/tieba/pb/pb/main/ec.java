package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.BaobaoTailView;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.pb.view.PbReplyEcommCard;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class ec extends y.a {
    public TextView aVU;
    public ViewStub aYH;
    public TbImageView aYI;
    UserIconBox ahw;
    public TbImageView bSs;
    public UserIconBox cgq;
    public View enE;
    public View enF;
    public View enG;
    public View enH;
    public View enI;
    public HeadPendantView enJ;
    public HeadImageView enK;
    public ImageView enL;
    public ImageView enM;
    public ImageView enN;
    public TextView enO;
    public TextView enP;
    public ImageView enQ;
    public ImageView enR;
    public TbRichTextView enS;
    public FrsPraiseView enT;
    public ImageView enU;
    public PbGiftListView enV;
    public RelativeLayout enW;
    public LinearLayout enX;
    public ImageView enY;
    public SubPbLayout enZ;
    public BaobaoTailView eoa;
    public RelativeLayout eob;
    public RelativeLayout eoc;
    public LinearLayout eod;
    public TextView eoe;
    public LinearLayout eog;
    public Button eoh;
    public LinearLayout eoi;
    public TextView eoj;
    public View eok;
    public View eol;
    public LinearLayout eom;
    public ImageView eon;
    public TextView eoo;
    public LinearLayout eop;
    public ImageView eoq;
    public TextView eor;
    public TextView eos;
    public View esI;
    public RelativeLayout esJ;
    public View esK;
    public TextView esL;
    public TextView esM;
    public TextView esN;
    public TbImageView esO;
    public TextView esP;
    public TextView esQ;
    public RelativeLayout esR;
    public ImageView esS;
    public ClickableHeaderImageView esT;
    public TextView esU;
    public TbImageView esV;
    public FrameLayout esW;
    public TbImageView esX;
    public GifView esY;
    public ThreadSkinView esZ;
    public LinearLayout eta;
    private ViewStub etb;
    public PbReplyEcommCard etd;
    public LinearLayout ete;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [190=5] */
    public ec(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.mSkinType = 3;
        this.enI = view.findViewById(r.g.sub_pb_more);
        this.eob = (RelativeLayout) view.findViewById(r.g.user_head_layout);
        this.enK = (HeadImageView) view.findViewById(r.g.photo);
        this.enJ = (HeadPendantView) view.findViewById(r.g.pendant_photo);
        this.aYH = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.enK.setRadius(com.baidu.adp.lib.util.k.e(view.getContext(), r.e.ds40));
        this.enJ.wk();
        if (this.enJ.getHeadView() != null) {
            this.enJ.getHeadView().setIsRound(true);
            this.enJ.getHeadView().setDrawBorder(false);
        }
        if (this.enJ.getPendantView() != null) {
            this.enJ.getPendantView().setIsRound(true);
            this.enJ.getPendantView().setDrawBorder(false);
        }
        this.aVU = (TextView) view.findViewById(r.g.user_name);
        this.enL = (ImageView) view.findViewById(r.g.user_rank);
        this.enM = (ImageView) view.findViewById(r.g.user_bawu);
        this.enN = (ImageView) view.findViewById(r.g.user_gender);
        this.enR = (ImageView) view.findViewById(r.g.reply);
        this.enS = (TbRichTextView) view.findViewById(r.g.richText);
        this.esI = view.findViewById(r.g.new_pb_list_item_line_full);
        this.enV = (PbGiftListView) view.findViewById(r.g.gift_list_view);
        this.enT = (FrsPraiseView) view.findViewById(r.g.pb_item_praise_view);
        this.enU = (ImageView) view.findViewById(r.g.pb_item_praise_bottomline);
        this.eom = (LinearLayout) view.findViewById(r.g.pb_item_location_container);
        this.eoo = (TextView) view.findViewById(r.g.pb_item_location_address);
        this.eon = (ImageView) view.findViewById(r.g.pb_item_location_img);
        this.eop = (LinearLayout) view.findViewById(r.g.pb_reply_location_container);
        this.eor = (TextView) view.findViewById(r.g.pb_reply_location_address);
        this.eoq = (ImageView) view.findViewById(r.g.pb_reply_location_img);
        this.eoc = (RelativeLayout) view.findViewById(r.g.pb_item_floor_layout);
        this.enQ = (ImageView) view.findViewById(r.g.floor_owner);
        this.enO = (TextView) view.findViewById(r.g.floor);
        this.enP = (TextView) view.findViewById(r.g.time);
        this.enW = (RelativeLayout) view.findViewById(r.g.pb_post_header_layout);
        this.enZ = (SubPbLayout) view.findViewById(r.g.pb_post_footer_layout);
        this.enX = (LinearLayout) view.findViewById(r.g.pb_subpb_layout_root);
        this.enY = (ImageView) view.findViewById(r.g.pb_post_footer_layout_line_top);
        this.enE = view;
        this.enF = view.findViewById(r.g.new_pb_list_item_line_top);
        this.enG = view.findViewById(r.g.new_pb_list_item_line_top_full);
        this.enH = view.findViewById(r.g.new_pb_list_item_blank_top);
        this.enS.IO();
        this.enS.setImageViewStretch(true);
        this.bSs = (TbImageView) view.findViewById(r.g.game_activity_banner);
        this.esU = (TextView) view.findViewById(r.g.action_button);
        this.esV = (TbImageView) view.findViewById(r.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.enS.getPaddingLeft()) - this.enS.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds60)), i);
        this.enS.setMaxImageWidth(min);
        this.enS.setMaxImageHeight((int) (min * 1.618f));
        this.enS.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.enK.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds80);
            this.enK.setLayoutParams(layoutParams);
            this.enK.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.enK.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds40);
            this.enK.setLayoutParams(layoutParams2);
            this.enK.setVisibility(4);
        }
        this.enS.k(z2, false);
        this.enS.setVoiceViewRes(r.h.voice_play_btn_new);
        this.cgq = (UserIconBox) view.findViewById(r.g.user_icon_box);
        this.ahw = (UserIconBox) view.findViewById(r.g.user_tshow_icon_box);
        this.eod = (LinearLayout) view.findViewById(r.g.add_post_footer_layout);
        if (z3) {
            this.enW.setVisibility(8);
            this.enR.setVisibility(8);
            this.enS.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.enS.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            this.enS.setLayoutParams(layoutParams3);
            view.findViewById(r.g.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.eog = (LinearLayout) view.findViewById(r.g.add_time_container);
            this.eoe = (TextView) view.findViewById(r.g.add_time);
            this.eoh = (Button) view.findViewById(r.g.manage_btn);
            this.eog.setVisibility(0);
        }
        this.eoi = (LinearLayout) view.findViewById(r.g.addition_more_container);
        this.eoj = (TextView) this.eoi.findViewById(r.g.addition_more);
        this.eok = this.eoi.findViewById(r.g.addition_divider1);
        this.eol = this.eoi.findViewById(r.g.addition_divider2);
        this.eoa = (BaobaoTailView) view.findViewById(r.g.baobao_tail);
        this.eos = (TextView) view.findViewById(r.g.pb_item_tail_content);
        this.esS = (ImageView) view.findViewById(r.g.replybtn);
        this.esT = (ClickableHeaderImageView) view.findViewById(r.g.god_user_photo);
        this.aYI = (TbImageView) view.findViewById(r.g.user_head_mask);
        this.esT.setGodIconMargin(0);
        this.esW = (FrameLayout) view.findViewById(r.g.lottery_tail);
        this.esX = (TbImageView) view.findViewById(r.g.lottery_tail_normalview);
        this.esY = (GifView) view.findViewById(r.g.lottery_tail_gifview);
        this.esZ = (ThreadSkinView) view.findViewById(r.g.pb_item_thread_skin);
        this.eta = (LinearLayout) view.findViewById(r.g.middle);
        this.etb = (ViewStub) view.findViewById(r.g.reply_ecomm_card);
        this.ete = (LinearLayout) view.findViewById(r.g.pb_list_content);
    }

    public PbReplyEcommCard aPo() {
        if (this.etd == null) {
            this.etd = (PbReplyEcommCard) this.etb.inflate();
        }
        return this.etd;
    }

    public void aPp() {
        if (this.esJ == null) {
            this.esJ = (RelativeLayout) ((ViewStub) this.enE.findViewById(r.g.pb_yule_head_img_container)).inflate();
        }
        this.esJ.setVisibility(0);
        if (this.esO == null) {
            this.esO = (TbImageView) this.enE.findViewById(r.g.yule_head_img_img);
        }
        if (this.esP == null) {
            this.esP = (TextView) this.enE.findViewById(r.g.yule_head_img_pic_author);
        }
        if (this.esQ == null) {
            this.esQ = (TextView) this.enE.findViewById(r.g.yule_head_img_post_author);
        }
        if (this.esN == null) {
            this.esN = (TextView) this.enE.findViewById(r.g.yule_head_img_all_rank);
        }
        if (this.esK == null) {
            this.esK = this.enE.findViewById(r.g.yule_head_img_header_divider);
        }
        if (this.esL == null) {
            this.esL = (TextView) this.enE.findViewById(r.g.yule_head_img_rank);
        }
        if (this.esM == null) {
            this.esM = (TextView) this.enE.findViewById(r.g.yule_head_img_up_info);
        }
    }
}
