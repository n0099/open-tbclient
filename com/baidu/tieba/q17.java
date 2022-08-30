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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
/* loaded from: classes5.dex */
public class q17 implements l98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p17 a;
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
    public g98 n;
    public int o;

    public q17(Context context, ViewGroup viewGroup) {
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (context = this.b) == null || this.c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0917, this.c, true);
        if (inflate != null) {
            inflate.setOnClickListener(this);
        }
        ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0924f9);
        if (imageView != null) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            imageView.setOnClickListener(this);
        }
        TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0924c0);
        this.f = textView;
        if (textView != null) {
            os4.d(textView).y(R.array.S_O_X001);
        }
        TextView textView2 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0924fb);
        this.e = textView2;
        if (textView2 != null) {
            os4.d(textView2).y(R.array.S_O_X001);
        }
        TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09252a);
        this.d = tbImageView;
        if (tbImageView != null) {
            tbImageView.s();
            this.d.setDrawCorner(false);
            this.d.setPlaceHolder(3);
        }
    }

    public final void b() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.g || (viewGroup = this.c) == null || this.b == null || this.h == null) {
            return;
        }
        viewGroup.removeAllViews();
        p17 p17Var = new p17(this.b, this.c);
        this.a = p17Var;
        p17Var.setUniqueId(this.i);
        this.a.setFrom(this.j);
        this.a.setStageType(this.k);
        this.a.setData(this.h);
        if (this.h.getThreadVideoInfo() != null && this.h.getThreadVideoInfo().is_vertical.intValue() == 1 && UbsABTestHelper.showNewUI()) {
            this.a.changeRenderViewMode(this.o);
        }
        this.a.setJumpToPbClickListener(this.l);
        this.a.setAfterClickListener(this.m);
        this.a.setStatistic(this.n);
        this.g = true;
    }

    @Override // com.baidu.tieba.l98
    public void changeRenderViewMode(int i) {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.o = i;
            if (!this.g || (p17Var = this.a) == null) {
                return;
            }
            p17Var.changeRenderViewMode(i);
        }
    }

    @Override // com.baidu.tieba.l98
    public int getCurrentPosition() {
        InterceptResult invokeV;
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.g || (p17Var = this.a) == null) {
                return 0;
            }
            return p17Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l98
    public View getMainView() {
        InterceptResult invokeV;
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.g || (p17Var = this.a) == null) {
                return null;
            }
            return p17Var.getMainView();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l98
    public boolean isFullScreen() {
        InterceptResult invokeV;
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.g || (p17Var = this.a) == null) {
                return false;
            }
            return p17Var.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l98
    public boolean isPlaying() {
        InterceptResult invokeV;
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.g || (p17Var = this.a) == null) {
                return false;
            }
            return p17Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l98
    public boolean onBackPress() {
        InterceptResult invokeV;
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.g || (p17Var = this.a) == null) {
                return false;
            }
            return p17Var.onBackPress();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l98
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (!this.g || (p17Var = this.a) == null) {
                return false;
            }
            return p17Var.onBackground(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            b();
            if (!this.g || (p17Var = this.a) == null) {
                return;
            }
            p17Var.onClick(view2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.g && (p17Var = this.a) != null) {
            p17Var.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048587, this, i, i2, obj)) == null) {
            if (!this.g || (p17Var = this.a) == null) {
                return false;
            }
            return p17Var.onError(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048588, this, i, i2, obj)) == null) {
            if (!this.g || (p17Var = this.a) == null) {
                return false;
            }
            return p17Var.onInfo(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.g && (p17Var = this.a) != null) {
            p17Var.onPrepared();
        }
    }

    @Override // com.baidu.tieba.l98
    public void onScroll() {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.g && (p17Var = this.a) != null) {
            p17Var.onScroll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g && (p17Var = this.a) != null) {
            p17Var.onSeekComplete();
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.g && (p17Var = this.a) != null) {
            p17Var.onSurfaceDestroyed();
        }
    }

    @Override // com.baidu.tieba.l98
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!this.g || (p17Var = this.a) == null) {
                return false;
            }
            return p17Var.onVolumeUp();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l98
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.m = onClickListener;
            if (!this.g || (p17Var = this.a) == null) {
                return;
            }
            p17Var.setAfterClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.l98
    public void setData(ThreadData threadData) {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) || threadData == null || threadData.getThreadVideoInfo() == null) {
            return;
        }
        this.h = threadData;
        if (this.g && (p17Var = this.a) != null) {
            p17Var.setData(threadData);
            return;
        }
        int intValue = threadData.getThreadVideoInfo().video_duration.intValue() * 1000;
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(StringHelper.stringForVideoTime(intValue));
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setText(String.format(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0e8c), StringHelper.numFormatOverWan(threadData.getThreadVideoInfo().play_count.intValue())));
        }
        if (this.d != null) {
            if (TbadkCoreApplication.getInst().getAutoPlaySwitch() != 2 && TbadkCoreApplication.getInst().getAutoPlaySwitch() != 1) {
                this.d.K(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            } else if (!qi.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                this.d.K(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
            } else {
                this.d.K(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            }
        }
    }

    @Override // com.baidu.tieba.l98
    public void setFrom(String str) {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.j = str;
            if (!this.g || (p17Var = this.a) == null) {
                return;
            }
            p17Var.setFrom(str);
        }
    }

    @Override // com.baidu.tieba.l98
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.l = onClickListener;
            if (!this.g || (p17Var = this.a) == null) {
                return;
            }
            p17Var.setJumpToPbClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.l98
    public void setStageType(String str) {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.k = str;
            if (!this.g || (p17Var = this.a) == null) {
                return;
            }
            p17Var.setStageType(str);
        }
    }

    @Override // com.baidu.tieba.l98
    public void setStatistic(g98 g98Var) {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, g98Var) == null) {
            this.n = g98Var;
            if (!this.g || (p17Var = this.a) == null) {
                return;
            }
            p17Var.setStatistic(g98Var);
        }
    }

    @Override // com.baidu.tieba.l98
    public void setUniqueId(BdUniqueId bdUniqueId) {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
            if (!this.g || (p17Var = this.a) == null) {
                return;
            }
            p17Var.setUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.l98
    public void startPlay() {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            b();
            if (!this.g || (p17Var = this.a) == null) {
                return;
            }
            p17Var.startPlay();
        }
    }

    @Override // com.baidu.tieba.l98
    public void stopPlay() {
        p17 p17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.g && (p17Var = this.a) != null) {
            p17Var.stopPlay();
        }
    }
}
