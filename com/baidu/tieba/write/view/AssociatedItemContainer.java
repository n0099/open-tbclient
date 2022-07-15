package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewGroupKt;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.view.AssociatedItemContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/write/view/AssociatedItemContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onAddedListener", "Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnAddedListener;", "getOnAddedListener", "()Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnAddedListener;", "setOnAddedListener", "(Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnAddedListener;)V", "onDeletedListener", "Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnDeletedListener;", "getOnDeletedListener", "()Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnDeletedListener;", "setOnDeletedListener", "(Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnDeletedListener;)V", "addAssociatedItem", "", "itemData", "Lcom/baidu/tbadk/core/data/ItemData;", "onChangeSkin", "Companion", "OnAddedListener", "OnDeletedListener", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class AssociatedItemContainer extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public a b;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(ItemData itemData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1574308993, "Lcom/baidu/tieba/write/view/AssociatedItemContainer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1574308993, "Lcom/baidu/tieba/write/view/AssociatedItemContainer;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AssociatedItemContainer(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static final void b(ItemCardView itemCardView, AssociatedItemContainer this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, itemCardView, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(itemCardView, "$itemCardView");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ViewParent parent = itemCardView.getParent();
            if (parent == null) {
                return;
            }
            int indexOfChild = ((ViewGroup) parent).indexOfChild(itemCardView);
            this$0.removeViewsInLayout(indexOfChild, this$0.getChildCount() == indexOfChild + 1 ? 1 : 2);
            if (this$0.getChildCount() > 0 && !(this$0.getChildAt(this$0.getChildCount() - 1) instanceof ItemCardView)) {
                this$0.removeViewAt(this$0.getChildCount() - 1);
            }
            this$0.requestLayout();
            b onDeletedListener = this$0.getOnDeletedListener();
            if (onDeletedListener == null) {
                return;
            }
            Object tag = itemCardView.getTag(R.id.obfuscated_res_0x7f090fcf);
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.data.ItemData");
            }
            onDeletedListener.a((ItemData) tag);
        }
    }

    public final void a(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            boolean z = getChildCount() == 0;
            if (getChildCount() != 0) {
                View view2 = new View(getContext());
                view2.setLayoutParams(new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004)));
                addView(view2);
            }
            final ItemCardView itemCardView = new ItemCardView(getContext());
            itemCardView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            itemCardView.N();
            itemCardView.setTag(R.id.obfuscated_res_0x7f090fcf, itemData);
            itemCardView.setOnCloseListener(new View.OnClickListener() { // from class: com.repackage.zx8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        AssociatedItemContainer.b(ItemCardView.this, this, view3);
                    }
                }
            });
            itemCardView.setData(itemData, 10, "", false);
            addView(itemCardView);
            a aVar = this.b;
            if (aVar == null) {
                return;
            }
            aVar.a(z);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (View view2 : ViewGroupKt.getChildren(this)) {
                if (view2 instanceof ItemCardView) {
                    ((ItemCardView) view2).G();
                }
            }
        }
    }

    public final a getOnAddedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (a) invokeV.objValue;
    }

    public final b getOnDeletedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (b) invokeV.objValue;
    }

    public final void setOnAddedListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.b = aVar;
        }
    }

    public final void setOnDeletedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.a = bVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AssociatedItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssociatedItemContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
    }
}
