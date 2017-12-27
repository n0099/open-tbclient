package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private final PbModel fEI;
    private int fEJ;
    private int fEK;
    private z.a fEL;
    private final z.a fEM;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.fEJ = -1;
        this.fEK = -1;
        this.fEM = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void L(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                n aYM = MoreGodReplyModel.this.fEI.getPbData().aYM();
                if (aYM != null) {
                    List<PostData> list2 = aYM.fCX;
                    int size = list2.size();
                    if (!v.G(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.fEI.a(MoreGodReplyModel.this.fEI.getPbData(), size);
                }
                if (MoreGodReplyModel.this.fEJ > 0) {
                    MoreGodReplyModel.this.fEK = MoreGodReplyModel.this.fEJ;
                }
                if (MoreGodReplyModel.this.fEL != null) {
                    MoreGodReplyModel.this.fEL.L(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void i(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.fEL != null) {
                    MoreGodReplyModel.this.fEL.i(i, str, str2);
                }
            }
        };
        this.fEI = pbModel;
        this.fEI.bcb().b(this.fEM);
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

    public boolean aZJ() {
        n aYM;
        f pbData = this.fEI.getPbData();
        if (pbData == null || (aYM = pbData.aYM()) == null) {
            return false;
        }
        if (this.fEK < 0) {
            this.fEK = aYM.getCount();
        }
        List<Long> list = aYM.fCY;
        int size = list.size();
        int i = this.fEK;
        if (size <= i || aYM.fCX.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.fEJ = min;
        this.isLoading = true;
        this.fEI.bcb().cV(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean DY() {
        return this.isLoading;
    }

    public PbModel aZK() {
        return this.fEI;
    }

    public List<i> aZL() {
        f pbData = this.fEI.getPbData();
        if (pbData == null || pbData.aYM() == null || v.G(pbData.aYM().fCX)) {
            return null;
        }
        n aYM = pbData.aYM();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = aYM.fCX;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.hjq = i < size + (-1);
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
        this.fEL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ahx() {
        n aYM;
        f pbData = this.fEI.getPbData();
        if (pbData == null || (aYM = pbData.aYM()) == null) {
            return false;
        }
        if (this.fEK < 0) {
            this.fEK = aYM.getCount();
        }
        return aYM.fCY.size() > this.fEK && aYM.fCX.size() < 100;
    }
}
