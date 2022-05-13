package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.f9;
import com.repackage.gs4;
import com.repackage.li;
import com.repackage.mi;
import com.repackage.w55;
/* loaded from: classes4.dex */
public class PlayVoiceBntNew extends RelativeLayout implements VoiceManager.i, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public VoiceData.VoiceModel a;
    public RelativeLayout b;
    public ImageView c;
    public TextView d;
    public ProgressBar e;
    public AudioAnimationView f;
    public Context g;
    public int h;
    public View.OnClickListener i;
    public float j;
    public VoiceManager k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class PLAY_TYPE {
        public static final /* synthetic */ PLAY_TYPE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PLAY_TYPE NORMAL;
        public static final PLAY_TYPE REPLY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2026038917, "Lcom/baidu/tieba/tbadkCore/voice/PlayVoiceBntNew$PLAY_TYPE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2026038917, "Lcom/baidu/tieba/tbadkCore/voice/PlayVoiceBntNew$PLAY_TYPE;");
                    return;
                }
            }
            NORMAL = new PLAY_TYPE("NORMAL", 0);
            PLAY_TYPE play_type = new PLAY_TYPE("REPLY", 1);
            REPLY = play_type;
            $VALUES = new PLAY_TYPE[]{NORMAL, play_type};
        }

        public PLAY_TYPE(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PLAY_TYPE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PLAY_TYPE) Enum.valueOf(PLAY_TYPE.class, str) : (PLAY_TYPE) invokeL.objValue;
        }

        public static PLAY_TYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PLAY_TYPE[]) $VALUES.clone() : (PLAY_TYPE[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-197030426, "Lcom/baidu/tieba/tbadkCore/voice/PlayVoiceBntNew;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-197030426, "Lcom/baidu/tieba/tbadkCore/voice/PlayVoiceBntNew;");
                return;
            }
        }
        l = ((mi.k(TbadkCoreApplication.getInst()) - (mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, play_type};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = 0;
        play_type.ordinal();
        h(context);
    }

    private int getAudioVoiceColumnCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            VoiceData.VoiceModel voiceModel = getVoiceModel();
            if (voiceModel == null) {
                return 0;
            }
            return g(voiceModel) / 10;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (!j()) {
                m(1);
                return;
            }
            l(i);
            VoiceData.VoiceModel voiceModel = this.a;
            if (voiceModel != null) {
                voiceModel.elapse = i;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void b(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) || voiceModel == null) {
            return;
        }
        if (this.a != voiceModel) {
            m(1);
        } else {
            m(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f.e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
            gs4 d = gs4.d(this.b);
            d.n(R.string.J_X05);
            d.l(R.dimen.L_X03);
            d.k(R.color.CAM_X0302);
            d.f(R.color.CAM_X0201);
        }
    }

    public final void f(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (imageView = this.c) == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08090b, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08090c, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        }
    }

    public final int g(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        double d;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, voiceModel)) == null) {
            int i2 = voiceModel.duration;
            if (i2 < 10) {
                d = l * 0.6d;
            } else {
                if (i2 < 30) {
                    i = l;
                } else if (i2 < 60) {
                    i = l;
                } else {
                    d = l * 2;
                }
                d = i * 0.6d * 2.0d;
            }
            if (d < mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
                d = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds216);
            }
            double f = (d - this.j) - mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds75);
            if (f > 0.0d) {
                return (int) f;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public ImageView getImgStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (ImageView) invokeV.objValue;
    }

    public TextView getPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).getRealView(this.a);
            }
            return ((f9.a(getContext()) instanceof b9) && (tbPageContext = (TbPageContext) f9.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) ? ((VoiceManager.j) tbPageContext.getOrignalPage()).getRealView(this.a) : this;
        }
        return (VoiceManager.i) invokeV.objValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).getVoiceManager();
            }
            if ((f9.a(getContext()) instanceof b9) && (tbPageContext = (TbPageContext) f9.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
            }
            return this.k;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData.VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : (VoiceData.VoiceModel) invokeV.objValue;
    }

    public RelativeLayout getmVoiceImageContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.b : (RelativeLayout) invokeV.objValue;
    }

    public void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            i(context);
            setOnClickListener(this);
        }
    }

    public void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06e0, (ViewGroup) this, true);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09242e);
            this.b = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f0918b6);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0918a8);
            this.f = (AudioAnimationView) findViewById(R.id.obfuscated_res_0x7f0902cc);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091975);
            this.e = progressBar;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
            this.g = context;
            e();
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.a == null) {
                return false;
            }
            VoiceManager voiceManager = getVoiceManager();
            return voiceManager == null || voiceManager.isPlayDoing(this.a);
        }
        return invokeV.booleanValue;
    }

    public void k(View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) || (relativeLayout = this.b) == null) {
            return;
        }
        relativeLayout.setOnClickListener(onClickListener);
    }

    public void l(int i) {
        VoiceData.VoiceModel voiceModel;
        String formatVoiceTime;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (voiceModel = this.a) == null || this.d == null) {
            return;
        }
        int i3 = i / 1000;
        if (i3 > 0 && i3 < (i2 = voiceModel.duration)) {
            formatVoiceTime = VoiceManager.formatVoiceTime(i2 - i3);
        } else {
            formatVoiceTime = VoiceManager.formatVoiceTime(this.a.duration);
        }
        String charSequence2String = li.charSequence2String(this.d.getText(), null);
        if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
            this.d.setText(formatVoiceTime);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (i == 3) {
                this.e.setVisibility(4);
                f(true);
                this.f.setVisibility(0);
                this.f.g();
                return;
            }
            this.f.setCertainColumnCount(getAudioVoiceColumnCount());
            this.f.f();
            this.f.setVisibility(4);
            if (w55.b().d()) {
                w55.b().n(false);
                w55.b().l(false);
            }
            f(false);
            if (i == 1) {
                VoiceData.VoiceModel voiceModel = this.a;
                if (voiceModel != null) {
                    this.d.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                }
                this.e.setVisibility(4);
            } else if (i == 2) {
                VoiceData.VoiceModel voiceModel2 = this.a;
                if (voiceModel2 != null) {
                    this.d.setText(VoiceManager.formatVoiceTime(voiceModel2.duration));
                }
                this.e.setVisibility(0);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a = null;
            setTag(null);
            m(1);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams.width = -2;
            this.f.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, view2) == null) && this.a != null && view2 == this.b) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            View.OnClickListener onClickListener = this.i;
            if (onClickListener != null) {
                onClickListener.onClick(this);
            }
            TiebaStatic.log(this.a.from);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i, str) == null) {
            mi.K(getContext(), str);
        }
    }

    public void q() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.a == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void setPlayTimeTextView(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i) == null) || (textView = this.d) == null) {
            return;
        }
        textView.setTextSize(0, mi.f(getContext(), i));
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, obj) == null) {
            if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
                TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
                VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.A();
                if (voiceModel == null) {
                    voiceModel = new VoiceData.VoiceModel();
                    if (tbRichTextVoiceInfo.y() == 0) {
                        voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                    } else {
                        voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                    }
                    voiceModel.voiceId = tbRichTextVoiceInfo.z();
                    voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                    tbRichTextVoiceInfo.B(voiceModel);
                }
                tbRichTextVoiceInfo.y();
                setVoiceModel(voiceModel);
                d();
                obj = voiceModel;
            }
            super.setTag(obj);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, voiceManager) == null) {
            this.k = voiceManager;
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, voiceModel) == null) {
            requestLayout();
            this.a = voiceModel;
            if (voiceModel == null) {
                return;
            }
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                l(this.a.elapse);
                return;
            }
            m(this.a.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            int measureText = (int) this.d.getPaint().measureText(formatVoiceTime);
            this.h = measureText;
            this.j = measureText + mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.f.setCertainColumnCount(getAudioVoiceColumnCount());
            this.f.f();
            this.b.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.j, getPaddingBottom());
            this.d.setText(formatVoiceTime);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0404da});
        obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        h(context);
    }
}
