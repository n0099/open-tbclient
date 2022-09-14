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
/* loaded from: classes6.dex */
public class w39 extends y39<t49> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public View g;
    @Nullable
    public PlayVoiceBntNew h;
    @Nullable
    public ImageView i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w39 a;

        public a(w39 w39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w39Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w39(TbPageContext<?> tbPageContext) {
        super(tbPageContext, t49.class);
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

    @Override // com.baidu.tieba.d49
    public void b(WriteData writeData) {
        PlayVoiceBntNew playVoiceBntNew;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || (playVoiceBntNew = this.h) == null) {
            return;
        }
        VoiceData.VoiceModel voiceModel = playVoiceBntNew.getVoiceModel();
        writeData.setVoiceModel(voiceModel);
        if (voiceModel != null) {
            if (voiceModel.getId() != null) {
                writeData.setVoice(voiceModel.getId());
                writeData.setVoiceDuringTime(voiceModel.duration);
                return;
            }
            writeData.setVoice(null);
            writeData.setVoiceDuringTime(-1);
            return;
        }
        writeData.setVoice(null);
        writeData.setVoiceDuringTime(-1);
    }

    @Override // com.baidu.tieba.d49
    public void d(@NonNull WriteData writeData) {
        PlayVoiceBntNew playVoiceBntNew;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) || (playVoiceBntNew = this.h) == null) {
            return;
        }
        writeData.setVoiceModel(playVoiceBntNew.getVoiceModel());
    }

    @Override // com.baidu.tieba.d49
    public void k(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) || writeData.getVoiceModel() == null) {
            return;
        }
        y(writeData.getVoiceModel());
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public void l(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, intent, writeData) == null) {
            super.l(bundle, intent, writeData);
        }
    }

    @Override // com.baidu.tieba.d49
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            WebPManager.setPureDrawable(this.i, R.drawable.obfuscated_res_0x7f08095e, R.color.CAM_X0107, null);
            PlayVoiceBntNew playVoiceBntNew = this.h;
            if (playVoiceBntNew != null) {
                playVoiceBntNew.e();
            }
        }
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public void p(u45 u45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, u45Var) == null) {
            super.p(u45Var);
            int i = u45Var.a;
            if (i != 10) {
                if (i == 11) {
                    z();
                    return;
                }
                return;
            }
            Object obj = u45Var.c;
            if (obj instanceof VoiceData.VoiceModel) {
                y((VoiceData.VoiceModel) obj);
            }
        }
    }

    @Override // com.baidu.tieba.d49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0518, viewGroup, false);
            this.g = inflate;
            this.h = (PlayVoiceBntNew) inflate.findViewById(R.id.obfuscated_res_0x7f090455);
            ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091003);
            this.i = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new a(this));
            }
            return this.g;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public boolean r() {
        InterceptResult invokeV;
        PlayVoiceBntNew playVoiceBntNew;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View view2 = this.g;
            return (view2 == null || view2.getVisibility() != 0 || (playVoiceBntNew = this.h) == null || playVoiceBntNew.getVoiceModel() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void y(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, voiceModel) == null) || this.g == null || this.h == null || voiceModel == null || this.e == null || TextUtils.isEmpty(voiceModel.voiceId) || voiceModel.duration <= 0) {
            return;
        }
        ((t49) this.d).a = voiceModel;
        this.e.setVoiceModel(voiceModel);
        this.g.setVisibility(0);
        this.h.setVoiceModel(voiceModel);
        this.h.o();
        f49 f49Var = this.b;
        if (f49Var != null) {
            f49Var.h();
            this.b.x(new int[]{34});
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.g == null || this.h == null || this.e == null) {
            return;
        }
        D d = this.d;
        if (((t49) d).a != null) {
            kz4.a(kz4.b(((t49) d).a.voiceId));
        }
        ((t49) this.d).a = null;
        this.e.setVoiceModel(null);
        this.g.setVisibility(8);
        this.h.p();
        this.h.setVoiceModel(null);
        f49 f49Var = this.b;
        if (f49Var != null) {
            f49Var.e();
            this.b.h();
            this.b.x(new int[]{34});
        }
    }
}
