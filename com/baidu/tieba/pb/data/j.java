package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes6.dex */
public class j {
    private AntiData aKm;
    private ForumData aWV;
    private int aXn;
    private bb bJG;
    public boolean eam;
    public Error fKd;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int fKb = -1;
    private boolean fKc = false;
    private PostData fJY = null;
    private ArrayList<PostData> fJZ = new ArrayList<>();
    private int fKa = 1;

    public Error beZ() {
        return this.fKd;
    }

    public PostData bfa() {
        return this.fJY;
    }

    public void e(PostData postData) {
        this.fJY = postData;
    }

    public int bfb() {
        if (this.fKb == -1) {
            this.fKb = this.mCurrentPage;
        }
        return this.fKb;
    }

    public int bfc() {
        return this.fKb;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.ayn());
            this.fKb = jVar.SS();
            a(jVar.bfg());
            setPageSize(jVar.getPageSize());
            aa(jVar.YL());
            setTotalCount(jVar.getTotalCount());
            kt(jVar.bff());
            this.fJZ.addAll(0, jVar.bfe());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.ayn());
            a(jVar.bfg());
            e(jVar.bfa());
            aa(jVar.YL());
            if (jVar.bfe() != null) {
                setCurrentPage(jVar.SS());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kt(jVar.bff());
            }
            int size = this.fJZ.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.fJZ.remove(this.fJZ.size() - 1);
                }
            }
            this.fJZ.addAll(jVar.bfe());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.ayn());
            a(jVar.bfg());
            e(jVar.bfa());
            aa(jVar.YL());
            if (jVar.bfe() != null && jVar.bfe().size() > 0) {
                setCurrentPage(jVar.SS());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kt(jVar.bff());
            }
            int size = this.fJZ.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.fJZ.remove(this.fJZ.size() - 1);
                }
            }
            this.fJZ.addAll(jVar.bfe());
            bfd();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            b(jVar.ayn());
            a(jVar.bfg());
            e(jVar.bfa());
            aa(jVar.YL());
            if (jVar.bfe() != null && jVar.bfe().size() > 0) {
                setCurrentPage(jVar.SS());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kt(jVar.bff());
                this.fKb = (this.mCurrentPage - (((jVar.bfe().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.fKb < 0) {
                    this.fKb = 0;
                }
            }
            this.fJZ.addAll(jVar.bfe());
        }
    }

    public void bfd() {
        if (this.fKb < 0) {
            this.fKb = this.mCurrentPage;
        } else if (this.fKb > this.mCurrentPage) {
            this.fKb = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bfe() {
        return this.fJZ;
    }

    public void am(ArrayList<PostData> arrayList) {
        this.fJZ = arrayList;
    }

    public int bff() {
        return this.fKa;
    }

    public void kt(int i) {
        this.fKa = i;
    }

    public int getTotalCount() {
        return this.aXn;
    }

    public void setTotalCount(int i) {
        this.aXn = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int SS() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.aWV = forumData;
    }

    public ForumData bfg() {
        return this.aWV;
    }

    public void b(AntiData antiData) {
        this.aKm = antiData;
    }

    public AntiData ayn() {
        return this.aKm;
    }

    public void aa(bb bbVar) {
        this.bJG = bbVar;
    }

    public boolean aRK() {
        return (this.bJG == null || this.fJY == null || this.bJG.yC() == null || this.bJG.yC().getUserId() == null || this.fJY.yC() == null || this.fJY.yC().getUserId() == null || !this.bJG.yC().getUserId().equals(this.fJY.yC().getUserId())) ? false : true;
    }

    public boolean vm() {
        return this.fKc;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fKa;
    }

    public bb YL() {
        return this.bJG;
    }

    public static j a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            j jVar = new j();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            jVar.b(antiData);
            bb bbVar = new bb();
            bbVar.a(dataRes.thread);
            bbVar.setCurrentPage(2);
            jVar.aa(bbVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            jVar.a(forumData);
            jVar.eam = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.ku(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            jVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.ku(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            jVar.am(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            jVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                jVar.setCurrentPage(intValue3);
                jVar.setPageSize(intValue2);
                jVar.setTotalCount(intValue4);
                jVar.kt(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
