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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.util.ap;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class FaceSearchFragment extends BaseFragment implements SearchEditView.a {
    private int bcY;
    private f lCQ;
    private BdListView lCS;
    private LinearLayout lCY;
    private SearchEditView lDX;
    private TextView lDY;
    private FaceImageLayout lDZ;
    private AutoLineWrapLayout lEa;
    private h lEb;
    private SearchEmotionModel lEc;
    private GetHotWordsModel lEd;
    private List<String> lEe;
    private String lEf;
    private View lto;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a iUq = new SearchEmotionModel.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.4
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (aVar == null || aVar.cyt() == null || aVar.cyt().isEmpty()) {
                if (FaceSearchFragment.this.bcY == 0) {
                    FaceSearchFragment.this.djb();
                    return;
                }
                return;
            }
            FaceSearchFragment.this.bcY = aVar.getPage();
            if (FaceSearchFragment.this.bcY == 1) {
                FaceSearchFragment.this.mEmotionList.clear();
            }
            FaceSearchFragment.this.mHasMore = aVar.cys() != 0;
            FaceSearchFragment.this.mEmotionList.addAll(aVar.cyt());
            FaceSearchFragment.this.lEb.notifyDataSetChanged();
            FaceSearchFragment.this.diY();
            l.hideSoftKeyPad(FaceSearchFragment.this.getActivity(), FaceSearchFragment.this.lDX);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (FaceSearchFragment.this.bcY == 1) {
                FaceSearchFragment.this.djb();
            }
        }
    };
    private final BdListView.e Yb = new BdListView.e() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            FaceSearchFragment.this.dja();
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActivity = getPageContext().getPageActivity();
        this.mActivity.getWindow().setSoftInputMode(3);
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_search, (ViewGroup) null);
        am(inflate);
        this.lEc = new SearchEmotionModel();
        this.bcY = 1;
        bER();
        return inflate;
    }

    private void am(View view) {
        Serializable serializable;
        this.lCY = (LinearLayout) view.findViewById(R.id.layout_root);
        this.lDZ = (FaceImageLayout) view.findViewById(R.id.layout_content);
        this.lDZ.setListener(new FaceImageLayout.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.1
            @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
            public void diS() {
                l.hideSoftKeyPad(FaceSearchFragment.this.mActivity, FaceSearchFragment.this.lDX);
            }
        });
        this.lto = view.findViewById(R.id.view_line);
        this.lDX = (SearchEditView) view.findViewById(R.id.edit_search_view);
        this.lDX.setCallback(this);
        this.lEa = (AutoLineWrapLayout) view.findViewById(R.id.layout_hot_words);
        this.lDY = (TextView) view.findViewById(R.id.tv_tips);
        ap.setBackgroundResource(this.lCY, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lto, R.color.CAM_X0204);
        ap.setViewTextColor(this.lDY, R.color.CAM_X0109);
        this.lCS = (BdListView) view.findViewById(R.id.listview_emotion);
        this.lCS.setOnSrollToBottomListener(this.Yb);
        this.mEmotionList = new ArrayList();
        this.lEb = new h(this.mEmotionList, 10);
        this.lEb.b(this.lCQ);
        this.lCS.setAdapter((ListAdapter) this.lEb);
        if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 2 && faceData.emotionImageData != null) {
                    linkedHashMap.put(faceData.emotionImageData.getPicUrl(), faceData.emotionImageData);
                }
            }
            this.lEb.I(linkedHashMap);
        }
    }

    private void bER() {
        this.lEd = new GetHotWordsModel();
        this.lEe = new ArrayList();
        this.lEd.a(new GetHotWordsModel.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.2
            @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.a
            public void aj(List<String> list) {
                if (list != null) {
                    FaceSearchFragment.this.lEe.addAll(list);
                    if (FaceSearchFragment.this.lEe == null || FaceSearchFragment.this.lEe.isEmpty()) {
                        FaceSearchFragment.this.lEa.setVisibility(8);
                        FaceSearchFragment.this.lDY.setVisibility(8);
                    }
                    FaceSearchFragment.this.diX();
                }
            }

            @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.a
            public void onFail(int i, String str) {
                FaceSearchFragment.this.lEa.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diX() {
        this.lEa.setVisibility(0);
        this.lDY.setVisibility(0);
        int min = Math.min(this.lEe.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.lEe.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                TextView textView = new TextView(this.mActivity);
                ap.setBackgroundColor(textView, R.color.CAM_X0205);
                ap.setViewTextColor(textView, R.color.CAM_X0106);
                int dimens = l.getDimens(this.mActivity, R.dimen.ds16);
                textView.setPadding(dimens, dimens, dimens, dimens);
                textView.setText(str2);
                textView.setTextSize(0, l.getDimens(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FaceSearchFragment.this.lDX.setText(str);
                        FaceSearchFragment.this.lDX.setSelection(str.length());
                        FaceSearchFragment.this.OZ(str);
                    }
                });
                this.lEa.addView(textView);
            }
        }
    }

    public void a(f fVar) {
        this.lCQ = fVar;
        if (this.lEb != null) {
            this.lEb.b(this.lCQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diY() {
        this.lCS.setVisibility(0);
        this.lDY.setVisibility(8);
        this.lEa.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void diZ() {
        if (this.lEe != null && !this.lEe.isEmpty()) {
            this.lEa.setVisibility(0);
            this.lDY.setVisibility(0);
        }
        this.lCS.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dja() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            getBaseFragmentActivity().showProgressBar();
            this.lEc.a(this.lEf, this.bcY + 1, 40, this.iUq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djb() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lDZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.BI(this.mActivity.getText(R.string.face_group_no_emotion).toString()), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.lEa.setVisibility(8);
        this.lCS.setVisibility(8);
        this.lDY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            getBaseFragmentActivity().showProgressBar();
            this.bcY = 0;
            this.lEf = str;
            this.lEc.a(str, this.bcY + 1, 40, this.iUq);
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JD(String str) {
        OZ(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JE(String str) {
        if (str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lEb != null) {
                this.lEb.notifyDataSetChanged();
            }
            diZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lEb != null) {
            this.lEb.djd();
        }
        this.lEc.cancelLoadData();
        this.lEd.cancelLoadData();
    }

    public LinkedHashMap<String, EmotionImageData> diL() {
        if (this.lEb != null) {
            return this.lEb.diL();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }
}
