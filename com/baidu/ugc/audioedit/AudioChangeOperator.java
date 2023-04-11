package com.baidu.ugc.audioedit;

import com.baidu.audioprocesswrapper.DuAudioProcess;
import com.baidu.audioprocesswrapper.DuDelayProcess;
import com.baidu.tieba.dha;
import com.baidu.tieba.rda;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class AudioChangeOperator implements rda {
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
    public int mAgcType;
    public int mAirType;
    public AudioChangeConfig mAudioChangeConfig;
    public int mByteWidth;
    public int mChannelCount;
    public DuDelayProcess mDelayProcess;
    public int mDenoiseType;
    public DuAudioProcess mDuAudioProcess;
    public int mEQType;
    public int mPitchType;
    public int mReverbType;
    public int mSampleRate;
    public int mCompressType = 601;
    public int mHarmonyType = 700;
    public volatile int[] mCurrentTypeArray = null;
    public volatile int[] mLastTypeArray = null;
    public volatile int[] mLastEQparams = null;
    public volatile double[] mLastReverbParams = null;
    public volatile int[] mCurrentEQparams = null;
    public volatile double[] mCurrentReverbParams = null;

    private boolean canDelay() {
        if (this.mDelayProcess != null && delayAvailable()) {
            return true;
        }
        return false;
    }

    private void closeDelay() {
        DuDelayProcess duDelayProcess = this.mDelayProcess;
        if (duDelayProcess == null) {
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
        DelayConfig delayConfig;
        AudioChangeConfig audioChangeConfig = this.mAudioChangeConfig;
        if (audioChangeConfig == null || (delayConfig = audioChangeConfig.getDelayConfig()) == null || !delayConfig.available()) {
            return false;
        }
        return true;
    }

    private boolean initProcess() {
        boolean z;
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

    private void reset() {
        this.mAgcType = 300;
        this.mDenoiseType = 200;
        this.mPitchType = 0;
        this.mReverbType = 100;
        this.mHarmonyType = 700;
    }

    @Override // com.baidu.tieba.rda
    public int availableBytes() {
        if (canDelay()) {
            return this.mDelayProcess.a();
        }
        DuAudioProcess duAudioProcess = this.mDuAudioProcess;
        if (duAudioProcess != null) {
            return duAudioProcess.a();
        }
        return 0;
    }

    @Override // com.baidu.tieba.rda
    public void clearQueues() {
        DuAudioProcess duAudioProcess = this.mDuAudioProcess;
        if (duAudioProcess != null) {
            duAudioProcess.b();
        }
    }

    @Override // com.baidu.tieba.rda
    public void close() {
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

    @Override // com.baidu.tieba.rda
    public void flush() {
        DuAudioProcess duAudioProcess = this.mDuAudioProcess;
        if (duAudioProcess != null) {
            duAudioProcess.d();
        }
        if (canDelay()) {
            this.mDelayProcess.c();
        }
    }

    private void audioSwitch() {
        this.mDuAudioProcess.k(this.mPitchType);
        int i = this.mReverbType;
        int i2 = 0;
        if (i - 100 != 15) {
            this.mDuAudioProcess.l(Math.max(i - 100, 0));
        } else if (i - 100 == 15 && this.mCurrentReverbParams != null) {
            this.mDuAudioProcess.m(Math.max(this.mReverbType - 100, 0), this.mCurrentReverbParams);
        }
        int i3 = this.mEQType;
        if (i3 + ErrorCode.ARGS_ERROR != 15) {
            this.mDuAudioProcess.h(Math.max(i3 + ErrorCode.ARGS_ERROR, 0));
        } else if (i3 + ErrorCode.ARGS_ERROR == 15 && this.mCurrentEQparams != null) {
            this.mDuAudioProcess.i(Math.max(this.mEQType + ErrorCode.ARGS_ERROR, 0), this.mCurrentEQparams);
        }
        this.mDuAudioProcess.g(Math.max(this.mAirType + ErrorCode.SERVER_ERROR, 0));
        DuAudioProcess duAudioProcess = this.mDuAudioProcess;
        if (this.mHarmonyType >= 700) {
            i2 = 1;
        }
        duAudioProcess.j(i2);
        dha.d("AudioChangeOperatorNew: 切换效果 mPitchType = " + this.mPitchType);
        dha.d("AudioChangeOperatorNew: 切换效果 mReverbType = " + this.mReverbType);
    }

    private boolean checkTypesEquals(int[] iArr, int[] iArr2, double[] dArr) {
        if (this.mCurrentTypeArray == null && iArr != null) {
            return false;
        }
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

    private void init() {
        if (checkTypesEquals(this.mLastTypeArray, this.mLastEQparams, this.mLastReverbParams) && !delayAvailable()) {
            return;
        }
        this.mCurrentTypeArray = this.mLastTypeArray;
        this.mCurrentReverbParams = this.mLastReverbParams;
        this.mCurrentEQparams = this.mLastEQparams;
        if (initProcess()) {
            return;
        }
        long j = 0;
        int i = this.mDenoiseType;
        if (i > 200) {
            j = 0 | ((i - 200) << 0);
        }
        int i2 = this.mCompressType;
        if (i2 > 600) {
            j |= (i2 - 600) << 24;
        }
        int i3 = this.mAgcType;
        if (i3 > 300) {
            j |= (i3 - 300) << 4;
        }
        dha.d("AudioChangeOperatorNew: 创建DuAudioProcess开始");
        this.mDuAudioProcess = new DuAudioProcess(this.mSampleRate, this.mChannelCount, j);
        audioSwitch();
        dha.d("AudioChangeOperatorNew: 创建DuAudioProcess完成");
        dha.d("AudioChangeOperatorNew: 创建DuDelayProcess开始");
        this.mDelayProcess = new DuDelayProcess(this.mSampleRate, 1);
        setDelayConfig();
        dha.d("AudioChangeOperatorNew: 创建DuDelayProcess完成");
    }

    private void setDelayConfig() {
        AudioChangeConfig audioChangeConfig;
        if (this.mDelayProcess == null || (audioChangeConfig = this.mAudioChangeConfig) == null) {
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
        dha.d("AudioChangeOperatorNew: delayConfig = " + delayConfig.toString());
    }

    private boolean shouldClose(DelayConfig delayConfig) {
        if (delayConfig == null) {
            closeDelay();
            return true;
        } else if (!delayConfig.available()) {
            closeDelay();
            return true;
        } else {
            return false;
        }
    }

    public void setAudioChangeConfig(AudioChangeConfig audioChangeConfig) {
        this.mAudioChangeConfig = audioChangeConfig;
    }

    @Override // com.baidu.tieba.rda
    public boolean available() {
        if (this.mReverbType <= 100 && this.mPitchType <= 0 && this.mDenoiseType <= 200 && this.mAgcType <= 300 && this.mEQType <= 400 && this.mAirType <= 500 && this.mHarmonyType <= 700 && !delayAvailable()) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.rda
    public int getBytes(byte[] bArr, int i) {
        if (canDelay()) {
            return this.mDelayProcess.e(bArr, i);
        }
        DuAudioProcess duAudioProcess = this.mDuAudioProcess;
        if (duAudioProcess != null) {
            return duAudioProcess.f(bArr, i);
        }
        return 0;
    }

    @Override // com.baidu.tieba.rda
    public boolean putBytes(byte[] bArr, int i) {
        init();
        DuAudioProcess duAudioProcess = this.mDuAudioProcess;
        if (duAudioProcess != null) {
            boolean e = duAudioProcess.e(bArr, i);
            if (canDelay()) {
                return this.mDelayProcess.d(bArr, this.mDuAudioProcess.f(bArr, i));
            }
            return e;
        }
        return false;
    }

    @Override // com.baidu.tieba.rda
    public void initVoiceChanger(int i, int i2, int i3, int i4) {
        this.mChannelCount = i2;
        this.mSampleRate = i3;
        this.mByteWidth = i4;
    }

    @Override // com.baidu.tieba.rda
    public void setVoiceChangeType(int[] iArr) {
        if (checkTypesEquals(iArr, this.mLastEQparams, this.mLastReverbParams)) {
            return;
        }
        this.mLastTypeArray = iArr;
        reset();
        if (iArr != null && iArr.length != 0) {
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
    }

    @Override // com.baidu.tieba.rda
    public void setVoiceChangeType(int[] iArr, int[] iArr2, double[] dArr) {
        this.mLastEQparams = iArr2;
        this.mLastReverbParams = dArr;
        setVoiceChangeType(iArr);
    }
}
