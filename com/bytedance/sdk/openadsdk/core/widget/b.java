package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67117a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f67118b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f67119c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f67120d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f67121e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f67122f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f67123g;

    /* renamed from: h  reason: collision with root package name */
    public Button f67124h;

    /* renamed from: i  reason: collision with root package name */
    public a f67125i;

    /* renamed from: j  reason: collision with root package name */
    public String f67126j;
    public String k;
    public String l;
    public String m;
    public String n;
    public HashMap<String, String> o;
    public View p;
    public TextView q;
    public boolean r;
    public List<c> s;

    /* loaded from: classes9.dex */
    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1912b extends ArrayAdapter<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f67130a;

        /* renamed from: com.bytedance.sdk.openadsdk.core.widget.b$b$a */
        /* loaded from: classes9.dex */
        public class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public TextView f67131a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f67132b;

            /* renamed from: c  reason: collision with root package name */
            public ImageView f67133c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ C1912b f67134d;

            public a(C1912b c1912b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1912b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67134d = c1912b;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1912b(b bVar, Context context, int i2, List<c> list) {
            super(context, i2, list);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, Integer.valueOf(i2), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (List) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67130a = bVar;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NonNull
        public View getView(int i2, @Nullable View view, @NonNull ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, view, viewGroup)) == null) {
                c item = getItem(i2);
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(t.f(this.f67130a.f67117a, "tt_app_detail_listview_item"), viewGroup, false);
                    aVar = new a(this);
                    aVar.f67131a = (TextView) view.findViewById(t.e(this.f67130a.f67117a, "tt_item_title_tv"));
                    aVar.f67132b = (TextView) view.findViewById(t.e(this.f67130a.f67117a, "tt_item_desc_tv"));
                    aVar.f67133c = (ImageView) view.findViewById(t.e(this.f67130a.f67117a, "tt_item_select_img"));
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.f67133c.setVisibility(0);
                if ("补充中，可于应用官网查看".equals(item.a())) {
                    aVar.f67133c.setVisibility(4);
                }
                aVar.f67131a.setText(item.a());
                aVar.f67132b.setText(item.b());
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f67135a;

        /* renamed from: b  reason: collision with root package name */
        public String f67136b;

        /* renamed from: c  reason: collision with root package name */
        public String f67137c;

        public c(b bVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67135a = bVar;
            this.f67136b = str;
            this.f67137c = str2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67136b : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67137c : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, String str) {
        super(context, t.g(context, "tt_dialog_full"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67126j = "补充中，可于应用官网查看";
        this.k = "暂无";
        this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
        this.r = false;
        this.s = new ArrayList();
        this.f67117a = context;
        if (context == null) {
            this.f67117a = o.a();
        }
        this.n = str;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.f67118b != null) {
                this.f67118b.setText(String.format(t.a(this.f67117a, "tt_open_app_detail_developer"), this.f67126j));
            }
            if (this.f67119c != null) {
                this.f67119c.setText(String.format(t.a(this.f67117a, "tt_open_app_version"), this.k));
            }
            String str = this.m;
            if (str != null) {
                this.f67120d.setText(str);
            }
            if (this.f67122f != null) {
                this.f67122f.setText(String.format(t.a(this.f67117a, "tt_open_app_name"), this.l));
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = getLayoutInflater().inflate(t.f(this.f67117a, "tt_app_detail_full_dialog_list_head"), (ViewGroup) null);
            this.p = inflate;
            this.f67118b = (TextView) inflate.findViewById(t.e(this.f67117a, "tt_app_developer_tv"));
            this.f67120d = (TextView) this.p.findViewById(t.e(this.f67117a, "tt_app_privacy_url_tv"));
            this.q = (TextView) this.p.findViewById(t.e(this.f67117a, "tt_app_privacy_tv"));
            this.f67122f = (TextView) this.p.findViewById(t.e(this.f67117a, "tt_app_name_tv"));
            this.f67119c = (TextView) this.p.findViewById(t.e(this.f67117a, "tt_app_version_tv"));
            this.f67124h = (Button) findViewById(t.e(this.f67117a, "tt_download_app_btn"));
            this.f67123g = (ListView) findViewById(t.e(this.f67117a, "tt_privacy_list"));
            this.f67121e = (TextView) findViewById(t.e(this.f67117a, "tt_app_detail_back_tv"));
            this.f67123g.addHeaderView(this.p);
            if (this.r) {
                this.f67124h.setVisibility(0);
                this.f67124h.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f67127a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67127a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f67127a.f67125i == null) {
                            return;
                        }
                        this.f67127a.f67125i.a(this.f67127a);
                    }
                });
            } else {
                this.f67124h.setVisibility(8);
            }
            this.f67121e.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f67128a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67128a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f67128a.f67125i == null) {
                        return;
                    }
                    this.f67128a.f67125i.b(this.f67128a);
                }
            });
            this.f67120d.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f67129a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67129a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f67129a.f67125i == null) {
                        return;
                    }
                    this.f67129a.f67125i.c(this.f67129a);
                }
            });
            List<c> list = this.s;
            if (list == null || list.size() <= 0) {
                return;
            }
            Context context = this.f67117a;
            this.f67123g.setAdapter((ListAdapter) new C1912b(this, context, t.f(context, "tt_app_detail_listview_item"), this.s));
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f67125i) == null) {
            return;
        }
        aVar.b(this);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(t.f(this.f67117a, "tt_app_detail_full_dialog"));
            a();
            b();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.show();
            c();
        }
    }

    public b a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            this.f67125i = aVar;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (TextUtils.isEmpty(this.n)) {
                this.k = "暂无";
                this.f67126j = "补充中，可于应用官网查看";
                this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                a(this.o);
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.core.e.c b2 = com.bytedance.sdk.openadsdk.core.b.b(new JSONObject(this.n));
                if (b2 != null) {
                    String b3 = b2.b();
                    this.k = b3;
                    if (TextUtils.isEmpty(b3)) {
                        this.k = "暂无";
                    }
                    String c2 = b2.c();
                    this.f67126j = c2;
                    if (TextUtils.isEmpty(c2)) {
                        this.f67126j = "补充中，可于应用官网查看";
                    }
                    String d2 = b2.d();
                    this.m = d2;
                    if (TextUtils.isEmpty(d2)) {
                        this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                    }
                    String g2 = b2.g();
                    if (!TextUtils.isEmpty(g2)) {
                        this.l = g2;
                    }
                    HashMap<String, String> a2 = b2.a();
                    this.o = a2;
                    a(a2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, hashMap) == null) {
            List<c> list = this.s;
            if (list != null && list.size() > 0) {
                this.s.clear();
            }
            if (this.s == null) {
                this.s = new ArrayList();
            }
            if (hashMap != null && hashMap.size() > 0) {
                for (String str : hashMap.keySet()) {
                    this.s.add(new c(this, str, hashMap.get(str)));
                }
                return;
            }
            this.s.add(new c(this, "补充中，可于应用官网查看", ""));
        }
    }

    public b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.r = z;
        }
    }
}
