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
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes7.dex */
public class b extends a<PostData, l> {
    protected bj Kn;
    private int WJ;
    private View.OnClickListener ain;
    private TbRichTextView.i dIr;
    private com.baidu.tieba.pb.a.c dmA;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gri;
    private com.baidu.adp.lib.d.b<TbImageView> grj;
    private TbRichTextView.c iDS;
    private boolean iDa;
    private String iVj;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.Kn = null;
        this.iDS = null;
        this.iDa = i.axy().isShowImages();
        this.ain = null;
        this.dIr = null;
        this.dmA = null;
        this.mOnLongClickListener = null;
        this.gri = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bEy */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.iVi.getPageContext().getPageActivity());
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
        this.grj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aFP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.iVi.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.cpW() != null) {
            this.WJ = newSubPbActivity.cpW().cqM();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public l b(ViewGroup viewGroup) {
        l lVar = new l(this.iVi.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.WJ);
        lVar.pF(true);
        lVar.iEh.setConstrainLayoutPool(this.gri);
        lVar.iEh.setImageViewPool(this.grj);
        d(lVar);
        com.baidu.tieba.pb.pb.b.cjU();
        com.baidu.tieba.pb.pb.b.a(lVar, (f) null);
        return lVar;
    }

    private void d(final l lVar) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        if (lVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds1);
        layoutParams.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds180);
        lVar.mBottomLine.setLayoutParams(layoutParams);
        ColumnLayout columnLayout = (ColumnLayout) lVar.getView().findViewById(R.id.item_head_owner_root);
        if (columnLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) columnLayout.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams2.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds31);
        layoutParams2.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds1);
        columnLayout.setLayoutParams(layoutParams2);
        if (lVar.iEw.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) lVar.iEw.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        lVar.iEw.setLayoutParams(layoutParams3);
        lVar.iEg.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ain.onClick(lVar.getView());
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.sub.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, l lVar) {
        b(lVar);
        c(lVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.aBh();
            a(lVar, postData2, view, i);
            b(lVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(lVar, (f) null);
        return view;
    }

    private void b(l lVar, PostData postData) {
        if (lVar != null && lVar.iDY != null) {
            if (aq.equals(this.iVj, postData.getId())) {
                am.setBackgroundColor(lVar.iDY, R.color.cp_other_g);
            } else {
                am.setBackgroundColor(lVar.iDY, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            lVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(lVar, postData, view, i, this.iVi, this.Kn);
            com.baidu.tieba.pb.pb.b.a(lVar, postData, this.Kn, i);
            com.baidu.tieba.pb.pb.b.a(this.iVi, lVar, postData, view, this.iDa, this.mIsFromCDN, i != 0, this.iDS);
            com.baidu.tieba.pb.pb.b.a(this.iVi, lVar, postData, this.Kn);
            com.baidu.tieba.pb.pb.b.a(lVar, postData);
            com.baidu.tieba.pb.pb.b.a(lVar, postData, this.iDa);
            i(lVar, postData);
        }
    }

    private void i(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.iEz.setVisibility(postData.kgl ? 0 : 8);
        }
    }

    private void c(l lVar) {
        lVar.iEg.setTextViewOnTouchListener(this.dmA);
        lVar.iEg.setTextViewCheckSelection(false);
    }

    private void b(l lVar) {
        lVar.iDY.setOnLongClickListener(this.mOnLongClickListener);
        if (this.iVi != null && this.iVi.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a cjQ = this.iVi.cjQ();
            if (cjQ != null) {
                lVar.ftZ.setOnClickListener(cjQ.gOU);
                lVar.iEf.setOnClickListener(cjQ.gOU);
                lVar.iEn.setOnClickListener(cjQ.gOU);
                lVar.iEn.getHeadView().setOnClickListener(cjQ.gOU);
                lVar.iEg.setOnEmotionClickListener(cjQ.iRj);
            }
            lVar.iEg.setOnLongClickListener(this.mOnLongClickListener);
            lVar.iEg.setOnImageClickListener(this.dIr);
            lVar.iEg.setOnClickListener(this.ain);
            lVar.getView().setOnClickListener(this.ain);
            lVar.iEq.setOnClickListener(this.ain);
            lVar.iEr.setOnClickListener(this.ain);
        }
    }

    public void x(View.OnClickListener onClickListener) {
        this.ain = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIr = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bj bjVar) {
        this.Kn = bjVar;
    }

    public void Gf(String str) {
        this.iVj = str;
    }
}
