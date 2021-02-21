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
/* loaded from: classes9.dex */
public class FaceSearchFragment extends BaseFragment implements SearchEditView.a {
    private int bby;
    private f lAO;
    private BdListView lAQ;
    private LinearLayout lAW;
    private SearchEditView lBV;
    private TextView lBW;
    private FaceImageLayout lBX;
    private AutoLineWrapLayout lBY;
    private h lBZ;
    private SearchEmotionModel lCa;
    private GetHotWordsModel lCb;
    private List<String> lCc;
    private String lCd;
    private View lrm;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a iSH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.4
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (aVar == null || aVar.cyn() == null || aVar.cyn().isEmpty()) {
                if (FaceSearchFragment.this.bby == 0) {
                    FaceSearchFragment.this.diS();
                    return;
                }
                return;
            }
            FaceSearchFragment.this.bby = aVar.getPage();
            if (FaceSearchFragment.this.bby == 1) {
                FaceSearchFragment.this.mEmotionList.clear();
            }
            FaceSearchFragment.this.mHasMore = aVar.cym() != 0;
            FaceSearchFragment.this.mEmotionList.addAll(aVar.cyn());
            FaceSearchFragment.this.lBZ.notifyDataSetChanged();
            FaceSearchFragment.this.diP();
            l.hideSoftKeyPad(FaceSearchFragment.this.getActivity(), FaceSearchFragment.this.lBV);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (FaceSearchFragment.this.bby == 1) {
                FaceSearchFragment.this.diS();
            }
        }
    };
    private final BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            FaceSearchFragment.this.diR();
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActivity = getPageContext().getPageActivity();
        this.mActivity.getWindow().setSoftInputMode(3);
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_search, (ViewGroup) null);
        am(inflate);
        this.lCa = new SearchEmotionModel();
        this.bby = 1;
        bEN();
        return inflate;
    }

    private void am(View view) {
        Serializable serializable;
        this.lAW = (LinearLayout) view.findViewById(R.id.layout_root);
        this.lBX = (FaceImageLayout) view.findViewById(R.id.layout_content);
        this.lBX.setListener(new FaceImageLayout.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.1
            @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
            public void diJ() {
                l.hideSoftKeyPad(FaceSearchFragment.this.mActivity, FaceSearchFragment.this.lBV);
            }
        });
        this.lrm = view.findViewById(R.id.view_line);
        this.lBV = (SearchEditView) view.findViewById(R.id.edit_search_view);
        this.lBV.setCallback(this);
        this.lBY = (AutoLineWrapLayout) view.findViewById(R.id.layout_hot_words);
        this.lBW = (TextView) view.findViewById(R.id.tv_tips);
        ap.setBackgroundResource(this.lAW, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lrm, R.color.CAM_X0204);
        ap.setViewTextColor(this.lBW, R.color.CAM_X0109);
        this.lAQ = (BdListView) view.findViewById(R.id.listview_emotion);
        this.lAQ.setOnSrollToBottomListener(this.WH);
        this.mEmotionList = new ArrayList();
        this.lBZ = new h(this.mEmotionList, 10);
        this.lBZ.b(this.lAO);
        this.lAQ.setAdapter((ListAdapter) this.lBZ);
        if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 2 && faceData.emotionImageData != null) {
                    linkedHashMap.put(faceData.emotionImageData.getPicUrl(), faceData.emotionImageData);
                }
            }
            this.lBZ.I(linkedHashMap);
        }
    }

    private void bEN() {
        this.lCb = new GetHotWordsModel();
        this.lCc = new ArrayList();
        this.lCb.a(new GetHotWordsModel.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.2
            @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.a
            public void aj(List<String> list) {
                if (list != null) {
                    FaceSearchFragment.this.lCc.addAll(list);
                    if (FaceSearchFragment.this.lCc == null || FaceSearchFragment.this.lCc.isEmpty()) {
                        FaceSearchFragment.this.lBY.setVisibility(8);
                        FaceSearchFragment.this.lBW.setVisibility(8);
                    }
                    FaceSearchFragment.this.diO();
                }
            }

            @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.a
            public void onFail(int i, String str) {
                FaceSearchFragment.this.lBY.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diO() {
        this.lBY.setVisibility(0);
        this.lBW.setVisibility(0);
        int min = Math.min(this.lCc.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.lCc.get(i);
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
                        FaceSearchFragment.this.lBV.setText(str);
                        FaceSearchFragment.this.lBV.setSelection(str.length());
                        FaceSearchFragment.this.OT(str);
                    }
                });
                this.lBY.addView(textView);
            }
        }
    }

    public void a(f fVar) {
        this.lAO = fVar;
        if (this.lBZ != null) {
            this.lBZ.b(this.lAO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diP() {
        this.lAQ.setVisibility(0);
        this.lBW.setVisibility(8);
        this.lBY.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void diQ() {
        if (this.lCc != null && !this.lCc.isEmpty()) {
            this.lBY.setVisibility(0);
            this.lBW.setVisibility(0);
        }
        this.lAQ.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diR() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            getBaseFragmentActivity().showProgressBar();
            this.lCa.a(this.lCd, this.bby + 1, 40, this.iSH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diS() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lBX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.BB(this.mActivity.getText(R.string.face_group_no_emotion).toString()), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.lBY.setVisibility(8);
        this.lAQ.setVisibility(8);
        this.lBW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OT(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            getBaseFragmentActivity().showProgressBar();
            this.bby = 0;
            this.lCd = str;
            this.lCa.a(str, this.bby + 1, 40, this.iSH);
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Ju(String str) {
        OT(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Jv(String str) {
        if (str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lBZ != null) {
                this.lBZ.notifyDataSetChanged();
            }
            diQ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lBZ != null) {
            this.lBZ.diU();
        }
        this.lCa.cancelLoadData();
        this.lCb.cancelLoadData();
    }

    public LinkedHashMap<String, EmotionImageData> diC() {
        if (this.lBZ != null) {
            return this.lBZ.diC();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }
}
