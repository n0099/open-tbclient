package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.s07;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class km6 implements s07.m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public km6() {
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

    public static final void l(i27 state, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, state, view2) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            for (n47 n47Var : state.i()) {
                n77.a.b(n47Var, state.g() + 1);
                state.f().invoke(n47Var);
            }
        }
    }

    @Override // com.baidu.tieba.s07.m
    public void a(ViewGroup view2, final i27 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, state) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(state, "state");
            if (view2 instanceof PlayVoiceBntNew) {
                s47 h = state.h();
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.from = h.b();
                voiceModel.setVoiceId(h.c());
                voiceModel.setDuration(h.a());
                PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) view2;
                playVoiceBntNew.setVoiceModel(voiceModel);
                playVoiceBntNew.setTag(voiceModel);
                playVoiceBntNew.b();
                Integer num = voiceModel.voice_status;
                Intrinsics.checkNotNullExpressionValue(num, "voiceModel.voice_status");
                playVoiceBntNew.j(num.intValue());
                playVoiceBntNew.l();
                playVoiceBntNew.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.vl6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            km6.l(i27.this, view3);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.s07.s
    public void b(ViewGroup view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            if (view2 instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) view2).b();
            }
        }
    }

    @Override // com.baidu.tieba.s07.m
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new PlayVoiceBntNew(context, PlayVoiceBntNew.PLAY_TYPE.NORMAL);
        }
        return (ViewGroup) invokeL.objValue;
    }
}
