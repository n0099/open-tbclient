package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.BaobaoTailView;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class ad extends y.a {
    public TextView aVl;
    UserIconBox ahO;
    public UserIconBox cgs;
    public View elH;
    public View elI;
    public View elJ;
    public View elK;
    public View elL;
    public HeadPendantView elM;
    public HeadImageView elN;
    public ImageView elO;
    public ImageView elP;
    public ImageView elQ;
    public TextView elR;
    public TextView elS;
    public ImageView elT;
    public ImageView elU;
    public TbRichTextView elV;
    public FrsPraiseView elW;
    public ImageView elX;
    public PbGiftListView elY;
    public RelativeLayout elZ;
    public LinearLayout ema;
    public ImageView emb;
    public SubPbLayout emc;
    public BaobaoTailView emd;
    public RelativeLayout eme;
    public RelativeLayout emf;
    public LinearLayout emg;
    public TextView emh;
    public LinearLayout emi;
    public Button emj;
    public LinearLayout emk;
    public TextView eml;
    public View emm;
    public View emn;
    public LinearLayout emo;
    public ImageView emp;
    public TextView emq;
    public LinearLayout emr;
    public ImageView ems;
    public TextView emt;
    public TextView emu;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=5] */
    public ad(View view, boolean z, boolean z2, int i, boolean z3) {
        super(view);
        this.mSkinType = 3;
        this.elL = view.findViewById(t.g.sub_pb_more);
        this.eme = (RelativeLayout) view.findViewById(t.g.user_head_layout);
        this.emf = (RelativeLayout) view.findViewById(t.g.pb_item_floor_layout);
        this.elN = (HeadImageView) view.findViewById(t.g.photo);
        this.elM = (HeadPendantView) view.findViewById(t.g.pendant_photo);
        this.elM.vW();
        if (this.elM.getHeadView() != null) {
            this.elM.getHeadView().setIsRound(true);
            this.elM.getHeadView().setDrawBorder(false);
        }
        if (this.elM.getPendantView() != null) {
            this.elM.getPendantView().setIsRound(true);
            this.elM.getPendantView().setDrawBorder(false);
        }
        this.aVl = (TextView) view.findViewById(t.g.user_name);
        this.elO = (ImageView) view.findViewById(t.g.user_rank);
        this.elP = (ImageView) view.findViewById(t.g.user_bawu);
        this.elQ = (ImageView) view.findViewById(t.g.user_gender);
        this.elU = (ImageView) view.findViewById(t.g.reply);
        this.elV = (TbRichTextView) view.findViewById(t.g.richText);
        this.elW = (FrsPraiseView) view.findViewById(t.g.pb_item_praise_view);
        this.elX = (ImageView) view.findViewById(t.g.pb_item_praise_bottomline);
        this.elY = (PbGiftListView) view.findViewById(t.g.gift_list_view);
        this.emo = (LinearLayout) view.findViewById(t.g.pb_item_location_container);
        this.emq = (TextView) view.findViewById(t.g.pb_item_location_address);
        this.emp = (ImageView) view.findViewById(t.g.pb_item_location_img);
        this.emr = (LinearLayout) view.findViewById(t.g.pb_reply_location_container);
        this.emt = (TextView) view.findViewById(t.g.pb_reply_location_address);
        this.ems = (ImageView) view.findViewById(t.g.pb_reply_location_img);
        this.elT = (ImageView) view.findViewById(t.g.floor_owner);
        this.elR = (TextView) view.findViewById(t.g.floor);
        this.elS = (TextView) view.findViewById(t.g.time);
        this.elZ = (RelativeLayout) view.findViewById(t.g.pb_post_header_layout);
        this.emc = (SubPbLayout) view.findViewById(t.g.pb_post_footer_layout);
        this.ema = (LinearLayout) view.findViewById(t.g.pb_subpb_layout_root);
        this.emb = (ImageView) view.findViewById(t.g.pb_post_footer_layout_line_top);
        this.elH = view;
        this.elI = view.findViewById(t.g.new_pb_list_item_line_top);
        this.elJ = view.findViewById(t.g.new_pb_list_item_line_top_full);
        this.elK = view.findViewById(t.g.new_pb_list_item_blank_top);
        this.elV.IO();
        this.elV.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.elV.getPaddingLeft()) - this.elV.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(t.e.ds60)), i);
        this.elV.setMaxImageWidth(min);
        this.elV.setMaxImageHeight((int) (min * 1.618f));
        this.elV.setTextSize(TbConfig.getContentSize());
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.elN.getLayoutParams();
            layoutParams.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(t.e.ds60);
            this.elN.setLayoutParams(layoutParams);
            this.elN.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.elN.getLayoutParams();
            layoutParams2.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(t.e.ds30);
            this.elN.setLayoutParams(layoutParams2);
            this.elN.setVisibility(4);
        }
        this.elV.k(z2, false);
        this.elV.setVoiceViewRes(t.h.voice_play_btn);
        this.cgs = (UserIconBox) view.findViewById(t.g.user_icon_box);
        this.ahO = (UserIconBox) view.findViewById(t.g.user_tshow_icon_box);
        this.emg = (LinearLayout) view.findViewById(t.g.add_post_footer_layout);
        if (z3) {
            this.elZ.setVisibility(8);
            this.elU.setVisibility(8);
            this.elV.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.elV.getLayoutParams();
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            this.elV.setLayoutParams(layoutParams3);
            view.findViewById(t.g.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.emi = (LinearLayout) view.findViewById(t.g.add_time_container);
            this.emh = (TextView) view.findViewById(t.g.add_time);
            this.emj = (Button) view.findViewById(t.g.manage_btn);
            this.emi.setVisibility(0);
        }
        this.emk = (LinearLayout) view.findViewById(t.g.addition_more_container);
        this.eml = (TextView) this.emk.findViewById(t.g.addition_more);
        this.emm = this.emk.findViewById(t.g.addition_divider1);
        this.emn = this.emk.findViewById(t.g.addition_divider2);
        this.emd = (BaobaoTailView) view.findViewById(t.g.baobao_tail);
        this.emu = (TextView) view.findViewById(t.g.pb_item_tail_content);
    }
}
