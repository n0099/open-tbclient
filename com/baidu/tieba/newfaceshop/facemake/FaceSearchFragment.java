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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.s0.c2.g.f;
import d.a.s0.c2.g.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class FaceSearchFragment extends BaseFragment implements SearchEditView.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SearchEditView f18861e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18862f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f18863g;

    /* renamed from: h  reason: collision with root package name */
    public FaceImageLayout f18864h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f18865i;
    public View j;
    public AutoLineWrapLayout k;
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

    /* loaded from: classes5.dex */
    public class a implements FaceImageLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FaceSearchFragment f18866a;

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
            this.f18866a = faceSearchFragment;
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.x(this.f18866a.v, this.f18866a.f18861e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements GetHotWordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FaceSearchFragment f18867a;

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
            this.f18867a = faceSearchFragment;
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f18867a.k.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
                return;
            }
            this.f18867a.q.addAll(list);
            if (this.f18867a.q == null || this.f18867a.q.isEmpty()) {
                this.f18867a.k.setVisibility(8);
                this.f18867a.f18862f.setVisibility(8);
            }
            this.f18867a.W0();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18868e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FaceSearchFragment f18869f;

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
            this.f18869f = faceSearchFragment;
            this.f18868e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18869f.f18861e.setText(this.f18868e);
                this.f18869f.f18861e.setSelection(this.f18868e.length());
                this.f18869f.a1(this.f18868e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SearchEmotionModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FaceSearchFragment f18870a;

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
            this.f18870a = faceSearchFragment;
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void a(String str, d.a.s0.o0.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
                this.f18870a.getBaseFragmentActivity().hideProgressBar();
                if (aVar == null || aVar.a() == null || aVar.a().isEmpty()) {
                    if (this.f18870a.r == 0) {
                        this.f18870a.d1();
                        return;
                    }
                    return;
                }
                this.f18870a.r = aVar.c();
                if (this.f18870a.r == 1) {
                    this.f18870a.n.clear();
                }
                this.f18870a.s = aVar.b() != 0;
                this.f18870a.n.addAll(aVar.a());
                this.f18870a.m.notifyDataSetChanged();
                this.f18870a.e1();
                l.x(this.f18870a.getActivity(), this.f18870a.f18861e);
            }
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f18870a.getBaseFragmentActivity().hideProgressBar();
                if (this.f18870a.r == 1) {
                    this.f18870a.d1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceSearchFragment f18871e;

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
            this.f18871e = faceSearchFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18871e.Y0();
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

    public LinkedHashMap<String, EmotionImageData> V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            h hVar = this.m;
            if (hVar != null) {
                return hVar.i();
            }
            return null;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k.setVisibility(0);
            this.f18862f.setVisibility(0);
            int min = Math.min(this.q.size(), 10);
            for (int i2 = 0; i2 < min; i2++) {
                String str = this.q.get(i2);
                if (!TextUtils.isEmpty(str)) {
                    String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                    TextView textView = new TextView(this.v);
                    SkinManager.setBackgroundColor(textView, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
                    int g2 = l.g(this.v, R.dimen.ds16);
                    textView.setPadding(g2, g2, g2, g2);
                    textView.setText(str2);
                    textView.setTextSize(0, l.g(this.v, R.dimen.fontsize24));
                    textView.setSingleLine();
                    textView.setOnClickListener(new c(this, str));
                    this.k.addView(textView);
                }
            }
        }
    }

    public final void X0(View view) {
        Serializable serializable;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.f18863g = (LinearLayout) view.findViewById(R.id.layout_root);
            FaceImageLayout faceImageLayout = (FaceImageLayout) view.findViewById(R.id.layout_content);
            this.f18864h = faceImageLayout;
            faceImageLayout.setListener(new a(this));
            this.j = view.findViewById(R.id.view_line);
            SearchEditView searchEditView = (SearchEditView) view.findViewById(R.id.edit_search_view);
            this.f18861e = searchEditView;
            searchEditView.setCallback(this);
            this.k = (AutoLineWrapLayout) view.findViewById(R.id.layout_hot_words);
            this.f18862f = (TextView) view.findViewById(R.id.tv_tips);
            SkinManager.setBackgroundResource(this.f18863g, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f18862f, R.color.CAM_X0109);
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

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!j.z()) {
                showToast(R.string.neterror);
            } else if (this.s) {
                getBaseFragmentActivity().showProgressBar();
                this.o.x(this.t, this.r + 1, 40, this.w);
            }
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.p = new GetHotWordsModel();
            this.q = new ArrayList();
            this.p.x(new b(this));
        }
    }

    public final void a1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
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

    public void b1(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.u = fVar;
            h hVar = this.m;
            if (hVar != null) {
                hVar.l(fVar);
            }
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            List<String> list = this.q;
            if (list != null && !list.isEmpty()) {
                this.k.setVisibility(0);
                this.f18862f.setVisibility(0);
            }
            this.l.setVisibility(8);
            NoDataView noDataView = this.f18865i;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f18865i == null) {
                NoDataView a2 = NoDataViewFactory.a(this.v, this.f18864h, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.v, R.dimen.ds320)), NoDataViewFactory.e.c(this.v.getText(R.string.face_group_no_emotion).toString()), null);
                this.f18865i = a2;
                a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.f18865i.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.f18862f.setVisibility(8);
        }
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l.setVisibility(0);
            this.f18862f.setVisibility(8);
            this.k.setVisibility(8);
            NoDataView noDataView = this.f18865i;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void onClickSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            a1(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            Activity pageActivity = getPageContext().getPageActivity();
            this.v = pageActivity;
            pageActivity.getWindow().setSoftInputMode(3);
            View inflate = layoutInflater.inflate(R.layout.fragment_pick_search, (ViewGroup) null);
            X0(inflate);
            this.o = new SearchEmotionModel();
            this.r = 1;
            Z0();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && str.length() == 0) {
            this.n.clear();
            h hVar = this.m;
            if (hVar != null) {
                hVar.notifyDataSetChanged();
            }
            c1();
        }
    }
}
