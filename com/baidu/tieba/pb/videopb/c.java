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
    private PbReplyLoadMoreAdapter lJE;
    private f lJI;
    private k lJv;
    private com.baidu.adp.widget.ListView.a lJy;
    private ReplyFragment mgp;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private boolean mgq = true;
    private String blY = null;
    private boolean lJJ = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener lJS = null;
    private View.OnClickListener bdp = null;
    private TbRichTextView.i fWO = null;
    private com.baidu.tieba.pb.a.c fyb = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mgp = replyFragment;
        this.jlj = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.lJv = new k(this.mgp.dpC(), PostData.nrv);
        this.lJv.a((TbRichTextView.c) this.mgp.dpC());
        this.lJE = new PbReplyLoadMoreAdapter(this.mgp.dpC(), PostData.nrz);
        this.khi = r.dEV().a(this.mgp.dpC().getBaseFragmentActivity(), AdvertAppInfo.eNE);
        this.lJy = r.dEV().a(this.mgp.dpC().getBaseFragmentActivity(), AdvertAppInfo.eNI);
        this.boM.add(this.khi);
        this.boM.add(this.lJy);
        this.boM.add(this.lJv);
        this.boM.add(this.lJE);
        this.jlj.addAdapters(this.boM);
    }

    public void setData(f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.lJI = fVar;
            if (fVar != null && fVar.dmE() != null && fVar.dmE().brq() != null) {
                this.blY = fVar.dmE().brq().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lJI != null && this.lJI.dmG() != null && this.lJI.dmG().size() > 0) {
                this.postList.addAll(this.lJI.dmG());
            }
            this.lJv.setData(fVar);
            this.lJv.setFromCDN(this.mIsFromCDN);
            this.lJv.hJ(this.blY);
            this.lJv.uz(this.lJJ);
            this.lJv.C(this.bdp);
            this.lJv.U(this.lJS);
            this.lJv.setOnImageClickListener(this.fWO);
            this.lJv.setOnLongClickListener(this.mOnLongClickListener);
            this.lJv.setTbGestureDetector(this.fyb);
            this.lJE.setOnClickListener(this.bdp);
            dow();
            if (this.lJy != null && (this.lJy instanceof o)) {
                ((o) this.lJy).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<n> arrayList = new ArrayList<>(fVar.dmG());
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                n next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dPd() == 1) {
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

    private void dow() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lJI != null && !this.lJI.lGG && this.lJI.aas != 2) {
            ArrayList<PostData> dmG = this.lJI.dmG();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dmV = this.lJI.dmV();
            if (dmV != null && !dmV.isEmpty() && dmG != null && !dmG.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dmV.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dmV.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jCL = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dmV.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dOR() != null) {
                        int bpe = next3.dOR().bpe();
                        if (bpe != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, bpe);
                            if (bpe != 28 && bpe != 31) {
                                if (next3.dOR().goods != null) {
                                    next3.dOR().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bpe);
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
                    if (this.lJI.getForum() != null) {
                        oVar4.forumId = this.lJI.getForum().getId();
                    }
                    if (this.lJI.dmE() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lJI.dmE().getId(), 0L);
                    }
                    if (this.lJI != null && this.lJI.getPage() != null) {
                        oVar4.pageNumber = this.lJI.getPage().bqd();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lJI.lGF;
                    if (position + i3 >= dmG.size()) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, com.baidu.tieba.lego.card.c.a.eN(arrayList));
                        return;
                    }
                    if (!this.mgq) {
                        position--;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(dmG, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        dmG.add(position, oVar4);
                        TiebaStatic.eventStat(this.mgp.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dOR().apk_name);
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
        if (oVar != null && this.lJI != null && oVar.dOR() != null) {
            oVar.dOR().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lJI.getPage() != null) {
                oVar.dOR().advertAppContext.pn = this.lJI.getPage().bqd();
            }
            oVar.dOR().advertAppContext.page = oVar.dOU();
            if (this.lJI.getForum() != null && (forum = this.lJI.getForum()) != null) {
                oVar.dOR().advertAppContext.fid = forum.getId();
                oVar.dOR().advertAppContext.eNv = forum.getFirst_class();
                oVar.dOR().advertAppContext.eNw = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dOR().advertAppContext.eNx = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dOR().advertAppContext.extensionInfo = oVar.dOR().ext_info;
            oVar.dOR().advertAppContext.aay = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lJS = onClickListener;
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
        this.mgq = z;
    }
}
