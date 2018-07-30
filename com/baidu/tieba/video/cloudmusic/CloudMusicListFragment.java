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
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView bvA;
    private BdListView enw;
    private com.baidu.tieba.video.cloudmusic.a.a hcp;
    private d.a hcq;
    private CloudMusicData.MusicTagList hcr;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int cEP = 1;
    private CustomMessageListener hcs = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.hcp != null) {
                CloudMusicListFragment.this.hcp.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(d.h.fragment_cloud_music_list, viewGroup, false);
        this.hcr = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.enw = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.hcp = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.enw.setAdapter((ListAdapter) this.hcp);
        this.enw.setExOnSrollToBottomListener(this);
        this.enw.setDivider(null);
        this.hcp.a(this);
        this.bvA = new PbListView(getPageContext().getPageActivity());
        this.bvA.np();
        this.bvA.dB(d.C0140d.cp_bg_line_d);
        this.bvA.dC(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.du(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hcr != null && this.hcq != null && this.hcr.page != null) {
            this.tagId = this.hcr.tag_id;
            this.cEP = this.hcr.page.has_more;
            this.hcq.c(this.hcr);
        }
        this.enw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.jE()) {
                    CloudMusicListFragment.this.hcq.a(CloudMusicListFragment.this.hcp.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.hcs);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.jE()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.hcq != null && this.cEP != 0) {
            this.hcq.uE(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bvA.dC(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.hcq = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hcr = musicTagList;
        if (this.hcp != null) {
            this.hcp.dF(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mR(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void bAq() {
        if (this.bvA != null) {
            if (this.bvA.getView().getParent() == null) {
                this.enw.setNextPage(this.bvA);
            }
            this.bvA.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.bvA.Ay();
        }
        this.cEP = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mS(boolean z) {
        if (this.bvA != null) {
            if (z) {
                if (this.bvA.getView().getParent() == null) {
                    this.enw.setNextPage(this.bvA);
                }
                this.bvA.AD();
                this.bvA.Ax();
                return;
            }
            this.bvA.Ay();
            this.enw.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uB(int i) {
        this.hcp.E(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uC(int i) {
        this.hcp.E(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uD(int i) {
        this.hcp.E(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hcq.bme();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hcq != null) {
            this.hcq.aws();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bAx().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hcp != null && this.hcp.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hcp.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
