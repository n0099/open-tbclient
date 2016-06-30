package com.baidu.tieba.person.data;
/* loaded from: classes.dex */
public class e {
    public int ehR;
    public String ehS;
    public int mType;

    public e(int i) {
        this.mType = i;
        nW(i);
    }

    private void nW(int i) {
        switch (i) {
            case 0:
                this.ehS = "我的好友";
                return;
            case 1:
                this.ehS = "我的收藏";
                return;
            case 2:
                this.ehS = "浏览历史";
                return;
            case 3:
                this.ehS = "我的粉丝";
                return;
            case 4:
                this.ehS = "关注的人";
                return;
            case 5:
                this.ehS = "好友动态";
                return;
            default:
                return;
        }
    }
}
