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
    private AntiData aNN;
    private bb bNy;
    private int baO;
    private ForumData baw;
    public boolean ejG;
    public Error fTL;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int fTJ = -1;
    private boolean fTK = false;
    private PostData fTG = null;
    private ArrayList<PostData> fTH = new ArrayList<>();
    private int fTI = 1;

    public Error bhB() {
        return this.fTL;
    }

    public PostData bhC() {
        return this.fTG;
    }

    public void e(PostData postData) {
        this.fTG = postData;
    }

    public int bhD() {
        if (this.fTJ == -1) {
            this.fTJ = this.mCurrentPage;
        }
        return this.fTJ;
    }

    public int bhE() {
        return this.fTJ;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.aAM());
            this.fTJ = jVar.Ua();
            a(jVar.bhI());
            setPageSize(jVar.getPageSize());
            aa(jVar.ZT());
            setTotalCount(jVar.getTotalCount());
            kW(jVar.bhH());
            this.fTH.addAll(0, jVar.bhG());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.aAM());
            a(jVar.bhI());
            e(jVar.bhC());
            aa(jVar.ZT());
            if (jVar.bhG() != null) {
                setCurrentPage(jVar.Ua());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kW(jVar.bhH());
            }
            int size = this.fTH.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.fTH.remove(this.fTH.size() - 1);
                }
            }
            this.fTH.addAll(jVar.bhG());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.aAM());
            a(jVar.bhI());
            e(jVar.bhC());
            aa(jVar.ZT());
            if (jVar.bhG() != null && jVar.bhG().size() > 0) {
                setCurrentPage(jVar.Ua());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kW(jVar.bhH());
            }
            int size = this.fTH.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.fTH.remove(this.fTH.size() - 1);
                }
            }
            this.fTH.addAll(jVar.bhG());
            bhF();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            b(jVar.aAM());
            a(jVar.bhI());
            e(jVar.bhC());
            aa(jVar.ZT());
            if (jVar.bhG() != null && jVar.bhG().size() > 0) {
                setCurrentPage(jVar.Ua());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kW(jVar.bhH());
                this.fTJ = (this.mCurrentPage - (((jVar.bhG().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.fTJ < 0) {
                    this.fTJ = 0;
                }
            }
            this.fTH.addAll(jVar.bhG());
        }
    }

    public void bhF() {
        if (this.fTJ < 0) {
            this.fTJ = this.mCurrentPage;
        } else if (this.fTJ > this.mCurrentPage) {
            this.fTJ = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bhG() {
        return this.fTH;
    }

    public void am(ArrayList<PostData> arrayList) {
        this.fTH = arrayList;
    }

    public int bhH() {
        return this.fTI;
    }

    public void kW(int i) {
        this.fTI = i;
    }

    public int getTotalCount() {
        return this.baO;
    }

    public void setTotalCount(int i) {
        this.baO = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int Ua() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.baw = forumData;
    }

    public ForumData bhI() {
        return this.baw;
    }

    public void b(AntiData antiData) {
        this.aNN = antiData;
    }

    public AntiData aAM() {
        return this.aNN;
    }

    public void aa(bb bbVar) {
        this.bNy = bbVar;
    }

    public boolean aUp() {
        return (this.bNy == null || this.fTG == null || this.bNy.zG() == null || this.bNy.zG().getUserId() == null || this.fTG.zG() == null || this.fTG.zG().getUserId() == null || !this.bNy.zG().getUserId().equals(this.fTG.zG().getUserId())) ? false : true;
    }

    public boolean wq() {
        return this.fTK;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fTI;
    }

    public bb ZT() {
        return this.bNy;
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
            jVar.ejG = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.kA(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            jVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.kA(forumData.isBrandForum);
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
                jVar.kW(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
