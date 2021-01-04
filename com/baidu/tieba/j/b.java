package com.baidu.tieba.j;

import tbclient.GoodsWin;
/* loaded from: classes.dex */
public class b {
    public String goods_url;
    public Integer show;

    public void a(GoodsWin goodsWin) {
        this.show = goodsWin.show;
        this.goods_url = goodsWin.goods_url;
    }

    public boolean cQl() {
        return this.show.intValue() == 1;
    }
}
