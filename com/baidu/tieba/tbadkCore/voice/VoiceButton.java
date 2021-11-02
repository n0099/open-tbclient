package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import b.a.e.a.j;
import b.a.e.e.q.f;
import b.a.r0.l3.r0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VoiceButton extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f54300e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54301f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54301f = false;
    }

    public a getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager == null || voiceManager.getRecorderManager() == null) {
                return null;
            }
            return voiceManager.getRecorderManager();
        }
        return (a) invokeV.objValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).getVoiceManager();
            }
            if ((j.a(getContext()) instanceof b.a.e.a.f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            a recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (recorderManager == null || !recorderManager.e()) {
                    return false;
                }
                this.f54301f = recorderManager.c(this.f54300e, -1);
                setPressed(true);
            } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                if (!isPressed()) {
                    setPressed(true);
                }
            } else {
                if (this.f54301f && recorderManager != null) {
                    recorderManager.stopRecord();
                }
                setPressed(false);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setRecorderView(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f54300e = fVar;
            a recorderManager = getRecorderManager();
            if (recorderManager != null) {
                recorderManager.d(fVar);
            }
        }
    }
}
