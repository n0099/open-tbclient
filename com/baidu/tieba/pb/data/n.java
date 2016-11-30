package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class n {
    private bk aNA;
    private int axo;
    private int cfF;
    private AntiData esD;
    public Error esF;
    private ForumData esx;
    private int esB = 20;
    private int esC = -1;
    private boolean esE = false;
    private q esy = null;
    private ArrayList<q> esz = new ArrayList<>();
    private int esA = 1;

    public Error aOF() {
        return this.esF;
    }

    public q aOG() {
        return this.esy;
    }

    public void b(q qVar) {
        this.esy = qVar;
    }

    public int aOH() {
        if (this.esC == -1) {
            this.esC = this.cfF;
        }
        return this.esC;
    }

    public int aOI() {
        return this.esC;
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            setAntiData(nVar.getAntiData());
            this.esC = nVar.mi();
            b(nVar.aOM());
            setPageSize(nVar.aOL());
            c(nVar.Jz());
            setTotalCount(nVar.getTotalCount());
            os(nVar.aLZ());
            this.esz.addAll(0, nVar.aOK());
        }
    }

    public void b(n nVar, boolean z) {
        if (nVar != null) {
            setAntiData(nVar.getAntiData());
            b(nVar.aOM());
            b(nVar.aOG());
            c(nVar.Jz());
            if (nVar.aOK() != null && nVar.aOK().size() > 0) {
                aW(nVar.mi());
                setPageSize(nVar.aOL());
                setTotalCount(nVar.getTotalCount());
                os(nVar.aLZ());
            }
            int size = this.esz.size();
            if (z && size % this.esB != 0) {
                for (int i = 0; i < size % this.esB; i++) {
                    this.esz.remove(this.esz.size() - 1);
                }
            }
            this.esz.addAll(nVar.aOK());
        }
    }

    public void c(n nVar, boolean z) {
        if (nVar != null) {
            setAntiData(nVar.getAntiData());
            b(nVar.aOM());
            b(nVar.aOG());
            c(nVar.Jz());
            if (nVar.aOK() != null && nVar.aOK().size() > 0) {
                aW(nVar.mi());
                setPageSize(nVar.aOL());
                setTotalCount(nVar.getTotalCount());
                os(nVar.aLZ());
            }
            int size = this.esz.size();
            if (z && size % this.esB != 0) {
                for (int i = 0; i < size % this.esB; i++) {
                    this.esz.remove(this.esz.size() - 1);
                }
            }
            this.esz.addAll(nVar.aOK());
            aOJ();
        }
    }

    public void d(n nVar, boolean z) {
        a(nVar, z);
    }

    public void a(n nVar) {
        if (nVar != null) {
            setAntiData(nVar.getAntiData());
            b(nVar.aOM());
            b(nVar.aOG());
            c(nVar.Jz());
            if (nVar.aOK() != null && nVar.aOK().size() > 0) {
                aW(nVar.mi());
                setPageSize(nVar.aOL());
                setTotalCount(nVar.getTotalCount());
                os(nVar.aLZ());
                this.esC = (this.cfF - (((nVar.aOK().size() - 1) + this.esB) / this.esB)) + 1;
                if (this.esC < 0) {
                    this.esC = 0;
                }
            }
            this.esz.addAll(nVar.aOK());
        }
    }

    public void aOJ() {
        if (this.esC < 0) {
            this.esC = this.cfF;
        } else if (this.esC > this.cfF) {
            this.esC = this.cfF;
        }
    }

    public ArrayList<q> aOK() {
        return this.esz;
    }

    public void an(ArrayList<q> arrayList) {
        this.esz = arrayList;
    }

    public int aLZ() {
        return this.esA;
    }

    public void os(int i) {
        this.esA = i;
    }

    public int getTotalCount() {
        return this.axo;
    }

    public void setTotalCount(int i) {
        this.axo = i;
    }

    public int aOL() {
        return this.esB;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.esB = i;
        }
    }

    public int mi() {
        return this.cfF;
    }

    public void aW(int i) {
        this.cfF = i;
    }

    public void b(ForumData forumData) {
        this.esx = forumData;
    }

    public ForumData aOM() {
        return this.esx;
    }

    public void setAntiData(AntiData antiData) {
        this.esD = antiData;
    }

    public AntiData getAntiData() {
        return this.esD;
    }

    public void c(bk bkVar) {
        this.aNA = bkVar;
    }

    public boolean axY() {
        return (this.aNA == null || this.esy == null || this.aNA.getAuthor() == null || this.aNA.getAuthor().getUserId() == null || this.esy.getAuthor() == null || this.esy.getAuthor().getUserId() == null || !this.aNA.getAuthor().getUserId().equals(this.esy.getAuthor().getUserId())) ? false : true;
    }

    public boolean nz() {
        return this.esE;
    }

    public boolean hasMore() {
        return this.cfF < this.esA;
    }

    public bk Jz() {
        return this.aNA;
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
            bk bkVar = new bk();
            bkVar.a(dataRes.thread);
            nVar.c(bkVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            nVar.b(forumData);
            q qVar = new q();
            qVar.a(dataRes.post, context);
            nVar.b(qVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<q> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                q qVar2 = new q();
                qVar2.a(list.get(i), context);
                arrayList.add(qVar2);
            }
            nVar.an(arrayList);
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
                nVar.os(intValue);
            }
            return nVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
