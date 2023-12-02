package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nea extends oea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemData U0;
    public VideoSerializeVideoThreadInfo V0;
    public ThreadData W0;

    @Override // com.baidu.tieba.oea
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.oea, com.baidu.tieba.lea
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nea(Context context, View view2) {
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
        u0(false);
        setStageType(null);
    }

    public final void H0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.S);
            pbActivityConfig.createNormalCfg(str2, null, null);
            pbActivityConfig.setForumId(String.valueOf(str));
            pbActivityConfig.setThreadData(this.W0);
            pbActivityConfig.setVideoOriginArea(ThreadCardUtils.computeViewArea(this.U));
            pbActivityConfig.setNeedPreLoad(true);
            hs7.e(this.W0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            View.OnClickListener onClickListener = this.F0;
            if (onClickListener != null) {
                onClickListener.onClick(getMainView());
            }
        }
    }

    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x0(this.f);
        }
    }

    @Override // com.baidu.tieba.oea
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i = this.p;
            if (i == this.e || i == this.n) {
                I0();
            }
        }
    }

    @Override // com.baidu.tieba.oea
    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f = 32;
        }
    }

    @Override // com.baidu.tieba.oea
    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.i0();
            this.U.setOnTouchListener(null);
            this.U.setOnClickListener(this);
        }
    }

    @Override // com.baidu.tieba.oea, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            startPlay();
        }
    }

    @Override // com.baidu.tieba.oea, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2.getId() == R.id.video_mute) {
            c0();
        } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.S, (int) R.string.no_network_guide);
        } else if (this.X) {
            VideoItemData videoItemData = this.U0;
            if (videoItemData != null) {
                H0(videoItemData.forum_id, videoItemData.thread_id);
            }
        } else {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.V0;
            if (videoSerializeVideoThreadInfo != null) {
                H0(videoSerializeVideoThreadInfo.forumId, videoSerializeVideoThreadInfo.threadId);
            }
        }
    }

    @Override // com.baidu.tieba.oea, com.baidu.tieba.lea
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) {
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
