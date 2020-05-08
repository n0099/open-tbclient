package com.baidu.tieba.pb.videopb;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.recapp.l;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class c {
    private ArrayList<m> eIF;
    private com.baidu.adp.widget.ListView.a hPK;
    private BdTypeRecyclerView hcY;
    private ReplyFragment jLa;
    private com.baidu.tieba.pb.pb.a.c jqD;
    private com.baidu.tieba.pb.data.e jqG;
    private j jqw;
    private com.baidu.adp.widget.ListView.a jqz;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private boolean jLb = true;
    private String aJV = null;
    private boolean jqH = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener jqQ = null;
    private View.OnClickListener aDi = null;
    private TbRichTextView.i emX = null;
    private com.baidu.tieba.pb.a.c dRm = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jLa = replyFragment;
        this.hcY = bdTypeRecyclerView;
        BB();
    }

    private void BB() {
        this.jqw = new j(this.jLa.cyg(), PostData.kSs);
        this.jqw.a((TbRichTextView.c) this.jLa.cyg());
        this.jqD = new com.baidu.tieba.pb.pb.a.c(this.jLa.cyg(), PostData.kSx);
        this.hPK = q.cNl().a(this.jLa.cyg().getBaseFragmentActivity(), AdvertAppInfo.dmg);
        this.jqz = q.cNl().a(this.jLa.cyg().getBaseFragmentActivity(), AdvertAppInfo.dmk);
        this.aMj.add(this.hPK);
        this.aMj.add(this.jqz);
        this.aMj.add(this.jqw);
        this.aMj.add(this.jqD);
        this.hcY.addAdapters(this.aMj);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        boolean z;
        if (eVar != null) {
            this.jqG = eVar;
            if (eVar != null && eVar.cvr() != null && eVar.cvr().aKC() != null) {
                this.aJV = eVar.cvr().aKC().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.jqG != null && this.jqG.cvt() != null && this.jqG.cvt().size() > 0) {
                this.postList.addAll(this.jqG.cvt());
            }
            this.jqw.setData(eVar);
            this.jqw.setFromCDN(this.mIsFromCDN);
            this.jqw.eA(this.aJV);
            this.jqw.qG(this.jqH);
            this.jqw.z(this.aDi);
            this.jqw.Q(this.jqQ);
            this.jqw.setOnImageClickListener(this.emX);
            this.jqw.setOnLongClickListener(this.mOnLongClickListener);
            this.jqw.setTbGestureDetector(this.dRm);
            this.jqD.setOnClickListener(this.aDi);
            cxb();
            if (this.jqz != null && (this.jqz instanceof l)) {
                ((l) this.jqz).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<m> arrayList = new ArrayList<>(eVar.cvt());
            Iterator<m> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                m next = it.next();
                if ((next instanceof PostData) && ((PostData) next).cWo() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.hcY != null) {
                this.eIF = arrayList;
                this.hcY.setData(this.eIF);
            }
        }
    }

    private void cxb() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.jqG != null && !this.jqG.jon && this.jqG.WD != 2) {
            ArrayList<PostData> cvt = this.jqG.cvt();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> cvF = this.jqG.cvF();
            if (cvF != null && !cvF.isEmpty() && cvt != null && !cvt.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it = cvF.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = cvF.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                    if (next2 != null) {
                        next2.hqr = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = cvF.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                    if (next3.cWc() != null) {
                        int aID = next3.cWc().aID();
                        if (aID != 0) {
                            a(next3, aID);
                            if (aID != 28 && aID != 31) {
                                if (next3.cWc().goods != null) {
                                    next3.cWc().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + aID);
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); i++) {
                    com.baidu.tieba.tbadkCore.data.m mVar3 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(sparseArray.keyAt(i));
                    if (mVar3 != null && (mVar2 = (com.baidu.tieba.tbadkCore.data.m) hashMap.put(mVar3.getAdId(), mVar3)) != null) {
                        b(mVar2, 30);
                    }
                }
                sparseArray.clear();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry != null && (mVar = (com.baidu.tieba.tbadkCore.data.m) entry.getValue()) != null) {
                        sparseArray.put(mVar.getPosition(), mVar);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    com.baidu.tieba.tbadkCore.data.m mVar4 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                    if (this.jqG.getForum() != null) {
                        mVar4.forumId = this.jqG.getForum().getId();
                    }
                    if (this.jqG.cvr() != null) {
                        mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.jqG.cvr().getId(), 0L);
                    }
                    if (this.jqG != null && this.jqG.getPage() != null) {
                        mVar4.pageNumber = this.jqG.getPage().aJw();
                    }
                    c(mVar4);
                    int position = mVar4.getPosition() + this.jqG.jom;
                    if (position + i3 >= cvt.size()) {
                        a(mVar4, 2);
                        return;
                    }
                    if (!this.jLb) {
                        position--;
                    }
                    if (position < 0) {
                        a(mVar4, 23);
                    } else if (b(cvt, position)) {
                        a(mVar4, 1);
                    } else {
                        cvt.add(position, mVar4);
                        TiebaStatic.eventStat(this.jLa.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cWc().apk_name);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof com.baidu.tieba.tbadkCore.data.m) {
                return true;
            }
        }
        return false;
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.c c = g.c(mVar, 5);
        c.BI(i);
        com.baidu.tieba.recapp.report.d.cOi().a(c);
        if (mVar != null && mVar.cWc() != null) {
            mVar.cWc().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cWc() != null && mVar.cWc().goods != null && mVar.cWc().goods.goods_style != 1001 && mVar.cWc().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.jqG != null && mVar.cWc() != null) {
            mVar.cWc().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.jqG.getPage() != null) {
                mVar.cWc().advertAppContext.pn = this.jqG.getPage().aJw();
            }
            mVar.cWc().advertAppContext.page = mVar.cWf();
            if (this.jqG.getForum() != null && (forum = this.jqG.getForum()) != null) {
                mVar.cWc().advertAppContext.fid = forum.getId();
                mVar.cWc().advertAppContext.dlX = forum.getFirst_class();
                mVar.cWc().advertAppContext.dlY = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cWc().advertAppContext.dlZ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cWc().advertAppContext.extensionInfo = mVar.cWc().ext_info;
            mVar.cWc().advertAppContext.WL = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jqQ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emX = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dRm = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.aDi = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.hcY.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            this.hcY.getAdapter().notifyDataSetChanged();
        }
    }

    public ArrayList<m> getDataList() {
        return this.eIF;
    }

    public void sd(boolean z) {
        this.jLb = z;
    }
}
