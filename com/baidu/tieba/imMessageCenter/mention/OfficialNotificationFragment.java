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
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes4.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b eXV;
    private OfficialNotificationListModel eXW;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener eCl = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.eXX, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d eCm = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (OfficialNotificationFragment.this.eXW != null && OfficialNotificationFragment.this.eXV != null && !ao.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.eXW.getUser() != null && ao.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.eXW.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.eXW.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.eXV.refreshGo2New(OfficialNotificationFragment.this.eXW.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.eXV.refreshPrepage(OfficialNotificationFragment.this.eXW.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.eXV.refreshCheckNew(OfficialNotificationFragment.this.eXW.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e eXX = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.e
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public int RA() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<ImageView> RB() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<TextView> RC() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<GifView> RD() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<View> RE() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<LinearLayout> RF() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<RelativeLayout> RG() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ak(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void e(Context context, String str, boolean z) {
            ay.Db().c(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void al(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void am(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void an(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void i(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ao(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        s(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.eXV = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.eXW != null) {
            this.eXV.a(this.eXW.getData());
            this.eXW.loadFirst(null);
        }
        return this.eXV.getView();
    }

    protected boolean s(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.a.GL().Hn();
        this.eXW = new OfficialNotificationListModel(this.mPageContext);
        this.eXW.setLoadDataCallBack(this.eCm);
        if (bundle != null) {
            t(bundle);
            return true;
        }
        aLQ();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bE(boolean z) {
    }

    protected void t(Bundle bundle) {
        if (this.eXW != null) {
            this.eXW.setIsAcceptNotify(true);
            u(bundle);
        }
    }

    protected void aLQ() {
        if (this.eXW != null) {
            this.eXW.setIsAcceptNotify(true);
            aUf();
        }
    }

    protected void u(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.eXW.setUser(userData);
        }
    }

    protected void aUf() {
        if (!ao.isEmpty(this.mUid) && this.mPageContext != null && this.eXW != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(e.j.system_message), null, 0);
            c(userData);
            this.eXW.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        x.b(new w<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: Vq */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aSs().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.eCl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.eCl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eXW.onDestroy();
        this.eXW.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == e.g.iv_head || id == e.g.tv_user_name) && !ao.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void alU() {
        if (this.eXW != null) {
            this.eXW.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.eXW == null || this.eXW.getData() == null) {
            return true;
        }
        return this.eXW.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eXV != null) {
            this.eXV.onChangeSkinType();
        }
    }
}
