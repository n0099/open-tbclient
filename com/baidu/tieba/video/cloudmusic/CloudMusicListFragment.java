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
    private PbListView dnG;
    private BdListView gBF;
    private com.baidu.tieba.video.cloudmusic.a.a jul;
    private d.a jum;
    private CloudMusicData.MusicTagList jun;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int eIF = 1;
    private CustomMessageListener juo = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.jul != null) {
                CloudMusicListFragment.this.jul.notifyDataSetChanged();
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
        this.jun = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.gBF = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.jul = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.gBF.setAdapter((ListAdapter) this.jul);
        this.gBF.setExOnSrollToBottomListener(this);
        this.gBF.setDivider(null);
        this.jul.a(this);
        this.dnG = new PbListView(getPageContext().getPageActivity());
        this.dnG.nZ();
        this.dnG.iU(R.color.cp_bg_line_d);
        this.dnG.iV(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.iN(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.jun != null && this.jum != null && this.jun.page != null) {
            this.tagId = this.jun.tag_id;
            this.eIF = this.jun.page.has_more;
            this.jum.c(this.jun);
        }
        this.gBF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.kc()) {
                    CloudMusicListFragment.this.jum.a(CloudMusicListFragment.this.jul.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.juo);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.kc()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.jum != null && this.eIF != 0) {
            this.jum.Ce(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.dnG.iV(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.jum = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.jun = musicTagList;
        if (this.jul != null) {
            this.jul.eo(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rC(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ctM() {
        if (this.dnG != null) {
            if (this.dnG.getView().getParent() == null) {
                this.gBF.setNextPage(this.dnG);
            }
            this.dnG.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.dnG.akE();
        }
        this.eIF = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rD(boolean z) {
        if (this.dnG != null) {
            if (z) {
                if (this.dnG.getView().getParent() == null) {
                    this.gBF.setNextPage(this.dnG);
                }
                this.dnG.akJ();
                this.dnG.akD();
                return;
            }
            this.dnG.akE();
            this.gBF.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Cb(int i) {
        this.jul.S(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Cc(int i) {
        this.jul.S(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Cd(int i) {
        this.jul.S(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.jum.cgm();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jum != null) {
            this.jum.bos();
        }
        com.baidu.tieba.video.cloudmusic.data.a.ctT().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.jul != null && this.jul.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.jul.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
