package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class VideoMiddleNiaiControllerView extends VideoControllerView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOTTOM_HEIGHT;
    public static final int EIGHT_WIDTH_PADDING_TOP;
    public static final int THREE_WIDTH_PADDING_TOP;
    public static final int TYPE_BOTTOM = 1;
    public static final int TYPE_VERTICLE_CENTER = 0;
    public static final int VERTICLE_CENTER_HEIGHT;
    public static final int VERTICLE_CENTER_PADDING_BOTTOM;
    public transient /* synthetic */ FieldHolder $fh;
    public View o;
    public LinearVideoLoadingSeekBar p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1708390420, "Lcom/baidu/tieba/play/VideoMiddleNiaiControllerView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1708390420, "Lcom/baidu/tieba/play/VideoMiddleNiaiControllerView;");
                return;
            }
        }
        BOTTOM_HEIGHT = UtilHelper.getDimenPixelSize(e.tbds52);
        VERTICLE_CENTER_HEIGHT = UtilHelper.getDimenPixelSize(e.tbds117);
        THREE_WIDTH_PADDING_TOP = UtilHelper.getDimenPixelSize(e.tbds49);
        EIGHT_WIDTH_PADDING_TOP = UtilHelper.getDimenPixelSize(e.tbds44);
        VERTICLE_CENTER_PADDING_BOTTOM = UtilHelper.getDimenPixelSize(e.tbds37);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddleNiaiControllerView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o.getLayoutParams().height = VERTICLE_CENTER_HEIGHT;
            SeekBar seekBar = this.mProgress;
            seekBar.setPadding(seekBar.getPaddingLeft(), EIGHT_WIDTH_PADDING_TOP, this.mProgress.getPaddingRight(), VERTICLE_CENTER_PADDING_BOTTOM);
            this.o.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public View getLayout(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            View inflate = View.inflate(context, h.video_middle_naivi_controller, null);
            this.o = inflate;
            this.p = (LinearVideoLoadingSeekBar) inflate.findViewById(g.pb_video_controller_seekBar);
            return this.o;
        }
        return (View) invokeL.objValue;
    }

    public SeekBar getSeekBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : (SeekBar) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o.getLayoutParams().height = BOTTOM_HEIGHT;
            SeekBar seekBar = this.mProgress;
            seekBar.setPadding(seekBar.getPaddingLeft(), EIGHT_WIDTH_PADDING_TOP, this.mProgress.getPaddingRight(), this.mProgress.getPaddingBottom());
            this.o.requestLayout();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o.getLayoutParams().height = BOTTOM_HEIGHT;
            SeekBar seekBar = this.mProgress;
            seekBar.setPadding(seekBar.getPaddingLeft(), THREE_WIDTH_PADDING_TOP, this.mProgress.getPaddingRight(), 0);
            this.o.requestLayout();
        }
    }

    public void initProgressUIType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 == 1) {
                i();
            } else {
                g();
            }
        }
    }

    public void setBottomBarShow(boolean z, int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (seekBar = this.mProgress) == null) {
            return;
        }
        if (z) {
            seekBar.setThumb(null);
            if (i2 == 1) {
                i();
            } else {
                g();
            }
            this.mProgress.setProgressDrawable(SkinManager.getDrawable(f.video_navi_video_three_width_seekbar));
            return;
        }
        seekBar.setThumb(null);
        if (i2 == 1) {
            h();
        } else {
            g();
        }
        this.mProgress.setProgressDrawable(SkinManager.getDrawable(f.video_navi_video_eight_width_seekbar));
    }

    public void setLoading(boolean z) {
        LinearVideoLoadingSeekBar linearVideoLoadingSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (linearVideoLoadingSeekBar = this.p) == null) {
            return;
        }
        linearVideoLoadingSeekBar.setLoading(z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddleNiaiControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddleNiaiControllerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }
}
