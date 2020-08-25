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
/* loaded from: classes16.dex */
public class b extends a<PostData, n> {
    private int aEB;
    private View.OnClickListener aRU;
    protected bw afJ;
    private com.baidu.tieba.pb.a.c eFf;
    private TbRichTextView.i fcy;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hZl;
    private com.baidu.adp.lib.d.b<TbImageView> hZm;
    private TbRichTextView.c kAW;
    private boolean kAY;
    private boolean kAZ;
    private boolean kAh;
    private String kTD;
    public com.baidu.tieba.pb.pb.main.b.c kzG;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.afJ = null;
        this.kAW = null;
        this.kAh = k.bbM().isShowImages();
        this.aRU = null;
        this.fcy = null;
        this.eFf = null;
        this.mOnLongClickListener = null;
        this.kAY = com.baidu.tbadk.a.d.baf();
        this.kAZ = com.baidu.tbadk.a.d.bag();
        this.hZl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: coB */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.kTC.getPageContext().getPageActivity());
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
        this.hZm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blb */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.kTC.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.dcy() != null) {
            this.aEB = newSubPbActivity.dcy().ddp();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cc */
    public n b(ViewGroup viewGroup) {
        n nVar = new n(this.kTC.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aEB, this.kAY, this.kAZ);
        nVar.sP(true);
        nVar.kBq.setConstrainLayoutPool(this.hZl);
        nVar.kBq.setImageViewPool(this.hZm);
        e(nVar);
        com.baidu.tieba.pb.pb.b.cWw();
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.kAY);
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
        if (this.kAY) {
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
        if (nVar.kBR.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) nVar.kBR.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        nVar.kBR.setLayoutParams(layoutParams3);
        nVar.kBp.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && nVar.getView() != null) {
                    nVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aRU.onClick(nVar.getView());
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
            postData2.bfQ();
            a(nVar, postData2, view, i);
            b(nVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.kAY);
        return view;
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.kBh != null) {
            if (at.equals(this.kTD, postData.getId())) {
                ap.setBackgroundColor(nVar.kBh, R.color.cp_other_g);
            } else {
                ap.setBackgroundColor(nVar.kBh, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(nVar, postData, view, i, this.kTC, this.afJ, this.kAY);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.afJ, i, this.kAY);
            if (this.kAY && postData.mfK) {
                nVar.kBr.setVisibility(8);
                nVar.kBw.setVisibility(0);
                if (this.afJ.bdo()) {
                    nVar.kBK.setVisibility(8);
                } else {
                    nVar.kBK.setVisibility(0);
                }
            } else {
                nVar.kBw.setVisibility(8);
                nVar.kBr.setVisibility(0);
                nVar.kBv.setVisibility(0);
                nVar.iTP.setVisibility(0);
                nVar.kBn.setVisibility(0);
                nVar.kBK.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(nVar, postData, postData.mfK, this.kAY);
            com.baidu.tieba.pb.pb.b.a(this.kTC, nVar, postData, view, this.kAh, this.mIsFromCDN, i != 0, this.kAW);
            com.baidu.tieba.pb.pb.b.a(this.kTC, nVar, postData, this.afJ);
            com.baidu.tieba.pb.pb.b.a(nVar, postData);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.kAh);
            i(nVar, postData);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.kBU.setVisibility(postData.mfG ? 0 : 8);
        }
    }

    private void c(n nVar) {
        nVar.kBp.setTextViewOnTouchListener(this.eFf);
        nVar.kBp.setTextViewCheckSelection(false);
    }

    private void a(n nVar, PostData postData, int i) {
        if (this.kAY) {
            if (nVar.kBy != null) {
                SparseArray sparseArray = (SparseArray) nVar.kBy.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.kBy.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.kBx != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.kBx.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.kBx.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (nVar.kBv != null) {
            SparseArray sparseArray3 = (SparseArray) nVar.kBv.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                nVar.kBv.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (nVar.iTP != null) {
            SparseArray sparseArray4 = (SparseArray) nVar.iTP.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                nVar.iTP.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.mfK));
        }
    }

    private void b(final n nVar) {
        nVar.kBh.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kTC != null && this.kTC.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a cWs = this.kTC.cWs();
            if (cWs != null) {
                nVar.gVT.setOnClickListener(cWs.hCj);
                nVar.kBo.setOnClickListener(cWs.hCj);
                nVar.kBH.setOnClickListener(cWs.hCj);
                nVar.kBH.getHeadView().setOnClickListener(cWs.hCj);
                nVar.kBp.setOnEmotionClickListener(cWs.kPG);
            }
            nVar.kBp.setOnLongClickListener(this.mOnLongClickListener);
            nVar.kBp.setOnImageClickListener(this.fcy);
            nVar.kBp.setOnClickListener(this.aRU);
            nVar.getView().setOnClickListener(this.aRU);
            nVar.kBL.setOnClickListener(this.aRU);
            nVar.kBM.setOnClickListener(this.aRU);
            if (this.kzG == null) {
                this.kzG = new com.baidu.tieba.pb.pb.main.b.c(this.kTC.getPageContext());
            }
            if (this.kAY) {
                nVar.kBy.setOnClickListener(this.aRU);
                nVar.kBx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kBh != null && b.this.kzG != null) {
                                e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.kzG.kPV.a(null, b.this.afJ, postData, nVar.kBh);
                                    }
                                }, 100L);
                                String id = b.this.afJ.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.afJ.getNid();
                                }
                                TiebaStatic.log(new aq("c13700").dD("tid", id).u("fid", b.this.afJ.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData.getId()).ai("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.kBE.eok = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.afJ != null && nVar != null && nVar.kBE != null && nVar.kBE.getData() != null) {
                            int i = view == nVar.kBE.getImgAgree() ? 1 : 2;
                            String id = b.this.afJ.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.afJ.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dD("tid", id).u("fid", b.this.afJ.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", nVar.kBE.getData().postId).ai("obj_type", i));
                        }
                    }
                };
            }
            nVar.kBv.setOnClickListener(this.aRU);
            nVar.iTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kBh != null && b.this.kzG != null) {
                            e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.kzG.kPV.a(null, b.this.afJ, postData, nVar.kBh);
                                }
                            }, 100L);
                            String id = b.this.afJ.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.afJ.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dD("tid", id).u("fid", b.this.afJ.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData.getId()).ai("obj_type", 4));
                        }
                    }
                }
            });
            nVar.kBn.eok = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.afJ != null && nVar != null && nVar.kBn != null && nVar.kBn.getData() != null) {
                        int i = view == nVar.kBn.getImgAgree() ? 1 : 2;
                        String id = b.this.afJ.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.afJ.getNid();
                        }
                        TiebaStatic.log(new aq("c13700").dD("tid", id).u("fid", b.this.afJ.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", nVar.kBn.getData().postId).ai("obj_type", i));
                    }
                }
            };
            if (this.kAY) {
                nVar.kBK.setOnClickListener(this.aRU);
            }
        }
    }

    public void A(View.OnClickListener onClickListener) {
        this.aRU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcy = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bw bwVar) {
        this.afJ = bwVar;
    }

    public void Ob(String str) {
        this.kTD = str;
    }
}
