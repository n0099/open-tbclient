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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.e;
/* loaded from: classes2.dex */
public class a extends BaseFragment implements BdListView.f, a.b, e.b {
    private PbListView bgb;
    private BdListView bmN;
    private com.baidu.tieba.video.cloudmusic.a.a gud;
    private e.a gue;
    private CloudMusicData.MusicTagList guf;
    private f mNoDataView;
    private int gug = 0;
    private int bQo = 1;
    private CustomMessageListener guh = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.gud != null) {
                a.this.gud.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(d.j.fragment_cloud_music_list, viewGroup, false);
        this.guf = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.bmN = (BdListView) inflate.findViewById(d.h.cloud_music_list_view);
        this.gud = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.bmN.setAdapter((ListAdapter) this.gud);
        this.bmN.setExOnSrollToBottomListener(this);
        this.bmN.setDivider(null);
        this.gud.a(this);
        this.bgb = new PbListView(getPageContext().getPageActivity());
        this.bgb.ld();
        this.bgb.dy(d.e.cp_bg_line_d);
        this.bgb.dz(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.f.ds200)), NoDataViewFactory.d.dq(d.l.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.guf != null && this.gue != null && this.guf.page != null) {
            this.gug = this.guf.tag_id;
            this.bQo = this.guf.page.has_more;
            this.gue.c(this.guf);
        }
        this.bmN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.hh()) {
                    a.this.gue.a(a.this.gud.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.l.neterror);
                }
            }
        });
        registerListener(this.guh);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.hh()) {
            l.showToast(getPageContext().getPageActivity(), d.l.neterror);
        } else if (this.gue != null && this.bQo != 0) {
            this.gue.uu(this.gug);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bgb.dz(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.gue = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.guf = musicTagList;
        if (this.gud != null) {
            this.gud.dy(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void mZ(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void bvu() {
        if (this.bgb != null) {
            if (this.bgb.getView().getParent() == null) {
                this.bmN.setNextPage(this.bgb);
            }
            this.bgb.setText(getPageContext().getResources().getString(d.l.cloud_music_from_baidu_music));
            this.bgb.wu();
        }
        this.bQo = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void na(boolean z) {
        if (this.bgb != null) {
            if (z) {
                if (this.bgb.getView().getParent() == null) {
                    this.bmN.setNextPage(this.bgb);
                }
                this.bgb.wy();
                this.bgb.wt();
                return;
            }
            this.bgb.wu();
            this.bmN.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void ur(int i) {
        this.gud.C(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void us(int i) {
        this.gud.C(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void ut(int i) {
        this.gud.C(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.l.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gue.bfp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gue != null) {
            this.gue.aiD();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bvB().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void b(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.gud != null && this.gud.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.gud.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
