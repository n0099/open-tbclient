package com.baidu.tieba.pb.pb.sub.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PostDisPraiseView;
import com.baidu.tbadk.core.view.PostPraiseView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class b extends a<PostData, j> {
    protected bg XS;
    private TbRichTextView.h cAB;
    private com.baidu.tieba.pb.a.c cbY;
    private View.OnLongClickListener cdd;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdW;
    private com.baidu.adp.lib.e.b<TbImageView> fdX;
    private String hDx;
    private View.OnClickListener hDy;
    private TbRichTextView.c hpM;
    private boolean hpm;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    public b(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
        this.XS = null;
        this.hpM = null;
        this.hpm = i.Wy().WC();
        this.mHostId = null;
        this.mCommonClickListener = null;
        this.cAB = null;
        this.cbY = null;
        this.cdd = null;
        this.fdW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beI */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.hDw.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.fdX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: afb */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.hDw.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0277d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.hDy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view instanceof PostDisPraiseView) {
                    PostDisPraiseView postDisPraiseView = (PostDisPraiseView) view;
                    postDisPraiseView.aF(postDisPraiseView);
                } else if (view instanceof PostPraiseView) {
                    PostPraiseView postPraiseView = (PostPraiseView) view;
                    postPraiseView.aF(postPraiseView);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public j onCreateViewHolder(ViewGroup viewGroup) {
        j jVar = new j(this.hDw.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.nt(true);
        jVar.hqc.setConstrainLayoutPool(this.fdW);
        jVar.hqc.setImageViewPool(this.fdX);
        d(jVar);
        com.baidu.tieba.pb.pb.b.a(jVar, (com.baidu.tieba.pb.data.d) null);
        return jVar;
    }

    private void d(final j jVar) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        if (jVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) jVar.mBottomLine.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(d.e.tbds1);
        layoutParams.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(d.e.tbds180);
        jVar.mBottomLine.setLayoutParams(layoutParams);
        ColumnLayout columnLayout = (ColumnLayout) jVar.getView().findViewById(d.g.item_head_owner_root);
        if (columnLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) columnLayout.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams2.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(d.e.tbds31);
        layoutParams2.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(d.e.tbds1);
        columnLayout.setLayoutParams(layoutParams2);
        if (jVar.hqr.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) jVar.hqr.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(d.e.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(d.e.tbds2);
        jVar.hqr.setLayoutParams(layoutParams3);
        jVar.hqb.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
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
            postData2.ZV();
            a(jVar, postData2, view, i);
            b(jVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(jVar, (com.baidu.tieba.pb.data.d) null);
        return view;
    }

    private void b(j jVar, PostData postData) {
        if (jVar != null && ap.equals(this.hDx, postData.getId())) {
            al.l(jVar.hpS, d.C0277d.cp_other_g);
        } else {
            jVar.hpS.setBackgroundDrawable(null);
        }
    }

    private void a(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            jVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(jVar, postData, view, i, this.hDw, this.XS);
            com.baidu.tieba.pb.pb.b.a(jVar, postData, this.XS, i);
            com.baidu.tieba.pb.pb.b.a(this.hDw, jVar, postData, view, this.hpm, this.mIsFromCDN, i != 0, this.hpM);
            com.baidu.tieba.pb.pb.b.a(this.hDw, jVar, postData);
            com.baidu.tieba.pb.pb.b.a(jVar, postData);
            com.baidu.tieba.pb.pb.b.a(jVar, postData, this.hpm);
            i(jVar, postData);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hqu.setVisibility(postData.iGT ? 0 : 8);
        }
    }

    private void h(PostData postData) {
    }

    private void c(j jVar) {
        jVar.hqb.setTextViewOnTouchListener(this.cbY);
        jVar.hqb.setTextViewCheckSelection(false);
    }

    private void b(j jVar) {
        jVar.hpS.setOnLongClickListener(this.cdd);
        if (this.hDw != null && this.hDw.getPageContext().getOrignalPage() != null) {
            com.baidu.tieba.pb.pb.main.b.a bIP = this.hDw.bIP();
            if (bIP != null) {
                jVar.dZu.setOnClickListener(bIP.fAj);
                jVar.hqa.setOnClickListener(bIP.fAj);
                jVar.hqi.setOnClickListener(bIP.fAj);
                jVar.hqi.getHeadView().setOnClickListener(bIP.fAj);
                jVar.hqb.setOnEmotionClickListener(bIP.hAh);
            }
            jVar.hqb.setOnLongClickListener(this.cdd);
            jVar.hqb.setOnImageClickListener(this.cAB);
            jVar.hqb.setOnClickListener(this.mCommonClickListener);
            jVar.getView().setOnClickListener(this.mCommonClickListener);
            jVar.hql.setOnClickListener(this.mCommonClickListener);
            jVar.hqm.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAB = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdd = onLongClickListener;
    }

    public void aj(bg bgVar) {
        this.XS = bgVar;
    }

    public void Ap(String str) {
        this.hDx = str;
    }
}
