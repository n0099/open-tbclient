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
    private ArrayList<q> fwa;
    private BdTypeRecyclerView hYQ;
    private com.baidu.adp.widget.ListView.a iPl;
    private com.baidu.tieba.pb.pb.a.c kAc;
    private com.baidu.tieba.pb.data.f kAg;
    private ReplyFragment kWk;
    private m kzV;
    private com.baidu.adp.widget.ListView.a kzY;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private boolean kWl = true;
    private String aYW = null;
    private boolean kAh = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener kAq = null;
    private View.OnClickListener aRU = null;
    private TbRichTextView.i fcy = null;
    private com.baidu.tieba.pb.a.c eFf = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kWk = replyFragment;
        this.hYQ = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.kzV = new m(this.kWk.cYh(), PostData.meN);
        this.kzV.a((TbRichTextView.c) this.kWk.cYh());
        this.kAc = new com.baidu.tieba.pb.pb.a.c(this.kWk.cYh(), PostData.meR);
        this.iPl = r.dnh().a(this.kWk.cYh().getBaseFragmentActivity(), AdvertAppInfo.dVT);
        this.kzY = r.dnh().a(this.kWk.cYh().getBaseFragmentActivity(), AdvertAppInfo.dVX);
        this.bbu.add(this.iPl);
        this.bbu.add(this.kzY);
        this.bbu.add(this.kzV);
        this.bbu.add(this.kAc);
        this.hYQ.addAdapters(this.bbu);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.kAg = fVar;
            if (fVar != null && fVar.cVl() != null && fVar.cVl().beE() != null) {
                this.aYW = fVar.cVl().beE().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kAg != null && this.kAg.cVn() != null && this.kAg.cVn().size() > 0) {
                this.postList.addAll(this.kAg.cVn());
            }
            this.kzV.setData(fVar);
            this.kzV.setFromCDN(this.mIsFromCDN);
            this.kzV.gL(this.aYW);
            this.kzV.sD(this.kAh);
            this.kzV.A(this.aRU);
            this.kzV.S(this.kAq);
            this.kzV.setOnImageClickListener(this.fcy);
            this.kzV.setOnLongClickListener(this.mOnLongClickListener);
            this.kzV.setTbGestureDetector(this.eFf);
            this.kAc.setOnClickListener(this.aRU);
            cXc();
            if (this.kzY != null && (this.kzY instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.kzY).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<q> arrayList = new ArrayList<>(fVar.cVn());
            Iterator<q> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                q next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dwF() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.hYQ != null) {
                this.fwa = arrayList;
                this.hYQ.setData(this.fwa);
            }
        }
    }

    private void cXc() {
        n nVar;
        n nVar2;
        if (this.kAg != null && !this.kAg.kxx && this.kAg.XV != 2) {
            ArrayList<PostData> cVn = this.kAg.cVn();
            ArrayList<n> cVC = this.kAg.cVC();
            if (cVC != null && !cVC.isEmpty() && cVn != null && !cVn.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = cVC.iterator();
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
                Iterator<n> it2 = cVC.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.ino = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = cVC.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.dwt() != null) {
                        int bcv = next3.dwt().bcv();
                        if (bcv != 0) {
                            a(next3, bcv);
                            if (bcv != 28 && bcv != 31) {
                                if (next3.dwt().goods != null) {
                                    next3.dwt().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bcv);
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
                    if (this.kAg.getForum() != null) {
                        nVar4.forumId = this.kAg.getForum().getId();
                    }
                    if (this.kAg.cVl() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kAg.cVl().getId(), 0L);
                    }
                    if (this.kAg != null && this.kAg.getPage() != null) {
                        nVar4.pageNumber = this.kAg.getPage().bds();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kAg.kxw;
                    if (position + i3 >= cVn.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kWl) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (d(cVn, position)) {
                        a(nVar4, 1);
                    } else {
                        cVn.add(position, nVar4);
                        TiebaStatic.eventStat(this.kWk.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dwt().apk_name);
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
        c.Gn(i);
        com.baidu.tieba.recapp.report.d.doi().a(c);
        if (nVar != null && nVar.dwt() != null) {
            nVar.dwt().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.dwt() != null && nVar.dwt().goods != null && nVar.dwt().goods.goods_style != 1001 && nVar.dwt().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.kAg != null && nVar.dwt() != null) {
            nVar.dwt().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kAg.getPage() != null) {
                nVar.dwt().advertAppContext.pn = this.kAg.getPage().bds();
            }
            nVar.dwt().advertAppContext.page = nVar.dww();
            if (this.kAg.getForum() != null && (forum = this.kAg.getForum()) != null) {
                nVar.dwt().advertAppContext.fid = forum.getId();
                nVar.dwt().advertAppContext.dVK = forum.getFirst_class();
                nVar.dwt().advertAppContext.dVL = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dwt().advertAppContext.dVM = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dwt().advertAppContext.extensionInfo = nVar.dwt().ext_info;
            nVar.dwt().advertAppContext.Yb = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kAq = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcy = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eFf = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aRU = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.hYQ.getAdapter() instanceof h) {
            this.hYQ.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fwa;
    }

    public void ue(boolean z) {
        this.kWl = z;
    }
}
