package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c.a.q0.s.q.d2;
import c.a.q0.s.u.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FakeVideoContainer extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f56179e;

    /* renamed from: f  reason: collision with root package name */
    public View f56180f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56181g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f56182h;
    public View.OnClickListener mAfterClickListener;
    public Context mContext;
    public View.OnClickListener mJumpToPbListener;
    public BdUniqueId mUniqueId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FakeVideoContainer(Context context) {
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
        this.mAfterClickListener = null;
        this.mJumpToPbListener = null;
        init();
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.fake_video_container, this);
            this.f56179e = (TbImageView) findViewById(R.id.video_thumbnail);
            this.f56180f = findViewById(R.id.black_mask);
            this.f56181g = (ImageView) findViewById(R.id.video_play);
            this.f56182h = (EMTextView) findViewById(R.id.fake_video_info);
            this.f56181g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            c d2 = c.d(this.f56182h);
            d2.v(R.color.CAM_X0101);
            d2.A(R.string.F_X01);
            this.f56179e.clearCornerFlag();
            this.f56179e.setDrawCorner(false);
            this.f56179e.setPlaceHolder(3);
            setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            BdToast.i(getContext(), getContext().getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) || d2Var == null || d2Var.q1() == null) {
            return;
        }
        d2Var.q1().is_vertical.intValue();
        this.f56179e.setPlaceHolder(3);
        if (!d2Var.q1().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !d2Var.q1().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            this.f56179e.startLoad(d2Var.q1().thumbnail_url, 32, false);
        } else {
            this.f56179e.startLoad(d2Var.q1().thumbnail_url, 10, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FakeVideoContainer(Context context, AttributeSet attributeSet) {
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
        this.mAfterClickListener = null;
        this.mJumpToPbListener = null;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FakeVideoContainer(Context context, AttributeSet attributeSet, int i2) {
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
        this.mAfterClickListener = null;
        this.mJumpToPbListener = null;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FakeVideoContainer(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mAfterClickListener = null;
        this.mJumpToPbListener = null;
        init();
    }
}
