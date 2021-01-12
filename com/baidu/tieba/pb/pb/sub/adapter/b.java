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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private int aHt;
    private View.OnClickListener aYB;
    protected bz ahu;
    private TbRichTextView.i fSh;
    private com.baidu.tieba.pb.a.c ftt;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jgX;
    private com.baidu.adp.lib.d.b<TbImageView> jgY;
    public com.baidu.tieba.pb.pb.main.b.c lEv;
    private TbRichTextView.c lFW;
    private boolean lFY;
    private boolean lFe;
    private boolean lIB;
    private String lYZ;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.ahu = null;
        this.lFW = null;
        this.lFe = k.bkB().isShowImages();
        this.aYB = null;
        this.fSh = null;
        this.ftt = null;
        this.mOnLongClickListener = null;
        this.lIB = d.biM();
        this.lFY = d.biN();
        this.jgX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cDT */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.lYY.getPageContext().getPageActivity());
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
        this.jgY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bur */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.lYY.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.dqm() != null) {
            this.aHt = newSubPbActivity.dqm().drd();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ct */
    public PbCommenFloorItemViewHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.lYY.getPageContext(), inflate, this.aHt, this.lFY);
        pbCommenFloorItemViewHolder.uH(true);
        pbCommenFloorItemViewHolder.lGo.setConstrainLayoutPool(this.jgX);
        pbCommenFloorItemViewHolder.lGo.setImageViewPool(this.jgY);
        e(pbCommenFloorItemViewHolder);
        com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, (f) null, this.lIB);
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
        if (this.lIB) {
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
        pbCommenFloorItemViewHolder.lGn.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && pbCommenFloorItemViewHolder.getView() != null) {
                    pbCommenFloorItemViewHolder.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aYB.onClick(pbCommenFloorItemViewHolder.getView());
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
            postData2.boL();
            a(pbCommenFloorItemViewHolder, postData2, view, i);
            b(pbCommenFloorItemViewHolder, postData);
        }
        com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, (f) null, this.lIB);
        pbCommenFloorItemViewHolder.mBottomLine.setVisibility(i == 0 ? 8 : 0);
        return view;
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lGf != null) {
            if (at.equals(this.lYZ, postData.getId())) {
                ao.setBackgroundColor(pbCommenFloorItemViewHolder.lGf, R.color.CAM_X0313);
            } else {
                ao.setBackgroundColor(pbCommenFloorItemViewHolder.lGf, R.color.CAM_X0205);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, view, i, this.lYY, this.ahu, this.lIB);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, this.ahu, i, this.lIB);
            if (this.lIB && postData.nnK) {
                pbCommenFloorItemViewHolder.lGp.setVisibility(8);
                pbCommenFloorItemViewHolder.lGt.setVisibility(0);
                if (this.ahu.bmg()) {
                    pbCommenFloorItemViewHolder.lGH.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lGH.setVisibility(0);
                }
            } else {
                pbCommenFloorItemViewHolder.lGt.setVisibility(8);
                pbCommenFloorItemViewHolder.lGp.setVisibility(0);
                pbCommenFloorItemViewHolder.jMo.setVisibility(0);
                pbCommenFloorItemViewHolder.jMm.setVisibility(0);
                pbCommenFloorItemViewHolder.lGl.setVisibility(0);
                pbCommenFloorItemViewHolder.lGH.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, postData.nnK, this.lIB);
            com.baidu.tieba.pb.pb.b.a(this.lYY, pbCommenFloorItemViewHolder, postData, view, this.lFe, this.mIsFromCDN, i != 0, this.lFW);
            com.baidu.tieba.pb.pb.b.a(this.lYY, pbCommenFloorItemViewHolder, postData, this.ahu);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, this.lFe);
            j(pbCommenFloorItemViewHolder, postData);
        }
    }

    private void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lGR.setVisibility(postData.nnG ? 0 : 8);
        }
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lGn.setTextViewOnTouchListener(this.ftt);
        pbCommenFloorItemViewHolder.lGn.setTextViewCheckSelection(false);
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        if (this.lIB) {
            if (pbCommenFloorItemViewHolder.lGv != null) {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lGv.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.lGv.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (pbCommenFloorItemViewHolder.lGu != null) {
                SparseArray sparseArray2 = (SparseArray) pbCommenFloorItemViewHolder.lGu.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.lGu.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (pbCommenFloorItemViewHolder.jMo != null) {
            SparseArray sparseArray3 = (SparseArray) pbCommenFloorItemViewHolder.jMo.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.jMo.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (pbCommenFloorItemViewHolder.jMm != null) {
            SparseArray sparseArray4 = (SparseArray) pbCommenFloorItemViewHolder.jMm.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                pbCommenFloorItemViewHolder.jMm.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.nnK));
        }
    }

    private void b(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lGf.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lYY != null && this.lYY.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a djU = this.lYY.djU();
            if (djU != null) {
                pbCommenFloorItemViewHolder.hXC.setOnClickListener(djU.iJX);
                pbCommenFloorItemViewHolder.lGm.setOnClickListener(djU.iJX);
                pbCommenFloorItemViewHolder.lGE.setOnClickListener(djU.iJX);
                pbCommenFloorItemViewHolder.lGE.getHeadView().setOnClickListener(djU.iJX);
                pbCommenFloorItemViewHolder.lGn.setOnEmotionClickListener(djU.lUV);
            }
            pbCommenFloorItemViewHolder.lGn.setOnLongClickListener(this.mOnLongClickListener);
            pbCommenFloorItemViewHolder.lGn.setOnImageClickListener(this.fSh);
            pbCommenFloorItemViewHolder.lGn.setOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.getView().setOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.lGI.setOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.lGJ.setOnClickListener(this.aYB);
            if (this.lEv == null) {
                this.lEv = new com.baidu.tieba.pb.pb.main.b.c(this.lYY.getPageContext());
            }
            if (this.lIB) {
                pbCommenFloorItemViewHolder.lGv.setOnClickListener(this.aYB);
                pbCommenFloorItemViewHolder.lGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lGf != null && b.this.lEv != null) {
                                e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.lEv.lVk.a(null, b.this.ahu, postData, pbCommenFloorItemViewHolder.lGn.getLayoutStrategy());
                                    }
                                }, 100L);
                                String id = b.this.ahu.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.ahu.blV();
                                }
                                TiebaStatic.log(new aq("c13700").dW("tid", id).w("fid", b.this.ahu.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("post_id", postData.getId()).an("obj_source", 1).an("obj_type", 4));
                            }
                        }
                    }
                });
                pbCommenFloorItemViewHolder.lGB.fcj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.ahu != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lGB != null && pbCommenFloorItemViewHolder.lGB.getData() != null) {
                            int i = view == pbCommenFloorItemViewHolder.lGB.getImgAgree() ? 1 : 2;
                            String id = b.this.ahu.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.ahu.blV();
                            }
                            TiebaStatic.log(new aq("c13700").dW("tid", id).w("fid", b.this.ahu.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("post_id", pbCommenFloorItemViewHolder.lGB.getData().postId).an("obj_source", 1).an("obj_type", i));
                        }
                    }
                };
            }
            pbCommenFloorItemViewHolder.jMo.setOnClickListener(this.aYB);
            pbCommenFloorItemViewHolder.jMm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lGf != null && b.this.lEv != null) {
                            e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.lEv.lVk.a(null, b.this.ahu, postData, pbCommenFloorItemViewHolder.lGn.getLayoutStrategy());
                                }
                            }, 100L);
                            String id = b.this.ahu.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.ahu.blV();
                            }
                            TiebaStatic.log(new aq("c13700").dW("tid", id).w("fid", b.this.ahu.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("post_id", postData.getId()).an("obj_source", 1).an("obj_type", 4));
                        }
                    }
                }
            });
            pbCommenFloorItemViewHolder.lGl.fcj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.ahu != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lGl != null && pbCommenFloorItemViewHolder.lGl.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lGl.getImgAgree() ? 1 : 2;
                        String id = b.this.ahu.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.ahu.blV();
                        }
                        TiebaStatic.log(new aq("c13700").dW("tid", id).w("fid", b.this.ahu.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("post_id", pbCommenFloorItemViewHolder.lGl.getData().postId).an("obj_source", 1).an("obj_type", i));
                    }
                }
            };
            if (this.lIB) {
                pbCommenFloorItemViewHolder.lGH.setOnClickListener(this.aYB);
            }
        }
    }

    public void C(View.OnClickListener onClickListener) {
        this.aYB = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fSh = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bz bzVar) {
        this.ahu = bzVar;
    }

    public void Pi(String str) {
        this.lYZ = str;
    }
}
