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
    private final PbModel hlB;
    private int hlC;
    private int hlD;
    private z.a hlE;
    private final z.a hlF;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hlC = -1;
        this.hlD = -1;
        this.hlF = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void ac(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                k bIh = MoreGodReplyModel.this.hlB.getPbData().bIh();
                if (bIh != null) {
                    List<PostData> list2 = bIh.hkJ;
                    int size = list2.size();
                    if (!v.T(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hlB.a(MoreGodReplyModel.this.hlB.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hlC > 0) {
                    MoreGodReplyModel.this.hlD = MoreGodReplyModel.this.hlC;
                }
                if (MoreGodReplyModel.this.hlE != null) {
                    MoreGodReplyModel.this.hlE.ac(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void j(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hlE != null) {
                    MoreGodReplyModel.this.hlE.j(i, str, str2);
                }
            }
        };
        this.hlB = pbModel;
        this.hlB.bLq().b(this.hlF);
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
        com.baidu.tieba.pb.data.d pbData = this.hlB.getPbData();
        if (pbData == null || (bIh = pbData.bIh()) == null) {
            return false;
        }
        if (this.hlD < 0) {
            this.hlD = bIh.getCount();
        }
        List<Long> list = bIh.hkK;
        int size = list.size();
        int i = this.hlD;
        if (size <= i || bIh.hkJ.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hlC = min;
        this.isLoading = true;
        this.hlB.bLq().dz(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean qz() {
        return this.isLoading;
    }

    public PbModel bIX() {
        return this.hlB;
    }

    public List<m> bIY() {
        com.baidu.tieba.pb.data.d pbData = this.hlB.getPbData();
        if (pbData == null || pbData.bIh() == null || v.T(pbData.bIh().hkJ)) {
            return null;
        }
        k bIh = pbData.bIh();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bIh.hkJ;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.iGu = i < size + (-1);
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
        this.hlE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Hy() {
        k bIh;
        com.baidu.tieba.pb.data.d pbData = this.hlB.getPbData();
        if (pbData == null || (bIh = pbData.bIh()) == null) {
            return false;
        }
        if (this.hlD < 0) {
            this.hlD = bIh.getCount();
        }
        return bIh.hkK.size() > this.hlD && bIh.hkJ.size() < 100;
    }
}
