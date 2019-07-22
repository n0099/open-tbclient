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
    private final PbModel hJt;
    private int hJu;
    private int hJv;
    private z.a hJw;
    private final z.a hJx;
    private boolean isLoading;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(e eVar, PbModel pbModel) {
        super(eVar);
        this.isLoading = false;
        this.hJu = -1;
        this.hJv = -1;
        this.hJx = new z.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void aj(List<PostData> list) {
                MoreGodReplyModel.this.isLoading = false;
                m bSI = MoreGodReplyModel.this.hJt.getPbData().bSI();
                if (bSI != null) {
                    List<PostData> list2 = bSI.hIB;
                    int size = list2.size();
                    if (!v.aa(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.hJt.a(MoreGodReplyModel.this.hJt.getPbData(), size);
                }
                if (MoreGodReplyModel.this.hJu > 0) {
                    MoreGodReplyModel.this.hJv = MoreGodReplyModel.this.hJu;
                }
                if (MoreGodReplyModel.this.hJw != null) {
                    MoreGodReplyModel.this.hJw.aj(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.z.a
            public void l(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.hJw != null) {
                    MoreGodReplyModel.this.hJw.l(i, str, str2);
                }
            }
        };
        this.hJt = pbModel;
        this.hJt.bVY().b(this.hJx);
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

    public boolean bTC() {
        m bSI;
        com.baidu.tieba.pb.data.d pbData = this.hJt.getPbData();
        if (pbData == null || (bSI = pbData.bSI()) == null) {
            return false;
        }
        if (this.hJv < 0) {
            this.hJv = bSI.getCount();
        }
        List<Long> list = bSI.hIC;
        int size = list.size();
        int i = this.hJv;
        if (size <= i || bSI.hIB.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.hJu = min;
        this.isLoading = true;
        this.hJt.bVY().dJ(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean pP() {
        return this.isLoading;
    }

    public PbModel bTD() {
        return this.hJt;
    }

    public List<com.baidu.adp.widget.ListView.m> bTE() {
        com.baidu.tieba.pb.data.d pbData = this.hJt.getPbData();
        if (pbData == null || pbData.bSI() == null || v.aa(pbData.bSI().hIB)) {
            return null;
        }
        m bSI = pbData.bSI();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = bSI.hIB;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.jfH = i < size + (-1);
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
        this.hJw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean KB() {
        m bSI;
        com.baidu.tieba.pb.data.d pbData = this.hJt.getPbData();
        if (pbData == null || (bSI = pbData.bSI()) == null) {
            return false;
        }
        if (this.hJv < 0) {
            this.hJv = bSI.getCount();
        }
        return bSI.hIC.size() > this.hJv && bSI.hIB.size() < 100;
    }
}
