package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SearchPageFocusBar extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f18358e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18359f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f18360g;

    /* renamed from: h  reason: collision with root package name */
    public Context f18361h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18362i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchPageFocusBar(Context context) {
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
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) {
            this.f18361h = context;
            LayoutInflater.from(context).inflate(R.layout.home_search_focusbar, this);
            this.f18358e = (RelativeLayout) findViewById(R.id.focusbar_container);
            TextView textView = (TextView) findViewById(R.id.focusbar_hint);
            this.f18362i = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0108, 1);
            this.f18362i.setVisibility(8);
            TextView textView2 = (TextView) findViewById(R.id.focusbar_show);
            this.f18359f = textView2;
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1);
            this.f18359f.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && (view instanceof TextView)) {
            String charSequence = ((TextView) view).getText().toString();
            if (StringUtils.isNull(charSequence)) {
                return;
            }
            this.f18360g.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18360g.getPageActivity()).createNormalCfg(charSequence, FrsActivityConfig.FRS_FROM_SEARCH)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchPageFocusBar(Context context, AttributeSet attributeSet) {
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
        a(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchPageFocusBar(Context context, AttributeSet attributeSet, int i2) {
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
        a(context, null);
    }
}
