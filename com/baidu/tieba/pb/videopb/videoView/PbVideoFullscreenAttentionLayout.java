package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gi;
import com.baidu.tieba.hi;
import com.baidu.tieba.j45;
import com.baidu.tieba.lm8;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;
    public PbVideoFullscreenLikeBtn b;
    public lm8 c;
    public BdUniqueId d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoFullscreenAttentionLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoFullscreenAttentionLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoFullscreenAttentionLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        c(context);
    }

    public int a(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return 0;
            }
            if (threadData.isMutiForumThread()) {
                if (gi.isEmpty(threadData.getForum_name())) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.b.setOnclickEvent(onClickListener);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.d = bdUniqueId;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            lm8 lm8Var = this.c;
            if (lm8Var != null && lm8Var.j() != null && this.c.j().getIsLike()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0744, this);
            this.a = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f0902ea);
            this.b = (PbVideoFullscreenLikeBtn) findViewById(R.id.obfuscated_res_0x7f09075f);
            this.a.setIsRound(true);
            this.a.setBorderWidth(hi.g(context, R.dimen.tbds3));
            this.a.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
            this.a.setAutoChangeStyle(false);
            this.b.setConfig(new j45());
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) && threadData != null && threadData.getAuthor() != null) {
            String avater = threadData.getAuthor().getAvater();
            if (avater != null && avater.startsWith("http")) {
                this.a.M(avater, 10, false);
            } else {
                this.a.M(avater, 25, false);
            }
            this.a.setBjhAuthIconRes(0);
            this.a.setIsBigV(threadData.getAuthor().isBigV());
            this.a.setShowV(threadData.getAuthor().isBigV());
            d(threadData);
        }
    }

    public void d(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) && threadData != null && threadData.getAuthor() != null) {
            String str = threadData.tid;
            int a = a(threadData);
            if (this.c == null) {
                if (getContext() instanceof AbsPbActivity) {
                    lm8 lm8Var = new lm8(((AbsPbActivity) getContext()).getPageContext(), this.b, -1);
                    this.c = lm8Var;
                    lm8Var.m("11");
                    this.c.l(this.d);
                } else {
                    return;
                }
            }
            this.c.n(threadData.getAuthor());
            this.c.z(str);
            this.c.x(threadData);
            lm8 lm8Var2 = this.c;
            lm8Var2.p = true;
            lm8Var2.y(a);
        }
    }
}
