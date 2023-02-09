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
import com.baidu.tieba.ay9;
import com.baidu.tieba.dg9;
import com.baidu.tieba.lx9;
import com.baidu.tieba.view.widget.mediaedit.SimpleDraweeView;
import com.baidu.tieba.xx9;
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
    public List<dg9> a;
    public Context b;
    public a c;
    public boolean d;
    public boolean e;

    /* loaded from: classes6.dex */
    public interface a {
        void e(int i, View view2, dg9 dg9Var);
    }

    /* loaded from: classes6.dex */
    public static class MultiMediaHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;
        public SimpleDraweeView b;
        public SimpleDraweeView c;
        public ArrayList<SimpleDraweeView> d;
        public TextView e;
        public View f;
        public MultiMediaAdapter g;
        public LinearLayout h;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;
            public final /* synthetic */ MultiMediaHolder b;

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
                this.b = multiMediaHolder;
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                dg9 dg9Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.g != null && !lx9.e(this.b.g.e()) && (dg9Var = (dg9) lx9.c(this.b.g.e(), this.b.getAdapterPosition())) != null) {
                    this.a.e(this.b.getAdapterPosition(), view2, dg9Var);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiMediaHolder(View view2, a aVar) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, aVar};
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
            this.d = new ArrayList<>();
            this.a = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f0915d6);
            this.b = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f0915d7);
            this.c = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f0915d8);
            this.d.add(this.a);
            this.d.add(this.b);
            this.d.add(this.c);
            this.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0915d9);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924c4);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f09263e);
            view2.setOnClickListener(new a(this, aVar));
        }

        public void b(MultiMediaAdapter multiMediaAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, multiMediaAdapter) == null) {
                this.g = multiMediaAdapter;
            }
        }
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
        this.d = false;
        this.e = false;
    }

    public List<dg9> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<dg9> list = this.a;
            if (list == null) {
                return new ArrayList();
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public List<dg9> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.e) {
            notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (dg9 dg9Var : e()) {
                dg9Var.c(false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return lx9.b(this.a);
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (lx9.e(this.a)) {
                return -1;
            }
            return this.a.get(i).getType();
        }
        return invokeI.intValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.d = z;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.e = z;
        }
    }

    public void j(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.c = aVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        dg9 dg9Var;
        String str;
        int i2;
        ArrayList<SimpleDraweeView> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, viewHolder, i) == null) && (dg9Var = (dg9) lx9.c(this.a, i)) != null && (viewHolder instanceof MultiMediaHolder)) {
            MultiMediaHolder multiMediaHolder = (MultiMediaHolder) viewHolder;
            LocalAlbumInfo a2 = dg9Var.a();
            if (a2 != null) {
                if ((multiMediaHolder.a.getTag() == null || !TextUtils.equals((String) multiMediaHolder.a.getTag(), a2.path)) && (str = a2.path) != null) {
                    multiMediaHolder.a.setTag(str);
                    ArrayList<SimpleDraweeView> arrayList2 = multiMediaHolder.d;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        for (int i3 = 0; i3 < multiMediaHolder.d.size(); i3++) {
                            multiMediaHolder.d.get(i3).setImageURI(Uri.fromFile(new File(a2.path)));
                        }
                    } else {
                        multiMediaHolder.a.setImageURI(Uri.fromFile(new File(a2.path)));
                    }
                }
                multiMediaHolder.e.setText(ay9.b((int) a2.getDurationWithSpeed()));
                View view2 = multiMediaHolder.f;
                if (dg9Var.b()) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                view2.setVisibility(i2);
                if (dg9Var.getType() == 2 && (arrayList = multiMediaHolder.d) != null) {
                    int size = arrayList.size();
                    int i4 = 1;
                    if (!this.d && !this.e) {
                        multiMediaHolder.h.getLayoutParams().width = ((int) xx9.i(R.dimen.obfuscated_res_0x7f07019a)) * size;
                        while (i4 < size) {
                            multiMediaHolder.d.get(i4).setVisibility(0);
                            i4++;
                        }
                        return;
                    }
                    while (i4 < size) {
                        multiMediaHolder.d.get(i4).setVisibility(8);
                        i4++;
                    }
                    multiMediaHolder.h.getLayoutParams().width = (int) xx9.i(R.dimen.obfuscated_res_0x7f07019a);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, viewHolder, i, list) == null) {
            if (!lx9.e(list)) {
                dg9 dg9Var = (dg9) lx9.c(this.a, i);
                if (viewHolder instanceof MultiMediaHolder) {
                    View view2 = ((MultiMediaHolder) viewHolder).f;
                    if (dg9Var.b()) {
                        i2 = 0;
                    } else {
                        i2 = 4;
                    }
                    view2.setVisibility(i2);
                    return;
                }
                return;
            }
            onBindViewHolder(viewHolder, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i)) == null) {
            this.b = viewGroup.getContext();
            if (i == 2) {
                MultiMediaHolder multiMediaHolder = new MultiMediaHolder(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d040b, viewGroup, false), this.c);
                multiMediaHolder.b(this);
                return multiMediaHolder;
            }
            return null;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
