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
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b feK;
    private OfficialNotificationListModel feL;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener eJa = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.feM, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d eJb = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (OfficialNotificationFragment.this.feL != null && OfficialNotificationFragment.this.feK != null && !ao.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.feL.getUser() != null && ao.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.feL.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.feL.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.feK.refreshGo2New(OfficialNotificationFragment.this.feL.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.feK.refreshPrepage(OfficialNotificationFragment.this.feL.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.feK.refreshCheckNew(OfficialNotificationFragment.this.feL.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e feM = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.e
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public int SG() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<ImageView> SH() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<TextView> SI() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<GifView> SJ() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<View> SK() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<LinearLayout> SL() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<RelativeLayout> SM() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void an(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void e(Context context, String str, boolean z) {
            ay.Ef().c(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ao(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ap(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void aq(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void i(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ar(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        v(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.feK = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.feL != null) {
            this.feK.a(this.feL.getData());
            this.feL.loadFirst(null);
        }
        return this.feK.getView();
    }

    protected boolean v(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.a.HP().Ir();
        this.feL = new OfficialNotificationListModel(this.mPageContext);
        this.feL.setLoadDataCallBack(this.eJb);
        if (bundle != null) {
            w(bundle);
            return true;
        }
        aNH();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void bF(boolean z) {
    }

    protected void w(Bundle bundle) {
        if (this.feL != null) {
            this.feL.setIsAcceptNotify(true);
            x(bundle);
        }
    }

    protected void aNH() {
        if (this.feL != null) {
            this.feL.setIsAcceptNotify(true);
            aVW();
        }
    }

    protected void x(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.feL.setUser(userData);
        }
    }

    protected void aVW() {
        if (!ao.isEmpty(this.mUid) && this.mPageContext != null && this.feL != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(e.j.system_message), null, 0);
            c(userData);
            this.feL.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        x.b(new w<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            /* renamed from: Ww */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.aUj().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.eJa);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.eJa);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.feL.onDestroy();
        this.feL.setLoadDataCallBack(null);
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

    public void anb() {
        if (this.feL != null) {
            this.feL.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.feL == null || this.feL.getData() == null) {
            return true;
        }
        return this.feL.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.feK != null) {
            this.feK.onChangeSkinType();
        }
    }
}
