package com.baidu.tieba.pb.data;

import android.support.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class l extends PostData {
    public static final BdUniqueId Xr = BdUniqueId.gen();
    public int fTK;
    @DrawableRes
    public int kVG;
    public String kVH;
    public int kVI;
    public int kVJ;
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return Xr;
    }
}
