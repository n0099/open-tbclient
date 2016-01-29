package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.data.MyLikeForum;
import java.util.List;
/* loaded from: classes.dex */
public class f extends a {
    public static final BdUniqueId dbK = BdUniqueId.gen();
    private int count;
    private List<MyLikeForum> dbL;
    private int dbM = 1;
    private int isFriend = 1;
    private boolean isSelf;
    private int sex;
    private String userId;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dbK;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public List<MyLikeForum> auh() {
        return this.dbL;
    }

    public void bo(List<MyLikeForum> list) {
        this.dbL = list;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public int aui() {
        return this.dbM;
    }

    public void lw(int i) {
        this.dbM = i;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
