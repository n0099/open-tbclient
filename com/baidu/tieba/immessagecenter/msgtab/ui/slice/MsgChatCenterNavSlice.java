package com.baidu.tieba.immessagecenter.msgtab.ui.slice;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.immessagecenter.msgtab.ui.slice.MsgChatCenterNavSlice;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.py5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J$\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/slice/MsgChatCenterNavSlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "(Lcom/baidu/tbadk/TbPageContext;)V", "context", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "mNaviIcon", "Landroid/widget/ImageView;", "mNaviMoreText", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "mNaviTitle", "mNavigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "onChangeSkinType", "", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgChatCenterNavSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> j;
    public final Activity k;
    public NavigationBar l;
    public EMTextView m;
    public EMTextView n;
    public ImageView o;

    public MsgChatCenterNavSlice(TbPageContext<?> pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.j = pageContext;
        this.k = pageContext.getPageActivity();
    }

    public static final void X(MsgChatCenterNavSlice this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(this$0.k);
            shareFriendActivityConfig.setIsForChat(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
            TiebaStatic.log("c12929");
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View N(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            View inflate = inflater.inflate(R.layout.obfuscated_res_0x7f0d08bb, container, false);
            this.l = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f091747);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void U(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.U(view2, bundle);
            py5.b(view2);
            NavigationBar navigationBar = this.l;
            if (navigationBar != null) {
                navigationBar.setStatusBarVisibility(8);
                EMTextView eMTextView = (EMTextView) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d06dd, (View.OnClickListener) null).findViewById(R.id.obfuscated_res_0x7f091898);
                this.m = eMTextView;
                if (eMTextView != null) {
                    eMTextView.setText(this.k.getString(R.string.obfuscated_res_0x7f0f0ca5));
                }
                View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d06dc, new View.OnClickListener() { // from class: com.baidu.tieba.ws8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            MsgChatCenterNavSlice.X(MsgChatCenterNavSlice.this, view3);
                        }
                    }
                });
                this.o = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091896);
                EMTextView eMTextView2 = (EMTextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091897);
                this.n = eMTextView2;
                if (eMTextView2 != null) {
                    eMTextView2.setText(this.k.getString(R.string.obfuscated_res_0x7f0f0ca4));
                }
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            NavigationBar navigationBar = this.l;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.j, i);
            }
            d85 d = d85.d(F());
            d.o(R.string.J_X19);
            d.f(R.color.CAM_X0201);
            d85 d2 = d85.d(this.n);
            d2.x(R.color.CAM_X0107);
            d2.C(R.dimen.T_X12);
            d85 d3 = d85.d(this.m);
            d3.x(R.color.CAM_X0105);
            d3.C(R.dimen.T_X04);
            d3.D(R.string.F_X02);
            WebPManager.setPureDrawable(this.o, R.drawable.obfuscated_res_0x7f080afd, R.color.CAM_X0107, null);
        }
    }
}
