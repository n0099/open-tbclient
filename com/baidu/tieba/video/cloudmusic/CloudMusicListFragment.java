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
    private PbListView elj;
    private BdListView hvg;
    private com.baidu.tieba.video.cloudmusic.a.a kvt;
    private d.a kvu;
    private CloudMusicData.MusicTagList kvv;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int gTA = 1;
    private CustomMessageListener kvw = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.kvt != null) {
                CloudMusicListFragment.this.kvt.notifyDataSetChanged();
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
        this.kvv = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.hvg = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.kvt = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.hvg.setAdapter((ListAdapter) this.kvt);
        this.hvg.setExOnSrollToBottomListener(this);
        this.hvg.setDivider(null);
        this.kvt.a(this);
        this.elj = new PbListView(getPageContext().getPageActivity());
        this.elj.createView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.elj.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.lh(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.kvv != null && this.kvu != null && this.kvv.page != null) {
            this.tagId = this.kvv.tag_id;
            this.gTA = this.kvv.page.has_more;
            this.kvu.c(this.kvv);
        }
        this.hvg.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.kvu.a(CloudMusicListFragment.this.kvt.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.kvw);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.kvu != null && this.gTA != 0) {
            this.kvu.Dw(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.elj.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.kvu = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.kvv = musicTagList;
        if (this.kvt != null) {
            this.kvt.eo(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void tm(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void cPp() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.hvg.setNextPage(this.elj);
            }
            this.elj.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.elj.endLoadData();
        }
        this.gTA = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void tn(boolean z) {
        if (this.elj != null) {
            if (z) {
                if (this.elj.getView().getParent() == null) {
                    this.hvg.setNextPage(this.elj);
                }
                this.elj.showLoadingViewWithoutEmptyView();
                this.elj.startLoadData();
                return;
            }
            this.elj.endLoadData();
            this.hvg.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Dt(int i) {
        this.kvt.S(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Du(int i) {
        this.kvt.S(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Dv(int i) {
        this.kvt.S(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.kvu.cAO();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kvu != null) {
            this.kvu.bGv();
        }
        com.baidu.tieba.video.cloudmusic.data.a.cPw().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.kvt != null && this.kvt.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.kvt.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
