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
/* loaded from: classes21.dex */
public class p {
    private int aTP;
    private bw ajX;
    private AntiData eCu;
    private ForumData ePP;
    private int eQh;
    public boolean iFW;
    public Error kGR;
    private int mPageSize = 20;
    private int kGP = -1;
    private boolean kGQ = false;
    private PostData kGM = null;
    private ArrayList<PostData> kGN = new ArrayList<>();
    private int kGO = 1;

    public Error cZL() {
        return this.kGR;
    }

    public PostData cZH() {
        return this.kGM;
    }

    public void g(PostData postData) {
        this.kGM = postData;
    }

    public int cZM() {
        if (this.kGP == -1) {
            this.kGP = this.aTP;
        }
        return this.kGP;
    }

    public int cZN() {
        return this.kGP;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.coh());
            this.kGP = pVar.bAN();
            a(pVar.btx());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.bcY());
            setTotalCount(pVar.getTotalCount());
            Es(pVar.cZQ());
            this.kGN.addAll(0, pVar.cZP());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.coh());
            a(pVar.btx());
            g(pVar.cZH());
            setThreadData(pVar.bcY());
            if (pVar.cZP() != null) {
                setCurrentPage(pVar.bAN());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Es(pVar.cZQ());
            }
            int size = this.kGN.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kGN.remove(this.kGN.size() - 1);
                }
            }
            this.kGN.addAll(pVar.cZP());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.coh());
            a(pVar.btx());
            g(pVar.cZH());
            setThreadData(pVar.bcY());
            if (pVar.cZP() != null && pVar.cZP().size() > 0) {
                setCurrentPage(pVar.bAN());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Es(pVar.cZQ());
            }
            int size = this.kGN.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kGN.remove(this.kGN.size() - 1);
                }
            }
            this.kGN.addAll(pVar.cZP());
            cZO();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.coh());
            a(pVar.btx());
            g(pVar.cZH());
            setThreadData(pVar.bcY());
            if (pVar.cZP() != null && pVar.cZP().size() > 0) {
                setCurrentPage(pVar.bAN());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                Es(pVar.cZQ());
                this.kGP = (this.aTP - (((pVar.cZP().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.kGP < 0) {
                    this.kGP = 0;
                }
            }
            this.kGN.addAll(pVar.cZP());
        }
    }

    public void cZO() {
        if (this.kGP < 0) {
            this.kGP = this.aTP;
        } else if (this.kGP > this.aTP) {
            this.kGP = this.aTP;
        }
    }

    public ArrayList<PostData> cZP() {
        return this.kGN;
    }

    public void aV(ArrayList<PostData> arrayList) {
        this.kGN = arrayList;
    }

    public int cZQ() {
        return this.kGO;
    }

    public void Es(int i) {
        this.kGO = i;
    }

    public int getTotalCount() {
        return this.eQh;
    }

    public void setTotalCount(int i) {
        this.eQh = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bAN() {
        return this.aTP;
    }

    public void setCurrentPage(int i) {
        this.aTP = i;
    }

    public void a(ForumData forumData) {
        this.ePP = forumData;
    }

    public ForumData btx() {
        return this.ePP;
    }

    public void b(AntiData antiData) {
        this.eCu = antiData;
    }

    public AntiData coh() {
        return this.eCu;
    }

    public void setThreadData(bw bwVar) {
        this.ajX = bwVar;
    }

    public boolean cLj() {
        return (this.ajX == null || this.kGM == null || this.ajX.bfy() == null || this.ajX.bfy().getUserId() == null || this.kGM.bfy() == null || this.kGM.bfy().getUserId() == null || !this.ajX.bfy().getUserId().equals(this.kGM.bfy().getUserId())) ? false : true;
    }

    public boolean bbu() {
        return this.kGQ;
    }

    public boolean hasMore() {
        return this.aTP < this.kGO;
    }

    public bw bcY() {
        return this.ajX;
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
            pVar.iFW = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.wj(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            pVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.wj(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.bhp() != null && postData2.bhp().baijiahaoData == null && bwVar.getBaijiahaoData() != null) {
                    postData2.bhp().baijiahaoData = bwVar.getBaijiahaoData();
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
                pVar.Es(intValue);
            }
            return pVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
