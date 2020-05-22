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
    private ArrayList<o> eVf;
    private BdTypeRecyclerView hrM;
    private com.baidu.adp.widget.ListView.a iep;
    private k jHj;
    private com.baidu.adp.widget.ListView.a jHm;
    private com.baidu.tieba.pb.pb.a.c jHq;
    private com.baidu.tieba.pb.data.e jHu;
    private ReplyFragment kcM;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private boolean kcN = true;
    private String aPJ = null;
    private boolean jHv = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener jHE = null;
    private View.OnClickListener aIH = null;
    private TbRichTextView.i eBC = null;
    private com.baidu.tieba.pb.a.c efF = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kcM = replyFragment;
        this.hrM = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.jHj = new k(this.kcM.cFb(), PostData.lkJ);
        this.jHj.a((TbRichTextView.c) this.kcM.cFb());
        this.jHq = new com.baidu.tieba.pb.pb.a.c(this.kcM.cFb(), PostData.lkO);
        this.iep = q.cUm().a(this.kcM.cFb().getBaseFragmentActivity(), AdvertAppInfo.dAi);
        this.jHm = q.cUm().a(this.kcM.cFb().getBaseFragmentActivity(), AdvertAppInfo.dAm);
        this.aSj.add(this.iep);
        this.aSj.add(this.jHm);
        this.aSj.add(this.jHj);
        this.aSj.add(this.jHq);
        this.hrM.addAdapters(this.aSj);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        boolean z;
        if (eVar != null) {
            this.jHu = eVar;
            if (eVar != null && eVar.cCi() != null && eVar.cCi().aQx() != null) {
                this.aPJ = eVar.cCi().aQx().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.jHu != null && this.jHu.cCk() != null && this.jHu.cCk().size() > 0) {
                this.postList.addAll(this.jHu.cCk());
            }
            this.jHj.setData(eVar);
            this.jHj.setFromCDN(this.mIsFromCDN);
            this.jHj.fl(this.aPJ);
            this.jHj.re(this.jHv);
            this.jHj.y(this.aIH);
            this.jHj.Q(this.jHE);
            this.jHj.setOnImageClickListener(this.eBC);
            this.jHj.setOnLongClickListener(this.mOnLongClickListener);
            this.jHj.setTbGestureDetector(this.efF);
            this.jHq.setOnClickListener(this.aIH);
            cDX();
            if (this.jHm != null && (this.jHm instanceof l)) {
                ((l) this.jHm).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<o> arrayList = new ArrayList<>(eVar.cCk());
            Iterator<o> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                o next = it.next();
                if ((next instanceof PostData) && ((PostData) next).ddu() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.hrM != null) {
                this.eVf = arrayList;
                this.hrM.setData(this.eVf);
            }
        }
    }

    private void cDX() {
        n nVar;
        n nVar2;
        if (this.jHu != null && !this.jHu.jEL && this.jHu.WR != 2) {
            ArrayList<PostData> cCk = this.jHu.cCk();
            ArrayList<n> cCz = this.jHu.cCz();
            if (cCz != null && !cCz.isEmpty() && cCk != null && !cCk.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = cCz.iterator();
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
                Iterator<n> it2 = cCz.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.hFf = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = cCz.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.ddi() != null) {
                        int aOy = next3.ddi().aOy();
                        if (aOy != 0) {
                            a(next3, aOy);
                            if (aOy != 28 && aOy != 31) {
                                if (next3.ddi().goods != null) {
                                    next3.ddi().goods.goods_style = -1001;
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
                    if (this.jHu.getForum() != null) {
                        nVar4.forumId = this.jHu.getForum().getId();
                    }
                    if (this.jHu.cCi() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.jHu.cCi().getId(), 0L);
                    }
                    if (this.jHu != null && this.jHu.getPage() != null) {
                        nVar4.pageNumber = this.jHu.getPage().aPr();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.jHu.jEK;
                    if (position + i3 >= cCk.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kcN) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (d(cCk, position)) {
                        a(nVar4, 1);
                    } else {
                        cCk.add(position, nVar4);
                        TiebaStatic.eventStat(this.kcM.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.ddi().apk_name);
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
        c.Cs(i);
        com.baidu.tieba.recapp.report.d.cVk().a(c);
        if (nVar != null && nVar.ddi() != null) {
            nVar.ddi().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.ddi() != null && nVar.ddi().goods != null && nVar.ddi().goods.goods_style != 1001 && nVar.ddi().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.jHu != null && nVar.ddi() != null) {
            nVar.ddi().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.jHu.getPage() != null) {
                nVar.ddi().advertAppContext.pn = this.jHu.getPage().aPr();
            }
            nVar.ddi().advertAppContext.page = nVar.ddl();
            if (this.jHu.getForum() != null && (forum = this.jHu.getForum()) != null) {
                nVar.ddi().advertAppContext.fid = forum.getId();
                nVar.ddi().advertAppContext.dzZ = forum.getFirst_class();
                nVar.ddi().advertAppContext.dAa = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.ddi().advertAppContext.dAb = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.ddi().advertAppContext.extensionInfo = nVar.ddi().ext_info;
            nVar.ddi().advertAppContext.WZ = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jHE = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBC = iVar;
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
        if (this.hrM.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            this.hrM.getAdapter().notifyDataSetChanged();
        }
    }

    public ArrayList<o> getDataList() {
        return this.eVf;
    }

    public void sB(boolean z) {
        this.kcN = z;
    }
}
