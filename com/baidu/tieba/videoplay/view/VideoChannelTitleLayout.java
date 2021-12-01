package com.baidu.tieba.videoplay.view;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.f.p.l;
import c.a.r0.j4.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class VideoChannelTitleLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f50163e;

    /* renamed from: f  reason: collision with root package name */
    public int f50164f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50165g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelTitleLayout(Context context) {
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
        this.f50165g = false;
    }

    public final void a(int i2) {
        StaticLayout staticLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 <= 0) {
            return;
        }
        int f2 = l.f(getContext(), d.tbds8);
        int f3 = l.f(getContext(), d.M_W_X001);
        ExpandableTextView expandableTextView = (ExpandableTextView) getChildAt(0);
        View childAt = getChildAt(1);
        CharSequence text = expandableTextView.getContentView().getText();
        StaticLayout staticLayout2 = new StaticLayout(text, expandableTextView.getContentView().getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int lineCount = staticLayout2.getLineCount();
        if (lineCount < 3) {
            int i3 = lineCount - 1;
            StaticLayout staticLayout3 = new StaticLayout(text.subSequence(staticLayout2.getLineStart(i3), staticLayout2.getLineEnd(i3)), expandableTextView.getContentView().getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (staticLayout3.getLineRight(staticLayout3.getLineCount() - 1) + f3 + childAt.getMeasuredWidth() <= i2) {
                this.f50163e = staticLayout2.getLineTop(i3) + (i3 * f2);
                this.f50164f = ((int) staticLayout2.getLineRight(i3)) + f3;
                return;
            }
            this.f50163e = staticLayout2.getHeight() + ((lineCount + 1) * f2);
            this.f50164f = 0;
            return;
        }
        if (lineCount == 3) {
            int i4 = lineCount - 1;
            StaticLayout staticLayout4 = new StaticLayout(text.subSequence(staticLayout2.getLineStart(i4), staticLayout2.getLineEnd(i4)), expandableTextView.getContentView().getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (staticLayout4.getLineRight(staticLayout4.getLineCount() - 1) + f3 + childAt.getMeasuredWidth() <= i2) {
                this.f50163e = staticLayout2.getLineTop(i4) + (lineCount * f2);
                this.f50164f = (int) staticLayout2.getLineRight(i4);
                return;
            }
            staticLayout = staticLayout2;
        } else {
            staticLayout = staticLayout2;
        }
        int lineStart = staticLayout.getLineStart(2);
        int lineEnd = staticLayout.getLineEnd(2);
        int measuredWidth = i2 - childAt.getMeasuredWidth();
        StaticLayout staticLayout5 = new StaticLayout("..." + ((Object) text.subSequence(lineStart, lineEnd)), expandableTextView.getContentView().getPaint(), measuredWidth <= 0 ? i2 : measuredWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text.subSequence(0, lineStart + (staticLayout5.getLineEnd(0) - staticLayout5.getLineStart(0)) + (-3)));
        spannableStringBuilder.append((CharSequence) "...");
        expandableTextView.getContentView().setText(spannableStringBuilder);
        StaticLayout staticLayout6 = new StaticLayout(spannableStringBuilder, expandableTextView.getContentView().getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f50164f = staticLayout6.getLineStart(staticLayout6.getLineCount() - 1);
        this.f50163e = staticLayout.getLineEnd(staticLayout6.getLineCount() - 1) + (staticLayout6.getLineCount() * f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            ExpandableTextView expandableTextView = (ExpandableTextView) getChildAt(0);
            View childAt = getChildAt(1);
            expandableTextView.layout(0, 0, expandableTextView.getMeasuredWidth(), expandableTextView.getMeasuredHeight());
            if (!this.f50165g) {
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
                return;
            }
            int i6 = this.f50164f;
            childAt.layout(i6, this.f50163e, childAt.getMeasuredWidth() + i6, this.f50163e + childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            measureChildren(i2, i3);
            a(size);
            ExpandableTextView expandableTextView = (ExpandableTextView) getChildAt(0);
            View childAt = getChildAt(1);
            this.f50165g = childAt.getVisibility() == 0;
            measureChildren(i2, i3);
            if (!this.f50165g) {
                setMeasuredDimension(expandableTextView.getMeasuredWidth(), expandableTextView.getMeasuredHeight());
                return;
            }
            a(size);
            setMeasuredDimension(size, this.f50163e + childAt.getMeasuredHeight());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelTitleLayout(Context context, AttributeSet attributeSet) {
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
        this.f50165g = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelTitleLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f50165g = false;
    }
}
