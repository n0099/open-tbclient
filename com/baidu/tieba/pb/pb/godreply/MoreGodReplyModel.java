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
    private final PbModel hlC;
    private int hlD;
    private int hlE;
    private z.a hlF;
    private final z.a hlG;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hlD = -1;
        this.hlE = -1;
        this.hlG = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void ac(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                k bIh = MoreGodReplyModel.this.hlC.getPbData().bIh();
                if (bIh != null) {
                    List<PostData> list2 = bIh.hkK;
                    int size = list2.size();
                    if (!v.T(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hlC.a(MoreGodReplyModel.this.hlC.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hlD > 0) {
                    MoreGodReplyModel.this.hlE = MoreGodReplyModel.this.hlD;
                }
                if (MoreGodReplyModel.this.hlF != null) {
                    MoreGodReplyModel.this.hlF.ac(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void j(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hlF != null) {
                    MoreGodReplyModel.this.hlF.j(i, str, str2);
                }
            }
        };
        this.hlC = pbModel;
        this.hlC.bLq().b(this.hlG);
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

    public boolean bIW() {
        k bIh;
        com.baidu.tieba.pb.data.d pbData = this.hlC.getPbData();
        if (pbData == null || (bIh = pbData.bIh()) == null) {
            return false;
        }
        if (this.hlE < 0) {
            this.hlE = bIh.getCount();
        }
        List<Long> list = bIh.hkL;
        int size = list.size();
        int i = this.hlE;
        if (size <= i || bIh.hkK.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hlD = min;
        this.isLoading = true;
        this.hlC.bLq().dz(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean qz() {
        return this.isLoading;
    }

    public PbModel bIX() {
        return this.hlC;
    }

    public List<m> bIY() {
        com.baidu.tieba.pb.data.d pbData = this.hlC.getPbData();
        if (pbData == null || pbData.bIh() == null || v.T(pbData.bIh().hkK)) {
            return null;
        }
        k bIh = pbData.bIh();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bIh.hkK;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.iGv = i < size + (-1);
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
        this.hlF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Hy() {
        k bIh;
        com.baidu.tieba.pb.data.d pbData = this.hlC.getPbData();
        if (pbData == null || (bIh = pbData.bIh()) == null) {
            return false;
        }
        if (this.hlE < 0) {
            this.hlE = bIh.getCount();
        }
        return bIh.hkL.size() > this.hlE && bIh.hkK.size() < 100;
    }
}
