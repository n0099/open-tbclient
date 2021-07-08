package com.bytedance.sdk.openadsdk.dislike.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<FilterWord> f31085a;

    /* renamed from: b  reason: collision with root package name */
    public Context f31086b;

    /* renamed from: c  reason: collision with root package name */
    public a f31087c;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2, FilterWord filterWord);
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f31091a;

        /* renamed from: b  reason: collision with root package name */
        public FlowLayout f31092b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f31093c;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31093c = dVar;
        }
    }

    public d(Context context, List<FilterWord> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31085a = list;
        this.f31086b = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<FilterWord> list = this.f31085a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f31085a.get(i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                bVar = new b();
                view2 = LayoutInflater.from(this.f31086b).inflate(r.f(this.f31086b, "tt_dialog_listview_item"), viewGroup, false);
                bVar.f31091a = (TextView) view2.findViewById(r.e(this.f31086b, "tt_item_tv"));
                bVar.f31092b = (FlowLayout) view2.findViewById(r.e(this.f31086b, "tt_item_tv_son"));
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            FilterWord filterWord = this.f31085a.get(i2);
            bVar.f31091a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i2 != this.f31085a.size() - 1) {
                    bVar.f31091a.setBackgroundResource(r.d(this.f31086b, "tt_dislike_middle_seletor"));
                } else {
                    bVar.f31091a.setBackgroundResource(r.d(this.f31086b, "tt_dislike_bottom_seletor"));
                }
            }
            if (i2 == 0) {
                bVar.f31091a.setBackgroundResource(r.d(this.f31086b, "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                bVar.f31092b.removeAllViews();
                List<FilterWord> options = filterWord.getOptions();
                for (int i3 = 0; i3 < options.size(); i3++) {
                    FilterWord filterWord2 = options.get(i3);
                    TextView a2 = a();
                    a2.setText(filterWord2.getName());
                    a2.setOnClickListener(new View.OnClickListener(this, i2, filterWord2) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.d.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f31088a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ FilterWord f31089b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ d f31090c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2), filterWord2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31090c = this;
                            this.f31088a = i2;
                            this.f31089b = filterWord2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) || this.f31090c.f31087c == null) {
                                return;
                            }
                            this.f31090c.f31087c.a(this.f31088a, this.f31089b);
                        }
                    });
                    bVar.f31092b.addView(a2);
                }
                bVar.f31092b.setVisibility(0);
            } else {
                bVar.f31092b.setVisibility(8);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    private TextView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            TextView textView = new TextView(this.f31086b);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.setMargins(0, 0, com.bytedance.sdk.openadsdk.dislike.a.a.b().a(this.f31086b, 8.0f), com.bytedance.sdk.openadsdk.dislike.a.a.b().a(this.f31086b, 8.0f));
            textView.setLayoutParams(marginLayoutParams);
            textView.setPadding(com.bytedance.sdk.openadsdk.dislike.a.a.b().a(this.f31086b, 21.0f), com.bytedance.sdk.openadsdk.dislike.a.a.b().a(this.f31086b, 6.0f), com.bytedance.sdk.openadsdk.dislike.a.a.b().a(this.f31086b, 21.0f), com.bytedance.sdk.openadsdk.dislike.a.a.b().a(this.f31086b, 6.0f));
            textView.setBackgroundResource(r.d(this.f31086b, "tt_dislike_flowlayout_tv_bg"));
            textView.setTextColor(Color.parseColor("#BF161823"));
            textView.setTextSize(14.0f);
            textView.setAlpha(0.75f);
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f31087c = aVar;
        }
    }

    public void a(List<FilterWord> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f31085a.clear();
        this.f31085a.addAll(list);
        notifyDataSetChanged();
    }
}
