package com.baidu.tieba.pb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.feedback.FeedbackButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class AigcFeedbackViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final FeedbackButton b;
    @NonNull
    public final FeedbackButton c;

    public AigcFeedbackViewBinding(@NonNull LinearLayout linearLayout, @NonNull FeedbackButton feedbackButton, @NonNull FeedbackButton feedbackButton2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayout, feedbackButton, feedbackButton2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = linearLayout;
        this.b = feedbackButton;
        this.c = feedbackButton2;
    }

    @NonNull
    public static AigcFeedbackViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.obfuscated_res_0x7f0901c4;
            FeedbackButton feedbackButton = (FeedbackButton) view2.findViewById(R.id.obfuscated_res_0x7f0901c4);
            if (feedbackButton != null) {
                i = R.id.obfuscated_res_0x7f0901c5;
                FeedbackButton feedbackButton2 = (FeedbackButton) view2.findViewById(R.id.obfuscated_res_0x7f0901c5);
                if (feedbackButton2 != null) {
                    return new AigcFeedbackViewBinding((LinearLayout) view2, feedbackButton, feedbackButton2);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (AigcFeedbackViewBinding) invokeL.objValue;
    }

    @NonNull
    public static AigcFeedbackViewBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e7, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (AigcFeedbackViewBinding) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (LinearLayout) invokeV.objValue;
    }
}
