package com.baidu.ugc.audioedit;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.audioprocesswrapper.DuAudioProcess;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.w0.g.b;
import d.a.w0.t.c;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class AudioChangeOperator implements b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DU_AUDIO_EFFECT_SHIFT_AGC = 4;
    public static final int DU_AUDIO_EFFECT_SHIFT_NS = 0;
    public static final int DU_AUDIO_EFFECT_SHIFT_PITCH = 12;
    public static final int DU_AUDIO_EFFECT_SHIFT_REVERB = 8;
    public static final int PITCH_ORIGIN = 0;
    public static final int REVERB_ORIGIN = 100;
    public static final int VOICE_AGC_ORIGIN = 300;
    public static final int VOICE_DENOISE_ORIGIN = 200;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAgcType;
    public int mByteWidth;
    public int mChannelCount;
    public volatile int[] mCurrentTypeArray;
    public int mDenoiseType;
    public DuAudioProcess mDuAudioProcess;
    public volatile int[] mLastTypeArray;
    public int mPitchType;
    public int mReverbType;
    public int mSampleRate;

    public AudioChangeOperator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrentTypeArray = null;
        this.mLastTypeArray = null;
    }

    private boolean checkTypesEquals(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, iArr)) == null) {
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
                return Arrays.equals(iArr, this.mCurrentTypeArray);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || checkTypesEquals(this.mLastTypeArray)) {
            return;
        }
        this.mCurrentTypeArray = this.mLastTypeArray;
        DuAudioProcess duAudioProcess = this.mDuAudioProcess;
        if (duAudioProcess != null) {
            duAudioProcess.g(this.mPitchType);
            this.mDuAudioProcess.h(Math.max(this.mReverbType - 100, 0));
            c.d("AudioChangeOperatorNew: 切换效果 mPitchType = " + this.mPitchType);
            c.d("AudioChangeOperatorNew: 切换效果 mReverbType = " + this.mReverbType);
            return;
        }
        int i2 = this.mDenoiseType;
        int i3 = i2 > 200 ? 0 | ((i2 - 200) << 0) : 0;
        int i4 = this.mAgcType;
        if (i4 > 300) {
            i3 |= (i4 - 300) << 4;
        }
        int i5 = this.mReverbType;
        if (i5 > 100) {
            i3 |= (i5 - 100) << 8;
        }
        int i6 = this.mPitchType;
        if (i6 > 0) {
            i3 |= i6 << 12;
        }
        c.d("AudioChangeOperatorNew: 创建DuAudioProcess开始");
        this.mDuAudioProcess = new DuAudioProcess(this.mSampleRate, this.mChannelCount, i3);
        c.d("AudioChangeOperatorNew: 创建DuAudioProcess完成");
    }

    private void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mAgcType = 300;
            this.mDenoiseType = 200;
            this.mPitchType = 0;
            this.mReverbType = 100;
        }
    }

    @Override // d.a.w0.g.b
    public boolean available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mReverbType > 100 || this.mPitchType > 0 || this.mDenoiseType > 200 || this.mAgcType > 300 : invokeV.booleanValue;
    }

    @Override // d.a.w0.g.b
    public int availableBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            DuAudioProcess duAudioProcess = this.mDuAudioProcess;
            if (duAudioProcess != null) {
                return duAudioProcess.a();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.w0.g.b
    public void clearQueues() {
        DuAudioProcess duAudioProcess;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (duAudioProcess = this.mDuAudioProcess) == null) {
            return;
        }
        duAudioProcess.b();
    }

    @Override // d.a.w0.g.b
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            DuAudioProcess duAudioProcess = this.mDuAudioProcess;
            if (duAudioProcess != null) {
                duAudioProcess.c();
            }
            this.mDuAudioProcess = null;
        }
    }

    @Override // d.a.w0.g.b
    public void flush() {
        DuAudioProcess duAudioProcess;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (duAudioProcess = this.mDuAudioProcess) == null) {
            return;
        }
        duAudioProcess.d();
    }

    @Override // d.a.w0.g.b
    public int getBytes(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, bArr, i2)) == null) {
            DuAudioProcess duAudioProcess = this.mDuAudioProcess;
            if (duAudioProcess != null) {
                return duAudioProcess.f(bArr, i2);
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    @Override // d.a.w0.g.b
    public void initVoiceChanger(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            this.mChannelCount = i3;
            this.mSampleRate = i4;
            this.mByteWidth = i5;
        }
    }

    @Override // d.a.w0.g.b
    public boolean putBytes(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, bArr, i2)) == null) {
            init();
            DuAudioProcess duAudioProcess = this.mDuAudioProcess;
            if (duAudioProcess != null) {
                return duAudioProcess.e(bArr, i2);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // d.a.w0.g.b
    public void setVoiceChangeType(int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr) == null) || checkTypesEquals(iArr)) {
            return;
        }
        this.mLastTypeArray = iArr;
        reset();
        if (iArr == null || iArr.length == 0) {
            return;
        }
        for (int i2 : iArr) {
            if (i2 >= 300) {
                this.mAgcType = i2;
            } else if (i2 >= 200) {
                this.mDenoiseType = i2;
            } else if (i2 >= 100) {
                this.mReverbType = i2;
            } else if (i2 >= 0) {
                this.mPitchType = i2;
            }
        }
    }
}
