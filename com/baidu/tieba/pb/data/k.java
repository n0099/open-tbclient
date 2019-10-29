package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes4.dex */
public class k {
    private int ZN;
    private int cHQ;
    private ForumData cHw;
    private bh cry;
    private AntiData cuS;
    public boolean fWY;
    public Error hJW;
    private int mPageSize = 20;
    private int hJU = -1;
    private boolean hJV = false;
    private PostData hJR = null;
    private ArrayList<PostData> hJS = new ArrayList<>();
    private int hJT = 1;

    public Error bRh() {
        return this.hJW;
    }

    public PostData bRi() {
        return this.hJR;
    }

    public void e(PostData postData) {
        this.hJR = postData;
    }

    public int bRj() {
        if (this.hJU == -1) {
            this.hJU = this.ZN;
        }
        return this.hJU;
    }

    public int bRk() {
        return this.hJU;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biZ());
            this.hJU = kVar.aBm();
            a(kVar.bRo());
            setPageSize(kVar.getPageSize());
            ai(kVar.agI());
            setTotalCount(kVar.getTotalCount());
            oW(kVar.bRn());
            this.hJS.addAll(0, kVar.bRm());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biZ());
            a(kVar.bRo());
            e(kVar.bRi());
            ai(kVar.agI());
            if (kVar.bRm() != null) {
                setCurrentPage(kVar.aBm());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                oW(kVar.bRn());
            }
            int size = this.hJS.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hJS.remove(this.hJS.size() - 1);
                }
            }
            this.hJS.addAll(kVar.bRm());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.biZ());
            a(kVar.bRo());
            e(kVar.bRi());
            ai(kVar.agI());
            if (kVar.bRm() != null && kVar.bRm().size() > 0) {
                setCurrentPage(kVar.aBm());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                oW(kVar.bRn());
            }
            int size = this.hJS.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hJS.remove(this.hJS.size() - 1);
                }
            }
            this.hJS.addAll(kVar.bRm());
            bRl();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.biZ());
            a(kVar.bRo());
            e(kVar.bRi());
            ai(kVar.agI());
            if (kVar.bRm() != null && kVar.bRm().size() > 0) {
                setCurrentPage(kVar.aBm());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                oW(kVar.bRn());
                this.hJU = (this.ZN - (((kVar.bRm().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.hJU < 0) {
                    this.hJU = 0;
                }
            }
            this.hJS.addAll(kVar.bRm());
        }
    }

    public void bRl() {
        if (this.hJU < 0) {
            this.hJU = this.ZN;
        } else if (this.hJU > this.ZN) {
            this.hJU = this.ZN;
        }
    }

    public ArrayList<PostData> bRm() {
        return this.hJS;
    }

    public void ay(ArrayList<PostData> arrayList) {
        this.hJS = arrayList;
    }

    public int bRn() {
        return this.hJT;
    }

    public void oW(int i) {
        this.hJT = i;
    }

    public int getTotalCount() {
        return this.cHQ;
    }

    public void setTotalCount(int i) {
        this.cHQ = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int aBm() {
        return this.ZN;
    }

    public void setCurrentPage(int i) {
        this.ZN = i;
    }

    public void a(ForumData forumData) {
        this.cHw = forumData;
    }

    public ForumData bRo() {
        return this.cHw;
    }

    public void b(AntiData antiData) {
        this.cuS = antiData;
    }

    public AntiData biZ() {
        return this.cuS;
    }

    public void ai(bh bhVar) {
        this.cry = bhVar;
    }

    public boolean bDy() {
        return (this.cry == null || this.hJR == null || this.cry.aiG() == null || this.cry.aiG().getUserId() == null || this.hJR.aiG() == null || this.hJR.aiG().getUserId() == null || !this.cry.aiG().getUserId().equals(this.hJR.aiG().getUserId())) ? false : true;
    }

    public boolean afm() {
        return this.hJV;
    }

    public boolean hasMore() {
        return this.ZN < this.hJT;
    }

    public bh agI() {
        return this.cry;
    }

    public static k a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            k kVar = new k();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            kVar.b(antiData);
            bh bhVar = new bh();
            bhVar.a(dataRes.thread);
            bhVar.setCurrentPage(2);
            kVar.ai(bhVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.a(forumData);
            kVar.fWY = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.qM(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            kVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.qM(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.ay(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            kVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                kVar.setCurrentPage(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.oW(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
