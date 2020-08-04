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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes16.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b jqk;
    private OfficialNotificationListModel jql;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener iRM = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.jqm, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d iRN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (OfficialNotificationFragment.this.jql != null && OfficialNotificationFragment.this.jqk != null && !as.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.jql.getUser() != null && as.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.jql.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.jql.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.jqk.refreshGo2New(OfficialNotificationFragment.this.jql.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.jqk.refreshPrepage(OfficialNotificationFragment.this.jql.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.jqk.refreshCheckNew(OfficialNotificationFragment.this.jql.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.i jqm = new com.baidu.tbadk.widget.richText.i() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.i
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public int bpt() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<ImageView> bpu() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<TextView> bpv() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<GifView> bpw() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<View> bpx() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<LinearLayout> bpy() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<RelativeLayout> bpz() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void am(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void f(Context context, String str, boolean z) {
            bd.baV().b(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void an(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void ao(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void ap(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void r(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void aq(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        au(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.jqk = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.jql != null) {
            this.jqk.a(this.jql.getData());
            this.jql.loadFirst(null);
        }
        return this.jqk.getView();
    }

    protected boolean au(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfJ();
        this.jql = new OfficialNotificationListModel(this.mPageContext);
        this.jql.setLoadDataCallBack(this.iRN);
        if (bundle != null) {
            av(bundle);
            return true;
        }
        cqt();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
    }

    protected void av(Bundle bundle) {
        if (this.jql != null) {
            this.jql.setIsAcceptNotify(true);
            aw(bundle);
        }
    }

    protected void cqt() {
        if (this.jql != null) {
            this.jql.setIsAcceptNotify(true);
            czc();
        }
    }

    protected void aw(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            b(userData);
            this.jql.setUser(userData);
        }
    }

    protected void czc() {
        if (!as.isEmpty(this.mUid) && this.mPageContext != null && this.jql != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(R.string.system_message), null, 0);
            b(userData);
            this.jql.setUser(userData);
        }
    }

    protected void b(final UserData userData) {
        ad.b(new ac<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bsE */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.cxs().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.iRM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.iRM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jql.onDestroy();
        this.jql.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == R.id.iv_head || id == R.id.tv_user_name) && !as.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void bAT() {
        if (this.jql != null) {
            this.jql.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.jql == null || this.jql.getData() == null) {
            return true;
        }
        return this.jql.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jqk != null) {
            this.jqk.onChangeSkinType();
        }
    }
}
