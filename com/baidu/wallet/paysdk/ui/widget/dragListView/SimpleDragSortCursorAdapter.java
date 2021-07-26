package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SimpleDragSortCursorAdapter extends ResourceDragSortCursorAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String[] f27184a;

    /* renamed from: b  reason: collision with root package name */
    public int f27185b;

    /* renamed from: c  reason: collision with root package name */
    public a f27186c;

    /* renamed from: d  reason: collision with root package name */
    public b f27187d;
    public int[] mFrom;
    public int[] mTo;

    /* loaded from: classes5.dex */
    public interface a {
        CharSequence a(Cursor cursor);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean a(View view, Cursor cursor, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SimpleDragSortCursorAdapter(Context context, int i2, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i2, cursor);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), cursor, strArr, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (Cursor) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27185b = -1;
        this.mTo = iArr;
        this.f27184a = strArr;
        a(cursor, strArr);
    }

    private void a(Cursor cursor, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, cursor, strArr) == null) {
            if (cursor != null) {
                int length = strArr.length;
                int[] iArr = this.mFrom;
                if (iArr == null || iArr.length != length) {
                    this.mFrom = new int[length];
                }
                for (int i2 = 0; i2 < length; i2++) {
                    this.mFrom[i2] = cursor.getColumnIndexOrThrow(strArr[i2]);
                }
                return;
            }
            this.mFrom = null;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, view, context, cursor) == null) {
            b bVar = this.f27187d;
            int[] iArr = this.mTo;
            int length = iArr.length;
            int[] iArr2 = this.mFrom;
            for (int i2 = 0; i2 < length; i2++) {
                View findViewById = view.findViewById(iArr[i2]);
                if (findViewById != null) {
                    if (bVar != null ? bVar.a(findViewById, cursor, iArr2[i2]) : false) {
                        continue;
                    } else {
                        String string = cursor.getString(iArr2[i2]);
                        if (string == null) {
                            string = "";
                        }
                        if (findViewById instanceof TextView) {
                            setViewText((TextView) findViewById, string);
                        } else if (findViewById instanceof ImageView) {
                            setViewImage((ImageView) findViewById, string);
                        } else {
                            throw new IllegalStateException(findViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                        }
                    }
                }
            }
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor, strArr, iArr) == null) {
            this.f27184a = strArr;
            this.mTo = iArr;
            a(cursor, strArr);
            super.changeCursor(cursor);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            a aVar = this.f27186c;
            if (aVar != null) {
                return aVar.a(cursor);
            }
            int i2 = this.f27185b;
            if (i2 > -1) {
                return cursor.getString(i2);
            }
            return super.convertToString(cursor);
        }
        return (CharSequence) invokeL.objValue;
    }

    public a getCursorToStringConverter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27186c : (a) invokeV.objValue;
    }

    public int getStringConversionColumn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27185b : invokeV.intValue;
    }

    public b getViewBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27187d : (b) invokeV.objValue;
    }

    public void setCursorToStringConverter(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f27186c = aVar;
        }
    }

    public void setStringConversionColumn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f27185b = i2;
        }
    }

    public void setViewBinder(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f27187d = bVar;
        }
    }

    public void setViewImage(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, imageView, str) == null) {
            try {
                imageView.setImageResource(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                imageView.setImageURI(Uri.parse(str));
            }
        }
    }

    public void setViewText(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, textView, str) == null) {
            textView.setText(str);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cursor)) == null) {
            a(cursor, this.f27184a);
            return super.swapCursor(cursor);
        }
        return (Cursor) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDragSortCursorAdapter(Context context, int i2, Cursor cursor, String[] strArr, int[] iArr, int i3) {
        super(context, i2, cursor, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), cursor, strArr, iArr, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (Cursor) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27185b = -1;
        this.mTo = iArr;
        this.f27184a = strArr;
        a(cursor, strArr);
    }
}
