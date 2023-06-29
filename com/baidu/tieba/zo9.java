package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class zo9 extends bp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData S0;
    public VideoSerializeVideoThreadInfo T0;
    public ThreadData U0;

    @Override // com.baidu.tieba.bp9
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.bp9, com.baidu.tieba.yo9
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zo9(Context context, View view2) {
        super(context, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 5000;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zo9(Context context, View view2, boolean z) {
        this(context, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        s0(z);
    }

    public final void E0(Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, rect) != null) || this.U0 == null) {
            return;
        }
        if (this.S0 == null) {
            this.S0 = new VideoItemData();
        }
        ArrayList arrayList = new ArrayList();
        this.S0.buildWithThreadData(this.U0);
        arrayList.add(this.S0);
        String str = null;
        ThreadData threadData = this.U0;
        if (threadData != null && threadData.getBaijiahaoData() != null) {
            str = this.U0.getBaijiahaoData().oriUgcNid;
        }
        String str2 = str;
        Context context = this.R;
        boolean z = this.W;
        String str3 = this.e0;
        ThreadData threadData2 = this.U0;
        cx5.e(context, arrayList, str2, z, 0, rect, "from_nani_video", "personalize_page", "", str3, str3, false, threadData2.isJumpToFrsVideoTabPlay, true, threadData2.getFid());
    }

    @Override // com.baidu.tieba.bp9, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.video_mute) {
            a0();
        } else if (id == R.id.obfuscated_res_0x7f091ea1) {
            v0(this.b);
            startPlay();
        } else {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                xi.P(this.R, R.string.no_network_guide);
            } else {
                E0(ThreadCardUtils.computeViewArea(this.f1091T));
                TbSingleton.getInstance().setIsNeedReuseVideoPlayer(isPlaying());
            }
            View.OnClickListener onClickListener = this.E0;
            if (onClickListener != null) {
                onClickListener.onClick(getMainView());
            }
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v0(this.f);
        }
    }

    @Override // com.baidu.tieba.bp9
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i = this.p;
            if (i == this.e || i == this.n) {
                F0();
            }
        }
    }

    @Override // com.baidu.tieba.bp9
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f = 32;
        }
    }

    @Override // com.baidu.tieba.bp9
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.g0();
            this.f1091T.setOnTouchListener(null);
            this.f1091T.setOnClickListener(this);
        }
    }

    @Override // com.baidu.tieba.bp9, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            startPlay();
        }
    }

    @Override // com.baidu.tieba.bp9, com.baidu.tieba.yo9
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) {
            super.setData(threadData);
            this.U0 = threadData;
            if (this.W) {
                VideoItemData videoItemData = new VideoItemData();
                this.S0 = videoItemData;
                videoItemData.buildWithThreadData(threadData);
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            this.T0 = videoSerializeVideoThreadInfo;
            videoSerializeVideoThreadInfo.copyFromThreadInfo(threadData);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.T0;
            videoSerializeVideoThreadInfo2.source = threadData.mRecomSource;
            videoSerializeVideoThreadInfo2.extra = threadData.mRecomExtra;
            videoSerializeVideoThreadInfo2.ab_tag = threadData.mRecomAbTag;
            videoSerializeVideoThreadInfo2.weight = threadData.mRecomWeight;
        }
    }
}
