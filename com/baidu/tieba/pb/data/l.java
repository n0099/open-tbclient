package com.baidu.tieba.pb.data;

import android.support.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class l extends PostData {
    public static final BdUniqueId WI = BdUniqueId.gen();
    public int fEk;
    @DrawableRes
    public int kxQ;
    public String kxR;
    public int kxS;
    public int kxT;
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return WI;
    }
}
