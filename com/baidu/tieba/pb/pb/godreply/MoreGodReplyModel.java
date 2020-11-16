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
/* loaded from: classes21.dex */
public class MoreGodReplyModel extends BdBaseModel<e> {
    private boolean isLoading;
    private PbModel lpG;
    private int lpH;
    private int lpI;
    private ai.a lpJ;
    private final ai.a lpK;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.lpH = -1;
        this.lpI = -1;
        this.lpK = new ai.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void af(List<PostData> list) {
                r dhV;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lpG != null && MoreGodReplyModel.this.lpG.getPbData() != null && (dhV = MoreGodReplyModel.this.lpG.getPbData().dhV()) != null) {
                    List<PostData> list2 = dhV.loU;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.lpG.a(MoreGodReplyModel.this.lpG.getPbData(), size);
                }
                if (MoreGodReplyModel.this.lpH > 0) {
                    MoreGodReplyModel.this.lpI = MoreGodReplyModel.this.lpH;
                }
                if (MoreGodReplyModel.this.lpJ != null) {
                    MoreGodReplyModel.this.lpJ.af(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ai.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lpJ != null) {
                    MoreGodReplyModel.this.lpJ.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.lpG = pbModel;
            ai dly = pbModel.dly();
            if (dly != null) {
                dly.b(this.lpK);
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

    public boolean diU() {
        r dhV;
        f pbData = this.lpG.getPbData();
        if (pbData == null || (dhV = pbData.dhV()) == null) {
            return false;
        }
        if (this.lpI < 0) {
            this.lpI = dhV.getCount();
        }
        List<Long> list = dhV.loV;
        int size = list.size();
        int i = this.lpI;
        if (size <= i || dhV.loU.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.lpH = min;
        this.isLoading = true;
        this.lpG.dly().fd(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel diV() {
        return this.lpG;
    }

    public List<q> diW() {
        f pbData;
        if (this.lpG == null || (pbData = this.lpG.getPbData()) == null || pbData.dhV() == null || y.isEmpty(pbData.dhV().loU)) {
            return null;
        }
        r dhV = pbData.dhV();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dhV.loU;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.mYs = i < size + (-1);
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
        this.lpJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aGb() {
        f pbData;
        r dhV;
        if (this.lpG == null || (pbData = this.lpG.getPbData()) == null || (dhV = pbData.dhV()) == null) {
            return false;
        }
        if (this.lpI < 0) {
            this.lpI = dhV.getCount();
        }
        return dhV.loV.size() > this.lpI && dhV.loU.size() < 100;
    }
}
