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
    private int aJu;
    private View.OnClickListener aYF;
    protected bw agx;
    private TbRichTextView.i fAg;
    private com.baidu.tieba.pb.a.c fbT;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iHO;
    private com.baidu.adp.lib.d.b<TbImageView> iHP;
    private String lEe;
    public com.baidu.tieba.pb.pb.main.b.c ljU;
    private boolean lkv;
    private TbRichTextView.c llk;
    private boolean llm;
    private boolean lln;
    private boolean llo;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.agx = null;
        this.llk = null;
        this.lkv = k.bhh().isShowImages();
        this.aYF = null;
        this.fAg = null;
        this.fbT = null;
        this.mOnLongClickListener = null;
        this.llm = com.baidu.tbadk.a.d.bfv();
        this.lln = com.baidu.tbadk.a.d.bfw();
        this.llo = com.baidu.tbadk.a.d.bfr();
        this.iHO = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cyu */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.lEd.getPageContext().getPageActivity());
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
        this.iHP = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bqz */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.lEd.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.dmT() != null) {
            this.aJu = newSubPbActivity.dmT().dnL();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cg */
    public n c(ViewGroup viewGroup) {
        n nVar = new n(this.lEd.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aJu, this.llm, this.lln);
        nVar.tW(true);
        nVar.llF.setConstrainLayoutPool(this.iHO);
        nVar.llF.setImageViewPool(this.iHP);
        e(nVar);
        com.baidu.tieba.pb.pb.b.dgR();
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.llm);
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
        if (this.llm) {
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
        if (nVar.lmg.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) nVar.lmg.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        nVar.lmg.setLayoutParams(layoutParams3);
        nVar.llE.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && nVar.getView() != null) {
                    nVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aYF.onClick(nVar.getView());
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
            postData2.blm();
            a(nVar, postData2, view, i);
            b(nVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.llm);
        return view;
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.llw != null) {
            if (at.equals(this.lEe, postData.getId())) {
                ap.setBackgroundColor(nVar.llw, R.color.cp_other_g);
            } else {
                ap.setBackgroundColor(nVar.llw, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(nVar, postData, view, i, this.lEd, this.agx, this.llm);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.agx, i, this.llm);
            if (this.llm && postData.mRL) {
                nVar.llG.setVisibility(8);
                nVar.llL.setVisibility(0);
                if (this.agx.biK()) {
                    nVar.llZ.setVisibility(8);
                } else {
                    nVar.llZ.setVisibility(0);
                }
            } else {
                nVar.llL.setVisibility(8);
                nVar.llG.setVisibility(0);
                nVar.llK.setVisibility(0);
                nVar.jEa.setVisibility(0);
                nVar.llC.setVisibility(0);
                nVar.llZ.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(nVar, postData, postData.mRL, this.llm);
            com.baidu.tieba.pb.pb.b.a(this.lEd, nVar, postData, view, this.lkv, this.llo, this.mIsFromCDN, i != 0, this.llk);
            com.baidu.tieba.pb.pb.b.a(this.lEd, nVar, postData, this.agx);
            com.baidu.tieba.pb.pb.b.a(nVar, postData);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.lkv);
            i(nVar, postData);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.lmj.setVisibility(postData.mRH ? 0 : 8);
        }
    }

    private void c(n nVar) {
        nVar.llE.setTextViewOnTouchListener(this.fbT);
        nVar.llE.setTextViewCheckSelection(false);
    }

    private void a(n nVar, PostData postData, int i) {
        if (this.llm) {
            if (nVar.llN != null) {
                SparseArray sparseArray = (SparseArray) nVar.llN.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.llN.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.llM != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.llM.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.llM.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (nVar.llK != null) {
            SparseArray sparseArray3 = (SparseArray) nVar.llK.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                nVar.llK.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (nVar.jEa != null) {
            SparseArray sparseArray4 = (SparseArray) nVar.jEa.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                nVar.jEa.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.mRL));
        }
    }

    private void b(final n nVar) {
        nVar.llw.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lEd != null && this.lEd.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a dgN = this.lEd.dgN();
            if (dgN != null) {
                nVar.hAA.setOnClickListener(dgN.ikM);
                nVar.llD.setOnClickListener(dgN.ikM);
                nVar.llW.setOnClickListener(dgN.ikM);
                nVar.llW.getHeadView().setOnClickListener(dgN.ikM);
                nVar.llE.setOnEmotionClickListener(dgN.lAg);
            }
            nVar.llE.setOnLongClickListener(this.mOnLongClickListener);
            nVar.llE.setOnImageClickListener(this.fAg);
            nVar.llE.setOnClickListener(this.aYF);
            nVar.getView().setOnClickListener(this.aYF);
            nVar.lma.setOnClickListener(this.aYF);
            nVar.lmb.setOnClickListener(this.aYF);
            if (this.ljU == null) {
                this.ljU = new com.baidu.tieba.pb.pb.main.b.c(this.lEd.getPageContext());
            }
            if (this.llm) {
                nVar.llN.setOnClickListener(this.aYF);
                nVar.llM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.llw != null && b.this.ljU != null) {
                                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.ljU.lAv.a(null, b.this.agx, postData, nVar.llE.getLayoutStrategy());
                                    }
                                }, 100L);
                                String id = b.this.agx.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.agx.getNid();
                                }
                                TiebaStatic.log(new aq("c13700").dR("tid", id).w("fid", b.this.agx.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).aj("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.llT.eLm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.agx != null && nVar != null && nVar.llT != null && nVar.llT.getData() != null) {
                            int i = view == nVar.llT.getImgAgree() ? 1 : 2;
                            String id = b.this.agx.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.agx.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dR("tid", id).w("fid", b.this.agx.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.llT.getData().postId).aj("obj_type", i));
                        }
                    }
                };
            }
            nVar.llK.setOnClickListener(this.aYF);
            nVar.jEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.llw != null && b.this.ljU != null) {
                            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.ljU.lAv.a(null, b.this.agx, postData, nVar.llE.getLayoutStrategy());
                                }
                            }, 100L);
                            String id = b.this.agx.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.agx.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dR("tid", id).w("fid", b.this.agx.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).aj("obj_type", 4));
                        }
                    }
                }
            });
            nVar.llC.eLm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.agx != null && nVar != null && nVar.llC != null && nVar.llC.getData() != null) {
                        int i = view == nVar.llC.getImgAgree() ? 1 : 2;
                        String id = b.this.agx.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.agx.getNid();
                        }
                        TiebaStatic.log(new aq("c13700").dR("tid", id).w("fid", b.this.agx.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.llC.getData().postId).aj("obj_type", i));
                    }
                }
            };
            if (this.llm) {
                nVar.llZ.setOnClickListener(this.aYF);
            }
        }
    }

    public void A(View.OnClickListener onClickListener) {
        this.aYF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fAg = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bw bwVar) {
        this.agx = bwVar;
    }

    public void PQ(String str) {
        this.lEe = str;
    }
}
