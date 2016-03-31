package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tieba.tbadkCore.data.s;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class g {
    private int awh;
    private as bks;
    private int bsT;
    private ForumData dcX;
    private AntiData ddd;
    public Error ddf;
    private int ddb = 20;
    private int ddc = -1;
    private boolean dde = false;
    private s dcY = null;
    private ArrayList<s> dcZ = new ArrayList<>();
    private int dda = 1;

    public Error avH() {
        return this.ddf;
    }

    public s avI() {
        return this.dcY;
    }

    public void a(s sVar) {
        this.dcY = sVar;
    }

    public int avJ() {
        if (this.ddc == -1) {
            this.ddc = this.bsT;
        }
        return this.ddc;
    }

    public int avK() {
        return this.ddc;
    }

    public void a(g gVar, boolean z) {
        if (gVar != null) {
            e(gVar.amu());
            this.ddc = gVar.oX();
            b(gVar.avP());
            setPageSize(gVar.avO());
            h(gVar.LC());
            setTotalCount(gVar.getTotalCount());
            lO(gVar.avN());
            this.dcZ.addAll(0, gVar.avM());
        }
    }

    public void b(g gVar, boolean z) {
        if (gVar != null) {
            e(gVar.amu());
            b(gVar.avP());
            a(gVar.avI());
            h(gVar.LC());
            if (gVar.avM() != null && gVar.avM().size() > 0) {
                aS(gVar.oX());
                setPageSize(gVar.avO());
                setTotalCount(gVar.getTotalCount());
                lO(gVar.avN());
            }
            int size = this.dcZ.size();
            if (z && size % this.ddb != 0) {
                for (int i = 0; i < size % this.ddb; i++) {
                    this.dcZ.remove(this.dcZ.size() - 1);
                }
            }
            this.dcZ.addAll(gVar.avM());
        }
    }

    public void c(g gVar, boolean z) {
        if (gVar != null) {
            e(gVar.amu());
            b(gVar.avP());
            a(gVar.avI());
            h(gVar.LC());
            if (gVar.avM() != null && gVar.avM().size() > 0) {
                aS(gVar.oX());
                setPageSize(gVar.avO());
                setTotalCount(gVar.getTotalCount());
                lO(gVar.avN());
            }
            int size = this.dcZ.size();
            if (z && size % this.ddb != 0) {
                for (int i = 0; i < size % this.ddb; i++) {
                    this.dcZ.remove(this.dcZ.size() - 1);
                }
            }
            this.dcZ.addAll(gVar.avM());
            avL();
        }
    }

    public void d(g gVar, boolean z) {
        a(gVar, z);
    }

    public void a(g gVar) {
        if (gVar != null) {
            e(gVar.amu());
            b(gVar.avP());
            a(gVar.avI());
            h(gVar.LC());
            if (gVar.avM() != null && gVar.avM().size() > 0) {
                aS(gVar.oX());
                setPageSize(gVar.avO());
                setTotalCount(gVar.getTotalCount());
                lO(gVar.avN());
                this.ddc = (this.bsT - (((gVar.avM().size() - 1) + this.ddb) / this.ddb)) + 1;
                if (this.ddc < 0) {
                    this.ddc = 0;
                }
            }
            this.dcZ.addAll(gVar.avM());
        }
    }

    public void avL() {
        if (this.ddc < 0) {
            this.ddc = this.bsT;
        } else if (this.ddc > this.bsT) {
            this.ddc = this.bsT;
        }
    }

    public ArrayList<s> avM() {
        return this.dcZ;
    }

    public void W(ArrayList<s> arrayList) {
        this.dcZ = arrayList;
    }

    public int avN() {
        return this.dda;
    }

    public void lO(int i) {
        this.dda = i;
    }

    public int getTotalCount() {
        return this.awh;
    }

    public void setTotalCount(int i) {
        this.awh = i;
    }

    public int avO() {
        return this.ddb;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.ddb = i;
        }
    }

    public int oX() {
        return this.bsT;
    }

    public void aS(int i) {
        this.bsT = i;
    }

    public void b(ForumData forumData) {
        this.dcX = forumData;
    }

    public ForumData avP() {
        return this.dcX;
    }

    public void e(AntiData antiData) {
        this.ddd = antiData;
    }

    public AntiData amu() {
        return this.ddd;
    }

    public void h(as asVar) {
        this.bks = asVar;
    }

    public boolean ahG() {
        return (this.bks == null || this.dcY == null || this.bks.getAuthor() == null || this.bks.getAuthor().getUserId() == null || this.dcY.getAuthor() == null || this.dcY.getAuthor().getUserId() == null || !this.bks.getAuthor().getUserId().equals(this.dcY.getAuthor().getUserId())) ? false : true;
    }

    public boolean pu() {
        return this.dde;
    }

    public boolean hasMore() {
        return this.bsT < this.dda;
    }

    public as LC() {
        return this.bks;
    }

    public static g a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            g gVar = new g();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            gVar.e(antiData);
            as asVar = new as();
            asVar.a(dataRes.thread);
            gVar.h(asVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            gVar.b(forumData);
            s sVar = new s();
            sVar.a(dataRes.post, context);
            gVar.a(sVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<s> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                s sVar2 = new s();
                sVar2.a(list.get(i), context);
                arrayList.add(sVar2);
            }
            gVar.W(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            gVar.e(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                gVar.aS(intValue3);
                gVar.setPageSize(intValue2);
                gVar.setTotalCount(intValue4);
                gVar.lO(intValue);
            }
            return gVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
