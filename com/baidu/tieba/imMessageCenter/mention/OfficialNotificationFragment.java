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
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes4.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b gPt;
    private OfficialNotificationListModel gPu;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener gtK = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.gPv, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d gtL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (OfficialNotificationFragment.this.gPu != null && OfficialNotificationFragment.this.gPt != null && !ap.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.gPu.getUser() != null && ap.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.gPu.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.gPu.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.gPt.refreshGo2New(OfficialNotificationFragment.this.gPu.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.gPt.refreshPrepage(OfficialNotificationFragment.this.gPu.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.gPt.refreshCheckNew(OfficialNotificationFragment.this.gPu.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e gPv = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.e
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public int ayg() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<ImageView> ayh() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<TextView> ayi() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<GifView> ayj() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<View> ayk() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<LinearLayout> ayl() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<RelativeLayout> aym() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void am(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void d(Context context, String str, boolean z) {
            ba.aiz().c(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
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
        public void n(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void aq(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        U(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gPt = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.gPu != null) {
            this.gPt.a(this.gPu.getData());
            this.gPu.loadFirst(null);
        }
        return this.gPt.getView();
    }

    protected boolean U(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.b.amy().ana();
        this.gPu = new OfficialNotificationListModel(this.mPageContext);
        this.gPu.setLoadDataCallBack(this.gtL);
        if (bundle != null) {
            V(bundle);
            return true;
        }
        bxm();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void el(boolean z) {
    }

    protected void V(Bundle bundle) {
        if (this.gPu != null) {
            this.gPu.setIsAcceptNotify(true);
            W(bundle);
        }
    }

    protected void bxm() {
        if (this.gPu != null) {
            this.gPu.setIsAcceptNotify(true);
            bFv();
        }
    }

    protected void W(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.gPu.setUser(userData);
        }
    }

    protected void bFv() {
        if (!ap.isEmpty(this.mUid) && this.mPageContext != null && this.gPu != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(R.string.system_message), null, 0);
            c(userData);
            this.gPu.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        aa.b(new z<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: aCb */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.bDK().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.gtK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.gtK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gPu.onDestroy();
        this.gPu.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == R.id.iv_head || id == R.id.tv_user_name) && !ap.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void aUX() {
        if (this.gPu != null) {
            this.gPu.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.gPu == null || this.gPu.getData() == null) {
            return true;
        }
        return this.gPu.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gPt != null) {
            this.gPt.onChangeSkinType();
        }
    }
}
