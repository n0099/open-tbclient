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
/* loaded from: classes6.dex */
public class b extends a<PostData, l> {
    protected bj Ki;
    private int Wq;
    private View.OnClickListener ahD;
    private TbRichTextView.i dIi;
    private com.baidu.tieba.pb.a.c dmm;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gnZ;
    private com.baidu.adp.lib.d.b<TbImageView> goa;
    private TbRichTextView.c iAo;
    private String iRB;
    private boolean izw;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.Ki = null;
        this.iAo = null;
        this.izw = i.axf().isShowImages();
        this.ahD = null;
        this.dIi = null;
        this.dmm = null;
        this.mOnLongClickListener = null;
        this.gnZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bDw */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.iRA.getPageContext().getPageActivity());
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
        this.goa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aFw */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.iRA.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.coP() != null) {
            this.Wq = newSubPbActivity.coP().cpE();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bB */
    public l b(ViewGroup viewGroup) {
        l lVar = new l(this.iRA.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.Wq);
        lVar.pt(true);
        lVar.iAD.setConstrainLayoutPool(this.gnZ);
        lVar.iAD.setImageViewPool(this.goa);
        d(lVar);
        com.baidu.tieba.pb.pb.b.ciM();
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
        if (lVar.iAS.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) lVar.iAS.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        lVar.iAS.setLayoutParams(layoutParams3);
        lVar.iAC.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ahD.onClick(lVar.getView());
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
            postData2.aAO();
            a(lVar, postData2, view, i);
            b(lVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(lVar, (f) null);
        return view;
    }

    private void b(l lVar, PostData postData) {
        if (lVar != null && lVar.iAu != null) {
            if (aq.equals(this.iRB, postData.getId())) {
                am.setBackgroundColor(lVar.iAu, R.color.cp_other_g);
            } else {
                am.setBackgroundColor(lVar.iAu, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            lVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(lVar, postData, view, i, this.iRA, this.Ki);
            com.baidu.tieba.pb.pb.b.a(lVar, postData, this.Ki, i);
            com.baidu.tieba.pb.pb.b.a(this.iRA, lVar, postData, view, this.izw, this.mIsFromCDN, i != 0, this.iAo);
            com.baidu.tieba.pb.pb.b.a(this.iRA, lVar, postData, this.Ki);
            com.baidu.tieba.pb.pb.b.a(lVar, postData);
            com.baidu.tieba.pb.pb.b.a(lVar, postData, this.izw);
            i(lVar, postData);
        }
    }

    private void i(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.iAV.setVisibility(postData.kcD ? 0 : 8);
        }
    }

    private void c(l lVar) {
        lVar.iAC.setTextViewOnTouchListener(this.dmm);
        lVar.iAC.setTextViewCheckSelection(false);
    }

    private void b(l lVar) {
        lVar.iAu.setOnLongClickListener(this.mOnLongClickListener);
        if (this.iRA != null && this.iRA.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a ciI = this.iRA.ciI();
            if (ciI != null) {
                lVar.fqP.setOnClickListener(ciI.gLG);
                lVar.iAB.setOnClickListener(ciI.gLG);
                lVar.iAJ.setOnClickListener(ciI.gLG);
                lVar.iAJ.getHeadView().setOnClickListener(ciI.gLG);
                lVar.iAC.setOnEmotionClickListener(ciI.iNF);
            }
            lVar.iAC.setOnLongClickListener(this.mOnLongClickListener);
            lVar.iAC.setOnImageClickListener(this.dIi);
            lVar.iAC.setOnClickListener(this.ahD);
            lVar.getView().setOnClickListener(this.ahD);
            lVar.iAM.setOnClickListener(this.ahD);
            lVar.iAN.setOnClickListener(this.ahD);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIi = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bj bjVar) {
        this.Ki = bjVar;
    }

    public void FV(String str) {
        this.iRB = str;
    }
}
