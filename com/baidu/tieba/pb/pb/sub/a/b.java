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
    protected bb aAQ;
    private View.OnLongClickListener aOZ;
    private TbRichTextView.h bnD;
    private com.baidu.tieba.pb.a.c bnE;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dEO;
    private com.baidu.adp.lib.e.b<TbImageView> dEP;
    private boolean fMV;
    private TbRichTextView.c fNs;
    private View.OnClickListener gbk;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    public b(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
        this.aAQ = null;
        this.fNs = null;
        this.fMV = i.ws().ww();
        this.mHostId = null;
        this.mCommonClickListener = null;
        this.bnD = null;
        this.bnE = null;
        this.aOZ = null;
        this.dEO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aBG */
            public ConstrainImageLayout jB() {
                return new ConstrainImageLayout(b.this.gbj.getPageContext().getPageActivity());
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
        this.dEP = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ef */
            public TbImageView jB() {
                TbImageView tbImageView = new TbImageView(b.this.gbj.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds1));
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
        this.gbk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
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
    /* renamed from: bi */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.gbj.getPageContext(), LayoutInflater.from(this.mContext).inflate(e.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.bh(true);
        jVar.fNK.setConstrainLayoutPool(this.dEO);
        jVar.fNK.setImageViewPool(this.dEP);
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
        layoutParams.height = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0175e.tbds1);
        layoutParams.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0175e.tbds180);
        jVar.mBottomLine.setLayoutParams(layoutParams);
        ColumnLayout columnLayout = (ColumnLayout) jVar.getView().findViewById(e.g.item_head_owner_root);
        if (columnLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams2 = (LinearLayout.LayoutParams) columnLayout.getLayoutParams();
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams2.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0175e.tbds31);
        layoutParams2.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0175e.tbds1);
        columnLayout.setLayoutParams(layoutParams2);
        if (jVar.fNX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams3 = (LinearLayout.LayoutParams) jVar.fNX.getLayoutParams();
        } else {
            layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0175e.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(e.C0175e.tbds2);
        jVar.fNX.setLayoutParams(layoutParams3);
        jVar.fNF.setVisibility(8);
        jVar.fNJ.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
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
            postData2.zs();
            a(jVar, postData2, view, i);
        }
        com.baidu.tieba.pb.pb.b.a(jVar, (com.baidu.tieba.pb.data.d) null);
        return view;
    }

    private void a(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            com.baidu.tieba.pb.pb.b.a(jVar, postData, view, i, this.gbj, this.aAQ);
            com.baidu.tieba.pb.pb.b.a(jVar, postData, this.aAQ, i);
            com.baidu.tieba.pb.pb.b.a(this.gbj, jVar, postData, view, this.fMV, this.mIsFromCDN, i != 0, this.fNs);
            com.baidu.tieba.pb.pb.b.a(this.gbj, jVar, postData);
            com.baidu.tieba.pb.pb.b.a(jVar, postData);
            com.baidu.tieba.pb.pb.b.a(jVar, postData, this.fMV);
        }
    }

    private void g(PostData postData) {
    }

    private void c(j jVar) {
        jVar.fNJ.setTextViewOnTouchListener(this.bnE);
        jVar.fNJ.setTextViewCheckSelection(false);
    }

    private void b(j jVar) {
        jVar.fNy.setOnLongClickListener(this.aOZ);
        if (this.gbj != null && this.gbj.getPageContext().getOrignalPage() != null) {
            com.baidu.tieba.pb.pb.main.b.a bfP = this.gbj.bfP();
            if (bfP != null) {
                jVar.cGZ.setOnClickListener(bfP.eak);
                jVar.fNI.setOnClickListener(bfP.eak);
                jVar.fNO.setOnClickListener(bfP.eak);
                jVar.fNO.getHeadView().setOnClickListener(bfP.eak);
                jVar.fNJ.setOnEmotionClickListener(bfP.fXY);
            }
            jVar.fNF.setOnClickListener(this.mCommonClickListener);
            jVar.fNJ.setOnLongClickListener(this.aOZ);
            jVar.fNJ.setOnImageClickListener(this.bnD);
            jVar.fNJ.setOnClickListener(this.mCommonClickListener);
            jVar.getView().setOnClickListener(this.mCommonClickListener);
            jVar.fNG.setOnClickListener(this.gbk);
            jVar.fNH.setOnClickListener(this.gbk);
            jVar.fNR.setOnClickListener(this.mCommonClickListener);
            jVar.fNS.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bnD = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aOZ = onLongClickListener;
    }

    public void aa(bb bbVar) {
        this.aAQ = bbVar;
    }
}
