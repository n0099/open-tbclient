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
import com.baidu.tieba.pb.pb.a.j;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<q> ghy;
    private BdTypeRecyclerView iYW;
    private com.baidu.adp.widget.ListView.a jTX;
    private m lEk;
    private com.baidu.adp.widget.ListView.a lEn;
    private j lEr;
    private com.baidu.tieba.pb.data.f lEv;
    private ReplyFragment mbd;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private boolean mbe = true;
    private String bkt = null;
    private boolean lEw = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener lEF = null;
    private View.OnClickListener bbH = null;
    private TbRichTextView.i fNk = null;
    private com.baidu.tieba.pb.a.c fos = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mbd = replyFragment;
        this.iYW = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.lEk = new m(this.mbd.dpQ(), PostData.nlJ);
        this.lEk.a((TbRichTextView.c) this.mbd.dpQ());
        this.lEr = new j(this.mbd.dpQ(), PostData.nlN);
        this.jTX = r.dFg().a(this.mbd.dpQ().getBaseFragmentActivity(), AdvertAppInfo.eDR);
        this.lEn = r.dFg().a(this.mbd.dpQ().getBaseFragmentActivity(), AdvertAppInfo.eDV);
        this.bnf.add(this.jTX);
        this.bnf.add(this.lEn);
        this.bnf.add(this.lEk);
        this.bnf.add(this.lEr);
        this.iYW.addAdapters(this.bnf);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.lEv = fVar;
            if (fVar != null && fVar.dmU() != null && fVar.dmU().boP() != null) {
                this.bkt = fVar.dmU().boP().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lEv != null && this.lEv.dmW() != null && this.lEv.dmW().size() > 0) {
                this.postList.addAll(this.lEv.dmW());
            }
            this.lEk.setData(fVar);
            this.lEk.setFromCDN(this.mIsFromCDN);
            this.lEk.hY(this.bkt);
            this.lEk.uy(this.lEw);
            this.lEk.B(this.bbH);
            this.lEk.S(this.lEF);
            this.lEk.setOnImageClickListener(this.fNk);
            this.lEk.setOnLongClickListener(this.mOnLongClickListener);
            this.lEk.setTbGestureDetector(this.fos);
            this.lEr.setOnClickListener(this.bbH);
            doK();
            if (this.lEn != null && (this.lEn instanceof o)) {
                ((o) this.lEn).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<q> arrayList = new ArrayList<>(fVar.dmW());
            Iterator<q> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                q next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dPh() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.iYW != null) {
                this.ghy = arrayList;
                this.iYW.setData(this.ghy);
            }
        }
    }

    private void doK() {
        n nVar;
        n nVar2;
        if (this.lEv != null && !this.lEv.lBA && this.lEv.ZJ != 2) {
            ArrayList<PostData> dmW = this.lEv.dmW();
            ArrayList<n> dnl = this.lEv.dnl();
            if (dnl != null && !dnl.isEmpty() && dmW != null && !dmW.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = dnl.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(",");
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<n> it2 = dnl.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.jqp = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = dnl.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.dOV() != null) {
                        int bmD = next3.dOV().bmD();
                        if (bmD != 0) {
                            a(next3, bmD);
                            if (bmD != 28 && bmD != 31) {
                                if (next3.dOV().goods != null) {
                                    next3.dOV().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bmD);
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
                    if (this.lEv.getForum() != null) {
                        nVar4.forumId = this.lEv.getForum().getId();
                    }
                    if (this.lEv.dmU() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lEv.dmU().getId(), 0L);
                    }
                    if (this.lEv != null && this.lEv.getPage() != null) {
                        nVar4.pageNumber = this.lEv.getPage().bnD();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lEv.lBz;
                    if (position + i3 >= dmW.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.mbe) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dmW, position)) {
                        a(nVar4, 1);
                    } else {
                        dmW.add(position, nVar4);
                        TiebaStatic.eventStat(this.mbd.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dOV().apk_name);
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
        c.Js(i);
        com.baidu.tieba.recapp.report.d.dGg().a(c);
        if (nVar != null && nVar.dOV() != null) {
            nVar.dOV().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.dOV() != null && nVar.dOV().goods != null && nVar.dOV().goods.goods_style != 1001 && nVar.dOV().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.lEv != null && nVar.dOV() != null) {
            nVar.dOV().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lEv.getPage() != null) {
                nVar.dOV().advertAppContext.pn = this.lEv.getPage().bnD();
            }
            nVar.dOV().advertAppContext.page = nVar.dOY();
            if (this.lEv.getForum() != null && (forum = this.lEv.getForum()) != null) {
                nVar.dOV().advertAppContext.fid = forum.getId();
                nVar.dOV().advertAppContext.eDI = forum.getFirst_class();
                nVar.dOV().advertAppContext.eDJ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dOV().advertAppContext.eDK = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dOV().advertAppContext.extensionInfo = nVar.dOV().ext_info;
            nVar.dOV().advertAppContext.ZP = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lEF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fNk = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fos = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iYW.getAdapter() instanceof h) {
            this.iYW.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.ghy;
    }

    public void wb(boolean z) {
        this.mbe = z;
    }
}
