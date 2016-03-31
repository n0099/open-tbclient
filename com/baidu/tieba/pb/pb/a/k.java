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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.db;
import com.baidu.tieba.pb.pb.main.p;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class k extends db<com.baidu.tieba.tbadkCore.data.s, q> implements View.OnClickListener {
    private static HashMap<Integer, Integer> ddG = new HashMap<>();
    private com.baidu.tieba.tbadkCore.w MY;
    private TbRichTextView.d aJc;
    private View.OnLongClickListener aoa;
    private com.baidu.adp.base.g bbu;
    private View.OnClickListener brL;
    private int[] ddS;
    private int ddn;
    private boolean ddo;
    private boolean ddp;
    private com.baidu.tieba.pb.data.e ddq;
    private boolean ddr;
    private com.baidu.tieba.pb.a.c dds;
    private int ddt;
    private int ddv;
    private boolean ddw;
    private final boolean ddx;

    static {
        ddG.put(1, Integer.valueOf(t.j.i_want_share_picture));
        ddG.put(2, Integer.valueOf(t.j.look_result));
        ddG.put(4, Integer.valueOf(t.j.i_want_share_picture));
    }

    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.ddn = 0;
        this.ddo = true;
        this.ddp = true;
        this.ddr = true;
        this.ddq = null;
        this.brL = null;
        this.aJc = null;
        this.dds = null;
        this.aoa = null;
        this.ddw = false;
        this.ddx = Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 16;
        this.bbu = new l(this);
        this.ddS = new int[]{t.f.icon_grade_shaitu1, t.f.icon_grade_shaitu2, t.f.icon_grade_shaitu3};
        init();
    }

    private void init() {
        this.MY = new com.baidu.tieba.tbadkCore.w(this.dfw.getPageContext());
        this.MY.setLoadDataCallBack(this.bbu);
        this.ddt = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.ddv = com.baidu.adp.lib.util.k.B(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public q b(ViewGroup viewGroup) {
        return new q(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item_show_pic, viewGroup, false), this.ddp, this.ddo, this.ddn, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.db, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, q qVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) qVar);
        at.l(qVar.ddU, t.d.cp_bg_line_d);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(qVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) aF(i);
        at.l(qVar.ddB, t.d.cp_bg_line_b);
        at.l(qVar.ddD, t.d.cp_bg_line_e);
        at.l(qVar.ddE, t.d.cp_bg_line_e);
        at.c(qVar.ddE, t.d.cp_bg_line_b);
        int tH = this.ddq.avv().tH();
        if (tH == 1 || tH == 4) {
            at.b(qVar.ddJ, t.d.cp_cont_i, 1);
            at.k(qVar.ddJ, t.f.buy_yinji_btn_bg);
        } else if (tH == 2) {
            at.b(qVar.ddJ, t.d.cp_cont_b, 1);
            at.k(qVar.ddJ, t.f.btn_pb_bottom_comment_selector);
        }
        if (sVar2 != null) {
            a(qVar, sVar2, view, false, i);
        }
        if (!this.ddw && this.ddx && qVar != null && qVar.ddA.IX() && (listView = ((PbActivity) this.dfw.getPageContext().getOrignalPage()).getListView()) != null) {
            this.ddw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(q qVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        if (qVar != null && sVar != null) {
            a(qVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.ddA.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            qVar.ddA.setLayoutParams(layoutParams);
            qVar.ddA.setPadding(0, 0, 0, 0);
            qVar.ddA.gu(null);
            if (sVar.aTs() == 1) {
                qVar.ddC.setVisibility(0);
                String str = null;
                long j = 0;
                if (sVar.getAuthor() != null) {
                    j = sVar.getAuthor().getUserIdLong();
                    str = sVar.getAuthor().getUserName();
                }
                qVar.ddC.a(sVar.aTB(), str, j, com.baidu.adp.lib.h.b.c(this.ddq.avv().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                qVar.ddC.uA();
                if (this.ddr) {
                    PraiseData praise = this.ddq.avv().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        qVar.ddD.setVisibility(0);
                        qVar.ddB.setVisibility(0);
                        qVar.ddE.setVisibility(0);
                        qVar.ddD.setIsFromPb(true);
                        qVar.ddD.a(praise, this.ddq.avv().getId(), praise.getPostId(), true);
                        qVar.ddD.dn(this.mSkinType);
                    } else {
                        qVar.ddD.setVisibility(8);
                        qVar.ddB.setVisibility(8);
                        qVar.ddE.setVisibility(8);
                    }
                } else {
                    qVar.ddD.setVisibility(8);
                    qVar.ddB.setVisibility(8);
                    qVar.ddE.setVisibility(8);
                }
                com.baidu.tieba.graffiti.d.af(qVar.ddD);
                com.baidu.tieba.graffiti.d.af(qVar.ddB);
                com.baidu.tieba.graffiti.d.af(qVar.ddE);
                a(qVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds30));
            } else {
                qVar.ddC.setVisibility(8);
            }
            qVar.ddA.setVideoImageId(t.f.pic_video);
            qVar.ddA.setTextColor(at.getColor(t.d.pb_listitem_content));
            qVar.ddA.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            qVar.ddA.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            if (this.ddo) {
                qVar.ddA.setDefaultImageId(t.f.transparent_bg);
            } else {
                qVar.ddA.setDefaultImageId(t.f.icon_click);
            }
            qVar.ddA.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (sVar.aTs() == 1 && this.ddq.avv().tJ()) {
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
                qVar.ddJ.setVisibility(8);
                int tH = this.ddq.avv().tH();
                if (tH == 1 || tH == 2 || tH == 4) {
                    qVar.ddJ.setVisibility(0);
                    qVar.ddJ.setOnClickListener(new m(this));
                    qVar.ddJ.setEnabled(true);
                }
                Integer num = ddG.get(Integer.valueOf(tH));
                if (num != null) {
                    qVar.ddJ.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                qVar.ddJ.setVisibility(8);
            }
            if (aVar == null) {
                aVar = sVar.amn();
            }
            if (this.ddw || !this.ddx) {
                qVar.ddA.a(aVar, false);
            } else {
                qVar.ddA.a(aVar, true);
            }
            a(qVar, sVar);
            b(qVar, sVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(q qVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        int i;
        if (sVar == null || sVar.aTn() == null) {
            qVar.ddV.setVisibility(8);
            return;
        }
        at.a(qVar.ddM, t.d.cp_link_tip_c, 1, this.mSkinType);
        at.a(qVar.ddO, t.d.cp_link_tip_c, 1, this.mSkinType);
        at.a(qVar.ddN, t.d.cp_cont_b, 1, this.mSkinType);
        at.d(qVar.ddP, t.d.cp_bg_line_a, this.mSkinType);
        at.d(qVar.ddQ, t.d.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c aTn = sVar.aTn();
        if (aTn == null) {
            qVar.ddV.setVisibility(8);
            return;
        }
        String aSL = aTn.aSL();
        if (!StringUtils.isNULL(aSL)) {
            qVar.ddN.setText(aSL);
        } else {
            qVar.ddN.setText(t.j.show_pic_list);
        }
        qVar.ddM.setVisibility(8);
        qVar.ddO.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> aSN = aTn.aSN();
        if (aSN != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : aSN) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            qVar.ddM.setVisibility(0);
                            qVar.ddM.setText(bVar.getDescription());
                            qVar.ddM.setTag(bVar.aSK());
                            qVar.ddM.setOnClickListener(this.brL);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        qVar.ddO.setVisibility(0);
                        qVar.ddO.setText(bVar.getDescription());
                        qVar.ddO.setTag(bVar.aSK());
                        qVar.ddO.setOnClickListener(this.brL);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> aSM = aTn.aSM();
        qVar.ddL.removeAllViews();
        if (aSM == null || aSM.size() == 0) {
            a(qVar);
            qVar.ddO.setVisibility(8);
            return;
        }
        int size = aSM.size();
        if (qVar.ddR == null) {
            qVar.ddR = new SparseArray<>();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < size && i3 < 3) {
            com.baidu.tieba.tbadkCore.data.a aVar = aSM.get(i2);
            if (aVar != null) {
                com.baidu.tieba.pb.view.l lVar = qVar.ddR.get(i3);
                com.baidu.tieba.pb.view.l lVar2 = lVar;
                if (lVar == null) {
                    com.baidu.tieba.pb.view.l lVar3 = new com.baidu.tieba.pb.view.l(this.mContext);
                    lVar3.setOnClickListener(lVar3);
                    qVar.ddR.put(i3, lVar3);
                    lVar2 = lVar3;
                }
                lVar2.IY();
                lVar2.setData(aVar);
                lVar2.d(this.dfw.getPageContext(), this.mSkinType);
                lVar2.setIconResId(this.ddS[i3]);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                lVar2.setLayoutParams(layoutParams);
                lVar2.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds20));
                qVar.ddL.addView(lVar2, layoutParams);
                i = i3 + 1;
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        if (i3 == 0) {
            a(qVar);
            qVar.ddO.setVisibility(8);
            return;
        }
        qVar.ddO.setVisibility(0);
    }

    private void a(q qVar) {
        if (qVar.mNoDataView == null) {
            qVar.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 0), NoDataViewFactory.d.ag(this.mContext.getResources().getString(t.j.show_pic_no_pic), this.mContext.getResources().getString(t.j.share_your_pic)), null);
            qVar.mNoDataView.onChangeSkinType(this.dfw.getPageContext(), this.mSkinType);
            qVar.mNoDataView.setVisibility(0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds20));
        qVar.mNoDataView.setLayoutParams(layoutParams);
        qVar.ddL.addView(qVar.mNoDataView);
    }

    private void b(q qVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.ddo) {
            qVar.ddA.setOnClickListener(null);
        } else {
            qVar.ddA.setOnClickListener(this.brL);
        }
        qVar.ddA.setTextViewCheckSelection(false);
        qVar.ddA.setTextViewOnClickListener(new n(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ddv - (i - this.ddt));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(q qVar) {
        qVar.ddA.setOnLongClickListener(this.aoa);
        qVar.ddA.setOnTouchListener(this.dds);
        qVar.ddA.setOnImageClickListener(this.aJc);
        qVar.ddA.setOnEmotionClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dny);
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
    public void avQ() {
        com.baidu.tbadk.editortools.d.e awd;
        if (this.dfw != null && (awd = this.dfw.awd()) != null) {
            if (this.dfw.awi() != null) {
                this.dfw.awi().ayk();
            }
            com.baidu.tbadk.editortools.d.b.DI().setStatus(1);
            awd.eL(140);
            WriteImagesInfo writeImagesInfo = awd.getWriteImagesInfo();
            if (writeImagesInfo == null) {
                writeImagesInfo = new WriteImagesInfo();
            }
            writeImagesInfo.clear();
            writeImagesInfo.setMaxImagesAllowed(1);
            awd.Ei();
            awd.eK(1);
            awd.eI(SendView.awf);
            awd.eJ(SendView.awf);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, writeImagesInfo.toJsonString(), String.valueOf(System.currentTimeMillis()), 2);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avR() {
        if (this.dfw != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tieba.pb.pb.main.p pVar = new com.baidu.tieba.pb.pb.main.p(this.dfw.getActivity());
            p.c cVar = new p.c();
            cVar.bLb = this.dfw.getPageContext();
            cVar.dgf = this.dfw.getPageContext().getPageActivity().getString(t.j.no_attention_on_forum);
            cVar.dgg = this.dfw.getPageContext().getPageActivity().getString(t.j.attention_before_show_pic);
            cVar.dgb = TbadkCoreApplication.m411getInst().getString(t.j.cancel);
            cVar.dgc = TbadkCoreApplication.m411getInst().getString(t.j.attention);
            cVar.dgd = new o(this, currentAccount);
            cVar.dge = new p(this, currentAccount);
            pVar.a(cVar);
        }
    }
}
