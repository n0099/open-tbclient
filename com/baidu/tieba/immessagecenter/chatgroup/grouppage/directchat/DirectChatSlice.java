package com.baidu.tieba.immessagecenter.chatgroup.grouppage.directchat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.CustomRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.le8;
import com.baidu.tieba.o75;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class DirectChatSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final TbPageContext<?> j;
    @Nullable
    public a k;
    @Nullable
    public DirectChatAdapter l;
    @Nullable
    public ChatRoomDetail m;
    @Nullable
    public le8 n;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public CustomRecyclerView b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                a aVar = new a();
                aVar.a = view2;
                aVar.b = (CustomRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0908bc);
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    public DirectChatSlice(@NonNull TbPageContext<?> tbPageContext, @NonNull le8 le8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, le8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = tbPageContext;
        this.n = le8Var;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void T(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.T(view2, bundle);
            if (view2 != null) {
                this.k = a.a(view2);
            }
            this.l = new DirectChatAdapter(this.j.getContext(), this.n);
            this.k.b.setLayoutManager(new LinearLayoutManager(this.j.getContext(), 0, false));
            this.k.b.setAdapter(this.l);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @Nullable
    public View M(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0889, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void W() {
        ChatRoomDetail chatRoomDetail;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (chatRoomDetail = this.m) != null && chatRoomDetail.getQuickTalk() != null) {
            this.l.J(this.m.getQuickTalk());
            if (this.m.getBasicInfo() != null) {
                this.l.E(this.m.getBasicInfo().getId());
                this.l.C(this.m.getBasicInfo().getForumId());
                this.l.F(this.m.getBasicInfo().getName());
            }
            this.l.notifyDataSetChanged();
        }
    }

    public void X(@NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, chatRoomDetail) == null) {
            this.m = chatRoomDetail;
            W();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            this.l.notifyDataSetChanged();
            o75.d(this.k.b).f(R.color.transparent);
            o75.d(this.k.a).f(R.color.transparent);
        }
    }
}
