package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes22.dex */
public class p {
    private int aXa;
    private bw akp;
    private AntiData eOB;
    private ForumData fbW;
    private int fco;
    public boolean iUM;
    public Error kWc;
    private int mPageSize = 20;
    private int kWa = -1;
    private boolean kWb = false;
    private PostData kVX = null;
    private ArrayList<PostData> kVY = new ArrayList<>();
    private int kVZ = 1;

    public Error ddu() {
        return this.kWc;
    }

    public PostData ddq() {
        return this.kVX;
    }

    public void g(PostData postData) {
        this.kVX = postData;
    }

    public int ddv() {
        if (this.kWa == -1) {
            this.kWa = this.aXa;
        }
        return this.kWa;
    }

    public int ddw() {
        return this.kWa;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.crF());
            this.kWa = pVar.bDz();
            a(pVar.bwh());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.bfG());
            setTotalCount(pVar.getTotalCount());
            EY(pVar.ddz());
            this.kVY.addAll(0, pVar.ddy());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.crF());
            a(pVar.bwh());
            g(pVar.ddq());
            setThreadData(pVar.bfG());
            if (pVar.ddy() != null) {
                setCurrentPage(pVar.bDz());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                EY(pVar.ddz());
            }
            int size = this.kVY.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kVY.remove(this.kVY.size() - 1);
                }
            }
            this.kVY.addAll(pVar.ddy());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.crF());
            a(pVar.bwh());
            g(pVar.ddq());
            setThreadData(pVar.bfG());
            if (pVar.ddy() != null && pVar.ddy().size() > 0) {
                setCurrentPage(pVar.bDz());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                EY(pVar.ddz());
            }
            int size = this.kVY.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kVY.remove(this.kVY.size() - 1);
                }
            }
            this.kVY.addAll(pVar.ddy());
            ddx();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.crF());
            a(pVar.bwh());
            g(pVar.ddq());
            setThreadData(pVar.bfG());
            if (pVar.ddy() != null && pVar.ddy().size() > 0) {
                setCurrentPage(pVar.bDz());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                EY(pVar.ddz());
                this.kWa = (this.aXa - (((pVar.ddy().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.kWa < 0) {
                    this.kWa = 0;
                }
            }
            this.kVY.addAll(pVar.ddy());
        }
    }

    public void ddx() {
        if (this.kWa < 0) {
            this.kWa = this.aXa;
        } else if (this.kWa > this.aXa) {
            this.kWa = this.aXa;
        }
    }

    public ArrayList<PostData> ddy() {
        return this.kVY;
    }

    public void aV(ArrayList<PostData> arrayList) {
        this.kVY = arrayList;
    }

    public int ddz() {
        return this.kVZ;
    }

    public void EY(int i) {
        this.kVZ = i;
    }

    public int getTotalCount() {
        return this.fco;
    }

    public void setTotalCount(int i) {
        this.fco = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bDz() {
        return this.aXa;
    }

    public void setCurrentPage(int i) {
        this.aXa = i;
    }

    public void a(ForumData forumData) {
        this.fbW = forumData;
    }

    public ForumData bwh() {
        return this.fbW;
    }

    public void b(AntiData antiData) {
        this.eOB = antiData;
    }

    public AntiData crF() {
        return this.eOB;
    }

    public void setThreadData(bw bwVar) {
        this.akp = bwVar;
    }

    public boolean SR() {
        return (this.akp == null || this.kVX == null || this.akp.bih() == null || this.akp.bih().getUserId() == null || this.kVX.bih() == null || this.kVX.bih().getUserId() == null || !this.akp.bih().getUserId().equals(this.kVX.bih().getUserId())) ? false : true;
    }

    public boolean bec() {
        return this.kWb;
    }

    public boolean hasMore() {
        return this.aXa < this.kVZ;
    }

    public bw bfG() {
        return this.akp;
    }

    public static p a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            p pVar = new p();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            pVar.b(antiData);
            bw bwVar = new bw();
            bwVar.a(dataRes.thread);
            pVar.setThreadData(bwVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            pVar.a(forumData);
            pVar.iUM = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.wQ(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            pVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.wQ(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.bjY() != null && postData2.bjY().baijiahaoData == null && bwVar.getBaijiahaoData() != null) {
                    postData2.bjY().baijiahaoData = bwVar.getBaijiahaoData();
                }
                arrayList.add(postData2);
            }
            pVar.aV(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            pVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                pVar.setCurrentPage(intValue3);
                pVar.setPageSize(intValue2);
                pVar.setTotalCount(intValue4);
                pVar.EY(intValue);
            }
            return pVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
