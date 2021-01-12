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
import com.baidu.tbadk.core.util.ao;
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
    private int aYr;
    private View liR;
    private LinearLayout lsD;
    private f lsv;
    private BdListView lsx;
    private SearchEditView ltD;
    private TextView ltE;
    private FaceImageLayout ltF;
    private AutoLineWrapLayout ltG;
    private h ltH;
    private SearchEmotionModel ltI;
    private GetHotWordsModel ltJ;
    private List<String> ltK;
    private String ltL;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a iMM = new SearchEmotionModel.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.4
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (aVar == null || aVar.cwV() == null || aVar.cwV().isEmpty()) {
                if (FaceSearchFragment.this.aYr == 0) {
                    FaceSearchFragment.this.dgK();
                    return;
                }
                return;
            }
            FaceSearchFragment.this.aYr = aVar.getPage();
            if (FaceSearchFragment.this.aYr == 1) {
                FaceSearchFragment.this.mEmotionList.clear();
            }
            FaceSearchFragment.this.mHasMore = aVar.cwU() != 0;
            FaceSearchFragment.this.mEmotionList.addAll(aVar.cwV());
            FaceSearchFragment.this.ltH.notifyDataSetChanged();
            FaceSearchFragment.this.dgH();
            l.hideSoftKeyPad(FaceSearchFragment.this.getActivity(), FaceSearchFragment.this.ltD);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (FaceSearchFragment.this.aYr == 1) {
                FaceSearchFragment.this.dgK();
            }
        }
    };
    private final BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            FaceSearchFragment.this.dgJ();
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActivity = getPageContext().getPageActivity();
        this.mActivity.getWindow().setSoftInputMode(3);
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_search, (ViewGroup) null);
        ap(inflate);
        this.ltI = new SearchEmotionModel();
        this.aYr = 1;
        bEv();
        return inflate;
    }

    private void ap(View view) {
        Serializable serializable;
        this.lsD = (LinearLayout) view.findViewById(R.id.layout_root);
        this.ltF = (FaceImageLayout) view.findViewById(R.id.layout_content);
        this.ltF.setListener(new FaceImageLayout.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.1
            @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
            public void dgB() {
                l.hideSoftKeyPad(FaceSearchFragment.this.mActivity, FaceSearchFragment.this.ltD);
            }
        });
        this.liR = view.findViewById(R.id.view_line);
        this.ltD = (SearchEditView) view.findViewById(R.id.edit_search_view);
        this.ltD.setCallback(this);
        this.ltG = (AutoLineWrapLayout) view.findViewById(R.id.layout_hot_words);
        this.ltE = (TextView) view.findViewById(R.id.tv_tips);
        ao.setBackgroundResource(this.lsD, R.color.CAM_X0201);
        ao.setBackgroundColor(this.liR, R.color.CAM_X0204);
        ao.setViewTextColor(this.ltE, R.color.CAM_X0109);
        this.lsx = (BdListView) view.findViewById(R.id.listview_emotion);
        this.lsx.setOnSrollToBottomListener(this.WL);
        this.mEmotionList = new ArrayList();
        this.ltH = new h(this.mEmotionList, 10);
        this.ltH.b(this.lsv);
        this.lsx.setAdapter((ListAdapter) this.ltH);
        if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 2 && faceData.emotionImageData != null) {
                    linkedHashMap.put(faceData.emotionImageData.getPicUrl(), faceData.emotionImageData);
                }
            }
            this.ltH.G(linkedHashMap);
        }
    }

    private void bEv() {
        this.ltJ = new GetHotWordsModel();
        this.ltK = new ArrayList();
        this.ltJ.a(new GetHotWordsModel.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.2
            @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.a
            public void ai(List<String> list) {
                if (list != null) {
                    FaceSearchFragment.this.ltK.addAll(list);
                    if (FaceSearchFragment.this.ltK == null || FaceSearchFragment.this.ltK.isEmpty()) {
                        FaceSearchFragment.this.ltG.setVisibility(8);
                        FaceSearchFragment.this.ltE.setVisibility(8);
                    }
                    FaceSearchFragment.this.dgG();
                }
            }

            @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.a
            public void onFail(int i, String str) {
                FaceSearchFragment.this.ltG.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgG() {
        this.ltG.setVisibility(0);
        this.ltE.setVisibility(0);
        int min = Math.min(this.ltK.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.ltK.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                TextView textView = new TextView(this.mActivity);
                ao.setBackgroundColor(textView, R.color.CAM_X0205);
                ao.setViewTextColor(textView, R.color.CAM_X0106);
                int dimens = l.getDimens(this.mActivity, R.dimen.ds16);
                textView.setPadding(dimens, dimens, dimens, dimens);
                textView.setText(str2);
                textView.setTextSize(0, l.getDimens(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FaceSearchFragment.this.ltD.setText(str);
                        FaceSearchFragment.this.ltD.setSelection(str.length());
                        FaceSearchFragment.this.Oc(str);
                    }
                });
                this.ltG.addView(textView);
            }
        }
    }

    public void a(f fVar) {
        this.lsv = fVar;
        if (this.ltH != null) {
            this.ltH.b(this.lsv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgH() {
        this.lsx.setVisibility(0);
        this.ltE.setVisibility(8);
        this.ltG.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dgI() {
        if (this.ltK != null && !this.ltK.isEmpty()) {
            this.ltG.setVisibility(0);
            this.ltE.setVisibility(0);
        }
        this.lsx.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgJ() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            getBaseFragmentActivity().showProgressBar();
            this.ltI.a(this.ltL, this.aYr + 1, 40, this.iMM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgK() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.ltF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.Bk(this.mActivity.getText(R.string.face_group_no_emotion).toString()), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.ltG.setVisibility(8);
        this.lsx.setVisibility(8);
        this.ltE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oc(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            getBaseFragmentActivity().showProgressBar();
            this.aYr = 0;
            this.ltL = str;
            this.ltI.a(str, this.aYr + 1, 40, this.iMM);
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void II(String str) {
        Oc(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void IJ(String str) {
        if (str.length() == 0) {
            this.mEmotionList.clear();
            if (this.ltH != null) {
                this.ltH.notifyDataSetChanged();
            }
            dgI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ltH != null) {
            this.ltH.dgM();
        }
        this.ltI.cancelLoadData();
        this.ltJ.cancelLoadData();
    }

    public LinkedHashMap<String, EmotionImageData> dgu() {
        if (this.ltH != null) {
            return this.ltH.dgu();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }
}
