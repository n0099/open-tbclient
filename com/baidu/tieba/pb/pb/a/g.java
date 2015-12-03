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
import com.baidu.tieba.pb.pb.main.cb;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class g extends cb<com.baidu.tieba.tbadkCore.data.o, m> implements View.OnClickListener {
    private static HashMap<Integer, Integer> czQ = new HashMap<>();
    private x Ml;
    private TbRichTextView.d aDR;
    private com.baidu.adp.base.g aQL;
    private View.OnLongClickListener alK;
    private View.OnClickListener bfL;
    private boolean cAl;
    private com.baidu.tieba.pb.a.c cAm;
    private int[] cAn;
    private int czL;
    private boolean czM;
    private boolean czN;
    private com.baidu.tieba.pb.b.c czP;
    private boolean czR;
    private final boolean czS;
    private int czT;
    private int czU;

    static {
        czQ.put(1, Integer.valueOf(n.i.i_want_share_picture));
        czQ.put(2, Integer.valueOf(n.i.look_result));
        czQ.put(4, Integer.valueOf(n.i.i_want_share_picture));
    }

    public g(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.czL = 0;
        this.czM = true;
        this.cAl = true;
        this.czN = true;
        this.cAm = null;
        this.bfL = null;
        this.aDR = null;
        this.czP = null;
        this.alK = null;
        this.czR = false;
        this.czS = Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 16;
        this.aQL = new h(this);
        this.cAn = new int[]{n.e.icon_grade_shaitu1, n.e.icon_grade_shaitu2, n.e.icon_grade_shaitu3};
        init();
    }

    private void init() {
        this.Ml = new x(this.cCy.getPageContext());
        this.Ml.setLoadDataCallBack(this.aQL);
        this.czT = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds30);
        this.czU = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public m a(ViewGroup viewGroup) {
        return new m(LayoutInflater.from(this.mContext).inflate(n.g.new_pb_list_item_show_pic, viewGroup, false), this.cAl, this.czM, this.czL, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cb, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.o oVar, m mVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.tbadkCore.data.o) mVar);
        as.j(mVar.cAp, n.c.cp_bg_line_d);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(mVar);
        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) aB(i);
        as.j(mVar.czZ, n.c.cp_bg_line_b);
        as.j(mVar.cAa, n.c.cp_bg_line_e);
        as.j(mVar.cAb, n.c.cp_bg_line_e);
        as.c(mVar.cAb, n.c.cp_bg_line_b);
        int sX = this.cAm.ajz().sX();
        if (sX == 1 || sX == 4) {
            as.b(mVar.czY, n.c.cp_cont_i, 1);
            as.i((View) mVar.czY, n.e.buy_yinji_btn_bg);
        } else if (sX == 2) {
            as.b(mVar.czY, n.c.cp_cont_b, 1);
            as.i((View) mVar.czY, n.e.btn_pb_bottom_comment_selector);
        }
        if (oVar2 != null) {
            a(mVar, oVar2, view, false, i);
        }
        if (!this.czR && this.czS && mVar != null && mVar.czX.Gn() && (listView = ((PbActivity) this.cCy.getPageContext().getOrignalPage()).getListView()) != null) {
            this.czR = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(m mVar, com.baidu.tieba.tbadkCore.data.o oVar, View view, boolean z, int i) {
        if (mVar != null && oVar != null) {
            a(mVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mVar.czX.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            mVar.czX.setLayoutParams(layoutParams);
            mVar.czX.setPadding(0, 0, 0, 0);
            mVar.czX.gh(null);
            if (oVar.aDd() == 1) {
                mVar.cAc.setVisibility(0);
                String str = null;
                long j = 0;
                if (oVar.getAuthor() != null) {
                    j = oVar.getAuthor().getUserIdLong();
                    str = oVar.getAuthor().getUserName();
                }
                mVar.cAc.a(oVar.aDm(), str, j, com.baidu.adp.lib.h.b.c(this.cAm.ajz().getId(), 0L), com.baidu.adp.lib.h.b.c(oVar.getId(), 0L));
                mVar.cAc.tH();
                if (this.czN) {
                    PraiseData praise = this.cAm.ajz().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        mVar.cAa.setVisibility(0);
                        mVar.czZ.setVisibility(0);
                        mVar.cAb.setVisibility(0);
                        mVar.cAa.setIsFromPb(true);
                        mVar.cAa.a(praise, this.cAm.ajz().getId(), praise.getPostId(), true);
                        mVar.cAa.cX(this.mSkinType);
                    } else {
                        mVar.cAa.setVisibility(8);
                        mVar.czZ.setVisibility(8);
                        mVar.cAb.setVisibility(8);
                    }
                } else {
                    mVar.cAa.setVisibility(8);
                    mVar.czZ.setVisibility(8);
                    mVar.cAb.setVisibility(8);
                }
                a(mVar.czX, (int) this.mContext.getResources().getDimension(n.d.ds30));
            } else {
                mVar.cAc.setVisibility(8);
            }
            mVar.czX.setVideoImageId(n.e.pic_video);
            mVar.czX.setTextColor(as.getColor(n.c.pb_listitem_content));
            mVar.czX.setLinkTextColor(as.getColor(n.c.cp_link_tip_c));
            mVar.czX.setLinkTextColor(as.getColor(n.c.cp_link_tip_c));
            if (this.czM) {
                mVar.czX.setDefaultImageId(n.e.img_default_100);
            } else {
                mVar.czX.setDefaultImageId(n.e.icon_click);
            }
            mVar.czX.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (oVar.aDd() == 1 && this.cAm.ajz().sZ()) {
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
                mVar.czY.setVisibility(8);
                int sX = this.cAm.ajz().sX();
                if (sX == 1 || sX == 2 || sX == 4) {
                    mVar.czY.setVisibility(0);
                    mVar.czY.setOnClickListener(new i(this));
                    mVar.czY.setEnabled(true);
                }
                Integer num = czQ.get(Integer.valueOf(sX));
                if (num != null) {
                    mVar.czY.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                mVar.czY.setVisibility(8);
            }
            if (aVar == null) {
                aVar = oVar.aDe();
            }
            if (this.czR || !this.czS) {
                mVar.czX.a(aVar, false);
            } else {
                mVar.czX.a(aVar, true);
            }
            a(mVar, oVar);
            b(mVar, oVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(m mVar, com.baidu.tieba.tbadkCore.data.o oVar) {
        int i;
        if (oVar == null || oVar.aCY() == null) {
            mVar.cAq.setVisibility(8);
            return;
        }
        as.a(mVar.cAf, n.c.cp_link_tip_c, 1, this.mSkinType);
        as.a(mVar.cAh, n.c.cp_link_tip_c, 1, this.mSkinType);
        as.a(mVar.cAg, n.c.cp_cont_b, 1, this.mSkinType);
        as.d(mVar.cAi, n.c.cp_bg_line_a, this.mSkinType);
        as.d(mVar.cAj, n.c.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c aCY = oVar.aCY();
        if (aCY == null) {
            mVar.cAq.setVisibility(8);
            return;
        }
        String aCE = aCY.aCE();
        if (!StringUtils.isNULL(aCE)) {
            mVar.cAg.setText(aCE);
        } else {
            mVar.cAg.setText(n.i.show_pic_list);
        }
        mVar.cAf.setVisibility(8);
        mVar.cAh.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> aCG = aCY.aCG();
        if (aCG != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : aCG) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            mVar.cAf.setVisibility(0);
                            mVar.cAf.setText(bVar.getDescription());
                            mVar.cAf.setTag(bVar.aCD());
                            mVar.cAf.setOnClickListener(this.bfL);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        mVar.cAh.setVisibility(0);
                        mVar.cAh.setText(bVar.getDescription());
                        mVar.cAh.setTag(bVar.aCD());
                        mVar.cAh.setOnClickListener(this.bfL);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> aCF = aCY.aCF();
        mVar.cAe.removeAllViews();
        if (aCF == null || aCF.size() == 0) {
            a(mVar);
            mVar.cAh.setVisibility(8);
            return;
        }
        int size = aCF.size();
        if (mVar.cAk == null) {
            mVar.cAk = new SparseArray<>();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < size && i3 < 3) {
            com.baidu.tieba.tbadkCore.data.a aVar = aCF.get(i2);
            if (aVar != null) {
                com.baidu.tieba.pb.view.f fVar = mVar.cAk.get(i3);
                com.baidu.tieba.pb.view.f fVar2 = fVar;
                if (fVar == null) {
                    com.baidu.tieba.pb.view.f fVar3 = new com.baidu.tieba.pb.view.f(this.mContext);
                    fVar3.setOnClickListener(fVar3);
                    mVar.cAk.put(i3, fVar3);
                    fVar2 = fVar3;
                }
                fVar2.Go();
                fVar2.setData(aVar);
                fVar2.onChangeSkinType(this.cCy.getPageContext(), this.mSkinType);
                fVar2.setIconResId(this.cAn[i3]);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                fVar2.setLayoutParams(layoutParams);
                fVar2.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds20));
                mVar.cAe.addView(fVar2, layoutParams);
                i = i3 + 1;
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        if (i3 == 0) {
            a(mVar);
            mVar.cAh.setVisibility(8);
            return;
        }
        mVar.cAh.setVisibility(0);
    }

    private void a(m mVar) {
        if (mVar.mNoDataView == null) {
            mVar.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 0), NoDataViewFactory.d.ad(this.mContext.getResources().getString(n.i.show_pic_no_pic), this.mContext.getResources().getString(n.i.share_your_pic)), null);
            mVar.mNoDataView.onChangeSkinType(this.cCy.getPageContext(), this.mSkinType);
            mVar.mNoDataView.setVisibility(0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds20));
        mVar.mNoDataView.setLayoutParams(layoutParams);
        mVar.cAe.addView(mVar.mNoDataView);
    }

    private void b(m mVar, com.baidu.tieba.tbadkCore.data.o oVar) {
        if (TextUtils.isEmpty(oVar.getBimg_url()) || !this.czM) {
            mVar.czX.setOnClickListener(null);
        } else {
            mVar.czX.setOnClickListener(this.bfL);
        }
        mVar.czX.setTextViewCheckSelection(false);
        mVar.czX.setTextViewOnClickListener(new j(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.czU - (i - this.czT));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(m mVar) {
        mVar.czX.setOnLongClickListener(this.alK);
        mVar.czX.setOnTouchListener(this.czP);
        mVar.czX.setOnImageClickListener(this.aDR);
        mVar.czX.setOnEmotionClickListener(((PbActivity) this.cCy.getPageContext().getOrignalPage()).cBM.cGp);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cAm = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.czL = i;
    }

    public void eT(boolean z) {
        this.czM = z;
    }

    public void eV(boolean z) {
        this.cAl = z;
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
    public void ajV() {
        com.baidu.tbadk.editortools.d.e ajY;
        if (this.cCy != null && (ajY = this.cCy.ajY()) != null) {
            if (this.cCy.aka() != null) {
                this.cCy.aka().aln();
            }
            com.baidu.tbadk.editortools.d.b.BV().setStatus(1);
            ajY.es(140);
            WriteImagesInfo writeImagesInfo = ajY.getWriteImagesInfo();
            if (writeImagesInfo == null) {
                writeImagesInfo = new WriteImagesInfo();
            }
            writeImagesInfo.clear();
            writeImagesInfo.setMaxImagesAllowed(1);
            ajY.Ct();
            ajY.er(1);
            ajY.ep(SendView.ati);
            ajY.eq(SendView.ati);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, writeImagesInfo.toJsonString(), String.valueOf(System.currentTimeMillis()), 2);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajW() {
        if (this.cCy != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tieba.pb.pb.main.c cVar = new com.baidu.tieba.pb.pb.main.c(this.cCy.getActivity());
            c.C0080c c0080c = new c.C0080c();
            c0080c.cBo = this.cCy.getPageContext();
            c0080c.cBt = this.cCy.getPageContext().getPageActivity().getString(n.i.no_attention_on_forum);
            c0080c.cBn = this.cCy.getPageContext().getPageActivity().getString(n.i.attention_before_show_pic);
            c0080c.cBp = TbadkCoreApplication.m411getInst().getString(n.i.cancel);
            c0080c.cBq = TbadkCoreApplication.m411getInst().getString(n.i.attention);
            c0080c.cBr = new k(this, currentAccount);
            c0080c.cBs = new l(this, currentAccount);
            cVar.b(c0080c);
        }
    }
}
