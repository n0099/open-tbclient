package com.baidu.tieba.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rl4;
import java.text.DecimalFormat;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class PbVideoWifiTipLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public View.OnClickListener f;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbVideoWifiTipLayout a;

        public a(PbVideoWifiTipLayout pbVideoWifiTipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbVideoWifiTipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbVideoWifiTipLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                rl4.z(true, this.a.getContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06c2), TbConfig.URL_BAIDU_SINGKIL);
                if (this.a.f != null) {
                    this.a.f.onClick(view2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoWifiTipLayout(Context context) {
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
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04ee, this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0922b0);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0922af);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f092277);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f092223);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092266);
            this.e = textView;
            textView.setOnClickListener(new a(this));
        }
    }

    public TextView getTvOpenFreeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (TextView) invokeV.objValue;
    }

    public TextView getTvPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (TextView) invokeV.objValue;
    }

    public void setData(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, videoInfo) == null) || videoInfo == null) {
            return;
        }
        setData(videoInfo.video_duration.intValue(), videoInfo.video_length.intValue());
    }

    public void setFreeClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void setOnPlayClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.c.setOnClickListener(onClickListener);
        }
    }

    public void setData(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            if (i > 0) {
                this.a.setText(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0de0), StringHelper.stringForVideoTime(i * 1000)));
            } else {
                this.a.setVisibility(8);
                this.d.setVisibility(8);
            }
            if (i2 > 0) {
                this.b.setText(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0ddc), new DecimalFormat("0.0").format(i2 / 1048576.0f)));
            } else {
                this.b.setVisibility(8);
                this.d.setVisibility(8);
            }
            this.e.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoWifiTipLayout(Context context, AttributeSet attributeSet) {
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
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoWifiTipLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        b();
    }
}
