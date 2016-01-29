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
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLotteryRequestMessage;
import com.baidu.tieba.pb.pb.main.c;
import com.baidu.tieba.pb.pb.main.cl;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d extends cl<com.baidu.tieba.tbadkCore.data.r, i> implements View.OnClickListener {
    private static HashMap<Integer, Integer> cKo = new HashMap<>();
    private TbRichTextView.d aGi;
    private View.OnLongClickListener anJ;
    private View.OnClickListener bmy;
    private int cJW;
    private boolean cJX;
    private boolean cKa;
    private com.baidu.tieba.pb.b.c cKb;
    private int cKc;
    private int cKd;
    private boolean cKe;
    private final boolean cKf;
    private com.baidu.tieba.pb.a.c cKn;

    static {
        cKo.put(1, Integer.valueOf(t.j.i_want_lottery));
        cKo.put(2, Integer.valueOf(t.j.look_result));
        cKo.put(4, Integer.valueOf(t.j.i_want_lottery));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cJW = 0;
        this.cJX = true;
        this.cKa = true;
        this.cKn = null;
        this.bmy = null;
        this.aGi = null;
        this.cKb = null;
        this.anJ = null;
        this.cKe = false;
        this.cKf = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.cKc = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30);
        this.cKd = com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public i b(ViewGroup viewGroup) {
        return new i(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item_lottery, viewGroup, false), this.cJX, this.cJW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cl, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, i iVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) iVar);
        a(iVar);
        com.baidu.tbadk.core.util.ar.l(iVar.cKq, t.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.ar.l(iVar.cKj, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.ar.l(iVar.cKl, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ar.l(iVar.cKm, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ar.c(iVar.cKm, t.d.cp_bg_line_b);
        int i2 = -1;
        if (this.cKn.aoF() != null) {
            i2 = this.cKn.aoF().tD();
        }
        if (i2 == 1 || i2 == 4) {
            com.baidu.tbadk.core.util.ar.b(iVar.cKr, t.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.ar.k(iVar.cKr, t.f.buy_yinji_btn_bg);
        } else if (i2 == 2) {
            com.baidu.tbadk.core.util.ar.b(iVar.cKr, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.k(iVar.cKr, t.f.btn_pb_bottom_comment_selector);
        }
        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) aG(i);
        if (rVar2 != null) {
            a(iVar, rVar2, view, false, i);
        }
        if (!this.cKe && this.cKf && iVar != null && iVar.cKi.HB() && (listView = ((PbActivity) this.cNL.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cKe = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(i iVar, com.baidu.tieba.tbadkCore.data.r rVar, View view, boolean z, int i) {
        if (iVar != null && rVar != null && this.cKn.aoF() != null) {
            a(iVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) iVar.cKi.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            iVar.cKi.setLayoutParams(layoutParams);
            iVar.cKi.setPadding(0, 0, 0, 0);
            iVar.cKi.gi(null);
            if (rVar.aMw() == 1) {
                iVar.cKk.setVisibility(0);
                String str = null;
                long j = 0;
                if (rVar.getAuthor() != null) {
                    j = rVar.getAuthor().getUserIdLong();
                    str = rVar.getAuthor().getUserName();
                }
                iVar.cKk.a(rVar.aME(), str, j, com.baidu.adp.lib.h.b.c(this.cKn.aoF().getId(), 0L), com.baidu.adp.lib.h.b.c(rVar.getId(), 0L));
                iVar.cKk.uv();
                if (this.cKa) {
                    PraiseData praise = this.cKn.aoF().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        iVar.cKl.setVisibility(0);
                        iVar.cKj.setVisibility(0);
                        iVar.cKm.setVisibility(0);
                        iVar.cKl.setIsFromPb(true);
                        iVar.cKl.a(praise, this.cKn.aoF().getId(), praise.getPostId(), true);
                        iVar.cKl.dk(this.mSkinType);
                    } else {
                        iVar.cKl.setVisibility(8);
                        iVar.cKj.setVisibility(8);
                        iVar.cKm.setVisibility(8);
                    }
                } else {
                    iVar.cKl.setVisibility(8);
                    iVar.cKj.setVisibility(8);
                    iVar.cKm.setVisibility(8);
                }
                a(iVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds30));
            } else {
                iVar.cKk.setVisibility(8);
            }
            iVar.cKi.setVideoImageId(t.f.pic_video);
            iVar.cKi.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.pb_listitem_content));
            iVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            iVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            if (this.cJX) {
                iVar.cKi.setDefaultImageId(t.f.img_default_100);
            } else {
                iVar.cKi.setDefaultImageId(t.f.icon_click);
            }
            iVar.cKi.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (rVar.aMw() == 1 && this.cKn.aoF().tF()) {
                ArrayList arrayList = new ArrayList();
                com.baidu.tbadk.widget.richText.a aiT = rVar.aiT();
                if (aiT != null && aiT.GS() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> GS = aiT.GS();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= GS.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = GS.get(i3);
                        if (cVar.getType() == 1) {
                            arrayList.add(cVar);
                        }
                        i2 = i3 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
                iVar.cKr.setVisibility(8);
                int tD = this.cKn.aoF().tD();
                if (tD == 1 || tD == 2 || tD == 4) {
                    iVar.cKr.setVisibility(0);
                    iVar.cKr.setOnClickListener(new e(this, tD));
                }
                Integer num = cKo.get(Integer.valueOf(tD));
                if (num != null) {
                    iVar.cKr.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                iVar.cKr.setVisibility(8);
            }
            if (aVar == null) {
                aVar = rVar.aiT();
            }
            if (this.cKe || !this.cKf) {
                iVar.cKi.a(aVar, false);
            } else {
                iVar.cKi.a(aVar, true);
            }
            a(iVar, rVar);
            b(iVar, rVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(i iVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        int i;
        if (rVar == null || rVar.aMr() == null) {
            iVar.cKs.setVisibility(8);
            return;
        }
        com.baidu.tbadk.core.util.ar.a(iVar.cKu, t.d.cp_link_tip_c, 1, this.mSkinType);
        com.baidu.tbadk.core.util.ar.a(iVar.cKw, t.d.cp_link_tip_c, 1, this.mSkinType);
        com.baidu.tbadk.core.util.ar.a(iVar.cKv, t.d.cp_cont_b, 1, this.mSkinType);
        com.baidu.tbadk.core.util.ar.d(iVar.cKx, t.d.cp_bg_line_a, this.mSkinType);
        com.baidu.tbadk.core.util.ar.d(iVar.cKy, t.d.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c aMr = rVar.aMr();
        if (aMr == null) {
            iVar.cKs.setVisibility(8);
            return;
        }
        String aLR = aMr.aLR();
        if (!StringUtils.isNULL(aLR)) {
            iVar.cKv.setText(aLR);
        } else {
            iVar.cKv.setText(t.j.award_list);
        }
        iVar.cKu.setVisibility(8);
        iVar.cKw.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> aLT = aMr.aLT();
        if (aLT != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : aLT) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            iVar.cKu.setVisibility(0);
                            iVar.cKu.setText(bVar.getDescription());
                            iVar.cKu.setTag(bVar.aLQ());
                            iVar.cKu.setOnClickListener(this.bmy);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        iVar.cKw.setVisibility(0);
                        iVar.cKw.setText(bVar.getDescription());
                        iVar.cKw.setTag(bVar.aLQ());
                        iVar.cKw.setOnClickListener(this.bmy);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> aLS = aMr.aLS();
        if (aLS != null && aLS.size() != 0) {
            int size = aLS.size();
            iVar.cKt.removeAllViews();
            if (iVar.cKz == null) {
                iVar.cKz = new SparseArray<>();
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < size && i3 < 3) {
                com.baidu.tieba.tbadkCore.data.a aVar = aLS.get(i2);
                if (aVar != null) {
                    com.baidu.tieba.pb.view.l lVar = iVar.cKz.get(i3);
                    com.baidu.tieba.pb.view.l lVar2 = lVar;
                    if (lVar == null) {
                        com.baidu.tieba.pb.view.l lVar3 = new com.baidu.tieba.pb.view.l(this.mContext);
                        lVar3.setOnClickListener(lVar3);
                        iVar.cKz.put(i3, lVar3);
                        lVar2 = lVar3;
                    }
                    lVar2.setData(aVar);
                    lVar2.d(this.cNL.getPageContext(), this.mSkinType);
                    if (lVar2.getIcon() != null) {
                        lVar2.getIcon().setVisibility(8);
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    lVar2.setLayoutParams(layoutParams);
                    lVar2.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds12));
                    iVar.cKt.addView(lVar2, layoutParams);
                    i = i3 + 1;
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void b(i iVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cJX) {
            iVar.cKi.setOnClickListener(null);
        } else {
            iVar.cKi.setOnClickListener(this.bmy);
        }
        iVar.cKi.setTextViewCheckSelection(false);
        iVar.cKi.setTextViewOnClickListener(new f(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cKd - (i - this.cKc));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(i iVar) {
        iVar.cKi.setOnLongClickListener(this.anJ);
        iVar.cKi.setOnTouchListener(this.cKb);
        iVar.cKi.setOnImageClickListener(this.aGi);
        iVar.cKi.setOnEmotionClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSG);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cKn = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cJW = i;
    }

    public void fg(boolean z) {
        this.cJX = z;
    }

    public void fi(boolean z) {
        this.cKa = z;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bmy = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGi = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cKb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anJ = onLongClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoY() {
        if (this.cNL != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tieba.pb.pb.main.c cVar = new com.baidu.tieba.pb.pb.main.c(this.cNL.getActivity());
            c.C0077c c0077c = new c.C0077c();
            c0077c.cMk = this.cNL.getPageContext();
            c0077c.cMp = this.cNL.getPageContext().getPageActivity().getString(t.j.no_attention_on_forum);
            c0077c.cMj = this.cNL.getPageContext().getPageActivity().getString(t.j.attention_before_lottery);
            c0077c.cMl = this.cNL.getActivity().getString(t.j.cancel);
            c0077c.cMm = this.cNL.getActivity().getString(t.j.attention);
            c0077c.cMn = new g(this, currentAccount);
            c0077c.cMo = new h(this, currentAccount);
            cVar.b(c0077c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kL(int i) {
        if (!this.cNL.isProgressBarShown() && this.cKn.aoE() != null && this.cKn.aoF() != null && this.cKn.aoF().tt() != null && this.cKn.aoF().tt().size() > 0 && this.cKn.aoF().tt().get(0) != null) {
            String id = this.cKn.aoE().getId();
            String id2 = this.cKn.aoF().getId();
            int activityId = this.cKn.aoF().tt().get(0).getActivityId();
            int awardActId = this.cKn.aoF().tt().get(0).getAwardActId();
            int componentId = this.cKn.aoF().tt().get(0).getComponentId();
            if (MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.cNL.getUniqueId()) == null || MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.cNL.getUniqueId()).size() == 0) {
                this.cNL.showProgressBar(true, 0, 0);
                this.cNL.sendMessage(new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), id, id2, i, activityId, awardActId, componentId));
            }
        }
    }
}
