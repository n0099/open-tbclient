package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.faceshop.CollectEmotionData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class FaceCollectFragment extends BaseFragment {
    private f lsv;
    private BdListView lsx;
    private h lsy;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private NoDataView mNoDataView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Serializable serializable;
        this.mActivity = getPageContext().getPageActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_collect, (ViewGroup) null);
        ao.setBackgroundResource(inflate, R.color.CAM_X0201);
        this.mNoDataView = NoDataViewFactory.a(this.mActivity, inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.Bk(this.mActivity.getText(R.string.face_group_no_emotion).toString()), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(8);
        this.lsx = (BdListView) inflate.findViewById(R.id.listview_emotion);
        this.mEmotionList = new ArrayList();
        this.lsy = new h(this.mEmotionList, 20);
        this.lsy.b(this.lsv);
        if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 1 && faceData.emotionImageData != null) {
                    linkedHashMap.put(faceData.emotionImageData.getPicUrl(), faceData.emotionImageData);
                }
            }
            this.lsy.G(linkedHashMap);
        }
        this.lsx.setAdapter((ListAdapter) this.lsy);
        bEv();
        return inflate;
    }

    public void a(f fVar) {
        this.lsv = fVar;
        if (this.lsy != null) {
            this.lsy.b(this.lsv);
        }
    }

    private void bEv() {
        new BdAsyncTask<Void, Void, List<EmotionImageData>>() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceCollectFragment.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: c */
            public List<EmotionImageData> doInBackground(Void... voidArr) {
                List<CollectEmotionData> IU = com.baidu.tieba.faceshop.i.cxt().IU(TbadkCoreApplication.getCurrentAccount());
                if (IU == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (CollectEmotionData collectEmotionData : IU) {
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
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: B */
            public void onPostExecute(List<EmotionImageData> list) {
                if (list == null || list.isEmpty()) {
                    FaceCollectFragment.this.lsx.setVisibility(8);
                    FaceCollectFragment.this.mNoDataView.setVisibility(0);
                    return;
                }
                FaceCollectFragment.this.mEmotionList.clear();
                FaceCollectFragment.this.mEmotionList.addAll(list);
                FaceCollectFragment.this.lsy.notifyDataSetChanged();
            }
        }.execute(new Void[0]);
    }

    public LinkedHashMap<String, EmotionImageData> dgu() {
        if (this.lsy != null) {
            return this.lsy.dgu();
        }
        return null;
    }
}
