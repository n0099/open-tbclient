package com.baidu.tieba.write.write;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.q0.s.q.d2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class FeedBackTopListView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f55967e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d2> f55968f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f55969g;

    /* renamed from: h  reason: collision with root package name */
    public int f55970h;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55971e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FeedBackTopListView f55972f;

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
            this.f55972f = feedBackTopListView;
            this.f55971e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f55972f.f55967e).createNormalCfg(this.f55971e, null, WriteActivityConfig.FEED_BACK)));
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

    public final View b(d2 d2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, d2Var, i2)) == null) {
            if (d2Var == null) {
                return null;
            }
            View inflate = LayoutInflater.from(this.f55967e).inflate(R.layout.frs_top_item, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.frs_top_item);
            TextView textView = (TextView) inflate.findViewById(R.id.frs_top_title);
            inflate.findViewById(R.id.frs_top_divider);
            String s1 = d2Var.s1();
            textView.setText(d2Var.getTitle());
            this.f55969g.getLayoutMode().k(this.f55970h == 1);
            this.f55969g.getLayoutMode().j(inflate);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_notice);
            SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_frs_top_middle_selector);
            if (bitmapDrawable != null) {
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            }
            textView.setCompoundDrawables(bitmapDrawable, null, null, null);
            linearLayout.setOnClickListener(new a(this, s1));
            return inflate;
        }
        return (View) invokeLI.objValue;
    }

    public void c(ArrayList<d2> arrayList, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, tbPageContext) == null) {
            this.f55969g = tbPageContext;
            if (arrayList != null && arrayList.size() != 0) {
                setVisibility(0);
                if (arrayList.size() > 3) {
                    this.f55968f = new ArrayList<>(arrayList.subList(0, 3));
                } else {
                    this.f55968f = arrayList;
                }
                for (int i2 = 0; i2 < this.f55968f.size(); i2++) {
                    addView(b(this.f55968f.get(i2), i2));
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
        this.f55967e = null;
        this.f55968f = null;
        this.f55970h = 3;
        this.f55967e = context;
        this.f55970h = TbadkCoreApplication.getInst().getSkinType();
    }
}
