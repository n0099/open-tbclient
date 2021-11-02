package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.r0.k2.g;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PbVideoMediaController extends OperableVideoMediaControllerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoMediaController(Context context) {
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
        g();
    }

    public void changeViewLayout(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int g2 = l.g(getContext(), g.tbds126);
            if (z2 && z) {
                g2 = l.g(getContext(), g.tbds210);
            }
            layoutParams.height = g2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTextViewCurTime.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTextViewDuration.getLayoutParams();
            layoutParams2.leftMargin = l.g(getContext(), (!z2 || z) ? g.tbds44 : g.tbds78);
            layoutParams3.rightMargin = l.g(getContext(), (!z2 || z) ? g.tbds150 : g.tbds184);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.p = (ProgressBar) findViewById(i.pb_bottom_progress_bar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView, com.baidu.tieba.play.VideoControllerView
    public View getLayout(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? View.inflate(context, j.pb_video_media_controller, null) : (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void initCurTimeAndDuration(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.initCurTimeAndDuration(i2, i3);
            this.p.setProgress(this.mProgress.getProgress());
        }
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void resetProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.resetProgress();
            this.p.setProgress(0);
        }
    }

    public void setBottomBarShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p.setVisibility(z ? 0 : 8);
            this.mProgress.setVisibility(z ? 8 : 0);
            this.mTextViewCurTime.setVisibility(z ? 8 : 0);
            this.mTextViewDuration.setVisibility(z ? 8 : 0);
        }
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void setCurrentDuration(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.setCurrentDuration(i2, z);
            if (!z) {
                this.mProgress.setProgress((int) (((i2 * 1.0f) / this.mDuration) * 10000.0f));
                TextView textView = this.mTextViewCurTime;
                if (textView != null) {
                    textView.setText(StringHelper.stringForVideoTime(i2));
                }
            }
            this.p.setProgress(this.mProgress.getProgress());
        }
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public int setProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int progress = super.setProgress();
            this.p.setProgress(this.mProgress.getProgress());
            return progress;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoMediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoMediaController(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        g();
    }
}
