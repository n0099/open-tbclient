package com.baidu.tieba.pb.data;

import android.support.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes21.dex */
public class l extends PostData {
    public static final BdUniqueId Xw = BdUniqueId.gen();
    public int gjk;
    @DrawableRes
    public int lov;
    public String lox;
    public int loy;
    public int loz;
    private int position = 0;
    public int loA = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return Xw;
    }
}
