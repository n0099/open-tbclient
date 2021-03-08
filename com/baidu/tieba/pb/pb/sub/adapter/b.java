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
    private int aLy;
    protected cb aiB;
    private View.OnClickListener bdi;
    private TbRichTextView.i fVW;
    private com.baidu.tieba.pb.a.c fxj;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> joC;
    private com.baidu.adp.lib.d.b<TbImageView> joD;
    public com.baidu.tieba.pb.pb.main.b.c lPB;
    private boolean lQl;
    private TbRichTextView.c lRd;
    private boolean lRf;
    private boolean lRg;
    private boolean lTP;
    private View.OnLongClickListener mOnLongClickListener;
    private String mky;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.aiB = null;
        this.lRd = null;
        this.lQl = k.bkV().isShowImages();
        this.bdi = null;
        this.fVW = null;
        this.fxj = null;
        this.mOnLongClickListener = null;
        this.lTP = d.bja();
        this.lRf = d.bjb();
        this.lRg = false;
        this.joC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFs */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.mkx.getPageContext().getPageActivity());
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
        this.joD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buO */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.mkx.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.dsQ() != null) {
            this.aLy = newSubPbActivity.dsQ().dtH();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cs */
    public PbCommenFloorItemViewHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.mkx.getPageContext(), inflate, this.aLy, this.lRf);
        pbCommenFloorItemViewHolder.uW(true);
        pbCommenFloorItemViewHolder.lRw.setConstrainLayoutPool(this.joC);
        pbCommenFloorItemViewHolder.lRw.setImageViewPool(this.joD);
        e(pbCommenFloorItemViewHolder);
        com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, (f) null, this.lTP);
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
        if (this.lTP) {
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
        pbCommenFloorItemViewHolder.lRv.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && pbCommenFloorItemViewHolder.getView() != null) {
                    pbCommenFloorItemViewHolder.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.bdi.onClick(pbCommenFloorItemViewHolder.getView());
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
            postData2.bpf();
            a(pbCommenFloorItemViewHolder, postData2, view, i);
            b(pbCommenFloorItemViewHolder, postData);
            b(pbCommenFloorItemViewHolder, postData, i);
        }
        com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, (f) null, this.lTP);
        pbCommenFloorItemViewHolder.mBottomLine.setVisibility(i == 0 ? 8 : 0);
        return view;
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lRn != null) {
            if (au.equals(this.mky, postData.getId())) {
                ap.setBackgroundColor(pbCommenFloorItemViewHolder.lRn, R.color.CAM_X0313);
            } else {
                ap.setBackgroundColor(pbCommenFloorItemViewHolder.lRn, R.color.CAM_X0205);
            }
        }
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, view, i, this.mkx, this.aiB, this.lTP);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, this.aiB, i, this.lTP);
            if (this.lTP && postData.nAa) {
                pbCommenFloorItemViewHolder.lRx.setVisibility(8);
                pbCommenFloorItemViewHolder.lRB.setVisibility(0);
                if (this.aiB.bmB()) {
                    pbCommenFloorItemViewHolder.lRP.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.lRP.setVisibility(0);
                }
            } else {
                pbCommenFloorItemViewHolder.lRB.setVisibility(8);
                pbCommenFloorItemViewHolder.lRx.setVisibility(0);
                pbCommenFloorItemViewHolder.jVW.setVisibility(0);
                pbCommenFloorItemViewHolder.jVU.setVisibility(0);
                pbCommenFloorItemViewHolder.lRt.setVisibility(0);
                pbCommenFloorItemViewHolder.lRP.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, postData.nAa, this.lTP);
            com.baidu.tieba.pb.pb.b.a(this.mkx, pbCommenFloorItemViewHolder, postData, view, this.lQl, this.mIsFromCDN, i != 0, this.lRd);
            com.baidu.tieba.pb.pb.b.a(this.mkx, pbCommenFloorItemViewHolder, postData, this.aiB);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData);
            com.baidu.tieba.pb.pb.b.a(pbCommenFloorItemViewHolder, postData, this.lQl);
            j(pbCommenFloorItemViewHolder, postData);
        }
    }

    private void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.lRZ.setVisibility(postData.nzW ? 0 : 8);
        }
    }

    private void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lRv.setTextViewOnTouchListener(this.fxj);
        pbCommenFloorItemViewHolder.lRv.setTextViewCheckSelection(false);
    }

    private void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        if (this.lTP) {
            if (pbCommenFloorItemViewHolder.lRD != null) {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.lRD.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.lRD.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (pbCommenFloorItemViewHolder.lRC != null) {
                SparseArray sparseArray2 = (SparseArray) pbCommenFloorItemViewHolder.lRC.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.lRC.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (pbCommenFloorItemViewHolder.jVW != null) {
            SparseArray sparseArray3 = (SparseArray) pbCommenFloorItemViewHolder.jVW.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.jVW.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (pbCommenFloorItemViewHolder.jVU != null) {
            SparseArray sparseArray4 = (SparseArray) pbCommenFloorItemViewHolder.jVU.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                pbCommenFloorItemViewHolder.jVU.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.nAa));
        }
    }

    public void uT(boolean z) {
        this.lRg = z;
    }

    private void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        if (pbCommenFloorItemViewHolder != null && postData != null) {
            if (i == 0) {
                pbCommenFloorItemViewHolder.c(postData.nzP, postData.getId(), this.lRg);
            } else {
                pbCommenFloorItemViewHolder.c(postData.isAuthorView == 1, postData.getId(), this.lRg);
            }
        }
    }

    private void b(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        pbCommenFloorItemViewHolder.lRn.setOnLongClickListener(this.mOnLongClickListener);
        if (this.mkx != null && this.mkx.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a dmx = this.mkx.dmx();
            if (dmx != null) {
                pbCommenFloorItemViewHolder.idX.setOnClickListener(dmx.iRC);
                pbCommenFloorItemViewHolder.lRu.setOnClickListener(dmx.iRC);
                pbCommenFloorItemViewHolder.lRM.setOnClickListener(dmx.iRC);
                pbCommenFloorItemViewHolder.lRM.getHeadView().setOnClickListener(dmx.iRC);
                pbCommenFloorItemViewHolder.lRv.setOnEmotionClickListener(dmx.mgr);
            }
            pbCommenFloorItemViewHolder.lRv.setOnLongClickListener(this.mOnLongClickListener);
            pbCommenFloorItemViewHolder.lRv.setOnImageClickListener(this.fVW);
            pbCommenFloorItemViewHolder.lRv.setOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.getView().setOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.lRQ.setOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.lRR.setOnClickListener(this.bdi);
            if (this.lPB == null) {
                this.lPB = new com.baidu.tieba.pb.pb.main.b.c(this.mkx.getPageContext());
            }
            if (this.lTP) {
                pbCommenFloorItemViewHolder.lRD.setOnClickListener(this.bdi);
                pbCommenFloorItemViewHolder.lRC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lRn != null && b.this.lPB != null) {
                                e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.lPB.mgG.a(null, b.this.aiB, postData, pbCommenFloorItemViewHolder.lRv.getLayoutStrategy());
                                    }
                                }, 100L);
                                String id = b.this.aiB.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.aiB.bmq();
                                }
                                TiebaStatic.log(new ar("c13700").dR("tid", id).v("fid", b.this.aiB.getFid()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).aq("obj_source", 1).aq("obj_type", 4));
                            }
                        }
                    }
                });
                pbCommenFloorItemViewHolder.lRJ.ffY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.aiB != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lRJ != null && pbCommenFloorItemViewHolder.lRJ.getData() != null) {
                            int i = view == pbCommenFloorItemViewHolder.lRJ.getImgAgree() ? 1 : 2;
                            String id = b.this.aiB.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.aiB.bmq();
                            }
                            TiebaStatic.log(new ar("c13700").dR("tid", id).v("fid", b.this.aiB.getFid()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lRJ.getData().postId).aq("obj_source", 1).aq("obj_type", i));
                        }
                    }
                };
            }
            pbCommenFloorItemViewHolder.jVW.setOnClickListener(this.bdi);
            pbCommenFloorItemViewHolder.jVU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && pbCommenFloorItemViewHolder.lRn != null && b.this.lPB != null) {
                            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.lPB.mgG.a(null, b.this.aiB, postData, pbCommenFloorItemViewHolder.lRv.getLayoutStrategy());
                                }
                            }, 100L);
                            String id = b.this.aiB.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.aiB.bmq();
                            }
                            TiebaStatic.log(new ar("c13700").dR("tid", id).v("fid", b.this.aiB.getFid()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).aq("obj_source", 1).aq("obj_type", 4));
                        }
                    }
                }
            });
            pbCommenFloorItemViewHolder.lRt.ffY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.adapter.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.aiB != null && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.lRt != null && pbCommenFloorItemViewHolder.lRt.getData() != null) {
                        int i = view == pbCommenFloorItemViewHolder.lRt.getImgAgree() ? 1 : 2;
                        String id = b.this.aiB.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.aiB.bmq();
                        }
                        TiebaStatic.log(new ar("c13700").dR("tid", id).v("fid", b.this.aiB.getFid()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", pbCommenFloorItemViewHolder.lRt.getData().postId).aq("obj_source", 1).aq("obj_type", i));
                    }
                }
            };
            if (this.lTP) {
                pbCommenFloorItemViewHolder.lRP.setOnClickListener(this.bdi);
            }
        }
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdi = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fVW = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(cb cbVar) {
        this.aiB = cbVar;
    }

    public void Qh(String str) {
        this.mky = str;
    }
}
