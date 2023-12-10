package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.z29;
import java.util.Map;
/* loaded from: classes8.dex */
public interface w29 extends t29 {
    void a(@NonNull String str);

    void c(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail);

    void h();

    void i(boolean z, int i, int i2, @Nullable Map<String, Object> map, boolean z2, int i3, long j, long j2);

    void j(@NonNull String str);

    void k(@NonNull String str, @NonNull CharSequence charSequence);

    void l(@NonNull u29 u29Var);

    void n(Object obj);

    FastRequest.b<z29.e> o();

    void onChangeSkinType();

    void onDestroy();

    void q();

    boolean r();

    void s(@NonNull String str, @Nullable String str2);

    void t(int i, int i2, @Nullable String str, Object obj);

    void u(@Nullable BaseItem baseItem, @Nullable ChatRoomDetail chatRoomDetail);
}
