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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
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
    private GridView djx;
    private BaseFragmentActivity iKt;
    private g iWF;
    private com.baidu.tbadk.album.b iWG;
    private f lAA;
    private List<ImageFileInfo> mImageList;
    private NoDataView mNoDataView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iKt = (BaseFragmentActivity) getPageContext().getPageActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_album, (ViewGroup) null);
        ap.setBackgroundResource(inflate, R.color.CAM_X0201);
        this.mNoDataView = NoDataViewFactory.a(this.iKt, inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iKt, R.dimen.ds320)), NoDataViewFactory.d.BB(this.iKt.getText(R.string.face_group_no_picture).toString()), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(8);
        this.djx = (GridView) inflate.findViewById(R.id.grid_view);
        init();
        czA();
        return inflate;
    }

    private void init() {
        Serializable serializable;
        this.mImageList = new ArrayList();
        this.iWG = new com.baidu.tbadk.album.b(getActivity());
        this.iWF = new g(this.iKt, this.mImageList);
        this.iWF.b(this.lAA);
        this.djx.setAdapter((ListAdapter) this.iWF);
        this.djx.setOnScrollListener(this);
        if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 3 && faceData.imageFileInfo != null) {
                    linkedHashMap.put(faceData.imageFileInfo.getFilePath(), faceData.imageFileInfo);
                }
            }
            this.iWF.I(linkedHashMap);
        }
    }

    private void czA() {
        this.iWG.a(com.baidu.tbadk.album.a.ALBUM_ID_ALL, new com.baidu.tbadk.album.d() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceAlbumFragment.1
            @Override // com.baidu.tbadk.album.d
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.d
            public void a(List<com.baidu.tbadk.album.a> list, List<ImageFileInfo> list2, String str) {
                if (!y.isEmpty(list2)) {
                    FaceAlbumFragment.this.mImageList.addAll(list2);
                    FaceAlbumFragment.this.iWF.notifyDataSetChanged();
                    return;
                }
                FaceAlbumFragment.this.djx.setVisibility(8);
                FaceAlbumFragment.this.mNoDataView.setVisibility(0);
            }
        });
    }

    public void a(f fVar) {
        this.lAA = fVar;
        if (this.iWF != null) {
            this.iWF.b(this.lAA);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.iWF.dq(true);
        } else if (this.iWF.isScroll()) {
            this.iWF.dq(false);
            czB();
        }
    }

    private void czB() {
        if (this.iWF != null && this.iWF.diM() != null) {
            int childCount = this.djx.getChildCount();
            int firstVisiblePosition = this.djx.getFirstVisiblePosition();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.djx.getChildAt(i);
                if (childAt != null) {
                    TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                    ImageFileInfo item = this.iWF.getItem(firstVisiblePosition + i);
                    if (item != null && tbImageView != null) {
                        tbImageView.setTag(item.toCachedKey(false));
                        this.iWF.diM().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceAlbumFragment.2
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                                TbImageView tbImageView2 = (TbImageView) FaceAlbumFragment.this.djx.findViewWithTag(str);
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

    public LinkedHashMap<String, ImageFileInfo> div() {
        if (this.iWF != null) {
            return this.iWF.div();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iWG != null) {
            this.iWG.bjU();
        }
    }
}
