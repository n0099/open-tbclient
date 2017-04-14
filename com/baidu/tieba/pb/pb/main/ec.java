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
    public TbImageView bPk;
    public ViewStub bba;
    public TbImageView bbb;
    public TextView bsf;
    public UserIconBox cdi;
    public ImageView ehA;
    public ImageView ehB;
    public TextView ehC;
    public TextView ehD;
    public TextView ehE;
    public TbRichTextView ehF;
    public FrsPraiseView ehG;
    public ImageView ehH;
    public PbGiftListView ehI;
    public RelativeLayout ehJ;
    public SubPbLayout ehK;
    public RelativeLayout ehL;
    public RelativeLayout ehM;
    public View ehN;
    public LinearLayout ehO;
    public LinearLayout ehS;
    public TextView ehT;
    public View ehU;
    public View ehV;
    public RelativeLayout ehW;
    public TextView ehX;
    public TextView ehY;
    public TextView ehZ;
    public View ehv;
    public View ehw;
    public View ehx;
    public HeadPendantView ehy;
    public HeadImageView ehz;
    public TextView eia;
    public TextView eib;
    public TriangleShapeView eic;
    public FrameLayout enA;
    public TbImageView enB;
    public GifView enC;
    public ThreadSkinView enD;
    public LinearLayout enE;
    public LinearLayout enF;
    public com.baidu.tieba.pb.pb.main.view.j enG;
    public View enj;
    public RelativeLayout enk;
    public View enl;
    public TextView enm;
    public TextView enn;
    public TextView eno;
    public TbImageView enp;
    public TextView enq;
    public TextView enr;
    public ImageView ens;
    public View ent;
    public ImageView enu;
    public View env;
    public PbFloorAgreeView enw;
    public ClickableHeaderImageView enx;
    public TextView eny;
    public TbImageView enz;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=5] */
    public ec(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.ehx = view.findViewById(w.h.sub_pb_more);
        this.ehL = (RelativeLayout) view.findViewById(w.h.user_head_layout);
        this.ehz = (HeadImageView) view.findViewById(w.h.photo);
        this.ehy = (HeadPendantView) view.findViewById(w.h.pendant_photo);
        this.bba = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.ehz.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), w.f.ds30));
        this.ehy.wL();
        if (this.ehy.getHeadView() != null) {
            this.ehy.getHeadView().setIsRound(true);
            this.ehy.getHeadView().setDrawBorder(false);
        }
        if (this.ehy.getPendantView() != null) {
            this.ehy.getPendantView().setIsRound(true);
            this.ehy.getPendantView().setDrawBorder(false);
        }
        this.bsf = (TextView) view.findViewById(w.h.user_name);
        this.ehA = (ImageView) view.findViewById(w.h.user_rank);
        this.ehB = (ImageView) view.findViewById(w.h.user_bawu);
        this.ehF = (TbRichTextView) view.findViewById(w.h.richText);
        this.ehN = view.findViewById(w.h.new_pb_list_item_line_full);
        this.ehI = (PbGiftListView) view.findViewById(w.h.gift_list_view);
        this.ehG = (FrsPraiseView) view.findViewById(w.h.pb_item_praise_view);
        this.ehH = (ImageView) view.findViewById(w.h.pb_item_praise_bottomline);
        this.ehW = (RelativeLayout) view.findViewById(w.h.pb_first_floor_location_container);
        this.ehX = (TextView) view.findViewById(w.h.pb_item_first_floor_name);
        this.ehY = (TextView) view.findViewById(w.h.pb_item_first_floor_reply_time);
        this.ehZ = (TextView) view.findViewById(w.h.pb_item_first_floor_location_address);
        this.eia = (TextView) view.findViewById(w.h.pb_reply_location_address);
        this.ehM = (RelativeLayout) view.findViewById(w.h.pb_item_floor_layout);
        this.ehE = (TextView) view.findViewById(w.h.floor_owner);
        this.ehC = (TextView) view.findViewById(w.h.floor);
        this.ehD = (TextView) view.findViewById(w.h.time);
        this.ehJ = (RelativeLayout) view.findViewById(w.h.pb_post_header_layout);
        this.ehK = (SubPbLayout) view.findViewById(w.h.pb_post_footer_layout);
        this.ehv = view;
        this.ehw = view.findViewById(w.h.new_pb_list_item_blank_top);
        this.ehF.Jc();
        this.ehF.setImageViewStretch(true);
        this.bPk = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.eny = (TextView) view.findViewById(w.h.action_button);
        this.enz = (TbImageView) view.findViewById(w.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ehF.getPaddingLeft()) - this.ehF.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60)), i);
        this.ehF.setMaxImageWidth(min);
        this.ehF.setMaxImageHeight((int) (min * 1.618f));
        this.ehF.setTextSize(TbConfig.getContentSize());
        this.ehF.j(z, false);
        this.ehF.setVoiceViewRes(w.j.voice_play_btn_new);
        this.cdi = (UserIconBox) view.findViewById(w.h.user_icon_box);
        this.ams = (UserIconBox) view.findViewById(w.h.user_tshow_icon_box);
        this.ehO = (LinearLayout) view.findViewById(w.h.add_post_footer_layout);
        this.ehS = (LinearLayout) view.findViewById(w.h.addition_more_container);
        this.ehT = (TextView) this.ehS.findViewById(w.h.addition_more);
        this.ehU = this.ehS.findViewById(w.h.addition_divider1);
        this.ehV = this.ehS.findViewById(w.h.addition_divider2);
        this.eib = (TextView) view.findViewById(w.h.pb_item_tail_content);
        this.ens = (ImageView) view.findViewById(w.h.replybtn);
        this.ent = view.findViewById(w.h.cover_reply_content);
        this.enu = (ImageView) view.findViewById(w.h.replybtn_top_right);
        this.env = view.findViewById(w.h.cover_reply_content_top_right);
        this.enw = (PbFloorAgreeView) view.findViewById(w.h.pb_floor_agree);
        this.enx = (ClickableHeaderImageView) view.findViewById(w.h.god_user_photo);
        this.bbb = (TbImageView) view.findViewById(w.h.user_head_mask);
        this.enx.setGodIconMargin(0);
        this.enx.setGodIconWidth(w.f.ds24);
        this.enA = (FrameLayout) view.findViewById(w.h.lottery_tail);
        this.enB = (TbImageView) view.findViewById(w.h.lottery_tail_normalview);
        this.enC = (GifView) view.findViewById(w.h.lottery_tail_gifview);
        this.enD = (ThreadSkinView) view.findViewById(w.h.pb_item_thread_skin);
        this.enE = (LinearLayout) view.findViewById(w.h.middle);
        this.enF = (LinearLayout) view.findViewById(w.h.pb_list_content);
        this.enG = new com.baidu.tieba.pb.pb.main.view.j(tbPageContext, view);
        this.eic = (TriangleShapeView) view.findViewById(w.h.triangle_view);
        this.enj = com.baidu.tbadk.ala.c.oa().h(tbPageContext.getPageActivity(), 3);
        if (this.enj != null) {
            this.enE.addView(this.enj, 2);
            this.enj.setVisibility(8);
        }
    }

    public void aMA() {
        if (this.enk == null) {
            this.enk = (RelativeLayout) ((ViewStub) this.ehv.findViewById(w.h.pb_yule_head_img_container)).inflate();
        }
        this.enk.setVisibility(0);
        if (this.enp == null) {
            this.enp = (TbImageView) this.ehv.findViewById(w.h.yule_head_img_img);
        }
        if (this.enq == null) {
            this.enq = (TextView) this.ehv.findViewById(w.h.yule_head_img_pic_author);
        }
        if (this.enr == null) {
            this.enr = (TextView) this.ehv.findViewById(w.h.yule_head_img_post_author);
        }
        if (this.eno == null) {
            this.eno = (TextView) this.ehv.findViewById(w.h.yule_head_img_all_rank);
        }
        if (this.enl == null) {
            this.enl = this.ehv.findViewById(w.h.yule_head_img_header_divider);
        }
        if (this.enm == null) {
            this.enm = (TextView) this.ehv.findViewById(w.h.yule_head_img_rank);
        }
        if (this.enn == null) {
            this.enn = (TextView) this.ehv.findViewById(w.h.yule_head_img_up_info);
        }
    }
}
