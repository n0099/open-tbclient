package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.a.g;
import com.baidu.tieba.recommendfrs.a.h;
import com.baidu.tieba.recommendfrs.a.i;
import com.baidu.tieba.recommendfrs.a.k;
import com.baidu.tieba.recommendfrs.a.o;
import java.util.List;
import tbclient.FineFrsPage.Pic;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> {
    private static final Class<?>[] cJD = {i.class, k.class, o.class, g.class, com.baidu.tieba.recommendfrs.a.e.class, com.baidu.tieba.recommendfrs.a.b.class, com.baidu.tieba.recommendfrs.a.c.class, com.baidu.tieba.recommendfrs.a.a.class, h.class};
    private static final int[] cyv = {i.g.recommend_frs_item_pic, i.g.recommend_frs_item_pics, i.g.recommend_frs_item_time_divider, i.g.hot_thread_item_title, i.g.hot_thread_item_text, i.g.hot_thread_item_pic, i.g.hot_thread_item_multi_pic, i.g.hot_thread_item_more, i.g.recommend_frs_item_photo_live};

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cJD, cyv, viewEventCenter);
    }

    @Override // com.baidu.tbadk.mvc.g.b
    public int eq(int i) {
        Object item = getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
            com.baidu.tieba.recommendfrs.data.b bVar = (com.baidu.tieba.recommendfrs.data.b) item;
            if (bVar.aqH() == 33) {
                return 8;
            }
            return bVar.getType() == 2 ? 1 : 0;
        }
        if (item instanceof com.baidu.tieba.recommendfrs.data.d) {
            String type = ((com.baidu.tieba.recommendfrs.data.d) item).getType();
            if (type == "text_type_title") {
                return 3;
            }
            if (type == "text_type_check_more") {
                return 7;
            }
        } else if (item instanceof com.baidu.tieba.recommendfrs.data.c) {
            List<Pic> list = ((com.baidu.tieba.recommendfrs.data.c) item).aqJ().pics;
            if (list != null) {
                int size = list.size();
                if (size >= 3) {
                    return 6;
                }
                if (size > 0 && size < 3) {
                    return 5;
                }
                return 4;
            }
        } else if (item instanceof String) {
            return 2;
        }
        return 0;
    }

    public com.baidu.tieba.recommendfrs.data.b aqr() {
        com.baidu.tieba.recommendfrs.data.b bVar;
        for (int count = getCount() - 1; count >= 0; count--) {
            Object item = getItem(count);
            if ((item instanceof com.baidu.tieba.recommendfrs.data.b) && (bVar = (com.baidu.tieba.recommendfrs.data.b) item) != null) {
                return bVar;
            }
        }
        return null;
    }
}
