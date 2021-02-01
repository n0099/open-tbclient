package com.baidu.tieba.pb.data;

import androidx.annotation.DrawableRes;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class m extends PostData {
    public static final BdUniqueId Yl = BdUniqueId.gen();
    public int gAx;
    @DrawableRes
    public int lLi;
    public String lLj;
    public int lLk;
    public int lLl;
    private int position = 0;
    public int lLm = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return Yl;
    }
}
