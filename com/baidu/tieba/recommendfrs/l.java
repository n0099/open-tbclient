package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> {
    private static final Class<?>[] dDm = {com.baidu.tieba.recommendfrs.b.c.class, com.baidu.tieba.recommendfrs.b.g.class, com.baidu.tieba.recommendfrs.b.a.class};
    private static final int[] dnR = {t.h.recommend_frs_item_pic, t.h.recommend_frs_item_pics, t.h.recommend_frs_item_photo_live};

    public l(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext, dDm, dnR, viewEventCenter);
    }

    @Override // com.baidu.tbadk.mvc.g.b
    public int eS(int i) {
        Object item = getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.l) {
            com.baidu.tieba.recommendfrs.data.l lVar = (com.baidu.tieba.recommendfrs.data.l) item;
            if (lVar.aFC() == 33) {
                return 2;
            }
            return lVar.getType() == 2 ? 1 : 0;
        }
        return 0;
    }

    public com.baidu.tieba.recommendfrs.data.l aEX() {
        com.baidu.tieba.recommendfrs.data.l lVar;
        for (int count = getCount() - 1; count >= 0; count--) {
            Object item = getItem(count);
            if ((item instanceof com.baidu.tieba.recommendfrs.data.l) && (lVar = (com.baidu.tieba.recommendfrs.data.l) item) != null) {
                return lVar;
            }
        }
        return null;
    }
}
