package com.baidu.tieba;

import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
/* loaded from: classes6.dex */
public interface in8<ChildItemData extends BaseItem<? extends TbBaseMsg>> {
    void onEvent(ChildItemData childitemdata);
}
