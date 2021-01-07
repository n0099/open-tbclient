package com.baidu.tieba.newfaceshop.facemake;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.FaceData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class FaceAlbumFragment extends BaseFragment implements AbsListView.OnScrollListener {
    private GridView dlY;
    private BaseFragmentActivity iJr;
    private g iVF;
    private com.baidu.tbadk.album.b iVG;
    private f lxb;
    private List<ImageFileInfo> mImageList;
    private NoDataView mNoDataView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iJr = (BaseFragmentActivity) getPageContext().getPageActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_album, (ViewGroup) null);
        ao.setBackgroundResource(inflate, R.color.CAM_X0201);
        this.mNoDataView = NoDataViewFactory.a(this.iJr, inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iJr, R.dimen.ds320)), NoDataViewFactory.d.Cv(this.iJr.getText(R.string.face_group_no_picture).toString()), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(8);
        this.dlY = (GridView) inflate.findViewById(R.id.grid_view);
        init();
        cCh();
        return inflate;
    }

    private void init() {
        Serializable serializable;
        this.mImageList = new ArrayList();
        this.iVG = new com.baidu.tbadk.album.b(getActivity());
        this.iVF = new g(this.iJr, this.mImageList);
        this.iVF.b(this.lxb);
        this.dlY.setAdapter((ListAdapter) this.iVF);
        this.dlY.setOnScrollListener(this);
        if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 3 && faceData.imageFileInfo != null) {
                    linkedHashMap.put(faceData.imageFileInfo.getFilePath(), faceData.imageFileInfo);
                }
            }
            this.iVF.G(linkedHashMap);
        }
    }

    private void cCh() {
        this.iVG.a(com.baidu.tbadk.album.a.ALBUM_ID_ALL, new com.baidu.tbadk.album.d() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceAlbumFragment.1
            @Override // com.baidu.tbadk.album.d
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.d
            public void a(List<com.baidu.tbadk.album.a> list, List<ImageFileInfo> list2, String str) {
                if (!x.isEmpty(list2)) {
                    FaceAlbumFragment.this.mImageList.addAll(list2);
                    FaceAlbumFragment.this.iVF.notifyDataSetChanged();
                    return;
                }
                FaceAlbumFragment.this.dlY.setVisibility(8);
                FaceAlbumFragment.this.mNoDataView.setVisibility(0);
            }
        });
    }

    public void a(f fVar) {
        this.lxb = fVar;
        if (this.iVF != null) {
            this.iVF.b(this.lxb);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.iVF.dm(true);
        } else if (this.iVF.isScroll()) {
            this.iVF.dm(false);
            cCi();
        }
    }

    private void cCi() {
        if (this.iVF != null && this.iVF.dkD() != null) {
            int childCount = this.dlY.getChildCount();
            int firstVisiblePosition = this.dlY.getFirstVisiblePosition();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dlY.getChildAt(i);
                if (childAt != null) {
                    TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                    ImageFileInfo item = this.iVF.getItem(firstVisiblePosition + i);
                    if (item != null && tbImageView != null) {
                        tbImageView.setTag(item.toCachedKey(false));
                        this.iVF.dkD().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceAlbumFragment.2
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                                TbImageView tbImageView2 = (TbImageView) FaceAlbumFragment.this.dlY.findViewWithTag(str);
                                if (tbImageView2 != null && aVar != null) {
                                    tbImageView2.invalidate();
                                }
                            }
                        }, false, false);
                    }
                }
            }
        }
    }

    public LinkedHashMap<String, ImageFileInfo> dkm() {
        if (this.iVF != null) {
            return this.iVF.dkm();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iVG != null) {
            this.iVG.bnt();
        }
    }
}
