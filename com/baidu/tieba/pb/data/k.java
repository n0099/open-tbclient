package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class k {
    private AntiData aBN;
    private int aOE;
    private ForumData aOm;
    private bb buy;
    public boolean dJN;
    public Error ftt;
    private int mCurrentPage;
    private int dUX = 20;
    private int ftr = -1;
    private boolean fts = false;
    private PostData fto = null;
    private ArrayList<PostData> ftp = new ArrayList<>();
    private int ftq = 1;

    public Error aZT() {
        return this.ftt;
    }

    public PostData aZU() {
        return this.fto;
    }

    public void d(PostData postData) {
        this.fto = postData;
    }

    public int aZV() {
        if (this.ftr == -1) {
            this.ftr = this.mCurrentPage;
        }
        return this.ftr;
    }

    public int aZW() {
        return this.ftr;
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.Cb());
            this.ftr = kVar.OV();
            a(kVar.bab());
            setPageSize(kVar.baa());
            Z(kVar.Tg());
            setTotalCount(kVar.getTotalCount());
            jd(kVar.aZZ());
            this.ftp.addAll(0, kVar.aZY());
        }
    }

    public void b(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.Cb());
            a(kVar.bab());
            d(kVar.aZU());
            Z(kVar.Tg());
            if (kVar.aZY() != null && kVar.aZY().size() > 0) {
                ca(kVar.OV());
                setPageSize(kVar.baa());
                setTotalCount(kVar.getTotalCount());
                jd(kVar.aZZ());
            }
            int size = this.ftp.size();
            if (z && size % this.dUX != 0) {
                for (int i = 0; i < size % this.dUX; i++) {
                    this.ftp.remove(this.ftp.size() - 1);
                }
            }
            this.ftp.addAll(kVar.aZY());
        }
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            b(kVar.Cb());
            a(kVar.bab());
            d(kVar.aZU());
            Z(kVar.Tg());
            if (kVar.aZY() != null && kVar.aZY().size() > 0) {
                ca(kVar.OV());
                setPageSize(kVar.baa());
                setTotalCount(kVar.getTotalCount());
                jd(kVar.aZZ());
            }
            int size = this.ftp.size();
            if (z && size % this.dUX != 0) {
                for (int i = 0; i < size % this.dUX; i++) {
                    this.ftp.remove(this.ftp.size() - 1);
                }
            }
            this.ftp.addAll(kVar.aZY());
            aZX();
        }
    }

    public void d(k kVar, boolean z) {
        a(kVar, z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            b(kVar.Cb());
            a(kVar.bab());
            d(kVar.aZU());
            Z(kVar.Tg());
            if (kVar.aZY() != null && kVar.aZY().size() > 0) {
                ca(kVar.OV());
                setPageSize(kVar.baa());
                setTotalCount(kVar.getTotalCount());
                jd(kVar.aZZ());
                this.ftr = (this.mCurrentPage - (((kVar.aZY().size() - 1) + this.dUX) / this.dUX)) + 1;
                if (this.ftr < 0) {
                    this.ftr = 0;
                }
            }
            this.ftp.addAll(kVar.aZY());
        }
    }

    public void aZX() {
        if (this.ftr < 0) {
            this.ftr = this.mCurrentPage;
        } else if (this.ftr > this.mCurrentPage) {
            this.ftr = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aZY() {
        return this.ftp;
    }

    public void an(ArrayList<PostData> arrayList) {
        this.ftp = arrayList;
    }

    public int aZZ() {
        return this.ftq;
    }

    public void jd(int i) {
        this.ftq = i;
    }

    public int getTotalCount() {
        return this.aOE;
    }

    public void setTotalCount(int i) {
        this.aOE = i;
    }

    public int baa() {
        return this.dUX;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.dUX = i;
        }
    }

    public int OV() {
        return this.mCurrentPage;
    }

    public void ca(int i) {
        this.mCurrentPage = i;
    }

    public void a(ForumData forumData) {
        this.aOm = forumData;
    }

    public ForumData bab() {
        return this.aOm;
    }

    public void b(AntiData antiData) {
        this.aBN = antiData;
    }

    public AntiData Cb() {
        return this.aBN;
    }

    public void Z(bb bbVar) {
        this.buy = bbVar;
    }

    public boolean aMK() {
        return (this.buy == null || this.fto == null || this.buy.vj() == null || this.buy.vj().getUserId() == null || this.fto.vj() == null || this.fto.vj().getUserId() == null || !this.buy.vj().getUserId().equals(this.fto.vj().getUserId())) ? false : true;
    }

    public boolean rL() {
        return this.fts;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.ftq;
    }

    public bb Tg() {
        return this.buy;
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
            bb bbVar = new bb();
            bbVar.a(dataRes.thread);
            bbVar.ca(2);
            kVar.Z(bbVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            kVar.a(forumData);
            kVar.dJN = forumData.isBrandForum;
            PostData postData = new PostData();
            postData.js(forumData.isBrandForum);
            postData.a(dataRes.post, context);
            kVar.d(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.js(forumData.isBrandForum);
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            kVar.an(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            kVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                kVar.ca(intValue3);
                kVar.setPageSize(intValue2);
                kVar.setTotalCount(intValue4);
                kVar.jd(intValue);
            }
            return kVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
