package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
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
import d.a.c.e.p.l;
import d.a.o0.m0.g;
import d.a.o0.z1.g.f;
import d.a.o0.z1.g.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class FaceCollectFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public BdListView f18714e;

    /* renamed from: f  reason: collision with root package name */
    public h f18715f;

    /* renamed from: g  reason: collision with root package name */
    public List<EmotionImageData> f18716g;

    /* renamed from: h  reason: collision with root package name */
    public f f18717h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f18718i;
    public Activity j;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Void, List<EmotionImageData>> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<EmotionImageData> doInBackground(Void... voidArr) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<EmotionImageData> list) {
            if (list == null || list.isEmpty()) {
                FaceCollectFragment.this.f18714e.setVisibility(8);
                FaceCollectFragment.this.f18718i.setVisibility(0);
                return;
            }
            FaceCollectFragment.this.f18716g.clear();
            FaceCollectFragment.this.f18716g.addAll(list);
            FaceCollectFragment.this.f18715f.notifyDataSetChanged();
        }
    }

    public LinkedHashMap<String, EmotionImageData> K0() {
        h hVar = this.f18715f;
        if (hVar != null) {
            return hVar.i();
        }
        return null;
    }

    public final void L0() {
        new a().execute(new Void[0]);
    }

    public void M0(f fVar) {
        this.f18717h = fVar;
        h hVar = this.f18715f;
        if (hVar != null) {
            hVar.l(fVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Serializable serializable;
        EmotionImageData emotionImageData;
        this.j = getPageContext().getPageActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_collect, (ViewGroup) null);
        SkinManager.setBackgroundResource(inflate, R.color.CAM_X0201);
        NoDataView a2 = NoDataViewFactory.a(this.j, inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.j, R.dimen.ds320)), NoDataViewFactory.e.c(this.j.getText(R.string.face_group_no_emotion).toString()), null);
        this.f18718i = a2;
        a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.f18718i.setVisibility(8);
        this.f18714e = (BdListView) inflate.findViewById(R.id.listview_emotion);
        this.f18716g = new ArrayList();
        h hVar = new h(this.f18716g, 20);
        this.f18715f = hVar;
        hVar.l(this.f18717h);
        if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                    linkedHashMap.put(emotionImageData.getPicUrl(), faceData.emotionImageData);
                }
            }
            this.f18715f.g(linkedHashMap);
        }
        this.f18714e.setAdapter((ListAdapter) this.f18715f);
        L0();
        return inflate;
    }
}
