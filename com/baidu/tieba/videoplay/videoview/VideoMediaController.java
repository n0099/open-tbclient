package com.baidu.tieba.videoplay.videoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class VideoMediaController extends OperableVideoMediaControllerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMediaController(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        v();
    }

    public void setBottomBarShow(boolean z) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            ProgressBar progressBar = this.p;
            int i4 = 0;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            progressBar.setVisibility(i);
            SeekBar seekBar = this.g;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            seekBar.setVisibility(i2);
            TextView textView = this.c;
            if (z) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView.setVisibility(i3);
            TextView textView2 = this.d;
            if (z) {
                i4 = 8;
            }
            textView2.setVisibility(i4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        v();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMediaController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        v();
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView, com.baidu.tieba.play.VideoControllerView
    public View i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            return View.inflate(context, R.layout.obfuscated_res_0x7f0d09f7, null);
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            super.l(i, i2);
            this.p.setProgress(this.g.getProgress());
        }
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.q();
            this.p.setProgress(0);
        }
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int s = super.s();
            this.p.setProgress(this.g.getProgress());
            return s;
        }
        return invokeV.intValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091ab6);
        }
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void setCurrentDuration(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.setCurrentDuration(i, z);
            if (!z) {
                this.g.setProgress((int) (((i * 1.0f) / this.k) * 10000.0f));
                TextView textView = this.c;
                if (textView != null) {
                    textView.setText(StringHelper.stringForVideoTime(i));
                }
            }
            this.p.setProgress(this.g.getProgress());
        }
    }

    public void u(boolean z, boolean z2) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds126);
            if (z2 && z) {
                dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds210);
            }
            layoutParams.height = dimens;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            Context context = getContext();
            if (z2 && !z) {
                i = R.dimen.tbds78;
            } else {
                i = R.dimen.tbds44;
            }
            layoutParams2.leftMargin = BdUtilHelper.getDimens(context, i);
            Context context2 = getContext();
            if (z2 && !z) {
                i2 = R.dimen.tbds184;
            } else {
                i2 = R.dimen.tbds150;
            }
            layoutParams3.rightMargin = BdUtilHelper.getDimens(context2, i2);
        }
    }
}
