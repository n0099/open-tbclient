package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.data.MyLikeForum;
import java.util.List;
/* loaded from: classes.dex */
public class f extends a {
    public static final BdUniqueId cRW = BdUniqueId.gen();
    private List<MyLikeForum> cRX;
    private int count;
    private boolean isSelf;
    private int sex;
    private String userId;
    private int cRY = 1;
    private int isFriend = 1;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cRW;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public List<MyLikeForum> app() {
        return this.cRX;
    }

    public void bm(List<MyLikeForum> list) {
        this.cRX = list;
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

    public int apq() {
        return this.cRY;
    }

    public void kP(int i) {
        this.cRY = i;
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
