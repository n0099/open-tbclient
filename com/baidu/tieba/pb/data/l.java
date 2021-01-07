package com.baidu.tieba.pb.data;

import androidx.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class l extends PostData {
    public static final BdUniqueId Yr = BdUniqueId.gen();
    public int gCu;
    @DrawableRes
    public int lGZ;
    public String lHa;
    public int lHb;
    public int lHc;
    private int position = 0;
    public int lHd = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return Yr;
    }
}
