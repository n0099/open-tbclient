package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.z;
import com.baidu.tieba.tbadkCore.data.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class d {
    private int auO;
    private z bdq;
    private int bkZ;
    private ForumData cDa;
    private AntiData cDg;
    public Error cDi;
    private int cDe = 20;
    private int cDf = -1;
    private boolean cDh = false;
    private r cDb = null;
    private ArrayList<r> cDc = new ArrayList<>();
    private int cDd = 1;

    public Error akR() {
        return this.cDi;
    }

    public r akS() {
        return this.cDb;
    }

    public void a(r rVar) {
        this.cDb = rVar;
    }

    public int akT() {
        if (this.cDf == -1) {
            this.cDf = this.bkZ;
        }
        return this.cDf;
    }

    public int akU() {
        return this.cDf;
    }

    public void a(d dVar, boolean z) {
        if (dVar != null) {
            b(dVar.ala());
            this.cDf = dVar.getCurrentPage();
            b(dVar.akZ());
            setPageSize(dVar.akY());
            g(dVar.Iv());
            setTotalCount(dVar.getTotalCount());
            kk(dVar.akX());
            this.cDc.addAll(0, dVar.akW());
        }
    }

    public void b(d dVar, boolean z) {
        if (dVar != null) {
            b(dVar.ala());
            b(dVar.akZ());
            a(dVar.akS());
            g(dVar.Iv());
            if (dVar.akW() != null && dVar.akW().size() > 0) {
                setCurrentPage(dVar.getCurrentPage());
                setPageSize(dVar.akY());
                setTotalCount(dVar.getTotalCount());
                kk(dVar.akX());
            }
            int size = this.cDc.size();
            if (z && size % this.cDe != 0) {
                for (int i = 0; i < size % this.cDe; i++) {
                    this.cDc.remove(this.cDc.size() - 1);
                }
            }
            this.cDc.addAll(dVar.akW());
        }
    }

    public void c(d dVar, boolean z) {
        if (dVar != null) {
            b(dVar.ala());
            b(dVar.akZ());
            a(dVar.akS());
            g(dVar.Iv());
            if (dVar.akW() != null && dVar.akW().size() > 0) {
                setCurrentPage(dVar.getCurrentPage());
                setPageSize(dVar.akY());
                setTotalCount(dVar.getTotalCount());
                kk(dVar.akX());
            }
            int size = this.cDc.size();
            if (z && size % this.cDe != 0) {
                for (int i = 0; i < size % this.cDe; i++) {
                    this.cDc.remove(this.cDc.size() - 1);
                }
            }
            this.cDc.addAll(dVar.akW());
            akV();
        }
    }

    public void d(d dVar, boolean z) {
        a(dVar, z);
    }

    public void a(d dVar) {
        if (dVar != null) {
            b(dVar.ala());
            b(dVar.akZ());
            a(dVar.akS());
            g(dVar.Iv());
            if (dVar.akW() != null && dVar.akW().size() > 0) {
                setCurrentPage(dVar.getCurrentPage());
                setPageSize(dVar.akY());
                setTotalCount(dVar.getTotalCount());
                kk(dVar.akX());
                this.cDf = (this.bkZ - (((dVar.akW().size() - 1) + this.cDe) / this.cDe)) + 1;
                if (this.cDf < 0) {
                    this.cDf = 0;
                }
            }
            this.cDc.addAll(dVar.akW());
        }
    }

    public void akV() {
        if (this.cDf < 0) {
            this.cDf = this.bkZ;
        } else if (this.cDf > this.bkZ) {
            this.cDf = this.bkZ;
        }
    }

    public ArrayList<r> akW() {
        return this.cDc;
    }

    public void U(ArrayList<r> arrayList) {
        this.cDc = arrayList;
    }

    public int akX() {
        return this.cDd;
    }

    public void kk(int i) {
        this.cDd = i;
    }

    public int getTotalCount() {
        return this.auO;
    }

    public void setTotalCount(int i) {
        this.auO = i;
    }

    public int akY() {
        return this.cDe;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.cDe = i;
        }
    }

    public int getCurrentPage() {
        return this.bkZ;
    }

    public void setCurrentPage(int i) {
        this.bkZ = i;
    }

    public void b(ForumData forumData) {
        this.cDa = forumData;
    }

    public ForumData akZ() {
        return this.cDa;
    }

    public void b(AntiData antiData) {
        this.cDg = antiData;
    }

    public AntiData ala() {
        return this.cDg;
    }

    public void g(z zVar) {
        this.bdq = zVar;
    }

    public boolean abn() {
        return (this.bdq == null || this.cDb == null || this.bdq.getAuthor() == null || this.bdq.getAuthor().getUserId() == null || this.cDb.getAuthor() == null || this.cDb.getAuthor().getUserId() == null || !this.bdq.getAuthor().getUserId().equals(this.cDb.getAuthor().getUserId())) ? false : true;
    }

    public boolean pN() {
        return this.cDh;
    }

    public boolean hasMore() {
        return this.bkZ < this.cDd;
    }

    public z Iv() {
        return this.bdq;
    }

    public static d a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            d dVar = new d();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            dVar.b(antiData);
            z zVar = new z();
            zVar.a(dataRes.thread);
            dVar.g(zVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            dVar.b(forumData);
            r rVar = new r();
            rVar.a(dataRes.post, context);
            dVar.a(rVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<r> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                r rVar2 = new r();
                rVar2.a(list.get(i), context);
                arrayList.add(rVar2);
            }
            dVar.U(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            dVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                dVar.setCurrentPage(intValue3);
                dVar.setPageSize(intValue2);
                dVar.setTotalCount(intValue4);
                dVar.kk(intValue);
            }
            return dVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
