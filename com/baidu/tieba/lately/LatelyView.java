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
import c.a.d.f.p.l;
import c.a.o0.f0.h;
import c.a.p0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.SelectForumData;
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
/* loaded from: classes5.dex */
public class LatelyView extends FrameLayout implements g<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f34167b;

    /* renamed from: c  reason: collision with root package name */
    public SelectForumItemAdapter f34168c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayoutManager f34169d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.f0.g f34170e;

    /* renamed from: f  reason: collision with root package name */
    public h f34171f;

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A()) {
                this.a.c(null);
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

    @Override // c.a.p0.g
    public void a() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        c.a.o0.f0.g gVar = this.f34170e;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.f34171f;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.f34168c.notifyDataSetChanged();
    }

    @Override // c.a.p0.g
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    public void d() {
        c.a.o0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.f34170e) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f34170e = null;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h hVar = this.f34171f;
            if (hVar != null) {
                hVar.dettachView(this);
                this.f34171f = null;
            }
            this.f34167b.setVisibility(0);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0761, (ViewGroup) this, true);
            this.f34167b = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091c72);
            SelectForumItemAdapter selectForumItemAdapter = new SelectForumItemAdapter(this);
            this.f34168c = selectForumItemAdapter;
            selectForumItemAdapter.k(1);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.f34169d = linearLayoutManager;
            this.f34167b.setLayoutManager(linearLayoutManager);
            this.f34167b.setAdapter(this.f34168c);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            h hVar = this.f34171f;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.g
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getContext().getString(R.string.obfuscated_res_0x7f0f0090) : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.g
    /* renamed from: h */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            RecentlyVisitedForumData j = c.a.p0.w0.h.a.l().j();
            if (j == null) {
                i(false, false);
                return;
            }
            LinkedList<VisitedForumData> A = j.A();
            if (ListUtils.isEmpty(A)) {
                i(false, false);
                return;
            }
            e();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<VisitedForumData> it = A.iterator();
            while (it.hasNext()) {
                VisitedForumData next = it.next();
                if (next != null) {
                    SelectForumData selectForumData = new SelectForumData();
                    selectForumData.forumId = next.getForumId();
                    selectForumData.avatarUrl = next.A();
                    selectForumData.forumName = next.getForumName();
                    selectForumData.level = next.getLevel();
                    selectForumData.isLately = next.J();
                    selectForumData.isCanPost = next.I();
                    selectForumData.blockInfo = next.y();
                    selectForumData.tabInfoList = next.E();
                    selectForumData.postPrefix = next.C();
                    if (selectForumData.isLately) {
                        arrayList2.add(selectForumData);
                    } else {
                        arrayList.add(selectForumData);
                    }
                    selectForumData.isForumBusinessAccount = next.isForumBusinessAccount;
                }
            }
            arrayList2.addAll(arrayList);
            this.f34168c.i(arrayList2);
            this.f34168c.notifyDataSetChanged();
        }
    }

    public void i(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || g()) {
            return;
        }
        if (this.f34171f == null) {
            this.f34171f = new h(getContext(), new a(this));
        }
        this.f34171f.k(getResources().getDimensionPixelSize(R.dimen.tbds380));
        this.f34171f.attachView(this, z);
        if (z2) {
            this.f34171f.p();
        } else {
            this.f34171f.h(R.drawable.new_pic_emotion_01);
            this.f34171f.e();
        }
        this.f34171f.o(getContext().getString(R.string.obfuscated_res_0x7f0f008c));
        this.f34167b.setVisibility(8);
    }

    @Override // c.a.p0.g
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            d();
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
        f();
    }
}
