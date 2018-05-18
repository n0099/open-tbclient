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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes2.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b eoI;
    private OfficialNotificationListModel eoJ;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener dSO = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.eoK, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d dSP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (OfficialNotificationFragment.this.eoJ != null && OfficialNotificationFragment.this.eoI != null && !an.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.eoJ.getUser() != null && an.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.eoJ.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.eoJ.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.eoI.refreshGo2New(OfficialNotificationFragment.this.eoJ.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.eoI.refreshPrepage(OfficialNotificationFragment.this.eoJ.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.eoI.refreshCheckNew(OfficialNotificationFragment.this.eoJ.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e eoK = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.e
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public int Km() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<ImageView> Kn() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<TextView> Ko() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<GifView> Kp() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<View> Kq() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<LinearLayout> Kr() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<RelativeLayout> Ks() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void S(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void T(Context context, String str) {
            ax.wf().c(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void U(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void V(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void W(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void g(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void X(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        n(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.eoI = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.eoJ != null) {
            this.eoI.a(this.eoJ.getData());
            this.eoJ.loadFirst(null);
        }
        return this.eoI.getView();
    }

    protected boolean n(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.a.zw().zY();
        this.eoJ = new OfficialNotificationListModel(this.mPageContext);
        this.eoJ.setLoadDataCallBack(this.dSP);
        if (bundle != null) {
            o(bundle);
            return true;
        }
        aAm();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
    }

    protected void o(Bundle bundle) {
        if (this.eoJ != null) {
            this.eoJ.setIsAcceptNotify(true);
            p(bundle);
        }
    }

    protected void aAm() {
        if (this.eoJ != null) {
            this.eoJ.setIsAcceptNotify(true);
            aIH();
        }
    }

    protected void p(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.eoJ.setUser(userData);
        }
    }

    protected void aIH() {
        if (!an.isEmpty(this.mUid) && this.mPageContext != null && this.eoJ != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(d.k.system_message), null, 0);
            c(userData);
            this.eoJ.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        v.b(new u<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: No */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aGU().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.dSO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.dSO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eoJ.onDestroy();
        this.eoJ.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        int id = view2.getId();
        if ((id == d.g.iv_head || id == d.g.tv_user_name) && !an.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void acE() {
        if (this.eoJ != null) {
            this.eoJ.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.eoJ == null || this.eoJ.getData() == null) {
            return true;
        }
        return this.eoJ.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eoI != null) {
            this.eoI.onChangeSkinType();
        }
    }
}
