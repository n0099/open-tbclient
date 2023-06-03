package com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.gd8;
import com.baidu.tieba.hd8;
import com.baidu.tieba.m75;
import com.baidu.tieba.tc8;
import com.baidu.tieba.uc8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ChatNameViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public static int i;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout d;
    public TextView e;
    public ImageView f;
    public RecyclerView g;
    public gd8 h;

    /* loaded from: classes6.dex */
    public class a extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ChatNameViewHolder chatNameViewHolder, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatNameViewHolder, context};
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
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatNameViewHolder a;

        public b(ChatNameViewHolder chatNameViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatNameViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatNameViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null) {
                if (this.a.h.d()) {
                    this.a.f.setImageResource(R.drawable.obfuscated_res_0x7f080910);
                    ChatNameViewHolder chatNameViewHolder = this.a;
                    uc8.d(chatNameViewHolder, chatNameViewHolder.g);
                    int unused = ChatNameViewHolder.i = 1;
                } else {
                    this.a.f.setImageResource(R.drawable.obfuscated_res_0x7f08090f);
                    ChatNameViewHolder chatNameViewHolder2 = this.a;
                    uc8.a(chatNameViewHolder2, chatNameViewHolder2.g);
                    int unused2 = ChatNameViewHolder.i = 2;
                }
                this.a.n();
                this.a.h.g(true ^ this.a.h.d());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatNameViewHolder(@NonNull View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091824);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e79);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e95);
        this.g = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090e86);
        this.g.setLayoutManager(new a(this, view2.getContext()));
        this.g.setFocusable(false);
        this.d.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && !this.h.e()) {
            m75 d = m75.d(this.e);
            d.B(R.dimen.T_X08);
            d.C(R.string.F_X01);
            d.w(R.color.CAM_X0107);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void d(@NonNull tc8 tc8Var, @NonNull TbPageContext tbPageContext, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, tc8Var, tbPageContext, i2) == null) && (tc8Var instanceof gd8)) {
            gd8 gd8Var = (gd8) tc8Var;
            this.h = gd8Var;
            this.e.setText(gd8Var.b());
            ImageView imageView = this.f;
            int i4 = R.drawable.obfuscated_res_0x7f080910;
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080910);
            if (this.g.getAdapter() != this.h.getAdapter()) {
                if (this.g.getAdapter() != null) {
                    this.g.swapAdapter(this.h.getAdapter(), true);
                } else {
                    this.g.setAdapter(this.h.getAdapter());
                }
            } else {
                this.h.f();
            }
            RecyclerView recyclerView = this.g;
            if (this.h.d()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            recyclerView.setVisibility(i3);
            ImageView imageView2 = this.f;
            if (this.h.d()) {
                i4 = R.drawable.obfuscated_res_0x7f08090f;
            }
            imageView2.setImageResource(i4);
            o();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_CLICK);
            tc8 tc8Var = this.h.getSubItems().get(0);
            if (tc8Var instanceof hd8) {
                hd8 hd8Var = (hd8) tc8Var;
                if (hd8Var.a() != null) {
                    statisticItem.param("fid", hd8Var.a().getForumId());
                    statisticItem.param("fname", hd8Var.a().getForumName());
                }
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_source", this.h.b());
            TiebaStatic.log(statisticItem);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.h.e()) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
            }
            f(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
