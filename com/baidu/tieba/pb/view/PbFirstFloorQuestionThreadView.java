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
import com.baidu.tieba.d85;
import com.baidu.tieba.du6;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.xm9;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
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
    public du6 h;
    public boolean i;

    /* loaded from: classes7.dex */
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
                if (this.a.h != null && this.a.h.i()) {
                    this.a.h.h();
                    xm9.v("c14884");
                }
                xm9.v("c14885");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921724));
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null) {
                this.a.h.h();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorQuestionThreadView a;

        public c(PbFirstFloorQuestionThreadView pbFirstFloorQuestionThreadView) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = new int[2];
                this.a.c.getLocationOnScreen(iArr);
                int i = iArr[1];
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f070420);
                if (this.a.g || i <= dimenPixelSize) {
                    return;
                }
                this.a.g = true;
                this.a.j();
            }
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
        h(context);
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
        h(context);
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
        h(context);
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.i = z;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.e = tbPageContext;
        }
    }

    public void f() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.i && this.f && !this.g && getVisibility() != 8 && (textView = this.c) != null && textView.getVisibility() != 8) {
            this.c.post(new c(this));
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0783, (ViewGroup) this, true);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091dd3);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091dd0);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091dd4);
            this.d = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f091dd5);
            i();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0109);
            d85.d(this.c).x(R.color.CAM_X0302);
            this.d.setAllCornerRound(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42));
            SkinManager.setBackgroundColorWithAlpha(this.d, R.color.CAM_X0304, 0.08f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            du6 du6Var = new du6(this.e, this.c);
            this.h = du6Var;
            du6Var.L(R.drawable.ic_question_tip_arror);
            this.h.x(true);
            this.h.N(true);
            this.h.l(2);
            this.h.o(48);
            this.h.C(R.color.CAM_X0101);
            this.h.J(R.dimen.tbds29);
            this.h.I(UtilHelper.getDimenPixelSize(R.dimen.M_H_X002));
            this.h.F(UtilHelper.getDimenPixelSize(R.dimen.tbds29));
            this.h.G(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            this.h.H(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            this.h.R(-UtilHelper.getDimenPixelSize(R.dimen.M_H_X001));
            this.h.B(100);
            this.h.n(3000);
            String string = getContext().getString(R.string.pb_ask_post_first_tip);
            this.h.m(new b(this));
            this.h.S(string);
            xm9.v("c14883");
        }
    }

    public void setData(ThreadData threadData, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{threadData, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (threadData != null && threadData.isQuestionThread()) {
                setVisibility(0);
                int reply_num = threadData.getReply_num();
                if (j <= 0) {
                    this.a.setVisibility(8);
                    ((LinearLayout.LayoutParams) this.b.getLayoutParams()).leftMargin = 0;
                } else {
                    this.a.setVisibility(0);
                    TextView textView = this.a;
                    textView.setText(j + getContext().getString(R.string.pb_ask_post_read));
                }
                if (reply_num <= 0) {
                    this.b.setText(getContext().getString(R.string.pb_ask_post_answer_no));
                    this.c.setText(getContext().getString(R.string.pb_ask_post_first_answer));
                    this.f = true;
                } else {
                    TextView textView2 = this.b;
                    textView2.setText(reply_num + getContext().getString(R.string.pb_ask_post_answer));
                    this.c.setText(getContext().getString(R.string.pb_ask_post_answer));
                }
                this.c.setOnClickListener(new a(this));
                if (z) {
                    this.d.setAlpha(0.33f);
                    this.c.setClickable(false);
                } else {
                    this.d.setAlpha(1.0f);
                    this.c.setClickable(true);
                }
                f();
                return;
            }
            setVisibility(8);
        }
    }
}
