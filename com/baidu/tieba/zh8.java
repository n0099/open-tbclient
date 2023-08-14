package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.adapter.ResponsePanelEmojiAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.Reaction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class zh8 implements ex6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public LinearLayout a;
    @NonNull
    public final wh8 b;
    public ImageView c;
    @Nullable
    public ResponsePanelEmojiAdapter d;

    /* loaded from: classes8.dex */
    public class a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zh8 zh8Var, Context context, int i, boolean z) {
            super(context, i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zh8Var, context, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements lk8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zh8 a;

        public b(zh8 zh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zh8Var;
        }

        @Override // com.baidu.tieba.lk8
        public void a(@NonNull Reaction reaction) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, reaction) == null) {
                this.a.b.K(reaction);
                this.a.b.A();
            }
        }
    }

    public zh8(@NonNull wh8 wh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wh8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = wh8Var;
    }

    public void c(@NonNull List<Reaction> list) {
        ResponsePanelEmojiAdapter responsePanelEmojiAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && (responsePanelEmojiAdapter = this.d) != null) {
            responsePanelEmojiAdapter.o(list);
        }
    }

    public void d(boolean z) {
        LinearLayout linearLayout;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || (linearLayout = this.a) == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        linearLayout.setVisibility(i);
    }

    @Override // com.baidu.tieba.ex6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            WebPManager.setPureDrawable(this.c, R.drawable.obfuscated_res_0x7f0800e2, R.color.CAM_X0108, null);
        }
    }

    public void b(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e88);
            this.a = linearLayout;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            int i = hk8.a;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.a.setLayoutParams(layoutParams);
            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091e3c);
            this.d = new ResponsePanelEmojiAdapter(this.b.getPageContext().getOrignalPage().getPageContext());
            a aVar = new a(this, this.b.getPageContext().getPageActivity(), 0, false);
            this.d.p(new b(this));
            recyclerView.setLayoutManager(aVar);
            recyclerView.setAdapter(this.d);
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09178a);
            this.c = imageView;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            int i2 = hk8.b;
            layoutParams2.leftMargin = i2;
            layoutParams2.rightMargin = i2;
            this.c.setLayoutParams(layoutParams2);
            this.c.setOnClickListener(this.b);
            onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }
}
