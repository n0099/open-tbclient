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
    private int aBC;
    private bi aRX;
    private ForumData eiK;
    private AntiData eiQ;
    public Error eiS;
    private int mCurrentPage;
    private int eiO = 20;
    private int eiP = -1;
    private boolean eiR = false;
    private PostData eiL = null;
    private ArrayList<PostData> eiM = new ArrayList<>();
    private int eiN = 1;

    public Error aKV() {
        return this.eiS;
    }

    public PostData aKW() {
        return this.eiL;
    }

    public void b(PostData postData) {
        this.eiL = postData;
    }

    public int aKX() {
        if (this.eiP == -1) {
            this.eiP = this.mCurrentPage;
        }
        return this.eiP;
    }

    public int aKY() {
        return this.eiP;
    }

    public void a(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.axt());
            this.eiP = jVar.JG();
            b(jVar.aLc());
            setPageSize(jVar.aLb());
            h(jVar.Kn());
            setTotalCount(jVar.getTotalCount());
            gX(jVar.aIn());
            this.eiM.addAll(0, jVar.aLa());
        }
    }

    public void b(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.axt());
            b(jVar.aLc());
            b(jVar.aKW());
            h(jVar.Kn());
            if (jVar.aLa() != null && jVar.aLa().size() > 0) {
                bX(jVar.JG());
                setPageSize(jVar.aLb());
                setTotalCount(jVar.getTotalCount());
                gX(jVar.aIn());
            }
            int size = this.eiM.size();
            if (z && size % this.eiO != 0) {
                for (int i = 0; i < size % this.eiO; i++) {
                    this.eiM.remove(this.eiM.size() - 1);
                }
            }
            this.eiM.addAll(jVar.aLa());
        }
    }

    public void c(j jVar, boolean z) {
        if (jVar != null) {
            e(jVar.axt());
            b(jVar.aLc());
            b(jVar.aKW());
            h(jVar.Kn());
            if (jVar.aLa() != null && jVar.aLa().size() > 0) {
                bX(jVar.JG());
                setPageSize(jVar.aLb());
                setTotalCount(jVar.getTotalCount());
                gX(jVar.aIn());
            }
            int size = this.eiM.size();
            if (z && size % this.eiO != 0) {
                for (int i = 0; i < size % this.eiO; i++) {
                    this.eiM.remove(this.eiM.size() - 1);
                }
            }
            this.eiM.addAll(jVar.aLa());
            aKZ();
        }
    }

    public void d(j jVar, boolean z) {
        a(jVar, z);
    }

    public void a(j jVar) {
        if (jVar != null) {
            e(jVar.axt());
            b(jVar.aLc());
            b(jVar.aKW());
            h(jVar.Kn());
            if (jVar.aLa() != null && jVar.aLa().size() > 0) {
                bX(jVar.JG());
                setPageSize(jVar.aLb());
                setTotalCount(jVar.getTotalCount());
                gX(jVar.aIn());
                this.eiP = (this.mCurrentPage - (((jVar.aLa().size() - 1) + this.eiO) / this.eiO)) + 1;
                if (this.eiP < 0) {
                    this.eiP = 0;
                }
            }
            this.eiM.addAll(jVar.aLa());
        }
    }

    public void aKZ() {
        if (this.eiP < 0) {
            this.eiP = this.mCurrentPage;
        } else if (this.eiP > this.mCurrentPage) {
            this.eiP = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aLa() {
        return this.eiM;
    }

    public void aj(ArrayList<PostData> arrayList) {
        this.eiM = arrayList;
    }

    public int aIn() {
        return this.eiN;
    }

    public void gX(int i) {
        this.eiN = i;
    }

    public int getTotalCount() {
        return this.aBC;
    }

    public void setTotalCount(int i) {
        this.aBC = i;
    }

    public int aLb() {
        return this.eiO;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.eiO = i;
        }
    }

    public int JG() {
        return this.mCurrentPage;
    }

    public void bX(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.eiK = forumData;
    }

    public ForumData aLc() {
        return this.eiK;
    }

    public void e(AntiData antiData) {
        this.eiQ = antiData;
    }

    public AntiData axt() {
        return this.eiQ;
    }

    public void h(bi biVar) {
        this.aRX = biVar;
    }

    public boolean atS() {
        return (this.aRX == null || this.eiL == null || this.aRX.getAuthor() == null || this.aRX.getAuthor().getUserId() == null || this.eiL.getAuthor() == null || this.eiL.getAuthor().getUserId() == null || !this.aRX.getAuthor().getUserId().equals(this.eiL.getAuthor().getUserId())) ? false : true;
    }

    public boolean oe() {
        return this.eiR;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.eiN;
    }

    public bi Kn() {
        return this.aRX;
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
                jVar.gX(intValue);
            }
            return jVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
