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
import com.baidu.tieba.pb.b;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class dh extends cm<com.baidu.tieba.tbadkCore.data.s, dk> implements View.OnClickListener {
    private TbRichTextView.d aFe;
    private final TbRichTextView.e aFf;
    private View.OnLongClickListener ajO;
    private ArrayList<IconData> bfm;
    private View.OnClickListener bnn;
    protected final b.a ddo;
    protected int dfH;
    protected boolean dfI;
    protected boolean dfJ;
    private com.baidu.tieba.pb.data.e dfK;
    private boolean dfL;
    private com.baidu.tieba.pb.a.d dfM;
    private int dfN;
    private int dfO;
    private boolean dfP;
    private final boolean dfQ;
    private com.baidu.tieba.tbadkCore.data.s dfs;
    private String dgZ;
    private com.baidu.tieba.pb.pb.sub.an dha;
    private ArrayList<IconData> dhb;
    private View.OnClickListener dhc;
    protected HashMap<Long, HashSet<String>> dml;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dfH = 0;
        this.dfI = true;
        this.dfJ = true;
        this.dfL = true;
        this.dfK = null;
        this.dfs = null;
        this.dgZ = null;
        this.dha = null;
        this.dhb = null;
        this.bfm = null;
        this.dhc = null;
        this.bnn = null;
        this.dfM = null;
        this.ajO = null;
        this.aFe = null;
        this.dfP = false;
        this.dfQ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.dml = new HashMap<>();
        this.ddo = new di(this);
        this.aFf = new dj(this);
        init();
    }

    private void init() {
        this.dfN = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.dfO = com.baidu.adp.lib.util.k.B(this.mContext) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public dk b(ViewGroup viewGroup) {
        return new dk(LayoutInflater.from(this.mContext).inflate(t.h.pb_newchudian_base_item, viewGroup, false), this.dfJ, this.dfI, this.dfH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, dk dkVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) dkVar);
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        b(dkVar);
        this.dfs = (com.baidu.tieba.tbadkCore.data.s) at(i);
        com.baidu.tbadk.core.util.at.l(dkVar.dhh, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.at.l(dkVar.dhi, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.l(dkVar.dhj, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.c(dkVar.aLz, t.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.at.c(dkVar.dmn, t.f.icon_tuiguang);
        com.baidu.tbadk.core.util.at.c(dkVar.dhq, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.at.c(dkVar.dhr, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.at.c(dkVar.dht, t.f.btn_pb_more_selector);
        com.baidu.tbadk.core.util.at.c(dkVar.dkC, t.f.btn_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.at.c(dkVar.dhw, t.d.cp_bg_line_b);
        if (this.dfs != null) {
            a(dkVar, this.dfs, view, false, i);
        }
        if (!this.dfP && this.dfQ && dkVar != null && dkVar.dfT.Hn() && (listView = ((PbActivity) this.dhY.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dfP = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(dk dkVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        com.baidu.tieba.tbadkCore.data.i aUc;
        SparseArray sparseArray;
        if (dkVar != null && sVar != null && (aUc = sVar.aUc()) != null) {
            this.ddo.z(null, "IMAGE0", "VIEW_TRUE");
            dkVar.dfT.setOnLinkImageClickListener(this.aFf);
            dkVar.dhm.setTag(null);
            dkVar.dhm.setUserId(null);
            dkVar.aLz.setText((CharSequence) null);
            dkVar.dhx.setVisibility(0);
            dkVar.dht.setVisibility(0);
            SparseArray sparseArray2 = (SparseArray) dkVar.dhu.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                dkVar.dhu.setTag(sparseArray2);
                dkVar.dfT.setTag(sparseArray2);
            }
            sparseArray2.put(t.g.tag_clip_board, sVar);
            sparseArray2.put(t.g.tag_is_subpb, false);
            a(dkVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds30));
            if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.dfI) {
                sparseArray2.put(t.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dkVar.dfT.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                dkVar.dfT.setLayoutParams(layoutParams);
                dkVar.dfT.setPadding(0, 0, 0, 0);
                dkVar.dfT.gv(null);
            } else {
                sparseArray2.put(t.g.tag_richtext_bg, sVar.getBimg_url());
                dkVar.dfT.gv(sVar.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dkVar.dfT.getLayoutParams();
                layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                dkVar.dfT.setLayoutParams(layoutParams2);
            }
            dkVar.dhr.setText(com.baidu.tbadk.core.util.ay.x(sVar.getTime()));
            if (i == 1) {
                if (this.dfL) {
                    dkVar.dhi.setVisibility(8);
                    dkVar.dhj.setVisibility(8);
                    PraiseData praise = this.dfK.avB().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        dkVar.dhj.setVisibility(8);
                        dkVar.dhi.setVisibility(0);
                    } else {
                        dkVar.dhj.setVisibility(0);
                        dkVar.dhi.setVisibility(8);
                    }
                } else {
                    dkVar.dhi.setVisibility(0);
                    dkVar.dhj.setVisibility(8);
                }
            } else {
                dkVar.dhi.setVisibility(0);
                dkVar.dhj.setVisibility(8);
            }
            dkVar.dhk.setVisibility(0);
            dkVar.dhu.setVisibility(0);
            dkVar.dhr.setVisibility(0);
            String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(sVar.aTS()));
            dkVar.dhq.setVisibility(0);
            dkVar.dhq.setText(format);
            if (!this.dfJ) {
                a(dkVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds74));
            } else {
                a(dkVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds104));
            }
            com.baidu.tbadk.core.util.at.k(dkVar.dhl, t.f.bg_floor_new_middle);
            dkVar.dfT.setVideoImageId(t.f.pic_video);
            dkVar.dfT.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.pb_listitem_content));
            com.baidu.tbadk.core.util.at.c(dkVar.dht, t.f.btn_pb_more_selector);
            dkVar.dfT.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) dkVar.dht.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                dkVar.dht.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, sVar);
            sparseArray.put(t.g.tag_load_sub_data, sVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            SparseArray sparseArray5 = (SparseArray) dkVar.dkC.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                dkVar.dkC.setTag(sparseArray5);
            }
            sparseArray5.put(t.g.tag_clip_board, sVar);
            sparseArray5.put(t.g.tag_load_sub_data, sVar);
            sparseArray5.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(t.g.tag_pb_floor_number, Integer.valueOf(sVar.aTS()));
            if (sVar.aTW() > 0) {
                if (this.dha == null) {
                    this.dha = new com.baidu.tieba.pb.pb.sub.an(this.mContext);
                    this.dha.setIsFromCDN(this.mIsFromCDN);
                    this.dha.J(this.dhc);
                    boolean z2 = false;
                    String userId = this.dfK.avB().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                    }
                    this.dha.v(this.dfK.avH(), z2);
                    this.dha.l(this.dfK.avB());
                    this.dha.gr(this.dfJ);
                }
                dkVar.dhx.setVisibility(0);
                dkVar.dhw.setVisibility(0);
                dkVar.dhv.setVisibility(0);
                dkVar.dhx.a(sVar, view);
                dkVar.dhx.setChildOnClickListener(this.bnn);
                dkVar.dhx.setChildOnLongClickListener(this.ajO);
                dkVar.dhx.setChildOnTouchListener(this.dfM);
                dkVar.dhx.setSubPbAdapter(this.dha);
                dkVar.dhx.setVisibility(0);
            } else {
                dkVar.dhx.setVisibility(8);
                dkVar.dhw.setVisibility(8);
                dkVar.dhv.setVisibility(8);
            }
            String portrait = sVar.getAuthor().getPortrait();
            if (sVar.getAuthor() != null) {
                String name_show = sVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.u.gp(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                }
                dkVar.aLz.setText(name_show);
                ArrayList<IconData> tShowInfo = sVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.at.c(dkVar.aLz, t.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.at.c(dkVar.aLz, t.d.cp_cont_f, 1);
                }
                int i2 = 3;
                if (sVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.at.c(dkVar.dhp, t.f.icon_pb_pop_girl);
                    dkVar.dhp.setVisibility(0);
                } else if (sVar.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.at.c(dkVar.dhp, t.f.icon_pb_pop_boy);
                    dkVar.dhp.setVisibility(0);
                } else {
                    dkVar.dhp.setVisibility(8);
                }
                if (com.baidu.tbadk.util.u.gp(sVar.getAuthor().getName_show()) >= 14 && dkVar.dmn.getVisibility() == 0) {
                    i2 = 2;
                }
                this.dhb = sVar.getAuthor().getIconInfo();
                this.bfm = sVar.getAuthor().getTShowInfoNew();
                if (dkVar.bvy != null) {
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 == this.dhb.size()) {
                            break;
                        }
                        IconData iconData = this.dhb.get(i4);
                        if (!com.baidu.tbadk.core.util.ay.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                            arrayList.add(iconData);
                        }
                        i3 = i4 + 1;
                    }
                    dkVar.bvy.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                    dkVar.bvy.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.bkL);
                    dkVar.bvy.a(arrayList, i2, this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                }
                if (dkVar.adH != null) {
                    dkVar.adH.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpK);
                    if (this.bfm != null && this.bfm.size() > 0 && this.bfm.get(0) != null) {
                        dkVar.adH.setTag(this.bfm.get(0).getUrl());
                    }
                    dkVar.adH.a(this.bfm, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds60), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
                }
            }
            dkVar.dhm.setUserId(sVar.getAuthor().getUserId());
            dkVar.dhm.setUserName(sVar.getAuthor().getUserName());
            dkVar.dhm.setImageDrawable(null);
            dkVar.aLz.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
            dkVar.aLz.setTag(t.g.tag_user_name, sVar.getAuthor().getUserName());
            dkVar.dhm.c(portrait, 28, false);
            dkVar.dfT.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_c));
            if (this.dfI) {
                dkVar.dfT.setDefaultImageId(t.f.img_default_100);
            } else {
                dkVar.dfT.setDefaultImageId(t.f.icon_click);
            }
            dkVar.dfT.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = sVar.amw();
            }
            if (this.dfP || !this.dfQ) {
                dkVar.dfT.a(aVar, false);
            } else {
                dkVar.dfT.a(aVar, true);
            }
            boolean z3 = false;
            if (this.dfK != null && this.dfK.avB() != null && this.dfK.avB().getAuthor() != null && sVar.getAuthor() != null) {
                String userId2 = this.dfK.avB().getAuthor().getUserId();
                String userId3 = sVar.getAuthor().getUserId();
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
                if (sVar.getAuthor() != null) {
                    sparseArray.put(t.g.tag_disable_reply_mute_userid, sVar.getAuthor().getUserId());
                    sparseArray.put(t.g.tag_disable_reply_mute_username, sVar.getAuthor().getUserName());
                }
                if (this.dfK.avB() != null) {
                    sparseArray.put(t.g.tag_disable_reply_thread_id, this.dfK.avB().getId());
                }
                sparseArray.put(t.g.tag_disable_reply_post_id, sVar.getId());
            } else {
                sparseArray.put(t.g.tag_display_reply_visible, false);
            }
            sparseArray.put(t.g.tag_should_delete_visible, false);
            sparseArray.put(t.g.tag_display_reply_visible, false);
            sparseArray.put(t.g.tag_should_manage_visible, false);
            sparseArray.put(t.g.tag_user_mute_visible, false);
            sparseArray.put(t.g.tag_should_hide_chudian_visible, true);
            sparseArray.put(t.g.tag_chudian_template_id, Long.valueOf(aUc.getTemplateId()));
            sparseArray.put(t.g.tag_chudian_monitor_id, aUc.aTw());
            sparseArray.put(t.g.tag_chudian_hide_day, Integer.valueOf(aUc.aTx()));
            a(dkVar, sVar, sVar.aTS() == 1, aVar);
            a(dkVar);
            dkVar.dmo.a(aUc, this.dhY, this.ddo);
        }
    }

    private void a(dk dkVar) {
        dkVar.dfT.setTextViewOnTouchListener(this.dfM);
        dkVar.dfT.setTextViewCheckSelection(false);
    }

    private void a(dk dkVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aAC() == null) {
            dkVar.dhP.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.n.a(sVar.aAC(), dkVar.dhP, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.dfO - (i - this.dfN));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(dk dkVar) {
        dkVar.aLz.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpJ);
        dkVar.dkC.setOnClickListener(this.bnn);
        dkVar.dht.setOnClickListener(this.bnn);
        dkVar.dhm.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpJ);
        dkVar.dhu.setOnLongClickListener(this.ajO);
        dkVar.dfT.setOnLongClickListener(this.ajO);
        dkVar.dhu.setOnTouchListener(this.dfM);
        dkVar.dfT.setOnTouchListener(this.dfM);
        dkVar.dfT.setOnImageClickListener(this.aFe);
        dkVar.dfT.setOnEmotionClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpL);
        dkVar.bvy.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.bkL);
        dkVar.adH.setOnClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpK);
        dkVar.dhP.setOnClickListener(this.bnn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.e eVar) {
        this.dfK = eVar;
    }

    public void lE(int i) {
        this.dfH = i;
    }

    public void gq(boolean z) {
        this.dfI = z;
    }

    public void gr(boolean z) {
        this.dfJ = z;
    }

    public void gs(boolean z) {
        this.dfL = z;
    }

    public void lQ(String str) {
        this.dgZ = str;
    }

    public void H(View.OnClickListener onClickListener) {
        this.dhc = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bnn = onClickListener;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dfM = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajO = onLongClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFe = dVar;
    }
}
