package com.baidu.tieba.person.data;
/* loaded from: classes.dex */
public class f {
    public int erX;
    public String erY;
    public int mType;

    public f(int i) {
        this.mType = i;
        oh(i);
    }

    private void oh(int i) {
        switch (i) {
            case 0:
                this.erY = "我的好友";
                return;
            case 1:
                this.erY = "我的收藏";
                return;
            case 2:
                this.erY = "浏览历史";
                return;
            case 3:
                this.erY = "我的粉丝";
                return;
            case 4:
                this.erY = "关注的人";
                return;
            default:
                return;
        }
    }
}
