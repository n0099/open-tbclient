package com.baidu.tieba.pb.data;

import android.support.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class l extends PostData {
    public static final BdUniqueId Yt = BdUniqueId.gen();
    public int grv;
    @DrawableRes
    public int lBU;
    public String lBV;
    public int lBW;
    public int lBX;
    private int position = 0;
    public int lBY = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return Yt;
    }
}
