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
    UserIconBox ame;
    public TextView bsn;
    public UserIconBox ceI;
    public FrsPraiseView ejA;
    public ImageView ejB;
    public PbGiftListView ejC;
    public RelativeLayout ejD;
    public SubPbLayout ejE;
    public RelativeLayout ejF;
    public RelativeLayout ejG;
    public View ejH;
    public LinearLayout ejI;
    public TextView ejJ;
    public LinearLayout ejK;
    public Button ejL;
    public LinearLayout ejM;
    public TextView ejN;
    public View ejO;
    public View ejP;
    public RelativeLayout ejQ;
    public TextView ejR;
    public TextView ejS;
    public TextView ejT;
    public TextView ejU;
    public TextView ejV;
    public TriangleShapeView ejW;
    public View ejp;
    public View ejq;
    public View ejr;
    public HeadPendantView ejs;
    public HeadImageView ejt;
    public ImageView eju;
    public ImageView ejv;
    public TextView ejw;
    public TextView ejx;
    public TextView ejy;
    public TbRichTextView ejz;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [136=5] */
    public j(View view, boolean z, int i, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.ejr = view.findViewById(w.h.sub_pb_more);
        this.ejF = (RelativeLayout) view.findViewById(w.h.user_head_layout);
        this.ejG = (RelativeLayout) view.findViewById(w.h.pb_item_floor_layout);
        this.ejt = (HeadImageView) view.findViewById(w.h.photo);
        this.ejs = (HeadPendantView) view.findViewById(w.h.pendant_photo);
        this.ejs.wp();
        if (this.ejs.getHeadView() != null) {
            this.ejs.getHeadView().setIsRound(true);
            this.ejs.getHeadView().setDrawBorder(false);
        }
        if (this.ejs.getPendantView() != null) {
            this.ejs.getPendantView().setIsRound(true);
            this.ejs.getPendantView().setDrawBorder(false);
        }
        this.bsn = (TextView) view.findViewById(w.h.user_name);
        this.eju = (ImageView) view.findViewById(w.h.user_rank);
        this.ejv = (ImageView) view.findViewById(w.h.user_bawu);
        this.ejz = (TbRichTextView) view.findViewById(w.h.richText);
        this.ejA = (FrsPraiseView) view.findViewById(w.h.pb_item_praise_view);
        this.ejB = (ImageView) view.findViewById(w.h.pb_item_praise_bottomline);
        this.ejC = (PbGiftListView) view.findViewById(w.h.gift_list_view);
        this.ejQ = (RelativeLayout) view.findViewById(w.h.pb_first_floor_location_container);
        this.ejR = (TextView) view.findViewById(w.h.pb_item_first_floor_name);
        this.ejS = (TextView) view.findViewById(w.h.pb_item_first_floor_reply_time);
        this.ejT = (TextView) view.findViewById(w.h.pb_item_first_floor_location_address);
        this.ejU = (TextView) view.findViewById(w.h.pb_reply_location_address);
        this.ejy = (TextView) view.findViewById(w.h.floor_owner);
        this.ejw = (TextView) view.findViewById(w.h.floor);
        this.ejx = (TextView) view.findViewById(w.h.time);
        this.ejD = (RelativeLayout) view.findViewById(w.h.pb_post_header_layout);
        this.ejE = (SubPbLayout) view.findViewById(w.h.pb_post_footer_layout);
        this.ejp = view;
        this.ejq = view.findViewById(w.h.new_pb_list_item_blank_top);
        this.ejH = view.findViewById(w.h.new_pb_list_item_line_full);
        this.ejz.ID();
        this.ejz.setImageViewStretch(true);
        int min = Math.min(((((k.ag(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ejz.getPaddingLeft()) - this.ejz.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60)), i);
        this.ejz.setMaxImageWidth(min);
        this.ejz.setMaxImageHeight((int) (min * 1.618f));
        this.ejz.setTextSize(TbConfig.getContentSize());
        ViewGroup.LayoutParams layoutParams = this.ejt.getLayoutParams();
        layoutParams.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60);
        this.ejt.setLayoutParams(layoutParams);
        this.ejt.setVisibility(0);
        this.ejz.j(z, false);
        this.ejz.setVoiceViewRes(w.j.voice_play_btn);
        this.ceI = (UserIconBox) view.findViewById(w.h.user_icon_box);
        this.ame = (UserIconBox) view.findViewById(w.h.user_tshow_icon_box);
        this.ejI = (LinearLayout) view.findViewById(w.h.add_post_footer_layout);
        if (z2) {
            this.ejD.setVisibility(8);
            this.ejz.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ejz.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.ejz.setLayoutParams(layoutParams2);
            view.findViewById(w.h.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.ejK = (LinearLayout) view.findViewById(w.h.add_time_container);
            this.ejJ = (TextView) view.findViewById(w.h.add_time);
            this.ejL = (Button) view.findViewById(w.h.manage_btn);
            this.ejK.setVisibility(0);
        }
        this.ejM = (LinearLayout) view.findViewById(w.h.addition_more_container);
        this.ejN = (TextView) this.ejM.findViewById(w.h.addition_more);
        this.ejO = this.ejM.findViewById(w.h.addition_divider1);
        this.ejP = this.ejM.findViewById(w.h.addition_divider2);
        this.ejV = (TextView) view.findViewById(w.h.pb_item_tail_content);
        this.ejW = (TriangleShapeView) view.findViewById(w.h.triangle_view);
    }
}
