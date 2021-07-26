package com.baidu.tieba.videoplay.videoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class VideoMediaController extends OperableVideoMediaControllerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMediaController(Context context) {
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
        u();
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView, com.baidu.tieba.play.VideoControllerView
    public View l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? View.inflate(context, R.layout.video_media_controller, null) : (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void o(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            super.o(i2, i3);
            this.t.setProgress(this.l.getProgress());
        }
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.q();
            this.t.setProgress(0);
        }
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int r = super.r();
            this.t.setProgress(this.l.getProgress());
            return r;
        }
        return invokeV.intValue;
    }

    public void setBottomBarShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.t.setVisibility(z ? 0 : 8);
            this.l.setVisibility(z ? 8 : 0);
            this.f20409h.setVisibility(z ? 8 : 0);
            this.f20410i.setVisibility(z ? 8 : 0);
        }
    }

    @Override // com.baidu.tieba.play.VideoControllerView
    public void setCurrentDuration(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.setCurrentDuration(i2, z);
            if (!z) {
                this.l.setProgress((int) (((i2 * 1.0f) / this.p) * 10000.0f));
                TextView textView = this.f20409h;
                if (textView != null) {
                    textView.setText(StringHelper.stringForVideoTime(i2));
                }
            }
            this.t.setProgress(this.l.getProgress());
        }
    }

    public void t(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int g2 = l.g(getContext(), R.dimen.tbds126);
            if (z2 && z) {
                g2 = l.g(getContext(), R.dimen.tbds210);
            }
            layoutParams.height = g2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f20409h.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f20410i.getLayoutParams();
            layoutParams2.leftMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds44 : R.dimen.tbds78);
            layoutParams3.rightMargin = l.g(getContext(), (!z2 || z) ? R.dimen.tbds150 : R.dimen.tbds184);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t = (ProgressBar) findViewById(R.id.pb_bottom_progress_bar);
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
        u();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMediaController(Context context, AttributeSet attributeSet, int i2) {
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
        u();
    }
}
