package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.nea;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ti8 implements mea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public si8 a;
    public final Context b;
    public final ViewGroup c;
    public TbImageView d;
    public TextView e;
    public TextView f;
    public boolean g;
    public ThreadData h;
    public BdUniqueId i;
    public String j;
    public String k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public hea n;
    public int o;
    public nea.a p;

    public ti8(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
        this.c = viewGroup;
        a();
    }

    public final void a() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (context = this.b) != null && this.c != null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0a74, this.c, true);
            if (inflate != null) {
                inflate.setOnClickListener(this);
            }
            ImageView imageView = (ImageView) this.c.findViewById(R.id.video_play);
            if (imageView != null) {
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
                imageView.setOnClickListener(this);
            }
            TextView textView = (TextView) this.c.findViewById(R.id.video_duration);
            this.f = textView;
            if (textView != null) {
                EMManager.from(textView).setTextShadow(R.array.S_O_X001);
            }
            TextView textView2 = (TextView) this.c.findViewById(R.id.video_play_count);
            this.e = textView2;
            if (textView2 != null) {
                EMManager.from(textView2).setTextShadow(R.array.S_O_X001);
            }
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.video_thumbnail);
            this.d = tbImageView;
            if (tbImageView != null) {
                tbImageView.clearCornerFlag();
                this.d.setDrawCorner(false);
                this.d.setPlaceHolder(3);
            }
        }
    }

    public final void b() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.g && (viewGroup = this.c) != null && this.b != null && this.h != null) {
            viewGroup.removeAllViews();
            si8 si8Var = new si8(this.b, this.c);
            this.a = si8Var;
            si8Var.setUniqueId(this.i);
            this.a.setFrom(this.j);
            this.a.setStageType(this.k);
            this.a.setData(this.h);
            if (this.h.getThreadVideoInfo() != null && this.h.getThreadVideoInfo().is_vertical.intValue() == 1) {
                this.a.changeRenderViewMode(this.o);
            }
            this.a.setJumpToPbClickListener(this.l);
            this.a.setAfterClickListener(this.m);
            this.a.setStatistic(this.n);
            this.a.I0(this.p);
            this.g = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TextView textView = this.f;
            if (textView != null) {
                EMManager.from(textView).setTextShadow(R.array.S_O_X001);
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                EMManager.from(textView2).setTextShadow(R.array.S_O_X001);
            }
        }
    }

    public void e() {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (si8Var = this.a) != null) {
            si8Var.G0();
        }
    }

    @Override // com.baidu.tieba.mea
    public int getCurrentPosition() {
        InterceptResult invokeV;
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.g && (si8Var = this.a) != null) {
                return si8Var.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mea
    public View getMainView() {
        InterceptResult invokeV;
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.g && (si8Var = this.a) != null) {
                return si8Var.getMainView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mea
    public boolean isFullScreen() {
        InterceptResult invokeV;
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.g && (si8Var = this.a) != null) {
                return si8Var.isFullScreen();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mea
    public boolean isPlaying() {
        InterceptResult invokeV;
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.g && (si8Var = this.a) != null) {
                return si8Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mea
    public boolean onBackPress() {
        InterceptResult invokeV;
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.g && (si8Var = this.a) != null) {
                return si8Var.onBackPress();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.g && (si8Var = this.a) != null) {
            si8Var.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.g && (si8Var = this.a) != null) {
            si8Var.onPrepared();
        }
    }

    @Override // com.baidu.tieba.mea
    public void onScroll() {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.g && (si8Var = this.a) != null) {
            si8Var.onScroll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.g && (si8Var = this.a) != null) {
            si8Var.onSeekComplete();
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.g && (si8Var = this.a) != null) {
            si8Var.onSurfaceDestroyed();
        }
    }

    @Override // com.baidu.tieba.mea
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.g && (si8Var = this.a) != null) {
                return si8Var.onVolumeUp();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mea
    public void startPlay() {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            b();
            if (this.g && (si8Var = this.a) != null) {
                si8Var.startPlay();
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void stopPlay() {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.g && (si8Var = this.a) != null) {
            si8Var.stopPlay();
        }
    }

    @Override // com.baidu.tieba.mea
    public void changeRenderViewMode(int i) {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.o = i;
            if (this.g && (si8Var = this.a) != null) {
                si8Var.changeRenderViewMode(i);
            }
        }
    }

    public void d(nea.a aVar) {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.p = aVar;
            if (this.g && (si8Var = this.a) != null) {
                si8Var.I0(aVar);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            if (this.g && (si8Var = this.a) != null) {
                return si8Var.onBackground(z);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            b();
            if (this.g && (si8Var = this.a) != null) {
                si8Var.onClick(view2);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.m = onClickListener;
            if (this.g && (si8Var = this.a) != null) {
                si8Var.setAfterClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void setFrom(String str) {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.j = str;
            if (this.g && (si8Var = this.a) != null) {
                si8Var.setFrom(str);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.l = onClickListener;
            if (this.g && (si8Var = this.a) != null) {
                si8Var.setJumpToPbClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void setStageType(String str) {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.k = str;
            if (this.g && (si8Var = this.a) != null) {
                si8Var.setStageType(str);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void setStatistic(hea heaVar) {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, heaVar) == null) {
            this.n = heaVar;
            if (this.g && (si8Var = this.a) != null) {
                si8Var.setStatistic(heaVar);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void setUniqueId(BdUniqueId bdUniqueId) {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
            if (this.g && (si8Var = this.a) != null) {
                si8Var.setUniqueId(bdUniqueId);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048590, this, i, i2, obj)) == null) {
            if (this.g && (si8Var = this.a) != null) {
                return si8Var.onError(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048591, this, i, i2, obj)) == null) {
            if (this.g && (si8Var = this.a) != null) {
                return si8Var.onInfo(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.mea
    public void setData(ThreadData threadData) {
        si8 si8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null) {
            this.h = threadData;
            if (this.g && (si8Var = this.a) != null) {
                si8Var.setData(threadData);
                return;
            }
            int intValue = threadData.getThreadVideoInfo().video_duration.intValue() * 1000;
            TextView textView = this.f;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(intValue));
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                textView2.setText(String.format(this.b.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(threadData.getThreadVideoInfo().play_count.intValue())));
            }
            if (this.d != null) {
                if (TbadkCoreApplication.getInst().getAutoPlaySwitch() != 2 && TbadkCoreApplication.getInst().getAutoPlaySwitch() != 1) {
                    this.d.startLoad(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
                } else if (!rd.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                    this.d.startLoad(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
                } else {
                    this.d.startLoad(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
                }
            }
        }
    }
}
