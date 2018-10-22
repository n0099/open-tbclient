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
    private AntiData aJw;
    private ForumData aWf;
    private int aWx;
    private bb bIV;
    public boolean dYT;
    public Error fIF;
    private int mCurrentPage;
    private int ekk = 20;
    private int fID = -1;
    private boolean fIE = false;
    private PostData fIA = null;
    private ArrayList<PostData> fIB = new ArrayList<>();
    private int fIC = 1;

    public Error bfB() {
        return this.fIF;
    }

    public PostData bfC() {
        return this.fIA;
    }

    public void e(PostData postData) {
        this.fIA = postData;
    }

    public int bfD() {
        if (this.fID == -1) {
            this.fID = this.mCurrentPage;
        }
        return this.fID;
    }

    public int bfE() {
        return this.fID;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.ayQ());
            this.fID = jVar.SJ();
            a(jVar.bfJ());
            setPageSize(jVar.bfI());
            aa(jVar.YB());
            setTotalCount(jVar.getTotalCount());
            ka(jVar.bfH());
            this.fIB.addAll(0, jVar.bfG());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.ayQ());
            a(jVar.bfJ());
            e(jVar.bfC());
            aa(jVar.YB());
            if (jVar.bfG() != null) {
                setCurrentPage(jVar.SJ());
                setPageSize(jVar.bfI());
                setTotalCount(jVar.getTotalCount());
                ka(jVar.bfH());
            }
            int size = this.fIB.size();
            if (z && size % this.ekk != 0) {
                for (int i = 0; i < size % this.ekk; i++) {
                    this.fIB.remove(this.fIB.size() - 1);
                }
            }
            this.fIB.addAll(jVar.bfG());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.ayQ());
            a(jVar.bfJ());
            e(jVar.bfC());
            aa(jVar.YB());
            if (jVar.bfG() != null && jVar.bfG().size() > 0) {
                setCurrentPage(jVar.SJ());
                setPageSize(jVar.bfI());
                setTotalCount(jVar.getTotalCount());
                ka(jVar.bfH());
            }
            int size = this.fIB.size();
            if (z && size % this.ekk != 0) {
                for (int i = 0; i < size % this.ekk; i++) {
                    this.fIB.remove(this.fIB.size() - 1);
                }
            }
            this.fIB.addAll(jVar.bfG());
            bfF();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            b(jVar.ayQ());
            a(jVar.bfJ());
            e(jVar.bfC());
            aa(jVar.YB());
            if (jVar.bfG() != null && jVar.bfG().size() > 0) {
                setCurrentPage(jVar.SJ());
                setPageSize(jVar.bfI());
                setTotalCount(jVar.getTotalCount());
                ka(jVar.bfH());
                this.fID = (this.mCurrentPage - (((jVar.bfG().size() - 1) + this.ekk) / this.ekk)) + 1;
                if (this.fID < 0) {
                    this.fID = 0;
                }
            }
            this.fIB.addAll(jVar.bfG());
        }
    }

    public void bfF() {
        if (this.fID < 0) {
            this.fID = this.mCurrentPage;
        } else if (this.fID > this.mCurrentPage) {
            this.fID = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bfG() {
        return this.fIB;
    }

    public void an(ArrayList<PostData> arrayList) {
        this.fIB = arrayList;
    }

    public int bfH() {
        return this.fIC;
    }

    public void ka(int i) {
        this.fIC = i;
    }

    public int getTotalCount() {
        return this.aWx;
    }

    public void setTotalCount(int i) {
        this.aWx = i;
    }

    public int bfI() {
        return this.ekk;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.ekk = i;
        }
    }

    public int SJ() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.aWf = forumData;
    }

    public ForumData bfJ() {
        return this.aWf;
    }

    public void b(AntiData antiData) {
        this.aJw = antiData;
    }

    public AntiData ayQ() {
        return this.aJw;
    }

    public void aa(bb bbVar) {
        this.bIV = bbVar;
    }

    public boolean aSn() {
        return (this.bIV == null || this.fIA == null || this.bIV.yv() == null || this.bIV.yv().getUserId() == null || this.fIA.yv() == null || this.fIA.yv().getUserId() == null || !this.bIV.yv().getUserId().equals(this.fIA.yv().getUserId())) ? false : true;
    }

    public boolean vc() {
        return this.fIE;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fIC;
    }

    public bb YB() {
        return this.bIV;
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
            jVar.dYT = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.kk(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            jVar.e(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.kk(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            jVar.an(arrayList);
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
                jVar.ka(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
