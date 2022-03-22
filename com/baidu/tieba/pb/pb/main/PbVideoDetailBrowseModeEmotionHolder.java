package com.baidu.tieba.pb.pb.main;

import android.view.View;
import c.a.o0.r.l0.n.b;
import c.a.o0.r.v.c;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/PbVideoDetailBrowseModeEmotionHolder;", "Lcom/baidu/adp/widget/ListView/TypeAdapter$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "agreeBtn", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "descriptionText", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "emotionImg", "Lcom/baidu/adp/newwidget/ImageView/BDImageView;", "value", "Landroid/view/View$OnClickListener;", "onAgreeListener", "getOnAgreeListener", "()Landroid/view/View$OnClickListener;", "setOnAgreeListener", "(Landroid/view/View$OnClickListener;)V", "onChangeSkinType", "", "pb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PbVideoDetailBrowseModeEmotionHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BDImageView a;

    /* renamed from: b  reason: collision with root package name */
    public final EMTextView f35001b;

    /* renamed from: c  reason: collision with root package name */
    public final TBSpecificationBtn f35002c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f35003d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoDetailBrowseModeEmotionHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = b().findViewById(R.id.obfuscated_res_0x7f090887);
        Intrinsics.checkNotNullExpressionValue(findViewById, "getView().findViewById(R.id.emotion_img)");
        this.a = (BDImageView) findViewById;
        View findViewById2 = b().findViewById(R.id.obfuscated_res_0x7f090785);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "getView().findViewById(R.id.description_text)");
        this.f35001b = (EMTextView) findViewById2;
        View findViewById3 = b().findViewById(R.id.obfuscated_res_0x7f09014f);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "getView().findViewById(R.id.agree_btn)");
        this.f35002c = (TBSpecificationBtn) findViewById3;
        SkinManager.setImageResource(this.a, R.drawable.new_pic_emotion_01);
        this.f35001b.setText(R.string.obfuscated_res_0x7f0f0dc4);
        c.d(this.f35001b).v(R.color.CAM_X0107);
        b bVar = new b();
        bVar.p(R.color.CAM_X0303, R.color.CAM_X0101);
        this.f35002c.setConfig(bVar);
        this.f35002c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dc3));
        this.f35002c.setTextSize(R.dimen.T_X07);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setImageResource(this.a, R.drawable.new_pic_emotion_01);
            c.d(this.f35001b).v(R.color.CAM_X0107);
            this.f35002c.k();
        }
    }

    public final void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f35003d = onClickListener;
            if (onClickListener == null) {
                return;
            }
            this.f35002c.setOnClickListener(onClickListener);
        }
    }
}
