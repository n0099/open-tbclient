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
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.f;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes2.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b eHE;
    private OfficialNotificationListModel eHF;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener elH = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.eHG, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d elI = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (OfficialNotificationFragment.this.eHF != null && OfficialNotificationFragment.this.eHE != null && !ap.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.eHF.getUser() != null && ap.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.eHF.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.eHF.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.eHE.refreshGo2New(OfficialNotificationFragment.this.eHF.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.eHE.refreshPrepage(OfficialNotificationFragment.this.eHF.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.eHE.refreshCheckNew(OfficialNotificationFragment.this.eHF.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e eHG = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.e
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public int Od() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<ImageView> Oe() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<TextView> Of() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<GifView> Og() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<View> Oh() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<LinearLayout> Oi() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<RelativeLayout> Oj() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void X(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void d(Context context, String str, boolean z) {
            az.zI().c(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void Y(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void Z(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void aa(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void h(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ab(Context context, String str) {
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
        this.eHE = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.eHF != null) {
            this.eHE.a(this.eHF.getData());
            this.eHF.loadFirst(null);
        }
        return this.eHE.getView();
    }

    protected boolean o(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DN();
        this.eHF = new OfficialNotificationListModel(this.mPageContext);
        this.eHF.setLoadDataCallBack(this.elI);
        if (bundle != null) {
            p(bundle);
            return true;
        }
        aGM();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aR(boolean z) {
    }

    protected void p(Bundle bundle) {
        if (this.eHF != null) {
            this.eHF.setIsAcceptNotify(true);
            q(bundle);
        }
    }

    protected void aGM() {
        if (this.eHF != null) {
            this.eHF.setIsAcceptNotify(true);
            aPf();
        }
    }

    protected void q(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.eHF.setUser(userData);
        }
    }

    protected void aPf() {
        if (!ap.isEmpty(this.mUid) && this.mPageContext != null && this.eHF != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(f.j.system_message), null, 0);
            c(userData);
            this.eHF.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        v.b(new u<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: Rx */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aNs().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.elH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.elH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eHF.onDestroy();
        this.eHF.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == f.g.iv_head || id == f.g.tv_user_name) && !ap.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void ahe() {
        if (this.eHF != null) {
            this.eHF.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.eHF == null || this.eHF.getData() == null) {
            return true;
        }
        return this.eHF.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eHE != null) {
            this.eHE.onChangeSkinType();
        }
    }
}
