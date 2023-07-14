package com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.baidu.tieba.bj8;
import com.baidu.tieba.d85;
import com.baidu.tieba.hk8;
import com.baidu.tieba.yi;
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
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView e;
    public View f;
    public hk8 g;
    public FrameLayout h;
    public String i;
    public String j;
    public String k;

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
            this.b.m();
            ChatBannerViewHolder chatBannerViewHolder = this.b;
            chatBannerViewHolder.n(this.a, chatBannerViewHolder.j);
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
        yi.l(TbadkCoreApplication.getInst());
        UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        yi.l(TbadkCoreApplication.getInst());
        UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
        UtilHelper.getDimenPixelSize(R.dimen.tbds182);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBannerViewHolder(@NonNull View view2, String str) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str};
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
        this.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e6f);
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f090e71);
        this.h = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e70);
        this.k = str;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.g(i);
            if (!TextUtils.isEmpty(this.i) && this.e != null) {
                q(i);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder
    public void e(@NonNull bj8 bj8Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, bj8Var, tbPageContext, i) == null) {
            if (bj8Var instanceof hk8) {
                hk8 hk8Var = (hk8) bj8Var;
                this.g = hk8Var;
                String b = hk8Var.b();
                this.i = b;
                if (TextUtils.isEmpty(b)) {
                    this.h.setVisibility(8);
                    return;
                }
                this.h.setVisibility(0);
                this.j = this.g.c();
                this.e.setOnClickListener(new a(this, tbPageContext));
                o();
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_BOTTOM_BANNER_CLICKED);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.g.a());
            TiebaStatic.log(statisticItem);
        }
    }

    public void n(TbPageContext tbPageContext, String str) {
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

    public final void o() {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            p();
            this.e.setAutoChangeStyle(true);
            this.e.setScaleType(ImageView.ScaleType.FIT_XY);
            this.e.setPlaceHolder(2);
            this.e.setUseNightOrDarkMask(false);
            this.e.setConrers(15);
            this.e.setRadiusById(R.string.J_X06);
            int l = yi.l(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
            int l2 = (yi.l(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X005) * 2)) - UtilHelper.getDimenPixelSize(R.dimen.tbds182);
            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
            if (this.k.equals("dialog")) {
                f = l / 5;
            } else {
                f = (l2 * 64) / 322;
            }
            layoutParams.width = -1;
            layoutParams.height = (int) f;
            this.e.setLayoutParams(layoutParams);
            this.f.setLayoutParams(layoutParams);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!TextUtils.isEmpty(this.i)) {
                this.e.N(this.i, 10, false);
                q(skinType);
                return;
            }
            SkinManager.setImageResource(this.e, R.drawable.obfuscated_res_0x7f08070c, skinType);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.k.equals("dialog")) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                this.e.setLayoutParams(layoutParams);
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            this.e.setLayoutParams(layoutParams2);
        }
    }

    public final void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i == 0) {
                this.f.setVisibility(8);
                return;
            }
            this.f.setVisibility(0);
            d85.d(this.f).f(R.color.CAM_X0503);
            d85.d(this.f).o(R.string.J_X06);
        }
    }
}
