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
import com.baidu.tieba.pb.pb.main.cb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a extends cb<com.baidu.tieba.tbadkCore.data.o, f> implements View.OnClickListener {
    private static HashMap<Integer, Integer> czQ = new HashMap<>();
    private TbRichTextView.d aDR;
    private View.OnLongClickListener alK;
    private View.OnClickListener bfL;
    private int czL;
    private boolean czM;
    private boolean czN;
    private com.baidu.tieba.pb.a.c czO;
    private com.baidu.tieba.pb.b.c czP;
    private boolean czR;
    private final boolean czS;
    private int czT;
    private int czU;

    static {
        czQ.put(1, Integer.valueOf(n.i.i_want_lottery));
        czQ.put(2, Integer.valueOf(n.i.look_result));
        czQ.put(4, Integer.valueOf(n.i.i_want_lottery));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.czL = 0;
        this.czM = true;
        this.czN = true;
        this.czO = null;
        this.bfL = null;
        this.aDR = null;
        this.czP = null;
        this.alK = null;
        this.czR = false;
        this.czS = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.czT = com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds30);
        this.czU = com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public f a(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(n.g.new_pb_list_item_lottery, viewGroup, false), this.czM, this.czL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cb, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.o oVar, f fVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.tbadkCore.data.o) fVar);
        a(fVar);
        as.j(fVar.czW, n.c.cp_bg_line_d);
        as.j(fVar.czZ, n.c.cp_bg_line_b);
        as.j(fVar.cAa, n.c.cp_bg_line_e);
        as.j(fVar.cAb, n.c.cp_bg_line_e);
        as.c(fVar.cAb, n.c.cp_bg_line_b);
        int i2 = -1;
        if (this.czO.ajz() != null) {
            i2 = this.czO.ajz().sX();
        }
        if (i2 == 1 || i2 == 4) {
            as.b(fVar.czY, n.c.cp_cont_i, 1);
            as.i((View) fVar.czY, n.e.buy_yinji_btn_bg);
        } else if (i2 == 2) {
            as.b(fVar.czY, n.c.cp_cont_b, 1);
            as.i((View) fVar.czY, n.e.btn_pb_bottom_comment_selector);
        }
        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) aB(i);
        if (oVar2 != null) {
            a(fVar, oVar2, view, false, i);
        }
        if (!this.czR && this.czS && fVar != null && fVar.czX.Gn() && (listView = ((PbActivity) this.cCy.getPageContext().getOrignalPage()).getListView()) != null) {
            this.czR = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(f fVar, com.baidu.tieba.tbadkCore.data.o oVar, View view, boolean z, int i) {
        if (fVar != null && oVar != null && this.czO.ajz() != null) {
            a(fVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.czX.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            fVar.czX.setLayoutParams(layoutParams);
            fVar.czX.setPadding(0, 0, 0, 0);
            fVar.czX.gh(null);
            if (oVar.aDd() == 1) {
                fVar.cAc.setVisibility(0);
                String str = null;
                long j = 0;
                if (oVar.getAuthor() != null) {
                    j = oVar.getAuthor().getUserIdLong();
                    str = oVar.getAuthor().getUserName();
                }
                fVar.cAc.a(oVar.aDm(), str, j, com.baidu.adp.lib.h.b.c(this.czO.ajz().getId(), 0L), com.baidu.adp.lib.h.b.c(oVar.getId(), 0L));
                fVar.cAc.tH();
                if (this.czN) {
                    PraiseData praise = this.czO.ajz().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        fVar.cAa.setVisibility(0);
                        fVar.czZ.setVisibility(0);
                        fVar.cAb.setVisibility(0);
                        fVar.cAa.setIsFromPb(true);
                        fVar.cAa.a(praise, this.czO.ajz().getId(), praise.getPostId(), true);
                        fVar.cAa.cX(this.mSkinType);
                    } else {
                        fVar.cAa.setVisibility(8);
                        fVar.czZ.setVisibility(8);
                        fVar.cAb.setVisibility(8);
                    }
                } else {
                    fVar.cAa.setVisibility(8);
                    fVar.czZ.setVisibility(8);
                    fVar.cAb.setVisibility(8);
                }
                a(fVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds30));
            } else {
                fVar.cAc.setVisibility(8);
            }
            fVar.czX.setVideoImageId(n.e.pic_video);
            fVar.czX.setTextColor(as.getColor(n.c.pb_listitem_content));
            fVar.czX.setLinkTextColor(as.getColor(n.c.cp_link_tip_c));
            fVar.czX.setLinkTextColor(as.getColor(n.c.cp_link_tip_c));
            if (this.czM) {
                fVar.czX.setDefaultImageId(n.e.img_default_100);
            } else {
                fVar.czX.setDefaultImageId(n.e.icon_click);
            }
            fVar.czX.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (oVar.aDd() == 1 && this.czO.ajz().sZ()) {
                ArrayList arrayList = new ArrayList();
                com.baidu.tbadk.widget.richText.a aDe = oVar.aDe();
                if (aDe != null && aDe.FL() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> FL = aDe.FL();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= FL.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = FL.get(i3);
                        if (cVar.getType() == 1) {
                            arrayList.add(cVar);
                        }
                        i2 = i3 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
                fVar.czY.setVisibility(8);
                int sX = this.czO.ajz().sX();
                if (sX == 1 || sX == 2 || sX == 4) {
                    fVar.czY.setVisibility(0);
                    fVar.czY.setOnClickListener(new b(this, sX));
                }
                Integer num = czQ.get(Integer.valueOf(sX));
                if (num != null) {
                    fVar.czY.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                fVar.czY.setVisibility(8);
            }
            if (aVar == null) {
                aVar = oVar.aDe();
            }
            if (this.czR || !this.czS) {
                fVar.czX.a(aVar, false);
            } else {
                fVar.czX.a(aVar, true);
            }
            a(fVar, oVar);
            b(fVar, oVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(f fVar, com.baidu.tieba.tbadkCore.data.o oVar) {
        int i;
        if (oVar == null || oVar.aCY() == null) {
            fVar.cAd.setVisibility(8);
            return;
        }
        as.a(fVar.cAf, n.c.cp_link_tip_c, 1, this.mSkinType);
        as.a(fVar.cAh, n.c.cp_link_tip_c, 1, this.mSkinType);
        as.a(fVar.cAg, n.c.cp_cont_b, 1, this.mSkinType);
        as.d(fVar.cAi, n.c.cp_bg_line_a, this.mSkinType);
        as.d(fVar.cAj, n.c.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c aCY = oVar.aCY();
        if (aCY == null) {
            fVar.cAd.setVisibility(8);
            return;
        }
        String aCE = aCY.aCE();
        if (!StringUtils.isNULL(aCE)) {
            fVar.cAg.setText(aCE);
        } else {
            fVar.cAg.setText(n.i.award_list);
        }
        fVar.cAf.setVisibility(8);
        fVar.cAh.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> aCG = aCY.aCG();
        if (aCG != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : aCG) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            fVar.cAf.setVisibility(0);
                            fVar.cAf.setText(bVar.getDescription());
                            fVar.cAf.setTag(bVar.aCD());
                            fVar.cAf.setOnClickListener(this.bfL);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        fVar.cAh.setVisibility(0);
                        fVar.cAh.setText(bVar.getDescription());
                        fVar.cAh.setTag(bVar.aCD());
                        fVar.cAh.setOnClickListener(this.bfL);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> aCF = aCY.aCF();
        if (aCF != null && aCF.size() != 0) {
            int size = aCF.size();
            fVar.cAe.removeAllViews();
            if (fVar.cAk == null) {
                fVar.cAk = new SparseArray<>();
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < size && i3 < 3) {
                com.baidu.tieba.tbadkCore.data.a aVar = aCF.get(i2);
                if (aVar != null) {
                    com.baidu.tieba.pb.view.f fVar2 = fVar.cAk.get(i3);
                    com.baidu.tieba.pb.view.f fVar3 = fVar2;
                    if (fVar2 == null) {
                        com.baidu.tieba.pb.view.f fVar4 = new com.baidu.tieba.pb.view.f(this.mContext);
                        fVar4.setOnClickListener(fVar4);
                        fVar.cAk.put(i3, fVar4);
                        fVar3 = fVar4;
                    }
                    fVar3.setData(aVar);
                    fVar3.onChangeSkinType(this.cCy.getPageContext(), this.mSkinType);
                    if (fVar3.getIcon() != null) {
                        fVar3.getIcon().setVisibility(8);
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    fVar3.setLayoutParams(layoutParams);
                    fVar3.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds12));
                    fVar.cAe.addView(fVar3, layoutParams);
                    i = i3 + 1;
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    private void b(f fVar, com.baidu.tieba.tbadkCore.data.o oVar) {
        if (TextUtils.isEmpty(oVar.getBimg_url()) || !this.czM) {
            fVar.czX.setOnClickListener(null);
        } else {
            fVar.czX.setOnClickListener(this.bfL);
        }
        fVar.czX.setTextViewCheckSelection(false);
        fVar.czX.setTextViewOnClickListener(new c(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.czU - (i - this.czT));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(f fVar) {
        fVar.czX.setOnLongClickListener(this.alK);
        fVar.czX.setOnTouchListener(this.czP);
        fVar.czX.setOnImageClickListener(this.aDR);
        fVar.czX.setOnEmotionClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGp);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.czO = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.czL = i;
    }

    public void eT(boolean z) {
        this.czM = z;
    }

    public void eU(boolean z) {
        this.czN = z;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bfL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aDR = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.czP = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alK = onLongClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajU() {
        if (this.cCy != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tieba.pb.pb.main.c cVar = new com.baidu.tieba.pb.pb.main.c(this.cCy.getActivity());
            c.C0080c c0080c = new c.C0080c();
            c0080c.cBo = this.cCy.getPageContext();
            c0080c.cBt = this.cCy.getPageContext().getPageActivity().getString(n.i.no_attention_on_forum);
            c0080c.cBn = this.cCy.getPageContext().getPageActivity().getString(n.i.attention_before_lottery);
            c0080c.cBp = this.cCy.getActivity().getString(n.i.cancel);
            c0080c.cBq = this.cCy.getActivity().getString(n.i.attention);
            c0080c.cBr = new d(this, currentAccount);
            c0080c.cBs = new e(this, currentAccount);
            cVar.b(c0080c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jO(int i) {
        if (!this.cCy.isProgressBarShown() && this.czO.ajy() != null && this.czO.ajz() != null && this.czO.ajz().sQ() != null && this.czO.ajz().sQ().size() > 0 && this.czO.ajz().sQ().get(0) != null) {
            String id = this.czO.ajy().getId();
            String id2 = this.czO.ajz().getId();
            int activityId = this.czO.ajz().sQ().get(0).getActivityId();
            int awardActId = this.czO.ajz().sQ().get(0).getAwardActId();
            int componentId = this.czO.ajz().sQ().get(0).getComponentId();
            if (MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.cCy.getUniqueId()) == null || MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.cCy.getUniqueId()).size() == 0) {
                this.cCy.showProgressBar(true, 0, 0);
                this.cCy.sendMessage(new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), id, id2, i, activityId, awardActId, componentId));
            }
        }
    }
}
