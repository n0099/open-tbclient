package com.baidu.tieba.pb.pb.sub.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class b extends a<PostData, k> {
    protected bj KJ;
    private int Yv;
    private View.OnClickListener aku;
    private TbRichTextView.i dMK;
    private com.baidu.tieba.pb.a.c dqX;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gty;
    private com.baidu.adp.lib.d.b<TbImageView> gtz;
    private boolean iEV;
    private TbRichTextView.c iFK;
    private String iWM;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.KJ = null;
        this.iFK = null;
        this.iEV = i.azO().isShowImages();
        this.aku = null;
        this.dMK = null;
        this.dqX = null;
        this.mOnLongClickListener = null;
        this.gty = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bGd */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.iWL.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.gtz = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aIh */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.iWL.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        if (newSubPbActivity != null && newSubPbActivity.crr() != null) {
            this.Yv = newSubPbActivity.crr().csg();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public k b(ViewGroup viewGroup) {
        k kVar = new k(this.iWL.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.Yv);
        kVar.pI(true);
        kVar.iFZ.setConstrainLayoutPool(this.gty);
        kVar.iFZ.setImageViewPool(this.gtz);
        d(kVar);
        com.baidu.tieba.pb.pb.b.clv();
        com.baidu.tieba.pb.pb.b.a(kVar, (e) null);
        return kVar;
    }

    private void d(final k kVar) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        if (kVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) kVar.mBottomLine.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds1);
        layoutParams.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds180);
        kVar.mBottomLine.setLayoutParams(layoutParams);
        ColumnLayout columnLayout = (ColumnLayout) kVar.getView().findViewById(R.id.item_head_owner_root);
        if (columnLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) columnLayout.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams2.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds31);
        layoutParams2.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds1);
        columnLayout.setLayoutParams(layoutParams2);
        if (kVar.iGo.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) kVar.iGo.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        kVar.iGo.setLayoutParams(layoutParams3);
        kVar.iFY.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aku.onClick(kVar.getView());
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.sub.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, k kVar) {
        b(kVar);
        c(kVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.aDw();
            a(kVar, postData2, view, i);
            b(kVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(kVar, (e) null);
        return view;
    }

    private void b(k kVar, PostData postData) {
        if (kVar != null && kVar.iFQ != null) {
            if (aq.equals(this.iWM, postData.getId())) {
                am.setBackgroundColor(kVar.iFQ, R.color.cp_other_g);
            } else {
                am.setBackgroundColor(kVar.iFQ, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            kVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(kVar, postData, view, i, this.iWL, this.KJ);
            com.baidu.tieba.pb.pb.b.a(kVar, postData, this.KJ, i);
            com.baidu.tieba.pb.pb.b.a(this.iWL, kVar, postData, view, this.iEV, this.mIsFromCDN, i != 0, this.iFK);
            com.baidu.tieba.pb.pb.b.a(this.iWL, kVar, postData, this.KJ);
            com.baidu.tieba.pb.pb.b.a(kVar, postData);
            com.baidu.tieba.pb.pb.b.a(kVar, postData, this.iEV);
            i(kVar, postData);
        }
    }

    private void i(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.iGr.setVisibility(postData.khA ? 0 : 8);
        }
    }

    private void c(k kVar) {
        kVar.iFY.setTextViewOnTouchListener(this.dqX);
        kVar.iFY.setTextViewCheckSelection(false);
    }

    private void b(k kVar) {
        kVar.iFQ.setOnLongClickListener(this.mOnLongClickListener);
        if (this.iWL != null && this.iWL.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a clr = this.iWL.clr();
            if (clr != null) {
                kVar.fwO.setOnClickListener(clr.gRi);
                kVar.iFX.setOnClickListener(clr.gRi);
                kVar.iGf.setOnClickListener(clr.gRi);
                kVar.iGf.getHeadView().setOnClickListener(clr.gRi);
                kVar.iFY.setOnEmotionClickListener(clr.iSS);
            }
            kVar.iFY.setOnLongClickListener(this.mOnLongClickListener);
            kVar.iFY.setOnImageClickListener(this.dMK);
            kVar.iFY.setOnClickListener(this.aku);
            kVar.getView().setOnClickListener(this.aku);
            kVar.iGi.setOnClickListener(this.aku);
            kVar.iGj.setOnClickListener(this.aku);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        this.aku = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMK = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bj bjVar) {
        this.KJ = bjVar;
    }

    public void Gv(String str) {
        this.iWM = str;
    }
}
