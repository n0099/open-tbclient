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
    private ArrayList<n> grV;
    private BdTypeRecyclerView joh;
    private com.baidu.adp.widget.ListView.a knc;
    private k lPX;
    private com.baidu.adp.widget.ListView.a lQa;
    private PbReplyLoadMoreAdapter lQg;
    private f lQk;
    private ReplyFragment mnd;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private boolean mne = true;
    private String bmb = null;
    private boolean lQl = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener lQu = null;
    private View.OnClickListener bdi = null;
    private TbRichTextView.i fVW = null;
    private com.baidu.tieba.pb.a.c fxj = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mnd = replyFragment;
        this.joh = bdTypeRecyclerView;
        Kz();
    }

    private void Kz() {
        this.lPX = new k(this.mnd.dop(), PostData.nzd);
        this.lPX.a((TbRichTextView.c) this.mnd.dop());
        this.lQg = new PbReplyLoadMoreAdapter(this.mnd.dop(), PostData.nzh);
        this.knc = s.dDB().a(this.mnd.dop().getBaseFragmentActivity(), AdvertAppInfo.eMG);
        this.lQa = s.dDB().a(this.mnd.dop().getBaseFragmentActivity(), AdvertAppInfo.eMK);
        this.boS.add(this.knc);
        this.boS.add(this.lQa);
        this.boS.add(this.lPX);
        this.boS.add(this.lQg);
        this.joh.addAdapters(this.boS);
    }

    public void setData(f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.lQk = fVar;
            if (fVar != null && fVar.dlp() != null && fVar.dlp().bnS() != null) {
                this.bmb = fVar.dlp().bnS().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lQk != null && this.lQk.dlr() != null && this.lQk.dlr().size() > 0) {
                this.postList.addAll(this.lQk.dlr());
            }
            this.lPX.setData(fVar);
            this.lPX.setFromCDN(this.mIsFromCDN);
            this.lPX.hc(this.bmb);
            this.lPX.uJ(this.lQl);
            this.lPX.C(this.bdi);
            this.lPX.V(this.lQu);
            this.lPX.setOnImageClickListener(this.fVW);
            this.lPX.setOnLongClickListener(this.mOnLongClickListener);
            this.lPX.setTbGestureDetector(this.fxj);
            this.lQg.setOnClickListener(this.bdi);
            dnh();
            if (this.lQa != null && (this.lQa instanceof p)) {
                ((p) this.lQa).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<n> arrayList = new ArrayList<>(fVar.dlr());
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                n next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dNO() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.joh != null) {
                this.grV = arrayList;
                this.joh.setData(this.grV);
            }
        }
    }

    private void dnh() {
        o oVar;
        o oVar2;
        if (this.lQk != null && !this.lQk.lNd && this.lQk.abG != 2) {
            ArrayList<PostData> dlr = this.lQk.dlr();
            ArrayList<o> dlG = this.lQk.dlG();
            if (dlG != null && !dlG.isEmpty() && dlr != null && !dlr.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<o> it = dlG.iterator();
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
                Iterator<o> it2 = dlG.iterator();
                while (it2.hasNext()) {
                    o next2 = it2.next();
                    if (next2 != null) {
                        next2.jFH = sb.toString();
                        next2.position = next2.getPosition() - 1;
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<o> it3 = dlG.iterator();
                while (it3.hasNext()) {
                    o next3 = it3.next();
                    if (next3.dNC() != null) {
                        int blF = next3.dNC().blF();
                        if (blF != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, blF);
                            if (blF != 28 && blF != 31) {
                                if (next3.dNC().goods != null) {
                                    next3.dNC().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + blF);
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
                    if (this.lQk.getForum() != null) {
                        oVar4.forumId = this.lQk.getForum().getId();
                    }
                    if (this.lQk.dlp() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lQk.dlp().getId(), 0L);
                    }
                    if (this.lQk != null && this.lQk.getPage() != null) {
                        oVar4.pageNumber = this.lQk.getPage().bmF();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lQk.lNc;
                    if (position >= dlr.size()) {
                        oVar4.position = position;
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, com.baidu.tieba.lego.card.c.a.eL(arrayList));
                        return;
                    }
                    if (!this.mne) {
                        position--;
                        oVar4.position = position;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(dlr, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        dlr.add(position, oVar4);
                        TiebaStatic.eventStat(this.mnd.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dNC().apk_name);
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
        if (oVar != null && this.lQk != null && oVar.dNC() != null) {
            oVar.dNC().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lQk.getPage() != null) {
                oVar.dNC().advertAppContext.pn = this.lQk.getPage().bmF();
            }
            oVar.dNC().advertAppContext.page = oVar.dNF();
            if (this.lQk.getForum() != null && (forum = this.lQk.getForum()) != null) {
                oVar.dNC().advertAppContext.fid = forum.getId();
                oVar.dNC().advertAppContext.eMx = forum.getFirst_class();
                oVar.dNC().advertAppContext.eMy = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dNC().advertAppContext.eMz = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dNC().advertAppContext.extensionInfo = oVar.dNC().ext_info;
            oVar.dNC().advertAppContext.abM = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void V(View.OnClickListener onClickListener) {
        this.lQu = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fVW = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fxj = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.bdi = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.joh.getAdapter() instanceof BdRecyclerAdapter) {
            this.joh.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<n> getDataList() {
        return this.grV;
    }

    public void wp(boolean z) {
        this.mne = z;
    }
}
