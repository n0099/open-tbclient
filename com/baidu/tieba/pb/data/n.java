package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class n {
    private int aDs;
    private bl bfu;
    public Error eDA;
    private ForumData eDs;
    private AntiData eDy;
    private int mCurrentPage;
    private int eDw = 20;
    private int eDx = -1;
    private boolean eDz = false;
    private PostData eDt = null;
    private ArrayList<PostData> eDu = new ArrayList<>();
    private int eDv = 1;

    public Error aPF() {
        return this.eDA;
    }

    public PostData aPG() {
        return this.eDt;
    }

    public void f(PostData postData) {
        this.eDt = postData;
    }

    public int aPH() {
        if (this.eDx == -1) {
            this.eDx = this.mCurrentPage;
        }
        return this.eDx;
    }

    public int aPI() {
        return this.eDx;
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aAK());
            this.eDx = nVar.JA();
            b(nVar.aPM());
            setPageSize(nVar.aPL());
            U(nVar.MA());
            setTotalCount(nVar.getTotalCount());
            hA(nVar.aMN());
            this.eDu.addAll(0, nVar.aPK());
        }
    }

    public void b(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aAK());
            b(nVar.aPM());
            f(nVar.aPG());
            U(nVar.MA());
            if (nVar.aPK() != null && nVar.aPK().size() > 0) {
                bV(nVar.JA());
                setPageSize(nVar.aPL());
                setTotalCount(nVar.getTotalCount());
                hA(nVar.aMN());
            }
            int size = this.eDu.size();
            if (z && size % this.eDw != 0) {
                for (int i = 0; i < size % this.eDw; i++) {
                    this.eDu.remove(this.eDu.size() - 1);
                }
            }
            this.eDu.addAll(nVar.aPK());
        }
    }

    public void c(n nVar, boolean z) {
        if (nVar != null) {
            e(nVar.aAK());
            b(nVar.aPM());
            f(nVar.aPG());
            U(nVar.MA());
            if (nVar.aPK() != null && nVar.aPK().size() > 0) {
                bV(nVar.JA());
                setPageSize(nVar.aPL());
                setTotalCount(nVar.getTotalCount());
                hA(nVar.aMN());
            }
            int size = this.eDu.size();
            if (z && size % this.eDw != 0) {
                for (int i = 0; i < size % this.eDw; i++) {
                    this.eDu.remove(this.eDu.size() - 1);
                }
            }
            this.eDu.addAll(nVar.aPK());
            aPJ();
        }
    }

    public void d(n nVar, boolean z) {
        a(nVar, z);
    }

    public void a(n nVar) {
        if (nVar != null) {
            e(nVar.aAK());
            b(nVar.aPM());
            f(nVar.aPG());
            U(nVar.MA());
            if (nVar.aPK() != null && nVar.aPK().size() > 0) {
                bV(nVar.JA());
                setPageSize(nVar.aPL());
                setTotalCount(nVar.getTotalCount());
                hA(nVar.aMN());
                this.eDx = (this.mCurrentPage - (((nVar.aPK().size() - 1) + this.eDw) / this.eDw)) + 1;
                if (this.eDx < 0) {
                    this.eDx = 0;
                }
            }
            this.eDu.addAll(nVar.aPK());
        }
    }

    public void aPJ() {
        if (this.eDx < 0) {
            this.eDx = this.mCurrentPage;
        } else if (this.eDx > this.mCurrentPage) {
            this.eDx = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aPK() {
        return this.eDu;
    }

    public void ak(ArrayList<PostData> arrayList) {
        this.eDu = arrayList;
    }

    public int aMN() {
        return this.eDv;
    }

    public void hA(int i) {
        this.eDv = i;
    }

    public int getTotalCount() {
        return this.aDs;
    }

    public void setTotalCount(int i) {
        this.aDs = i;
    }

    public int aPL() {
        return this.eDw;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eDw = i;
        }
    }

    public int JA() {
        return this.mCurrentPage;
    }

    public void bV(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eDs = forumData;
    }

    public ForumData aPM() {
        return this.eDs;
    }

    public void e(AntiData antiData) {
        this.eDy = antiData;
    }

    public AntiData aAK() {
        return this.eDy;
    }

    public void U(bl blVar) {
        this.bfu = blVar;
    }

    public boolean axb() {
        return (this.bfu == null || this.eDt == null || this.bfu.getAuthor() == null || this.bfu.getAuthor().getUserId() == null || this.eDt.getAuthor() == null || this.eDt.getAuthor().getUserId() == null || !this.bfu.getAuthor().getUserId().equals(this.eDt.getAuthor().getUserId())) ? false : true;
    }

    public boolean nB() {
        return this.eDz;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eDv;
    }

    public bl MA() {
        return this.bfu;
    }

    public static n a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            n nVar = new n();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            nVar.e(antiData);
            bl blVar = new bl();
            blVar.a(dataRes.thread);
            blVar.bV(2);
            nVar.U(blVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            nVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            nVar.f(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            nVar.ak(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            nVar.e(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                nVar.bV(intValue3);
                nVar.setPageSize(intValue2);
                nVar.setTotalCount(intValue4);
                nVar.hA(intValue);
            }
            return nVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
