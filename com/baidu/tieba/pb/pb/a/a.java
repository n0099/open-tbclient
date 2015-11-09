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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLotteryRequestMessage;
import com.baidu.tieba.pb.pb.main.bz;
import com.baidu.tieba.pb.pb.main.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a extends bz<com.baidu.tieba.tbadkCore.data.o, f> implements View.OnClickListener {
    private static HashMap<Integer, Integer> cht = new HashMap<>();
    private TbRichTextView.d aBf;
    private View.OnClickListener aZI;
    private View.OnLongClickListener ajZ;
    private int cho;
    private boolean chp;
    private boolean chq;
    private com.baidu.tieba.pb.a.c chr;
    private com.baidu.tieba.pb.b.c chs;
    private boolean chu;
    private final boolean chv;
    private int chw;
    private int chx;

    static {
        cht.put(1, Integer.valueOf(i.h.i_want_lottery));
        cht.put(2, Integer.valueOf(i.h.look_result));
        cht.put(4, Integer.valueOf(i.h.i_want_lottery));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cho = 0;
        this.chp = true;
        this.chq = true;
        this.chr = null;
        this.aZI = null;
        this.aBf = null;
        this.chs = null;
        this.ajZ = null;
        this.chu = false;
        this.chv = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        this.chw = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds30);
        this.chx = com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: G */
    public f a(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item_lottery, viewGroup, false), this.chp, this.cho);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bz, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.o oVar, f fVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.tbadkCore.data.o) fVar);
        a(fVar);
        an.j(fVar.chA, i.c.cp_bg_line_d);
        an.j(fVar.chD, i.c.cp_bg_line_b);
        an.j(fVar.chE, i.c.cp_bg_line_e);
        an.j(fVar.chF, i.c.cp_bg_line_e);
        an.c(fVar.chF, i.c.cp_bg_line_b);
        int i2 = -1;
        if (this.chr.afh() != null) {
            i2 = this.chr.afh().sw();
        }
        if (i2 == 1 || i2 == 4) {
            an.b(fVar.chC, i.c.cp_cont_i, 1);
            an.i((View) fVar.chC, i.e.buy_yinji_btn_bg);
        } else if (i2 == 2) {
            an.b(fVar.chC, i.c.cp_cont_b, 1);
            an.i((View) fVar.chC, i.e.btn_pb_bottom_comment_selector);
        }
        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) aA(i);
        if (oVar2 != null) {
            a(fVar, oVar2, view, false, i);
        }
        if (!this.chu && this.chv && fVar != null && fVar.chB.Fi() && (listView = ((PbActivity) this.cjZ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.chu = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(f fVar, com.baidu.tieba.tbadkCore.data.o oVar, View view, boolean z, int i) {
        com.baidu.tbadk.widget.richText.a aVar;
        if (fVar != null && oVar != null && this.chr.afh() != null) {
            a(fVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fVar.chB.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            fVar.chB.setLayoutParams(layoutParams);
            fVar.chB.setPadding(0, 0, 0, 0);
            fVar.chB.fU(null);
            if (oVar.axt() == 1) {
                if (this.chq) {
                    PraiseData praise = this.chr.afh().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        fVar.chE.setVisibility(0);
                        fVar.chD.setVisibility(0);
                        fVar.chF.setVisibility(0);
                        fVar.chE.setIsFromPb(true);
                        fVar.chE.a(praise, this.chr.afh().getId(), praise.getPostId(), true);
                        fVar.chE.cP(this.mSkinType);
                    } else {
                        fVar.chE.setVisibility(8);
                        fVar.chD.setVisibility(8);
                        fVar.chF.setVisibility(8);
                    }
                } else {
                    fVar.chE.setVisibility(8);
                    fVar.chD.setVisibility(8);
                    fVar.chF.setVisibility(8);
                }
                a(fVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds30));
            }
            fVar.chB.setVideoImageId(i.e.pic_video);
            fVar.chB.setTextColor(an.getColor(i.c.pb_listitem_content));
            fVar.chB.setLinkTextColor(an.getColor(i.c.cp_link_tip_c));
            fVar.chB.setLinkTextColor(an.getColor(i.c.cp_link_tip_c));
            if (this.chp) {
                fVar.chB.setDefaultImageId(i.e.img_default_100);
            } else {
                fVar.chB.setDefaultImageId(i.e.icon_click);
            }
            fVar.chB.setIsFromCDN(this.mIsFromCDN);
            if (oVar.axt() == 1 && this.chr.afh().sy()) {
                ArrayList arrayList = new ArrayList();
                com.baidu.tbadk.widget.richText.a axu = oVar.axu();
                if (axu != null && axu.EI() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> EI = axu.EI();
                    for (int i2 = 0; i2 < EI.size(); i2++) {
                        com.baidu.tbadk.widget.richText.c cVar = EI.get(i2);
                        if (cVar.getType() == 1) {
                            arrayList.add(cVar);
                        }
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
                fVar.chC.setVisibility(8);
                int sw = this.chr.afh().sw();
                if (sw == 1 || sw == 2 || sw == 4) {
                    fVar.chC.setVisibility(0);
                    fVar.chC.setOnClickListener(new b(this, sw));
                }
                Integer num = cht.get(Integer.valueOf(sw));
                if (num != null) {
                    fVar.chC.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                fVar.chC.setVisibility(8);
                aVar = null;
            }
            if (aVar == null) {
                aVar = oVar.axu();
            }
            if (this.chu || !this.chv) {
                fVar.chB.a(aVar, false);
            } else {
                fVar.chB.a(aVar, true);
            }
            a(fVar, oVar);
            b(fVar, oVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(f fVar, com.baidu.tieba.tbadkCore.data.o oVar) {
        int i;
        if (oVar == null || oVar.axo() == null) {
            fVar.chG.setVisibility(8);
            return;
        }
        an.a(fVar.chI, i.c.cp_link_tip_c, 1, this.mSkinType);
        an.a(fVar.chK, i.c.cp_link_tip_c, 1, this.mSkinType);
        an.a(fVar.chJ, i.c.cp_cont_b, 1, this.mSkinType);
        an.d(fVar.chL, i.c.cp_bg_line_a, this.mSkinType);
        an.d(fVar.chM, i.c.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c axo = oVar.axo();
        if (axo == null) {
            fVar.chG.setVisibility(8);
            return;
        }
        String awS = axo.awS();
        if (!StringUtils.isNULL(awS)) {
            fVar.chJ.setText(awS);
        } else {
            fVar.chJ.setText(i.h.award_list);
        }
        fVar.chI.setVisibility(8);
        fVar.chK.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> awU = axo.awU();
        if (awU != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : awU) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            fVar.chI.setVisibility(0);
                            fVar.chI.setText(bVar.getDescription());
                            fVar.chI.setTag(bVar.awR());
                            fVar.chI.setOnClickListener(this.aZI);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        fVar.chK.setVisibility(0);
                        fVar.chK.setText(bVar.getDescription());
                        fVar.chK.setTag(bVar.awR());
                        fVar.chK.setOnClickListener(this.aZI);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> awT = axo.awT();
        if (awT != null && awT.size() != 0) {
            int size = awT.size();
            fVar.chH.removeAllViews();
            if (fVar.chN == null) {
                fVar.chN = new SparseArray<>();
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < size && i3 < 3) {
                com.baidu.tieba.tbadkCore.data.a aVar = awT.get(i2);
                if (aVar != null) {
                    com.baidu.tieba.pb.view.e eVar = fVar.chN.get(i3);
                    com.baidu.tieba.pb.view.e eVar2 = eVar;
                    if (eVar == null) {
                        com.baidu.tieba.pb.view.e eVar3 = new com.baidu.tieba.pb.view.e(this.mContext);
                        eVar3.setOnClickListener(eVar3);
                        fVar.chN.put(i3, eVar3);
                        eVar2 = eVar3;
                    }
                    eVar2.setData(aVar);
                    eVar2.onChangeSkinType(this.cjZ.getPageContext(), this.mSkinType);
                    if (eVar2.getIcon() != null) {
                        eVar2.getIcon().setVisibility(8);
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    eVar2.setLayoutParams(layoutParams);
                    eVar2.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds12));
                    fVar.chH.addView(eVar2, layoutParams);
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
        if (TextUtils.isEmpty(oVar.getBimg_url()) || !this.chp) {
            fVar.chB.setOnClickListener(null);
        } else {
            fVar.chB.setOnClickListener(this.aZI);
        }
        fVar.chB.setTextViewCheckSelection(false);
        fVar.chB.setTextViewOnClickListener(new c(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.chx - (i - this.chw));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(f fVar) {
        fVar.chB.setOnLongClickListener(this.ajZ);
        fVar.chB.setOnTouchListener(this.chs);
        fVar.chB.setOnImageClickListener(this.aBf);
        fVar.chB.setOnEmotionClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cne);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.chr = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cho = i;
    }

    public void er(boolean z) {
        this.chp = z;
    }

    public void es(boolean z) {
        this.chq = z;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.aZI = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aBf = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.chs = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajZ = onLongClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afC() {
        if (this.cjZ != null) {
            com.baidu.tieba.pb.pb.main.c cVar = new com.baidu.tieba.pb.pb.main.c(this.cjZ.getActivity());
            c.C0072c c0072c = new c.C0072c();
            c0072c.ciS = this.cjZ.getPageContext();
            c0072c.ciX = this.cjZ.getPageContext().getPageActivity().getString(i.h.no_attention_on_forum);
            c0072c.ciR = this.cjZ.getPageContext().getPageActivity().getString(i.h.attention_before_lottery);
            c0072c.ciT = this.cjZ.getActivity().getString(i.h.cancel);
            c0072c.ciU = this.cjZ.getActivity().getString(i.h.attention);
            c0072c.ciV = new d(this);
            c0072c.ciW = new e(this);
            cVar.b(c0072c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iW(int i) {
        if (!this.cjZ.isProgressBarShown() && this.chr.afg() != null && this.chr.afh() != null && this.chr.afh().so() != null && this.chr.afh().so().size() > 0 && this.chr.afh().so().get(0) != null) {
            String id = this.chr.afg().getId();
            String id2 = this.chr.afh().getId();
            int activityId = this.chr.afh().so().get(0).getActivityId();
            int awardActId = this.chr.afh().so().get(0).getAwardActId();
            int componentId = this.chr.afh().so().get(0).getComponentId();
            if (MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.cjZ.getUniqueId()) == null || MessageManager.getInstance().findMessage(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, this.cjZ.getUniqueId()).size() == 0) {
                this.cjZ.showProgressBar(true, 0, 0);
                this.cjZ.sendMessage(new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), id, id2, i, activityId, awardActId, componentId));
            }
        }
    }
}
