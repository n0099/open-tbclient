package com.baidu.tieba.pb.a;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.w;
import com.baidu.tieba.tbadkCore.data.j;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class c {
    private w aLp;
    private int aXk;
    private int bCZ;
    private ForumData bJP;
    private AntiData bJV;
    public Error bJX;
    private int bJT = 20;
    private int bJU = -1;
    private boolean bJW = false;
    private j bJQ = null;
    private ArrayList<j> bJR = new ArrayList<>();
    private int bJS = 1;

    public Error aaA() {
        return this.bJX;
    }

    public j aaB() {
        return this.bJQ;
    }

    public void a(j jVar) {
        this.bJQ = jVar;
    }

    public int aaC() {
        if (this.bJU == -1) {
            this.bJU = this.aXk;
        }
        return this.bJU;
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            a(cVar.aaH());
            this.bJU = cVar.getCurrentPage();
            b(cVar.aaG());
            setPageSize(cVar.aaF());
            d(cVar.aaI());
            setTotalCount(cVar.getTotalCount());
            hw(cVar.aaE());
            this.bJR.addAll(0, cVar.aaD());
        }
    }

    public void b(c cVar, boolean z) {
        if (cVar != null) {
            a(cVar.aaH());
            b(cVar.aaG());
            a(cVar.aaB());
            d(cVar.aaI());
            if (cVar.aaD() != null || cVar.aaD().size() > 0) {
                aJ(cVar.getCurrentPage());
                setPageSize(cVar.aaF());
                setTotalCount(cVar.getTotalCount());
                hw(cVar.aaE());
            }
            int size = this.bJR.size();
            if (z && size % this.bJT != 0) {
                for (int i = 0; i < size % this.bJT; i++) {
                    this.bJR.remove(this.bJR.size() - 1);
                }
            }
            this.bJR.addAll(cVar.aaD());
        }
    }

    public ArrayList<j> aaD() {
        return this.bJR;
    }

    public void J(ArrayList<j> arrayList) {
        this.bJR = arrayList;
    }

    public int aaE() {
        return this.bJS;
    }

    public void hw(int i) {
        this.bJS = i;
    }

    public int getTotalCount() {
        return this.bCZ;
    }

    public void setTotalCount(int i) {
        this.bCZ = i;
    }

    public int aaF() {
        return this.bJT;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.bJT = i;
        }
    }

    public int getCurrentPage() {
        return this.aXk;
    }

    public void aJ(int i) {
        this.aXk = i;
    }

    public void b(ForumData forumData) {
        this.bJP = forumData;
    }

    public ForumData aaG() {
        return this.bJP;
    }

    public void a(AntiData antiData) {
        this.bJV = antiData;
    }

    public AntiData aaH() {
        return this.bJV;
    }

    public void d(w wVar) {
        this.aLp = wVar;
    }

    public boolean Us() {
        return (this.aLp == null || this.bJQ == null || this.aLp.getAuthor() == null || this.aLp.getAuthor().getUserId() == null || this.bJQ.getAuthor() == null || this.bJQ.getAuthor().getUserId() == null || !this.aLp.getAuthor().getUserId().equals(this.bJQ.getAuthor().getUserId())) ? false : true;
    }

    public boolean pq() {
        return this.bJW;
    }

    public boolean hasMore() {
        return this.aXk < this.bJS;
    }

    public w aaI() {
        return this.aLp;
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
            cVar.J(arrayList);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                cVar.aJ(intValue3);
                cVar.setPageSize(intValue2);
                cVar.setTotalCount(intValue4);
                cVar.hw(intValue);
            }
            return cVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
