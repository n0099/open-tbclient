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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
/* loaded from: classes.dex */
public class w extends y.a {
    public TextView aYg;
    UserIconBox ahW;
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
    public TextView etP;
    public LinearLayout etQ;
    public Button etR;
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
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [136=5] */
    public w(View view, boolean z, int i, boolean z2) {
        super(view);
        this.mSkinType = 3;
        this.etx = view.findViewById(r.g.sub_pb_more);
        this.etL = (RelativeLayout) view.findViewById(r.g.user_head_layout);
        this.etM = (RelativeLayout) view.findViewById(r.g.pb_item_floor_layout);
        this.etz = (HeadImageView) view.findViewById(r.g.photo);
        this.ety = (HeadPendantView) view.findViewById(r.g.pendant_photo);
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
        this.etG = (FrsPraiseView) view.findViewById(r.g.pb_item_praise_view);
        this.etH = (ImageView) view.findViewById(r.g.pb_item_praise_bottomline);
        this.etI = (PbGiftListView) view.findViewById(r.g.gift_list_view);
        this.etW = (RelativeLayout) view.findViewById(r.g.pb_first_floor_location_container);
        this.etX = (TextView) view.findViewById(r.g.pb_item_first_floor_name);
        this.etY = (TextView) view.findViewById(r.g.pb_item_first_floor_reply_time);
        this.etZ = (TextView) view.findViewById(r.g.pb_item_first_floor_location_address);
        this.eua = (TextView) view.findViewById(r.g.pb_reply_location_address);
        this.etE = (TextView) view.findViewById(r.g.floor_owner);
        this.etC = (TextView) view.findViewById(r.g.floor);
        this.etD = (TextView) view.findViewById(r.g.time);
        this.etJ = (RelativeLayout) view.findViewById(r.g.pb_post_header_layout);
        this.etK = (SubPbLayout) view.findViewById(r.g.pb_post_footer_layout);
        this.etv = view;
        this.etw = view.findViewById(r.g.new_pb_list_item_blank_top);
        this.etN = view.findViewById(r.g.new_pb_list_item_line_full);
        this.etF.IR();
        this.etF.setImageViewStretch(true);
        int min = Math.min(((((com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.etF.getPaddingLeft()) - this.etF.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds60)), i);
        this.etF.setMaxImageWidth(min);
        this.etF.setMaxImageHeight((int) (min * 1.618f));
        this.etF.setTextSize(TbConfig.getContentSize());
        ViewGroup.LayoutParams layoutParams = this.etz.getLayoutParams();
        layoutParams.width = (int) TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds60);
        this.etz.setLayoutParams(layoutParams);
        this.etz.setVisibility(0);
        this.etF.j(z, false);
        this.etF.setVoiceViewRes(r.h.voice_play_btn);
        this.clv = (UserIconBox) view.findViewById(r.g.user_icon_box);
        this.ahW = (UserIconBox) view.findViewById(r.g.user_tshow_icon_box);
        this.etO = (LinearLayout) view.findViewById(r.g.add_post_footer_layout);
        if (z2) {
            this.etJ.setVisibility(8);
            this.etF.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.etF.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.etF.setLayoutParams(layoutParams2);
            view.findViewById(r.g.pb_list_item_layout).setPadding(0, 0, 0, 0);
            this.etQ = (LinearLayout) view.findViewById(r.g.add_time_container);
            this.etP = (TextView) view.findViewById(r.g.add_time);
            this.etR = (Button) view.findViewById(r.g.manage_btn);
            this.etQ.setVisibility(0);
        }
        this.etS = (LinearLayout) view.findViewById(r.g.addition_more_container);
        this.etT = (TextView) this.etS.findViewById(r.g.addition_more);
        this.etU = this.etS.findViewById(r.g.addition_divider1);
        this.etV = this.etS.findViewById(r.g.addition_divider2);
        this.eub = (TextView) view.findViewById(r.g.pb_item_tail_content);
        this.euc = (TriangleShapeView) view.findViewById(r.g.triangle_view);
    }
}
