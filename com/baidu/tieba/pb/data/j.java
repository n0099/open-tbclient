package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes4.dex */
public class j {
    private bg bTo;
    private AntiData bWS;
    private ForumData ckM;
    private int clg;
    public boolean fzc;
    public Error hkJ;
    private int mCurrentPage;
    private int mPageSize = 20;
    private int hkH = -1;
    private boolean hkI = false;
    private PostData hkE = null;
    private ArrayList<PostData> hkF = new ArrayList<>();
    private int hkG = 1;

    public Error bIz() {
        return this.hkJ;
    }

    public PostData bIA() {
        return this.hkE;
    }

    public void e(PostData postData) {
        this.hkE = postData;
    }

    public int bIB() {
        if (this.hkH == -1) {
            this.hkH = this.mCurrentPage;
        }
        return this.hkH;
    }

    public int bIC() {
        return this.hkH;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.bbG());
            this.hkH = jVar.aur();
            a(jVar.bIG());
            setPageSize(jVar.getPageSize());
            ai(jVar.WO());
            setTotalCount(jVar.getTotalCount());
            ov(jVar.bIF());
            this.hkF.addAll(0, jVar.bIE());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.bbG());
            a(jVar.bIG());
            e(jVar.bIA());
            ai(jVar.WO());
            if (jVar.bIE() != null) {
                setCurrentPage(jVar.aur());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                ov(jVar.bIF());
            }
            int size = this.hkF.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hkF.remove(this.hkF.size() - 1);
                }
            }
            this.hkF.addAll(jVar.bIE());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.bbG());
            a(jVar.bIG());
            e(jVar.bIA());
            ai(jVar.WO());
            if (jVar.bIE() != null && jVar.bIE().size() > 0) {
                setCurrentPage(jVar.aur());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                ov(jVar.bIF());
            }
            int size = this.hkF.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.hkF.remove(this.hkF.size() - 1);
                }
            }
            this.hkF.addAll(jVar.bIE());
            bID();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            b(jVar.bbG());
            a(jVar.bIG());
            e(jVar.bIA());
            ai(jVar.WO());
            if (jVar.bIE() != null && jVar.bIE().size() > 0) {
                setCurrentPage(jVar.aur());
                setPageSize(jVar.getPageSize());
                setTotalCount(jVar.getTotalCount());
                ov(jVar.bIF());
                this.hkH = (this.mCurrentPage - (((jVar.bIE().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.hkH < 0) {
                    this.hkH = 0;
                }
            }
            this.hkF.addAll(jVar.bIE());
        }
    }

    public void bID() {
        if (this.hkH < 0) {
            this.hkH = this.mCurrentPage;
        } else if (this.hkH > this.mCurrentPage) {
            this.hkH = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bIE() {
        return this.hkF;
    }

    public void aq(ArrayList<PostData> arrayList) {
        this.hkF = arrayList;
    }

    public int bIF() {
        return this.hkG;
    }

    public void ov(int i) {
        this.hkG = i;
    }

    public int getTotalCount() {
        return this.clg;
    }

    public void setTotalCount(int i) {
        this.clg = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int aur() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.ckM = forumData;
    }

    public ForumData bIG() {
        return this.ckM;
    }

    public void b(AntiData antiData) {
        this.bWS = antiData;
    }

    public AntiData bbG() {
        return this.bWS;
    }

    public void ai(bg bgVar) {
        this.bTo = bgVar;
    }

    public boolean bvr() {
        return (this.bTo == null || this.hkE == null || this.bTo.YO() == null || this.bTo.YO().getUserId() == null || this.hkE.YO() == null || this.hkE.YO().getUserId() == null || !this.bTo.YO().getUserId().equals(this.hkE.YO().getUserId())) ? false : true;
    }

    public boolean UY() {
        return this.hkI;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.hkG;
    }

    public bg WO() {
        return this.bTo;
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
            bg bgVar = new bg();
            bgVar.a(dataRes.thread);
            bgVar.setCurrentPage(2);
            jVar.ai(bgVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            jVar.a(forumData);
            jVar.fzc = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.pU(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            jVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.pU(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            jVar.aq(arrayList);
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
                jVar.ov(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
