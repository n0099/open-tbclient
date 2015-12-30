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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLotteryRequestMessage;
import com.baidu.tieba.pb.pb.main.c;
import com.baidu.tieba.pb.pb.main.ce;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a extends ce<com.baidu.tieba.tbadkCore.data.r, f> implements View.OnClickListener {
    private static HashMap<Integer, Integer> cDv = new HashMap<>();
    private TbRichTextView.d aFq;
    private View.OnLongClickListener amQ;
    private View.OnClickListener bjD;
    private int cDq;
    private boolean cDr;
    private boolean cDs;
    private com.baidu.tieba.pb.a.c cDt;
    private com.baidu.tieba.pb.b.c cDu;
    private boolean cDw;
    private final boolean cDx;
    private int cDy;
    private int cDz;

    static {
        cDv.put(1, Integer.valueOf(n.j.i_want_lottery));
        cDv.put(2, Integer.valueOf(n.j.look_result));
        cDv.put(4, Integer.valueOf(n.j.i_want_lottery));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cDq = 0;
        this.cDr = true;
        this.cDs = true;
        this.cDt = null;
        this.bjD = null;
        this.aFq = null;
        this.cDu = null;
        this.amQ = null;
        this.cDw = false;
        this.cDx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.cDy = com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds30);
        this.cDz = com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public f a(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(n.h.new_pb_list_item_lottery, viewGroup, false), this.cDr, this.cDq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ce, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, f fVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) fVar);
        a(fVar);
        as.j(fVar.cDB, n.d.cp_bg_line_d);
        as.j(fVar.cDE, n.d.cp_bg_line_b);
        as.j(fVar.cDF, n.d.cp_bg_line_e);
        as.j(fVar.cDG, n.d.cp_bg_line_e);
        as.c(fVar.cDG, n.d.cp_bg_line_b);
        int i2 = -1;
        if (this.cDt.akH() != null) {
            i2 = this.cDt.akH().sH();
        }
        if (i2 == 1 || i2 == 4) {
            as.b(fVar.cDD, n.d.cp_cont_i, 1);
            as.i((View) fVar.cDD, n.f.buy_yinji_btn_bg);
        } else if (i2 == 2) {
            as.b(fVar.cDD, n.d.cp_cont_b, 1);
            as.i((View) fVar.cDD, n.f.btn_pb_bottom_comment_selector);
        }
        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) au(i);
        if (rVar2 != null) {
            a(fVar, rVar2, view, false, i);
        }
        if (!this.cDw && this.cDx && fVar != null && fVar.cDC.Gc() && (listView = ((PbActivity) this.cGj.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cDw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(f fVar, com.baidu.tieba.tbadkCore.data.r rVar, View view, boolean z, int i) {
        if (fVar != null && rVar != null && this.cDt.akH() != null) {
            a(fVar.cDC, (int) this.mContext.getResources().getDimension(n.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.cDC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            fVar.cDC.setLayoutParams(layoutParams);
            fVar.cDC.setPadding(0, 0, 0, 0);
            fVar.cDC.gl(null);
            if (rVar.aFq() == 1) {
                fVar.cDH.setVisibility(0);
                String str = null;
                long j = 0;
                if (rVar.getAuthor() != null) {
                    j = rVar.getAuthor().getUserIdLong();
                    str = rVar.getAuthor().getUserName();
                }
                fVar.cDH.a(rVar.aFz(), str, j, com.baidu.adp.lib.h.b.c(this.cDt.akH().getId(), 0L), com.baidu.adp.lib.h.b.c(rVar.getId(), 0L));
                fVar.cDH.tr();
                if (this.cDs) {
                    PraiseData praise = this.cDt.akH().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        fVar.cDF.setVisibility(0);
                        fVar.cDE.setVisibility(0);
                        fVar.cDG.setVisibility(0);
                        fVar.cDF.setIsFromPb(true);
                        fVar.cDF.a(praise, this.cDt.akH().getId(), praise.getPostId(), true);
                        fVar.cDF.cR(this.mSkinType);
                    } else {
                        fVar.cDF.setVisibility(8);
                        fVar.cDE.setVisibility(8);
                        fVar.cDG.setVisibility(8);
                    }
                } else {
                    fVar.cDF.setVisibility(8);
                    fVar.cDE.setVisibility(8);
                    fVar.cDG.setVisibility(8);
                }
                a(fVar.cDC, (int) this.mContext.getResources().getDimension(n.e.ds30));
            } else {
                fVar.cDH.setVisibility(8);
            }
            fVar.cDC.setVideoImageId(n.f.pic_video);
            fVar.cDC.setTextColor(as.getColor(n.d.pb_listitem_content));
            fVar.cDC.setLinkTextColor(as.getColor(n.d.cp_link_tip_c));
            fVar.cDC.setLinkTextColor(as.getColor(n.d.cp_link_tip_c));
            if (this.cDr) {
                fVar.cDC.setDefaultImageId(n.f.img_default_100);
            } else {
                fVar.cDC.setDefaultImageId(n.f.icon_click);
            }
            fVar.cDC.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (rVar.aFq() == 1 && this.cDt.akH().sJ()) {
                ArrayList arrayList = new ArrayList();
                com.baidu.tbadk.widget.richText.a aFr = rVar.aFr();
                if (aFr != null && aFr.FA() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> FA = aFr.FA();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= FA.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = FA.get(i3);
                        if (cVar.getType() == 1) {
                            arrayList.add(cVar);
                        }
                        i2 = i3 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
                fVar.cDD.setVisibility(8);
                int sH = this.cDt.akH().sH();
                if (sH == 1 || sH == 2 || sH == 4) {
                    fVar.cDD.setVisibility(0);
                    fVar.cDD.setOnClickListener(new b(this, sH));
                }
                Integer num = cDv.get(Integer.valueOf(sH));
                if (num != null) {
                    fVar.cDD.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                fVar.cDD.setVisibility(8);
            }
            if (aVar == null) {
                aVar = rVar.aFr();
            }
            if (this.cDw || !this.cDx) {
                fVar.cDC.a(aVar, false);
            } else {
                fVar.cDC.a(aVar, true);
            }
            a(fVar, rVar);
            b(fVar, rVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(f fVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        int i;
        if (rVar == null || rVar.aFl() == null) {
            fVar.cDI.setVisibility(8);
            return;
        }
        as.a(fVar.cDK, n.d.cp_link_tip_c, 1, this.mSkinType);
        as.a(fVar.cDM, n.d.cp_link_tip_c, 1, this.mSkinType);
        as.a(fVar.cDL, n.d.cp_cont_b, 1, this.mSkinType);
        as.d(fVar.cDN, n.d.cp_bg_line_a, this.mSkinType);
        as.d(fVar.cDO, n.d.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c aFl = rVar.aFl();
        if (aFl == null) {
            fVar.cDI.setVisibility(8);
            return;
        }
        String aEL = aFl.aEL();
        if (!StringUtils.isNULL(aEL)) {
            fVar.cDL.setText(aEL);
        } else {
            fVar.cDL.setText(n.j.award_list);
        }
        fVar.cDK.setVisibility(8);
        fVar.cDM.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> aEN = aFl.aEN();
        if (aEN != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : aEN) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            fVar.cDK.setVisibility(0);
                            fVar.cDK.setText(bVar.getDescription());
                            fVar.cDK.setTag(bVar.aEK());
                            fVar.cDK.setOnClickListener(this.bjD);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        fVar.cDM.setVisibility(0);
                        fVar.cDM.setText(bVar.getDescription());
                        fVar.cDM.setTag(bVar.aEK());
                        fVar.cDM.setOnClickListener(this.bjD);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> aEM = aFl.aEM();
        if (aEM != null && aEM.size() != 0) {
            int size = aEM.size();
            fVar.cDJ.removeAllViews();
            if (fVar.cDP == null) {
                fVar.cDP = new SparseArray<>();
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < size && i3 < 3) {
                com.baidu.tieba.tbadkCore.data.a aVar = aEM.get(i2);
                if (aVar != null) {
                    com.baidu.tieba.pb.view.i iVar = fVar.cDP.get(i3);
                    com.baidu.tieba.pb.view.i iVar2 = iVar;
                    if (iVar == null) {
                        com.baidu.tieba.pb.view.i iVar3 = new com.baidu.tieba.pb.view.i(this.mContext);
                        iVar3.setOnClickListener(iVar3);
                        fVar.cDP.put(i3, iVar3);
                        iVar2 = iVar3;
                    }
                    iVar2.setData(aVar);
                    iVar2.onChangeSkinType(this.cGj.getPageContext(), this.mSkinType);
                    if (iVar2.getIcon() != null) {
                        iVar2.getIcon().setVisibility(8);
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    iVar2.setLayoutParams(layoutParams);
                    iVar2.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds12));
                    fVar.cDJ.addView(iVar2, layoutParams);
                    i = i3 + 1;
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void b(f fVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cDr) {
            fVar.cDC.setOnClickListener(null);
        } else {
            fVar.cDC.setOnClickListener(this.bjD);
        }
        fVar.cDC.setTextViewCheckSelection(false);
        fVar.cDC.setTextViewOnClickListener(new c(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cDz - (i - this.cDy));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(f fVar) {
        fVar.cDC.setOnLongClickListener(this.amQ);
        fVar.cDC.setOnTouchListener(this.cDu);
        fVar.cDC.setOnImageClickListener(this.aFq);
        fVar.cDC.setOnEmotionClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cDt = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cDq = i;
    }

    public void eS(boolean z) {
        this.cDr = z;
    }

    public void eT(boolean z) {
        this.cDs = z;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bjD = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFq = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cDu = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amQ = onLongClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alb() {
        if (this.cGj != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tieba.pb.pb.main.c cVar = new com.baidu.tieba.pb.pb.main.c(this.cGj.getActivity());
            c.C0075c c0075c = new c.C0075c();
            c0075c.cET = this.cGj.getPageContext();
            c0075c.cEY = this.cGj.getPageContext().getPageActivity().getString(n.j.no_attention_on_forum);
            c0075c.cES = this.cGj.getPageContext().getPageActivity().getString(n.j.attention_before_lottery);
            c0075c.cEU = this.cGj.getActivity().getString(n.j.cancel);
            c0075c.cEV = this.cGj.getActivity().getString(n.j.attention);
            c0075c.cEW = new d(this, currentAccount);
            c0075c.cEX = new e(this, currentAccount);
            cVar.b(c0075c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kl(int i) {
        if (!this.cGj.isProgressBarShown() && this.cDt.akG() != null && this.cDt.akH() != null && this.cDt.akH().sA() != null && this.cDt.akH().sA().size() > 0 && this.cDt.akH().sA().get(0) != null) {
            String id = this.cDt.akG().getId();
            String id2 = this.cDt.akH().getId();
            int activityId = this.cDt.akH().sA().get(0).getActivityId();
            int awardActId = this.cDt.akH().sA().get(0).getAwardActId();
            int componentId = this.cDt.akH().sA().get(0).getComponentId();
            if (MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.cGj.getUniqueId()) == null || MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.cGj.getUniqueId()).size() == 0) {
                this.cGj.showProgressBar(true, 0, 0);
                this.cGj.sendMessage(new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), id, id2, i, activityId, awardActId, componentId));
            }
        }
    }
}
