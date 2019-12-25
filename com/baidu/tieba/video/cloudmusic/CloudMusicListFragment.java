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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes7.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView egU;
    private BdListView hpC;
    private com.baidu.tieba.video.cloudmusic.a.a kqM;
    private d.a kqN;
    private CloudMusicData.MusicTagList kqO;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int gOe = 1;
    private CustomMessageListener kqP = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.kqM != null) {
                CloudMusicListFragment.this.kqM.notifyDataSetChanged();
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

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cloud_music_list, viewGroup, false);
        this.kqO = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.hpC = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.kqM = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.hpC.setAdapter((ListAdapter) this.kqM);
        this.hpC.setExOnSrollToBottomListener(this);
        this.hpC.setDivider(null);
        this.kqM.a(this);
        this.egU = new PbListView(getPageContext().getPageActivity());
        this.egU.createView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.egU.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.kQ(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.kqO != null && this.kqN != null && this.kqO.page != null) {
            this.tagId = this.kqO.tag_id;
            this.gOe = this.kqO.page.has_more;
            this.kqN.c(this.kqO);
        }
        this.hpC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.kqN.a(CloudMusicListFragment.this.kqM.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.kqP);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.kqN != null && this.gOe != 0) {
            this.kqN.Dk(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.egU.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.kqN = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.kqO = musicTagList;
        if (this.kqM != null) {
            this.kqM.es(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void sW(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void cML() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.hpC.setNextPage(this.egU);
            }
            this.egU.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.egU.endLoadData();
        }
        this.gOe = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void sX(boolean z) {
        if (this.egU != null) {
            if (z) {
                if (this.egU.getView().getParent() == null) {
                    this.hpC.setNextPage(this.egU);
                }
                this.egU.showLoadingViewWithoutEmptyView();
                this.egU.startLoadData();
                return;
            }
            this.egU.endLoadData();
            this.hpC.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Dh(int i) {
        this.kqM.T(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Di(int i) {
        this.kqM.T(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Dj(int i) {
        this.kqM.T(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.kqN.cyi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kqN != null) {
            this.kqN.bDP();
        }
        com.baidu.tieba.video.cloudmusic.data.a.cMS().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.kqM != null && this.kqM.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.kqM.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
