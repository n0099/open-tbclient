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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.co5;
import com.baidu.tieba.d85;
import com.baidu.tieba.do5;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.adapter.EmojiDetailRecyclerAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiDetailUserInfo;
import com.baidu.tieba.pm8;
import com.baidu.tieba.tm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class EmojiDetailFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmojiDetailRecyclerAdapter a;
    public final TbPageContext<BaseFragmentActivity> b;
    @NonNull
    public final tm8 c;
    public final BdUniqueId d;
    public boolean e;
    public View f;
    public c g;
    public TextView h;
    public boolean i;
    public final pm8 j;
    public final BdListView.p k;

    /* loaded from: classes6.dex */
    public class a implements pm8 {
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

        @Override // com.baidu.tieba.pm8
        public void a(boolean z, @Nullable List<EmojiDetailUserInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                if (this.a.isLoadingViewAttached()) {
                    this.a.T1();
                }
                this.a.i = z;
                this.a.a.m(list);
                TextView S1 = this.a.S1(z);
                if (this.a.g.b.getFooterViewsCount() == 0 && S1.getParent() == null) {
                    this.a.g.b.addFooterView(S1);
                } else {
                    this.a.S1(z);
                }
            }
        }

        @Override // com.baidu.tieba.pm8
        public void onFailure(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && this.a.isLoadingViewAttached()) {
                this.a.W1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiDetailFragment a;

        public b(EmojiDetailFragment emojiDetailFragment) {
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
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BdRecyclerView b;

        public c() {
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

        public static c a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                c cVar = new c();
                cVar.a = view2;
                cVar.b = (BdRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090988);
                return cVar;
            }
            return (c) invokeL.objValue;
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
        this.j = new a(this);
        this.k = new b(this);
        this.b = tbPageContext;
        this.c = new tm8(tbPageContext, emojiData, j, this.d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            TextView textView = this.h;
            if (textView != null) {
                d85.d(textView).x(R.color.CAM_X0105);
            }
        }
    }

    public final TextView S1(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (this.h == null) {
                this.h = new TextView(this.b.getPageActivity());
                this.h.setLayoutParams(new RecyclerView.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds100)));
                this.h.setGravity(17);
                d85.d(this.h).x(R.color.CAM_X0105);
            }
            if (z) {
                this.h.setText(R.string.load_more);
            } else {
                this.h.setText(R.string.no_more_msg);
            }
            return this.h;
        }
        return (TextView) invokeZ.objValue;
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            hideLoadingView(getView());
            this.loadingView = null;
        }
    }

    public void U1() {
        c cVar;
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (cVar = this.g) != null && (bdRecyclerView = cVar.b) != null) {
            bdRecyclerView.smoothScrollToPosition(0);
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            T1();
            showNetRefreshView(this.g.a, null, false);
            do5 do5Var = this.mRefreshView;
            if (do5Var != null) {
                do5Var.b().setClickable(false);
                this.mRefreshView.f(R.color.transparent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onNetRefreshButtonClicked();
            V1();
            this.c.g(this.j);
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            hideNetRefreshView(getView());
            this.mRefreshView = null;
            showLoadingView(getView());
            co5 co5Var = this.loadingView;
            if (co5Var != null) {
                co5Var.j().setClickable(false);
                this.loadingView.i();
                this.loadingView.q(0, 0.2f);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f == null) {
                this.f = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0287, viewGroup, false);
            }
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            if (!this.e) {
                this.e = true;
                this.g = c.a(view2);
                this.a = new EmojiDetailRecyclerAdapter();
                this.g.b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
                this.g.b.setOnSrollToBottomListener(this.k);
                this.g.b.setAdapter(this.a);
                V1();
                this.c.g(this.j);
            }
        }
    }
}
