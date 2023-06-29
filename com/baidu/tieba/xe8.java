package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatNameViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xe8 {
    public static /* synthetic */ Interceptable $ic;
    public static int g;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public jf8 a;
    @NonNull
    public ve8 b;
    public View c;
    public ChatNameViewHolder d;
    public String e;
    public final View.OnClickListener f;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe8 a;

        public a(xe8 xe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xe8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            jf8 jf8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (jf8Var = this.a.a) != null) {
                if (jf8Var.d()) {
                    if (this.a.e.equals("msgTabFragment")) {
                        WebPManager.setPureDrawable(this.a.b.d(), R.drawable.obfuscated_res_0x7f080a89, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
                    } else {
                        this.a.b.d().setImageResource(R.drawable.obfuscated_res_0x7f080917);
                    }
                    xe8 xe8Var = this.a;
                    ge8.d(xe8Var.d, xe8Var.b.c());
                    int unused = xe8.g = 1;
                } else {
                    if (this.a.e.equals("msgTabFragment")) {
                        WebPManager.setPureDrawable(this.a.b.d(), R.drawable.icon_close, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
                    } else {
                        this.a.b.d().setImageResource(R.drawable.obfuscated_res_0x7f080914);
                    }
                    xe8 xe8Var2 = this.a;
                    ge8.a(xe8Var2.d, xe8Var2.b.c());
                    int unused2 = xe8.g = 2;
                }
                this.a.c();
                jf8 jf8Var2 = this.a.a;
                jf8Var2.g(true ^ jf8Var2.d());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(xe8 xe8Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, recycler, state) == null) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public xe8(@NonNull jf8 jf8Var, @NonNull ve8 ve8Var, View view2, ChatNameViewHolder chatNameViewHolder, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jf8Var, ve8Var, view2, chatNameViewHolder, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.a = jf8Var;
        this.b = ve8Var;
        this.c = view2;
        this.d = chatNameViewHolder;
        this.e = str;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                WebPManager.setPureDrawable(this.b.d(), R.drawable.icon_close, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            } else {
                WebPManager.setPureDrawable(this.b.d(), R.drawable.obfuscated_res_0x7f080a89, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_CLICK);
            fe8 fe8Var = this.a.getSubItems().get(0);
            if (fe8Var instanceof kf8) {
                kf8 kf8Var = (kf8) fe8Var;
                if (kf8Var.a() != null) {
                    statisticItem.param("fid", kf8Var.a().getForumId());
                    statisticItem.param("fname", kf8Var.a().getForumName());
                }
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_type", g);
            statisticItem.param("obj_source", this.a.b());
            TiebaStatic.log(statisticItem);
        }
    }

    public void d(@NonNull jf8 jf8Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jf8Var) == null) {
            this.b.c().setLayoutManager(new b(this, this.c.getContext()));
            this.b.c().setFocusable(false);
            this.b.a().setOnClickListener(this.f);
            this.b.e().setText(jf8Var.b());
            boolean equals = this.e.equals("msgTabFragment");
            int i2 = R.drawable.obfuscated_res_0x7f080917;
            if (equals) {
                WebPManager.setPureDrawable(this.b.d(), R.drawable.obfuscated_res_0x7f080a89, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            } else {
                this.b.d().setImageResource(R.drawable.obfuscated_res_0x7f080917);
            }
            if (this.b.c().getAdapter() != jf8Var.getAdapter()) {
                if (this.b.c().getAdapter() != null) {
                    this.b.c().swapAdapter(jf8Var.getAdapter(), true);
                } else {
                    this.b.c().setAdapter(jf8Var.getAdapter());
                }
            } else {
                jf8Var.f();
            }
            RecyclerView c = this.b.c();
            if (jf8Var.d()) {
                i = 8;
            } else {
                i = 0;
            }
            c.setVisibility(i);
            if (this.e.equals("msgTabFragment")) {
                f(jf8Var.d());
            } else {
                ImageView d = this.b.d();
                if (jf8Var.d()) {
                    i2 = R.drawable.obfuscated_res_0x7f080914;
                }
                d.setImageResource(i2);
            }
            if (this.a.e()) {
                this.b.a().setVisibility(8);
            } else {
                this.b.a().setVisibility(0);
            }
            e();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.b(TbadkCoreApplication.getInst().getSkinType(), this.a);
        }
    }
}
