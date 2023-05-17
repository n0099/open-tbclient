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
/* loaded from: classes7.dex */
public class VideoMiddleNiaiControllerView extends VideoControllerView {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public View p;
    public LinearVideoLoadingSeekBar q;

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
        r = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        s = UtilHelper.getDimenPixelSize(R.dimen.tbds117);
        t = UtilHelper.getDimenPixelSize(R.dimen.tbds49);
        u = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
        v = UtilHelper.getDimenPixelSize(R.dimen.tbds37);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddleNiaiControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public SeekBar getSeekBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.q;
        }
        return (SeekBar) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.getLayoutParams().height = s;
            SeekBar seekBar = this.g;
            seekBar.setPadding(seekBar.getPaddingLeft(), u, this.g.getPaddingRight(), v);
            this.p.requestLayout();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p.getLayoutParams().height = r;
            SeekBar seekBar = this.g;
            seekBar.setPadding(seekBar.getPaddingLeft(), t, this.g.getPaddingRight(), 0);
            this.p.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public View i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            View inflate = View.inflate(context, R.layout.video_middle_naivi_controller, null);
            this.p = inflate;
            this.q = (LinearVideoLoadingSeekBar) inflate.findViewById(R.id.pb_video_controller_seekBar);
            return this.p;
        }
        return (View) invokeL.objValue;
    }

    public void setLoading(boolean z) {
        LinearVideoLoadingSeekBar linearVideoLoadingSeekBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (linearVideoLoadingSeekBar = this.q) != null) {
            linearVideoLoadingSeekBar.setLoading(z);
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i == 1) {
                x();
            } else {
                v();
            }
        }
    }

    public void setBottomBarShow(boolean z, int i) {
        SeekBar seekBar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || (seekBar = this.g) == null) {
            return;
        }
        if (z) {
            seekBar.setThumb(null);
            if (i == 1) {
                x();
            } else {
                v();
            }
            this.g.setProgressDrawable(SkinManager.getDrawable(R.drawable.video_navi_video_three_width_seekbar));
            return;
        }
        seekBar.setThumb(null);
        if (i == 1) {
            w();
        } else {
            v();
        }
        this.g.setProgressDrawable(SkinManager.getDrawable(R.drawable.video_navi_video_eight_width_seekbar));
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.p.getLayoutParams().height = r;
            SeekBar seekBar = this.g;
            seekBar.setPadding(seekBar.getPaddingLeft(), u, this.g.getPaddingRight(), this.g.getPaddingBottom());
            this.p.requestLayout();
        }
    }
}
