package com.baidu.tieba.pb.pb.sub.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class b extends a<PostData, PbCommenFloorItemViewHolder> {
    private int aJY;
    protected cb ahi;
    private View.OnClickListener bbI;
    private TbRichTextView.i fUw;
    private com.baidu.tieba.pb.a.c fvK;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jmT;
    private com.baidu.adp.lib.d.b<TbImageView> jmU;
    public com.baidu.tieba.pb.pb.main.b.c lNz;
    private boolean lOj;
    private TbRichTextView.c lPb;
    private boolean lPd;
    private boolean lPe;
    private boolean lRN;
    private View.OnLongClickListener mOnLongClickListener;
    private String miw;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.ahi = null;
        this.lPb = null;
        this.lOj = k.bkT().isShowImages();
        this.bbI = null;
        this.fUw = null;
        this.fvK = null;
        this.mOnLongClickListener = null;
        this.lRN = d.biY();
        this.lPd = d.biZ();
        this.lPe = false;
        this.jmT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFm */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.miv.getPageContext().getPageActivity());
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
        this.jmU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buL */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.miv.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.dsH() != null) {
            this.aJY = newSubPbActivity.dsH().dty();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ct */
    public PbCommenFloorItemViewHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.miv.getPageContext(), inflate, this.aJY, this.lPd);
        pbCommenFloorItemViewHolder.uW(true);
        pbCommenFloorItemViewHolder.lPu.setConstrainLayoutPool(this.jmT);
        pbCommenFloorItemViewHolder.lPu.setImageViewPool(this.jmU);
        e(pbCommenFloorItemViewHolder);
        com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, (f) null, this.lRN);
        return pbCommenFloorItemViewHolder;
    }

    private void e(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds148);
        if (this.lRN) {
            layoutParams.topMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds0);
        }
        pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
        ColumnLayout columnLayout = (ColumnLayout) pbCommenFloorItemViewHolder.getView().findViewById(R.id.item_head_owner_root);
        if (columnLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) columnLayout.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams2.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds21);
        layoutParams2.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds1);
        columnLayout.setLayoutParams(layoutParams2);
        pbCommenFloorItemViewHolder.lPt.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && pbCommenFloorItemViewHolder.getView() != null) {
                    pbCommenFloorItemViewHolder.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.bbI.onClick(pbCommenFloorItemViewHolder.getView());
                if (view != null) {
                    view.setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
                if (pbCommenFloorItemViewHolder.getView() != null) {
                    pbCommenFloorItemViewHolder.getView().setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.sub.adapter.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        a(pbCommenFloorItemViewHolder, postData, i);
        b(pbCommenFloorItemViewHolder);
        c(pbCommenFloorItemViewHolder);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.bpd();
            a(pbCommenFloorItemViewHolder, postData2, view, i);
            b(pbCommenFloorItemViewHolder, postData);
            b(pbCommenFloorItemViewHolder, postData, i);
        }
        com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, (f) null, this.lRN);
        pbCommenFloorItemViewHolder.mBottomLine.setVisibility(i == 0 ? 8 : 0);
        return view;
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPl != null) {
            if (au.equals(this.miw, postData.getId())) {
                ap.setBackgroundColor(pbCommenFloorItemViewHolder.lPl, R.color.CAM_X0313);
            } else {
                ap.setBackgroundColor(pbCommenFloorItemViewHolder.lPl, R.color.CAM_X0205);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, view, i, this.miv, this.ahi, this.lRN);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, this.ahi, i, this.lRN);
            if (this.lRN && postData.nxV) {
                pbCommenFloorItemViewHolder.lPv.setVisibility(8);
                pbCommenFloorItemViewHolder.lPz.setVisibility(0);
                if (this.ahi.bmz()) {
                    pbCommenFloorItemViewHolder.lPN.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lPN.setVisibility(0);
                }
            } else {
                pbCommenFloorItemViewHolder.lPz.setVisibility(8);
                pbCommenFloorItemViewHolder.lPv.setVisibility(0);
                pbCommenFloorItemViewHolder.jTF.setVisibility(0);
                pbCommenFloorItemViewHolder.jTD.setVisibility(0);
                pbCommenFloorItemViewHolder.lPr.setVisibility(0);
                pbCommenFloorItemViewHolder.lPN.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, postData.nxV, this.lRN);
            com.baidu.tieba.pb.pb.b.a(this.miv, pbCommenFloorItemViewHolder, postData, view, this.lOj, this.mIsFromCDN, i != 0, this.lPb);
            com.baidu.tieba.pb.pb.b.a(this.miv, pbCommenFloorItemViewHolder, postData, this.ahi);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, this.lOj);
            j(pbCommenFloorItemViewHolder, postData);
        }
    }

    private void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lPX.setVisibility(postData.nxR ? 0 : 8);
        }
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lPt.setTextViewOnTouchListener(this.fvK);
        pbCommenFloorItemViewHolder.lPt.setTextViewCheckSelection(false);
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        if (this.lRN) {
            if (pbCommenFloorItemViewHolder.lPB != null) {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lPB.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.lPB.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (pbCommenFloorItemViewHolder.lPA != null) {
                SparseArray sparseArray2 = (SparseArray) pbCommenFloorItemViewHolder.lPA.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.lPA.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (pbCommenFloorItemViewHolder.jTF != null) {
            SparseArray sparseArray3 = (SparseArray) pbCommenFloorItemViewHolder.jTF.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.jTF.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (pbCommenFloorItemViewHolder.jTD != null) {
            SparseArray sparseArray4 = (SparseArray) pbCommenFloorItemViewHolder.jTD.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                pbCommenFloorItemViewHolder.jTD.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.nxV));
        }
    }

    public void uT(boolean z) {
        this.lPe = z;
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (i == 0) {
                pbCommenFloorItemViewHolder.c(postData.nxK, postData.getId(), this.lPe);
            } else {
                pbCommenFloorItemViewHolder.c(postData.isAuthorView == 1, postData.getId(), this.lPe);
            }
        }
    }

    private void b(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lPl.setOnLongClickListener(this.mOnLongClickListener);
        if (this.miv != null && this.miv.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a dmo = this.miv.dmo();
            if (dmo != null) {
                pbCommenFloorItemViewHolder.ick.setOnClickListener(dmo.iPT);
                pbCommenFloorItemViewHolder.lPs.setOnClickListener(dmo.iPT);
                pbCommenFloorItemViewHolder.lPK.setOnClickListener(dmo.iPT);
                pbCommenFloorItemViewHolder.lPK.getHeadView().setOnClickListener(dmo.iPT);
                pbCommenFloorItemViewHolder.lPt.setOnEmotionClickListener(dmo.mep);
            }
            pbCommenFloorItemViewHolder.lPt.setOnLongClickListener(this.mOnLongClickListener);
            pbCommenFloorItemViewHolder.lPt.setOnImageClickListener(this.fUw);
            pbCommenFloorItemViewHolder.lPt.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.getView().setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPO.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPP.setOnClickListener(this.bbI);
            if (this.lNz == null) {
                this.lNz = new com.baidu.tieba.pb.pb.main.b.c(this.miv.getPageContext());
            }
            if (this.lRN) {
                pbCommenFloorItemViewHolder.lPB.setOnClickListener(this.bbI);
                pbCommenFloorItemViewHolder.lPA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lPl != null && b.this.lNz != null) {
                                e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.lNz.meE.a(null, b.this.ahi, postData, pbCommenFloorItemViewHolder.lPt.getLayoutStrategy());
                                    }
                                }, 100L);
                                String id = b.this.ahi.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.ahi.bmo();
                                }
                                TiebaStatic.log(new ar("c13700").dR("tid", id).v("fid", b.this.ahi.getFid()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).ap("obj_source", 1).ap("obj_type", 4));
                            }
                        }
                    }
                });
                pbCommenFloorItemViewHolder.lPH.fez = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.ahi != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPH != null && pbCommenFloorItemViewHolder.lPH.getData() != null) {
                            int i = view == pbCommenFloorItemViewHolder.lPH.getImgAgree() ? 1 : 2;
                            String id = b.this.ahi.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.ahi.bmo();
                            }
                            TiebaStatic.log(new ar("c13700").dR("tid", id).v("fid", b.this.ahi.getFid()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lPH.getData().postId).ap("obj_source", 1).ap("obj_type", i));
                        }
                    }
                };
            }
            pbCommenFloorItemViewHolder.jTF.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.jTD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lPl != null && b.this.lNz != null) {
                            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.lNz.meE.a(null, b.this.ahi, postData, pbCommenFloorItemViewHolder.lPt.getLayoutStrategy());
                                }
                            }, 100L);
                            String id = b.this.ahi.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.ahi.bmo();
                            }
                            TiebaStatic.log(new ar("c13700").dR("tid", id).v("fid", b.this.ahi.getFid()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).ap("obj_source", 1).ap("obj_type", 4));
                        }
                    }
                }
            });
            pbCommenFloorItemViewHolder.lPr.fez = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.ahi != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPr != null && pbCommenFloorItemViewHolder.lPr.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lPr.getImgAgree() ? 1 : 2;
                        String id = b.this.ahi.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.ahi.bmo();
                        }
                        TiebaStatic.log(new ar("c13700").dR("tid", id).v("fid", b.this.ahi.getFid()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lPr.getData().postId).ap("obj_source", 1).ap("obj_type", i));
                    }
                }
            };
            if (this.lRN) {
                pbCommenFloorItemViewHolder.lPN.setOnClickListener(this.bbI);
            }
        }
    }

    public void C(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fUw = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(cb cbVar) {
        this.ahi = cbVar;
    }

    public void Qb(String str) {
        this.miw = str;
    }
}
