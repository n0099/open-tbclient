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
    public d.a.m0.e.b f18625e;

    /* renamed from: f  reason: collision with root package name */
    public GridView f18626f;

    /* renamed from: g  reason: collision with root package name */
    public g f18627g;

    /* renamed from: h  reason: collision with root package name */
    public List<ImageFileInfo> f18628h;

    /* renamed from: i  reason: collision with root package name */
    public f f18629i;
    public NoDataView j;
    public BaseFragmentActivity k;

    /* loaded from: classes4.dex */
    public class a implements d {
        public a() {
        }

        @Override // d.a.m0.e.d
        public void a(List<d.a.m0.e.a> list, List<ImageFileInfo> list2, String str) {
            if (!ListUtils.isEmpty(list2)) {
                FaceAlbumFragment.this.f18628h.addAll(list2);
                FaceAlbumFragment.this.f18627g.notifyDataSetChanged();
                return;
            }
            FaceAlbumFragment.this.f18626f.setVisibility(8);
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
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) FaceAlbumFragment.this.f18626f.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    public LinkedHashMap<String, ImageFileInfo> K0() {
        g gVar = this.f18627g;
        if (gVar != null) {
            return gVar.f();
        }
        return null;
    }

    public final void L0() {
        Serializable serializable;
        ImageFileInfo imageFileInfo;
        this.f18628h = new ArrayList();
        this.f18625e = new d.a.m0.e.b(getActivity());
        g gVar = new g(this.k, this.f18628h);
        this.f18627g = gVar;
        gVar.j(this.f18629i);
        this.f18626f.setAdapter((ListAdapter) this.f18627g);
        this.f18626f.setOnScrollListener(this);
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
        this.f18627g.e(linkedHashMap);
    }

    public final void M0() {
        this.f18625e.i(d.a.m0.e.a.f52973f, new a());
    }

    public final void N0() {
        g gVar = this.f18627g;
        if (gVar == null || gVar.g() == null) {
            return;
        }
        int childCount = this.f18626f.getChildCount();
        int firstVisiblePosition = this.f18626f.getFirstVisiblePosition();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f18626f.getChildAt(i2);
            if (childAt != null) {
                TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                ImageFileInfo item = this.f18627g.getItem(firstVisiblePosition + i2);
                if (item != null && tbImageView != null) {
                    tbImageView.setTag(item.toCachedKey(false));
                    this.f18627g.g().e(item, new b(), false, false);
                }
            }
        }
    }

    public void O0(f fVar) {
        this.f18629i = fVar;
        g gVar = this.f18627g;
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
        this.f18626f = (GridView) inflate.findViewById(R.id.grid_view);
        L0();
        M0();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.m0.e.b bVar = this.f18625e;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        super.onScrollStateChanged(absListView, i2);
        if (i2 == 2) {
            this.f18627g.l(true);
        } else if (this.f18627g.i()) {
            this.f18627g.l(false);
            N0();
        }
    }
}
