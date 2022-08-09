package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i08;
import com.repackage.ms4;
import com.repackage.o16;
import com.repackage.qi;
/* loaded from: classes4.dex */
public class PbFirstFloorQuestionThreadView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public RoundRelativeLayout d;
    public TbPageContext e;
    public boolean f;
    public boolean g;
    public o16 h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorQuestionThreadView a;

        public a(PbFirstFloorQuestionThreadView pbFirstFloorQuestionThreadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorQuestionThreadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFirstFloorQuestionThreadView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.h != null && this.a.h.O()) {
                    this.a.h.N();
                    i08.p("c14884");
                }
                i08.p("c14885");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921724));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorQuestionThreadView a;

        public b(PbFirstFloorQuestionThreadView pbFirstFloorQuestionThreadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorQuestionThreadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFirstFloorQuestionThreadView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.h == null) {
                return;
            }
            this.a.h.N();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorQuestionThreadView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        c(context);
    }

    public void b() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || !this.f || this.g || getVisibility() == 8 || (textView = this.c) == null || textView.getVisibility() == 8) {
            return;
        }
        this.g = true;
        e();
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06a6, (ViewGroup) this, true);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091aee);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091aeb);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091aef);
            this.d = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f091af0);
            d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0109);
            ms4.d(this.c).v(R.color.CAM_X0302);
            this.d.setAllCornerRound(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds42));
            SkinManager.setBackgroundColorWithAlpha(this.d, R.color.CAM_X0304, 0.08f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o16 o16Var = new o16(this.e, this.c);
            this.h = o16Var;
            o16Var.q0(R.drawable.obfuscated_res_0x7f080645);
            this.h.c0(true);
            this.h.r0(true);
            this.h.Q(2);
            this.h.T(48);
            this.h.h0(R.color.CAM_X0101);
            this.h.o0(R.dimen.tbds29);
            this.h.n0(UtilHelper.getDimenPixelSize(R.dimen.M_H_X002));
            this.h.k0(UtilHelper.getDimenPixelSize(R.dimen.tbds29));
            this.h.l0(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            this.h.m0(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            this.h.v0(-UtilHelper.getDimenPixelSize(R.dimen.M_H_X001));
            this.h.g0(100);
            this.h.S(3000);
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f0dbe);
            this.h.R(new b(this));
            this.h.w0(string);
            i08.p("c14883");
        }
    }

    public void setData(ThreadData threadData, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{threadData, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (threadData != null && threadData.isQuestionThread()) {
                setVisibility(0);
                int reply_num = threadData.getReply_num();
                if (j <= 0) {
                    this.a.setVisibility(8);
                    ((LinearLayout.LayoutParams) this.b.getLayoutParams()).leftMargin = 0;
                } else {
                    this.a.setVisibility(0);
                    TextView textView = this.a;
                    textView.setText(j + getContext().getString(R.string.obfuscated_res_0x7f0f0dbf));
                }
                if (reply_num <= 0) {
                    this.b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0dbc));
                    this.c.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0dbd));
                    this.f = true;
                } else {
                    TextView textView2 = this.b;
                    textView2.setText(reply_num + getContext().getString(R.string.obfuscated_res_0x7f0f0dbb));
                    this.c.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0dbb));
                }
                this.c.setOnClickListener(new a(this));
                if (z) {
                    this.d.setAlpha(0.33f);
                    this.c.setClickable(false);
                } else {
                    this.d.setAlpha(1.0f);
                    this.c.setClickable(true);
                }
                b();
                return;
            }
            setVisibility(8);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.e = tbPageContext;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorQuestionThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = false;
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorQuestionThreadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = false;
        c(context);
    }
}
