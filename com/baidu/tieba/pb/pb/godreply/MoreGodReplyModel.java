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
    private final PbModel hlT;
    private int hlU;
    private int hlV;
    private z.a hlW;
    private final z.a hlX;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hlU = -1;
        this.hlV = -1;
        this.hlX = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void ac(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                k bIl = MoreGodReplyModel.this.hlT.getPbData().bIl();
                if (bIl != null) {
                    List<PostData> list2 = bIl.hkX;
                    int size = list2.size();
                    if (!v.T(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hlT.a(MoreGodReplyModel.this.hlT.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hlU > 0) {
                    MoreGodReplyModel.this.hlV = MoreGodReplyModel.this.hlU;
                }
                if (MoreGodReplyModel.this.hlW != null) {
                    MoreGodReplyModel.this.hlW.ac(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void j(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hlW != null) {
                    MoreGodReplyModel.this.hlW.j(i, str, str2);
                }
            }
        };
        this.hlT = pbModel;
        this.hlT.bLu().b(this.hlX);
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

    public boolean bJa() {
        k bIl;
        com.baidu.tieba.pb.data.d pbData = this.hlT.getPbData();
        if (pbData == null || (bIl = pbData.bIl()) == null) {
            return false;
        }
        if (this.hlV < 0) {
            this.hlV = bIl.getCount();
        }
        List<Long> list = bIl.hkY;
        int size = list.size();
        int i = this.hlV;
        if (size <= i || bIl.hkX.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hlU = min;
        this.isLoading = true;
        this.hlT.bLu().dC(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean qz() {
        return this.isLoading;
    }

    public PbModel bJb() {
        return this.hlT;
    }

    public List<m> bJc() {
        com.baidu.tieba.pb.data.d pbData = this.hlT.getPbData();
        if (pbData == null || pbData.bIl() == null || v.T(pbData.bIl().hkX)) {
            return null;
        }
        k bIl = pbData.bIl();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bIl.hkX;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.iGS = i < size + (-1);
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
        this.hlW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean HA() {
        k bIl;
        com.baidu.tieba.pb.data.d pbData = this.hlT.getPbData();
        if (pbData == null || (bIl = pbData.bIl()) == null) {
            return false;
        }
        if (this.hlV < 0) {
            this.hlV = bIl.getCount();
        }
        return bIl.hkY.size() > this.hlV && bIl.hkX.size() < 100;
    }
}
