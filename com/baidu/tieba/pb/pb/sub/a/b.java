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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private int aKu;
    private View.OnClickListener aZX;
    protected bw agx;
    private TbRichTextView.i fFW;
    private com.baidu.tieba.pb.a.c fhK;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iNL;
    private com.baidu.adp.lib.d.b<TbImageView> iNM;
    private String lKa;
    public com.baidu.tieba.pb.pb.main.b.c lpV;
    private boolean lqw;
    private TbRichTextView.c lrl;
    private boolean lrn;
    private boolean lro;
    private boolean lrp;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.agx = null;
        this.lrl = null;
        this.lqw = k.bjH().isShowImages();
        this.aZX = null;
        this.fFW = null;
        this.fhK = null;
        this.mOnLongClickListener = null;
        this.lrn = com.baidu.tbadk.a.d.bhV();
        this.lro = com.baidu.tbadk.a.d.bhW();
        this.lrp = com.baidu.tbadk.a.d.bhR();
        this.iNL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cAV */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.lJZ.getPageContext().getPageActivity());
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
        this.iNM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bsZ */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.lJZ.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.dpw() != null) {
            this.aKu = newSubPbActivity.dpw().dqn();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public n c(ViewGroup viewGroup) {
        n nVar = new n(this.lJZ.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aKu, this.lrn, this.lro);
        nVar.uf(true);
        nVar.lrG.setConstrainLayoutPool(this.iNL);
        nVar.lrG.setImageViewPool(this.iNM);
        e(nVar);
        com.baidu.tieba.pb.pb.b.djt();
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.lrn);
        return nVar;
    }

    private void e(final n nVar) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        if (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds180);
        if (this.lrn) {
            layoutParams.topMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds0);
        }
        nVar.mBottomLine.setLayoutParams(layoutParams);
        ColumnLayout columnLayout = (ColumnLayout) nVar.getView().findViewById(R.id.item_head_owner_root);
        if (columnLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) columnLayout.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams2.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds31);
        layoutParams2.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds1);
        columnLayout.setLayoutParams(layoutParams2);
        if (nVar.lsh.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) nVar.lsh.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        nVar.lsh.setLayoutParams(layoutParams3);
        nVar.lrF.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && nVar.getView() != null) {
                    nVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aZX.onClick(nVar.getView());
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
            postData2.bnM();
            a(nVar, postData2, view, i);
            b(nVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.lrn);
        return view;
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.lrx != null) {
            if (at.equals(this.lKa, postData.getId())) {
                ap.setBackgroundColor(nVar.lrx, R.color.cp_other_g);
            } else {
                ap.setBackgroundColor(nVar.lrx, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(nVar, postData, view, i, this.lJZ, this.agx, this.lrn);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.agx, i, this.lrn);
            if (this.lrn && postData.mXO) {
                nVar.lrH.setVisibility(8);
                nVar.lrM.setVisibility(0);
                if (this.agx.blk()) {
                    nVar.lsa.setVisibility(8);
                } else {
                    nVar.lsa.setVisibility(0);
                }
            } else {
                nVar.lrM.setVisibility(8);
                nVar.lrH.setVisibility(0);
                nVar.lrL.setVisibility(0);
                nVar.jJY.setVisibility(0);
                nVar.lrD.setVisibility(0);
                nVar.lsa.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(nVar, postData, postData.mXO, this.lrn);
            com.baidu.tieba.pb.pb.b.a(this.lJZ, nVar, postData, view, this.lqw, this.lrp, this.mIsFromCDN, i != 0, this.lrl);
            com.baidu.tieba.pb.pb.b.a(this.lJZ, nVar, postData, this.agx);
            com.baidu.tieba.pb.pb.b.a(nVar, postData);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.lqw);
            i(nVar, postData);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.lsk.setVisibility(postData.mXK ? 0 : 8);
        }
    }

    private void c(n nVar) {
        nVar.lrF.setTextViewOnTouchListener(this.fhK);
        nVar.lrF.setTextViewCheckSelection(false);
    }

    private void a(n nVar, PostData postData, int i) {
        if (this.lrn) {
            if (nVar.lrO != null) {
                SparseArray sparseArray = (SparseArray) nVar.lrO.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.lrO.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.lrN != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.lrN.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.lrN.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (nVar.lrL != null) {
            SparseArray sparseArray3 = (SparseArray) nVar.lrL.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                nVar.lrL.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (nVar.jJY != null) {
            SparseArray sparseArray4 = (SparseArray) nVar.jJY.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                nVar.jJY.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.mXO));
        }
    }

    private void b(final n nVar) {
        nVar.lrx.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lJZ != null && this.lJZ.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a djp = this.lJZ.djp();
            if (djp != null) {
                nVar.hGx.setOnClickListener(djp.iqL);
                nVar.lrE.setOnClickListener(djp.iqL);
                nVar.lrX.setOnClickListener(djp.iqL);
                nVar.lrX.getHeadView().setOnClickListener(djp.iqL);
                nVar.lrF.setOnEmotionClickListener(djp.lGc);
            }
            nVar.lrF.setOnLongClickListener(this.mOnLongClickListener);
            nVar.lrF.setOnImageClickListener(this.fFW);
            nVar.lrF.setOnClickListener(this.aZX);
            nVar.getView().setOnClickListener(this.aZX);
            nVar.lsb.setOnClickListener(this.aZX);
            nVar.lsc.setOnClickListener(this.aZX);
            if (this.lpV == null) {
                this.lpV = new com.baidu.tieba.pb.pb.main.b.c(this.lJZ.getPageContext());
            }
            if (this.lrn) {
                nVar.lrO.setOnClickListener(this.aZX);
                nVar.lrN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lrx != null && b.this.lpV != null) {
                                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.lpV.lGr.a(null, b.this.agx, postData, nVar.lrF.getLayoutStrategy());
                                    }
                                }, 100L);
                                String id = b.this.agx.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.agx.getNid();
                                }
                                TiebaStatic.log(new aq("c13700").dR("tid", id).w("fid", b.this.agx.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).al("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.lrU.eRb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.agx != null && nVar != null && nVar.lrU != null && nVar.lrU.getData() != null) {
                            int i = view == nVar.lrU.getImgAgree() ? 1 : 2;
                            String id = b.this.agx.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.agx.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dR("tid", id).w("fid", b.this.agx.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.lrU.getData().postId).al("obj_type", i));
                        }
                    }
                };
            }
            nVar.lrL.setOnClickListener(this.aZX);
            nVar.jJY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lrx != null && b.this.lpV != null) {
                            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.lpV.lGr.a(null, b.this.agx, postData, nVar.lrF.getLayoutStrategy());
                                }
                            }, 100L);
                            String id = b.this.agx.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.agx.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dR("tid", id).w("fid", b.this.agx.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).al("obj_type", 4));
                        }
                    }
                }
            });
            nVar.lrD.eRb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.agx != null && nVar != null && nVar.lrD != null && nVar.lrD.getData() != null) {
                        int i = view == nVar.lrD.getImgAgree() ? 1 : 2;
                        String id = b.this.agx.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.agx.getNid();
                        }
                        TiebaStatic.log(new aq("c13700").dR("tid", id).w("fid", b.this.agx.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.lrD.getData().postId).al("obj_type", i));
                    }
                }
            };
            if (this.lrn) {
                nVar.lsa.setOnClickListener(this.aZX);
            }
        }
    }

    public void B(View.OnClickListener onClickListener) {
        this.aZX = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFW = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bw bwVar) {
        this.agx = bwVar;
    }

    public void Qh(String str) {
        this.lKa = str;
    }
}
