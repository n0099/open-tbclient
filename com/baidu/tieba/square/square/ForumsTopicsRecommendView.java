package com.baidu.tieba.square.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.xi5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes8.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements xi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public ArrayList<TbImageView> f;
    public int g;
    public float h;
    public int i;
    public View j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForumsTopicsRecommendView(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
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
        this.f = new ArrayList<>(4);
        this.g = 0;
        this.h = 0.62222224f;
        this.i = 0;
        this.j = null;
        this.a = context;
        this.d = BdUtilHelper.getEquipmentWidth(context);
        this.b = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
        this.c = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b2);
        this.e = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070399);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0330, (ViewGroup) this, true);
        this.f.add((TbImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090c6f));
        this.f.add((TbImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090c70));
        this.f.add((TbImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090c71));
        this.f.add((TbImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090c72));
        int i3 = this.d;
        int i4 = this.b;
        this.g = ((i3 - (i4 * 2)) - this.c) / 2;
        setPadding(i4, 0, i4, 0);
    }

    @Override // com.baidu.tieba.xi5
    public void a(BdImage bdImage, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, bdImage, str, z) == null) {
            b(str);
        }
    }

    public final void b(String str) {
        View view2;
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (view2 = this.j) != null && (headImageView = (HeadImageView) view2.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    int i6 = i5 % 2;
                    if (i6 == 0) {
                        paddingLeft = getPaddingLeft();
                    }
                    childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                    paddingLeft += childAt.getMeasuredWidth() + this.c;
                    if (i6 != 0) {
                        paddingTop += childAt.getMeasuredHeight() + this.c;
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            int i3 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int childCount = getChildCount();
            int i4 = i3 - (this.b * 2);
            int i5 = (int) ((((i4 - this.c) / 2.0f) * this.h) + 0.5f);
            for (int i6 = 0; i6 < childCount; i6++) {
                getChildAt(i6).measure(((i4 - this.c) / 2) + 1073741824, 1073741824 + i5);
            }
            int i7 = this.i / 2;
            setMeasuredDimension(i3, (i5 * i7) + ((i7 - 1) * this.c) + this.e);
        }
    }
}
