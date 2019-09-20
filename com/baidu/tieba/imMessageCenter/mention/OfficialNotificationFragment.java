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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes4.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b gYr;
    private OfficialNotificationListModel gYs;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener gCG = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.gYt, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d gCH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (OfficialNotificationFragment.this.gYs != null && OfficialNotificationFragment.this.gYr != null && !aq.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.gYs.getUser() != null && aq.bV(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.gYs.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.gYs.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.gYr.refreshGo2New(OfficialNotificationFragment.this.gYs.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.gYr.refreshPrepage(OfficialNotificationFragment.this.gYs.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.gYr.refreshCheckNew(OfficialNotificationFragment.this.gYs.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e gYt = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.e
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public int azG() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<ImageView> azH() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<TextView> azI() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<GifView> azJ() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<View> azK() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<LinearLayout> azL() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<RelativeLayout> azM() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void al(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void d(Context context, String str, boolean z) {
            ba.ajK().c(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void am(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void an(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ao(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void n(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ap(Context context, String str) {
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
        this.gYr = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.gYs != null) {
            this.gYr.a(this.gYs.getData());
            this.gYs.loadFirst(null);
        }
        return this.gYr.getView();
    }

    protected boolean U(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.b.anR().aot();
        this.gYs = new OfficialNotificationListModel(this.mPageContext);
        this.gYs.setLoadDataCallBack(this.gCH);
        if (bundle != null) {
            V(bundle);
            return true;
        }
        bAT();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void es(boolean z) {
    }

    protected void V(Bundle bundle) {
        if (this.gYs != null) {
            this.gYs.setIsAcceptNotify(true);
            W(bundle);
        }
    }

    protected void bAT() {
        if (this.gYs != null) {
            this.gYs.setIsAcceptNotify(true);
            bJf();
        }
    }

    protected void W(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            c(userData);
            this.gYs.setUser(userData);
        }
    }

    protected void bJf() {
        if (!aq.isEmpty(this.mUid) && this.mPageContext != null && this.gYs != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(R.string.system_message), null, 0);
            c(userData);
            this.gYs.setUser(userData);
        }
    }

    protected void c(final UserData userData) {
        z.b(new y<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: aDX */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.bHu().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.gCG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.gCG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gYs.onDestroy();
        this.gYs.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == R.id.iv_head || id == R.id.tv_user_name) && !aq.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void aXy() {
        if (this.gYs != null) {
            this.gYs.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.gYs == null || this.gYs.getData() == null) {
            return true;
        }
        return this.gYs.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gYr != null) {
            this.gYr.onChangeSkinType();
        }
    }
}
