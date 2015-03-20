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
    private w aIY;
    private int aUl;
    private ForumData bHm;
    private AntiData bHs;
    public Error bHu;
    private int bzX;
    private int bHq = 20;
    private int bHr = -1;
    private boolean bHt = false;
    private j bHn = null;
    private ArrayList<j> bHo = new ArrayList<>();
    private int bHp = 1;

    public Error YW() {
        return this.bHu;
    }

    public j YX() {
        return this.bHn;
    }

    public void a(j jVar) {
        this.bHn = jVar;
    }

    public int YY() {
        if (this.bHr == -1) {
            this.bHr = this.aUl;
        }
        return this.bHr;
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            a(cVar.Zc());
            this.bHr = cVar.getCurrentPage();
            b(cVar.Zb());
            hg(cVar.Za());
            d(cVar.Zd());
            setTotalCount(cVar.getTotalCount());
            hf(cVar.getTotalPage());
            this.bHo.addAll(0, cVar.YZ());
        }
    }

    public void b(c cVar, boolean z) {
        if (cVar != null) {
            a(cVar.Zc());
            aM(cVar.getCurrentPage());
            b(cVar.Zb());
            hg(cVar.Za());
            d(cVar.Zd());
            setTotalCount(cVar.getTotalCount());
            hf(cVar.getTotalPage());
            int size = this.bHo.size();
            if (z && size % this.bHq != 0) {
                for (int i = 0; i < size % this.bHq; i++) {
                    this.bHo.remove(this.bHo.size() - 1);
                }
            }
            this.bHo.addAll(cVar.YZ());
        }
    }

    public ArrayList<j> YZ() {
        return this.bHo;
    }

    public void K(ArrayList<j> arrayList) {
        this.bHo = arrayList;
    }

    public int getTotalPage() {
        return this.bHp;
    }

    public void hf(int i) {
        this.bHp = i;
    }

    public int getTotalCount() {
        return this.bzX;
    }

    public void setTotalCount(int i) {
        this.bzX = i;
    }

    public int Za() {
        return this.bHq;
    }

    public void hg(int i) {
        if (i != 0) {
            this.bHq = i;
        }
    }

    public int getCurrentPage() {
        return this.aUl;
    }

    public void aM(int i) {
        this.aUl = i;
    }

    public void b(ForumData forumData) {
        this.bHm = forumData;
    }

    public ForumData Zb() {
        return this.bHm;
    }

    public void a(AntiData antiData) {
        this.bHs = antiData;
    }

    public AntiData Zc() {
        return this.bHs;
    }

    public void d(w wVar) {
        this.aIY = wVar;
    }

    public boolean SR() {
        return (this.aIY == null || this.bHn == null || this.aIY.getAuthor() == null || this.aIY.getAuthor().getUserId() == null || this.bHn.getAuthor() == null || this.bHn.getAuthor().getUserId() == null || !this.aIY.getAuthor().getUserId().equals(this.bHn.getAuthor().getUserId())) ? false : true;
    }

    public boolean oQ() {
        return this.bHt;
    }

    public boolean hasMore() {
        return this.aUl < this.bHp && this.aUl * this.bHq < 200;
    }

    public w Zd() {
        return this.aIY;
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
            cVar.K(arrayList);
            Page page = dataRes.page;
            int intValue = page.total_page.intValue();
            int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
            int intValue3 = page.current_page.intValue();
            int intValue4 = page.total_count.intValue();
            cVar.aM(intValue3);
            cVar.hg(intValue2);
            cVar.setTotalCount(intValue4);
            cVar.hf(intValue);
            return cVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void W(boolean z) {
        this.bHt = z;
    }
}
