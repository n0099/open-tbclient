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
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView dwJ;
    private BdListView gCo;
    private com.baidu.tieba.video.cloudmusic.a.a jxG;
    private d.a jxH;
    private CloudMusicData.MusicTagList jxI;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int eTa = 1;
    private CustomMessageListener jxJ = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.jxG != null) {
                CloudMusicListFragment.this.jxG.notifyDataSetChanged();
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
        this.jxI = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.gCo = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.jxG = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.gCo.setAdapter((ListAdapter) this.jxG);
        this.gCo.setExOnSrollToBottomListener(this);
        this.gCo.setDivider(null);
        this.jxG.a(this);
        this.dwJ = new PbListView(getPageContext().getPageActivity());
        this.dwJ.createView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.dwJ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.iL(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.jxI != null && this.jxH != null && this.jxI.page != null) {
            this.tagId = this.jxI.tag_id;
            this.eTa = this.jxI.page.has_more;
            this.jxH.c(this.jxI);
        }
        this.gCo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.jxH.a(CloudMusicListFragment.this.jxG.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.jxJ);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.jxH != null && this.eTa != 0) {
            this.jxH.AQ(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.dwJ.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.jxH = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.jxI = musicTagList;
        if (this.jxG != null) {
            this.jxG.eA(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rp(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void csL() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.gCo.setNextPage(this.dwJ);
            }
            this.dwJ.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.dwJ.endLoadData();
        }
        this.eTa = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rq(boolean z) {
        if (this.dwJ != null) {
            if (z) {
                if (this.dwJ.getView().getParent() == null) {
                    this.gCo.setNextPage(this.dwJ);
                }
                this.dwJ.showLoadingViewWithoutEmptyView();
                this.dwJ.startLoadData();
                return;
            }
            this.dwJ.endLoadData();
            this.gCo.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void AN(int i) {
        this.jxG.R(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void AO(int i) {
        this.jxG.R(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void AP(int i) {
        this.jxG.R(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.jxH.cer();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jxH != null) {
            this.jxH.bmv();
        }
        com.baidu.tieba.video.cloudmusic.data.a.csS().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.jxG != null && this.jxG.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.jxG.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
