package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> {
    private static final Class<?>[] dXZ = {com.baidu.tieba.recommendfrs.view.c.class, com.baidu.tieba.recommendfrs.view.g.class, com.baidu.tieba.recommendfrs.view.a.class};
    private static final int[] dLH = {t.h.recommend_frs_item_pic, t.h.recommend_frs_item_pics, t.h.recommend_frs_item_photo_live};

    public n(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext, dXZ, dLH, viewEventCenter);
    }

    @Override // com.baidu.tbadk.mvc.g.b
    public int eE(int i) {
        Object item = getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.p) {
            com.baidu.tieba.recommendfrs.data.p pVar = (com.baidu.tieba.recommendfrs.data.p) item;
            if (pVar.aMB() == 33) {
                return 2;
            }
            return pVar.getType() == 2 ? 1 : 0;
        }
        return 0;
    }

    public com.baidu.tieba.recommendfrs.data.p aLQ() {
        com.baidu.tieba.recommendfrs.data.p pVar;
        for (int count = getCount() - 1; count >= 0; count--) {
            Object item = getItem(count);
            if ((item instanceof com.baidu.tieba.recommendfrs.data.p) && (pVar = (com.baidu.tieba.recommendfrs.data.p) item) != null) {
                return pVar;
            }
        }
        return null;
    }
}
