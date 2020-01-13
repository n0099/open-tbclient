package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel iBN;
    private int iBO;
    private int iBP;
    private aa.a iBQ;
    private final aa.a iBR;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.iBO = -1;
        this.iBP = -1;
        this.iBR = new aa.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.aa.a
            public void onSuccess(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                o cjd = MoreGodReplyModel.this.iBN.getPbData().cjd();
                if (cjd != null) {
                    List<PostData> list2 = cjd.iAX;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.iBN.a(MoreGodReplyModel.this.iBN.getPbData(), size);
                }
                if (MoreGodReplyModel.this.iBO > 0) {
                    MoreGodReplyModel.this.iBP = MoreGodReplyModel.this.iBO;
                }
                if (MoreGodReplyModel.this.iBQ != null) {
                    MoreGodReplyModel.this.iBQ.onSuccess(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.aa.a
            public void l(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.iBQ != null) {
                    MoreGodReplyModel.this.iBQ.l(i, str, str2);
                }
            }
        };
        this.iBN = pbModel;
        this.iBN.cmI().b(this.iBR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(List<PostData> list, PostData postData) {
        if (list != null && postData != null) {
            for (PostData postData2 : list) {
                if (postData2 != null) {
                    if (postData2 == postData) {
                        return true;
                    }
                    if (postData2.getId() != null && postData.getId() != null && postData2.getId().equals(postData.getId())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean ckb() {
        o cjd;
        f pbData = this.iBN.getPbData();
        if (pbData == null || (cjd = pbData.cjd()) == null) {
            return false;
        }
        if (this.iBP < 0) {
            this.iBP = cjd.getCount();
        }
        List<Long> list = cjd.iAY;
        int size = list.size();
        int i = this.iBP;
        if (size <= i || cjd.iAX.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.iBO = min;
        this.isLoading = true;
        this.iBN.cmI().dK(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel ckc() {
        return this.iBN;
    }

    public List<m> ckd() {
        f pbData = this.iBN.getPbData();
        if (pbData == null || pbData.cjd() == null || v.isEmpty(pbData.cjd().iAX)) {
            return null;
        }
        o cjd = pbData.cjd();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cjd.iAX;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.kfW = i < size + (-1);
            }
            i++;
        }
        return arrayList;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.isLoading = false;
        return false;
    }

    public void a(aa.a aVar) {
        this.iBQ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ZK() {
        o cjd;
        f pbData = this.iBN.getPbData();
        if (pbData == null || (cjd = pbData.cjd()) == null) {
            return false;
        }
        if (this.iBP < 0) {
            this.iBP = cjd.getCount();
        }
        return cjd.iAY.size() > this.iBP && cjd.iAX.size() < 100;
    }
}
