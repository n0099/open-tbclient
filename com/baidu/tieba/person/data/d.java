package com.baidu.tieba.person.data;
/* loaded from: classes.dex */
public class d {
    public int cRS;
    public String cRT;
    public int mType;

    public d(int i) {
        this.mType = i;
        kO(i);
    }

    private void kO(int i) {
        switch (i) {
            case 0:
                this.cRT = "我的好友";
                return;
            case 1:
                this.cRT = "我的收藏";
                return;
            case 2:
                this.cRT = "浏览历史";
                return;
            case 3:
                this.cRT = "我的粉丝";
                return;
            case 4:
                this.cRT = "关注的人";
                return;
            default:
                return;
        }
    }
}
