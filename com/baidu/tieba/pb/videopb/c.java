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
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.recapp.l;
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
    private ArrayList<q> ffB;
    private BdTypeRecyclerView hEN;
    private com.baidu.adp.widget.ListView.a iun;
    private k kbZ;
    private com.baidu.adp.widget.ListView.a kcc;
    private com.baidu.tieba.pb.pb.a.c kcg;
    private com.baidu.tieba.pb.data.e kck;
    private ReplyFragment kxH;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private boolean kxI = true;
    private String aSp = null;
    private boolean kcl = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener kcu = null;
    private View.OnClickListener aLl = null;
    private TbRichTextView.i eLw = null;
    private com.baidu.tieba.pb.a.c eor = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kxH = replyFragment;
        this.hEN = bdTypeRecyclerView;
        Dz();
    }

    private void Dz() {
        this.kbZ = new k(this.kxH.cJI(), PostData.lFM);
        this.kbZ.a((TbRichTextView.c) this.kxH.cJI());
        this.kcg = new com.baidu.tieba.pb.pb.a.c(this.kxH.cJI(), PostData.lFQ);
        this.iun = com.baidu.tieba.recapp.q.cYT().a(this.kxH.cJI().getBaseFragmentActivity(), AdvertAppInfo.dGz);
        this.kcc = com.baidu.tieba.recapp.q.cYT().a(this.kxH.cJI().getBaseFragmentActivity(), AdvertAppInfo.dGD);
        this.aUP.add(this.iun);
        this.aUP.add(this.kcc);
        this.aUP.add(this.kbZ);
        this.aUP.add(this.kcg);
        this.hEN.addAdapters(this.aUP);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        boolean z;
        if (eVar != null) {
            this.kck = eVar;
            if (eVar != null && eVar.cGO() != null && eVar.cGO().aSp() != null) {
                this.aSp = eVar.cGO().aSp().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kck != null && this.kck.cGQ() != null && this.kck.cGQ().size() > 0) {
                this.postList.addAll(this.kck.cGQ());
            }
            this.kbZ.setData(eVar);
            this.kbZ.setFromCDN(this.mIsFromCDN);
            this.kbZ.fr(this.aSp);
            this.kbZ.rr(this.kcl);
            this.kbZ.z(this.aLl);
            this.kbZ.R(this.kcu);
            this.kbZ.setOnImageClickListener(this.eLw);
            this.kbZ.setOnLongClickListener(this.mOnLongClickListener);
            this.kbZ.setTbGestureDetector(this.eor);
            this.kcg.setOnClickListener(this.aLl);
            cIE();
            if (this.kcc != null && (this.kcc instanceof l)) {
                ((l) this.kcc).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<q> arrayList = new ArrayList<>(eVar.cGQ());
            Iterator<q> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                q next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dhZ() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.hEN != null) {
                this.ffB = arrayList;
                this.hEN.setData(this.ffB);
            }
        }
    }

    private void cIE() {
        n nVar;
        n nVar2;
        if (this.kck != null && !this.kck.jZB && this.kck.Xx != 2) {
            ArrayList<PostData> cGQ = this.kck.cGQ();
            ArrayList<n> cHf = this.kck.cHf();
            if (cHf != null && !cHf.isEmpty() && cGQ != null && !cGQ.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = cHf.iterator();
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
                Iterator<n> it2 = cHf.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.hTf = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = cHf.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.dhN() != null) {
                        int aQi = next3.dhN().aQi();
                        if (aQi != 0) {
                            a(next3, aQi);
                            if (aQi != 28 && aQi != 31) {
                                if (next3.dhN().goods != null) {
                                    next3.dhN().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + aQi);
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
                    if (this.kck.getForum() != null) {
                        nVar4.forumId = this.kck.getForum().getId();
                    }
                    if (this.kck.cGO() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kck.cGO().getId(), 0L);
                    }
                    if (this.kck != null && this.kck.getPage() != null) {
                        nVar4.pageNumber = this.kck.getPage().aRd();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kck.jZA;
                    if (position + i3 >= cGQ.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kxI) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (d(cGQ, position)) {
                        a(nVar4, 1);
                    } else {
                        cGQ.add(position, nVar4);
                        TiebaStatic.eventStat(this.kxH.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dhN().apk_name);
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
        c.Dw(i);
        com.baidu.tieba.recapp.report.d.cZR().a(c);
        if (nVar != null && nVar.dhN() != null) {
            nVar.dhN().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.dhN() != null && nVar.dhN().goods != null && nVar.dhN().goods.goods_style != 1001 && nVar.dhN().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.kck != null && nVar.dhN() != null) {
            nVar.dhN().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kck.getPage() != null) {
                nVar.dhN().advertAppContext.pn = this.kck.getPage().aRd();
            }
            nVar.dhN().advertAppContext.page = nVar.dhQ();
            if (this.kck.getForum() != null && (forum = this.kck.getForum()) != null) {
                nVar.dhN().advertAppContext.fid = forum.getId();
                nVar.dhN().advertAppContext.dGq = forum.getFirst_class();
                nVar.dhN().advertAppContext.dGr = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dhN().advertAppContext.dGs = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dhN().advertAppContext.extensionInfo = nVar.dhN().ext_info;
            nVar.dhN().advertAppContext.XE = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kcu = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eLw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eor = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.aLl = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.hEN.getAdapter() instanceof h) {
            this.hEN.getAdapter().notifyDataSetChanged();
        }
    }

    public ArrayList<q> getDataList() {
        return this.ffB;
    }

    public void sP(boolean z) {
        this.kxI = z;
    }
}
