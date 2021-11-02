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
/* loaded from: classes10.dex */
public class b implements DragSortListView.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f60603a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60604b;

    /* renamed from: c  reason: collision with root package name */
    public int f60605c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f60606d;

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
        this.f60605c = -16777216;
        this.f60606d = listView;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            ((ImageView) view).setImageDrawable(null);
            this.f60603a.recycle();
            this.f60603a = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view, Point point, Point point2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, point, point2) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public View c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            ListView listView = this.f60606d;
            View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f60606d.getFirstVisiblePosition());
            if (childAt == null) {
                return null;
            }
            childAt.setPressed(false);
            childAt.setDrawingCacheEnabled(true);
            this.f60603a = Bitmap.createBitmap(childAt.getDrawingCache());
            childAt.setDrawingCacheEnabled(false);
            if (this.f60604b == null) {
                this.f60604b = new ImageView(this.f60606d.getContext());
            }
            this.f60604b.setBackgroundColor(this.f60605c);
            this.f60604b.setPadding(0, 0, 0, 0);
            this.f60604b.setImageBitmap(this.f60603a);
            this.f60604b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
            return this.f60604b;
        }
        return (View) invokeI.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f60605c = i2;
        }
    }
}
