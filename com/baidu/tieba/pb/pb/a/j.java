package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
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
public class j extends y.a {
    UserIconBox ams;
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
    public TextView ekf;
    public LinearLayout ekg;
    public Button ekh;
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
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [136=5] */
    public j(View view, boolean z, int i, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.ejN = view.findViewById(w.h.sub_pb_more);
        this.ekb = (RelativeLayout) view.findViewById(w.h.user_head_layout);
        this.ekc = (RelativeLayout) view.findViewById(w.h.pb_item_floor_layout);
        this.ejP = (HeadImageView) view.findViewById(w.h.photo);
        this.ejO = (HeadPendantView) view.findViewById(w.h.pendant_photo);
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
        this.ejW = (FrsPraiseView) view.findViewById(w.h.pb_item_praise_view);
        this.ejX = (ImageView) view.findViewById(w.h.pb_item_praise_bottomline);
        this.ejY = (PbGiftListView) view.findViewById(w.h.gift_list_view);
        this.ekm = (RelativeLayout) view.findViewById(w.h.pb_first_floor_location_container);
        this.ekn = (TextView) view.findViewById(w.h.pb_item_first_floor_name);
        this.eko = (TextView) view.findViewById(w.h.pb_item_first_floor_reply_time);
        this.ekp = (TextView) view.findViewById(w.h.pb_item_first_floor_location_address);
        this.ekq = (TextView) view.findViewById(w.h.pb_reply_location_address);
        this.ejU = (TextView) view.findViewById(w.h.floor_owner);
        this.ejS = (TextView) view.findViewById(w.h.floor);
        this.ejT = (TextView) view.findViewById(w.h.time);
        this.ejZ = (RelativeLayout) view.findViewById(w.h.pb_post_header_layout);
        this.eka = (SubPbLayout) view.findViewById(w.h.pb_post_footer_layout);
        this.ejL = view;
        this.ejM = view.findViewById(w.h.new_pb_list_item_blank_top);
        this.ekd = view.findViewById(w.h.new_pb_list_item_line_full);
        this.ejV.Jc();
        this.ejV.setImageViewStretch(true);
        int min = Math.min(((((k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ejV.getPaddingLeft()) - this.ejV.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60)), i);
        this.ejV.setMaxImageWidth(min);
        this.ejV.setMaxImageHeight((int) (min * 1.618f));
        this.ejV.setTextSize(TbConfig.getContentSize());
        ViewGroup.LayoutParams layoutParams = this.ejP.getLayoutParams();
        layoutParams.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60);
        this.ejP.setLayoutParams(layoutParams);
        this.ejP.setVisibility(0);
        this.ejV.j(z, false);
        this.ejV.setVoiceViewRes(w.j.voice_play_btn);
        this.cfz = (UserIconBox) view.findViewById(w.h.user_icon_box);
        this.ams = (UserIconBox) view.findViewById(w.h.user_tshow_icon_box);
        this.eke = (LinearLayout) view.findViewById(w.h.add_post_footer_layout);
        if (z2) {
            this.ejZ.setVisibility(8);
            this.ejV.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ejV.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.ejV.setLayoutParams(layoutParams2);
            view.findViewById(w.h.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.ekg = (LinearLayout) view.findViewById(w.h.add_time_container);
            this.ekf = (TextView) view.findViewById(w.h.add_time);
            this.ekh = (Button) view.findViewById(w.h.manage_btn);
            this.ekg.setVisibility(0);
        }
        this.eki = (LinearLayout) view.findViewById(w.h.addition_more_container);
        this.ekj = (TextView) this.eki.findViewById(w.h.addition_more);
        this.ekk = this.eki.findViewById(w.h.addition_divider1);
        this.ekl = this.eki.findViewById(w.h.addition_divider2);
        this.ekr = (TextView) view.findViewById(w.h.pb_item_tail_content);
        this.eks = (TriangleShapeView) view.findViewById(w.h.triangle_view);
    }
}
