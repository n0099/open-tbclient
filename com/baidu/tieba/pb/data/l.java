package com.baidu.tieba.pb.data;

import android.support.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class l extends PostData {
    public static final BdUniqueId Wc = BdUniqueId.gen();
    public int fsQ;
    public int kiA;
    public int kiB;
    @DrawableRes
    public int kiy;
    public String kiz;
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return Wc;
    }
}
