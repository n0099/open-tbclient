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
    private int aZN;
    private bw akq;
    private AntiData fcN;
    private int fqF;
    private ForumData fqn;
    public boolean jnh;
    public Error loC;
    private int mPageSize = 20;
    private int loA = -1;
    private boolean loB = false;
    private PostData lox = null;
    private ArrayList<PostData> loy = new ArrayList<>();
    private int loz = 1;

    public Error dje() {
        return this.loC;
    }

    public PostData dja() {
        return this.lox;
    }

    public void g(PostData postData) {
        this.lox = postData;
    }

    public int djf() {
        if (this.loA == -1) {
            this.loA = this.aZN;
        }
        return this.loA;
    }

    public int djg() {
        return this.loA;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cxn());
            this.loA = pVar.bHR();
            a(pVar.bAz());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.bjZ());
            setTotalCount(pVar.getTotalCount());
            FE(pVar.djj());
            this.loy.addAll(0, pVar.dji());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cxn());
            a(pVar.bAz());
            g(pVar.dja());
            setThreadData(pVar.bjZ());
            if (pVar.dji() != null) {
                setCurrentPage(pVar.bHR());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                FE(pVar.djj());
            }
            int size = this.loy.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.loy.remove(this.loy.size() - 1);
                }
            }
            this.loy.addAll(pVar.dji());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.cxn());
            a(pVar.bAz());
            g(pVar.dja());
            setThreadData(pVar.bjZ());
            if (pVar.dji() != null && pVar.dji().size() > 0) {
                setCurrentPage(pVar.bHR());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                FE(pVar.djj());
            }
            int size = this.loy.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.loy.remove(this.loy.size() - 1);
                }
            }
            this.loy.addAll(pVar.dji());
            djh();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.cxn());
            a(pVar.bAz());
            g(pVar.dja());
            setThreadData(pVar.bjZ());
            if (pVar.dji() != null && pVar.dji().size() > 0) {
                setCurrentPage(pVar.bHR());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                FE(pVar.djj());
                this.loA = (this.aZN - (((pVar.dji().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.loA < 0) {
                    this.loA = 0;
                }
            }
            this.loy.addAll(pVar.dji());
        }
    }

    public void djh() {
        if (this.loA < 0) {
            this.loA = this.aZN;
        } else if (this.loA > this.aZN) {
            this.loA = this.aZN;
        }
    }

    public ArrayList<PostData> dji() {
        return this.loy;
    }

    public void aY(ArrayList<PostData> arrayList) {
        this.loy = arrayList;
    }

    public int djj() {
        return this.loz;
    }

    public void FE(int i) {
        this.loz = i;
    }

    public int getTotalCount() {
        return this.fqF;
    }

    public void setTotalCount(int i) {
        this.fqF = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bHR() {
        return this.aZN;
    }

    public void setCurrentPage(int i) {
        this.aZN = i;
    }

    public void a(ForumData forumData) {
        this.fqn = forumData;
    }

    public ForumData bAz() {
        return this.fqn;
    }

    public void b(AntiData antiData) {
        this.fcN = antiData;
    }

    public AntiData cxn() {
        return this.fcN;
    }

    public void setThreadData(bw bwVar) {
        this.akq = bwVar;
    }

    public boolean Wq() {
        return (this.akq == null || this.lox == null || this.akq.bmA() == null || this.akq.bmA().getUserId() == null || this.lox.bmA() == null || this.lox.bmA().getUserId() == null || !this.akq.bmA().getUserId().equals(this.lox.bmA().getUserId())) ? false : true;
    }

    public boolean biv() {
        return this.loB;
    }

    public boolean hasMore() {
        return this.aZN < this.loz;
    }

    public bw bjZ() {
        return this.akq;
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
            pVar.jnh = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.xq(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            pVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.xq(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.bor() != null && postData2.bor().baijiahaoData == null && bwVar.getBaijiahaoData() != null) {
                    postData2.bor().baijiahaoData = bwVar.getBaijiahaoData();
                }
                arrayList.add(postData2);
            }
            pVar.aY(arrayList);
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
                pVar.FE(intValue);
            }
            return pVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
