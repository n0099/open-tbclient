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
    private PbModel lMV;
    private int lMW;
    private int lMX;
    private ab.a lMY;
    private final ab.a lMZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public MoreGodReplyModel(f fVar, PbModel pbModel) {
        super(fVar);
        this.isLoading = false;
        this.lMW = -1;
        this.lMX = -1;
        this.lMZ = new ab.a() { // from class: com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel.1
            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void aj(List<PostData> list) {
                s dlu;
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lMV != null && MoreGodReplyModel.this.lMV.getPbData() != null && (dlu = MoreGodReplyModel.this.lMV.getPbData().dlu()) != null) {
                    List<PostData> list2 = dlu.lLW;
                    int size = list2.size();
                    if (!y.isEmpty(list)) {
                        for (PostData postData : list) {
                            if (postData != null && !MoreGodReplyModel.a(list2, postData)) {
                                list2.add(postData);
                            }
                        }
                    }
                    MoreGodReplyModel.this.lMV.a(MoreGodReplyModel.this.lMV.getPbData(), size);
                }
                if (MoreGodReplyModel.this.lMW > 0) {
                    MoreGodReplyModel.this.lMX = MoreGodReplyModel.this.lMW;
                }
                if (MoreGodReplyModel.this.lMY != null) {
                    MoreGodReplyModel.this.lMY.aj(list);
                }
            }

            @Override // com.baidu.tieba.pb.pb.main.ab.a
            public void n(int i, String str, String str2) {
                MoreGodReplyModel.this.isLoading = false;
                if (MoreGodReplyModel.this.lMY != null) {
                    MoreGodReplyModel.this.lMY.n(i, str, str2);
                }
            }
        };
        if (pbModel != null) {
            this.lMV = pbModel;
            ab dpf = pbModel.dpf();
            if (dpf != null) {
                dpf.b(this.lMZ);
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

    public boolean dmw() {
        s dlu;
        com.baidu.tieba.pb.data.f pbData = this.lMV.getPbData();
        if (pbData == null || (dlu = pbData.dlu()) == null) {
            return false;
        }
        if (this.lMX < 0) {
            this.lMX = dlu.getCount();
        }
        List<Long> list = dlu.lLX;
        int size = list.size();
        int i = this.lMX;
        if (size <= i || dlu.lLW.size() >= 100) {
            return false;
        }
        int min = Math.min(100, Math.min(i + 20, size));
        this.lMW = min;
        this.isLoading = true;
        this.lMV.dpf().fm(list.subList(i, min));
        Log.d("more_god_reply", "load from " + i + " to " + min);
        return true;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public PbModel dmx() {
        return this.lMV;
    }

    public List<n> dmy() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lMV == null || (pbData = this.lMV.getPbData()) == null || pbData.dlu() == null || y.isEmpty(pbData.dlu().lLW)) {
            return null;
        }
        s dlu = pbData.dlu();
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dlu.lLW;
        int size = list.size();
        int i = 0;
        while (i < size) {
            PostData postData = list.get(i);
            if (postData != null) {
                arrayList.add(postData);
                postData.nxH = i < size + (-1);
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
        this.lMY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aHt() {
        com.baidu.tieba.pb.data.f pbData;
        s dlu;
        if (this.lMV == null || (pbData = this.lMV.getPbData()) == null || (dlu = pbData.dlu()) == null) {
            return false;
        }
        if (this.lMX < 0) {
            this.lMX = dlu.getCount();
        }
        return dlu.lLX.size() > this.lMX && dlu.lLW.size() < 100;
    }
}
