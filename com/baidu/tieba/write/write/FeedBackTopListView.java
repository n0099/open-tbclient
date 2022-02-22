package com.baidu.tieba.write.write;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.t0.s.r.e2;
import c.a.u0.s4.f;
import c.a.u0.s4.g;
import c.a.u0.s4.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class FeedBackTopListView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f49978e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<e2> f49979f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f49980g;

    /* renamed from: h  reason: collision with root package name */
    public int f49981h;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49982e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FeedBackTopListView f49983f;

        public a(FeedBackTopListView feedBackTopListView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedBackTopListView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49983f = feedBackTopListView;
            this.f49982e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f49983f.f49978e).createNormalCfg(this.f49982e, null, WriteActivityConfig.FEED_BACK)));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedBackTopListView(Context context) {
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

    public final View b(e2 e2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, e2Var, i2)) == null) {
            if (e2Var == null) {
                return null;
            }
            View inflate = LayoutInflater.from(this.f49978e).inflate(h.frs_top_item, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(g.frs_top_item);
            TextView textView = (TextView) inflate.findViewById(g.frs_top_title);
            inflate.findViewById(g.frs_top_divider);
            String w1 = e2Var.w1();
            textView.setText(e2Var.getTitle());
            this.f49980g.getLayoutMode().k(this.f49981h == 1);
            this.f49980g.getLayoutMode().j(inflate);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(f.icon_notice);
            SkinManager.setBackgroundResource(linearLayout, f.bg_frs_top_middle_selector);
            if (bitmapDrawable != null) {
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            }
            textView.setCompoundDrawables(bitmapDrawable, null, null, null);
            linearLayout.setOnClickListener(new a(this, w1));
            return inflate;
        }
        return (View) invokeLI.objValue;
    }

    public void c(ArrayList<e2> arrayList, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, tbPageContext) == null) {
            this.f49980g = tbPageContext;
            if (arrayList != null && arrayList.size() != 0) {
                setVisibility(0);
                if (arrayList.size() > 3) {
                    this.f49979f = new ArrayList<>(arrayList.subList(0, 3));
                } else {
                    this.f49979f = arrayList;
                }
                for (int i2 = 0; i2 < this.f49979f.size(); i2++) {
                    addView(b(this.f49979f.get(i2), i2));
                }
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
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
        this.f49978e = null;
        this.f49979f = null;
        this.f49981h = 3;
        this.f49978e = context;
        this.f49981h = TbadkCoreApplication.getInst().getSkinType();
    }
}
