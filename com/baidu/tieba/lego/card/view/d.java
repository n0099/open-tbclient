package com.baidu.tieba.lego.card.view;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
/* loaded from: classes2.dex */
public class d {
    public static l s(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof com.baidu.tieba.lego.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.b) tbPageContext.getPageActivity()).getPlaySwitchController();
    }

    public static c t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof com.baidu.tieba.lego.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.b) tbPageContext.getPageActivity()).bzr();
    }

    public static LegoListFragment u(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof com.baidu.tieba.lego.b)) {
            return null;
        }
        return ((com.baidu.tieba.lego.b) tbPageContext.getPageActivity()).bzs();
    }
}
