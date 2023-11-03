package com.baidu.tieba.lately;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.adapter.SelectForumItemAdapter;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.kx6;
import com.baidu.tieba.vj5;
import com.baidu.tieba.zz5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class LatelyView extends FrameLayout implements zz5<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public RecyclerView b;
    public SelectForumItemAdapter c;
    public LinearLayoutManager d;
    public LoadingView e;
    public vj5 f;

    @Override // com.baidu.tieba.zz5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LatelyView a;

        public a(LatelyView latelyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {latelyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = latelyView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.a.b(null);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LatelyView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LatelyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LatelyView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 3;
        e();
    }

    public void c() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (loadingView = this.e) != null) {
            loadingView.dettachView(this);
            this.e = null;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            vj5 vj5Var = this.f;
            if (vj5Var != null) {
                vj5Var.dettachView(this);
                this.f = null;
            }
            this.b.setVisibility(0);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            vj5 vj5Var = this.f;
            if (vj5Var != null) {
                return vj5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zz5
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return getContext().getString(R.string.obfuscated_res_0x7f0f00bf);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zz5
    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        LoadingView loadingView = this.e;
        if (loadingView != null) {
            loadingView.onChangeSkinType();
        }
        vj5 vj5Var = this.f;
        if (vj5Var != null) {
            vj5Var.onChangeSkinType();
        }
        this.c.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.zz5
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08b5, (ViewGroup) this, true);
            this.b = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0921cd);
            SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
            this.c = selectForumItemAdapter;
            selectForumItemAdapter.t(1);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.d = linearLayoutManager;
            this.b.setLayoutManager(linearLayoutManager);
            this.b.setAdapter(this.c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zz5
    /* renamed from: g */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            RecentlyVisitedForumData k = kx6.o().k();
            if (k == null) {
                h(false, false);
                return;
            }
            LinkedList<VisitedForumData> forumData = k.getForumData();
            if (ListUtils.isEmpty(forumData)) {
                h(false, false);
                return;
            }
            d();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<VisitedForumData> it = forumData.iterator();
            while (it.hasNext()) {
                VisitedForumData next = it.next();
                if (next != null) {
                    SelectForumData selectForumData = new SelectForumData();
                    selectForumData.forumId = next.getForumId();
                    selectForumData.avatarUrl = next.getForumImageUrl();
                    selectForumData.forumName = next.getForumName();
                    selectForumData.level = next.getLevel();
                    selectForumData.isLately = next.isPost();
                    selectForumData.isCanPost = next.isCanPost();
                    selectForumData.blockInfo = next.getBlockInfo();
                    selectForumData.tabInfoList = next.getTabInfoList();
                    selectForumData.postPrefix = next.getPostPrefix();
                    if (selectForumData.isLately) {
                        arrayList2.add(selectForumData);
                    } else {
                        arrayList.add(selectForumData);
                    }
                    selectForumData.isForumBusinessAccount = next.isForumBusinessAccount;
                    selectForumData.forumTagInfo = next.forumTagInfo;
                    selectForumData.firstCategory = next.firstCategory;
                }
            }
            arrayList2.addAll(arrayList);
            this.c.q(arrayList2);
            this.c.notifyDataSetChanged();
        }
    }

    public void h(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || f()) {
            return;
        }
        if (this.f == null) {
            this.f = new vj5(getContext(), new a(this));
        }
        this.f.j(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.f.attachView(this, z);
        if (z2) {
            this.f.o();
        } else {
            this.f.g(R.drawable.new_pic_emotion_01);
            this.f.d();
        }
        this.f.n(getContext().getString(R.string.obfuscated_res_0x7f0f00bb));
        this.b.setVisibility(8);
    }
}
