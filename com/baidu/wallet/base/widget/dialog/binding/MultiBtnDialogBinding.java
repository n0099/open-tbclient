package com.baidu.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.dialog.model.MultiBtnDialogModel;
/* loaded from: classes6.dex */
public class MultiBtnDialogBinding extends BaseBinding<MultiBtnDialogModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f49436b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f49437c;

    /* renamed from: d  reason: collision with root package name */
    public final Button f49438d;

    /* renamed from: e  reason: collision with root package name */
    public final Button f49439e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiBtnDialogBinding(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f49436b = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
        this.f49437c = (Button) view.findViewById(ResUtils.id(this.context, "first_btn"));
        this.f49438d = (Button) view.findViewById(ResUtils.id(this.context, "second_btn"));
        this.f49439e = (Button) view.findViewById(ResUtils.id(this.context, "third_btn"));
    }

    @Override // com.baidu.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        TextPaint paint;
        TextPaint paint2;
        TextPaint paint3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            T t = this.viewModel;
            if (((MultiBtnDialogModel) t).titleId != 0) {
                this.a.setText(((MultiBtnDialogModel) t).titleId);
            } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t).titleText)) {
                this.a.setText(((MultiBtnDialogModel) this.viewModel).titleText);
            }
            T t2 = this.viewModel;
            if (((MultiBtnDialogModel) t2).messageId != 0) {
                this.f49436b.setText(((MultiBtnDialogModel) t2).messageId);
            } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t2).message)) {
                this.f49436b.setText(((MultiBtnDialogModel) this.viewModel).message);
            }
            this.f49437c.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
            this.f49438d.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
            this.f49439e.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
            T t3 = this.viewModel;
            if (((MultiBtnDialogModel) t3).firstBtnClickListener != null) {
                this.f49437c.setOnClickListener(((MultiBtnDialogModel) t3).firstBtnClickListener);
            }
            T t4 = this.viewModel;
            if (((MultiBtnDialogModel) t4).secondBtnClickListener != null) {
                this.f49438d.setOnClickListener(((MultiBtnDialogModel) t4).secondBtnClickListener);
            }
            T t5 = this.viewModel;
            if (((MultiBtnDialogModel) t5).thirdBtnClickListener != null) {
                this.f49439e.setOnClickListener(((MultiBtnDialogModel) t5).thirdBtnClickListener);
            }
            T t6 = this.viewModel;
            if (((MultiBtnDialogModel) t6).firstBtnTextId != 0) {
                this.f49437c.setText(((MultiBtnDialogModel) t6).firstBtnTextId);
            } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t6).firstBtnText)) {
                this.f49437c.setText(((MultiBtnDialogModel) this.viewModel).firstBtnText);
            }
            T t7 = this.viewModel;
            if (((MultiBtnDialogModel) t7).secondBtnTextId != 0) {
                this.f49438d.setText(((MultiBtnDialogModel) t7).secondBtnTextId);
            } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t7).secondBtnText)) {
                this.f49438d.setText(((MultiBtnDialogModel) this.viewModel).secondBtnText);
            }
            T t8 = this.viewModel;
            if (((MultiBtnDialogModel) t8).thirdBtnTextId != 0) {
                this.f49439e.setText(((MultiBtnDialogModel) t8).thirdBtnTextId);
            } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t8).thirdBtnText)) {
                this.f49439e.setText(((MultiBtnDialogModel) this.viewModel).thirdBtnText);
            }
            if (((MultiBtnDialogModel) this.viewModel).firstBtnTextBold && (paint3 = this.f49437c.getPaint()) != null) {
                paint3.setFakeBoldText(true);
            }
            if (((MultiBtnDialogModel) this.viewModel).secondBtnTextBold && (paint2 = this.f49438d.getPaint()) != null) {
                paint2.setFakeBoldText(true);
            }
            if (!((MultiBtnDialogModel) this.viewModel).thirdBtnTextBold || (paint = this.f49439e.getPaint()) == null) {
                return;
            }
            paint.setFakeBoldText(true);
        }
    }
}
