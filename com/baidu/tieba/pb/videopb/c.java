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
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<q> fZl;
    private BdTypeRecyclerView iOd;
    private com.baidu.adp.widget.ListView.a jGs;
    private ReplyFragment lMZ;
    private com.baidu.adp.widget.ListView.a lqC;
    private com.baidu.tieba.pb.pb.a.c lqG;
    private com.baidu.tieba.pb.data.f lqK;
    private m lqz;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private boolean lNa = true;
    private String bgd = null;
    private boolean lqL = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener lqU = null;
    private View.OnClickListener aYm = null;
    private TbRichTextView.i fFy = null;
    private com.baidu.tieba.pb.a.c fgS = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lMZ = replyFragment;
        this.iOd = bdTypeRecyclerView;
        Lp();
    }

    private void Lp() {
        this.lqz = new m(this.lMZ.dkA(), PostData.mXJ);
        this.lqz.a((TbRichTextView.c) this.lMZ.dkA());
        this.lqG = new com.baidu.tieba.pb.pb.a.c(this.lMZ.dkA(), PostData.mXN);
        this.jGs = com.baidu.tieba.recapp.q.dzO().a(this.lMZ.dkA().getBaseFragmentActivity(), AdvertAppInfo.ewQ);
        this.lqC = com.baidu.tieba.recapp.q.dzO().a(this.lMZ.dkA().getBaseFragmentActivity(), AdvertAppInfo.ewU);
        this.biN.add(this.jGs);
        this.biN.add(this.lqC);
        this.biN.add(this.lqz);
        this.biN.add(this.lqG);
        this.iOd.addAdapters(this.biN);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.lqK = fVar;
            if (fVar != null && fVar.dhH() != null && fVar.dhH().blC() != null) {
                this.bgd = fVar.dhH().blC().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lqK != null && this.lqK.dhJ() != null && this.lqK.dhJ().size() > 0) {
                this.postList.addAll(this.lqK.dhJ());
            }
            this.lqz.setData(fVar);
            this.lqz.setFromCDN(this.mIsFromCDN);
            this.lqz.hy(this.bgd);
            this.lqz.tW(this.lqL);
            this.lqz.B(this.aYm);
            this.lqz.S(this.lqU);
            this.lqz.setOnImageClickListener(this.fFy);
            this.lqz.setOnLongClickListener(this.mOnLongClickListener);
            this.lqz.setTbGestureDetector(this.fgS);
            this.lqG.setOnClickListener(this.aYm);
            dju();
            if (this.lqC != null && (this.lqC instanceof n)) {
                ((n) this.lqC).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<q> arrayList = new ArrayList<>(fVar.dhJ());
            Iterator<q> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                q next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dJQ() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.iOd != null) {
                this.fZl = arrayList;
                this.iOd.setData(this.fZl);
            }
        }
    }

    private void dju() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.lqK != null && !this.lqK.lnZ && this.lqK.YM != 2) {
            ArrayList<PostData> dhJ = this.lqK.dhJ();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> dhY = this.lqK.dhY();
            if (dhY != null && !dhY.isEmpty() && dhJ != null && !dhJ.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = dhY.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = dhY.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.jcK = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = dhY.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dJE() != null) {
                        int bjt = next3.dJE().bjt();
                        if (bjt != 0) {
                            a(next3, bjt);
                            if (bjt != 28 && bjt != 31) {
                                if (next3.dJE().goods != null) {
                                    next3.dJE().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bjt);
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); i++) {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(sparseArray.keyAt(i));
                    if (nVar3 != null && (nVar2 = (com.baidu.tieba.tbadkCore.data.n) hashMap.put(nVar3.getAdId(), nVar3)) != null) {
                        b(nVar2, 30);
                    }
                }
                sparseArray.clear();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry != null && (nVar = (com.baidu.tieba.tbadkCore.data.n) entry.getValue()) != null) {
                        sparseArray.put(nVar.getPosition(), nVar);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                    if (this.lqK.getForum() != null) {
                        nVar4.forumId = this.lqK.getForum().getId();
                    }
                    if (this.lqK.dhH() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lqK.dhH().getId(), 0L);
                    }
                    if (this.lqK != null && this.lqK.getPage() != null) {
                        nVar4.pageNumber = this.lqK.getPage().bkq();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lqK.lnY;
                    if (position + i3 >= dhJ.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.lNa) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dhJ, position)) {
                        a(nVar4, 1);
                    } else {
                        dhJ.add(position, nVar4);
                        TiebaStatic.eventStat(this.lMZ.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dJE().apk_name);
                    }
                }
            }
        }
    }

    private boolean e(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof com.baidu.tieba.tbadkCore.data.n) {
                return true;
            }
        }
        return false;
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = g.c(nVar, 5);
        c.IB(i);
        com.baidu.tieba.recapp.report.d.dAT().a(c);
        if (nVar != null && nVar.dJE() != null) {
            nVar.dJE().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dJE() != null && nVar.dJE().goods != null && nVar.dJE().goods.goods_style != 1001 && nVar.dJE().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lqK != null && nVar.dJE() != null) {
            nVar.dJE().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lqK.getPage() != null) {
                nVar.dJE().advertAppContext.pn = this.lqK.getPage().bkq();
            }
            nVar.dJE().advertAppContext.page = nVar.dJH();
            if (this.lqK.getForum() != null && (forum = this.lqK.getForum()) != null) {
                nVar.dJE().advertAppContext.fid = forum.getId();
                nVar.dJE().advertAppContext.ewH = forum.getFirst_class();
                nVar.dJE().advertAppContext.ewI = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dJE().advertAppContext.ewJ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dJE().advertAppContext.extensionInfo = nVar.dJE().ext_info;
            nVar.dJE().advertAppContext.YS = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lqU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFy = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fgS = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aYm = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iOd.getAdapter() instanceof h) {
            this.iOd.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fZl;
    }

    public void vy(boolean z) {
        this.lNa = z;
    }
}
