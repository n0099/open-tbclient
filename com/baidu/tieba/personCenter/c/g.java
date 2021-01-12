package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends BaseCardInfo implements com.baidu.adp.widget.ListView.n {
    public static BdUniqueId mkT = BdUniqueId.gen();
    public List<a> ewR;
    public UserData mUserData;

    /* loaded from: classes2.dex */
    public static class a {
        public int mkU;
        public String text;
        public int type;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mkT;
    }

    public void fx(List<a> list) {
        this.ewR = list;
    }
}
