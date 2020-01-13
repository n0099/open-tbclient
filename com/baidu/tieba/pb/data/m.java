package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes7.dex */
public class m {
    private bj Np;
    private int aic;
    private AntiData dhW;
    private ForumData duJ;
    public boolean gNS;
    public Error iAW;
    private int mTotalCount;
    private int mPageSize = 20;
    private int iAU = -1;
    private boolean iAV = false;
    private PostData iAR = null;
    private ArrayList<PostData> iAS = new ArrayList<>();
    private int iAT = 1;

    public Error cjE() {
        return this.iAW;
    }

    public PostData cjF() {
        return this.iAR;
    }

    public void f(PostData postData) {
        this.iAR = postData;
    }

    public int cjG() {
        if (this.iAU == -1) {
            this.iAU = this.aic;
        }
        return this.iAU;
    }

    public int cjH() {
        return this.iAU;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.bBu());
            this.iAU = mVar.aTs();
            a(mVar.aMO());
            setPageSize(mVar.getPageSize());
            setThreadData(mVar.axQ());
            setTotalCount(mVar.getTotalCount());
            yv(mVar.cjK());
            this.iAS.addAll(0, mVar.cjJ());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.bBu());
            a(mVar.aMO());
            f(mVar.cjF());
            setThreadData(mVar.axQ());
            if (mVar.cjJ() != null) {
                setCurrentPage(mVar.aTs());
                setPageSize(mVar.getPageSize());
                setTotalCount(mVar.getTotalCount());
                yv(mVar.cjK());
            }
            int size = this.iAS.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.iAS.remove(this.iAS.size() - 1);
                }
            }
            this.iAS.addAll(mVar.cjJ());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.bBu());
            a(mVar.aMO());
            f(mVar.cjF());
            setThreadData(mVar.axQ());
            if (mVar.cjJ() != null && mVar.cjJ().size() > 0) {
                setCurrentPage(mVar.aTs());
                setPageSize(mVar.getPageSize());
                setTotalCount(mVar.getTotalCount());
                yv(mVar.cjK());
            }
            int size = this.iAS.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.iAS.remove(this.iAS.size() - 1);
                }
            }
            this.iAS.addAll(mVar.cjJ());
            cjI();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            b(mVar.bBu());
            a(mVar.aMO());
            f(mVar.cjF());
            setThreadData(mVar.axQ());
            if (mVar.cjJ() != null && mVar.cjJ().size() > 0) {
                setCurrentPage(mVar.aTs());
                setPageSize(mVar.getPageSize());
                setTotalCount(mVar.getTotalCount());
                yv(mVar.cjK());
                this.iAU = (this.aic - (((mVar.cjJ().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.iAU < 0) {
                    this.iAU = 0;
                }
            }
            this.iAS.addAll(mVar.cjJ());
        }
    }

    public void cjI() {
        if (this.iAU < 0) {
            this.iAU = this.aic;
        } else if (this.iAU > this.aic) {
            this.iAU = this.aic;
        }
    }

    public ArrayList<PostData> cjJ() {
        return this.iAS;
    }

    public void aJ(ArrayList<PostData> arrayList) {
        this.iAS = arrayList;
    }

    public int cjK() {
        return this.iAT;
    }

    public void yv(int i) {
        this.iAT = i;
    }

    public int getTotalCount() {
        return this.mTotalCount;
    }

    public void setTotalCount(int i) {
        this.mTotalCount = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int aTs() {
        return this.aic;
    }

    public void setCurrentPage(int i) {
        this.aic = i;
    }

    public void a(ForumData forumData) {
        this.duJ = forumData;
    }

    public ForumData aMO() {
        return this.duJ;
    }

    public void b(AntiData antiData) {
        this.dhW = antiData;
    }

    public AntiData bBu() {
        return this.dhW;
    }

    public void setThreadData(bj bjVar) {
        this.Np = bjVar;
    }

    public boolean bVR() {
        return (this.Np == null || this.iAR == null || this.Np.azX() == null || this.Np.azX().getUserId() == null || this.iAR.azX() == null || this.iAR.azX().getUserId() == null || !this.Np.azX().getUserId().equals(this.iAR.azX().getUserId())) ? false : true;
    }

    public boolean aww() {
        return this.iAV;
    }

    public boolean hasMore() {
        return this.aic < this.iAT;
    }

    public bj axQ() {
        return this.Np;
    }

    public static m a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            m mVar = new m();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            mVar.b(antiData);
            bj bjVar = new bj();
            bjVar.a(dataRes.thread);
            mVar.setThreadData(bjVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            mVar.a(forumData);
            mVar.gNS = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.sG(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            mVar.f(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.sG(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            mVar.aJ(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            mVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                mVar.setCurrentPage(intValue3);
                mVar.setPageSize(intValue2);
                mVar.setTotalCount(intValue4);
                mVar.yv(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
