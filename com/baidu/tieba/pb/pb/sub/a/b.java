package com.baidu.tieba.pb.pb.sub.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PostDisPraiseView;
import com.baidu.tbadk.core.view.PostPraiseView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class b extends a<PostData, j> {
    protected bb aBF;
    private View.OnLongClickListener aPP;
    private TbRichTextView.h bop;
    private com.baidu.tieba.pb.a.c boq;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dGe;
    private com.baidu.adp.lib.e.b<TbImageView> dGf;
    private TbRichTextView.c fOR;
    private boolean fOu;
    private View.OnClickListener gcG;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    public b(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
        this.aBF = null;
        this.fOR = null;
        this.fOu = i.wA().wE();
        this.mHostId = null;
        this.mCommonClickListener = null;
        this.bop = null;
        this.boq = null;
        this.aPP = null;
        this.dGe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aBd */
            public ConstrainImageLayout jz() {
                return new ConstrainImageLayout(b.this.gcF.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout v(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout w(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dGf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ep */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(b.this.gcF.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView v(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView w(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.gcG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view instanceof PostDisPraiseView) {
                    PostDisPraiseView postDisPraiseView = (PostDisPraiseView) view;
                    postDisPraiseView.L(postDisPraiseView);
                } else if (view instanceof PostPraiseView) {
                    PostPraiseView postPraiseView = (PostPraiseView) view;
                    postPraiseView.L(postPraiseView);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.gcF.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.bx(true);
        jVar.fPj.setConstrainLayoutPool(this.dGe);
        jVar.fPj.setImageViewPool(this.dGf);
        d(jVar);
        com.baidu.tieba.pb.pb.b.a(jVar, (com.baidu.tieba.pb.data.d) null);
        return jVar;
    }

    private void d(final j jVar) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        if (jVar.mBottomLine.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0200e.tbds1);
        layoutParams.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0200e.tbds180);
        jVar.mBottomLine.setLayoutParams(layoutParams);
        ColumnLayout columnLayout = (ColumnLayout) jVar.getView().findViewById(e.g.item_head_owner_root);
        if (columnLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams2 = (LinearLayout.LayoutParams) columnLayout.getLayoutParams();
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams2.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0200e.tbds31);
        layoutParams2.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0200e.tbds1);
        columnLayout.setLayoutParams(layoutParams2);
        if (jVar.fPw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams3 = (LinearLayout.LayoutParams) jVar.fPw.getLayoutParams();
        } else {
            layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0200e.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0200e.tbds2);
        jVar.fPw.setLayoutParams(layoutParams3);
        jVar.fPe.setVisibility(8);
        jVar.fPi.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mCommonClickListener.onClick(jVar.getView());
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.sub.a.a, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, j jVar) {
        b(jVar);
        c(jVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            g(postData2);
            postData2.zz();
            a(jVar, postData2, view, i);
        }
        com.baidu.tieba.pb.pb.b.a(jVar, (com.baidu.tieba.pb.data.d) null);
        return view;
    }

    private void a(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            com.baidu.tieba.pb.pb.b.a(jVar, postData, view, i, this.gcF, this.aBF);
            com.baidu.tieba.pb.pb.b.a(jVar, postData, this.aBF, i);
            com.baidu.tieba.pb.pb.b.a(this.gcF, jVar, postData, view, this.fOu, this.mIsFromCDN, i != 0, this.fOR);
            com.baidu.tieba.pb.pb.b.a(this.gcF, jVar, postData);
            com.baidu.tieba.pb.pb.b.a(jVar, postData);
            com.baidu.tieba.pb.pb.b.a(jVar, postData, this.fOu);
        }
    }

    private void g(PostData postData) {
    }

    private void c(j jVar) {
        jVar.fPi.setTextViewOnTouchListener(this.boq);
        jVar.fPi.setTextViewCheckSelection(false);
    }

    private void b(j jVar) {
        jVar.fOX.setOnLongClickListener(this.aPP);
        if (this.gcF != null && this.gcF.getPageContext().getOrignalPage() != null) {
            com.baidu.tieba.pb.pb.main.b.a bfm = this.gcF.bfm();
            if (bfm != null) {
                jVar.cIi.setOnClickListener(bfm.ebD);
                jVar.fPh.setOnClickListener(bfm.ebD);
                jVar.fPn.setOnClickListener(bfm.ebD);
                jVar.fPn.getHeadView().setOnClickListener(bfm.ebD);
                jVar.fPi.setOnEmotionClickListener(bfm.fZx);
            }
            jVar.fPe.setOnClickListener(this.mCommonClickListener);
            jVar.fPi.setOnLongClickListener(this.aPP);
            jVar.fPi.setOnImageClickListener(this.bop);
            jVar.fPi.setOnClickListener(this.mCommonClickListener);
            jVar.getView().setOnClickListener(this.mCommonClickListener);
            jVar.fPf.setOnClickListener(this.gcG);
            jVar.fPg.setOnClickListener(this.gcG);
            jVar.fPq.setOnClickListener(this.mCommonClickListener);
            jVar.fPr.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bop = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aPP = onLongClickListener;
    }

    public void aa(bb bbVar) {
        this.aBF = bbVar;
    }
}
