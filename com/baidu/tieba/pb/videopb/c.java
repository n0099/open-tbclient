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
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<q> fzo;
    private com.baidu.adp.widget.ListView.a iXX;
    private BdTypeRecyclerView iga;
    private com.baidu.adp.widget.ListView.a kIC;
    private com.baidu.tieba.pb.pb.a.c kIG;
    private com.baidu.tieba.pb.data.f kIK;
    private m kIz;
    private ReplyFragment leW;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private boolean leX = true;
    private String bbv = null;
    private boolean kIL = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener kIU = null;
    private View.OnClickListener aTZ = null;
    private TbRichTextView.i ffu = null;
    private com.baidu.tieba.pb.a.c eHq = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.leW = replyFragment;
        this.iga = bdTypeRecyclerView;
        JZ();
    }

    private void JZ() {
        this.kIz = new m(this.leW.dbL(), PostData.moB);
        this.kIz.a((TbRichTextView.c) this.leW.dbL());
        this.kIG = new com.baidu.tieba.pb.pb.a.c(this.leW.dbL(), PostData.moF);
        this.iXX = r.dqU().a(this.leW.dbL().getBaseFragmentActivity(), AdvertAppInfo.dYh);
        this.kIC = r.dqU().a(this.leW.dbL().getBaseFragmentActivity(), AdvertAppInfo.dYl);
        this.bdV.add(this.iXX);
        this.bdV.add(this.kIC);
        this.bdV.add(this.kIz);
        this.bdV.add(this.kIG);
        this.iga.addAdapters(this.bdV);
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        boolean z;
        if (fVar != null) {
            this.kIK = fVar;
            if (fVar != null && fVar.cYR() != null && fVar.cYR().bfy() != null) {
                this.bbv = fVar.cYR().bfy().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kIK != null && this.kIK.cYT() != null && this.kIK.cYT().size() > 0) {
                this.postList.addAll(this.kIK.cYT());
            }
            this.kIz.setData(fVar);
            this.kIz.setFromCDN(this.mIsFromCDN);
            this.kIz.gY(this.bbv);
            this.kIz.sM(this.kIL);
            this.kIz.A(this.aTZ);
            this.kIz.S(this.kIU);
            this.kIz.setOnImageClickListener(this.ffu);
            this.kIz.setOnLongClickListener(this.mOnLongClickListener);
            this.kIz.setTbGestureDetector(this.eHq);
            this.kIG.setOnClickListener(this.aTZ);
            daG();
            if (this.kIC != null && (this.kIC instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.kIC).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<q> arrayList = new ArrayList<>(fVar.cYT());
            Iterator<q> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                q next = it.next();
                if ((next instanceof PostData) && ((PostData) next).dAD() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.iga != null) {
                this.fzo = arrayList;
                this.iga.setData(this.fzo);
            }
        }
    }

    private void daG() {
        n nVar;
        n nVar2;
        if (this.kIK != null && !this.kIK.kGc && this.kIK.Yq != 2) {
            ArrayList<PostData> cYT = this.kIK.cYT();
            ArrayList<n> cZi = this.kIK.cZi();
            if (cZi != null && !cZi.isEmpty() && cYT != null && !cYT.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<n> it = cZi.iterator();
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
                Iterator<n> it2 = cZi.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 != null) {
                        next2.iuL = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<n> it3 = cZi.iterator();
                while (it3.hasNext()) {
                    n next3 = it3.next();
                    if (next3.dAr() != null) {
                        int bdp = next3.dAr().bdp();
                        if (bdp != 0) {
                            a(next3, bdp);
                            if (bdp != 28 && bdp != 31) {
                                if (next3.dAr().goods != null) {
                                    next3.dAr().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bdp);
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
                    if (this.kIK.getForum() != null) {
                        nVar4.forumId = this.kIK.getForum().getId();
                    }
                    if (this.kIK.cYR() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kIK.cYR().getId(), 0L);
                    }
                    if (this.kIK != null && this.kIK.getPage() != null) {
                        nVar4.pageNumber = this.kIK.getPage().bem();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kIK.kGb;
                    if (position + i3 >= cYT.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.leX) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(cYT, position)) {
                        a(nVar4, 1);
                    } else {
                        cYT.add(position, nVar4);
                        TiebaStatic.eventStat(this.leW.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dAr().apk_name);
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
        c.GO(i);
        com.baidu.tieba.recapp.report.d.drV().a(c);
        if (nVar != null && nVar.dAr() != null) {
            nVar.dAr().mDiscardReason = i;
        }
    }

    private void b(n nVar, int i) {
        if (nVar != null && nVar.dAr() != null && nVar.dAr().goods != null && nVar.dAr().goods.goods_style != 1001 && nVar.dAr().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.kIK != null && nVar.dAr() != null) {
            nVar.dAr().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kIK.getPage() != null) {
                nVar.dAr().advertAppContext.pn = this.kIK.getPage().bem();
            }
            nVar.dAr().advertAppContext.page = nVar.dAu();
            if (this.kIK.getForum() != null && (forum = this.kIK.getForum()) != null) {
                nVar.dAr().advertAppContext.fid = forum.getId();
                nVar.dAr().advertAppContext.dXY = forum.getFirst_class();
                nVar.dAr().advertAppContext.dXZ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dAr().advertAppContext.dYa = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dAr().advertAppContext.extensionInfo = nVar.dAr().ext_info;
            nVar.dAr().advertAppContext.Yw = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kIU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.ffu = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eHq = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aTZ = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iga.getAdapter() instanceof h) {
            this.iga.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fzo;
    }

    public void uo(boolean z) {
        this.leX = z;
    }
}
