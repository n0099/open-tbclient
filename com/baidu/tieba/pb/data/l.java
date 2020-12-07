package com.baidu.tieba.pb.data;

import android.support.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class l extends PostData {
    public static final BdUniqueId Yt = BdUniqueId.gen();
    public int grt;
    @DrawableRes
    public int lBS;
    public String lBT;
    public int lBU;
    public int lBV;
    private int position = 0;
    public int lBW = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return Yt;
    }
}
