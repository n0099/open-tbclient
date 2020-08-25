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
/* loaded from: classes17.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView fDW;
    private BdListView jiX;
    private NoDataView mNoDataView;
    private com.baidu.tieba.video.cloudmusic.a.a mui;
    private d.a muj;
    private CloudMusicData.MusicTagList muk;
    private int tagId = 0;
    private int iCU = 1;
    private CustomMessageListener mul = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.mui != null) {
                CloudMusicListFragment.this.mui.notifyDataSetChanged();
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
        this.muk = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.jiX = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.mui = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.jiX.setAdapter((ListAdapter) this.mui);
        this.jiX.setExOnSrollToBottomListener(this);
        this.jiX.setDivider(null);
        this.mui.a(this);
        this.fDW = new PbListView(getPageContext().getPageActivity());
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fDW.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.oK(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.muk != null && this.muj != null && this.muk.page != null) {
            this.tagId = this.muk.tag_id;
            this.iCU = this.muk.page.has_more;
            this.muj.c(this.muk);
        }
        this.jiX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.muj.a(CloudMusicListFragment.this.mui.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.mul);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.muj != null && this.iCU != 0) {
            this.muj.IP(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.fDW.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.muj = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.muk = musicTagList;
        if (this.mui != null) {
            this.mui.fn(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wA(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dBd() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.jiX.setNextPage(this.fDW);
            }
            this.fDW.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.fDW.endLoadData();
        }
        this.iCU = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wB(boolean z) {
        if (this.fDW != null) {
            if (z) {
                if (this.fDW.getView().getParent() == null) {
                    this.jiX.setNextPage(this.fDW);
                }
                this.fDW.showLoadingViewWithoutEmptyView();
                this.fDW.startLoadData();
                return;
            }
            this.fDW.endLoadData();
            this.jiX.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void IM(int i) {
        this.mui.ag(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void IN(int i) {
        this.mui.ag(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void IO(int i) {
        this.mui.ag(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.muj.dlK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.muj != null) {
            this.muj.coU();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dBk().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.mui != null && this.mui.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.mui.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
