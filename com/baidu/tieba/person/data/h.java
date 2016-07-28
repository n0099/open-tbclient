package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.data.MyLikeForum;
import java.util.List;
/* loaded from: classes.dex */
public class h extends a {
    public static final BdUniqueId esb = BdUniqueId.gen();
    private int count;
    private List<MyLikeForum> esc;
    private int esd = 1;
    private int isFriend = 1;
    private boolean isSelf;
    private int sex;
    private String userId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return esb;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public List<MyLikeForum> aNE() {
        return this.esc;
    }

    public void cv(List<MyLikeForum> list) {
        this.esc = list;
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

    public int aNF() {
        return this.esd;
    }

    public void oi(int i) {
        this.esd = i;
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
