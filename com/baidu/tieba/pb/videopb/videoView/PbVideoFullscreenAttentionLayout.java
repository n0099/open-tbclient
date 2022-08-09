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
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kx7;
import com.repackage.ov4;
import com.repackage.pi;
import com.repackage.qi;
/* loaded from: classes4.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;
    public PbVideoFullscreenLikeBtn b;
    public kx7 c;
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

    public int a(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return 0;
            }
            if (threadData.isMutiForumThread()) {
                return !pi.isEmpty(threadData.getForum_name()) ? 2 : 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            kx7 kx7Var = this.c;
            return (kx7Var == null || kx7Var.j() == null || !this.c.j().getIsLike()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d06d1, this);
            this.a = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f0902d4);
            this.b = (PbVideoFullscreenLikeBtn) findViewById(R.id.obfuscated_res_0x7f0906ae);
            this.a.setIsRound(true);
            this.a.setBorderWidth(qi.f(context, R.dimen.tbds3));
            this.a.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
            this.a.setAutoChangeStyle(false);
            this.b.setConfig(new ov4());
        }
    }

    public void d(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        String str = threadData.tid;
        int a = a(threadData);
        if (this.c == null) {
            if (!(getContext() instanceof AbsPbActivity)) {
                return;
            }
            kx7 kx7Var = new kx7(((AbsPbActivity) getContext()).getPageContext(), this.b, -1);
            this.c = kx7Var;
            kx7Var.m("11");
            this.c.l(this.d);
        }
        this.c.n(threadData.getAuthor());
        this.c.x(str);
        this.c.v(threadData);
        kx7 kx7Var2 = this.c;
        kx7Var2.p = true;
        kx7Var2.w(a);
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        String avater = threadData.getAuthor().getAvater();
        if (avater.startsWith("http")) {
            this.a.K(avater, 10, false);
        } else {
            this.a.K(avater, 25, false);
        }
        this.a.setBjhAuthIconRes(0);
        this.a.setIsBigV(threadData.getAuthor().isBigV());
        this.a.setShowV(threadData.getAuthor().isBigV());
        d(threadData);
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
}
