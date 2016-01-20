package com.baidu.tieba.pb.pb.main;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class cp extends ce<com.baidu.tieba.tbadkCore.data.r, cs> implements View.OnClickListener {
    private TbRichTextView.d aFq;
    private final TbRichTextView.e aFr;
    private View.OnLongClickListener amQ;
    private ArrayList<IconData> bcl;
    private View.OnClickListener bjD;
    protected final a.InterfaceC0072a cBf;
    protected boolean cDQ;
    private com.baidu.tieba.pb.a.c cDR;
    private String cDX;
    private com.baidu.tieba.pb.pb.sub.am cDY;
    private ArrayList<IconData> cDZ;
    private com.baidu.tieba.tbadkCore.data.r cDb;
    protected int cDq;
    protected boolean cDr;
    private boolean cDs;
    private com.baidu.tieba.pb.b.c cDu;
    private boolean cDw;
    private final boolean cDx;
    private int cDy;
    private int cDz;
    private View.OnClickListener cEa;
    protected HashMap<Long, HashSet<String>> cHQ;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cDq = 0;
        this.cDr = true;
        this.cDQ = true;
        this.cDs = true;
        this.cDR = null;
        this.cDb = null;
        this.cDX = null;
        this.cDY = null;
        this.cDZ = null;
        this.bcl = null;
        this.cEa = null;
        this.bjD = null;
        this.cDu = null;
        this.amQ = null;
        this.aFq = null;
        this.cDw = false;
        this.cDx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.cHQ = new HashMap<>();
        this.cBf = new cq(this);
        this.aFr = new cr(this);
        init();
    }

    private void init() {
        this.cDy = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds30);
        this.cDz = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public cs a(ViewGroup viewGroup) {
        return new cs(LayoutInflater.from(this.mContext).inflate(n.h.pb_newchudian_base_item, viewGroup, false), this.cDQ, this.cDr, this.cDq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ce, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, cs csVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) csVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(csVar);
        this.cDb = (com.baidu.tieba.tbadkCore.data.r) au(i);
        com.baidu.tbadk.core.util.as.j(csVar.cEj, n.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.j(csVar.cEk, n.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.as.b(csVar.aLp, n.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.as.c(csVar.cHS, n.f.icon_tuiguang);
        com.baidu.tbadk.core.util.as.b(csVar.cEr, n.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.as.b(csVar.bIB, n.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.as.c(csVar.cEt, n.f.btn_pb_more_selector);
        com.baidu.tbadk.core.util.as.c(csVar.cGF, n.f.btn_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.as.c(csVar.cEw, n.d.cp_bg_line_b);
        if (this.cDb != null) {
            a(csVar, this.cDb, view, false, i);
        }
        if (!this.cDw && this.cDx && csVar != null && csVar.cDC.Gc() && (listView = ((PbActivity) this.cGj.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cDw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(cs csVar, com.baidu.tieba.tbadkCore.data.r rVar, View view, boolean z, int i) {
        com.baidu.tieba.tbadkCore.data.h aFA;
        SparseArray sparseArray;
        if (csVar != null && rVar != null && (aFA = rVar.aFA()) != null) {
            this.cBf.t(null, "IMAGE0", "VIEW_TRUE");
            csVar.cDC.setOnLinkImageClickListener(this.aFr);
            csVar.cEn.setTag(null);
            csVar.cEn.setUserId(null);
            csVar.aLp.setText((CharSequence) null);
            csVar.cEx.setVisibility(0);
            csVar.cEt.setVisibility(0);
            SparseArray sparseArray2 = (SparseArray) csVar.cEu.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                csVar.cEu.setTag(sparseArray2);
                csVar.cDC.setTag(sparseArray2);
            }
            sparseArray2.put(n.g.tag_clip_board, rVar);
            sparseArray2.put(n.g.tag_is_subpb, false);
            a(csVar.cDC, (int) this.mContext.getResources().getDimension(n.e.ds30));
            if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cDr) {
                sparseArray2.put(n.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) csVar.cDC.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                csVar.cDC.setLayoutParams(layoutParams);
                csVar.cDC.setPadding(0, 0, 0, 0);
                csVar.cDC.gl(null);
            } else {
                sparseArray2.put(n.g.tag_richtext_bg, rVar.getBimg_url());
                csVar.cDC.gl(rVar.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) csVar.cDC.getLayoutParams();
                layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(n.e.ds20);
                layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(n.e.ds20);
                csVar.cDC.setLayoutParams(layoutParams2);
            }
            csVar.bIB.setText(com.baidu.tbadk.core.util.ax.s(rVar.getTime()));
            com.baidu.tbadk.core.util.as.j(csVar.cEi, n.d.cp_bg_line_e);
            if (i == 1) {
                if (this.cDs) {
                    csVar.cEj.setVisibility(8);
                    csVar.cEk.setVisibility(8);
                    PraiseData praise = this.cDR.akH().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        csVar.cEk.setVisibility(8);
                        csVar.cEj.setVisibility(0);
                    } else {
                        csVar.cEk.setVisibility(0);
                        csVar.cEj.setVisibility(8);
                    }
                } else {
                    csVar.cEj.setVisibility(0);
                    csVar.cEk.setVisibility(8);
                }
            } else {
                csVar.cEj.setVisibility(0);
                csVar.cEk.setVisibility(8);
            }
            csVar.cEl.setVisibility(0);
            csVar.cEu.setVisibility(0);
            csVar.bIB.setVisibility(0);
            String format = String.format(this.mContext.getString(n.j.is_floor), Integer.valueOf(rVar.aFq()));
            csVar.cEr.setVisibility(0);
            csVar.cEr.setText(format);
            if (!this.cDQ) {
                a(csVar.cDC, (int) this.mContext.getResources().getDimension(n.e.ds74));
            } else {
                a(csVar.cDC, (int) this.mContext.getResources().getDimension(n.e.ds104));
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) csVar.cEv.getLayoutParams();
            if (!this.cDQ) {
                layoutParams3.leftMargin = 0;
            } else {
                layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(n.e.ds30);
            }
            com.baidu.tbadk.core.util.as.i(csVar.cEm, n.f.bg_floor_new_middle);
            csVar.cDC.setVideoImageId(n.f.pic_video);
            csVar.cDC.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.pb_listitem_content));
            com.baidu.tbadk.core.util.as.c(csVar.cEt, n.f.btn_pb_more_selector);
            csVar.cDC.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) csVar.cEt.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                csVar.cEt.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(n.g.tag_clip_board, rVar);
            sparseArray.put(n.g.tag_load_sub_data, rVar);
            sparseArray.put(n.g.tag_load_sub_view, view);
            SparseArray sparseArray5 = (SparseArray) csVar.cGF.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                csVar.cGF.setTag(sparseArray5);
            }
            sparseArray5.put(n.g.tag_clip_board, rVar);
            sparseArray5.put(n.g.tag_load_sub_data, rVar);
            sparseArray5.put(n.g.tag_load_sub_view, view);
            if (rVar.aFu() > 0) {
                if (this.cDY == null) {
                    this.cDY = new com.baidu.tieba.pb.pb.sub.am(this.mContext);
                    this.cDY.setIsFromCDN(this.mIsFromCDN);
                    this.cDY.D(this.cEa);
                    boolean z2 = false;
                    String userId = this.cDR.akH().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                    }
                    this.cDY.r(this.cDR.akL(), z2);
                    this.cDY.g(this.cDR.akH());
                    this.cDY.eU(this.cDQ);
                }
                csVar.cEx.setVisibility(0);
                csVar.cEw.setVisibility(0);
                csVar.cEv.setVisibility(0);
                csVar.cEx.a(rVar, view);
                csVar.cEx.setChildOnClickListener(this.bjD);
                csVar.cEx.setChildOnLongClickListener(this.amQ);
                csVar.cEx.setChildOnTouchListener(this.cDu);
                csVar.cEx.setSubPbAdapter(this.cDY);
                csVar.cEx.setVisibility(0);
            } else {
                csVar.cEx.setVisibility(8);
                csVar.cEw.setVisibility(8);
                csVar.cEv.setVisibility(8);
            }
            String portrait = rVar.getAuthor().getPortrait();
            if (rVar.getAuthor() != null) {
                String name_show = rVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.o.gi(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.o.e(name_show, 0, 14)) + "...";
                }
                csVar.aLp.setText(name_show);
                ArrayList<IconData> tShowInfo = rVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.as.b(csVar.aLp, n.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.as.b(csVar.aLp, n.d.cp_cont_f, 1);
                }
                int i2 = 3;
                if (rVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.as.c(csVar.cEq, n.f.icon_pb_pop_girl);
                    csVar.cEq.setVisibility(0);
                } else if (rVar.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.as.c(csVar.cEq, n.f.icon_pb_pop_boy);
                    csVar.cEq.setVisibility(0);
                } else {
                    csVar.cEq.setVisibility(8);
                }
                if (com.baidu.tbadk.util.o.gi(rVar.getAuthor().getName_show()) >= 14 && csVar.cHS.getVisibility() == 0) {
                    i2 = 2;
                }
                this.cDZ = rVar.getAuthor().getIconInfo();
                this.bcl = rVar.getAuthor().getTShowInfoNew();
                if (csVar.bnP != null) {
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 == this.cDZ.size()) {
                            break;
                        }
                        IconData iconData = this.cDZ.get(i4);
                        if (!com.baidu.tbadk.core.util.ax.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                            arrayList.add(iconData);
                        }
                        i3 = i4 + 1;
                    }
                    csVar.bnP.setTag(n.g.tag_user_id, rVar.getAuthor().getUserId());
                    csVar.bnP.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.bhv);
                    csVar.bnP.a(arrayList, i2, this.mContext.getResources().getDimensionPixelSize(n.e.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(n.e.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(n.e.pb_icon_margin));
                }
                if (csVar.agT != null) {
                    csVar.agT.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKn);
                    if (this.bcl != null && this.bcl.size() > 0 && this.bcl.get(0) != null) {
                        csVar.agT.setTag(this.bcl.get(0).getUrl());
                    }
                    csVar.agT.a(this.bcl, 3, this.mContext.getResources().getDimensionPixelSize(n.e.ds60), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_margin), true);
                }
            }
            csVar.cEn.setUserId(rVar.getAuthor().getUserId());
            csVar.cEn.setUserName(rVar.getAuthor().getUserName());
            csVar.cEn.setImageDrawable(null);
            csVar.aLp.setTag(n.g.tag_user_id, rVar.getAuthor().getUserId());
            csVar.aLp.setTag(n.g.tag_user_name, rVar.getAuthor().getUserName());
            csVar.cEn.d(portrait, 28, false);
            csVar.cDC.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_link_tip_c));
            if (this.cDr) {
                csVar.cDC.setDefaultImageId(n.f.img_default_100);
            } else {
                csVar.cDC.setDefaultImageId(n.f.icon_click);
            }
            csVar.cDC.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = rVar.aFr();
            }
            if (this.cDw || !this.cDx) {
                csVar.cDC.a(aVar, false);
            } else {
                csVar.cDC.a(aVar, true);
            }
            boolean z3 = false;
            if (this.cDR != null && this.cDR.akH() != null && this.cDR.akH().getAuthor() != null && rVar.getAuthor() != null) {
                String userId2 = this.cDR.akH().getAuthor().getUserId();
                String userId3 = rVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId2) && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                    }
                }
            }
            if (z3) {
                sparseArray.put(n.g.tag_display_reply_visible, true);
                sparseArray.put(n.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (rVar.getAuthor() != null) {
                    sparseArray.put(n.g.tag_disable_reply_mute_userid, rVar.getAuthor().getUserId());
                    sparseArray.put(n.g.tag_disable_reply_mute_username, rVar.getAuthor().getUserName());
                }
                if (this.cDR.akH() != null) {
                    sparseArray.put(n.g.tag_disable_reply_thread_id, this.cDR.akH().getId());
                }
                sparseArray.put(n.g.tag_disable_reply_post_id, rVar.getId());
            } else {
                sparseArray.put(n.g.tag_display_reply_visible, false);
            }
            sparseArray.put(n.g.tag_should_delete_visible, false);
            sparseArray.put(n.g.tag_display_reply_visible, false);
            sparseArray.put(n.g.tag_should_manage_visible, false);
            sparseArray.put(n.g.tag_user_mute_visible, false);
            sparseArray.put(n.g.tag_should_hide_chudian_visible, true);
            sparseArray.put(n.g.tag_chudian_template_id, Long.valueOf(aFA.getTemplateId()));
            sparseArray.put(n.g.tag_chudian_monitor_id, aFA.aEU());
            a(csVar, rVar, rVar.aFq() == 1, aVar);
            a(csVar);
            csVar.cHT.a(aFA, this.cGj, this.cBf);
        }
    }

    private void a(cs csVar) {
        csVar.cDC.setTextViewOnTouchListener(this.cDu);
        csVar.cDC.setTextViewCheckSelection(false);
    }

    private void a(cs csVar, com.baidu.tieba.tbadkCore.data.r rVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (rVar == null || rVar.aoe() == null) {
            csVar.cEN.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(rVar.aoe(), csVar.cEN, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(rVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cDz - (i - this.cDy));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(cs csVar) {
        csVar.aLp.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKm);
        csVar.cGF.setOnClickListener(this.bjD);
        csVar.cEt.setOnClickListener(this.bjD);
        csVar.cEn.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKm);
        csVar.cEu.setOnLongClickListener(this.amQ);
        csVar.cDC.setOnLongClickListener(this.amQ);
        csVar.cEu.setOnTouchListener(this.cDu);
        csVar.cDC.setOnTouchListener(this.cDu);
        csVar.cDC.setOnImageClickListener(this.aFq);
        csVar.cDC.setOnEmotionClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKo);
        csVar.bnP.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.bhv);
        csVar.agT.setOnClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKn);
        csVar.cEN.setOnClickListener(this.bjD);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cDR = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cDq = i;
    }

    public void eS(boolean z) {
        this.cDr = z;
    }

    public void eU(boolean z) {
        this.cDQ = z;
    }

    public void eT(boolean z) {
        this.cDs = z;
    }

    public void kv(String str) {
        this.cDX = str;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cEa = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bjD = onClickListener;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cDu = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amQ = onLongClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFq = dVar;
    }
}
