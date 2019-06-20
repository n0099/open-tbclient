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
    private final PbModel hDg;
    private int hDh;
    private int hDi;
    private z.a hDj;
    private final z.a hDk;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hDh = -1;
        this.hDi = -1;
        this.hDk = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void aj(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                m bPX = MoreGodReplyModel.this.hDg.getPbData().bPX();
                if (bPX != null) {
                    List<PostData> list2 = bPX.hCo;
                    int size = list2.size();
                    if (!v.aa(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hDg.a(MoreGodReplyModel.this.hDg.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hDh > 0) {
                    MoreGodReplyModel.this.hDi = MoreGodReplyModel.this.hDh;
                }
                if (MoreGodReplyModel.this.hDj != null) {
                    MoreGodReplyModel.this.hDj.aj(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void l(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hDj != null) {
                    MoreGodReplyModel.this.hDj.l(i, str, str2);
                }
            }
        };
        this.hDg = pbModel;
        this.hDg.bTl().b(this.hDk);
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

    public boolean bQR() {
        m bPX;
        com.baidu.tieba.pb.data.d pbData = this.hDg.getPbData();
        if (pbData == null || (bPX = pbData.bPX()) == null) {
            return false;
        }
        if (this.hDi < 0) {
            this.hDi = bPX.getCount();
        }
        List<Long> list = bPX.hCp;
        int size = list.size();
        int i = this.hDi;
        if (size <= i || bPX.hCo.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hDh = min;
        this.isLoading = true;
        this.hDg.bTl().dH(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean pu() {
        return this.isLoading;
    }

    public PbModel bQS() {
        return this.hDg;
    }

    public List<com.baidu.adp.widget.ListView.m> bQT() {
        com.baidu.tieba.pb.data.d pbData = this.hDg.getPbData();
        if (pbData == null || pbData.bPX() == null || v.aa(pbData.bPX().hCo)) {
            return null;
        }
        m bPX = pbData.bPX();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bPX.hCo;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.iZq = i < size + (-1);
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
        this.hDj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean JO() {
        m bPX;
        com.baidu.tieba.pb.data.d pbData = this.hDg.getPbData();
        if (pbData == null || (bPX = pbData.bPX()) == null) {
            return false;
        }
        if (this.hDi < 0) {
            this.hDi = bPX.getCount();
        }
        return bPX.hCp.size() > this.hDi && bPX.hCo.size() < 100;
    }
}
