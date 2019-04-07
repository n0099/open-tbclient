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
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView dbr;
    private BdListView gee;
    private com.baidu.tieba.video.cloudmusic.a.a iVb;
    private d.a iVc;
    private CloudMusicData.MusicTagList iVd;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int enY = 1;
    private CustomMessageListener iVe = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.iVb != null) {
                CloudMusicListFragment.this.iVb.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(d.h.fragment_cloud_music_list, viewGroup, false);
        this.iVd = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.gee = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.iVb = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.gee.setAdapter((ListAdapter) this.iVb);
        this.gee.setExOnSrollToBottomListener(this);
        this.gee.setDivider(null);
        this.iVb.a(this);
        this.dbr = new PbListView(getPageContext().getPageActivity());
        this.dbr.oM();
        this.dbr.ia(d.C0277d.cp_bg_line_d);
        this.dbr.ib(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.hT(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.iVd != null && this.iVc != null && this.iVd.page != null) {
            this.tagId = this.iVd.tag_id;
            this.enY = this.iVd.page.has_more;
            this.iVc.c(this.iVd);
        }
        this.gee.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.kY()) {
                    CloudMusicListFragment.this.iVc.a(CloudMusicListFragment.this.iVb.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.iVe);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.kY()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.iVc != null && this.enY != 0) {
            this.iVc.Ap(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.dbr.ib(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.iVc = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.iVd = musicTagList;
        if (this.iVb != null) {
            this.iVb.eb(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void qz(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ciV() {
        if (this.dbr != null) {
            if (this.dbr.getView().getParent() == null) {
                this.gee.setNextPage(this.dbr);
            }
            this.dbr.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.dbr.aeA();
        }
        this.enY = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void qA(boolean z) {
        if (this.dbr != null) {
            if (z) {
                if (this.dbr.getView().getParent() == null) {
                    this.gee.setNextPage(this.dbr);
                }
                this.dbr.aeF();
                this.dbr.aez();
                return;
            }
            this.dbr.aeA();
            this.gee.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Am(int i) {
        this.iVb.L(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void An(int i) {
        this.iVb.L(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Ao(int i) {
        this.iVb.L(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.iVc.bVq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iVc != null) {
            this.iVc.beW();
        }
        com.baidu.tieba.video.cloudmusic.data.a.cjc().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.iVb != null && this.iVb.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.iVb.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
