package com.baidu.tieba.pb.data;

import android.support.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class l extends PostData {
    public static final BdUniqueId Xs = BdUniqueId.gen();
    public int gjD;
    @DrawableRes
    public int lod;
    public String loe;
    public int lof;
    public int loh;
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return Xs;
    }
}
