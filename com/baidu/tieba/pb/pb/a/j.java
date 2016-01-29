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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.c;
import com.baidu.tieba.pb.pb.main.cl;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class j extends cl<com.baidu.tieba.tbadkCore.data.r, p> implements View.OnClickListener {
    private static HashMap<Integer, Integer> cKo = new HashMap<>();
    private com.baidu.tieba.tbadkCore.w MS;
    private TbRichTextView.d aGi;
    private com.baidu.adp.base.g aWL;
    private View.OnLongClickListener anJ;
    private View.OnClickListener bmy;
    private int cJW;
    private boolean cJX;
    private boolean cJY;
    private com.baidu.tieba.pb.a.c cJZ;
    private int[] cKA;
    private boolean cKa;
    private com.baidu.tieba.pb.b.c cKb;
    private int cKc;
    private int cKd;
    private boolean cKe;
    private final boolean cKf;

    static {
        cKo.put(1, Integer.valueOf(t.j.i_want_share_picture));
        cKo.put(2, Integer.valueOf(t.j.look_result));
        cKo.put(4, Integer.valueOf(t.j.i_want_share_picture));
    }

    public j(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.cJW = 0;
        this.cJX = true;
        this.cJY = true;
        this.cKa = true;
        this.cJZ = null;
        this.bmy = null;
        this.aGi = null;
        this.cKb = null;
        this.anJ = null;
        this.cKe = false;
        this.cKf = Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 16;
        this.aWL = new k(this);
        this.cKA = new int[]{t.f.icon_grade_shaitu1, t.f.icon_grade_shaitu2, t.f.icon_grade_shaitu3};
        init();
    }

    private void init() {
        this.MS = new com.baidu.tieba.tbadkCore.w(this.cNL.getPageContext());
        this.MS.setLoadDataCallBack(this.aWL);
        this.cKc = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.cKd = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public p b(ViewGroup viewGroup) {
        return new p(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item_show_pic, viewGroup, false), this.cJY, this.cJX, this.cJW, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cl, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, p pVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) pVar);
        com.baidu.tbadk.core.util.ar.l(pVar.cKC, t.d.cp_bg_line_d);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(pVar);
        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) aG(i);
        com.baidu.tbadk.core.util.ar.l(pVar.cKj, t.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.ar.l(pVar.cKl, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ar.l(pVar.cKm, t.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.ar.c(pVar.cKm, t.d.cp_bg_line_b);
        int tD = this.cJZ.aoF().tD();
        if (tD == 1 || tD == 4) {
            com.baidu.tbadk.core.util.ar.b(pVar.cKr, t.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.ar.k(pVar.cKr, t.f.buy_yinji_btn_bg);
        } else if (tD == 2) {
            com.baidu.tbadk.core.util.ar.b(pVar.cKr, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.k(pVar.cKr, t.f.btn_pb_bottom_comment_selector);
        }
        if (rVar2 != null) {
            a(pVar, rVar2, view, false, i);
        }
        if (!this.cKe && this.cKf && pVar != null && pVar.cKi.HB() && (listView = ((PbActivity) this.cNL.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cKe = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(p pVar, com.baidu.tieba.tbadkCore.data.r rVar, View view, boolean z, int i) {
        if (pVar != null && rVar != null) {
            a(pVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.cKi.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            pVar.cKi.setLayoutParams(layoutParams);
            pVar.cKi.setPadding(0, 0, 0, 0);
            pVar.cKi.gi(null);
            if (rVar.aMw() == 1) {
                pVar.cKk.setVisibility(0);
                String str = null;
                long j = 0;
                if (rVar.getAuthor() != null) {
                    j = rVar.getAuthor().getUserIdLong();
                    str = rVar.getAuthor().getUserName();
                }
                pVar.cKk.a(rVar.aME(), str, j, com.baidu.adp.lib.h.b.c(this.cJZ.aoF().getId(), 0L), com.baidu.adp.lib.h.b.c(rVar.getId(), 0L));
                pVar.cKk.uv();
                if (this.cKa) {
                    PraiseData praise = this.cJZ.aoF().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        pVar.cKl.setVisibility(0);
                        pVar.cKj.setVisibility(0);
                        pVar.cKm.setVisibility(0);
                        pVar.cKl.setIsFromPb(true);
                        pVar.cKl.a(praise, this.cJZ.aoF().getId(), praise.getPostId(), true);
                        pVar.cKl.dk(this.mSkinType);
                    } else {
                        pVar.cKl.setVisibility(8);
                        pVar.cKj.setVisibility(8);
                        pVar.cKm.setVisibility(8);
                    }
                } else {
                    pVar.cKl.setVisibility(8);
                    pVar.cKj.setVisibility(8);
                    pVar.cKm.setVisibility(8);
                }
                a(pVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds30));
            } else {
                pVar.cKk.setVisibility(8);
            }
            pVar.cKi.setVideoImageId(t.f.pic_video);
            pVar.cKi.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.pb_listitem_content));
            pVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            pVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            if (this.cJX) {
                pVar.cKi.setDefaultImageId(t.f.img_default_100);
            } else {
                pVar.cKi.setDefaultImageId(t.f.icon_click);
            }
            pVar.cKi.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (rVar.aMw() == 1 && this.cJZ.aoF().tF()) {
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
                pVar.cKr.setVisibility(8);
                int tD = this.cJZ.aoF().tD();
                if (tD == 1 || tD == 2 || tD == 4) {
                    pVar.cKr.setVisibility(0);
                    pVar.cKr.setOnClickListener(new l(this));
                    pVar.cKr.setEnabled(true);
                }
                Integer num = cKo.get(Integer.valueOf(tD));
                if (num != null) {
                    pVar.cKr.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                pVar.cKr.setVisibility(8);
            }
            if (aVar == null) {
                aVar = rVar.aiT();
            }
            if (this.cKe || !this.cKf) {
                pVar.cKi.a(aVar, false);
            } else {
                pVar.cKi.a(aVar, true);
            }
            a(pVar, rVar);
            b(pVar, rVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(p pVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        int i;
        if (rVar == null || rVar.aMr() == null) {
            pVar.cKD.setVisibility(8);
            return;
        }
        com.baidu.tbadk.core.util.ar.a(pVar.cKu, t.d.cp_link_tip_c, 1, this.mSkinType);
        com.baidu.tbadk.core.util.ar.a(pVar.cKw, t.d.cp_link_tip_c, 1, this.mSkinType);
        com.baidu.tbadk.core.util.ar.a(pVar.cKv, t.d.cp_cont_b, 1, this.mSkinType);
        com.baidu.tbadk.core.util.ar.d(pVar.cKx, t.d.cp_bg_line_a, this.mSkinType);
        com.baidu.tbadk.core.util.ar.d(pVar.cKy, t.d.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c aMr = rVar.aMr();
        if (aMr == null) {
            pVar.cKD.setVisibility(8);
            return;
        }
        String aLR = aMr.aLR();
        if (!StringUtils.isNULL(aLR)) {
            pVar.cKv.setText(aLR);
        } else {
            pVar.cKv.setText(t.j.show_pic_list);
        }
        pVar.cKu.setVisibility(8);
        pVar.cKw.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> aLT = aMr.aLT();
        if (aLT != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : aLT) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            pVar.cKu.setVisibility(0);
                            pVar.cKu.setText(bVar.getDescription());
                            pVar.cKu.setTag(bVar.aLQ());
                            pVar.cKu.setOnClickListener(this.bmy);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        pVar.cKw.setVisibility(0);
                        pVar.cKw.setText(bVar.getDescription());
                        pVar.cKw.setTag(bVar.aLQ());
                        pVar.cKw.setOnClickListener(this.bmy);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> aLS = aMr.aLS();
        pVar.cKt.removeAllViews();
        if (aLS == null || aLS.size() == 0) {
            a(pVar);
            pVar.cKw.setVisibility(8);
            return;
        }
        int size = aLS.size();
        if (pVar.cKz == null) {
            pVar.cKz = new SparseArray<>();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < size && i3 < 3) {
            com.baidu.tieba.tbadkCore.data.a aVar = aLS.get(i2);
            if (aVar != null) {
                com.baidu.tieba.pb.view.l lVar = pVar.cKz.get(i3);
                com.baidu.tieba.pb.view.l lVar2 = lVar;
                if (lVar == null) {
                    com.baidu.tieba.pb.view.l lVar3 = new com.baidu.tieba.pb.view.l(this.mContext);
                    lVar3.setOnClickListener(lVar3);
                    pVar.cKz.put(i3, lVar3);
                    lVar2 = lVar3;
                }
                lVar2.HC();
                lVar2.setData(aVar);
                lVar2.d(this.cNL.getPageContext(), this.mSkinType);
                lVar2.setIconResId(this.cKA[i3]);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                lVar2.setLayoutParams(layoutParams);
                lVar2.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds20));
                pVar.cKt.addView(lVar2, layoutParams);
                i = i3 + 1;
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        if (i3 == 0) {
            a(pVar);
            pVar.cKw.setVisibility(8);
            return;
        }
        pVar.cKw.setVisibility(0);
    }

    private void a(p pVar) {
        if (pVar.mNoDataView == null) {
            pVar.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 0), NoDataViewFactory.d.ac(this.mContext.getResources().getString(t.j.show_pic_no_pic), this.mContext.getResources().getString(t.j.share_your_pic)), null);
            pVar.mNoDataView.onChangeSkinType(this.cNL.getPageContext(), this.mSkinType);
            pVar.mNoDataView.setVisibility(0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds20));
        pVar.mNoDataView.setLayoutParams(layoutParams);
        pVar.cKt.addView(pVar.mNoDataView);
    }

    private void b(p pVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cJX) {
            pVar.cKi.setOnClickListener(null);
        } else {
            pVar.cKi.setOnClickListener(this.bmy);
        }
        pVar.cKi.setTextViewCheckSelection(false);
        pVar.cKi.setTextViewOnClickListener(new m(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cKd - (i - this.cKc));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(p pVar) {
        pVar.cKi.setOnLongClickListener(this.anJ);
        pVar.cKi.setOnTouchListener(this.cKb);
        pVar.cKi.setOnImageClickListener(this.aGi);
        pVar.cKi.setOnEmotionClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSG);
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
    public void aoZ() {
        com.baidu.tbadk.editortools.d.e aph;
        if (this.cNL != null && (aph = this.cNL.aph()) != null) {
            if (this.cNL.apj() != null) {
                this.cNL.apj().aqT();
            }
            com.baidu.tbadk.editortools.d.b.Da().setStatus(1);
            aph.eG(140);
            WriteImagesInfo writeImagesInfo = aph.getWriteImagesInfo();
            if (writeImagesInfo == null) {
                writeImagesInfo = new WriteImagesInfo();
            }
            writeImagesInfo.clear();
            writeImagesInfo.setMaxImagesAllowed(1);
            aph.Dy();
            aph.eF(1);
            aph.eD(SendView.avE);
            aph.eE(SendView.avE);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, writeImagesInfo.toJsonString(), String.valueOf(System.currentTimeMillis()), 2);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apa() {
        if (this.cNL != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tieba.pb.pb.main.c cVar = new com.baidu.tieba.pb.pb.main.c(this.cNL.getActivity());
            c.C0077c c0077c = new c.C0077c();
            c0077c.cMk = this.cNL.getPageContext();
            c0077c.cMp = this.cNL.getPageContext().getPageActivity().getString(t.j.no_attention_on_forum);
            c0077c.cMj = this.cNL.getPageContext().getPageActivity().getString(t.j.attention_before_show_pic);
            c0077c.cMl = TbadkCoreApplication.m411getInst().getString(t.j.cancel);
            c0077c.cMm = TbadkCoreApplication.m411getInst().getString(t.j.attention);
            c0077c.cMn = new n(this, currentAccount);
            c0077c.cMo = new o(this, currentAccount);
            cVar.b(c0077c);
        }
    }
}
