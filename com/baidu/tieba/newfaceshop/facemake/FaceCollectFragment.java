package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.n99;
import com.baidu.tieba.p99;
import com.baidu.tieba.z17;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class FaceCollectFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public p99 b;
    public List<EmotionImageData> c;
    public n99 d;
    public NoDataView e;
    public Activity f;
    public a g;

    /* loaded from: classes7.dex */
    public static class a extends BdAsyncTask<Void, Void, List<EmotionImageData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<BdListView> a;
        public WeakReference<p99> b;
        public WeakReference<List<EmotionImageData>> c;
        public WeakReference<NoDataView> d;

        public a(BdListView bdListView, p99 p99Var, List<EmotionImageData> list, NoDataView noDataView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdListView, p99Var, list, noDataView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(bdListView);
            this.b = new WeakReference<>(p99Var);
            this.c = new WeakReference<>(list);
            this.d = new WeakReference<>(noDataView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<EmotionImageData> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List<CollectEmotionData> q = z17.o().q(TbadkCoreApplication.getCurrentAccount());
                if (q == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (CollectEmotionData collectEmotionData : q) {
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid)) {
                        EmotionImageData emotionImageData = new EmotionImageData();
                        emotionImageData.setPicId(collectEmotionData.pid);
                        emotionImageData.setWidth(collectEmotionData.width);
                        emotionImageData.setHeight(collectEmotionData.height);
                        emotionImageData.setPicUrl(collectEmotionData.getSharpText());
                        emotionImageData.setThumbUrl(collectEmotionData.getSharpText());
                        arrayList.add(emotionImageData);
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<EmotionImageData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && !list.isEmpty()) {
                    this.a.clear();
                    List<EmotionImageData> list2 = this.c.get();
                    if (list2 != null) {
                        list2.addAll(list);
                    }
                    p99 p99Var = this.b.get();
                    if (p99Var != null) {
                        p99Var.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                BdListView bdListView = this.a.get();
                if (bdListView != null) {
                    bdListView.setVisibility(8);
                }
                NoDataView noDataView = this.d.get();
                if (noDataView != null) {
                    noDataView.setVisibility(0);
                }
            }
        }
    }

    public FaceCollectFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public LinkedHashMap<String, EmotionImageData> I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            p99 p99Var = this.b;
            if (p99Var != null) {
                return p99Var.i();
            }
            return null;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g.execute(new Void[0]);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.g.cancel();
        }
    }

    public void K1(n99 n99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n99Var) == null) {
            this.d = n99Var;
            p99 p99Var = this.b;
            if (p99Var != null) {
                p99Var.l(n99Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Serializable serializable;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f = getPageContext().getPageActivity();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0330, (ViewGroup) null);
            SkinManager.setBackgroundResource(inflate, R.color.CAM_X0201);
            NoDataView a2 = NoDataViewFactory.a(this.f, inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(this.f, R.dimen.obfuscated_res_0x7f0703bc)), NoDataViewFactory.e.c(this.f.getText(R.string.obfuscated_res_0x7f0f06fb).toString()), null);
            this.e = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.e.setVisibility(8);
            this.a = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f09154b);
            this.c = new ArrayList();
            p99 p99Var = new p99(this.c, 20);
            this.b = p99Var;
            p99Var.l(this.d);
            if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it = ((ArrayList) serializable).iterator();
                while (it.hasNext()) {
                    FaceData faceData = (FaceData) it.next();
                    if (faceData != null && faceData.type == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                        linkedHashMap.put(emotionImageData.getPicUrl(), faceData.emotionImageData);
                    }
                }
                this.b.g(linkedHashMap);
            }
            this.a.setAdapter((ListAdapter) this.b);
            this.g = new a(this.a, this.b, this.c, this.e);
            J1();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
