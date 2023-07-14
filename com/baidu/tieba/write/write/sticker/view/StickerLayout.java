package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.qx5;
import com.baidu.tieba.wya;
import com.baidu.tieba.yya;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class StickerLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<StickerView> b;
    public FrameLayout.LayoutParams c;
    public int d;

    /* loaded from: classes8.dex */
    public class a implements wya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StickerView a;
        public final /* synthetic */ yya b;
        public final /* synthetic */ StickerLayout c;

        @Override // com.baidu.tieba.wya
        public void a(StickerView stickerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, stickerView) == null) {
            }
        }

        @Override // com.baidu.tieba.wya
        public void c(StickerView stickerView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, stickerView) == null) {
            }
        }

        public a(StickerLayout stickerLayout, StickerView stickerView, yya yyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {stickerLayout, stickerView, yyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = stickerLayout;
            this.a = stickerView;
            this.b = yyaVar;
        }

        @Override // com.baidu.tieba.wya
        public void b(StickerView stickerView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stickerView, z) == null) {
                stickerView.setEdit(z);
                if (z) {
                    stickerView.bringToFront();
                }
            }
        }

        @Override // com.baidu.tieba.wya
        public void onDelete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c.removeView(this.a);
                this.c.b.remove(this.a);
                this.c.e();
                yya yyaVar = this.b;
                if (yyaVar != null) {
                    yyaVar.a();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void f(yya yyaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yyaVar) == null) {
            Iterator<StickerView> it = this.b.iterator();
            while (it.hasNext()) {
                StickerView next = it.next();
                if (next != null) {
                    removeView(next);
                    it.remove();
                    e();
                    if (yyaVar != null) {
                        yyaVar.a();
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerLayout(Context context, AttributeSet attributeSet, int i) {
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
        d(context);
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.a = context;
            this.b = new ArrayList();
            this.c = new FrameLayout.LayoutParams(-1, -1);
        }
    }

    public void setRemoveRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.d = i;
        }
    }

    public StickerView b(Bitmap bitmap, yya yyaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, yyaVar)) == null) {
            StickerView stickerView = new StickerView(this.a);
            stickerView.setImageBitmap(bitmap);
            stickerView.setLayoutParams(this.c);
            stickerView.setmOnStickerActionListener(new a(this, stickerView, yyaVar));
            addView(stickerView);
            this.b.add(stickerView);
            e();
            if (yyaVar != null) {
                yyaVar.d();
            }
            return stickerView;
        }
        return (StickerView) invokeLL.objValue;
    }

    public Bitmap c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ListUtils.isEmpty(this.b)) {
                return null;
            }
            e();
            return qx5.c(this);
        }
        return (Bitmap) invokeV.objValue;
    }

    public List<StickerView> getStickerViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.b.size() <= 0) {
            return;
        }
        for (StickerView stickerView : this.b) {
            if (stickerView != null) {
                stickerView.setRemoveRes(this.d);
                stickerView.setEdit(false);
            }
        }
    }
}
