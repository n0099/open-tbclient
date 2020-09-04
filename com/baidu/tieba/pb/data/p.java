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
/* loaded from: classes16.dex */
public class p {
    private int aRM;
    private bw ajz;
    private AntiData eAp;
    private ForumData eMY;
    private int eNq;
    public boolean iyA;
    public Error kyu;
    private int mPageSize = 20;
    private int kys = -1;
    private boolean kyt = false;
    private PostData kyp = null;
    private ArrayList<PostData> kyq = new ArrayList<>();
    private int kyr = 1;

    public Error cWh() {
        return this.kyu;
    }

    public PostData cWi() {
        return this.kyp;
    }

    public void g(PostData postData) {
        this.kyp = postData;
    }

    public int cWj() {
        if (this.kys == -1) {
            this.kys = this.aRM;
        }
        return this.kys;
    }

    public int cWk() {
        return this.kys;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.ckU());
            this.kys = pVar.bzE();
            a(pVar.bst());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.bce());
            setTotalCount(pVar.getTotalCount());
            DR(pVar.cWn());
            this.kyq.addAll(0, pVar.cWm());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.ckU());
            a(pVar.bst());
            g(pVar.cWi());
            setThreadData(pVar.bce());
            if (pVar.cWm() != null) {
                setCurrentPage(pVar.bzE());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                DR(pVar.cWn());
            }
            int size = this.kyq.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kyq.remove(this.kyq.size() - 1);
                }
            }
            this.kyq.addAll(pVar.cWm());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.ckU());
            a(pVar.bst());
            g(pVar.cWi());
            setThreadData(pVar.bce());
            if (pVar.cWm() != null && pVar.cWm().size() > 0) {
                setCurrentPage(pVar.bzE());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                DR(pVar.cWn());
            }
            int size = this.kyq.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kyq.remove(this.kyq.size() - 1);
                }
            }
            this.kyq.addAll(pVar.cWm());
            cWl();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.ckU());
            a(pVar.bst());
            g(pVar.cWi());
            setThreadData(pVar.bce());
            if (pVar.cWm() != null && pVar.cWm().size() > 0) {
                setCurrentPage(pVar.bzE());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                DR(pVar.cWn());
                this.kys = (this.aRM - (((pVar.cWm().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.kys < 0) {
                    this.kys = 0;
                }
            }
            this.kyq.addAll(pVar.cWm());
        }
    }

    public void cWl() {
        if (this.kys < 0) {
            this.kys = this.aRM;
        } else if (this.kys > this.aRM) {
            this.kys = this.aRM;
        }
    }

    public ArrayList<PostData> cWm() {
        return this.kyq;
    }

    public void aT(ArrayList<PostData> arrayList) {
        this.kyq = arrayList;
    }

    public int cWn() {
        return this.kyr;
    }

    public void DR(int i) {
        this.kyr = i;
    }

    public int getTotalCount() {
        return this.eNq;
    }

    public void setTotalCount(int i) {
        this.eNq = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bzE() {
        return this.aRM;
    }

    public void setCurrentPage(int i) {
        this.aRM = i;
    }

    public void a(ForumData forumData) {
        this.eMY = forumData;
    }

    public ForumData bst() {
        return this.eMY;
    }

    public void b(AntiData antiData) {
        this.eAp = antiData;
    }

    public AntiData ckU() {
        return this.eAp;
    }

    public void setThreadData(bw bwVar) {
        this.ajz = bwVar;
    }

    public boolean cHD() {
        return (this.ajz == null || this.kyp == null || this.ajz.beE() == null || this.ajz.beE().getUserId() == null || this.kyp.beE() == null || this.kyp.beE().getUserId() == null || !this.ajz.beE().getUserId().equals(this.kyp.beE().getUserId())) ? false : true;
    }

    public boolean baA() {
        return this.kyt;
    }

    public boolean hasMore() {
        return this.aRM < this.kyr;
    }

    public bw bce() {
        return this.ajz;
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
            pVar.iyA = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.wa(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            pVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.wa(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                if (postData2.bgv() != null && postData2.bgv().baijiahaoData == null && bwVar.getBaijiahaoData() != null) {
                    postData2.bgv().baijiahaoData = bwVar.getBaijiahaoData();
                }
                arrayList.add(postData2);
            }
            pVar.aT(arrayList);
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
                pVar.DR(intValue);
            }
            return pVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
