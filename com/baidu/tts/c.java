package com.baidu.tts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.client.SynthesizerResponse;
/* loaded from: classes9.dex */
public class c implements SynthesizerResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SynthesizerResponse.SynthesizeType a;
    public final String b;
    public final String c;
    public final String d;
    public SynthesizerResponse.SynthesizerData e;
    public SynthesizerResponse.SynthesizerError f;

    /* loaded from: classes9.dex */
    public static class a implements SynthesizerResponse.SynthesizerData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] a;
        public final int b;
        public final int c;
        public final int d;

        public a(byte[] bArr, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bArr;
            this.b = i;
            this.d = i2;
            this.c = i3;
        }

        @Override // com.baidu.tts.client.SynthesizerResponse.SynthesizerData
        public byte[] getAudioData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (byte[]) invokeV.objValue;
        }

        @Override // com.baidu.tts.client.SynthesizerResponse.SynthesizerData
        public int getAudioProgress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tts.client.SynthesizerResponse.SynthesizerData
        public int getAudioSampleRate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tts.client.SynthesizerResponse.SynthesizerData
        public int getEngineType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "SynthesizerData{mAudioDataLength=" + this.a.length + ", mAudioProgress=" + this.b + ", mAudioSampleRate=" + this.c + ", mEngineType=" + this.d + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements SynthesizerResponse.SynthesizerError {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final String b;

        public b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = str;
        }

        @Override // com.baidu.tts.client.SynthesizerResponse.SynthesizerError
        public int getCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tts.client.SynthesizerResponse.SynthesizerError
        public String getDescription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "SynthesizerError{mCode=" + this.a + ", mDescription='" + this.b + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(SynthesizerResponse.SynthesizeType synthesizeType, String str, String str2, String str3) {
        this(synthesizeType, str, str2, str3, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {synthesizeType, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((SynthesizerResponse.SynthesizeType) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (SynthesizerResponse.SynthesizerData) objArr2[4], (SynthesizerResponse.SynthesizerError) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c(SynthesizerResponse.SynthesizeType synthesizeType, String str, String str2, String str3, SynthesizerResponse.SynthesizerData synthesizerData, SynthesizerResponse.SynthesizerError synthesizerError) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {synthesizeType, str, str2, str3, synthesizerData, synthesizerError};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = synthesizeType;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = synthesizerData;
        this.f = synthesizerError;
    }

    @Override // com.baidu.tts.client.SynthesizerResponse
    public String getInstanceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tts.client.SynthesizerResponse
    public String getSn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tts.client.SynthesizerResponse
    public SynthesizerResponse.SynthesizeType getSynthesizeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (SynthesizerResponse.SynthesizeType) invokeV.objValue;
    }

    @Override // com.baidu.tts.client.SynthesizerResponse
    public SynthesizerResponse.SynthesizerData getSynthesizerData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (SynthesizerResponse.SynthesizerData) invokeV.objValue;
    }

    @Override // com.baidu.tts.client.SynthesizerResponse
    public SynthesizerResponse.SynthesizerError getSynthesizerError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (SynthesizerResponse.SynthesizerError) invokeV.objValue;
    }

    @Override // com.baidu.tts.client.SynthesizerResponse
    public String getUtteranceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "SynthesizerResponse{mSynthesizeType=" + this.a + ", mUtteranceId='" + this.c + "', mInstanceId='" + this.d + "', mSynthesizerData=" + this.e + ", mSynthesizerError=" + this.f + '}';
        }
        return (String) invokeV.objValue;
    }
}
