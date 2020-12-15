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
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class b extends a<PostData, n> {
    private int aLC;
    protected by ahA;
    private View.OnClickListener bbH;
    private TbRichTextView.i fNk;
    private com.baidu.tieba.pb.a.c fos;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iZr;
    private com.baidu.adp.lib.d.b<TbImageView> iZs;
    public com.baidu.tieba.pb.pb.main.b.c lDV;
    private boolean lEw;
    private TbRichTextView.c lFl;
    private boolean lFn;
    private boolean lHR;
    private String lYr;
    private boolean lYs;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.ahA = null;
        this.lFl = null;
        this.lEw = k.blV().isShowImages();
        this.bbH = null;
        this.fNk = null;
        this.fos = null;
        this.mOnLongClickListener = null;
        this.lHR = com.baidu.tbadk.a.d.bkr();
        this.lFn = com.baidu.tbadk.a.d.bks();
        this.lYs = com.baidu.tbadk.a.d.bkm();
        this.iZr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cEP */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.lYq.getPageContext().getPageActivity());
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
        this.iZs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bvP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.lYq.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.duo() != null) {
            this.aLC = newSubPbActivity.duo().dvf();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ch */
    public n c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
        n nVar = new n(this.lYq.getPageContext(), inflate, this.aLC, this.lFn);
        nVar.uK(true);
        nVar.lFD.setConstrainLayoutPool(this.iZr);
        nVar.lFD.setImageViewPool(this.iZs);
        e(nVar);
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.lHR);
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
        if (this.lHR) {
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
        nVar.lFC.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && nVar.getView() != null) {
                    nVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.bbH.onClick(nVar.getView());
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
            postData2.bqd();
            a(nVar, postData2, view, i);
            b(nVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.lHR);
        nVar.mBottomLine.setVisibility(i == 0 ? 8 : 0);
        return view;
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.lFu != null) {
            if (au.equals(this.lYr, postData.getId())) {
                ap.setBackgroundColor(nVar.lFu, R.color.CAM_X0313);
            } else {
                ap.setBackgroundColor(nVar.lFu, R.color.CAM_X0205);
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(nVar, postData, view, i, this.lYq, this.ahA, this.lHR);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.ahA, i, this.lHR);
            if (this.lHR && postData.nmG) {
                nVar.lFE.setVisibility(8);
                nVar.lFJ.setVisibility(0);
                if (this.ahA.bnz()) {
                    nVar.lFX.setVisibility(8);
                } else {
                    nVar.lFX.setVisibility(0);
                }
            } else {
                nVar.lFJ.setVisibility(8);
                nVar.lFE.setVisibility(0);
                nVar.lFI.setVisibility(0);
                nVar.jYo.setVisibility(0);
                nVar.lFA.setVisibility(0);
                nVar.lFX.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(nVar, postData, postData.nmG, this.lHR);
            com.baidu.tieba.pb.pb.b.a(this.lYq, nVar, postData, view, this.lEw, this.lYs, this.mIsFromCDN, i != 0, this.lFl);
            com.baidu.tieba.pb.pb.b.a(this.lYq, nVar, postData, this.ahA);
            com.baidu.tieba.pb.pb.b.a(nVar, postData);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.lEw);
            j(nVar, postData);
        }
    }

    private void j(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.lGh.setVisibility(postData.nmC ? 0 : 8);
        }
    }

    private void c(n nVar) {
        nVar.lFC.setTextViewOnTouchListener(this.fos);
        nVar.lFC.setTextViewCheckSelection(false);
    }

    private void a(n nVar, PostData postData, int i) {
        if (this.lHR) {
            if (nVar.lFL != null) {
                SparseArray sparseArray = (SparseArray) nVar.lFL.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.lFL.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.lFK != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.lFK.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.lFK.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (nVar.lFI != null) {
            SparseArray sparseArray3 = (SparseArray) nVar.lFI.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                nVar.lFI.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (nVar.jYo != null) {
            SparseArray sparseArray4 = (SparseArray) nVar.jYo.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                nVar.jYo.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.nmG));
        }
    }

    private void b(final n nVar) {
        nVar.lFu.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lYq != null && this.lYq.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a doc = this.lYq.doc();
            if (doc != null) {
                nVar.hPN.setOnClickListener(doc.iCs);
                nVar.lFB.setOnClickListener(doc.iCs);
                nVar.lFU.setOnClickListener(doc.iCs);
                nVar.lFU.getHeadView().setOnClickListener(doc.iCs);
                nVar.lFC.setOnEmotionClickListener(doc.lUo);
            }
            nVar.lFC.setOnLongClickListener(this.mOnLongClickListener);
            nVar.lFC.setOnImageClickListener(this.fNk);
            nVar.lFC.setOnClickListener(this.bbH);
            nVar.getView().setOnClickListener(this.bbH);
            nVar.lFY.setOnClickListener(this.bbH);
            nVar.lFZ.setOnClickListener(this.bbH);
            if (this.lDV == null) {
                this.lDV = new com.baidu.tieba.pb.pb.main.b.c(this.lYq.getPageContext());
            }
            if (this.lHR) {
                nVar.lFL.setOnClickListener(this.bbH);
                nVar.lFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lFu != null && b.this.lDV != null) {
                                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.lDV.lUD.a(null, b.this.ahA, postData, nVar.lFC.getLayoutStrategy());
                                    }
                                }, 100L);
                                String id = b.this.ahA.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.ahA.getNid();
                                }
                                TiebaStatic.log(new ar("c13700").dY("tid", id).w("fid", b.this.ahA.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", postData.getId()).al("obj_source", 1).al("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.lFR.eXr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.ahA != null && nVar != null && nVar.lFR != null && nVar.lFR.getData() != null) {
                            int i = view == nVar.lFR.getImgAgree() ? 1 : 2;
                            String id = b.this.ahA.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.ahA.getNid();
                            }
                            TiebaStatic.log(new ar("c13700").dY("tid", id).w("fid", b.this.ahA.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", nVar.lFR.getData().postId).al("obj_source", 1).al("obj_type", i));
                        }
                    }
                };
            }
            nVar.lFI.setOnClickListener(this.bbH);
            nVar.jYo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lFu != null && b.this.lDV != null) {
                            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.lDV.lUD.a(null, b.this.ahA, postData, nVar.lFC.getLayoutStrategy());
                                }
                            }, 100L);
                            String id = b.this.ahA.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.ahA.getNid();
                            }
                            TiebaStatic.log(new ar("c13700").dY("tid", id).w("fid", b.this.ahA.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", postData.getId()).al("obj_source", 1).al("obj_type", 4));
                        }
                    }
                }
            });
            nVar.lFA.eXr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.ahA != null && nVar != null && nVar.lFA != null && nVar.lFA.getData() != null) {
                        int i = view == nVar.lFA.getImgAgree() ? 1 : 2;
                        String id = b.this.ahA.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.ahA.getNid();
                        }
                        TiebaStatic.log(new ar("c13700").dY("tid", id).w("fid", b.this.ahA.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", nVar.lFA.getData().postId).al("obj_source", 1).al("obj_type", i));
                    }
                }
            };
            if (this.lHR) {
                nVar.lFX.setOnClickListener(this.bbH);
            }
        }
    }

    public void B(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fNk = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(by byVar) {
        this.ahA = byVar;
    }

    public void QL(String str) {
        this.lYr = str;
    }
}
