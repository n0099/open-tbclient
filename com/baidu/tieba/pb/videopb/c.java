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
    private ArrayList<q> ghw;
    private BdTypeRecyclerView iYU;
    private com.baidu.adp.widget.ListView.a jTV;
    private m lEi;
    private com.baidu.adp.widget.ListView.a lEl;
    private j lEp;
    private com.baidu.tieba.pb.data.f lEt;
    private ReplyFragment mbb;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private boolean mbc = true;
    private String bkt = null;
    private boolean lEu = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener lED = null;
    private View.OnClickListener bbH = null;
    private TbRichTextView.i fNk = null;
    private com.baidu.tieba.pb.a.c fos = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mbb = replyFragment;
        this.iYU = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.lEi = new m(this.mbb.dpP(), PostData.nlH);
        this.lEi.a((TbRichTextView.c) this.mbb.dpP());
        this.lEp = new j(this.mbb.dpP(), PostData.nlL);
        this.jTV = r.dFf().a(this.mbb.dpP().getBaseFragmentActivity(), AdvertAppInfo.eDR);
        this.lEl = r.dFf().a(this.mbb.dpP().getBaseFragmentActivity(), AdvertAppInfo.eDV);
        this.bnf.add(this.jTV);
        this.bnf.add(this.lEl);
        this.bnf.add(this.lEi);
        this.bnf.add(this.lEp);
        this.iYU.addAdapters(this.bnf);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.lEt = fVar;
            if (fVar != null && fVar.dmT() != null && fVar.dmT().boP() != null) {
                this.bkt = fVar.dmT().boP().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lEt != null && this.lEt.dmV() != null && this.lEt.dmV().size() > 0) {
                this.postList.addAll(this.lEt.dmV());
            }
            this.lEi.setData(fVar);
            this.lEi.setFromCDN(this.mIsFromCDN);
            this.lEi.hY(this.bkt);
            this.lEi.uy(this.lEu);
            this.lEi.B(this.bbH);
            this.lEi.S(this.lED);
            this.lEi.setOnImageClickListener(this.fNk);
            this.lEi.setOnLongClickListener(this.mOnLongClickListener);
            this.lEi.setTbGestureDetector(this.fos);
            this.lEp.setOnClickListener(this.bbH);
            doJ();
            if (this.lEl != null && (this.lEl instanceof o)) {
                ((o) this.lEl).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<q> arrayList = new ArrayList<>(fVar.dmV());
            Iterator<q> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                q next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dPg() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.iYU != null) {
                this.ghw = arrayList;
                this.iYU.setData(this.ghw);
            }
        }
    }

    private void doJ() {
        n nVar;
        n nVar2;
        if (this.lEt != null && !this.lEt.lBy && this.lEt.ZJ != 2) {
            ArrayList<PostData> dmV = this.lEt.dmV();
            ArrayList<n> dnk = this.lEt.dnk();
            if (dnk != null && !dnk.isEmpty() && dmV != null && !dmV.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = dnk.iterator();
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
                Iterator<n> it2 = dnk.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.jqn = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = dnk.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.dOU() != null) {
                        int bmD = next3.dOU().bmD();
                        if (bmD != 0) {
                            a(next3, bmD);
                            if (bmD != 28 && bmD != 31) {
                                if (next3.dOU().goods != null) {
                                    next3.dOU().goods.goods_style = -1001;
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
                    if (this.lEt.getForum() != null) {
                        nVar4.forumId = this.lEt.getForum().getId();
                    }
                    if (this.lEt.dmT() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lEt.dmT().getId(), 0L);
                    }
                    if (this.lEt != null && this.lEt.getPage() != null) {
                        nVar4.pageNumber = this.lEt.getPage().bnD();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lEt.lBx;
                    if (position + i3 >= dmV.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.mbc) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dmV, position)) {
                        a(nVar4, 1);
                    } else {
                        dmV.add(position, nVar4);
                        TiebaStatic.eventStat(this.mbb.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dOU().apk_name);
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
        com.baidu.tieba.recapp.report.d.dGf().a(c);
        if (nVar != null && nVar.dOU() != null) {
            nVar.dOU().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.dOU() != null && nVar.dOU().goods != null && nVar.dOU().goods.goods_style != 1001 && nVar.dOU().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.lEt != null && nVar.dOU() != null) {
            nVar.dOU().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lEt.getPage() != null) {
                nVar.dOU().advertAppContext.pn = this.lEt.getPage().bnD();
            }
            nVar.dOU().advertAppContext.page = nVar.dOX();
            if (this.lEt.getForum() != null && (forum = this.lEt.getForum()) != null) {
                nVar.dOU().advertAppContext.fid = forum.getId();
                nVar.dOU().advertAppContext.eDI = forum.getFirst_class();
                nVar.dOU().advertAppContext.eDJ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dOU().advertAppContext.eDK = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dOU().advertAppContext.extensionInfo = nVar.dOU().ext_info;
            nVar.dOU().advertAppContext.ZP = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lED = onClickListener;
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
        if (this.iYU.getAdapter() instanceof h) {
            this.iYU.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.ghw;
    }

    public void wb(boolean z) {
        this.mbc = z;
    }
}
