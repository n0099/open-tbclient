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
import com.baidu.tieba.recapp.p;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<n> gqm;
    private BdTypeRecyclerView jmy;
    private com.baidu.adp.widget.ListView.a kla;
    private k lNV;
    private com.baidu.adp.widget.ListView.a lNY;
    private PbReplyLoadMoreAdapter lOe;
    private f lOi;
    private ReplyFragment mlb;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private boolean mlc = true;
    private String bkB = null;
    private boolean lOj = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener lOs = null;
    private View.OnClickListener bbI = null;
    private TbRichTextView.i fUw = null;
    private com.baidu.tieba.pb.a.c fvK = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mlb = replyFragment;
        this.jmy = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.lNV = new k(this.mlb.dog(), PostData.nwY);
        this.lNV.a((TbRichTextView.c) this.mlb.dog());
        this.lOe = new PbReplyLoadMoreAdapter(this.mlb.dog(), PostData.nxc);
        this.kla = s.dDt().a(this.mlb.dog().getBaseFragmentActivity(), AdvertAppInfo.eLf);
        this.lNY = s.dDt().a(this.mlb.dog().getBaseFragmentActivity(), AdvertAppInfo.eLj);
        this.bns.add(this.kla);
        this.bns.add(this.lNY);
        this.bns.add(this.lNV);
        this.bns.add(this.lOe);
        this.jmy.addAdapters(this.bns);
    }

    public void setData(f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.lOi = fVar;
            if (fVar != null && fVar.dlg() != null && fVar.dlg().bnQ() != null) {
                this.bkB = fVar.dlg().bnQ().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lOi != null && this.lOi.dli() != null && this.lOi.dli().size() > 0) {
                this.postList.addAll(this.lOi.dli());
            }
            this.lNV.setData(fVar);
            this.lNV.setFromCDN(this.mIsFromCDN);
            this.lNV.gW(this.bkB);
            this.lNV.uJ(this.lOj);
            this.lNV.C(this.bbI);
            this.lNV.U(this.lOs);
            this.lNV.setOnImageClickListener(this.fUw);
            this.lNV.setOnLongClickListener(this.mOnLongClickListener);
            this.lNV.setTbGestureDetector(this.fvK);
            this.lOe.setOnClickListener(this.bbI);
            dmY();
            if (this.lNY != null && (this.lNY instanceof p)) {
                ((p) this.lNY).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<n> arrayList = new ArrayList<>(fVar.dli());
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                n next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dNF() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.jmy != null) {
                this.gqm = arrayList;
                this.jmy.setData(this.gqm);
            }
        }
    }

    private void dmY() {
        o oVar;
        o oVar2;
        if (this.lOi != null && !this.lOi.lLb && this.lOi.aam != 2) {
            ArrayList<PostData> dli = this.lOi.dli();
            ArrayList<o> dlx = this.lOi.dlx();
            if (dlx != null && !dlx.isEmpty() && dli != null && !dli.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<o> it = dlx.iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(",");
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<o> it2 = dlx.iterator();
                while (it2.hasNext()) {
                    o next2 = it2.next();
                    if (next2 != null) {
                        next2.jDY = sb.toString();
                        next2.position = next2.getPosition() - 1;
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<o> it3 = dlx.iterator();
                while (it3.hasNext()) {
                    o next3 = it3.next();
                    if (next3.dNt() != null) {
                        int blD = next3.dNt().blD();
                        if (blD != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, blD);
                            if (blD != 28 && blD != 31) {
                                if (next3.dNt().goods != null) {
                                    next3.dNt().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + blD);
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); i++) {
                    o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i));
                    if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.getAdId(), oVar3)) != null) {
                        com.baidu.tieba.recapp.report.d.a(oVar2, 30);
                    }
                }
                sparseArray.clear();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry != null && (oVar = (o) entry.getValue()) != null) {
                        sparseArray.put(oVar.getPosition(), oVar);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    o oVar4 = (o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                    if (this.lOi.getForum() != null) {
                        oVar4.forumId = this.lOi.getForum().getId();
                    }
                    if (this.lOi.dlg() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lOi.dlg().getId(), 0L);
                    }
                    if (this.lOi != null && this.lOi.getPage() != null) {
                        oVar4.pageNumber = this.lOi.getPage().bmD();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lOi.lLa;
                    if (position >= dli.size()) {
                        oVar4.position = position;
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, com.baidu.tieba.lego.card.c.a.eL(arrayList));
                        return;
                    }
                    if (!this.mlc) {
                        position--;
                        oVar4.position = position;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(dli, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        dli.add(position, oVar4);
                        TiebaStatic.eventStat(this.mlb.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dNt().apk_name);
                    }
                }
            }
        }
    }

    private boolean g(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof o) {
                return true;
            }
        }
        return false;
    }

    private void c(o oVar) {
        ForumData forum;
        if (oVar != null && this.lOi != null && oVar.dNt() != null) {
            oVar.dNt().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lOi.getPage() != null) {
                oVar.dNt().advertAppContext.pn = this.lOi.getPage().bmD();
            }
            oVar.dNt().advertAppContext.page = oVar.dNw();
            if (this.lOi.getForum() != null && (forum = this.lOi.getForum()) != null) {
                oVar.dNt().advertAppContext.fid = forum.getId();
                oVar.dNt().advertAppContext.eKW = forum.getFirst_class();
                oVar.dNt().advertAppContext.eKX = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dNt().advertAppContext.eKY = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dNt().advertAppContext.extensionInfo = oVar.dNt().ext_info;
            oVar.dNt().advertAppContext.aas = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOs = onClickListener;
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
        if (this.jmy.getAdapter() instanceof BdRecyclerAdapter) {
            this.jmy.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<n> getDataList() {
        return this.gqm;
    }

    public void wp(boolean z) {
        this.mlc = z;
    }
}
