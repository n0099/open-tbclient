package com.baidu.tieba.person.data;
/* loaded from: classes.dex */
public class d {
    public int cNo;
    public String cNp;
    public int mType;

    public d(int i) {
        this.mType = i;
        kr(i);
    }

    private void kr(int i) {
        switch (i) {
            case 0:
                this.cNp = "我的好友";
                return;
            case 1:
                this.cNp = "我的收藏";
                return;
            case 2:
                this.cNp = "浏览历史";
                return;
            case 3:
                this.cNp = "我的粉丝";
                return;
            case 4:
                this.cNp = "关注的人";
                return;
            default:
                return;
        }
    }
}
