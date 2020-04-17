package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes9.dex */
public class l {
    private int aCS;
    private bj agz;
    private AntiData dMz;
    private ForumData dYX;
    private int dZp;
    public boolean hBp;
    public Error joK;
    private int mPageSize = 20;
    private int joI = -1;
    private boolean joJ = false;
    private PostData joF = null;
    private ArrayList<PostData> joG = new ArrayList<>();
    private int joH = 1;

    public Error cwg() {
        return this.joK;
    }

    public PostData cwh() {
        return this.joF;
    }

    public void f(PostData postData) {
        this.joF = postData;
    }

    public int cwi() {
        if (this.joI == -1) {
            this.joI = this.aCS;
        }
        return this.joI;
    }

    public int cwj() {
        return this.joI;
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bNG());
            this.joI = lVar.bea();
            a(lVar.aXI());
            setPageSize(lVar.getPageSize());
            setThreadData(lVar.aIw());
            setTotalCount(lVar.getTotalCount());
            zl(lVar.cwm());
            this.joG.addAll(0, lVar.cwl());
        }
    }

    public void b(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bNG());
            a(lVar.aXI());
            f(lVar.cwh());
            setThreadData(lVar.aIw());
            if (lVar.cwl() != null) {
                setCurrentPage(lVar.bea());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                zl(lVar.cwm());
            }
            int size = this.joG.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.joG.remove(this.joG.size() - 1);
                }
            }
            this.joG.addAll(lVar.cwl());
        }
    }

    public void c(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bNG());
            a(lVar.aXI());
            f(lVar.cwh());
            setThreadData(lVar.aIw());
            if (lVar.cwl() != null && lVar.cwl().size() > 0) {
                setCurrentPage(lVar.bea());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                zl(lVar.cwm());
            }
            int size = this.joG.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.joG.remove(this.joG.size() - 1);
                }
            }
            this.joG.addAll(lVar.cwl());
            cwk();
        }
    }

    public void d(l lVar, boolean z) {
        a(lVar, z);
    }

    public void a(l lVar) {
        if (lVar != null) {
            b(lVar.bNG());
            a(lVar.aXI());
            f(lVar.cwh());
            setThreadData(lVar.aIw());
            if (lVar.cwl() != null && lVar.cwl().size() > 0) {
                setCurrentPage(lVar.bea());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                zl(lVar.cwm());
                this.joI = (this.aCS - (((lVar.cwl().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.joI < 0) {
                    this.joI = 0;
                }
            }
            this.joG.addAll(lVar.cwl());
        }
    }

    public void cwk() {
        if (this.joI < 0) {
            this.joI = this.aCS;
        } else if (this.joI > this.aCS) {
            this.joI = this.aCS;
        }
    }

    public ArrayList<PostData> cwl() {
        return this.joG;
    }

    public void aL(ArrayList<PostData> arrayList) {
        this.joG = arrayList;
    }

    public int cwm() {
        return this.joH;
    }

    public void zl(int i) {
        this.joH = i;
    }

    public int getTotalCount() {
        return this.dZp;
    }

    public void setTotalCount(int i) {
        this.dZp = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bea() {
        return this.aCS;
    }

    public void setCurrentPage(int i) {
        this.aCS = i;
    }

    public void a(ForumData forumData) {
        this.dYX = forumData;
    }

    public ForumData aXI() {
        return this.dYX;
    }

    public void b(AntiData antiData) {
        this.dMz = antiData;
    }

    public AntiData bNG() {
        return this.dMz;
    }

    public void setThreadData(bj bjVar) {
        this.agz = bjVar;
    }

    public boolean cio() {
        return (this.agz == null || this.joF == null || this.agz.aKE() == null || this.agz.aKE().getUserId() == null || this.joF.aKE() == null || this.joF.aKE().getUserId() == null || !this.agz.aKE().getUserId().equals(this.joF.aKE().getUserId())) ? false : true;
    }

    public boolean aGZ() {
        return this.joJ;
    }

    public boolean hasMore() {
        return this.aCS < this.joH;
    }

    public bj aIw() {
        return this.agz;
    }

    public static l a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            l lVar = new l();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            lVar.b(antiData);
            bj bjVar = new bj();
            bjVar.a(dataRes.thread);
            lVar.setThreadData(bjVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            lVar.a(forumData);
            lVar.hBp = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.tS(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            lVar.f(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.tS(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            lVar.aL(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            lVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                lVar.setCurrentPage(intValue3);
                lVar.setPageSize(intValue2);
                lVar.setTotalCount(intValue4);
                lVar.zl(intValue);
            }
            return lVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
