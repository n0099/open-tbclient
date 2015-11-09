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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.bz;
import com.baidu.tieba.pb.pb.main.c;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class g extends bz<com.baidu.tieba.tbadkCore.data.o, m> implements View.OnClickListener {
    private static HashMap<Integer, Integer> cht = new HashMap<>();
    private w LU;
    private TbRichTextView.d aBf;
    private com.baidu.adp.base.g aMc;
    private View.OnClickListener aZI;
    private View.OnLongClickListener ajZ;
    private boolean chO;
    private com.baidu.tieba.pb.a.c chP;
    private int[] chQ;
    private int cho;
    private boolean chp;
    private boolean chq;
    private com.baidu.tieba.pb.b.c chs;
    private boolean chu;
    private final boolean chv;
    private int chw;
    private int chx;

    static {
        cht.put(1, Integer.valueOf(i.h.i_want_share_picture));
        cht.put(2, Integer.valueOf(i.h.look_result));
        cht.put(4, Integer.valueOf(i.h.i_want_share_picture));
    }

    public g(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        this.cho = 0;
        this.chp = true;
        this.chO = true;
        this.chq = true;
        this.chP = null;
        this.aZI = null;
        this.aBf = null;
        this.chs = null;
        this.ajZ = null;
        this.chu = false;
        this.chv = Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <= 16;
        this.aMc = new h(this);
        this.chQ = new int[]{i.e.icon_grade_shaitu1, i.e.icon_grade_shaitu2, i.e.icon_grade_shaitu3};
        init();
    }

    private void init() {
        this.LU = new w(this.cjZ.getPageContext());
        this.LU.setLoadDataCallBack(this.aMc);
        this.chw = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30);
        this.chx = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: H */
    public m a(ViewGroup viewGroup) {
        return new m(LayoutInflater.from(this.mContext).inflate(i.g.new_pb_list_item_show_pic, viewGroup, false), this.chO, this.chp, this.cho, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.bz, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.o oVar, m mVar) {
        BdListView listView;
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tieba.tbadkCore.data.o) mVar);
        an.j(mVar.chS, i.c.cp_bg_line_d);
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        b(mVar);
        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) aA(i);
        an.j(mVar.chD, i.c.cp_bg_line_b);
        an.j(mVar.chE, i.c.cp_bg_line_e);
        an.j(mVar.chF, i.c.cp_bg_line_e);
        an.c(mVar.chF, i.c.cp_bg_line_b);
        int sw = this.chP.afh().sw();
        if (sw == 1 || sw == 4) {
            an.b(mVar.chC, i.c.cp_cont_i, 1);
            an.i((View) mVar.chC, i.e.buy_yinji_btn_bg);
        } else if (sw == 2) {
            an.b(mVar.chC, i.c.cp_cont_b, 1);
            an.i((View) mVar.chC, i.e.btn_pb_bottom_comment_selector);
        }
        if (oVar2 != null) {
            a(mVar, oVar2, view, false, i);
        }
        if (!this.chu && this.chv && mVar != null && mVar.chB.Fi() && (listView = ((PbActivity) this.cjZ.getPageContext().getOrignalPage()).getListView()) != null) {
            this.chu = true;
            CompatibleUtile.getInstance().closeViewGpu(listView);
        }
        return view;
    }

    private void a(m mVar, com.baidu.tieba.tbadkCore.data.o oVar, View view, boolean z, int i) {
        com.baidu.tbadk.widget.richText.a aVar;
        if (mVar != null && oVar != null) {
            a(mVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mVar.chB.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            mVar.chB.setLayoutParams(layoutParams);
            mVar.chB.setPadding(0, 0, 0, 0);
            mVar.chB.fU(null);
            if (oVar.axt() == 1) {
                if (this.chq) {
                    PraiseData praise = this.chP.afh().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        mVar.chE.setVisibility(0);
                        mVar.chD.setVisibility(0);
                        mVar.chF.setVisibility(0);
                        mVar.chE.setIsFromPb(true);
                        mVar.chE.a(praise, this.chP.afh().getId(), praise.getPostId(), true);
                        mVar.chE.cP(this.mSkinType);
                    } else {
                        mVar.chE.setVisibility(8);
                        mVar.chD.setVisibility(8);
                        mVar.chF.setVisibility(8);
                    }
                } else {
                    mVar.chE.setVisibility(8);
                    mVar.chD.setVisibility(8);
                    mVar.chF.setVisibility(8);
                }
                a(mVar.chB, (int) this.mContext.getResources().getDimension(i.d.ds30));
            }
            mVar.chB.setVideoImageId(i.e.pic_video);
            mVar.chB.setTextColor(an.getColor(i.c.pb_listitem_content));
            mVar.chB.setLinkTextColor(an.getColor(i.c.cp_link_tip_c));
            mVar.chB.setLinkTextColor(an.getColor(i.c.cp_link_tip_c));
            if (this.chp) {
                mVar.chB.setDefaultImageId(i.e.img_default_100);
            } else {
                mVar.chB.setDefaultImageId(i.e.icon_click);
            }
            mVar.chB.setIsFromCDN(this.mIsFromCDN);
            if (oVar.axt() == 1 && this.chP.afh().sy()) {
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
                mVar.chC.setVisibility(8);
                int sw = this.chP.afh().sw();
                if (sw == 1 || sw == 2 || sw == 4) {
                    mVar.chC.setVisibility(0);
                    mVar.chC.setOnClickListener(new i(this));
                    mVar.chC.setEnabled(true);
                }
                Integer num = cht.get(Integer.valueOf(sw));
                if (num != null) {
                    mVar.chC.setText(num.intValue());
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                mVar.chC.setVisibility(8);
                aVar = null;
            }
            if (aVar == null) {
                aVar = oVar.axu();
            }
            if (this.chu || !this.chv) {
                mVar.chB.a(aVar, false);
            } else {
                mVar.chB.a(aVar, true);
            }
            a(mVar, oVar);
            b(mVar, oVar);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(m mVar, com.baidu.tieba.tbadkCore.data.o oVar) {
        int i;
        if (oVar == null || oVar.axo() == null) {
            mVar.chT.setVisibility(8);
            return;
        }
        an.a(mVar.chI, i.c.cp_link_tip_c, 1, this.mSkinType);
        an.a(mVar.chK, i.c.cp_link_tip_c, 1, this.mSkinType);
        an.a(mVar.chJ, i.c.cp_cont_b, 1, this.mSkinType);
        an.d(mVar.chL, i.c.cp_bg_line_a, this.mSkinType);
        an.d(mVar.chM, i.c.cp_bg_line_a, this.mSkinType);
        com.baidu.tieba.tbadkCore.data.c axo = oVar.axo();
        if (axo == null) {
            mVar.chT.setVisibility(8);
            return;
        }
        String awS = axo.awS();
        if (!StringUtils.isNULL(awS)) {
            mVar.chJ.setText(awS);
        } else {
            mVar.chJ.setText(i.h.show_pic_list);
        }
        mVar.chI.setVisibility(8);
        mVar.chK.setVisibility(8);
        List<com.baidu.tieba.tbadkCore.data.b> awU = axo.awU();
        if (awU != null) {
            for (com.baidu.tieba.tbadkCore.data.b bVar : awU) {
                if (bVar != null) {
                    if ("1".equals(bVar.getType())) {
                        if (!StringUtils.isNULL(bVar.getDescription())) {
                            mVar.chI.setVisibility(0);
                            mVar.chI.setText(bVar.getDescription());
                            mVar.chI.setTag(bVar.awR());
                            mVar.chI.setOnClickListener(this.aZI);
                        }
                    } else if ("2".equals(bVar.getType()) && !StringUtils.isNULL(bVar.getDescription())) {
                        mVar.chK.setVisibility(0);
                        mVar.chK.setText(bVar.getDescription());
                        mVar.chK.setTag(bVar.awR());
                        mVar.chK.setOnClickListener(this.aZI);
                    }
                }
            }
        }
        List<com.baidu.tieba.tbadkCore.data.a> awT = axo.awT();
        mVar.chH.removeAllViews();
        if (awT == null || awT.size() == 0) {
            a(mVar);
            mVar.chK.setVisibility(8);
            return;
        }
        int size = awT.size();
        if (mVar.chN == null) {
            mVar.chN = new SparseArray<>();
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < size && i3 < 3) {
            com.baidu.tieba.tbadkCore.data.a aVar = awT.get(i2);
            if (aVar != null) {
                com.baidu.tieba.pb.view.e eVar = mVar.chN.get(i3);
                com.baidu.tieba.pb.view.e eVar2 = eVar;
                if (eVar == null) {
                    com.baidu.tieba.pb.view.e eVar3 = new com.baidu.tieba.pb.view.e(this.mContext);
                    eVar3.setOnClickListener(eVar3);
                    mVar.chN.put(i3, eVar3);
                    eVar2 = eVar3;
                }
                eVar2.Fj();
                eVar2.setData(aVar);
                eVar2.onChangeSkinType(this.cjZ.getPageContext(), this.mSkinType);
                eVar2.setIconResId(this.chQ[i3]);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                eVar2.setLayoutParams(layoutParams);
                eVar2.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds20));
                mVar.chH.addView(eVar2, layoutParams);
                i = i3 + 1;
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        if (i3 == 0) {
            a(mVar);
            mVar.chK.setVisibility(8);
            return;
        }
        mVar.chK.setVisibility(0);
    }

    private void a(m mVar) {
        if (mVar.mNoDataView == null) {
            mVar.mNoDataView = NoDataViewFactory.a(this.mContext, null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 0), NoDataViewFactory.d.ag(this.mContext.getResources().getString(i.h.show_pic_no_pic), this.mContext.getResources().getString(i.h.share_your_pic)), null);
            mVar.mNoDataView.onChangeSkinType(this.cjZ.getPageContext(), this.mSkinType);
            mVar.mNoDataView.setVisibility(0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds20));
        mVar.mNoDataView.setLayoutParams(layoutParams);
        mVar.chH.addView(mVar.mNoDataView);
    }

    private void b(m mVar, com.baidu.tieba.tbadkCore.data.o oVar) {
        if (TextUtils.isEmpty(oVar.getBimg_url()) || !this.chp) {
            mVar.chB.setOnClickListener(null);
        } else {
            mVar.chB.setOnClickListener(this.aZI);
        }
        mVar.chB.setTextViewCheckSelection(false);
        mVar.chB.setTextViewOnClickListener(new j(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.chx - (i - this.chw));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void b(m mVar) {
        mVar.chB.setOnLongClickListener(this.ajZ);
        mVar.chB.setOnTouchListener(this.chs);
        mVar.chB.setOnImageClickListener(this.aBf);
        mVar.chB.setOnEmotionClickListener(((PbActivity) this.cjZ.getPageContext().getOrignalPage()).cjp.cne);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.chP = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cho = i;
    }

    public void er(boolean z) {
        this.chp = z;
    }

    public void et(boolean z) {
        this.chO = z;
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
    public void afD() {
        com.baidu.tbadk.editortools.c.e afG;
        if (this.cjZ != null && (afG = this.cjZ.afG()) != null) {
            if (this.cjZ.afI() != null) {
                this.cjZ.afI().agP();
            }
            com.baidu.tbadk.editortools.c.b.AW().setStatus(1);
            afG.ee(140);
            WriteImagesInfo writeImagesInfo = afG.getWriteImagesInfo();
            if (writeImagesInfo == null) {
                writeImagesInfo = new WriteImagesInfo();
            }
            writeImagesInfo.clear();
            writeImagesInfo.setMaxImagesAllowed(1);
            afG.Bt();
            afG.ed(1);
            afG.eb(SendView.arg);
            afG.ec(SendView.arg);
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, writeImagesInfo.toJsonString(), String.valueOf(System.currentTimeMillis()), 2);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afE() {
        if (this.cjZ != null) {
            com.baidu.tieba.pb.pb.main.c cVar = new com.baidu.tieba.pb.pb.main.c(this.cjZ.getActivity());
            c.C0072c c0072c = new c.C0072c();
            c0072c.ciS = this.cjZ.getPageContext();
            c0072c.ciX = this.cjZ.getPageContext().getPageActivity().getString(i.h.no_attention_on_forum);
            c0072c.ciR = this.cjZ.getPageContext().getPageActivity().getString(i.h.attention_before_show_pic);
            c0072c.ciT = TbadkCoreApplication.m411getInst().getString(i.h.cancel);
            c0072c.ciU = TbadkCoreApplication.m411getInst().getString(i.h.attention);
            c0072c.ciV = new k(this);
            c0072c.ciW = new l(this);
            cVar.b(c0072c);
        }
    }
}
