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
    private int aMg;
    protected bz aim;
    private View.OnClickListener bdp;
    private TbRichTextView.i fWO;
    private com.baidu.tieba.pb.a.c fyb;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jlE;
    private com.baidu.adp.lib.d.b<TbImageView> jlF;
    private boolean lJJ;
    public com.baidu.tieba.pb.pb.main.b.c lJb;
    private TbRichTextView.c lKB;
    private boolean lKD;
    private boolean lNg;
    private View.OnLongClickListener mOnLongClickListener;
    private String mdH;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.aim = null;
        this.lKB = null;
        this.lJJ = k.bou().isShowImages();
        this.bdp = null;
        this.fWO = null;
        this.fyb = null;
        this.mOnLongClickListener = null;
        this.lNg = d.bmF();
        this.lKD = d.bmG();
        this.jlE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHK */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.mdG.getPageContext().getPageActivity());
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
        this.jlF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: byk */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.mdG.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.dud() != null) {
            this.aMg = newSubPbActivity.dud().duU();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ct */
    public PbCommenFloorItemViewHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.mdG.getPageContext(), inflate, this.aMg, this.lKD);
        pbCommenFloorItemViewHolder.uL(true);
        pbCommenFloorItemViewHolder.lKT.setConstrainLayoutPool(this.jlE);
        pbCommenFloorItemViewHolder.lKT.setImageViewPool(this.jlF);
        e(pbCommenFloorItemViewHolder);
        com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, (f) null, this.lNg);
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
        if (this.lNg) {
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
        pbCommenFloorItemViewHolder.lKS.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && pbCommenFloorItemViewHolder.getView() != null) {
                    pbCommenFloorItemViewHolder.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.bdp.onClick(pbCommenFloorItemViewHolder.getView());
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
            postData2.bsE();
            a(pbCommenFloorItemViewHolder, postData2, view, i);
            b(pbCommenFloorItemViewHolder, postData);
        }
        com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, (f) null, this.lNg);
        pbCommenFloorItemViewHolder.mBottomLine.setVisibility(i == 0 ? 8 : 0);
        return view;
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lKK != null) {
            if (at.equals(this.mdH, postData.getId())) {
                ao.setBackgroundColor(pbCommenFloorItemViewHolder.lKK, R.color.CAM_X0313);
            } else {
                ao.setBackgroundColor(pbCommenFloorItemViewHolder.lKK, R.color.CAM_X0205);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, view, i, this.mdG, this.aim, this.lNg);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, this.aim, i, this.lNg);
            if (this.lNg && postData.nss) {
                pbCommenFloorItemViewHolder.lKU.setVisibility(8);
                pbCommenFloorItemViewHolder.lKY.setVisibility(0);
                if (this.aim.bpZ()) {
                    pbCommenFloorItemViewHolder.lLm.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lLm.setVisibility(0);
                }
            } else {
                pbCommenFloorItemViewHolder.lKY.setVisibility(8);
                pbCommenFloorItemViewHolder.lKU.setVisibility(0);
                pbCommenFloorItemViewHolder.jQT.setVisibility(0);
                pbCommenFloorItemViewHolder.jQR.setVisibility(0);
                pbCommenFloorItemViewHolder.lKQ.setVisibility(0);
                pbCommenFloorItemViewHolder.lLm.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, postData.nss, this.lNg);
            com.baidu.tieba.pb.pb.b.a(this.mdG, pbCommenFloorItemViewHolder, postData, view, this.lJJ, this.mIsFromCDN, i != 0, this.lKB);
            com.baidu.tieba.pb.pb.b.a(this.mdG, pbCommenFloorItemViewHolder, postData, this.aim);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, this.lJJ);
            j(pbCommenFloorItemViewHolder, postData);
        }
    }

    private void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lLw.setVisibility(postData.nso ? 0 : 8);
        }
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lKS.setTextViewOnTouchListener(this.fyb);
        pbCommenFloorItemViewHolder.lKS.setTextViewCheckSelection(false);
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        if (this.lNg) {
            if (pbCommenFloorItemViewHolder.lLa != null) {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lLa.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.lLa.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (pbCommenFloorItemViewHolder.lKZ != null) {
                SparseArray sparseArray2 = (SparseArray) pbCommenFloorItemViewHolder.lKZ.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.lKZ.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (pbCommenFloorItemViewHolder.jQT != null) {
            SparseArray sparseArray3 = (SparseArray) pbCommenFloorItemViewHolder.jQT.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.jQT.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (pbCommenFloorItemViewHolder.jQR != null) {
            SparseArray sparseArray4 = (SparseArray) pbCommenFloorItemViewHolder.jQR.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                pbCommenFloorItemViewHolder.jQR.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.nss));
        }
    }

    private void b(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lKK.setOnLongClickListener(this.mOnLongClickListener);
        if (this.mdG != null && this.mdG.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a dnM = this.mdG.dnM();
            if (dnM != null) {
                pbCommenFloorItemViewHolder.icj.setOnClickListener(dnM.iOE);
                pbCommenFloorItemViewHolder.lKR.setOnClickListener(dnM.iOE);
                pbCommenFloorItemViewHolder.lLj.setOnClickListener(dnM.iOE);
                pbCommenFloorItemViewHolder.lLj.getHeadView().setOnClickListener(dnM.iOE);
                pbCommenFloorItemViewHolder.lKS.setOnEmotionClickListener(dnM.lZA);
            }
            pbCommenFloorItemViewHolder.lKS.setOnLongClickListener(this.mOnLongClickListener);
            pbCommenFloorItemViewHolder.lKS.setOnImageClickListener(this.fWO);
            pbCommenFloorItemViewHolder.lKS.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.getView().setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLn.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.lLo.setOnClickListener(this.bdp);
            if (this.lJb == null) {
                this.lJb = new com.baidu.tieba.pb.pb.main.b.c(this.mdG.getPageContext());
            }
            if (this.lNg) {
                pbCommenFloorItemViewHolder.lLa.setOnClickListener(this.bdp);
                pbCommenFloorItemViewHolder.lKZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lKK != null && b.this.lJb != null) {
                                e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.lJb.lZP.a(null, b.this.aim, postData, pbCommenFloorItemViewHolder.lKS.getLayoutStrategy());
                                    }
                                }, 100L);
                                String id = b.this.aim.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.aim.bpO();
                                }
                                TiebaStatic.log(new aq("c13700").dX("tid", id).w("fid", b.this.aim.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", postData.getId()).an("obj_source", 1).an("obj_type", 4));
                            }
                        }
                    }
                });
                pbCommenFloorItemViewHolder.lLg.fgS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.aim != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lLg != null && pbCommenFloorItemViewHolder.lLg.getData() != null) {
                            int i = view == pbCommenFloorItemViewHolder.lLg.getImgAgree() ? 1 : 2;
                            String id = b.this.aim.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.aim.bpO();
                            }
                            TiebaStatic.log(new aq("c13700").dX("tid", id).w("fid", b.this.aim.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", pbCommenFloorItemViewHolder.lLg.getData().postId).an("obj_source", 1).an("obj_type", i));
                        }
                    }
                };
            }
            pbCommenFloorItemViewHolder.jQT.setOnClickListener(this.bdp);
            pbCommenFloorItemViewHolder.jQR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lKK != null && b.this.lJb != null) {
                            e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.lJb.lZP.a(null, b.this.aim, postData, pbCommenFloorItemViewHolder.lKS.getLayoutStrategy());
                                }
                            }, 100L);
                            String id = b.this.aim.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.aim.bpO();
                            }
                            TiebaStatic.log(new aq("c13700").dX("tid", id).w("fid", b.this.aim.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", postData.getId()).an("obj_source", 1).an("obj_type", 4));
                        }
                    }
                }
            });
            pbCommenFloorItemViewHolder.lKQ.fgS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.aim != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lKQ != null && pbCommenFloorItemViewHolder.lKQ.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lKQ.getImgAgree() ? 1 : 2;
                        String id = b.this.aim.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.aim.bpO();
                        }
                        TiebaStatic.log(new aq("c13700").dX("tid", id).w("fid", b.this.aim.getFid()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", pbCommenFloorItemViewHolder.lKQ.getData().postId).an("obj_source", 1).an("obj_type", i));
                    }
                }
            };
            if (this.lNg) {
                pbCommenFloorItemViewHolder.lLm.setOnClickListener(this.bdp);
            }
        }
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fWO = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bz bzVar) {
        this.aim = bzVar;
    }

    public void Qr(String str) {
        this.mdH = str;
    }
}
