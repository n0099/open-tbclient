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
    private int aED;
    private View.OnClickListener aRW;
    protected bw afL;
    private com.baidu.tieba.pb.a.c eFj;
    private TbRichTextView.i fcC;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hZr;
    private com.baidu.adp.lib.d.b<TbImageView> hZs;
    private boolean kAo;
    private TbRichTextView.c kBd;
    private boolean kBf;
    private boolean kBg;
    private String kTK;
    public com.baidu.tieba.pb.pb.main.b.c kzN;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.afL = null;
        this.kBd = null;
        this.kAo = k.bbM().isShowImages();
        this.aRW = null;
        this.fcC = null;
        this.eFj = null;
        this.mOnLongClickListener = null;
        this.kBf = com.baidu.tbadk.a.d.baf();
        this.kBg = com.baidu.tbadk.a.d.bag();
        this.hZr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: coC */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.kTJ.getPageContext().getPageActivity());
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
        this.hZs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blb */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.kTJ.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.dcz() != null) {
            this.aED = newSubPbActivity.dcz().ddq();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cc */
    public n b(ViewGroup viewGroup) {
        n nVar = new n(this.kTJ.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aED, this.kBf, this.kBg);
        nVar.sR(true);
        nVar.kBx.setConstrainLayoutPool(this.hZr);
        nVar.kBx.setImageViewPool(this.hZs);
        e(nVar);
        com.baidu.tieba.pb.pb.b.cWx();
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.kBf);
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
        if (this.kBf) {
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
        if (nVar.kBY.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) nVar.kBY.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        nVar.kBY.setLayoutParams(layoutParams3);
        nVar.kBw.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && nVar.getView() != null) {
                    nVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aRW.onClick(nVar.getView());
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
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.kBf);
        return view;
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.kBo != null) {
            if (at.equals(this.kTK, postData.getId())) {
                ap.setBackgroundColor(nVar.kBo, R.color.cp_other_g);
            } else {
                ap.setBackgroundColor(nVar.kBo, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(nVar, postData, view, i, this.kTJ, this.afL, this.kBf);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.afL, i, this.kBf);
            if (this.kBf && postData.mfZ) {
                nVar.kBy.setVisibility(8);
                nVar.kBD.setVisibility(0);
                if (this.afL.bdo()) {
                    nVar.kBR.setVisibility(8);
                } else {
                    nVar.kBR.setVisibility(0);
                }
            } else {
                nVar.kBD.setVisibility(8);
                nVar.kBy.setVisibility(0);
                nVar.kBC.setVisibility(0);
                nVar.iTV.setVisibility(0);
                nVar.kBu.setVisibility(0);
                nVar.kBR.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(nVar, postData, postData.mfZ, this.kBf);
            com.baidu.tieba.pb.pb.b.a(this.kTJ, nVar, postData, view, this.kAo, this.mIsFromCDN, i != 0, this.kBd);
            com.baidu.tieba.pb.pb.b.a(this.kTJ, nVar, postData, this.afL);
            com.baidu.tieba.pb.pb.b.a(nVar, postData);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.kAo);
            i(nVar, postData);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.kCb.setVisibility(postData.mfV ? 0 : 8);
        }
    }

    private void c(n nVar) {
        nVar.kBw.setTextViewOnTouchListener(this.eFj);
        nVar.kBw.setTextViewCheckSelection(false);
    }

    private void a(n nVar, PostData postData, int i) {
        if (this.kBf) {
            if (nVar.kBF != null) {
                SparseArray sparseArray = (SparseArray) nVar.kBF.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.kBF.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.kBE != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.kBE.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.kBE.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (nVar.kBC != null) {
            SparseArray sparseArray3 = (SparseArray) nVar.kBC.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                nVar.kBC.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (nVar.iTV != null) {
            SparseArray sparseArray4 = (SparseArray) nVar.iTV.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                nVar.iTV.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.mfZ));
        }
    }

    private void b(final n nVar) {
        nVar.kBo.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kTJ != null && this.kTJ.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a cWt = this.kTJ.cWt();
            if (cWt != null) {
                nVar.gVX.setOnClickListener(cWt.hCp);
                nVar.kBv.setOnClickListener(cWt.hCp);
                nVar.kBO.setOnClickListener(cWt.hCp);
                nVar.kBO.getHeadView().setOnClickListener(cWt.hCp);
                nVar.kBw.setOnEmotionClickListener(cWt.kPN);
            }
            nVar.kBw.setOnLongClickListener(this.mOnLongClickListener);
            nVar.kBw.setOnImageClickListener(this.fcC);
            nVar.kBw.setOnClickListener(this.aRW);
            nVar.getView().setOnClickListener(this.aRW);
            nVar.kBS.setOnClickListener(this.aRW);
            nVar.kBT.setOnClickListener(this.aRW);
            if (this.kzN == null) {
                this.kzN = new com.baidu.tieba.pb.pb.main.b.c(this.kTJ.getPageContext());
            }
            if (this.kBf) {
                nVar.kBF.setOnClickListener(this.aRW);
                nVar.kBE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kBo != null && b.this.kzN != null) {
                                e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.kzN.kQc.a(null, b.this.afL, postData, nVar.kBo);
                                    }
                                }, 100L);
                                String id = b.this.afL.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.afL.getNid();
                                }
                                TiebaStatic.log(new aq("c13700").dD("tid", id).u("fid", b.this.afL.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData.getId()).ai("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.kBL.eoo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.afL != null && nVar != null && nVar.kBL != null && nVar.kBL.getData() != null) {
                            int i = view == nVar.kBL.getImgAgree() ? 1 : 2;
                            String id = b.this.afL.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.afL.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dD("tid", id).u("fid", b.this.afL.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", nVar.kBL.getData().postId).ai("obj_type", i));
                        }
                    }
                };
            }
            nVar.kBC.setOnClickListener(this.aRW);
            nVar.iTV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kBo != null && b.this.kzN != null) {
                            e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.kzN.kQc.a(null, b.this.afL, postData, nVar.kBo);
                                }
                            }, 100L);
                            String id = b.this.afL.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.afL.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dD("tid", id).u("fid", b.this.afL.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData.getId()).ai("obj_type", 4));
                        }
                    }
                }
            });
            nVar.kBu.eoo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.afL != null && nVar != null && nVar.kBu != null && nVar.kBu.getData() != null) {
                        int i = view == nVar.kBu.getImgAgree() ? 1 : 2;
                        String id = b.this.afL.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.afL.getNid();
                        }
                        TiebaStatic.log(new aq("c13700").dD("tid", id).u("fid", b.this.afL.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", nVar.kBu.getData().postId).ai("obj_type", i));
                    }
                }
            };
            if (this.kBf) {
                nVar.kBR.setOnClickListener(this.aRW);
            }
        }
    }

    public void A(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcC = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bw bwVar) {
        this.afL = bwVar;
    }

    public void Oc(String str) {
        this.kTK = str;
    }
}
