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
    private int aIS;
    private View.OnClickListener aXk;
    protected bw agw;
    private com.baidu.tieba.pb.a.c eTx;
    private TbRichTextView.i frJ;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> ivs;
    private com.baidu.adp.lib.d.b<TbImageView> ivt;
    private boolean kXW;
    public com.baidu.tieba.pb.pb.main.b.c kXv;
    private TbRichTextView.c kYL;
    private boolean kYN;
    private boolean kYO;
    private boolean kYP;
    private String lrF;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.agw = null;
        this.kYL = null;
        this.kXW = k.bfo().isShowImages();
        this.aXk = null;
        this.frJ = null;
        this.eTx = null;
        this.mOnLongClickListener = null;
        this.kYN = com.baidu.tbadk.a.d.bdC();
        this.kYO = com.baidu.tbadk.a.d.bdD();
        this.kYP = com.baidu.tbadk.a.d.bdy();
        this.ivs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cvn */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.lrE.getPageContext().getPageActivity());
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
        this.ivt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: boG */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.lrE.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.djM() != null) {
            this.aIS = newSubPbActivity.djM().dkD();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cf */
    public n c(ViewGroup viewGroup) {
        n nVar = new n(this.lrE.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aIS, this.kYN, this.kYO);
        nVar.tF(true);
        nVar.kZg.setConstrainLayoutPool(this.ivs);
        nVar.kZg.setImageViewPool(this.ivt);
        e(nVar);
        com.baidu.tieba.pb.pb.b.ddJ();
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.kYN);
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
        if (this.kYN) {
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
        if (nVar.kZH.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) nVar.kZH.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        nVar.kZH.setLayoutParams(layoutParams3);
        nVar.kZf.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && nVar.getView() != null) {
                    nVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aXk.onClick(nVar.getView());
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
            postData2.bjt();
            a(nVar, postData2, view, i);
            b(nVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.kYN);
        return view;
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.kYX != null) {
            if (at.equals(this.lrF, postData.getId())) {
                ap.setBackgroundColor(nVar.kYX, R.color.cp_other_g);
            } else {
                ap.setBackgroundColor(nVar.kYX, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(nVar, postData, view, i, this.lrE, this.agw, this.kYN);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.agw, i, this.kYN);
            if (this.kYN && postData.mFf) {
                nVar.kZh.setVisibility(8);
                nVar.kZm.setVisibility(0);
                if (this.agw.bgR()) {
                    nVar.kZA.setVisibility(8);
                } else {
                    nVar.kZA.setVisibility(0);
                }
            } else {
                nVar.kZm.setVisibility(8);
                nVar.kZh.setVisibility(0);
                nVar.kZl.setVisibility(0);
                nVar.jrA.setVisibility(0);
                nVar.kZd.setVisibility(0);
                nVar.kZA.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(nVar, postData, postData.mFf, this.kYN);
            com.baidu.tieba.pb.pb.b.a(this.lrE, nVar, postData, view, this.kXW, this.kYP, this.mIsFromCDN, i != 0, this.kYL);
            com.baidu.tieba.pb.pb.b.a(this.lrE, nVar, postData, this.agw);
            com.baidu.tieba.pb.pb.b.a(nVar, postData);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.kXW);
            i(nVar, postData);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.kZK.setVisibility(postData.mFa ? 0 : 8);
        }
    }

    private void c(n nVar) {
        nVar.kZf.setTextViewOnTouchListener(this.eTx);
        nVar.kZf.setTextViewCheckSelection(false);
    }

    private void a(n nVar, PostData postData, int i) {
        if (this.kYN) {
            if (nVar.kZo != null) {
                SparseArray sparseArray = (SparseArray) nVar.kZo.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.kZo.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.kZn != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.kZn.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.kZn.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (nVar.kZl != null) {
            SparseArray sparseArray3 = (SparseArray) nVar.kZl.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                nVar.kZl.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (nVar.jrA != null) {
            SparseArray sparseArray4 = (SparseArray) nVar.jrA.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                nVar.jrA.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.mFf));
        }
    }

    private void b(final n nVar) {
        nVar.kYX.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lrE != null && this.lrE.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a ddF = this.lrE.ddF();
            if (ddF != null) {
                nVar.hoF.setOnClickListener(ddF.hYm);
                nVar.kZe.setOnClickListener(ddF.hYm);
                nVar.kZx.setOnClickListener(ddF.hYm);
                nVar.kZx.getHeadView().setOnClickListener(ddF.hYm);
                nVar.kZf.setOnEmotionClickListener(ddF.lnD);
            }
            nVar.kZf.setOnLongClickListener(this.mOnLongClickListener);
            nVar.kZf.setOnImageClickListener(this.frJ);
            nVar.kZf.setOnClickListener(this.aXk);
            nVar.getView().setOnClickListener(this.aXk);
            nVar.kZB.setOnClickListener(this.aXk);
            nVar.kZC.setOnClickListener(this.aXk);
            if (this.kXv == null) {
                this.kXv = new com.baidu.tieba.pb.pb.main.b.c(this.lrE.getPageContext());
            }
            if (this.kYN) {
                nVar.kZo.setOnClickListener(this.aXk);
                nVar.kZn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kYX != null && b.this.kXv != null) {
                                e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.kXv.lnS.a(null, b.this.agw, postData, nVar.kZf.getLayoutStrategy());
                                    }
                                }, 100L);
                                String id = b.this.agw.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.agw.getNid();
                                }
                                TiebaStatic.log(new aq("c13700").dK("tid", id).u("fid", b.this.agw.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("post_id", postData.getId()).aj("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.kZu.eCQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.agw != null && nVar != null && nVar.kZu != null && nVar.kZu.getData() != null) {
                            int i = view == nVar.kZu.getImgAgree() ? 1 : 2;
                            String id = b.this.agw.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.agw.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dK("tid", id).u("fid", b.this.agw.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("post_id", nVar.kZu.getData().postId).aj("obj_type", i));
                        }
                    }
                };
            }
            nVar.kZl.setOnClickListener(this.aXk);
            nVar.jrA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kYX != null && b.this.kXv != null) {
                            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.kXv.lnS.a(null, b.this.agw, postData, nVar.kZf.getLayoutStrategy());
                                }
                            }, 100L);
                            String id = b.this.agw.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.agw.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dK("tid", id).u("fid", b.this.agw.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("post_id", postData.getId()).aj("obj_type", 4));
                        }
                    }
                }
            });
            nVar.kZd.eCQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.agw != null && nVar != null && nVar.kZd != null && nVar.kZd.getData() != null) {
                        int i = view == nVar.kZd.getImgAgree() ? 1 : 2;
                        String id = b.this.agw.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.agw.getNid();
                        }
                        TiebaStatic.log(new aq("c13700").dK("tid", id).u("fid", b.this.agw.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("post_id", nVar.kZd.getData().postId).aj("obj_type", i));
                    }
                }
            };
            if (this.kYN) {
                nVar.kZA.setOnClickListener(this.aXk);
            }
        }
    }

    public void A(View.OnClickListener onClickListener) {
        this.aXk = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.frJ = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bw bwVar) {
        this.agw = bwVar;
    }

    public void Ps(String str) {
        this.lrF = str;
    }
}
