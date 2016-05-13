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
import com.baidu.tieba.pb.pb.main.cm;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class k extends cm<com.baidu.tieba.tbadkCore.data.s, q> implements View.OnClickListener {
    private static HashMap<Integer, Integer> dga = new HashMap<>();
    private com.baidu.tieba.tbadkCore.x Dp;
    private TbRichTextView.d aFe;
    private com.baidu.adp.base.g aXD;
    private View.OnLongClickListener ajO;
    private View.OnClickListener bnn;
    private int dfH;
    private boolean dfI;
    private boolean dfJ;
    private com.baidu.tieba.pb.data.e dfK;
    private boolean dfL;
    private com.baidu.tieba.pb.a.d dfM;
    private int dfN;
    private int dfO;
    private boolean dfP;
    private final boolean dfQ;
    private int[] dgm;

    static {
        dga.put(1, Integer.valueOf(t.j.i_want_share_picture));
        dga.put(2, Integer.valueOf(t.j.look_result));
        dga.put(4, Integer.valueOf(t.j.i_want_share_picture));
    }

    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.dfH = 0;
        this.dfI = true;
        this.dfJ = true;
        this.dfL = true;
        this.dfK = null;
        this.bnn = null;
        this.aFe = null;
        this.dfM = null;
        this.ajO = null;
        this.dfP = false;
        this.dfQ = Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 16;
        this.aXD = new l(this);
        this.dgm = new int[]{t.f.icon_grade_shaitu1, t.f.icon_grade_shaitu2, t.f.icon_grade_shaitu3};
        init();
    }

    private void init() {
        this.Dp = new com.baidu.tieba.tbadkCore.x(this.dhY.getPageContext());
        this.Dp.setLoadDataCallBack(this.aXD);
        this.dfN = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.dfO = com.baidu.adp.lib.util.k.B(this.mContext) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aC */
    public q b(ViewGroup viewGroup) {
        q qVar = new q(LayoutInflater.from(this.mContext).inflate(t.h.new_pb_list_item_show_pic, viewGroup, false), this.dfJ, this.dfI, this.dfH, false);
        a(qVar);
        return qVar;
    }

    private void a(q qVar) {
        int skinType;
        if (qVar != null && qVar.mSkinType != (skinType = TbadkCoreApplication.m11getInst().getSkinType())) {
            at.l(qVar.dfU, t.d.cp_bg_line_b);
            at.l(qVar.dfW, t.d.cp_bg_line_e);
            at.l(qVar.dfX, t.d.cp_bg_line_e);
            at.c(qVar.dfX, t.d.cp_bg_line_b);
            at.l(qVar.DM, t.d.cp_bg_line_b);
            at.l(qVar.dgo, t.d.cp_bg_line_d);
            qVar.mSkinType = skinType;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, q qVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) qVar);
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        c(qVar);
        a(qVar);
        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) as(i);
        int rg = this.dfK.avE().rg();
        if (rg == 1 || rg == 4) {
            at.c(qVar.dgd, t.d.cp_cont_i, 1);
            at.k(qVar.dgd, t.f.buy_yinji_btn_bg);
        } else if (rg == 2) {
            at.c(qVar.dgd, t.d.cp_cont_b, 1);
            at.k(qVar.dgd, t.f.btn_pb_bottom_comment_selector);
        }
        if (sVar2 != null) {
            a(qVar, sVar2, view, false, i);
        }
        if (!this.dfP && this.dfQ && qVar != null && qVar.dfT.Hp() && (listView = ((PbActivity) this.dhY.getPageContext().getOrignalPage()).getListView()) != null) {
            this.dfP = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(q qVar, com.baidu.tieba.tbadkCore.data.s sVar, View view, boolean z, int i) {
        if (qVar != null && sVar != null) {
            a(qVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.dfT.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            qVar.dfT.setLayoutParams(layoutParams);
            qVar.dfT.setPadding(0, 0, 0, 0);
            qVar.dfT.gv(null);
            if (sVar.aTY() == 1) {
                qVar.dfV.setVisibility(0);
                String str = null;
                long j = 0;
                if (sVar.getAuthor() != null) {
                    j = sVar.getAuthor().getUserIdLong();
                    str = sVar.getAuthor().getUserName();
                }
                qVar.dfV.a(sVar.aUh(), str, j, com.baidu.adp.lib.h.b.c(this.dfK.avE().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                qVar.dfV.sg();
                if (this.dfL) {
                    PraiseData praise = this.dfK.avE().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        qVar.dfW.setVisibility(0);
                        qVar.dfU.setVisibility(0);
                        qVar.dfX.setVisibility(0);
                        qVar.dfW.setIsFromPb(true);
                        qVar.dfW.a(praise, this.dfK.avE().getId(), praise.getPostId(), true);
                        qVar.dfW.cV(this.mSkinType);
                    } else {
                        qVar.dfW.setVisibility(8);
                        qVar.dfU.setVisibility(8);
                        qVar.dfX.setVisibility(8);
                    }
                } else {
                    qVar.dfW.setVisibility(8);
                    qVar.dfU.setVisibility(8);
                    qVar.dfX.setVisibility(8);
                }
                com.baidu.tieba.graffiti.d.aj(qVar.dfW);
                com.baidu.tieba.graffiti.d.aj(qVar.dfU);
                com.baidu.tieba.graffiti.d.aj(qVar.dfX);
                a(qVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds30));
            } else {
                qVar.dfV.setVisibility(8);
            }
            qVar.dfT.setVideoImageId(t.f.pic_video);
            qVar.dfT.setTextColor(at.getColor(t.d.pb_listitem_content));
            qVar.dfT.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            qVar.dfT.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            if (this.dfI) {
                qVar.dfT.setDefaultImageId(t.f.transparent_bg);
            } else {
                qVar.dfT.setDefaultImageId(t.f.icon_click);
            }
            qVar.dfT.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (sVar.aTY() == 1 && this.dfK.avE().ri()) {
                ArrayList arrayList = new ArrayList();
                com.baidu.tbadk.widget.richText.a amz = sVar.amz();
                if (amz != null && amz.GE() != null) {
                    ArrayList<com.baidu.tbadk.widget.richText.c> GE = amz.GE();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= GE.size()) {
                            break;
                        }
                        com.baidu.tbadk.widget.richText.c cVar = GE.get(i3);
                        if (cVar.getType() == 1) {
                            arrayList.add(cVar);
                        }
                        i2 = i3 + 1;
                    }
                }
                com.baidu.tbadk.widget.richText.a aVar2 = new com.baidu.tbadk.widget.richText.a(this.mContext, arrayList);
                qVar.dgd.setVisibility(8);
                int rg = this.dfK.avE().rg();
                if (rg == 1 || rg == 2 || rg == 4) {
                    qVar.dgd.setVisibility(0);
                    qVar.dgd.setOnClickListener(new m(this));
                    qVar.dgd.setEnabled(true);
                }
                Integer num = dga.get(Integer.valueOf(rg));
                if (num != null) {
                    qVar.dgd.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                qVar.dgd.setVisibility(8);
            }
            if (aVar == null) {
                aVar = sVar.amz();
            }
            if (this.dfP || !this.dfQ) {
                qVar.dfT.a(aVar, false);
            } else {
                qVar.dfT.a(aVar, true);
            }
            a(qVar, sVar);
            b(qVar, sVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(q qVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        int i;
        if (sVar == null || sVar.aTT() == null) {
            qVar.dgp.setVisibility(8);
            return;
        }
        at.b(qVar.dgg, t.d.cp_link_tip_c, 1, this.mSkinType);
        at.b(qVar.dgi, t.d.cp_link_tip_c, 1, this.mSkinType);
        at.b(qVar.dgh, t.d.cp_cont_b, 1, this.mSkinType);
        at.e(qVar.dgj, t.d.cp_bg_line_a, this.mSkinType);
        at.e(qVar.dgk, t.d.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c aTT = sVar.aTT();
        if (aTT == null) {
            qVar.dgp.setVisibility(8);
            return;
        }
        String aTs = aTT.aTs();
        if (!StringUtils.isNULL(aTs)) {
            qVar.dgh.setText(aTs);
        } else {
            qVar.dgh.setText(t.j.show_pic_list);
        }
        qVar.dgg.setVisibility(8);
        qVar.dgi.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> aTu = aTT.aTu();
        if (aTu != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : aTu) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            qVar.dgg.setVisibility(0);
                            qVar.dgg.setText(bVar.getDescription());
                            qVar.dgg.setTag(bVar.aTr());
                            qVar.dgg.setOnClickListener(this.bnn);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        qVar.dgi.setVisibility(0);
                        qVar.dgi.setText(bVar.getDescription());
                        qVar.dgi.setTag(bVar.aTr());
                        qVar.dgi.setOnClickListener(this.bnn);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> aTt = aTT.aTt();
        qVar.dgf.removeAllViews();
        if (aTt == null || aTt.size() == 0) {
            b(qVar);
            qVar.dgi.setVisibility(8);
            return;
        }
        int size = aTt.size();
        if (qVar.dgl == null) {
            qVar.dgl = new SparseArray<>();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < size && i3 < 3) {
            com.baidu.tieba.tbadkCore.data.a aVar = aTt.get(i2);
            if (aVar != null) {
                com.baidu.tieba.pb.view.r rVar = qVar.dgl.get(i3);
                com.baidu.tieba.pb.view.r rVar2 = rVar;
                if (rVar == null) {
                    com.baidu.tieba.pb.view.r rVar3 = new com.baidu.tieba.pb.view.r(this.mContext);
                    rVar3.setOnClickListener(rVar3);
                    qVar.dgl.put(i3, rVar3);
                    rVar2 = rVar3;
                }
                rVar2.Hq();
                rVar2.setData(aVar);
                rVar2.d(this.dhY.getPageContext(), this.mSkinType);
                rVar2.setIconResId(this.dgm[i3]);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                rVar2.setLayoutParams(layoutParams);
                rVar2.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds20));
                qVar.dgf.addView(rVar2, layoutParams);
                i = i3 + 1;
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        if (i3 == 0) {
            b(qVar);
            qVar.dgi.setVisibility(8);
            return;
        }
        qVar.dgi.setVisibility(0);
    }

    private void b(q qVar) {
        if (qVar.mNoDataView == null) {
            qVar.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 0), NoDataViewFactory.d.ag(this.mContext.getResources().getString(t.j.show_pic_no_pic), this.mContext.getResources().getString(t.j.share_your_pic)), null);
            qVar.mNoDataView.onChangeSkinType(this.dhY.getPageContext(), this.mSkinType);
            qVar.mNoDataView.setVisibility(0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds20));
        qVar.mNoDataView.setLayoutParams(layoutParams);
        qVar.dgf.addView(qVar.mNoDataView);
    }

    private void b(q qVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.dfI) {
            qVar.dfT.setOnClickListener(null);
        } else {
            qVar.dfT.setOnClickListener(this.bnn);
        }
        qVar.dfT.setTextViewCheckSelection(false);
        qVar.dfT.setTextViewOnClickListener(new n(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.dfO - (i - this.dfN));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void c(q qVar) {
        qVar.dfT.setOnLongClickListener(this.ajO);
        qVar.dfT.setOnTouchListener(this.dfM);
        qVar.dfT.setOnImageClickListener(this.aFe);
        qVar.dfT.setOnEmotionClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.e eVar) {
        this.dfK = eVar;
    }

    public void lD(int i) {
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
    public void awc() {
        com.baidu.tbadk.editortools.d.e awu;
        if (this.dhY != null && (awu = this.dhY.awu()) != null) {
            if (this.dhY.aww() != null) {
                this.dhY.aww().ayK();
            }
            com.baidu.tbadk.editortools.d.b.BD().setStatus(1);
            awu.eq(140);
            WriteImagesInfo writeImagesInfo = awu.getWriteImagesInfo();
            if (writeImagesInfo == null) {
                writeImagesInfo = new WriteImagesInfo();
            }
            writeImagesInfo.clear();
            writeImagesInfo.setMaxImagesAllowed(1);
            awu.Cc();
            awu.ep(1);
            awu.en(SendView.ase);
            awu.eo(SendView.ase);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, writeImagesInfo.toJsonString(), String.valueOf(System.currentTimeMillis()), 2);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awd() {
        if (this.dhY != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tieba.pb.pb.main.g gVar = new com.baidu.tieba.pb.pb.main.g(this.dhY.getActivity());
            g.c cVar = new g.c();
            cVar.bLj = this.dhY.getPageContext();
            cVar.dis = this.dhY.getPageContext().getPageActivity().getString(t.j.no_attention_on_forum);
            cVar.dit = this.dhY.getPageContext().getPageActivity().getString(t.j.attention_before_show_pic);
            cVar.dio = TbadkCoreApplication.m11getInst().getString(t.j.cancel);
            cVar.dip = TbadkCoreApplication.m11getInst().getString(t.j.attention);
            cVar.diq = new o(this, currentAccount);
            cVar.dir = new p(this, currentAccount);
            gVar.a(cVar);
        }
    }
}
