package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class VideoMiddleNiaiControllerView extends VideoControllerView {
    public static /* synthetic */ Interceptable $ic;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public View t;
    public LinearVideoLoadingSeekBar u;

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
        v = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        w = UtilHelper.getDimenPixelSize(R.dimen.tbds117);
        x = UtilHelper.getDimenPixelSize(R.dimen.tbds49);
        y = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
        z = UtilHelper.getDimenPixelSize(R.dimen.tbds37);
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

    @Override // com.baidu.tieba.play.VideoControllerView
    public View l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            View inflate = View.inflate(context, R.layout.video_middle_naivi_controller, null);
            this.t = inflate;
            this.u = (LinearVideoLoadingSeekBar) inflate.findViewById(R.id.pb_video_controller_seekBar);
            return this.t;
        }
        return (View) invokeL.objValue;
    }

    public void setBottomBarShow(boolean z2, int i2) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || (seekBar = this.l) == null) {
            return;
        }
        if (z2) {
            seekBar.setThumb(null);
            if (i2 == 1) {
                w();
            } else {
                u();
            }
            this.l.setProgressDrawable(SkinManager.getDrawable(R.drawable.video_navi_video_three_width_seekbar));
            return;
        }
        seekBar.setThumb(null);
        if (i2 == 1) {
            v();
        } else {
            u();
        }
        this.l.setProgressDrawable(SkinManager.getDrawable(R.drawable.video_navi_video_eight_width_seekbar));
    }

    public void setLoading(boolean z2) {
        LinearVideoLoadingSeekBar linearVideoLoadingSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) || (linearVideoLoadingSeekBar = this.u) == null) {
            return;
        }
        linearVideoLoadingSeekBar.setLoading(z2);
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == 1) {
                w();
            } else {
                u();
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t.getLayoutParams().height = w;
            SeekBar seekBar = this.l;
            seekBar.setPadding(seekBar.getPaddingLeft(), 0, this.l.getPaddingRight(), z);
            this.t.requestLayout();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.t.getLayoutParams().height = v;
            SeekBar seekBar = this.l;
            seekBar.setPadding(seekBar.getPaddingLeft(), y, this.l.getPaddingRight(), this.l.getPaddingBottom());
            this.t.requestLayout();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.t.getLayoutParams().height = v;
            SeekBar seekBar = this.l;
            seekBar.setPadding(seekBar.getPaddingLeft(), x, this.l.getPaddingRight(), 0);
            this.t.requestLayout();
        }
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
