package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.pb.data.s;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MoreGodReplyModel extends BdBaseModel<f> {
    private boolean isLoading;
    private PbModel lMG;
    private int lMH;
    private int lMI;
    private ab.a lMJ;
    private final ab.a lMK;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(f fVar, PbModel pbModel) {
        super(fVar);
        this.isLoading = false;
        this.lMH = -1;
        this.lMI = -1;
        this.lMK = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void aj(List<PostData> list) {
                s dln;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lMG != null && MoreGodReplyModel.this.lMG.getPbData() != null && (dln = MoreGodReplyModel.this.lMG.getPbData().dln()) != null) {
                    List<PostData> list2 = dln.lLH;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.lMG.a(MoreGodReplyModel.this.lMG.getPbData(), size);
                }
                if (MoreGodReplyModel.this.lMH > 0) {
                    MoreGodReplyModel.this.lMI = MoreGodReplyModel.this.lMH;
                }
                if (MoreGodReplyModel.this.lMJ != null) {
                    MoreGodReplyModel.this.lMJ.aj(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lMJ != null) {
                    MoreGodReplyModel.this.lMJ.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.lMG = pbModel;
            ab doY = pbModel.doY();
            if (doY != null) {
                doY.b(this.lMK);
            }
        }
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

    public boolean dmp() {
        s dln;
        com.baidu.tieba.pb.data.f pbData = this.lMG.getPbData();
        if (pbData == null || (dln = pbData.dln()) == null) {
            return false;
        }
        if (this.lMI < 0) {
            this.lMI = dln.getCount();
        }
        List<Long> list = dln.lLI;
        int size = list.size();
        int i = this.lMI;
        if (size <= i || dln.lLH.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.lMH = min;
        this.isLoading = true;
        this.lMG.doY().fm(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel dmq() {
        return this.lMG;
    }

    public List<n> dmr() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lMG == null || (pbData = this.lMG.getPbData()) == null || pbData.dln() == null || y.isEmpty(pbData.dln().lLH)) {
            return null;
        }
        s dln = pbData.dln();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dln.lLH;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.nxh = i < size + (-1);
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

    public void a(ab.a aVar) {
        this.lMJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aHt() {
        com.baidu.tieba.pb.data.f pbData;
        s dln;
        if (this.lMG == null || (pbData = this.lMG.getPbData()) == null || (dln = pbData.dln()) == null) {
            return false;
        }
        if (this.lMI < 0) {
            this.lMI = dln.getCount();
        }
        return dln.lLI.size() > this.lMI && dln.lLH.size() < 100;
    }
}
