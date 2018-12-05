package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel fRR;
    private int fRS;
    private int fRT;
    private z.a fRU;
    private final z.a fRV;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fRS = -1;
        this.fRT = -1;
        this.fRV = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void P(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                k bgv = MoreGodReplyModel.this.fRR.getPbData().bgv();
                if (bgv != null) {
                    List<PostData> list2 = bgv.fQU;
                    int size = list2.size();
                    if (!v.I(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fRR.a(MoreGodReplyModel.this.fRR.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fRS > 0) {
                    MoreGodReplyModel.this.fRT = MoreGodReplyModel.this.fRS;
                }
                if (MoreGodReplyModel.this.fRU != null) {
                    MoreGodReplyModel.this.fRU.P(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void j(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fRU != null) {
                    MoreGodReplyModel.this.fRU.j(i, str, str2);
                }
            }
        };
        this.fRR = pbModel;
        this.fRR.bjD().b(this.fRV);
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

    public boolean bhn() {
        k bgv;
        com.baidu.tieba.pb.data.d pbData = this.fRR.getPbData();
        if (pbData == null || (bgv = pbData.bgv()) == null) {
            return false;
        }
        if (this.fRT < 0) {
            this.fRT = bgv.getCount();
        }
        List<Long> list = bgv.fQV;
        int size = list.size();
        int i = this.fRT;
        if (size <= i || bgv.fQU.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fRS = min;
        this.isLoading = true;
        this.fRR.bjD().dm(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean Fi() {
        return this.isLoading;
    }

    public PbModel bho() {
        return this.fRR;
    }

    public List<h> bhp() {
        com.baidu.tieba.pb.data.d pbData = this.fRR.getPbData();
        if (pbData == null || pbData.bgv() == null || v.I(pbData.bgv().fQU)) {
            return null;
        }
        k bgv = pbData.bgv();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bgv.fQU;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.hlV = i < size + (-1);
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

    public void a(z.a aVar) {
        this.fRU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMoreData() {
        k bgv;
        com.baidu.tieba.pb.data.d pbData = this.fRR.getPbData();
        if (pbData == null || (bgv = pbData.bgv()) == null) {
            return false;
        }
        if (this.fRT < 0) {
            this.fRT = bgv.getCount();
        }
        return bgv.fQV.size() > this.fRT && bgv.fQU.size() < 100;
    }
}
