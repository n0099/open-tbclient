package com.baidu.tieba.pb.data;

import androidx.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class m extends PostData {
    public static final BdUniqueId ZE = BdUniqueId.gen();
    public int gCu;
    public String lNA;
    public int lNB;
    public int lNC;
    @DrawableRes
    public int lNz;
    private int position = 0;
    public int lND = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ZE;
    }
}
