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
import com.baidu.tieba.pb.pb.main.db;
import com.baidu.tieba.pb.pb.main.p;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d extends db<com.baidu.tieba.tbadkCore.data.s, i> implements View.OnClickListener {
    private static HashMap<Integer, Integer> ddG = new HashMap<>();
    private TbRichTextView.d aJc;
    private View.OnLongClickListener aoa;
    private View.OnClickListener brL;
    private com.baidu.tieba.pb.data.e ddF;
    private int ddn;
    private boolean ddo;
    private boolean ddr;
    private com.baidu.tieba.pb.a.c dds;
    private int ddt;
    private int ddv;
    private boolean ddw;
    private final boolean ddx;

    static {
        ddG.put(1, Integer.valueOf(t.j.i_want_lottery));
        ddG.put(2, Integer.valueOf(t.j.look_result));
        ddG.put(4, Integer.valueOf(t.j.i_want_lottery));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ddn = 0;
        this.ddo = true;
        this.ddr = true;
        this.ddF = null;
        this.brL = null;
        this.aJc = null;
        this.dds = null;
        this.aoa = null;
        this.ddw = false;
        this.ddx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.ddt = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30);
        this.ddv = com.baidu.adp.lib.util.k.B(this.mContext) - com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public i b(ViewGroup viewGroup) {
        return new i(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item_lottery, viewGroup, false), this.ddo, this.ddn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.db, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, i iVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) iVar);
        a(iVar);
        at.l(iVar.ddI, t.d.cp_bg_line_d);
        at.l(iVar.ddB, t.d.cp_bg_line_b);
        at.l(iVar.ddD, t.d.cp_bg_line_e);
        at.l(iVar.ddE, t.d.cp_bg_line_e);
        at.c(iVar.ddE, t.d.cp_bg_line_b);
        int i2 = -1;
        if (this.ddF.avv() != null) {
            i2 = this.ddF.avv().tH();
        }
        if (i2 == 1 || i2 == 4) {
            at.b(iVar.ddJ, t.d.cp_cont_i, 1);
            at.k(iVar.ddJ, t.f.buy_yinji_btn_bg);
        } else if (i2 == 2) {
            at.b(iVar.ddJ, t.d.cp_cont_b, 1);
            at.k(iVar.ddJ, t.f.btn_pb_bottom_comment_selector);
        }
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) aF(i);
        if (sVar2 != null) {
            a(iVar, sVar2, view, false, i);
        }
        if (!this.ddw && this.ddx && iVar != null && iVar.ddA.IX() && (listView = ((PbActivity) this.dfw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ddw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(i iVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        if (iVar != null && sVar != null && this.ddF.avv() != null) {
            a(iVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) iVar.ddA.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            iVar.ddA.setLayoutParams(layoutParams);
            iVar.ddA.setPadding(0, 0, 0, 0);
            iVar.ddA.gu(null);
            if (sVar.aTs() == 1) {
                iVar.ddC.setVisibility(0);
                String str = null;
                long j = 0;
                if (sVar.getAuthor() != null) {
                    j = sVar.getAuthor().getUserIdLong();
                    str = sVar.getAuthor().getUserName();
                }
                iVar.ddC.a(sVar.aTB(), str, j, com.baidu.adp.lib.h.b.c(this.ddF.avv().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                iVar.ddC.uA();
                if (this.ddr) {
                    PraiseData praise = this.ddF.avv().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        iVar.ddD.setVisibility(0);
                        iVar.ddB.setVisibility(0);
                        iVar.ddE.setVisibility(0);
                        iVar.ddD.setIsFromPb(true);
                        iVar.ddD.a(praise, this.ddF.avv().getId(), praise.getPostId(), true);
                        iVar.ddD.dn(this.mSkinType);
                    } else {
                        iVar.ddD.setVisibility(8);
                        iVar.ddB.setVisibility(8);
                        iVar.ddE.setVisibility(8);
                    }
                } else {
                    iVar.ddD.setVisibility(8);
                    iVar.ddB.setVisibility(8);
                    iVar.ddE.setVisibility(8);
                }
                com.baidu.tieba.graffiti.d.af(iVar.ddD);
                com.baidu.tieba.graffiti.d.af(iVar.ddB);
                com.baidu.tieba.graffiti.d.af(iVar.ddE);
                a(iVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds30));
            } else {
                iVar.ddC.setVisibility(8);
            }
            iVar.ddA.setVideoImageId(t.f.pic_video);
            iVar.ddA.setTextColor(at.getColor(t.d.pb_listitem_content));
            iVar.ddA.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            iVar.ddA.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            if (this.ddo) {
                iVar.ddA.setDefaultImageId(t.f.img_default_100);
            } else {
                iVar.ddA.setDefaultImageId(t.f.icon_click);
            }
            iVar.ddA.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (sVar.aTs() == 1 && this.ddF.avv().tJ()) {
                ArrayList arrayList = new ArrayList();
                com.baidu.tbadk.widget.richText.a amn = sVar.amn();
                if (amn != null && amn.Im() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> Im = amn.Im();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= Im.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = Im.get(i3);
                        if (cVar.getType() == 1) {
                            arrayList.add(cVar);
                        }
                        i2 = i3 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
                iVar.ddJ.setVisibility(8);
                int tH = this.ddF.avv().tH();
                if (tH == 1 || tH == 2 || tH == 4) {
                    iVar.ddJ.setVisibility(0);
                    iVar.ddJ.setOnClickListener(new e(this, tH));
                }
                Integer num = ddG.get(Integer.valueOf(tH));
                if (num != null) {
                    iVar.ddJ.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                iVar.ddJ.setVisibility(8);
            }
            if (aVar == null) {
                aVar = sVar.amn();
            }
            if (this.ddw || !this.ddx) {
                iVar.ddA.a(aVar, false);
            } else {
                iVar.ddA.a(aVar, true);
            }
            a(iVar, sVar);
            b(iVar, sVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(i iVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        int i;
        if (sVar == null || sVar.aTn() == null) {
            iVar.ddK.setVisibility(8);
            return;
        }
        at.a(iVar.ddM, t.d.cp_link_tip_c, 1, this.mSkinType);
        at.a(iVar.ddO, t.d.cp_link_tip_c, 1, this.mSkinType);
        at.a(iVar.ddN, t.d.cp_cont_b, 1, this.mSkinType);
        at.d(iVar.ddP, t.d.cp_bg_line_a, this.mSkinType);
        at.d(iVar.ddQ, t.d.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c aTn = sVar.aTn();
        if (aTn == null) {
            iVar.ddK.setVisibility(8);
            return;
        }
        String aSL = aTn.aSL();
        if (!StringUtils.isNULL(aSL)) {
            iVar.ddN.setText(aSL);
        } else {
            iVar.ddN.setText(t.j.award_list);
        }
        iVar.ddM.setVisibility(8);
        iVar.ddO.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> aSN = aTn.aSN();
        if (aSN != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : aSN) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            iVar.ddM.setVisibility(0);
                            iVar.ddM.setText(bVar.getDescription());
                            iVar.ddM.setTag(bVar.aSK());
                            iVar.ddM.setOnClickListener(this.brL);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        iVar.ddO.setVisibility(0);
                        iVar.ddO.setText(bVar.getDescription());
                        iVar.ddO.setTag(bVar.aSK());
                        iVar.ddO.setOnClickListener(this.brL);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> aSM = aTn.aSM();
        if (aSM != null && aSM.size() != 0) {
            int size = aSM.size();
            iVar.ddL.removeAllViews();
            if (iVar.ddR == null) {
                iVar.ddR = new SparseArray<>();
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < size && i3 < 3) {
                com.baidu.tieba.tbadkCore.data.a aVar = aSM.get(i2);
                if (aVar != null) {
                    com.baidu.tieba.pb.view.l lVar = iVar.ddR.get(i3);
                    com.baidu.tieba.pb.view.l lVar2 = lVar;
                    if (lVar == null) {
                        com.baidu.tieba.pb.view.l lVar3 = new com.baidu.tieba.pb.view.l(this.mContext);
                        lVar3.setOnClickListener(lVar3);
                        iVar.ddR.put(i3, lVar3);
                        lVar2 = lVar3;
                    }
                    lVar2.setData(aVar);
                    lVar2.d(this.dfw.getPageContext(), this.mSkinType);
                    if (lVar2.getIcon() != null) {
                        lVar2.getIcon().setVisibility(8);
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    lVar2.setLayoutParams(layoutParams);
                    lVar2.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds12));
                    iVar.ddL.addView(lVar2, layoutParams);
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
        if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.ddo) {
            iVar.ddA.setOnClickListener(null);
        } else {
            iVar.ddA.setOnClickListener(this.brL);
        }
        iVar.ddA.setTextViewCheckSelection(false);
        iVar.ddA.setTextViewOnClickListener(new f(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ddv - (i - this.ddt));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(i iVar) {
        iVar.ddA.setOnLongClickListener(this.aoa);
        iVar.ddA.setOnTouchListener(this.dds);
        iVar.ddA.setOnImageClickListener(this.aJc);
        iVar.ddA.setOnEmotionClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dny);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        this.ddF = eVar;
    }

    public void lP(int i) {
        this.ddn = i;
    }

    public void fQ(boolean z) {
        this.ddo = z;
    }

    public void fS(boolean z) {
        this.ddr = z;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.brL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJc = dVar;
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.dds = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoa = onLongClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apb() {
        if (this.dfw != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tieba.pb.pb.main.p pVar = new com.baidu.tieba.pb.pb.main.p(this.dfw.getActivity());
            p.c cVar = new p.c();
            cVar.bLb = this.dfw.getPageContext();
            cVar.dgf = this.dfw.getPageContext().getPageActivity().getString(t.j.no_attention_on_forum);
            cVar.dgg = this.dfw.getPageContext().getPageActivity().getString(t.j.attention_before_lottery);
            cVar.dgb = this.dfw.getActivity().getString(t.j.cancel);
            cVar.dgc = this.dfw.getActivity().getString(t.j.attention);
            cVar.dgd = new g(this, currentAccount);
            cVar.dge = new h(this, currentAccount);
            pVar.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ(int i) {
        if (!this.dfw.isProgressBarShown() && this.ddF.avu() != null && this.ddF.avv() != null && this.ddF.avv().tw() != null && this.ddF.avv().tw().size() > 0 && this.ddF.avv().tw().get(0) != null) {
            String id = this.ddF.avu().getId();
            String id2 = this.ddF.avv().getId();
            int activityId = this.ddF.avv().tw().get(0).getActivityId();
            int qY = this.ddF.avv().tw().get(0).qY();
            int qZ = this.ddF.avv().tw().get(0).qZ();
            if (MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.dfw.getUniqueId()) == null || MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.dfw.getUniqueId()).size() == 0) {
                this.dfw.showProgressBar(true, 0, 0);
                this.dfw.sendMessage(new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), id, id2, i, activityId, qY, qZ));
            }
        }
    }
}
