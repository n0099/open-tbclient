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
/* loaded from: classes21.dex */
public class b extends a<PostData, n> {
    private int aFO;
    private View.OnClickListener aTZ;
    protected bw agf;
    private com.baidu.tieba.pb.a.c eHq;
    private TbRichTextView.i ffu;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> igv;
    private com.baidu.adp.lib.d.b<TbImageView> igw;
    private boolean kIL;
    public com.baidu.tieba.pb.pb.main.b.c kIk;
    private TbRichTextView.c kJA;
    private boolean kJC;
    private boolean kJD;
    private boolean kJE;
    private String lco;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.agf = null;
        this.kJA = null;
        this.kIL = k.bcG().isShowImages();
        this.aTZ = null;
        this.ffu = null;
        this.eHq = null;
        this.mOnLongClickListener = null;
        this.kJC = com.baidu.tbadk.a.d.baU();
        this.kJD = com.baidu.tbadk.a.d.baV();
        this.kJE = com.baidu.tbadk.a.d.baQ();
        this.igv = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: crP */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.lcn.getPageContext().getPageActivity());
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
        this.igw = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blW */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.lcn.getPageContext().getPageActivity());
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
        if (newSubPbActivity != null && newSubPbActivity.dgd() != null) {
            this.aFO = newSubPbActivity.dgd().dgU();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cd */
    public n c(ViewGroup viewGroup) {
        n nVar = new n(this.lcn.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aFO, this.kJC, this.kJD);
        nVar.sY(true);
        nVar.kJV.setConstrainLayoutPool(this.igv);
        nVar.kJV.setImageViewPool(this.igw);
        e(nVar);
        com.baidu.tieba.pb.pb.b.daa();
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.kJC);
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
        if (this.kJC) {
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
        if (nVar.kKw.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) nVar.kKw.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        nVar.kKw.setLayoutParams(layoutParams3);
        nVar.kJU.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && nVar.getView() != null) {
                    nVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aTZ.onClick(nVar.getView());
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
            postData2.bgK();
            a(nVar, postData2, view, i);
            b(nVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(nVar, (f) null, this.kJC);
        return view;
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.kJM != null) {
            if (at.equals(this.lco, postData.getId())) {
                ap.setBackgroundColor(nVar.kJM, R.color.cp_other_g);
            } else {
                ap.setBackgroundColor(nVar.kJM, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(nVar, postData, view, i, this.lcn, this.agf, this.kJC);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.agf, i, this.kJC);
            if (this.kJC && postData.mpy) {
                nVar.kJW.setVisibility(8);
                nVar.kKb.setVisibility(0);
                if (this.agf.bei()) {
                    nVar.kKp.setVisibility(8);
                } else {
                    nVar.kKp.setVisibility(0);
                }
            } else {
                nVar.kKb.setVisibility(8);
                nVar.kJW.setVisibility(0);
                nVar.kKa.setVisibility(0);
                nVar.jcB.setVisibility(0);
                nVar.kJS.setVisibility(0);
                nVar.kKp.setVisibility(8);
            }
            com.baidu.tieba.pb.pb.b.a(nVar, postData, postData.mpy, this.kJC);
            com.baidu.tieba.pb.pb.b.a(this.lcn, nVar, postData, view, this.kIL, this.kJE, this.mIsFromCDN, i != 0, this.kJA);
            com.baidu.tieba.pb.pb.b.a(this.lcn, nVar, postData, this.agf);
            com.baidu.tieba.pb.pb.b.a(nVar, postData);
            com.baidu.tieba.pb.pb.b.a(nVar, postData, this.kIL);
            i(nVar, postData);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.kKz.setVisibility(postData.mpu ? 0 : 8);
        }
    }

    private void c(n nVar) {
        nVar.kJU.setTextViewOnTouchListener(this.eHq);
        nVar.kJU.setTextViewCheckSelection(false);
    }

    private void a(n nVar, PostData postData, int i) {
        if (this.kJC) {
            if (nVar.kKd != null) {
                SparseArray sparseArray = (SparseArray) nVar.kKd.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.kKd.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.kKc != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.kKc.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.kKc.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
        }
        if (nVar.kKa != null) {
            SparseArray sparseArray3 = (SparseArray) nVar.kKa.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                nVar.kKa.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        if (nVar.jcB != null) {
            SparseArray sparseArray4 = (SparseArray) nVar.jcB.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                nVar.jcB.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, postData);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.mpy));
        }
    }

    private void b(final n nVar) {
        nVar.kJM.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lcn != null && this.lcn.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a cZW = this.lcn.cZW();
            if (cZW != null) {
                nVar.gZE.setOnClickListener(cZW.hJr);
                nVar.kJT.setOnClickListener(cZW.hJr);
                nVar.kKm.setOnClickListener(cZW.hJr);
                nVar.kKm.getHeadView().setOnClickListener(cZW.hJr);
                nVar.kJU.setOnEmotionClickListener(cZW.kYp);
            }
            nVar.kJU.setOnLongClickListener(this.mOnLongClickListener);
            nVar.kJU.setOnImageClickListener(this.ffu);
            nVar.kJU.setOnClickListener(this.aTZ);
            nVar.getView().setOnClickListener(this.aTZ);
            nVar.kKq.setOnClickListener(this.aTZ);
            nVar.kKr.setOnClickListener(this.aTZ);
            if (this.kIk == null) {
                this.kIk = new com.baidu.tieba.pb.pb.main.b.c(this.lcn.getPageContext());
            }
            if (this.kJC) {
                nVar.kKd.setOnClickListener(this.aTZ);
                nVar.kKc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kJM != null && b.this.kIk != null) {
                                e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.kIk.kYE.a(null, b.this.agf, postData, nVar.kJU.getLayoutStrategy());
                                    }
                                }, 100L);
                                String id = b.this.agf.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.agf.getNid();
                                }
                                TiebaStatic.log(new aq("c13700").dF("tid", id).u("fid", b.this.agf.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("post_id", postData.getId()).ai("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.kKj.eqE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.agf != null && nVar != null && nVar.kKj != null && nVar.kKj.getData() != null) {
                            int i = view == nVar.kKj.getImgAgree() ? 1 : 2;
                            String id = b.this.agf.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.agf.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dF("tid", id).u("fid", b.this.agf.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("post_id", nVar.kKj.getData().postId).ai("obj_type", i));
                        }
                    }
                };
            }
            nVar.kKa.setOnClickListener(this.aTZ);
            nVar.jcB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kJM != null && b.this.kIk != null) {
                            e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.kIk.kYE.a(null, b.this.agf, postData, nVar.kJU.getLayoutStrategy());
                                }
                            }, 100L);
                            String id = b.this.agf.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.agf.getNid();
                            }
                            TiebaStatic.log(new aq("c13700").dF("tid", id).u("fid", b.this.agf.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("post_id", postData.getId()).ai("obj_type", 4));
                        }
                    }
                }
            });
            nVar.kJS.eqE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && b.this.agf != null && nVar != null && nVar.kJS != null && nVar.kJS.getData() != null) {
                        int i = view == nVar.kJS.getImgAgree() ? 1 : 2;
                        String id = b.this.agf.getId();
                        if (StringUtils.isNull(id) || "0".equals(id)) {
                            id = b.this.agf.getNid();
                        }
                        TiebaStatic.log(new aq("c13700").dF("tid", id).u("fid", b.this.agf.getFid()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("post_id", nVar.kJS.getData().postId).ai("obj_type", i));
                    }
                }
            };
            if (this.kJC) {
                nVar.kKp.setOnClickListener(this.aTZ);
            }
        }
    }

    public void A(View.OnClickListener onClickListener) {
        this.aTZ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.ffu = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bw bwVar) {
        this.agf = bwVar;
    }

    public void OD(String str) {
        this.lco = str;
    }
}
