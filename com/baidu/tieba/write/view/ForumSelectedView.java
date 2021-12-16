package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.r0.s.v.c;
import c.a.s0.n4.d;
import c.a.s0.n4.f;
import c.a.s0.n4.g;
import c.a.s0.n4.h;
import c.a.s0.n4.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class ForumSelectedView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f51445e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f51446f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51447g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51448h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f51449i;

    /* renamed from: j  reason: collision with root package name */
    public View f51450j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForumSelectedView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(h.cell_forum_selected_layout, (ViewGroup) this, true);
            this.f51446f = (ImageView) findViewById(g.cell_forum_selected_icon);
            this.f51447g = (TextView) findViewById(g.cell_forum_selected_name);
            this.f51448h = (TextView) findViewById(g.cell_forum_selected_tip);
            this.f51449i = (ImageView) findViewById(g.cell_forum_selected_arrow);
            this.f51450j = findViewById(g.cell_forum_selected_line);
            setOnClickListener(this);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f51445e) {
            return;
        }
        this.f51445e = skinType;
        SkinManager.setBackgroundResource(this, f.forum_selected_view_bg);
        this.f51446f.setImageDrawable(WebPManager.getPureDrawable(f.icon_pure_ba16, SkinManager.getColor(d.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        SkinManager.setViewTextColor(this.f51447g, d.CAM_X0105);
        SkinManager.setViewTextColor(this.f51448h, d.CAM_X0109);
        c d2 = c.d(this.f51448h);
        d2.n(j.J_X06);
        d2.f(d.CAM_X0206);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f51449i, f.icon_pure_list_arrow16_right_svg, d.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.f51450j, d.CAM_X0210);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(getContext())));
        }
    }

    public void setSelectedForum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f51448h.setVisibility(8);
            this.f51447g.setText(str);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForumSelectedView(Context context, AttributeSet attributeSet) {
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
    public ForumSelectedView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51445e = 3;
        a();
    }
}
