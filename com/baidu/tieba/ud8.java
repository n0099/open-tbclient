package com.baidu.tieba;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ud8 extends h9<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public ImageView c;
    public HorizontalScrollView d;
    public LinearLayout e;
    public int f;
    public gf g;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ud8 a;

        public a(ud8 ud8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ud8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ud8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null) {
                this.a.g.y(view2, 18, this.a.f, 0L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GifView a;
        public final /* synthetic */ bf8 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ud8 d;

        public b(ud8 ud8Var, GifView gifView, bf8 bf8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ud8Var, gifView, bf8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ud8Var;
            this.a = gifView;
            this.b = bf8Var;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getBdImage() != null && this.a.getBdImage().isValidNow()) {
                this.b.c = this.a.getBdImage().getWidth();
                this.b.d = this.a.getBdImage().getHeight();
                if (this.d.g != null) {
                    new StatisticItem("c14658").addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
                    this.d.g.y(view2, 19, this.d.f, this.c);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ud8(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgicebreak_view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BdPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            this.b = (TextView) t(R.id.msg_ice_break_title);
            this.c = (ImageView) t(R.id.msg_ice_break_close);
            this.d = (HorizontalScrollView) t(R.id.msg_ice_break_scroll_view);
            this.e = (LinearLayout) t(R.id.msg_ice_break_gif_ll);
            this.b.setText(R.string.im_ice_break_guide_title);
            this.c.setOnClickListener(new a(this));
        }
    }

    public void E(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) && this.e != null && chatMessage != null && chatMessage.getIceBreakEmotions() != null) {
            this.e.removeAllViews();
            int dimens = BdUtilHelper.getDimens(this.e.getContext(), R.dimen.tbds260);
            int dimens2 = BdUtilHelper.getDimens(this.e.getContext(), R.dimen.M_W_X004);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
            layoutParams.setMargins(0, 0, dimens2, 0);
            for (int i = 0; i < chatMessage.getIceBreakEmotions().size(); i++) {
                this.e.addView(z(chatMessage.getIceBreakEmotions().get(i), i), layoutParams);
            }
            new StatisticItem("c14661").addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
        }
    }

    public void D(gf gfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gfVar) == null) {
            this.g = gfVar;
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            HorizontalScrollView horizontalScrollView = this.d;
            if (horizontalScrollView != null) {
                EMManager.from(horizontalScrollView).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0201);
            }
            TextView textView = this.b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_im_pobing_close18, R.color.CAM_X0111, null);
            }
        }
    }

    public final GifView z(bf8 bf8Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bf8Var, i)) == null) {
            GifView gifView = new GifView(this.e.getContext());
            gifView.setDrawerType(1);
            gifView.setConrers(15);
            gifView.setRadiusById(R.string.J_X05);
            gifView.setShowStaticDrawable(false);
            gifView.setPlaceHolder(2);
            gifView.p(bf8Var.b, 38);
            gifView.setOnClickListener(new b(this, gifView, bf8Var, i));
            return gifView;
        }
        return (GifView) invokeLI.objValue;
    }
}
