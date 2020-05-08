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
/* loaded from: classes9.dex */
public class l {
    private int aCY;
    private bj agC;
    private AntiData dMD;
    private ForumData dZc;
    private int dZu;
    public boolean hBv;
    public Error joO;
    private int mPageSize = 20;
    private int joM = -1;
    private boolean joN = false;
    private PostData joJ = null;
    private ArrayList<PostData> joK = new ArrayList<>();
    private int joL = 1;

    public Error cwd() {
        return this.joO;
    }

    public PostData cwe() {
        return this.joJ;
    }

    public void f(PostData postData) {
        this.joJ = postData;
    }

    public int cwf() {
        if (this.joM == -1) {
            this.joM = this.aCY;
        }
        return this.joM;
    }

    public int cwg() {
        return this.joM;
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bNE());
            this.joM = lVar.bdY();
            a(lVar.aXG());
            setPageSize(lVar.getPageSize());
            setThreadData(lVar.aIu());
            setTotalCount(lVar.getTotalCount());
            zl(lVar.cwj());
            this.joK.addAll(0, lVar.cwi());
        }
    }

    public void b(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bNE());
            a(lVar.aXG());
            f(lVar.cwe());
            setThreadData(lVar.aIu());
            if (lVar.cwi() != null) {
                setCurrentPage(lVar.bdY());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                zl(lVar.cwj());
            }
            int size = this.joK.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.joK.remove(this.joK.size() - 1);
                }
            }
            this.joK.addAll(lVar.cwi());
        }
    }

    public void c(l lVar, boolean z) {
        if (lVar != null) {
            b(lVar.bNE());
            a(lVar.aXG());
            f(lVar.cwe());
            setThreadData(lVar.aIu());
            if (lVar.cwi() != null && lVar.cwi().size() > 0) {
                setCurrentPage(lVar.bdY());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                zl(lVar.cwj());
            }
            int size = this.joK.size();
            if (z && size % this.mPageSize != 0) {
                for (int i = 0; i < size % this.mPageSize; i++) {
                    this.joK.remove(this.joK.size() - 1);
                }
            }
            this.joK.addAll(lVar.cwi());
            cwh();
        }
    }

    public void d(l lVar, boolean z) {
        a(lVar, z);
    }

    public void a(l lVar) {
        if (lVar != null) {
            b(lVar.bNE());
            a(lVar.aXG());
            f(lVar.cwe());
            setThreadData(lVar.aIu());
            if (lVar.cwi() != null && lVar.cwi().size() > 0) {
                setCurrentPage(lVar.bdY());
                setPageSize(lVar.getPageSize());
                setTotalCount(lVar.getTotalCount());
                zl(lVar.cwj());
                this.joM = (this.aCY - (((lVar.cwi().size() - 1) + this.mPageSize) / this.mPageSize)) + 1;
                if (this.joM < 0) {
                    this.joM = 0;
                }
            }
            this.joK.addAll(lVar.cwi());
        }
    }

    public void cwh() {
        if (this.joM < 0) {
            this.joM = this.aCY;
        } else if (this.joM > this.aCY) {
            this.joM = this.aCY;
        }
    }

    public ArrayList<PostData> cwi() {
        return this.joK;
    }

    public void aL(ArrayList<PostData> arrayList) {
        this.joK = arrayList;
    }

    public int cwj() {
        return this.joL;
    }

    public void zl(int i) {
        this.joL = i;
    }

    public int getTotalCount() {
        return this.dZu;
    }

    public void setTotalCount(int i) {
        this.dZu = i;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.mPageSize = i;
        }
    }

    public int bdY() {
        return this.aCY;
    }

    public void setCurrentPage(int i) {
        this.aCY = i;
    }

    public void a(ForumData forumData) {
        this.dZc = forumData;
    }

    public ForumData aXG() {
        return this.dZc;
    }

    public void b(AntiData antiData) {
        this.dMD = antiData;
    }

    public AntiData bNE() {
        return this.dMD;
    }

    public void setThreadData(bj bjVar) {
        this.agC = bjVar;
    }

    public boolean cim() {
        return (this.agC == null || this.joJ == null || this.agC.aKC() == null || this.agC.aKC().getUserId() == null || this.joJ.aKC() == null || this.joJ.aKC().getUserId() == null || !this.agC.aKC().getUserId().equals(this.joJ.aKC().getUserId())) ? false : true;
    }

    public boolean aGX() {
        return this.joN;
    }

    public boolean hasMore() {
        return this.aCY < this.joL;
    }

    public bj aIu() {
        return this.agC;
    }

    public static l a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            l lVar = new l();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            lVar.b(antiData);
            bj bjVar = new bj();
            bjVar.a(dataRes.thread);
            lVar.setThreadData(bjVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            lVar.a(forumData);
            lVar.hBv = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.tS(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            lVar.f(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.tS(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            lVar.aL(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            lVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                lVar.setCurrentPage(intValue3);
                lVar.setPageSize(intValue2);
                lVar.setTotalCount(intValue4);
                lVar.zl(intValue);
            }
            return lVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
