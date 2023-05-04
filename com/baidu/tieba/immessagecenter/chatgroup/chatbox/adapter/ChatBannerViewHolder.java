package com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.g35;
import com.baidu.tieba.ii;
import com.baidu.tieba.l58;
import com.baidu.tieba.x58;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ChatBannerViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView d;
    public View e;
    public x58 f;
    public String g;
    public String h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ ChatBannerViewHolder b;

        public a(ChatBannerViewHolder chatBannerViewHolder, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatBannerViewHolder, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chatBannerViewHolder;
            this.a = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.l();
            ChatBannerViewHolder chatBannerViewHolder = this.b;
            chatBannerViewHolder.m(this.a, chatBannerViewHolder.h);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-599481123, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/adapter/ChatBannerViewHolder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-599481123, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/adapter/ChatBannerViewHolder;");
                return;
            }
        }
        i = ii.l(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBannerViewHolder(@NonNull View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e1a);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f090e1c);
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void d(@NonNull l58 l58Var, @NonNull TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, l58Var, tbPageContext, i2) == null) {
            if (l58Var instanceof x58) {
                x58 x58Var = (x58) l58Var;
                this.f = x58Var;
                this.g = x58Var.b();
                this.h = this.f.c();
                this.d.setOnClickListener(new a(this, tbPageContext));
            }
            n();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void f(int i2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.f(i2);
            if (TextUtils.isEmpty(this.g) && (tbImageView = this.d) != null) {
                SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080603, i2);
            }
            if (!TextUtils.isEmpty(this.g) && this.d != null) {
                o(i2);
            }
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 == 0) {
                this.e.setVisibility(8);
                return;
            }
            this.e.setVisibility(0);
            g35.d(this.e).f(R.color.CAM_X0503);
            g35.d(this.e).o(R.string.J_X06);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_BOTTOM_BANNER_CLICKED);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.f.a());
            TiebaStatic.log(statisticItem);
        }
    }

    public void m(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, str) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d.setAutoChangeStyle(true);
            this.d.setScaleType(ImageView.ScaleType.FIT_XY);
            this.d.setPlaceHolder(2);
            this.d.setUseNightOrDarkMask(false);
            this.d.setConrers(15);
            this.d.setRadiusById(R.string.J_X06);
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = i / 5;
            this.d.setLayoutParams(layoutParams);
            this.e.setLayoutParams(layoutParams);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!TextUtils.isEmpty(this.g)) {
                this.d.N(this.g, 10, false);
                o(skinType);
                return;
            }
            SkinManager.setImageResource(this.d, R.drawable.obfuscated_res_0x7f080603, skinType);
        }
    }
}
