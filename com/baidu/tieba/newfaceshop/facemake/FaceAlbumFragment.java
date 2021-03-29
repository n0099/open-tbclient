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
import d.b.b.e.p.l;
import d.b.h0.e.d;
import d.b.i0.x1.g.f;
import d.b.i0.x1.g.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class FaceAlbumFragment extends BaseFragment implements AbsListView.OnScrollListener {

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.e.b f19219e;

    /* renamed from: f  reason: collision with root package name */
    public GridView f19220f;

    /* renamed from: g  reason: collision with root package name */
    public g f19221g;

    /* renamed from: h  reason: collision with root package name */
    public List<ImageFileInfo> f19222h;
    public f i;
    public NoDataView j;
    public BaseFragmentActivity k;

    /* loaded from: classes3.dex */
    public class a implements d {
        public a() {
        }

        @Override // d.b.h0.e.d
        public void a(List<d.b.h0.e.a> list, List<ImageFileInfo> list2, String str) {
            if (!ListUtils.isEmpty(list2)) {
                FaceAlbumFragment.this.f19222h.addAll(list2);
                FaceAlbumFragment.this.f19221g.notifyDataSetChanged();
                return;
            }
            FaceAlbumFragment.this.f19220f.setVisibility(8);
            FaceAlbumFragment.this.j.setVisibility(0);
        }

        @Override // d.b.h0.e.d
        public void onPreLoad() {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a0.b {
        public b() {
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.b.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) FaceAlbumFragment.this.f19220f.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    public LinkedHashMap<String, ImageFileInfo> I0() {
        g gVar = this.f19221g;
        if (gVar != null) {
            return gVar.f();
        }
        return null;
    }

    public final void J0() {
        Serializable serializable;
        ImageFileInfo imageFileInfo;
        this.f19222h = new ArrayList();
        this.f19219e = new d.b.h0.e.b(getActivity());
        g gVar = new g(this.k, this.f19222h);
        this.f19221g = gVar;
        gVar.j(this.i);
        this.f19220f.setAdapter((ListAdapter) this.f19221g);
        this.f19220f.setOnScrollListener(this);
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
        this.f19221g.e(linkedHashMap);
    }

    public final void K0() {
        this.f19219e.i(d.b.h0.e.a.f50120f, new a());
    }

    public final void L0() {
        g gVar = this.f19221g;
        if (gVar == null || gVar.g() == null) {
            return;
        }
        int childCount = this.f19220f.getChildCount();
        int firstVisiblePosition = this.f19220f.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f19220f.getChildAt(i);
            if (childAt != null) {
                TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                ImageFileInfo item = this.f19221g.getItem(firstVisiblePosition + i);
                if (item != null && tbImageView != null) {
                    tbImageView.setTag(item.toCachedKey(false));
                    this.f19221g.g().e(item, new b(), false, false);
                }
            }
        }
    }

    public void M0(f fVar) {
        this.i = fVar;
        g gVar = this.f19221g;
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
        this.f19220f = (GridView) inflate.findViewById(R.id.grid_view);
        J0();
        K0();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.b.h0.e.b bVar = this.f19219e;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.f19221g.l(true);
        } else if (this.f19221g.i()) {
            this.f19221g.l(false);
            L0();
        }
    }
}
