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
    private bg bTk;
    private AntiData bWO;
    private ForumData ckJ;
    private int cld;
    public boolean fzp;
    public Error hkW;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int hkU = -1;
    private boolean hkV = false;
    private PostData hkR = null;
    private ArrayList<PostData> hkS = new ArrayList<>();
    private int hkT = 1;

    public Error bID() {
        return this.hkW;
    }

    public PostData bIE() {
        return this.hkR;
    }

    public void e(PostData postData) {
        this.hkR = postData;
    }

    public int bIF() {
        if (this.hkU == -1) {
            this.hkU = this.mCurrentPage;
        }
        return this.hkU;
    }

    public int bIG() {
        return this.hkU;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.bbJ());
            this.hkU = jVar.auv();
            a(jVar.bIK());
            setPageSize(jVar.getPageSize());
            aj(jVar.WR());
            setTotalCount(jVar.getTotalCount());
            oz(jVar.bIJ());
            this.hkS.addAll(0, jVar.bII());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.bbJ());
            a(jVar.bIK());
            e(jVar.bIE());
            aj(jVar.WR());
            if (jVar.bII() != null) {
                setCurrentPage(jVar.auv());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                oz(jVar.bIJ());
            }
            int size = this.hkS.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hkS.remove(this.hkS.size() - 1);
                }
            }
            this.hkS.addAll(jVar.bII());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.bbJ());
            a(jVar.bIK());
            e(jVar.bIE());
            aj(jVar.WR());
            if (jVar.bII() != null && jVar.bII().size() > 0) {
                setCurrentPage(jVar.auv());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                oz(jVar.bIJ());
            }
            int size = this.hkS.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hkS.remove(this.hkS.size() - 1);
                }
            }
            this.hkS.addAll(jVar.bII());
            bIH();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            b(jVar.bbJ());
            a(jVar.bIK());
            e(jVar.bIE());
            aj(jVar.WR());
            if (jVar.bII() != null && jVar.bII().size() > 0) {
                setCurrentPage(jVar.auv());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                oz(jVar.bIJ());
                this.hkU = (this.mCurrentPage - (((jVar.bII().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.hkU < 0) {
                    this.hkU = 0;
                }
            }
            this.hkS.addAll(jVar.bII());
        }
    }

    public void bIH() {
        if (this.hkU < 0) {
            this.hkU = this.mCurrentPage;
        } else if (this.hkU > this.mCurrentPage) {
            this.hkU = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bII() {
        return this.hkS;
    }

    public void aq(ArrayList<PostData> arrayList) {
        this.hkS = arrayList;
    }

    public int bIJ() {
        return this.hkT;
    }

    public void oz(int i) {
        this.hkT = i;
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

    public int auv() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.ckJ = forumData;
    }

    public ForumData bIK() {
        return this.ckJ;
    }

    public void b(AntiData antiData) {
        this.bWO = antiData;
    }

    public AntiData bbJ() {
        return this.bWO;
    }

    public void aj(bg bgVar) {
        this.bTk = bgVar;
    }

    public boolean bvv() {
        return (this.bTk == null || this.hkR == null || this.bTk.YR() == null || this.bTk.YR().getUserId() == null || this.hkR.YR() == null || this.hkR.YR().getUserId() == null || !this.bTk.YR().getUserId().equals(this.hkR.YR().getUserId())) ? false : true;
    }

    public boolean Vb() {
        return this.hkV;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.hkT;
    }

    public bg WR() {
        return this.bTk;
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
            jVar.fzp = forumData.isBrandForum;
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
