package com.baidu.tieba.person.data;
/* loaded from: classes.dex */
public class d {
    public int dwj;
    public String dwk;
    public int mType;

    public d(int i) {
        this.mType = i;
        mE(i);
    }

    private void mE(int i) {
        switch (i) {
            case 0:
                this.dwk = "我的好友";
                return;
            case 1:
                this.dwk = "我的收藏";
                return;
            case 2:
                this.dwk = "浏览历史";
                return;
            case 3:
                this.dwk = "我的粉丝";
                return;
            case 4:
                this.dwk = "关注的人";
                return;
            case 5:
                this.dwk = "好友动态";
                return;
            default:
                return;
        }
    }
}
