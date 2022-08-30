package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.d9;
import com.baidu.tieba.i9;
import com.baidu.tieba.m75;
import com.baidu.tieba.qi;
import com.baidu.tieba.ri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PlayVoiceBnt extends RelativeLayout implements VoiceManager.i, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public VoiceData.VoiceModel b;
    public ImageView c;
    public TextView d;
    public ProgressBar e;
    public Context f;
    public View.OnClickListener g;
    public AnimationDrawable h;
    public VoiceManager i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class PLAY_TYPE {
        public static final /* synthetic */ PLAY_TYPE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PLAY_TYPE NORMAL;
        public static final PLAY_TYPE REPLY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1708215567, "Lcom/baidu/tieba/tbadkCore/voice/PlayVoiceBnt$PLAY_TYPE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1708215567, "Lcom/baidu/tieba/tbadkCore/voice/PlayVoiceBnt$PLAY_TYPE;");
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
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
        this.a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040559});
        this.a = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        e(context);
    }

    private int getBtnWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            VoiceData.VoiceModel voiceModel = getVoiceModel();
            if (voiceModel == null) {
                return -1;
            }
            int i = voiceModel.duration;
            int k = ri.k(getContext());
            if (i > 10) {
                if (i <= 30) {
                    float f = k;
                    int i2 = (int) (0.3f * f);
                    return i2 + (((i - 10) * (((int) (f * 0.45f)) - i2)) / 20);
                }
                return (int) (k * 0.45f);
            }
            float f2 = k;
            int i3 = (int) (0.18f * f2);
            int i4 = (int) (f2 * 0.3f);
            if (i < 5) {
                i = 4;
            }
            return i3 + (((i - 1) * (i4 - i3)) / 10);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (!g()) {
                j(1);
                return;
            }
            if (this.h == null) {
                j(this.b.voice_status.intValue());
            }
            i(i);
            VoiceData.VoiceModel voiceModel = this.b;
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
        if (this.b != voiceModel) {
            j(1);
        } else {
            j(voiceModel.voice_status.intValue());
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
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.a == 0) {
                int i = skinType != 1 ? -13553101 : -6574132;
                SkinManager.setBackgroundResource(this, R.drawable.but_thread_voice_selector);
                TextView textView = this.d;
                if (textView != null) {
                    textView.setTextSize(0, this.f.getResources().getDimension(R.dimen.obfuscated_res_0x7f070215));
                    this.d.setTextColor(i);
                }
                ImageView imageView = this.c;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.anim.obfuscated_res_0x7f010148);
                    this.c.setPadding(ri.d(getContext(), 12.0f), 0, 0, 0);
                }
            } else {
                int i2 = skinType != 1 ? -16777216 : -8682095;
                SkinManager.setBackgroundResource(this, R.drawable.but_thread_voice_reply_selector);
                TextView textView2 = this.d;
                if (textView2 != null) {
                    textView2.setTextSize(0, this.f.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f9));
                    this.d.setTextColor(i2);
                }
                ImageView imageView2 = this.c;
                if (imageView2 != null) {
                    SkinManager.setImageResource(imageView2, R.anim.obfuscated_res_0x7f010148);
                    this.c.setPadding(ri.d(getContext(), 8.0f), 0, 0, 0);
                }
            }
            ImageView imageView3 = this.c;
            if (imageView3 == null || !(imageView3.getDrawable() instanceof AnimationDrawable)) {
                return;
            }
            ((AnimationDrawable) this.c.getDrawable()).stop();
        }
    }

    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            f(context);
            setOnClickListener(this);
        }
    }

    public void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0721, (ViewGroup) this, true);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f0919ba);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0919ab);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091a7a);
            this.e = progressBar;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
            this.f = context;
            d();
            setContentDescription(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b00));
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.b == null) {
                return false;
            }
            VoiceManager voiceManager = getVoiceManager();
            return voiceManager == null || voiceManager.isPlayDoing(this.b);
        }
        return invokeV.booleanValue;
    }

    public int[] getDefinedWH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int[] iArr = {0, 0};
            if (this.a == 0) {
                iArr[0] = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070262);
                iArr[1] = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070305);
            } else {
                iArr[0] = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07024d);
                iArr[1] = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07026f);
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).e1(this.b);
            }
            return ((i9.a(getContext()) instanceof d9) && (tbPageContext = (TbPageContext) i9.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) ? ((VoiceManager.j) tbPageContext.getOrignalPage()).e1(this.b) : this;
        }
        return (VoiceManager.i) invokeV.objValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).t0();
            }
            if ((i9.a(getContext()) instanceof d9) && (tbPageContext = (TbPageContext) i9.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).t0();
            }
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData.VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (VoiceData.VoiceModel) invokeV.objValue;
    }

    public final int h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == 1073741824) {
                return Math.max(size, i2);
            }
            return Math.min(size, i2);
        }
        return invokeII.intValue;
    }

    public void i(int i) {
        VoiceData.VoiceModel voiceModel;
        String formatVoiceTime;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (voiceModel = this.b) == null || this.d == null) {
            return;
        }
        int i3 = i / 1000;
        if (i3 > 0 && i3 < (i2 = voiceModel.duration)) {
            formatVoiceTime = VoiceManager.formatVoiceTime(i2 - i3);
        } else {
            formatVoiceTime = VoiceManager.formatVoiceTime(this.b.duration);
        }
        String charSequence2String = qi.charSequence2String(this.d.getText(), null);
        if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
            this.d.setText(formatVoiceTime);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i == 3) {
                ImageView imageView = this.c;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                this.e.setVisibility(4);
                m();
                return;
            }
            o();
            if (m75.b().d()) {
                m75.b().n(false);
                m75.b().l(false);
            }
            if (i != 1) {
                if (i == 2) {
                    VoiceData.VoiceModel voiceModel = this.b;
                    if (voiceModel != null) {
                        this.d.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    }
                    this.e.setVisibility(0);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.c;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            VoiceData.VoiceModel voiceModel2 = this.b;
            if (voiceModel2 != null) {
                this.d.setText(VoiceManager.formatVoiceTime(voiceModel2.duration));
            }
            this.e.setVisibility(4);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b = null;
            setTag(null);
            j(1);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i = this.a;
            int i2 = R.anim.obfuscated_res_0x7f010148;
            if (i != 0 ? skinType == 1 : skinType == 1) {
                i2 = R.anim.obfuscated_res_0x7f010149;
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            AnimationDrawable animationDrawable = this.h;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            l();
            AnimationDrawable animationDrawable2 = (AnimationDrawable) this.c.getDrawable();
            this.h = animationDrawable2;
            animationDrawable2.start();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TbadkCoreApplication.getInst().getSkinType();
            ImageView imageView = this.c;
            if (imageView != null) {
                if (this.a == 0) {
                    SkinManager.setImageResource(imageView, R.drawable.icon_thread_voice_reply_curve_three);
                } else {
                    SkinManager.setImageResource(imageView, R.drawable.icon_thread_voice_reply_curve_three);
                }
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Drawable drawable = this.c.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                this.h = (AnimationDrawable) drawable;
            }
            AnimationDrawable animationDrawable = this.h;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            this.h = null;
            n();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, view2) == null) || this.b == null) {
            return;
        }
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null) {
            voiceManager.setAllowChangeVoiceMode(true);
            voiceManager.startPlay(this);
        }
        View.OnClickListener onClickListener = this.g;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
        TiebaStatic.log(this.b.from);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(h(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i, str) == null) {
            ri.K(getContext(), str);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, obj) == null) {
            if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
                TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
                VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.B();
                if (voiceModel == null) {
                    voiceModel = new VoiceData.VoiceModel();
                    if (tbRichTextVoiceInfo.z() == 0) {
                        voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                    } else {
                        voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                    }
                    voiceModel.voiceId = tbRichTextVoiceInfo.A();
                    voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                    tbRichTextVoiceInfo.C(voiceModel);
                }
                this.a = tbRichTextVoiceInfo.z();
                setVoiceModel(voiceModel);
                d();
                obj = voiceModel;
            }
            super.setTag(obj);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, voiceManager) == null) {
            this.i = voiceManager;
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, voiceModel) == null) {
            requestLayout();
            this.b = voiceModel;
            if (voiceModel == null) {
                return;
            }
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                i(this.b.elapse);
                return;
            }
            j(this.b.voice_status.intValue());
            this.d.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }
}
