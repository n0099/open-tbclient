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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.k0.y1.g.f;
import d.a.k0.y1.g.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class FaceSearchFragment extends BaseFragment implements SearchEditView.d {

    /* renamed from: e  reason: collision with root package name */
    public SearchEditView f18661e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18662f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f18663g;

    /* renamed from: h  reason: collision with root package name */
    public FaceImageLayout f18664h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f18665i;
    public View j;
    public AutoLineWrapLayout k;
    public BdListView l;
    public h m;
    public List<EmotionImageData> n;
    public SearchEmotionModel o;
    public GetHotWordsModel p;
    public List<String> q;
    public int r;
    public boolean s;
    public String t;
    public f u;
    public Activity v;
    public final SearchEmotionModel.b w = new d();
    public final BdListView.p x = new e();

    /* loaded from: classes4.dex */
    public class a implements FaceImageLayout.a {
        public a() {
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
        public void a() {
            l.x(FaceSearchFragment.this.v, FaceSearchFragment.this.f18661e);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements GetHotWordsModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.b
        public void onFail(int i2, String str) {
            FaceSearchFragment.this.k.setVisibility(8);
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.b
        public void onSuccess(List<String> list) {
            if (list != null) {
                FaceSearchFragment.this.q.addAll(list);
                if (FaceSearchFragment.this.q == null || FaceSearchFragment.this.q.isEmpty()) {
                    FaceSearchFragment.this.k.setVisibility(8);
                    FaceSearchFragment.this.f18662f.setVisibility(8);
                }
                FaceSearchFragment.this.T0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18668e;

        public c(String str) {
            this.f18668e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FaceSearchFragment.this.f18661e.setText(this.f18668e);
            FaceSearchFragment.this.f18661e.setSelection(this.f18668e.length());
            FaceSearchFragment.this.X0(this.f18668e);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements SearchEmotionModel.b {
        public d() {
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void a(String str, d.a.k0.k0.c.a aVar) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (aVar == null || aVar.a() == null || aVar.a().isEmpty()) {
                if (FaceSearchFragment.this.r == 0) {
                    FaceSearchFragment.this.a1();
                    return;
                }
                return;
            }
            FaceSearchFragment.this.r = aVar.c();
            if (FaceSearchFragment.this.r == 1) {
                FaceSearchFragment.this.n.clear();
            }
            FaceSearchFragment.this.s = aVar.b() != 0;
            FaceSearchFragment.this.n.addAll(aVar.a());
            FaceSearchFragment.this.m.notifyDataSetChanged();
            FaceSearchFragment.this.b1();
            l.x(FaceSearchFragment.this.getActivity(), FaceSearchFragment.this.f18661e);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i2, String str) {
            FaceSearchFragment.this.getBaseFragmentActivity().hideProgressBar();
            if (FaceSearchFragment.this.r == 1) {
                FaceSearchFragment.this.a1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            FaceSearchFragment.this.V0();
        }
    }

    public LinkedHashMap<String, EmotionImageData> S0() {
        h hVar = this.m;
        if (hVar != null) {
            return hVar.i();
        }
        return null;
    }

    public final void T0() {
        this.k.setVisibility(0);
        this.f18662f.setVisibility(0);
        int min = Math.min(this.q.size(), 10);
        for (int i2 = 0; i2 < min; i2++) {
            String str = this.q.get(i2);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                TextView textView = new TextView(this.v);
                SkinManager.setBackgroundColor(textView, R.color.CAM_X0205);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
                int g2 = l.g(this.v, R.dimen.ds16);
                textView.setPadding(g2, g2, g2, g2);
                textView.setText(str2);
                textView.setTextSize(0, l.g(this.v, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new c(str));
                this.k.addView(textView);
            }
        }
    }

    public final void U0(View view) {
        Serializable serializable;
        EmotionImageData emotionImageData;
        this.f18663g = (LinearLayout) view.findViewById(R.id.layout_root);
        FaceImageLayout faceImageLayout = (FaceImageLayout) view.findViewById(R.id.layout_content);
        this.f18664h = faceImageLayout;
        faceImageLayout.setListener(new a());
        this.j = view.findViewById(R.id.view_line);
        SearchEditView searchEditView = (SearchEditView) view.findViewById(R.id.edit_search_view);
        this.f18661e = searchEditView;
        searchEditView.setCallback(this);
        this.k = (AutoLineWrapLayout) view.findViewById(R.id.layout_hot_words);
        this.f18662f = (TextView) view.findViewById(R.id.tv_tips);
        SkinManager.setBackgroundResource(this.f18663g, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f18662f, R.color.CAM_X0109);
        BdListView bdListView = (BdListView) view.findViewById(R.id.listview_emotion);
        this.l = bdListView;
        bdListView.setOnSrollToBottomListener(this.x);
        this.n = new ArrayList();
        h hVar = new h(this.n, 10);
        this.m = hVar;
        hVar.l(this.u);
        this.l.setAdapter((ListAdapter) this.m);
        if (getArguments() == null || (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) == null || !(serializable instanceof ArrayList)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = ((ArrayList) serializable).iterator();
        while (it.hasNext()) {
            FaceData faceData = (FaceData) it.next();
            if (faceData != null && faceData.type == 2 && (emotionImageData = faceData.emotionImageData) != null) {
                linkedHashMap.put(emotionImageData.getPicUrl(), faceData.emotionImageData);
            }
        }
        this.m.g(linkedHashMap);
    }

    public final void V0() {
        if (!j.z()) {
            showToast(R.string.neterror);
        } else if (this.s) {
            getBaseFragmentActivity().showProgressBar();
            this.o.t(this.t, this.r + 1, 40, this.w);
        }
    }

    public final void W0() {
        this.p = new GetHotWordsModel();
        this.q = new ArrayList();
        this.p.t(new b());
    }

    public final void X0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!j.z()) {
            showToast(R.string.neterror);
            return;
        }
        getBaseFragmentActivity().showProgressBar();
        this.r = 0;
        this.t = str;
        this.o.t(str, 0 + 1, 40, this.w);
    }

    public void Y0(f fVar) {
        this.u = fVar;
        h hVar = this.m;
        if (hVar != null) {
            hVar.l(fVar);
        }
    }

    public final void Z0() {
        List<String> list = this.q;
        if (list != null && !list.isEmpty()) {
            this.k.setVisibility(0);
            this.f18662f.setVisibility(0);
        }
        this.l.setVisibility(8);
        NoDataView noDataView = this.f18665i;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void a1() {
        if (this.f18665i == null) {
            NoDataView a2 = NoDataViewFactory.a(this.v, this.f18664h, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.v, R.dimen.ds320)), NoDataViewFactory.e.c(this.v.getText(R.string.face_group_no_emotion).toString()), null);
            this.f18665i = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.f18665i.setVisibility(0);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.f18662f.setVisibility(8);
    }

    public final void b1() {
        this.l.setVisibility(0);
        this.f18662f.setVisibility(8);
        this.k.setVisibility(8);
        NoDataView noDataView = this.f18665i;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void onClickSearch(String str) {
        X0(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Activity pageActivity = getPageContext().getPageActivity();
        this.v = pageActivity;
        pageActivity.getWindow().setSoftInputMode(3);
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_search, (ViewGroup) null);
        U0(inflate);
        this.o = new SearchEmotionModel();
        this.r = 1;
        W0();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        h hVar = this.m;
        if (hVar != null) {
            hVar.k();
        }
        this.o.cancelLoadData();
        this.p.cancelLoadData();
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void onTextChanged(String str) {
        if (str.length() == 0) {
            this.n.clear();
            h hVar = this.m;
            if (hVar != null) {
                hVar.notifyDataSetChanged();
            }
            Z0();
        }
    }
}
