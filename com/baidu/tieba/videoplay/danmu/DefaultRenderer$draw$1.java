package com.baidu.tieba.videoplay.danmu;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.fv4;
import com.baidu.tieba.nc6;
import com.baidu.tieba.r46;
import com.baidu.tieba.videoplay.danmu.DefaultRenderer$draw$1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.baidu.tieba.videoplay.danmu.DefaultRenderer$draw$1", f = "DefaultRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class DefaultRenderer$draw$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Canvas $canvas;
    public final /* synthetic */ r46 $danmakuItemData;
    public transient /* synthetic */ FieldHolder $fh;
    public int label;
    public final /* synthetic */ DefaultRenderer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultRenderer$draw$1(r46 r46Var, Canvas canvas, DefaultRenderer defaultRenderer, Continuation<? super DefaultRenderer$draw$1> continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r46Var, canvas, defaultRenderer, continuation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (Continuation) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$danmakuItemData = r46Var;
        this.$canvas = canvas;
        this.this$0 = defaultRenderer;
    }

    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m53invokeSuspend$lambda0(Canvas canvas, DefaultRenderer defaultRenderer, r46 r46Var, SpannableStringBuilder stringBuilder) {
        TextPaint textPaint;
        TextPaint textPaint2;
        TextPaint textPaint3;
        TextPaint textPaint4;
        Paint paint;
        int i;
        Paint paint2;
        int i2;
        Paint paint3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, canvas, defaultRenderer, r46Var, stringBuilder) == null) || canvas.getWidth() <= 6) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(stringBuilder, "stringBuilder");
        textPaint = defaultRenderer.d;
        StaticLayout h = defaultRenderer.h(stringBuilder, textPaint, canvas.getWidth() - 6);
        textPaint2 = defaultRenderer.c;
        StaticLayout h2 = defaultRenderer.h(stringBuilder, textPaint2, canvas.getWidth() - 6);
        textPaint3 = defaultRenderer.c;
        textPaint4 = defaultRenderer.c;
        canvas.save();
        canvas.translate(0.0f, (((textPaint3.getFontMetrics().descent + 17.43f) - textPaint4.getFontMetrics().bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3)) + r46Var.e());
        h.draw(canvas);
        h2.draw(canvas);
        canvas.restore();
        if (r46Var.g() == 8) {
            float[] y = fv4.y(R.string.J_X04);
            paint = defaultRenderer.e;
            float strokeWidth = paint.getStrokeWidth() * 0.2f;
            i = defaultRenderer.a;
            paint2 = defaultRenderer.e;
            i2 = defaultRenderer.a;
            float f = y[0];
            float f2 = y[1];
            paint3 = defaultRenderer.e;
            canvas.drawRoundRect(strokeWidth, i, canvas.getWidth() - (paint2.getStrokeWidth() * 0.2f), canvas.getHeight() - i2, f, f2, paint3);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) ? new DefaultRenderer$draw$1(this.$danmakuItemData, this.$canvas, this.this$0, continuation) : (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, coroutineScope, continuation)) == null) ? ((DefaultRenderer$draw$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                CharSequence d = this.$danmakuItemData.d();
                final Canvas canvas = this.$canvas;
                final DefaultRenderer defaultRenderer = this.this$0;
                final r46 r46Var = this.$danmakuItemData;
                nc6.d(inst, d, new nc6.h() { // from class: com.baidu.tieba.tx8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.nc6.h
                    public final void a(SpannableStringBuilder spannableStringBuilder) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, spannableStringBuilder) == null) {
                            DefaultRenderer$draw$1.m53invokeSuspend$lambda0(canvas, defaultRenderer, r46Var, spannableStringBuilder);
                        }
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return invokeL.objValue;
    }
}
