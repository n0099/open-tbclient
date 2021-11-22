package com.baidu.tieba.lately;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.j;
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
    public int f51903e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f51904f;

    /* renamed from: g  reason: collision with root package name */
    public SelectForumItemAdapter f51905g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f51906h;

    /* renamed from: i  reason: collision with root package name */
    public g f51907i;
    public h j;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LatelyView f51908e;

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
            this.f51908e = latelyView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f51908e.request((String) null);
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
            this.f51904f = (RecyclerView) findViewById(R.id.select_forum_list);
            SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
            this.f51905g = selectForumItemAdapter;
            selectForumItemAdapter.setType(1);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.f51906h = linearLayoutManager;
            this.f51904f.setLayoutManager(linearLayoutManager);
            this.f51904f.setAdapter(this.f51905g);
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f51907i) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f51907i = null;
    }

    public void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            h hVar = this.j;
            if (hVar != null) {
                hVar.dettachView(this);
                this.j = null;
            }
            this.f51904f.setVisibility(0);
        }
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g gVar = this.f51907i;
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f51903e) {
            return;
        }
        this.f51903e = skinType;
        g gVar = this.f51907i;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.f51905g.notifyDataSetChanged();
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
        if (this.f51907i == null) {
            g gVar = new g(getContext());
            this.f51907i = gVar;
            gVar.onChangeSkinType();
        }
        this.f51907i.attachView(this, z);
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
        this.f51904f.setVisibility(8);
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
                    jVar.f14908a = next.getForumId();
                    jVar.f14909b = next.y();
                    jVar.f14910c = next.getForumName();
                    jVar.f14911d = next.getLevel();
                    jVar.f14912e = next.H();
                    jVar.f14913f = next.G();
                    jVar.f14914g = next.w();
                    jVar.f14915h = next.C();
                    jVar.f14916i = next.A();
                    if (jVar.f14912e) {
                        arrayList2.add(jVar);
                    } else {
                        arrayList.add(jVar);
                    }
                    jVar.j = next.isForumBusinessAccount;
                }
            }
            arrayList2.addAll(arrayList);
            this.f51905g.setDataList(arrayList2);
            this.f51905g.notifyDataSetChanged();
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
        this.f51903e = 3;
        a();
    }
}
