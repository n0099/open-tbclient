package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes7.dex */
public class l9a extends n9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData U0;
    public VideoSerializeVideoThreadInfo V0;
    public ThreadData W0;
    public a X0;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    @Override // com.baidu.tieba.n9a
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.n9a, com.baidu.tieba.k9a
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l9a(Context context, View view2) {
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
    public l9a(Context context, View view2, boolean z) {
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

    public final void F0(Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, rect) != null) || this.W0 == null) {
            return;
        }
        if (this.U0 == null) {
            this.U0 = new VideoItemData();
        }
        ArrayList arrayList = new ArrayList();
        this.U0.buildWithThreadData(this.W0);
        arrayList.add(this.U0);
        String str = null;
        ThreadData threadData = this.W0;
        if (threadData != null && threadData.getBaijiahaoData() != null) {
            str = this.W0.getBaijiahaoData().oriUgcNid;
        }
        String str2 = str;
        Context context = this.S;
        boolean z = this.X;
        String str3 = this.f0;
        ThreadData threadData2 = this.W0;
        lt5.e(context, arrayList, str2, z, 0, rect, "from_nani_video", "personalize_page", "", str3, str3, false, threadData2.isJumpToFrsVideoTabPlay, true, threadData2.getFid());
    }

    @Override // com.baidu.tieba.n9a, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.video_mute) {
            a0();
        } else if (id == R.id.obfuscated_res_0x7f091f6a) {
            v0(this.b);
            startPlay();
        } else {
            a aVar = this.X0;
            if (aVar != null) {
                aVar.a();
                return;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(this.S, (int) R.string.no_network_guide);
            } else {
                F0(ThreadCardUtils.computeViewArea(this.U));
                TbSingleton.getInstance().setIsNeedReuseVideoPlayer(isPlaying());
            }
            View.OnClickListener onClickListener = this.F0;
            if (onClickListener != null) {
                onClickListener.onClick(getMainView());
            }
        }
    }

    public void G0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.X0 = aVar;
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            v0(this.f);
        }
    }

    @Override // com.baidu.tieba.n9a
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i = this.p;
            if (i == this.e || i == this.n) {
                H0();
            }
        }
    }

    @Override // com.baidu.tieba.n9a
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f = 32;
        }
    }

    @Override // com.baidu.tieba.n9a
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.g0();
            this.U.setOnTouchListener(null);
            this.U.setOnClickListener(this);
        }
    }

    @Override // com.baidu.tieba.n9a, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            startPlay();
        }
    }

    @Override // com.baidu.tieba.n9a, com.baidu.tieba.k9a
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) {
            super.setData(threadData);
            this.W0 = threadData;
            if (this.X) {
                VideoItemData videoItemData = new VideoItemData();
                this.U0 = videoItemData;
                videoItemData.buildWithThreadData(threadData);
                return;
            }
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            this.V0 = videoSerializeVideoThreadInfo;
            videoSerializeVideoThreadInfo.copyFromThreadInfo(threadData);
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.V0;
            videoSerializeVideoThreadInfo2.source = threadData.mRecomSource;
            videoSerializeVideoThreadInfo2.extra = threadData.mRecomExtra;
            videoSerializeVideoThreadInfo2.ab_tag = threadData.mRecomAbTag;
            videoSerializeVideoThreadInfo2.weight = threadData.mRecomWeight;
        }
    }
}
