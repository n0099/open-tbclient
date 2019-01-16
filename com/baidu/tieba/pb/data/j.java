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
    private AntiData aOp;
    private bb bOk;
    private ForumData bbg;
    private int bby;
    public boolean ekm;
    public Error fUI;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int fUG = -1;
    private boolean fUH = false;
    private PostData fUD = null;
    private ArrayList<PostData> fUE = new ArrayList<>();
    private int fUF = 1;

    public Error bif() {
        return this.fUI;
    }

    public PostData big() {
        return this.fUD;
    }

    public void e(PostData postData) {
        this.fUD = postData;
    }

    public int bih() {
        if (this.fUG == -1) {
            this.fUG = this.mCurrentPage;
        }
        return this.fUG;
    }

    public int bii() {
        return this.fUG;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.aBj());
            this.fUG = jVar.Uw();
            a(jVar.bim());
            setPageSize(jVar.getPageSize());
            aa(jVar.aaq());
            setTotalCount(jVar.getTotalCount());
            kX(jVar.bil());
            this.fUE.addAll(0, jVar.bik());
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
            int size = this.fUE.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.fUE.remove(this.fUE.size() - 1);
                }
            }
            this.fUE.addAll(jVar.bik());
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
            int size = this.fUE.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.fUE.remove(this.fUE.size() - 1);
                }
            }
            this.fUE.addAll(jVar.bik());
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
                this.fUG = (this.mCurrentPage - (((jVar.bik().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.fUG < 0) {
                    this.fUG = 0;
                }
            }
            this.fUE.addAll(jVar.bik());
        }
    }

    public void bij() {
        if (this.fUG < 0) {
            this.fUG = this.mCurrentPage;
        } else if (this.fUG > this.mCurrentPage) {
            this.fUG = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bik() {
        return this.fUE;
    }

    public void am(ArrayList<PostData> arrayList) {
        this.fUE = arrayList;
    }

    public int bil() {
        return this.fUF;
    }

    public void kX(int i) {
        this.fUF = i;
    }

    public int getTotalCount() {
        return this.bby;
    }

    public void setTotalCount(int i) {
        this.bby = i;
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
        this.bbg = forumData;
    }

    public ForumData bim() {
        return this.bbg;
    }

    public void b(AntiData antiData) {
        this.aOp = antiData;
    }

    public AntiData aBj() {
        return this.aOp;
    }

    public void aa(bb bbVar) {
        this.bOk = bbVar;
    }

    public boolean aUP() {
        return (this.bOk == null || this.fUD == null || this.bOk.zT() == null || this.bOk.zT().getUserId() == null || this.fUD.zT() == null || this.fUD.zT().getUserId() == null || !this.bOk.zT().getUserId().equals(this.fUD.zT().getUserId())) ? false : true;
    }

    public boolean wx() {
        return this.fUH;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fUF;
    }

    public bb aaq() {
        return this.bOk;
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
            jVar.ekm = forumData.isBrandForum;
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
