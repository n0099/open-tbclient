package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sva extends vva<swa> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public View g;
    @Nullable
    public PlayVoiceBntNew h;
    @Nullable
    public ImageView i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sva a;

        public a(sva svaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {svaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = svaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.B();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sva(TbPageContext<?> tbPageContext) {
        super(tbPageContext, swa.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.awa
    public void b(WriteData writeData) {
        PlayVoiceBntNew playVoiceBntNew;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, writeData) != null) || (playVoiceBntNew = this.h) == null) {
            return;
        }
        VoiceData.VoiceModel voiceModel = playVoiceBntNew.getVoiceModel();
        writeData.setVoiceModel(voiceModel);
        if (voiceModel != null) {
            if (voiceModel.getId() != null) {
                writeData.setVoice(voiceModel.getId());
                writeData.setVoiceDuringTime(voiceModel.getDuration());
                return;
            }
            writeData.setVoice(null);
            writeData.setVoiceDuringTime(-1);
            return;
        }
        writeData.setVoice(null);
        writeData.setVoiceDuringTime(-1);
    }

    @Override // com.baidu.tieba.awa
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) && writeData.getVoiceModel() != null) {
            A(writeData.getVoiceModel());
        }
    }

    @Override // com.baidu.tieba.awa
    public void e(@NonNull WriteData writeData) {
        PlayVoiceBntNew playVoiceBntNew;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, writeData) != null) || (playVoiceBntNew = this.h) == null) {
            return;
        }
        writeData.setVoiceModel(playVoiceBntNew.getVoiceModel());
    }

    @Override // com.baidu.tieba.awa
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            WebPManager.setPureDrawable(this.i, R.drawable.icon_pure_home_delete16, R.color.CAM_X0107, null);
            PlayVoiceBntNew playVoiceBntNew = this.h;
            if (playVoiceBntNew != null) {
                playVoiceBntNew.b();
            }
        }
    }

    @Override // com.baidu.tieba.vva, com.baidu.tieba.awa
    public void r(lh5 lh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lh5Var) == null) {
            super.r(lh5Var);
            int i = lh5Var.a;
            if (i == 10) {
                Object obj = lh5Var.c;
                if (obj instanceof VoiceData.VoiceModel) {
                    A((VoiceData.VoiceModel) obj);
                }
            } else if (i == 11) {
                B();
            }
        }
    }

    public final void A(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, voiceModel) == null) && this.g != null && this.h != null && voiceModel != null && this.e != null && !TextUtils.isEmpty(voiceModel.getVoiceId()) && voiceModel.getDuration() > 0) {
            ((swa) this.d).a = voiceModel;
            this.e.setVoiceModel(voiceModel);
            this.g.setVisibility(0);
            this.h.setVoiceModel(voiceModel);
            this.h.l();
            cwa cwaVar = this.b;
            if (cwaVar != null) {
                cwaVar.i();
                this.b.x(new int[]{34});
            }
        }
    }

    @Override // com.baidu.tieba.awa
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d059a, viewGroup, false);
            this.g = inflate;
            this.h = (PlayVoiceBntNew) inflate.findViewById(R.id.obfuscated_res_0x7f0904e5);
            ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091206);
            this.i = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new a(this));
            }
            return this.g;
        }
        return (View) invokeL.objValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.g == null || this.h == null || this.e == null) {
            return;
        }
        D d = this.d;
        if (((swa) d).a != null) {
            fb5.a(fb5.b(((swa) d).a.getVoiceId()));
        }
        ((swa) this.d).a = null;
        this.e.setVoiceModel(null);
        this.g.setVisibility(8);
        this.h.m();
        this.h.setVoiceModel(null);
        cwa cwaVar = this.b;
        if (cwaVar != null) {
            cwaVar.f();
            this.b.i();
            this.b.x(new int[]{34});
        }
    }

    @Override // com.baidu.tieba.vva, com.baidu.tieba.awa
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
        }
    }

    @Override // com.baidu.tieba.vva, com.baidu.tieba.awa
    public boolean t() {
        InterceptResult invokeV;
        PlayVoiceBntNew playVoiceBntNew;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            View view2 = this.g;
            if (view2 == null || view2.getVisibility() != 0 || (playVoiceBntNew = this.h) == null || playVoiceBntNew.getVoiceModel() == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
