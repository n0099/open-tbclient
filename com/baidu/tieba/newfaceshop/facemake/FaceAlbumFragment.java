package com.baidu.tieba.newfaceshop.facemake;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.FaceData;
import d.a.c.e.p.l;
import d.a.m0.e.d;
import d.a.n0.z1.g.f;
import d.a.n0.z1.g.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class FaceAlbumFragment extends BaseFragment implements AbsListView.OnScrollListener {

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.e.b f18549e;

    /* renamed from: f  reason: collision with root package name */
    public GridView f18550f;

    /* renamed from: g  reason: collision with root package name */
    public g f18551g;

    /* renamed from: h  reason: collision with root package name */
    public List<ImageFileInfo> f18552h;

    /* renamed from: i  reason: collision with root package name */
    public f f18553i;
    public NoDataView j;
    public BaseFragmentActivity k;

    /* loaded from: classes4.dex */
    public class a implements d {
        public a() {
        }

        @Override // d.a.m0.e.d
        public void a(List<d.a.m0.e.a> list, List<ImageFileInfo> list2, String str) {
            if (!ListUtils.isEmpty(list2)) {
                FaceAlbumFragment.this.f18552h.addAll(list2);
                FaceAlbumFragment.this.f18551g.notifyDataSetChanged();
                return;
            }
            FaceAlbumFragment.this.f18550f.setVisibility(8);
            FaceAlbumFragment.this.j.setVisibility(0);
        }

        @Override // d.a.m0.e.d
        public void onPreLoad() {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.m0.a0.b {
        public b() {
        }

        @Override // d.a.m0.a0.b
        public void a(d.a.c.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) FaceAlbumFragment.this.f18550f.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    public LinkedHashMap<String, ImageFileInfo> H0() {
        g gVar = this.f18551g;
        if (gVar != null) {
            return gVar.f();
        }
        return null;
    }

    public final void I0() {
        Serializable serializable;
        ImageFileInfo imageFileInfo;
        this.f18552h = new ArrayList();
        this.f18549e = new d.a.m0.e.b(getActivity());
        g gVar = new g(this.k, this.f18552h);
        this.f18551g = gVar;
        gVar.j(this.f18553i);
        this.f18550f.setAdapter((ListAdapter) this.f18551g);
        this.f18550f.setOnScrollListener(this);
        if (getArguments() == null || (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) == null || !(serializable instanceof ArrayList)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = ((ArrayList) serializable).iterator();
        while (it.hasNext()) {
            FaceData faceData = (FaceData) it.next();
            if (faceData != null && faceData.type == 3 && (imageFileInfo = faceData.imageFileInfo) != null) {
                linkedHashMap.put(imageFileInfo.getFilePath(), faceData.imageFileInfo);
            }
        }
        this.f18551g.e(linkedHashMap);
    }

    public final void J0() {
        this.f18549e.i(d.a.m0.e.a.f49299f, new a());
    }

    public final void K0() {
        g gVar = this.f18551g;
        if (gVar == null || gVar.g() == null) {
            return;
        }
        int childCount = this.f18550f.getChildCount();
        int firstVisiblePosition = this.f18550f.getFirstVisiblePosition();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f18550f.getChildAt(i2);
            if (childAt != null) {
                TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                ImageFileInfo item = this.f18551g.getItem(firstVisiblePosition + i2);
                if (item != null && tbImageView != null) {
                    tbImageView.setTag(item.toCachedKey(false));
                    this.f18551g.g().e(item, new b(), false, false);
                }
            }
        }
    }

    public void L0(f fVar) {
        this.f18553i = fVar;
        g gVar = this.f18551g;
        if (gVar != null) {
            gVar.j(fVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = (BaseFragmentActivity) getPageContext().getPageActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_album, (ViewGroup) null);
        SkinManager.setBackgroundResource(inflate, R.color.CAM_X0201);
        NoDataView a2 = NoDataViewFactory.a(this.k, inflate, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.k, R.dimen.ds320)), NoDataViewFactory.e.c(this.k.getText(R.string.face_group_no_picture).toString()), null);
        this.j = a2;
        a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.j.setVisibility(8);
        this.f18550f = (GridView) inflate.findViewById(R.id.grid_view);
        I0();
        J0();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.m0.e.b bVar = this.f18549e;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        super.onScrollStateChanged(absListView, i2);
        if (i2 == 2) {
            this.f18551g.l(true);
        } else if (this.f18551g.i()) {
            this.f18551g.l(false);
            K0();
        }
    }
}
