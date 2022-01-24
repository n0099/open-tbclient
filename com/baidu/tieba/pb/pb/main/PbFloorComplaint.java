package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c.a.s0.s.u.c;
import c.a.t0.t2.f;
import c.a.t0.t2.g;
import c.a.t0.t2.h;
import c.a.t0.t2.i;
import c.a.t0.t2.j;
import c.a.t0.t2.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PbFloorComplaint extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DO_NOT_SHOW_REMIND = 0;
    public static final int FOLDED_AND_APPEAL_FAILED = 3;
    public static final int FOLDED_AND_APPEAL_PROCESSING = 2;
    public static final int HAS_BEEN_FOLDED = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f46485e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f46486f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f46487g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f46488h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f46489i;

    /* renamed from: j  reason: collision with root package name */
    public int f46490j;
    public int k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbFloorComplaint(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(j.pb_reply_floor_complaint_reminder, (ViewGroup) this, true);
            this.f46485e = (ImageView) findViewById(i.remind_icon);
            this.f46486f = (ImageView) findViewById(i.right_icon);
            this.f46487g = (EMTextView) findViewById(i.remind_text);
            this.f46488h = (EMTextView) findViewById(i.reply_remind);
            this.f46489i = (RelativeLayout) findViewById(i.folding_prompt);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ImageView imageView = this.f46485e;
            if (imageView != null) {
                imageView.invalidate();
            }
            int i2 = this.f46490j;
            if (i2 == 1) {
                this.f46487g.setText(l.reply_has_been_folded);
                c.d(this.f46487g).v(f.CAM_X0301);
            } else if (i2 == 2) {
                this.f46487g.setText(l.folded_and_complaint);
                c.d(this.f46487g).v(f.CAM_X0105);
            } else if (i2 == 3) {
                this.f46487g.setText(l.folded_and_not_complain);
                c.d(this.f46487g).v(f.CAM_X0301);
            } else {
                this.f46487g.setText(l.reply_has_been_folded);
                c.d(this.f46487g).v(f.CAM_X0301);
            }
            int i3 = this.k;
            if (i3 == 1 || i3 == 3) {
                WebPManager.setPureDrawable(this.f46485e, h.icon_pure_warning, f.CAM_X0301, null);
            } else if (i3 == 2) {
                WebPManager.setPureDrawable(this.f46485e, h.icon_pure_await12, f.CAM_X0105, null);
            } else {
                WebPManager.setPureDrawable(this.f46485e, h.icon_pure_warning, f.CAM_X0301, null);
            }
            WebPManager.setPureDrawable(this.f46486f, h.icon_pure_arrow14_right_n, f.CAM_X0304, null);
            c d2 = c.d(this.f46488h);
            d2.v(f.CAM_X0107);
            d2.z(g.T_X09);
        }
    }

    public void setAmendIconListener(View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (relativeLayout = this.f46489i) == null) {
            return;
        }
        relativeLayout.setOnClickListener(onClickListener);
    }

    public void setRemindIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.k = i2;
            onChangeSkinType();
        }
    }

    public void setRemindText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f46490j = i2;
            onChangeSkinType();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbFloorComplaint(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFloorComplaint(Context context, AttributeSet attributeSet, int i2) {
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
        this.f46490j = 0;
        this.k = 0;
        a(context);
    }
}
