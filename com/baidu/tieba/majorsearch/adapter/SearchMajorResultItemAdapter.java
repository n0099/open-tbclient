package com.baidu.tieba.majorsearch.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class SearchMajorResultItemAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f18404a;

    /* renamed from: b  reason: collision with root package name */
    public Context f18405b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f18406c;

    /* renamed from: d  reason: collision with root package name */
    public b f18407d;

    /* loaded from: classes5.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f18408a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SearchMajorResultItemAdapter searchMajorResultItemAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchMajorResultItemAdapter, view};
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
            this.f18408a = (TextView) view.findViewById(R.id.tv_major_name);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18409e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SearchMajorResultItemAdapter f18410f;

        public a(SearchMajorResultItemAdapter searchMajorResultItemAdapter, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchMajorResultItemAdapter, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18410f = searchMajorResultItemAdapter;
            this.f18409e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18410f.f18407d == null) {
                return;
            }
            this.f18410f.f18407d.a(this.f18409e);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str);
    }

    public SearchMajorResultItemAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18405b = context;
    }

    public final void e(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, textView, str) == null) || textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f18404a)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f18404a.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f18404a.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i2) {
        List<String> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, i2) == null) || (list = this.f18406c) == null) {
            return;
        }
        String str = list.get(i2);
        if (StringUtils.isNull(str)) {
            return;
        }
        viewHolder.f18408a.setText(str);
        SkinManager.setViewTextColor(viewHolder.f18408a, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(viewHolder.itemView, R.drawable.more_pop_item_bg_selector);
        e(viewHolder.f18408a, str);
        viewHolder.itemView.setOnClickListener(new a(this, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: g */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) ? new ViewHolder(this, LayoutInflater.from(this.f18405b).inflate(R.layout.search_major_item_layout, viewGroup, false)) : (ViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<String> list = this.f18406c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f18404a = str;
        }
    }

    public void m() {
        List<String> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (list = this.f18406c) == null) {
            return;
        }
        list.clear();
        notifyDataSetChanged();
    }

    public void n(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f18407d = bVar;
        }
    }

    public void setData(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f18406c = list;
            notifyDataSetChanged();
        }
    }
}
