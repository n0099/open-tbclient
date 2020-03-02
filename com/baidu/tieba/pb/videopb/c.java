package com.baidu.tieba.pb.videopb;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.g;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class c {
    private ArrayList<m> eim;
    private BdTypeRecyclerView gsQ;
    private com.baidu.adp.widget.ListView.a heo;
    private com.baidu.adp.widget.ListView.a iEB;
    private com.baidu.tieba.pb.pb.a.c iEF;
    private com.baidu.tieba.pb.data.e iEI;
    private j iEy;
    private ReplyFragment iZc;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private boolean iZd = true;
    private String aqV = null;
    private boolean iEJ = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener iES = null;
    private View.OnClickListener akt = null;
    private TbRichTextView.i dMx = null;
    private com.baidu.tieba.pb.a.c dqK = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iZc = replyFragment;
        this.gsQ = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.iEy = new j(this.iZc.cnh(), PostData.kgt);
        this.iEy.a((TbRichTextView.c) this.iZc.cnh());
        this.iEF = new com.baidu.tieba.pb.pb.a.c(this.iZc.cnh(), PostData.kgy);
        this.heo = r.cCv().a(this.iZc.cnh().getBaseFragmentActivity(), AdvertAppInfo.cMK);
        this.iEB = r.cCv().a(this.iZc.cnh().getBaseFragmentActivity(), AdvertAppInfo.cMO);
        this.asE.add(this.heo);
        this.asE.add(this.iEB);
        this.asE.add(this.iEy);
        this.asE.add(this.iEF);
        this.gsQ.addAdapters(this.asE);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        boolean z;
        if (eVar != null) {
            this.iEI = eVar;
            if (eVar != null && eVar.cku() != null && eVar.cku().aCo() != null) {
                this.aqV = eVar.cku().aCo().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.iEI != null && this.iEI.ckw() != null && this.iEI.ckw().size() > 0) {
                this.postList.addAll(this.iEI.ckw());
            }
            this.iEy.setData(eVar);
            this.iEy.setFromCDN(this.mIsFromCDN);
            this.iEy.dI(this.aqV);
            this.iEy.pw(this.iEJ);
            this.iEy.y(this.akt);
            this.iEy.P(this.iES);
            this.iEy.setOnImageClickListener(this.dMx);
            this.iEy.setOnLongClickListener(this.mOnLongClickListener);
            this.iEy.setTbGestureDetector(this.dqK);
            this.iEF.setOnClickListener(this.akt);
            cmc();
            if (this.iEB != null && (this.iEB instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.iEB).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<m> arrayList = new ArrayList<>(eVar.ckw());
            Iterator<m> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                m next = it.next();
                if ((next instanceof PostData) && ((PostData) next).cLa() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.gsQ != null) {
                this.eim = arrayList;
                this.gsQ.setData(this.eim);
            }
        }
    }

    private void cmc() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.iEI != null && !this.iEI.iCr && this.iEI.Df != 2) {
            ArrayList<PostData> ckw = this.iEI.ckw();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> ckI = this.iEI.ckI();
            if (ckI != null && !ckI.isEmpty() && ckw != null && !ckw.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it = ckI.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = ckI.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                    if (next2 != null) {
                        next2.gFI = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = ckI.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                    if (next3.cKO() != null) {
                        int aAp = next3.cKO().aAp();
                        if (aAp != 0) {
                            a(next3, aAp);
                            if (aAp != 28 && aAp != 31) {
                                if (next3.cKO().goods != null) {
                                    next3.cKO().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + aAp);
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); i++) {
                    com.baidu.tieba.tbadkCore.data.m mVar3 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(sparseArray.keyAt(i));
                    if (mVar3 != null && (mVar2 = (com.baidu.tieba.tbadkCore.data.m) hashMap.put(mVar3.getAdId(), mVar3)) != null) {
                        b(mVar2, 30);
                    }
                }
                sparseArray.clear();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry != null && (mVar = (com.baidu.tieba.tbadkCore.data.m) entry.getValue()) != null) {
                        sparseArray.put(mVar.getPosition(), mVar);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    com.baidu.tieba.tbadkCore.data.m mVar4 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                    if (this.iEI.getForum() != null) {
                        mVar4.forumId = this.iEI.getForum().getId();
                    }
                    if (this.iEI.cku() != null) {
                        mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.iEI.cku().getId(), 0L);
                    }
                    if (this.iEI != null && this.iEI.getPage() != null) {
                        mVar4.pageNumber = this.iEI.getPage().aBi();
                    }
                    c(mVar4);
                    int position = mVar4.getPosition() + this.iEI.iCq;
                    if (position + i3 >= ckw.size()) {
                        a(mVar4, 2);
                        return;
                    }
                    if (!this.iZd) {
                        position--;
                    }
                    if (position < 0) {
                        a(mVar4, 23);
                    } else if (b(ckw, position)) {
                        a(mVar4, 1);
                    } else {
                        ckw.add(position, mVar4);
                        TiebaStatic.eventStat(this.iZc.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cKO().apk_name);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof com.baidu.tieba.tbadkCore.data.m) {
                return true;
            }
        }
        return false;
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.Ba(i);
        com.baidu.tieba.recapp.report.c.cDp().a(c);
        if (mVar != null && mVar.cKO() != null) {
            mVar.cKO().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cKO() != null && mVar.cKO().goods != null && mVar.cKO().goods.goods_style != 1001 && mVar.cKO().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.iEI != null && mVar.cKO() != null) {
            mVar.cKO().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.iEI.getPage() != null) {
                mVar.cKO().advertAppContext.pn = this.iEI.getPage().aBi();
            }
            mVar.cKO().advertAppContext.page = mVar.cKR();
            if (this.iEI.getForum() != null && (forum = this.iEI.getForum()) != null) {
                mVar.cKO().advertAppContext.fid = forum.getId();
                mVar.cKO().advertAppContext.cMB = forum.getFirst_class();
                mVar.cKO().advertAppContext.cMC = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cKO().advertAppContext.cMD = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cKO().advertAppContext.extensionInfo = mVar.cKO().ext_info;
            mVar.cKO().advertAppContext.Dn = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iES = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMx = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.gsQ.getAdapter() instanceof g) {
            this.gsQ.getAdapter().notifyDataSetChanged();
        }
    }

    public ArrayList<m> getDataList() {
        return this.eim;
    }

    public void qT(boolean z) {
        this.iZd = z;
    }
}
