package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class j {
    private int aBA;
    private bi aRV;
    private AntiData egA;
    public Error egC;
    private ForumData egu;
    private int mCurrentPage;
    private int egy = 20;
    private int egz = -1;
    private boolean egB = false;
    private PostData egv = null;
    private ArrayList<PostData> egw = new ArrayList<>();
    private int egx = 1;

    public Error aJU() {
        return this.egC;
    }

    public PostData aJV() {
        return this.egv;
    }

    public void b(PostData postData) {
        this.egv = postData;
    }

    public int aJW() {
        if (this.egz == -1) {
            this.egz = this.mCurrentPage;
        }
        return this.egz;
    }

    public int aJX() {
        return this.egz;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.aws());
            this.egz = jVar.JG();
            b(jVar.aKb());
            setPageSize(jVar.aKa());
            h(jVar.Kn());
            setTotalCount(jVar.getTotalCount());
            gR(jVar.aHm());
            this.egw.addAll(0, jVar.aJZ());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.aws());
            b(jVar.aKb());
            b(jVar.aJV());
            h(jVar.Kn());
            if (jVar.aJZ() != null && jVar.aJZ().size() > 0) {
                bX(jVar.JG());
                setPageSize(jVar.aKa());
                setTotalCount(jVar.getTotalCount());
                gR(jVar.aHm());
            }
            int size = this.egw.size();
            if (z && size % this.egy != 0) {
                for (int i = 0; i < size % this.egy; i++) {
                    this.egw.remove(this.egw.size() - 1);
                }
            }
            this.egw.addAll(jVar.aJZ());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.aws());
            b(jVar.aKb());
            b(jVar.aJV());
            h(jVar.Kn());
            if (jVar.aJZ() != null && jVar.aJZ().size() > 0) {
                bX(jVar.JG());
                setPageSize(jVar.aKa());
                setTotalCount(jVar.getTotalCount());
                gR(jVar.aHm());
            }
            int size = this.egw.size();
            if (z && size % this.egy != 0) {
                for (int i = 0; i < size % this.egy; i++) {
                    this.egw.remove(this.egw.size() - 1);
                }
            }
            this.egw.addAll(jVar.aJZ());
            aJY();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            e(jVar.aws());
            b(jVar.aKb());
            b(jVar.aJV());
            h(jVar.Kn());
            if (jVar.aJZ() != null && jVar.aJZ().size() > 0) {
                bX(jVar.JG());
                setPageSize(jVar.aKa());
                setTotalCount(jVar.getTotalCount());
                gR(jVar.aHm());
                this.egz = (this.mCurrentPage - (((jVar.aJZ().size() - 1) + this.egy) / this.egy)) + 1;
                if (this.egz < 0) {
                    this.egz = 0;
                }
            }
            this.egw.addAll(jVar.aJZ());
        }
    }

    public void aJY() {
        if (this.egz < 0) {
            this.egz = this.mCurrentPage;
        } else if (this.egz > this.mCurrentPage) {
            this.egz = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aJZ() {
        return this.egw;
    }

    public void aj(ArrayList<PostData> arrayList) {
        this.egw = arrayList;
    }

    public int aHm() {
        return this.egx;
    }

    public void gR(int i) {
        this.egx = i;
    }

    public int getTotalCount() {
        return this.aBA;
    }

    public void setTotalCount(int i) {
        this.aBA = i;
    }

    public int aKa() {
        return this.egy;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.egy = i;
        }
    }

    public int JG() {
        return this.mCurrentPage;
    }

    public void bX(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.egu = forumData;
    }

    public ForumData aKb() {
        return this.egu;
    }

    public void e(AntiData antiData) {
        this.egA = antiData;
    }

    public AntiData aws() {
        return this.egA;
    }

    public void h(bi biVar) {
        this.aRV = biVar;
    }

    public boolean asR() {
        return (this.aRV == null || this.egv == null || this.aRV.getAuthor() == null || this.aRV.getAuthor().getUserId() == null || this.egv.getAuthor() == null || this.egv.getAuthor().getUserId() == null || !this.aRV.getAuthor().getUserId().equals(this.egv.getAuthor().getUserId())) ? false : true;
    }

    public boolean oe() {
        return this.egB;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.egx;
    }

    public bi Kn() {
        return this.aRV;
    }

    public static j a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            j jVar = new j();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            jVar.e(antiData);
            bi biVar = new bi();
            biVar.a(dataRes.thread);
            biVar.bX(2);
            jVar.h(biVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            jVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            jVar.b(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            jVar.aj(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            jVar.e(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                jVar.bX(intValue3);
                jVar.setPageSize(intValue2);
                jVar.setTotalCount(intValue4);
                jVar.gR(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
