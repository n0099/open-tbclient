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
    private ArrayList<q> fLx;
    private BdTypeRecyclerView iuX;
    private com.baidu.adp.widget.ListView.a jmW;
    private m kXK;
    private com.baidu.adp.widget.ListView.a kXN;
    private com.baidu.tieba.pb.pb.a.c kXR;
    private com.baidu.tieba.pb.data.f kXV;
    private ReplyFragment lun;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private boolean luo = true;
    private String bfg = null;
    private boolean kXW = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener kYf = null;
    private View.OnClickListener aXk = null;
    private TbRichTextView.i frJ = null;
    private com.baidu.tieba.pb.a.c eTx = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lun = replyFragment;
        this.iuX = bdTypeRecyclerView;
        Le();
    }

    private void Le() {
        this.kXK = new m(this.lun.dfu(), PostData.mEh);
        this.kXK.a((TbRichTextView.c) this.lun.dfu());
        this.kXR = new com.baidu.tieba.pb.pb.a.c(this.lun.dfu(), PostData.mEl);
        this.jmW = r.duF().a(this.lun.dfu().getBaseFragmentActivity(), AdvertAppInfo.ekj);
        this.kXN = r.duF().a(this.lun.dfu().getBaseFragmentActivity(), AdvertAppInfo.ekn);
        this.bhH.add(this.jmW);
        this.bhH.add(this.kXN);
        this.bhH.add(this.kXK);
        this.bhH.add(this.kXR);
        this.iuX.addAdapters(this.bhH);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.kXV = fVar;
            if (fVar != null && fVar.dcA() != null && fVar.dcA().bih() != null) {
                this.bfg = fVar.dcA().bih().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kXV != null && this.kXV.dcC() != null && this.kXV.dcC().size() > 0) {
                this.postList.addAll(this.kXV.dcC());
            }
            this.kXK.setData(fVar);
            this.kXK.setFromCDN(this.mIsFromCDN);
            this.kXK.hp(this.bfg);
            this.kXK.tt(this.kXW);
            this.kXK.A(this.aXk);
            this.kXK.S(this.kYf);
            this.kXK.setOnImageClickListener(this.frJ);
            this.kXK.setOnLongClickListener(this.mOnLongClickListener);
            this.kXK.setTbGestureDetector(this.eTx);
            this.kXR.setOnClickListener(this.aXk);
            dep();
            if (this.kXN != null && (this.kXN instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.kXN).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<q> arrayList = new ArrayList<>(fVar.dcC());
            Iterator<q> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                q next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dEp() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.iuX != null) {
                this.fLx = arrayList;
                this.iuX.setData(this.fLx);
            }
        }
    }

    private void dep() {
        n nVar;
        n nVar2;
        if (this.kXV != null && !this.kXV.kVn && this.kXV.YG != 2) {
            ArrayList<PostData> dcC = this.kXV.dcC();
            ArrayList<n> dcR = this.kXV.dcR();
            if (dcR != null && !dcR.isEmpty() && dcC != null && !dcC.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = dcR.iterator();
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
                Iterator<n> it2 = dcR.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.iJE = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = dcR.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.dEd() != null) {
                        int bfY = next3.dEd().bfY();
                        if (bfY != 0) {
                            a(next3, bfY);
                            if (bfY != 28 && bfY != 31) {
                                if (next3.dEd().goods != null) {
                                    next3.dEd().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bfY);
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
                    if (this.kXV.getForum() != null) {
                        nVar4.forumId = this.kXV.getForum().getId();
                    }
                    if (this.kXV.dcA() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kXV.dcA().getId(), 0L);
                    }
                    if (this.kXV != null && this.kXV.getPage() != null) {
                        nVar4.pageNumber = this.kXV.getPage().bgV();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kXV.kVm;
                    if (position + i3 >= dcC.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.luo) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dcC, position)) {
                        a(nVar4, 1);
                    } else {
                        dcC.add(position, nVar4);
                        TiebaStatic.eventStat(this.lun.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dEd().apk_name);
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
        c.Hu(i);
        com.baidu.tieba.recapp.report.d.dvG().a(c);
        if (nVar != null && nVar.dEd() != null) {
            nVar.dEd().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.dEd() != null && nVar.dEd().goods != null && nVar.dEd().goods.goods_style != 1001 && nVar.dEd().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.kXV != null && nVar.dEd() != null) {
            nVar.dEd().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kXV.getPage() != null) {
                nVar.dEd().advertAppContext.pn = this.kXV.getPage().bgV();
            }
            nVar.dEd().advertAppContext.page = nVar.dEg();
            if (this.kXV.getForum() != null && (forum = this.kXV.getForum()) != null) {
                nVar.dEd().advertAppContext.fid = forum.getId();
                nVar.dEd().advertAppContext.eka = forum.getFirst_class();
                nVar.dEd().advertAppContext.ekb = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dEd().advertAppContext.ekc = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dEd().advertAppContext.extensionInfo = nVar.dEd().ext_info;
            nVar.dEd().advertAppContext.YM = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kYf = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.frJ = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eTx = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aXk = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iuX.getAdapter() instanceof h) {
            this.iuX.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fLx;
    }

    public void uV(boolean z) {
        this.luo = z;
    }
}
