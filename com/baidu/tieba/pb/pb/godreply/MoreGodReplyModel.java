package com.baidu.tieba.pb.pb.godreply;

import android.util.Log;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.r;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ai;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private boolean isLoading;
    private PbModel kzc;
    private int kzd;
    private int kze;
    private ai.a kzf;
    private final ai.a kzg;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.kzd = -1;
        this.kze = -1;
        this.kzg = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void bd(List<PostData> list) {
                r cVz;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kzc != null && MoreGodReplyModel.this.kzc.getPbData() != null && (cVz = MoreGodReplyModel.this.kzc.getPbData().cVz()) != null) {
                    List<PostData> list2 = cVz.kyo;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.kzc.a(MoreGodReplyModel.this.kzc.getPbData(), size);
                }
                if (MoreGodReplyModel.this.kzd > 0) {
                    MoreGodReplyModel.this.kze = MoreGodReplyModel.this.kzd;
                }
                if (MoreGodReplyModel.this.kzf != null) {
                    MoreGodReplyModel.this.kzf.bd(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void m(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.kzf != null) {
                    MoreGodReplyModel.this.kzf.m(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.kzc = pbModel;
            ai cZf = pbModel.cZf();
            if (cZf != null) {
                cZf.b(this.kzg);
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

    public boolean cWC() {
        r cVz;
        f pbData = this.kzc.getPbData();
        if (pbData == null || (cVz = pbData.cVz()) == null) {
            return false;
        }
        if (this.kze < 0) {
            this.kze = cVz.getCount();
        }
        List<Long> list = cVz.kyp;
        int size = list.size();
        int i = this.kze;
        if (size <= i || cVz.kyo.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.kzd = min;
        this.isLoading = true;
        this.kzc.cZf().eB(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel cWD() {
        return this.kzc;
    }

    public List<q> cWE() {
        f pbData;
        if (this.kzc == null || (pbData = this.kzc.getPbData()) == null || pbData.cVz() == null || y.isEmpty(pbData.cVz().kyo)) {
            return null;
        }
        r cVz = pbData.cVz();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = cVz.kyo;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.mfw = i < size + (-1);
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

    public void a(ai.a aVar) {
        this.kzf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ayX() {
        f pbData;
        r cVz;
        if (this.kzc == null || (pbData = this.kzc.getPbData()) == null || (cVz = pbData.cVz()) == null) {
            return false;
        }
        if (this.kze < 0) {
            this.kze = cVz.getCount();
        }
        return cVz.kyp.size() > this.kze && cVz.kyo.size() < 100;
    }
}
