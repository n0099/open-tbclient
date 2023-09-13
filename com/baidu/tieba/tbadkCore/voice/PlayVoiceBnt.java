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
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.bka;
import com.baidu.tieba.cq5;
import com.baidu.tieba.ei;
import com.baidu.tieba.m9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PlayVoiceBnt extends RelativeLayout implements VoiceManager.IPlayView, View.OnClickListener {
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

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onPlayPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (PLAY_TYPE) Enum.valueOf(PLAY_TYPE.class, str);
            }
            return (PLAY_TYPE) invokeL.objValue;
        }

        public static PLAY_TYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (PLAY_TYPE[]) $VALUES.clone();
            }
            return (PLAY_TYPE[]) invokeV.objValue;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, bka.Voice_play_type);
        this.a = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        b(context);
    }

    private int getBtnWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            VoiceData.VoiceModel voiceModel = getVoiceModel();
            if (voiceModel == null) {
                return -1;
            }
            int duration = voiceModel.getDuration();
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext());
            if (duration <= 10) {
                float f = equipmentWidth;
                int i = (int) (0.18f * f);
                int i2 = (int) (f * 0.3f);
                if (duration < 5) {
                    duration = 4;
                }
                return i + (((duration - 1) * (i2 - i)) / 10);
            } else if (duration <= 30) {
                float f2 = equipmentWidth;
                int i3 = (int) (0.3f * f2);
                return i3 + (((duration - 10) * (((int) (f2 * 0.45f)) - i3)) / 20);
            } else {
                return (int) (equipmentWidth * 0.45f);
            }
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public VoiceManager.IPlayView getRealView() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).r1(this.b);
            }
            if ((m9.a(getContext()) instanceof BdPageContext) && (tbPageContext = (TbPageContext) m9.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).r1(this.b);
            }
            return this;
        }
        return (VoiceManager.IPlayView) invokeV.objValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).H0();
            }
            if ((m9.a(getContext()) instanceof BdPageContext) && (tbPageContext = (TbPageContext) m9.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).H0();
            }
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().getSkinType();
            if (this.a == 0) {
                SkinManager.setBackgroundResource(this, R.drawable.but_thread_voice_selector);
                TextView textView = this.d;
                if (textView != null) {
                    textView.setTextSize(0, this.f.getResources().getDimension(R.dimen.obfuscated_res_0x7f070215));
                    this.d.setTextColor(-13553101);
                }
                ImageView imageView = this.c;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.anim.voice_btn_play_anim);
                    this.c.setPadding(BdUtilHelper.dip2px(getContext(), 12.0f), 0, 0, 0);
                }
            } else {
                SkinManager.setBackgroundResource(this, R.drawable.but_thread_voice_reply_selector);
                TextView textView2 = this.d;
                if (textView2 != null) {
                    textView2.setTextSize(0, this.f.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f9));
                    this.d.setTextColor(-16777216);
                }
                ImageView imageView2 = this.c;
                if (imageView2 != null) {
                    SkinManager.setImageResource(imageView2, R.anim.voice_btn_play_anim);
                    this.c.setPadding(BdUtilHelper.dip2px(getContext(), 8.0f), 0, 0, 0);
                }
            }
            ImageView imageView3 = this.c;
            if (imageView3 != null && (imageView3.getDrawable() instanceof AnimationDrawable)) {
                ((AnimationDrawable) this.c.getDrawable()).stop();
            }
        }
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            c(context);
            setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, view2) == null) && this.b != null) {
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
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onRefreshByPlayStatus(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, voiceModel) != null) || voiceModel == null) {
            return;
        }
        if (this.b != voiceModel) {
            g(1);
        } else {
            g(voiceModel.voice_status.intValue());
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, voiceManager) == null) {
            this.i = voiceManager;
        }
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ced);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091cda);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091dad);
            this.e = progressBar;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
            this.f = context;
            a();
            setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
        }
    }

    public void f(int i) {
        VoiceData.VoiceModel voiceModel;
        String formatVoiceTime;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (voiceModel = this.b) != null && this.d != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < voiceModel.getDuration()) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.b.getDuration() - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.b.getDuration());
            }
            String charSequence2String = ei.charSequence2String(this.d.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.d.setText(formatVoiceTime);
            }
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, obj) == null) {
            if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
                TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
                VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.O();
                if (voiceModel == null) {
                    voiceModel = new VoiceData.VoiceModel();
                    if (tbRichTextVoiceInfo.M() == 0) {
                        voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                    } else {
                        voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                    }
                    voiceModel.setVoiceId(tbRichTextVoiceInfo.N());
                    voiceModel.setDuration(tbRichTextVoiceInfo.getDuration());
                    tbRichTextVoiceInfo.P(voiceModel);
                }
                this.a = tbRichTextVoiceInfo.M();
                setVoiceModel(voiceModel);
                a();
                obj = voiceModel;
            }
            super.setTag(obj);
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
                f(this.b.elapse);
                return;
            }
            g(this.b.voice_status.intValue());
            this.d.setText(VoiceManager.formatVoiceTime(voiceModel.getDuration()));
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b == null) {
                return false;
            }
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && !voiceManager.isPlayDoing(this.b)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public VoiceData.VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (VoiceData.VoiceModel) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b = null;
            setTag(null);
            g(1);
        }
    }

    public final void i() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (imageView = this.c) != null) {
            imageView.setImageResource(R.anim.voice_btn_play_anim);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            AnimationDrawable animationDrawable = this.h;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            i();
            AnimationDrawable animationDrawable2 = (AnimationDrawable) this.c.getDrawable();
            this.h = animationDrawable2;
            animationDrawable2.start();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Drawable drawable = this.c.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                this.h = (AnimationDrawable) drawable;
            }
            AnimationDrawable animationDrawable = this.h;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            this.h = null;
            k();
        }
    }

    public final int e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == 1073741824) {
                return Math.max(size, i2);
            }
            return Math.min(size, i2);
        }
        return invokeII.intValue;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(e(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i, str) == null) {
            BdUtilHelper.showLongToast(getContext(), str);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i == 3) {
                ImageView imageView = this.c;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                this.e.setVisibility(4);
                j();
                return;
            }
            l();
            if (cq5.b().d()) {
                cq5.b().n(false);
                cq5.b().l(false);
            }
            if (i == 1) {
                ImageView imageView2 = this.c;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                VoiceData.VoiceModel voiceModel = this.b;
                if (voiceModel != null) {
                    this.d.setText(VoiceManager.formatVoiceTime(voiceModel.getDuration()));
                }
                this.e.setVisibility(4);
            } else if (i == 2) {
                VoiceData.VoiceModel voiceModel2 = this.b;
                if (voiceModel2 != null) {
                    this.d.setText(VoiceManager.formatVoiceTime(voiceModel2.getDuration()));
                }
                this.e.setVisibility(0);
            }
        }
    }

    public int[] getDefinedWH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int[] iArr = {0, 0};
            if (this.a == 0) {
                iArr[0] = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07038b);
                iArr[1] = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070423);
            } else {
                iArr[0] = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070379);
                iArr[1] = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07026f);
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onPlayElapse(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (!d()) {
                g(1);
                return;
            }
            if (this.h == null) {
                g(this.b.voice_status.intValue());
            }
            f(i);
            VoiceData.VoiceModel voiceModel = this.b;
            if (voiceModel != null) {
                voiceModel.elapse = i;
            }
        }
    }
}
