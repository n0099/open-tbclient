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
    protected bg XR;
    private TbRichTextView.h cAE;
    private com.baidu.tieba.pb.a.c cbY;
    private View.OnLongClickListener cdd;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdX;
    private com.baidu.adp.lib.e.b<TbImageView> fdY;
    private String hDD;
    private View.OnClickListener hDE;
    private TbRichTextView.c hpT;
    private boolean hpt;
    private View.OnClickListener mCommonClickListener;
    private String mHostId;

    public b(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
        this.XR = null;
        this.hpT = null;
        this.hpt = i.Wy().WC();
        this.mHostId = null;
        this.mCommonClickListener = null;
        this.cAE = null;
        this.cbY = null;
        this.cdd = null;
        this.fdX = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beJ */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.hDC.getPageContext().getPageActivity());
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
        this.fdY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: afb */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.hDC.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0236d.common_color_10043));
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
        this.hDE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
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
        j jVar = new j(this.hDC.getPageContext(), LayoutInflater.from(this.mContext).inflate(d.h.pb_reply_floor_item_layout, viewGroup, false));
        jVar.nt(true);
        jVar.hqj.setConstrainLayoutPool(this.fdX);
        jVar.hqj.setImageViewPool(this.fdY);
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
        if (jVar.hqy.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) jVar.hqy.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(d.e.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(d.e.tbds2);
        jVar.hqy.setLayoutParams(layoutParams3);
        jVar.hqi.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
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
        if (jVar != null && ap.equals(this.hDD, postData.getId())) {
            al.l(jVar.hpZ, d.C0236d.cp_other_g);
        } else {
            jVar.hpZ.setBackgroundDrawable(null);
        }
    }

    private void a(j jVar, PostData postData, View view, int i) {
        if (jVar != null && postData != null) {
            jVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(jVar, postData, view, i, this.hDC, this.XR);
            com.baidu.tieba.pb.pb.b.a(jVar, postData, this.XR, i);
            com.baidu.tieba.pb.pb.b.a(this.hDC, jVar, postData, view, this.hpt, this.mIsFromCDN, i != 0, this.hpT);
            com.baidu.tieba.pb.pb.b.a(this.hDC, jVar, postData);
            com.baidu.tieba.pb.pb.b.a(jVar, postData);
            com.baidu.tieba.pb.pb.b.a(jVar, postData, this.hpt);
            i(jVar, postData);
        }
    }

    private void i(j jVar, PostData postData) {
        if (jVar != null && postData != null) {
            jVar.hqB.setVisibility(postData.iHb ? 0 : 8);
        }
    }

    private void h(PostData postData) {
    }

    private void c(j jVar) {
        jVar.hqi.setTextViewOnTouchListener(this.cbY);
        jVar.hqi.setTextViewCheckSelection(false);
    }

    private void b(j jVar) {
        jVar.hpZ.setOnLongClickListener(this.cdd);
        if (this.hDC != null && this.hDC.getPageContext().getOrignalPage() != null) {
            com.baidu.tieba.pb.pb.main.b.a bIQ = this.hDC.bIQ();
            if (bIQ != null) {
                jVar.dZy.setOnClickListener(bIQ.fAk);
                jVar.hqh.setOnClickListener(bIQ.fAk);
                jVar.hqp.setOnClickListener(bIQ.fAk);
                jVar.hqp.getHeadView().setOnClickListener(bIQ.fAk);
                jVar.hqi.setOnEmotionClickListener(bIQ.hAn);
            }
            jVar.hqi.setOnLongClickListener(this.cdd);
            jVar.hqi.setOnImageClickListener(this.cAE);
            jVar.hqi.setOnClickListener(this.mCommonClickListener);
            jVar.getView().setOnClickListener(this.mCommonClickListener);
            jVar.hqs.setOnClickListener(this.mCommonClickListener);
            jVar.hqt.setOnClickListener(this.mCommonClickListener);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAE = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdd = onLongClickListener;
    }

    public void aj(bg bgVar) {
        this.XR = bgVar;
    }

    public void Ar(String str) {
        this.hDD = str;
    }
}
