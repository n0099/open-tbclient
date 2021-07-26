package com.bigkoo.svprogresshud;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class R {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class anim {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int svfade_in_center = 0x7f01011f;
        public static final int svfade_out_center = 0x7f010120;
        public static final int svslide_in_bottom = 0x7f010121;
        public static final int svslide_in_top = 0x7f010122;
        public static final int svslide_out_bottom = 0x7f010123;
        public static final int svslide_out_top = 0x7f010124;
        public transient /* synthetic */ FieldHolder $fh;

        public anim() {
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
    }

    /* loaded from: classes5.dex */
    public static final class attr {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int svprogress_max = 0x7f040510;
        public static final int svprogress_roundColor = 0x7f040511;
        public static final int svprogress_roundProgressColor = 0x7f040512;
        public static final int svprogress_roundWidth = 0x7f040513;
        public static final int svprogress_style = 0x7f040514;
        public transient /* synthetic */ FieldHolder $fh;

        public attr() {
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
    }

    /* loaded from: classes5.dex */
    public static final class color {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int bgColor_overlay = 0x7f0602b1;
        public static final int bgColor_overlay_black = 0x7f0602b2;
        public static final int bgColor_svprogressdefaultview = 0x7f0602b3;
        public static final int roundColor_svprogresshuddefault = 0x7f06080b;
        public static final int roundProgressColor_svprogresshuddefault = 0x7f06080c;
        public static final int textColor_svprogresshuddefault_msg = 0x7f0609eb;
        public transient /* synthetic */ FieldHolder $fh;

        public color() {
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
    }

    /* loaded from: classes5.dex */
    public static final class dimen {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int margintop_svprogresshuddefault_msg = 0x7f0703d6;
        public static final int padding_svprogresshuddefault = 0x7f07049c;
        public static final int radius_svprogresshuddefault = 0x7f0704d1;
        public static final int size_image_bigloading = 0x7f0705ae;
        public static final int size_image_smallloading = 0x7f0705af;
        public static final int size_minwidth_svprogresshuddefault = 0x7f0705b0;
        public static final int textSize_svprogresshuddefault_msg = 0x7f0708a8;
        public transient /* synthetic */ FieldHolder $fh;

        public dimen() {
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
    }

    /* loaded from: classes5.dex */
    public static final class drawable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int bg_overlay_gradient = 0x7f080398;
        public static final int bg_svprogresshuddefault = 0x7f0803f0;
        public static final int ic_svstatus_error = 0x7f080a26;
        public static final int ic_svstatus_info = 0x7f080a27;
        public static final int ic_svstatus_loading = 0x7f080a28;
        public static final int ic_svstatus_success = 0x7f080a29;
        public transient /* synthetic */ FieldHolder $fh;

        public drawable() {
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
    }

    /* loaded from: classes5.dex */
    public static final class id {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FILL = 0x7f09000b;
        public static final int STROKE = 0x7f090015;
        public static final int circleProgressBar = 0x7f09071f;
        public static final int ivBigLoading = 0x7f0910f8;
        public static final int ivSmallLoading = 0x7f0910f9;
        public static final int sv_outmost_container = 0x7f091e58;
        public static final int tvMsg = 0x7f09227c;
        public transient /* synthetic */ FieldHolder $fh;

        public id() {
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
    }

    /* loaded from: classes5.dex */
    public static final class integer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int svanimation_default_duration = 0x7f0a001f;
        public transient /* synthetic */ FieldHolder $fh;

        public integer() {
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
    }

    /* loaded from: classes5.dex */
    public static final class layout {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int layout_svprogresshud = 0x7f0c0496;
        public static final int view_svprogressdefault = 0x7f0c0809;
        public transient /* synthetic */ FieldHolder $fh;

        public layout() {
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
    }

    /* loaded from: classes5.dex */
    public static final class style {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int AlertActivity_AlertStyle = 0x7f100002;
        public transient /* synthetic */ FieldHolder $fh;

        public style() {
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
    }

    /* loaded from: classes5.dex */
    public static final class styleable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int[] SVCircleProgressBar;
        public static final int SVCircleProgressBar_svprogress_max = 0x00000000;
        public static final int SVCircleProgressBar_svprogress_roundColor = 0x00000001;
        public static final int SVCircleProgressBar_svprogress_roundProgressColor = 0x00000002;
        public static final int SVCircleProgressBar_svprogress_roundWidth = 0x00000003;
        public static final int SVCircleProgressBar_svprogress_style = 0x00000004;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-312774028, "Lcom/bigkoo/svprogresshud/R$styleable;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-312774028, "Lcom/bigkoo/svprogresshud/R$styleable;");
                    return;
                }
            }
            SVCircleProgressBar = new int[]{com.baidu.tieba.R.attr.svprogress_max, com.baidu.tieba.R.attr.svprogress_roundColor, com.baidu.tieba.R.attr.svprogress_roundProgressColor, com.baidu.tieba.R.attr.svprogress_roundWidth, com.baidu.tieba.R.attr.svprogress_style};
        }

        public styleable() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public R() {
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
}
