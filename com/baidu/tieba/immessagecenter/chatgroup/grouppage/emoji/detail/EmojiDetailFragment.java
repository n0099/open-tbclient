package com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.gi5;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.adapter.EmojiDetailRecyclerAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiDetailUserInfo;
import com.baidu.tieba.tn8;
import com.baidu.tieba.xn8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes6.dex */
public class EmojiDetailFragment extends BaseFragment implements tn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmojiDetailRecyclerAdapter a;
    public final TbPageContext<BaseFragmentActivity> b;
    @NonNull
    public final xn8 c;
    public final BdUniqueId d;
    public boolean e;
    public View f;
    public b g;
    public TextView h;
    public boolean i;
    @NonNull
    public final c j;
    public final BdListView.p k;

    /* loaded from: classes6.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiDetailFragment a;

        public a(EmojiDetailFragment emojiDetailFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiDetailFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emojiDetailFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.i) {
                this.a.c.g(this.a.j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BdRecyclerView b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static b a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                b bVar = new b();
                bVar.a = view2;
                bVar.b = (BdRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0909ae);
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements tn8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<tn8> a;

        public c(tn8 tn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(tn8Var);
        }

        @Override // com.baidu.tieba.tn8
        public void a(boolean z, @Nullable List<EmojiDetailUserInfo> list) {
            tn8 tn8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) && (tn8Var = this.a.get()) != null) {
                tn8Var.a(z, list);
            }
        }

        @Override // com.baidu.tieba.tn8
        public void onFailure(int i, String str) {
            tn8 tn8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (tn8Var = this.a.get()) != null) {
                tn8Var.onFailure(i, str);
            }
        }
    }

    public EmojiDetailFragment(TbPageContext<BaseFragmentActivity> tbPageContext, EmojiData emojiData, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, emojiData, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = BdUniqueId.gen();
        this.e = false;
        this.k = new a(this);
        this.b = tbPageContext;
        this.c = new xn8(tbPageContext, emojiData, j, this.d);
        this.j = new c(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            TextView textView = this.h;
            if (textView != null) {
                EMManager.from(textView).setTextColor(R.color.CAM_X0105);
            }
        }
    }

    @Override // com.baidu.tieba.tn8
    public void a(boolean z, @Nullable List<EmojiDetailUserInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
            if (isLoadingViewAttached()) {
                hideLoading();
            }
            this.i = z;
            this.a.l(list);
            TextView f2 = f2(z);
            if (this.g.b.getFooterViewsCount() == 0 && f2.getParent() == null) {
                this.g.b.addFooterView(f2);
            } else {
                f2(z);
            }
        }
    }

    public final TextView f2(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (this.h == null) {
                this.h = new TextView(this.b.getPageActivity());
                this.h.setLayoutParams(new RecyclerView.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds100)));
                this.h.setGravity(17);
                EMManager.from(this.h).setTextColor(R.color.CAM_X0105);
            }
            if (z) {
                this.h.setText(R.string.load_more);
            } else {
                this.h.setText("");
            }
            return this.h;
        }
        return (TextView) invokeZ.objValue;
    }

    public void g2() {
        b bVar;
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bVar = this.g) != null && (bdRecyclerView = bVar.b) != null) {
            bdRecyclerView.smoothScrollToPosition(0);
        }
    }

    public final void hideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hideLoadingView(getView());
            this.loadingView = null;
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            hideLoading();
            showNetRefreshView(this.g.a, null, false);
            gi5 gi5Var = this.mRefreshView;
            if (gi5Var != null) {
                gi5Var.getAttachedView().setClickable(false);
                this.mRefreshView.e(R.color.transparent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onNetRefreshButtonClicked();
            h2();
            this.c.g(this.j);
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            hideNetRefreshView(getView());
            this.mRefreshView = null;
            showLoadingView(getView());
            LoadingView loadingView = this.loadingView;
            if (loadingView != null) {
                loadingView.getAttachedView().setClickable(false);
                this.loadingView.cancelCenterVertical();
                this.loadingView.setLayoutMarginWithHeaderHeightAndPercent(0, 0.2f);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f == null) {
                this.f = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0290, viewGroup, false);
            }
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.tn8
    public void onFailure(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str) == null) && isLoadingViewAttached()) {
            i2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            if (!this.e) {
                this.e = true;
                this.g = b.a(view2);
                this.a = new EmojiDetailRecyclerAdapter();
                this.g.b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
                this.g.b.setOnSrollToBottomListener(this.k);
                this.g.b.setAdapter(this.a);
                h2();
                this.c.g(this.j);
            }
        }
    }
}
