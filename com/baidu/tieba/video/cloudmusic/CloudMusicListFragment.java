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
/* loaded from: classes23.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView gjo;
    private BdListView jYZ;
    private NoDataView mNoDataView;
    private com.baidu.tieba.video.cloudmusic.a.a nmv;
    private d.a nmw;
    private CloudMusicData.MusicTagList nmx;
    private int tagId = 0;
    private int jrF = 1;
    private CustomMessageListener nmy = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.nmv != null) {
                CloudMusicListFragment.this.nmv.notifyDataSetChanged();
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
        this.nmx = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.jYZ = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.nmv = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.jYZ.setAdapter((ListAdapter) this.nmv);
        this.jYZ.setExOnSrollToBottomListener(this);
        this.jYZ.setDivider(null);
        this.nmv.a(this);
        this.gjo = new PbListView(getPageContext().getPageActivity());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.gjo.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.pQ(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.nmx != null && this.nmw != null && this.nmx.page != null) {
            this.tagId = this.nmx.tag_id;
            this.jrF = this.nmx.page.has_more;
            this.nmw.c(this.nmx);
        }
        this.jYZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.nmw.a(CloudMusicListFragment.this.nmv.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.nmy);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.nmw != null && this.jrF != 0) {
            this.nmw.KE(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.gjo.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.nmw = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.nmx = musicTagList;
        if (this.nmv != null) {
            this.nmv.fQ(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void xS(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dOC() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.jYZ.setNextPage(this.gjo);
            }
            this.gjo.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.gjo.endLoadData();
        }
        this.jrF = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void xT(boolean z) {
        if (this.gjo != null) {
            if (z) {
                if (this.gjo.getView().getParent() == null) {
                    this.jYZ.setNextPage(this.gjo);
                }
                this.gjo.showLoadingViewWithoutEmptyView();
                this.gjo.startLoadData();
                return;
            }
            this.gjo.endLoadData();
            this.jYZ.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void KB(int i) {
        this.nmv.aj(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void KC(int i) {
        this.nmv.aj(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void KD(int i) {
        this.nmv.aj(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.nmw.dyO();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nmw != null) {
            this.nmw.cBn();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dOJ().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.nmv != null && this.nmv.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.nmv.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
