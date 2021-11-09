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
    public Bitmap f60602a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60603b;

    /* renamed from: c  reason: collision with root package name */
    public int f60604c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f60605d;

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
        this.f60604c = -16777216;
        this.f60605d = listView;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            ((ImageView) view).setImageDrawable(null);
            this.f60602a.recycle();
            this.f60602a = null;
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
            ListView listView = this.f60605d;
            View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f60605d.getFirstVisiblePosition());
            if (childAt == null) {
                return null;
            }
            childAt.setPressed(false);
            childAt.setDrawingCacheEnabled(true);
            this.f60602a = Bitmap.createBitmap(childAt.getDrawingCache());
            childAt.setDrawingCacheEnabled(false);
            if (this.f60603b == null) {
                this.f60603b = new ImageView(this.f60605d.getContext());
            }
            this.f60603b.setBackgroundColor(this.f60604c);
            this.f60603b.setPadding(0, 0, 0, 0);
            this.f60603b.setImageBitmap(this.f60602a);
            this.f60603b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
            return this.f60603b;
        }
        return (View) invokeI.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f60604c = i2;
        }
    }
}
