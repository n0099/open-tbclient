package com.baidu.tieba.pb.data;

import android.support.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes21.dex */
public class l extends PostData {
    public static final BdUniqueId Xa = BdUniqueId.gen();
    public int fHA;
    @DrawableRes
    public int kGv;
    public String kGw;
    public int kGx;
    public int kGy;
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return Xa;
    }
}
