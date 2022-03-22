package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import c.a.d.f.p.n;
import c.a.p0.a1.g;
import c.a.p0.r2.g.f;
import c.a.p0.r2.g.h;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
public class FaceCollectFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public h f34670b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionImageData> f34671c;

    /* renamed from: d  reason: collision with root package name */
    public f f34672d;

    /* renamed from: e  reason: collision with root package name */
    public NoDataView f34673e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f34674f;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Void, List<EmotionImageData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceCollectFragment a;

        public a(FaceCollectFragment faceCollectFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceCollectFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceCollectFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<EmotionImageData> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List<CollectEmotionData> n = g.k().n(TbadkCoreApplication.getCurrentAccount());
                if (n == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (CollectEmotionData collectEmotionData : n) {
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid)) {
                        EmotionImageData emotionImageData = new EmotionImageData();
                        emotionImageData.setPicId(collectEmotionData.pid);
                        emotionImageData.setWidth(collectEmotionData.width);
                        emotionImageData.setHeight(collectEmotionData.height);
                        emotionImageData.setPicUrl(collectEmotionData.sharpText);
                        emotionImageData.setThumbUrl(collectEmotionData.sharpText);
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
                if (list == null || list.isEmpty()) {
                    this.a.a.setVisibility(8);
                    this.a.f34673e.setVisibility(0);
                    return;
                }
                this.a.f34671c.clear();
                this.a.f34671c.addAll(list);
                this.a.f34670b.notifyDataSetChanged();
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

    public LinkedHashMap<String, EmotionImageData> G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            h hVar = this.f34670b;
            if (hVar != null) {
                return hVar.i();
            }
            return null;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            new a(this).execute(new Void[0]);
        }
    }

    public void I0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f34672d = fVar;
            h hVar = this.f34670b;
            if (hVar != null) {
                hVar.l(fVar);
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
            this.f34674f = getPageContext().getPageActivity();
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02ec, (ViewGroup) null);
            SkinManager.setBackgroundResource(inflate, R.color.CAM_X0201);
            NoDataView a2 = NoDataViewFactory.a(this.f34674f, inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this.f34674f, R.dimen.obfuscated_res_0x7f070297)), NoDataViewFactory.e.c(this.f34674f.getText(R.string.obfuscated_res_0x7f0f05d4).toString()), null);
            this.f34673e = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f34673e.setVisibility(8);
            this.a = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f091288);
            this.f34671c = new ArrayList();
            h hVar = new h(this.f34671c, 20);
            this.f34670b = hVar;
            hVar.l(this.f34672d);
            if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it = ((ArrayList) serializable).iterator();
                while (it.hasNext()) {
                    FaceData faceData = (FaceData) it.next();
                    if (faceData != null && faceData.type == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                        linkedHashMap.put(emotionImageData.getPicUrl(), faceData.emotionImageData);
                    }
                }
                this.f34670b.g(linkedHashMap);
            }
            this.a.setAdapter((ListAdapter) this.f34670b);
            H0();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
