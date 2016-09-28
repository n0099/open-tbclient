package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class n {
    private bi aLV;
    private int awx;
    private int cci;
    private ForumData emA;
    private AntiData emG;
    public Error emI;
    private int emE = 20;
    private int emF = -1;
    private boolean emH = false;
    private q emB = null;
    private ArrayList<q> emC = new ArrayList<>();
    private int emD = 1;

    public Error aMM() {
        return this.emI;
    }

    public q aMN() {
        return this.emB;
    }

    public void a(q qVar) {
        this.emB = qVar;
    }

    public int aMO() {
        if (this.emF == -1) {
            this.emF = this.cci;
        }
        return this.emF;
    }

    public int aMP() {
        return this.emF;
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            setAntiData(nVar.getAntiData());
            this.emF = nVar.mf();
            b(nVar.aMT());
            setPageSize(nVar.aMS());
            b(nVar.Jv());
            setTotalCount(nVar.getTotalCount());
            oi(nVar.aKg());
            this.emC.addAll(0, nVar.aMR());
        }
    }

    public void b(n nVar, boolean z) {
        if (nVar != null) {
            setAntiData(nVar.getAntiData());
            b(nVar.aMT());
            a(nVar.aMN());
            b(nVar.Jv());
            if (nVar.aMR() != null && nVar.aMR().size() > 0) {
                aW(nVar.mf());
                setPageSize(nVar.aMS());
                setTotalCount(nVar.getTotalCount());
                oi(nVar.aKg());
            }
            int size = this.emC.size();
            if (z && size % this.emE != 0) {
                for (int i = 0; i < size % this.emE; i++) {
                    this.emC.remove(this.emC.size() - 1);
                }
            }
            this.emC.addAll(nVar.aMR());
        }
    }

    public void c(n nVar, boolean z) {
        if (nVar != null) {
            setAntiData(nVar.getAntiData());
            b(nVar.aMT());
            a(nVar.aMN());
            b(nVar.Jv());
            if (nVar.aMR() != null && nVar.aMR().size() > 0) {
                aW(nVar.mf());
                setPageSize(nVar.aMS());
                setTotalCount(nVar.getTotalCount());
                oi(nVar.aKg());
            }
            int size = this.emC.size();
            if (z && size % this.emE != 0) {
                for (int i = 0; i < size % this.emE; i++) {
                    this.emC.remove(this.emC.size() - 1);
                }
            }
            this.emC.addAll(nVar.aMR());
            aMQ();
        }
    }

    public void d(n nVar, boolean z) {
        a(nVar, z);
    }

    public void a(n nVar) {
        if (nVar != null) {
            setAntiData(nVar.getAntiData());
            b(nVar.aMT());
            a(nVar.aMN());
            b(nVar.Jv());
            if (nVar.aMR() != null && nVar.aMR().size() > 0) {
                aW(nVar.mf());
                setPageSize(nVar.aMS());
                setTotalCount(nVar.getTotalCount());
                oi(nVar.aKg());
                this.emF = (this.cci - (((nVar.aMR().size() - 1) + this.emE) / this.emE)) + 1;
                if (this.emF < 0) {
                    this.emF = 0;
                }
            }
            this.emC.addAll(nVar.aMR());
        }
    }

    public void aMQ() {
        if (this.emF < 0) {
            this.emF = this.cci;
        } else if (this.emF > this.cci) {
            this.emF = this.cci;
        }
    }

    public ArrayList<q> aMR() {
        return this.emC;
    }

    public void ak(ArrayList<q> arrayList) {
        this.emC = arrayList;
    }

    public int aKg() {
        return this.emD;
    }

    public void oi(int i) {
        this.emD = i;
    }

    public int getTotalCount() {
        return this.awx;
    }

    public void setTotalCount(int i) {
        this.awx = i;
    }

    public int aMS() {
        return this.emE;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.emE = i;
        }
    }

    public int mf() {
        return this.cci;
    }

    public void aW(int i) {
        this.cci = i;
    }

    public void b(ForumData forumData) {
        this.emA = forumData;
    }

    public ForumData aMT() {
        return this.emA;
    }

    public void setAntiData(AntiData antiData) {
        this.emG = antiData;
    }

    public AntiData getAntiData() {
        return this.emG;
    }

    public void b(bi biVar) {
        this.aLV = biVar;
    }

    public boolean awb() {
        return (this.aLV == null || this.emB == null || this.aLV.getAuthor() == null || this.aLV.getAuthor().getUserId() == null || this.emB.getAuthor() == null || this.emB.getAuthor().getUserId() == null || !this.aLV.getAuthor().getUserId().equals(this.emB.getAuthor().getUserId())) ? false : true;
    }

    public boolean nv() {
        return this.emH;
    }

    public boolean hasMore() {
        return this.cci < this.emD;
    }

    public bi Jv() {
        return this.aLV;
    }

    public static n a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            n nVar = new n();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            nVar.setAntiData(antiData);
            bi biVar = new bi();
            biVar.a(dataRes.thread);
            nVar.b(biVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            nVar.b(forumData);
            q qVar = new q();
            qVar.a(dataRes.post, context);
            nVar.a(qVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<q> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                q qVar2 = new q();
                qVar2.a(list.get(i), context);
                arrayList.add(qVar2);
            }
            nVar.ak(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            nVar.setAntiData(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                nVar.aW(intValue3);
                nVar.setPageSize(intValue2);
                nVar.setTotalCount(intValue4);
                nVar.oi(intValue);
            }
            return nVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
