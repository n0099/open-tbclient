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
/* loaded from: classes10.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView fbY;
    private BdListView ivu;
    private com.baidu.tieba.video.cloudmusic.a.a lAn;
    private d.a lAo;
    private CloudMusicData.MusicTagList lAp;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int hTD = 1;
    private CustomMessageListener lAq = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.lAn != null) {
                CloudMusicListFragment.this.lAn.notifyDataSetChanged();
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
        this.lAp = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.ivu = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.lAn = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.ivu.setAdapter((ListAdapter) this.lAn);
        this.ivu.setExOnSrollToBottomListener(this);
        this.ivu.setDivider(null);
        this.lAn.a(this);
        this.fbY = new PbListView(getPageContext().getPageActivity());
        this.fbY.createView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fbY.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.lT(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.lAp != null && this.lAo != null && this.lAp.page != null) {
            this.tagId = this.lAp.tag_id;
            this.hTD = this.lAp.page.has_more;
            this.lAo.c(this.lAp);
        }
        this.ivu.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.lAo.a(CloudMusicListFragment.this.lAn.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.lAq);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.lAo != null && this.hTD != 0) {
            this.lAo.ET(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.fbY.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.lAo = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.lAp = musicTagList;
        if (this.lAn != null) {
            this.lAn.eK(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uR(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dhS() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.ivu.setNextPage(this.fbY);
            }
            this.fbY.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.fbY.endLoadData();
        }
        this.hTD = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uS(boolean z) {
        if (this.fbY != null) {
            if (z) {
                if (this.fbY.getView().getParent() == null) {
                    this.ivu.setNextPage(this.fbY);
                }
                this.fbY.showLoadingViewWithoutEmptyView();
                this.fbY.startLoadData();
                return;
            }
            this.fbY.endLoadData();
            this.ivu.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void EQ(int i) {
        this.lAn.ac(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ER(int i) {
        this.lAn.ac(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ES(int i) {
        this.lAn.ac(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.lAo.cSS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lAo != null) {
            this.lAo.bXE();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dhZ().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.lAn != null && this.lAn.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.lAn.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
