package com.baidu.tieba.pb.videopb;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.recapp.r;
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
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<q> fkE;
    private BdTypeRecyclerView hKL;
    private com.baidu.adp.widget.ListView.a iAt;
    private ReplyFragment kGD;
    private m kkD;
    private com.baidu.adp.widget.ListView.a kkG;
    private com.baidu.tieba.pb.pb.a.c kkK;
    private com.baidu.tieba.pb.data.f kkO;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private boolean kGE = true;
    private String aTI = null;
    private boolean kkP = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener kkY = null;
    private View.OnClickListener aMH = null;
    private TbRichTextView.i eRR = null;
    private com.baidu.tieba.pb.a.c euG = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kGD = replyFragment;
        this.hKL = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.kkD = new m(this.kGD.cNs(), PostData.lNd);
        this.kkD.a((TbRichTextView.c) this.kGD.cNs());
        this.kkK = new com.baidu.tieba.pb.pb.a.c(this.kGD.cNs(), PostData.lNh);
        this.iAt = r.dca().a(this.kGD.cNs().getBaseFragmentActivity(), AdvertAppInfo.dMK);
        this.kkG = r.dca().a(this.kGD.cNs().getBaseFragmentActivity(), AdvertAppInfo.dMO);
        this.aWf.add(this.iAt);
        this.aWf.add(this.kkG);
        this.aWf.add(this.kkD);
        this.aWf.add(this.kkK);
        this.hKL.addAdapters(this.aWf);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.kkO = fVar;
            if (fVar != null && fVar.cKx() != null && fVar.cKx().aWl() != null) {
                this.aTI = fVar.cKx().aWl().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kkO != null && this.kkO.cKz() != null && this.kkO.cKz().size() > 0) {
                this.postList.addAll(this.kkO.cKz());
            }
            this.kkD.setData(fVar);
            this.kkD.setFromCDN(this.mIsFromCDN);
            this.kkD.fq(this.aTI);
            this.kkD.rW(this.kkP);
            this.kkD.z(this.aMH);
            this.kkD.R(this.kkY);
            this.kkD.setOnImageClickListener(this.eRR);
            this.kkD.setOnLongClickListener(this.mOnLongClickListener);
            this.kkD.setTbGestureDetector(this.euG);
            this.kkK.setOnClickListener(this.aMH);
            cMo();
            if (this.kkG != null && (this.kkG instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.kkG).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<q> arrayList = new ArrayList<>(fVar.cKz());
            Iterator<q> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                q next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dli() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.hKL != null) {
                this.fkE = arrayList;
                this.hKL.setData(this.fkE);
            }
        }
    }

    private void cMo() {
        n nVar;
        n nVar2;
        if (this.kkO != null && !this.kkO.kif && this.kkO.Xq != 2) {
            ArrayList<PostData> cKz = this.kkO.cKz();
            ArrayList<n> cKO = this.kkO.cKO();
            if (cKO != null && !cKO.isEmpty() && cKz != null && !cKz.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = cKO.iterator();
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
                Iterator<n> it2 = cKO.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.hZg = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = cKO.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.dkW() != null) {
                        int aUe = next3.dkW().aUe();
                        if (aUe != 0) {
                            a(next3, aUe);
                            if (aUe != 28 && aUe != 31) {
                                if (next3.dkW().goods != null) {
                                    next3.dkW().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + aUe);
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
                    if (this.kkO.getForum() != null) {
                        nVar4.forumId = this.kkO.getForum().getId();
                    }
                    if (this.kkO.cKx() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kkO.cKx().getId(), 0L);
                    }
                    if (this.kkO != null && this.kkO.getPage() != null) {
                        nVar4.pageNumber = this.kkO.getPage().aUZ();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kkO.kie;
                    if (position + i3 >= cKz.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kGE) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (d(cKz, position)) {
                        a(nVar4, 1);
                    } else {
                        cKz.add(position, nVar4);
                        TiebaStatic.eventStat(this.kGD.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dkW().apk_name);
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
        c.DS(i);
        com.baidu.tieba.recapp.report.d.dcY().a(c);
        if (nVar != null && nVar.dkW() != null) {
            nVar.dkW().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.dkW() != null && nVar.dkW().goods != null && nVar.dkW().goods.goods_style != 1001 && nVar.dkW().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.kkO != null && nVar.dkW() != null) {
            nVar.dkW().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kkO.getPage() != null) {
                nVar.dkW().advertAppContext.pn = this.kkO.getPage().aUZ();
            }
            nVar.dkW().advertAppContext.page = nVar.dkZ();
            if (this.kkO.getForum() != null && (forum = this.kkO.getForum()) != null) {
                nVar.dkW().advertAppContext.fid = forum.getId();
                nVar.dkW().advertAppContext.dMB = forum.getFirst_class();
                nVar.dkW().advertAppContext.dMC = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dkW().advertAppContext.dMD = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dkW().advertAppContext.extensionInfo = nVar.dkW().ext_info;
            nVar.dkW().advertAppContext.Xw = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kkY = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eRR = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.euG = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.aMH = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.hKL.getAdapter() instanceof h) {
            this.hKL.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fkE;
    }

    public void tv(boolean z) {
        this.kGE = z;
    }
}
