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
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView dpz;
    private BdListView gEo;
    private com.baidu.tieba.video.cloudmusic.a.a jxO;
    private d.a jxP;
    private CloudMusicData.MusicTagList jxQ;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int eKv = 1;
    private CustomMessageListener jxR = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.jxO != null) {
                CloudMusicListFragment.this.jxO.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(R.layout.fragment_cloud_music_list, viewGroup, false);
        this.jxQ = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.gEo = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.jxO = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.gEo.setAdapter((ListAdapter) this.jxO);
        this.gEo.setExOnSrollToBottomListener(this);
        this.gEo.setDivider(null);
        this.jxO.a(this);
        this.dpz = new PbListView(getPageContext().getPageActivity());
        this.dpz.nZ();
        this.dpz.iX(R.color.cp_bg_line_d);
        this.dpz.iY(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.iQ(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.jxQ != null && this.jxP != null && this.jxQ.page != null) {
            this.tagId = this.jxQ.tag_id;
            this.eKv = this.jxQ.page.has_more;
            this.jxP.c(this.jxQ);
        }
        this.gEo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.kc()) {
                    CloudMusicListFragment.this.jxP.a(CloudMusicListFragment.this.jxO.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.jxR);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.kc()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.jxP != null && this.eKv != 0) {
            this.jxP.Ck(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.dpz.iY(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.jxP = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.jxQ = musicTagList;
        if (this.jxO != null) {
            this.jxO.en(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rG(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void cuW() {
        if (this.dpz != null) {
            if (this.dpz.getView().getParent() == null) {
                this.gEo.setNextPage(this.dpz);
            }
            this.dpz.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.dpz.akS();
        }
        this.eKv = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rH(boolean z) {
        if (this.dpz != null) {
            if (z) {
                if (this.dpz.getView().getParent() == null) {
                    this.gEo.setNextPage(this.dpz);
                }
                this.dpz.akX();
                this.dpz.akR();
                return;
            }
            this.dpz.akS();
            this.gEo.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Ch(int i) {
        this.jxO.T(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Ci(int i) {
        this.jxO.T(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Cj(int i) {
        this.jxO.T(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.jxP.chs();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jxP != null) {
            this.jxP.bpq();
        }
        com.baidu.tieba.video.cloudmusic.data.a.cvd().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.jxO != null && this.jxO.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.jxO.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
