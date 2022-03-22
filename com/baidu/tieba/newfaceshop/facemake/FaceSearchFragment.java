package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.p0.r2.g.f;
import c.a.p0.r2.g.h;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import com.baidu.tieba.newfaceshop.facemake.FaceImageLayout;
import com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class FaceSearchFragment extends BaseFragment implements SearchEditView.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SearchEditView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34678b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f34679c;

    /* renamed from: d  reason: collision with root package name */
    public FaceImageLayout f34680d;

    /* renamed from: e  reason: collision with root package name */
    public NoDataView f34681e;

    /* renamed from: f  reason: collision with root package name */
    public View f34682f;

    /* renamed from: g  reason: collision with root package name */
    public AutoLineWrapLayout f34683g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView f34684h;
    public h i;
    public List<EmotionImageData> j;
    public SearchEmotionModel k;
    public GetHotWordsModel l;
    public List<String> m;
    public int n;
    public boolean o;
    public String p;
    public f q;
    public Activity r;
    public final SearchEmotionModel.b s;
    public final BdListView.p t;

    /* loaded from: classes5.dex */
    public class a implements FaceImageLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceSearchFragment a;

        public a(FaceSearchFragment faceSearchFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceSearchFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceSearchFragment;
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n.w(this.a.r, this.a.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements GetHotWordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceSearchFragment a;

        public b(FaceSearchFragment faceSearchFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceSearchFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceSearchFragment;
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.f34683g.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
                return;
            }
            this.a.m.addAll(list);
            if (this.a.m == null || this.a.m.isEmpty()) {
                this.a.f34683g.setVisibility(8);
                this.a.f34678b.setVisibility(8);
            }
            this.a.S0();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FaceSearchFragment f34685b;

        public c(FaceSearchFragment faceSearchFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceSearchFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34685b = faceSearchFragment;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f34685b.a.setText(this.a);
                this.f34685b.a.setSelection(this.a.length());
                this.f34685b.W0(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SearchEmotionModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceSearchFragment a;

        public d(FaceSearchFragment faceSearchFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceSearchFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceSearchFragment;
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void a(String str, c.a.p0.z0.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
                this.a.getBaseFragmentActivity().hideProgressBar();
                if (aVar == null || aVar.a() == null || aVar.a().isEmpty()) {
                    if (this.a.n == 0) {
                        this.a.Z0();
                        return;
                    }
                    return;
                }
                this.a.n = aVar.c();
                if (this.a.n == 1) {
                    this.a.j.clear();
                }
                this.a.o = aVar.b() != 0;
                this.a.j.addAll(aVar.a());
                this.a.i.notifyDataSetChanged();
                this.a.a1();
                n.w(this.a.getActivity(), this.a.a);
            }
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.getBaseFragmentActivity().hideProgressBar();
                if (this.a.n == 1) {
                    this.a.Z0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceSearchFragment a;

        public e(FaceSearchFragment faceSearchFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceSearchFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceSearchFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.U0();
            }
        }
    }

    public FaceSearchFragment() {
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
        this.s = new d(this);
        this.t = new e(this);
    }

    public LinkedHashMap<String, EmotionImageData> R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            h hVar = this.i;
            if (hVar != null) {
                return hVar.i();
            }
            return null;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f34683g.setVisibility(0);
            this.f34678b.setVisibility(0);
            int min = Math.min(this.m.size(), 10);
            for (int i = 0; i < min; i++) {
                String str = this.m.get(i);
                if (!TextUtils.isEmpty(str)) {
                    String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                    TextView textView = new TextView(this.r);
                    SkinManager.setBackgroundColor(textView, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
                    int f2 = n.f(this.r, R.dimen.obfuscated_res_0x7f0701be);
                    textView.setPadding(f2, f2, f2, f2);
                    textView.setText(str2);
                    textView.setTextSize(0, n.f(this.r, R.dimen.obfuscated_res_0x7f0702b3));
                    textView.setSingleLine();
                    textView.setOnClickListener(new c(this, str));
                    this.f34683g.addView(textView);
                }
            }
        }
    }

    public final void T0(View view) {
        Serializable serializable;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.f34679c = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0911f5);
            FaceImageLayout faceImageLayout = (FaceImageLayout) view.findViewById(R.id.obfuscated_res_0x7f0911d2);
            this.f34680d = faceImageLayout;
            faceImageLayout.setListener(new a(this));
            this.f34682f = view.findViewById(R.id.obfuscated_res_0x7f0923c9);
            SearchEditView searchEditView = (SearchEditView) view.findViewById(R.id.obfuscated_res_0x7f090861);
            this.a = searchEditView;
            searchEditView.setCallback(this);
            this.f34683g = (AutoLineWrapLayout) view.findViewById(R.id.obfuscated_res_0x7f0911df);
            this.f34678b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09221d);
            SkinManager.setBackgroundResource(this.f34679c, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f34682f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f34678b, (int) R.color.CAM_X0109);
            BdListView bdListView = (BdListView) view.findViewById(R.id.obfuscated_res_0x7f091288);
            this.f34684h = bdListView;
            bdListView.setOnSrollToBottomListener(this.t);
            this.j = new ArrayList();
            h hVar = new h(this.j, 10);
            this.i = hVar;
            hVar.l(this.q);
            this.f34684h.setAdapter((ListAdapter) this.i);
            if (getArguments() == null || (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) == null || !(serializable instanceof ArrayList)) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 2 && (emotionImageData = faceData.emotionImageData) != null) {
                    linkedHashMap.put(emotionImageData.getPicUrl(), faceData.emotionImageData);
                }
            }
            this.i.g(linkedHashMap);
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!l.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c15);
            } else if (this.o) {
                getBaseFragmentActivity().showProgressBar();
                this.k.z(this.p, this.n + 1, 40, this.s);
            }
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l = new GetHotWordsModel();
            this.m = new ArrayList();
            this.l.z(new b(this));
        }
    }

    public final void W0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!l.z()) {
            showToast(R.string.obfuscated_res_0x7f0f0c15);
            return;
        }
        getBaseFragmentActivity().showProgressBar();
        this.n = 0;
        this.p = str;
        this.k.z(str, 0 + 1, 40, this.s);
    }

    public void X0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.q = fVar;
            h hVar = this.i;
            if (hVar != null) {
                hVar.l(fVar);
            }
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            List<String> list = this.m;
            if (list != null && !list.isEmpty()) {
                this.f34683g.setVisibility(0);
                this.f34678b.setVisibility(0);
            }
            this.f34684h.setVisibility(8);
            NoDataView noDataView = this.f34681e;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f34681e == null) {
                NoDataView a2 = NoDataViewFactory.a(this.r, this.f34680d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this.r, R.dimen.obfuscated_res_0x7f070297)), NoDataViewFactory.e.c(this.r.getText(R.string.obfuscated_res_0x7f0f05d4).toString()), null);
                this.f34681e = a2;
                a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f34681e.setVisibility(0);
            this.f34683g.setVisibility(8);
            this.f34684h.setVisibility(8);
            this.f34678b.setVisibility(8);
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f34684h.setVisibility(0);
            this.f34678b.setVisibility(8);
            this.f34683g.setVisibility(8);
            NoDataView noDataView = this.f34681e;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void onClickSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            W0(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            Activity pageActivity = getPageContext().getPageActivity();
            this.r = pageActivity;
            pageActivity.getWindow().setSoftInputMode(3);
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02ed, (ViewGroup) null);
            T0(inflate);
            this.k = new SearchEmotionModel();
            this.n = 1;
            V0();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            h hVar = this.i;
            if (hVar != null) {
                hVar.k();
            }
            this.k.cancelLoadData();
            this.l.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void onTextChanged(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && str.length() == 0) {
            this.j.clear();
            h hVar = this.i;
            if (hVar != null) {
                hVar.notifyDataSetChanged();
            }
            Y0();
        }
    }
}
