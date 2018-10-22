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
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b eWD;
    private OfficialNotificationListModel eWE;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener eAS = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.eWF, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d eAT = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (OfficialNotificationFragment.this.eWE != null && OfficialNotificationFragment.this.eWD != null && !ao.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.eWE.getUser() != null && ao.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.eWE.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.eWE.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.eWD.refreshGo2New(OfficialNotificationFragment.this.eWE.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.eWD.refreshPrepage(OfficialNotificationFragment.this.eWE.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.eWD.refreshCheckNew(OfficialNotificationFragment.this.eWE.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e eWF = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.e
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public int Rr() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<ImageView> Rs() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<TextView> Rt() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<GifView> Ru() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<View> Rv() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<LinearLayout> Rw() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<RelativeLayout> Rx() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void am(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void e(Context context, String str, boolean z) {
            ay.CU().c(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void an(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ao(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ap(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void i(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void aq(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        p(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.eWD = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.eWE != null) {
            this.eWD.a(this.eWE.getData());
            this.eWE.loadFirst(null);
        }
        return this.eWD.getView();
    }

    protected boolean p(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.a.Gz().Hb();
        this.eWE = new OfficialNotificationListModel(this.mPageContext);
        this.eWE.setLoadDataCallBack(this.eAT);
        if (bundle != null) {
            q(bundle);
            return true;
        }
        aMs();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bn(boolean z) {
    }

    protected void q(Bundle bundle) {
        if (this.eWE != null) {
            this.eWE.setIsAcceptNotify(true);
            r(bundle);
        }
    }

    protected void aMs() {
        if (this.eWE != null) {
            this.eWE.setIsAcceptNotify(true);
            aUI();
        }
    }

    protected void r(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.eWE.setUser(userData);
        }
    }

    protected void aUI() {
        if (!ao.isEmpty(this.mUid) && this.mPageContext != null && this.eWE != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(e.j.system_message), null, 0);
            c(userData);
            this.eWE.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        x.b(new w<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: Vh */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aSV().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.eAS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.eAS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eWE.onDestroy();
        this.eWE.setLoadDataCallBack(null);
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

    public void amv() {
        if (this.eWE != null) {
            this.eWE.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.eWE == null || this.eWE.getData() == null) {
            return true;
        }
        return this.eWE.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eWD != null) {
            this.eWD.onChangeSkinType();
        }
    }
}
