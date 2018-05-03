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
    private AntiData fcR;
    public Error fcT;
    private int mCurrentPage;
    private int fcP = 20;
    private int fcQ = -1;
    private boolean fcS = false;
    private PostData fcM = null;
    private ArrayList<PostData> fcN = new ArrayList<>();
    private int fcO = 1;

    public Error aWb() {
        return this.fcT;
    }

    public PostData aWc() {
        return this.fcM;
    }

    public void d(PostData postData) {
        this.fcM = postData;
    }

    public int aWd() {
        if (this.fcQ == -1) {
            this.fcQ = this.mCurrentPage;
        }
        return this.fcQ;
    }

    public int aWe() {
        return this.fcQ;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.aWk());
            this.fcQ = kVar.La();
            a(kVar.aWj());
            setPageSize(kVar.aWi());
            T(kVar.Pe());
            setTotalCount(kVar.getTotalCount());
            iT(kVar.aWh());
            this.fcN.addAll(0, kVar.aWg());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.aWk());
            a(kVar.aWj());
            d(kVar.aWc());
            T(kVar.Pe());
            if (kVar.aWg() != null && kVar.aWg().size() > 0) {
                bU(kVar.La());
                setPageSize(kVar.aWi());
                setTotalCount(kVar.getTotalCount());
                iT(kVar.aWh());
            }
            int size = this.fcN.size();
            if (z && size % this.fcP != 0) {
                for (int i = 0; i < size % this.fcP; i++) {
                    this.fcN.remove(this.fcN.size() - 1);
                }
            }
            this.fcN.addAll(kVar.aWg());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.aWk());
            a(kVar.aWj());
            d(kVar.aWc());
            T(kVar.Pe());
            if (kVar.aWg() != null && kVar.aWg().size() > 0) {
                bU(kVar.La());
                setPageSize(kVar.aWi());
                setTotalCount(kVar.getTotalCount());
                iT(kVar.aWh());
            }
            int size = this.fcN.size();
            if (z && size % this.fcP != 0) {
                for (int i = 0; i < size % this.fcP; i++) {
                    this.fcN.remove(this.fcN.size() - 1);
                }
            }
            this.fcN.addAll(kVar.aWg());
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
                bU(kVar.La());
                setPageSize(kVar.aWi());
                setTotalCount(kVar.getTotalCount());
                iT(kVar.aWh());
                this.fcQ = (this.mCurrentPage - (((kVar.aWg().size() - 1) + this.fcP) / this.fcP)) + 1;
                if (this.fcQ < 0) {
                    this.fcQ = 0;
                }
            }
            this.fcN.addAll(kVar.aWg());
        }
    }

    public void aWf() {
        if (this.fcQ < 0) {
            this.fcQ = this.mCurrentPage;
        } else if (this.fcQ > this.mCurrentPage) {
            this.fcQ = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aWg() {
        return this.fcN;
    }

    public void al(ArrayList<PostData> arrayList) {
        this.fcN = arrayList;
    }

    public int aWh() {
        return this.fcO;
    }

    public void iT(int i) {
        this.fcO = i;
    }

    public int getTotalCount() {
        return this.aFp;
    }

    public void setTotalCount(int i) {
        this.aFp = i;
    }

    public int aWi() {
        return this.fcP;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.fcP = i;
        }
    }

    public int La() {
        return this.mCurrentPage;
    }

    public void bU(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.aEX = forumData;
    }

    public ForumData aWj() {
        return this.aEX;
    }

    public void b(AntiData antiData) {
        this.fcR = antiData;
    }

    public AntiData aWk() {
        return this.fcR;
    }

    public void T(bd bdVar) {
        this.bjU = bdVar;
    }

    public boolean aGn() {
        return (this.bjU == null || this.fcM == null || this.bjU.rQ() == null || this.bjU.rQ().getUserId() == null || this.fcM.rQ() == null || this.fcM.rQ().getUserId() == null || !this.bjU.rQ().getUserId().equals(this.fcM.rQ().getUserId())) ? false : true;
    }

    public boolean oI() {
        return this.fcS;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fcO;
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
            bdVar.bU(2);
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
                kVar.bU(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.iT(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
