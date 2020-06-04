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
    private PbListView fcj;
    private BdListView iwh;
    private com.baidu.tieba.video.cloudmusic.a.a lBw;
    private d.a lBx;
    private CloudMusicData.MusicTagList lBy;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int hUq = 1;
    private CustomMessageListener lBz = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.lBw != null) {
                CloudMusicListFragment.this.lBw.notifyDataSetChanged();
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
        this.lBy = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.iwh = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.lBw = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.iwh.setAdapter((ListAdapter) this.lBw);
        this.iwh.setExOnSrollToBottomListener(this);
        this.iwh.setDivider(null);
        this.lBw.a(this);
        this.fcj = new PbListView(getPageContext().getPageActivity());
        this.fcj.createView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fcj.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.lV(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.lBy != null && this.lBx != null && this.lBy.page != null) {
            this.tagId = this.lBy.tag_id;
            this.hUq = this.lBy.page.has_more;
            this.lBx.c(this.lBy);
        }
        this.iwh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.lBx.a(CloudMusicListFragment.this.lBw.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.lBz);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.lBx != null && this.hUq != 0) {
            this.lBx.EV(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.fcj.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.lBx = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.lBy = musicTagList;
        if (this.lBw != null) {
            this.lBw.eM(musicTagList.music_list);
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
    public void dih() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.iwh.setNextPage(this.fcj);
            }
            this.fcj.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.fcj.endLoadData();
        }
        this.hUq = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uS(boolean z) {
        if (this.fcj != null) {
            if (z) {
                if (this.fcj.getView().getParent() == null) {
                    this.iwh.setNextPage(this.fcj);
                }
                this.fcj.showLoadingViewWithoutEmptyView();
                this.fcj.startLoadData();
                return;
            }
            this.fcj.endLoadData();
            this.iwh.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ES(int i) {
        this.lBw.ac(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ET(int i) {
        this.lBw.ac(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void EU(int i) {
        this.lBw.ac(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.lBx.cTi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lBx != null) {
            this.lBx.bXG();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dio().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.lBw != null && this.lBw.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.lBw.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
