package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes22.dex */
public class t extends af.a {
    public VoteView aiD;
    public AppletsCellView alz;
    public View eub;
    public View kYX;
    public TextView kZB;
    private ImageView lag;
    private View lah;
    public TbRichTextView lai;
    public TbImageView laj;
    public TbImageView lak;
    public ThreadSkinView lal;
    public LinearLayout lam;
    public TextView lan;
    public LinearLayout lao;
    public u lap;
    public FrameLayout laq;
    public com.baidu.tieba.pb.pb.main.c.a lar;
    public ThreadForumEnterButtonContainer las;
    public PbBusinessPromotionContainer lau;
    public com.baidu.tieba.pb.pb.main.view.a lav;
    public int mSkinType;

    public t(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.lap = new u(view);
        this.lag = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lag.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ay.dhv());
        this.lag.setImageMatrix(matrix);
        this.lah = view.findViewById(R.id.blank_view_above_rich_text);
        this.lai = (TbRichTextView) view.findViewById(R.id.richText);
        this.kYX = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lai.getPaddingLeft()) - this.lai.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lai.getLayoutStrategy());
        dVar.ftO = equipmentWidth;
        this.lai.setLayoutStrategy(dVar);
        this.lak = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lai.getLayoutStrategy().rS(min);
        this.lai.getLayoutStrategy().rT((int) (min * 1.618f));
        this.lai.setTextSize(TbConfig.getContentSize());
        this.lai.setDisplayImage(z, false);
        this.lai.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eub = view.findViewById(R.id.divider_bottom_first_floor);
        this.laj = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.lal = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.lam = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.kZB = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.alz = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lao = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.lan = (TextView) view.findViewById(R.id.pb_tail_text);
        this.las = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.las.setFrom(1);
        this.lav = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.lau = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.laq = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.aiD = (VoteView) view.findViewById(R.id.vote_view);
        this.aiD.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.las != null && fVar != null && fVar.getForum() != null) {
            if (fVar.ddd() && fVar.dda()) {
                this.las.setVisibility(8);
                return;
            }
            this.las.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.dcX())) {
            }
            bw bwVar = new bw();
            bwVar.setId(fVar.getThreadId());
            bwVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bwVar.Av(fVar.getForum().getName());
            bwVar.AA(fVar.getForum().getFirst_class());
            bwVar.AB(fVar.getForum().getSecond_class());
            if (fVar.dcA() != null) {
                bwVar.setThreadType(fVar.dcA().threadType);
            }
            if (fVar.kUB) {
                this.las.setVisibility(8);
                this.lau.a(bwVar, fVar.dcz(), fVar.dda());
                return;
            }
            this.lau.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.kUC) {
            this.lag.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lag.setVisibility(0);
        } else if (z && z2) {
            this.lag.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lag.setVisibility(0);
        } else if (z) {
            this.lag.setImageResource(R.drawable.pic_pb_refined_n);
            this.lag.setVisibility(0);
        } else if (z2) {
            this.lag.setImageResource(R.drawable.pic_pb_stick_n);
            this.lag.setVisibility(0);
        } else {
            this.lag.setVisibility(8);
        }
    }

    public void G(boolean z, int i) {
        if (this.lah != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lah.getLayoutParams();
                layoutParams.height = i;
                this.lah.setLayoutParams(layoutParams);
                this.lah.setVisibility(0);
                return;
            }
            this.lah.setVisibility(8);
        }
    }
}
