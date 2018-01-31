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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.e;
/* loaded from: classes2.dex */
public class a extends BaseFragment implements BdListView.f, a.b, e.b {
    private PbListView bYZ;
    private BdListView euz;
    private com.baidu.tieba.video.cloudmusic.a.a hnk;
    private e.a hnl;
    private CloudMusicData.MusicTagList hnm;
    private h mNoDataView;
    private int tagId = 0;
    private int dak = 1;
    private CustomMessageListener hnn = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.hnk != null) {
                a.this.hnk.notifyDataSetChanged();
            }
        }
    };

    public static a a(CloudMusicData.MusicTagList musicTagList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("music_list_key", musicTagList);
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_cloud_music_list, viewGroup, false);
        this.hnm = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.euz = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.hnk = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.euz.setAdapter((ListAdapter) this.hnk);
        this.euz.setExOnSrollToBottomListener(this);
        this.euz.setDivider(null);
        this.hnk.a(this);
        this.bYZ = new PbListView(getPageContext().getPageActivity());
        this.bYZ.sv();
        this.bYZ.gu(d.C0108d.cp_bg_line_d);
        this.bYZ.gv(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.gn(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hnm != null && this.hnl != null && this.hnm.page != null) {
            this.tagId = this.hnm.tag_id;
            this.dak = this.hnm.page.has_more;
            this.hnl.c(this.hnm);
        }
        this.euz.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.oJ()) {
                    a.this.hnl.a(a.this.hnk.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.hnn);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.oJ()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.hnl != null && this.dak != 0) {
            this.hnl.wJ(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bYZ.gv(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.hnl = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hnm = musicTagList;
        if (this.hnk != null) {
            this.hnk.dB(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nb(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void bAh() {
        if (this.bYZ != null) {
            if (this.bYZ.getView().getParent() == null) {
                this.euz.setNextPage(this.bYZ);
            }
            this.bYZ.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.bYZ.DN();
        }
        this.dak = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nc(boolean z) {
        if (this.bYZ != null) {
            if (z) {
                if (this.bYZ.getView().getParent() == null) {
                    this.euz.setNextPage(this.bYZ);
                }
                this.bYZ.DQ();
                this.bYZ.DM();
                return;
            }
            this.bYZ.DN();
            this.euz.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wG(int i) {
        this.hnk.O(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wH(int i) {
        this.hnk.O(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wI(int i) {
        this.hnk.O(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hnl.blQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hnl != null) {
            this.hnl.avS();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bAo().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hnk != null && this.hnk.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hnk.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
