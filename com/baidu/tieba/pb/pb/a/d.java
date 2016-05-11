package com.baidu.tieba.pb.pb.a;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLotteryRequestMessage;
import com.baidu.tieba.pb.pb.main.cm;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d extends cm<com.baidu.tieba.tbadkCore.data.s, i> implements View.OnClickListener {
    private static HashMap<Integer, Integer> dga = new HashMap<>();
    private TbRichTextView.d aFe;
    private View.OnLongClickListener ajO;
    private View.OnClickListener bnn;
    private int dfH;
    private boolean dfI;
    private boolean dfL;
    private com.baidu.tieba.pb.a.d dfM;
    private int dfN;
    private int dfO;
    private boolean dfP;
    private final boolean dfQ;
    private com.baidu.tieba.pb.data.e dfY;
    private com.baidu.tieba.pb.pb.b.a dfZ;

    static {
        dga.put(1, Integer.valueOf(t.j.i_want_lottery));
        dga.put(2, Integer.valueOf(t.j.look_result));
        dga.put(4, Integer.valueOf(t.j.i_want_lottery));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dfH = 0;
        this.dfI = true;
        this.dfL = true;
        this.dfY = null;
        this.bnn = null;
        this.aFe = null;
        this.dfM = null;
        this.ajO = null;
        this.dfP = false;
        this.dfQ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.dfN = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30);
        this.dfO = com.baidu.adp.lib.util.k.B(this.mContext) - com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds60);
        this.dfZ = new com.baidu.tieba.pb.pb.b.a(pbActivity, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public i b(ViewGroup viewGroup) {
        return new i(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item_lottery, viewGroup, false), this.dfI, this.dfH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, i iVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) iVar);
        a(iVar);
        at.l(iVar.dgc, t.d.cp_bg_line_d);
        at.l(iVar.dfU, t.d.cp_bg_line_b);
        at.l(iVar.dfW, t.d.cp_bg_line_e);
        at.l(iVar.dfX, t.d.cp_bg_line_e);
        at.c(iVar.dfX, t.d.cp_bg_line_b);
        at.l(iVar.DM, t.d.cp_bg_line_b);
        int i2 = -1;
        if (this.dfY.avB() != null) {
            i2 = this.dfY.avB().rf();
        }
        if (i2 == 1 || i2 == 4) {
            at.c(iVar.dgd, t.d.cp_cont_i, 1);
            at.k(iVar.dgd, t.f.buy_yinji_btn_bg);
        } else if (i2 == 2) {
            at.c(iVar.dgd, t.d.cp_cont_b, 1);
            at.k(iVar.dgd, t.f.btn_pb_bottom_comment_selector);
        }
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) at(i);
        if (sVar2 != null) {
            a(iVar, sVar2, view, false, i);
        }
        if (!this.dfP && this.dfQ && iVar != null && iVar.dfT.Hn() && (listView = ((PbActivity) this.dhY.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dfP = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(i iVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        if (iVar != null && sVar != null && this.dfY.avB() != null) {
            a(iVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) iVar.dfT.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            iVar.dfT.setLayoutParams(layoutParams);
            iVar.dfT.setPadding(0, 0, 0, 0);
            iVar.dfT.gv(null);
            if (sVar.aTS() == 1) {
                iVar.dfV.setVisibility(0);
                String str = null;
                long j = 0;
                if (sVar.getAuthor() != null) {
                    j = sVar.getAuthor().getUserIdLong();
                    str = sVar.getAuthor().getUserName();
                }
                iVar.dfV.a(sVar.aUb(), str, j, com.baidu.adp.lib.h.b.c(this.dfY.avB().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                iVar.dfV.sf();
                if (this.dfL) {
                    PraiseData praise = this.dfY.avB().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        iVar.dfW.setVisibility(0);
                        iVar.dfU.setVisibility(0);
                        iVar.dfX.setVisibility(0);
                        iVar.dfW.setIsFromPb(true);
                        iVar.dfW.a(praise, this.dfY.avB().getId(), praise.getPostId(), true);
                        iVar.dfW.cW(this.mSkinType);
                    } else {
                        iVar.dfW.setVisibility(8);
                        iVar.dfU.setVisibility(8);
                        iVar.dfX.setVisibility(8);
                    }
                } else {
                    iVar.dfW.setVisibility(8);
                    iVar.dfU.setVisibility(8);
                    iVar.dfX.setVisibility(8);
                }
                com.baidu.tieba.graffiti.d.aj(iVar.dfW);
                com.baidu.tieba.graffiti.d.aj(iVar.dfU);
                com.baidu.tieba.graffiti.d.aj(iVar.dfX);
                a(iVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds30));
            } else {
                iVar.dfV.setVisibility(8);
            }
            iVar.dfT.setVideoImageId(t.f.pic_video);
            iVar.dfT.setTextColor(at.getColor(t.d.pb_listitem_content));
            iVar.dfT.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            iVar.dfT.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            if (this.dfI) {
                iVar.dfT.setDefaultImageId(t.f.img_default_100);
            } else {
                iVar.dfT.setDefaultImageId(t.f.icon_click);
            }
            iVar.dfT.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (sVar.aTS() == 1 && this.dfY.avB().rh()) {
                ArrayList arrayList = new ArrayList();
                com.baidu.tbadk.widget.richText.a amw = sVar.amw();
                if (amw != null && amw.GC() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> GC = amw.GC();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= GC.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = GC.get(i3);
                        if (cVar.getType() == 1) {
                            arrayList.add(cVar);
                        }
                        i2 = i3 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
                iVar.dgd.setVisibility(8);
                int rf = this.dfY.avB().rf();
                if (rf == 1 || rf == 2 || rf == 4) {
                    iVar.dgd.setVisibility(0);
                    iVar.dgd.setOnClickListener(new e(this, rf));
                }
                Integer num = dga.get(Integer.valueOf(rf));
                if (num != null) {
                    iVar.dgd.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                iVar.dgd.setVisibility(8);
            }
            if (aVar == null) {
                aVar = sVar.amw();
            }
            if (this.dfP || !this.dfQ) {
                iVar.dfT.a(aVar, false);
            } else {
                iVar.dfT.a(aVar, true);
            }
            a(iVar, sVar);
            b(iVar, sVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(i iVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        int i;
        if (sVar == null || sVar.aTN() == null) {
            iVar.dge.setVisibility(8);
            return;
        }
        at.b(iVar.dgg, t.d.cp_link_tip_c, 1, this.mSkinType);
        at.b(iVar.dgi, t.d.cp_link_tip_c, 1, this.mSkinType);
        at.b(iVar.dgh, t.d.cp_cont_b, 1, this.mSkinType);
        at.e(iVar.dgj, t.d.cp_bg_line_a, this.mSkinType);
        at.e(iVar.dgk, t.d.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c aTN = sVar.aTN();
        if (aTN == null) {
            iVar.dge.setVisibility(8);
            return;
        }
        String aTm = aTN.aTm();
        if (!StringUtils.isNULL(aTm)) {
            iVar.dgh.setText(aTm);
        } else {
            iVar.dgh.setText(t.j.award_list);
        }
        iVar.dgg.setVisibility(8);
        iVar.dgi.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> aTo = aTN.aTo();
        if (aTo != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : aTo) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            iVar.dgg.setVisibility(0);
                            iVar.dgg.setText(bVar.getDescription());
                            iVar.dgg.setTag(bVar.aTl());
                            iVar.dgg.setOnClickListener(this.bnn);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        iVar.dgi.setVisibility(0);
                        iVar.dgi.setText(bVar.getDescription());
                        iVar.dgi.setTag(bVar.aTl());
                        iVar.dgi.setOnClickListener(this.bnn);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> aTn = aTN.aTn();
        if (aTn != null && aTn.size() != 0) {
            int size = aTn.size();
            iVar.dgf.removeAllViews();
            if (iVar.dgl == null) {
                iVar.dgl = new SparseArray<>();
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < size && i3 < 3) {
                com.baidu.tieba.tbadkCore.data.a aVar = aTn.get(i2);
                if (aVar != null) {
                    com.baidu.tieba.pb.view.r rVar = iVar.dgl.get(i3);
                    com.baidu.tieba.pb.view.r rVar2 = rVar;
                    if (rVar == null) {
                        com.baidu.tieba.pb.view.r rVar3 = new com.baidu.tieba.pb.view.r(this.mContext);
                        rVar3.setOnClickListener(rVar3);
                        iVar.dgl.put(i3, rVar3);
                        rVar2 = rVar3;
                    }
                    rVar2.setData(aVar);
                    rVar2.d(this.dhY.getPageContext(), this.mSkinType);
                    if (rVar2.getIcon() != null) {
                        rVar2.getIcon().setVisibility(8);
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    rVar2.setLayoutParams(layoutParams);
                    rVar2.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds12));
                    iVar.dgf.addView(rVar2, layoutParams);
                    i = i3 + 1;
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void b(i iVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.dfI) {
            iVar.dfT.setOnClickListener(null);
        } else {
            iVar.dfT.setOnClickListener(this.bnn);
        }
        iVar.dfT.setTextViewCheckSelection(false);
        iVar.dfT.setTextViewOnClickListener(new f(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.dfO - (i - this.dfN));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(i iVar) {
        iVar.dfT.setOnLongClickListener(this.ajO);
        iVar.dfT.setOnTouchListener(this.dfM);
        iVar.dfT.setOnImageClickListener(this.aFe);
        iVar.dfT.setOnEmotionClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.e eVar) {
        this.dfY = eVar;
    }

    public void lE(int i) {
        this.dfH = i;
    }

    public void gq(boolean z) {
        this.dfI = z;
    }

    public void gs(boolean z) {
        this.dfL = z;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bnn = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFe = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dfM = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajO = onLongClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apg() {
        if (this.dhY != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tieba.pb.pb.main.g gVar = new com.baidu.tieba.pb.pb.main.g(this.dhY.getActivity());
            g.c cVar = new g.c();
            cVar.bLj = this.dhY.getPageContext();
            cVar.dis = this.dhY.getPageContext().getPageActivity().getString(t.j.no_attention_on_forum);
            cVar.dit = this.dhY.getPageContext().getPageActivity().getString(t.j.attention_before_lottery);
            cVar.dio = this.dhY.getActivity().getString(t.j.cancel);
            cVar.dip = this.dhY.getActivity().getString(t.j.attention);
            cVar.diq = new g(this, currentAccount);
            cVar.dir = new h(this, currentAccount);
            gVar.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(int i) {
        if (!this.dhY.isProgressBarShown() && this.dfY.avA() != null && this.dfY.avB() != null && this.dfY.avB().qU() != null && this.dfY.avB().qU().size() > 0 && this.dfY.avB().qU().get(0) != null) {
            String id = this.dfY.avA().getId();
            String id2 = this.dfY.avB().getId();
            int activityId = this.dfY.avB().qU().get(0).getActivityId();
            int ov = this.dfY.avB().qU().get(0).ov();
            int ow = this.dfY.avB().qU().get(0).ow();
            if (MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.dhY.getUniqueId()) == null || MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.dhY.getUniqueId()).size() == 0) {
                this.dhY.showProgressBar(true, 0, 0);
                this.dhY.sendMessage(new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), id, id2, i, activityId, ov, ow, this.dfZ.awh()));
            }
        }
    }
}
