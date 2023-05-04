package com.baidu.tieba.impersonal.slices;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tieba.fe8;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.impersonal.components.inputview.ImPersonInputView;
import com.baidu.tieba.impersonal.databinding.SlicePersonalInputBinding;
import com.baidu.tieba.nc8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/tieba/impersonal/slices/ChatInputSlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "repo", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "(Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;)V", "binding", "Lcom/baidu/tieba/impersonal/databinding/SlicePersonalInputBinding;", "imPersonInputTool", "Lcom/baidu/tieba/impersonal/components/inputview/ImPersonInputView;", "imPersonInputViewController", "Lcom/baidu/tieba/impersonal/components/inputview/ImPersonInputViewController;", "onChangeSkinType", "", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onKeyboardVisibilityChanged", MapBundleKey.MapObjKey.OBJ_SL_VISI, "", "onViewCreated", NativeConstants.TYPE_VIEW, "setBottomMargin", "bottomMargin", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChatInputSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fe8 j;
    public ImPersonInputView k;
    public SlicePersonalInputBinding l;

    public ChatInputSlice(fe8 repo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {repo};
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
        this.j = repo;
    }

    public final void X(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            SlicePersonalInputBinding slicePersonalInputBinding = this.l;
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
                SlicePersonalInputBinding slicePersonalInputBinding3 = this.l;
                if (slicePersonalInputBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    slicePersonalInputBinding2 = slicePersonalInputBinding3;
                }
                slicePersonalInputBinding2.getRoot().setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View N(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            SlicePersonalInputBinding it = SlicePersonalInputBinding.c(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.l = it;
            return it.getRoot();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.P(z);
            ImPersonInputView imPersonInputView = this.k;
            if (imPersonInputView != null) {
                imPersonInputView.b(z);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            ImPersonInputView imPersonInputView = this.k;
            if (imPersonInputView != null) {
                imPersonInputView.a();
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void U(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bundle) == null) {
            super.U(view2, bundle);
            SlicePersonalInputBinding slicePersonalInputBinding = this.l;
            if (slicePersonalInputBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                slicePersonalInputBinding = null;
            }
            ImPersonInputView imPersonInputView = slicePersonalInputBinding.b;
            this.k = imPersonInputView;
            if (imPersonInputView != null) {
                new nc8(E().getPageContext(), imPersonInputView, this.j);
            }
        }
    }
}
