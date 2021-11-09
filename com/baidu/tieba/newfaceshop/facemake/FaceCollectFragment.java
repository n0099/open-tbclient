package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import b.a.e.e.p.l;
import b.a.r0.f2.g.f;
import b.a.r0.f2.g.h;
import b.a.r0.s0.g;
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
/* loaded from: classes9.dex */
public class FaceCollectFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f51842e;

    /* renamed from: f  reason: collision with root package name */
    public h f51843f;

    /* renamed from: g  reason: collision with root package name */
    public List<EmotionImageData> f51844g;

    /* renamed from: h  reason: collision with root package name */
    public f f51845h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f51846i;
    public Activity j;

    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<Void, Void, List<EmotionImageData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FaceCollectFragment f51847a;

        public a(FaceCollectFragment faceCollectFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceCollectFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51847a = faceCollectFragment;
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
                    this.f51847a.f51842e.setVisibility(8);
                    this.f51847a.f51846i.setVisibility(0);
                    return;
                }
                this.f51847a.f51844g.clear();
                this.f51847a.f51844g.addAll(list);
                this.f51847a.f51843f.notifyDataSetChanged();
            }
        }
    }

    public FaceCollectFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new a(this).execute(new Void[0]);
        }
    }

    public LinkedHashMap<String, EmotionImageData> getChoosedMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h hVar = this.f51843f;
            if (hVar != null) {
                return hVar.i();
            }
            return null;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Serializable serializable;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            this.j = getPageContext().getPageActivity();
            View inflate = layoutInflater.inflate(R.layout.fragment_pick_collect, (ViewGroup) null);
            SkinManager.setBackgroundResource(inflate, R.color.CAM_X0201);
            NoDataView a2 = NoDataViewFactory.a(this.j, inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.j, R.dimen.ds320)), NoDataViewFactory.e.c(this.j.getText(R.string.face_group_no_emotion).toString()), null);
            this.f51846i = a2;
            a2.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f51846i.setVisibility(8);
            this.f51842e = (BdListView) inflate.findViewById(R.id.listview_emotion);
            this.f51844g = new ArrayList();
            h hVar = new h(this.f51844g, 20);
            this.f51843f = hVar;
            hVar.l(this.f51845h);
            if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it = ((ArrayList) serializable).iterator();
                while (it.hasNext()) {
                    FaceData faceData = (FaceData) it.next();
                    if (faceData != null && faceData.type == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                        linkedHashMap.put(emotionImageData.getPicUrl(), faceData.emotionImageData);
                    }
                }
                this.f51843f.g(linkedHashMap);
            }
            this.f51842e.setAdapter((ListAdapter) this.f51843f);
            g();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public void setEmotionChooseCallback(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f51845h = fVar;
            h hVar = this.f51843f;
            if (hVar != null) {
                hVar.l(fVar);
            }
        }
    }
}
