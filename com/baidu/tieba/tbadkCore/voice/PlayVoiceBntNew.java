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
import c.a.d.a.f;
import c.a.d.a.j;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.v.c;
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
/* loaded from: classes6.dex */
public class PlayVoiceBntNew extends RelativeLayout implements VoiceManager.i, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public VoiceData.VoiceModel a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f36194b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36195c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36196d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f36197e;

    /* renamed from: f  reason: collision with root package name */
    public AudioAnimationView f36198f;

    /* renamed from: g  reason: collision with root package name */
    public Context f36199g;

    /* renamed from: h  reason: collision with root package name */
    public int f36200h;
    public View.OnClickListener i;
    public float j;
    public VoiceManager k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
        l = ((n.k(TbadkCoreApplication.getInst()) - (n.f(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
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
        this.f36200h = 0;
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f36198f.e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void c(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voiceModel) == null) || voiceModel == null) {
            return;
        }
        if (this.a != voiceModel) {
            m(1);
        } else {
            m(voiceModel.voice_status.intValue());
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b();
            SkinManager.setViewTextColor(this.f36196d, (int) R.color.CAM_X0302);
            c d2 = c.d(this.f36194b);
            d2.n(R.string.J_X05);
            d2.l(R.dimen.L_X03);
            d2.k(R.color.CAM_X0302);
            d2.f(R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final void f(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (imageView = this.f36195c) == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0808f3, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0808f4, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        }
    }

    public final int g(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        double d2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, voiceModel)) == null) {
            int i2 = voiceModel.duration;
            if (i2 < 10) {
                d2 = l * 0.6d;
            } else {
                if (i2 < 30) {
                    i = l;
                } else if (i2 < 60) {
                    i = l;
                } else {
                    d2 = l * 2;
                }
                d2 = i * 0.6d * 2.0d;
            }
            if (d2 < n.f(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
                d2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds216);
            }
            double f2 = (d2 - this.j) - n.f(TbadkCoreApplication.getInst(), R.dimen.tbds75);
            if (f2 > 0.0d) {
                return (int) f2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public ImageView getImgStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36195c : (ImageView) invokeV.objValue;
    }

    public TextView getPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f36196d : (TextView) invokeV.objValue;
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
            return ((j.a(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) ? ((VoiceManager.j) tbPageContext.getOrignalPage()).getRealView(this.a) : this;
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
            if ((j.a(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36194b : (RelativeLayout) invokeV.objValue;
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06eb, (ViewGroup) this, true);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f092401);
            this.f36194b = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.f36195c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091862);
            this.f36196d = (TextView) findViewById(R.id.obfuscated_res_0x7f091854);
            this.f36198f = (AudioAnimationView) findViewById(R.id.obfuscated_res_0x7f0902cb);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091929);
            this.f36197e = progressBar;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
            this.f36199g = context;
            d();
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
        if (!(interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) || (relativeLayout = this.f36194b) == null) {
            return;
        }
        relativeLayout.setOnClickListener(onClickListener);
    }

    public void l(int i) {
        VoiceData.VoiceModel voiceModel;
        String formatVoiceTime;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (voiceModel = this.a) == null || this.f36196d == null) {
            return;
        }
        int i3 = i / 1000;
        if (i3 > 0 && i3 < (i2 = voiceModel.duration)) {
            formatVoiceTime = VoiceManager.formatVoiceTime(i2 - i3);
        } else {
            formatVoiceTime = VoiceManager.formatVoiceTime(this.a.duration);
        }
        String charSequence2String = m.charSequence2String(this.f36196d.getText(), null);
        if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
            this.f36196d.setText(formatVoiceTime);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (i == 3) {
                this.f36197e.setVisibility(4);
                f(true);
                this.f36198f.setVisibility(0);
                this.f36198f.g();
                return;
            }
            this.f36198f.setCertainColumnCount(getAudioVoiceColumnCount());
            this.f36198f.f();
            this.f36198f.setVisibility(4);
            if (c.a.o0.i0.g.c.b().d()) {
                c.a.o0.i0.g.c.b().n(false);
                c.a.o0.i0.g.c.b().l(false);
            }
            f(false);
            if (i == 1) {
                VoiceData.VoiceModel voiceModel = this.a;
                if (voiceModel != null) {
                    this.f36196d.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                }
                this.f36197e.setVisibility(4);
            } else if (i == 2) {
                VoiceData.VoiceModel voiceModel2 = this.a;
                if (voiceModel2 != null) {
                    this.f36196d.setText(VoiceManager.formatVoiceTime(voiceModel2.duration));
                }
                this.f36197e.setVisibility(0);
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f36198f.getLayoutParams();
            layoutParams.width = -2;
            this.f36198f.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, view) == null) && this.a != null && view == this.f36194b) {
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
            n.K(getContext(), str);
        }
    }

    public void p() {
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
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i) == null) || (textView = this.f36196d) == null) {
            return;
        }
        textView.setTextSize(0, n.f(getContext(), i));
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
                b();
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
            int measureText = (int) this.f36196d.getPaint().measureText(formatVoiceTime);
            this.f36200h = measureText;
            this.j = measureText + n.f(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.f36198f.setCertainColumnCount(getAudioVoiceColumnCount());
            this.f36198f.f();
            this.f36194b.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.j, getPaddingBottom());
            this.f36196d.setText(formatVoiceTime);
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
        this.f36200h = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040497});
        obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        h(context);
    }
}
