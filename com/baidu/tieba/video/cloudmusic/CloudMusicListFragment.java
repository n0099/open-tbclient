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
    private PbListView gdy;
    private BdListView jTd;
    private NoDataView mNoDataView;
    private d.a ngA;
    private CloudMusicData.MusicTagList ngB;
    private com.baidu.tieba.video.cloudmusic.a.a ngz;
    private int tagId = 0;
    private int jlH = 1;
    private CustomMessageListener ngC = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.ngz != null) {
                CloudMusicListFragment.this.ngz.notifyDataSetChanged();
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
        this.ngB = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.jTd = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.ngz = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.jTd.setAdapter((ListAdapter) this.ngz);
        this.jTd.setExOnSrollToBottomListener(this);
        this.jTd.setDivider(null);
        this.ngz.a(this);
        this.gdy = new PbListView(getPageContext().getPageActivity());
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.gdy.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.pG(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.ngB != null && this.ngA != null && this.ngB.page != null) {
            this.tagId = this.ngB.tag_id;
            this.jlH = this.ngB.page.has_more;
            this.ngA.c(this.ngB);
        }
        this.jTd.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.ngA.a(CloudMusicListFragment.this.ngz.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.ngC);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.ngA != null && this.jlH != 0) {
            this.ngA.Kr(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.gdy.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.ngA = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.ngB = musicTagList;
        if (this.ngz != null) {
            this.ngz.fI(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void xJ(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dMa() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.jTd.setNextPage(this.gdy);
            }
            this.gdy.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.gdy.endLoadData();
        }
        this.jlH = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void xK(boolean z) {
        if (this.gdy != null) {
            if (z) {
                if (this.gdy.getView().getParent() == null) {
                    this.jTd.setNextPage(this.gdy);
                }
                this.gdy.showLoadingViewWithoutEmptyView();
                this.gdy.startLoadData();
                return;
            }
            this.gdy.endLoadData();
            this.jTd.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Ko(int i) {
        this.ngz.aj(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Kp(int i) {
        this.ngz.aj(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Kq(int i) {
        this.ngz.aj(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.ngA.dwm();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ngA != null) {
            this.ngA.cyM();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dMh().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.ngz != null && this.ngz.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.ngz.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
