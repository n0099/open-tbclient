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
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k extends y.a {
    UserIconBox amq;
    public TextView but;
    public UserIconBox ccw;
    public View eeP;
    public View eeQ;
    public View eeR;
    public HeadPendantView eeS;
    public HeadImageView eeT;
    public ImageView eeU;
    public ImageView eeV;
    public TextView eeW;
    public TextView eeX;
    public TextView eeY;
    public TbRichTextView eeZ;
    public TextView efA;
    public LinearLayout efB;
    public FrsPraiseView efa;
    public ImageView efb;
    public PbGiftListView efc;
    public RelativeLayout efd;
    public SubPbLayout efe;
    public RelativeLayout eff;
    public RelativeLayout efg;
    public View efh;
    public LinearLayout efi;
    public TextView efj;
    public LinearLayout efk;
    public Button efl;
    public LinearLayout efm;
    public TextView efn;
    public View efo;
    public View efp;
    public RelativeLayout efq;
    public TextView efr;
    public TextView efs;
    public TextView eft;
    public TextView efu;
    public TextView efv;
    public TriangleShapeView efw;
    public TextView efx;
    public TextView efy;
    public TextView efz;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [144=5] */
    public k(View view, boolean z, int i, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.efB = (LinearLayout) view.findViewById(w.h.contentView);
        this.efx = (TextView) view.findViewById(w.h.belong_ba_btn1);
        this.efy = (TextView) view.findViewById(w.h.belong_ba_btn2);
        this.efz = (TextView) view.findViewById(w.h.belong_ba_btn3);
        this.efA = (TextView) view.findViewById(w.h.belong_ba_btn4);
        this.eeR = view.findViewById(w.h.sub_pb_more);
        this.eff = (RelativeLayout) view.findViewById(w.h.user_head_layout);
        this.efg = (RelativeLayout) view.findViewById(w.h.pb_item_floor_layout);
        this.eeT = (HeadImageView) view.findViewById(w.h.photo);
        this.eeS = (HeadPendantView) view.findViewById(w.h.pendant_photo);
        this.eeS.vY();
        if (this.eeS.getHeadView() != null) {
            this.eeS.getHeadView().setIsRound(true);
            this.eeS.getHeadView().setDrawBorder(false);
        }
        if (this.eeS.getPendantView() != null) {
            this.eeS.getPendantView().setIsRound(true);
            this.eeS.getPendantView().setDrawBorder(false);
        }
        this.but = (TextView) view.findViewById(w.h.user_name);
        this.eeU = (ImageView) view.findViewById(w.h.user_rank);
        this.eeV = (ImageView) view.findViewById(w.h.user_bawu);
        this.eeZ = (TbRichTextView) view.findViewById(w.h.richText);
        this.efa = (FrsPraiseView) view.findViewById(w.h.pb_item_praise_view);
        this.efb = (ImageView) view.findViewById(w.h.pb_item_praise_bottomline);
        this.efc = (PbGiftListView) view.findViewById(w.h.gift_list_view);
        this.efq = (RelativeLayout) view.findViewById(w.h.pb_first_floor_location_container);
        this.efr = (TextView) view.findViewById(w.h.pb_item_first_floor_name);
        this.efs = (TextView) view.findViewById(w.h.pb_item_first_floor_reply_time);
        this.eft = (TextView) view.findViewById(w.h.pb_item_first_floor_location_address);
        this.efu = (TextView) view.findViewById(w.h.pb_reply_location_address);
        this.eeY = (TextView) view.findViewById(w.h.floor_owner);
        this.eeW = (TextView) view.findViewById(w.h.floor);
        this.eeX = (TextView) view.findViewById(w.h.time);
        this.efd = (RelativeLayout) view.findViewById(w.h.pb_post_header_layout);
        this.efe = (SubPbLayout) view.findViewById(w.h.pb_post_footer_layout);
        this.eeP = view;
        this.eeQ = view.findViewById(w.h.new_pb_list_item_blank_top);
        this.efh = view.findViewById(w.h.new_pb_list_item_line_full);
        this.eeZ.Iq();
        this.eeZ.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eeZ.getPaddingLeft()) - this.eeZ.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60)), i);
        this.eeZ.setMaxImageWidth(min);
        this.eeZ.setMaxImageHeight((int) (min * 1.618f));
        this.eeZ.setTextSize(TbConfig.getContentSize());
        ViewGroup.LayoutParams layoutParams = this.eeT.getLayoutParams();
        layoutParams.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60);
        this.eeT.setLayoutParams(layoutParams);
        this.eeT.setVisibility(0);
        this.eeZ.j(z, false);
        this.eeZ.setVoiceViewRes(w.j.voice_play_btn);
        this.ccw = (UserIconBox) view.findViewById(w.h.user_icon_box);
        this.amq = (UserIconBox) view.findViewById(w.h.user_tshow_icon_box);
        this.efi = (LinearLayout) view.findViewById(w.h.add_post_footer_layout);
        if (z2) {
            this.efd.setVisibility(8);
            this.eeZ.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eeZ.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.eeZ.setLayoutParams(layoutParams2);
            view.findViewById(w.h.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.efk = (LinearLayout) view.findViewById(w.h.add_time_container);
            this.efj = (TextView) view.findViewById(w.h.add_time);
            this.efl = (Button) view.findViewById(w.h.manage_btn);
            this.efk.setVisibility(0);
        }
        this.efm = (LinearLayout) view.findViewById(w.h.addition_more_container);
        this.efn = (TextView) this.efm.findViewById(w.h.addition_more);
        this.efo = this.efm.findViewById(w.h.addition_divider1);
        this.efp = this.efm.findViewById(w.h.addition_divider2);
        this.efv = (TextView) view.findViewById(w.h.pb_item_tail_content);
        this.efw = (TriangleShapeView) view.findViewById(w.h.triangle_view);
    }
}
