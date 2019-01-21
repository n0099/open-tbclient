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
    protected bb aFJ;
    private View.OnLongClickListener aUa;
    private TbRichTextView.h bsE;
    private com.baidu.tieba.pb.a.c bsF;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dQb;
    private com.baidu.adp.lib.e.b<TbImageView> dQc;
    private boolean fZa;
    private TbRichTextView.c fZx;
    private View.OnClickListener gnt;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    public b(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
        this.aFJ = null;
        this.fZx = null;
        this.fZa = i.xR().xV();
        this.mHostId = null;
        this.mCommonClickListener = null;
        this.bsE = null;
        this.bsF = null;
        this.aUa = null;
        this.dQb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDZ */
            public ConstrainImageLayout jz() {
                return new ConstrainImageLayout(b.this.gns.getPageContext().getPageActivity());
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
        this.dQc = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: FH */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(b.this.gns.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1));
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
        this.gnt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
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
    /* renamed from: bk */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.gns.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.bz(true);
        jVar.fZP.setConstrainLayoutPool(this.dQb);
        jVar.fZP.setImageViewPool(this.dQc);
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
        layoutParams.height = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0210e.tbds1);
        layoutParams.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0210e.tbds180);
        jVar.mBottomLine.setLayoutParams(layoutParams);
        ColumnLayout columnLayout = (ColumnLayout) jVar.getView().findViewById(e.g.item_head_owner_root);
        if (columnLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams2 = (LinearLayout.LayoutParams) columnLayout.getLayoutParams();
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams2.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0210e.tbds31);
        layoutParams2.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0210e.tbds1);
        columnLayout.setLayoutParams(layoutParams2);
        if (jVar.gac.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams3 = (LinearLayout.LayoutParams) jVar.gac.getLayoutParams();
        } else {
            layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0210e.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0210e.tbds2);
        jVar.gac.setLayoutParams(layoutParams3);
        jVar.fZK.setVisibility(8);
        jVar.fZO.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
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
            h(postData2);
            postData2.AQ();
            a(jVar, postData2, view, i);
        }
        com.baidu.tieba.pb.pb.b.a(jVar, (com.baidu.tieba.pb.data.d) null);
        return view;
    }

    private void a(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            com.baidu.tieba.pb.pb.b.a(jVar, postData, view, i, this.gns, this.aFJ);
            com.baidu.tieba.pb.pb.b.a(jVar, postData, this.aFJ, i);
            com.baidu.tieba.pb.pb.b.a(this.gns, jVar, postData, view, this.fZa, this.mIsFromCDN, i != 0, this.fZx);
            com.baidu.tieba.pb.pb.b.a(this.gns, jVar, postData);
            com.baidu.tieba.pb.pb.b.a(jVar, postData);
            com.baidu.tieba.pb.pb.b.a(jVar, postData, this.fZa);
        }
    }

    private void h(PostData postData) {
    }

    private void c(j jVar) {
        jVar.fZO.setTextViewOnTouchListener(this.bsF);
        jVar.fZO.setTextViewCheckSelection(false);
    }

    private void b(j jVar) {
        jVar.fZD.setOnLongClickListener(this.aUa);
        if (this.gns != null && this.gns.getPageContext().getOrignalPage() != null) {
            com.baidu.tieba.pb.pb.main.b.a bis = this.gns.bis();
            if (bis != null) {
                jVar.cLX.setOnClickListener(bis.elD);
                jVar.fZN.setOnClickListener(bis.elD);
                jVar.fZT.setOnClickListener(bis.elD);
                jVar.fZT.getHeadView().setOnClickListener(bis.elD);
                jVar.fZO.setOnEmotionClickListener(bis.gkl);
            }
            jVar.fZK.setOnClickListener(this.mCommonClickListener);
            jVar.fZO.setOnLongClickListener(this.aUa);
            jVar.fZO.setOnImageClickListener(this.bsE);
            jVar.fZO.setOnClickListener(this.mCommonClickListener);
            jVar.getView().setOnClickListener(this.mCommonClickListener);
            jVar.fZL.setOnClickListener(this.gnt);
            jVar.fZM.setOnClickListener(this.gnt);
            jVar.fZW.setOnClickListener(this.mCommonClickListener);
            jVar.fZX.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bsE = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aUa = onLongClickListener;
    }

    public void aa(bb bbVar) {
        this.aFJ = bbVar;
    }
}
