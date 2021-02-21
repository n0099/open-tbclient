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
/* loaded from: classes8.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView gAw;
    private BdListView kDK;
    private NoDataView mNoDataView;
    private com.baidu.tieba.video.cloudmusic.a.a nLt;
    private d.a nLu;
    private CloudMusicData.MusicTagList nLv;
    private int tagId = 0;
    private int jWr = 1;
    private CustomMessageListener nLw = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.nLt != null) {
                CloudMusicListFragment.this.nLt.notifyDataSetChanged();
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cloud_music_list, viewGroup, false);
        this.nLv = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.kDK = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.nLt = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.kDK.setAdapter((ListAdapter) this.nLt);
        this.kDK.setExOnSrollToBottomListener(this);
        this.kDK.setDivider(null);
        this.nLt.a(this);
        this.gAw = new PbListView(getPageContext().getPageActivity());
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0201);
        this.gAw.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.pz(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.nLv != null && this.nLu != null && this.nLv.page != null) {
            this.tagId = this.nLv.tag_id;
            this.jWr = this.nLv.page.has_more;
            this.nLu.c(this.nLv);
        }
        this.kDK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.nLu.a(CloudMusicListFragment.this.nLt.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.nLw);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.nLu != null && this.jWr != 0) {
            this.nLu.KA(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.gAw.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.nLu = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.nLv = musicTagList;
        if (this.nLt != null) {
            this.nLt.fX(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void yW(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dSn() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.kDK.setNextPage(this.gAw);
            }
            this.gAw.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.gAw.endLoadData();
        }
        this.jWr = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void yX(boolean z) {
        if (this.gAw != null) {
            if (z) {
                if (this.gAw.getView().getParent() == null) {
                    this.kDK.setNextPage(this.gAw);
                }
                this.gAw.showLoadingViewWithoutEmptyView();
                this.gAw.startLoadData();
                return;
            }
            this.gAw.endLoadData();
            this.kDK.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Kx(int i) {
        this.nLt.ah(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Ky(int i) {
        this.nLt.ah(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Kz(int i) {
        this.nLt.ah(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.nLu.dBV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nLu != null) {
            this.nLu.cFE();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dSu().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.nLt != null && this.nLt.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.nLt.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
