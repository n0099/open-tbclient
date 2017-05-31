package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class l extends z.a {
    UserIconBox amk;
    public TextView bAh;
    public UserIconBox ciK;
    public FrsPraiseView ekA;
    public ImageView ekB;
    public PbGiftListView ekC;
    public RelativeLayout ekD;
    public SubPbLayout ekE;
    public RelativeLayout ekF;
    public RelativeLayout ekG;
    public View ekH;
    public LinearLayout ekI;
    public TextView ekJ;
    public LinearLayout ekK;
    public Button ekL;
    public LinearLayout ekM;
    public TextView ekN;
    public View ekO;
    public View ekP;
    public RelativeLayout ekQ;
    public TextView ekR;
    public TextView ekS;
    public TextView ekT;
    public TextView ekU;
    public TextView ekV;
    public TriangleShapeView ekW;
    public TextView ekX;
    public TextView ekY;
    public TextView ekZ;
    public View ekp;
    public View ekq;
    public View ekr;
    public HeadPendantView eks;
    public HeadImageView ekt;
    public ImageView eku;
    public ImageView ekv;
    public TextView ekw;
    public TextView ekx;
    public TextView eky;
    public TbRichTextView ekz;
    public TextView ela;
    public LinearLayout elb;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [143=5] */
    public l(View view, boolean z, int i, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.elb = (LinearLayout) view.findViewById(w.h.belong_ba);
        this.ekX = (TextView) view.findViewById(w.h.belong_ba_btn1);
        this.ekY = (TextView) view.findViewById(w.h.belong_ba_btn2);
        this.ekZ = (TextView) view.findViewById(w.h.belong_ba_btn3);
        this.ela = (TextView) view.findViewById(w.h.belong_ba_btn4);
        this.ekr = view.findViewById(w.h.sub_pb_more);
        this.ekF = (RelativeLayout) view.findViewById(w.h.user_head_layout);
        this.ekG = (RelativeLayout) view.findViewById(w.h.pb_item_floor_layout);
        this.ekt = (HeadImageView) view.findViewById(w.h.photo);
        this.eks = (HeadPendantView) view.findViewById(w.h.pendant_photo);
        this.eks.vV();
        if (this.eks.getHeadView() != null) {
            this.eks.getHeadView().setIsRound(true);
            this.eks.getHeadView().setDrawBorder(false);
        }
        if (this.eks.getPendantView() != null) {
            this.eks.getPendantView().setIsRound(true);
            this.eks.getPendantView().setDrawBorder(false);
        }
        this.bAh = (TextView) view.findViewById(w.h.user_name);
        this.eku = (ImageView) view.findViewById(w.h.user_rank);
        this.ekv = (ImageView) view.findViewById(w.h.user_bawu);
        this.ekz = (TbRichTextView) view.findViewById(w.h.richText);
        this.ekA = (FrsPraiseView) view.findViewById(w.h.pb_item_praise_view);
        this.ekB = (ImageView) view.findViewById(w.h.pb_item_praise_bottomline);
        this.ekC = (PbGiftListView) view.findViewById(w.h.gift_list_view);
        this.ekQ = (RelativeLayout) view.findViewById(w.h.pb_first_floor_location_container);
        this.ekR = (TextView) view.findViewById(w.h.pb_item_first_floor_name);
        this.ekS = (TextView) view.findViewById(w.h.pb_item_first_floor_reply_time);
        this.ekT = (TextView) view.findViewById(w.h.pb_item_first_floor_location_address);
        this.ekU = (TextView) view.findViewById(w.h.pb_reply_location_address);
        this.eky = (TextView) view.findViewById(w.h.floor_owner);
        this.ekw = (TextView) view.findViewById(w.h.floor);
        this.ekx = (TextView) view.findViewById(w.h.time);
        this.ekD = (RelativeLayout) view.findViewById(w.h.pb_post_header_layout);
        this.ekE = (SubPbLayout) view.findViewById(w.h.pb_post_footer_layout);
        this.ekp = view;
        this.ekq = view.findViewById(w.h.new_pb_list_item_blank_top);
        this.ekH = view.findViewById(w.h.new_pb_list_item_line_full);
        this.ekz.Il();
        this.ekz.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ekz.getPaddingLeft()) - this.ekz.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60)), i);
        this.ekz.setMaxImageWidth(min);
        this.ekz.setMaxImageHeight((int) (min * 1.618f));
        this.ekz.setTextSize(TbConfig.getContentSize());
        ViewGroup.LayoutParams layoutParams = this.ekt.getLayoutParams();
        layoutParams.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60);
        this.ekt.setLayoutParams(layoutParams);
        this.ekt.setVisibility(0);
        this.ekz.j(z, false);
        this.ekz.setVoiceViewRes(w.j.voice_play_btn);
        this.ciK = (UserIconBox) view.findViewById(w.h.user_icon_box);
        this.amk = (UserIconBox) view.findViewById(w.h.user_tshow_icon_box);
        this.ekI = (LinearLayout) view.findViewById(w.h.add_post_footer_layout);
        if (z2) {
            this.ekD.setVisibility(8);
            this.ekz.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ekz.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.ekz.setLayoutParams(layoutParams2);
            view.findViewById(w.h.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.ekK = (LinearLayout) view.findViewById(w.h.add_time_container);
            this.ekJ = (TextView) view.findViewById(w.h.add_time);
            this.ekL = (Button) view.findViewById(w.h.manage_btn);
            this.ekK.setVisibility(0);
        }
        this.ekM = (LinearLayout) view.findViewById(w.h.addition_more_container);
        this.ekN = (TextView) this.ekM.findViewById(w.h.addition_more);
        this.ekO = this.ekM.findViewById(w.h.addition_divider1);
        this.ekP = this.ekM.findViewById(w.h.addition_divider2);
        this.ekV = (TextView) view.findViewById(w.h.pb_item_tail_content);
        this.ekW = (TriangleShapeView) view.findViewById(w.h.triangle_view);
    }
}
