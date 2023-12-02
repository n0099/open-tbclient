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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.mea;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class xo7 implements lea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mea a;
    public final Context b;
    public final ViewGroup c;
    public TbImageView d;
    public View e;
    public TextView f;
    public TextView g;
    public boolean h;
    public ThreadData i;
    public BdUniqueId j;
    public String k;
    public String l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public gea o;
    public int p;
    public mea.a q;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
        }
    }

    public xo7(Context context, ViewGroup viewGroup) {
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0a73, this.c, true);
            if (inflate != null) {
                inflate.setOnClickListener(this);
            }
            ImageView imageView = (ImageView) this.c.findViewById(R.id.video_play);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080afc);
            }
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f092a1e);
            this.e = findViewById;
            if (findViewById != null) {
                EMManager.from(findViewById).setMaskBackGround(R.array.Mask_X003);
            }
            TextView textView = (TextView) this.c.findViewById(R.id.video_duration);
            this.g = textView;
            if (textView != null) {
                EMManager.from(textView).setTextShadow(R.array.S_O_X001);
            }
            TextView textView2 = (TextView) this.c.findViewById(R.id.video_play_count);
            this.f = textView2;
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.h && (viewGroup = this.c) != null && this.b != null && this.i != null) {
            viewGroup.removeAllViews();
            mea meaVar = new mea(this.b, this.c);
            this.a = meaVar;
            meaVar.setUniqueId(this.j);
            this.a.setFrom(this.k);
            this.a.setStageType(this.l);
            this.a.setData(this.i);
            if (this.i.getThreadVideoInfo() != null && this.i.getThreadVideoInfo().is_vertical.intValue() == 1) {
                this.a.changeRenderViewMode(this.p);
            }
            this.a.setJumpToPbClickListener(this.m);
            this.a.setAfterClickListener(this.n);
            this.a.setStatistic(this.o);
            this.a.I0(this.q);
            this.h = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TextView textView = this.g;
            if (textView != null) {
                EMManager.from(textView).setTextShadow(R.array.S_O_X001);
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                EMManager.from(textView2).setTextShadow(R.array.S_O_X001);
            }
        }
    }

    @Override // com.baidu.tieba.lea
    public int getCurrentPosition() {
        InterceptResult invokeV;
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.h && (meaVar = this.a) != null) {
                return meaVar.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.lea
    public View getMainView() {
        InterceptResult invokeV;
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.h && (meaVar = this.a) != null) {
                return meaVar.getMainView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lea
    public boolean isFullScreen() {
        InterceptResult invokeV;
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.h && (meaVar = this.a) != null) {
                return meaVar.isFullScreen();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lea
    public boolean isPlaying() {
        InterceptResult invokeV;
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.h && (meaVar = this.a) != null) {
                return meaVar.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lea
    public boolean onBackPress() {
        InterceptResult invokeV;
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.h && (meaVar = this.a) != null) {
                return meaVar.onBackPress();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        mea meaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.h && (meaVar = this.a) != null) {
            meaVar.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        mea meaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.h && (meaVar = this.a) != null) {
            meaVar.onPrepared();
        }
    }

    @Override // com.baidu.tieba.lea
    public void onScroll() {
        mea meaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.h && (meaVar = this.a) != null) {
            meaVar.onScroll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        mea meaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.h && (meaVar = this.a) != null) {
            meaVar.onSeekComplete();
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        mea meaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.h && (meaVar = this.a) != null) {
            meaVar.onSurfaceDestroyed();
        }
    }

    @Override // com.baidu.tieba.lea
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.h && (meaVar = this.a) != null) {
                return meaVar.onVolumeUp();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lea
    public void startPlay() {
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            b();
            if (this.h && (meaVar = this.a) != null) {
                meaVar.startPlay();
            }
        }
    }

    @Override // com.baidu.tieba.lea
    public void stopPlay() {
        mea meaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.h && (meaVar = this.a) != null) {
            meaVar.stopPlay();
        }
    }

    @Override // com.baidu.tieba.lea
    public void changeRenderViewMode(int i) {
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.p = i;
            if (this.h && (meaVar = this.a) != null) {
                meaVar.changeRenderViewMode(i);
            }
        }
    }

    public void d(mea.a aVar) {
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.q = aVar;
            if (this.h && (meaVar = this.a) != null) {
                meaVar.I0(aVar);
            }
        }
    }

    @Override // com.baidu.tieba.lea
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            if (this.h && (meaVar = this.a) != null) {
                return meaVar.onBackground(z);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.lea
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            this.n = onClickListener;
            if (this.h && (meaVar = this.a) != null) {
                meaVar.setAfterClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.lea
    public void setFrom(String str) {
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.k = str;
            if (this.h && (meaVar = this.a) != null) {
                meaVar.setFrom(str);
            }
        }
    }

    @Override // com.baidu.tieba.lea
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.m = onClickListener;
            if (this.h && (meaVar = this.a) != null) {
                meaVar.setJumpToPbClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.lea
    public void setStageType(String str) {
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.l = str;
            if (this.h && (meaVar = this.a) != null) {
                meaVar.setStageType(str);
            }
        }
    }

    @Override // com.baidu.tieba.lea
    public void setStatistic(gea geaVar) {
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, geaVar) == null) {
            this.o = geaVar;
            if (this.h && (meaVar = this.a) != null) {
                meaVar.setStatistic(geaVar);
            }
        }
    }

    @Override // com.baidu.tieba.lea
    public void setUniqueId(BdUniqueId bdUniqueId) {
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bdUniqueId) == null) {
            this.j = bdUniqueId;
            if (this.h && (meaVar = this.a) != null) {
                meaVar.setUniqueId(bdUniqueId);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048589, this, i, i2, obj)) == null) {
            if (this.h && (meaVar = this.a) != null) {
                return meaVar.onError(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        mea meaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048590, this, i, i2, obj)) == null) {
            if (this.h && (meaVar = this.a) != null) {
                return meaVar.onInfo(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.lea
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null) {
            this.i = threadData;
            if (this.h && this.a != null) {
                View view2 = this.e;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                this.a.setData(threadData);
                return;
            }
            int intValue = threadData.getThreadVideoInfo().video_duration.intValue() * 1000;
            TextView textView = this.g;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(intValue));
            }
            TextView textView2 = this.f;
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
            View view3 = this.e;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
    }
}
