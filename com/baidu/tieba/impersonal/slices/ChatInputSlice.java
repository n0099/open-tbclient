package com.baidu.tieba.impersonal.slices;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tieba.bd9;
import com.baidu.tieba.eb9;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.impersonal.components.inputview.ImPersonInputView;
import com.baidu.tieba.impersonal.data.BehaviorExt;
import com.baidu.tieba.impersonal.databinding.SlicePersonalInputBinding;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J$\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u000e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/tieba/impersonal/slices/ChatInputSlice;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "repo", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "behaviorExt", "Lcom/baidu/tieba/impersonal/data/BehaviorExt;", "(Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;Lcom/baidu/tieba/impersonal/data/BehaviorExt;)V", "binding", "Lcom/baidu/tieba/impersonal/databinding/SlicePersonalInputBinding;", "imPersonInputTool", "Lcom/baidu/tieba/impersonal/components/inputview/ImPersonInputView;", "imPersonInputViewController", "Lcom/baidu/tieba/impersonal/components/inputview/ImPersonInputViewController;", "onChangeSkinType", "", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onKeyboardVisibilityChanged", MapBundleKey.MapObjKey.OBJ_SL_VISI, "", "onViewCreated", "view", "setBottomMargin", "bottomMargin", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatInputSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bd9 j;
    public final BehaviorExt k;
    public ImPersonInputView l;
    public SlicePersonalInputBinding m;

    public ChatInputSlice(bd9 repo, BehaviorExt behaviorExt) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {repo, behaviorExt};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(behaviorExt, "behaviorExt");
        this.j = repo;
        this.k = behaviorExt;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void a0(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bundle) == null) {
            super.a0(view2, bundle);
            SlicePersonalInputBinding slicePersonalInputBinding = this.m;
            if (slicePersonalInputBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalInputBinding = null;
            }
            ImPersonInputView imPersonInputView = slicePersonalInputBinding.b;
            this.l = imPersonInputView;
            if (imPersonInputView != null) {
                new eb9(K().getPageContext(), imPersonInputView, this.j, this.k);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public View U(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            SlicePersonalInputBinding it = SlicePersonalInputBinding.c(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.m = it;
            return it.getRoot();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.W(z);
            ImPersonInputView imPersonInputView = this.l;
            if (imPersonInputView != null) {
                imPersonInputView.b(z);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            ImPersonInputView imPersonInputView = this.l;
            if (imPersonInputView != null) {
                imPersonInputView.a();
            }
        }
    }

    public final void d0(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            SlicePersonalInputBinding slicePersonalInputBinding = this.m;
            SlicePersonalInputBinding slicePersonalInputBinding2 = null;
            if (slicePersonalInputBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalInputBinding = null;
            }
            ViewGroup.LayoutParams layoutParams = slicePersonalInputBinding.getRoot().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = i;
                SlicePersonalInputBinding slicePersonalInputBinding3 = this.m;
                if (slicePersonalInputBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    slicePersonalInputBinding2 = slicePersonalInputBinding3;
                }
                slicePersonalInputBinding2.getRoot().setLayoutParams(marginLayoutParams);
            }
        }
    }
}
