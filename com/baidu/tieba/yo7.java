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
import com.baidu.tieba.nea;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class yo7 implements mea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nea a;
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
    public hea o;
    public int p;
    public nea.a q;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
        }
    }

    public yo7(Context context, ViewGroup viewGroup) {
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
            nea neaVar = new nea(this.b, this.c);
            this.a = neaVar;
            neaVar.setUniqueId(this.j);
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

    @Override // com.baidu.tieba.mea
    public int getCurrentPosition() {
        InterceptResult invokeV;
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.h && (neaVar = this.a) != null) {
                return neaVar.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mea
    public View getMainView() {
        InterceptResult invokeV;
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.h && (neaVar = this.a) != null) {
                return neaVar.getMainView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mea
    public boolean isFullScreen() {
        InterceptResult invokeV;
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.h && (neaVar = this.a) != null) {
                return neaVar.isFullScreen();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mea
    public boolean isPlaying() {
        InterceptResult invokeV;
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.h && (neaVar = this.a) != null) {
                return neaVar.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mea
    public boolean onBackPress() {
        InterceptResult invokeV;
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.h && (neaVar = this.a) != null) {
                return neaVar.onBackPress();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        nea neaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.h && (neaVar = this.a) != null) {
            neaVar.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        nea neaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.h && (neaVar = this.a) != null) {
            neaVar.onPrepared();
        }
    }

    @Override // com.baidu.tieba.mea
    public void onScroll() {
        nea neaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.h && (neaVar = this.a) != null) {
            neaVar.onScroll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        nea neaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.h && (neaVar = this.a) != null) {
            neaVar.onSeekComplete();
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        nea neaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.h && (neaVar = this.a) != null) {
            neaVar.onSurfaceDestroyed();
        }
    }

    @Override // com.baidu.tieba.mea
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.h && (neaVar = this.a) != null) {
                return neaVar.onVolumeUp();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mea
    public void startPlay() {
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            b();
            if (this.h && (neaVar = this.a) != null) {
                neaVar.startPlay();
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void stopPlay() {
        nea neaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.h && (neaVar = this.a) != null) {
            neaVar.stopPlay();
        }
    }

    @Override // com.baidu.tieba.mea
    public void changeRenderViewMode(int i) {
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.p = i;
            if (this.h && (neaVar = this.a) != null) {
                neaVar.changeRenderViewMode(i);
            }
        }
    }

    public void d(nea.a aVar) {
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.q = aVar;
            if (this.h && (neaVar = this.a) != null) {
                neaVar.I0(aVar);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            if (this.h && (neaVar = this.a) != null) {
                return neaVar.onBackground(z);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.mea
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            this.n = onClickListener;
            if (this.h && (neaVar = this.a) != null) {
                neaVar.setAfterClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void setFrom(String str) {
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.k = str;
            if (this.h && (neaVar = this.a) != null) {
                neaVar.setFrom(str);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.m = onClickListener;
            if (this.h && (neaVar = this.a) != null) {
                neaVar.setJumpToPbClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void setStageType(String str) {
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.l = str;
            if (this.h && (neaVar = this.a) != null) {
                neaVar.setStageType(str);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void setStatistic(hea heaVar) {
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, heaVar) == null) {
            this.o = heaVar;
            if (this.h && (neaVar = this.a) != null) {
                neaVar.setStatistic(heaVar);
            }
        }
    }

    @Override // com.baidu.tieba.mea
    public void setUniqueId(BdUniqueId bdUniqueId) {
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bdUniqueId) == null) {
            this.j = bdUniqueId;
            if (this.h && (neaVar = this.a) != null) {
                neaVar.setUniqueId(bdUniqueId);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048589, this, i, i2, obj)) == null) {
            if (this.h && (neaVar = this.a) != null) {
                return neaVar.onError(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048590, this, i, i2, obj)) == null) {
            if (this.h && (neaVar = this.a) != null) {
                return neaVar.onInfo(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.mea
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
