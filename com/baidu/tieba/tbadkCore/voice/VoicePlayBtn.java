package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.VideoAudioHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.di;
import com.baidu.tieba.m9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Voice;
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001>B\u0011\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\bH\u0002J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u0004\u0018\u00010\u0017J\b\u0010%\u001a\u00020\u0019H\u0016J\b\u0010&\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\bH\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\u0012\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u001fH\u0014J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u001fH\u0016J\u0012\u00101\u001a\u00020\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020/2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020/H\u0002J\u0010\u00109\u001a\u00020\u001f2\b\u0010:\u001a\u0004\u0018\u00010;J\b\u0010<\u001a\u00020\u001fH\u0002J\b\u0010=\u001a\u00020\u001fH\u0002R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/baidu/tieba/tbadkCore/voice/VoicePlayBtn;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/tbadk/core/voice/VoiceManager$IPlayView;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lastVideoCardMute", "", "getLastVideoCardMute", "()Ljava/lang/Boolean;", "setLastVideoCardMute", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "lottieView", "Lcom/baidu/tbadk/widget/lottie/TBLottieAnimationView;", "mClickCallBack", "Lcom/baidu/tieba/tbadkCore/voice/VoicePlayBtn$ClickCallBack;", "getMClickCallBack", "()Lcom/baidu/tieba/tbadkCore/voice/VoicePlayBtn$ClickCallBack;", "setMClickCallBack", "(Lcom/baidu/tieba/tbadkCore/voice/VoicePlayBtn$ClickCallBack;)V", "mVoiceManager", "Lcom/baidu/tbadk/core/voice/VoiceManager;", "model", "Lcom/baidu/tbadk/core/data/VoiceData$VoiceModel;", "voicePlayImg", "Landroid/widget/ImageView;", "voiceText", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "changeVideoVoiceState", "", "canPlay", "changeVoicePlayRes", "isPlaying", "getRealView", "getVoiceManager", "getVoiceModel", "initUI", "isModelPlaying", "onChangeSkinType", "onClick", "v", "Landroid/view/View;", "onDetachedFromWindow", "onPlayElapse", "elapse", "", "onPlayPrepared", "onRefreshByPlayStatus", "onShowErr", StatConstants.KEY_EXT_ERR_CODE, StatConstants.KEY_EXT_ERR_MSG, "", "refreshPlayTime", "refreshViewState", "state", "setData", "voice", "Ltbclient/Voice;", "startVoiceAnimation", "stopVoiceAnimation", "ClickCallBack", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VoicePlayBtn extends RelativeLayout implements VoiceManager.IPlayView, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ImageView a;
    public final TBLottieAnimationView b;
    public final EMTextView c;
    public VoiceData.VoiceModel d;
    public VoiceManager e;
    public a f;
    public Boolean g;

    /* loaded from: classes8.dex */
    public interface a {
        void onClick();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public VoiceManager.IPlayView getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (VoiceManager.IPlayView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onPlayPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoicePlayBtn(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ImageView(context);
        this.b = new TBLottieAnimationView(context);
        this.c = new EMTextView(context);
        this.d = new VoiceData.VoiceModel();
        c();
    }

    public final void f(int i) {
        String formatVoiceTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 <= this.d.getDuration()) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.d.getDuration() - i2);
                Intrinsics.checkNotNullExpressionValue(formatVoiceTime, "{\n            val s = mo…matVoiceTime(s)\n        }");
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.d.getDuration());
                Intrinsics.checkNotNullExpressionValue(formatVoiceTime, "{\n            VoiceManag….getDuration())\n        }");
            }
            String charSequence2String = di.charSequence2String(this.c.getText(), null);
            if (charSequence2String == null || !Intrinsics.areEqual(charSequence2String, formatVoiceTime)) {
                this.c.setText(formatVoiceTime);
            }
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i == 3) {
                b(true);
                h();
                return;
            }
            i();
            b(false);
            if (i != 1) {
                if (i == 2) {
                    this.c.setText(VoiceManager.formatVoiceTime(this.d.getDuration()));
                    return;
                }
                return;
            }
            this.c.setText(VoiceManager.formatVoiceTime(this.d.getDuration()));
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z && this.g != null) {
                TbSingleton tbSingleton = TbSingleton.getInstance();
                Boolean bool = this.g;
                Intrinsics.checkNotNull(bool);
                tbSingleton.setVideoCardMute(bool.booleanValue());
                this.g = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921821, Boolean.valueOf(z)));
            } else if (!z && this.g == null) {
                this.g = Boolean.valueOf(TbSingleton.getInstance().isVideoCardMute());
                TbSingleton.getInstance().setVideoCardMute(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921821, Boolean.valueOf(z)));
            }
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            VideoAudioHelper.isPlayVoicePlaying = z;
            if (z) {
                this.a.setImageResource(R.drawable.icon_pic_pw_pause);
            } else {
                this.a.setImageResource(R.drawable.icon_pic_pw_play);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            if (this.e == null) {
                this.e = getVoiceManager();
            }
            a(false);
            VoiceManager voiceManager = this.e;
            if (voiceManager != null) {
                voiceManager.startPlay(this);
            }
            a aVar = this.f;
            if (aVar != null) {
                aVar.onClick();
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onPlayElapse(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (!d()) {
                g(1);
                return;
            }
            f(i);
            VoiceData.VoiceModel voiceModel = this.d;
            if (voiceModel != null) {
                voiceModel.elapse = i;
            }
        }
    }

    public final void setLastVideoCardMute(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bool) == null) {
            this.g = bool;
        }
    }

    public final void setMClickCallBack(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setOnClickListener(this);
            setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds3);
            setGravity(16);
            int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds68);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens2, dimens2);
            layoutParams.addRule(15);
            layoutParams.leftMargin = dimens;
            layoutParams.topMargin = dimens;
            layoutParams.bottomMargin = dimens;
            this.a.setImageResource(R.drawable.icon_pic_pw_play);
            addView(this.a, layoutParams);
            int dimens3 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds36);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimens3, dimens3);
            layoutParams2.addRule(15);
            layoutParams2.leftMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds80);
            layoutParams2.rightMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X001);
            this.b.loop(true);
            addView(this.b, layoutParams2);
            addView(this.c);
            e();
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.e == null) {
                this.e = getVoiceManager();
            }
            VoiceManager voiceManager = this.e;
            if (voiceManager != null) {
                bool = Boolean.valueOf(voiceManager.isPlayDoing(this.d));
            } else {
                bool = null;
            }
            Intrinsics.checkNotNull(bool);
            if (!bool.booleanValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            EMManager.from(this).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0923);
            EMManager.from(this.c).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0610);
            SkinManager.setLottieAnimation(this.b, R.raw.lottie_peiwan);
        }
    }

    public final Boolean getLastVideoCardMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return (Boolean) invokeV.objValue;
    }

    public final a getMClickCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (a) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public VoiceData.VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return (VoiceData.VoiceModel) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.playAnimation();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b.cancelAnimation();
            this.b.setFrame(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
            try {
                i();
                if (this.e == null) {
                    this.e = getVoiceManager();
                }
                a(true);
                VoiceManager voiceManager = this.e;
                if (voiceManager != null) {
                    voiceManager.stopPlay();
                }
                this.f = null;
            } catch (Exception unused) {
            }
        }
    }

    public final VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.i) {
                return ((VoiceManager.i) context).N0();
            }
            if (m9.a(getContext()) != null) {
                BdPageContext<?> a2 = m9.a(getContext());
                if (a2 != null) {
                    TbPageContext tbPageContext = (TbPageContext) a2;
                    if (tbPageContext.getOrignalPage() instanceof VoiceManager.i) {
                        T orignalPage = tbPageContext.getOrignalPage();
                        if (orignalPage != 0) {
                            return ((VoiceManager.i) orignalPage).N0();
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.voice.VoiceManager.IMediaPlayerVoiceActivity");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.TbPageContext<*>");
                }
            }
            return this.e;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onRefreshByPlayStatus(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, voiceModel) != null) || voiceModel == null) {
            return;
        }
        if (this.d != voiceModel) {
            g(1);
            a(true);
            return;
        }
        Integer num = voiceModel.voice_status;
        if (num != null && num.intValue() == 1) {
            a(true);
        }
        Integer num2 = voiceModel.voice_status;
        Intrinsics.checkNotNullExpressionValue(num2, "model.voice_status");
        g(num2.intValue());
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, str) == null) {
            BdUtilHelper.showLongToast(getContext(), str);
        }
    }

    public final void setData(Voice voice) {
        int intValue;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, voice) != null) || voice == null) {
            return;
        }
        this.e = getVoiceManager();
        this.d.setVoiceUrl(voice.voice_url);
        VoiceData.VoiceModel voiceModel = this.d;
        Integer num = voice.during_time;
        Intrinsics.checkNotNullExpressionValue(num, "voice.during_time");
        voiceModel.duration = num.intValue();
        String voiceUrl = this.d.getVoiceUrl();
        String str = "";
        if (voiceUrl == null) {
            voiceUrl = "";
        }
        Uri parse = Uri.parse(voiceUrl);
        VoiceData.VoiceModel voiceModel2 = this.d;
        String lastPathSegment = parse.getLastPathSegment();
        if (lastPathSegment != null) {
            str = lastPathSegment;
        }
        voiceModel2.voiceId = str;
        this.d.isUseUrl = true;
        Integer num2 = voice.during_time;
        if (num2 == null) {
            intValue = 0;
        } else {
            intValue = num2.intValue();
        }
        String formatVoiceTime = VoiceManager.formatVoiceTime(intValue);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) this.c.getPaint().measureText(formatVoiceTime), -2);
        layoutParams.rightMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004);
        layoutParams.leftMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds127);
        layoutParams.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds24);
        this.c.setLayoutParams(layoutParams);
        this.c.setText(formatVoiceTime);
        Integer num3 = this.d.voice_status;
        if (num3 == null || num3.intValue() != 1) {
            VoiceManager voiceManager = this.e;
            if (voiceManager != null) {
                voiceManager.resetPlayView(this);
            }
            f(this.d.elapse);
        }
        Integer num4 = this.d.voice_status;
        Intrinsics.checkNotNullExpressionValue(num4, "model.voice_status");
        g(num4.intValue());
    }
}
