package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.data.MyLikeForum;
import java.util.List;
/* loaded from: classes.dex */
public class f extends a {
    public static final BdUniqueId dwn = BdUniqueId.gen();
    private int count;
    private List<MyLikeForum> dwo;
    private int dwp = 1;
    private int isFriend = 1;
    private boolean isSelf;
    private int sex;
    private String userId;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dwn;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public List<MyLikeForum> aBN() {
        return this.dwo;
    }

    public void bK(List<MyLikeForum> list) {
        this.dwo = list;
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

    public int aBO() {
        return this.dwp;
    }

    public void mF(int i) {
        this.dwp = i;
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
