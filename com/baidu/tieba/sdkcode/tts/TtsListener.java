package com.baidu.tieba.sdkcode.tts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/sdkcode/tts/TtsListener;", "", "onPlayError", "", "speakerId", "", "errCore", "", StatConstants.KEY_EXT_ERR_MSG, "onPlayFinish", "onPlayProgress", "pos", "onPlayStart", "onPlayStop", "TtsListenerAdapter", "SdkCodeInterface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface TtsListener {
    void onPlayError(String str, int i, String str2);

    void onPlayFinish(String str);

    void onPlayProgress(String str, int i);

    void onPlayStart(String str);

    void onPlayStop(String str);

    /* loaded from: classes8.dex */
    public static class a implements TtsListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.sdkcode.tts.TtsListener
        public void onPlayError(String speakerId, int i, String errMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, speakerId, i, errMsg) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            }
        }

        @Override // com.baidu.tieba.sdkcode.tts.TtsListener
        public void onPlayFinish(String speakerId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, speakerId) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
            }
        }

        @Override // com.baidu.tieba.sdkcode.tts.TtsListener
        public void onPlayProgress(String speakerId, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, speakerId, i) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
            }
        }

        @Override // com.baidu.tieba.sdkcode.tts.TtsListener
        public void onPlayStart(String speakerId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, speakerId) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }
}
