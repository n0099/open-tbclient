package com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.b39;
import com.baidu.tieba.fn8;
import com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder;
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
    public b39 g;
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
            this.b.n();
            ChatBannerViewHolder chatBannerViewHolder = this.b;
            chatBannerViewHolder.o(this.a, chatBannerViewHolder.j);
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
        BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
        UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
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
        this.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ef8);
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f090efa);
        this.h = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ef9);
        this.k = str;
    }

    @Override // com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.f(i);
            if (!TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.j) && this.e != null) {
                s(i);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder
    public void d(@NonNull fn8 fn8Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, fn8Var, tbPageContext, i) == null) {
            if (fn8Var instanceof b39) {
                b39 b39Var = (b39) fn8Var;
                this.g = b39Var;
                this.i = b39Var.b();
                this.j = this.g.c();
                if (!TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.j)) {
                    this.h.setVisibility(0);
                    this.e.setOnClickListener(new a(this, tbPageContext));
                    q();
                    return;
                }
                this.h.setVisibility(8);
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_BOTTOM_BANNER_CLICKED);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.g.a());
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if ("frs".equals(this.k)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o(TbPageContext tbPageContext, String str) {
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

    public final void q() {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            r();
            this.e.setAutoChangeStyle(true);
            this.e.setScaleType(ImageView.ScaleType.FIT_XY);
            this.e.setPlaceHolder(2);
            this.e.setUseNightOrDarkMask(false);
            this.e.setConrers(15);
            if (p()) {
                this.e.setRadiusById(R.string.J_X06);
            } else {
                this.e.setRadiusById(R.string.J_X05);
            }
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
            int equipmentWidth2 = (BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X005) * 2)) - UtilHelper.getDimenPixelSize(R.dimen.tbds182);
            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
            if (p()) {
                f = equipmentWidth / 5;
            } else {
                f = (equipmentWidth2 * 64) / 322;
            }
            layoutParams.width = -1;
            layoutParams.height = (int) f;
            this.e.setLayoutParams(layoutParams);
            this.f.setLayoutParams(layoutParams);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.j)) {
                this.e.startLoad(this.i, 10, false);
                s(skinType);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (p()) {
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

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (i == 0) {
                this.f.setVisibility(8);
                return;
            }
            this.f.setVisibility(0);
            EMManager.from(this.f).setBackGroundColor(R.color.CAM_X0503);
            if (p()) {
                EMManager.from(this.f).setCorner(R.string.J_X06);
            } else {
                EMManager.from(this.f).setCorner(R.string.J_X05);
            }
        }
    }
}
