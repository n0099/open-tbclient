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
import com.baidu.tbadk.core.util.az;
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
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b eDP;
    private OfficialNotificationListModel eDQ;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener ehV = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.eDR, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d ehW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (OfficialNotificationFragment.this.eDQ != null && OfficialNotificationFragment.this.eDP != null && !ap.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.eDQ.getUser() != null && ap.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.eDQ.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.eDQ.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.eDP.refreshGo2New(OfficialNotificationFragment.this.eDQ.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.eDP.refreshPrepage(OfficialNotificationFragment.this.eDQ.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.eDP.refreshCheckNew(OfficialNotificationFragment.this.eDQ.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e eDR = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.e
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public int Oe() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<ImageView> Of() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<TextView> Og() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<GifView> Oh() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<View> Oi() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<LinearLayout> Oj() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<RelativeLayout> Ok() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void V(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void f(Context context, String str, boolean z) {
            az.zV().c(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
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
        this.eDP = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.eDQ != null) {
            this.eDP.a(this.eDQ.getData());
            this.eDQ.loadFirst(null);
        }
        return this.eDP.getView();
    }

    protected boolean o(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DR();
        this.eDQ = new OfficialNotificationListModel(this.mPageContext);
        this.eDQ.setLoadDataCallBack(this.ehW);
        if (bundle != null) {
            p(bundle);
            return true;
        }
        aFP();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aS(boolean z) {
    }

    protected void p(Bundle bundle) {
        if (this.eDQ != null) {
            this.eDQ.setIsAcceptNotify(true);
            q(bundle);
        }
    }

    protected void aFP() {
        if (this.eDQ != null) {
            this.eDQ.setIsAcceptNotify(true);
            aOi();
        }
    }

    protected void q(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.eDQ.setUser(userData);
        }
    }

    protected void aOi() {
        if (!ap.isEmpty(this.mUid) && this.mPageContext != null && this.eDQ != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(d.k.system_message), null, 0);
            c(userData);
            this.eDQ.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        w.b(new v<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: Rl */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aMv().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.ehV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.ehV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eDQ.onDestroy();
        this.eDQ.setLoadDataCallBack(null);
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

    public void agH() {
        if (this.eDQ != null) {
            this.eDQ.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.eDQ == null || this.eDQ.getData() == null) {
            return true;
        }
        return this.eDQ.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eDP != null) {
            this.eDP.onChangeSkinType();
        }
    }
}
