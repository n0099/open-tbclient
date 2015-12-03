package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.z;
import com.baidu.tieba.tbadkCore.data.o;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class d {
    private z aZu;
    private int atk;
    private int bhi;
    private AntiData czB;
    public Error czD;
    private ForumData czv;
    private int czz = 20;
    private int czA = -1;
    private boolean czC = false;
    private o czw = null;
    private ArrayList<o> czx = new ArrayList<>();
    private int czy = 1;

    public Error ajJ() {
        return this.czD;
    }

    public o ajK() {
        return this.czw;
    }

    public void a(o oVar) {
        this.czw = oVar;
    }

    public int ajL() {
        if (this.czA == -1) {
            this.czA = this.bhi;
        }
        return this.czA;
    }

    public int ajM() {
        return this.czA;
    }

    public void a(d dVar, boolean z) {
        if (dVar != null) {
            b(dVar.ajS());
            this.czA = dVar.getCurrentPage();
            b(dVar.ajR());
            setPageSize(dVar.ajQ());
            e(dVar.ajT());
            setTotalCount(dVar.getTotalCount());
            jN(dVar.ajP());
            this.czx.addAll(0, dVar.ajO());
        }
    }

    public void b(d dVar, boolean z) {
        if (dVar != null) {
            b(dVar.ajS());
            b(dVar.ajR());
            a(dVar.ajK());
            e(dVar.ajT());
            if (dVar.ajO() != null && dVar.ajO().size() > 0) {
                setCurrentPage(dVar.getCurrentPage());
                setPageSize(dVar.ajQ());
                setTotalCount(dVar.getTotalCount());
                jN(dVar.ajP());
            }
            int size = this.czx.size();
            if (z && size % this.czz != 0) {
                for (int i = 0; i < size % this.czz; i++) {
                    this.czx.remove(this.czx.size() - 1);
                }
            }
            this.czx.addAll(dVar.ajO());
        }
    }

    public void c(d dVar, boolean z) {
        if (dVar != null) {
            b(dVar.ajS());
            b(dVar.ajR());
            a(dVar.ajK());
            e(dVar.ajT());
            if (dVar.ajO() != null && dVar.ajO().size() > 0) {
                setCurrentPage(dVar.getCurrentPage());
                setPageSize(dVar.ajQ());
                setTotalCount(dVar.getTotalCount());
                jN(dVar.ajP());
            }
            int size = this.czx.size();
            if (z && size % this.czz != 0) {
                for (int i = 0; i < size % this.czz; i++) {
                    this.czx.remove(this.czx.size() - 1);
                }
            }
            this.czx.addAll(dVar.ajO());
            ajN();
        }
    }

    public void d(d dVar, boolean z) {
        a(dVar, z);
    }

    public void a(d dVar) {
        if (dVar != null) {
            b(dVar.ajS());
            b(dVar.ajR());
            a(dVar.ajK());
            e(dVar.ajT());
            if (dVar.ajO() != null && dVar.ajO().size() > 0) {
                setCurrentPage(dVar.getCurrentPage());
                setPageSize(dVar.ajQ());
                setTotalCount(dVar.getTotalCount());
                jN(dVar.ajP());
                this.czA = (this.bhi - (((dVar.ajO().size() - 1) + this.czz) / this.czz)) + 1;
                if (this.czA < 0) {
                    this.czA = 0;
                }
            }
            this.czx.addAll(dVar.ajO());
        }
    }

    public void ajN() {
        if (this.czA < 0) {
            this.czA = this.bhi;
        } else if (this.czA > this.bhi) {
            this.czA = this.bhi;
        }
    }

    public ArrayList<o> ajO() {
        return this.czx;
    }

    public void V(ArrayList<o> arrayList) {
        this.czx = arrayList;
    }

    public int ajP() {
        return this.czy;
    }

    public void jN(int i) {
        this.czy = i;
    }

    public int getTotalCount() {
        return this.atk;
    }

    public void setTotalCount(int i) {
        this.atk = i;
    }

    public int ajQ() {
        return this.czz;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.czz = i;
        }
    }

    public int getCurrentPage() {
        return this.bhi;
    }

    public void setCurrentPage(int i) {
        this.bhi = i;
    }

    public void b(ForumData forumData) {
        this.czv = forumData;
    }

    public ForumData ajR() {
        return this.czv;
    }

    public void b(AntiData antiData) {
        this.czB = antiData;
    }

    public AntiData ajS() {
        return this.czB;
    }

    public void e(z zVar) {
        this.aZu = zVar;
    }

    public boolean aah() {
        return (this.aZu == null || this.czw == null || this.aZu.getAuthor() == null || this.aZu.getAuthor().getUserId() == null || this.czw.getAuthor() == null || this.czw.getAuthor().getUserId() == null || !this.aZu.getAuthor().getUserId().equals(this.czw.getAuthor().getUserId())) ? false : true;
    }

    public boolean qp() {
        return this.czC;
    }

    public boolean hasMore() {
        return this.bhi < this.czy;
    }

    public z ajT() {
        return this.aZu;
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
            dVar.e(zVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            dVar.b(forumData);
            o oVar = new o();
            oVar.a(dataRes.post, context);
            dVar.a(oVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<o> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                o oVar2 = new o();
                oVar2.a(list.get(i), context);
                arrayList.add(oVar2);
            }
            dVar.V(arrayList);
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
                dVar.jN(intValue);
            }
            return dVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
