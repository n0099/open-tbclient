package com.baidu.tieba;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forum.widget.TbLinkageScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class rm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final View b;
    public TbLinkageScrollView c;
    public float d;
    public float e;
    public int f;
    public final ArrayList<sm7> g;
    public final a h;

    /* loaded from: classes8.dex */
    public static final class a implements pm7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm7 a;

        public a(rm7 rm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm7Var;
        }

        @Override // com.baidu.tieba.pm7
        public Boolean a(MotionEvent e) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e)) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                return this.a.c(e);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    public rm7(View scrollTarget, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {scrollTarget, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(scrollTarget, "scrollTarget");
        this.a = scrollTarget;
        this.b = view2;
        this.g = new ArrayList<>();
        this.h = new a(this);
    }

    public final rm7 b(sm7 listener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listener)) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (!this.g.contains(listener)) {
                this.g.add(listener);
            }
            return this;
        }
        return (rm7) invokeL.objValue;
    }

    public final void d(TbLinkageScrollView linkageScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, linkageScrollView) == null) {
            Intrinsics.checkNotNullParameter(linkageScrollView, "linkageScrollView");
            this.c = linkageScrollView;
            linkageScrollView.H(this.h);
        }
    }

    public final void f(sm7 listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.g.remove(listener);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
        if (r7 == false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        int i;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                boolean z3 = true;
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return null;
                        }
                    } else {
                        int rawX = (int) (this.d - motionEvent.getRawX());
                        int rawY = (int) (this.e - motionEvent.getRawY());
                        this.d = motionEvent.getRawX();
                        this.e = motionEvent.getRawY();
                        if (this.f != 1) {
                            if (this.a.getScrollY() == 0) {
                                View view2 = this.b;
                                if (view2 != null) {
                                    i = view2.getScrollY();
                                } else {
                                    i = 0;
                                }
                                if (i == 0 && Math.abs(rawX) < Math.abs(rawY)) {
                                    if (rawY >= 0) {
                                        if (this.a.getTranslationY() == 0.0f) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                    }
                                    z = true;
                                    if (z) {
                                        this.f = 1;
                                        for (sm7 sm7Var : this.g) {
                                            sm7Var.c();
                                        }
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                            }
                        }
                        if (this.f == 1) {
                            if ((this.a.getTranslationY() > 0.0f || rawY <= 0) ? false : false) {
                                this.a.setTranslationY(0.0f);
                                this.f = 0;
                                return Boolean.TRUE;
                            }
                            View view3 = this.a;
                            view3.setTranslationY(view3.getTranslationY() - rawY);
                            for (sm7 sm7Var2 : this.g) {
                                sm7Var2.a(this.a.getTranslationY());
                            }
                            return Boolean.TRUE;
                        }
                        return null;
                    }
                }
                if (this.f == 1) {
                    for (sm7 sm7Var3 : this.g) {
                        sm7Var3.b(this.a.getTranslationY());
                    }
                    this.a.setTranslationY(0.0f);
                    this.f = 0;
                    return Boolean.TRUE;
                }
                return null;
            }
            this.d = motionEvent.getRawX();
            this.e = motionEvent.getRawY();
            return null;
        }
        return (Boolean) invokeL.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.clear();
            TbLinkageScrollView tbLinkageScrollView = this.c;
            if (tbLinkageScrollView != null) {
                tbLinkageScrollView.K(this.h);
            }
        }
    }
}
