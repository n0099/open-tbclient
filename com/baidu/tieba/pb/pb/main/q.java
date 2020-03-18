package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes9.dex */
public class q extends v.a {
    public AppletsCellView OP;
    public View cVI;
    public TextView iHJ;
    public View iHr;
    public com.baidu.tieba.pb.pb.main.view.a iIA;
    private ImageView iIn;
    private View iIo;
    public TbRichTextView iIp;
    public TbImageView iIq;
    public TbImageView iIr;
    public ThreadSkinView iIs;
    public LinearLayout iIt;
    public TextView iIu;
    public r iIv;
    public FrameLayout iIw;
    public com.baidu.tieba.pb.pb.main.c.a iIx;
    public ThreadForumEnterButtonContainer iIy;
    public PbBusinessPromotionContainer iIz;
    public int mSkinType;

    public q(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.iIv = new r(view);
        this.iIn = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.iIn.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -am.cpy());
        this.iIn.setImageMatrix(matrix);
        this.iIo = view.findViewById(R.id.blank_view_above_rich_text);
        this.iIp = (TbRichTextView) view.findViewById(R.id.richText);
        this.iHr = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iIp.getPaddingLeft()) - this.iIp.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        c cVar = new c(this.iIp.getLayoutStrategy());
        cVar.dOD = equipmentWidth;
        this.iIp.setLayoutStrategy(cVar);
        this.iIr = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.iIp.getLayoutStrategy().nk(min);
        this.iIp.getLayoutStrategy().nl((int) (min * 1.618f));
        this.iIp.setTextSize(TbConfig.getContentSize());
        this.iIp.setDisplayImage(z, false);
        this.iIp.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.cVI = view.findViewById(R.id.divider_bottom_first_floor);
        this.iIq = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.iIs = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.iIt = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.iHJ = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.OP = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.iIu = (TextView) view.findViewById(R.id.pb_tail_text);
        this.iIy = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.iIy.setFrom(1);
        this.iIA = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.iIz = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.iIw = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (this.iIy != null && eVar != null && eVar.getForum() != null) {
            if (eVar.cln() && eVar.aHP()) {
                this.iIy.setVisibility(8);
                return;
            }
            this.iIy.setBottomPlaceHolderVisibility(z2);
            boolean z3 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cli())) {
                z3 = true;
            }
            bj bjVar = new bj();
            bjVar.setId(eVar.getThreadId());
            bjVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForum().getId(), 0L));
            bjVar.sF(eVar.getForum().getName());
            bjVar.sK(eVar.getForum().getFirst_class());
            bjVar.sL(eVar.getForum().getSecond_class());
            if (eVar.ckP() != null) {
                bjVar.setThreadType(eVar.ckP().threadType);
            }
            if (z3) {
                this.iIy.a(bjVar, eVar.cli());
            } else {
                this.iIy.F(bjVar);
            }
            if (eVar.iDs) {
                this.iIy.setVisibility(8);
                this.iIz.a(bjVar, eVar.ckO(), eVar.aHP());
                return;
            }
            this.iIz.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.iDt) {
            this.iIn.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iIn.setVisibility(0);
        } else if (z && z2) {
            this.iIn.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iIn.setVisibility(0);
        } else if (z) {
            this.iIn.setImageResource(R.drawable.pic_pb_refined_n);
            this.iIn.setVisibility(0);
        } else if (z2) {
            this.iIn.setImageResource(R.drawable.pic_pb_stick_n);
            this.iIn.setVisibility(0);
        } else {
            this.iIn.setVisibility(8);
        }
    }

    public void w(boolean z, int i) {
        if (this.iIo != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iIo.getLayoutParams();
                layoutParams.height = i;
                this.iIo.setLayoutParams(layoutParams);
                this.iIo.setVisibility(0);
                return;
            }
            this.iIo.setVisibility(8);
        }
    }
}
