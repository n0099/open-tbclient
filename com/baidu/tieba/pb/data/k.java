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
    private bh ccq;
    private AntiData cga;
    private int cuK;
    private ForumData cup;
    public boolean fVM;
    public Error hJt;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int hJr = -1;
    private boolean hJs = false;
    private PostData hJo = null;
    private ArrayList<PostData> hJp = new ArrayList<>();
    private int hJq = 1;

    public Error bTt() {
        return this.hJt;
    }

    public PostData bTu() {
        return this.hJo;
    }

    public void e(PostData postData) {
        this.hJo = postData;
    }

    public int bTv() {
        if (this.hJr == -1) {
            this.hJr = this.mCurrentPage;
        }
        return this.hJr;
    }

    public int bTw() {
        return this.hJr;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bli());
            this.hJr = kVar.aAN();
            a(kVar.bTA());
            setPageSize(kVar.getPageSize());
            aj(kVar.acy());
            setTotalCount(kVar.getTotalCount());
            pQ(kVar.bTz());
            this.hJp.addAll(0, kVar.bTy());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bli());
            a(kVar.bTA());
            e(kVar.bTu());
            aj(kVar.acy());
            if (kVar.bTy() != null) {
                setCurrentPage(kVar.aAN());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pQ(kVar.bTz());
            }
            int size = this.hJp.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hJp.remove(this.hJp.size() - 1);
                }
            }
            this.hJp.addAll(kVar.bTy());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bli());
            a(kVar.bTA());
            e(kVar.bTu());
            aj(kVar.acy());
            if (kVar.bTy() != null && kVar.bTy().size() > 0) {
                setCurrentPage(kVar.aAN());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pQ(kVar.bTz());
            }
            int size = this.hJp.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hJp.remove(this.hJp.size() - 1);
                }
            }
            this.hJp.addAll(kVar.bTy());
            bTx();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.bli());
            a(kVar.bTA());
            e(kVar.bTu());
            aj(kVar.acy());
            if (kVar.bTy() != null && kVar.bTy().size() > 0) {
                setCurrentPage(kVar.aAN());
                setPageSize(kVar.getPageSize());
                setTotalCount(kVar.getTotalCount());
                pQ(kVar.bTz());
                this.hJr = (this.mCurrentPage - (((kVar.bTy().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.hJr < 0) {
                    this.hJr = 0;
                }
            }
            this.hJp.addAll(kVar.bTy());
        }
    }

    public void bTx() {
        if (this.hJr < 0) {
            this.hJr = this.mCurrentPage;
        } else if (this.hJr > this.mCurrentPage) {
            this.hJr = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bTy() {
        return this.hJp;
    }

    public void au(ArrayList<PostData> arrayList) {
        this.hJp = arrayList;
    }

    public int bTz() {
        return this.hJq;
    }

    public void pQ(int i) {
        this.hJq = i;
    }

    public int getTotalCount() {
        return this.cuK;
    }

    public void setTotalCount(int i) {
        this.cuK = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int aAN() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.cup = forumData;
    }

    public ForumData bTA() {
        return this.cup;
    }

    public void b(AntiData antiData) {
        this.cga = antiData;
    }

    public AntiData bli() {
        return this.cga;
    }

    public void aj(bh bhVar) {
        this.ccq = bhVar;
    }

    public boolean bFZ() {
        return (this.ccq == null || this.hJo == null || this.ccq.aey() == null || this.ccq.aey().getUserId() == null || this.hJo.aey() == null || this.hJo.aey().getUserId() == null || !this.ccq.aey().getUserId().equals(this.hJo.aey().getUserId())) ? false : true;
    }

    public boolean aaB() {
        return this.hJs;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.hJq;
    }

    public bh acy() {
        return this.ccq;
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
            kVar.aj(bhVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.a(forumData);
            kVar.fVM = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.ra(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            kVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.ra(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.au(arrayList);
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
                kVar.pQ(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
