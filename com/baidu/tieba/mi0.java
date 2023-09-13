package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class mi0 extends vl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public th0 g;

    /* loaded from: classes7.dex */
    public static final class a extends jn0<th0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mi0 mi0Var, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi0Var, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mi0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jn0
        public void onEvent(th0 it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (this.b.e != null && !(!Intrinsics.areEqual(it.a, "2"))) {
                    this.b.g = it;
                    if (it.h) {
                        bm0 bm0Var = (bm0) this.b.e.get();
                        if (bm0Var != null) {
                            Context b = tj0.b();
                            Intrinsics.checkNotNullExpressionValue(b, "AdRuntime.applicationContext()");
                            bm0Var.update(b.getResources().getString(R.string.nad_download_open), this.b.a);
                            return;
                        }
                        return;
                    }
                    this.b.t();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mi0(il0 data, bm0<?> view2) {
        super(data, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {data, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((il0) objArr2[0], (bm0) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    @Override // com.baidu.tieba.vl0
    public void t() {
        String str;
        boolean z;
        String str2;
        boolean z2;
        String str3;
        boolean z3;
        String str4;
        boolean z4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            th0 th0Var = this.g;
            if (th0Var == null) {
                super.t();
            } else if (this.e == null) {
            } else {
                String str12 = null;
                if (th0Var != null) {
                    str = th0Var.c;
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    th0 th0Var2 = this.g;
                    if (th0Var2 != null) {
                        str2 = th0Var2.b;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        Context b = tj0.b();
                        Intrinsics.checkNotNullExpressionValue(b, "AdRuntime.applicationContext()");
                        Resources resources = b.getResources();
                        String string = resources.getString(R.string.nad_download_start);
                        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.nad_download_start)");
                        AdDownloadStatus adDownloadStatus = this.a.c;
                        if (adDownloadStatus != null) {
                            switch (li0.$EnumSwitchMapping$0[adDownloadStatus.ordinal()]) {
                                case 1:
                                    Object[] objArr = new Object[2];
                                    th0 th0Var3 = this.g;
                                    if (th0Var3 != null) {
                                        str6 = th0Var3.b;
                                    } else {
                                        str6 = null;
                                    }
                                    objArr[0] = str6;
                                    th0 th0Var4 = this.g;
                                    if (th0Var4 != null) {
                                        str7 = th0Var4.c;
                                    } else {
                                        str7 = null;
                                    }
                                    objArr[1] = str7;
                                    string = resources.getString(R.string.nad_reward_download_task_init, objArr);
                                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…t?.duration, event?.coin)");
                                    break;
                                case 2:
                                    string = new DecimalFormat("#.#%").format(this.a.i);
                                    Intrinsics.checkNotNullExpressionValue(string, "format.format(mData.progress.toDouble())");
                                    break;
                                case 3:
                                    string = resources.getString(R.string.nad_download_continue);
                                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ng.nad_download_continue)");
                                    break;
                                case 4:
                                    Object[] objArr2 = new Object[2];
                                    th0 th0Var5 = this.g;
                                    if (th0Var5 != null) {
                                        str8 = th0Var5.b;
                                    } else {
                                        str8 = null;
                                    }
                                    objArr2[0] = str8;
                                    th0 th0Var6 = this.g;
                                    if (th0Var6 != null) {
                                        str9 = th0Var6.c;
                                    } else {
                                        str9 = null;
                                    }
                                    objArr2[1] = str9;
                                    string = resources.getString(R.string.nad_reward_download_task_install, objArr2);
                                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…t?.duration, event?.coin)");
                                    break;
                                case 5:
                                    Object[] objArr3 = new Object[2];
                                    th0 th0Var7 = this.g;
                                    if (th0Var7 != null) {
                                        str10 = th0Var7.b;
                                    } else {
                                        str10 = null;
                                    }
                                    objArr3[0] = str10;
                                    th0 th0Var8 = this.g;
                                    if (th0Var8 != null) {
                                        str11 = th0Var8.c;
                                    } else {
                                        str11 = null;
                                    }
                                    objArr3[1] = str11;
                                    string = resources.getString(R.string.nad_reward_download_task_open, objArr3);
                                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…t?.duration, event?.coin)");
                                    break;
                                case 6:
                                    string = resources.getString(R.string.nad_download_failed_retry);
                                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ad_download_failed_retry)");
                                    break;
                            }
                        }
                        th0 th0Var9 = this.g;
                        if (th0Var9 != null) {
                            str3 = th0Var9.d;
                        } else {
                            str3 = null;
                        }
                        if (str3 != null && str3.length() != 0) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3) {
                            th0 th0Var10 = this.g;
                            if (th0Var10 != null) {
                                str4 = th0Var10.e;
                            } else {
                                str4 = null;
                            }
                            if (str4 != null && str4.length() != 0) {
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            if (!z4 && (this.e.get() instanceof NadMiniVideoDownloadView)) {
                                bm0<?> bm0Var = this.e.get();
                                if (bm0Var != null) {
                                    Drawable background = ((NadMiniVideoDownloadView) bm0Var).getBackground();
                                    if (background != null) {
                                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                                        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                                        int[] iArr = new int[2];
                                        th0 th0Var11 = this.g;
                                        if (th0Var11 != null) {
                                            str5 = th0Var11.d;
                                        } else {
                                            str5 = null;
                                        }
                                        iArr[0] = m61.a(str5, R.color.nad_reward_full_tail_btn_color);
                                        th0 th0Var12 = this.g;
                                        if (th0Var12 != null) {
                                            str12 = th0Var12.e;
                                        }
                                        iArr[1] = m61.a(str12, R.color.nad_reward_full_tail_btn_color);
                                        gradientDrawable.setColors(iArr);
                                        bm0<?> bm0Var2 = this.e.get();
                                        if (bm0Var2 != null) {
                                            ((NadMiniVideoDownloadView) bm0Var2).setBackground(gradientDrawable);
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView");
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView");
                                }
                            }
                        }
                        bm0<?> bm0Var3 = this.e.get();
                        if (bm0Var3 != null) {
                            bm0Var3.update(string, this.a);
                        }
                    }
                }
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            fn0.a().b(this, new a(this, th0.class));
        }
    }
}
