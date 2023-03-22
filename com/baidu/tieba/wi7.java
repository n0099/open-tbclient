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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wi7 implements jy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vi7 a;
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
    public ey8 n;
    public int o;

    public wi7(Context context, ViewGroup viewGroup) {
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d09af, this.c, true);
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
                n15.d(textView).z(R.array.S_O_X001);
            }
            TextView textView2 = (TextView) this.c.findViewById(R.id.video_play_count);
            this.e = textView2;
            if (textView2 != null) {
                n15.d(textView2).z(R.array.S_O_X001);
            }
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.video_thumbnail);
            this.d = tbImageView;
            if (tbImageView != null) {
                tbImageView.s();
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
            vi7 vi7Var = new vi7(this.b, this.c);
            this.a = vi7Var;
            vi7Var.setUniqueId(this.i);
            this.a.setFrom(this.j);
            this.a.setStageType(this.k);
            this.a.setData(this.h);
            if (this.h.getThreadVideoInfo() != null && this.h.getThreadVideoInfo().is_vertical.intValue() == 1) {
                this.a.changeRenderViewMode(this.o);
            }
            this.a.setJumpToPbClickListener(this.l);
            this.a.setAfterClickListener(this.m);
            this.a.setStatistic(this.n);
            this.g = true;
        }
    }

    public void c() {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (vi7Var = this.a) != null) {
            vi7Var.C0();
        }
    }

    @Override // com.baidu.tieba.jy8
    public int getCurrentPosition() {
        InterceptResult invokeV;
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.g && (vi7Var = this.a) != null) {
                return vi7Var.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jy8
    public View getMainView() {
        InterceptResult invokeV;
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.g && (vi7Var = this.a) != null) {
                return vi7Var.getMainView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jy8
    public boolean isFullScreen() {
        InterceptResult invokeV;
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.g && (vi7Var = this.a) != null) {
                return vi7Var.isFullScreen();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.jy8
    public boolean isPlaying() {
        InterceptResult invokeV;
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.g && (vi7Var = this.a) != null) {
                return vi7Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.jy8
    public boolean onBackPress() {
        InterceptResult invokeV;
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.g && (vi7Var = this.a) != null) {
                return vi7Var.onBackPress();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.g && (vi7Var = this.a) != null) {
            vi7Var.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.g && (vi7Var = this.a) != null) {
            vi7Var.onPrepared();
        }
    }

    @Override // com.baidu.tieba.jy8
    public void onScroll() {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g && (vi7Var = this.a) != null) {
            vi7Var.onScroll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.g && (vi7Var = this.a) != null) {
            vi7Var.onSeekComplete();
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.g && (vi7Var = this.a) != null) {
            vi7Var.onSurfaceDestroyed();
        }
    }

    @Override // com.baidu.tieba.jy8
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g && (vi7Var = this.a) != null) {
                return vi7Var.onVolumeUp();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.jy8
    public void startPlay() {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            b();
            if (this.g && (vi7Var = this.a) != null) {
                vi7Var.startPlay();
            }
        }
    }

    @Override // com.baidu.tieba.jy8
    public void stopPlay() {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.g && (vi7Var = this.a) != null) {
            vi7Var.stopPlay();
        }
    }

    @Override // com.baidu.tieba.jy8
    public void changeRenderViewMode(int i) {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.o = i;
            if (this.g && (vi7Var = this.a) != null) {
                vi7Var.changeRenderViewMode(i);
            }
        }
    }

    @Override // com.baidu.tieba.jy8
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (this.g && (vi7Var = this.a) != null) {
                return vi7Var.onBackground(z);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            b();
            if (this.g && (vi7Var = this.a) != null) {
                vi7Var.onClick(view2);
            }
        }
    }

    @Override // com.baidu.tieba.jy8
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.m = onClickListener;
            if (this.g && (vi7Var = this.a) != null) {
                vi7Var.setAfterClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.jy8
    public void setFrom(String str) {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.j = str;
            if (this.g && (vi7Var = this.a) != null) {
                vi7Var.setFrom(str);
            }
        }
    }

    @Override // com.baidu.tieba.jy8
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.l = onClickListener;
            if (this.g && (vi7Var = this.a) != null) {
                vi7Var.setJumpToPbClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.jy8
    public void setStageType(String str) {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.k = str;
            if (this.g && (vi7Var = this.a) != null) {
                vi7Var.setStageType(str);
            }
        }
    }

    @Override // com.baidu.tieba.jy8
    public void setStatistic(ey8 ey8Var) {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ey8Var) == null) {
            this.n = ey8Var;
            if (this.g && (vi7Var = this.a) != null) {
                vi7Var.setStatistic(ey8Var);
            }
        }
    }

    @Override // com.baidu.tieba.jy8
    public void setUniqueId(BdUniqueId bdUniqueId) {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
            if (this.g && (vi7Var = this.a) != null) {
                vi7Var.setUniqueId(bdUniqueId);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048588, this, i, i2, obj)) == null) {
            if (this.g && (vi7Var = this.a) != null) {
                return vi7Var.onError(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048589, this, i, i2, obj)) == null) {
            if (this.g && (vi7Var = this.a) != null) {
                return vi7Var.onInfo(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.jy8
    public void setData(ThreadData threadData) {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null) {
            this.h = threadData;
            if (this.g && (vi7Var = this.a) != null) {
                vi7Var.setData(threadData);
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
                    this.d.M(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
                } else if (!gi.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                    this.d.M(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
                } else {
                    this.d.M(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
                }
            }
        }
    }
}
