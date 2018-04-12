package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class k {
    private ForumData aEX;
    private int aFp;
    private bd bjU;
    private AntiData fcU;
    public Error fcW;
    private int mCurrentPage;
    private int fcS = 20;
    private int fcT = -1;
    private boolean fcV = false;
    private PostData fcP = null;
    private ArrayList<PostData> fcQ = new ArrayList<>();
    private int fcR = 1;

    public Error aWb() {
        return this.fcW;
    }

    public PostData aWc() {
        return this.fcP;
    }

    public void d(PostData postData) {
        this.fcP = postData;
    }

    public int aWd() {
        if (this.fcT == -1) {
            this.fcT = this.mCurrentPage;
        }
        return this.fcT;
    }

    public int aWe() {
        return this.fcT;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.aWk());
            this.fcT = kVar.La();
            a(kVar.aWj());
            setPageSize(kVar.aWi());
            T(kVar.Pe());
            setTotalCount(kVar.getTotalCount());
            iU(kVar.aWh());
            this.fcQ.addAll(0, kVar.aWg());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.aWk());
            a(kVar.aWj());
            d(kVar.aWc());
            T(kVar.Pe());
            if (kVar.aWg() != null && kVar.aWg().size() > 0) {
                bV(kVar.La());
                setPageSize(kVar.aWi());
                setTotalCount(kVar.getTotalCount());
                iU(kVar.aWh());
            }
            int size = this.fcQ.size();
            if (z && size % this.fcS != 0) {
                for (int i = 0; i < size % this.fcS; i++) {
                    this.fcQ.remove(this.fcQ.size() - 1);
                }
            }
            this.fcQ.addAll(kVar.aWg());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.aWk());
            a(kVar.aWj());
            d(kVar.aWc());
            T(kVar.Pe());
            if (kVar.aWg() != null && kVar.aWg().size() > 0) {
                bV(kVar.La());
                setPageSize(kVar.aWi());
                setTotalCount(kVar.getTotalCount());
                iU(kVar.aWh());
            }
            int size = this.fcQ.size();
            if (z && size % this.fcS != 0) {
                for (int i = 0; i < size % this.fcS; i++) {
                    this.fcQ.remove(this.fcQ.size() - 1);
                }
            }
            this.fcQ.addAll(kVar.aWg());
            aWf();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.aWk());
            a(kVar.aWj());
            d(kVar.aWc());
            T(kVar.Pe());
            if (kVar.aWg() != null && kVar.aWg().size() > 0) {
                bV(kVar.La());
                setPageSize(kVar.aWi());
                setTotalCount(kVar.getTotalCount());
                iU(kVar.aWh());
                this.fcT = (this.mCurrentPage - (((kVar.aWg().size() - 1) + this.fcS) / this.fcS)) + 1;
                if (this.fcT < 0) {
                    this.fcT = 0;
                }
            }
            this.fcQ.addAll(kVar.aWg());
        }
    }

    public void aWf() {
        if (this.fcT < 0) {
            this.fcT = this.mCurrentPage;
        } else if (this.fcT > this.mCurrentPage) {
            this.fcT = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aWg() {
        return this.fcQ;
    }

    public void al(ArrayList<PostData> arrayList) {
        this.fcQ = arrayList;
    }

    public int aWh() {
        return this.fcR;
    }

    public void iU(int i) {
        this.fcR = i;
    }

    public int getTotalCount() {
        return this.aFp;
    }

    public void setTotalCount(int i) {
        this.aFp = i;
    }

    public int aWi() {
        return this.fcS;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.fcS = i;
        }
    }

    public int La() {
        return this.mCurrentPage;
    }

    public void bV(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.aEX = forumData;
    }

    public ForumData aWj() {
        return this.aEX;
    }

    public void b(AntiData antiData) {
        this.fcU = antiData;
    }

    public AntiData aWk() {
        return this.fcU;
    }

    public void T(bd bdVar) {
        this.bjU = bdVar;
    }

    public boolean aGn() {
        return (this.bjU == null || this.fcP == null || this.bjU.rQ() == null || this.bjU.rQ().getUserId() == null || this.fcP.rQ() == null || this.fcP.rQ().getUserId() == null || !this.bjU.rQ().getUserId().equals(this.fcP.rQ().getUserId())) ? false : true;
    }

    public boolean oI() {
        return this.fcV;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fcR;
    }

    public bd Pe() {
        return this.bjU;
    }

    public static k a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            k kVar = new k();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            kVar.b(antiData);
            bd bdVar = new bd();
            bdVar.a(dataRes.thread);
            bdVar.bV(2);
            kVar.T(bdVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.a(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            kVar.d(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.al(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            kVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                kVar.bV(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.iU(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
