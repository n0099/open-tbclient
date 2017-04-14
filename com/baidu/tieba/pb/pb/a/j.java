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
    public TextView ehP;
    public LinearLayout ehQ;
    public Button ehR;
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
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [136=5] */
    public j(View view, boolean z, int i, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.ehx = view.findViewById(w.h.sub_pb_more);
        this.ehL = (RelativeLayout) view.findViewById(w.h.user_head_layout);
        this.ehM = (RelativeLayout) view.findViewById(w.h.pb_item_floor_layout);
        this.ehz = (HeadImageView) view.findViewById(w.h.photo);
        this.ehy = (HeadPendantView) view.findViewById(w.h.pendant_photo);
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
        this.ehG = (FrsPraiseView) view.findViewById(w.h.pb_item_praise_view);
        this.ehH = (ImageView) view.findViewById(w.h.pb_item_praise_bottomline);
        this.ehI = (PbGiftListView) view.findViewById(w.h.gift_list_view);
        this.ehW = (RelativeLayout) view.findViewById(w.h.pb_first_floor_location_container);
        this.ehX = (TextView) view.findViewById(w.h.pb_item_first_floor_name);
        this.ehY = (TextView) view.findViewById(w.h.pb_item_first_floor_reply_time);
        this.ehZ = (TextView) view.findViewById(w.h.pb_item_first_floor_location_address);
        this.eia = (TextView) view.findViewById(w.h.pb_reply_location_address);
        this.ehE = (TextView) view.findViewById(w.h.floor_owner);
        this.ehC = (TextView) view.findViewById(w.h.floor);
        this.ehD = (TextView) view.findViewById(w.h.time);
        this.ehJ = (RelativeLayout) view.findViewById(w.h.pb_post_header_layout);
        this.ehK = (SubPbLayout) view.findViewById(w.h.pb_post_footer_layout);
        this.ehv = view;
        this.ehw = view.findViewById(w.h.new_pb_list_item_blank_top);
        this.ehN = view.findViewById(w.h.new_pb_list_item_line_full);
        this.ehF.Jc();
        this.ehF.setImageViewStretch(true);
        int min = Math.min(((((k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ehF.getPaddingLeft()) - this.ehF.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60)), i);
        this.ehF.setMaxImageWidth(min);
        this.ehF.setMaxImageHeight((int) (min * 1.618f));
        this.ehF.setTextSize(TbConfig.getContentSize());
        ViewGroup.LayoutParams layoutParams = this.ehz.getLayoutParams();
        layoutParams.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60);
        this.ehz.setLayoutParams(layoutParams);
        this.ehz.setVisibility(0);
        this.ehF.j(z, false);
        this.ehF.setVoiceViewRes(w.j.voice_play_btn);
        this.cdi = (UserIconBox) view.findViewById(w.h.user_icon_box);
        this.ams = (UserIconBox) view.findViewById(w.h.user_tshow_icon_box);
        this.ehO = (LinearLayout) view.findViewById(w.h.add_post_footer_layout);
        if (z2) {
            this.ehJ.setVisibility(8);
            this.ehF.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ehF.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.ehF.setLayoutParams(layoutParams2);
            view.findViewById(w.h.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.ehQ = (LinearLayout) view.findViewById(w.h.add_time_container);
            this.ehP = (TextView) view.findViewById(w.h.add_time);
            this.ehR = (Button) view.findViewById(w.h.manage_btn);
            this.ehQ.setVisibility(0);
        }
        this.ehS = (LinearLayout) view.findViewById(w.h.addition_more_container);
        this.ehT = (TextView) this.ehS.findViewById(w.h.addition_more);
        this.ehU = this.ehS.findViewById(w.h.addition_divider1);
        this.ehV = this.ehS.findViewById(w.h.addition_divider2);
        this.eib = (TextView) view.findViewById(w.h.pb_item_tail_content);
        this.eic = (TriangleShapeView) view.findViewById(w.h.triangle_view);
    }
}
