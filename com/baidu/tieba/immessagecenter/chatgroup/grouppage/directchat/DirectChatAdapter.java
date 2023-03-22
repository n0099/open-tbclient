package com.baidu.tieba.immessagecenter.chatgroup.grouppage.directchat;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ViewSingleClickCompat;
import com.baidu.tieba.R;
import com.baidu.tieba.fv7;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.n15;
import com.baidu.tieba.nx7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class DirectChatAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<AbilityItem> b;
    public long c;
    public final List<String> d;
    public final int e;
    public final int f;
    public final int g;
    @NonNull
    public fv7 h;
    public View.OnClickListener i;

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public ImageView b;
        public TextView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NonNull DirectChatAdapter directChatAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {directChatAdapter, view2};
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
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09088b);
            this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09088a);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09088d);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DirectChatAdapter a;

        public a(DirectChatAdapter directChatAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {directChatAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = directChatAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String content;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof AbilityItem)) {
                AbilityItem abilityItem = (AbilityItem) view2.getTag();
                this.a.h.c(abilityItem, null);
                if (abilityItem.getStyleConf().getContent() == null) {
                    content = "";
                } else {
                    content = abilityItem.getStyleConf().getContent();
                }
                nx7.e("c15187", content, this.a.c);
            }
        }
    }

    public DirectChatAdapter(Context context, @NonNull fv7 fv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fv7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.i = new a(this);
        this.a = context;
        this.h = fv7Var;
        this.f = context.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        this.e = context.getResources().getDimensionPixelSize(R.dimen.M_W_X004);
        this.g = context.getResources().getDimensionPixelSize(R.dimen.M_W_X006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        AbilityItem abilityItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, viewHolder, i) == null) && (abilityItem = (AbilityItem) ListUtils.getItem(this.b, i)) != null && abilityItem.getStyleConf() != null) {
            AbilityItem.StyleConf styleConf = abilityItem.getStyleConf();
            g(styleConf, viewHolder);
            if (!TextUtils.isEmpty(styleConf.getContent())) {
                viewHolder.c.setVisibility(0);
                viewHolder.c.setText(styleConf.getContent());
            } else {
                j(viewHolder);
            }
            String content = styleConf.getContent();
            if (!TextUtils.isEmpty(content) && !this.d.contains(content)) {
                nx7.e("c15186", content, this.c);
                this.d.add(content);
            }
            viewHolder.a.setTag(abilityItem);
            ViewSingleClickCompat.setOnClickListener(viewHolder.a, this.i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.a.getLayoutParams();
            if (i == 0) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.f;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.e;
            }
            viewHolder.a.setLayoutParams(layoutParams);
        }
    }

    public final void j(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, viewHolder) == null) {
            viewHolder.c.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int i = this.g;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.gravity = 16;
            viewHolder.b.setLayoutParams(layoutParams);
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.c = j;
        }
    }

    public final void n(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewHolder) == null) {
            viewHolder.b.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int i = this.g;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            layoutParams.gravity = 16;
            viewHolder.c.setLayoutParams(layoutParams);
        }
    }

    public void o(@NonNull List<AbilityItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.b = list;
        }
    }

    public final Uri f(@NonNull AbilityItem.StyleConf styleConf, @NonNull ViewHolder viewHolder) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, styleConf, viewHolder)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (styleConf.getDay() == null || styleConf.getDay().getContentColor() == null || styleConf.getDay().getBackgroundColor() == null || styleConf.getDark() == null || styleConf.getDark().getContentColor() == null || styleConf.getDark().getBackgroundColor() == null) {
                l(viewHolder);
            }
            if (skinType == 4) {
                if (styleConf.getDark() != null && !TextUtils.isEmpty(styleConf.getDark().getIcon())) {
                    str = styleConf.getDark().getIcon();
                } else {
                    str = null;
                }
                if (styleConf.getDark() != null && !TextUtils.isEmpty(styleConf.getDark().getBackgroundColor()) && !TextUtils.isEmpty(styleConf.getDark().getContentColor())) {
                    m(viewHolder, styleConf.getDark().getBackgroundColor(), styleConf.getDark().getContentColor());
                }
            } else {
                if (styleConf.getDay() != null && !TextUtils.isEmpty(styleConf.getDay().getIcon())) {
                    str = styleConf.getDay().getIcon();
                } else {
                    str = null;
                }
                if (styleConf.getDay() != null && !TextUtils.isEmpty(styleConf.getDay().getBackgroundColor()) && !TextUtils.isEmpty(styleConf.getDay().getContentColor())) {
                    m(viewHolder, styleConf.getDay().getBackgroundColor(), styleConf.getDay().getContentColor());
                }
            }
            if (StringUtils.isNull(str)) {
                return null;
            }
            return Uri.parse(str);
        }
        return (Uri) invokeLL.objValue;
    }

    public void g(@NonNull AbilityItem.StyleConf styleConf, @NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, styleConf, viewHolder) == null) {
            Uri f = f(styleConf, viewHolder);
            if (f == null) {
                n(viewHolder);
                return;
            }
            viewHolder.b.setVisibility(0);
            Glide.with(viewHolder.b.getContext()).load(f).placeholder((int) R.drawable.pic_use_header_40_n).into(viewHolder.b);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: i */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            return new ViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d024b, viewGroup, false));
        }
        return (ViewHolder) invokeLI.objValue;
    }

    public final void l(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewHolder) == null) {
            n15 d = n15.d(viewHolder.a);
            d.o(R.string.J_X01);
            d.f(R.color.CAM_X0208);
            n15 d2 = n15.d(viewHolder.c);
            d2.A(R.dimen.T_X08);
            d2.B(R.string.F_X02);
            d2.w(R.color.CAM_X0105);
        }
    }

    public final void m(@NonNull ViewHolder viewHolder, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewHolder, str, str2) == null) {
            n15 d = n15.d(viewHolder.a);
            d.o(R.string.J_X01);
            d.g(str);
            n15 d2 = n15.d(viewHolder.c);
            d2.A(R.dimen.T_X08);
            d2.B(R.string.F_X02);
            viewHolder.c.setTextColor(Color.parseColor(str2));
        }
    }
}
