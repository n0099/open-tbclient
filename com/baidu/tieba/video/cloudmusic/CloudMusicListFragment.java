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
    private PbListView bJY;
    private BdListView eCA;
    private CloudMusicData.MusicTagList hrA;
    private com.baidu.tieba.video.cloudmusic.a.a hry;
    private d.a hrz;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int cSW = 1;
    private CustomMessageListener hrB = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.hry != null) {
                CloudMusicListFragment.this.hry.notifyDataSetChanged();
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
        this.hrA = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.eCA = (BdListView) inflate.findViewById(e.g.cloud_music_list_view);
        this.hry = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.eCA.setAdapter((ListAdapter) this.hry);
        this.eCA.setExOnSrollToBottomListener(this);
        this.eCA.setDivider(null);
        this.hry.a(this);
        this.bJY = new PbListView(getPageContext().getPageActivity());
        this.bJY.oG();
        this.bJY.dV(e.d.cp_bg_line_d);
        this.bJY.dW(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0175e.ds200)), NoDataViewFactory.d.dO(e.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hrA != null && this.hrz != null && this.hrA.page != null) {
            this.tagId = this.hrA.tag_id;
            this.cSW = this.hrA.page.has_more;
            this.hrz.c(this.hrA);
        }
        this.eCA.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.kX()) {
                    CloudMusicListFragment.this.hrz.a(CloudMusicListFragment.this.hry.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), e.j.neterror);
                }
            }
        });
        registerListener(this.hrB);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.kX()) {
            l.showToast(getPageContext().getPageActivity(), e.j.neterror);
        } else if (this.hrz != null && this.cSW != 0) {
            this.hrz.vB(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bJY.dW(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.hrz = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hrA = musicTagList;
        if (this.hry != null) {
            this.hry.dU(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nF(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void bGv() {
        if (this.bJY != null) {
            if (this.bJY.getView().getParent() == null) {
                this.eCA.setNextPage(this.bJY);
            }
            this.bJY.setText(getPageContext().getResources().getString(e.j.cloud_music_from_baidu_music));
            this.bJY.DP();
        }
        this.cSW = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nG(boolean z) {
        if (this.bJY != null) {
            if (z) {
                if (this.bJY.getView().getParent() == null) {
                    this.eCA.setNextPage(this.bJY);
                }
                this.bJY.DT();
                this.bJY.DO();
                return;
            }
            this.bJY.DP();
            this.eCA.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void vy(int i) {
        this.hry.F(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void vz(int i) {
        this.hry.F(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void vA(int i) {
        this.hry.F(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), e.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hrz.brW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hrz != null) {
            this.hrz.aBV();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bGC().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hry != null && this.hry.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hry.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
