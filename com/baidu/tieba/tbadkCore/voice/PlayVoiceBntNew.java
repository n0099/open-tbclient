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
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ad;
import com.baidu.tieba.k4;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.xga;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PlayVoiceBntNew extends RelativeLayout implements VoiceManager.IPlayView, View.OnClickListener {
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

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onPlayPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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
        l = ((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - (BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public VoiceManager.IPlayView getRealView() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).v1(this.a);
            }
            if ((k4.a(getContext()) instanceof BdPageContext) && (tbPageContext = (TbPageContext) k4.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).v1(this.a);
            }
            return this;
        }
        return (VoiceManager.IPlayView) invokeV.objValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).O0();
            }
            if ((k4.a(getContext()) instanceof BdPageContext) && (tbPageContext = (TbPageContext) k4.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).O0();
            }
            return this.k;
        }
        return (VoiceManager) invokeV.objValue;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, xga.Voice_play_type);
        obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        e(context);
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
        e(context);
    }

    private int getAudioVoiceColumnCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            VoiceData.VoiceModel voiceModel = getVoiceModel();
            if (voiceModel == null) {
                return 0;
            }
            return d(voiceModel) / 10;
        }
        return invokeV.intValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.a == null) {
                return false;
            }
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && !voiceManager.isPlayDoing(this.a)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ImageView getImgStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (ImageView) invokeV.objValue;
    }

    public TextView getPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public VoiceData.VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return (VoiceData.VoiceModel) invokeV.objValue;
    }

    public RelativeLayout getmVoiceImageContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a = null;
            setTag(null);
            j(1);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams.width = -2;
            this.f.setLayoutParams(layoutParams);
        }
    }

    public void m() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.a != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
            EMManager.from(this.b).setCorner(R.string.J_X05).setBorderWidth(R.dimen.L_X03).setBorderColor(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public final void c(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || (imageView = this.c) == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_common_voice_pause16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_common_voice_play16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, view2) == null) && this.a != null && view2 == this.b) {
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

    public final int d(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        double d;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voiceModel)) == null) {
            if (voiceModel.getDuration() < 10) {
                d = l * 0.6d;
            } else {
                if (voiceModel.getDuration() < 30) {
                    i = l;
                } else if (voiceModel.getDuration() < 60) {
                    i = l;
                } else {
                    d = l * 2;
                }
                d = i * 0.6d * 2.0d;
            }
            if (d < BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
                d = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
            }
            double dimens = (d - this.j) - BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
            if (dimens > 0.0d) {
                return (int) dimens;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            if (i == 3) {
                this.e.setVisibility(4);
                c(true);
                this.f.setVisibility(0);
                this.f.g();
                return;
            }
            this.f.setCertainColumnCount(getAudioVoiceColumnCount());
            this.f.f();
            this.f.setVisibility(4);
            c(false);
            if (i == 1) {
                VoiceData.VoiceModel voiceModel = this.a;
                if (voiceModel != null) {
                    this.d.setText(VoiceManager.formatVoiceTime(voiceModel.getDuration()));
                }
                this.e.setVisibility(4);
            } else if (i == 2) {
                VoiceData.VoiceModel voiceModel2 = this.a;
                if (voiceModel2 != null) {
                    this.d.setText(VoiceManager.formatVoiceTime(voiceModel2.getDuration()));
                }
                this.e.setVisibility(0);
            }
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
                i(this.a.elapse);
                return;
            }
            j(this.a.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.getDuration());
            int measureText = (int) this.d.getPaint().measureText(formatVoiceTime);
            this.h = measureText;
            this.j = measureText + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.f.setCertainColumnCount(getAudioVoiceColumnCount());
            this.f.f();
            this.b.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.j, getPaddingBottom());
            this.d.setText(formatVoiceTime);
        }
    }

    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            f(context);
            setOnClickListener(this);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) && (relativeLayout = this.b) != null) {
            relativeLayout.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onPlayElapse(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            if (!g()) {
                j(1);
                return;
            }
            i(i);
            VoiceData.VoiceModel voiceModel = this.a;
            if (voiceModel != null) {
                voiceModel.elapse = i;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onRefreshByPlayStatus(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, voiceModel) != null) || voiceModel == null) {
            return;
        }
        if (this.a != voiceModel) {
            j(1);
        } else {
            j(voiceModel.voice_status.intValue());
        }
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
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && (textView = this.d) != null) {
            textView.setTextSize(0, BdUtilHelper.getDimens(getContext(), i));
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, voiceManager) == null) {
            this.k = voiceManager;
        }
    }

    public void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.voice_image_content);
            this.b = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ce3);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091cd0);
            this.f = (AudioAnimationView) findViewById(R.id.audioAnimationView);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091d9d);
            this.e = progressBar;
            if (progressBar != null) {
                progressBar.setVisibility(4);
            }
            this.g = context;
            b();
        }
    }

    public void i(int i) {
        VoiceData.VoiceModel voiceModel;
        String formatVoiceTime;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (voiceModel = this.a) != null && this.d != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < voiceModel.getDuration()) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.a.getDuration() - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.a.getDuration());
            }
            String charSequence2String = ad.charSequence2String(this.d.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.d.setText(formatVoiceTime);
            }
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, obj) == null) {
            if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
                TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
                VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.P();
                if (voiceModel == null) {
                    voiceModel = new VoiceData.VoiceModel();
                    if (tbRichTextVoiceInfo.N() == 0) {
                        voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                    } else {
                        voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                    }
                    voiceModel.setVoiceId(tbRichTextVoiceInfo.O());
                    voiceModel.setDuration(tbRichTextVoiceInfo.getDuration());
                    tbRichTextVoiceInfo.Q(voiceModel);
                }
                tbRichTextVoiceInfo.N();
                setVoiceModel(voiceModel);
                a();
                obj = voiceModel;
            }
            super.setTag(obj);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i, str) == null) {
            BdUtilHelper.showLongToast(getContext(), str);
        }
    }
}
