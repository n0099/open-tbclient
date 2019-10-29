package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel hKN;
    private int hKO;
    private int hKP;
    private z.a hKQ;
    private final z.a hKR;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hKO = -1;
        this.hKP = -1;
        this.hKR = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void aD(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                m bQK = MoreGodReplyModel.this.hKN.getPbData().bQK();
                if (bQK != null) {
                    List<PostData> list2 = bQK.hJX;
                    int size = list2.size();
                    if (!v.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hKN.a(MoreGodReplyModel.this.hKN.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hKO > 0) {
                    MoreGodReplyModel.this.hKP = MoreGodReplyModel.this.hKO;
                }
                if (MoreGodReplyModel.this.hKQ != null) {
                    MoreGodReplyModel.this.hKQ.aD(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hKQ != null) {
                    MoreGodReplyModel.this.hKQ.n(i, str, str2);
                }
            }
        };
        this.hKN = pbModel;
        this.hKN.bUd().b(this.hKR);
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

    public boolean bRE() {
        m bQK;
        com.baidu.tieba.pb.data.d pbData = this.hKN.getPbData();
        if (pbData == null || (bQK = pbData.bQK()) == null) {
            return false;
        }
        if (this.hKP < 0) {
            this.hKP = bQK.getCount();
        }
        List<Long> list = bQK.hJY;
        int size = list.size();
        int i = this.hKP;
        if (size <= i || bQK.hJX.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hKO = min;
        this.isLoading = true;
        this.hKN.bUd().dV(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel bRF() {
        return this.hKN;
    }

    public List<com.baidu.adp.widget.ListView.m> bRG() {
        com.baidu.tieba.pb.data.d pbData = this.hKN.getPbData();
        if (pbData == null || pbData.bQK() == null || v.isEmpty(pbData.bQK().hJX)) {
            return null;
        }
        m bQK = pbData.bQK();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bQK.hJX;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.jiY = i < size + (-1);
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
        this.hKQ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Py() {
        m bQK;
        com.baidu.tieba.pb.data.d pbData = this.hKN.getPbData();
        if (pbData == null || (bQK = pbData.bQK()) == null) {
            return false;
        }
        if (this.hKP < 0) {
            this.hKP = bQK.getCount();
        }
        return bQK.hJY.size() > this.hKP && bQK.hJX.size() < 100;
    }
}
