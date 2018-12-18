package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes6.dex */
public class j {
    private AntiData aNL;
    private bb bNv;
    private int baL;
    private ForumData bat;
    public boolean egP;
    public Error fQT;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int fQR = -1;
    private boolean fQS = false;
    private PostData fQO = null;
    private ArrayList<PostData> fQP = new ArrayList<>();
    private int fQQ = 1;

    public Error bgP() {
        return this.fQT;
    }

    public PostData bgQ() {
        return this.fQO;
    }

    public void e(PostData postData) {
        this.fQO = postData;
    }

    public int bgR() {
        if (this.fQR == -1) {
            this.fQR = this.mCurrentPage;
        }
        return this.fQR;
    }

    public int bgS() {
        return this.fQR;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.azX());
            this.fQR = jVar.TY();
            a(jVar.bgW());
            setPageSize(jVar.getPageSize());
            aa(jVar.ZR());
            setTotalCount(jVar.getTotalCount());
            kJ(jVar.bgV());
            this.fQP.addAll(0, jVar.bgU());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.azX());
            a(jVar.bgW());
            e(jVar.bgQ());
            aa(jVar.ZR());
            if (jVar.bgU() != null) {
                setCurrentPage(jVar.TY());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kJ(jVar.bgV());
            }
            int size = this.fQP.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.fQP.remove(this.fQP.size() - 1);
                }
            }
            this.fQP.addAll(jVar.bgU());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.azX());
            a(jVar.bgW());
            e(jVar.bgQ());
            aa(jVar.ZR());
            if (jVar.bgU() != null && jVar.bgU().size() > 0) {
                setCurrentPage(jVar.TY());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kJ(jVar.bgV());
            }
            int size = this.fQP.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.fQP.remove(this.fQP.size() - 1);
                }
            }
            this.fQP.addAll(jVar.bgU());
            bgT();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            b(jVar.azX());
            a(jVar.bgW());
            e(jVar.bgQ());
            aa(jVar.ZR());
            if (jVar.bgU() != null && jVar.bgU().size() > 0) {
                setCurrentPage(jVar.TY());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                kJ(jVar.bgV());
                this.fQR = (this.mCurrentPage - (((jVar.bgU().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.fQR < 0) {
                    this.fQR = 0;
                }
            }
            this.fQP.addAll(jVar.bgU());
        }
    }

    public void bgT() {
        if (this.fQR < 0) {
            this.fQR = this.mCurrentPage;
        } else if (this.fQR > this.mCurrentPage) {
            this.fQR = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bgU() {
        return this.fQP;
    }

    public void am(ArrayList<PostData> arrayList) {
        this.fQP = arrayList;
    }

    public int bgV() {
        return this.fQQ;
    }

    public void kJ(int i) {
        this.fQQ = i;
    }

    public int getTotalCount() {
        return this.baL;
    }

    public void setTotalCount(int i) {
        this.baL = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int TY() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.bat = forumData;
    }

    public ForumData bgW() {
        return this.bat;
    }

    public void b(AntiData antiData) {
        this.aNL = antiData;
    }

    public AntiData azX() {
        return this.aNL;
    }

    public void aa(bb bbVar) {
        this.bNv = bbVar;
    }

    public boolean aTB() {
        return (this.bNv == null || this.fQO == null || this.bNv.zG() == null || this.bNv.zG().getUserId() == null || this.fQO.zG() == null || this.fQO.zG().getUserId() == null || !this.bNv.zG().getUserId().equals(this.fQO.zG().getUserId())) ? false : true;
    }

    public boolean wq() {
        return this.fQS;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fQQ;
    }

    public bb ZR() {
        return this.bNv;
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
            bb bbVar = new bb();
            bbVar.a(dataRes.thread);
            bbVar.setCurrentPage(2);
            jVar.aa(bbVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            jVar.a(forumData);
            jVar.egP = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.kx(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            jVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.kx(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            jVar.am(arrayList);
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
                jVar.kJ(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
