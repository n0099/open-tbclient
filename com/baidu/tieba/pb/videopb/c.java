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
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<q> fZE;
    private BdTypeRecyclerView iNq;
    private com.baidu.adp.widget.ListView.a jFt;
    private ReplyFragment lMH;
    private m lqk;
    private com.baidu.adp.widget.ListView.a lqn;
    private com.baidu.tieba.pb.pb.a.c lqr;
    private com.baidu.tieba.pb.data.f lqv;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private boolean lMI = true;
    private String bhP = null;
    private boolean lqw = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener lqF = null;
    private View.OnClickListener aZX = null;
    private TbRichTextView.i fFW = null;
    private com.baidu.tieba.pb.a.c fhK = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lMH = replyFragment;
        this.iNq = bdTypeRecyclerView;
        LY();
    }

    private void LY() {
        this.lqk = new m(this.lMH.dld(), PostData.mWR);
        this.lqk.a((TbRichTextView.c) this.lMH.dld());
        this.lqr = new com.baidu.tieba.pb.pb.a.c(this.lMH.dld(), PostData.mWV);
        this.jFt = r.dAo().a(this.lMH.dld().getBaseFragmentActivity(), AdvertAppInfo.eyC);
        this.lqn = r.dAo().a(this.lMH.dld().getBaseFragmentActivity(), AdvertAppInfo.eyG);
        this.bky.add(this.jFt);
        this.bky.add(this.lqn);
        this.bky.add(this.lqk);
        this.bky.add(this.lqr);
        this.iNq.addAdapters(this.bky);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.lqv = fVar;
            if (fVar != null && fVar.dik() != null && fVar.dik().bmA() != null) {
                this.bhP = fVar.dik().bmA().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lqv != null && this.lqv.dim() != null && this.lqv.dim().size() > 0) {
                this.postList.addAll(this.lqv.dim());
            }
            this.lqk.setData(fVar);
            this.lqk.setFromCDN(this.mIsFromCDN);
            this.lqk.hE(this.bhP);
            this.lqk.tT(this.lqw);
            this.lqk.B(this.aZX);
            this.lqk.T(this.lqF);
            this.lqk.setOnImageClickListener(this.fFW);
            this.lqk.setOnLongClickListener(this.mOnLongClickListener);
            this.lqk.setTbGestureDetector(this.fhK);
            this.lqr.setOnClickListener(this.aZX);
            djY();
            if (this.lqn != null && (this.lqn instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.lqn).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<q> arrayList = new ArrayList<>(fVar.dim());
            Iterator<q> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                q next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dJZ() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.iNq != null) {
                this.fZE = arrayList;
                this.iNq.setData(this.fZE);
            }
        }
    }

    private void djY() {
        n nVar;
        n nVar2;
        if (this.lqv != null && !this.lqv.lnJ && this.lqv.YH != 2) {
            ArrayList<PostData> dim = this.lqv.dim();
            ArrayList<n> diB = this.lqv.diB();
            if (diB != null && !diB.isEmpty() && dim != null && !dim.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = diB.iterator();
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
                Iterator<n> it2 = diB.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.jbX = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = diB.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.dJN() != null) {
                        int bkr = next3.dJN().bkr();
                        if (bkr != 0) {
                            a(next3, bkr);
                            if (bkr != 28 && bkr != 31) {
                                if (next3.dJN().goods != null) {
                                    next3.dJN().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bkr);
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
                    if (this.lqv.getForum() != null) {
                        nVar4.forumId = this.lqv.getForum().getId();
                    }
                    if (this.lqv.dik() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lqv.dik().getId(), 0L);
                    }
                    if (this.lqv != null && this.lqv.getPage() != null) {
                        nVar4.pageNumber = this.lqv.getPage().blo();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lqv.lnI;
                    if (position + i3 >= dim.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.lMI) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dim, position)) {
                        a(nVar4, 1);
                    } else {
                        dim.add(position, nVar4);
                        TiebaStatic.eventStat(this.lMH.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dJN().apk_name);
                    }
                }
            }
        }
    }

    private boolean e(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof n) {
                return true;
            }
        }
        return false;
    }

    private void a(n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = g.c(nVar, 5);
        c.Ia(i);
        com.baidu.tieba.recapp.report.d.dBp().a(c);
        if (nVar != null && nVar.dJN() != null) {
            nVar.dJN().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.dJN() != null && nVar.dJN().goods != null && nVar.dJN().goods.goods_style != 1001 && nVar.dJN().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.lqv != null && nVar.dJN() != null) {
            nVar.dJN().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.lqv.getPage() != null) {
                nVar.dJN().advertAppContext.pn = this.lqv.getPage().blo();
            }
            nVar.dJN().advertAppContext.page = nVar.dJQ();
            if (this.lqv.getForum() != null && (forum = this.lqv.getForum()) != null) {
                nVar.dJN().advertAppContext.fid = forum.getId();
                nVar.dJN().advertAppContext.eyt = forum.getFirst_class();
                nVar.dJN().advertAppContext.eyu = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dJN().advertAppContext.eyv = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dJN().advertAppContext.extensionInfo = nVar.dJN().ext_info;
            nVar.dJN().advertAppContext.YN = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void T(View.OnClickListener onClickListener) {
        this.lqF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFW = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fhK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.aZX = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iNq.getAdapter() instanceof h) {
            this.iNq.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fZE;
    }

    public void vv(boolean z) {
        this.lMI = z;
    }
}
