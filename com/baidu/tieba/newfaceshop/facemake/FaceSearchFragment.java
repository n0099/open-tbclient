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
import com.repackage.lo7;
import com.repackage.mi;
import com.repackage.no7;
import com.repackage.oi;
import com.repackage.v86;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class FaceSearchFragment extends BaseFragment implements SearchEditView.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SearchEditView a;
    public TextView b;
    public LinearLayout c;
    public FaceImageLayout d;
    public NoDataView e;
    public View f;
    public AutoLineWrapLayout g;
    public BdListView h;
    public no7 i;
    public List<EmotionImageData> j;
    public SearchEmotionModel k;
    public GetHotWordsModel l;
    public List<String> m;
    public int n;
    public boolean o;
    public String p;
    public lo7 q;
    public Activity r;
    public final SearchEmotionModel.b s;
    public final BdListView.p t;

    /* loaded from: classes3.dex */
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
                oi.w(this.a.r, this.a.a);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.g.setVisibility(8);
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
                this.a.g.setVisibility(8);
                this.a.b.setVisibility(8);
            }
            this.a.R0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ FaceSearchFragment b;

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
            this.b = faceSearchFragment;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.a.setText(this.a);
                this.b.a.setSelection(this.a.length());
                this.b.V0(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void a(String str, v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, v86Var) == null) {
                this.a.getBaseFragmentActivity().hideProgressBar();
                if (v86Var == null || v86Var.a() == null || v86Var.a().isEmpty()) {
                    if (this.a.n == 0) {
                        this.a.Y0();
                        return;
                    }
                    return;
                }
                this.a.n = v86Var.c();
                if (this.a.n == 1) {
                    this.a.j.clear();
                }
                this.a.o = v86Var.b() != 0;
                this.a.j.addAll(v86Var.a());
                this.a.i.notifyDataSetChanged();
                this.a.Z0();
                oi.w(this.a.getActivity(), this.a.a);
            }
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.getBaseFragmentActivity().hideProgressBar();
                if (this.a.n == 1) {
                    this.a.Y0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.T0();
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

    public LinkedHashMap<String, EmotionImageData> Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            no7 no7Var = this.i;
            if (no7Var != null) {
                return no7Var.i();
            }
            return null;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g.setVisibility(0);
            this.b.setVisibility(0);
            int min = Math.min(this.m.size(), 10);
            for (int i = 0; i < min; i++) {
                String str = this.m.get(i);
                if (!TextUtils.isEmpty(str)) {
                    String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                    TextView textView = new TextView(this.r);
                    SkinManager.setBackgroundColor(textView, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
                    int f = oi.f(this.r, R.dimen.obfuscated_res_0x7f0701be);
                    textView.setPadding(f, f, f, f);
                    textView.setText(str2);
                    textView.setTextSize(0, oi.f(this.r, R.dimen.obfuscated_res_0x7f0702b3));
                    textView.setSingleLine();
                    textView.setOnClickListener(new c(this, str));
                    this.g.addView(textView);
                }
            }
        }
    }

    public final void S0(View view2) {
        Serializable serializable;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0911eb);
            FaceImageLayout faceImageLayout = (FaceImageLayout) view2.findViewById(R.id.obfuscated_res_0x7f0911c8);
            this.d = faceImageLayout;
            faceImageLayout.setListener(new a(this));
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f0923a6);
            SearchEditView searchEditView = (SearchEditView) view2.findViewById(R.id.obfuscated_res_0x7f090869);
            this.a = searchEditView;
            searchEditView.setCallback(this);
            this.g = (AutoLineWrapLayout) view2.findViewById(R.id.obfuscated_res_0x7f0911d5);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092201);
            SkinManager.setBackgroundResource(this.c, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0109);
            BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f09127d);
            this.h = bdListView;
            bdListView.setOnSrollToBottomListener(this.t);
            this.j = new ArrayList();
            no7 no7Var = new no7(this.j, 10);
            this.i = no7Var;
            no7Var.l(this.q);
            this.h.setAdapter((ListAdapter) this.i);
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

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!mi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c17);
            } else if (this.o) {
                getBaseFragmentActivity().showProgressBar();
                this.k.z(this.p, this.n + 1, 40, this.s);
            }
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l = new GetHotWordsModel();
            this.m = new ArrayList();
            this.l.z(new b(this));
        }
    }

    public final void V0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!mi.z()) {
            showToast(R.string.obfuscated_res_0x7f0f0c17);
            return;
        }
        getBaseFragmentActivity().showProgressBar();
        this.n = 0;
        this.p = str;
        this.k.z(str, 0 + 1, 40, this.s);
    }

    public void W0(lo7 lo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lo7Var) == null) {
            this.q = lo7Var;
            no7 no7Var = this.i;
            if (no7Var != null) {
                no7Var.l(lo7Var);
            }
        }
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            List<String> list = this.m;
            if (list != null && !list.isEmpty()) {
                this.g.setVisibility(0);
                this.b.setVisibility(0);
            }
            this.h.setVisibility(8);
            NoDataView noDataView = this.e;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.e == null) {
                NoDataView a2 = NoDataViewFactory.a(this.r, this.d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, oi.f(this.r, R.dimen.obfuscated_res_0x7f0702a1)), NoDataViewFactory.e.c(this.r.getText(R.string.obfuscated_res_0x7f0f05db).toString()), null);
                this.e = a2;
                a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.e.setVisibility(0);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.b.setVisibility(8);
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.h.setVisibility(0);
            this.b.setVisibility(8);
            this.g.setVisibility(8);
            NoDataView noDataView = this.e;
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
            V0(str);
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
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02ee, (ViewGroup) null);
            S0(inflate);
            this.k = new SearchEmotionModel();
            this.n = 1;
            U0();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            no7 no7Var = this.i;
            if (no7Var != null) {
                no7Var.k();
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
            no7 no7Var = this.i;
            if (no7Var != null) {
                no7Var.notifyDataSetChanged();
            }
            X0();
        }
    }
}
