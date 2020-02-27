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
    private View.OnClickListener akt;
    private TbRichTextView.i dMw;
    private com.baidu.tieba.pb.a.c dqJ;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gtj;
    private com.baidu.adp.lib.d.b<TbImageView> gtk;
    private boolean iEH;
    private TbRichTextView.c iFw;
    private String iWy;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.KJ = null;
        this.iFw = null;
        this.iEH = i.azM().isShowImages();
        this.akt = null;
        this.dMw = null;
        this.dqJ = null;
        this.mOnLongClickListener = null;
        this.gtj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bGa */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.iWx.getPageContext().getPageActivity());
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
        this.gtk = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aIe */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.iWx.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.cro() != null) {
            this.Yv = newSubPbActivity.cro().csd();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public k b(ViewGroup viewGroup) {
        k kVar = new k(this.iWx.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.Yv);
        kVar.pI(true);
        kVar.iFL.setConstrainLayoutPool(this.gtj);
        kVar.iFL.setImageViewPool(this.gtk);
        d(kVar);
        com.baidu.tieba.pb.pb.b.cls();
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
        if (kVar.iGa.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) kVar.iGa.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        kVar.iGa.setLayoutParams(layoutParams3);
        kVar.iFK.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.akt.onClick(kVar.getView());
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
            postData2.aDu();
            a(kVar, postData2, view, i);
            b(kVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(kVar, (e) null);
        return view;
    }

    private void b(k kVar, PostData postData) {
        if (kVar != null && kVar.iFC != null) {
            if (aq.equals(this.iWy, postData.getId())) {
                am.setBackgroundColor(kVar.iFC, R.color.cp_other_g);
            } else {
                am.setBackgroundColor(kVar.iFC, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            kVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(kVar, postData, view, i, this.iWx, this.KJ);
            com.baidu.tieba.pb.pb.b.a(kVar, postData, this.KJ, i);
            com.baidu.tieba.pb.pb.b.a(this.iWx, kVar, postData, view, this.iEH, this.mIsFromCDN, i != 0, this.iFw);
            com.baidu.tieba.pb.pb.b.a(this.iWx, kVar, postData, this.KJ);
            com.baidu.tieba.pb.pb.b.a(kVar, postData);
            com.baidu.tieba.pb.pb.b.a(kVar, postData, this.iEH);
            i(kVar, postData);
        }
    }

    private void i(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.iGd.setVisibility(postData.khm ? 0 : 8);
        }
    }

    private void c(k kVar) {
        kVar.iFK.setTextViewOnTouchListener(this.dqJ);
        kVar.iFK.setTextViewCheckSelection(false);
    }

    private void b(k kVar) {
        kVar.iFC.setOnLongClickListener(this.mOnLongClickListener);
        if (this.iWx != null && this.iWx.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a clo = this.iWx.clo();
            if (clo != null) {
                kVar.fwA.setOnClickListener(clo.gQU);
                kVar.iFJ.setOnClickListener(clo.gQU);
                kVar.iFR.setOnClickListener(clo.gQU);
                kVar.iFR.getHeadView().setOnClickListener(clo.gQU);
                kVar.iFK.setOnEmotionClickListener(clo.iSE);
            }
            kVar.iFK.setOnLongClickListener(this.mOnLongClickListener);
            kVar.iFK.setOnImageClickListener(this.dMw);
            kVar.iFK.setOnClickListener(this.akt);
            kVar.getView().setOnClickListener(this.akt);
            kVar.iFU.setOnClickListener(this.akt);
            kVar.iFV.setOnClickListener(this.akt);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMw = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bj bjVar) {
        this.KJ = bjVar;
    }

    public void Gu(String str) {
        this.iWy = str;
    }
}
