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
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jmF;
    private com.baidu.adp.lib.d.b<TbImageView> jmG;
    private boolean lNU;
    public com.baidu.tieba.pb.pb.main.b.c lNk;
    private TbRichTextView.c lOM;
    private boolean lOO;
    private boolean lOP;
    private boolean lRy;
    private View.OnLongClickListener mOnLongClickListener;
    private String mig;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.ahi = null;
        this.lOM = null;
        this.lNU = k.bkT().isShowImages();
        this.bbI = null;
        this.fUw = null;
        this.fvK = null;
        this.mOnLongClickListener = null;
        this.lRy = d.biY();
        this.lOO = d.biZ();
        this.lOP = false;
        this.jmF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFf */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.mif.getPageContext().getPageActivity());
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
        this.jmG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buL */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.mif.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.dsA() != null) {
            this.aJY = newSubPbActivity.dsA().dtr();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ct */
    public PbCommenFloorItemViewHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.mif.getPageContext(), inflate, this.aJY, this.lOO);
        pbCommenFloorItemViewHolder.uW(true);
        pbCommenFloorItemViewHolder.lPf.setConstrainLayoutPool(this.jmF);
        pbCommenFloorItemViewHolder.lPf.setImageViewPool(this.jmG);
        e(pbCommenFloorItemViewHolder);
        com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, (f) null, this.lRy);
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
        if (this.lRy) {
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
        pbCommenFloorItemViewHolder.lPe.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.3
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
        com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, (f) null, this.lRy);
        pbCommenFloorItemViewHolder.mBottomLine.setVisibility(i == 0 ? 8 : 0);
        return view;
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lOW != null) {
            if (au.equals(this.mig, postData.getId())) {
                ap.setBackgroundColor(pbCommenFloorItemViewHolder.lOW, R.color.CAM_X0313);
            } else {
                ap.setBackgroundColor(pbCommenFloorItemViewHolder.lOW, R.color.CAM_X0205);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, view, i, this.mif, this.ahi, this.lRy);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, this.ahi, i, this.lRy);
            if (this.lRy && postData.nxv) {
                pbCommenFloorItemViewHolder.lPg.setVisibility(8);
                pbCommenFloorItemViewHolder.lPk.setVisibility(0);
                if (this.ahi.bmz()) {
                    pbCommenFloorItemViewHolder.lPy.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lPy.setVisibility(0);
                }
            } else {
                pbCommenFloorItemViewHolder.lPk.setVisibility(8);
                pbCommenFloorItemViewHolder.lPg.setVisibility(0);
                pbCommenFloorItemViewHolder.jTr.setVisibility(0);
                pbCommenFloorItemViewHolder.jTp.setVisibility(0);
                pbCommenFloorItemViewHolder.lPc.setVisibility(0);
                pbCommenFloorItemViewHolder.lPy.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, postData.nxv, this.lRy);
            com.baidu.tieba.pb.pb.b.a(this.mif, pbCommenFloorItemViewHolder, postData, view, this.lNU, this.mIsFromCDN, i != 0, this.lOM);
            com.baidu.tieba.pb.pb.b.a(this.mif, pbCommenFloorItemViewHolder, postData, this.ahi);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, this.lNU);
            j(pbCommenFloorItemViewHolder, postData);
        }
    }

    private void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lPI.setVisibility(postData.nxr ? 0 : 8);
        }
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lPe.setTextViewOnTouchListener(this.fvK);
        pbCommenFloorItemViewHolder.lPe.setTextViewCheckSelection(false);
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        if (this.lRy) {
            if (pbCommenFloorItemViewHolder.lPm != null) {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lPm.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.lPm.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (pbCommenFloorItemViewHolder.lPl != null) {
                SparseArray sparseArray2 = (SparseArray) pbCommenFloorItemViewHolder.lPl.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.lPl.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (pbCommenFloorItemViewHolder.jTr != null) {
            SparseArray sparseArray3 = (SparseArray) pbCommenFloorItemViewHolder.jTr.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.jTr.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (pbCommenFloorItemViewHolder.jTp != null) {
            SparseArray sparseArray4 = (SparseArray) pbCommenFloorItemViewHolder.jTp.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                pbCommenFloorItemViewHolder.jTp.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.nxv));
        }
    }

    public void uT(boolean z) {
        this.lOP = z;
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (i == 0) {
                pbCommenFloorItemViewHolder.c(postData.nxk, postData.getId(), this.lOP);
            } else {
                pbCommenFloorItemViewHolder.c(postData.isAuthorView == 1, postData.getId(), this.lOP);
            }
        }
    }

    private void b(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lOW.setOnLongClickListener(this.mOnLongClickListener);
        if (this.mif != null && this.mif.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a dmh = this.mif.dmh();
            if (dmh != null) {
                pbCommenFloorItemViewHolder.ibW.setOnClickListener(dmh.iPF);
                pbCommenFloorItemViewHolder.lPd.setOnClickListener(dmh.iPF);
                pbCommenFloorItemViewHolder.lPv.setOnClickListener(dmh.iPF);
                pbCommenFloorItemViewHolder.lPv.getHeadView().setOnClickListener(dmh.iPF);
                pbCommenFloorItemViewHolder.lPe.setOnEmotionClickListener(dmh.mdZ);
            }
            pbCommenFloorItemViewHolder.lPe.setOnLongClickListener(this.mOnLongClickListener);
            pbCommenFloorItemViewHolder.lPe.setOnImageClickListener(this.fUw);
            pbCommenFloorItemViewHolder.lPe.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.getView().setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPz.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.lPA.setOnClickListener(this.bbI);
            if (this.lNk == null) {
                this.lNk = new com.baidu.tieba.pb.pb.main.b.c(this.mif.getPageContext());
            }
            if (this.lRy) {
                pbCommenFloorItemViewHolder.lPm.setOnClickListener(this.bbI);
                pbCommenFloorItemViewHolder.lPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lOW != null && b.this.lNk != null) {
                                e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.lNk.mep.a(null, b.this.ahi, postData, pbCommenFloorItemViewHolder.lPe.getLayoutStrategy());
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
                pbCommenFloorItemViewHolder.lPs.fez = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.ahi != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPs != null && pbCommenFloorItemViewHolder.lPs.getData() != null) {
                            int i = view == pbCommenFloorItemViewHolder.lPs.getImgAgree() ? 1 : 2;
                            String id = b.this.ahi.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.ahi.bmo();
                            }
                            TiebaStatic.log(new ar("c13700").dR("tid", id).v("fid", b.this.ahi.getFid()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lPs.getData().postId).ap("obj_source", 1).ap("obj_type", i));
                        }
                    }
                };
            }
            pbCommenFloorItemViewHolder.jTr.setOnClickListener(this.bbI);
            pbCommenFloorItemViewHolder.jTp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lOW != null && b.this.lNk != null) {
                            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.lNk.mep.a(null, b.this.ahi, postData, pbCommenFloorItemViewHolder.lPe.getLayoutStrategy());
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
            pbCommenFloorItemViewHolder.lPc.fez = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.ahi != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lPc != null && pbCommenFloorItemViewHolder.lPc.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lPc.getImgAgree() ? 1 : 2;
                        String id = b.this.ahi.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.ahi.bmo();
                        }
                        TiebaStatic.log(new ar("c13700").dR("tid", id).v("fid", b.this.ahi.getFid()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lPc.getData().postId).ap("obj_source", 1).ap("obj_type", i));
                    }
                }
            };
            if (this.lRy) {
                pbCommenFloorItemViewHolder.lPy.setOnClickListener(this.bbI);
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

    public void Qa(String str) {
        this.mig = str;
    }
}
