package com.baidu.tieba.videoplay.view;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hi;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class VideoChannelTitleLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelTitleLayout(Context context) {
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
        this.c = false;
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
        this.c = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelTitleLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.c = false;
    }

    public final void a(int i) {
        StaticLayout staticLayout;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || i <= 0) {
            return;
        }
        int g = hi.g(getContext(), R.dimen.tbds8);
        int g2 = hi.g(getContext(), R.dimen.M_W_X001);
        ExpandableTextView expandableTextView = (ExpandableTextView) getChildAt(0);
        View childAt = getChildAt(1);
        CharSequence text = expandableTextView.getContentView().getText();
        StaticLayout staticLayout2 = new StaticLayout(text, expandableTextView.getContentView().getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int lineCount = staticLayout2.getLineCount();
        if (lineCount < 3) {
            int i3 = lineCount - 1;
            StaticLayout staticLayout3 = new StaticLayout(text.subSequence(staticLayout2.getLineStart(i3), staticLayout2.getLineEnd(i3)), expandableTextView.getContentView().getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (staticLayout3.getLineRight(staticLayout3.getLineCount() - 1) + g2 + childAt.getMeasuredWidth() <= i) {
                this.a = staticLayout2.getLineTop(i3) + (i3 * g);
                this.b = ((int) staticLayout2.getLineRight(i3)) + g2;
                return;
            }
            this.a = staticLayout2.getHeight() + ((lineCount + 1) * g);
            this.b = 0;
            return;
        }
        if (lineCount == 3) {
            int i4 = lineCount - 1;
            StaticLayout staticLayout4 = new StaticLayout(text.subSequence(staticLayout2.getLineStart(i4), staticLayout2.getLineEnd(i4)), expandableTextView.getContentView().getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (staticLayout4.getLineRight(staticLayout4.getLineCount() - 1) + g2 + childAt.getMeasuredWidth() <= i) {
                this.a = staticLayout2.getLineTop(i4) + (lineCount * g);
                this.b = (int) staticLayout2.getLineRight(i4);
                return;
            }
            staticLayout = staticLayout2;
        } else {
            staticLayout = staticLayout2;
        }
        int lineStart = staticLayout.getLineStart(2);
        int lineEnd = staticLayout.getLineEnd(2);
        int measuredWidth = i - childAt.getMeasuredWidth();
        if (measuredWidth <= 0) {
            i2 = i;
        } else {
            i2 = measuredWidth;
        }
        StaticLayout staticLayout5 = new StaticLayout(StringHelper.STRING_MORE + ((Object) text.subSequence(lineStart, lineEnd)), expandableTextView.getContentView().getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text.subSequence(0, lineStart + (staticLayout5.getLineEnd(0) - staticLayout5.getLineStart(0)) + (-3)));
        spannableStringBuilder.append((CharSequence) StringHelper.STRING_MORE);
        expandableTextView.getContentView().setText(spannableStringBuilder);
        StaticLayout staticLayout6 = new StaticLayout(spannableStringBuilder, expandableTextView.getContentView().getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.b = staticLayout6.getLineStart(staticLayout6.getLineCount() - 1);
        this.a = staticLayout.getLineEnd(staticLayout6.getLineCount() - 1) + (staticLayout6.getLineCount() * g);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            ExpandableTextView expandableTextView = (ExpandableTextView) getChildAt(0);
            View childAt = getChildAt(1);
            expandableTextView.layout(0, 0, expandableTextView.getMeasuredWidth(), expandableTextView.getMeasuredHeight());
            if (!this.c) {
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
                return;
            }
            int i5 = this.b;
            childAt.layout(i5, this.a, childAt.getMeasuredWidth() + i5, this.a + childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i);
            measureChildren(i, i2);
            a(size);
            boolean z = false;
            ExpandableTextView expandableTextView = (ExpandableTextView) getChildAt(0);
            View childAt = getChildAt(1);
            if (childAt.getVisibility() == 0) {
                z = true;
            }
            this.c = z;
            measureChildren(i, i2);
            if (!this.c) {
                setMeasuredDimension(expandableTextView.getMeasuredWidth(), expandableTextView.getMeasuredHeight());
                return;
            }
            a(size);
            setMeasuredDimension(size, this.a + childAt.getMeasuredHeight());
        }
    }
}
