package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class q {
    private cb amn;
    private int bcY;
    private ForumData fFL;
    private int fGd;
    private AntiData fsl;
    public boolean jSk;
    public Error lNX;
    private int mPageSize = 20;
    private int lNV = -1;
    private boolean lNW = false;
    private PostData lNS = null;
    private ArrayList<PostData> lNT = new ArrayList<>();
    private int lNU = 1;

    public Error dmm() {
        return this.lNX;
    }

    public PostData dmh() {
        return this.lNS;
    }

    public void g(PostData postData) {
        this.lNS = postData;
    }

    public int dmn() {
        if (this.lNV == -1) {
            this.lNV = this.bcY;
        }
        return this.lNV;
    }

    public int dmo() {
        return this.lNV;
    }

    public void a(q qVar, boolean z) {
        if (qVar != null) {
            b(qVar.cBF());
            this.lNV = qVar.bJO();
            a(qVar.bCn());
            setPageSize(qVar.getPageSize());
            setThreadData(qVar.blp());
            setTotalCount(qVar.getTotalCount());
            Fz(qVar.dmr());
            this.lNT.addAll(0, qVar.dmq());
        }
    }

    public void b(q qVar, boolean z) {
        if (qVar != null) {
            b(qVar.cBF());
            a(qVar.bCn());
            g(qVar.dmh());
            setThreadData(qVar.blp());
            if (qVar.dmq() != null) {
                setCurrentPage(qVar.bJO());
                setPageSize(qVar.getPageSize());
                setTotalCount(qVar.getTotalCount());
                Fz(qVar.dmr());
            }
            int size = this.lNT.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lNT.remove(this.lNT.size() - 1);
                }
            }
            this.lNT.addAll(qVar.dmq());
        }
    }

    public void c(q qVar, boolean z) {
        if (qVar != null) {
            b(qVar.cBF());
            a(qVar.bCn());
            g(qVar.dmh());
            setThreadData(qVar.blp());
            if (qVar.dmq() != null && qVar.dmq().size() > 0) {
                setCurrentPage(qVar.bJO());
                setPageSize(qVar.getPageSize());
                setTotalCount(qVar.getTotalCount());
                Fz(qVar.dmr());
            }
            int size = this.lNT.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.lNT.remove(this.lNT.size() - 1);
                }
            }
            this.lNT.addAll(qVar.dmq());
            dmp();
        }
    }

    public void d(q qVar, boolean z) {
        a(qVar, z);
    }

    public void a(q qVar) {
        if (qVar != null) {
            b(qVar.cBF());
            a(qVar.bCn());
            g(qVar.dmh());
            setThreadData(qVar.blp());
            if (qVar.dmq() != null && qVar.dmq().size() > 0) {
                setCurrentPage(qVar.bJO());
                setPageSize(qVar.getPageSize());
                setTotalCount(qVar.getTotalCount());
                Fz(qVar.dmr());
                this.lNV = (this.bcY - (((qVar.dmq().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.lNV < 0) {
                    this.lNV = 0;
                }
            }
            this.lNT.addAll(qVar.dmq());
        }
    }

    public void dmp() {
        if (this.lNV < 0) {
            this.lNV = this.bcY;
        } else if (this.lNV > this.bcY) {
            this.lNV = this.bcY;
        }
    }

    public ArrayList<PostData> dmq() {
        return this.lNT;
    }

    public void aV(ArrayList<PostData> arrayList) {
        this.lNT = arrayList;
    }

    public int dmr() {
        return this.lNU;
    }

    public void Fz(int i) {
        this.lNU = i;
    }

    public int getTotalCount() {
        return this.fGd;
    }

    public void setTotalCount(int i) {
        this.fGd = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bJO() {
        return this.bcY;
    }

    public void setCurrentPage(int i) {
        this.bcY = i;
    }

    public void a(ForumData forumData) {
        this.fFL = forumData;
    }

    public ForumData bCn() {
        return this.fFL;
    }

    public void b(AntiData antiData) {
        this.fsl = antiData;
    }

    public AntiData cBF() {
        return this.fsl;
    }

    public void setThreadData(cb cbVar) {
        this.amn = cbVar;
    }

    public boolean Xj() {
        return (this.amn == null || this.lNS == null || this.amn.bnS() == null || this.amn.bnS().getUserId() == null || this.lNS.bnS() == null || this.lNS.bnS().getUserId() == null || !this.amn.bnS().getUserId().equals(this.lNS.bnS().getUserId())) ? false : true;
    }

    public boolean bkb() {
        return this.lNW;
    }

    public boolean hasMore() {
        return this.bcY < this.lNU;
    }

    public cb blp() {
        return this.amn;
    }

    public static q a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            q qVar = new q();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            qVar.b(antiData);
            cb cbVar = new cb();
            cbVar.a(dataRes.thread);
            qVar.setThreadData(cbVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            qVar.a(forumData);
            qVar.jSk = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.yr(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            qVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.yr(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.bpL() != null && postData2.bpL().baijiahaoData == null && cbVar.getBaijiahaoData() != null) {
                    postData2.bpL().baijiahaoData = cbVar.getBaijiahaoData();
                }
                arrayList.add(postData2);
            }
            qVar.aV(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            qVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                qVar.setCurrentPage(intValue3);
                qVar.setPageSize(intValue2);
                qVar.setTotalCount(intValue4);
                qVar.Fz(intValue);
            }
            return qVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
