package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
import com.baidu.tieba.recommendfrs.a.f;
import com.baidu.tieba.recommendfrs.a.h;
import com.baidu.tieba.recommendfrs.a.i;
import com.baidu.tieba.recommendfrs.a.j;
import com.baidu.tieba.recommendfrs.a.m;
import java.util.List;
import tbclient.FineFrsPage.Pic;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.j.b<Object, com.baidu.tbadk.mvc.e.c, com.baidu.tbadk.mvc.j.a<Object, com.baidu.tbadk.mvc.e.c>> {
    private static final Class<?>[] cbu = {i.class, j.class, m.class, h.class, f.class, com.baidu.tieba.recommendfrs.a.b.class, com.baidu.tieba.recommendfrs.a.d.class, com.baidu.tieba.recommendfrs.a.a.class};
    private static final int[] cbv = {r.recommend_frs_item_pic, r.recommend_frs_item_pics, r.recommend_frs_item_time_divider, r.hot_thread_item_title, r.hot_thread_item_text, r.hot_thread_item_pic, r.hot_thread_item_multi_pic, r.hot_thread_item_more};

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cbu, cbv, viewEventCenter);
    }

    @Override // com.baidu.tbadk.mvc.j.b
    public int ec(int i) {
        Object item = getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.data.b) {
            return ((com.baidu.tieba.recommendfrs.data.b) item).getType() == 2 ? 1 : 0;
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
            List<Pic> list = ((com.baidu.tieba.recommendfrs.data.c) item).ahB().pics;
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
}
