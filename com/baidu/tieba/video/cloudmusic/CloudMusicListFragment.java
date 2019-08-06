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
    private PbListView dnN;
    private BdListView gCx;
    private com.baidu.tieba.video.cloudmusic.a.a jvs;
    private d.a jvt;
    private CloudMusicData.MusicTagList jvu;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int eIM = 1;
    private CustomMessageListener jvv = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.jvs != null) {
                CloudMusicListFragment.this.jvs.notifyDataSetChanged();
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
        this.jvu = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.gCx = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.jvs = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.gCx.setAdapter((ListAdapter) this.jvs);
        this.gCx.setExOnSrollToBottomListener(this);
        this.gCx.setDivider(null);
        this.jvs.a(this);
        this.dnN = new PbListView(getPageContext().getPageActivity());
        this.dnN.nZ();
        this.dnN.iU(R.color.cp_bg_line_d);
        this.dnN.iV(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.iN(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.jvu != null && this.jvt != null && this.jvu.page != null) {
            this.tagId = this.jvu.tag_id;
            this.eIM = this.jvu.page.has_more;
            this.jvt.c(this.jvu);
        }
        this.gCx.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.kc()) {
                    CloudMusicListFragment.this.jvt.a(CloudMusicListFragment.this.jvs.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.jvv);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.kc()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.jvt != null && this.eIM != 0) {
            this.jvt.Cg(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.dnN.iV(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.jvt = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.jvu = musicTagList;
        if (this.jvs != null) {
            this.jvs.en(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rD(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void cui() {
        if (this.dnN != null) {
            if (this.dnN.getView().getParent() == null) {
                this.gCx.setNextPage(this.dnN);
            }
            this.dnN.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.dnN.akG();
        }
        this.eIM = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rE(boolean z) {
        if (this.dnN != null) {
            if (z) {
                if (this.dnN.getView().getParent() == null) {
                    this.gCx.setNextPage(this.dnN);
                }
                this.dnN.akL();
                this.dnN.akF();
                return;
            }
            this.dnN.akG();
            this.gCx.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Cd(int i) {
        this.jvs.S(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Ce(int i) {
        this.jvs.S(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Cf(int i) {
        this.jvs.S(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.jvt.cgE();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jvt != null) {
            this.jvt.boF();
        }
        com.baidu.tieba.video.cloudmusic.data.a.cup().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.jvs != null && this.jvs.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.jvs.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
