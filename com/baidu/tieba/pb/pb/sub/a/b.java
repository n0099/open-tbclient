package com.baidu.tieba.pb.pb.sub.a;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes21.dex */
public class b extends a<PostData, n> {
    private int aIJ;
    private View.OnClickListener aYm;
    protected bx agB;
    private TbRichTextView.i fFy;
    private com.baidu.tieba.pb.a.c fgS;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iOy;
    private com.baidu.adp.lib.d.b<TbImageView> iOz;
    private String lKs;
    private boolean lqL;
    public com.baidu.tieba.pb.pb.main.b.c lqk;
    private TbRichTextView.c lrB;
    private boolean lrD;
    private boolean lrE;
    private boolean lrF;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.agB = null;
        this.lrB = null;
        this.lqL = k.biL().isShowImages();
        this.aYm = null;
        this.fFy = null;
        this.fgS = null;
        this.mOnLongClickListener = null;
        this.lrD = com.baidu.tbadk.a.d.bhn();
        this.lrE = com.baidu.tbadk.a.d.bho();
        this.lrF = com.baidu.tbadk.a.d.bhi();
        this.iOy = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cAy */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.lKr.getPageContext().getPageActivity());
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
        this.iOz = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bsp */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.lKr.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ap.getColor(R.color.common_color_10043));
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
        if (newSubPbActivity != null && newSubPbActivity.doW() != null) {
            this.aIJ = newSubPbActivity.doW().dpN();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ce */
    public n c(ViewGroup viewGroup) {
        n nVar = new n(this.lKr.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aIJ, this.lrD, this.lrE);
        nVar.ui(true);
        nVar.lrW.setConstrainLayoutPool(this.iOy);
        nVar.lrW.setImageViewPool(this.iOz);
        e(nVar);
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.lrD);
        return nVar;
    }

    private void e(final n nVar) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds148);
        if (this.lrD) {
            layoutParams.topMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds0);
        }
        nVar.mBottomLine.setLayoutParams(layoutParams);
        ColumnLayout columnLayout = (ColumnLayout) nVar.getView().findViewById(R.id.item_head_owner_root);
        if (columnLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) columnLayout.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams2.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds21);
        layoutParams2.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds1);
        columnLayout.setLayoutParams(layoutParams2);
        nVar.lrV.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && nVar.getView() != null) {
                    nVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aYm.onClick(nVar.getView());
                if (view != null) {
                    view.setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
                if (nVar.getView() != null) {
                    nVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.sub.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, n nVar) {
        a(nVar, postData, i);
        b(nVar);
        c(nVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.bmQ();
            a(nVar, postData2, view, i);
            b(nVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.lrD);
        nVar.mBottomLine.setVisibility(i == 0 ? 8 : 0);
        return view;
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.lrN != null) {
            if (au.equals(this.lKs, postData.getId())) {
                ap.setBackgroundColor(nVar.lrN, R.color.CAM_X0313);
            } else {
                ap.setBackgroundColor(nVar.lrN, R.color.CAM_X0205);
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(nVar, postData, view, i, this.lKr, this.agB, this.lrD);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.agB, i, this.lrD);
            if (this.lrD && postData.mYG) {
                nVar.lrX.setVisibility(8);
                nVar.lsc.setVisibility(0);
                if (this.agB.bkm()) {
                    nVar.lsq.setVisibility(8);
                } else {
                    nVar.lsq.setVisibility(0);
                }
            } else {
                nVar.lsc.setVisibility(8);
                nVar.lrX.setVisibility(0);
                nVar.lsb.setVisibility(0);
                nVar.jKJ.setVisibility(0);
                nVar.lrT.setVisibility(0);
                nVar.lsq.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(nVar, postData, postData.mYG, this.lrD);
            com.baidu.tieba.pb.pb.b.a(this.lKr, nVar, postData, view, this.lqL, this.lrF, this.mIsFromCDN, i != 0, this.lrB);
            com.baidu.tieba.pb.pb.b.a(this.lKr, nVar, postData, this.agB);
            com.baidu.tieba.pb.pb.b.a(nVar, postData);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.lqL);
            i(nVar, postData);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.lsA.setVisibility(postData.mYC ? 0 : 8);
        }
    }

    private void c(n nVar) {
        nVar.lrV.setTextViewOnTouchListener(this.fgS);
        nVar.lrV.setTextViewCheckSelection(false);
    }

    private void a(n nVar, PostData postData, int i) {
        if (this.lrD) {
            if (nVar.lse != null) {
                SparseArray sparseArray = (SparseArray) nVar.lse.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.lse.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.lsd != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.lsd.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.lsd.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (nVar.lsb != null) {
            SparseArray sparseArray3 = (SparseArray) nVar.lsb.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                nVar.lsb.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (nVar.jKJ != null) {
            SparseArray sparseArray4 = (SparseArray) nVar.jKJ.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                nVar.jKJ.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.mYG));
        }
    }

    private void b(final n nVar) {
        nVar.lrN.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lKr != null && this.lKr.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a diM = this.lKr.diM();
            if (diM != null) {
                nVar.hGe.setOnClickListener(diM.iry);
                nVar.lrU.setOnClickListener(diM.iry);
                nVar.lsn.setOnClickListener(diM.iry);
                nVar.lsn.getHeadView().setOnClickListener(diM.iry);
                nVar.lrV.setOnEmotionClickListener(diM.lGt);
            }
            nVar.lrV.setOnLongClickListener(this.mOnLongClickListener);
            nVar.lrV.setOnImageClickListener(this.fFy);
            nVar.lrV.setOnClickListener(this.aYm);
            nVar.getView().setOnClickListener(this.aYm);
            nVar.lsr.setOnClickListener(this.aYm);
            nVar.lss.setOnClickListener(this.aYm);
            if (this.lqk == null) {
                this.lqk = new com.baidu.tieba.pb.pb.main.b.c(this.lKr.getPageContext());
            }
            if (this.lrD) {
                nVar.lse.setOnClickListener(this.aYm);
                nVar.lsd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lrN != null && b.this.lqk != null) {
                                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.lqk.lGI.a(null, b.this.agB, postData, nVar.lrV.getLayoutStrategy());
                                    }
                                }, 100L);
                                String id = b.this.agB.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.agB.getNid();
                                }
                                TiebaStatic.log(new ar("c13700").dR("tid", id).w("fid", b.this.agB.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).ak("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.lsk.eQc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.agB != null && nVar != null && nVar.lsk != null && nVar.lsk.getData() != null) {
                            int i = view == nVar.lsk.getImgAgree() ? 1 : 2;
                            String id = b.this.agB.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.agB.getNid();
                            }
                            TiebaStatic.log(new ar("c13700").dR("tid", id).w("fid", b.this.agB.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.lsk.getData().postId).ak("obj_type", i));
                        }
                    }
                };
            }
            nVar.lsb.setOnClickListener(this.aYm);
            nVar.jKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lrN != null && b.this.lqk != null) {
                            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.lqk.lGI.a(null, b.this.agB, postData, nVar.lrV.getLayoutStrategy());
                                }
                            }, 100L);
                            String id = b.this.agB.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.agB.getNid();
                            }
                            TiebaStatic.log(new ar("c13700").dR("tid", id).w("fid", b.this.agB.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).ak("obj_type", 4));
                        }
                    }
                }
            });
            nVar.lrT.eQc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.agB != null && nVar != null && nVar.lrT != null && nVar.lrT.getData() != null) {
                        int i = view == nVar.lrT.getImgAgree() ? 1 : 2;
                        String id = b.this.agB.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.agB.getNid();
                        }
                        TiebaStatic.log(new ar("c13700").dR("tid", id).w("fid", b.this.agB.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.lrT.getData().postId).ak("obj_type", i));
                    }
                }
            };
            if (this.lrD) {
                nVar.lsq.setOnClickListener(this.aYm);
            }
        }
    }

    public void B(View.OnClickListener onClickListener) {
        this.aYm = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFy = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bx bxVar) {
        this.agB = bxVar;
    }

    public void PD(String str) {
        this.lKs = str;
    }
}
