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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    private View.OnClickListener aIH;
    protected bk aee;
    private int avV;
    private TbRichTextView.i eBC;
    private com.baidu.tieba.pb.a.c efF;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hsh;
    private com.baidu.adp.lib.d.b<TbImageView> hsi;
    public com.baidu.tieba.pb.pb.main.b.c jGS;
    private boolean jHv;
    private TbRichTextView.c jIl;
    private boolean jIn;
    private boolean jIo;
    private String kai;
    private View.OnLongClickListener mOnLongClickListener;

    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        this.aee = null;
        this.jIl = null;
        this.jHv = k.aNQ().isShowImages();
        this.aIH = null;
        this.eBC = null;
        this.efF = null;
        this.mOnLongClickListener = null;
        this.jIn = com.baidu.tbadk.a.d.aMp();
        this.jIo = com.baidu.tbadk.a.d.aMo();
        this.hsh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bXl */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(b.this.kah.getPageContext().getPageActivity());
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
        this.hsi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.sub.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aWM */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(b.this.kah.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10043));
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
        if (newSubPbActivity != null && newSubPbActivity.cJn() != null) {
            this.avV = newSubPbActivity.cJn().cKd();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bS */
    public l b(ViewGroup viewGroup) {
        l lVar = new l(this.kah.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.avV, this.jIn);
        lVar.rq(true);
        lVar.jIF.setConstrainLayoutPool(this.hsh);
        lVar.jIF.setImageViewPool(this.hsi);
        e(lVar);
        com.baidu.tieba.pb.pb.b.cDr();
        com.baidu.tieba.pb.pb.b.a(lVar, (e) null, this.jIn);
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
        if (lVar.jIV.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) lVar.jIV.getLayoutParams();
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams3.leftMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        layoutParams3.rightMargin = com.baidu.tieba.pb.pb.b.getDimensionPixelSize(R.dimen.tbds2);
        lVar.jIV.setLayoutParams(layoutParams3);
        lVar.jIE.setCommonTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && lVar.getView() != null) {
                    lVar.getView().setTag(R.id.tag_subpb_ban_display_keyboard, true);
                }
                b.this.aIH.onClick(lVar.getView());
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
            postData2.aRK();
            a(lVar, postData2, view, i);
            b(lVar, postData);
        }
        com.baidu.tieba.pb.pb.b.a(lVar, (e) null, this.jIn);
        return view;
    }

    private void b(l lVar, PostData postData) {
        if (lVar != null && lVar.jIv != null) {
            if (aq.equals(this.kai, postData.getId())) {
                am.setBackgroundColor(lVar.jIv, R.color.cp_other_g);
            } else {
                am.setBackgroundColor(lVar.jIv, R.color.cp_bg_line_e);
            }
        }
    }

    private void a(l lVar, PostData postData, View view, int i) {
        if (lVar != null && postData != null) {
            lVar.mPosition = i;
            com.baidu.tieba.pb.pb.b.a(lVar, postData, view, i, this.kah, this.aee);
            com.baidu.tieba.pb.pb.b.a(lVar, postData, this.aee, i);
            if (this.jIn) {
                com.baidu.tieba.pb.pb.b.a(lVar, postData.llJ);
            }
            com.baidu.tieba.pb.pb.b.a(this.kah, lVar, postData, view, this.jHv, this.mIsFromCDN, i != 0, this.jIl);
            com.baidu.tieba.pb.pb.b.a(this.kah, lVar, postData, this.aee);
            com.baidu.tieba.pb.pb.b.a(lVar, postData);
            com.baidu.tieba.pb.pb.b.a(lVar, postData, this.jHv);
            i(lVar, postData);
        }
    }

    private void i(l lVar, PostData postData) {
        if (lVar != null && postData != null) {
            lVar.jIY.setVisibility((!postData.llE || this.jIo) ? 8 : 0);
        }
    }

    private void c(l lVar) {
        lVar.jIE.setTextViewOnTouchListener(this.efF);
        lVar.jIE.setTextViewCheckSelection(false);
    }

    private void a(l lVar, PostData postData, int i) {
        if (this.jIn) {
            if (lVar.jIJ != null) {
                SparseArray sparseArray = (SparseArray) lVar.jIJ.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    lVar.jIJ.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
            }
            if (lVar.igT != null) {
                SparseArray sparseArray2 = (SparseArray) lVar.igT.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    lVar.igT.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
                sparseArray2.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.llJ));
            }
        }
    }

    private void b(final l lVar) {
        lVar.jIv.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kah != null && this.kah.getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a cDn = this.kah.cDn();
            if (cDn != null) {
                lVar.gqT.setOnClickListener(cDn.gWJ);
                lVar.jID.setOnClickListener(cDn.gWJ);
                lVar.jIM.setOnClickListener(cDn.gWJ);
                lVar.jIM.getHeadView().setOnClickListener(cDn.gWJ);
                lVar.jIE.setOnEmotionClickListener(cDn.jWf);
            }
            lVar.jIE.setOnLongClickListener(this.mOnLongClickListener);
            lVar.jIE.setOnImageClickListener(this.eBC);
            lVar.jIE.setOnClickListener(this.aIH);
            lVar.getView().setOnClickListener(this.aIH);
            lVar.jIP.setOnClickListener(this.aIH);
            lVar.jIQ.setOnClickListener(this.aIH);
            if (this.jGS == null) {
                this.jGS = new com.baidu.tieba.pb.pb.main.b.c(this.kah.getPageContext());
            }
            if (this.jIn) {
                lVar.jIJ.setOnClickListener(this.aIH);
                lVar.igT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && lVar.jIv != null && b.this.jGS != null) {
                                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.b.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.jGS.jWu.a(null, b.this.aee, postData, lVar.jIv);
                                    }
                                }, 100L);
                                String id = b.this.aee.getId();
                                if (StringUtils.isNull(id) || "0".equals(id)) {
                                    id = b.this.aee.getNid();
                                }
                                TiebaStatic.log(new an("c13700").dh("tid", id).s("fid", b.this.aee.getFid()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", postData.getId()).ag("obj_type", 4));
                            }
                        }
                    }
                });
                lVar.jIB.dRF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.b.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && b.this.aee != null && lVar != null && lVar.jIB != null && lVar.jIB.getData() != null) {
                            int i = view == lVar.jIB.getImgAgree() ? 1 : 2;
                            String id = b.this.aee.getId();
                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                id = b.this.aee.getNid();
                            }
                            TiebaStatic.log(new an("c13700").dh("tid", id).s("fid", b.this.aee.getFid()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dh("post_id", lVar.jIB.getData().postId).ag("obj_type", i));
                        }
                    }
                };
            }
        }
    }

    public void y(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBC = iVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void setThreadData(bk bkVar) {
        this.aee = bkVar;
    }

    public void JR(String str) {
        this.kai = str;
    }
}
