package com.baidu.tieba.immessagecenter.mention.reply;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.mention.reply.InteractionManagerSizer;
import com.baidu.tieba.p39;
import com.baidu.tieba.q39;
import com.baidu.tieba.t39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\"\u0010!\u001a\u00020\"2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u001e\u0010#\u001a\u00020\"2\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010$2\u0006\u0010%\u001a\u00020\u0016H\u0016J\u0012\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010(\u001a\u00020\"H\u0016J\b\u0010)\u001a\u00020\nH\u0017J\u0018\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0016H\u0016J\b\u0010-\u001a\u00020\"H\u0016J\u000e\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u0019J\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\fH\u0002J\u0010\u00102\u001a\u00020\"2\u0006\u00101\u001a\u00020\fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/tieba/immessagecenter/mention/reply/InteractionManagerSizer;", "Lcom/baidu/tieba/immessagecenter/mention/reply/AbsSizerView;", "Landroid/view/View$OnClickListener;", "Lcom/baidu/tieba/immessagecenter/mention/reply/OptionClickCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "divideLine", "Landroid/view/View;", "isCheckedThread", "", "isCheckedTime", "optionAdapter", "Lcom/baidu/tieba/immessagecenter/mention/reply/OptionAdapter;", "options", "", "Lcom/baidu/tieba/immessagecenter/mention/reply/OptionData;", "optionsView", "Lcom/baidu/tieba/immessagecenter/mention/reply/MaxHeightRecycleView;", "selectedThreadAnchor", "", "selectedTimeAnchor", "sizerCallback", "Lcom/baidu/tieba/immessagecenter/mention/reply/SizerCallback;", "threadDes", "Landroid/widget/TextView;", "threadIcon", "Landroid/widget/ImageView;", "timeDes", "timeIcon", "times", "onBindViewData", "", "onChangeSkinType", "Lcom/baidu/tbadk/TbPageContext;", WriteMulitImageActivityConfig.SKIN_TYPE, "onClick", "v", "onCreateMenuView", "onCreateOptionsView", "onOptionClick", "data", "anchor", "optionsDismiss", "setSizerCallback", WebChromeClient.KEY_ARG_CALLBACK, "updateThreadMenu", "isChecked", "updateTimeMenu", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InteractionManagerSizer extends AbsSizerView implements View.OnClickListener, p39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public ImageView c;
    public TextView d;
    public ImageView e;
    public View f;
    public MaxHeightRecycleView g;
    public boolean h;
    public boolean i;
    public OptionAdapter j;
    public List<q39> k;
    public List<q39> l;
    public t39 m;
    public int n;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionManagerSizer(Context context, AttributeSet attributeSet) {
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
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void h(InteractionManagerSizer this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b();
        }
    }

    public final void g(List<q39> options, List<q39> times) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, options, times) == null) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(times, "times");
            this.k = options;
            this.l = times;
        }
    }

    @Override // com.baidu.tieba.p39
    public void a(q39 data, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            int b = data.b();
            TextView textView = null;
            if (b != 0) {
                if (b == 1) {
                    this.o = i;
                    TextView textView2 = this.d;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timeDes");
                    } else {
                        textView = textView2;
                    }
                    textView.setText(data.a());
                }
            } else {
                this.n = i;
                TextView textView3 = this.b;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("threadDes");
                } else {
                    textView = textView3;
                }
                textView.setText(data.a());
            }
            t39 t39Var = this.m;
            if (t39Var != null) {
                t39Var.a(data);
            }
            b();
        }
    }

    @Override // com.baidu.tieba.it
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            EMManager.from(this).setBackGroundColor(R.color.CAM_X0208);
            View view2 = this.f;
            MaxHeightRecycleView maxHeightRecycleView = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("divideLine");
                view2 = null;
            }
            EMManager.from(view2).setBackGroundColor(R.color.CAM_X0203);
            MaxHeightRecycleView maxHeightRecycleView2 = this.g;
            if (maxHeightRecycleView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("optionsView");
            } else {
                maxHeightRecycleView = maxHeightRecycleView2;
            }
            EMManager.from(maxHeightRecycleView).setCorner(R.string.J_X17).setBackGroundColor(R.color.CAM_X0208);
            i(this.i);
            k(this.h);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.mention.reply.AbsSizerView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05ad, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0917a6);
            findViewById.setOnClickListener(this);
            View findViewById2 = findViewById.findViewById(R.id.obfuscated_res_0x7f091799);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "threadContainer.findViewById(R.id.menu_item_des)");
            TextView textView = (TextView) findViewById2;
            this.b = textView;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("threadDes");
                textView = null;
            }
            textView.setText(R.string.obfuscated_res_0x7f0f1447);
            View findViewById3 = findViewById.findViewById(R.id.obfuscated_res_0x7f09179a);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "threadContainer.findViewById(R.id.menu_item_icon)");
            this.c = (ImageView) findViewById3;
            View findViewById4 = findViewById(R.id.obfuscated_res_0x7f0917a7);
            findViewById4.setOnClickListener(this);
            View findViewById5 = findViewById4.findViewById(R.id.obfuscated_res_0x7f091799);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "timeContainer.findViewById(R.id.menu_item_des)");
            TextView textView3 = (TextView) findViewById5;
            this.d = textView3;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeDes");
            } else {
                textView2 = textView3;
            }
            textView2.setText(R.string.obfuscated_res_0x7f0f1448);
            View findViewById6 = findViewById4.findViewById(R.id.obfuscated_res_0x7f09179a);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "timeContainer.findViewById(R.id.menu_item_icon)");
            this.e = (ImageView) findViewById6;
            View findViewById7 = findViewById(R.id.obfuscated_res_0x7f09091d);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.divide_line)");
            this.f = findViewById7;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.mention.reply.AbsSizerView
    @SuppressLint({"InflateParams"})
    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            OptionAdapter optionAdapter = null;
            View optionsContainer = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05ae, (ViewGroup) null);
            optionsContainer.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.o39
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        InteractionManagerSizer.h(InteractionManagerSizer.this, view2);
                    }
                }
            });
            View findViewById = optionsContainer.findViewById(R.id.obfuscated_res_0x7f0922a0);
            Intrinsics.checkNotNullExpressionValue(findViewById, "optionsContainer.findVie….sizer_options_container)");
            MaxHeightRecycleView maxHeightRecycleView = (MaxHeightRecycleView) findViewById;
            this.g = maxHeightRecycleView;
            if (maxHeightRecycleView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("optionsView");
                maxHeightRecycleView = null;
            }
            maxHeightRecycleView.setMaxHeight(UtilHelper.getScreenHeight(TbadkApplication.getInst()) / 2);
            MaxHeightRecycleView maxHeightRecycleView2 = this.g;
            if (maxHeightRecycleView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("optionsView");
                maxHeightRecycleView2 = null;
            }
            maxHeightRecycleView2.setLayoutManager(new LinearLayoutManager(getContext()));
            OptionAdapter optionAdapter2 = new OptionAdapter();
            this.j = optionAdapter2;
            if (optionAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("optionAdapter");
                optionAdapter2 = null;
            }
            optionAdapter2.p(this);
            MaxHeightRecycleView maxHeightRecycleView3 = this.g;
            if (maxHeightRecycleView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("optionsView");
                maxHeightRecycleView3 = null;
            }
            OptionAdapter optionAdapter3 = this.j;
            if (optionAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("optionAdapter");
            } else {
                optionAdapter = optionAdapter3;
            }
            maxHeightRecycleView3.setAdapter(optionAdapter);
            Intrinsics.checkNotNullExpressionValue(optionsContainer, "optionsContainer");
            return optionsContainer;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.mention.reply.AbsSizerView
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.e();
            this.i = false;
            this.h = false;
            k(false);
            i(this.i);
        }
    }

    public final void i(boolean z) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            TextView textView = this.b;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("threadDes");
                textView = null;
            }
            EMManager from = EMManager.from(textView);
            int i4 = R.color.CAM_X0105;
            if (z) {
                i = R.color.CAM_X0105;
            } else {
                i = R.color.CAM_X0108;
            }
            EMManager textColor = from.setTextColor(i);
            if (z) {
                i2 = R.string.F_X02;
            } else {
                i2 = R.string.F_X01;
            }
            textColor.setTextStyle(i2);
            ImageView imageView = this.c;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("threadIcon");
                imageView = null;
            }
            if (z) {
                i3 = R.drawable.obfuscated_res_0x7f080cd1;
            } else {
                i3 = R.drawable.obfuscated_res_0x7f080cd0;
            }
            if (!z) {
                i4 = R.color.CAM_X0108;
            }
            WebPManager.setPureDrawable(imageView, i3, i4, null);
        }
    }

    public final void k(boolean z) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            TextView textView = this.d;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeDes");
                textView = null;
            }
            EMManager from = EMManager.from(textView);
            int i4 = R.color.CAM_X0105;
            if (z) {
                i = R.color.CAM_X0105;
            } else {
                i = R.color.CAM_X0108;
            }
            EMManager textColor = from.setTextColor(i);
            if (z) {
                i2 = R.string.F_X02;
            } else {
                i2 = R.string.F_X01;
            }
            textColor.setTextStyle(i2);
            ImageView imageView = this.e;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeIcon");
                imageView = null;
            }
            if (z) {
                i3 = R.drawable.obfuscated_res_0x7f080cd1;
            } else {
                i3 = R.drawable.obfuscated_res_0x7f080cd0;
            }
            if (!z) {
                i4 = R.color.CAM_X0108;
            }
            WebPManager.setPureDrawable(imageView, i3, i4, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (view2 != null) {
                i = view2.getId();
            } else {
                i = 0;
            }
            OptionAdapter optionAdapter = null;
            if (i == R.id.obfuscated_res_0x7f0917a7) {
                List<q39> list = this.l;
                if (list != null) {
                    OptionAdapter optionAdapter2 = this.j;
                    if (optionAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("optionAdapter");
                        optionAdapter2 = null;
                    }
                    optionAdapter2.m(list);
                }
                this.i = false;
                boolean z = !this.h;
                this.h = z;
                if (z) {
                    OptionAdapter optionAdapter3 = this.j;
                    if (optionAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("optionAdapter");
                    } else {
                        optionAdapter = optionAdapter3;
                    }
                    optionAdapter.q(this.o);
                    f();
                } else {
                    b();
                }
                k(this.h);
                i(this.i);
            } else if (i == R.id.obfuscated_res_0x7f0917a6) {
                List<q39> list2 = this.k;
                if (list2 != null) {
                    OptionAdapter optionAdapter4 = this.j;
                    if (optionAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("optionAdapter");
                        optionAdapter4 = null;
                    }
                    optionAdapter4.m(list2);
                }
                this.h = false;
                boolean z2 = !this.i;
                this.i = z2;
                if (z2) {
                    OptionAdapter optionAdapter5 = this.j;
                    if (optionAdapter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("optionAdapter");
                    } else {
                        optionAdapter = optionAdapter5;
                    }
                    optionAdapter.q(this.n);
                    f();
                } else {
                    b();
                }
                k(this.h);
                i(this.i);
            }
        }
    }

    public final void setSizerCallback(t39 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.m = callback;
        }
    }
}
