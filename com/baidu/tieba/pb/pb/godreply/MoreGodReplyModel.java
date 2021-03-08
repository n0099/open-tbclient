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
    private PbModel lOX;
    private int lOY;
    private int lOZ;
    private ab.a lPa;
    private final ab.a lPb;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(f fVar, PbModel pbModel) {
        super(fVar);
        this.isLoading = false;
        this.lOY = -1;
        this.lOZ = -1;
        this.lPb = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void aj(List<PostData> list) {
                s dlD;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lOX != null && MoreGodReplyModel.this.lOX.getPbData() != null && (dlD = MoreGodReplyModel.this.lOX.getPbData().dlD()) != null) {
                    List<PostData> list2 = dlD.lNY;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.lOX.a(MoreGodReplyModel.this.lOX.getPbData(), size);
                }
                if (MoreGodReplyModel.this.lOY > 0) {
                    MoreGodReplyModel.this.lOZ = MoreGodReplyModel.this.lOY;
                }
                if (MoreGodReplyModel.this.lPa != null) {
                    MoreGodReplyModel.this.lPa.aj(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lPa != null) {
                    MoreGodReplyModel.this.lPa.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.lOX = pbModel;
            ab dpo = pbModel.dpo();
            if (dpo != null) {
                dpo.b(this.lPb);
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

    public boolean dmF() {
        s dlD;
        com.baidu.tieba.pb.data.f pbData = this.lOX.getPbData();
        if (pbData == null || (dlD = pbData.dlD()) == null) {
            return false;
        }
        if (this.lOZ < 0) {
            this.lOZ = dlD.getCount();
        }
        List<Long> list = dlD.lNZ;
        int size = list.size();
        int i = this.lOZ;
        if (size <= i || dlD.lNY.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.lOY = min;
        this.isLoading = true;
        this.lOX.dpo().fm(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel dmG() {
        return this.lOX;
    }

    public List<n> dmH() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lOX == null || (pbData = this.lOX.getPbData()) == null || pbData.dlD() == null || y.isEmpty(pbData.dlD().lNY)) {
            return null;
        }
        s dlD = pbData.dlD();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dlD.lNY;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.nzM = i < size + (-1);
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
        this.lPa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aHw() {
        com.baidu.tieba.pb.data.f pbData;
        s dlD;
        if (this.lOX == null || (pbData = this.lOX.getPbData()) == null || (dlD = pbData.dlD()) == null) {
            return false;
        }
        if (this.lOZ < 0) {
            this.lOZ = dlD.getCount();
        }
        return dlD.lNZ.size() > this.lOZ && dlD.lNY.size() < 100;
    }
}
