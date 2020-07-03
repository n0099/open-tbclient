package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes9.dex */
public class n {
    private int aLb;
    private bu aiq;
    private AntiData ejE;
    private ForumData ewc;
    private int ewu;
    public boolean ieq;
    public Error kan;
    private int mPageSize = 20;
    private int kal = -1;
    private boolean kam = false;
    private PostData kai = null;
    private ArrayList<PostData> kaj = new ArrayList<>();
    private int kak = 1;

    public Error cHH() {
        return this.kan;
    }

    public PostData cHI() {
        return this.kai;
    }

    public void g(PostData postData) {
        this.kai = postData;
    }

    public int cHJ() {
        if (this.kal == -1) {
            this.kal = this.aLb;
        }
        return this.kal;
    }

    public int cHK() {
        return this.kal;
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            b(nVar.bXd());
            this.kal = nVar.bmK();
            a(nVar.bfV());
            setPageSize(nVar.getPageSize());
            setThreadData(nVar.aPS());
            setTotalCount(nVar.getTotalCount());
            AZ(nVar.cHN());
            this.kaj.addAll(0, nVar.cHM());
        }
    }

    public void b(n nVar, boolean z) {
        if (nVar != null) {
            b(nVar.bXd());
            a(nVar.bfV());
            g(nVar.cHI());
            setThreadData(nVar.aPS());
            if (nVar.cHM() != null) {
                setCurrentPage(nVar.bmK());
                setPageSize(nVar.getPageSize());
                setTotalCount(nVar.getTotalCount());
                AZ(nVar.cHN());
            }
            int size = this.kaj.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kaj.remove(this.kaj.size() - 1);
                }
            }
            this.kaj.addAll(nVar.cHM());
        }
    }

    public void c(n nVar, boolean z) {
        if (nVar != null) {
            b(nVar.bXd());
            a(nVar.bfV());
            g(nVar.cHI());
            setThreadData(nVar.aPS());
            if (nVar.cHM() != null && nVar.cHM().size() > 0) {
                setCurrentPage(nVar.bmK());
                setPageSize(nVar.getPageSize());
                setTotalCount(nVar.getTotalCount());
                AZ(nVar.cHN());
            }
            int size = this.kaj.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kaj.remove(this.kaj.size() - 1);
                }
            }
            this.kaj.addAll(nVar.cHM());
            cHL();
        }
    }

    public void d(n nVar, boolean z) {
        a(nVar, z);
    }

    public void a(n nVar) {
        if (nVar != null) {
            b(nVar.bXd());
            a(nVar.bfV());
            g(nVar.cHI());
            setThreadData(nVar.aPS());
            if (nVar.cHM() != null && nVar.cHM().size() > 0) {
                setCurrentPage(nVar.bmK());
                setPageSize(nVar.getPageSize());
                setTotalCount(nVar.getTotalCount());
                AZ(nVar.cHN());
                this.kal = (this.aLb - (((nVar.cHM().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.kal < 0) {
                    this.kal = 0;
                }
            }
            this.kaj.addAll(nVar.cHM());
        }
    }

    public void cHL() {
        if (this.kal < 0) {
            this.kal = this.aLb;
        } else if (this.kal > this.aLb) {
            this.kal = this.aLb;
        }
    }

    public ArrayList<PostData> cHM() {
        return this.kaj;
    }

    public void aM(ArrayList<PostData> arrayList) {
        this.kaj = arrayList;
    }

    public int cHN() {
        return this.kak;
    }

    public void AZ(int i) {
        this.kak = i;
    }

    public int getTotalCount() {
        return this.ewu;
    }

    public void setTotalCount(int i) {
        this.ewu = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bmK() {
        return this.aLb;
    }

    public void setCurrentPage(int i) {
        this.aLb = i;
    }

    public void a(ForumData forumData) {
        this.ewc = forumData;
    }

    public ForumData bfV() {
        return this.ewc;
    }

    public void b(AntiData antiData) {
        this.ejE = antiData;
    }

    public AntiData bXd() {
        return this.ejE;
    }

    public void setThreadData(bu buVar) {
        this.aiq = buVar;
    }

    public boolean csI() {
        return (this.aiq == null || this.kai == null || this.aiq.aSp() == null || this.aiq.aSp().getUserId() == null || this.kai.aSp() == null || this.kai.aSp().getUserId() == null || !this.aiq.aSp().getUserId().equals(this.kai.aSp().getUserId())) ? false : true;
    }

    public boolean aOo() {
        return this.kam;
    }

    public boolean hasMore() {
        return this.aLb < this.kak;
    }

    public bu aPS() {
        return this.aiq;
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
            bu buVar = new bu();
            buVar.a(dataRes.thread);
            nVar.setThreadData(buVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            nVar.a(forumData);
            nVar.ieq = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.uF(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            nVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.uF(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.aUg() != null && postData2.aUg().baijiahaoData == null && buVar.getBaijiahaoData() != null) {
                    postData2.aUg().baijiahaoData = buVar.getBaijiahaoData();
                }
                arrayList.add(postData2);
            }
            nVar.aM(arrayList);
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
                nVar.AZ(intValue);
            }
            return nVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
