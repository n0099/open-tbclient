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
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.r0.l2.g.f;
import c.a.r0.l2.g.h;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
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
/* loaded from: classes10.dex */
public class FaceSearchFragment extends BaseFragment implements SearchEditView.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SearchEditView f47245e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47246f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f47247g;

    /* renamed from: h  reason: collision with root package name */
    public FaceImageLayout f47248h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f47249i;

    /* renamed from: j  reason: collision with root package name */
    public View f47250j;

    /* renamed from: k  reason: collision with root package name */
    public AutoLineWrapLayout f47251k;
    public BdListView l;
    public h m;
    public List<EmotionImageData> n;
    public SearchEmotionModel o;
    public GetHotWordsModel p;
    public List<String> q;
    public int r;
    public boolean s;
    public String t;
    public f u;
    public Activity v;
    public final SearchEmotionModel.b w;
    public final BdListView.p x;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                l.w(this.a.v, this.a.f47245e);
            }
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceSearchFragment;
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.a.f47251k.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
                return;
            }
            this.a.q.addAll(list);
            if (this.a.q == null || this.a.q.isEmpty()) {
                this.a.f47251k.setVisibility(8);
                this.a.f47246f.setVisibility(8);
            }
            this.a.t();
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47252e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FaceSearchFragment f47253f;

        public c(FaceSearchFragment faceSearchFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceSearchFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47253f = faceSearchFragment;
            this.f47252e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47253f.f47245e.setText(this.f47252e);
                this.f47253f.f47245e.setSelection(this.f47252e.length());
                this.f47253f.x(this.f47252e);
            }
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceSearchFragment;
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void a(String str, c.a.r0.x0.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
                this.a.getBaseFragmentActivity().hideProgressBar();
                if (aVar == null || aVar.a() == null || aVar.a().isEmpty()) {
                    if (this.a.r == 0) {
                        this.a.z();
                        return;
                    }
                    return;
                }
                this.a.r = aVar.c();
                if (this.a.r == 1) {
                    this.a.n.clear();
                }
                this.a.s = aVar.b() != 0;
                this.a.n.addAll(aVar.a());
                this.a.m.notifyDataSetChanged();
                this.a.A();
                l.w(this.a.getActivity(), this.a.f47245e);
            }
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.a.getBaseFragmentActivity().hideProgressBar();
                if (this.a.r == 1) {
                    this.a.z();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceSearchFragment f47254e;

        public e(FaceSearchFragment faceSearchFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceSearchFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47254e = faceSearchFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47254e.v();
            }
        }
    }

    public FaceSearchFragment() {
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
        this.w = new d(this);
        this.x = new e(this);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l.setVisibility(0);
            this.f47246f.setVisibility(8);
            this.f47251k.setVisibility(8);
            NoDataView noDataView = this.f47249i;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    public LinkedHashMap<String, EmotionImageData> getChoosedMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h hVar = this.m;
            if (hVar != null) {
                return hVar.i();
            }
            return null;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void onClickSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            x(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            Activity pageActivity = getPageContext().getPageActivity();
            this.v = pageActivity;
            pageActivity.getWindow().setSoftInputMode(3);
            View inflate = layoutInflater.inflate(R.layout.fragment_pick_search, (ViewGroup) null);
            u(inflate);
            this.o = new SearchEmotionModel();
            this.r = 1;
            w();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public void onDeleteAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            h hVar = this.m;
            if (hVar != null) {
                hVar.k();
            }
            this.o.cancelLoadData();
            this.p.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void onTextChanged(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && str.length() == 0) {
            this.n.clear();
            h hVar = this.m;
            if (hVar != null) {
                hVar.notifyDataSetChanged();
            }
            y();
        }
    }

    public void setEmotionChooseCallback(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.u = fVar;
            h hVar = this.m;
            if (hVar != null) {
                hVar.l(fVar);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f47251k.setVisibility(0);
            this.f47246f.setVisibility(0);
            int min = Math.min(this.q.size(), 10);
            for (int i2 = 0; i2 < min; i2++) {
                String str = this.q.get(i2);
                if (!TextUtils.isEmpty(str)) {
                    String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                    TextView textView = new TextView(this.v);
                    SkinManager.setBackgroundColor(textView, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
                    int f2 = l.f(this.v, R.dimen.ds16);
                    textView.setPadding(f2, f2, f2, f2);
                    textView.setText(str2);
                    textView.setTextSize(0, l.f(this.v, R.dimen.fontsize24));
                    textView.setSingleLine();
                    textView.setOnClickListener(new c(this, str));
                    this.f47251k.addView(textView);
                }
            }
        }
    }

    public final void u(View view) {
        Serializable serializable;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            this.f47247g = (LinearLayout) view.findViewById(R.id.layout_root);
            FaceImageLayout faceImageLayout = (FaceImageLayout) view.findViewById(R.id.layout_content);
            this.f47248h = faceImageLayout;
            faceImageLayout.setListener(new a(this));
            this.f47250j = view.findViewById(R.id.view_line);
            SearchEditView searchEditView = (SearchEditView) view.findViewById(R.id.edit_search_view);
            this.f47245e = searchEditView;
            searchEditView.setCallback(this);
            this.f47251k = (AutoLineWrapLayout) view.findViewById(R.id.layout_hot_words);
            this.f47246f = (TextView) view.findViewById(R.id.tv_tips);
            SkinManager.setBackgroundResource(this.f47247g, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f47250j, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f47246f, R.color.CAM_X0109);
            BdListView bdListView = (BdListView) view.findViewById(R.id.listview_emotion);
            this.l = bdListView;
            bdListView.setOnSrollToBottomListener(this.x);
            this.n = new ArrayList();
            h hVar = new h(this.n, 10);
            this.m = hVar;
            hVar.l(this.u);
            this.l.setAdapter((ListAdapter) this.m);
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
            this.m.g(linkedHashMap);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!j.z()) {
                showToast(R.string.neterror);
            } else if (this.s) {
                getBaseFragmentActivity().showProgressBar();
                this.o.x(this.t, this.r + 1, 40, this.w);
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.p = new GetHotWordsModel();
            this.q = new ArrayList();
            this.p.x(new b(this));
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!j.z()) {
            showToast(R.string.neterror);
            return;
        }
        getBaseFragmentActivity().showProgressBar();
        this.r = 0;
        this.t = str;
        this.o.x(str, 0 + 1, 40, this.w);
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            List<String> list = this.q;
            if (list != null && !list.isEmpty()) {
                this.f47251k.setVisibility(0);
                this.f47246f.setVisibility(0);
            }
            this.l.setVisibility(8);
            NoDataView noDataView = this.f47249i;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.f47249i == null) {
                NoDataView a2 = NoDataViewFactory.a(this.v, this.f47248h, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.f(this.v, R.dimen.ds320)), NoDataViewFactory.e.c(this.v.getText(R.string.face_group_no_emotion).toString()), null);
                this.f47249i = a2;
                a2.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f47249i.setVisibility(0);
            this.f47251k.setVisibility(8);
            this.l.setVisibility(8);
            this.f47246f.setVisibility(8);
        }
    }
}
