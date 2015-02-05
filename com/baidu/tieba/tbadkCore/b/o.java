package com.baidu.tieba.tbadkCore.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class o {
    private x aDj;
    private int aaL;
    private AntiData bLt;
    private int bWE;
    private ForumData bYU;
    public Error bZb;
    private int bYY = 10;
    private int bYZ = -1;
    private boolean bZa = false;
    private k bYV = null;
    private ArrayList<k> bYW = new ArrayList<>();
    private int bYX = 1;

    public Error ahB() {
        return this.bZb;
    }

    public k ahC() {
        return this.bYV;
    }

    public void d(k kVar) {
        this.bYV = kVar;
    }

    public int ahD() {
        if (this.bYZ == -1) {
            this.bYZ = this.aaL;
        }
        return this.bYZ;
    }

    public void a(o oVar, boolean z) {
        if (oVar != null) {
            b(oVar.abO());
            this.bYZ = oVar.getCurrentPage();
            b(oVar.ahG());
            ia(oVar.ahF());
            f(oVar.ahH());
            setTotalCount(oVar.getTotalCount());
            hZ(oVar.getTotalPage());
            this.bYW.addAll(0, oVar.ahE());
        }
    }

    public void b(o oVar, boolean z) {
        if (oVar != null) {
            b(oVar.abO());
            aL(oVar.getCurrentPage());
            b(oVar.ahG());
            ia(oVar.ahF());
            f(oVar.ahH());
            setTotalCount(oVar.getTotalCount());
            hZ(oVar.getTotalPage());
            int size = this.bYW.size();
            if (z && size % this.bYY != 0) {
                for (int i = 0; i < size % this.bYY; i++) {
                    this.bYW.remove(this.bYW.size() - 1);
                }
            }
            this.bYW.addAll(oVar.ahE());
        }
    }

    public ArrayList<k> ahE() {
        return this.bYW;
    }

    public void Q(ArrayList<k> arrayList) {
        this.bYW = arrayList;
    }

    public int getTotalPage() {
        return this.bYX;
    }

    public void hZ(int i) {
        this.bYX = i;
    }

    public int getTotalCount() {
        return this.bWE;
    }

    public void setTotalCount(int i) {
        this.bWE = i;
    }

    public int ahF() {
        return this.bYY;
    }

    public void ia(int i) {
        if (i != 0) {
            this.bYY = i;
        }
    }

    public int getCurrentPage() {
        return this.aaL;
    }

    public void aL(int i) {
        this.aaL = i;
    }

    public void b(ForumData forumData) {
        this.bYU = forumData;
    }

    public ForumData ahG() {
        return this.bYU;
    }

    public void b(AntiData antiData) {
        this.bLt = antiData;
    }

    public AntiData abO() {
        return this.bLt;
    }

    public void f(x xVar) {
        this.aDj = xVar;
    }

    public boolean RM() {
        return (this.aDj == null || this.bYV == null || this.aDj.getAuthor() == null || this.aDj.getAuthor().getUserId() == null || this.bYV.getAuthor() == null || this.bYV.getAuthor().getUserId() == null || !this.aDj.getAuthor().getUserId().equals(this.bYV.getAuthor().getUserId())) ? false : true;
    }

    public boolean lb() {
        return this.bZa;
    }

    public boolean hasMore() {
        return this.aaL < this.bYX && this.aaL * this.bYY < 200;
    }

    public x ahH() {
        return this.aDj;
    }

    public static o a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            o oVar = new o();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            oVar.b(antiData);
            x xVar = new x();
            xVar.a(dataRes.thread);
            oVar.f(xVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            oVar.b(forumData);
            k kVar = new k();
            kVar.a(dataRes.post, context);
            oVar.d(kVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<k> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                k kVar2 = new k();
                kVar2.a(list.get(i), context);
                arrayList.add(kVar2);
            }
            oVar.Q(arrayList);
            Page page = dataRes.page;
            int intValue = page.total_page.intValue();
            int intValue2 = page.page_size.intValue() == 0 ? page.page_size.intValue() : 10;
            int intValue3 = page.current_page.intValue();
            int intValue4 = page.total_count.intValue();
            oVar.aL(intValue3);
            oVar.ia(intValue2);
            oVar.setTotalCount(intValue4);
            oVar.hZ(intValue);
            return oVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void Y(boolean z) {
        this.bZa = z;
    }
}
