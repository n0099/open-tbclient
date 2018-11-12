package com.baidu.tieba.video.cloudmusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.e;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView bKJ;
    private BdListView eDU;
    private com.baidu.tieba.video.cloudmusic.a.a hti;
    private d.a htj;
    private CloudMusicData.MusicTagList htk;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int cUc = 1;
    private CustomMessageListener htl = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.hti != null) {
                CloudMusicListFragment.this.hti.notifyDataSetChanged();
            }
        }
    };

    public static CloudMusicListFragment a(CloudMusicData.MusicTagList musicTagList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("music_list_key", musicTagList);
        CloudMusicListFragment cloudMusicListFragment = new CloudMusicListFragment();
        cloudMusicListFragment.setArguments(bundle);
        return cloudMusicListFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.fragment_cloud_music_list, viewGroup, false);
        this.htk = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.eDU = (BdListView) inflate.findViewById(e.g.cloud_music_list_view);
        this.hti = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.eDU.setAdapter((ListAdapter) this.hti);
        this.eDU.setExOnSrollToBottomListener(this);
        this.eDU.setDivider(null);
        this.hti.a(this);
        this.bKJ = new PbListView(getPageContext().getPageActivity());
        this.bKJ.oE();
        this.bKJ.ej(e.d.cp_bg_line_d);
        this.bKJ.ek(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0200e.ds200)), NoDataViewFactory.d.ec(e.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.htk != null && this.htj != null && this.htk.page != null) {
            this.tagId = this.htk.tag_id;
            this.cUc = this.htk.page.has_more;
            this.htj.c(this.htk);
        }
        this.eDU.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.kV()) {
                    CloudMusicListFragment.this.htj.a(CloudMusicListFragment.this.hti.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), e.j.neterror);
                }
            }
        });
        registerListener(this.htl);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.kV()) {
            l.showToast(getPageContext().getPageActivity(), e.j.neterror);
        } else if (this.htj != null && this.cUc != 0) {
            this.htj.vU(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bKJ.ek(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.htj = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.htk = musicTagList;
        if (this.hti != null) {
            this.hti.dS(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nT(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void bFU() {
        if (this.bKJ != null) {
            if (this.bKJ.getView().getParent() == null) {
                this.eDU.setNextPage(this.bKJ);
            }
            this.bKJ.setText(getPageContext().getResources().getString(e.j.cloud_music_from_baidu_music));
            this.bKJ.DZ();
        }
        this.cUc = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nU(boolean z) {
        if (this.bKJ != null) {
            if (z) {
                if (this.bKJ.getView().getParent() == null) {
                    this.eDU.setNextPage(this.bKJ);
                }
                this.bKJ.Ed();
                this.bKJ.DY();
                return;
            }
            this.bKJ.DZ();
            this.eDU.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void vR(int i) {
        this.hti.F(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void vS(int i) {
        this.hti.F(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void vT(int i) {
        this.hti.F(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), e.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.htj.brs();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.htj != null) {
            this.htj.aBt();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bGb().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hti != null && this.hti.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hti.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
