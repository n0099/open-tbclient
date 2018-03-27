package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class k {
    private bd bZU;
    private int buR;
    private ForumData fIl;
    private AntiData fIr;
    public Error fIt;
    private int mCurrentPage;
    private int fIp = 20;
    private int fIq = -1;
    private boolean fIs = false;
    private PostData fIm = null;
    private ArrayList<PostData> fIn = new ArrayList<>();
    private int fIo = 1;

    public Error bbc() {
        return this.fIt;
    }

    public PostData bbd() {
        return this.fIm;
    }

    public void d(PostData postData) {
        this.fIm = postData;
    }

    public int bbe() {
        if (this.fIq == -1) {
            this.fIq = this.mCurrentPage;
        }
        return this.fIq;
    }

    public int bbf() {
        return this.fIq;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbl());
            this.fIq = kVar.SC();
            b(kVar.bbk());
            setPageSize(kVar.bbj());
            T(kVar.WE());
            setTotalCount(kVar.getTotalCount());
            lJ(kVar.bbi());
            this.fIn.addAll(0, kVar.bbh());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbl());
            b(kVar.bbk());
            d(kVar.bbd());
            T(kVar.WE());
            if (kVar.bbh() != null && kVar.bbh().size() > 0) {
                eW(kVar.SC());
                setPageSize(kVar.bbj());
                setTotalCount(kVar.getTotalCount());
                lJ(kVar.bbi());
            }
            int size = this.fIn.size();
            if (z && size % this.fIp != 0) {
                for (int i = 0; i < size % this.fIp; i++) {
                    this.fIn.remove(this.fIn.size() - 1);
                }
            }
            this.fIn.addAll(kVar.bbh());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.bbl());
            b(kVar.bbk());
            d(kVar.bbd());
            T(kVar.WE());
            if (kVar.bbh() != null && kVar.bbh().size() > 0) {
                eW(kVar.SC());
                setPageSize(kVar.bbj());
                setTotalCount(kVar.getTotalCount());
                lJ(kVar.bbi());
            }
            int size = this.fIn.size();
            if (z && size % this.fIp != 0) {
                for (int i = 0; i < size % this.fIp; i++) {
                    this.fIn.remove(this.fIn.size() - 1);
                }
            }
            this.fIn.addAll(kVar.bbh());
            bbg();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.bbl());
            b(kVar.bbk());
            d(kVar.bbd());
            T(kVar.WE());
            if (kVar.bbh() != null && kVar.bbh().size() > 0) {
                eW(kVar.SC());
                setPageSize(kVar.bbj());
                setTotalCount(kVar.getTotalCount());
                lJ(kVar.bbi());
                this.fIq = (this.mCurrentPage - (((kVar.bbh().size() - 1) + this.fIp) / this.fIp)) + 1;
                if (this.fIq < 0) {
                    this.fIq = 0;
                }
            }
            this.fIn.addAll(kVar.bbh());
        }
    }

    public void bbg() {
        if (this.fIq < 0) {
            this.fIq = this.mCurrentPage;
        } else if (this.fIq > this.mCurrentPage) {
            this.fIq = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> bbh() {
        return this.fIn;
    }

    public void ak(ArrayList<PostData> arrayList) {
        this.fIn = arrayList;
    }

    public int bbi() {
        return this.fIo;
    }

    public void lJ(int i) {
        this.fIo = i;
    }

    public int getTotalCount() {
        return this.buR;
    }

    public void setTotalCount(int i) {
        this.buR = i;
    }

    public int bbj() {
        return this.fIp;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.fIp = i;
        }
    }

    public int SC() {
        return this.mCurrentPage;
    }

    public void eW(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.fIl = forumData;
    }

    public ForumData bbk() {
        return this.fIl;
    }

    public void b(AntiData antiData) {
        this.fIr = antiData;
    }

    public AntiData bbl() {
        return this.fIr;
    }

    public void T(bd bdVar) {
        this.bZU = bdVar;
    }

    public boolean aLq() {
        return (this.bZU == null || this.fIm == null || this.bZU.zn() == null || this.bZU.zn().getUserId() == null || this.fIm.zn() == null || this.fIm.zn().getUserId() == null || !this.bZU.zn().getUserId().equals(this.fIm.zn().getUserId())) ? false : true;
    }

    public boolean vX() {
        return this.fIs;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fIo;
    }

    public bd WE() {
        return this.bZU;
    }

    public static k a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            k kVar = new k();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            kVar.b(antiData);
            bd bdVar = new bd();
            bdVar.a(dataRes.thread);
            bdVar.eW(2);
            kVar.T(bdVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            kVar.d(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.ak(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            kVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                kVar.eW(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.lJ(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
