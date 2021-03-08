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
/* loaded from: classes8.dex */
public class FaceAlbumFragment extends BaseFragment implements AbsListView.OnScrollListener {
    private GridView dkY;
    private BaseFragmentActivity iMq;
    private g iYC;
    private com.baidu.tbadk.album.b iYD;
    private f lCQ;
    private List<ImageFileInfo> mImageList;
    private NoDataView mNoDataView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iMq = (BaseFragmentActivity) getPageContext().getPageActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_pick_album, (ViewGroup) null);
        ap.setBackgroundResource(inflate, R.color.CAM_X0201);
        this.mNoDataView = NoDataViewFactory.a(this.iMq, inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iMq, R.dimen.ds320)), NoDataViewFactory.d.BI(this.iMq.getText(R.string.face_group_no_picture).toString()), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(8);
        this.dkY = (GridView) inflate.findViewById(R.id.grid_view);
        init();
        czN();
        return inflate;
    }

    private void init() {
        Serializable serializable;
        this.mImageList = new ArrayList();
        this.iYD = new com.baidu.tbadk.album.b(getActivity());
        this.iYC = new g(this.iMq, this.mImageList);
        this.iYC.b(this.lCQ);
        this.dkY.setAdapter((ListAdapter) this.iYC);
        this.dkY.setOnScrollListener(this);
        if (getArguments() != null && (serializable = getArguments().getSerializable(PickFaceTabActivityConfig.CHOOSED_LIST)) != null && (serializable instanceof ArrayList)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = ((ArrayList) serializable).iterator();
            while (it.hasNext()) {
                FaceData faceData = (FaceData) it.next();
                if (faceData != null && faceData.type == 3 && faceData.imageFileInfo != null) {
                    linkedHashMap.put(faceData.imageFileInfo.getFilePath(), faceData.imageFileInfo);
                }
            }
            this.iYC.I(linkedHashMap);
        }
    }

    private void czN() {
        this.iYD.a(com.baidu.tbadk.album.a.ALBUM_ID_ALL, new com.baidu.tbadk.album.d() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceAlbumFragment.1
            @Override // com.baidu.tbadk.album.d
            public void onPreLoad() {
            }

            @Override // com.baidu.tbadk.album.d
            public void a(List<com.baidu.tbadk.album.a> list, List<ImageFileInfo> list2, String str) {
                if (!y.isEmpty(list2)) {
                    FaceAlbumFragment.this.mImageList.addAll(list2);
                    FaceAlbumFragment.this.iYC.notifyDataSetChanged();
                    return;
                }
                FaceAlbumFragment.this.dkY.setVisibility(8);
                FaceAlbumFragment.this.mNoDataView.setVisibility(0);
            }
        });
    }

    public void a(f fVar) {
        this.lCQ = fVar;
        if (this.iYC != null) {
            this.iYC.b(this.lCQ);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.iYC.dq(true);
        } else if (this.iYC.isScroll()) {
            this.iYC.dq(false);
            czO();
        }
    }

    private void czO() {
        if (this.iYC != null && this.iYC.djc() != null) {
            int childCount = this.dkY.getChildCount();
            int firstVisiblePosition = this.dkY.getFirstVisiblePosition();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dkY.getChildAt(i);
                if (childAt != null) {
                    TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                    ImageFileInfo item = this.iYC.getItem(firstVisiblePosition + i);
                    if (item != null && tbImageView != null) {
                        tbImageView.setTag(item.toCachedKey(false));
                        this.iYC.djc().a(item, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceAlbumFragment.2
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                                TbImageView tbImageView2 = (TbImageView) FaceAlbumFragment.this.dkY.findViewWithTag(str);
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

    public LinkedHashMap<String, ImageFileInfo> diL() {
        if (this.iYC != null) {
            return this.iYC.diL();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iYD != null) {
            this.iYD.bjW();
        }
    }
}
