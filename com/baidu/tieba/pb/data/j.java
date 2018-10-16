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
    public boolean dYS;
    public Error fIE;
    private int mCurrentPage;
    private int ekj = 20;
    private int fIC = -1;
    private boolean fID = false;
    private PostData fIz = null;
    private ArrayList<PostData> fIA = new ArrayList<>();
    private int fIB = 1;

    public Error bfB() {
        return this.fIE;
    }

    public PostData bfC() {
        return this.fIz;
    }

    public void e(PostData postData) {
        this.fIz = postData;
    }

    public int bfD() {
        if (this.fIC == -1) {
            this.fIC = this.mCurrentPage;
        }
        return this.fIC;
    }

    public int bfE() {
        return this.fIC;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.ayP());
            this.fIC = jVar.SJ();
            a(jVar.bfJ());
            setPageSize(jVar.bfI());
            aa(jVar.YA());
            setTotalCount(jVar.getTotalCount());
            ka(jVar.bfH());
            this.fIA.addAll(0, jVar.bfG());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.ayP());
            a(jVar.bfJ());
            e(jVar.bfC());
            aa(jVar.YA());
            if (jVar.bfG() != null) {
                setCurrentPage(jVar.SJ());
                setPageSize(jVar.bfI());
                setTotalCount(jVar.getTotalCount());
                ka(jVar.bfH());
            }
            int size = this.fIA.size();
            if (z && size % this.ekj != 0) {
                for (int i = 0; i < size % this.ekj; i++) {
                    this.fIA.remove(this.fIA.size() - 1);
                }
            }
            this.fIA.addAll(jVar.bfG());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            b(jVar.ayP());
            a(jVar.bfJ());
            e(jVar.bfC());
            aa(jVar.YA());
            if (jVar.bfG() != null && jVar.bfG().size() > 0) {
                setCurrentPage(jVar.SJ());
                setPageSize(jVar.bfI());
                setTotalCount(jVar.getTotalCount());
                ka(jVar.bfH());
            }
            int size = this.fIA.size();
            if (z && size % this.ekj != 0) {
                for (int i = 0; i < size % this.ekj; i++) {
                    this.fIA.remove(this.fIA.size() - 1);
                }
            }
            this.fIA.addAll(jVar.bfG());
            bfF();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            b(jVar.ayP());
            a(jVar.bfJ());
            e(jVar.bfC());
            aa(jVar.YA());
            if (jVar.bfG() != null && jVar.bfG().size() > 0) {
                setCurrentPage(jVar.SJ());
                setPageSize(jVar.bfI());
                setTotalCount(jVar.getTotalCount());
                ka(jVar.bfH());
                this.fIC = (this.mCurrentPage - (((jVar.bfG().size() - 1) + this.ekj) / this.ekj)) + 1;
                if (this.fIC < 0) {
                    this.fIC = 0;
                }
            }
            this.fIA.addAll(jVar.bfG());
        }
    }

    public void bfF() {
        if (this.fIC < 0) {
            this.fIC = this.mCurrentPage;
        } else if (this.fIC > this.mCurrentPage) {
            this.fIC = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bfG() {
        return this.fIA;
    }

    public void an(ArrayList<PostData> arrayList) {
        this.fIA = arrayList;
    }

    public int bfH() {
        return this.fIB;
    }

    public void ka(int i) {
        this.fIB = i;
    }

    public int getTotalCount() {
        return this.aWx;
    }

    public void setTotalCount(int i) {
        this.aWx = i;
    }

    public int bfI() {
        return this.ekj;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.ekj = i;
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

    public AntiData ayP() {
        return this.aJw;
    }

    public void aa(bb bbVar) {
        this.bIV = bbVar;
    }

    public boolean aSn() {
        return (this.bIV == null || this.fIz == null || this.bIV.yv() == null || this.bIV.yv().getUserId() == null || this.fIz.yv() == null || this.fIz.yv().getUserId() == null || !this.bIV.yv().getUserId().equals(this.fIz.yv().getUserId())) ? false : true;
    }

    public boolean vc() {
        return this.fID;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fIB;
    }

    public bb YA() {
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
            jVar.dYS = forumData.isBrandForum;
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
