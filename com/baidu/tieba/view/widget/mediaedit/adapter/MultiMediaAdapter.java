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
import d.a.w0.t.h;
import d.a.w0.t.t;
import d.a.w0.t.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MultiMediaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.q0.z3.m.c.c.a> f22585a;

    /* renamed from: b  reason: collision with root package name */
    public Context f22586b;

    /* renamed from: c  reason: collision with root package name */
    public a f22587c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22588d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22589e;

    /* loaded from: classes4.dex */
    public static class MultiMediaHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f22590a;

        /* renamed from: b  reason: collision with root package name */
        public SimpleDraweeView f22591b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDraweeView f22592c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<SimpleDraweeView> f22593d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f22594e;

        /* renamed from: f  reason: collision with root package name */
        public View f22595f;

        /* renamed from: g  reason: collision with root package name */
        public MultiMediaAdapter f22596g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f22597h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f22598e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ MultiMediaHolder f22599f;

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
                this.f22599f = multiMediaHolder;
                this.f22598e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.q0.z3.m.c.c.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22598e == null || this.f22599f.f22596g == null || h.e(this.f22599f.f22596g.e()) || (aVar = (d.a.q0.z3.m.c.c.a) h.c(this.f22599f.f22596g.e(), this.f22599f.getAdapterPosition())) == null) {
                    return;
                }
                this.f22598e.e(this.f22599f.getAdapterPosition(), view, aVar);
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
            this.f22593d = new ArrayList<>();
            this.f22590a = (SimpleDraweeView) view.findViewById(R.id.media_cover);
            this.f22591b = (SimpleDraweeView) view.findViewById(R.id.media_cover1);
            this.f22592c = (SimpleDraweeView) view.findViewById(R.id.media_cover2);
            this.f22593d.add(this.f22590a);
            this.f22593d.add(this.f22591b);
            this.f22593d.add(this.f22592c);
            this.f22597h = (LinearLayout) view.findViewById(R.id.media_cover_wrap);
            this.f22594e = (TextView) view.findViewById(R.id.tv_choose_duration);
            this.f22595f = view.findViewById(R.id.v_bottom_dot);
            view.setOnClickListener(new a(this, aVar));
        }

        public void b(MultiMediaAdapter multiMediaAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, multiMediaAdapter) == null) {
                this.f22596g = multiMediaAdapter;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        void e(int i2, View view, d.a.q0.z3.m.c.c.a aVar);
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
        this.f22588d = false;
        this.f22589e = false;
    }

    public List<d.a.q0.z3.m.c.c.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<d.a.q0.z3.m.c.c.a> list = this.f22585a;
            return list == null ? new ArrayList() : list;
        }
        return (List) invokeV.objValue;
    }

    public List<d.a.q0.z3.m.c.c.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22585a : (List) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f22589e) {
            return;
        }
        notifyDataSetChanged();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (d.a.q0.z3.m.c.c.a aVar : e()) {
                aVar.d(false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h.b(this.f22585a) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (h.e(this.f22585a)) {
                return -1;
            }
            return this.f22585a.get(i2).b();
        }
        return invokeI.intValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f22588d = z;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f22589e = z;
        }
    }

    public void j(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f22587c = aVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        d.a.q0.z3.m.c.c.a aVar;
        String str;
        ArrayList<SimpleDraweeView> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, viewHolder, i2) == null) && (aVar = (d.a.q0.z3.m.c.c.a) h.c(this.f22585a, i2)) != null && (viewHolder instanceof MultiMediaHolder)) {
            MultiMediaHolder multiMediaHolder = (MultiMediaHolder) viewHolder;
            LocalAlbumInfo a2 = aVar.a();
            if (a2 != null) {
                if ((multiMediaHolder.f22590a.getTag() == null || !TextUtils.equals((String) multiMediaHolder.f22590a.getTag(), a2.path)) && (str = a2.path) != null) {
                    multiMediaHolder.f22590a.setTag(str);
                    ArrayList<SimpleDraweeView> arrayList2 = multiMediaHolder.f22593d;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        for (int i3 = 0; i3 < multiMediaHolder.f22593d.size(); i3++) {
                            multiMediaHolder.f22593d.get(i3).setImageURI(Uri.fromFile(new File(a2.path)));
                        }
                    } else {
                        multiMediaHolder.f22590a.setImageURI(Uri.fromFile(new File(a2.path)));
                    }
                }
                multiMediaHolder.f22594e.setText(w.b((int) a2.getDurationWithSpeed()));
                multiMediaHolder.f22595f.setVisibility(aVar.c() ? 0 : 4);
                if (aVar.b() != 2 || (arrayList = multiMediaHolder.f22593d) == null) {
                    return;
                }
                int size = arrayList.size();
                int i4 = 1;
                if (!this.f22588d && !this.f22589e) {
                    multiMediaHolder.f22597h.getLayoutParams().width = ((int) t.i(R.dimen.ds100)) * size;
                    while (i4 < size) {
                        multiMediaHolder.f22593d.get(i4).setVisibility(0);
                        i4++;
                    }
                    return;
                }
                while (i4 < size) {
                    multiMediaHolder.f22593d.get(i4).setVisibility(8);
                    i4++;
                }
                multiMediaHolder.f22597h.getLayoutParams().width = (int) t.i(R.dimen.ds100);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i2)) == null) {
            this.f22586b = viewGroup.getContext();
            if (i2 == 2) {
                MultiMediaHolder multiMediaHolder = new MultiMediaHolder(LayoutInflater.from(this.f22586b).inflate(R.layout.item_multi_media_layout, viewGroup, false), this.f22587c);
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
                d.a.q0.z3.m.c.c.a aVar = (d.a.q0.z3.m.c.c.a) h.c(this.f22585a, i2);
                if (viewHolder instanceof MultiMediaHolder) {
                    ((MultiMediaHolder) viewHolder).f22595f.setVisibility(aVar.c() ? 0 : 4);
                    return;
                }
                return;
            }
            onBindViewHolder(viewHolder, i2);
        }
    }
}
