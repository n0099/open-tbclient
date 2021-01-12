package com.baidu.tieba.pb.data;

import androidx.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class l extends PostData {
    public static final BdUniqueId Yp = BdUniqueId.gen();
    public int gxN;
    @DrawableRes
    public int lCu;
    public String lCv;
    public int lCw;
    public int lCx;
    private int position = 0;
    public int lCy = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return Yp;
    }
}
