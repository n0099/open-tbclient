package com.baidu.tieba.pb.videopb;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<n> gpY;
    private BdTypeRecyclerView jmj;
    private com.baidu.adp.widget.ListView.a kkM;
    private k lNG;
    private com.baidu.adp.widget.ListView.a lNJ;
    private PbReplyLoadMoreAdapter lNP;
    private f lNT;
    private ReplyFragment mkM;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private boolean mkN = true;
    private String bkB = null;
    private boolean lNU = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener lOd = null;
    private View.OnClickListener bbI = null;
    private TbRichTextView.i fUw = null;
    private com.baidu.tieba.pb.a.c fvK = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mkM = replyFragment;
        this.jmj = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.lNG = new k(this.mkM.dnZ(), PostData.nwy);
        this.lNG.a((TbRichTextView.c) this.mkM.dnZ());
        this.lNP = new PbReplyLoadMoreAdapter(this.mkM.dnZ(), PostData.nwC);
        this.kkM = r.dDm().a(this.mkM.dnZ().getBaseFragmentActivity(), AdvertAppInfo.eLf);
        this.lNJ = r.dDm().a(this.mkM.dnZ().getBaseFragmentActivity(), AdvertAppInfo.eLj);
        this.bns.add(this.kkM);
        this.bns.add(this.lNJ);
        this.bns.add(this.lNG);
        this.bns.add(this.lNP);
        this.jmj.addAdapters(this.bns);
    }

    public void setData(f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.lNT = fVar;
            if (fVar != null && fVar.dkZ() != null && fVar.dkZ().bnQ() != null) {
                this.bkB = fVar.dkZ().bnQ().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lNT != null && this.lNT.dlb() != null && this.lNT.dlb().size() > 0) {
                this.postList.addAll(this.lNT.dlb());
            }
            this.lNG.setData(fVar);
            this.lNG.setFromCDN(this.mIsFromCDN);
            this.lNG.gW(this.bkB);
            this.lNG.uJ(this.lNU);
            this.lNG.C(this.bbI);
            this.lNG.U(this.lOd);
            this.lNG.setOnImageClickListener(this.fUw);
            this.lNG.setOnLongClickListener(this.mOnLongClickListener);
            this.lNG.setTbGestureDetector(this.fvK);
            this.lNP.setOnClickListener(this.bbI);
            dmR();
            if (this.lNJ != null && (this.lNJ instanceof o)) {
                ((o) this.lNJ).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<n> arrayList = new ArrayList<>(fVar.dlb());
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                n next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dNx() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.jmj != null) {
                this.gpY = arrayList;
                this.jmj.setData(this.gpY);
            }
        }
    }

    private void dmR() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lNT != null && !this.lNT.lKN && this.lNT.aam != 2) {
            ArrayList<PostData> dlb = this.lNT.dlb();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dlq = this.lNT.dlq();
            if (dlq != null && !dlq.isEmpty() && dlb != null && !dlb.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dlq.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(",");
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dlq.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jDK = sb.toString();
                        next2.position = next2.getPosition() - 1;
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dlq.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dNl() != null) {
                        int blD = next3.dNl().blD();
                        if (blD != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, blD);
                            if (blD != 28 && blD != 31) {
                                if (next3.dNl().goods != null) {
                                    next3.dNl().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + blD);
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); i++) {
                    com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(sparseArray.keyAt(i));
                    if (oVar3 != null && (oVar2 = (com.baidu.tieba.tbadkCore.data.o) hashMap.put(oVar3.getAdId(), oVar3)) != null) {
                        com.baidu.tieba.recapp.report.d.a(oVar2, 30);
                    }
                }
                sparseArray.clear();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry != null && (oVar = (com.baidu.tieba.tbadkCore.data.o) entry.getValue()) != null) {
                        sparseArray.put(oVar.getPosition(), oVar);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    com.baidu.tieba.tbadkCore.data.o oVar4 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                    if (this.lNT.getForum() != null) {
                        oVar4.forumId = this.lNT.getForum().getId();
                    }
                    if (this.lNT.dkZ() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lNT.dkZ().getId(), 0L);
                    }
                    if (this.lNT != null && this.lNT.getPage() != null) {
                        oVar4.pageNumber = this.lNT.getPage().bmD();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lNT.lKM;
                    if (position >= dlb.size()) {
                        oVar4.position = position;
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, com.baidu.tieba.lego.card.c.a.eL(arrayList));
                        return;
                    }
                    if (!this.mkN) {
                        position--;
                        oVar4.position = position;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(dlb, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        dlb.add(position, oVar4);
                        TiebaStatic.eventStat(this.mkM.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dNl().apk_name);
                    }
                }
            }
        }
    }

    private boolean g(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof com.baidu.tieba.tbadkCore.data.o) {
                return true;
            }
        }
        return false;
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lNT != null && oVar.dNl() != null) {
            oVar.dNl().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lNT.getPage() != null) {
                oVar.dNl().advertAppContext.pn = this.lNT.getPage().bmD();
            }
            oVar.dNl().advertAppContext.page = oVar.dNo();
            if (this.lNT.getForum() != null && (forum = this.lNT.getForum()) != null) {
                oVar.dNl().advertAppContext.fid = forum.getId();
                oVar.dNl().advertAppContext.eKW = forum.getFirst_class();
                oVar.dNl().advertAppContext.eKX = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dNl().advertAppContext.eKY = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dNl().advertAppContext.extensionInfo = oVar.dNl().ext_info;
            oVar.dNl().advertAppContext.aas = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOd = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fUw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fvK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.jmj.getAdapter() instanceof BdRecyclerAdapter) {
            this.jmj.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<n> getDataList() {
        return this.gpY;
    }

    public void wp(boolean z) {
        this.mkN = z;
    }
}
