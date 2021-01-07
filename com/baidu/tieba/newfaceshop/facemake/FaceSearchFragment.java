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
/* loaded from: classes9.dex */
public class FaceSearchFragment extends BaseFragment implements SearchEditView.a {
    private int bdf;
    private View lnx;
    private f lxb;
    private BdListView lxd;
    private LinearLayout lxj;
    private SearchEditView lyi;
    private TextView lyj;
    private FaceImageLayout lyk;
    private AutoLineWrapLayout lyl;
    private h lym;
    private SearchEmotionModel lyn;
    private GetHotWordsModel lyp;
    private List<String> lyq;
    private String lyr;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a iRt = new SearchEmotionModel.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.4
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (aVar == null || aVar.cAN() == null || aVar.cAN().isEmpty()) {
                if (FaceSearchFragment.this.bdf == 0) {
                    FaceSearchFragment.this.dkC();
                    return;
                }
                return;
            }
            FaceSearchFragment.this.bdf = aVar.getPage();
            if (FaceSearchFragment.this.bdf == 1) {
                FaceSearchFragment.this.mEmotionList.clear();
            }
            FaceSearchFragment.this.mHasMore = aVar.cAM() != 0;
            FaceSearchFragment.this.mEmotionList.addAll(aVar.cAN());
            FaceSearchFragment.this.lym.notifyDataSetChanged();
            FaceSearchFragment.this.dkz();
            l.hideSoftKeyPad(FaceSearchFragment.this.getActivity(), FaceSearchFragment.this.lyi);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (FaceSearchFragment.this.bdf == 1) {
                FaceSearchFragment.this.dkC();
            }
        }
    };
    private final BdListView.e WN = new BdListView.e() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            FaceSearchFragment.this.dkB();
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mActivity = getPageContext().getPageActivity();
        this.mActivity.getWindow().setSoftInputMode(3);
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_search, (ViewGroup) null);
        ap(inflate);
        this.lyn = new SearchEmotionModel();
        this.bdf = 1;
        bIn();
        return inflate;
    }

    private void ap(View view) {
        Serializable serializable;
        this.lxj = (LinearLayout) view.findViewById(R.id.layout_root);
        this.lyk = (FaceImageLayout) view.findViewById(R.id.layout_content);
        this.lyk.setListener(new FaceImageLayout.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.1
            @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
            public void dkt() {
                l.hideSoftKeyPad(FaceSearchFragment.this.mActivity, FaceSearchFragment.this.lyi);
            }
        });
        this.lnx = view.findViewById(R.id.view_line);
        this.lyi = (SearchEditView) view.findViewById(R.id.edit_search_view);
        this.lyi.setCallback(this);
        this.lyl = (AutoLineWrapLayout) view.findViewById(R.id.layout_hot_words);
        this.lyj = (TextView) view.findViewById(R.id.tv_tips);
        ao.setBackgroundResource(this.lxj, R.color.CAM_X0201);
        ao.setBackgroundColor(this.lnx, R.color.CAM_X0204);
        ao.setViewTextColor(this.lyj, R.color.CAM_X0109);
        this.lxd = (BdListView) view.findViewById(R.id.listview_emotion);
        this.lxd.setOnSrollToBottomListener(this.WN);
        this.mEmotionList = new ArrayList();
        this.lym = new h(this.mEmotionList, 10);
        this.lym.b(this.lxb);
        this.lxd.setAdapter((ListAdapter) this.lym);
        if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 2 && faceData.emotionImageData != null) {
                    linkedHashMap.put(faceData.emotionImageData.getPicUrl(), faceData.emotionImageData);
                }
            }
            this.lym.G(linkedHashMap);
        }
    }

    private void bIn() {
        this.lyp = new GetHotWordsModel();
        this.lyq = new ArrayList();
        this.lyp.a(new GetHotWordsModel.a() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceSearchFragment.2
            @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.a
            public void ai(List<String> list) {
                if (list != null) {
                    FaceSearchFragment.this.lyq.addAll(list);
                    if (FaceSearchFragment.this.lyq == null || FaceSearchFragment.this.lyq.isEmpty()) {
                        FaceSearchFragment.this.lyl.setVisibility(8);
                        FaceSearchFragment.this.lyj.setVisibility(8);
                    }
                    FaceSearchFragment.this.dky();
                }
            }

            @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.a
            public void onFail(int i, String str) {
                FaceSearchFragment.this.lyl.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dky() {
        this.lyl.setVisibility(0);
        this.lyj.setVisibility(0);
        int min = Math.min(this.lyq.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.lyq.get(i);
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
                        FaceSearchFragment.this.lyi.setText(str);
                        FaceSearchFragment.this.lyi.setSelection(str.length());
                        FaceSearchFragment.this.Pk(str);
                    }
                });
                this.lyl.addView(textView);
            }
        }
    }

    public void a(f fVar) {
        this.lxb = fVar;
        if (this.lym != null) {
            this.lym.b(this.lxb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkz() {
        this.lxd.setVisibility(0);
        this.lyj.setVisibility(8);
        this.lyl.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dkA() {
        if (this.lyq != null && !this.lyq.isEmpty()) {
            this.lyl.setVisibility(0);
            this.lyj.setVisibility(0);
        }
        this.lxd.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkB() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            getBaseFragmentActivity().showProgressBar();
            this.lyn.a(this.lyr, this.bdf + 1, 40, this.iRt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkC() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lyk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.Cv(this.mActivity.getText(R.string.face_group_no_emotion).toString()), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.lyl.setVisibility(8);
        this.lxd.setVisibility(8);
        this.lyj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pk(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            getBaseFragmentActivity().showProgressBar();
            this.bdf = 0;
            this.lyr = str;
            this.lyn.a(str, this.bdf + 1, 40, this.iRt);
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JT(String str) {
        Pk(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JU(String str) {
        if (str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lym != null) {
                this.lym.notifyDataSetChanged();
            }
            dkA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lym != null) {
            this.lym.dkE();
        }
        this.lyn.cancelLoadData();
        this.lyp.cancelLoadData();
    }

    public LinkedHashMap<String, EmotionImageData> dkm() {
        if (this.lym != null) {
            return this.lym.dkm();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }
}
