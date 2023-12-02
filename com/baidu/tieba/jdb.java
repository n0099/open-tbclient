package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jdb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdPageContext a;
    public final ri b;
    public Runnable c;
    public boolean d;

    public jdb(BdPageContext bdPageContext, ri riVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, riVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bdPageContext;
        this.b = riVar;
    }

    @NonNull
    public final Rect a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public final boolean b(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect)) == null) {
            float equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            int i = (int) (0.0f * equipmentHeight);
            int i2 = (int) (equipmentHeight * 0.66f);
            if (rect.top >= i && rect.bottom <= i2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (view2.getTag(R.id.virtual_image_user_head) instanceof idb)) {
            ((idb) view2.getTag(R.id.virtual_image_user_head)).a();
            view2.setTag(R.id.virtual_image_user_head, null);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.d = z;
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.d) {
            return;
        }
        if (this.c == null) {
            this.c = new Runnable() { // from class: com.baidu.tieba.hdb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        jdb.this.e();
                    }
                }
            };
        }
        SafeHandler.getInst().postDelayed(this.c, i);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.c != null) {
            SafeHandler.getInst().removeCallbacks(this.c);
        }
    }

    public final void e() {
        ri riVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a != null && (riVar = this.b) != null && riVar.getListView().getChildCount() != 0 && this.b.getContentViewsCount() != 0) {
            Context context = this.b.getListView().getContext();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    int childCount = this.b.getListView().getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = this.b.getListView().getChildAt(i);
                        if (childAt != null && (childAt.getTag(R.id.virtual_image_user_head) instanceof idb)) {
                            idb idbVar = (idb) childAt.getTag(R.id.virtual_image_user_head);
                            if (b(a(childAt))) {
                                idbVar.play();
                            }
                        }
                    }
                }
            }
        }
    }
}
