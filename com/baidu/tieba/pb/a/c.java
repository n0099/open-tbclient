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
    private w aLo;
    private int aXj;
    private int bCY;
    private ForumData bJO;
    private AntiData bJU;
    public Error bJW;
    private int bJS = 20;
    private int bJT = -1;
    private boolean bJV = false;
    private j bJP = null;
    private ArrayList<j> bJQ = new ArrayList<>();
    private int bJR = 1;

    public Error aaz() {
        return this.bJW;
    }

    public j aaA() {
        return this.bJP;
    }

    public void a(j jVar) {
        this.bJP = jVar;
    }

    public int aaB() {
        if (this.bJT == -1) {
            this.bJT = this.aXj;
        }
        return this.bJT;
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            a(cVar.aaG());
            this.bJT = cVar.getCurrentPage();
            b(cVar.aaF());
            setPageSize(cVar.aaE());
            d(cVar.aaH());
            setTotalCount(cVar.getTotalCount());
            hw(cVar.aaD());
            this.bJQ.addAll(0, cVar.aaC());
        }
    }

    public void b(c cVar, boolean z) {
        if (cVar != null) {
            a(cVar.aaG());
            b(cVar.aaF());
            a(cVar.aaA());
            d(cVar.aaH());
            if (cVar.aaC() != null || cVar.aaC().size() > 0) {
                aJ(cVar.getCurrentPage());
                setPageSize(cVar.aaE());
                setTotalCount(cVar.getTotalCount());
                hw(cVar.aaD());
            }
            int size = this.bJQ.size();
            if (z && size % this.bJS != 0) {
                for (int i = 0; i < size % this.bJS; i++) {
                    this.bJQ.remove(this.bJQ.size() - 1);
                }
            }
            this.bJQ.addAll(cVar.aaC());
        }
    }

    public ArrayList<j> aaC() {
        return this.bJQ;
    }

    public void J(ArrayList<j> arrayList) {
        this.bJQ = arrayList;
    }

    public int aaD() {
        return this.bJR;
    }

    public void hw(int i) {
        this.bJR = i;
    }

    public int getTotalCount() {
        return this.bCY;
    }

    public void setTotalCount(int i) {
        this.bCY = i;
    }

    public int aaE() {
        return this.bJS;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.bJS = i;
        }
    }

    public int getCurrentPage() {
        return this.aXj;
    }

    public void aJ(int i) {
        this.aXj = i;
    }

    public void b(ForumData forumData) {
        this.bJO = forumData;
    }

    public ForumData aaF() {
        return this.bJO;
    }

    public void a(AntiData antiData) {
        this.bJU = antiData;
    }

    public AntiData aaG() {
        return this.bJU;
    }

    public void d(w wVar) {
        this.aLo = wVar;
    }

    public boolean Ur() {
        return (this.aLo == null || this.bJP == null || this.aLo.getAuthor() == null || this.aLo.getAuthor().getUserId() == null || this.bJP.getAuthor() == null || this.bJP.getAuthor().getUserId() == null || !this.aLo.getAuthor().getUserId().equals(this.bJP.getAuthor().getUserId())) ? false : true;
    }

    public boolean pq() {
        return this.bJV;
    }

    public boolean hasMore() {
        return this.aXj < this.bJR;
    }

    public w aaH() {
        return this.aLo;
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
