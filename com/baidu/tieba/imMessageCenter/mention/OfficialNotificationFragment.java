package com.baidu.tieba.imMessageCenter.mention;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
import d.b.c.a.e;
import d.b.c.e.p.k;
import d.b.i0.b1.m.f;
import d.b.i0.b1.m.h;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
/* loaded from: classes4.dex */
public class OfficialNotificationFragment extends BaseFragment implements NoNetworkView.b, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f18010e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.f1.b.q.b f18011f;

    /* renamed from: g  reason: collision with root package name */
    public OfficialNotificationListModel f18012g;

    /* renamed from: h  reason: collision with root package name */
    public String f18013h;
    public CustomMessageListener i = new a(2001332);
    public e j = new c();
    public h k = new d();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof f.a)) {
                return;
            }
            f.a aVar = (f.a) customResponsedMessage.getData();
            f.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.k, aVar.f50708a, aVar.f50709b, aVar.f50710c);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserData f18015a;

        public b(UserData userData) {
            this.f18015a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.b.j0.e1.t.d.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.f18015a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends e {
        public c() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (OfficialNotificationFragment.this.f18012g == null || OfficialNotificationFragment.this.f18011f == null || k.isEmpty(OfficialNotificationFragment.this.f18013h) || OfficialNotificationFragment.this.f18012g.getUser() == null || !StringHelper.equals(OfficialNotificationFragment.this.f18013h, OfficialNotificationFragment.this.f18012g.getUser().getUserId())) {
                return;
            }
            int loadDataMode = OfficialNotificationFragment.this.f18012g.getLoadDataMode();
            if (loadDataMode == 1) {
                OfficialNotificationFragment.this.f18011f.l(OfficialNotificationFragment.this.f18012g.getData());
            } else if (loadDataMode == 2) {
                OfficialNotificationFragment.this.f18011f.n(OfficialNotificationFragment.this.f18012g.getData());
            } else if (loadDataMode != 3) {
            } else {
                OfficialNotificationFragment.this.f18011f.k(OfficialNotificationFragment.this.f18012g.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements h {
        public d() {
        }

        @Override // d.b.i0.b1.m.h
        public d.b.c.e.k.b<GifView> getGifViewPool() {
            return null;
        }

        @Override // d.b.i0.b1.m.h
        public d.b.c.e.k.b<ImageView> getImageViewPool() {
            return null;
        }

        @Override // d.b.i0.b1.m.h
        public ListView getListView() {
            return null;
        }

        @Override // d.b.i0.b1.m.h
        public d.b.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
            return null;
        }

        @Override // d.b.i0.b1.m.h
        public int getRichTextViewId() {
            return 0;
        }

        @Override // d.b.i0.b1.m.h
        public d.b.c.e.k.b<TextView> getTextViewPool() {
            return null;
        }

        @Override // d.b.i0.b1.m.h
        public d.b.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
            return null;
        }

        @Override // d.b.i0.b1.m.h
        public d.b.c.e.k.b<View> getVoiceViewPool() {
            return null;
        }

        @Override // d.b.i0.b1.m.h
        public void onAtClicked(Context context, String str) {
        }

        @Override // d.b.i0.b1.m.h
        public void onLinkButtonClicked(Context context, String str) {
        }

        @Override // d.b.i0.b1.m.h
        public void onLinkClicked(Context context, String str, boolean z) {
            UrlManager.getInstance().dealOneLink(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // d.b.i0.b1.m.h
        public void onPhoneClicked(Context context, String str, String str2) {
        }

        @Override // d.b.i0.b1.m.h
        public void onSongClicked(Context context, String str) {
        }

        @Override // d.b.i0.b1.m.h
        public void onVideoClicked(Context context, String str) {
        }

        @Override // d.b.i0.b1.m.h
        public void onVideoP2PClicked(Context context, String str) {
        }
    }

    public boolean H0() {
        OfficialNotificationListModel officialNotificationListModel = this.f18012g;
        if (officialNotificationListModel == null || officialNotificationListModel.getData() == null) {
            return true;
        }
        return this.f18012g.getData().getIsNewAdd();
    }

    public boolean I0(Bundle bundle) {
        this.f18013h = d.b.i0.s.d.b.g0().D();
        OfficialNotificationListModel officialNotificationListModel = new OfficialNotificationListModel(this.f18010e);
        this.f18012g = officialNotificationListModel;
        officialNotificationListModel.setLoadDataCallBack(this.j);
        if (bundle != null) {
            K0(bundle);
            return true;
        }
        J0();
        return true;
    }

    public void J0() {
        OfficialNotificationListModel officialNotificationListModel = this.f18012g;
        if (officialNotificationListModel == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        M0();
    }

    public void K0(Bundle bundle) {
        OfficialNotificationListModel officialNotificationListModel = this.f18012g;
        if (officialNotificationListModel == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        N0(bundle);
    }

    public void L0() {
        OfficialNotificationListModel officialNotificationListModel = this.f18012g;
        if (officialNotificationListModel != null) {
            officialNotificationListModel.loadPrepage();
        }
    }

    public void M0() {
        if (k.isEmpty(this.f18013h) || this.f18010e == null || this.f18012g == null) {
            return;
        }
        UserData userData = new UserData(Long.parseLong(this.f18013h), this.f18010e.getString(R.string.system_message), null, 0);
        O0(userData);
        this.f18012g.setUser(userData);
    }

    public void N0(Bundle bundle) {
        if (bundle == null || bundle.getString("user") == null) {
            return;
        }
        UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
        O0(userData);
        this.f18012g.setUser(userData);
    }

    public void O0(UserData userData) {
        h0.c(new b(userData), null);
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.j0.f1.b.q.b bVar = this.f18011f;
        if (bVar != null) {
            bVar.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == R.id.iv_head || id == R.id.tv_user_name) && !k.isEmpty(this.f18013h)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.f18013h))));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18010e = getPageContext();
        I0(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        d.b.j0.f1.b.q.b bVar = new d.b.j0.f1.b.q.b(this.f18010e, this, viewGroup);
        this.f18011f = bVar;
        OfficialNotificationListModel officialNotificationListModel = this.f18012g;
        if (officialNotificationListModel != null) {
            bVar.f(officialNotificationListModel.getData());
            this.f18012g.loadFirst(null);
        }
        return this.f18011f.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f18012g.onDestroy();
        this.f18012g.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.i);
    }
}
