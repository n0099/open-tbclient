package com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter;

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
import com.baidu.tieba.fh7;
import com.baidu.tieba.gh7;
import com.baidu.tieba.rw4;
import com.baidu.tieba.wg7;
import com.baidu.tieba.xg7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ChatNameViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public static int i;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout d;
    public TextView e;
    public ImageView f;
    public RecyclerView g;
    public fh7 h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatNameViewHolder a;

        public a(ChatNameViewHolder chatNameViewHolder) {
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
                if (this.a.h.g()) {
                    this.a.f.setImageResource(R.drawable.obfuscated_res_0x7f08077f);
                    ChatNameViewHolder chatNameViewHolder = this.a;
                    xg7.d(chatNameViewHolder, chatNameViewHolder.g);
                    int unused = ChatNameViewHolder.i = 1;
                } else {
                    this.a.f.setImageResource(R.drawable.obfuscated_res_0x7f08077e);
                    ChatNameViewHolder chatNameViewHolder2 = this.a;
                    xg7.a(chatNameViewHolder2, chatNameViewHolder2.g);
                    int unused2 = ChatNameViewHolder.i = 2;
                }
                this.a.n();
                this.a.h.j(true ^ this.a.h.g());
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
        this.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916c1);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d62);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090d7a);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090d6c);
        this.g = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(view2.getContext()));
        this.g.setFocusable(false);
        this.d.setOnClickListener(new a(this));
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && !this.h.h()) {
            rw4 d = rw4.d(this.e);
            d.z(R.dimen.T_X08);
            d.A(R.string.F_X01);
            d.v(R.color.CAM_X0107);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void d(@NonNull wg7 wg7Var, @NonNull TbPageContext tbPageContext, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, wg7Var, tbPageContext, i2) == null) && (wg7Var instanceof fh7)) {
            fh7 fh7Var = (fh7) wg7Var;
            this.h = fh7Var;
            this.e.setText(fh7Var.d());
            ImageView imageView = this.f;
            int i4 = R.drawable.obfuscated_res_0x7f08077f;
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08077f);
            if (this.g.getAdapter() != this.h.b()) {
                if (this.g.getAdapter() != null) {
                    this.g.swapAdapter(this.h.b(), true);
                } else {
                    this.g.setAdapter(this.h.b());
                }
            } else {
                this.h.i();
            }
            RecyclerView recyclerView = this.g;
            if (this.h.g()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            recyclerView.setVisibility(i3);
            ImageView imageView2 = this.f;
            if (this.h.g()) {
                i4 = R.drawable.obfuscated_res_0x7f08077e;
            }
            imageView2.setImageResource(i4);
            o();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_CLICK);
            wg7 wg7Var = this.h.e().get(0);
            if (wg7Var instanceof gh7) {
                gh7 gh7Var = (gh7) wg7Var;
                if (gh7Var.b() != null) {
                    statisticItem.param("fid", gh7Var.b().getForumId());
                    statisticItem.param("fname", gh7Var.b().getForumName());
                }
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_source", this.h.d());
            TiebaStatic.log(statisticItem);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.h.h()) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
            }
            f(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
