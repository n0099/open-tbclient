package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.mz8;
import java.util.Map;
/* loaded from: classes6.dex */
public interface jz8 extends gz8 {
    void a(@NonNull String str);

    void c(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail);

    void h();

    void i(boolean z, int i, int i2, @Nullable Map<String, Object> map, boolean z2, int i3, long j, long j2);

    void k(@NonNull String str);

    void l(@NonNull String str, @NonNull CharSequence charSequence);

    void n(@NonNull hz8 hz8Var);

    void o(Object obj);

    void onChangeSkinType();

    void onDestroy();

    FastRequest.b<mz8.e> p();

    void q();

    boolean r();

    void s(@NonNull String str, @Nullable String str2);

    void t(int i, int i2, @Nullable String str, Object obj);

    void u(@Nullable BaseItem baseItem, @Nullable ChatRoomDetail chatRoomDetail);
}
