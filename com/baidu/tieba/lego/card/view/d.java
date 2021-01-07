package com.baidu.tieba.lego.card.view;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
/* loaded from: classes9.dex */
public class d {
    public static n y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof com.baidu.tieba.lego.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.b) tbPageContext.getPageActivity()).getPlaySwitchController();
    }

    public static c z(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof com.baidu.tieba.lego.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.b) tbPageContext.getPageActivity()).dcW();
    }

    public static LegoListFragment A(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof com.baidu.tieba.lego.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.b) tbPageContext.getPageActivity()).dcX();
    }
}
