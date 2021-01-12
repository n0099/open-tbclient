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
/* loaded from: classes8.dex */
public class FaceAlbumFragment extends BaseFragment implements AbsListView.OnScrollListener {
    private GridView dhj;
    private BaseFragmentActivity iEK;
    private g iQY;
    private com.baidu.tbadk.album.b iQZ;
    private f lsv;
    private List<ImageFileInfo> mImageList;
    private NoDataView mNoDataView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iEK = (BaseFragmentActivity) getPageContext().getPageActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_album, (ViewGroup) null);
        ao.setBackgroundResource(inflate, R.color.CAM_X0201);
        this.mNoDataView = NoDataViewFactory.a(this.iEK, inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iEK, R.dimen.ds320)), NoDataViewFactory.d.Bk(this.iEK.getText(R.string.face_group_no_picture).toString()), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(8);
        this.dhj = (GridView) inflate.findViewById(R.id.grid_view);
        init();
        cyp();
        return inflate;
    }

    private void init() {
        Serializable serializable;
        this.mImageList = new ArrayList();
        this.iQZ = new com.baidu.tbadk.album.b(getActivity());
        this.iQY = new g(this.iEK, this.mImageList);
        this.iQY.b(this.lsv);
        this.dhj.setAdapter((ListAdapter) this.iQY);
        this.dhj.setOnScrollListener(this);
        if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 3 && faceData.imageFileInfo != null) {
                    linkedHashMap.put(faceData.imageFileInfo.getFilePath(), faceData.imageFileInfo);
                }
            }
            this.iQY.G(linkedHashMap);
        }
    }

    private void cyp() {
        this.iQZ.a(com.baidu.tbadk.album.a.ALBUM_ID_ALL, new com.baidu.tbadk.album.d() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceAlbumFragment.1
            @Override // com.baidu.tbadk.album.d
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.d
            public void a(List<com.baidu.tbadk.album.a> list, List<ImageFileInfo> list2, String str) {
                if (!x.isEmpty(list2)) {
                    FaceAlbumFragment.this.mImageList.addAll(list2);
                    FaceAlbumFragment.this.iQY.notifyDataSetChanged();
                    return;
                }
                FaceAlbumFragment.this.dhj.setVisibility(8);
                FaceAlbumFragment.this.mNoDataView.setVisibility(0);
            }
        });
    }

    public void a(f fVar) {
        this.lsv = fVar;
        if (this.iQY != null) {
            this.iQY.b(this.lsv);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.iQY.di(true);
        } else if (this.iQY.isScroll()) {
            this.iQY.di(false);
            cyq();
        }
    }

    private void cyq() {
        if (this.iQY != null && this.iQY.dgL() != null) {
            int childCount = this.dhj.getChildCount();
            int firstVisiblePosition = this.dhj.getFirstVisiblePosition();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dhj.getChildAt(i);
                if (childAt != null) {
                    TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                    ImageFileInfo item = this.iQY.getItem(firstVisiblePosition + i);
                    if (item != null && tbImageView != null) {
                        tbImageView.setTag(item.toCachedKey(false));
                        this.iQY.dgL().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceAlbumFragment.2
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                                TbImageView tbImageView2 = (TbImageView) FaceAlbumFragment.this.dhj.findViewWithTag(str);
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

    public LinkedHashMap<String, ImageFileInfo> dgu() {
        if (this.iQY != null) {
            return this.iQY.dgu();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iQZ != null) {
            this.iQZ.bjz();
        }
    }
}
