package com.baidu.tieba.pb.pb.sub.a;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class b extends a<PostData, l> {
    private View.OnClickListener aLl;
    protected bu aeK;
    private int ayd;
    private TbRichTextView.i eLw;
    private com.baidu.tieba.pb.a.c eor;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hFi;
    private com.baidu.adp.lib.d.b<TbImageView> hFj;
    public com.baidu.tieba.pb.pb.main.b.c kbI;
    private TbRichTextView.c kcZ;
    private boolean kcl;
    private boolean kdb;
    private boolean kdc;
    private String kvc;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.aeK = null;
        this.kcZ = null;
        this.kcl = k.aPA().isShowImages();
        this.aLl = null;
        this.eLw = null;
        this.eor = null;
        this.mOnLongClickListener = null;
        this.kdb = com.baidu.tbadk.a.d.aNS();
        this.kdc = com.baidu.tbadk.a.d.aNR();
        this.hFi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cay */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.kvb.getPageContext().getPageActivity());
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
        this.hFj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aYG */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.kvb.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(an.getColor(R.color.common_color_10043));
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
        if (newSubPbActivity != null && newSubPbActivity.cNU() != null) {
            this.ayd = newSubPbActivity.cNU().cOK();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ce */
    public l b(ViewGroup viewGroup) {
        l lVar = new l(this.kvb.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.ayd, this.kdb);
        lVar.rD(true);
        lVar.kdt.setConstrainLayoutPool(this.hFi);
        lVar.kdt.setImageViewPool(this.hFj);
        e(lVar);
        com.baidu.tieba.pb.pb.b.cHX();
        com.baidu.tieba.pb.pb.b.a(lVar, (e) null, this.kdb);
        return lVar;
    }

    private void e(final l lVar) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        if (lVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) lVar.mBottomLine.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds1);
        layoutParams.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds180);
        lVar.mBottomLine.setLayoutParams(layoutParams);
        ColumnLayout columnLayout = (ColumnLayout) lVar.getView().findViewById(R.id.item_head_owner_root);
        if (columnLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) columnLayout.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams2.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds31);
        layoutParams2.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds1);
        columnLayout.setLayoutParams(layoutParams2);
        if (lVar.kdJ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) lVar.kdJ.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        lVar.kdJ.setLayoutParams(layoutParams3);
        lVar.kds.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && lVar.getView() != null) {
                    lVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aLl.onClick(lVar.getView());
                if (view != null) {
                    view.setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
                if (lVar.getView() != null) {
                    lVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.sub.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, l lVar) {
        a(lVar, postData, i);
        b(lVar);
        c(lVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.aTB();
            a(lVar, postData2, view, i);
            b(lVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(lVar, (e) null, this.kdb);
        return view;
    }

    private void b(l lVar, PostData postData) {
        if (lVar != null && lVar.kdj != null) {
            if (ar.equals(this.kvc, postData.getId())) {
                an.setBackgroundColor(lVar.kdj, R.color.cp_other_g);
            } else {
                an.setBackgroundColor(lVar.kdj, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            lVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(lVar, postData, view, i, this.kvb, this.aeK);
            com.baidu.tieba.pb.pb.b.a(lVar, postData, this.aeK, i);
            if (this.kdb) {
                com.baidu.tieba.pb.pb.b.a(lVar, postData.lGK);
            }
            com.baidu.tieba.pb.pb.b.a(this.kvb, lVar, postData, view, this.kcl, this.mIsFromCDN, i != 0, this.kcZ);
            com.baidu.tieba.pb.pb.b.a(this.kvb, lVar, postData, this.aeK);
            com.baidu.tieba.pb.pb.b.a(lVar, postData);
            com.baidu.tieba.pb.pb.b.a(lVar, postData, this.kcl);
            i(lVar, postData);
        }
    }

    private void i(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.kdM.setVisibility((!postData.lGG || this.kdc) ? 8 : 0);
        }
    }

    private void c(l lVar) {
        lVar.kds.setTextViewOnTouchListener(this.eor);
        lVar.kds.setTextViewCheckSelection(false);
    }

    private void a(l lVar, PostData postData, int i) {
        if (this.kdb) {
            if (lVar.kdx != null) {
                SparseArray sparseArray = (SparseArray) lVar.kdx.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    lVar.kdx.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (lVar.iyL != null) {
                SparseArray sparseArray2 = (SparseArray) lVar.iyL.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    lVar.iyL.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
                sparseArray2.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.lGK));
            }
        }
    }

    private void b(final l lVar) {
        lVar.kdj.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kvb != null && this.kvb.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a cHT = this.kvb.cHT();
            if (cHT != null) {
                lVar.gDT.setOnClickListener(cHT.hjK);
                lVar.kdr.setOnClickListener(cHT.hjK);
                lVar.kdA.setOnClickListener(cHT.hjK);
                lVar.kdA.getHeadView().setOnClickListener(cHT.hjK);
                lVar.kds.setOnEmotionClickListener(cHT.krb);
            }
            lVar.kds.setOnLongClickListener(this.mOnLongClickListener);
            lVar.kds.setOnImageClickListener(this.eLw);
            lVar.kds.setOnClickListener(this.aLl);
            lVar.getView().setOnClickListener(this.aLl);
            lVar.kdD.setOnClickListener(this.aLl);
            lVar.kdE.setOnClickListener(this.aLl);
            if (this.kbI == null) {
                this.kbI = new com.baidu.tieba.pb.pb.main.b.c(this.kvb.getPageContext());
            }
            if (this.kdb) {
                lVar.kdx.setOnClickListener(this.aLl);
                lVar.iyL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && lVar.kdj != null && b.this.kbI != null) {
                                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.kbI.krq.a(null, b.this.aeK, postData, lVar.kdj);
                                    }
                                }, 100L);
                                String id = b.this.aeK.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.aeK.getNid();
                                }
                                TiebaStatic.log(new ao("c13700").dk("tid", id).s("fid", b.this.aeK.getFid()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dk("post_id", postData.getId()).ag("obj_type", 4));
                            }
                        }
                    }
                });
                lVar.kdp.dYx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.aeK != null && lVar != null && lVar.kdp != null && lVar.kdp.getData() != null) {
                            int i = view == lVar.kdp.getImgAgree() ? 1 : 2;
                            String id = b.this.aeK.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.aeK.getNid();
                            }
                            TiebaStatic.log(new ao("c13700").dk("tid", id).s("fid", b.this.aeK.getFid()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dk("post_id", lVar.kdp.getData().postId).ag("obj_type", i));
                        }
                    }
                };
            }
        }
    }

    public void z(View.OnClickListener onClickListener) {
        this.aLl = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eLw = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bu buVar) {
        this.aeK = buVar;
    }

    public void Ku(String str) {
        this.kvc = str;
    }
}
