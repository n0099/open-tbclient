package com.baidu.tieba.pb.data;

import androidx.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class m extends PostData {
    public static final BdUniqueId Yl = BdUniqueId.gen();
    public int gAL;
    public int lLA;
    @DrawableRes
    public int lLx;
    public String lLy;
    public int lLz;
    private int position = 0;
    public int lLB = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return Yl;
    }
}
