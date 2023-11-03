package com.baidu.tieba.write.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.pr7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class PostCategoryView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public MorePopupWindow b;
    public LinearLayout c;
    public LinearLayout d;
    public TabMenuPopView e;
    public View f;
    public Drawable g;
    public Drawable h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostCategoryView a;

        public a(PostCategoryView postCategoryView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postCategoryView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postCategoryView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_title_down);
        this.g = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.g.getIntrinsicHeight());
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_title_up);
        this.h = drawable2;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.g.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.g, null);
        setPadding(0, 0, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0703ec), 0);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0827, (ViewGroup) null);
        this.c = linearLayout;
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f091d5e);
        this.d = linearLayout2;
        this.e = (TabMenuPopView) linearLayout2.findViewById(R.id.obfuscated_res_0x7f091d5f);
        View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091d5d);
        this.f = findViewById;
        findViewById.setOnClickListener(new a(this));
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this, R.color.CAM_X0105, 1);
            LinearLayout linearLayout = this.d;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
            TabMenuPopView tabMenuPopView = this.e;
            if (tabMenuPopView != null) {
                tabMenuPopView.d();
            }
        }
    }

    public void b() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (morePopupWindow = this.b) != null) {
            morePopupWindow.dismiss();
        }
    }

    public void setCategoryContainerData(List<pr7> list, pr7 pr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, pr7Var) == null) {
            this.e.setData(list, pr7Var);
        }
    }
}
