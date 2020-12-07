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
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iZp;
    private com.baidu.adp.lib.d.b<TbImageView> iZq;
    public com.baidu.tieba.pb.pb.main.b.c lDT;
    private boolean lEu;
    private TbRichTextView.c lFj;
    private boolean lFl;
    private boolean lHP;
    private String lYp;
    private boolean lYq;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.ahA = null;
        this.lFj = null;
        this.lEu = k.blV().isShowImages();
        this.bbH = null;
        this.fNk = null;
        this.fos = null;
        this.mOnLongClickListener = null;
        this.lHP = com.baidu.tbadk.a.d.bkr();
        this.lFl = com.baidu.tbadk.a.d.bks();
        this.lYq = com.baidu.tbadk.a.d.bkm();
        this.iZp = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cEO */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.lYo.getPageContext().getPageActivity());
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
        this.iZq = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bvP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.lYo.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.dun() != null) {
            this.aLC = newSubPbActivity.dun().dve();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ch */
    public n c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
        n nVar = new n(this.lYo.getPageContext(), inflate, this.aLC, this.lFl);
        nVar.uK(true);
        nVar.lFB.setConstrainLayoutPool(this.iZp);
        nVar.lFB.setImageViewPool(this.iZq);
        e(nVar);
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.lHP);
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
        if (this.lHP) {
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
        nVar.lFA.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
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
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.lHP);
        nVar.mBottomLine.setVisibility(i == 0 ? 8 : 0);
        return view;
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.lFs != null) {
            if (au.equals(this.lYp, postData.getId())) {
                ap.setBackgroundColor(nVar.lFs, R.color.CAM_X0313);
            } else {
                ap.setBackgroundColor(nVar.lFs, R.color.CAM_X0205);
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(nVar, postData, view, i, this.lYo, this.ahA, this.lHP);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.ahA, i, this.lHP);
            if (this.lHP && postData.nmE) {
                nVar.lFC.setVisibility(8);
                nVar.lFH.setVisibility(0);
                if (this.ahA.bnz()) {
                    nVar.lFV.setVisibility(8);
                } else {
                    nVar.lFV.setVisibility(0);
                }
            } else {
                nVar.lFH.setVisibility(8);
                nVar.lFC.setVisibility(0);
                nVar.lFG.setVisibility(0);
                nVar.jYm.setVisibility(0);
                nVar.lFy.setVisibility(0);
                nVar.lFV.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(nVar, postData, postData.nmE, this.lHP);
            com.baidu.tieba.pb.pb.b.a(this.lYo, nVar, postData, view, this.lEu, this.lYq, this.mIsFromCDN, i != 0, this.lFj);
            com.baidu.tieba.pb.pb.b.a(this.lYo, nVar, postData, this.ahA);
            com.baidu.tieba.pb.pb.b.a(nVar, postData);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.lEu);
            j(nVar, postData);
        }
    }

    private void j(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.lGf.setVisibility(postData.nmA ? 0 : 8);
        }
    }

    private void c(n nVar) {
        nVar.lFA.setTextViewOnTouchListener(this.fos);
        nVar.lFA.setTextViewCheckSelection(false);
    }

    private void a(n nVar, PostData postData, int i) {
        if (this.lHP) {
            if (nVar.lFJ != null) {
                SparseArray sparseArray = (SparseArray) nVar.lFJ.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.lFJ.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.lFI != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.lFI.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.lFI.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (nVar.lFG != null) {
            SparseArray sparseArray3 = (SparseArray) nVar.lFG.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                nVar.lFG.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (nVar.jYm != null) {
            SparseArray sparseArray4 = (SparseArray) nVar.jYm.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                nVar.jYm.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.nmE));
        }
    }

    private void b(final n nVar) {
        nVar.lFs.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lYo != null && this.lYo.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a dob = this.lYo.dob();
            if (dob != null) {
                nVar.hPL.setOnClickListener(dob.iCq);
                nVar.lFz.setOnClickListener(dob.iCq);
                nVar.lFS.setOnClickListener(dob.iCq);
                nVar.lFS.getHeadView().setOnClickListener(dob.iCq);
                nVar.lFA.setOnEmotionClickListener(dob.lUm);
            }
            nVar.lFA.setOnLongClickListener(this.mOnLongClickListener);
            nVar.lFA.setOnImageClickListener(this.fNk);
            nVar.lFA.setOnClickListener(this.bbH);
            nVar.getView().setOnClickListener(this.bbH);
            nVar.lFW.setOnClickListener(this.bbH);
            nVar.lFX.setOnClickListener(this.bbH);
            if (this.lDT == null) {
                this.lDT = new com.baidu.tieba.pb.pb.main.b.c(this.lYo.getPageContext());
            }
            if (this.lHP) {
                nVar.lFJ.setOnClickListener(this.bbH);
                nVar.lFI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lFs != null && b.this.lDT != null) {
                                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.lDT.lUB.a(null, b.this.ahA, postData, nVar.lFA.getLayoutStrategy());
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
                nVar.lFP.eXr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.ahA != null && nVar != null && nVar.lFP != null && nVar.lFP.getData() != null) {
                            int i = view == nVar.lFP.getImgAgree() ? 1 : 2;
                            String id = b.this.ahA.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.ahA.getNid();
                            }
                            TiebaStatic.log(new ar("c13700").dY("tid", id).w("fid", b.this.ahA.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", nVar.lFP.getData().postId).al("obj_source", 1).al("obj_type", i));
                        }
                    }
                };
            }
            nVar.lFG.setOnClickListener(this.bbH);
            nVar.jYm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lFs != null && b.this.lDT != null) {
                            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.lDT.lUB.a(null, b.this.ahA, postData, nVar.lFA.getLayoutStrategy());
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
            nVar.lFy.eXr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.ahA != null && nVar != null && nVar.lFy != null && nVar.lFy.getData() != null) {
                        int i = view == nVar.lFy.getImgAgree() ? 1 : 2;
                        String id = b.this.ahA.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.ahA.getNid();
                        }
                        TiebaStatic.log(new ar("c13700").dY("tid", id).w("fid", b.this.ahA.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", nVar.lFy.getData().postId).al("obj_source", 1).al("obj_type", i));
                    }
                }
            };
            if (this.lHP) {
                nVar.lFV.setOnClickListener(this.bbH);
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
        this.lYp = str;
    }
}
