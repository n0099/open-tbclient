package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.g;
import c.a.s0.z3.a;
import c.a.s0.z3.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class NewUserGuideImgShowBox extends Dialog implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f49978e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49979f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49980g;

    /* renamed from: h  reason: collision with root package name */
    public View f49981h;

    /* renamed from: i  reason: collision with root package name */
    public View f49982i;

    /* renamed from: j  reason: collision with root package name */
    public InterestFrsData.Tag f49983j;

    /* renamed from: k  reason: collision with root package name */
    public b f49984k;
    public GridView l;
    public LinearLayout m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserGuideImgShowBox(Context context) {
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
        this.f49978e = context;
        a();
    }

    @Override // c.a.s0.z3.a
    public void ForumLike(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f49984k.notifyDataSetChanged();
        }
    }

    @Override // c.a.s0.z3.a
    public void ForumUnLike(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f49984k.notifyDataSetChanged();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49982i = View.inflate(this.f49978e, R.layout.new_user_img_box, null);
            this.f49984k = new b(this.f49978e);
            setCanceledOnTouchOutside(true);
            this.m = (LinearLayout) this.f49982i.findViewById(R.id.box_close_layout);
            GridView gridView = (GridView) this.f49982i.findViewById(R.id.layout_content);
            this.l = gridView;
            gridView.setAdapter((ListAdapter) this.f49984k);
            this.l.setSelector(R.color.common_color_10022);
            setContentView(this.f49982i);
            this.f49979f = (TextView) this.f49982i.findViewById(R.id.prompt_title);
            this.f49980g = (TextView) this.f49982i.findViewById(R.id.prompt_sub_title);
            View findViewById = this.f49982i.findViewById(R.id.view_layout);
            this.f49981h = findViewById;
            findViewById.setBackgroundDrawable(this.f49978e.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
        }
    }

    @Override // c.a.s0.z3.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49982i : (View) invokeV.objValue;
    }

    @Override // android.app.Dialog, c.a.s0.z3.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = this.f49978e;
            if (context instanceof Activity) {
                g.a(this, (Activity) context);
            } else {
                super.dismiss();
            }
        }
    }

    @Override // c.a.s0.z3.a
    public void setData(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tag) == null) {
            this.f49983j = tag;
            if (tag != null) {
                this.f49979f.setText(tag.getBname());
                this.f49980g.setText(tag.getBdesc());
                this.f49984k.a(tag.getCard_list());
            }
        }
    }

    @Override // c.a.s0.z3.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.m.setOnClickListener(onClickListener);
            this.f49984k.c(onClickListener);
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f49980g.setText(str);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f49979f.setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserGuideImgShowBox(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49978e = context;
        a();
    }
}
