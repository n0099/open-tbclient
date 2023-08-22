package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.l9;
import com.baidu.tieba.qi;
import com.baidu.tieba.si;
import com.baidu.tieba.tha;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class VoiceButton extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public si a;
    public boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
    }

    public tha getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.getRecorderManager() != null) {
                return voiceManager.getRecorderManager();
            }
            return null;
        }
        return (tha) invokeV.objValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.i) {
                return ((VoiceManager.i) context).G0();
            }
            if ((l9.a(getContext()) instanceof BdPageContext) && (tbPageContext = (TbPageContext) l9.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.i)) {
                return ((VoiceManager.i) tbPageContext.getOrignalPage()).G0();
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
            tha recorderManager = getRecorderManager();
            if (motionEvent.getAction() == 0) {
                if (recorderManager == null || !recorderManager.f()) {
                    return false;
                }
                this.b = recorderManager.c(this.a, -1);
                setPressed(true);
            } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                if (!isPressed()) {
                    setPressed(true);
                }
            } else {
                if (this.b && recorderManager != null) {
                    recorderManager.stopRecord();
                }
                setPressed(false);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setRecorderView(si siVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, siVar) == null) {
            this.a = siVar;
            tha recorderManager = getRecorderManager();
            if (recorderManager != null) {
                recorderManager.e(siVar);
                recorderManager.d(qi.a);
            }
        }
    }
}
