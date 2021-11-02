package com.baidu.tieba.lately;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.p.j;
import b.a.q0.g0.g;
import b.a.q0.g0.h;
import b.a.r0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.adapter.SelectForumItemAdapter;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class LatelyView extends FrameLayout implements f<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f50992e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f50993f;

    /* renamed from: g  reason: collision with root package name */
    public SelectForumItemAdapter f50994g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f50995h;

    /* renamed from: i  reason: collision with root package name */
    public g f50996i;
    public h j;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LatelyView f50997e;

        public a(LatelyView latelyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {latelyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50997e = latelyView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f50997e.request((String) null);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.select_forum_lately_layout, (ViewGroup) this, true);
            this.f50993f = (RecyclerView) findViewById(R.id.select_forum_list);
            SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
            this.f50994g = selectForumItemAdapter;
            selectForumItemAdapter.setType(1);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.f50995h = linearLayoutManager;
            this.f50993f.setLayoutManager(linearLayoutManager);
            this.f50993f.setAdapter(this.f50994g);
        }
    }

    @Override // b.a.r0.f
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getContext().getString(R.string.activity_select_forum_tab_recently) : (String) invokeV.objValue;
    }

    public void hideLoadingView() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f50996i) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f50996i = null;
    }

    public void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            h hVar = this.j;
            if (hVar != null) {
                hVar.dettachView(this);
                this.j = null;
            }
            this.f50993f.setVisibility(0);
        }
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g gVar = this.f50996i;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRefreshViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            h hVar = this.j;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.f
    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f50992e) {
            return;
        }
        this.f50992e = skinType;
        g gVar = this.f50996i;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.f50994g.notifyDataSetChanged();
    }

    @Override // b.a.r0.f
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hideLoadingView();
        }
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.f50996i == null) {
            g gVar = new g(getContext());
            this.f50996i = gVar;
            gVar.onChangeSkinType();
        }
        this.f50996i.attachView(this, z);
    }

    public void showNetRefreshView(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || isRefreshViewShowing()) {
            return;
        }
        if (this.j == null) {
            this.j = new h(getContext(), new a(this));
        }
        this.j.j(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.j.attachView(this, z);
        if (z2) {
            this.j.o();
        } else {
            this.j.h(R.drawable.new_pic_emotion_01);
            this.j.e();
        }
        this.j.n(getContext().getString(R.string.activity_select_forum_empty));
        this.f50993f.setVisibility(8);
    }

    @Override // b.a.r0.f
    public void showTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.f
    public void request(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            RecentlyVisitedForumData j = b.a.r0.o0.g.a.l().j();
            if (j == null) {
                showNetRefreshView(false, false);
                return;
            }
            LinkedList<VisitedForumData> y = j.y();
            if (ListUtils.isEmpty(y)) {
                showNetRefreshView(false, false);
                return;
            }
            hideNetRefreshView();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<VisitedForumData> it = y.iterator();
            while (it.hasNext()) {
                VisitedForumData next = it.next();
                if (next != null) {
                    b.a.q0.u.j jVar = new b.a.q0.u.j();
                    jVar.f14141a = next.getForumId();
                    jVar.f14142b = next.y();
                    jVar.f14143c = next.getForumName();
                    jVar.f14144d = next.getLevel();
                    jVar.f14145e = next.H();
                    jVar.f14146f = next.G();
                    jVar.f14147g = next.w();
                    jVar.f14148h = next.C();
                    jVar.f14149i = next.A();
                    if (jVar.f14145e) {
                        arrayList2.add(jVar);
                    } else {
                        arrayList.add(jVar);
                    }
                    jVar.j = next.isForumBusinessAccount;
                }
            }
            arrayList2.addAll(arrayList);
            this.f50994g.setDataList(arrayList2);
            this.f50994g.notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LatelyView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f50992e = 3;
        a();
    }
}
