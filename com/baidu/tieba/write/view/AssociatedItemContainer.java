package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0003!\"#B\u0013\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u001d\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0019\u0010\u001dB%\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u0019\u0010 J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/baidu/tieba/write/view/AssociatedItemContainer;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tbadk/core/data/ItemData;", "itemData", "", "addAssociatedItem", "(Lcom/baidu/tbadk/core/data/ItemData;)V", "onChangeSkin", "()V", "Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnAddedListener;", "onAddedListener", "Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnAddedListener;", "getOnAddedListener", "()Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnAddedListener;", "setOnAddedListener", "(Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnAddedListener;)V", "Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnDeletedListener;", "onDeletedListener", "Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnDeletedListener;", "getOnDeletedListener", "()Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnDeletedListener;", "setOnDeletedListener", "(Lcom/baidu/tieba/write/view/AssociatedItemContainer$OnDeletedListener;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "OnAddedListener", "OnDeletedListener", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class AssociatedItemContainer extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int REMOVED_ONE_CHILD = 1;
    public static final int REMOVED_TWO_CHILD = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f55891e;

    /* renamed from: f  reason: collision with root package name */
    public b f55892f;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(ItemData itemData);
    }

    /* loaded from: classes9.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AssociatedItemContainer f55893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ItemCardView f55894f;

        public d(AssociatedItemContainer associatedItemContainer, ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {associatedItemContainer, itemCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55893e = associatedItemContainer;
            this.f55894f = itemCardView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ViewParent parent;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (parent = this.f55894f.getParent()) == null) {
                return;
            }
            if (parent != null) {
                int indexOfChild = ((ViewGroup) parent).indexOfChild(this.f55894f);
                AssociatedItemContainer associatedItemContainer = this.f55893e;
                associatedItemContainer.removeViewsInLayout(indexOfChild, associatedItemContainer.getChildCount() == indexOfChild + 1 ? 1 : 2);
                if (this.f55893e.getChildCount() > 0) {
                    AssociatedItemContainer associatedItemContainer2 = this.f55893e;
                    if (!(associatedItemContainer2.getChildAt(associatedItemContainer2.getChildCount() - 1) instanceof ItemCardView)) {
                        AssociatedItemContainer associatedItemContainer3 = this.f55893e;
                        associatedItemContainer3.removeViewAt(associatedItemContainer3.getChildCount() - 1);
                    }
                }
                this.f55893e.requestLayout();
                c onDeletedListener = this.f55893e.getOnDeletedListener();
                if (onDeletedListener != null) {
                    Object tag = this.f55894f.getTag(R.id.key_item_data);
                    if (tag == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.core.data.ItemData");
                    }
                    onDeletedListener.a((ItemData) tag);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1574308993, "Lcom/baidu/tieba/write/view/AssociatedItemContainer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1574308993, "Lcom/baidu/tieba/write/view/AssociatedItemContainer;");
                return;
            }
        }
        Companion = new a(null);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void addAssociatedItem(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, itemData) == null) {
            boolean z = getChildCount() == 0;
            if (getChildCount() != 0) {
                View view = new View(getContext());
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.M_H_X004)));
                addView(view);
            }
            ItemCardView itemCardView = new ItemCardView(getContext());
            itemCardView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            itemCardView.showCloseButton();
            itemCardView.setTag(R.id.key_item_data, itemData);
            itemCardView.setOnCloseListener(new d(this, itemCardView));
            itemCardView.setData(itemData, 10, "", false);
            addView(itemCardView);
            b bVar = this.f55892f;
            if (bVar != null) {
                bVar.a(z);
            }
        }
    }

    public final b getOnAddedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55892f : (b) invokeV.objValue;
    }

    public final c getOnDeletedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55891e : (c) invokeV.objValue;
    }

    public final void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (View view : ViewGroupKt.getChildren(this)) {
                if (view instanceof ItemCardView) {
                    ((ItemCardView) view).onChangeSkinType();
                }
            }
        }
    }

    public final void setOnAddedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f55892f = bVar;
        }
    }

    public final void setOnDeletedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f55891e = cVar;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssociatedItemContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
