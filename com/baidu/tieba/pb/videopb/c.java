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
    private ArrayList<q> fTO;
    private BdTypeRecyclerView iHt;
    private com.baidu.adp.widget.ListView.a jzw;
    private ReplyFragment lGL;
    private m lkj;
    private com.baidu.adp.widget.ListView.a lkm;
    private com.baidu.tieba.pb.pb.a.c lkq;
    private com.baidu.tieba.pb.data.f lku;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private boolean lGM = true;
    private String bgw = null;
    private boolean lkv = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener lkE = null;
    private View.OnClickListener aYF = null;
    private TbRichTextView.i fAg = null;
    private com.baidu.tieba.pb.a.c fbT = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lGL = replyFragment;
        this.iHt = bdTypeRecyclerView;
        Ly();
    }

    private void Ly() {
        this.lkj = new m(this.lGL.diB(), PostData.mQN);
        this.lkj.a((TbRichTextView.c) this.lGL.diB());
        this.lkq = new com.baidu.tieba.pb.pb.a.c(this.lGL.diB(), PostData.mQR);
        this.jzw = r.dxM().a(this.lGL.diB().getBaseFragmentActivity(), AdvertAppInfo.esI);
        this.lkm = r.dxM().a(this.lGL.diB().getBaseFragmentActivity(), AdvertAppInfo.esM);
        this.bje.add(this.jzw);
        this.bje.add(this.lkm);
        this.bje.add(this.lkj);
        this.bje.add(this.lkq);
        this.iHt.addAdapters(this.bje);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.lku = fVar;
            if (fVar != null && fVar.dfI() != null && fVar.dfI().bka() != null) {
                this.bgw = fVar.dfI().bka().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lku != null && this.lku.dfK() != null && this.lku.dfK().size() > 0) {
                this.postList.addAll(this.lku.dfK());
            }
            this.lkj.setData(fVar);
            this.lkj.setFromCDN(this.mIsFromCDN);
            this.lkj.hx(this.bgw);
            this.lkj.tK(this.lkv);
            this.lkj.A(this.aYF);
            this.lkj.S(this.lkE);
            this.lkj.setOnImageClickListener(this.fAg);
            this.lkj.setOnLongClickListener(this.mOnLongClickListener);
            this.lkj.setTbGestureDetector(this.fbT);
            this.lkq.setOnClickListener(this.aYF);
            dhw();
            if (this.lkm != null && (this.lkm instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.lkm).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<q> arrayList = new ArrayList<>(fVar.dfK());
            Iterator<q> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                q next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dHx() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.iHt != null) {
                this.fTO = arrayList;
                this.iHt.setData(this.fTO);
            }
        }
    }

    private void dhw() {
        n nVar;
        n nVar2;
        if (this.lku != null && !this.lku.lhM && this.lku.YH != 2) {
            ArrayList<PostData> dfK = this.lku.dfK();
            ArrayList<n> dfZ = this.lku.dfZ();
            if (dfZ != null && !dfZ.isEmpty() && dfK != null && !dfK.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = dfZ.iterator();
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
                Iterator<n> it2 = dfZ.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.iWa = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = dfZ.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.dHl() != null) {
                        int bhR = next3.dHl().bhR();
                        if (bhR != 0) {
                            a(next3, bhR);
                            if (bhR != 28 && bhR != 31) {
                                if (next3.dHl().goods != null) {
                                    next3.dHl().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bhR);
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
                    if (this.lku.getForum() != null) {
                        nVar4.forumId = this.lku.getForum().getId();
                    }
                    if (this.lku.dfI() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lku.dfI().getId(), 0L);
                    }
                    if (this.lku != null && this.lku.getPage() != null) {
                        nVar4.pageNumber = this.lku.getPage().biO();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lku.lhL;
                    if (position + i3 >= dfK.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.lGM) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dfK, position)) {
                        a(nVar4, 1);
                    } else {
                        dfK.add(position, nVar4);
                        TiebaStatic.eventStat(this.lGL.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dHl().apk_name);
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
        c.HN(i);
        com.baidu.tieba.recapp.report.d.dyN().a(c);
        if (nVar != null && nVar.dHl() != null) {
            nVar.dHl().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.dHl() != null && nVar.dHl().goods != null && nVar.dHl().goods.goods_style != 1001 && nVar.dHl().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.lku != null && nVar.dHl() != null) {
            nVar.dHl().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.lku.getPage() != null) {
                nVar.dHl().advertAppContext.pn = this.lku.getPage().biO();
            }
            nVar.dHl().advertAppContext.page = nVar.dHo();
            if (this.lku.getForum() != null && (forum = this.lku.getForum()) != null) {
                nVar.dHl().advertAppContext.fid = forum.getId();
                nVar.dHl().advertAppContext.esz = forum.getFirst_class();
                nVar.dHl().advertAppContext.esA = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dHl().advertAppContext.esB = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dHl().advertAppContext.extensionInfo = nVar.dHl().ext_info;
            nVar.dHl().advertAppContext.YN = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lkE = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fAg = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fbT = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aYF = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iHt.getAdapter() instanceof h) {
            this.iHt.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fTO;
    }

    public void vm(boolean z) {
        this.lGM = z;
    }
}
