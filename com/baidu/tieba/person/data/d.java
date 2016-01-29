package com.baidu.tieba.person.data;
/* loaded from: classes.dex */
public class d {
    public int dbG;
    public String dbH;
    public int mType;

    public d(int i) {
        this.mType = i;
        lv(i);
    }

    private void lv(int i) {
        switch (i) {
            case 0:
                this.dbH = "我的好友";
                return;
            case 1:
                this.dbH = "我的收藏";
                return;
            case 2:
                this.dbH = "浏览历史";
                return;
            case 3:
                this.dbH = "我的粉丝";
                return;
            case 4:
                this.dbH = "关注的人";
                return;
            case 5:
                this.dbH = "好友动态";
                return;
            default:
                return;
        }
    }
}
