package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.tbadkCore.data.s;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class h {
    private int asi;
    private ax bgt;
    private int brH;
    private ForumData dfr;
    private AntiData dfx;
    public Error dfz;
    private int dfv = 20;
    private int dfw = -1;
    private boolean dfy = false;
    private s dfs = null;
    private ArrayList<s> dft = new ArrayList<>();
    private int dfu = 1;

    public Error avN() {
        return this.dfz;
    }

    public s avO() {
        return this.dfs;
    }

    public void a(s sVar) {
        this.dfs = sVar;
    }

    public int avP() {
        if (this.dfw == -1) {
            this.dfw = this.brH;
        }
        return this.dfw;
    }

    public int avQ() {
        return this.dfw;
    }

    public void a(h hVar, boolean z) {
        if (hVar != null) {
            setAntiData(hVar.getAntiData());
            this.dfw = hVar.lk();
            b(hVar.avV());
            setPageSize(hVar.avU());
            l(hVar.Kl());
            setTotalCount(hVar.getTotalCount());
            lC(hVar.avT());
            this.dft.addAll(0, hVar.avS());
        }
    }

    public void b(h hVar, boolean z) {
        if (hVar != null) {
            setAntiData(hVar.getAntiData());
            b(hVar.avV());
            a(hVar.avO());
            l(hVar.Kl());
            if (hVar.avS() != null && hVar.avS().size() > 0) {
                aG(hVar.lk());
                setPageSize(hVar.avU());
                setTotalCount(hVar.getTotalCount());
                lC(hVar.avT());
            }
            int size = this.dft.size();
            if (z && size % this.dfv != 0) {
                for (int i = 0; i < size % this.dfv; i++) {
                    this.dft.remove(this.dft.size() - 1);
                }
            }
            this.dft.addAll(hVar.avS());
        }
    }

    public void c(h hVar, boolean z) {
        if (hVar != null) {
            setAntiData(hVar.getAntiData());
            b(hVar.avV());
            a(hVar.avO());
            l(hVar.Kl());
            if (hVar.avS() != null && hVar.avS().size() > 0) {
                aG(hVar.lk());
                setPageSize(hVar.avU());
                setTotalCount(hVar.getTotalCount());
                lC(hVar.avT());
            }
            int size = this.dft.size();
            if (z && size % this.dfv != 0) {
                for (int i = 0; i < size % this.dfv; i++) {
                    this.dft.remove(this.dft.size() - 1);
                }
            }
            this.dft.addAll(hVar.avS());
            avR();
        }
    }

    public void d(h hVar, boolean z) {
        a(hVar, z);
    }

    public void a(h hVar) {
        if (hVar != null) {
            setAntiData(hVar.getAntiData());
            b(hVar.avV());
            a(hVar.avO());
            l(hVar.Kl());
            if (hVar.avS() != null && hVar.avS().size() > 0) {
                aG(hVar.lk());
                setPageSize(hVar.avU());
                setTotalCount(hVar.getTotalCount());
                lC(hVar.avT());
                this.dfw = (this.brH - (((hVar.avS().size() - 1) + this.dfv) / this.dfv)) + 1;
                if (this.dfw < 0) {
                    this.dfw = 0;
                }
            }
            this.dft.addAll(hVar.avS());
        }
    }

    public void avR() {
        if (this.dfw < 0) {
            this.dfw = this.brH;
        } else if (this.dfw > this.brH) {
            this.dfw = this.brH;
        }
    }

    public ArrayList<s> avS() {
        return this.dft;
    }

    public void Y(ArrayList<s> arrayList) {
        this.dft = arrayList;
    }

    public int avT() {
        return this.dfu;
    }

    public void lC(int i) {
        this.dfu = i;
    }

    public int getTotalCount() {
        return this.asi;
    }

    public void setTotalCount(int i) {
        this.asi = i;
    }

    public int avU() {
        return this.dfv;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.dfv = i;
        }
    }

    public int lk() {
        return this.brH;
    }

    public void aG(int i) {
        this.brH = i;
    }

    public void b(ForumData forumData) {
        this.dfr = forumData;
    }

    public ForumData avV() {
        return this.dfr;
    }

    public void setAntiData(AntiData antiData) {
        this.dfx = antiData;
    }

    public AntiData getAntiData() {
        return this.dfx;
    }

    public void l(ax axVar) {
        this.bgt = axVar;
    }

    public boolean ahN() {
        return (this.bgt == null || this.dfs == null || this.bgt.getAuthor() == null || this.bgt.getAuthor().getUserId() == null || this.dfs.getAuthor() == null || this.dfs.getAuthor().getUserId() == null || !this.bgt.getAuthor().getUserId().equals(this.dfs.getAuthor().getUserId())) ? false : true;
    }

    public boolean mP() {
        return this.dfy;
    }

    public boolean hasMore() {
        return this.brH < this.dfu;
    }

    public ax Kl() {
        return this.bgt;
    }

    public static h a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            h hVar = new h();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            hVar.setAntiData(antiData);
            ax axVar = new ax();
            axVar.a(dataRes.thread);
            hVar.l(axVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            hVar.b(forumData);
            s sVar = new s();
            sVar.a(dataRes.post, context);
            hVar.a(sVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<s> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                s sVar2 = new s();
                sVar2.a(list.get(i), context);
                arrayList.add(sVar2);
            }
            hVar.Y(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            hVar.setAntiData(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                hVar.aG(intValue3);
                hVar.setPageSize(intValue2);
                hVar.setTotalCount(intValue4);
                hVar.lC(intValue);
            }
            return hVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
