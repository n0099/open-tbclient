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
import com.baidu.tieba.ld8;
import com.baidu.tieba.md8;
import com.baidu.tieba.p75;
import com.baidu.tieba.yd8;
import com.baidu.tieba.zd8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ChatNameViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public static int j;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout e;
    public TextView f;
    public ImageView g;
    public RecyclerView h;
    public yd8 i;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i != null) {
                if (this.a.i.d()) {
                    this.a.g.setImageResource(R.drawable.obfuscated_res_0x7f080912);
                    ChatNameViewHolder chatNameViewHolder = this.a;
                    md8.d(chatNameViewHolder, chatNameViewHolder.h);
                    int unused = ChatNameViewHolder.j = 1;
                } else {
                    this.a.g.setImageResource(R.drawable.obfuscated_res_0x7f080911);
                    ChatNameViewHolder chatNameViewHolder2 = this.a;
                    md8.a(chatNameViewHolder2, chatNameViewHolder2.h);
                    int unused2 = ChatNameViewHolder.j = 2;
                }
                this.a.n();
                this.a.i.g(true ^ this.a.i.d());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09182a);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e77);
        this.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e93);
        this.h = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090e84);
        this.h.setLayoutManager(new a(this, view2.getContext()));
        this.h.setFocusable(false);
        this.e.setOnClickListener(new b(this));
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void f(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && !this.i.e()) {
            p75 d = p75.d(this.f);
            d.C(R.dimen.T_X08);
            d.D(R.string.F_X01);
            d.x(R.color.CAM_X0107);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void d(@NonNull ld8 ld8Var, @NonNull TbPageContext tbPageContext, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, ld8Var, tbPageContext, i) == null) && (ld8Var instanceof yd8)) {
            yd8 yd8Var = (yd8) ld8Var;
            this.i = yd8Var;
            this.f.setText(yd8Var.b());
            ImageView imageView = this.g;
            int i3 = R.drawable.obfuscated_res_0x7f080912;
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080912);
            if (this.h.getAdapter() != this.i.getAdapter()) {
                if (this.h.getAdapter() != null) {
                    this.h.swapAdapter(this.i.getAdapter(), true);
                } else {
                    this.h.setAdapter(this.i.getAdapter());
                }
            } else {
                this.i.f();
            }
            RecyclerView recyclerView = this.h;
            if (this.i.d()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            recyclerView.setVisibility(i2);
            ImageView imageView2 = this.g;
            if (this.i.d()) {
                i3 = R.drawable.obfuscated_res_0x7f080911;
            }
            imageView2.setImageResource(i3);
            o();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_CLICK);
            ld8 ld8Var = this.i.getSubItems().get(0);
            if (ld8Var instanceof zd8) {
                zd8 zd8Var = (zd8) ld8Var;
                if (zd8Var.a() != null) {
                    statisticItem.param("fid", zd8Var.a().getForumId());
                    statisticItem.param("fname", zd8Var.a().getForumName());
                }
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_type", j);
            statisticItem.param("obj_source", this.i.b());
            TiebaStatic.log(statisticItem);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.i.e()) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
            f(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
