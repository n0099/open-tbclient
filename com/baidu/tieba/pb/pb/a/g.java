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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.c;
import com.baidu.tieba.pb.pb.main.ce;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class g extends ce<com.baidu.tieba.tbadkCore.data.r, m> implements View.OnClickListener {
    private static HashMap<Integer, Integer> cDv = new HashMap<>();
    private x MB;
    private TbRichTextView.d aFq;
    private com.baidu.adp.base.g aUC;
    private View.OnLongClickListener amQ;
    private View.OnClickListener bjD;
    private boolean cDQ;
    private com.baidu.tieba.pb.a.c cDR;
    private int[] cDS;
    private int cDq;
    private boolean cDr;
    private boolean cDs;
    private com.baidu.tieba.pb.b.c cDu;
    private boolean cDw;
    private final boolean cDx;
    private int cDy;
    private int cDz;

    static {
        cDv.put(1, Integer.valueOf(n.j.i_want_share_picture));
        cDv.put(2, Integer.valueOf(n.j.look_result));
        cDv.put(4, Integer.valueOf(n.j.i_want_share_picture));
    }

    public g(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.cDq = 0;
        this.cDr = true;
        this.cDQ = true;
        this.cDs = true;
        this.cDR = null;
        this.bjD = null;
        this.aFq = null;
        this.cDu = null;
        this.amQ = null;
        this.cDw = false;
        this.cDx = Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 16;
        this.aUC = new h(this);
        this.cDS = new int[]{n.f.icon_grade_shaitu1, n.f.icon_grade_shaitu2, n.f.icon_grade_shaitu3};
        init();
    }

    private void init() {
        this.MB = new x(this.cGj.getPageContext());
        this.MB.setLoadDataCallBack(this.aUC);
        this.cDy = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds30);
        this.cDz = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public m a(ViewGroup viewGroup) {
        return new m(LayoutInflater.from(this.mContext).inflate(n.h.new_pb_list_item_show_pic, viewGroup, false), this.cDQ, this.cDr, this.cDq, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.ce, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, m mVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) mVar);
        as.j(mVar.cDU, n.d.cp_bg_line_d);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(mVar);
        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) au(i);
        as.j(mVar.cDE, n.d.cp_bg_line_b);
        as.j(mVar.cDF, n.d.cp_bg_line_e);
        as.j(mVar.cDG, n.d.cp_bg_line_e);
        as.c(mVar.cDG, n.d.cp_bg_line_b);
        int sH = this.cDR.akH().sH();
        if (sH == 1 || sH == 4) {
            as.b(mVar.cDD, n.d.cp_cont_i, 1);
            as.i((View) mVar.cDD, n.f.buy_yinji_btn_bg);
        } else if (sH == 2) {
            as.b(mVar.cDD, n.d.cp_cont_b, 1);
            as.i((View) mVar.cDD, n.f.btn_pb_bottom_comment_selector);
        }
        if (rVar2 != null) {
            a(mVar, rVar2, view, false, i);
        }
        if (!this.cDw && this.cDx && mVar != null && mVar.cDC.Gc() && (listView = ((PbActivity) this.cGj.getPageContext().getOrignalPage()).getListView()) != null) {
            this.cDw = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(m mVar, com.baidu.tieba.tbadkCore.data.r rVar, View view, boolean z, int i) {
        if (mVar != null && rVar != null) {
            a(mVar.cDC, (int) this.mContext.getResources().getDimension(n.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mVar.cDC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            mVar.cDC.setLayoutParams(layoutParams);
            mVar.cDC.setPadding(0, 0, 0, 0);
            mVar.cDC.gl(null);
            if (rVar.aFq() == 1) {
                mVar.cDH.setVisibility(0);
                String str = null;
                long j = 0;
                if (rVar.getAuthor() != null) {
                    j = rVar.getAuthor().getUserIdLong();
                    str = rVar.getAuthor().getUserName();
                }
                mVar.cDH.a(rVar.aFz(), str, j, com.baidu.adp.lib.h.b.c(this.cDR.akH().getId(), 0L), com.baidu.adp.lib.h.b.c(rVar.getId(), 0L));
                mVar.cDH.tr();
                if (this.cDs) {
                    PraiseData praise = this.cDR.akH().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        mVar.cDF.setVisibility(0);
                        mVar.cDE.setVisibility(0);
                        mVar.cDG.setVisibility(0);
                        mVar.cDF.setIsFromPb(true);
                        mVar.cDF.a(praise, this.cDR.akH().getId(), praise.getPostId(), true);
                        mVar.cDF.cR(this.mSkinType);
                    } else {
                        mVar.cDF.setVisibility(8);
                        mVar.cDE.setVisibility(8);
                        mVar.cDG.setVisibility(8);
                    }
                } else {
                    mVar.cDF.setVisibility(8);
                    mVar.cDE.setVisibility(8);
                    mVar.cDG.setVisibility(8);
                }
                a(mVar.cDC, (int) this.mContext.getResources().getDimension(n.e.ds30));
            } else {
                mVar.cDH.setVisibility(8);
            }
            mVar.cDC.setVideoImageId(n.f.pic_video);
            mVar.cDC.setTextColor(as.getColor(n.d.pb_listitem_content));
            mVar.cDC.setLinkTextColor(as.getColor(n.d.cp_link_tip_c));
            mVar.cDC.setLinkTextColor(as.getColor(n.d.cp_link_tip_c));
            if (this.cDr) {
                mVar.cDC.setDefaultImageId(n.f.img_default_100);
            } else {
                mVar.cDC.setDefaultImageId(n.f.icon_click);
            }
            mVar.cDC.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (rVar.aFq() == 1 && this.cDR.akH().sJ()) {
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
                mVar.cDD.setVisibility(8);
                int sH = this.cDR.akH().sH();
                if (sH == 1 || sH == 2 || sH == 4) {
                    mVar.cDD.setVisibility(0);
                    mVar.cDD.setOnClickListener(new i(this));
                    mVar.cDD.setEnabled(true);
                }
                Integer num = cDv.get(Integer.valueOf(sH));
                if (num != null) {
                    mVar.cDD.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                mVar.cDD.setVisibility(8);
            }
            if (aVar == null) {
                aVar = rVar.aFr();
            }
            if (this.cDw || !this.cDx) {
                mVar.cDC.a(aVar, false);
            } else {
                mVar.cDC.a(aVar, true);
            }
            a(mVar, rVar);
            b(mVar, rVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(m mVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        int i;
        if (rVar == null || rVar.aFl() == null) {
            mVar.cDV.setVisibility(8);
            return;
        }
        as.a(mVar.cDK, n.d.cp_link_tip_c, 1, this.mSkinType);
        as.a(mVar.cDM, n.d.cp_link_tip_c, 1, this.mSkinType);
        as.a(mVar.cDL, n.d.cp_cont_b, 1, this.mSkinType);
        as.d(mVar.cDN, n.d.cp_bg_line_a, this.mSkinType);
        as.d(mVar.cDO, n.d.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c aFl = rVar.aFl();
        if (aFl == null) {
            mVar.cDV.setVisibility(8);
            return;
        }
        String aEL = aFl.aEL();
        if (!StringUtils.isNULL(aEL)) {
            mVar.cDL.setText(aEL);
        } else {
            mVar.cDL.setText(n.j.show_pic_list);
        }
        mVar.cDK.setVisibility(8);
        mVar.cDM.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> aEN = aFl.aEN();
        if (aEN != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : aEN) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            mVar.cDK.setVisibility(0);
                            mVar.cDK.setText(bVar.getDescription());
                            mVar.cDK.setTag(bVar.aEK());
                            mVar.cDK.setOnClickListener(this.bjD);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        mVar.cDM.setVisibility(0);
                        mVar.cDM.setText(bVar.getDescription());
                        mVar.cDM.setTag(bVar.aEK());
                        mVar.cDM.setOnClickListener(this.bjD);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> aEM = aFl.aEM();
        mVar.cDJ.removeAllViews();
        if (aEM == null || aEM.size() == 0) {
            a(mVar);
            mVar.cDM.setVisibility(8);
            return;
        }
        int size = aEM.size();
        if (mVar.cDP == null) {
            mVar.cDP = new SparseArray<>();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < size && i3 < 3) {
            com.baidu.tieba.tbadkCore.data.a aVar = aEM.get(i2);
            if (aVar != null) {
                com.baidu.tieba.pb.view.i iVar = mVar.cDP.get(i3);
                com.baidu.tieba.pb.view.i iVar2 = iVar;
                if (iVar == null) {
                    com.baidu.tieba.pb.view.i iVar3 = new com.baidu.tieba.pb.view.i(this.mContext);
                    iVar3.setOnClickListener(iVar3);
                    mVar.cDP.put(i3, iVar3);
                    iVar2 = iVar3;
                }
                iVar2.Gd();
                iVar2.setData(aVar);
                iVar2.onChangeSkinType(this.cGj.getPageContext(), this.mSkinType);
                iVar2.setIconResId(this.cDS[i3]);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                iVar2.setLayoutParams(layoutParams);
                iVar2.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds20));
                mVar.cDJ.addView(iVar2, layoutParams);
                i = i3 + 1;
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        if (i3 == 0) {
            a(mVar);
            mVar.cDM.setVisibility(8);
            return;
        }
        mVar.cDM.setVisibility(0);
    }

    private void a(m mVar) {
        if (mVar.mNoDataView == null) {
            mVar.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 0), NoDataViewFactory.d.ac(this.mContext.getResources().getString(n.j.show_pic_no_pic), this.mContext.getResources().getString(n.j.share_your_pic)), null);
            mVar.mNoDataView.onChangeSkinType(this.cGj.getPageContext(), this.mSkinType);
            mVar.mNoDataView.setVisibility(0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds20));
        mVar.mNoDataView.setLayoutParams(layoutParams);
        mVar.cDJ.addView(mVar.mNoDataView);
    }

    private void b(m mVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cDr) {
            mVar.cDC.setOnClickListener(null);
        } else {
            mVar.cDC.setOnClickListener(this.bjD);
        }
        mVar.cDC.setTextViewCheckSelection(false);
        mVar.cDC.setTextViewOnClickListener(new j(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cDz - (i - this.cDy));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(m mVar) {
        mVar.cDC.setOnLongClickListener(this.amQ);
        mVar.cDC.setOnTouchListener(this.cDu);
        mVar.cDC.setOnImageClickListener(this.aFq);
        mVar.cDC.setOnEmotionClickListener(((PbActivity) this.cGj.getPageContext().getOrignalPage()).cFr.cKo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cDR = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cDq = i;
    }

    public void eS(boolean z) {
        this.cDr = z;
    }

    public void eU(boolean z) {
        this.cDQ = z;
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
    public void alc() {
        com.baidu.tbadk.editortools.d.e alf;
        if (this.cGj != null && (alf = this.cGj.alf()) != null) {
            if (this.cGj.alh() != null) {
                this.cGj.alh().amz();
            }
            com.baidu.tbadk.editortools.d.b.BK().setStatus(1);
            alf.em(140);
            WriteImagesInfo writeImagesInfo = alf.getWriteImagesInfo();
            if (writeImagesInfo == null) {
                writeImagesInfo = new WriteImagesInfo();
            }
            writeImagesInfo.clear();
            writeImagesInfo.setMaxImagesAllowed(1);
            alf.Ci();
            alf.el(1);
            alf.ej(SendView.auM);
            alf.ek(SendView.auM);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, writeImagesInfo.toJsonString(), String.valueOf(System.currentTimeMillis()), 2);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ald() {
        if (this.cGj != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tieba.pb.pb.main.c cVar = new com.baidu.tieba.pb.pb.main.c(this.cGj.getActivity());
            c.C0075c c0075c = new c.C0075c();
            c0075c.cET = this.cGj.getPageContext();
            c0075c.cEY = this.cGj.getPageContext().getPageActivity().getString(n.j.no_attention_on_forum);
            c0075c.cES = this.cGj.getPageContext().getPageActivity().getString(n.j.attention_before_show_pic);
            c0075c.cEU = TbadkCoreApplication.m411getInst().getString(n.j.cancel);
            c0075c.cEV = TbadkCoreApplication.m411getInst().getString(n.j.attention);
            c0075c.cEW = new k(this, currentAccount);
            c0075c.cEX = new l(this, currentAccount);
            cVar.b(c0075c);
        }
    }
}
