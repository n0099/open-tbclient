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
    private ArrayList<q> fwe;
    private BdTypeRecyclerView hYW;
    private com.baidu.adp.widget.ListView.a iPr;
    private m kAc;
    private com.baidu.adp.widget.ListView.a kAf;
    private com.baidu.tieba.pb.pb.a.c kAj;
    private com.baidu.tieba.pb.data.f kAn;
    private ReplyFragment kWr;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private boolean kWs = true;
    private String aYY = null;
    private boolean kAo = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener kAx = null;
    private View.OnClickListener aRW = null;
    private TbRichTextView.i fcC = null;
    private com.baidu.tieba.pb.a.c eFj = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kWr = replyFragment;
        this.hYW = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.kAc = new m(this.kWr.cYi(), PostData.mfc);
        this.kAc.a((TbRichTextView.c) this.kWr.cYi());
        this.kAj = new com.baidu.tieba.pb.pb.a.c(this.kWr.cYi(), PostData.mfg);
        this.iPr = r.dnk().a(this.kWr.cYi().getBaseFragmentActivity(), AdvertAppInfo.dVX);
        this.kAf = r.dnk().a(this.kWr.cYi().getBaseFragmentActivity(), AdvertAppInfo.dWb);
        this.bbw.add(this.iPr);
        this.bbw.add(this.kAf);
        this.bbw.add(this.kAc);
        this.bbw.add(this.kAj);
        this.hYW.addAdapters(this.bbw);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.kAn = fVar;
            if (fVar != null && fVar.cVm() != null && fVar.cVm().beE() != null) {
                this.aYY = fVar.cVm().beE().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kAn != null && this.kAn.cVo() != null && this.kAn.cVo().size() > 0) {
                this.postList.addAll(this.kAn.cVo());
            }
            this.kAc.setData(fVar);
            this.kAc.setFromCDN(this.mIsFromCDN);
            this.kAc.gM(this.aYY);
            this.kAc.sF(this.kAo);
            this.kAc.A(this.aRW);
            this.kAc.S(this.kAx);
            this.kAc.setOnImageClickListener(this.fcC);
            this.kAc.setOnLongClickListener(this.mOnLongClickListener);
            this.kAc.setTbGestureDetector(this.eFj);
            this.kAj.setOnClickListener(this.aRW);
            cXd();
            if (this.kAf != null && (this.kAf instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.kAf).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<q> arrayList = new ArrayList<>(fVar.cVo());
            Iterator<q> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                q next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dwK() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.hYW != null) {
                this.fwe = arrayList;
                this.hYW.setData(this.fwe);
            }
        }
    }

    private void cXd() {
        n nVar;
        n nVar2;
        if (this.kAn != null && !this.kAn.kxE && this.kAn.XX != 2) {
            ArrayList<PostData> cVo = this.kAn.cVo();
            ArrayList<n> cVD = this.kAn.cVD();
            if (cVD != null && !cVD.isEmpty() && cVo != null && !cVo.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = cVD.iterator();
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
                Iterator<n> it2 = cVD.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.inv = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = cVD.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.dwy() != null) {
                        int bcv = next3.dwy().bcv();
                        if (bcv != 0) {
                            a(next3, bcv);
                            if (bcv != 28 && bcv != 31) {
                                if (next3.dwy().goods != null) {
                                    next3.dwy().goods.goods_style = -1001;
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
                    if (this.kAn.getForum() != null) {
                        nVar4.forumId = this.kAn.getForum().getId();
                    }
                    if (this.kAn.cVm() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kAn.cVm().getId(), 0L);
                    }
                    if (this.kAn != null && this.kAn.getPage() != null) {
                        nVar4.pageNumber = this.kAn.getPage().bds();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kAn.kxD;
                    if (position + i3 >= cVo.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kWs) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (d(cVo, position)) {
                        a(nVar4, 1);
                    } else {
                        cVo.add(position, nVar4);
                        TiebaStatic.eventStat(this.kWr.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dwy().apk_name);
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
        com.baidu.tieba.recapp.report.d.dol().a(c);
        if (nVar != null && nVar.dwy() != null) {
            nVar.dwy().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.dwy() != null && nVar.dwy().goods != null && nVar.dwy().goods.goods_style != 1001 && nVar.dwy().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.kAn != null && nVar.dwy() != null) {
            nVar.dwy().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kAn.getPage() != null) {
                nVar.dwy().advertAppContext.pn = this.kAn.getPage().bds();
            }
            nVar.dwy().advertAppContext.page = nVar.dwB();
            if (this.kAn.getForum() != null && (forum = this.kAn.getForum()) != null) {
                nVar.dwy().advertAppContext.fid = forum.getId();
                nVar.dwy().advertAppContext.dVO = forum.getFirst_class();
                nVar.dwy().advertAppContext.dVP = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dwy().advertAppContext.dVQ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dwy().advertAppContext.extensionInfo = nVar.dwy().ext_info;
            nVar.dwy().advertAppContext.Ye = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kAx = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcC = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eFj = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.hYW.getAdapter() instanceof h) {
            this.hYW.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fwe;
    }

    public void ug(boolean z) {
        this.kWs = z;
    }
}
