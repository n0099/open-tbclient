package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId mur = BdUniqueId.gen();
    public String aHq;
    public int grS;
    public int itemId;
    public boolean mum;
    public boolean mun;
    public boolean muo = false;
    public j mup;
    public Bundle muq;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mur;
    }
}
