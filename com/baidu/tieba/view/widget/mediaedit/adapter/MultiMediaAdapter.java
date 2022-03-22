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
import c.a.v0.r.h;
import c.a.v0.r.t;
import c.a.v0.r.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.view.widget.mediaedit.SimpleDraweeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.bean.LocalAlbumInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MultiMediaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.p0.q4.n.c.c.a> a;

    /* renamed from: b  reason: collision with root package name */
    public Context f37163b;

    /* renamed from: c  reason: collision with root package name */
    public a f37164c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37165d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37166e;

    /* loaded from: classes6.dex */
    public static class MultiMediaHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;

        /* renamed from: b  reason: collision with root package name */
        public SimpleDraweeView f37167b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDraweeView f37168c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<SimpleDraweeView> f37169d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f37170e;

        /* renamed from: f  reason: collision with root package name */
        public View f37171f;

        /* renamed from: g  reason: collision with root package name */
        public MultiMediaAdapter f37172g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f37173h;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ MultiMediaHolder f37174b;

            public a(MultiMediaHolder multiMediaHolder, a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {multiMediaHolder, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f37174b = multiMediaHolder;
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a.p0.q4.n.c.c.a aVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a == null || this.f37174b.f37172g == null || h.e(this.f37174b.f37172g.e()) || (aVar = (c.a.p0.q4.n.c.c.a) h.c(this.f37174b.f37172g.e(), this.f37174b.getAdapterPosition())) == null) {
                    return;
                }
                this.a.e(this.f37174b.getAdapterPosition(), view, aVar);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37169d = new ArrayList<>();
            this.a = (SimpleDraweeView) view.findViewById(R.id.obfuscated_res_0x7f0913c1);
            this.f37167b = (SimpleDraweeView) view.findViewById(R.id.obfuscated_res_0x7f0913c2);
            this.f37168c = (SimpleDraweeView) view.findViewById(R.id.obfuscated_res_0x7f0913c3);
            this.f37169d.add(this.a);
            this.f37169d.add(this.f37167b);
            this.f37169d.add(this.f37168c);
            this.f37173h = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0913c4);
            this.f37170e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092190);
            this.f37171f = view.findViewById(R.id.obfuscated_res_0x7f0922e9);
            view.setOnClickListener(new a(this, aVar));
        }

        public void b(MultiMediaAdapter multiMediaAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, multiMediaAdapter) == null) {
                this.f37172g = multiMediaAdapter;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface a {
        void e(int i, View view, c.a.p0.q4.n.c.c.a aVar);
    }

    public MultiMediaAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37165d = false;
        this.f37166e = false;
    }

    public List<c.a.p0.q4.n.c.c.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<c.a.p0.q4.n.c.c.a> list = this.a;
            return list == null ? new ArrayList() : list;
        }
        return (List) invokeV.objValue;
    }

    public List<c.a.p0.q4.n.c.c.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f37166e) {
            return;
        }
        notifyDataSetChanged();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (c.a.p0.q4.n.c.c.a aVar : e()) {
                aVar.c(false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h.b(this.a) : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (h.e(this.a)) {
                return -1;
            }
            return this.a.get(i).getType();
        }
        return invokeI.intValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f37165d = z;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f37166e = z;
        }
    }

    public void j(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f37164c = aVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        c.a.p0.q4.n.c.c.a aVar;
        String str;
        ArrayList<SimpleDraweeView> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, viewHolder, i) == null) && (aVar = (c.a.p0.q4.n.c.c.a) h.c(this.a, i)) != null && (viewHolder instanceof MultiMediaHolder)) {
            MultiMediaHolder multiMediaHolder = (MultiMediaHolder) viewHolder;
            LocalAlbumInfo a2 = aVar.a();
            if (a2 != null) {
                if ((multiMediaHolder.a.getTag() == null || !TextUtils.equals((String) multiMediaHolder.a.getTag(), a2.path)) && (str = a2.path) != null) {
                    multiMediaHolder.a.setTag(str);
                    ArrayList<SimpleDraweeView> arrayList2 = multiMediaHolder.f37169d;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        for (int i2 = 0; i2 < multiMediaHolder.f37169d.size(); i2++) {
                            multiMediaHolder.f37169d.get(i2).setImageURI(Uri.fromFile(new File(a2.path)));
                        }
                    } else {
                        multiMediaHolder.a.setImageURI(Uri.fromFile(new File(a2.path)));
                    }
                }
                multiMediaHolder.f37170e.setText(w.b((int) a2.getDurationWithSpeed()));
                multiMediaHolder.f37171f.setVisibility(aVar.b() ? 0 : 4);
                if (aVar.getType() != 2 || (arrayList = multiMediaHolder.f37169d) == null) {
                    return;
                }
                int size = arrayList.size();
                int i3 = 1;
                if (!this.f37165d && !this.f37166e) {
                    multiMediaHolder.f37173h.getLayoutParams().width = ((int) t.i(R.dimen.obfuscated_res_0x7f07019a)) * size;
                    while (i3 < size) {
                        multiMediaHolder.f37169d.get(i3).setVisibility(0);
                        i3++;
                    }
                    return;
                }
                while (i3 < size) {
                    multiMediaHolder.f37169d.get(i3).setVisibility(8);
                    i3++;
                }
                multiMediaHolder.f37173h.getLayoutParams().width = (int) t.i(R.dimen.obfuscated_res_0x7f07019a);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i)) == null) {
            this.f37163b = viewGroup.getContext();
            if (i == 2) {
                MultiMediaHolder multiMediaHolder = new MultiMediaHolder(LayoutInflater.from(this.f37163b).inflate(R.layout.obfuscated_res_0x7f0d0408, viewGroup, false), this.f37164c);
                multiMediaHolder.b(this);
                return multiMediaHolder;
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, viewHolder, i, list) == null) {
            if (!h.e(list)) {
                c.a.p0.q4.n.c.c.a aVar = (c.a.p0.q4.n.c.c.a) h.c(this.a, i);
                if (viewHolder instanceof MultiMediaHolder) {
                    ((MultiMediaHolder) viewHolder).f37171f.setVisibility(aVar.b() ? 0 : 4);
                    return;
                }
                return;
            }
            onBindViewHolder(viewHolder, i);
        }
    }
}
