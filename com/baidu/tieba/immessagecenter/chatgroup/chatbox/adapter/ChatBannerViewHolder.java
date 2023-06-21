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
import com.baidu.tieba.ld8;
import com.baidu.tieba.p75;
import com.baidu.tieba.wi;
import com.baidu.tieba.xd8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ChatBannerViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView e;
    public View f;
    public xd8 g;
    public String h;
    public String i;

    /* loaded from: classes6.dex */
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
            chatBannerViewHolder.m(this.a, chatBannerViewHolder.i);
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
        j = wi.l(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e57);
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f090e59);
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void d(@NonNull ld8 ld8Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, ld8Var, tbPageContext, i) == null) {
            if (ld8Var instanceof xd8) {
                xd8 xd8Var = (xd8) ld8Var;
                this.g = xd8Var;
                this.h = xd8Var.b();
                this.i = this.g.c();
                this.e.setOnClickListener(new a(this, tbPageContext));
            }
            n();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void f(int i) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.f(i);
            if (TextUtils.isEmpty(this.h) && (tbImageView = this.e) != null) {
                SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f08070a, i);
            }
            if (!TextUtils.isEmpty(this.h) && this.e != null) {
                o(i);
            }
        }
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i == 0) {
                this.f.setVisibility(8);
                return;
            }
            this.f.setVisibility(0);
            p75.d(this.f).f(R.color.CAM_X0503);
            p75.d(this.f).o(R.string.J_X06);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_BOTTOM_BANNER_CLICKED);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.g.a());
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
            this.e.setAutoChangeStyle(true);
            this.e.setScaleType(ImageView.ScaleType.FIT_XY);
            this.e.setPlaceHolder(2);
            this.e.setUseNightOrDarkMask(false);
            this.e.setConrers(15);
            this.e.setRadiusById(R.string.J_X06);
            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = j / 5;
            this.e.setLayoutParams(layoutParams);
            this.f.setLayoutParams(layoutParams);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!TextUtils.isEmpty(this.h)) {
                this.e.N(this.h, 10, false);
                o(skinType);
                return;
            }
            SkinManager.setImageResource(this.e, R.drawable.obfuscated_res_0x7f08070a, skinType);
        }
    }
}
