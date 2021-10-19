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
import c.a.e.e.m.g;
import c.a.r0.o3.a;
import c.a.r0.o3.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class NewUserGuideImgShowBox extends Dialog implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f57381e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57382f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57383g;

    /* renamed from: h  reason: collision with root package name */
    public View f57384h;

    /* renamed from: i  reason: collision with root package name */
    public View f57385i;

    /* renamed from: j  reason: collision with root package name */
    public InterestFrsData.Tag f57386j;
    public b k;
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
        this.f57381e = context;
        a();
    }

    @Override // c.a.r0.o3.a
    public void ForumLike(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.k.notifyDataSetChanged();
        }
    }

    @Override // c.a.r0.o3.a
    public void ForumUnLike(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.k.notifyDataSetChanged();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f57385i = View.inflate(this.f57381e, R.layout.new_user_img_box, null);
            this.k = new b(this.f57381e);
            setCanceledOnTouchOutside(true);
            this.m = (LinearLayout) this.f57385i.findViewById(R.id.box_close_layout);
            GridView gridView = (GridView) this.f57385i.findViewById(R.id.layout_content);
            this.l = gridView;
            gridView.setAdapter((ListAdapter) this.k);
            this.l.setSelector(R.color.common_color_10022);
            setContentView(this.f57385i);
            this.f57382f = (TextView) this.f57385i.findViewById(R.id.prompt_title);
            this.f57383g = (TextView) this.f57385i.findViewById(R.id.prompt_sub_title);
            View findViewById = this.f57385i.findViewById(R.id.view_layout);
            this.f57384h = findViewById;
            findViewById.setBackgroundDrawable(this.f57381e.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
        }
    }

    @Override // c.a.r0.o3.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57385i : (View) invokeV.objValue;
    }

    @Override // android.app.Dialog, c.a.r0.o3.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = this.f57381e;
            if (context instanceof Activity) {
                g.a(this, (Activity) context);
            } else {
                super.dismiss();
            }
        }
    }

    @Override // c.a.r0.o3.a
    public void setData(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tag) == null) {
            this.f57386j = tag;
            if (tag != null) {
                this.f57382f.setText(tag.getBname());
                this.f57383g.setText(tag.getBdesc());
                this.k.a(tag.getCard_list());
            }
        }
    }

    @Override // c.a.r0.o3.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.m.setOnClickListener(onClickListener);
            this.k.c(onClickListener);
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f57383g.setText(str);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f57382f.setText(str);
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
        this.f57381e = context;
        a();
    }
}
