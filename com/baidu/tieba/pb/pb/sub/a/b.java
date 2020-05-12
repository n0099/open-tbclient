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
    private View.OnClickListener aDi;
    protected bj adJ;
    private int aqV;
    private com.baidu.tieba.pb.a.c dRm;
    private TbRichTextView.i emX;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hdt;
    private com.baidu.adp.lib.d.b<TbImageView> hdu;
    private String jIz;
    private boolean jqH;
    private TbRichTextView.c jrw;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.adJ = null;
        this.jrw = null;
        this.jqH = i.aIc().isShowImages();
        this.aDi = null;
        this.emX = null;
        this.dRm = null;
        this.mOnLongClickListener = null;
        this.hdt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bQP */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.jIy.getPageContext().getPageActivity());
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
        this.hdu = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aQE */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.jIy.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.cCq() != null) {
            this.aqV = newSubPbActivity.cCq().cDf();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public k b(ViewGroup viewGroup) {
        k kVar = new k(this.jIy.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aqV);
        kVar.qS(true);
        kVar.jrL.setConstrainLayoutPool(this.hdt);
        kVar.jrL.setImageViewPool(this.hdu);
        d(kVar);
        com.baidu.tieba.pb.pb.b.cwu();
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
        if (kVar.jsa.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) kVar.jsa.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        kVar.jsa.setLayoutParams(layoutParams3);
        kVar.jrK.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && kVar.getView() != null) {
                    kVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aDi.onClick(kVar.getView());
                if (view != null) {
                    view.setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
                if (kVar.getView() != null) {
                    kVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
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
            postData2.aLL();
            a(kVar, postData2, view, i);
            b(kVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(kVar, (e) null);
        return view;
    }

    private void b(k kVar, PostData postData) {
        if (kVar != null && kVar.jrC != null) {
            if (aq.equals(this.jIz, postData.getId())) {
                am.setBackgroundColor(kVar.jrC, R.color.cp_other_g);
            } else {
                am.setBackgroundColor(kVar.jrC, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(k kVar, PostData postData, View view, int i) {
        if (kVar != null && postData != null) {
            kVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(kVar, postData, view, i, this.jIy, this.adJ);
            com.baidu.tieba.pb.pb.b.a(kVar, postData, this.adJ, i);
            com.baidu.tieba.pb.pb.b.a(this.jIy, kVar, postData, view, this.jqH, this.mIsFromCDN, i != 0, this.jrw);
            com.baidu.tieba.pb.pb.b.a(this.jIy, kVar, postData, this.adJ);
            com.baidu.tieba.pb.pb.b.a(kVar, postData);
            com.baidu.tieba.pb.pb.b.a(kVar, postData, this.jqH);
            i(kVar, postData);
        }
    }

    private void i(k kVar, PostData postData) {
        if (kVar != null && postData != null) {
            kVar.jsd.setVisibility(postData.kTn ? 0 : 8);
        }
    }

    private void c(k kVar) {
        kVar.jrK.setTextViewOnTouchListener(this.dRm);
        kVar.jrK.setTextViewCheckSelection(false);
    }

    private void b(k kVar) {
        kVar.jrC.setOnLongClickListener(this.mOnLongClickListener);
        if (this.jIy != null && this.jIy.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a cwq = this.jIy.cwq();
            if (cwq != null) {
                kVar.gbZ.setOnClickListener(cwq.gHY);
                kVar.jrJ.setOnClickListener(cwq.gHY);
                kVar.jrR.setOnClickListener(cwq.gHY);
                kVar.jrR.getHeadView().setOnClickListener(cwq.gHY);
                kVar.jrK.setOnEmotionClickListener(cwq.jEG);
            }
            kVar.jrK.setOnLongClickListener(this.mOnLongClickListener);
            kVar.jrK.setOnImageClickListener(this.emX);
            kVar.jrK.setOnClickListener(this.aDi);
            kVar.getView().setOnClickListener(this.aDi);
            kVar.jrU.setOnClickListener(this.aDi);
            kVar.jrV.setOnClickListener(this.aDi);
        }
    }

    public void z(View.OnClickListener onClickListener) {
        this.aDi = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emX = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bj bjVar) {
        this.adJ = bjVar;
    }

    public void If(String str) {
        this.jIz = str;
    }
}
