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
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView btv;
    private BdListView efL;
    private com.baidu.tieba.video.cloudmusic.a.a gWX;
    private d.a gWY;
    private CloudMusicData.MusicTagList gWZ;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int cEr = 1;
    private CustomMessageListener gXa = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.gWX != null) {
                CloudMusicListFragment.this.gWX.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(d.i.fragment_cloud_music_list, viewGroup, false);
        this.gWZ = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.efL = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.gWX = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.efL.setAdapter((ListAdapter) this.gWX);
        this.efL.setExOnSrollToBottomListener(this);
        this.efL.setDivider(null);
        this.gWX.a(this);
        this.btv = new PbListView(getPageContext().getPageActivity());
        this.btv.nn();
        this.btv.dx(d.C0141d.cp_bg_line_d);
        this.btv.dy(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.dr(d.k.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.gWZ != null && this.gWY != null && this.gWZ.page != null) {
            this.tagId = this.gWZ.tag_id;
            this.cEr = this.gWZ.page.has_more;
            this.gWY.c(this.gWZ);
        }
        this.efL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.jD()) {
                    CloudMusicListFragment.this.gWY.a(CloudMusicListFragment.this.gWX.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), d.k.neterror);
                }
            }
        });
        registerListener(this.gXa);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.jD()) {
            l.showToast(getPageContext().getPageActivity(), d.k.neterror);
        } else if (this.gWY != null && this.cEr != 0) {
            this.gWY.ux(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.btv.dy(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.gWY = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.gWZ = musicTagList;
        if (this.gWX != null) {
            this.gWX.dG(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mX(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void bBf() {
        if (this.btv != null) {
            if (this.btv.getView().getParent() == null) {
                this.efL.setNextPage(this.btv);
            }
            this.btv.setText(getPageContext().getResources().getString(d.k.cloud_music_from_baidu_music));
            this.btv.As();
        }
        this.cEr = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mY(boolean z) {
        if (this.btv != null) {
            if (z) {
                if (this.btv.getView().getParent() == null) {
                    this.efL.setNextPage(this.btv);
                }
                this.btv.Aw();
                this.btv.Ar();
                return;
            }
            this.btv.As();
            this.efL.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uu(int i) {
        this.gWX.F(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uv(int i) {
        this.gWX.F(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uw(int i) {
        this.gWX.F(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.k.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gWY.bnh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gWY != null) {
            this.gWY.avk();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bBm().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.gWX != null && this.gWX.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.gWX.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
