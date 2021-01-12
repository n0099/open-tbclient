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
    private ArrayList<n> gnp;
    private BdTypeRecyclerView jgC;
    private com.baidu.adp.widget.ListView.a kcC;
    private k lEQ;
    private com.baidu.adp.widget.ListView.a lET;
    private PbReplyLoadMoreAdapter lEZ;
    private f lFd;
    private ReplyFragment mbJ;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private boolean mbK = true;
    private String bhj = null;
    private boolean lFe = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener lFn = null;
    private View.OnClickListener aYB = null;
    private TbRichTextView.i fSh = null;
    private com.baidu.tieba.pb.a.c ftt = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mbJ = replyFragment;
        this.jgC = bdTypeRecyclerView;
        IY();
    }

    private void IY() {
        this.lEQ = new k(this.mbJ.dlK(), PostData.nmN);
        this.lEQ.a((TbRichTextView.c) this.mbJ.dlK());
        this.lEZ = new PbReplyLoadMoreAdapter(this.mbJ.dlK(), PostData.nmR);
        this.kcC = r.dBe().a(this.mbJ.dlK().getBaseFragmentActivity(), AdvertAppInfo.eIT);
        this.lET = r.dBe().a(this.mbJ.dlK().getBaseFragmentActivity(), AdvertAppInfo.eIX);
        this.bjZ.add(this.kcC);
        this.bjZ.add(this.lET);
        this.bjZ.add(this.lEQ);
        this.bjZ.add(this.lEZ);
        this.jgC.addAdapters(this.bjZ);
    }

    public void setData(f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.lFd = fVar;
            if (fVar != null && fVar.diN() != null && fVar.diN().bnx() != null) {
                this.bhj = fVar.diN().bnx().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lFd != null && this.lFd.diP() != null && this.lFd.diP().size() > 0) {
                this.postList.addAll(this.lFd.diP());
            }
            this.lEQ.setData(fVar);
            this.lEQ.setFromCDN(this.mIsFromCDN);
            this.lEQ.gy(this.bhj);
            this.lEQ.uv(this.lFe);
            this.lEQ.C(this.aYB);
            this.lEQ.U(this.lFn);
            this.lEQ.setOnImageClickListener(this.fSh);
            this.lEQ.setOnLongClickListener(this.mOnLongClickListener);
            this.lEQ.setTbGestureDetector(this.ftt);
            this.lEZ.setOnClickListener(this.aYB);
            dkE();
            if (this.lET != null && (this.lET instanceof o)) {
                ((o) this.lET).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<n> arrayList = new ArrayList<>(fVar.diP());
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                n next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dLm() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.jgC != null) {
                this.gnp = arrayList;
                this.jgC.setData(this.gnp);
            }
        }
    }

    private void dkE() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lFd != null && !this.lFd.lCa && this.lFd.aaq != 2) {
            ArrayList<PostData> diP = this.lFd.diP();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dje = this.lFd.dje();
            if (dje != null && !dje.isEmpty() && diP != null && !diP.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dje.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dje.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jyf = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dje.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dLa() != null) {
                        int bll = next3.dLa().bll();
                        if (bll != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, bll);
                            if (bll != 28 && bll != 31) {
                                if (next3.dLa().goods != null) {
                                    next3.dLa().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bll);
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
                    if (this.lFd.getForum() != null) {
                        oVar4.forumId = this.lFd.getForum().getId();
                    }
                    if (this.lFd.diN() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lFd.diN().getId(), 0L);
                    }
                    if (this.lFd != null && this.lFd.getPage() != null) {
                        oVar4.pageNumber = this.lFd.getPage().bmk();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lFd.lBZ;
                    if (position + i3 >= diP.size()) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, com.baidu.tieba.lego.card.c.a.eN(arrayList));
                        return;
                    }
                    if (!this.mbK) {
                        position--;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(diP, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        diP.add(position, oVar4);
                        TiebaStatic.eventStat(this.mbJ.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dLa().apk_name);
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
        if (oVar != null && this.lFd != null && oVar.dLa() != null) {
            oVar.dLa().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lFd.getPage() != null) {
                oVar.dLa().advertAppContext.pn = this.lFd.getPage().bmk();
            }
            oVar.dLa().advertAppContext.page = oVar.dLd();
            if (this.lFd.getForum() != null && (forum = this.lFd.getForum()) != null) {
                oVar.dLa().advertAppContext.fid = forum.getId();
                oVar.dLa().advertAppContext.eIK = forum.getFirst_class();
                oVar.dLa().advertAppContext.eIL = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dLa().advertAppContext.eIM = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dLa().advertAppContext.extensionInfo = oVar.dLa().ext_info;
            oVar.dLa().advertAppContext.aaw = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lFn = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fSh = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ftt = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.aYB = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.jgC.getAdapter() instanceof BdRecyclerAdapter) {
            this.jgC.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<n> getDataList() {
        return this.gnp;
    }

    public void vY(boolean z) {
        this.mbK = z;
    }
}
