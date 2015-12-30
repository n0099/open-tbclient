package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> {
    private static final Class<?>[] dod = {com.baidu.tieba.recommendfrs.a.b.class, com.baidu.tieba.recommendfrs.a.e.class, com.baidu.tieba.recommendfrs.a.a.class};
    private static final int[] dba = {n.h.recommend_frs_item_pic, n.h.recommend_frs_item_pics, n.h.recommend_frs_item_photo_live};

    public j(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext, dod, dba, viewEventCenter);
    }

    @Override // com.baidu.tbadk.mvc.g.b
    public int ey(int i) {
        Object item = getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.j) {
            com.baidu.tieba.recommendfrs.data.j jVar = (com.baidu.tieba.recommendfrs.data.j) item;
            if (jVar.ayx() == 33) {
                return 2;
            }
            return jVar.getType() == 2 ? 1 : 0;
        }
        return 0;
    }

    public com.baidu.tieba.recommendfrs.data.j axY() {
        com.baidu.tieba.recommendfrs.data.j jVar;
        for (int count = getCount() - 1; count >= 0; count--) {
            Object item = getItem(count);
            if ((item instanceof com.baidu.tieba.recommendfrs.data.j) && (jVar = (com.baidu.tieba.recommendfrs.data.j) item) != null) {
                return jVar;
            }
        }
        return null;
    }
}
