package com.baidu.tieba.pb.videopb;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.recapp.l;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.n;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class c {
    private ArrayList<o> eVq;
    private BdTypeRecyclerView hrX;
    private com.baidu.adp.widget.ListView.a ifc;
    private com.baidu.tieba.pb.data.e jIA;
    private k jIp;
    private com.baidu.adp.widget.ListView.a jIs;
    private com.baidu.tieba.pb.pb.a.c jIw;
    private ReplyFragment kdS;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private boolean kdT = true;
    private String aPJ = null;
    private boolean jIB = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener jIK = null;
    private View.OnClickListener aIH = null;
    private TbRichTextView.i eBN = null;
    private com.baidu.tieba.pb.a.c efF = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kdS = replyFragment;
        this.hrX = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.jIp = new k(this.kdS.cFr(), PostData.llS);
        this.jIp.a((TbRichTextView.c) this.kdS.cFr());
        this.jIw = new com.baidu.tieba.pb.pb.a.c(this.kdS.cFr(), PostData.llX);
        this.ifc = q.cUC().a(this.kdS.cFr().getBaseFragmentActivity(), AdvertAppInfo.dAi);
        this.jIs = q.cUC().a(this.kdS.cFr().getBaseFragmentActivity(), AdvertAppInfo.dAm);
        this.aSj.add(this.ifc);
        this.aSj.add(this.jIs);
        this.aSj.add(this.jIp);
        this.aSj.add(this.jIw);
        this.hrX.addAdapters(this.aSj);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        boolean z;
        if (eVar != null) {
            this.jIA = eVar;
            if (eVar != null && eVar.cCy() != null && eVar.cCy().aQx() != null) {
                this.aPJ = eVar.cCy().aQx().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.jIA != null && this.jIA.cCA() != null && this.jIA.cCA().size() > 0) {
                this.postList.addAll(this.jIA.cCA());
            }
            this.jIp.setData(eVar);
            this.jIp.setFromCDN(this.mIsFromCDN);
            this.jIp.fl(this.aPJ);
            this.jIp.re(this.jIB);
            this.jIp.y(this.aIH);
            this.jIp.Q(this.jIK);
            this.jIp.setOnImageClickListener(this.eBN);
            this.jIp.setOnLongClickListener(this.mOnLongClickListener);
            this.jIp.setTbGestureDetector(this.efF);
            this.jIw.setOnClickListener(this.aIH);
            cEn();
            if (this.jIs != null && (this.jIs instanceof l)) {
                ((l) this.jIs).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<o> arrayList = new ArrayList<>(eVar.cCA());
            Iterator<o> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                o next = it.next();
                if ((next instanceof PostData) && ((PostData) next).ddJ() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.hrX != null) {
                this.eVq = arrayList;
                this.hrX.setData(this.eVq);
            }
        }
    }

    private void cEn() {
        n nVar;
        n nVar2;
        if (this.jIA != null && !this.jIA.jFR && this.jIA.WR != 2) {
            ArrayList<PostData> cCA = this.jIA.cCA();
            ArrayList<n> cCP = this.jIA.cCP();
            if (cCP != null && !cCP.isEmpty() && cCA != null && !cCA.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = cCP.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<n> it2 = cCP.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.hFS = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = cCP.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.ddx() != null) {
                        int aOy = next3.ddx().aOy();
                        if (aOy != 0) {
                            a(next3, aOy);
                            if (aOy != 28 && aOy != 31) {
                                if (next3.ddx().goods != null) {
                                    next3.ddx().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + aOy);
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); i++) {
                    n nVar3 = (n) sparseArray.get(sparseArray.keyAt(i));
                    if (nVar3 != null && (nVar2 = (n) hashMap.put(nVar3.getAdId(), nVar3)) != null) {
                        b(nVar2, 30);
                    }
                }
                sparseArray.clear();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry != null && (nVar = (n) entry.getValue()) != null) {
                        sparseArray.put(nVar.getPosition(), nVar);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    n nVar4 = (n) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                    if (this.jIA.getForum() != null) {
                        nVar4.forumId = this.jIA.getForum().getId();
                    }
                    if (this.jIA.cCy() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.jIA.cCy().getId(), 0L);
                    }
                    if (this.jIA != null && this.jIA.getPage() != null) {
                        nVar4.pageNumber = this.jIA.getPage().aPr();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.jIA.jFQ;
                    if (position + i3 >= cCA.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kdT) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (d(cCA, position)) {
                        a(nVar4, 1);
                    } else {
                        cCA.add(position, nVar4);
                        TiebaStatic.eventStat(this.kdS.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.ddx().apk_name);
                    }
                }
            }
        }
    }

    private boolean d(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof n) {
                return true;
            }
        }
        return false;
    }

    private void a(n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = g.c(nVar, 5);
        c.Cu(i);
        com.baidu.tieba.recapp.report.d.cVA().a(c);
        if (nVar != null && nVar.ddx() != null) {
            nVar.ddx().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.ddx() != null && nVar.ddx().goods != null && nVar.ddx().goods.goods_style != 1001 && nVar.ddx().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.jIA != null && nVar.ddx() != null) {
            nVar.ddx().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.jIA.getPage() != null) {
                nVar.ddx().advertAppContext.pn = this.jIA.getPage().aPr();
            }
            nVar.ddx().advertAppContext.page = nVar.ddA();
            if (this.jIA.getForum() != null && (forum = this.jIA.getForum()) != null) {
                nVar.ddx().advertAppContext.fid = forum.getId();
                nVar.ddx().advertAppContext.dzZ = forum.getFirst_class();
                nVar.ddx().advertAppContext.dAa = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.ddx().advertAppContext.dAb = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.ddx().advertAppContext.extensionInfo = nVar.ddx().ext_info;
            nVar.ddx().advertAppContext.WZ = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jIK = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBN = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.efF = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.hrX.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            this.hrX.getAdapter().notifyDataSetChanged();
        }
    }

    public ArrayList<o> getDataList() {
        return this.eVq;
    }

    public void sB(boolean z) {
        this.kdT = z;
    }
}
