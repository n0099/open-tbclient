package com.bigkoo.svprogresshud;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class R {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class anim {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int svfade_in_center = 0x7f010127;
        public static final int svfade_out_center = 0x7f010128;
        public static final int svslide_in_bottom = 0x7f010129;
        public static final int svslide_in_top = 0x7f01012a;
        public static final int svslide_out_bottom = 0x7f01012b;
        public static final int svslide_out_top = 0x7f01012c;
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

    /* loaded from: classes9.dex */
    public static final class attr {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int svprogress_max = 0x7f040546;
        public static final int svprogress_roundColor = 0x7f040547;
        public static final int svprogress_roundProgressColor = 0x7f040548;
        public static final int svprogress_roundWidth = 0x7f040549;
        public static final int svprogress_style = 0x7f04054a;
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

    /* loaded from: classes9.dex */
    public static final class color {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int bgColor_overlay = 0x7f060343;
        public static final int bgColor_overlay_black = 0x7f060344;
        public static final int bgColor_svprogressdefaultview = 0x7f060345;
        public static final int roundColor_svprogresshuddefault = 0x7f060997;
        public static final int roundProgressColor_svprogresshuddefault = 0x7f060998;
        public static final int textColor_svprogresshuddefault_msg = 0x7f060b6c;
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

    /* loaded from: classes9.dex */
    public static final class dimen {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int margintop_svprogresshuddefault_msg = 0x7f070482;
        public static final int padding_svprogresshuddefault = 0x7f070562;
        public static final int radius_svprogresshuddefault = 0x7f07058b;
        public static final int size_image_bigloading = 0x7f070668;
        public static final int size_image_smallloading = 0x7f070669;
        public static final int size_minwidth_svprogresshuddefault = 0x7f07066a;
        public static final int textSize_svprogresshuddefault_msg = 0x7f070980;
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

    /* loaded from: classes9.dex */
    public static final class drawable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int bg_overlay_gradient = 0x7f0802be;
        public static final int bg_svprogresshuddefault = 0x7f0802ee;
        public static final int ic_svstatus_error = 0x7f080720;
        public static final int ic_svstatus_info = 0x7f080721;
        public static final int ic_svstatus_loading = 0x7f080722;
        public static final int ic_svstatus_success = 0x7f080723;
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

    /* loaded from: classes9.dex */
    public static final class id {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FILL = 0x7f09000b;
        public static final int STROKE = 0x7f090019;
        public static final int circleProgressBar = 0x7f0906c4;
        public static final int ivBigLoading = 0x7f0910c4;
        public static final int ivSmallLoading = 0x7f0910c5;
        public static final int sv_outmost_container = 0x7f091e12;
        public static final int tvMsg = 0x7f092240;
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

    /* loaded from: classes9.dex */
    public static final class integer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int svanimation_default_duration = 0x7f0a0022;
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

    /* loaded from: classes9.dex */
    public static final class layout {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int layout_svprogresshud = 0x7f0c04b4;
        public static final int view_svprogressdefault = 0x7f0c0847;
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

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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
