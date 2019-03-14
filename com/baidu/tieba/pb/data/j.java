package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes4.dex */
public class j {
    private bg bTl;
    private AntiData bWP;
    private ForumData ckJ;
    private int cld;
    public boolean fzo;
    public Error hkV;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int hkT = -1;
    private boolean hkU = false;
    private PostData hkQ = null;
    private ArrayList<PostData> hkR = new ArrayList<>();
    private int hkS = 1;

    public Error bIC() {
        return this.hkV;
    }

    public PostData bID() {
        return this.hkQ;
    }

    public void e(PostData postData) {
        this.hkQ = postData;
    }

    public int bIE() {
        if (this.hkT == -1) {
            this.hkT = this.mCurrentPage;
        }
        return this.hkT;
    }

    public int bIF() {
        return this.hkT;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.bbI());
            this.hkT = jVar.auu();
            a(jVar.bIJ());
            setPageSize(jVar.getPageSize());
            aj(jVar.WR());
            setTotalCount(jVar.getTotalCount());
            oz(jVar.bII());
            this.hkR.addAll(0, jVar.bIH());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.bbI());
            a(jVar.bIJ());
            e(jVar.bID());
            aj(jVar.WR());
            if (jVar.bIH() != null) {
                setCurrentPage(jVar.auu());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                oz(jVar.bII());
            }
            int size = this.hkR.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hkR.remove(this.hkR.size() - 1);
                }
            }
            this.hkR.addAll(jVar.bIH());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.bbI());
            a(jVar.bIJ());
            e(jVar.bID());
            aj(jVar.WR());
            if (jVar.bIH() != null && jVar.bIH().size() > 0) {
                setCurrentPage(jVar.auu());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                oz(jVar.bII());
            }
            int size = this.hkR.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hkR.remove(this.hkR.size() - 1);
                }
            }
            this.hkR.addAll(jVar.bIH());
            bIG();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            b(jVar.bbI());
            a(jVar.bIJ());
            e(jVar.bID());
            aj(jVar.WR());
            if (jVar.bIH() != null && jVar.bIH().size() > 0) {
                setCurrentPage(jVar.auu());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                oz(jVar.bII());
                this.hkT = (this.mCurrentPage - (((jVar.bIH().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.hkT < 0) {
                    this.hkT = 0;
                }
            }
            this.hkR.addAll(jVar.bIH());
        }
    }

    public void bIG() {
        if (this.hkT < 0) {
            this.hkT = this.mCurrentPage;
        } else if (this.hkT > this.mCurrentPage) {
            this.hkT = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bIH() {
        return this.hkR;
    }

    public void aq(ArrayList<PostData> arrayList) {
        this.hkR = arrayList;
    }

    public int bII() {
        return this.hkS;
    }

    public void oz(int i) {
        this.hkS = i;
    }

    public int getTotalCount() {
        return this.cld;
    }

    public void setTotalCount(int i) {
        this.cld = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int auu() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.ckJ = forumData;
    }

    public ForumData bIJ() {
        return this.ckJ;
    }

    public void b(AntiData antiData) {
        this.bWP = antiData;
    }

    public AntiData bbI() {
        return this.bWP;
    }

    public void aj(bg bgVar) {
        this.bTl = bgVar;
    }

    public boolean bvu() {
        return (this.bTl == null || this.hkQ == null || this.bTl.YR() == null || this.bTl.YR().getUserId() == null || this.hkQ.YR() == null || this.hkQ.YR().getUserId() == null || !this.bTl.YR().getUserId().equals(this.hkQ.YR().getUserId())) ? false : true;
    }

    public boolean Vb() {
        return this.hkU;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.hkS;
    }

    public bg WR() {
        return this.bTl;
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
            bg bgVar = new bg();
            bgVar.a(dataRes.thread);
            bgVar.setCurrentPage(2);
            jVar.aj(bgVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            jVar.a(forumData);
            jVar.fzo = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.pU(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            jVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.pU(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            jVar.aq(arrayList);
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
                jVar.oz(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
