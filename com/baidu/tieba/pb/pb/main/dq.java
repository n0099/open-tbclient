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
public class dq extends db<com.baidu.tieba.tbadkCore.data.s, dt> implements View.OnClickListener {
    private TbRichTextView.d aJc;
    private final TbRichTextView.e aJd;
    private View.OnLongClickListener aoa;
    private ArrayList<IconData> bjm;
    private View.OnClickListener brL;
    protected final b.a daU;
    private com.baidu.tieba.tbadkCore.data.s dcY;
    protected int ddn;
    protected boolean ddo;
    protected boolean ddp;
    private com.baidu.tieba.pb.data.e ddq;
    private boolean ddr;
    private com.baidu.tieba.pb.a.c dds;
    private int ddt;
    private int ddv;
    private boolean ddw;
    private final boolean ddx;
    private String deG;
    private com.baidu.tieba.pb.pb.sub.an deH;
    private ArrayList<IconData> deI;
    private View.OnClickListener deJ;
    protected HashMap<Long, HashSet<String>> djP;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ddn = 0;
        this.ddo = true;
        this.ddp = true;
        this.ddr = true;
        this.ddq = null;
        this.dcY = null;
        this.deG = null;
        this.deH = null;
        this.deI = null;
        this.bjm = null;
        this.deJ = null;
        this.brL = null;
        this.dds = null;
        this.aoa = null;
        this.aJc = null;
        this.ddw = false;
        this.ddx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.djP = new HashMap<>();
        this.daU = new dr(this);
        this.aJd = new ds(this);
        init();
    }

    private void init() {
        this.ddt = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.ddv = com.baidu.adp.lib.util.k.B(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public dt b(ViewGroup viewGroup) {
        return new dt(LayoutInflater.from(this.mContext).inflate(t.h.pb_newchudian_base_item, viewGroup, false), this.ddp, this.ddo, this.ddn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.db, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, dt dtVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) dtVar);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(dtVar);
        this.dcY = (com.baidu.tieba.tbadkCore.data.s) aF(i);
        com.baidu.tbadk.core.util.at.l(dtVar.deP, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.l(dtVar.deQ, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.b(dtVar.aPp, t.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.at.c(dtVar.djR, t.f.icon_tuiguang);
        com.baidu.tbadk.core.util.at.b(dtVar.deX, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.at.b(dtVar.deY, t.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.at.c(dtVar.dfa, t.f.btn_pb_more_selector);
        com.baidu.tbadk.core.util.at.c(dtVar.diq, t.f.btn_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.at.c(dtVar.dfd, t.d.cp_bg_line_b);
        if (this.dcY != null) {
            a(dtVar, this.dcY, view, false, i);
        }
        if (!this.ddw && this.ddx && dtVar != null && dtVar.ddA.IX() && (listView = ((PbActivity) this.dfw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ddw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(dt dtVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        com.baidu.tieba.tbadkCore.data.i aTC;
        SparseArray sparseArray;
        if (dtVar != null && sVar != null && (aTC = sVar.aTC()) != null) {
            this.daU.y(null, "IMAGE0", "VIEW_TRUE");
            dtVar.ddA.setOnLinkImageClickListener(this.aJd);
            dtVar.deT.setTag(null);
            dtVar.deT.setUserId(null);
            dtVar.aPp.setText((CharSequence) null);
            dtVar.dfe.setVisibility(0);
            dtVar.dfa.setVisibility(0);
            SparseArray sparseArray2 = (SparseArray) dtVar.dfb.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                dtVar.dfb.setTag(sparseArray2);
                dtVar.ddA.setTag(sparseArray2);
            }
            sparseArray2.put(t.g.tag_clip_board, sVar);
            sparseArray2.put(t.g.tag_is_subpb, false);
            a(dtVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds30));
            if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.ddo) {
                sparseArray2.put(t.g.tag_richtext_bg, null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dtVar.ddA.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                dtVar.ddA.setLayoutParams(layoutParams);
                dtVar.ddA.setPadding(0, 0, 0, 0);
                dtVar.ddA.gu(null);
            } else {
                sparseArray2.put(t.g.tag_richtext_bg, sVar.getBimg_url());
                dtVar.ddA.gu(sVar.getBimg_url());
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dtVar.ddA.getLayoutParams();
                layoutParams2.topMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(t.e.ds20);
                dtVar.ddA.setLayoutParams(layoutParams2);
            }
            dtVar.deY.setText(com.baidu.tbadk.core.util.ay.w(sVar.getTime()));
            com.baidu.tbadk.core.util.at.l(dtVar.deO, t.d.cp_bg_line_e);
            if (i == 1) {
                if (this.ddr) {
                    dtVar.deP.setVisibility(8);
                    dtVar.deQ.setVisibility(8);
                    PraiseData praise = this.ddq.avv().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        dtVar.deQ.setVisibility(8);
                        dtVar.deP.setVisibility(0);
                    } else {
                        dtVar.deQ.setVisibility(0);
                        dtVar.deP.setVisibility(8);
                    }
                } else {
                    dtVar.deP.setVisibility(0);
                    dtVar.deQ.setVisibility(8);
                }
            } else {
                dtVar.deP.setVisibility(0);
                dtVar.deQ.setVisibility(8);
            }
            dtVar.deR.setVisibility(0);
            dtVar.dfb.setVisibility(0);
            dtVar.deY.setVisibility(0);
            String format = String.format(this.mContext.getString(t.j.is_floor), Integer.valueOf(sVar.aTs()));
            dtVar.deX.setVisibility(0);
            dtVar.deX.setText(format);
            if (!this.ddp) {
                a(dtVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds74));
            } else {
                a(dtVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds104));
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) dtVar.dfc.getLayoutParams();
            if (!this.ddp) {
                layoutParams3.leftMargin = 0;
            } else {
                layoutParams3.leftMargin = (int) this.mContext.getResources().getDimension(t.e.ds30);
            }
            com.baidu.tbadk.core.util.at.k(dtVar.deS, t.f.bg_floor_new_middle);
            dtVar.ddA.setVideoImageId(t.f.pic_video);
            dtVar.ddA.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.pb_listitem_content));
            com.baidu.tbadk.core.util.at.c(dtVar.dfa, t.f.btn_pb_more_selector);
            dtVar.ddA.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_c));
            SparseArray sparseArray3 = (SparseArray) dtVar.dfa.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                dtVar.dfa.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(t.g.tag_clip_board, sVar);
            sparseArray.put(t.g.tag_load_sub_data, sVar);
            sparseArray.put(t.g.tag_load_sub_view, view);
            SparseArray sparseArray5 = (SparseArray) dtVar.diq.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                dtVar.diq.setTag(sparseArray5);
            }
            sparseArray5.put(t.g.tag_clip_board, sVar);
            sparseArray5.put(t.g.tag_load_sub_data, sVar);
            sparseArray5.put(t.g.tag_load_sub_view, view);
            sparseArray.put(t.g.tag_pb_floor_postion, Integer.valueOf(i));
            if (sVar.aTw() > 0) {
                if (this.deH == null) {
                    this.deH = new com.baidu.tieba.pb.pb.sub.an(this.mContext);
                    this.deH.setIsFromCDN(this.mIsFromCDN);
                    this.deH.N(this.deJ);
                    boolean z2 = false;
                    String userId = this.ddq.avv().getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                    }
                    this.deH.t(this.ddq.avB(), z2);
                    this.deH.h(this.ddq.avv());
                    this.deH.fR(this.ddp);
                }
                dtVar.dfe.setVisibility(0);
                dtVar.dfd.setVisibility(0);
                dtVar.dfc.setVisibility(0);
                dtVar.dfe.a(sVar, view);
                dtVar.dfe.setChildOnClickListener(this.brL);
                dtVar.dfe.setChildOnLongClickListener(this.aoa);
                dtVar.dfe.setChildOnTouchListener(this.dds);
                dtVar.dfe.setSubPbAdapter(this.deH);
                dtVar.dfe.setVisibility(0);
            } else {
                dtVar.dfe.setVisibility(8);
                dtVar.dfd.setVisibility(8);
                dtVar.dfc.setVisibility(8);
            }
            String portrait = sVar.getAuthor().getPortrait();
            if (sVar.getAuthor() != null) {
                String name_show = sVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.r.go(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.r.d(name_show, 0, 14)) + "...";
                }
                dtVar.aPp.setText(name_show);
                ArrayList<IconData> tShowInfo = sVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.at.b(dtVar.aPp, t.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.at.b(dtVar.aPp, t.d.cp_cont_f, 1);
                }
                int i2 = 3;
                if (sVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.at.c(dtVar.deW, t.f.icon_pb_pop_girl);
                    dtVar.deW.setVisibility(0);
                } else if (sVar.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.at.c(dtVar.deW, t.f.icon_pb_pop_boy);
                    dtVar.deW.setVisibility(0);
                } else {
                    dtVar.deW.setVisibility(8);
                }
                if (com.baidu.tbadk.util.r.go(sVar.getAuthor().getName_show()) >= 14 && dtVar.djR.getVisibility() == 0) {
                    i2 = 2;
                }
                this.deI = sVar.getAuthor().getIconInfo();
                this.bjm = sVar.getAuthor().getTShowInfoNew();
                if (dtVar.bvK != null) {
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 == this.deI.size()) {
                            break;
                        }
                        IconData iconData = this.deI.get(i4);
                        if (!com.baidu.tbadk.core.util.ay.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                            arrayList.add(iconData);
                        }
                        i3 = i4 + 1;
                    }
                    dtVar.bvK.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
                    dtVar.bvK.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.bpv);
                    dtVar.bvK.a(arrayList, i2, this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                }
                if (dtVar.ahN != null) {
                    dtVar.ahN.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnx);
                    if (this.bjm != null && this.bjm.size() > 0 && this.bjm.get(0) != null) {
                        dtVar.ahN.setTag(this.bjm.get(0).getUrl());
                    }
                    dtVar.ahN.a(this.bjm, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds60), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
                }
            }
            dtVar.deT.setUserId(sVar.getAuthor().getUserId());
            dtVar.deT.setUserName(sVar.getAuthor().getUserName());
            dtVar.deT.setImageDrawable(null);
            dtVar.aPp.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
            dtVar.aPp.setTag(t.g.tag_user_name, sVar.getAuthor().getUserName());
            dtVar.deT.c(portrait, 28, false);
            dtVar.ddA.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_c));
            if (this.ddo) {
                dtVar.ddA.setDefaultImageId(t.f.img_default_100);
            } else {
                dtVar.ddA.setDefaultImageId(t.f.icon_click);
            }
            dtVar.ddA.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = sVar.amn();
            }
            if (this.ddw || !this.ddx) {
                dtVar.ddA.a(aVar, false);
            } else {
                dtVar.ddA.a(aVar, true);
            }
            boolean z3 = false;
            if (this.ddq != null && this.ddq.avv() != null && this.ddq.avv().getAuthor() != null && sVar.getAuthor() != null) {
                String userId2 = this.ddq.avv().getAuthor().getUserId();
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
                if (this.ddq.avv() != null) {
                    sparseArray.put(t.g.tag_disable_reply_thread_id, this.ddq.avv().getId());
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
            sparseArray.put(t.g.tag_chudian_template_id, Long.valueOf(aTC.getTemplateId()));
            sparseArray.put(t.g.tag_chudian_monitor_id, aTC.aSV());
            sparseArray.put(t.g.tag_chudian_hide_day, Integer.valueOf(aTC.aSW()));
            a(dtVar, sVar, sVar.aTs() == 1, aVar);
            a(dtVar);
            dtVar.djS.a(aTC, this.dfw, this.daU);
        }
    }

    private void a(dt dtVar) {
        dtVar.ddA.setTextViewOnTouchListener(this.dds);
        dtVar.ddA.setTextViewCheckSelection(false);
    }

    private void a(dt dtVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, com.baidu.tbadk.widget.richText.a aVar) {
        if (sVar == null || sVar.aAu() == null) {
            dtVar.dfu.setVisibility(8);
        } else {
            com.baidu.tieba.pb.view.h.a(sVar.aAu(), dtVar.dfu, false, z, aVar != null && StringUtils.isNull(aVar.toString()) && StringUtils.isNull(sVar.getBimg_url()));
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ddv - (i - this.ddt));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(dt dtVar) {
        dtVar.aPp.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnw);
        dtVar.diq.setOnClickListener(this.brL);
        dtVar.dfa.setOnClickListener(this.brL);
        dtVar.deT.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnw);
        dtVar.dfb.setOnLongClickListener(this.aoa);
        dtVar.ddA.setOnLongClickListener(this.aoa);
        dtVar.dfb.setOnTouchListener(this.dds);
        dtVar.ddA.setOnTouchListener(this.dds);
        dtVar.ddA.setOnImageClickListener(this.aJc);
        dtVar.ddA.setOnEmotionClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dny);
        dtVar.bvK.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.bpv);
        dtVar.ahN.setOnClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dnx);
        dtVar.dfu.setOnClickListener(this.brL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        this.ddq = eVar;
    }

    public void lP(int i) {
        this.ddn = i;
    }

    public void fQ(boolean z) {
        this.ddo = z;
    }

    public void fR(boolean z) {
        this.ddp = z;
    }

    public void fS(boolean z) {
        this.ddr = z;
    }

    public void lM(String str) {
        this.deG = str;
    }

    public void L(View.OnClickListener onClickListener) {
        this.deJ = onClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.brL = onClickListener;
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.dds = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoa = onLongClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJc = dVar;
    }
}
