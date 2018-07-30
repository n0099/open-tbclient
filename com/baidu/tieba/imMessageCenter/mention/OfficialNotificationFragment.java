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
import com.baidu.tbadk.core.util.ay;
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
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b eHJ;
    private OfficialNotificationListModel eHK;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener elL = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.eHL, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d elM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (OfficialNotificationFragment.this.eHK != null && OfficialNotificationFragment.this.eHJ != null && !ap.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.eHK.getUser() != null && ap.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.eHK.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.eHK.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.eHJ.refreshGo2New(OfficialNotificationFragment.this.eHK.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.eHJ.refreshPrepage(OfficialNotificationFragment.this.eHK.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.eHJ.refreshCheckNew(OfficialNotificationFragment.this.eHK.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e eHL = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
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
        public void X(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void f(Context context, String str, boolean z) {
            ay.zK().c(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
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
        this.eHJ = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.eHK != null) {
            this.eHJ.a(this.eHK.getData());
            this.eHK.loadFirst(null);
        }
        return this.eHJ.getView();
    }

    protected boolean o(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DN();
        this.eHK = new OfficialNotificationListModel(this.mPageContext);
        this.eHK.setLoadDataCallBack(this.elM);
        if (bundle != null) {
            p(bundle);
            return true;
        }
        aGP();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aQ(boolean z) {
    }

    protected void p(Bundle bundle) {
        if (this.eHK != null) {
            this.eHK.setIsAcceptNotify(true);
            q(bundle);
        }
    }

    protected void aGP() {
        if (this.eHK != null) {
            this.eHK.setIsAcceptNotify(true);
            aPi();
        }
    }

    protected void q(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.eHK.setUser(userData);
        }
    }

    protected void aPi() {
        if (!ap.isEmpty(this.mUid) && this.mPageContext != null && this.eHK != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(d.j.system_message), null, 0);
            c(userData);
            this.eHK.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        v.b(new u<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: Rs */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aNv().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.elL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.elL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eHK.onDestroy();
        this.eHK.setLoadDataCallBack(null);
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

    public void ahc() {
        if (this.eHK != null) {
            this.eHK.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.eHK == null || this.eHK.getData() == null) {
            return true;
        }
        return this.eHK.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eHJ != null) {
            this.eHJ.onChangeSkinType();
        }
    }
}
