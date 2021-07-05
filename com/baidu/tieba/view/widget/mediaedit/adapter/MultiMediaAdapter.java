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
import d.a.y0.t.h;
import d.a.y0.t.t;
import d.a.y0.t.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MultiMediaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.s0.z3.m.c.c.a> f22368a;

    /* renamed from: b  reason: collision with root package name */
    public Context f22369b;

    /* renamed from: c  reason: collision with root package name */
    public a f22370c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22371d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22372e;

    /* loaded from: classes5.dex */
    public static class MultiMediaHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f22373a;

        /* renamed from: b  reason: collision with root package name */
        public SimpleDraweeView f22374b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDraweeView f22375c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<SimpleDraweeView> f22376d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f22377e;

        /* renamed from: f  reason: collision with root package name */
        public View f22378f;

        /* renamed from: g  reason: collision with root package name */
        public MultiMediaAdapter f22379g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f22380h;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f22381e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ MultiMediaHolder f22382f;

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
                this.f22382f = multiMediaHolder;
                this.f22381e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a.s0.z3.m.c.c.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22381e == null || this.f22382f.f22379g == null || h.e(this.f22382f.f22379g.n()) || (aVar = (d.a.s0.z3.m.c.c.a) h.c(this.f22382f.f22379g.n(), this.f22382f.getAdapterPosition())) == null) {
                    return;
                }
                this.f22381e.e(this.f22382f.getAdapterPosition(), view, aVar);
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
            this.f22376d = new ArrayList<>();
            this.f22373a = (SimpleDraweeView) view.findViewById(R.id.media_cover);
            this.f22374b = (SimpleDraweeView) view.findViewById(R.id.media_cover1);
            this.f22375c = (SimpleDraweeView) view.findViewById(R.id.media_cover2);
            this.f22376d.add(this.f22373a);
            this.f22376d.add(this.f22374b);
            this.f22376d.add(this.f22375c);
            this.f22380h = (LinearLayout) view.findViewById(R.id.media_cover_wrap);
            this.f22377e = (TextView) view.findViewById(R.id.tv_choose_duration);
            this.f22378f = view.findViewById(R.id.v_bottom_dot);
            view.setOnClickListener(new a(this, aVar));
        }

        public void b(MultiMediaAdapter multiMediaAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, multiMediaAdapter) == null) {
                this.f22379g = multiMediaAdapter;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void e(int i2, View view, d.a.s0.z3.m.c.c.a aVar);
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
        this.f22371d = false;
        this.f22372e = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? h.b(this.f22368a) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (h.e(this.f22368a)) {
                return -1;
            }
            return this.f22368a.get(i2).b();
        }
        return invokeI.intValue;
    }

    public List<d.a.s0.z3.m.c.c.a> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d.a.s0.z3.m.c.c.a> list = this.f22368a;
            return list == null ? new ArrayList() : list;
        }
        return (List) invokeV.objValue;
    }

    public List<d.a.s0.z3.m.c.c.a> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22368a : (List) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f22372e) {
            return;
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        d.a.s0.z3.m.c.c.a aVar;
        String str;
        ArrayList<SimpleDraweeView> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) && (aVar = (d.a.s0.z3.m.c.c.a) h.c(this.f22368a, i2)) != null && (viewHolder instanceof MultiMediaHolder)) {
            MultiMediaHolder multiMediaHolder = (MultiMediaHolder) viewHolder;
            LocalAlbumInfo a2 = aVar.a();
            if (a2 != null) {
                if ((multiMediaHolder.f22373a.getTag() == null || !TextUtils.equals((String) multiMediaHolder.f22373a.getTag(), a2.path)) && (str = a2.path) != null) {
                    multiMediaHolder.f22373a.setTag(str);
                    ArrayList<SimpleDraweeView> arrayList2 = multiMediaHolder.f22376d;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        for (int i3 = 0; i3 < multiMediaHolder.f22376d.size(); i3++) {
                            multiMediaHolder.f22376d.get(i3).setImageURI(Uri.fromFile(new File(a2.path)));
                        }
                    } else {
                        multiMediaHolder.f22373a.setImageURI(Uri.fromFile(new File(a2.path)));
                    }
                }
                multiMediaHolder.f22377e.setText(w.b((int) a2.getDurationWithSpeed()));
                multiMediaHolder.f22378f.setVisibility(aVar.c() ? 0 : 4);
                if (aVar.b() != 2 || (arrayList = multiMediaHolder.f22376d) == null) {
                    return;
                }
                int size = arrayList.size();
                int i4 = 1;
                if (!this.f22371d && !this.f22372e) {
                    multiMediaHolder.f22380h.getLayoutParams().width = ((int) t.i(R.dimen.ds100)) * size;
                    while (i4 < size) {
                        multiMediaHolder.f22376d.get(i4).setVisibility(0);
                        i4++;
                    }
                    return;
                }
                while (i4 < size) {
                    multiMediaHolder.f22376d.get(i4).setVisibility(8);
                    i4++;
                }
                multiMediaHolder.f22380h.getLayoutParams().width = (int) t.i(R.dimen.ds100);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            this.f22369b = viewGroup.getContext();
            if (i2 == 2) {
                MultiMediaHolder multiMediaHolder = new MultiMediaHolder(LayoutInflater.from(this.f22369b).inflate(R.layout.item_multi_media_layout, viewGroup, false), this.f22370c);
                multiMediaHolder.b(this);
                return multiMediaHolder;
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (d.a.s0.z3.m.c.c.a aVar : n()) {
                aVar.d(false);
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f22371d = z;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f22372e = z;
        }
    }

    public void s(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f22370c = aVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, viewHolder, i2, list) == null) {
            if (!h.e(list)) {
                d.a.s0.z3.m.c.c.a aVar = (d.a.s0.z3.m.c.c.a) h.c(this.f22368a, i2);
                if (viewHolder instanceof MultiMediaHolder) {
                    ((MultiMediaHolder) viewHolder).f22378f.setVisibility(aVar.c() ? 0 : 4);
                    return;
                }
                return;
            }
            onBindViewHolder(viewHolder, i2);
        }
    }
}
