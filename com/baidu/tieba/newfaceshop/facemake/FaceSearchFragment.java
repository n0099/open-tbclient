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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.aq8;
import com.baidu.tieba.cq8;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import com.baidu.tieba.ft6;
import com.baidu.tieba.ii;
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
    public TextView b;
    public LinearLayout c;
    public FaceImageLayout d;
    public NoDataView e;
    public View f;
    public AutoLineWrapLayout g;
    public BdListView h;
    public cq8 i;
    public List<EmotionImageData> j;
    public SearchEmotionModel k;
    public GetHotWordsModel l;
    public List<String> m;
    public int n;
    public boolean o;
    public String p;
    public aq8 q;
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
        public void onIntercept() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ii.z(this.a.r, this.a.a);
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
                this.a.g.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && list != null) {
                this.a.m.addAll(list);
                if (this.a.m == null || this.a.m.isEmpty()) {
                    this.a.g.setVisibility(8);
                    this.a.b.setVisibility(8);
                }
                this.a.U1();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.b.Y1(this.a);
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
        public void a(String str, ft6 ft6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, ft6Var) == null) {
                this.a.getBaseFragmentActivity().hideProgressBar();
                if (ft6Var != null && ft6Var.a() != null && !ft6Var.a().isEmpty()) {
                    this.a.n = ft6Var.c();
                    boolean z = true;
                    if (this.a.n == 1) {
                        this.a.j.clear();
                    }
                    FaceSearchFragment faceSearchFragment = this.a;
                    if (ft6Var.b() == 0) {
                        z = false;
                    }
                    faceSearchFragment.o = z;
                    this.a.j.addAll(ft6Var.a());
                    this.a.i.notifyDataSetChanged();
                    this.a.c2();
                    ii.z(this.a.getActivity(), this.a.a);
                } else if (this.a.n == 0) {
                    this.a.b2();
                }
            }
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.getBaseFragmentActivity().hideProgressBar();
                if (this.a.n == 1) {
                    this.a.b2();
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
                this.a.W1();
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

    public LinkedHashMap<String, EmotionImageData> T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cq8 cq8Var = this.i;
            if (cq8Var != null) {
                return cq8Var.i();
            }
            return null;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l = new GetHotWordsModel();
            this.m = new ArrayList();
            this.l.R(new b(this));
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.h.setVisibility(0);
            this.b.setVisibility(8);
            this.g.setVisibility(8);
            NoDataView noDataView = this.e;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            cq8 cq8Var = this.i;
            if (cq8Var != null) {
                cq8Var.k();
            }
            this.k.cancelLoadData();
            this.l.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void C1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Y1(str);
        }
    }

    public void Z1(aq8 aq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aq8Var) == null) {
            this.q = aq8Var;
            cq8 cq8Var = this.i;
            if (cq8Var != null) {
                cq8Var.l(aq8Var);
            }
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void a0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && str.length() == 0) {
            this.j.clear();
            cq8 cq8Var = this.i;
            if (cq8Var != null) {
                cq8Var.notifyDataSetChanged();
            }
            a2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
        }
    }

    public final void U1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.setVisibility(0);
            this.b.setVisibility(0);
            int min = Math.min(this.m.size(), 10);
            for (int i = 0; i < min; i++) {
                String str2 = this.m.get(i);
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.length() > 20) {
                        str = str2.substring(0, 20) + StringHelper.STRING_MORE;
                    } else {
                        str = str2;
                    }
                    TextView textView = new TextView(this.r);
                    SkinManager.setBackgroundColor(textView, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
                    int g = ii.g(this.r, R.dimen.obfuscated_res_0x7f0701be);
                    textView.setPadding(g, g, g, g);
                    textView.setText(str);
                    textView.setTextSize(0, ii.g(this.r, R.dimen.obfuscated_res_0x7f0702b3));
                    textView.setSingleLine();
                    textView.setOnClickListener(new c(this, str2));
                    this.g.addView(textView);
                }
            }
        }
    }

    public final void V1(View view2) {
        Serializable serializable;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            this.c = (LinearLayout) view2.findViewById(R.id.layout_root);
            FaceImageLayout faceImageLayout = (FaceImageLayout) view2.findViewById(R.id.layout_content);
            this.d = faceImageLayout;
            faceImageLayout.setListener(new a(this));
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f0927c2);
            SearchEditView searchEditView = (SearchEditView) view2.findViewById(R.id.obfuscated_res_0x7f09093f);
            this.a = searchEditView;
            searchEditView.setCallback(this);
            this.g = (AutoLineWrapLayout) view2.findViewById(R.id.obfuscated_res_0x7f0913fd);
            this.b = (TextView) view2.findViewById(R.id.tv_tips);
            SkinManager.setBackgroundResource(this.c, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0109);
            BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f0914a8);
            this.h = bdListView;
            bdListView.setOnSrollToBottomListener(this.t);
            this.j = new ArrayList();
            cq8 cq8Var = new cq8(this.j, 10);
            this.i = cq8Var;
            cq8Var.l(this.q);
            this.h.setAdapter((ListAdapter) this.i);
            if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
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
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0d1b);
            } else if (this.o) {
                getBaseFragmentActivity().showProgressBar();
                this.k.R(this.p, this.n + 1, 40, this.s);
            }
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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

    public final void Y1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            showToast(R.string.obfuscated_res_0x7f0f0d1b);
            return;
        }
        getBaseFragmentActivity().showProgressBar();
        this.n = 0;
        this.p = str;
        this.k.R(str, 0 + 1, 40, this.s);
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.e == null) {
                NoDataView a2 = NoDataViewFactory.a(this.r, this.d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, ii.g(this.r, R.dimen.obfuscated_res_0x7f07029f)), NoDataViewFactory.e.c(this.r.getText(R.string.obfuscated_res_0x7f0f0644).toString()), null);
                this.e = a2;
                a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.e.setVisibility(0);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.b.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            Activity pageActivity = getPageContext().getPageActivity();
            this.r = pageActivity;
            pageActivity.getWindow().setSoftInputMode(3);
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0302, (ViewGroup) null);
            V1(inflate);
            this.k = new SearchEmotionModel();
            this.n = 1;
            X1();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
