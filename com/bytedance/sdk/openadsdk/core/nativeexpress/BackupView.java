package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.theme.ThemeStatusBroadcastReceiver;
/* loaded from: classes9.dex */
public abstract class BackupView extends FrameLayout implements com.bytedance.sdk.openadsdk.theme.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f66777a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f66778b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f66779c;

    /* renamed from: d  reason: collision with root package name */
    public TTDislikeDialogAbstract f66780d;

    /* renamed from: e  reason: collision with root package name */
    public String f66781e;

    /* renamed from: f  reason: collision with root package name */
    public int f66782f;

    /* renamed from: g  reason: collision with root package name */
    public int f66783g;

    /* renamed from: h  reason: collision with root package name */
    public int f66784h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66785i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f66786j;
    public String k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66781e = "embeded_ad";
        this.f66785i = true;
        this.f66786j = true;
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setTag("tt_express_backup_fl_tag_26");
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.f66778b;
            return mVar != null && com.bytedance.sdk.openadsdk.core.e.m.b(mVar);
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f66780d;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.show();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = this.f66779c;
            if (aVar != null) {
                aVar.showDislikeDialog();
            } else {
                TTDelegateActivity.a(getContext(), this.f66778b);
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
        }
    }

    public abstract void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar);

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (TextUtils.isEmpty(this.f66778b.ah())) {
                return !TextUtils.isEmpty(this.f66778b.ai()) ? this.f66778b.ai() : "";
            }
            return this.f66778b.ah();
        }
        return (String) invokeV.objValue;
    }

    public String getNameOrSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.f66778b;
            if (mVar == null) {
                return "";
            }
            if (mVar.al() == null || TextUtils.isEmpty(this.f66778b.al().c())) {
                return !TextUtils.isEmpty(this.f66778b.W()) ? this.f66778b.W() : "";
            }
            return this.f66778b.al().c();
        }
        return (String) invokeV.objValue;
    }

    public float getRealHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? com.bytedance.sdk.openadsdk.q.s.c(this.f66777a, this.f66783g) : invokeV.floatValue;
    }

    public float getRealWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? com.bytedance.sdk.openadsdk.q.s.c(this.f66777a, this.f66782f) : invokeV.floatValue;
    }

    @Override // android.view.View
    public Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "tt_express_backup_fl_tag_26" : invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f66778b.al() != null && !TextUtils.isEmpty(this.f66778b.al().c())) {
                return this.f66778b.al().c();
            }
            if (TextUtils.isEmpty(this.f66778b.W())) {
                return !TextUtils.isEmpty(this.f66778b.ah()) ? this.f66778b.ah() : "";
            }
            return this.f66778b.W();
        }
        return (String) invokeV.objValue;
    }

    public View getVideoView() {
        InterceptResult invokeV;
        NativeVideoTsView a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f66778b != null && this.f66777a != null) {
                if (c()) {
                    try {
                        a2 = a(this.f66777a, this.f66778b, this.f66781e, true, false);
                        a2.setVideoCacheUrl(this.k);
                        a2.setControllerStatusCallBack(new NativeVideoTsView.a(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ BackupView f66788a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f66788a = this;
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                            public void a(boolean z, long j2, long j3, long j4, boolean z2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z2)}) == null) {
                                }
                            }
                        });
                        a2.setIsAutoPlay(this.f66785i);
                        a2.setIsQuiet(this.f66786j);
                    } catch (Throwable unused) {
                    }
                    if (!c() && a2 != null && a2.a(0L, true, false)) {
                        return a2;
                    }
                }
                a2 = null;
                if (!c()) {
                }
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void setDislikeInner(TTAdDislike tTAdDislike) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, tTAdDislike) == null) && (tTAdDislike instanceof com.bytedance.sdk.openadsdk.dislike.ui.a)) {
            this.f66779c = (com.bytedance.sdk.openadsdk.dislike.ui.a) tTAdDislike;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.sdk.openadsdk.core.e.m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tTDislikeDialogAbstract) == null) {
            if (tTDislikeDialogAbstract != null && (mVar = this.f66778b) != null) {
                tTDislikeDialogAbstract.setDislikeModel(mVar.aG());
            }
            this.f66780d = tTDislikeDialogAbstract;
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, obj) == null) {
            super.setTag("tt_express_backup_fl_tag_26");
        }
    }

    public void setThemeChangeReceiver(ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, themeStatusBroadcastReceiver) == null) || themeStatusBroadcastReceiver == null) {
            return;
        }
        themeStatusBroadcastReceiver.a(this);
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f66786j = com.bytedance.sdk.openadsdk.core.o.h().b(this.f66784h);
            int d2 = com.bytedance.sdk.openadsdk.core.o.h().d(i2);
            if (3 == d2) {
                this.f66785i = false;
            } else if (1 == d2 && com.bytedance.sdk.component.utils.n.d(this.f66777a)) {
                this.f66785i = true;
            } else if (2 == d2) {
                if (com.bytedance.sdk.component.utils.n.e(this.f66777a) || com.bytedance.sdk.component.utils.n.d(this.f66777a) || com.bytedance.sdk.component.utils.n.f(this.f66777a)) {
                    this.f66785i = true;
                }
            } else if (5 == d2) {
                if (com.bytedance.sdk.component.utils.n.d(this.f66777a) || com.bytedance.sdk.component.utils.n.f(this.f66777a)) {
                    this.f66785i = true;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupView(@NonNull Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66781e = "embeded_ad";
        this.f66785i = true;
        this.f66786j = true;
        this.k = str;
        setTag("tt_express_backup_fl_tag_26");
    }

    public void a(View view, boolean z) {
        com.bytedance.sdk.openadsdk.core.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, view, z) == null) || view == null) {
            return;
        }
        if (z) {
            Context context = this.f66777a;
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.f66778b;
            String str = this.f66781e;
            bVar = new com.bytedance.sdk.openadsdk.core.b.a(context, mVar, str, com.bytedance.sdk.openadsdk.q.q.a(str));
        } else {
            Context context2 = this.f66777a;
            com.bytedance.sdk.openadsdk.core.e.m mVar2 = this.f66778b;
            String str2 = this.f66781e;
            bVar = new com.bytedance.sdk.openadsdk.core.b.b(context2, mVar2, str2, com.bytedance.sdk.openadsdk.q.q.a(str2));
        }
        view.setOnTouchListener(bVar);
        view.setOnClickListener(bVar);
        bVar.a(new a(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BackupView f66787a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66787a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a
            public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, kVar) == null) {
                    this.f66787a.a(i2, kVar);
                }
            }
        });
    }

    public NativeVideoTsView a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new NativeVideoTsView(context, mVar, str, z, z2) : (NativeVideoTsView) invokeCommon.objValue;
    }

    public void a(View view) {
        com.bytedance.sdk.openadsdk.core.e.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (mVar = this.f66778b) == null || mVar.V() == null || view == null) {
            return;
        }
        if (this.f66778b.h() == 1 && this.f66785i) {
            a(view, true);
        } else {
            a(view, false);
        }
    }
}
