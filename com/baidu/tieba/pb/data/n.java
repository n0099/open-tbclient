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
    public boolean hQV;
    public Error jGD;
    private int mPageSize = 20;
    private int jGB = -1;
    private boolean jGC = false;
    private PostData jGy = null;
    private ArrayList<PostData> jGz = new ArrayList<>();
    private int jGA = 1;

    public Error cDr() {
        return this.jGD;
    }

    public PostData cDs() {
        return this.jGy;
    }

    public void g(PostData postData) {
        this.jGy = postData;
    }

    public int cDt() {
        if (this.jGB == -1) {
            this.jGB = this.aIx;
        }
        return this.jGB;
    }

    public int cDu() {
        return this.jGB;
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            b(nVar.bUc());
            this.jGB = nVar.bkl();
            a(nVar.bdQ());
            setPageSize(nVar.getPageSize());
            setThreadData(nVar.aOi());
            setTotalCount(nVar.getTotalCount());
            zX(nVar.cDx());
            this.jGz.addAll(0, nVar.cDw());
        }
    }

    public void b(n nVar, boolean z) {
        if (nVar != null) {
            b(nVar.bUc());
            a(nVar.bdQ());
            g(nVar.cDs());
            setThreadData(nVar.aOi());
            if (nVar.cDw() != null) {
                setCurrentPage(nVar.bkl());
                setPageSize(nVar.getPageSize());
                setTotalCount(nVar.getTotalCount());
                zX(nVar.cDx());
            }
            int size = this.jGz.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.jGz.remove(this.jGz.size() - 1);
                }
            }
            this.jGz.addAll(nVar.cDw());
        }
    }

    public void c(n nVar, boolean z) {
        if (nVar != null) {
            b(nVar.bUc());
            a(nVar.bdQ());
            g(nVar.cDs());
            setThreadData(nVar.aOi());
            if (nVar.cDw() != null && nVar.cDw().size() > 0) {
                setCurrentPage(nVar.bkl());
                setPageSize(nVar.getPageSize());
                setTotalCount(nVar.getTotalCount());
                zX(nVar.cDx());
            }
            int size = this.jGz.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.jGz.remove(this.jGz.size() - 1);
                }
            }
            this.jGz.addAll(nVar.cDw());
            cDv();
        }
    }

    public void d(n nVar, boolean z) {
        a(nVar, z);
    }

    public void a(n nVar) {
        if (nVar != null) {
            b(nVar.bUc());
            a(nVar.bdQ());
            g(nVar.cDs());
            setThreadData(nVar.aOi());
            if (nVar.cDw() != null && nVar.cDw().size() > 0) {
                setCurrentPage(nVar.bkl());
                setPageSize(nVar.getPageSize());
                setTotalCount(nVar.getTotalCount());
                zX(nVar.cDx());
                this.jGB = (this.aIx - (((nVar.cDw().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.jGB < 0) {
                    this.jGB = 0;
                }
            }
            this.jGz.addAll(nVar.cDw());
        }
    }

    public void cDv() {
        if (this.jGB < 0) {
            this.jGB = this.aIx;
        } else if (this.jGB > this.aIx) {
            this.jGB = this.aIx;
        }
    }

    public ArrayList<PostData> cDw() {
        return this.jGz;
    }

    public void aL(ArrayList<PostData> arrayList) {
        this.jGz = arrayList;
    }

    public int cDx() {
        return this.jGA;
    }

    public void zX(int i) {
        this.jGA = i;
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

    public int bkl() {
        return this.aIx;
    }

    public void setCurrentPage(int i) {
        this.aIx = i;
    }

    public void a(ForumData forumData) {
        this.enm = forumData;
    }

    public ForumData bdQ() {
        return this.enm;
    }

    public void b(AntiData antiData) {
        this.eaU = antiData;
    }

    public AntiData bUc() {
        return this.eaU;
    }

    public void setThreadData(bk bkVar) {
        this.ahg = bkVar;
    }

    public boolean coT() {
        return (this.ahg == null || this.jGy == null || this.ahg.aQx() == null || this.ahg.aQx().getUserId() == null || this.jGy.aQx() == null || this.jGy.aQx().getUserId() == null || !this.ahg.aQx().getUserId().equals(this.jGy.aQx().getUserId())) ? false : true;
    }

    public boolean aML() {
        return this.jGC;
    }

    public boolean hasMore() {
        return this.aIx < this.jGA;
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
            nVar.hQV = forumData.isBrandForum;
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
                nVar.zX(intValue);
            }
            return nVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
