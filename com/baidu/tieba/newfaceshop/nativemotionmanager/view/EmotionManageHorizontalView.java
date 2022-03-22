package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.d.f.q.h;
import c.a.o0.r.t.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class EmotionManageHorizontalView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34713b;

    /* renamed from: c  reason: collision with root package name */
    public View f34714c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34715d;

    /* renamed from: e  reason: collision with root package name */
    public View f34716e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f34717f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34718g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34719h;
    public View i;
    public View j;
    public f k;
    public EmotionPackageData l;
    public TbPageContext m;
    public NewFaceGroupDownloadModel n;
    public PermissionJudgePolicy o;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageHorizontalView a;

        public a(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageHorizontalView;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.l == null) {
                return;
            }
            this.a.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.a.m.getPageActivity(), this.a.l.id, 0)));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EmotionManageHorizontalView f34720b;

        public b(EmotionManageHorizontalView emotionManageHorizontalView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34720b = emotionManageHorizontalView;
            this.a = i;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921311, Integer.valueOf(this.a)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageHorizontalView a;

        public c(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageHorizontalView;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageHorizontalView a;

        public d(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageHorizontalView;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c.a.p0.r2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageHorizontalView a;

        public e(EmotionManageHorizontalView emotionManageHorizontalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageHorizontalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageHorizontalView;
        }

        @Override // c.a.p0.r2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                n.M(this.a.m.getPageActivity(), R.string.obfuscated_res_0x7f0f04e7);
                this.a.l();
            }
        }

        @Override // c.a.p0.r2.e.b
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i > 0 && i < 100) {
                    n.K(this.a.m.getPageActivity(), h.a(R.string.obfuscated_res_0x7f0f0d00));
                } else if (i >= 100) {
                    n.J(this.a.m.getPageActivity(), R.string.obfuscated_res_0x7f0f04e2);
                }
            }
        }

        @Override // c.a.p0.r2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                n.M(this.a.m.getPageActivity(), R.string.obfuscated_res_0x7f0f04e2);
                this.a.k();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<EmotionPackageData.SingleEmotionData> a;

        /* renamed from: b  reason: collision with root package name */
        public TbPageContext f34721b;

        /* renamed from: c  reason: collision with root package name */
        public int f34722c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34723d;

        /* loaded from: classes5.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f34724b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f34725c;

            /* renamed from: d  reason: collision with root package name */
            public View f34726d;

            public a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = view;
                view.setEnabled(false);
                this.f34724b = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090887);
                this.f34725c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0908ab);
                View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f090874);
                this.f34726d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, int i, boolean z, int i2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f34724b.setDefaultResource(R.drawable.obfuscated_res_0x7f080b75);
                    this.f34724b.J(singleEmotionData.thumbnail, 10, false);
                }
                if (i2 == 0) {
                    if (i == 0) {
                        this.f34725c.setVisibility(8);
                    }
                    if (i == 1) {
                        this.f34725c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.f34725c, R.drawable.obfuscated_res_0x7f0804c6);
                    }
                    if (i == 2) {
                        this.f34725c.setVisibility(0);
                        SkinManager.setBackgroundResource(this.f34725c, R.drawable.obfuscated_res_0x7f0804c8);
                    }
                } else {
                    this.f34725c.setVisibility(8);
                }
                if (i2 == 7 && z) {
                    this.f34726d.setVisibility(0);
                } else {
                    this.f34726d.setVisibility(8);
                }
            }
        }

        public f(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList();
            this.f34722c = 0;
            this.f34723d = false;
            this.f34721b = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f34722c = i;
            this.a.clear();
            if (list.size() > 8) {
                this.a.addAll(list.subList(0, 8));
                this.f34723d = true;
            } else {
                this.a.addAll(list);
                this.f34723d = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.a;
                if (list == null) {
                    return null;
                }
                return list.get(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f34721b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d025e, (ViewGroup) null);
                    aVar = new a(view);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.a(this.a.get(i), this.f34722c, this.f34723d, i);
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionManageHorizontalView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        h();
    }

    public final void e(EmotionPackageData emotionPackageData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, emotionPackageData, i) == null) || emotionPackageData == null) {
            return;
        }
        if (emotionPackageData.isUndownloadheader) {
            this.f34714c.setVisibility(0);
            this.f34715d.setText(String.format(h.a(R.string.obfuscated_res_0x7f0f0547), Integer.valueOf(i)));
        } else {
            this.f34714c.setVisibility(8);
        }
        l();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m.sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(this.m.getPageActivity(), this.l.id, 0)));
        }
    }

    public final void g() {
        EmotionPackageData emotionPackageData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && ViewHelper.checkUpIsLogin(this.m.getPageActivity())) {
            if (c.a.p0.r2.d.m().o()) {
                n.M(this.m.getPageActivity(), R.string.obfuscated_res_0x7f0f05ce);
                return;
            }
            Activity pageActivity = this.m.getPageActivity();
            if (this.o == null) {
                this.o = new PermissionJudgePolicy();
            }
            this.o.clearRequestPermissionList();
            this.o.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.o.startRequestPermission(pageActivity) || (emotionPackageData = this.l) == null || emotionPackageData.id < 0) {
                return;
            }
            if (this.n == null) {
                this.n = new NewFaceGroupDownloadModel();
            }
            this.f34718g.setEnabled(false);
            this.n.y(Integer.toString(this.l.id), Boolean.TRUE, new e(this));
        }
    }

    public HListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (HListView) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d025f, this);
            this.f34717f = viewGroup;
            this.a = (HListView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090891);
            this.i = this.f34717f.findViewById(R.id.obfuscated_res_0x7f090894);
            this.f34713b = (TextView) this.f34717f.findViewById(R.id.obfuscated_res_0x7f090898);
            View findViewById = this.f34717f.findViewById(R.id.obfuscated_res_0x7f090895);
            this.f34714c = findViewById;
            findViewById.setVisibility(8);
            this.f34715d = (TextView) this.f34717f.findViewById(R.id.obfuscated_res_0x7f09089a);
            View findViewById2 = this.f34717f.findViewById(R.id.obfuscated_res_0x7f090892);
            this.f34716e = findViewById2;
            findViewById2.setVisibility(8);
            TextView textView = (TextView) this.f34717f.findViewById(R.id.obfuscated_res_0x7f09088c);
            this.f34718g = textView;
            textView.setVisibility(8);
            this.f34718g.setOnClickListener(this);
            ImageView imageView = (ImageView) this.f34717f.findViewById(R.id.obfuscated_res_0x7f09088a);
            this.f34719h = imageView;
            imageView.setVisibility(8);
            this.f34719h.setOnClickListener(this);
            View findViewById3 = this.f34717f.findViewById(R.id.obfuscated_res_0x7f09088b);
            this.j = findViewById3;
            findViewById3.setOnClickListener(this);
            setOnClickListener(this);
            this.a.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5));
            this.a.setOnItemClickListener(new a(this));
            this.a.setSelector(this.m.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081200));
            f fVar = new f(this.m);
            this.k = fVar;
            this.a.setAdapter((ListAdapter) fVar);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            ViewGroup viewGroup = this.f34717f;
            if (viewGroup != null) {
                SkinManager.setBackgroundColor(viewGroup, R.color.CAM_X0201, i);
            }
            View view = this.i;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0204, i);
            }
            View view2 = this.f34714c;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0204, i);
            }
            TextView textView = this.f34713b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, i);
            }
            TextView textView2 = this.f34715d;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0107, i);
            }
            TextView textView3 = this.f34718g;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0302, i);
                SkinManager.setBackgroundResource(this.f34718g, R.drawable.bg_emotion_download, i);
            }
            ImageView imageView = this.f34719h;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.obfuscated_res_0x7f0804c5, i);
            }
            View view3 = this.f34716e;
            if (view3 != null) {
                SkinManager.setViewTextColor(view3, R.color.white_alpha70, i);
            }
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.m == null) {
            return;
        }
        String a2 = h.a(R.string.obfuscated_res_0x7f0f0542);
        String a3 = h.a(R.string.obfuscated_res_0x7f0f0541);
        String a4 = h.a(R.string.obfuscated_res_0x7f0f0540);
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.m.getPageActivity());
        aVar.setMessage(a2);
        aVar.setPositiveButton(a3, new b(this, i));
        aVar.setNegativeButton(a4, new c(this));
        aVar.setOnCalcelListener(new d(this));
        aVar.create(this.m).show();
    }

    public final void k() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (textView = this.f34718g) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f054f);
        SkinManager.setViewTextColor(this.f34718g, (int) R.color.CAM_X0109);
        this.f34718g.setBackgroundDrawable(null);
        this.f34718g.setEnabled(false);
    }

    public final void l() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (textView = this.f34718g) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0543);
        SkinManager.setViewTextColor(this.f34718g, (int) R.color.CAM_X0302);
        SkinManager.setBackgroundResource(this.f34718g, R.drawable.bg_emotion_download);
        this.f34718g.setEnabled(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || this.l == null) {
            return;
        }
        if (view.getId() == R.id.obfuscated_res_0x7f09088c && view.isShown()) {
            g();
        } else if ((view.getId() == R.id.obfuscated_res_0x7f09088b || view.getId() == R.id.obfuscated_res_0x7f09088a) && this.f34719h.isShown()) {
            EmotionPackageData emotionPackageData = this.l;
            if (emotionPackageData != null) {
                j(emotionPackageData.id);
            }
        } else {
            f();
        }
    }

    public void setData(EmotionPackageData emotionPackageData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, emotionPackageData, i) == null) {
            this.l = emotionPackageData;
            if (emotionPackageData == null) {
                return;
            }
            this.k.a(emotionPackageData.pics, emotionPackageData.typeofemotion);
            this.f34713b.setText(this.l.name);
            if (emotionPackageData.ishasdownload) {
                this.f34716e.setVisibility(8);
                this.f34718g.setVisibility(8);
                if (c.a.p0.r2.h.a.b().a()) {
                    this.f34719h.setVisibility(0);
                } else {
                    this.f34719h.setVisibility(8);
                }
            } else {
                this.f34719h.setVisibility(8);
                this.f34718g.setVisibility(0);
                this.f34716e.setVisibility(0);
            }
            e(emotionPackageData, i);
        }
    }
}
