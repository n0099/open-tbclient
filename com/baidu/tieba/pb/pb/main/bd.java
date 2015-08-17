package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class bd {
    private BdTypeListView aVy;
    private bh cbA;
    private bq cbB;
    private com.baidu.tieba.pb.a.b cbC;
    private int cbH;
    private PbActivity cbx;
    private br cby;
    private bg cbz;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.i> cbD = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cbE = true;
    private boolean cbF = true;
    private boolean cbG = true;
    private String cbI = null;
    private View.OnClickListener cbJ = null;
    private View.OnClickListener aZc = null;
    private TbRichTextView.c aBY = null;
    private com.baidu.tieba.pb.pb.sub.ai cbK = null;
    private com.baidu.tieba.pb.b.c cbb = null;
    private View.OnLongClickListener akJ = null;
    private List<com.baidu.adp.widget.ListView.a> aVP = new ArrayList();
    private final CustomMessageListener aVd = new be(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public bd(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cbH = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.cbH = com.baidu.adp.lib.util.k.K(pbActivity.getPageContext().getPageActivity());
        this.width = this.cbH;
        this.cbx = pbActivity;
        this.aVy = bdTypeListView;
        pbActivity.registerListener(this.aVd);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cby = new br(pbActivity, com.baidu.tieba.tbadkCore.data.i.cIF);
        this.cbz = new bg(pbActivity, com.baidu.tbadk.core.data.c.Ub);
        this.cbA = new bh(pbActivity, com.baidu.tbadk.core.data.c.Uc);
        this.cbB = new bq(pbActivity, com.baidu.tbadk.core.data.z.Wg);
        this.aVP.add(this.cby);
        this.aVP.add(this.cbz);
        this.aVP.add(this.cbA);
        this.aVP.add(this.cbB);
        bdTypeListView.h(this.aVP);
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        boolean z;
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList;
        int size;
        com.baidu.tieba.tbadkCore.data.i iVar;
        int size2;
        if (this.cbC != bVar) {
            z = (bVar == null || bVar.acF()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.cbC = bVar;
        if (z) {
            adu();
            if (bVar != null) {
                bVar.ec(false);
            }
        }
        if (this.cbD == null) {
            this.cbD = new ArrayList<>();
        }
        this.cbD.clear();
        if (this.cbC != null && this.cbC.acI() != null && this.cbC.acI().size() > 0) {
            this.cbD.addAll(this.cbC.acI());
        }
        if (bVar != null && bVar.acH() != null && bVar.acH().getAuthor() != null) {
            this.cbI = bVar.acH().getAuthor().getUserId();
        }
        if (this.cby != null && this.cbz != null) {
            this.cby.b(bVar);
            this.cby.setFromCDN(this.mIsFromCDN);
            this.cby.jm(this.cbI);
            this.cby.setImageMaxWidth(this.cbH);
            this.cby.eh(this.cbE);
            this.cby.ei(this.cbF);
            this.cby.ej(this.cbG);
            this.cby.n(this.aZc);
            this.cby.B(this.cbJ);
            this.cby.setOnImageClickListener(this.aBY);
            this.cby.setOnLongClickListener(this.akJ);
            this.cby.a(this.cbb);
            this.cbz.setFromCDN(this.mIsFromCDN);
            this.cbA.setFromCDN(this.mIsFromCDN);
            if (bVar.acI() != null) {
                arrayList = new ArrayList<>(bVar.acI());
            } else {
                arrayList = new ArrayList<>();
            }
            if (!this.cbG && bVar != null && bVar.acI() != null && (size = bVar.acI().size()) > 0 && (iVar = bVar.acI().get(size - 1)) != null && iVar.apV() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            int a = a(this.cbC, arrayList, this.cbG);
            if (a >= 0) {
                arrayList.add(a, this.cbC.acJ());
            }
            this.cbB.s(this.aZc);
            if (this.aVy != null) {
                this.aVy.setData(arrayList);
            }
        }
    }

    public int a(com.baidu.tieba.pb.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList, boolean z) {
        if (bVar == null || bVar.acI() == null || bVar.acJ() == null || bVar.acI().size() == 0 || bVar.acH() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(bVar.acJ().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (bVar.acI().get(0) == null || bVar.acI().get(0).apV() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (bVar.getPage() == null || bVar.getPage().rR() != bVar.getPage().rP()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        return this.aVy.aA(i);
    }

    public BdUniqueId ip(int i) {
        if (this.aVy.aA(i) != null) {
            return this.aVy.aA(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.aVy.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVy.getAdapter()).notifyDataSetChanged();
        }
    }

    private void adu() {
        com.baidu.tieba.tbadkCore.data.h hVar;
        int position;
        if (this.cbC != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acI = this.cbC.acI();
            ArrayList<com.baidu.tieba.tbadkCore.data.h> acO = this.cbC.acO();
            if (acO != null) {
                int size = acO.size();
                if (acI != null && acI.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.h> it = acO.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.h next = it.next();
                        if (next != null && next.apN() != null) {
                            sb.append(next.apN());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.h> it2 = acO.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.h next2 = it2.next();
                        if (next2 != null) {
                            next2.aZG = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.h> it3 = acO.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.h next3 = it3.next();
                        if (next3.apM() != null && next3.apM().rv() && !com.baidu.tieba.tbadkCore.af.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.apM().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.h hVar2 = (com.baidu.tieba.tbadkCore.data.h) sparseArray.get(sparseArray.keyAt(i));
                        if (hVar2 != null) {
                            hashMap.put(hVar2.apN(), hVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (hVar = (com.baidu.tieba.tbadkCore.data.h) entry.getValue()) != null) {
                            sparseArray.put(hVar.getPosition(), hVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new bf(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.h hVar3 = (com.baidu.tieba.tbadkCore.data.h) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = hVar3.getPosition();
                        if (position2 + i3 < acI.size()) {
                            if (this.cbC.acG() != null) {
                                hVar3.cIE = this.cbC.acG().getId();
                            }
                            if (this.cbC.acH() != null) {
                                hVar3.threadId = com.baidu.adp.lib.g.b.c(this.cbC.acH().getId(), 0L);
                            }
                            acI.add(position2 + i3, hVar3);
                            TiebaStatic.eventStat(this.cbx.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", hVar3.apM().apk_name);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.cby.setFromCDN(z);
        this.cbz.setFromCDN(z);
        this.cbA.setFromCDN(z);
    }

    public void eh(boolean z) {
        this.cbE = z;
    }

    public void ei(boolean z) {
        this.cbF = z;
    }

    public void ej(boolean z) {
        this.cbG = z;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cbJ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aBY = cVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cbb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.akJ = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.aZc = onClickListener;
    }
}
