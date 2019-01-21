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
    private AntiData aOq;
    private bb bOl;
    private ForumData bbh;
    private int bbz;
    public boolean ekn;
    public Error fUJ;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int fUH = -1;
    private boolean fUI = false;
    private PostData fUE = null;
    private ArrayList<PostData> fUF = new ArrayList<>();
    private int fUG = 1;

    public Error bif() {
        return this.fUJ;
    }

    public PostData big() {
        return this.fUE;
    }

    public void e(PostData postData) {
        this.fUE = postData;
    }

    public int bih() {
        if (this.fUH == -1) {
            this.fUH = this.mCurrentPage;
        }
        return this.fUH;
    }

    public int bii() {
        return this.fUH;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.aBj());
            this.fUH = jVar.Uw();
            a(jVar.bim());
            setPageSize(jVar.getPageSize());
            aa(jVar.aaq());
            setTotalCount(jVar.getTotalCount());
            kX(jVar.bil());
            this.fUF.addAll(0, jVar.bik());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.aBj());
            a(jVar.bim());
            e(jVar.big());
            aa(jVar.aaq());
            if (jVar.bik() != null) {
                setCurrentPage(jVar.Uw());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kX(jVar.bil());
            }
            int size = this.fUF.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.fUF.remove(this.fUF.size() - 1);
                }
            }
            this.fUF.addAll(jVar.bik());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.aBj());
            a(jVar.bim());
            e(jVar.big());
            aa(jVar.aaq());
            if (jVar.bik() != null && jVar.bik().size() > 0) {
                setCurrentPage(jVar.Uw());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kX(jVar.bil());
            }
            int size = this.fUF.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.fUF.remove(this.fUF.size() - 1);
                }
            }
            this.fUF.addAll(jVar.bik());
            bij();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            b(jVar.aBj());
            a(jVar.bim());
            e(jVar.big());
            aa(jVar.aaq());
            if (jVar.bik() != null && jVar.bik().size() > 0) {
                setCurrentPage(jVar.Uw());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kX(jVar.bil());
                this.fUH = (this.mCurrentPage - (((jVar.bik().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.fUH < 0) {
                    this.fUH = 0;
                }
            }
            this.fUF.addAll(jVar.bik());
        }
    }

    public void bij() {
        if (this.fUH < 0) {
            this.fUH = this.mCurrentPage;
        } else if (this.fUH > this.mCurrentPage) {
            this.fUH = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bik() {
        return this.fUF;
    }

    public void am(ArrayList<PostData> arrayList) {
        this.fUF = arrayList;
    }

    public int bil() {
        return this.fUG;
    }

    public void kX(int i) {
        this.fUG = i;
    }

    public int getTotalCount() {
        return this.bbz;
    }

    public void setTotalCount(int i) {
        this.bbz = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int Uw() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.bbh = forumData;
    }

    public ForumData bim() {
        return this.bbh;
    }

    public void b(AntiData antiData) {
        this.aOq = antiData;
    }

    public AntiData aBj() {
        return this.aOq;
    }

    public void aa(bb bbVar) {
        this.bOl = bbVar;
    }

    public boolean aUP() {
        return (this.bOl == null || this.fUE == null || this.bOl.zT() == null || this.bOl.zT().getUserId() == null || this.fUE.zT() == null || this.fUE.zT().getUserId() == null || !this.bOl.zT().getUserId().equals(this.fUE.zT().getUserId())) ? false : true;
    }

    public boolean wx() {
        return this.fUI;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fUG;
    }

    public bb aaq() {
        return this.bOl;
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
            jVar.ekn = forumData.isBrandForum;
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
                jVar.kX(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
