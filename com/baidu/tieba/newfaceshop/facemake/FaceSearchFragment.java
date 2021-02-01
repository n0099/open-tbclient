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
    private f lAA;
    private BdListView lAC;
    private LinearLayout lAI;
    private SearchEditView lBH;
    private TextView lBI;
    private FaceImageLayout lBJ;
    private AutoLineWrapLayout lBK;
    private h lBL;
    private SearchEmotionModel lBM;
    private GetHotWordsModel lBN;
    private List<String> lBO;
    private String lBP;
    private View lqY;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a iSt = new SearchEmotionModel.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.4
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (aVar == null || aVar.cyg() == null || aVar.cyg().isEmpty()) {
                if (FaceSearchFragment.this.bby == 0) {
                    FaceSearchFragment.this.diL();
                    return;
                }
                return;
            }
            FaceSearchFragment.this.bby = aVar.getPage();
            if (FaceSearchFragment.this.bby == 1) {
                FaceSearchFragment.this.mEmotionList.clear();
            }
            FaceSearchFragment.this.mHasMore = aVar.cyf() != 0;
            FaceSearchFragment.this.mEmotionList.addAll(aVar.cyg());
            FaceSearchFragment.this.lBL.notifyDataSetChanged();
            FaceSearchFragment.this.diI();
            l.hideSoftKeyPad(FaceSearchFragment.this.getActivity(), FaceSearchFragment.this.lBH);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (FaceSearchFragment.this.bby == 1) {
                FaceSearchFragment.this.diL();
            }
        }
    };
    private final BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            FaceSearchFragment.this.diK();
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActivity = getPageContext().getPageActivity();
        this.mActivity.getWindow().setSoftInputMode(3);
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_search, (ViewGroup) null);
        am(inflate);
        this.lBM = new SearchEmotionModel();
        this.bby = 1;
        bEN();
        return inflate;
    }

    private void am(View view) {
        Serializable serializable;
        this.lAI = (LinearLayout) view.findViewById(R.id.layout_root);
        this.lBJ = (FaceImageLayout) view.findViewById(R.id.layout_content);
        this.lBJ.setListener(new FaceImageLayout.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.1
            @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
            public void diC() {
                l.hideSoftKeyPad(FaceSearchFragment.this.mActivity, FaceSearchFragment.this.lBH);
            }
        });
        this.lqY = view.findViewById(R.id.view_line);
        this.lBH = (SearchEditView) view.findViewById(R.id.edit_search_view);
        this.lBH.setCallback(this);
        this.lBK = (AutoLineWrapLayout) view.findViewById(R.id.layout_hot_words);
        this.lBI = (TextView) view.findViewById(R.id.tv_tips);
        ap.setBackgroundResource(this.lAI, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lqY, R.color.CAM_X0204);
        ap.setViewTextColor(this.lBI, R.color.CAM_X0109);
        this.lAC = (BdListView) view.findViewById(R.id.listview_emotion);
        this.lAC.setOnSrollToBottomListener(this.WH);
        this.mEmotionList = new ArrayList();
        this.lBL = new h(this.mEmotionList, 10);
        this.lBL.b(this.lAA);
        this.lAC.setAdapter((ListAdapter) this.lBL);
        if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 2 && faceData.emotionImageData != null) {
                    linkedHashMap.put(faceData.emotionImageData.getPicUrl(), faceData.emotionImageData);
                }
            }
            this.lBL.I(linkedHashMap);
        }
    }

    private void bEN() {
        this.lBN = new GetHotWordsModel();
        this.lBO = new ArrayList();
        this.lBN.a(new GetHotWordsModel.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.2
            @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.a
            public void aj(List<String> list) {
                if (list != null) {
                    FaceSearchFragment.this.lBO.addAll(list);
                    if (FaceSearchFragment.this.lBO == null || FaceSearchFragment.this.lBO.isEmpty()) {
                        FaceSearchFragment.this.lBK.setVisibility(8);
                        FaceSearchFragment.this.lBI.setVisibility(8);
                    }
                    FaceSearchFragment.this.diH();
                }
            }

            @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.a
            public void onFail(int i, String str) {
                FaceSearchFragment.this.lBK.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diH() {
        this.lBK.setVisibility(0);
        this.lBI.setVisibility(0);
        int min = Math.min(this.lBO.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.lBO.get(i);
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
                        FaceSearchFragment.this.lBH.setText(str);
                        FaceSearchFragment.this.lBH.setSelection(str.length());
                        FaceSearchFragment.this.OS(str);
                    }
                });
                this.lBK.addView(textView);
            }
        }
    }

    public void a(f fVar) {
        this.lAA = fVar;
        if (this.lBL != null) {
            this.lBL.b(this.lAA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diI() {
        this.lAC.setVisibility(0);
        this.lBI.setVisibility(8);
        this.lBK.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void diJ() {
        if (this.lBO != null && !this.lBO.isEmpty()) {
            this.lBK.setVisibility(0);
            this.lBI.setVisibility(0);
        }
        this.lAC.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diK() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            getBaseFragmentActivity().showProgressBar();
            this.lBM.a(this.lBP, this.bby + 1, 40, this.iSt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diL() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lBJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.BB(this.mActivity.getText(R.string.face_group_no_emotion).toString()), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.lBK.setVisibility(8);
        this.lAC.setVisibility(8);
        this.lBI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OS(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            getBaseFragmentActivity().showProgressBar();
            this.bby = 0;
            this.lBP = str;
            this.lBM.a(str, this.bby + 1, 40, this.iSt);
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Jt(String str) {
        OS(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Ju(String str) {
        if (str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lBL != null) {
                this.lBL.notifyDataSetChanged();
            }
            diJ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lBL != null) {
            this.lBL.diN();
        }
        this.lBM.cancelLoadData();
        this.lBN.cancelLoadData();
    }

    public LinkedHashMap<String, EmotionImageData> div() {
        if (this.lBL != null) {
            return this.lBL.div();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }
}
