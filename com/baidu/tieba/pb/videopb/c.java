package com.baidu.tieba.pb.videopb;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.g;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.recapp.r;
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
    private ArrayList<m> eiP;
    private BdTypeRecyclerView gtH;
    private com.baidu.adp.widget.ListView.a hfS;
    private j iGl;
    private com.baidu.adp.widget.ListView.a iGo;
    private com.baidu.tieba.pb.pb.a.c iGs;
    private com.baidu.tieba.pb.data.e iGv;
    private ReplyFragment jaO;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private boolean jaP = true;
    private String arg = null;
    private boolean iGw = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener iGF = null;
    private View.OnClickListener akE = null;
    private TbRichTextView.i dNb = null;
    private com.baidu.tieba.pb.a.c drk = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jaO = replyFragment;
        this.gtH = bdTypeRecyclerView;
        wR();
    }

    private void wR() {
        this.iGl = new j(this.jaO.cnD(), PostData.kii);
        this.iGl.a((TbRichTextView.c) this.jaO.cnD());
        this.iGs = new com.baidu.tieba.pb.pb.a.c(this.jaO.cnD(), PostData.kin);
        this.hfS = r.cCQ().a(this.jaO.cnD().getBaseFragmentActivity(), AdvertAppInfo.cMW);
        this.iGo = r.cCQ().a(this.jaO.cnD().getBaseFragmentActivity(), AdvertAppInfo.cNa);
        this.asP.add(this.hfS);
        this.asP.add(this.iGo);
        this.asP.add(this.iGl);
        this.asP.add(this.iGs);
        this.gtH.addAdapters(this.asP);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        boolean z;
        if (eVar != null) {
            this.iGv = eVar;
            if (eVar != null && eVar.ckP() != null && eVar.ckP().aCr() != null) {
                this.arg = eVar.ckP().aCr().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.iGv != null && this.iGv.ckR() != null && this.iGv.ckR().size() > 0) {
                this.postList.addAll(this.iGv.ckR());
            }
            this.iGl.setData(eVar);
            this.iGl.setFromCDN(this.mIsFromCDN);
            this.iGl.dH(this.arg);
            this.iGl.pC(this.iGw);
            this.iGl.y(this.akE);
            this.iGl.P(this.iGF);
            this.iGl.setOnImageClickListener(this.dNb);
            this.iGl.setOnLongClickListener(this.mOnLongClickListener);
            this.iGl.setTbGestureDetector(this.drk);
            this.iGs.setOnClickListener(this.akE);
            cmy();
            if (this.iGo != null && (this.iGo instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.iGo).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<m> arrayList = new ArrayList<>(eVar.ckR());
            Iterator<m> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                m next = it.next();
                if ((next instanceof PostData) && ((PostData) next).cLv() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.gtH != null) {
                this.eiP = arrayList;
                this.gtH.setData(this.eiP);
            }
        }
    }

    private void cmy() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.iGv != null && !this.iGv.iEd && this.iGv.Df != 2) {
            ArrayList<PostData> ckR = this.iGv.ckR();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> cld = this.iGv.cld();
            if (cld != null && !cld.isEmpty() && ckR != null && !ckR.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it = cld.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = cld.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                    if (next2 != null) {
                        next2.gGS = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = cld.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                    if (next3.cLj() != null) {
                        int aAs = next3.cLj().aAs();
                        if (aAs != 0) {
                            a(next3, aAs);
                            if (aAs != 28 && aAs != 31) {
                                if (next3.cLj().goods != null) {
                                    next3.cLj().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + aAs);
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
                    if (this.iGv.getForum() != null) {
                        mVar4.forumId = this.iGv.getForum().getId();
                    }
                    if (this.iGv.ckP() != null) {
                        mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.iGv.ckP().getId(), 0L);
                    }
                    if (this.iGv != null && this.iGv.getPage() != null) {
                        mVar4.pageNumber = this.iGv.getPage().aBl();
                    }
                    c(mVar4);
                    int position = mVar4.getPosition() + this.iGv.iEc;
                    if (position + i3 >= ckR.size()) {
                        a(mVar4, 2);
                        return;
                    }
                    if (!this.jaP) {
                        position--;
                    }
                    if (position < 0) {
                        a(mVar4, 23);
                    } else if (b(ckR, position)) {
                        a(mVar4, 1);
                    } else {
                        ckR.add(position, mVar4);
                        TiebaStatic.eventStat(this.jaO.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cLj().apk_name);
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
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.Bi(i);
        com.baidu.tieba.recapp.report.c.cDK().a(c);
        if (mVar != null && mVar.cLj() != null) {
            mVar.cLj().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cLj() != null && mVar.cLj().goods != null && mVar.cLj().goods.goods_style != 1001 && mVar.cLj().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.iGv != null && mVar.cLj() != null) {
            mVar.cLj().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.iGv.getPage() != null) {
                mVar.cLj().advertAppContext.pn = this.iGv.getPage().aBl();
            }
            mVar.cLj().advertAppContext.page = mVar.cLm();
            if (this.iGv.getForum() != null && (forum = this.iGv.getForum()) != null) {
                mVar.cLj().advertAppContext.fid = forum.getId();
                mVar.cLj().advertAppContext.cMN = forum.getFirst_class();
                mVar.cLj().advertAppContext.cMO = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cLj().advertAppContext.cMP = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cLj().advertAppContext.extensionInfo = mVar.cLj().ext_info;
            mVar.cLj().advertAppContext.Dn = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iGF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dNb = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.drk = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.akE = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.gtH.getAdapter() instanceof g) {
            this.gtH.getAdapter().notifyDataSetChanged();
        }
    }

    public ArrayList<m> getDataList() {
        return this.eiP;
    }

    public void qZ(boolean z) {
        this.jaP = z;
    }
}
