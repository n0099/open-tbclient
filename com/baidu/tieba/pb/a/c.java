package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.w;
import com.baidu.tieba.tbadkCore.c.j;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class c {
    private w aJg;
    private int aUA;
    private int bAk;
    private AntiData bHF;
    public Error bHH;
    private ForumData bHz;
    private int bHD = 20;
    private int bHE = -1;
    private boolean bHG = false;
    private j bHA = null;
    private ArrayList<j> bHB = new ArrayList<>();
    private int bHC = 1;

    public Error Zi() {
        return this.bHH;
    }

    public j Zj() {
        return this.bHA;
    }

    public void a(j jVar) {
        this.bHA = jVar;
    }

    public int Zk() {
        if (this.bHE == -1) {
            this.bHE = this.aUA;
        }
        return this.bHE;
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            a(cVar.Zp());
            this.bHE = cVar.getCurrentPage();
            b(cVar.Zo());
            hi(cVar.Zn());
            d(cVar.Zq());
            setTotalCount(cVar.getTotalCount());
            hh(cVar.Zm());
            this.bHB.addAll(0, cVar.Zl());
        }
    }

    public void b(c cVar, boolean z) {
        if (cVar != null && cVar.Zl() != null && cVar.Zl().size() != 0) {
            a(cVar.Zp());
            aM(cVar.getCurrentPage());
            b(cVar.Zo());
            hi(cVar.Zn());
            d(cVar.Zq());
            setTotalCount(cVar.getTotalCount());
            hh(cVar.Zm());
            int size = this.bHB.size();
            if (z && size % this.bHD != 0) {
                for (int i = 0; i < size % this.bHD; i++) {
                    this.bHB.remove(this.bHB.size() - 1);
                }
            }
            this.bHB.addAll(cVar.Zl());
        }
    }

    public ArrayList<j> Zl() {
        return this.bHB;
    }

    public void M(ArrayList<j> arrayList) {
        this.bHB = arrayList;
    }

    public int Zm() {
        return this.bHC;
    }

    public void hh(int i) {
        this.bHC = i;
    }

    public int getTotalCount() {
        return this.bAk;
    }

    public void setTotalCount(int i) {
        this.bAk = i;
    }

    public int Zn() {
        return this.bHD;
    }

    public void hi(int i) {
        if (i != 0) {
            this.bHD = i;
        }
    }

    public int getCurrentPage() {
        return this.aUA;
    }

    public void aM(int i) {
        this.aUA = i;
    }

    public void b(ForumData forumData) {
        this.bHz = forumData;
    }

    public ForumData Zo() {
        return this.bHz;
    }

    public void a(AntiData antiData) {
        this.bHF = antiData;
    }

    public AntiData Zp() {
        return this.bHF;
    }

    public void d(w wVar) {
        this.aJg = wVar;
    }

    public boolean Te() {
        return (this.aJg == null || this.bHA == null || this.aJg.getAuthor() == null || this.aJg.getAuthor().getUserId() == null || this.bHA.getAuthor() == null || this.bHA.getAuthor().getUserId() == null || !this.aJg.getAuthor().getUserId().equals(this.bHA.getAuthor().getUserId())) ? false : true;
    }

    public boolean oQ() {
        return this.bHG;
    }

    public boolean hasMore() {
        return this.aUA < this.bHC;
    }

    public w Zq() {
        return this.aJg;
    }

    public static c a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            c cVar = new c();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            cVar.a(antiData);
            w wVar = new w();
            wVar.a(dataRes.thread);
            cVar.d(wVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            cVar.b(forumData);
            j jVar = new j();
            jVar.a(dataRes.post, context);
            cVar.a(jVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<j> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                j jVar2 = new j();
                jVar2.a(list.get(i), context);
                arrayList.add(jVar2);
            }
            cVar.M(arrayList);
            Page page = dataRes.page;
            int intValue = page.total_page.intValue();
            int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
            int intValue3 = page.current_page.intValue();
            int intValue4 = page.total_count.intValue();
            cVar.aM(intValue3);
            cVar.hi(intValue2);
            cVar.setTotalCount(intValue4);
            cVar.hh(intValue);
            return cVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void W(boolean z) {
        this.bHG = z;
    }
}
