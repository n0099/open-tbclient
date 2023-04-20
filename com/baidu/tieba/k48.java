package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.immessagecenter.chatgroup.floatentrance.CollapseState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class k48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j48 a;
    public CollapseState b;
    public int c;

    public k48(j48 j48Var, l48 l48Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j48Var, l48Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.a = j48Var;
        this.b = new CollapseState();
    }

    public final void d(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
            if (!TextUtils.isEmpty(str) && j != 0) {
                CollapseState collapseState = this.b;
                collapseState.a = CollapseState.Icon.FORUM;
                collapseState.e = str;
                collapseState.d = j;
                return;
            }
            CollapseState collapseState2 = this.b;
            collapseState2.a = CollapseState.Icon.DEFAULT;
            collapseState2.e = null;
            collapseState2.d = 0L;
        }
    }

    public final void e(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                this.b.c = CollapseState.Tip.AT_ME;
            } else if (z2) {
                this.b.c = CollapseState.Tip.THREE_EXP;
            } else {
                this.b.c = CollapseState.Tip.DEFAULT;
            }
        }
    }

    public void a(List<Long> list, long j, List list2, int i) {
        List<Long> list3;
        ChatRoomInfo chatRoomInfo;
        boolean z;
        boolean a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, Long.valueOf(j), list2, Integer.valueOf(i)}) == null) && (list3 = list) != null && list2 != null) {
            long j2 = 0;
            String str = null;
            this.c = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list2.get(i2) instanceof ChatGroupInfo) {
                    List<ChatRoomInfo> roomInfoList = ((ChatGroupInfo) list2.get(i2)).getRoomInfoList();
                    if (!ListUtils.isEmpty(roomInfoList)) {
                        this.c += roomInfoList.size();
                    }
                }
            }
            int i3 = -1;
            int i4 = 0;
            boolean z2 = false;
            boolean z3 = false;
            int i5 = -1;
            while (i4 < list2.size()) {
                if (list2.get(i4) instanceof ChatGroupInfo) {
                    List<ChatRoomInfo> roomInfoList2 = ((ChatGroupInfo) list2.get(i4)).getRoomInfoList();
                    if (!ListUtils.isEmpty(roomInfoList2)) {
                        int i6 = 0;
                        while (i6 < roomInfoList2.size() && (chatRoomInfo = roomInfoList2.get(i6)) != null) {
                            if (chatRoomInfo.getAtInfo() != null && chatRoomInfo.getAtInfo().getCountAll() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            int indexOf = list3.indexOf(Long.valueOf(chatRoomInfo.getRoomId()));
                            if (indexOf != i3) {
                                if (z && !z2) {
                                    j2 = chatRoomInfo.getRoomId();
                                    str = chatRoomInfo.getAvatar();
                                } else if (z && z2) {
                                    if (i5 < 0 || indexOf < i5) {
                                        j2 = chatRoomInfo.getRoomId();
                                        str = chatRoomInfo.getAvatar();
                                    }
                                } else if (!z && !z2 && ((!(a = r78.a(j)) || this.c == 1) && (i5 < 0 || indexOf < i5))) {
                                    j2 = chatRoomInfo.getRoomId();
                                    z3 = !a;
                                    str = chatRoomInfo.getAvatar();
                                    i5 = indexOf;
                                    z2 = false;
                                }
                                i5 = indexOf;
                                z2 = true;
                                z3 = false;
                            }
                            i6++;
                            list3 = list;
                            i3 = -1;
                        }
                    }
                }
                i4++;
                list3 = list;
                i3 = -1;
            }
            CollapseState clone = this.b.clone();
            e(z2, z3);
            d(str, j2);
            j48 j48Var = this.a;
            if (j48Var != null) {
                j48Var.update(clone, this.b);
            }
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            CollapseState clone = this.b.clone();
            if (z) {
                this.b.b = CollapseState.State.EXPAND;
            } else {
                this.b.b = CollapseState.State.COLLAPSE;
            }
            j48 j48Var = this.a;
            if (j48Var != null) {
                j48Var.update(clone, this.b);
            }
        }
    }

    public void c(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            CollapseState clone = this.b.clone();
            e(false, false);
            if (this.c != 1) {
                d(null, 0L);
            }
            j48 j48Var = this.a;
            if (j48Var != null) {
                j48Var.update(clone, this.b);
            }
        }
    }
}
