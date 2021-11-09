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
import b.a.e.a.f;
import b.a.e.a.j;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.s.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PlayVoiceBntNew extends RelativeLayout implements VoiceManager.i, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public VoiceData$VoiceModel f54294e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f54295f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54296g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54297h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f54298i;
    public AudioAnimationView j;
    public Context k;
    public int l;
    public View.OnClickListener m;
    public float n;
    public VoiceManager o;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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
        p = ((l.k(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = 0;
        play_type.ordinal();
        init(context);
    }

    private int getAudioVoiceColumnCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            VoiceData$VoiceModel voiceModel = getVoiceModel();
            if (voiceModel == null) {
                return 0;
            }
            return c(voiceModel) / 10;
        }
        return invokeV.intValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void b(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (imageView = this.f54296g) == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_common_voice_pause16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_common_voice_play16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        }
    }

    public final int c(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        double d2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voiceData$VoiceModel)) == null) {
            int i3 = voiceData$VoiceModel.duration;
            if (i3 < 10) {
                d2 = p * 0.6d;
            } else {
                if (i3 < 30) {
                    i2 = p;
                } else if (i3 < 60) {
                    i2 = p;
                } else {
                    d2 = p * 2;
                }
                d2 = i2 * 0.6d * 2.0d;
            }
            if (d2 < l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
                d2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216);
            }
            double g2 = (d2 - this.n) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds75);
            if (g2 > 0.0d) {
                return (int) g2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void changeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a();
            SkinManager.setViewTextColor(this.f54297h, R.color.CAM_X0302);
            c d2 = c.d(this.f54295f);
            d2.n(R.string.J_X05);
            d2.l(R.dimen.L_X03);
            d2.k(R.color.CAM_X0302);
            d2.f(R.color.CAM_X0201);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f54294e == null) {
                return false;
            }
            VoiceManager voiceManager = getVoiceManager();
            return voiceManager == null || voiceManager.isPlayDoing(this.f54294e);
        }
        return invokeV.booleanValue;
    }

    public ImageView getImgStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f54296g : (ImageView) invokeV.objValue;
    }

    public TextView getPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f54297h : (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).getRealView(this.f54294e);
            }
            return ((j.a(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) ? ((VoiceManager.j) tbPageContext.getOrignalPage()).getRealView(this.f54294e) : this;
        }
        return (VoiceManager.i) invokeV.objValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).getVoiceManager();
            }
            if ((j.a(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
            }
            return this.o;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData$VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f54294e : (VoiceData$VoiceModel) invokeV.objValue;
    }

    public RelativeLayout getmVoiceImageContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f54295f : (RelativeLayout) invokeV.objValue;
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
            LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.voice_image_content);
            this.f54295f = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.f54296g = (ImageView) findViewById(R.id.playingImg);
            this.f54297h = (TextView) findViewById(R.id.playTime);
            this.j = (AudioAnimationView) findViewById(R.id.audioAnimationView);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
            this.f54298i = progressBar;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
            this.k = context;
            changeSkin();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view) == null) && this.f54294e != null && view == this.f54295f) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                onClickListener.onClick(this);
            }
            TiebaStatic.log(this.f54294e.from);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayElapse(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (!d()) {
                refreshViewState(1);
                return;
            }
            refreshPlayTime(i2);
            VoiceData$VoiceModel voiceData$VoiceModel = this.f54294e;
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
        if (this.f54294e != voiceData$VoiceModel) {
            refreshViewState(1);
        } else {
            refreshViewState(voiceData$VoiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onShowErr(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, str) == null) {
            l.J(getContext(), str);
        }
    }

    public void ovverideClickListener(View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) || (relativeLayout = this.f54295f) == null) {
            return;
        }
        relativeLayout.setOnClickListener(onClickListener);
    }

    public void refreshPlayTime(int i2) {
        VoiceData$VoiceModel voiceData$VoiceModel;
        String formatVoiceTime;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (voiceData$VoiceModel = this.f54294e) == null || this.f54297h == null) {
            return;
        }
        int i4 = i2 / 1000;
        if (i4 > 0 && i4 < (i3 = voiceData$VoiceModel.duration)) {
            formatVoiceTime = VoiceManager.formatVoiceTime(i3 - i4);
        } else {
            formatVoiceTime = VoiceManager.formatVoiceTime(this.f54294e.duration);
        }
        String charSequence2String = k.charSequence2String(this.f54297h.getText(), null);
        if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
            this.f54297h.setText(formatVoiceTime);
        }
    }

    public void refreshViewState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 == 3) {
                this.f54298i.setVisibility(4);
                b(true);
                this.j.setVisibility(0);
                this.j.start();
                return;
            }
            this.j.setCertainColumnCount(getAudioVoiceColumnCount());
            this.j.resetStartState();
            this.j.setVisibility(4);
            b(false);
            if (i2 == 1) {
                VoiceData$VoiceModel voiceData$VoiceModel = this.f54294e;
                if (voiceData$VoiceModel != null) {
                    this.f54297h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration));
                }
                this.f54298i.setVisibility(4);
            } else if (i2 == 2) {
                VoiceData$VoiceModel voiceData$VoiceModel2 = this.f54294e;
                if (voiceData$VoiceModel2 != null) {
                    this.f54297h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel2.duration));
                }
                this.f54298i.setVisibility(0);
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f54294e = null;
            setTag(null);
            refreshViewState(1);
        }
    }

    public void resetLayoutParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = -2;
            this.j.setLayoutParams(layoutParams);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void setPlayTimeTextView(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || (textView = this.f54297h) == null) {
            return;
        }
        textView.setTextSize(0, l.g(getContext(), i2));
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, obj) == null) {
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
                tbRichTextVoiceInfo.w();
                setVoiceModel(voiceData$VoiceModel);
                a();
                obj = voiceData$VoiceModel;
            }
            super.setTag(obj);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, voiceManager) == null) {
            this.o = voiceManager;
        }
    }

    public void setVoiceModel(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, voiceData$VoiceModel) == null) {
            requestLayout();
            this.f54294e = voiceData$VoiceModel;
            if (voiceData$VoiceModel == null) {
                return;
            }
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceData$VoiceModel)) {
                voiceManager.resetPlayView(this);
                refreshPlayTime(this.f54294e.elapse);
                return;
            }
            refreshViewState(this.f54294e.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration);
            int measureText = (int) this.f54297h.getPaint().measureText(formatVoiceTime);
            this.l = measureText;
            this.n = measureText + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.j.setCertainColumnCount(getAudioVoiceColumnCount());
            this.j.resetStartState();
            this.f54295f.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.n, getPaddingBottom());
            this.f54297h.setText(formatVoiceTime);
        }
    }

    public void stopCurrentPlay() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.f54294e == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.stopPlay();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Voice_play_type);
        obtainStyledAttributes.getInteger(R$styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }
}
