package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import c.a.r0.x3.l.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoEffectButtonLayout extends LinearLayout implements View.OnClickListener, h.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LAYOUT_BEAUTY = 2;
    public static final int LAYOUT_FILTER = 3;
    public static final int LAYOUT_MUSIC = 0;
    public static final int LAYOUT_STICKER = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f57729e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f57730f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57731g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f57732h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f57733i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f57734j;
    public LinearLayout k;
    public LinearLayout l;
    public a m;
    public View n;

    /* loaded from: classes7.dex */
    public interface a {
        void onClickBeauty();

        void onClickFilter();

        void onClickMusic();

        void onClickSticker();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEffectButtonLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.layout_video_effect_button, this);
            this.f57733i = (LinearLayout) findViewById(R.id.layout_music);
            this.f57734j = (LinearLayout) findViewById(R.id.layout_sticker);
            this.k = (LinearLayout) findViewById(R.id.layout_beauty);
            this.l = (LinearLayout) findViewById(R.id.layout_filter);
            this.f57729e = (ImageView) findViewById(R.id.img_music);
            this.f57730f = (ImageView) findViewById(R.id.img_sticker);
            this.f57731g = (ImageView) findViewById(R.id.img_beauty);
            this.f57732h = (ImageView) findViewById(R.id.img_filter);
            this.f57729e.setOnClickListener(this);
            this.f57730f.setOnClickListener(this);
            this.f57731g.setOnClickListener(this);
            this.f57732h.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.m == null) {
            return;
        }
        int id = view.getId();
        this.n = view;
        StatisticItem statisticItem = new StatisticItem("c12495");
        if (id == R.id.img_music) {
            this.m.onClickMusic();
            statisticItem.param("obj_type", 6);
        } else if (id == R.id.img_sticker) {
            this.m.onClickSticker();
            statisticItem.param("obj_type", 4);
        } else if (id == R.id.img_beauty) {
            this.m.onClickBeauty();
            statisticItem.param("obj_type", 3);
        } else if (id == R.id.img_filter) {
            this.m.onClickFilter();
            statisticItem.param("obj_type", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    @Override // c.a.r0.x3.l.h.b
    public void onStatusChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 == 1) {
                this.f57729e.setImageResource(R.drawable.icon_video_music);
            } else {
                this.f57729e.setImageResource(R.drawable.icon_video_music_disable);
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void setListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public void setViewChoosed(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 0) {
                this.f57729e.setSelected(z);
            } else if (i2 == 1) {
                this.f57730f.setSelected(z);
            } else if (i2 == 2) {
                this.f57731g.setSelected(z);
            } else if (i2 != 3) {
            } else {
                this.f57732h.setSelected(z);
            }
        }
    }

    public void setViewVisibility(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            if (i2 == 0) {
                this.f57733i.setVisibility(i3);
            } else if (i2 == 1) {
                this.f57734j.setVisibility(i3);
            } else if (i2 == 2) {
                this.k.setVisibility(i3);
            } else if (i2 != 3) {
            } else {
                this.l.setVisibility(i3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEffectButtonLayout(Context context, AttributeSet attributeSet) {
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
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEffectButtonLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }
}
