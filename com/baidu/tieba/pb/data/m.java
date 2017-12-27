package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes2.dex */
public class m {
    private be bXF;
    private int bsw;
    private ForumData fCO;
    private AntiData fCU;
    public Error fCW;
    private int mCurrentPage;
    private int fCS = 20;
    private int fCT = -1;
    private boolean fCV = false;
    private PostData fCP = null;
    private ArrayList<PostData> fCQ = new ArrayList<>();
    private int fCR = 1;

    public Error aZo() {
        return this.fCW;
    }

    public PostData aZp() {
        return this.fCP;
    }

    public void d(PostData postData) {
        this.fCP = postData;
    }

    public int aZq() {
        if (this.fCT == -1) {
            this.fCT = this.mCurrentPage;
        }
        return this.fCT;
    }

    public int aZr() {
        return this.fCT;
    }

    public void a(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aZx());
            this.fCT = mVar.Si();
            b(mVar.aZw());
            setPageSize(mVar.aZv());
            Q(mVar.VW());
            setTotalCount(mVar.getTotalCount());
            lK(mVar.aZu());
            this.fCQ.addAll(0, mVar.aZt());
        }
    }

    public void b(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aZx());
            b(mVar.aZw());
            d(mVar.aZp());
            Q(mVar.VW());
            if (mVar.aZt() != null && mVar.aZt().size() > 0) {
                eY(mVar.Si());
                setPageSize(mVar.aZv());
                setTotalCount(mVar.getTotalCount());
                lK(mVar.aZu());
            }
            int size = this.fCQ.size();
            if (z && size % this.fCS != 0) {
                for (int i = 0; i < size % this.fCS; i++) {
                    this.fCQ.remove(this.fCQ.size() - 1);
                }
            }
            this.fCQ.addAll(mVar.aZt());
        }
    }

    public void c(m mVar, boolean z) {
        if (mVar != null) {
            b(mVar.aZx());
            b(mVar.aZw());
            d(mVar.aZp());
            Q(mVar.VW());
            if (mVar.aZt() != null && mVar.aZt().size() > 0) {
                eY(mVar.Si());
                setPageSize(mVar.aZv());
                setTotalCount(mVar.getTotalCount());
                lK(mVar.aZu());
            }
            int size = this.fCQ.size();
            if (z && size % this.fCS != 0) {
                for (int i = 0; i < size % this.fCS; i++) {
                    this.fCQ.remove(this.fCQ.size() - 1);
                }
            }
            this.fCQ.addAll(mVar.aZt());
            aZs();
        }
    }

    public void d(m mVar, boolean z) {
        a(mVar, z);
    }

    public void a(m mVar) {
        if (mVar != null) {
            b(mVar.aZx());
            b(mVar.aZw());
            d(mVar.aZp());
            Q(mVar.VW());
            if (mVar.aZt() != null && mVar.aZt().size() > 0) {
                eY(mVar.Si());
                setPageSize(mVar.aZv());
                setTotalCount(mVar.getTotalCount());
                lK(mVar.aZu());
                this.fCT = (this.mCurrentPage - (((mVar.aZt().size() - 1) + this.fCS) / this.fCS)) + 1;
                if (this.fCT < 0) {
                    this.fCT = 0;
                }
            }
            this.fCQ.addAll(mVar.aZt());
        }
    }

    public void aZs() {
        if (this.fCT < 0) {
            this.fCT = this.mCurrentPage;
        } else if (this.fCT > this.mCurrentPage) {
            this.fCT = this.mCurrentPage;
        }
    }

    public ArrayList<PostData> aZt() {
        return this.fCQ;
    }

    public void aj(ArrayList<PostData> arrayList) {
        this.fCQ = arrayList;
    }

    public int aZu() {
        return this.fCR;
    }

    public void lK(int i) {
        this.fCR = i;
    }

    public int getTotalCount() {
        return this.bsw;
    }

    public void setTotalCount(int i) {
        this.bsw = i;
    }

    public int aZv() {
        return this.fCS;
    }

    public void setPageSize(int i) {
        if (i != 0) {
            this.fCS = i;
        }
    }

    public int Si() {
        return this.mCurrentPage;
    }

    public void eY(int i) {
        this.mCurrentPage = i;
    }

    public void b(ForumData forumData) {
        this.fCO = forumData;
    }

    public ForumData aZw() {
        return this.fCO;
    }

    public void b(AntiData antiData) {
        this.fCU = antiData;
    }

    public AntiData aZx() {
        return this.fCU;
    }

    public void Q(be beVar) {
        this.bXF = beVar;
    }

    public boolean aJE() {
        return (this.bXF == null || this.fCP == null || this.bXF.yX() == null || this.bXF.yX().getUserId() == null || this.fCP.yX() == null || this.fCP.yX().getUserId() == null || !this.bXF.yX().getUserId().equals(this.fCP.yX().getUserId())) ? false : true;
    }

    public boolean vk() {
        return this.fCV;
    }

    public boolean hasMore() {
        return this.mCurrentPage < this.fCR;
    }

    public be VW() {
        return this.bXF;
    }

    public static m a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            m mVar = new m();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            mVar.b(antiData);
            be beVar = new be();
            beVar.a(dataRes.thread);
            beVar.eY(2);
            mVar.Q(beVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            mVar.b(forumData);
            PostData postData = new PostData();
            postData.a(dataRes.post, context);
            mVar.d(postData);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<PostData> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                PostData postData2 = new PostData();
                postData2.a(list.get(i), context);
                arrayList.add(postData2);
            }
            mVar.aj(arrayList);
            AntiData antiData2 = new AntiData();
            antiData2.parserProtobuf(dataRes.anti);
            mVar.b(antiData2);
            Page page = dataRes.page;
            if (page != null) {
                int intValue = page.total_page.intValue();
                int intValue2 = page.page_size.intValue() == 0 ? 20 : page.page_size.intValue();
                int intValue3 = page.current_page.intValue();
                int intValue4 = page.total_count.intValue();
                mVar.eY(intValue3);
                mVar.setPageSize(intValue2);
                mVar.setTotalCount(intValue4);
                mVar.lK(intValue);
            }
            return mVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }
}
