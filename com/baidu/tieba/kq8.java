package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
/* loaded from: classes7.dex */
public interface kq8<ChildItemData extends BaseItem<? extends TbBaseMsg>> {
    boolean a(@NonNull View view2, @NonNull ChildItemData childitemdata, int i);
}
