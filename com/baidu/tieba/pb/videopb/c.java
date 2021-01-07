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
    private ArrayList<n> grW;
    private BdTypeRecyclerView jlj;
    private com.baidu.adp.widget.ListView.a khi;
    private PbReplyLoadMoreAdapter lJD;
    private f lJH;
    private k lJu;
    private com.baidu.adp.widget.ListView.a lJx;
    private ReplyFragment mgo;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private boolean mgp = true;
    private String blY = null;
    private boolean lJI = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener lJR = null;
    private View.OnClickListener bdp = null;
    private TbRichTextView.i fWO = null;
    private com.baidu.tieba.pb.a.c fyb = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mgo = replyFragment;
        this.jlj = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.lJu = new k(this.mgo.dpD(), PostData.nru);
        this.lJu.a((TbRichTextView.c) this.mgo.dpD());
        this.lJD = new PbReplyLoadMoreAdapter(this.mgo.dpD(), PostData.nry);
        this.khi = r.dEW().a(this.mgo.dpD().getBaseFragmentActivity(), AdvertAppInfo.eNE);
        this.lJx = r.dEW().a(this.mgo.dpD().getBaseFragmentActivity(), AdvertAppInfo.eNI);
        this.boM.add(this.khi);
        this.boM.add(this.lJx);
        this.boM.add(this.lJu);
        this.boM.add(this.lJD);
        this.jlj.addAdapters(this.boM);
    }

    public void setData(f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.lJH = fVar;
            if (fVar != null && fVar.dmF() != null && fVar.dmF().brr() != null) {
                this.blY = fVar.dmF().brr().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lJH != null && this.lJH.dmH() != null && this.lJH.dmH().size() > 0) {
                this.postList.addAll(this.lJH.dmH());
            }
            this.lJu.setData(fVar);
            this.lJu.setFromCDN(this.mIsFromCDN);
            this.lJu.hJ(this.blY);
            this.lJu.uz(this.lJI);
            this.lJu.C(this.bdp);
            this.lJu.U(this.lJR);
            this.lJu.setOnImageClickListener(this.fWO);
            this.lJu.setOnLongClickListener(this.mOnLongClickListener);
            this.lJu.setTbGestureDetector(this.fyb);
            this.lJD.setOnClickListener(this.bdp);
            dox();
            if (this.lJx != null && (this.lJx instanceof o)) {
                ((o) this.lJx).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<n> arrayList = new ArrayList<>(fVar.dmH());
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                n next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dPe() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.jlj != null) {
                this.grW = arrayList;
                this.jlj.setData(this.grW);
            }
        }
    }

    private void dox() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lJH != null && !this.lJH.lGF && this.lJH.aas != 2) {
            ArrayList<PostData> dmH = this.lJH.dmH();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dmW = this.lJH.dmW();
            if (dmW != null && !dmW.isEmpty() && dmH != null && !dmH.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dmW.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dmW.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jCL = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dmW.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dOS() != null) {
                        int bpf = next3.dOS().bpf();
                        if (bpf != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, bpf);
                            if (bpf != 28 && bpf != 31) {
                                if (next3.dOS().goods != null) {
                                    next3.dOS().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bpf);
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
                    if (this.lJH.getForum() != null) {
                        oVar4.forumId = this.lJH.getForum().getId();
                    }
                    if (this.lJH.dmF() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lJH.dmF().getId(), 0L);
                    }
                    if (this.lJH != null && this.lJH.getPage() != null) {
                        oVar4.pageNumber = this.lJH.getPage().bqe();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lJH.lGE;
                    if (position + i3 >= dmH.size()) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, com.baidu.tieba.lego.card.c.a.eN(arrayList));
                        return;
                    }
                    if (!this.mgp) {
                        position--;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(dmH, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        dmH.add(position, oVar4);
                        TiebaStatic.eventStat(this.mgo.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dOS().apk_name);
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
        if (oVar != null && this.lJH != null && oVar.dOS() != null) {
            oVar.dOS().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lJH.getPage() != null) {
                oVar.dOS().advertAppContext.pn = this.lJH.getPage().bqe();
            }
            oVar.dOS().advertAppContext.page = oVar.dOV();
            if (this.lJH.getForum() != null && (forum = this.lJH.getForum()) != null) {
                oVar.dOS().advertAppContext.fid = forum.getId();
                oVar.dOS().advertAppContext.eNv = forum.getFirst_class();
                oVar.dOS().advertAppContext.eNw = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dOS().advertAppContext.eNx = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dOS().advertAppContext.extensionInfo = oVar.dOS().ext_info;
            oVar.dOS().advertAppContext.aay = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lJR = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fWO = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fyb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.jlj.getAdapter() instanceof BdRecyclerAdapter) {
            this.jlj.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<n> getDataList() {
        return this.grW;
    }

    public void wc(boolean z) {
        this.mgp = z;
    }
}
