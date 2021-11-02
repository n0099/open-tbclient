package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class SearchPageFocusBar extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MIN_NUM_SHOW_ENTERFORUM_ICON = 7;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f51317e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f51318f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f51319g;

    /* renamed from: h  reason: collision with root package name */
    public Context f51320h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51321i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f51322e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SearchPageFocusBar f51323f;

        public a(SearchPageFocusBar searchPageFocusBar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchPageFocusBar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51323f = searchPageFocusBar;
            this.f51322e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51322e.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f51322e.getPageActivity()).createNormalCfg(1)));
            }
        }
    }

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
            this.f51320h = context;
            LayoutInflater.from(context).inflate(R.layout.home_search_focusbar, this);
            this.f51317e = (RelativeLayout) findViewById(R.id.focusbar_container);
            TextView textView = (TextView) findViewById(R.id.focusbar_hint);
            this.f51321i = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0108, 1);
            this.f51321i.setVisibility(8);
            TextView textView2 = (TextView) findViewById(R.id.focusbar_show);
            this.f51318f = textView2;
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1);
            this.f51318f.setVisibility(8);
        }
    }

    public final void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            int dimension = i2 % 2 > 0 ? (int) getResources().getDimension(R.dimen.ds330) : 0;
            TextView textView = (TextView) LayoutInflater.from(this.f51320h).inflate(R.layout.home_search_focusbar_item, (ViewGroup) null);
            int dimension2 = (i2 / 2) * ((int) getResources().getDimension(R.dimen.ds110));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) getResources().getDimension(R.dimen.ds321), (int) getResources().getDimension(R.dimen.ds96));
            layoutParams.leftMargin = dimension;
            layoutParams.topMargin = dimension2;
            textView.setLayoutParams(layoutParams);
            textView.setText(str);
            textView.setOnClickListener(this);
            SkinManager.setBackgroundResource(textView, R.drawable.home_like_item_bg);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
            this.f51317e.addView(textView);
        }
    }

    public void fillData(List<String> list, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, tbPageContext) == null) {
            this.f51319g = tbPageContext;
            this.f51317e.removeAllViews();
            if (list != null && list.size() > 0) {
                this.f51321i.setVisibility(0);
                for (int i2 = 0; i2 < list.size() && i2 <= 5; i2++) {
                    b(list.get(i2), i2);
                }
            }
            if (list == null || list.size() < 7) {
                return;
            }
            this.f51318f.setVisibility(0);
            this.f51318f.setOnClickListener(new a(this, tbPageContext));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && (view instanceof TextView)) {
            String charSequence = ((TextView) view).getText().toString();
            if (StringUtils.isNull(charSequence)) {
                return;
            }
            this.f51319g.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f51319g.getPageActivity()).createNormalCfg(charSequence, FrsActivityConfig.FRS_FROM_SEARCH)));
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
