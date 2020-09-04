package com.baidu.tieba.pb.data;

import android.support.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class l extends PostData {
    public static final BdUniqueId WI = BdUniqueId.gen();
    public int fEo;
    @DrawableRes
    public int kxX;
    public String kxY;
    public int kxZ;
    public int kya;
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return WI;
    }
}
