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
import c.a.d.a.f;
import c.a.d.a.j;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.j0.g.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class PlayVoiceBnt extends RelativeLayout implements VoiceManager.i, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f48232e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceData$VoiceModel f48233f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f48234g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f48235h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f48236i;

    /* renamed from: j  reason: collision with root package name */
    public Context f48237j;
    public View.OnClickListener k;
    public AnimationDrawable l;
    public VoiceManager m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
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

        public PLAY_TYPE(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
    public PlayVoiceBnt(Context context, PLAY_TYPE play_type) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, play_type};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48232e = 0;
        this.f48232e = play_type.ordinal();
        init(context);
    }

    private int getBtnWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            VoiceData$VoiceModel voiceModel = getVoiceModel();
            if (voiceModel == null) {
                return -1;
            }
            int i2 = voiceModel.duration;
            int k = n.k(getContext());
            if (i2 > 10) {
                if (i2 <= 30) {
                    float f2 = k;
                    int i3 = (int) (0.3f * f2);
                    return i3 + (((i2 - 10) * (((int) (f2 * 0.45f)) - i3)) / 20);
                }
                return (int) (k * 0.45f);
            }
            float f3 = k;
            int i4 = (int) (0.18f * f3);
            int i5 = (int) (f3 * 0.3f);
            if (i2 < 5) {
                i2 = 4;
            }
            return i4 + (((i2 - 1) * (i5 - i4)) / 10);
        }
        return invokeV.intValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.f48232e == 0) {
                int i2 = skinType != 1 ? -13553101 : -6574132;
                SkinManager.setBackgroundResource(this, R.drawable.but_thread_voice_selector);
                TextView textView = this.f48235h;
                if (textView != null) {
                    textView.setTextSize(0, this.f48237j.getResources().getDimension(R.dimen.ds36));
                    this.f48235h.setTextColor(i2);
                }
                ImageView imageView = this.f48234g;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.anim.voice_btn_play_anim);
                    this.f48234g.setPadding(n.d(getContext(), 12.0f), 0, 0, 0);
                }
            } else {
                int i3 = skinType != 1 ? -16777216 : -8682095;
                SkinManager.setBackgroundResource(this, R.drawable.but_thread_voice_reply_selector);
                TextView textView2 = this.f48235h;
                if (textView2 != null) {
                    textView2.setTextSize(0, this.f48237j.getResources().getDimension(R.dimen.ds28));
                    this.f48235h.setTextColor(i3);
                }
                ImageView imageView2 = this.f48234g;
                if (imageView2 != null) {
                    SkinManager.setImageResource(imageView2, R.anim.voice_btn_play_anim);
                    this.f48234g.setPadding(n.d(getContext(), 8.0f), 0, 0, 0);
                }
            }
            ImageView imageView3 = this.f48234g;
            if (imageView3 == null || !(imageView3.getDrawable() instanceof AnimationDrawable)) {
                return;
            }
            ((AnimationDrawable) this.f48234g.getDrawable()).stop();
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f48233f == null) {
                return false;
            }
            VoiceManager voiceManager = getVoiceManager();
            return voiceManager == null || voiceManager.isPlayDoing(this.f48233f);
        }
        return invokeV.booleanValue;
    }

    public final int c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824) {
                return Math.max(size, i3);
            }
            return Math.min(size, i3);
        }
        return invokeII.intValue;
    }

    public void changeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a();
        }
    }

    public final void d() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.f48232e == 0) {
                i2 = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
            } else {
                i2 = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
            }
            ImageView imageView = this.f48234g;
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AnimationDrawable animationDrawable = this.l;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            d();
            AnimationDrawable animationDrawable2 = (AnimationDrawable) this.f48234g.getDrawable();
            this.l = animationDrawable2;
            animationDrawable2.start();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbadkCoreApplication.getInst().getSkinType();
            ImageView imageView = this.f48234g;
            if (imageView != null) {
                if (this.f48232e == 0) {
                    SkinManager.setImageResource(imageView, R.drawable.icon_thread_voice_reply_curve_three);
                } else {
                    SkinManager.setImageResource(imageView, R.drawable.icon_thread_voice_reply_curve_three);
                }
            }
        }
    }

    public int[] getDefinedWH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int[] iArr = {0, 0};
            if (this.f48232e == 0) {
                iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds184);
                iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds86);
            } else {
                iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds150);
                iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds76);
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
                return ((VoiceManager.j) context).getRealView(this.f48233f);
            }
            return ((j.a(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) ? ((VoiceManager.j) tbPageContext.getOrignalPage()).getRealView(this.f48233f) : this;
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
                return ((VoiceManager.j) context).getVoiceManager();
            }
            if ((j.a(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
            }
            return this.m;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData$VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f48233f : (VoiceData$VoiceModel) invokeV.objValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            initComponents(context);
            setOnClickListener(this);
        }
    }

    public void initComponents(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
            this.f48234g = (ImageView) findViewById(R.id.playingImg);
            this.f48235h = (TextView) findViewById(R.id.playTime);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
            this.f48236i = progressBar;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
            this.f48237j = context;
            a();
            setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || this.f48233f == null) {
            return;
        }
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null) {
            voiceManager.setAllowChangeVoiceMode(true);
            voiceManager.startPlay(this);
        }
        View.OnClickListener onClickListener = this.k;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        TiebaStatic.log(this.f48233f.from);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(c(i2, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayElapse(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (!b()) {
                refreshViewState(1);
                return;
            }
            if (this.l == null) {
                refreshViewState(this.f48233f.voice_status.intValue());
            }
            refreshPlayTime(i2);
            VoiceData$VoiceModel voiceData$VoiceModel = this.f48233f;
            if (voiceData$VoiceModel != null) {
                voiceData$VoiceModel.elapse = i2;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onRefreshByPlayStatus(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, voiceData$VoiceModel) == null) || voiceData$VoiceModel == null) {
            return;
        }
        if (this.f48233f != voiceData$VoiceModel) {
            refreshViewState(1);
        } else {
            refreshViewState(voiceData$VoiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onShowErr(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, str) == null) {
            n.K(getContext(), str);
        }
    }

    public void refreshPlayTime(int i2) {
        VoiceData$VoiceModel voiceData$VoiceModel;
        String formatVoiceTime;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (voiceData$VoiceModel = this.f48233f) == null || this.f48235h == null) {
            return;
        }
        int i4 = i2 / 1000;
        if (i4 > 0 && i4 < (i3 = voiceData$VoiceModel.duration)) {
            formatVoiceTime = VoiceManager.formatVoiceTime(i3 - i4);
        } else {
            formatVoiceTime = VoiceManager.formatVoiceTime(this.f48233f.duration);
        }
        String charSequence2String = m.charSequence2String(this.f48235h.getText(), null);
        if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
            this.f48235h.setText(formatVoiceTime);
        }
    }

    public void refreshViewState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 3) {
                ImageView imageView = this.f48234g;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                this.f48236i.setVisibility(4);
                e();
                return;
            }
            stopVoiceAnimation();
            if (c.b().d()) {
                c.b().n(false);
                c.b().l(false);
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    VoiceData$VoiceModel voiceData$VoiceModel = this.f48233f;
                    if (voiceData$VoiceModel != null) {
                        this.f48235h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration));
                    }
                    this.f48236i.setVisibility(0);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.f48234g;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            VoiceData$VoiceModel voiceData$VoiceModel2 = this.f48233f;
            if (voiceData$VoiceModel2 != null) {
                this.f48235h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel2.duration));
            }
            this.f48236i.setVisibility(4);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f48233f = null;
            setTag(null);
            refreshViewState(1);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.k = onClickListener;
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, obj) == null) {
            if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
                TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
                VoiceData$VoiceModel voiceData$VoiceModel = (VoiceData$VoiceModel) tbRichTextVoiceInfo.y();
                if (voiceData$VoiceModel == null) {
                    voiceData$VoiceModel = new VoiceData$VoiceModel();
                    if (tbRichTextVoiceInfo.w() == 0) {
                        voiceData$VoiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                    } else {
                        voiceData$VoiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                    }
                    voiceData$VoiceModel.voiceId = tbRichTextVoiceInfo.x();
                    voiceData$VoiceModel.duration = tbRichTextVoiceInfo.getDuration();
                    tbRichTextVoiceInfo.z(voiceData$VoiceModel);
                }
                this.f48232e = tbRichTextVoiceInfo.w();
                setVoiceModel(voiceData$VoiceModel);
                a();
                obj = voiceData$VoiceModel;
            }
            super.setTag(obj);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, voiceManager) == null) {
            this.m = voiceManager;
        }
    }

    public void setVoiceModel(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, voiceData$VoiceModel) == null) {
            requestLayout();
            this.f48233f = voiceData$VoiceModel;
            if (voiceData$VoiceModel == null) {
                return;
            }
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceData$VoiceModel)) {
                voiceManager.resetPlayView(this);
                refreshPlayTime(this.f48233f.elapse);
                return;
            }
            refreshViewState(this.f48233f.voice_status.intValue());
            this.f48235h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration));
        }
    }

    public void stopCurrentPlay() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f48233f == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void stopVoiceAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            Drawable drawable = this.f48234g.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                this.l = (AnimationDrawable) drawable;
            }
            AnimationDrawable animationDrawable = this.l;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            this.l = null;
            f();
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
        this.f48232e = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Voice_play_type);
        this.f48232e = obtainStyledAttributes.getInteger(R$styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }
}
