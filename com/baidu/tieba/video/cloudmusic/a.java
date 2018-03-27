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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.e;
/* loaded from: classes2.dex */
public class a extends BaseFragment implements BdListView.f, a.b, e.b {
    private PbListView cbb;
    private BdListView eyR;
    private com.baidu.tieba.video.cloudmusic.a.a hoK;
    private e.a hoL;
    private CloudMusicData.MusicTagList hoM;
    private h mNoDataView;
    private int tagId = 0;
    private int dcP = 1;
    private CustomMessageListener hoN = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.hoK != null) {
                a.this.hoK.notifyDataSetChanged();
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
        this.hoM = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.eyR = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.hoK = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.eyR.setAdapter((ListAdapter) this.hoK);
        this.eyR.setExOnSrollToBottomListener(this);
        this.eyR.setDivider(null);
        this.hoK.a(this);
        this.cbb = new PbListView(getPageContext().getPageActivity());
        this.cbb.st();
        this.cbb.gw(d.C0141d.cp_bg_line_d);
        this.cbb.gx(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.gp(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hoM != null && this.hoL != null && this.hoM.page != null) {
            this.tagId = this.hoM.tag_id;
            this.dcP = this.hoM.page.has_more;
            this.hoL.c(this.hoM);
        }
        this.eyR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.oJ()) {
                    a.this.hoL.a(a.this.hoK.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.hoN);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.oJ()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.hoL != null && this.dcP != 0) {
            this.hoL.wJ(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.cbb.gx(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.hoL = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hoM = musicTagList;
        if (this.hoK != null) {
            this.hoK.dH(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void no(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void bAV() {
        if (this.cbb != null) {
            if (this.cbb.getView().getParent() == null) {
                this.eyR.setNextPage(this.cbb);
            }
            this.cbb.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.cbb.Eh();
        }
        this.dcP = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void np(boolean z) {
        if (this.cbb != null) {
            if (z) {
                if (this.cbb.getView().getParent() == null) {
                    this.eyR.setNextPage(this.cbb);
                }
                this.cbb.Ek();
                this.cbb.Eg();
                return;
            }
            this.cbb.Eh();
            this.eyR.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wG(int i) {
        this.hoK.U(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wH(int i) {
        this.hoK.U(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wI(int i) {
        this.hoK.U(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hoL.bnd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hoL != null) {
            this.hoL.awQ();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bBc().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hoK != null && this.hoK.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hoK.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
