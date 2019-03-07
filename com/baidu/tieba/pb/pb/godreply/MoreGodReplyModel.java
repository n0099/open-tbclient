package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel hlS;
    private int hlT;
    private int hlU;
    private z.a hlV;
    private final z.a hlW;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hlT = -1;
        this.hlU = -1;
        this.hlW = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void ac(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                k bIk = MoreGodReplyModel.this.hlS.getPbData().bIk();
                if (bIk != null) {
                    List<PostData> list2 = bIk.hkW;
                    int size = list2.size();
                    if (!v.T(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hlS.a(MoreGodReplyModel.this.hlS.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hlT > 0) {
                    MoreGodReplyModel.this.hlU = MoreGodReplyModel.this.hlT;
                }
                if (MoreGodReplyModel.this.hlV != null) {
                    MoreGodReplyModel.this.hlV.ac(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void j(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hlV != null) {
                    MoreGodReplyModel.this.hlV.j(i, str, str2);
                }
            }
        };
        this.hlS = pbModel;
        this.hlS.bLt().b(this.hlW);
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

    public boolean bIZ() {
        k bIk;
        com.baidu.tieba.pb.data.d pbData = this.hlS.getPbData();
        if (pbData == null || (bIk = pbData.bIk()) == null) {
            return false;
        }
        if (this.hlU < 0) {
            this.hlU = bIk.getCount();
        }
        List<Long> list = bIk.hkX;
        int size = list.size();
        int i = this.hlU;
        if (size <= i || bIk.hkW.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hlT = min;
        this.isLoading = true;
        this.hlS.bLt().dC(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean qz() {
        return this.isLoading;
    }

    public PbModel bJa() {
        return this.hlS;
    }

    public List<m> bJb() {
        com.baidu.tieba.pb.data.d pbData = this.hlS.getPbData();
        if (pbData == null || pbData.bIk() == null || v.T(pbData.bIk().hkW)) {
            return null;
        }
        k bIk = pbData.bIk();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bIk.hkW;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.iGR = i < size + (-1);
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
        this.hlV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean HA() {
        k bIk;
        com.baidu.tieba.pb.data.d pbData = this.hlS.getPbData();
        if (pbData == null || (bIk = pbData.bIk()) == null) {
            return false;
        }
        if (this.hlU < 0) {
            this.hlU = bIk.getCount();
        }
        return bIk.hkX.size() > this.hlU && bIk.hkW.size() < 100;
    }
}
