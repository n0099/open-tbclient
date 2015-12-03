package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.data.e;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> {
    private static final Class<?>[] din = {com.baidu.tieba.recommendfrs.a.b.class, com.baidu.tieba.recommendfrs.a.d.class, com.baidu.tieba.recommendfrs.a.a.class};
    private static final int[] cWd = {n.g.recommend_frs_item_pic, n.g.recommend_frs_item_pics, n.g.recommend_frs_item_photo_live};

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext, din, cWd, viewEventCenter);
    }

    @Override // com.baidu.tbadk.mvc.g.b
    public int eE(int i) {
        Object item = getItem(i);
        if (item instanceof e) {
            e eVar = (e) item;
            if (eVar.awt() == 33) {
                return 2;
            }
            return eVar.getType() == 2 ? 1 : 0;
        }
        return 0;
    }

    public e awb() {
        e eVar;
        for (int count = getCount() - 1; count >= 0; count--) {
            Object item = getItem(count);
            if ((item instanceof e) && (eVar = (e) item) != null) {
                return eVar;
            }
        }
        return null;
    }
}
