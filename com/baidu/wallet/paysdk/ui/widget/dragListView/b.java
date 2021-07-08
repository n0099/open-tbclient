package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView;
/* loaded from: classes5.dex */
public class b implements DragSortListView.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f27040a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f27041b;

    /* renamed from: c  reason: collision with root package name */
    public int f27042c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f27043d;

    public b(ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27042c = -16777216;
        this.f27043d = listView;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            ((ImageView) view).setImageDrawable(null);
            this.f27040a.recycle();
            this.f27040a = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view, Point point, Point point2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, point, point2) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public View d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            ListView listView = this.f27043d;
            View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f27043d.getFirstVisiblePosition());
            if (childAt == null) {
                return null;
            }
            childAt.setPressed(false);
            childAt.setDrawingCacheEnabled(true);
            this.f27040a = Bitmap.createBitmap(childAt.getDrawingCache());
            childAt.setDrawingCacheEnabled(false);
            if (this.f27041b == null) {
                this.f27041b = new ImageView(this.f27043d.getContext());
            }
            this.f27041b.setBackgroundColor(this.f27042c);
            this.f27041b.setPadding(0, 0, 0, 0);
            this.f27041b.setImageBitmap(this.f27040a);
            this.f27041b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
            return this.f27041b;
        }
        return (View) invokeI.objValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f27042c = i2;
        }
    }
}
