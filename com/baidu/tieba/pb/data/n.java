package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes9.dex */
public class n {
    private int aIx;
    private bk ahg;
    private AntiData eaU;
    private int enF;
    private ForumData enm;
    public boolean hQi;
    public Error jFx;
    private int mPageSize = 20;
    private int jFv = -1;
    private boolean jFw = false;
    private PostData jFs = null;
    private ArrayList<PostData> jFt = new ArrayList<>();
    private int jFu = 1;

    public Error cDb() {
        return this.jFx;
    }

    public PostData cDc() {
        return this.jFs;
    }

    public void g(PostData postData) {
        this.jFs = postData;
    }

    public int cDd() {
        if (this.jFv == -1) {
            this.jFv = this.aIx;
        }
        return this.jFv;
    }

    public int cDe() {
        return this.jFv;
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            b(nVar.bUa());
            this.jFv = nVar.bkj();
            a(nVar.bdP());
            setPageSize(nVar.getPageSize());
            setThreadData(nVar.aOi());
            setTotalCount(nVar.getTotalCount());
            zV(nVar.cDh());
            this.jFt.addAll(0, nVar.cDg());
        }
    }

    public void b(n nVar, boolean z) {
        if (nVar != null) {
            b(nVar.bUa());
            a(nVar.bdP());
            g(nVar.cDc());
            setThreadData(nVar.aOi());
            if (nVar.cDg() != null) {
                setCurrentPage(nVar.bkj());
                setPageSize(nVar.getPageSize());
                setTotalCount(nVar.getTotalCount());
                zV(nVar.cDh());
            }
            int size = this.jFt.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.jFt.remove(this.jFt.size() - 1);
                }
            }
            this.jFt.addAll(nVar.cDg());
        }
    }

    public void c(n nVar, boolean z) {
        if (nVar != null) {
            b(nVar.bUa());
            a(nVar.bdP());
            g(nVar.cDc());
            setThreadData(nVar.aOi());
            if (nVar.cDg() != null && nVar.cDg().size() > 0) {
                setCurrentPage(nVar.bkj());
                setPageSize(nVar.getPageSize());
                setTotalCount(nVar.getTotalCount());
                zV(nVar.cDh());
            }
            int size = this.jFt.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.jFt.remove(this.jFt.size() - 1);
                }
            }
            this.jFt.addAll(nVar.cDg());
            cDf();
        }
    }

    public void d(n nVar, boolean z) {
        a(nVar, z);
    }

    public void a(n nVar) {
        if (nVar != null) {
            b(nVar.bUa());
            a(nVar.bdP());
            g(nVar.cDc());
            setThreadData(nVar.aOi());
            if (nVar.cDg() != null && nVar.cDg().size() > 0) {
                setCurrentPage(nVar.bkj());
                setPageSize(nVar.getPageSize());
                setTotalCount(nVar.getTotalCount());
                zV(nVar.cDh());
                this.jFv = (this.aIx - (((nVar.cDg().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.jFv < 0) {
                    this.jFv = 0;
                }
            }
            this.jFt.addAll(nVar.cDg());
        }
    }

    public void cDf() {
        if (this.jFv < 0) {
            this.jFv = this.aIx;
        } else if (this.jFv > this.aIx) {
            this.jFv = this.aIx;
        }
    }

    public ArrayList<PostData> cDg() {
        return this.jFt;
    }

    public void aL(ArrayList<PostData> arrayList) {
        this.jFt = arrayList;
    }

    public int cDh() {
        return this.jFu;
    }

    public void zV(int i) {
        this.jFu = i;
    }

    public int getTotalCount() {
        return this.enF;
    }

    public void setTotalCount(int i) {
        this.enF = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bkj() {
        return this.aIx;
    }

    public void setCurrentPage(int i) {
        this.aIx = i;
    }

    public void a(ForumData forumData) {
        this.enm = forumData;
    }

    public ForumData bdP() {
        return this.enm;
    }

    public void b(AntiData antiData) {
        this.eaU = antiData;
    }

    public AntiData bUa() {
        return this.eaU;
    }

    public void setThreadData(bk bkVar) {
        this.ahg = bkVar;
    }

    public boolean coK() {
        return (this.ahg == null || this.jFs == null || this.ahg.aQx() == null || this.ahg.aQx().getUserId() == null || this.jFs.aQx() == null || this.jFs.aQx().getUserId() == null || !this.ahg.aQx().getUserId().equals(this.jFs.aQx().getUserId())) ? false : true;
    }

    public boolean aML() {
        return this.jFw;
    }

    public boolean hasMore() {
        return this.aIx < this.jFu;
    }

    public bk aOi() {
        return this.ahg;
    }

    public static n a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            n nVar = new n();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            nVar.b(antiData);
            bk bkVar = new bk();
            bkVar.a(dataRes.thread);
            nVar.setThreadData(bkVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            nVar.a(forumData);
            nVar.hQi = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.uq(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            nVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.uq(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            nVar.aL(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            nVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                nVar.setCurrentPage(intValue3);
                nVar.setPageSize(intValue2);
                nVar.setTotalCount(intValue4);
                nVar.zV(intValue);
            }
            return nVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
