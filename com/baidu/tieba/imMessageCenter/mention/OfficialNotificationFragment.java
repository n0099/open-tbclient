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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes4.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b gys;
    private OfficialNotificationListModel gyt;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener gcG = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.gyu, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d gcH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (OfficialNotificationFragment.this.gyt != null && OfficialNotificationFragment.this.gys != null && !ap.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.gyt.getUser() != null && ap.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.gyt.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.gyt.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.gys.refreshGo2New(OfficialNotificationFragment.this.gyt.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.gys.refreshPrepage(OfficialNotificationFragment.this.gyt.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.gys.refreshCheckNew(OfficialNotificationFragment.this.gyt.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e gyu = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.e
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public int ate() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<ImageView> atf() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<TextView> atg() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<GifView> ath() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<View> ati() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<LinearLayout> atj() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<RelativeLayout> atk() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void az(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void e(Context context, String str, boolean z) {
            ba.adD().c(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void aA(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void aB(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void aC(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void k(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void aD(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        T(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gys = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.gyt != null) {
            this.gys.a(this.gyt.getData());
            this.gyt.loadFirst(null);
        }
        return this.gys.getView();
    }

    protected boolean T(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.b.ahA().aic();
        this.gyt = new OfficialNotificationListModel(this.mPageContext);
        this.gyt.setLoadDataCallBack(this.gcH);
        if (bundle != null) {
            U(bundle);
            return true;
        }
        bpB();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void dP(boolean z) {
    }

    protected void U(Bundle bundle) {
        if (this.gyt != null) {
            this.gyt.setIsAcceptNotify(true);
            V(bundle);
        }
    }

    protected void bpB() {
        if (this.gyt != null) {
            this.gyt.setIsAcceptNotify(true);
            bxO();
        }
    }

    protected void V(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.gyt.setUser(userData);
        }
    }

    protected void bxO() {
        if (!ap.isEmpty(this.mUid) && this.mPageContext != null && this.gyt != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(d.j.system_message), null, 0);
            c(userData);
            this.gyt.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        aa.b(new z<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: awW */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.bwd().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.gcG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.gcG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gyt.onDestroy();
        this.gyt.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == d.g.iv_head || id == d.g.tv_user_name) && !ap.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void aOO() {
        if (this.gyt != null) {
            this.gyt.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.gyt == null || this.gyt.getData() == null) {
            return true;
        }
        return this.gyt.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gys != null) {
            this.gys.onChangeSkinType();
        }
    }
}
