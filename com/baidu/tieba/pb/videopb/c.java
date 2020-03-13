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
    private ArrayList<m> eiz;
    private BdTypeRecyclerView gtd;
    private com.baidu.adp.widget.ListView.a heA;
    private j iEK;
    private com.baidu.adp.widget.ListView.a iEN;
    private com.baidu.tieba.pb.pb.a.c iER;
    private com.baidu.tieba.pb.data.e iEU;
    private ReplyFragment iZo;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private boolean iZp = true;
    private String aqW = null;
    private boolean iEV = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener iFe = null;
    private View.OnClickListener aku = null;
    private TbRichTextView.i dMK = null;
    private com.baidu.tieba.pb.a.c dqX = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iZo = replyFragment;
        this.gtd = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.iEK = new j(this.iZo.cni(), PostData.kgF);
        this.iEK.a((TbRichTextView.c) this.iZo.cni());
        this.iER = new com.baidu.tieba.pb.pb.a.c(this.iZo.cni(), PostData.kgK);
        this.heA = r.cCw().a(this.iZo.cni().getBaseFragmentActivity(), AdvertAppInfo.cML);
        this.iEN = r.cCw().a(this.iZo.cni().getBaseFragmentActivity(), AdvertAppInfo.cMP);
        this.asF.add(this.heA);
        this.asF.add(this.iEN);
        this.asF.add(this.iEK);
        this.asF.add(this.iER);
        this.gtd.addAdapters(this.asF);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        boolean z;
        if (eVar != null) {
            this.iEU = eVar;
            if (eVar != null && eVar.ckv() != null && eVar.ckv().aCo() != null) {
                this.aqW = eVar.ckv().aCo().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.iEU != null && this.iEU.ckx() != null && this.iEU.ckx().size() > 0) {
                this.postList.addAll(this.iEU.ckx());
            }
            this.iEK.setData(eVar);
            this.iEK.setFromCDN(this.mIsFromCDN);
            this.iEK.dI(this.aqW);
            this.iEK.pw(this.iEV);
            this.iEK.y(this.aku);
            this.iEK.P(this.iFe);
            this.iEK.setOnImageClickListener(this.dMK);
            this.iEK.setOnLongClickListener(this.mOnLongClickListener);
            this.iEK.setTbGestureDetector(this.dqX);
            this.iER.setOnClickListener(this.aku);
            cmd();
            if (this.iEN != null && (this.iEN instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.iEN).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<m> arrayList = new ArrayList<>(eVar.ckx());
            Iterator<m> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                m next = it.next();
                if ((next instanceof PostData) && ((PostData) next).cLb() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.gtd != null) {
                this.eiz = arrayList;
                this.gtd.setData(this.eiz);
            }
        }
    }

    private void cmd() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.iEU != null && !this.iEU.iCD && this.iEU.Df != 2) {
            ArrayList<PostData> ckx = this.iEU.ckx();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> ckJ = this.iEU.ckJ();
            if (ckJ != null && !ckJ.isEmpty() && ckx != null && !ckx.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it = ckJ.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = ckJ.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                    if (next2 != null) {
                        next2.gFU = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = ckJ.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                    if (next3.cKP() != null) {
                        int aAp = next3.cKP().aAp();
                        if (aAp != 0) {
                            a(next3, aAp);
                            if (aAp != 28 && aAp != 31) {
                                if (next3.cKP().goods != null) {
                                    next3.cKP().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
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
                    if (this.iEU.getForum() != null) {
                        mVar4.forumId = this.iEU.getForum().getId();
                    }
                    if (this.iEU.ckv() != null) {
                        mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.iEU.ckv().getId(), 0L);
                    }
                    if (this.iEU != null && this.iEU.getPage() != null) {
                        mVar4.pageNumber = this.iEU.getPage().aBi();
                    }
                    c(mVar4);
                    int position = mVar4.getPosition() + this.iEU.iCC;
                    if (position + i3 >= ckx.size()) {
                        a(mVar4, 2);
                        return;
                    }
                    if (!this.iZp) {
                        position--;
                    }
                    if (position < 0) {
                        a(mVar4, 23);
                    } else if (b(ckx, position)) {
                        a(mVar4, 1);
                    } else {
                        ckx.add(position, mVar4);
                        TiebaStatic.eventStat(this.iZo.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cKP().apk_name);
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
        com.baidu.tieba.recapp.report.c.cDq().a(c);
        if (mVar != null && mVar.cKP() != null) {
            mVar.cKP().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cKP() != null && mVar.cKP().goods != null && mVar.cKP().goods.goods_style != 1001 && mVar.cKP().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.iEU != null && mVar.cKP() != null) {
            mVar.cKP().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.iEU.getPage() != null) {
                mVar.cKP().advertAppContext.pn = this.iEU.getPage().aBi();
            }
            mVar.cKP().advertAppContext.page = mVar.cKS();
            if (this.iEU.getForum() != null && (forum = this.iEU.getForum()) != null) {
                mVar.cKP().advertAppContext.fid = forum.getId();
                mVar.cKP().advertAppContext.cMC = forum.getFirst_class();
                mVar.cKP().advertAppContext.cMD = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cKP().advertAppContext.cME = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cKP().advertAppContext.extensionInfo = mVar.cKP().ext_info;
            mVar.cKP().advertAppContext.Dn = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iFe = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMK = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqX = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.aku = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.gtd.getAdapter() instanceof g) {
            this.gtd.getAdapter().notifyDataSetChanged();
        }
    }

    public ArrayList<m> getDataList() {
        return this.eiz;
    }

    public void qT(boolean z) {
        this.iZp = z;
    }
}
