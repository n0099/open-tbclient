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
    private ArrayList<m> eil;
    private BdTypeRecyclerView gsO;
    private com.baidu.adp.widget.ListView.a hem;
    private com.baidu.tieba.pb.pb.a.c iED;
    private com.baidu.tieba.pb.data.e iEG;
    private j iEw;
    private com.baidu.adp.widget.ListView.a iEz;
    private ReplyFragment iZa;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private boolean iZb = true;
    private String aqV = null;
    private boolean iEH = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener iEQ = null;
    private View.OnClickListener akt = null;
    private TbRichTextView.i dMw = null;
    private com.baidu.tieba.pb.a.c dqJ = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iZa = replyFragment;
        this.gsO = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.iEw = new j(this.iZa.cnf(), PostData.kgr);
        this.iEw.a((TbRichTextView.c) this.iZa.cnf());
        this.iED = new com.baidu.tieba.pb.pb.a.c(this.iZa.cnf(), PostData.kgw);
        this.hem = r.cCt().a(this.iZa.cnf().getBaseFragmentActivity(), AdvertAppInfo.cMJ);
        this.iEz = r.cCt().a(this.iZa.cnf().getBaseFragmentActivity(), AdvertAppInfo.cMN);
        this.asE.add(this.hem);
        this.asE.add(this.iEz);
        this.asE.add(this.iEw);
        this.asE.add(this.iED);
        this.gsO.addAdapters(this.asE);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        boolean z;
        if (eVar != null) {
            this.iEG = eVar;
            if (eVar != null && eVar.cks() != null && eVar.cks().aCm() != null) {
                this.aqV = eVar.cks().aCm().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.iEG != null && this.iEG.cku() != null && this.iEG.cku().size() > 0) {
                this.postList.addAll(this.iEG.cku());
            }
            this.iEw.setData(eVar);
            this.iEw.setFromCDN(this.mIsFromCDN);
            this.iEw.dI(this.aqV);
            this.iEw.pw(this.iEH);
            this.iEw.y(this.akt);
            this.iEw.P(this.iEQ);
            this.iEw.setOnImageClickListener(this.dMw);
            this.iEw.setOnLongClickListener(this.mOnLongClickListener);
            this.iEw.setTbGestureDetector(this.dqJ);
            this.iED.setOnClickListener(this.akt);
            cma();
            if (this.iEz != null && (this.iEz instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.iEz).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<m> arrayList = new ArrayList<>(eVar.cku());
            Iterator<m> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                m next = it.next();
                if ((next instanceof PostData) && ((PostData) next).cKY() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.gsO != null) {
                this.eil = arrayList;
                this.gsO.setData(this.eil);
            }
        }
    }

    private void cma() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.iEG != null && !this.iEG.iCp && this.iEG.Df != 2) {
            ArrayList<PostData> cku = this.iEG.cku();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> ckG = this.iEG.ckG();
            if (ckG != null && !ckG.isEmpty() && cku != null && !cku.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it = ckG.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = ckG.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                    if (next2 != null) {
                        next2.gFG = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = ckG.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                    if (next3.cKM() != null) {
                        int aAn = next3.cKM().aAn();
                        if (aAn != 0) {
                            a(next3, aAn);
                            if (aAn != 28 && aAn != 31) {
                                if (next3.cKM().goods != null) {
                                    next3.cKM().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + aAn);
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
                    if (this.iEG.getForum() != null) {
                        mVar4.forumId = this.iEG.getForum().getId();
                    }
                    if (this.iEG.cks() != null) {
                        mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.iEG.cks().getId(), 0L);
                    }
                    if (this.iEG != null && this.iEG.getPage() != null) {
                        mVar4.pageNumber = this.iEG.getPage().aBg();
                    }
                    c(mVar4);
                    int position = mVar4.getPosition() + this.iEG.iCo;
                    if (position + i3 >= cku.size()) {
                        a(mVar4, 2);
                        return;
                    }
                    if (!this.iZb) {
                        position--;
                    }
                    if (position < 0) {
                        a(mVar4, 23);
                    } else if (b(cku, position)) {
                        a(mVar4, 1);
                    } else {
                        cku.add(position, mVar4);
                        TiebaStatic.eventStat(this.iZa.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cKM().apk_name);
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
        com.baidu.tieba.recapp.report.c.cDn().a(c);
        if (mVar != null && mVar.cKM() != null) {
            mVar.cKM().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cKM() != null && mVar.cKM().goods != null && mVar.cKM().goods.goods_style != 1001 && mVar.cKM().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.iEG != null && mVar.cKM() != null) {
            mVar.cKM().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.iEG.getPage() != null) {
                mVar.cKM().advertAppContext.pn = this.iEG.getPage().aBg();
            }
            mVar.cKM().advertAppContext.page = mVar.cKP();
            if (this.iEG.getForum() != null && (forum = this.iEG.getForum()) != null) {
                mVar.cKM().advertAppContext.fid = forum.getId();
                mVar.cKM().advertAppContext.cMA = forum.getFirst_class();
                mVar.cKM().advertAppContext.cMB = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cKM().advertAppContext.cMC = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cKM().advertAppContext.extensionInfo = mVar.cKM().ext_info;
            mVar.cKM().advertAppContext.Dn = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iEQ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqJ = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.gsO.getAdapter() instanceof g) {
            this.gsO.getAdapter().notifyDataSetChanged();
        }
    }

    public ArrayList<m> getDataList() {
        return this.eil;
    }

    public void qT(boolean z) {
        this.iZb = z;
    }
}
