package com.baidu.ugc.audioedit;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.audioprocesswrapper.DuAudioProcess;
import com.baidu.audioprocesswrapper.DuDelayProcess;
import com.baidu.tieba.m89;
import com.baidu.tieba.yb9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class AudioChangeOperator implements m89 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DU_AUDIO_EFFECT_SHIFT_AGC = 4;
    public static final int DU_AUDIO_EFFECT_SHIFT_AIR = 20;
    public static final int DU_AUDIO_EFFECT_SHIFT_COMPRESS = 24;
    public static final int DU_AUDIO_EFFECT_SHIFT_EQUALIZER = 16;
    public static final int DU_AUDIO_EFFECT_SHIFT_NS = 0;
    public static final int DU_AUDIO_EFFECT_SHIFT_PITCH = 12;
    public static final int DU_AUDIO_EFFECT_SHIFT_REVERB = 8;
    public static final int HARMONY_TYPE_ORIGIN = 700;
    public static final int PITCH_ORIGIN = 0;
    public static final int REVERB_ORIGIN = 100;
    public static final int VOICE_AGC_ORIGIN = 300;
    public static final int VOICE_AIR_ORIGIN = 500;
    public static final int VOICE_AUTO_CONFIG_TYPE = 15;
    public static final int VOICE_COMPRESS_ORIGIN = 600;
    public static final int VOICE_DENOISE_ORIGIN = 200;
    public static final int VOICE_EQ_ORIGIN = 400;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAgcType;
    public int mAirType;
    public AudioChangeConfig mAudioChangeConfig;
    public int mByteWidth;
    public int mChannelCount;
    public int mCompressType;
    public volatile int[] mCurrentEQparams;
    public volatile double[] mCurrentReverbParams;
    public volatile int[] mCurrentTypeArray;
    public DuDelayProcess mDelayProcess;
    public int mDenoiseType;
    public DuAudioProcess mDuAudioProcess;
    public int mEQType;
    public int mHarmonyType;
    public volatile int[] mLastEQparams;
    public volatile double[] mLastReverbParams;
    public volatile int[] mLastTypeArray;
    public int mPitchType;
    public int mReverbType;
    public int mSampleRate;

    public AudioChangeOperator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCompressType = 601;
        this.mHarmonyType = 700;
        this.mCurrentTypeArray = null;
        this.mLastTypeArray = null;
        this.mLastEQparams = null;
        this.mLastReverbParams = null;
        this.mCurrentEQparams = null;
        this.mCurrentReverbParams = null;
    }

    private void audioSwitch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mDuAudioProcess.k(this.mPitchType);
            int i = this.mReverbType;
            if (i - 100 != 15) {
                this.mDuAudioProcess.l(Math.max(i - 100, 0));
            } else if (i - 100 == 15 && this.mCurrentReverbParams != null) {
                this.mDuAudioProcess.m(Math.max(this.mReverbType - 100, 0), this.mCurrentReverbParams);
            }
            int i2 = this.mEQType;
            if (i2 + ErrorCode.ARGS_ERROR != 15) {
                this.mDuAudioProcess.h(Math.max(i2 + ErrorCode.ARGS_ERROR, 0));
            } else if (i2 + ErrorCode.ARGS_ERROR == 15 && this.mCurrentEQparams != null) {
                this.mDuAudioProcess.i(Math.max(this.mEQType + ErrorCode.ARGS_ERROR, 0), this.mCurrentEQparams);
            }
            this.mDuAudioProcess.g(Math.max(this.mAirType + ErrorCode.SERVER_ERROR, 0));
            this.mDuAudioProcess.j(this.mHarmonyType >= 700 ? 1 : 0);
            yb9.d("AudioChangeOperatorNew: 切换效果 mPitchType = " + this.mPitchType);
            yb9.d("AudioChangeOperatorNew: 切换效果 mReverbType = " + this.mReverbType);
        }
    }

    private boolean canDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.mDelayProcess != null && delayAvailable() : invokeV.booleanValue;
    }

    private boolean checkTypesEquals(int[] iArr, int[] iArr2, double[] dArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, iArr, iArr2, dArr)) == null) {
            if (this.mCurrentTypeArray != null || iArr == null) {
                if (this.mCurrentTypeArray == iArr) {
                    return true;
                }
                if (iArr != null && iArr.length != 0) {
                    Arrays.sort(iArr);
                }
                if (this.mCurrentTypeArray != null && this.mCurrentTypeArray.length != 0) {
                    Arrays.sort(this.mCurrentTypeArray);
                }
                if (iArr != null && Arrays.equals(iArr, this.mCurrentTypeArray)) {
                    boolean z = true;
                    boolean z2 = true;
                    for (int i : iArr) {
                        if (i == 415 && iArr2 != null && this.mCurrentEQparams != null && !Arrays.equals(iArr2, this.mCurrentEQparams)) {
                            z = false;
                        }
                        if (i == 115 && dArr != null && this.mCurrentReverbParams != null && !Arrays.equals(dArr, this.mCurrentReverbParams)) {
                            z2 = false;
                        }
                    }
                    if (z && z2) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    private void closeDelay() {
        DuDelayProcess duDelayProcess;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (duDelayProcess = this.mDelayProcess) == null) {
            return;
        }
        try {
            duDelayProcess.j(0);
            this.mDelayProcess.f(0.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean delayAvailable() {
        InterceptResult invokeV;
        DelayConfig delayConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            AudioChangeConfig audioChangeConfig = this.mAudioChangeConfig;
            return (audioChangeConfig == null || (delayConfig = audioChangeConfig.getDelayConfig()) == null || !delayConfig.available()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if (!checkTypesEquals(this.mLastTypeArray, this.mLastEQparams, this.mLastReverbParams) || delayAvailable()) {
                this.mCurrentTypeArray = this.mLastTypeArray;
                this.mCurrentReverbParams = this.mLastReverbParams;
                this.mCurrentEQparams = this.mLastEQparams;
                if (initProcess()) {
                    return;
                }
                int i = this.mDenoiseType;
                long j = i > 200 ? 0 | ((i - 200) << 0) : 0L;
                int i2 = this.mCompressType;
                if (i2 > 600) {
                    j |= (i2 - 600) << 24;
                }
                int i3 = this.mAgcType;
                if (i3 > 300) {
                    j |= (i3 - 300) << 4;
                }
                yb9.d("AudioChangeOperatorNew: 创建DuAudioProcess开始");
                this.mDuAudioProcess = new DuAudioProcess(this.mSampleRate, this.mChannelCount, j);
                audioSwitch();
                yb9.d("AudioChangeOperatorNew: 创建DuAudioProcess完成");
                yb9.d("AudioChangeOperatorNew: 创建DuDelayProcess开始");
                this.mDelayProcess = new DuDelayProcess(this.mSampleRate, 1);
                setDelayConfig();
                yb9.d("AudioChangeOperatorNew: 创建DuDelayProcess完成");
            }
        }
    }

    private boolean initProcess() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.mDuAudioProcess != null) {
                audioSwitch();
                z = true;
            } else {
                z = false;
            }
            if (this.mDelayProcess != null) {
                setDelayConfig();
                return true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mAgcType = 300;
            this.mDenoiseType = 200;
            this.mPitchType = 0;
            this.mReverbType = 100;
            this.mHarmonyType = 700;
        }
    }

    private void setDelayConfig() {
        AudioChangeConfig audioChangeConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.mDelayProcess == null || (audioChangeConfig = this.mAudioChangeConfig) == null) {
            return;
        }
        DelayConfig delayConfig = audioChangeConfig.getDelayConfig();
        if (shouldClose(delayConfig)) {
            return;
        }
        int delayTime = delayConfig.getDelayTime();
        float decrease = delayConfig.getDecrease();
        int pairTimeLength = delayConfig.getPairTimeLength();
        int[] pairTimeArray = delayConfig.getPairTimeArray();
        int newPosition = delayConfig.getNewPosition();
        DuDelayProcess duDelayProcess = this.mDelayProcess;
        delayConfig.delayMode = 1;
        duDelayProcess.h(1);
        if (delayTime >= 0) {
            this.mDelayProcess.j(delayTime);
        }
        if (decrease >= 0.0f && decrease <= 1.0f) {
            this.mDelayProcess.f(decrease);
        }
        if (pairTimeLength > 0 && pairTimeArray != null && pairTimeArray.length > 0) {
            DuDelayProcess duDelayProcess2 = this.mDelayProcess;
            delayConfig.delayMode = 2;
            duDelayProcess2.h(2);
            this.mDelayProcess.g(pairTimeLength, pairTimeArray);
        }
        if (newPosition >= 0) {
            DuDelayProcess duDelayProcess3 = this.mDelayProcess;
            delayConfig.delayMode = 2;
            duDelayProcess3.h(2);
            this.mDelayProcess.i(newPosition);
        }
        yb9.d("AudioChangeOperatorNew: delayConfig = " + delayConfig.toString());
    }

    private boolean shouldClose(DelayConfig delayConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, delayConfig)) == null) {
            if (delayConfig == null) {
                closeDelay();
                return true;
            } else if (delayConfig.available()) {
                return false;
            } else {
                closeDelay();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.m89
    public boolean available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mReverbType > 100 || this.mPitchType > 0 || this.mDenoiseType > 200 || this.mAgcType > 300 || this.mEQType > 400 || this.mAirType > 500 || this.mHarmonyType > 700 || delayAvailable() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m89
    public int availableBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (canDelay()) {
                return this.mDelayProcess.a();
            }
            DuAudioProcess duAudioProcess = this.mDuAudioProcess;
            if (duAudioProcess != null) {
                return duAudioProcess.a();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.m89
    public void clearQueues() {
        DuAudioProcess duAudioProcess;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (duAudioProcess = this.mDuAudioProcess) == null) {
            return;
        }
        duAudioProcess.b();
    }

    @Override // com.baidu.tieba.m89
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            DuAudioProcess duAudioProcess = this.mDuAudioProcess;
            if (duAudioProcess != null) {
                duAudioProcess.c();
            }
            if (canDelay()) {
                this.mDelayProcess.b();
            }
            this.mDuAudioProcess = null;
            this.mDelayProcess = null;
        }
    }

    @Override // com.baidu.tieba.m89
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            DuAudioProcess duAudioProcess = this.mDuAudioProcess;
            if (duAudioProcess != null) {
                duAudioProcess.d();
            }
            if (canDelay()) {
                this.mDelayProcess.c();
            }
        }
    }

    @Override // com.baidu.tieba.m89
    public int getBytes(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, bArr, i)) == null) {
            if (canDelay()) {
                return this.mDelayProcess.e(bArr, i);
            }
            DuAudioProcess duAudioProcess = this.mDuAudioProcess;
            if (duAudioProcess != null) {
                return duAudioProcess.f(bArr, i);
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.m89
    public void initVoiceChanger(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i, i2, i3, i4) == null) {
            this.mChannelCount = i2;
            this.mSampleRate = i3;
            this.mByteWidth = i4;
        }
    }

    @Override // com.baidu.tieba.m89
    public boolean putBytes(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, bArr, i)) == null) {
            init();
            DuAudioProcess duAudioProcess = this.mDuAudioProcess;
            if (duAudioProcess != null) {
                return canDelay() ? this.mDelayProcess.d(bArr, this.mDuAudioProcess.f(bArr, i)) : duAudioProcess.e(bArr, i);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void setAudioChangeConfig(AudioChangeConfig audioChangeConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, audioChangeConfig) == null) {
            this.mAudioChangeConfig = audioChangeConfig;
        }
    }

    @Override // com.baidu.tieba.m89
    public void setVoiceChangeType(int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, iArr) == null) || checkTypesEquals(iArr, this.mLastEQparams, this.mLastReverbParams)) {
            return;
        }
        this.mLastTypeArray = iArr;
        reset();
        if (iArr == null || iArr.length == 0) {
            return;
        }
        for (int i : iArr) {
            if (i >= 700) {
                this.mHarmonyType = i;
            } else if (i >= 500) {
                this.mAirType = i;
            } else if (i >= 400) {
                this.mEQType = i;
            } else if (i >= 300) {
                this.mAgcType = i;
            } else if (i >= 200) {
                this.mDenoiseType = i;
            } else if (i >= 100) {
                this.mReverbType = i;
            } else if (i >= 0) {
                this.mPitchType = i;
            }
        }
    }

    @Override // com.baidu.tieba.m89
    public void setVoiceChangeType(int[] iArr, int[] iArr2, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, iArr, iArr2, dArr) == null) {
            this.mLastEQparams = iArr2;
            this.mLastReverbParams = dArr;
            setVoiceChangeType(iArr);
        }
    }
}
