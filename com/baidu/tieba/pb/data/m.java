package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.tbadkCore.data.s;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class m {
    private int asY;
    private az bCH;
    private int bPk;
    private ForumData dMk;
    private AntiData dMq;
    public Error dMs;
    private int dMo = 20;
    private int dMp = -1;
    private boolean dMr = false;
    private s dMl = null;
    private ArrayList<s> dMm = new ArrayList<>();
    private int dMn = 1;

    public Error aEd() {
        return this.dMs;
    }

    public s aEe() {
        return this.dMl;
    }

    public void a(s sVar) {
        this.dMl = sVar;
    }

    public int aEf() {
        if (this.dMp == -1) {
            this.dMp = this.bPk;
        }
        return this.dMp;
    }

    public int aEg() {
        return this.dMp;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            this.dMp = mVar.lo();
            b(mVar.aEl());
            setPageSize(mVar.aEk());
            p(mVar.Ix());
            setTotalCount(mVar.getTotalCount());
            nd(mVar.aEj());
            this.dMm.addAll(0, mVar.aEi());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            b(mVar.aEl());
            a(mVar.aEe());
            p(mVar.Ix());
            if (mVar.aEi() != null && mVar.aEi().size() > 0) {
                aG(mVar.lo());
                setPageSize(mVar.aEk());
                setTotalCount(mVar.getTotalCount());
                nd(mVar.aEj());
            }
            int size = this.dMm.size();
            if (z && size % this.dMo != 0) {
                for (int i = 0; i < size % this.dMo; i++) {
                    this.dMm.remove(this.dMm.size() - 1);
                }
            }
            this.dMm.addAll(mVar.aEi());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            b(mVar.aEl());
            a(mVar.aEe());
            p(mVar.Ix());
            if (mVar.aEi() != null && mVar.aEi().size() > 0) {
                aG(mVar.lo());
                setPageSize(mVar.aEk());
                setTotalCount(mVar.getTotalCount());
                nd(mVar.aEj());
            }
            int size = this.dMm.size();
            if (z && size % this.dMo != 0) {
                for (int i = 0; i < size % this.dMo; i++) {
                    this.dMm.remove(this.dMm.size() - 1);
                }
            }
            this.dMm.addAll(mVar.aEi());
            aEh();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            setAntiData(mVar.getAntiData());
            b(mVar.aEl());
            a(mVar.aEe());
            p(mVar.Ix());
            if (mVar.aEi() != null && mVar.aEi().size() > 0) {
                aG(mVar.lo());
                setPageSize(mVar.aEk());
                setTotalCount(mVar.getTotalCount());
                nd(mVar.aEj());
                this.dMp = (this.bPk - (((mVar.aEi().size() - 1) + this.dMo) / this.dMo)) + 1;
                if (this.dMp < 0) {
                    this.dMp = 0;
                }
            }
            this.dMm.addAll(mVar.aEi());
        }
    }

    public void aEh() {
        if (this.dMp < 0) {
            this.dMp = this.bPk;
        } else if (this.dMp > this.bPk) {
            this.dMp = this.bPk;
        }
    }

    public ArrayList<s> aEi() {
        return this.dMm;
    }

    public void ai(ArrayList<s> arrayList) {
        this.dMm = arrayList;
    }

    public int aEj() {
        return this.dMn;
    }

    public void nd(int i) {
        this.dMn = i;
    }

    public int getTotalCount() {
        return this.asY;
    }

    public void setTotalCount(int i) {
        this.asY = i;
    }

    public int aEk() {
        return this.dMo;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.dMo = i;
        }
    }

    public int lo() {
        return this.bPk;
    }

    public void aG(int i) {
        this.bPk = i;
    }

    public void b(ForumData forumData) {
        this.dMk = forumData;
    }

    public ForumData aEl() {
        return this.dMk;
    }

    public void setAntiData(AntiData antiData) {
        this.dMq = antiData;
    }

    public AntiData getAntiData() {
        return this.dMq;
    }

    public void p(az azVar) {
        this.bCH = azVar;
    }

    public boolean aqc() {
        return (this.bCH == null || this.dMl == null || this.bCH.getAuthor() == null || this.bCH.getAuthor().getUserId() == null || this.dMl.getAuthor() == null || this.dMl.getAuthor().getUserId() == null || !this.bCH.getAuthor().getUserId().equals(this.dMl.getAuthor().getUserId())) ? false : true;
    }

    public boolean mK() {
        return this.dMr;
    }

    public boolean hasMore() {
        return this.bPk < this.dMn;
    }

    public az Ix() {
        return this.bCH;
    }

    public static m a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            m mVar = new m();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            mVar.setAntiData(antiData);
            az azVar = new az();
            azVar.a(dataRes.thread);
            mVar.p(azVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            mVar.b(forumData);
            s sVar = new s();
            sVar.a(dataRes.post, context);
            mVar.a(sVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<s> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                s sVar2 = new s();
                sVar2.a(list.get(i), context);
                arrayList.add(sVar2);
            }
            mVar.ai(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            mVar.setAntiData(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                mVar.aG(intValue3);
                mVar.setPageSize(intValue2);
                mVar.setTotalCount(intValue4);
                mVar.nd(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
