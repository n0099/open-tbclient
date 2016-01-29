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
import com.baidu.tieba.pb.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class cw extends cl<com.baidu.tieba.tbadkCore.data.r, cz> implements View.OnClickListener {
    private TbRichTextView.d aGi;
    private final TbRichTextView.e aGj;
    private View.OnLongClickListener anJ;
    private ArrayList<IconData> beA;
    private View.OnClickListener bmy;
    protected final a.InterfaceC0074a cHL;
    private com.baidu.tieba.tbadkCore.data.r cJH;
    protected int cJW;
    protected boolean cJX;
    protected boolean cJY;
    private com.baidu.tieba.pb.a.c cJZ;
    private boolean cKa;
    private com.baidu.tieba.pb.b.c cKb;
    private int cKc;
    private int cKd;
    private boolean cKe;
    private final boolean cKf;
    private String cLq;
    private com.baidu.tieba.pb.pb.sub.am cLr;
    private ArrayList<IconData> cLs;
    private View.OnClickListener cLt;
    protected HashMap<Long, HashSet<String>> cPz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cw(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cJW = 0;
        this.cJX = true;
        this.cJY = true;
        this.cKa = true;
        this.cJZ = null;
        this.cJH = null;
        this.cLq = null;
        this.cLr = null;
        this.cLs = null;
        this.beA = null;
        this.cLt = null;
        this.bmy = null;
        this.cKb = null;
        this.anJ = null;
        this.aGi = null;
        this.cKe = false;
        this.cKf = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.cPz = new HashMap<>();
        this.cHL = new cx(this);
        this.aGj = new cy(this);
        init();
    }

    private void init() {
        this.cKc = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.cKd = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public cz b(ViewGroup viewGroup) {
        return new cz(LayoutInflater.from(this.mContext).inflate(t.h.pb_newchudian_base_item, viewGroup, false), this.cJY, this.cJX, this.cJW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cl, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, cz czVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) czVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(czVar);
        this.cJH = (com.baidu.tieba.tbadkCore.data.r) aG(i);
        com.baidu.tbadk.core.util.ar.l(czVar.cLz, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.ar.l(czVar.cLA, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.ar.b(czVar.aMu, t.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.ar.c(czVar.cPB, t.f.icon_tuiguang);
        com.baidu.tbadk.core.util.ar.b(czVar.cLH, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ar.b(czVar.cLI, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ar.c(czVar.cLK, t.f.btn_pb_more_selector);
        com.baidu.tbadk.core.util.ar.c(czVar.cOj, t.f.btn_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.ar.c(czVar.cLN, t.d.cp_bg_line_b);
        if (this.cJH != null) {
            a(czVar, this.cJH, view, false, i);
        }
        if (!this.cKe && this.cKf && czVar != null && czVar.cKi.HB() && (listView = ((PbActivity) this.cNL.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cKe = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(cz czVar, com.baidu.tieba.tbadkCore.data.r rVar, View view, boolean z, int i) {
        com.baidu.tieba.tbadkCore.data.h aMF;
        SparseArray sparseArray;
        if (czVar != null && rVar != null && (aMF = rVar.aMF()) != null) {
            this.cHL.u(null, "IMAGE0", "VIEW_TRUE");
            czVar.cKi.setOnLinkImageClickListener(this.aGj);
            czVar.cLD.setTag(null);
            czVar.cLD.setUserId(null);
            czVar.aMu.setText((CharSequence) null);
            czVar.cLO.setVisibility(0);
            czVar.cLK.setVisibility(0);
            SparseArray sparseArray2 = (SparseArray) czVar.cLL.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                czVar.cLL.setTag(sparseArray2);
                czVar.cKi.setTag(sparseArray2);
            }
            sparseArray2.put(t.g.tag_clip_board, rVar);
            sparseArray2.put(t.g.tag_is_subpb, false);
            a(czVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds30));
            if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cJX) {
                sparseArray2.put(t.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) czVar.cKi.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                czVar.cKi.setLayoutParams(layoutParams);
                czVar.cKi.setPadding(0, 0, 0, 0);
                czVar.cKi.gi(null);
            } else {
                sparseArray2.put(t.g.tag_richtext_bg, rVar.getBimg_url());
                czVar.cKi.gi(rVar.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) czVar.cKi.getLayoutParams();
                layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                czVar.cKi.setLayoutParams(layoutParams2);
            }
            czVar.cLI.setText(com.baidu.tbadk.core.util.aw.t(rVar.getTime()));
            com.baidu.tbadk.core.util.ar.l(czVar.cLy, t.d.cp_bg_line_e);
            if (i == 1) {
                if (this.cKa) {
                    czVar.cLz.setVisibility(8);
                    czVar.cLA.setVisibility(8);
                    PraiseData praise = this.cJZ.aoF().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        czVar.cLA.setVisibility(8);
                        czVar.cLz.setVisibility(0);
                    } else {
                        czVar.cLA.setVisibility(0);
                        czVar.cLz.setVisibility(8);
                    }
                } else {
                    czVar.cLz.setVisibility(0);
                    czVar.cLA.setVisibility(8);
                }
            } else {
                czVar.cLz.setVisibility(0);
                czVar.cLA.setVisibility(8);
            }
            czVar.cLB.setVisibility(0);
            czVar.cLL.setVisibility(0);
            czVar.cLI.setVisibility(0);
            String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(rVar.aMw()));
            czVar.cLH.setVisibility(0);
            czVar.cLH.setText(format);
            if (!this.cJY) {
                a(czVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds74));
            } else {
                a(czVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds104));
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) czVar.cLM.getLayoutParams();
            if (!this.cJY) {
                layoutParams3.leftMargin = 0;
            } else {
                layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(t.e.ds30);
            }
            com.baidu.tbadk.core.util.ar.k(czVar.cLC, t.f.bg_floor_new_middle);
            czVar.cKi.setVideoImageId(t.f.pic_video);
            czVar.cKi.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.pb_listitem_content));
            com.baidu.tbadk.core.util.ar.c(czVar.cLK, t.f.btn_pb_more_selector);
            czVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) czVar.cLK.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                czVar.cLK.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, rVar);
            sparseArray.put(t.g.tag_load_sub_data, rVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            SparseArray sparseArray5 = (SparseArray) czVar.cOj.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                czVar.cOj.setTag(sparseArray5);
            }
            sparseArray5.put(t.g.tag_clip_board, rVar);
            sparseArray5.put(t.g.tag_load_sub_data, rVar);
            sparseArray5.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            if (rVar.aMz() > 0) {
                if (this.cLr == null) {
                    this.cLr = new com.baidu.tieba.pb.pb.sub.am(this.mContext);
                    this.cLr.setIsFromCDN(this.mIsFromCDN);
                    this.cLr.J(this.cLt);
                    boolean z2 = false;
                    String userId = this.cJZ.aoF().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                    }
                    this.cLr.t(this.cJZ.aoJ(), z2);
                    this.cLr.h(this.cJZ.aoF());
                    this.cLr.fh(this.cJY);
                }
                czVar.cLO.setVisibility(0);
                czVar.cLN.setVisibility(0);
                czVar.cLM.setVisibility(0);
                czVar.cLO.a(rVar, view);
                czVar.cLO.setChildOnClickListener(this.bmy);
                czVar.cLO.setChildOnLongClickListener(this.anJ);
                czVar.cLO.setChildOnTouchListener(this.cKb);
                czVar.cLO.setSubPbAdapter(this.cLr);
                czVar.cLO.setVisibility(0);
            } else {
                czVar.cLO.setVisibility(8);
                czVar.cLN.setVisibility(8);
                czVar.cLM.setVisibility(8);
            }
            String portrait = rVar.getAuthor().getPortrait();
            if (rVar.getAuthor() != null) {
                String name_show = rVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.o.gf(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.o.d(name_show, 0, 14)) + "...";
                }
                czVar.aMu.setText(name_show);
                ArrayList<IconData> tShowInfo = rVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.ar.b(czVar.aMu, t.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ar.b(czVar.aMu, t.d.cp_cont_f, 1);
                }
                int i2 = 3;
                if (rVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.ar.c(czVar.cLG, t.f.icon_pb_pop_girl);
                    czVar.cLG.setVisibility(0);
                } else if (rVar.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.ar.c(czVar.cLG, t.f.icon_pb_pop_boy);
                    czVar.cLG.setVisibility(0);
                } else {
                    czVar.cLG.setVisibility(8);
                }
                if (com.baidu.tbadk.util.o.gf(rVar.getAuthor().getName_show()) >= 14 && czVar.cPB.getVisibility() == 0) {
                    i2 = 2;
                }
                this.cLs = rVar.getAuthor().getIconInfo();
                this.beA = rVar.getAuthor().getTShowInfoNew();
                if (czVar.bqH != null) {
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 == this.cLs.size()) {
                            break;
                        }
                        IconData iconData = this.cLs.get(i4);
                        if (!com.baidu.tbadk.core.util.aw.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                            arrayList.add(iconData);
                        }
                        i3 = i4 + 1;
                    }
                    czVar.bqH.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
                    czVar.bqH.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.bkj);
                    czVar.bqH.a(arrayList, i2, this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                }
                if (czVar.ahI != null) {
                    czVar.ahI.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSF);
                    if (this.beA != null && this.beA.size() > 0 && this.beA.get(0) != null) {
                        czVar.ahI.setTag(this.beA.get(0).getUrl());
                    }
                    czVar.ahI.a(this.beA, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds60), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
                }
            }
            czVar.cLD.setUserId(rVar.getAuthor().getUserId());
            czVar.cLD.setUserName(rVar.getAuthor().getUserName());
            czVar.cLD.setImageDrawable(null);
            czVar.aMu.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
            czVar.aMu.setTag(t.g.tag_user_name, rVar.getAuthor().getUserName());
            czVar.cLD.d(portrait, 28, false);
            czVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            if (this.cJX) {
                czVar.cKi.setDefaultImageId(t.f.img_default_100);
            } else {
                czVar.cKi.setDefaultImageId(t.f.icon_click);
            }
            czVar.cKi.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = rVar.aiT();
            }
            if (this.cKe || !this.cKf) {
                czVar.cKi.a(aVar, false);
            } else {
                czVar.cKi.a(aVar, true);
            }
            boolean z3 = false;
            if (this.cJZ != null && this.cJZ.aoF() != null && this.cJZ.aoF().getAuthor() != null && rVar.getAuthor() != null) {
                String userId2 = this.cJZ.aoF().getAuthor().getUserId();
                String userId3 = rVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId2) && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z3 = true;
                    if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                    }
                }
            }
            if (z3) {
                sparseArray.put(t.g.tag_display_reply_visible, true);
                sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                if (rVar.getAuthor() != null) {
                    sparseArray.put(t.g.tag_disable_reply_mute_userid, rVar.getAuthor().getUserId());
                    sparseArray.put(t.g.tag_disable_reply_mute_username, rVar.getAuthor().getUserName());
                }
                if (this.cJZ.aoF() != null) {
                    sparseArray.put(t.g.tag_disable_reply_thread_id, this.cJZ.aoF().getId());
                }
                sparseArray.put(t.g.tag_disable_reply_post_id, rVar.getId());
            } else {
                sparseArray.put(t.g.tag_display_reply_visible, false);
            }
            sparseArray.put(t.g.tag_should_delete_visible, false);
            sparseArray.put(t.g.tag_display_reply_visible, false);
            sparseArray.put(t.g.tag_should_manage_visible, false);
            sparseArray.put(t.g.tag_user_mute_visible, false);
            sparseArray.put(t.g.tag_should_hide_chudian_visible, true);
            sparseArray.put(t.g.tag_chudian_template_id, Long.valueOf(aMF.getTemplateId()));
            sparseArray.put(t.g.tag_chudian_monitor_id, aMF.aMa());
            a(czVar, rVar, rVar.aMw() == 1, aVar);
            a(czVar);
            czVar.cPC.a(aMF, this.cNL, this.cHL);
        }
    }

    private void a(cz czVar) {
        czVar.cKi.setTextViewOnTouchListener(this.cKb);
        czVar.cKi.setTextViewCheckSelection(false);
    }

    private void a(cz czVar, com.baidu.tieba.tbadkCore.data.r rVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (rVar == null || rVar.asK() == null) {
            czVar.cMe.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(rVar.asK(), czVar.cMe, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(rVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cKd - (i - this.cKc));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(cz czVar) {
        czVar.aMu.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSE);
        czVar.cOj.setOnClickListener(this.bmy);
        czVar.cLK.setOnClickListener(this.bmy);
        czVar.cLD.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSE);
        czVar.cLL.setOnLongClickListener(this.anJ);
        czVar.cKi.setOnLongClickListener(this.anJ);
        czVar.cLL.setOnTouchListener(this.cKb);
        czVar.cKi.setOnTouchListener(this.cKb);
        czVar.cKi.setOnImageClickListener(this.aGi);
        czVar.cKi.setOnEmotionClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSG);
        czVar.bqH.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.bkj);
        czVar.ahI.setOnClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSF);
        czVar.cMe.setOnClickListener(this.bmy);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cJZ = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cJW = i;
    }

    public void fg(boolean z) {
        this.cJX = z;
    }

    public void fh(boolean z) {
        this.cJY = z;
    }

    public void fi(boolean z) {
        this.cKa = z;
    }

    public void kz(String str) {
        this.cLq = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.cLt = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bmy = onClickListener;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cKb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anJ = onLongClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGi = dVar;
    }
}
