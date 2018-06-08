package com.baidu.tieba.imMessageCenter.mention;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes2.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private OfficialNotificationListModel eAa;
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b ezZ;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener eeb = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.eAb, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d eec = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (OfficialNotificationFragment.this.eAa != null && OfficialNotificationFragment.this.ezZ != null && !ao.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.eAa.getUser() != null && ao.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.eAa.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.eAa.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.ezZ.refreshGo2New(OfficialNotificationFragment.this.eAa.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.ezZ.refreshPrepage(OfficialNotificationFragment.this.eAa.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.ezZ.refreshCheckNew(OfficialNotificationFragment.this.eAa.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e eAb = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.e
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public int NL() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<ImageView> NM() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<TextView> NN() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<GifView> NO() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<View> NP() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<LinearLayout> NQ() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<RelativeLayout> NR() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void V(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void f(Context context, String str, boolean z) {
            ay.zG().c(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void W(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void X(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void Y(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void h(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void Z(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        o(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.ezZ = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.eAa != null) {
            this.ezZ.a(this.eAa.getData());
            this.eAa.loadFirst(null);
        }
        return this.ezZ.getView();
    }

    protected boolean o(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dz();
        this.eAa = new OfficialNotificationListModel(this.mPageContext);
        this.eAa.setLoadDataCallBack(this.eec);
        if (bundle != null) {
            p(bundle);
            return true;
        }
        aFh();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aQ(boolean z) {
    }

    protected void p(Bundle bundle) {
        if (this.eAa != null) {
            this.eAa.setIsAcceptNotify(true);
            q(bundle);
        }
    }

    protected void aFh() {
        if (this.eAa != null) {
            this.eAa.setIsAcceptNotify(true);
            aNC();
        }
    }

    protected void q(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.eAa.setUser(userData);
        }
    }

    protected void aNC() {
        if (!ao.isEmpty(this.mUid) && this.mPageContext != null && this.eAa != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(d.k.system_message), null, 0);
            c(userData);
            this.eAa.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        w.b(new v<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: QO */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aLP().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.eeb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.eeb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eAa.onDestroy();
        this.eAa.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == d.g.iv_head || id == d.g.tv_user_name) && !ao.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void agb() {
        if (this.eAa != null) {
            this.eAa.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.eAa == null || this.eAa.getData() == null) {
            return true;
        }
        return this.eAa.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ezZ != null) {
            this.ezZ.onChangeSkinType();
        }
    }
}
