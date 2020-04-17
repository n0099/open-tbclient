package com.baidu.tieba.pb.videopb;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
    private ArrayList<m> eIA;
    private com.baidu.adp.widget.ListView.a hPE;
    private BdTypeRecyclerView hcS;
    private ReplyFragment jKW;
    private com.baidu.tieba.pb.data.e jqC;
    private j jqs;
    private com.baidu.adp.widget.ListView.a jqv;
    private com.baidu.tieba.pb.pb.a.c jqz;
    private ArrayList<PostData> postList;
    private final List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private boolean jKX = true;
    private String aJP = null;
    private boolean jqD = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener jqM = null;
    private View.OnClickListener aDc = null;
    private TbRichTextView.i emS = null;
    private com.baidu.tieba.pb.a.c dRh = null;
    private View.OnLongClickListener mOnLongClickListener = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jKW = replyFragment;
        this.hcS = bdTypeRecyclerView;
        BC();
    }

    private void BC() {
        this.jqs = new j(this.jKW.cyj(), PostData.kSo);
        this.jqs.a((TbRichTextView.c) this.jKW.cyj());
        this.jqz = new com.baidu.tieba.pb.pb.a.c(this.jKW.cyj(), PostData.kSt);
        this.hPE = q.cNo().a(this.jKW.cyj().getBaseFragmentActivity(), AdvertAppInfo.dmc);
        this.jqv = q.cNo().a(this.jKW.cyj().getBaseFragmentActivity(), AdvertAppInfo.dmg);
        this.aMd.add(this.hPE);
        this.aMd.add(this.jqv);
        this.aMd.add(this.jqs);
        this.aMd.add(this.jqz);
        this.hcS.addAdapters(this.aMd);
    }

    public void setData(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        boolean z;
        if (eVar != null) {
            this.jqC = eVar;
            if (eVar != null && eVar.cvu() != null && eVar.cvu().aKE() != null) {
                this.aJP = eVar.cvu().aKE().getUserId();
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.jqC != null && this.jqC.cvw() != null && this.jqC.cvw().size() > 0) {
                this.postList.addAll(this.jqC.cvw());
            }
            this.jqs.setData(eVar);
            this.jqs.setFromCDN(this.mIsFromCDN);
            this.jqs.eA(this.aJP);
            this.jqs.qG(this.jqD);
            this.jqs.z(this.aDc);
            this.jqs.Q(this.jqM);
            this.jqs.setOnImageClickListener(this.emS);
            this.jqs.setOnLongClickListener(this.mOnLongClickListener);
            this.jqs.setTbGestureDetector(this.dRh);
            this.jqz.setOnClickListener(this.aDc);
            cxe();
            if (this.jqv != null && (this.jqv instanceof l)) {
                ((l) this.jqv).setIsFromCDN(this.mIsFromCDN);
            }
            ArrayList<m> arrayList = new ArrayList<>(eVar.cvw());
            Iterator<m> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    z = false;
                    break;
                }
                m next = it.next();
                if ((next instanceof PostData) && ((PostData) next).cWr() == 1) {
                    postData = (PostData) next;
                    z = true;
                    break;
                }
            }
            if (z) {
                arrayList.remove(postData);
            }
            if (this.hcS != null) {
                this.eIA = arrayList;
                this.hcS.setData(this.eIA);
            }
        }
    }

    private void cxe() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.jqC != null && !this.jqC.joj && this.jqC.WA != 2) {
            ArrayList<PostData> cvw = this.jqC.cvw();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> cvI = this.jqC.cvI();
            if (cvI != null && !cvI.isEmpty() && cvw != null && !cvw.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it = cvI.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = cvI.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                    if (next2 != null) {
                        next2.hql = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = cvI.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                    if (next3.cWf() != null) {
                        int aIF = next3.cWf().aIF();
                        if (aIF != 0) {
                            a(next3, aIF);
                            if (aIF != 28 && aIF != 31) {
                                if (next3.cWf().goods != null) {
                                    next3.cWf().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + aIF);
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
                    if (this.jqC.getForum() != null) {
                        mVar4.forumId = this.jqC.getForum().getId();
                    }
                    if (this.jqC.cvu() != null) {
                        mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.jqC.cvu().getId(), 0L);
                    }
                    if (this.jqC != null && this.jqC.getPage() != null) {
                        mVar4.pageNumber = this.jqC.getPage().aJy();
                    }
                    c(mVar4);
                    int position = mVar4.getPosition() + this.jqC.joi;
                    if (position + i3 >= cvw.size()) {
                        a(mVar4, 2);
                        return;
                    }
                    if (!this.jKX) {
                        position--;
                    }
                    if (position < 0) {
                        a(mVar4, 23);
                    } else if (b(cvw, position)) {
                        a(mVar4, 1);
                    } else {
                        cvw.add(position, mVar4);
                        TiebaStatic.eventStat(this.jKW.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cWf().apk_name);
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
        com.baidu.tieba.recapp.report.d.cOl().a(c);
        if (mVar != null && mVar.cWf() != null) {
            mVar.cWf().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cWf() != null && mVar.cWf().goods != null && mVar.cWf().goods.goods_style != 1001 && mVar.cWf().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.jqC != null && mVar.cWf() != null) {
            mVar.cWf().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.jqC.getPage() != null) {
                mVar.cWf().advertAppContext.pn = this.jqC.getPage().aJy();
            }
            mVar.cWf().advertAppContext.page = mVar.cWi();
            if (this.jqC.getForum() != null && (forum = this.jqC.getForum()) != null) {
                mVar.cWf().advertAppContext.fid = forum.getId();
                mVar.cWf().advertAppContext.dlT = forum.getFirst_class();
                mVar.cWf().advertAppContext.dlU = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cWf().advertAppContext.dlV = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cWf().advertAppContext.extensionInfo = mVar.cWf().ext_info;
            mVar.cWf().advertAppContext.WI = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jqM = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emS = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dRh = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.aDc = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.hcS.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            this.hcS.getAdapter().notifyDataSetChanged();
        }
    }

    public ArrayList<m> getDataList() {
        return this.eIA;
    }

    public void sd(boolean z) {
        this.jKX = z;
    }
}
