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
    private int aRK;
    private bw ajx;
    private AntiData eAl;
    private ForumData eMU;
    private int eNm;
    public boolean iyu;
    public Error kyn;
    private int mPageSize = 20;
    private int kyl = -1;
    private boolean kym = false;
    private PostData kyi = null;
    private ArrayList<PostData> kyj = new ArrayList<>();
    private int kyk = 1;

    public Error cWg() {
        return this.kyn;
    }

    public PostData cWh() {
        return this.kyi;
    }

    public void g(PostData postData) {
        this.kyi = postData;
    }

    public int cWi() {
        if (this.kyl == -1) {
            this.kyl = this.aRK;
        }
        return this.kyl;
    }

    public int cWj() {
        return this.kyl;
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.ckT());
            this.kyl = pVar.bzD();
            a(pVar.bss());
            setPageSize(pVar.getPageSize());
            setThreadData(pVar.bce());
            setTotalCount(pVar.getTotalCount());
            DR(pVar.cWm());
            this.kyj.addAll(0, pVar.cWl());
        }
    }

    public void b(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.ckT());
            a(pVar.bss());
            g(pVar.cWh());
            setThreadData(pVar.bce());
            if (pVar.cWl() != null) {
                setCurrentPage(pVar.bzD());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                DR(pVar.cWm());
            }
            int size = this.kyj.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kyj.remove(this.kyj.size() - 1);
                }
            }
            this.kyj.addAll(pVar.cWl());
        }
    }

    public void c(p pVar, boolean z) {
        if (pVar != null) {
            b(pVar.ckT());
            a(pVar.bss());
            g(pVar.cWh());
            setThreadData(pVar.bce());
            if (pVar.cWl() != null && pVar.cWl().size() > 0) {
                setCurrentPage(pVar.bzD());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                DR(pVar.cWm());
            }
            int size = this.kyj.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.kyj.remove(this.kyj.size() - 1);
                }
            }
            this.kyj.addAll(pVar.cWl());
            cWk();
        }
    }

    public void d(p pVar, boolean z) {
        a(pVar, z);
    }

    public void a(p pVar) {
        if (pVar != null) {
            b(pVar.ckT());
            a(pVar.bss());
            g(pVar.cWh());
            setThreadData(pVar.bce());
            if (pVar.cWl() != null && pVar.cWl().size() > 0) {
                setCurrentPage(pVar.bzD());
                setPageSize(pVar.getPageSize());
                setTotalCount(pVar.getTotalCount());
                DR(pVar.cWm());
                this.kyl = (this.aRK - (((pVar.cWl().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.kyl < 0) {
                    this.kyl = 0;
                }
            }
            this.kyj.addAll(pVar.cWl());
        }
    }

    public void cWk() {
        if (this.kyl < 0) {
            this.kyl = this.aRK;
        } else if (this.kyl > this.aRK) {
            this.kyl = this.aRK;
        }
    }

    public ArrayList<PostData> cWl() {
        return this.kyj;
    }

    public void aT(ArrayList<PostData> arrayList) {
        this.kyj = arrayList;
    }

    public int cWm() {
        return this.kyk;
    }

    public void DR(int i) {
        this.kyk = i;
    }

    public int getTotalCount() {
        return this.eNm;
    }

    public void setTotalCount(int i) {
        this.eNm = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bzD() {
        return this.aRK;
    }

    public void setCurrentPage(int i) {
        this.aRK = i;
    }

    public void a(ForumData forumData) {
        this.eMU = forumData;
    }

    public ForumData bss() {
        return this.eMU;
    }

    public void b(AntiData antiData) {
        this.eAl = antiData;
    }

    public AntiData ckT() {
        return this.eAl;
    }

    public void setThreadData(bw bwVar) {
        this.ajx = bwVar;
    }

    public boolean cHC() {
        return (this.ajx == null || this.kyi == null || this.ajx.beE() == null || this.ajx.beE().getUserId() == null || this.kyi.beE() == null || this.kyi.beE().getUserId() == null || !this.ajx.beE().getUserId().equals(this.kyi.beE().getUserId())) ? false : true;
    }

    public boolean baA() {
        return this.kym;
    }

    public boolean hasMore() {
        return this.aRK < this.kyk;
    }

    public bw bce() {
        return this.ajx;
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
            pVar.iyu = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.vY(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            pVar.g(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.vY(forumData.isBrandForum);
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
