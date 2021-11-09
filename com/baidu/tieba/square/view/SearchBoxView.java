package com.baidu.tieba.square.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.a.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.CaptureActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class SearchBoxView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f54153e;

    /* renamed from: f  reason: collision with root package name */
    public String f54154f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f54155g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54156h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54157i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SearchBoxView f54158e;

        public a(SearchBoxView searchBoxView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchBoxView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54158e = searchBoxView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CaptureActivityConfig(this.f54158e.f54153e, 16003)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SearchBoxView f54159e;

        public b(SearchBoxView searchBoxView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchBoxView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54159e = searchBoxView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == R.id.search_bg_layout) {
                TiebaStatic.eventStat(this.f54159e.f54153e, this.f54159e.f54154f, PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.f54159e.f54153e)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBoxView(Context context) {
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
        this.f54154f = "sq_tb_search";
        this.f54155g = null;
        this.f54156h = null;
        this.f54157i = null;
        this.j = new a(this);
        this.k = new b(this);
        c(context);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f54153e = (Activity) context;
            LayoutInflater.from(context).inflate(R.layout.widget_search_box, this);
            this.f54155g = (LinearLayout) findViewById(R.id.search_bg_layout);
            this.f54156h = (TextView) findViewById(R.id.search_bar_text);
            this.f54155g.setOnClickListener(this.k);
            TextView textView = (TextView) findViewById(R.id.search_from_qr);
            this.f54157i = textView;
            textView.setOnClickListener(this.j);
        }
    }

    public void onChangeSkinType(f<?> fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, i2) == null) {
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(i2 == 1);
                tbPageContext.getLayoutMode().j(this);
            }
            this.f54156h.setHintTextColor(SkinManager.getColor(R.color.common_color_10221));
            SkinManager.setBackgroundColor(this, R.color.common_color_10192);
        }
    }

    public void setClickStatKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f54154f = str;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f54155g.setOnClickListener(onClickListener);
    }

    public void setText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
            this.f54156h.setHint(charSequence);
        }
    }

    public void showQuickResponse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f54157i.setVisibility(0);
        }
    }

    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f54156h.setHint(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBoxView(Context context, AttributeSet attributeSet) {
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
        this.f54154f = "sq_tb_search";
        this.f54155g = null;
        this.f54156h = null;
        this.f54157i = null;
        this.j = new a(this);
        this.k = new b(this);
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBoxView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f54154f = "sq_tb_search";
        this.f54155g = null;
        this.f54156h = null;
        this.f54157i = null;
        this.j = new a(this);
        this.k = new b(this);
        c(context);
    }
}
