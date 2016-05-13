package com.baidu.tieba.person.data;
/* loaded from: classes.dex */
public class e {
    public int dzn;
    public String dzo;
    public int mType;

    public e(int i) {
        this.mType = i;
        mv(i);
    }

    private void mv(int i) {
        switch (i) {
            case 0:
                this.dzo = "我的好友";
                return;
            case 1:
                this.dzo = "我的收藏";
                return;
            case 2:
                this.dzo = "浏览历史";
                return;
            case 3:
                this.dzo = "我的粉丝";
                return;
            case 4:
                this.dzo = "关注的人";
                return;
            case 5:
                this.dzo = "好友动态";
                return;
            default:
                return;
        }
    }
}
