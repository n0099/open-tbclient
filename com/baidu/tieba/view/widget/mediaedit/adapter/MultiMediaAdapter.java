package com.baidu.tieba.view.widget.mediaedit.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.view.widget.mediaedit.SimpleDraweeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.bean.LocalAlbumInfo;
import d.a.v0.t.h;
import d.a.v0.t.t;
import d.a.v0.t.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MultiMediaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.p0.z3.m.c.c.a> f22427a;

    /* renamed from: b  reason: collision with root package name */
    public Context f22428b;

    /* renamed from: c  reason: collision with root package name */
    public a f22429c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22430d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22431e;

    /* loaded from: classes4.dex */
    public static class MultiMediaHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f22432a;

        /* renamed from: b  reason: collision with root package name */
        public SimpleDraweeView f22433b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDraweeView f22434c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<SimpleDraweeView> f22435d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f22436e;

        /* renamed from: f  reason: collision with root package name */
        public View f22437f;

        /* renamed from: g  reason: collision with root package name */
        public MultiMediaAdapter f22438g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f22439h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f22440e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ MultiMediaHolder f22441f;

            public a(MultiMediaHolder multiMediaHolder, a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {multiMediaHolder, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22441f = multiMediaHolder;
                this.f22440e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.p0.z3.m.c.c.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22440e == null || this.f22441f.f22438g == null || h.e(this.f22441f.f22438g.e()) || (aVar = (d.a.p0.z3.m.c.c.a) h.c(this.f22441f.f22438g.e(), this.f22441f.getAdapterPosition())) == null) {
                    return;
                }
                this.f22440e.e(this.f22441f.getAdapterPosition(), view, aVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiMediaHolder(View view, a aVar) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22435d = new ArrayList<>();
            this.f22432a = (SimpleDraweeView) view.findViewById(R.id.media_cover);
            this.f22433b = (SimpleDraweeView) view.findViewById(R.id.media_cover1);
            this.f22434c = (SimpleDraweeView) view.findViewById(R.id.media_cover2);
            this.f22435d.add(this.f22432a);
            this.f22435d.add(this.f22433b);
            this.f22435d.add(this.f22434c);
            this.f22439h = (LinearLayout) view.findViewById(R.id.media_cover_wrap);
            this.f22436e = (TextView) view.findViewById(R.id.tv_choose_duration);
            this.f22437f = view.findViewById(R.id.v_bottom_dot);
            view.setOnClickListener(new a(this, aVar));
        }

        public void b(MultiMediaAdapter multiMediaAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, multiMediaAdapter) == null) {
                this.f22438g = multiMediaAdapter;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        void e(int i2, View view, d.a.p0.z3.m.c.c.a aVar);
    }

    public MultiMediaAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22430d = false;
        this.f22431e = false;
    }

    public List<d.a.p0.z3.m.c.c.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<d.a.p0.z3.m.c.c.a> list = this.f22427a;
            return list == null ? new ArrayList() : list;
        }
        return (List) invokeV.objValue;
    }

    public List<d.a.p0.z3.m.c.c.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22427a : (List) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f22431e) {
            return;
        }
        notifyDataSetChanged();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (d.a.p0.z3.m.c.c.a aVar : e()) {
                aVar.d(false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h.b(this.f22427a) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (h.e(this.f22427a)) {
                return -1;
            }
            return this.f22427a.get(i2).b();
        }
        return invokeI.intValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f22430d = z;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f22431e = z;
        }
    }

    public void j(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f22429c = aVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        d.a.p0.z3.m.c.c.a aVar;
        String str;
        ArrayList<SimpleDraweeView> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, viewHolder, i2) == null) && (aVar = (d.a.p0.z3.m.c.c.a) h.c(this.f22427a, i2)) != null && (viewHolder instanceof MultiMediaHolder)) {
            MultiMediaHolder multiMediaHolder = (MultiMediaHolder) viewHolder;
            LocalAlbumInfo a2 = aVar.a();
            if (a2 != null) {
                if ((multiMediaHolder.f22432a.getTag() == null || !TextUtils.equals((String) multiMediaHolder.f22432a.getTag(), a2.path)) && (str = a2.path) != null) {
                    multiMediaHolder.f22432a.setTag(str);
                    ArrayList<SimpleDraweeView> arrayList2 = multiMediaHolder.f22435d;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        for (int i3 = 0; i3 < multiMediaHolder.f22435d.size(); i3++) {
                            multiMediaHolder.f22435d.get(i3).setImageURI(Uri.fromFile(new File(a2.path)));
                        }
                    } else {
                        multiMediaHolder.f22432a.setImageURI(Uri.fromFile(new File(a2.path)));
                    }
                }
                multiMediaHolder.f22436e.setText(w.b((int) a2.getDurationWithSpeed()));
                multiMediaHolder.f22437f.setVisibility(aVar.c() ? 0 : 4);
                if (aVar.b() != 2 || (arrayList = multiMediaHolder.f22435d) == null) {
                    return;
                }
                int size = arrayList.size();
                int i4 = 1;
                if (!this.f22430d && !this.f22431e) {
                    multiMediaHolder.f22439h.getLayoutParams().width = ((int) t.i(R.dimen.ds100)) * size;
                    while (i4 < size) {
                        multiMediaHolder.f22435d.get(i4).setVisibility(0);
                        i4++;
                    }
                    return;
                }
                while (i4 < size) {
                    multiMediaHolder.f22435d.get(i4).setVisibility(8);
                    i4++;
                }
                multiMediaHolder.f22439h.getLayoutParams().width = (int) t.i(R.dimen.ds100);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i2)) == null) {
            this.f22428b = viewGroup.getContext();
            if (i2 == 2) {
                MultiMediaHolder multiMediaHolder = new MultiMediaHolder(LayoutInflater.from(this.f22428b).inflate(R.layout.item_multi_media_layout, viewGroup, false), this.f22429c);
                multiMediaHolder.b(this);
                return multiMediaHolder;
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, viewHolder, i2, list) == null) {
            if (!h.e(list)) {
                d.a.p0.z3.m.c.c.a aVar = (d.a.p0.z3.m.c.c.a) h.c(this.f22427a, i2);
                if (viewHolder instanceof MultiMediaHolder) {
                    ((MultiMediaHolder) viewHolder).f22437f.setVisibility(aVar.c() ? 0 : 4);
                    return;
                }
                return;
            }
            onBindViewHolder(viewHolder, i2);
        }
    }
}
