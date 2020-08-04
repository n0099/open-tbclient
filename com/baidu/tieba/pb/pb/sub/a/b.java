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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class b extends a<PostData, n> {
    private View.OnClickListener aMH;
    protected bv aeA;
    private int azq;
    private TbRichTextView.i eRR;
    private com.baidu.tieba.pb.a.c euG;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hLg;
    private com.baidu.adp.lib.d.b<TbImageView> hLh;
    private String kDW;
    private boolean kkP;
    public com.baidu.tieba.pb.pb.main.b.c kko;
    private TbRichTextView.c klE;
    private boolean klG;
    private boolean klH;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.aeA = null;
        this.klE = null;
        this.kkP = k.aTv().isShowImages();
        this.aMH = null;
        this.eRR = null;
        this.euG = null;
        this.mOnLongClickListener = null;
        this.klG = com.baidu.tbadk.a.d.aRO();
        this.klH = com.baidu.tbadk.a.d.aRP();
        this.hLg = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cdX */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.kDV.getPageContext().getPageActivity());
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
        this.hLh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bcD */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.kDV.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ao.getColor(R.color.common_color_10043));
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
        if (newSubPbActivity != null && newSubPbActivity.cRI() != null) {
            this.azq = newSubPbActivity.cRI().cSy();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cg */
    public n b(ViewGroup viewGroup) {
        n nVar = new n(this.kDV.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.azq, this.klG, this.klH);
        nVar.si(true);
        nVar.klY.setConstrainLayoutPool(this.hLg);
        nVar.klY.setImageViewPool(this.hLh);
        e(nVar);
        com.baidu.tieba.pb.pb.b.cLI();
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.klG);
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
        if (this.klG) {
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
        if (nVar.kmz.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) nVar.kmz.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        nVar.kmz.setLayoutParams(layoutParams3);
        nVar.klX.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && nVar.getView() != null) {
                    nVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aMH.onClick(nVar.getView());
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
            postData2.aXx();
            a(nVar, postData2, view, i);
            b(nVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.klG);
        return view;
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.klP != null) {
            if (as.equals(this.kDW, postData.getId())) {
                ao.setBackgroundColor(nVar.klP, R.color.cp_other_g);
            } else {
                ao.setBackgroundColor(nVar.klP, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(nVar, postData, view, i, this.kDV, this.aeA, this.klG);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.aeA, i, this.klG);
            if (this.klG && postData.lOa) {
                nVar.klZ.setVisibility(8);
                nVar.kme.setVisibility(0);
                if (this.aeA.aUV()) {
                    nVar.kms.setVisibility(8);
                } else {
                    nVar.kms.setVisibility(0);
                }
            } else {
                nVar.kme.setVisibility(8);
                nVar.klZ.setVisibility(0);
                nVar.kmd.setVisibility(0);
                nVar.iER.setVisibility(0);
                nVar.klV.setVisibility(0);
                nVar.kms.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(nVar, postData, postData.lOa, this.klG);
            com.baidu.tieba.pb.pb.b.a(this.kDV, nVar, postData, view, this.kkP, this.mIsFromCDN, i != 0, this.klE);
            com.baidu.tieba.pb.pb.b.a(this.kDV, nVar, postData, this.aeA);
            com.baidu.tieba.pb.pb.b.a(nVar, postData);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.kkP);
            i(nVar, postData);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.kmC.setVisibility(postData.lNW ? 0 : 8);
        }
    }

    private void c(n nVar) {
        nVar.klX.setTextViewOnTouchListener(this.euG);
        nVar.klX.setTextViewCheckSelection(false);
    }

    private void a(n nVar, PostData postData, int i) {
        if (this.klG) {
            if (nVar.kmg != null) {
                SparseArray sparseArray = (SparseArray) nVar.kmg.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.kmg.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.kmf != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.kmf.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.kmf.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (nVar.kmd != null) {
            SparseArray sparseArray3 = (SparseArray) nVar.kmd.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                nVar.kmd.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (nVar.iER != null) {
            SparseArray sparseArray4 = (SparseArray) nVar.iER.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                nVar.iER.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.lOa));
        }
    }

    private void b(final n nVar) {
        nVar.klP.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kDV != null && this.kDV.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a cLE = this.kDV.cLE();
            if (cLE != null) {
                nVar.gJq.setOnClickListener(cLE.hps);
                nVar.klW.setOnClickListener(cLE.hps);
                nVar.kmp.setOnClickListener(cLE.hps);
                nVar.kmp.getHeadView().setOnClickListener(cLE.hps);
                nVar.klX.setOnEmotionClickListener(cLE.kAb);
            }
            nVar.klX.setOnLongClickListener(this.mOnLongClickListener);
            nVar.klX.setOnImageClickListener(this.eRR);
            nVar.klX.setOnClickListener(this.aMH);
            nVar.getView().setOnClickListener(this.aMH);
            nVar.kmt.setOnClickListener(this.aMH);
            nVar.kmu.setOnClickListener(this.aMH);
            if (this.kko == null) {
                this.kko = new com.baidu.tieba.pb.pb.main.b.c(this.kDV.getPageContext());
            }
            if (this.klG) {
                nVar.kmg.setOnClickListener(this.aMH);
                nVar.kmf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.klP != null && b.this.kko != null) {
                                e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.kko.kAq.a(null, b.this.aeA, postData, nVar.klP);
                                    }
                                }, 100L);
                                String id = b.this.aeA.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.aeA.getNid();
                                }
                                TiebaStatic.log(new ap("c13700").dn("tid", id).t("fid", b.this.aeA.getFid()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", postData.getId()).ah("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.kmm.eeJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.aeA != null && nVar != null && nVar.kmm != null && nVar.kmm.getData() != null) {
                            int i = view == nVar.kmm.getImgAgree() ? 1 : 2;
                            String id = b.this.aeA.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.aeA.getNid();
                            }
                            TiebaStatic.log(new ap("c13700").dn("tid", id).t("fid", b.this.aeA.getFid()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", nVar.kmm.getData().postId).ah("obj_type", i));
                        }
                    }
                };
            }
            nVar.kmd.setOnClickListener(this.aMH);
            nVar.iER.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.klP != null && b.this.kko != null) {
                            e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.kko.kAq.a(null, b.this.aeA, postData, nVar.klP);
                                }
                            }, 100L);
                            String id = b.this.aeA.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.aeA.getNid();
                            }
                            TiebaStatic.log(new ap("c13700").dn("tid", id).t("fid", b.this.aeA.getFid()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", postData.getId()).ah("obj_type", 4));
                        }
                    }
                }
            });
            nVar.klV.eeJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.aeA != null && nVar != null && nVar.klV != null && nVar.klV.getData() != null) {
                        int i = view == nVar.klV.getImgAgree() ? 1 : 2;
                        String id = b.this.aeA.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.aeA.getNid();
                        }
                        TiebaStatic.log(new ap("c13700").dn("tid", id).t("fid", b.this.aeA.getFid()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", nVar.klV.getData().postId).ah("obj_type", i));
                    }
                }
            };
            if (this.klG) {
                nVar.kms.setOnClickListener(this.aMH);
            }
        }
    }

    public void z(View.OnClickListener onClickListener) {
        this.aMH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eRR = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bv bvVar) {
        this.aeA = bvVar;
    }

    public void Li(String str) {
        this.kDW = str;
    }
}
